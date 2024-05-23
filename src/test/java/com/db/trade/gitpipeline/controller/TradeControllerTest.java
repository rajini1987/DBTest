//package com.db.trade.gitpipeline.controller;
//
//import com.db.trade.gitpipeline.model.Trade;
//import org.junit.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//
//@WebMvcTest(controllers =TradeController.class)
//
//public class TradeControllerTest {
//
//    @Test
//    public void test_when_lower_version_trade_posted_then_throw_exception() {
//
////
////		when(tradeController.trade(
////				getTrade("T1", "B1","CP-1", 1, LocalDate.now(), "Y"))).thenReturn(ResponseEntity.status(HttpStatus.OK).build());
//
//        ResponseEntity responseEntity = tradeController.trade(
//                getTrade("T1", "B1","CP-1", 1, LocalDate.now(), "Y"));
//
////		List<Trade> tradeList =tradeController.findAllTrades();
////		Assert.assertEquals(1, tradeList.size());
////		Assert.assertEquals("T1",tradeList.get(0).getTradeId());
////		Assertions.assertEquals(2,tradeList.get(0).getVersion());
////		Assertions.assertEquals("T1B1",tradeList.get(0).getBookId());
////		Assert.asserte
//
//    }
//
//    private Trade getTrade(String tradeId, String bookId, String counterPartID, int version, LocalDate  maturityDate, String expFlag) {
//        Trade trade = new Trade();
//        trade.setTradeId(tradeId);
//        trade.setBookId(bookId);
//        trade.setVersion(version);
//        trade.setCounterPartId(counterPartID);
//        trade.setMaturityDate(maturityDate);
//        trade.setExpiredFlag(expFlag);
//        return trade;
//    }
//
//}