package com.lexthedev.warehouse.controller.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ProductEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.service.warehouse.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(productService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(productService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProductEntity product) {
        try {
            productService.create(product);
            return ResponseEntity.ok("product created!");
        } catch (AlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PutMapping
    public ResponseEntity edit(@RequestBody ProductEntity product) {
        try {
            return ResponseEntity.ok(productService.edit(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(productService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }

}
