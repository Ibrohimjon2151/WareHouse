package com.example.task1.controller;

import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CategoryDTO;
import com.example.task1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @PostMapping
    public HttpEntity<ApiResponce> addCategory(@RequestBody CategoryDTO categoryDTO){
        ApiResponce apiResponce = categoryService.addCategory(categoryDTO);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping
    public HttpEntity<ApiResponce> getList(){
        return ResponseEntity.ok(categoryService.listCategory());
    }

    @GetMapping("/{id}")
    public HttpEntity<CategoryDTO> getOne(@PathVariable Integer id){
        CategoryDTO oneCategory = categoryService.getOneCategory(id);

        return ResponseEntity.ok(oneCategory);
    }

    @PutMapping("/{id}")
    public HttpEntity<ApiResponce> editOne(@PathVariable Integer id , @RequestBody CategoryDTO categoryDTO){
        ApiResponce apiResponce = categoryService.editOne(id, categoryDTO);
        return (HttpEntity<ApiResponce>) ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT );
    }

    @DeleteMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id){
        return categoryService.deleteOne(id);
    }


}
