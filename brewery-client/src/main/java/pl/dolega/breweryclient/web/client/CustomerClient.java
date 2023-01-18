package pl.dolega.breweryclient.web.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.dolega.breweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer";
    private String apiHost = "http://localhost:8080";

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto dto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, dto);
    }

    public void updateCustomer(UUID uuid, CustomerDto dto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), dto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + uuid.toString());
    }
}
