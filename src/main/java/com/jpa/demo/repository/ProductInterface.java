package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.model.Product;

public interface ProductInterface extends JpaRepository <Product, Integer> {
    
}
