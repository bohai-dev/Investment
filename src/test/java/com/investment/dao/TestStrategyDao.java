package com.investment.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.investment.bean.Strategy;



public class TestStrategyDao {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	@Before
    public void init(){
	        String resource = "mybatis-config.xml";
	        if(sqlSessionFactory ==null){
	            try {
	                InputStream inputStream = Resources.getResourceAsStream(resource);
	                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	                
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	
	
	@Test
	public void testInsertSelective() {
		 SqlSession session = sqlSessionFactory.openSession();	        
	     StrategyMapper mapper = session.getMapper(StrategyMapper.class);	     
	     Strategy strategy=new Strategy();
	     strategy.setStrategy("策略");
	     strategy.setInstrument("合约品种");
	     strategy.setDirection("买卖方向");
	     strategy.setVolumn("数量");
	     strategy.setCellprice("止盈价");
	     strategy.setEffectiveDate(new Date());	     
	     mapper.insertSelective(strategy);
	            
	     session.commit();	     
	     session.close();
		
	}
	    
	

}
