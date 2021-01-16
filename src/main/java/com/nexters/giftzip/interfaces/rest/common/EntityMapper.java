package com.nexters.giftzip.interfaces.rest.common;

public interface EntityMapper <T,V> {
    V entityToResult(T t);
}
