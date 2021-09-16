package com.dbs.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ClientStocks {

	@Id
	private int stockid;
	@OneToOne
	@JoinColumn(name="clientid")
	private Client client;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private int quantity;
	public ClientStocks() {
		// TODO Auto-generated constructor stub
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public Client getClientid() {
		return client;
	}
	public void setClientid(Client client) {
		this.client = client;
	}
	public Instrument getInstrumentid() {
		return instrument;
	}
	public void setInstrumentid(Instrument instrumentid) {
		this.instrument = instrument;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
