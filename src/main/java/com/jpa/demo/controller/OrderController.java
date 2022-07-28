package com.jpa.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.jpa.demo.model.Order;
import com.jpa.demo.repository.OrderInterface;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/api/order")
public class OrderController{
    
    @Autowired OrderInterface orderInteface;

    @PostMapping("/register")
    @ApiOperation("Cadastra pedido")
    public @ResponseBody Order save(@Valid Order order) {
        orderInteface.save(order);
        return order;
    }

    @GetMapping("/list")
    @ApiOperation("Lista pedidos cadastrados")
    public List<Order> findAll() {
        return orderInteface.findAll(); 
    }

    @GetMapping(path = "list/{id}")
    @ApiOperation("Lista pedidos por id")
    public Optional<Order> listById(@PathVariable Integer id) {
         return orderInteface.findById(id);
    }
   

    @PutMapping(path = "/update/{id}")
    @ApiOperation("Atualiza pedidos por id")
    public Order update(@Valid Order order){
        orderInteface.save(order);
        return order;
    }

    @DeleteMapping(path = "/delete/{id}")
    @ApiOperation("Deleta pedidos por id")
    public void deleteById(@Valid @PathVariable Integer id) {
        orderInteface.deleteById(id); 
    }

}
