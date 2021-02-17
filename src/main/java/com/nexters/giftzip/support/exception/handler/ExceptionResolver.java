package com.nexters.giftzip.support.exception.handler;

import com.nexters.giftzip.support.exception.ErrorResponse;
import com.nexters.giftzip.support.exception.HandleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class ExceptionResolver extends AbstractHandlerExceptionResolver {
    private final int DEFAULT_ERROR = -1;

    public ExceptionResolver() {
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest req,
                                              HttpServletResponse resp, Object handler, Exception ex) {
        // Call super method to get the ModelAndView
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

        Map<String, Object> map = new LinkedHashMap<>();
        if (ex instanceof HandleException) {
            map.put("code", ((HandleException) ex).getCommonErrorType().getErrorCode());
            map.put("reason", ((HandleException) ex).getCommonErrorType().getDesc());
            mav.setStatus(((HandleException) ex).getCommonErrorType().getStatus());
        } else if (ex instanceof DuplicateKeyException) {
            map.put("code", -403);
            map.put("reason", "중복 회원 입니다.");
            mav.setStatus(HttpStatus.NOT_ACCEPTABLE);
        } else {
            map.put("code", DEFAULT_ERROR);
            map.put("reason", ex.getLocalizedMessage());
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        mav.addAllObjects(map);
        ex.printStackTrace();
        return mav;
    }
}
