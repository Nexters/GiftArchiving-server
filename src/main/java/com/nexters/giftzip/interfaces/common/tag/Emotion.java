package com.nexters.giftzip.interfaces.common.tag;

public enum Emotion {
    CHEER("응원해"),
    SORRY("미안해"),
    BOAST("나최고지"),
    CONGRATULATIONS("축하해"),
    NICE_SENSE("센스최고"),
    LOVE_YOU("사랑해"),
    IMPRESSION("감동이야"),
    AMAZING("놀라워")
    ;

    private String desc;

    Emotion(String desc) {
        this.desc = desc;
    }
}
