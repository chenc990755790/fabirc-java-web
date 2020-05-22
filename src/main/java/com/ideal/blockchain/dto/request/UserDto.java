/*
 *  Copyright 2018, Mindtree Ltd. - All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.ideal.blockchain.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author
 */
@Data
public class UserDto {

    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String passWord;
    @NotEmpty(message = "所属机构不能为空")
    private String peerWithOrg;

    private String collectionName;
}
