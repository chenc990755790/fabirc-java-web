package com.ideal.blockchain.frame;

import com.ideal.blockchain.enums.ResponseCodeEnum;

public class RuleException extends RuntimeException {
    private final String code;
    private final transient Object body;
    private final String[] parameterArr;

    public RuleException(Object body, ResponseCodeEnum code, String... parameterArr) {
        super(getText(code, parameterArr));
        this.code = code.toString();
        this.body = body;
        this.parameterArr = parameterArr;
    }

    public RuleException(Object body, ResponseCodeEnum code) {
        this(body, code, "");
    }

    public RuleException(ResponseCodeEnum code, String... parameterArr) {
        this((Object) null, code, parameterArr);
    }

    public RuleException(ResponseCodeEnum codeStr, String parameter) {
        super(getText(codeStr, parameter));
        this.code = codeStr.toString();
        this.body = null;
        this.parameterArr = new String[]{parameter};
    }

    private static String getText(ResponseCodeEnum codeStr, String... parameterArr) {
        if (parameterArr != null && parameterArr.length != 0) {
            return parameterArr[0] + codeStr.getDesc();
        } else {
            return codeStr.getDesc();
        }
    }

    public String getCode() {
        return this.code;
    }

    public Object getBody() {
        return this.body;
    }

    public String[] getParameterArr() {
        return this.parameterArr;
    }
}
