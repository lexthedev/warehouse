package com.lexthedev.warehouse.controller.warehouse;

import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.model.warehouse.GoodsDTO;
import com.lexthedev.warehouse.service.warehouse.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(goodsService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(goodsService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GoodsDTO goods) {
        try {
            goodsService.create(goodsService.toEntity(goods));
            return ResponseEntity.ok("goods created!");
        } catch (AlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened :(");
        }
    }

    @PutMapping
    public ResponseEntity edit(@RequestBody GoodsDTO goods) {
        try {
            return ResponseEntity.ok(goodsService.edit(goodsService.toEntity(goods)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error happened");
        }
    }
}
