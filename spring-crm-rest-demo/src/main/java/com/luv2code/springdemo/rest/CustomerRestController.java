package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api")
public class CustomerRestController {


    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;


    //add mapping for GET /custonmer
@GetMapping("/customers")
    public List<Customer> getCustomers(){
    return customerService.getCustomers();
}


@GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

    Customer customer = customerService.getCustomer(customerId);

    if (customer == null){
    throw new CustomerNotFoundException("Customer id not found - " + customerId);
    }
    return customer ;

}


// add mapping for POST /customers - add new cjustomer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){

    // just in case the pass an id in JSON ... set id to 0
    // Hibernate will add the Customer if the id is 0 or null !!

    theCustomer.setId(0);
    customerService.saveCustomer(theCustomer);


    return theCustomer;
    }

// add Put Mapping for updating Customer

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){


    customerService.saveCustomer(theCustomer);
    return theCustomer;
    }

    //add Delete Mapping to delete an existing Customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        //First check , if Customer exists ; if not throw an execption
        Customer tempCustomer = customerService.getCustomer(customerId);

        if (tempCustomer == null){
        throw  new CustomerNotFoundException("No Customer with CustomerId :" + customerId + " found !");
    } else {
            // If the Customer Exists ; Delete it an return a confirmation Message
            customerService.deleteCustomer(customerId);
            return "Customer with CustomerID: " + customerId + " deleted" ;
        }

    }



}
