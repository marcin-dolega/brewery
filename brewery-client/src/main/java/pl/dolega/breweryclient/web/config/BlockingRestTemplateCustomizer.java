package pl.dolega.breweryclient.web.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.TimeValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer maxTotalConnections;
    private final Integer defaultMaxTotalConnections;
    private final Integer connectionRequestTimeout;
    private final Integer connectionKeepAlive;

    public BlockingRestTemplateCustomizer(@Value("${pl.maxtotalconnections}") Integer maxTotalConnections,
                                          @Value("${pl.defaultmaxtototalconnections}") Integer defaultMaxTotalConnections,
                                          @Value("${pl.connectiontequesttimeout}") Integer connectionRequestTimeout,
                                          @Value("${pl.connectionkeepalive}") Integer connectionKeepAlive) {
        this.maxTotalConnections = maxTotalConnections;
        this.defaultMaxTotalConnections = defaultMaxTotalConnections;
        this.connectionRequestTimeout = connectionRequestTimeout;
        this.connectionKeepAlive = connectionKeepAlive;
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnections);
        connectionManager.setDefaultMaxPerRoute(defaultMaxTotalConnections);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectionRequestTimeout, TimeUnit.MILLISECONDS)
                .setConnectionKeepAlive(TimeValue.of(connectionKeepAlive, TimeUnit.MILLISECONDS))
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}

