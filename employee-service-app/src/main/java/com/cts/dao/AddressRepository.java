package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
