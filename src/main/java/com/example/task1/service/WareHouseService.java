package com.example.task1.service;

import com.example.task1.entity.Measurment;
import com.example.task1.entity.WareHouse;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.peliod.WareHouseDTO;
import com.example.task1.repository.MeasurmentRepository;
import com.example.task1.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService {
    @Autowired
    WareHouseRepository measurmentRepository;

    public ApiResponce addCategory(WareHouseDTO measurmentDTO){
        WareHouse measurment = new WareHouse();
        measurment.setName(measurmentDTO.getName());
        WareHouse save = measurmentRepository.save(measurment);
        return new ApiResponce(true , save);
    }

    public ApiResponce listMeasurment(){
        List<WareHouse> categoryRepositoryAll = measurmentRepository.findAll();
        return new  ApiResponce(true , categoryRepositoryAll);
    }

    public WareHouseDTO getOneMeasurment(int id){
        Optional<WareHouse> optionalCategory = measurmentRepository.findById(id);
        WareHouse measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            return  new WareHouseDTO(measurment.getName());
        }
        return null;
    }

    public ApiResponce editOne(int id , WareHouseDTO measurmentDTO){
        Optional<WareHouse> optionalCategory = measurmentRepository.findById(id);
        WareHouse measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            measurment.setName(measurmentDTO.getName());
            return  new ApiResponce(true , measurment.getName());
        }
        return null;
    }

    public ApiResponce deleteOne(int id){
        Optional<WareHouse> optionalCategory = measurmentRepository.findById(id);
        WareHouse measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
           measurmentRepository.deleteById(id);
            return  new ApiResponce(true , measurment);
        }
        return null;
    }


}
