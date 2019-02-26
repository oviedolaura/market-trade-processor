package com.currencyfair.markettradeprocessor.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "trade_message_info")
public class TradeMessageInfo implements Serializable {


	private static final long serialVersionUID = -129498827661538888L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String currencyFrom;
	
	@NotBlank
	private String currencyTo;
	
	@Column(nullable = false,precision=10, scale=2)
	private BigDecimal amountSell;
	
	@Column(nullable = false,precision=10, scale=2)
	private BigDecimal amountBuy;
	
	@Column(nullable = false,precision=5, scale=4)
	private BigDecimal rate;
	
	@NotBlank
	private String timePlaced;
	
	@NotBlank
	private String originatingCountry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}

	public BigDecimal getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

}
