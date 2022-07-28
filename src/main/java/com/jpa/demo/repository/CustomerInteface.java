package com.jpa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.demo.model.Customer;

public interface CustomerInteface extends JpaRepository<Customer, Integer>{
    
    @Query(value = " select c from Customer c where c.name like :name ")
    List<Customer> findByName(@Param("name") String name);

    boolean existsByName(String name);
    
    }

