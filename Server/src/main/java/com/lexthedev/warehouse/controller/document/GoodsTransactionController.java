package com.lexthedev.warehouse.controller.document;

import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.model.document.GoodsTransaction;
import com.lexthedev.warehouse.model.document.GoodsTransactionDTO;
import com.lexthedev.warehouse.service.document.GoodsTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goodsTransactions")
public class GoodsTransactionController {
    @Autowired
    GoodsTransactionService goodsTransactionService;

    @GetMapping
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(goodsTransactionService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(goodsTransactionService.getAllIncome());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all/income")
    public ResponseEntity getAllIncome() {
        try {
            return ResponseEntity.ok(goodsTransactionService.getAllIncome());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all/outcome")
    public ResponseEntity getAllOutcome() {
        try {
            return ResponseEntity.ok(goodsTransactionService.getAllOutcome());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GoodsTransactionDTO goodsTransaction) {
        try {
            goodsTransactionService.create(goodsTransaction);
            return ResponseEntity.ok("goods created!");
        } catch (AlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PutMapping // doesn't work properly
    public ResponseEntity edit(@RequestBody GoodsTransactionDTO goodsTransaction) {
        try {
            return ResponseEntity.ok(goodsTransactionService.edit(goodsTransaction));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(goodsTransactionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }
}
