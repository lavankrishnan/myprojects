package com.test.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.credit.model.Credit;

@Repository
public interface CreditCardRepository extends JpaRepository<Credit, Long>{

}
