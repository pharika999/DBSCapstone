package com.dbs.web.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SellOrder {
	
	@Id
	private String sellid;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrumentid;
	@OneToOne
	@JoinColumn(name="clientid")
	private Client clientid;
	private String status;
	private int quanity;
	private int remainingquantity;
	private int price;
	private LocalDate orderdate;
	public SellOrder() {
		// TODO Auto-generated constructor stub
	}
	public String getSellid() {
		return sellid;
	}
	public void setSellid(String sellid) {
		this.sellid = sellid;
	}
	public Instrument getInstrumentid() {
		return instrumentid;
	}
	public void setInstrumentid(Instrument instrumentid) {
		this.instrumentid = instrumentid;
	}
	public Client getClientid() {
		return clientid;
	}
	public void setClientid(Client clientid) {
		this.clientid = clientid;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public int getRemainingquantity() {
		return remainingquantity;
	}
	public void setRemainingquantity(int remainingquantity) {
		this.remainingquantity = remainingquantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	

}
