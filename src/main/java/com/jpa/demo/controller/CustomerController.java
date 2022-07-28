package com.jpa.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jpa.demo.model.Customer;
import com.jpa.demo.repository.CustomerInteface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Controller
@RestController
@RequestMapping("/api/customer")
@Api("Api Clientes")
public class CustomerController {
    
    @Autowired CustomerInteface customerInteface;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra cliente")
    public @ResponseBody Customer saveCustomer(@Valid Customer customer){
        customerInteface.save(customer);
        return customer;
    }
    
    @GetMapping("/list")
    @ApiOperation("Lista clientes cadastrados")
    public List<Customer> listCustomer(){
        return customerInteface.findAll();
    }

    @GetMapping(path ="/list/{id}")
    @ApiOperation("Lista de cliente por id")
    @ApiResponse(code = 201, message = "Cliente encontrado")
    public Object listById(@PathVariable Integer id){
        Optional<Customer> customer = customerInteface.findById(id);

        if(customer.isPresent()){
            return customer.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    @PutMapping(path = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Atualiza cliente apartir do id")
    public Customer updateCustomer(@Valid Customer customer){
        saveCustomer(customer);
        return customer;
    }

    @DeleteMapping(path = "/delete/{id}" )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deleta cliente por id")
    public void deleteCustomer(@PathVariable Integer id){
    }

    @GetMapping("/list/name")
    @ApiOperation("Lista cliente por nome")
    public List<Customer> listByname(@PathVariable String name){
        try {
            List<Customer> customer = customerInteface.findByName(name);
            return customer;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

    
    }

}
