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
package snippets.jdk.jaxb.nested.a1;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "field")
public class Field {
    @XmlAttribute()
    private int id;
    private int folderFieldID;
    private String scope;
    private List<Locale> locales;

    public Field() {
    }
    
    public Field(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public int getFolderFieldID() {
        return folderFieldID;
    }
    public void setFolderFieldID(int folderFieldID) {
        this.folderFieldID = folderFieldID;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    public void setLocale(List<Locale> locales) {
        this.locales = locales;
    }
    public List<Locale> getLocale() {
        return this.locales;
    }
}
