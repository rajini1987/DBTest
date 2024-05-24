package com.db.trade.gitpipeline;

import com.db.trade.gitpipeline.controller.TradeController;
import com.db.trade.gitpipeline.exception.TradeException;
import com.db.trade.gitpipeline.model.Trade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)

public class DBTradeApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    TradeController tradeController;


    private Trade getTrade(String tradeId, String bookId, String counterPartID, int version, LocalDate maturityDate, String expFlag) {
        Trade trade = new Trade();
        trade.setTradeId(tradeId);
        trade.setBookId(bookId);
        trade.setVersion(version);
        trade.setCounterPartId(counterPartID);
        trade.setMaturityDate(maturityDate);
        trade.setExpiredFlag(expFlag);
        return trade;
    }


    @Test
    public void test_when_lower_version_trade_posted_then_throw_exception() {


        ResponseEntity responseEntity = tradeController.trade(getTrade("T1", "B1", "CP-1", 3, LocalDate.now(), "Y"));

        try {
            ResponseEntity responseEntity1 = tradeController.trade(getTrade("T1", "B1", "CP-1", 1, LocalDate.now(), "Y"));
            Assertions.fail();

        } catch (TradeException e) {

            Assertions.assertNotNull(e);
        }
    }

}
