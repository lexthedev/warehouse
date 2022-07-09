package com.lexthedev.warehouse.service;

import com.lexthedev.warehouse.constants.ProductType;
import com.lexthedev.warehouse.model.Settings;
import org.springframework.stereotype.Controller;

@Controller
public class SettingsService {

    public Settings getSettings() {
        ProductType[] types = ProductType.values();
        Settings result = new Settings();
        result.setProductTypes(types);
        return result;
    }
}
