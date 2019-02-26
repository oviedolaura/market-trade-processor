package com.currencyfair.markettradeprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currencyfair.markettradeprocessor.model.TradeMessageInfo;

@Repository
public interface MarketTradeRepository extends JpaRepository<TradeMessageInfo,Long> {

}
