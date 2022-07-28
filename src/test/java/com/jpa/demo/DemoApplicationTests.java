package com.jpa.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.demo.model.Customer;
import com.jpa.demo.repository.CustomerInteface;
import com.jpa.demo.repository.OrderInterface;
import com.jpa.demo.repository.ProductInterface;

@SpringBootTest
class DemoApplicationTests {

	@Autowired CustomerInteface customerInteface;
	@Autowired ProductInterface productInterface;
	@Autowired OrderInterface orderInterface;


	@Test
	void save() {
		Customer customer = new Customer();
		customer.setId(89);
		customer.setName("Pulao Teste");
		customer.setCep("64564564564");
		customerInteface.save(customer);
		assertNotNull(customerInteface.findById(43).get());
	}

	@Test
	void listAll(){
		List<Customer> list = customerInteface.findAll();
		assertNotNull(list);
	}

	@Test
	public void update(){
		Customer customer = new Customer();
		customerInteface.findById(26).get();
		customer.setName("Julio Cesar");
		customer.setCep("25555555");
		customerInteface.save(customer);
		assertNotNull("TESTE", customerInteface.findById(26).get().getName());
	}

	@Test
	void deleteById(){
		customerInteface.deleteById(35);
		assertFalse(customerInteface.existsById(35));
	}



}
