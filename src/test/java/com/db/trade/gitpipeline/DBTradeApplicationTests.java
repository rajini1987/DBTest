package com.db.trade.gitpipeline;

import com.db.trade.gitpipeline.controller.TradeController;
import com.db.trade.gitpipeline.model.Trade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)

public class DBTradeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	TradeController tradeController;


	private Trade getTrade(String tradeId, String bookId, String counterPartID, int version,LocalDate  maturityDate,String expFlag) {
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

		Trade trade = getTrade("T1", "B1","CP-1", 1, LocalDate.now(), "Y");


		try {

			ResponseEntity responseEntity = tradeController.trade(getTrade("T1", "B1", "CP-1", 1, LocalDate.now(), "Y"));
			Assert.fail();

		}catch (Exception e)
		{
			Assert.assertNotNull(e);
		}
	}

}
