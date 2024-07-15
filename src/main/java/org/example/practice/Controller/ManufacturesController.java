package org.example.practice.Controller;

import org.example.practice.Relationship.Manufactures;
import org.example.practice.Service.ManufacturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/manufactures")
public class ManufacturesController {

    private final ManufacturesService manufacturesService;

    @Autowired
    public ManufacturesController(ManufacturesService manufacturesService) {
        this.manufacturesService = manufacturesService;
    }

    @GetMapping("/expiring-soon")
    public ResponseEntity<List<Manufactures>> getProductsWithExpiringSoon(@RequestParam Date thresholdDate) {
        List<Manufactures> products = manufacturesService.findProductsWithExpiringSoon(thresholdDate);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}