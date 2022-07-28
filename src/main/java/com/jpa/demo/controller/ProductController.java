package com.jpa.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.model.Product;
import com.jpa.demo.repository.ProductInterface;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired ProductInterface repo;

    @PostMapping("/register")
    @ApiOperation("Cadastra produto")
    public @ResponseBody Product saveCustomer(@Valid Product product) {
       repo.save(product);
        return product;
    }

    @GetMapping("/list")
    @ApiOperation("Lista produtos cadastrados")
    public List<Product> listCustomer(){
        return repo.findAll();
    }

    @GetMapping(path ="/list/{id}")
    @ApiOperation("Lista produto por id")
    public Object listById(@PathVariable Integer id){
        return repo.findById(id);
    }

    @PutMapping(path = "/update/{id}")
    @ApiOperation("Atualiza produto por id")
    public Product updateCustomer(@Valid Product product){
        saveCustomer(product);
        return product;
    }

    @DeleteMapping(path = "/delete/{id}" )
    @ApiOperation("Deleta produto por id")
    public void deleteCustomer(@PathVariable Integer id){
        repo.deleteById(id);
    }
}
