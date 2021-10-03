package com.example.task1.service;

import com.example.task1.entity.Category;
import com.example.task1.entity.Measurment;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.CategoryDTO;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponce addCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        if (categoryDTO.getPrentId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getPrentId());
            category.setParenCategory(optionalCategory.get());
        } else {
            category.setParenCategory(null);
        }
        Category save = categoryRepository.save(category);
        return new ApiResponce(true,save);
    }

    public ApiResponce listCategory(){
        List<Category> categoryRepositoryAll = categoryRepository.findAll();
        return new  ApiResponce(true , categoryRepositoryAll);
    }

    public CategoryDTO getOneCategory(int id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(category.getName());
            categoryDTO.setPrentId(category.getId());
            return  categoryDTO;
        }
            return null;

    }


    public ApiResponce editOne(int id , CategoryDTO categoryDTO){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            category.setName(categoryDTO.getName());
            category.setParenCategory(categoryRepository.getById(categoryDTO.getPrentId()));
            return  new ApiResponce(true , category);
        }
        return null;
    }

    public ApiResponce deleteOne(int id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            categoryRepository.deleteById(id);
            return  new ApiResponce(true , category);
        }
        return null;
    }


}
