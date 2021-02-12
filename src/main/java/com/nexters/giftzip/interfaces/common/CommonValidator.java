package com.nexters.giftzip.interfaces.common;

import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.ValidationException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import java.util.Collection;

public interface CommonValidator<T> {

    void validate(T t);

    default void validateCollectionIsEmpty(Collection collection) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new ValidationException(CommonErrorType.COLLECTION_IS_EMPTY);
        }
    }

    default void validateStringIsEmpty(String str) {
        if(StringUtils.isEmpty(str)) {
            throw new ValidationException(CommonErrorType.STRING_IS_EMPTY);
        }
    }

    default <T extends Number> void validateNumberIsNullOrZero(T t) {
        if(t == null || t.equals(0)) {
            throw new ValidationException(CommonErrorType.NUMBER_IS_NULL_OR_ZERO);
        }
    }

    default void validateObjectIsNull(Object object) {
        if(ObjectUtils.isEmpty(object)) {
            throw new ValidationException(CommonErrorType.OBJECT_IS_NULL);
        }
    }
}
