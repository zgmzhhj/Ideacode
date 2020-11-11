package com.zgwzhhj.designpattern.pattern9;

public class Context {
    private String name;
    private String cardid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String cardid) {
        this.cardid = cardid;
    }

    public String getCardid() {
        return cardid;
    }
}
