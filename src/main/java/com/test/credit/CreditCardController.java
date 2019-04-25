package com.test.credit;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.credit.model.Credit;
import com.test.credit.repository.CreditCardRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CreditCardController {
	
	private CreditCardRepository creditRepository;	
	
	public CreditCardController(CreditCardRepository creditRepository) {
        this.creditRepository = creditRepository;
    }
	
	@PostMapping(value="/register", produces = {"application/json"})
	@ResponseBody
	public Credit registerUser(@RequestBody Credit creditCard) 
			throws Exception
	{	
		if(creditCard !=null && validateCreditCard(creditCard)) {
			return creditRepository.save(creditCard);
		}

		else {
			throw new Exception("Invalid CreditCardNumber");
		}
	}
	
	@GetMapping("/users")
    public List<Credit> getAllUsers() {
        return creditRepository.findAll();
    }
	
	private boolean validateCreditCard(@Valid Credit creditCard) {
		String cardNo = String.valueOf(creditCard.getcardno());
		int length = cardNo.length();
	    int sum = 0; 

		if(length <=19) {
			boolean secondDgt = false; 
		    for (int i = cardNo.length() - 1; i >= 0; i--)  
		    { 
		  
		        int d = cardNo.charAt(i) - '0'; 
		  
		        if (secondDgt == true) 
		            d = d * 2; 
		  
		        // We add two digits to handle 
		        // cases that make two digits  
		        // after doubling 
		        sum += d / 10; 
		        sum += d % 10; 
		  
		        secondDgt = !secondDgt; 
		    } 
		    return (sum % 10 == 0); 
		}
		else {
			return false;
		}
	}
}
