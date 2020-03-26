package com.ideal.blockchain.frame;

import com.alibaba.fastjson.JSON;
import com.ideal.blockchain.dto.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

public abstract class BaseExceptionInterceptor {
    private static final Logger log = LoggerFactory.getLogger(BaseExceptionInterceptor.class);

    public BaseExceptionInterceptor() {
    }

    protected abstract ResultInfo buildResForRuleException(RuleException ex);

    protected abstract ResultInfo buildResForException(Exception ex);

    protected abstract ResultInfo buildResForRequestValidException(MethodArgumentNotValidException ex);

    protected abstract ResultInfo buildResForRequestValidException(BindException ex);

    protected abstract ResultInfo buildResForRequestValidException(ConstraintViolationException ex);

    protected abstract ResultInfo buildResForRequestValidException(MissingServletRequestParameterException ex);

    protected abstract ResultInfo buildResForRequestValidException(MethodArgumentTypeMismatchException ex);

    protected abstract ResultInfo buildResForRequestValidException(HttpRequestMethodNotSupportedException ex);

    protected abstract ResultInfo buildResForRequestValidException(HttpMessageNotReadableException ex);

    protected ResultInfo handleException(HttpServletRequest request, Exception ex) {
        log.error("异常: ",ex);

        Throwable cause = ex.getCause() == null ? ex : ex.getCause();
        ResultInfo result;
        if (cause != null && cause instanceof MethodArgumentNotValidException) {
            result = this.buildResForRequestValidException((MethodArgumentNotValidException) cause);
        } else if (cause != null && cause instanceof BindException) {
            result = this.buildResForRequestValidException((BindException) cause);
        } else if (cause != null && cause instanceof ConstraintViolationException) {
            result = this.buildResForRequestValidException((ConstraintViolationException) cause);
        } else if (cause != null && cause instanceof MissingServletRequestParameterException) {
            result = this.buildResForRequestValidException((MissingServletRequestParameterException) cause);
        } else if (cause != null && cause instanceof MethodArgumentTypeMismatchException) {
            result = this.buildResForRequestValidException((MethodArgumentTypeMismatchException) cause);
        } else if (cause != null && cause instanceof HttpRequestMethodNotSupportedException) {
            result = this.buildResForRequestValidException((HttpRequestMethodNotSupportedException) cause);
        } else if (cause != null && cause instanceof HttpMessageNotReadableException) {
            result = this.buildResForRequestValidException((HttpMessageNotReadableException) cause);
        } else if (cause != null && cause instanceof RuleException) {
            result = this.buildResForRuleException((RuleException) cause);
        } else {
            result = this.buildResForException(ex);
        }
        log.info("==========>返回结果 : {}", JSON.toJSONString(result));
        return result;
    }
}
