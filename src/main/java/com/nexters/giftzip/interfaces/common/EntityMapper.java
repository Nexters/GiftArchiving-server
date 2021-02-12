package com.nexters.giftzip.interfaces.common;

public interface EntityMapper <T,V> {
    V entityToResult(T t);
}
