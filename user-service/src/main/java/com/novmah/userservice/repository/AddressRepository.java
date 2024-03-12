package com.novmah.userservice.repository;

import com.novmah.userservice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByUserId(Integer userId);

}
