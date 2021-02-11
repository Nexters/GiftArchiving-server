package com.nexters.giftzip.interfaces.rest.common.tag;

public enum Reason {
    ANNIVERSARY("기념일"),
    BIRTHDAY("생일"),
    HOUSES("집들이"),
    EMPLOYMENT("취업"),
    MARRIAGE("결혼"),
    STUDY("학업"),
    HOLIDAY("명절"),
    CHEER_UP("응원"),
    THANKS("감사"),
    APOLOGIZE("사과"),
    JUST("그냥"),
    ETC("기타");

    private String desc;

    Reason(String desc) {
        this.desc = desc;
    }
}
