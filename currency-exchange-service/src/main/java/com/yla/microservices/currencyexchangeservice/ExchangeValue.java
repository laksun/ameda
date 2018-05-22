package com.yla.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ExchangeValue {

	@Id
	private Long id;
	
	@Column(name="currency_from")
	String from;
	
	@Column(name="currency_to")
	String to;
	BigDecimal valueOf;
	int port;

	public int getPort() {
		return port;
	}

	public ExchangeValue(long l, String from, String to, BigDecimal valueOf) {
		this.id = l;
		this.from = from;
		this.to = to;
		this.valueOf = valueOf;
	}

	

	@Override
	public String toString() {
		return "ExchangeValue [l=" + id + ", from=" + from + ", to=" + to + ", valueOf=" + valueOf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((valueOf == null) ? 0 : valueOf.hashCode());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExchangeValue other = (ExchangeValue) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id != other.id)
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (valueOf == null) {
			if (other.valueOf != null)
				return false;
		} else if (!valueOf.equals(other.valueOf))
			return false;
		return true;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getValueOf() {
		return valueOf;
	}

	public void setValueOf(BigDecimal valueOf) {
		this.valueOf = valueOf;
	}

	public void setPort(int port) {
		this.port=port;

	}

}
