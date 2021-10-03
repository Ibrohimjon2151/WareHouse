package com.example.task1.service;

import com.example.task1.entity.Currency;
import com.example.task1.entity.Measurment;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CurrencyDTO;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.repository.CurrencyRepository;
import com.example.task1.repository.MeasurmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public ApiResponce addCategory(CurrencyDTO currencyDTO){
        Currency measurment = new Currency();
        measurment.setName(currencyDTO.getName());
        Currency save = currencyRepository.save(measurment);
        return new ApiResponce(true , save);
    }

    public ApiResponce listMeasurment(){
        List<Currency> categoryRepositoryAll = currencyRepository.findAll();
        return new  ApiResponce(true , categoryRepositoryAll);
    }

    public CurrencyDTO getOneMeasurment(int id){
        Optional<Currency> optionalCategory = currencyRepository.findById(id);
        Currency measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            return  new CurrencyDTO(measurment.getName());
        }
        return null;
    }

    public ApiResponce editOne(int id , CurrencyDTO currencyDTO){
        Optional<Currency> optionalCategory = currencyRepository.findById(id);
        Currency measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            measurment.setName(currencyDTO.getName());
            return  new ApiResponce(true , measurment.getName());
        }
        return null;
    }

    public ApiResponce deleteOne(int id){
        Optional<Currency> optionalCategory = currencyRepository.findById(id);
        Currency measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
           currencyRepository.deleteById(id);
            return  new ApiResponce(true , measurment);
        }
        return null;
    }


}
