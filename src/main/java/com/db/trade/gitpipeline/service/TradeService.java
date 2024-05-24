package com.db.trade.gitpipeline.service;

import com.db.trade.gitpipeline.model.Trade;
import com.db.trade.gitpipeline.repository.TradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TradeService {

    @Autowired
    TradeRepo tradeRepo;

    public boolean isValidVersion(Trade trade){

        if(valideMaturityDate(trade)) {
            Optional<Trade> existingTrade = tradeRepo.findById(trade.getTradeId());
            if (existingTrade.isPresent()) {
                return validateVersion(trade, existingTrade.get());
            }else{
                return true;
            }
        }
        return false;
    }

    private boolean validateVersion(Trade trade,Trade oldTrade) {

        return trade.getVersion() >= oldTrade.getVersion();
    }

    public void  createNewTrade(Trade trade){
        trade.setCreatedDate(LocalDate.now());
        tradeRepo.save(trade);
    }

    private boolean valideMaturityDate(Trade trade){
        return !trade.getMaturityDate().isBefore(LocalDate.now());
    }


}
