package com.db.trade.gitpipeline.repository;

import com.db.trade.gitpipeline.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepo extends JpaRepository<Trade,String> {
}



