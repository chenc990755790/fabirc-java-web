package com.ideal.blockchain.entity.saas;

import com.ideal.blockchain.dto.request.UserDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@ApiModel(description = "AC_USER")
@Entity
@Table(name = "AC_USER")
public class UserInfo extends UserDto {

    private static final String OBJECT_TYPE_NAME = "userInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Id
    @Column(name="USER_ID")
    @NotBlank(message = "用户编号不能为空")
    private String userId;
    @NotBlank(message = "用户手机号码不能为空")
    private String mobile;
    @NotBlank(message = "登陆密码不能为空")
    @Column(name="LOGIN_PASSWORD")
    private String loginPassword;
    @NotBlank(message = "公司编号不能为空")
    @Column(name="COMPANY_ID")
    private String companyId;
    @Column(name="LOGIN_LAST_TIME")
    private Date loginLastTime;
    @Column(name="LOGIN_PASSWORD_ERROR_LAST_TIME")
    private Date loginPasswordErrorLastTime;
    @Column(name="LOGIN_PASSWORD_ERROR_TIMES")
    private Long loginPasswordErrorTimes;
    @Column(name="LOGIN_PASSWORD_UPDATE_TIME")
    private Date loginPasswordUpdateTime;
    @Column(name="STATUS")
    @NotBlank(message = "用户状态不能为空")
    private String status;
    @Column(name="CREATE_TIME")
    private Date createTime;
    @Column(name="LAST_UPDATE_TIME")
    private Date lastUpdateTime;
    @Column(name="LAST_LOGIN_TIME")
    private Date lastLoginTime;
    @Column(name="IS_CONTACT")
    private String isContact;
    @Column(name="NAME")
    @NotBlank(message = "用户姓名")
    private String name;

}
