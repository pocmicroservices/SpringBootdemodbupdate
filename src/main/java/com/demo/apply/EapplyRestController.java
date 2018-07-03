package com.demo.apply;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.apply.bean.ApplyCardResponseBody;
import com.demo.apply.bean.CardDetail;
import com.demo.apply.bean.CardDetailed;
import com.demo.apply.bean.CardDetails;
import com.demo.apply.bean.Customer;
import com.demo.apply.exception.ApplyCardException;
import com.demo.apply.exception.InvalidCardApplicationDataException;
import com.demo.apply.service.dao.ApplyCardDAO;

@RestController
public class EapplyRestController {

	private Logger logger=LoggerFactory.getLogger(EapplyApplication.class);
	
	@Autowired
	ApplyCardDAO dao;
	
	@CrossOrigin("*")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	@RequestMapping(value="/cards", produces={"application/json"})
	public CardDetailed cards(){
		logger.info("Entry Message /cards");
		
		CardDetail card=new CardDetail();
		card.setId(1);
		card.setCardHeader("My Card Unlimited");
		card.setCardRating(4);
		card.setCardMemberView(100000);
		card.setDetailsTransaction("Earn 5% cash back on upto $1500 in combined purchases in Bonus categories each quarter you activate and unlimited 1% cash back on all other purchases");
		
		List<String> offerList=new ArrayList<String>();
		offerList.add("NEW CARDMEMBER OFFER");
		offerList.add("$150 Bonus");
		offerList.add("After you spend $500 on purchases in the first 3 months from account opening");
		card.setOffer(offerList);
		
		List<String> glanceList=new ArrayList<String>();
		glanceList.add("At a View");
		glanceList.add("Earn Unlimited cash back");
		glanceList.add("Earn Unlimited 1.5% cashback on every purchase its automatic. No mimimum to redeem for cashback");
		card.setOffer(glanceList);
		
		List<String> aprList=new ArrayList<String>();
		aprList.add("ANNUAL FEE");
		aprList.add("$0");
		card.setApr(aprList);
		
		CardDetail card2=new CardDetail();
		card2.setId(2);
		card2.setCardHeader("My Card Unlimited");
		card2.setCardRating(4);
		card2.setCardMemberView(100000);
		card2.setDetailsTransaction("Earn 5% cash back on upto $1,500 in combined purchases n bonus categories each quarter you activate and unminited 1% cash back on all other purchases");
		
		CardDetailed cardDeta=new CardDetailed();
		
		CardDetails cardList=new CardDetails();
		cardList.setCardList(card);
		cardDeta.setCardList(cardList);
		
		logger.info("Exit Method /cards");
		return cardDeta;
	}
	
	@CrossOrigin(origins="*")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	@PostMapping("/apply")
	@ResponseBody
	public ApplyCardResponseBody update(@RequestBody Customer customer) throws Exception
	{
		logger.info("Entry Method /apply");
		
		ApplyCardResponseBody resp=new ApplyCardResponseBody();
		if(customer.getFirstName()!=null&&customer.getLastName()!=null&&customer.getSsn()!=null){
			//call delegate (Controller<=>delegate<=>DAO)
			
			resp.setStatus(HttpStatus.OK.toString());
			resp.setMessage("Success");
			dao.insertCustomer(customer);
		}
		else if(customer.getFirstName()==null){
			throw new InvalidCardApplicationDataException("14000", "UE", "Mandatory Field Value-First Name is Invalid");
		}
		else if(customer.getLastName()==null){
			throw new ApplyCardException("14001","BE","Mandatory Field Value - Last Name is Invalid");
		}
		else if(customer.getSsn()==null){
			throw new Exception("SSN is NULL");
		}
		logger.info("Exit Method /apply");
		return resp;
	}
}
