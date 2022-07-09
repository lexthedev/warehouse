package com.lexthedev.warehouse.controller.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ClientEntity;
import com.lexthedev.warehouse.service.warehouse.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(clientService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(clientService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ClientEntity client) {
        try {
            clientService.create(client);
            return ResponseEntity.ok("client created!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PutMapping
    public ResponseEntity edit(@RequestBody ClientEntity client) {
        try {
            return ResponseEntity.ok(clientService.edit(client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }


    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(clientService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }
}
