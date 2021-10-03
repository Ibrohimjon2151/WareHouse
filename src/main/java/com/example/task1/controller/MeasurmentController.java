package com.example.task1.controller;

import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CategoryDTO;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.service.CategoryService;
import com.example.task1.service.MeasurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measurment")
public class MeasurmentController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    MeasurmentService measurmentService;


    @PostMapping
    public ApiResponce addCategory(@RequestBody MeasurmentDTO measurmentDTO) {
        return measurmentService.addCategory(measurmentDTO);
    }

    @GetMapping
    public ApiResponce getList() {
        return measurmentService.listMeasurment();
    }

    @GetMapping("/{id}")
    public MeasurmentDTO getOne(@PathVariable Integer id) {
        return measurmentService.getOneMeasurment(id);
    }

    @PutMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id, @RequestBody MeasurmentDTO categoryDTO) {
        return measurmentService.editOne(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id) {
        return measurmentService.deleteOne(id);

    }


}
