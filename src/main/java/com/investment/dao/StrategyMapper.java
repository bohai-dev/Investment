package com.investment.dao;

import com.investment.bean.Strategy;

public interface StrategyMapper {
   
    int insert(Strategy record);

    
    int insertSelective(Strategy record);
}