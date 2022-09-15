package com.usta.rest;

import com.usta.models.Book;
import com.usta.models.Customer;
import com.usta.models.Loans;
import com.usta.models.Publisher;
import com.usta.service.CustomerService;
import com.usta.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans/")
public class LoansRest {

    @Autowired
    private LoansService loansService;

    @GetMapping("listLoans")
    private ResponseEntity<List<Loans>> listAllLoans(){
        return ResponseEntity.ok(loansService.getAllLoans());
    }

    @PostMapping("createLoans")
    private ResponseEntity<Loans> saveLoans(@RequestBody Loans loans) {
        Loans temporal = loansService.createLoans(loans);
        try{
            return ResponseEntity.created(new URI("/api/loans"+temporal.getIdLoan())).body(loans);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchLoans/{id}")
    private ResponseEntity<Optional<Loans>> searchLoansById(@PathVariable("id") Long id){
        return ResponseEntity.ok(loansService.findById(id));
    }


    @DeleteMapping("deleteLoans/{id}")
    private ResponseEntity<String> deleteLoans(@PathVariable("id") Long id){
        loansService.deleteLoansById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updateLoans")
    private ResponseEntity<Loans> updateLoans(@RequestBody Loans loans){
        Loans temporal = loansService.createLoans(loans);
        try{
            return ResponseEntity.created(new URI("/api/loans" + temporal.getIdLoan())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countLoans")
    private ResponseEntity<String> listTotalLoans(){
        return ResponseEntity.ok("El total de prestamos son: "+ String.valueOf(loansService.countTotalLoans()));
    }

    @GetMapping(value = "searchCustomerIdLoan/{id}")
    private ResponseEntity<String> searchCustomerByIdLoan(@PathVariable("id") Long id){
        return ResponseEntity.ok(" NameCustomer: "+String.valueOf(loansService.searchCustomerByIdLoan(id)));
    }
}
