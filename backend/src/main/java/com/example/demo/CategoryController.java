package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CategoryController {

    private final ItemRepository itemRepo;

    public CategoryController(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public List<String> getCategories() {
        return itemRepo.findAll().stream()
                .map(Item::getCategory)
                .distinct()
                .toList();
    }
}