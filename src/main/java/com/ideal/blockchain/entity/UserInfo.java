package com.ideal.blockchain.entity;

import com.ideal.blockchain.dto.request.UserDto;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class UserInfo extends UserDto {

    private static final String OBJECT_TYPE_NAME="userInfo";

    private static final String objectType = OBJECT_TYPE_NAME;

    @NotBlank(message = "用户编号不能为空")
    private String userId;
    @NotBlank(message = "用户手机号码不能为空")
    private String mobile;
    @NotBlank(message = "登陆密码不能为空")
    private String loginPassword;
    @NotBlank(message = "公司编号不能为空")
    private String companyId;
    private Date loginLastTime;

    private Date loginPasswordErrorLastTime;

    private Long loginPasswordErrorTimes;

    private Date loginPasswordUpdateTime;
    @NotBlank(message = "用户状态不能为空")
    private String status;

    private Date createTime;

    private Date lastUpdateTime;

    private Date lastLoginTime;

    private String isContact;
    @NotBlank(message = "用户姓名")
    private String name;

}
