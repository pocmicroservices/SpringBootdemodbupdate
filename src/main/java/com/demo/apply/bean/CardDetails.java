package com.demo.apply.bean;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDetails {

	private ArrayList<CardDetail> cardList=new ArrayList<CardDetail>();
	
	@JsonProperty("cardDetails")
	public ArrayList<CardDetail> getCardList() {
		return cardList;
	}

	public void setCardList(CardDetail card) {
		this.cardList.add(card);
	}
	
	
	
}
