package com.db.trade.gitpipeline.controller;

import com.db.trade.gitpipeline.model.Trade;
import com.db.trade.gitpipeline.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @RequestMapping(value = "/trade", method = RequestMethod.POST)
    public ResponseEntity<String> trade(Trade trade) throws Exception       {
        if (!tradeService.isValidVersion(trade)) {
            throw new Exception();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
