package com.example.task1.controller;

import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.peliod.OutputDTO;
import com.example.task1.peliod.OutputProductDTO;
import com.example.task1.service.CategoryService;
import com.example.task1.service.MeasurmentService;
import com.example.task1.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/output")
public class OutputController {
    @Autowired
    OutputService addCategory;

    @PostMapping
    public ApiResponce addCategory(@RequestBody OutputDTO measurmentDTO) {
        return addCategory.saveProduct(measurmentDTO);
    }


}
