package com.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.v2.model.Customer;
import com.v2.repo.CustomerRepo;
import com.v2.utils.KafkaContant;

@Service("customerService")
public class CustomerService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@Autowired
	private CustomerRepo repo;
	
	public String add(List<Customer> customer) {
		if (!customer.isEmpty()) {
			for (Customer cust : customer) {
				kafkaTemplate.send(KafkaContant.TOPIC,cust);
				System.out.println("**********Mgs Published to Kafka Topic***************: "+cust);
			}
			
		}
		return "Customer Record Added to kafka Queue Successfully";
		
	}
	
	@KafkaListener(topics = KafkaContant.TOPIC, groupId = KafkaContant.GROUP_ID)
	public String listener(String cust) {
		System.out.println("====*MSG Recieved From Kafka Topics*=====: " + cust);
		return cust;

	}

	public Customer saveCust(Customer cust) {
		return repo.save(cust);
	}

	public List<Customer> getCustomers() {
		return repo.findAll();
	}
	

}
