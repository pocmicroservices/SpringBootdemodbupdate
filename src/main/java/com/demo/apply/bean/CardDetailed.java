package com.demo.apply.bean;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetailed {

	private ArrayList<CardDetails> cardDetails=new ArrayList<CardDetails>();
    
	@JsonProperty("cardList")
	public ArrayList<CardDetails> getCardList() {
		return cardDetails;
	}

	public void setCardList(CardDetails cardDetail) {
		this.cardDetails.add(cardDetail);
	}
	
}
