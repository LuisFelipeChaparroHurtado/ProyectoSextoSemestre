package com.usta.rest;

import com.usta.models.Book;
import com.usta.models.LoanDetail;
import com.usta.service.LoanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loanDetail/")
public class LoanDetailRest {

    @Autowired
    private LoanDetailService loanDetailService;

    @GetMapping("listLoanDetail")
    private ResponseEntity<List<LoanDetail>> listAllLoanDetail(){
        return ResponseEntity.ok(loanDetailService.getAllLoanDetail());
    }

    @PostMapping("createLoanDetail")
    private ResponseEntity<LoanDetail> saveLoanDetail(@RequestBody LoanDetail loanDetail) {
        LoanDetail temporal = loanDetailService.createLoanDetail(loanDetail);
        try{
            return ResponseEntity.created(new URI("/api/loanDetail/"+temporal.getIdLoanDetail())).body(loanDetail);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchLoanDetail/{id}")
    private ResponseEntity<Optional<LoanDetail>> listLoanDetailById(@PathVariable("id") Long id){
        return ResponseEntity.ok(loanDetailService.findById(id));
    }

    @DeleteMapping("deleteLoanDetail/{id}")
    private ResponseEntity<String> deleteLoanDetail(@PathVariable("id") Long id){
        loanDetailService.deleteLoanDetailById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updateLoanDetail")
    private ResponseEntity<LoanDetail> updateLoanDetail(@RequestBody LoanDetail loanDetail){
        LoanDetail temporal = loanDetailService.createLoanDetail(loanDetail);
        try{
            return ResponseEntity.created(new URI("/api/loanDetail" + temporal.getIdLoanDetail())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countLoanDetail")
    private ResponseEntity<String> listTotalLoanDetail(){
        return ResponseEntity.ok("El total de detalles de prestamos es: "+ String.valueOf(loanDetailService.countTotalLoanDetail()));
    }

    @GetMapping(value = "searchBookIdLoanDetail/{id}")
    private ResponseEntity<String> searchBookByIdLoanDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(" TitleBook: "+String.valueOf(loanDetailService.searchBookByIdLoanDetail(id)));
    }
}
