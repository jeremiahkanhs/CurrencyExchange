package com.example.currency.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency.Service.ExchangeCurrency;


@RestController
public class CurrencyController {
	
	@Autowired
	ExchangeCurrency exchCurr;
	
	@RequestMapping("/currencyExchange")
	public String currencyExchange(@RequestParam("fromCurrency") String fromCurrency, 
								   @RequestParam("toCurrency") String toCurrency,
								   @RequestParam("exchangeAmount") String exchangeAmount) {
		BigDecimal exchangeRate = exchCurr.getExchangeRate(fromCurrency, toCurrency);
		BigDecimal exchangeAmt = exchCurr.getExchangedAmount(exchangeRate, exchangeAmount);
		return exchangeAmt.toString();
	}
}
