package pl.dolega.breweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dolega.breweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerByIdTest() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomerTest() {
        CustomerDto dto = CustomerDto.builder().name("Kido").build();
        URI uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomerTest() {
        CustomerDto dto = CustomerDto.builder().name("Kido").build();
        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomerTest() {
        client.deleteCustomer(UUID.randomUUID());
    }
}
