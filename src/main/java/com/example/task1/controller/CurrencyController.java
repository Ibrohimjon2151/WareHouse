package com.example.task1.controller;

import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CurrencyDTO;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.service.CategoryService;
import com.example.task1.service.CurrencyService;
import com.example.task1.service.MeasurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;


    @PostMapping
    public ApiResponce addCategory(@RequestBody CurrencyDTO measurmentDTO) {
        return currencyService.addCategory(measurmentDTO);
    }

    @GetMapping
    public ApiResponce getList() {
        return currencyService.listMeasurment();
    }

    @GetMapping("/{id}")
    public CurrencyDTO getOne(@PathVariable Integer id) {
        return currencyService.getOneMeasurment(id);
    }

    @PutMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id, @RequestBody CurrencyDTO categoryDTO) {
        return currencyService.editOne(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id) {
        return currencyService.deleteOne(id);

    }


}
