package pl.dolega.brewery.web.mapper;

import org.mapstruct.Mapper;
import pl.dolega.brewery.domain.Customer;
import pl.dolega.brewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);

}
