package com.nexters.giftzip.interfaces.common.tag;

public enum Category {
    LIVING("리빙"),
    VOUCHER("모바일 교환권"),
    BEAUTY("화장품"),
    FASHION("패션"),
    FOOD("식품"),
    DIGITAL("디지털"),
    CULTURE("문화"),
    BABY("육아용품"),
    PET("반려동물"),
    ETC("기타"),
    GIFT_CARD("상품권"),
    SPORTS("스포츠");

    private String desc;

    Category(String desc) {
        this.desc = desc;
    }
}
