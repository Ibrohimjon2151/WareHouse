package com.example.task1.controller;

import com.example.task1.entity.Client;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.service.CategoryService;
import com.example.task1.service.ClientService;
import com.example.task1.service.MeasurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService clientService;


    @PostMapping
    public ApiResponce addCategory(@RequestBody Client measurmentDTO) {
        return clientService.add(measurmentDTO);
    }

    @GetMapping
    public List<Client> getList() {
        return clientService.clients();
    }
    @PutMapping("/{id}")
    public ApiResponce editOne(@PathVariable Integer id, @RequestBody Client categoryDTO) {
        return clientService.edit(id, categoryDTO);
    }

}
