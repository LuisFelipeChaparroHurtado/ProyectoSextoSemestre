package com.usta.rest;

import com.usta.models.Book;
import com.usta.models.Customer;
import com.usta.models.Loans;
import com.usta.service.BookService;
import com.usta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer/")
public class CustomerRest {

    @Autowired
    private CustomerService customerService;

    @GetMapping("listCustomer")
    private ResponseEntity<List<Customer>> listAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping("createCustomer")
    private ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer temporal = customerService.createCustomer(customer);
        try{
            return ResponseEntity.created(new URI("/api/customer/"+temporal.getIdCustomer())).body(customer);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchCustomer/{id}")
    private ResponseEntity<Optional<Customer>> listCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("deleteCustomer/{id}")
    private ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updateCustomer")
    private ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer temporal = customerService.createCustomer(customer);
        try{
            return ResponseEntity.created(new URI("/api/customer" + temporal.getIdCustomer())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countCustomer")
    private ResponseEntity<String> listTotalCustomer(){
        return ResponseEntity.ok("El total de clientes son: "+ String.valueOf(customerService.countTotalCustomer()));
    }
}
