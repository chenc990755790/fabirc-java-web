package com.ideal.blockchain.frame;

import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.stream.Collectors;

@SuppressWarnings("rawtypes")
@ControllerAdvice
public class ExceptionInterceptor extends BaseExceptionInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ExceptionInterceptor.class);

    private static final String DELIMITER = ";";

    @Override
    @SuppressWarnings("unchecked")
    protected ResultInfo buildResForRuleException(RuleException ex) {
        return new ResultInfo(ResponseCodeEnum.FAILURE.getCode(),ex.getMessage());
    }

    @Override
    protected ResultInfo buildResForException(Exception ex) {
        return new ResultInfo(ResponseCodeEnum.FAILURE);
    }

    @Override
    protected ResultInfo buildResForRequestValidException(MethodArgumentNotValidException ex) {
        String errorMessage = getErrorsMessage(ex.getBindingResult());
        return getTransResult(errorMessage);
    }

    @Override
    protected ResultInfo buildResForRequestValidException(BindException ex) {
        String errorMessage = getErrorsMessage(ex.getBindingResult());
        return getTransResult(errorMessage);
    }

    @Override
    protected ResultInfo buildResForRequestValidException(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining( DELIMITER ));
        return getTransResult(errorMessage);
    }

    @Override
    protected ResultInfo buildResForRequestValidException(MissingServletRequestParameterException ex) {
        return getTransResult("必要参数异常");
    }

    @Override
    protected ResultInfo buildResForRequestValidException(MethodArgumentTypeMismatchException ex) {
        return getTransResult("参数类型不匹配");
    }

    @Override
    protected ResultInfo buildResForRequestValidException(HttpRequestMethodNotSupportedException ex) {
        return getTransResult("请求方式错误");
    }

    @Override
    protected ResultInfo buildResForRequestValidException(HttpMessageNotReadableException ex) {
        return getTransResult("请求方式错误");
    }

    private String getErrorsMessage(BindingResult result){
        return result.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining( DELIMITER ));
    }

    private ResultInfo getTransResult(String errorMessage) {
        return new ResultInfo(ResponseCodeEnum.PARAM_VRFY_FAIL.getCode(), errorMessage);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Override
    public ResultInfo handleException(HttpServletRequest request, Exception ex) {
        return super.handleException(request, ex);
    }
}
