package com.example.task1.service;

import com.example.task1.entity.Attachment;
import com.example.task1.entity.Category;
import com.example.task1.entity.Measurment;
import com.example.task1.entity.Product;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.peliod.MeasurmentDTO;
import com.example.task1.peliod.ProductDTO;
import com.example.task1.repository.CategoryRepository;
import com.example.task1.repository.MeasurmentRepository;
import com.example.task1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MeasurmentRepository measurmentRepository;


    public ApiResponce addProduct(ProductDTO productDTO){
        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        Category category = optionalCategory.get();
        Optional<Measurment> optionalMeasurment = measurmentRepository.findById(productDTO.getMeasurmentId());
        Measurment measurment = optionalMeasurment.get();

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCode((int) (Math.random()*100));
        product.setMeasurment(measurment);
        product.setCategory(category);
        Product save = productRepository.save(product);
        return new ApiResponce(true , save);
    }

    public ApiResponce listproduct(){
        List<Product> productList = productRepository.findAll();
        List<ProductDTO>productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTO.setMeasurmentId(product.getMeasurment().getId());
            productDTOList.add(productDTO);
        }
        return new  ApiResponce(true , productDTOList);
    }

    public ApiResponce getOneMeasurment(int id){
        Optional<Product> optionalCategory = productRepository.findById(id);
        Product product = optionalCategory.get();
        if (optionalCategory.isPresent()) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTO.setMeasurmentId(product.getMeasurment().getId());
            return  new ApiResponce(true , productDTO);
        }
        return null;
    }

    public ApiResponce editOne(int id , ProductDTO productDTO){
        Optional<Product> optionalCategory = productRepository.findById(id);
        Product product = optionalCategory.get();
        Category repositoryById = categoryRepository.getById(id);
        Measurment repositoryById1 = measurmentRepository.getById(id);
        if (optionalCategory.isPresent()) {
            product.setName(productDTO.getName());
            product.setCategory(repositoryById);
            product.setMeasurment(repositoryById1);
            productRepository.save(product);
            return  new ApiResponce(true , product);
        }
        return null;
    }

    public ApiResponce deleteOne(int id){
        Optional<Product> optionalCategory = productRepository.findById(id);
        Product measurment = optionalCategory.get();
        if (optionalCategory.isPresent()) {
           measurmentRepository.deleteById(id);
            return  new ApiResponce(true , measurment);
        }
        return null;
    }


}
