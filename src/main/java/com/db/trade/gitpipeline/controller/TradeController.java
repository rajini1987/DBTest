package com.db.trade.gitpipeline.controller;

import com.db.trade.gitpipeline.exception.TradeException;
import com.db.trade.gitpipeline.exception.TradeException;
import com.db.trade.gitpipeline.model.Trade;
import com.db.trade.gitpipeline.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @RequestMapping(value = "/trade", method = RequestMethod.POST)
    public ResponseEntity<String> trade(@RequestBody Trade trade) {
        if (tradeService.isValidVersion(trade)) {

            tradeService.createNewTrade(trade);
        } else {

            //return ResponseEntity.badRequest().body("Invalid Trade request");

            throw new TradeException();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
