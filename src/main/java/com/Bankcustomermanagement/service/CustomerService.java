package com.Bankcustomermanagement.service;

import com.Bankcustomermanagement.entity.Customer;
import com.Bankcustomermanagement.ropository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerService {

    @Autowired
    private  final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer){
        // Optional: check if email already exists
        return customerRepository.save(customer);
    }
    @Transactional
    public Customer updateCustomer(Long id , Customer customerDetails){
        Customer customers = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer not found with id:"+ id));

        customers.setFirstname(customerDetails.getFirstname());
        customers.setMiddlename(customerDetails.getMiddlename());
        customers.setLastname(customerDetails.getLastname());
        customers.setEmail(customerDetails.getEmail());
        customers.setPhoneNumber( customerDetails.getPhoneNumber());
        customers.setBalance(customerDetails.getBalance());
        customers.setAddress(customerDetails.getAddress());
        customers.setCity(customerDetails.getCity());
        customers.setState(customerDetails.getState());

        return customerRepository.save(customers);
    }

    public  void deleteCustomer(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found with id:" + id));
        customerRepository.delete(customer);
    }

}
