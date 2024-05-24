package com.db.trade.gitpipeline;

import com.db.trade.gitpipeline.controller.TradeController;
import com.db.trade.gitpipeline.exception.TradeException;
import com.db.trade.gitpipeline.model.Trade;
import com.db.trade.gitpipeline.repository.TradeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @Autowired
    TradeRepo tradeRepo;


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

    @Test
    public void test_when_same_version_trade_posted_then_override_the_existing_trade() {


        ResponseEntity responseEntity = tradeController.trade(getTrade("T1", "B1", "CP-4", 4, LocalDate.now(), "Y"));
        try {
            ResponseEntity responseEntity1 = tradeController.trade(getTrade("T1", "B1", "CP-3", 4, LocalDate.now(), "N"));
            List<Trade> tradeList = tradeRepo.findAll();

            Assertions.assertEquals("T1",tradeList.get(0).getTradeId());
            Assertions.assertEquals(4,tradeList.get(0).getVersion());
            Assertions.assertEquals("CP-3",tradeList.get(0).getCounterPartId());

        } catch (TradeException e) {

            Assertions.fail();
        }
    }

}
