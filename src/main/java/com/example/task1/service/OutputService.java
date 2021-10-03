package com.example.task1.service;

import com.example.task1.entity.*;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.peliod.OutputDTO;
import com.example.task1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    public ApiResponce saveProduct(OutputDTO outputDTO){
        Output output = new Output();

        output.setDate(outputDTO.getDate());
        output.setCode((int) (Math.random() * 100));

        Optional<Currency> currencyRepositoryById = currencyRepository.findById(outputDTO.getCurrencyId());
        Currency currency = currencyRepositoryById.get();
        output.setCurrency(currency);

        Client repositoryById = clientRepository.getById(outputDTO.getClientId());
        output.setClient(repositoryById);

        WareHouse wareHouseRepositoryById = wareHouseRepository.getById(outputDTO.getWarehouseId());
        output.setWareHouse(wareHouseRepositoryById);

        Output save = outputRepository.save(output);

        return new ApiResponce(true , save);
    }


}
