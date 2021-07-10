package ada.wm2.carrental.service;

import ada.wm2.carrental.bean.CustomerBean;
import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;
import ada.wm2.carrental.repo.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest
{
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    @DisplayName("Should return customer bean")
    void testGetCustomerById()
    {
        Customer customer = new Customer();
        given(customerRepository.findById(anyInt())).willReturn(Optional.of(customer));
        CustomerBean found = customerService.getCustomerById(anyInt());
        then(customerRepository).should().findById(anyInt());
        assertThat(found).isNotNull();
    }

    @Test
    @DisplayName("Should return customer bean list")
    void testGetCustomerList()
    {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        given(customerRepository.findAll()).willReturn(customerList);
        List<CustomerBean> found = customerService.getCustomerList();
        then(customerRepository).should().findAll();
        assertThat(found).hasSize(2);
    }
}
