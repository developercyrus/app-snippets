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
package design.pattern.decorator.a1;

public class Teacher implements Human {
    private Human human;

    public Teacher(Human human) {
        this.human = human;
    }

    public String getJob() {
        return "In school " + this.human.getJob();
    } 
}