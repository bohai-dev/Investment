package com.investment.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.investment.bean.Strategy;

public class Main {
    
    static Logger logger = Logger.getLogger(Main.class);
    
    static Socket tradeSocket;
    
    static PrintWriter out;
    
    private List<Strategy> strategies;
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Main main = new Main();
        
        main.connect();
        /*Thread tradeConnect = new Thread(main.new TradeThread());
        tradeConnect.setDaemon(true);
        tradeConnect.start();*/
        
        while(true){
            if(true ){
                
                LocalTime nineOclock1 = LocalTime.of(9, 0);
                LocalTime now = LocalTime.now();
                if(now.isAfter(nineOclock1)){//9点后报单
                    
                }else {
                    try {
                        Thread.sleep(1000);
                        System.out.println(LocalTime.now());
                    } catch (InterruptedException e) {
                        logger.error("线程异常",e);
                    }
                }
            }
            
        }
        
    }
    
    /**
     * 连接交易服务器
     * @throws UnknownHostException
     * @throws IOException
     */
    public void connect() throws UnknownHostException, IOException{
        tradeSocket = new Socket("localhost", 3394);
        out = new PrintWriter(new OutputStreamWriter(tradeSocket.getOutputStream(),"UTF-8"));
    }
    
    /**
     * 交易线程
     * @author BHQH-CXYWB
     *
     */
    class TradeThread implements Runnable {
        
        public void run() {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(tradeSocket.getInputStream(),"UTF-8"));
                
            } catch (Exception e) {
                logger.error("获取交易socket输入流失败",e);
            }
            while(true){
                try {
                    String result = in.readLine();
                    logger.info("收到服务器返回信息"+result);
                    
                    String[] params = result.split("\\|");
                    
                    //用户名
                    String userName = params[1];
                    
                    
                    //成交回报
                    if(params[0].equals("onRtnTrade")){//成交回报
                        
                        
                        String tradeStr = params[3];
                        JSONObject jo = JSON.parseObject(tradeStr);
                        
                        logger.info("成交回报："+jo.toJSONString());
                        
                        
                    }/*else if (params[0].equals("onRtnOrder")) {//报单回报
                        
                        
                        
                    }else if (params[0].equals("onPosition")) {//持仓
                        
                        
                    }else if (params[0].equals("riskKYZJ")) {
                        
                    }*/
                    
                }catch (Exception e) {
                    logger.error("交易线程异常",e);
                    break;
                }
            }
            
        }
    }

}
