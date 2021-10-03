package com.example.task1.controller;

import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CurrencyDTO;
import com.example.task1.peliod.WareHouseDTO;
import com.example.task1.service.CurrencyService;
import com.example.task1.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wareHouse")
public class WareHouseController {

    @Autowired
    WareHouseService currencyService;


    @PostMapping
    public ApiResponce addCategory(@RequestBody WareHouseDTO measurmentDTO) {
        return currencyService.addCategory(measurmentDTO);
    }

    @GetMapping
    public ApiResponce getList() {
        return currencyService.listMeasurment();
    }

    @GetMapping("/{id}")
    public WareHouseDTO getOne(@PathVariable Integer id) {
        return currencyService.getOneMeasurment(id);
    }

    @PutMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id, @RequestBody WareHouseDTO wareHouseDTO) {
        return currencyService.editOne(id, wareHouseDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id) {
        return currencyService.deleteOne(id);
    }


}
