package com.currencyfair.markettradeprocessor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.currencyfair.markettradeprocessor.model.TradeMessageInfo;
import com.currencyfair.markettradeprocessor.repository.MarketTradeRepository;
import com.currencyfair.markettradeprocessor.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class TradeMessageController {
	
	public static final Logger logger = LoggerFactory.getLogger(TradeMessageController.class);
	
	@Autowired
	MarketTradeRepository tradeRepository;
	
	// -------------------Create a Trade-------------------------------------------
	  
		@PostMapping("/create")
		public ResponseEntity<?> createTrade(@RequestBody TradeMessageInfo trade, UriComponentsBuilder ucBuilder) {
			logger.info("Creating Trade Message : {}", trade);

			trade = tradeRepository.save(trade);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/trademessage/create/{id}").buildAndExpand(trade.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}

		// -------------------Retrieve Single Trade---------------------------------------

		@GetMapping("/trades/{id}")
		public ResponseEntity<?> getTrade(@PathVariable("id") Long id) {
			logger.info("Fetching Trade with id {}", id);
			TradeMessageInfo trade = tradeRepository.findById(id).get();
			if (trade == null) {
				logger.error("Trade with id {} not found.", id);
				return new ResponseEntity<CustomErrorType>(new CustomErrorType("Trade with id " + id + " not found"),
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<TradeMessageInfo>(trade, HttpStatus.OK);
		}
		
		@GetMapping("/trades")
		public List<TradeMessageInfo> getAllTrade() {
			logger.info("Fetching All Trades");
			return tradeRepository.findAll();
		}

}
