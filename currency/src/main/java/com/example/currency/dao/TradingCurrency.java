package com.example.currency.dao;

import java.math.BigDecimal;

public interface TradingCurrency{

	public BigDecimal getExchangeRate (String fromCurrency, String toCurrency);
	
	public BigDecimal getExchangedAmount (BigDecimal Currency, String ExchAmount);
	
}
