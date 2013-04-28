/*
 * (C) Copyright. Kuehne + Nagel All rights reserved.
 * 
 * This document, which contains confidential material, is private and
 * confidential and is the property and copyright of Kuehne + Nagel. It is not
 * to be used for any other purposes, copied, distributed or transmitted in any
 * form or by any means without the prior written consent of Kuehne + Nagel.
 * Infringement of copyright is a serious civil and criminal offense, which can
 * result in heavy fines and payment of substantial damages.
 */
package design.pattern.decorator.a2.after;

public class User {
    private String name;
    private boolean vip;
    private boolean company;
    
    public User(String name, boolean vip, boolean company) {
        this.name = name;
        this.vip = vip;
        this.company = company;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isVip() {
        return vip;
    }
    
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    public boolean isCompany() {
        return company;
    }
    
    public void setCompany(boolean company) {
        this.company = company;
    }
}