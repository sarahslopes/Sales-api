package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.model.Order;

public interface OrderInterface extends JpaRepository<Order, Integer>{
    
}
