package com.test.credit.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CUST_NAME")
    private String custName;
    
    @Column(name = "CARD_NO", unique=true)
    private Long cardno;
   
    @Column(name = "CREDIT_LIMIT")
    private int creditLimit;
    
    @Column(name = "BALANCE")
    private int balance;
	    
	public Credit() {
	  
	}
	
	public Credit(String custName, long cardno, int creditLimit) {
		this.custName = custName;
		this.cardno = cardno;
		this.creditLimit = creditLimit;	
		this.balance = 0;
	}
	
    public String getCustName() {
		return custName;
	}
    
    public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getcardno() {
		return cardno;
	}

	public void setcardno(Long cardno) {
		this.cardno = cardno;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", custName=" + custName + ", cardno=" + cardno + ", creditLimit=" + creditLimit + ", balance="
				+ balance + ", getName()=" + getCustName() + ", getcardno()=" + getcardno() + ", getLimit()=" + getCreditLimit()
				+ ", getId()=" + getId() + ", getBalance()=" + getBalance() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}		

}
