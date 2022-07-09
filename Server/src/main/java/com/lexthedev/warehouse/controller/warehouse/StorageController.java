package com.lexthedev.warehouse.controller.warehouse;

import com.lexthedev.warehouse.entity.warehouse.StorageEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.service.warehouse.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    @GetMapping
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(storageService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(storageService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody StorageEntity storage) {
        try {
            storageService.create(storage);
            return ResponseEntity.ok("storage created!");
        } catch (AlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PutMapping
    public ResponseEntity edit(@RequestBody StorageEntity storage) {
        try {
            return ResponseEntity.ok(storageService.edit(storage));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }


    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(storageService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }
}