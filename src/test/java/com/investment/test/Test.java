package com.investment.test;

import java.time.LocalTime;

public class Test {
    
    public static void main(String[] args) {
        
        
        LocalTime nineOclock = LocalTime.parse("09:00:00");
        
        LocalTime nineOclock1 = LocalTime.of(9, 0);
        
        LocalTime now = LocalTime.now();
        
        System.out.println(nineOclock.equals(now));
    }

}
