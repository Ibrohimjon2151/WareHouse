package com.example.task1.controller;

import com.example.task1.entity.Product;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CategoryDTO;
import com.example.task1.peliod.ProductDTO;
import com.example.task1.service.CategoryService;
import com.example.task1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductCotroller {
    @Autowired
    ProductService productService;


    @PostMapping("/add")
    public ApiResponce addCategory(@RequestBody ProductDTO categoryDTO) {
        return productService.addProduct(categoryDTO);
    }

    @GetMapping
    public ApiResponce getList() {
        return productService.listproduct();
    }

    @GetMapping("/{id}")
    public ApiResponce getOne(@PathVariable Integer id) {
        return productService.getOneMeasurment(id);
    }

    @PutMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id, @RequestBody ProductDTO categoryDTO) {
        return productService.editOne(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id) {
        return productService.deleteOne(id);
    }


}
