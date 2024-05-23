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

        if(validateMaturityDate(trade)) {
            Trade exsitingTrade = tradeRepo.getOne(trade.getTradeId());
            if (exsitingTrade.getTradeId() !=null) {
                return validateVersion(trade, exsitingTrade);
            }else{
                return true;
            }
        }
        return false;
    }

    private boolean validateVersion(Trade trade,Trade oldTrade) {

        if(trade.getVersion() >= oldTrade.getVersion()){
            return true;
        }
        return false;
    }

    private boolean validateMaturityDate(Trade trade){
        return trade.getMaturityDate().isBefore(LocalDate.now())  ? false:true;
    }


}
