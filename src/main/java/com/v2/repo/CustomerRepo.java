package com.v2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.v2.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
