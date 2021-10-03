package com.example.task1.service;

import com.example.task1.entity.Category;
import com.example.task1.entity.Measurment;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CategoryDTO;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.repository.CategoryRepository;
import com.example.task1.repository.MeasurmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurmentService {
    @Autowired
    MeasurmentRepository measurmentRepository;

    public ApiResponce addCategory(MeasurmentDTO measurmentDTO){
        Measurment measurment = new Measurment();
        measurment.setName(measurmentDTO.getName());
        Measurment save = measurmentRepository.save(measurment);
        return new ApiResponce(true , save);
    }

    public ApiResponce listMeasurment(){
        List<Measurment> categoryRepositoryAll = measurmentRepository.findAll();
        return new  ApiResponce(true , categoryRepositoryAll);
    }

    public MeasurmentDTO getOneMeasurment(int id){
        Optional<Measurment> optionalCategory = measurmentRepository.findById(id);
        Measurment measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            return  new MeasurmentDTO(measurment.getName());
        }
        return null;
    }

    public ApiResponce editOne(int id , MeasurmentDTO measurmentDTO){
        Optional<Measurment> optionalCategory = measurmentRepository.findById(id);
        Measurment measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            measurment.setName(measurmentDTO.getName());
            return  new ApiResponce(true , measurment.getName());
        }
        return null;
    }

    public ApiResponce deleteOne(int id){
        Optional<Measurment> optionalCategory = measurmentRepository.findById(id);
        Measurment measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
           measurmentRepository.deleteById(id);
            return  new ApiResponce(true , measurment);
        }
        return null;
    }


}
