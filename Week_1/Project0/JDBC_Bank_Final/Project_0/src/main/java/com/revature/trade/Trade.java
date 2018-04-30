package com.revature.trade;

import java.io.Serializable;

/**
 * Trade object that contains all the important information necessary for user trading
 * @author Jesse
 *
 */

public class Trade implements Serializable {


	private static final long serialVersionUID = -476213740237196669L;
	private int idRequestor;
	private int idAcceptor;
	private int tradeAmount;
	
	public int getIdRequestor() {
		return idRequestor;
	}
	public void setIdRequestor(int idRequestor) {
		this.idRequestor = idRequestor;
	}
	public int getIdAcceptor() {
		return idAcceptor;
	}
	public void setIdAcceptor(int idAcceptor) {
		this.idAcceptor = idAcceptor;
	}
	public int getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(int tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAcceptor;
		result = prime * result + idRequestor;
		result = prime * result + tradeAmount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (idAcceptor != other.idAcceptor)
			return false;
		if (idRequestor != other.idRequestor)
			return false;
		if (tradeAmount != other.tradeAmount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\n\t\tACCOUNT NUMBER " + idRequestor + " WOULD LIKE TO TRADE: " + tradeAmount + " TICOS\n";
	}
	
	public Trade(int idRequestor, int idAcceptor, int tradeAmount) {
		super();
		this.idRequestor = idRequestor;
		this.idAcceptor = idAcceptor;
		this.tradeAmount = tradeAmount;
	}
	
	public Trade() {}
}