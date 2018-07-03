package com.demo.apply.bean;

import java.util.List;

public class CardDetail {

	private int id;
	private String cardHeader;
	private int cardRating;
	private int cashback;
	private int cardMemberView;
	private String detailsTransaction;
	private List<String> offer;
	private List<String> glance;
	private List<String> apr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardHeader() {
		return cardHeader;
	}
	public void setCardHeader(String cardHeader) {
		this.cardHeader = cardHeader;
	}
	public int getCardRating() {
		return cardRating;
	}
	public void setCardRating(int cardRating) {
		this.cardRating = cardRating;
	}
	public int getCashback() {
		return cashback;
	}
	public void setCashback(int cashback) {
		this.cashback = cashback;
	}
	public int getCardMemberView() {
		return cardMemberView;
	}
	public void setCardMemberView(int cardMemberView) {
		this.cardMemberView = cardMemberView;
	}
	public String getDetailsTransaction() {
		return detailsTransaction;
	}
	public void setDetailsTransaction(String detailsTransaction) {
		this.detailsTransaction = detailsTransaction;
	}
	public List<String> getOffer() {
		return offer;
	}
	public void setOffer(List<String> offer) {
		this.offer = offer;
	}
	public List<String> getGlance() {
		return glance;
	}
	public void setGlance(List<String> glance) {
		this.glance = glance;
	}
	public List<String> getApr() {
		return apr;
	}
	public void setApr(List<String> apr) {
		this.apr = apr;
	}
}
