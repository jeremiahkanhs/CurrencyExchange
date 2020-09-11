package com.example.currency.Service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.currency.Model.Currency;

@Component
public class ExchangeCurrency extends Currency {

	public enum availCurrency { SGD, USD };

	@Override
	public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		availCurrency availFromCurrency;
		availCurrency availToCurrency;
		try {
			availFromCurrency = availCurrency.valueOf(fromCurrency);
			availToCurrency = availCurrency.valueOf(toCurrency);
			BigDecimal exchRate;
			switch (availFromCurrency) {
				case SGD : 
					switch (availToCurrency) {
						case USD : 
							exchRate = BigDecimal.valueOf(0.742164);
							return exchRate;
						case SGD : 
							return BigDecimal.valueOf(1.0);
						default:
							break;
					};
				case USD : 
					switch (availToCurrency) {
						case SGD :
							exchRate = BigDecimal.valueOf(1.34782);
							return exchRate;
						case USD : 
							return BigDecimal.valueOf(1.0);
						default:
							break;
					}
			}
		}catch(IllegalArgumentException IAE) {
			System.out.println("Assuming theres a logger : Please only select currencies from the available currencies");
		}
		return null;
	}

	@Override
	public BigDecimal getExchangedAmount(BigDecimal Currency, String ExchAmount) {
		// TODO Auto-generated method stub
		try {
			Long longExchAmt = Long.parseLong(ExchAmount);
			BigDecimal exchAmt = BigDecimal.valueOf(longExchAmt);
			return Currency.multiply(exchAmt);
		}catch (Exception E) {
			
		}
		return null;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
