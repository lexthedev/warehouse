package com.lexthedev.warehouse.controller;

import com.lexthedev.warehouse.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
public class SettingsController {
    @Autowired
    SettingsService settingsService;

    @GetMapping
    public ResponseEntity getSettings() {
        try {
            return ResponseEntity.ok(settingsService.getSettings());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error has happened");
        }
    }
}
