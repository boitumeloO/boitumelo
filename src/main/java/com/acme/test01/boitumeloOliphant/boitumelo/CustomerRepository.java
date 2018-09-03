package com.acme.test01.boitumeloOliphant.boitumelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.test01.boitumeloOliphant.boitumelo.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
