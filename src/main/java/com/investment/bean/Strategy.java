package com.investment.bean;

import java.util.Date;

public class Strategy {
    
    private String strategy;

   
    private String instrument;

   
    private String direction;

   
    private String volumn;

    
    private String cellprice;

   
    private String floorprice;

    
    private String timing;

    private String flag;

   
    private Date effectiveDate;

  
    private Date expireDate;

   
    public String getStrategy() {
        return strategy;
    }

    
    public void setStrategy(String strategy) {
        this.strategy = strategy == null ? null : strategy.trim();
    }

    
    public String getInstrument() {
        return instrument;
    }

    
    public void setInstrument(String instrument) {
        this.instrument = instrument == null ? null : instrument.trim();
    }

   
    public String getDirection() {
        return direction;
    }

   
    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

  
    public String getVolumn() {
        return volumn;
    }

   
    public void setVolumn(String volumn) {
        this.volumn = volumn == null ? null : volumn.trim();
    }

   
    public String getCellprice() {
        return cellprice;
    }

    public void setCellprice(String cellprice) {
        this.cellprice = cellprice == null ? null : cellprice.trim();
    }

    public String getFloorprice() {
        return floorprice;
    }

    public void setFloorprice(String floorprice) {
        this.floorprice = floorprice == null ? null : floorprice.trim();
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing == null ? null : timing.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}