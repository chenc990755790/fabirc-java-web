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
package com.ideal.blockchain.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author
 */
@Data
public class QueryArgsReq extends ChaincodeNameReq {

    @NotBlank(message = "please enter functionName in request body")
    private String function;

    private String[] args;

    public QueryArgsReq() {
    }

    public QueryArgsReq(String peerWithOrg,
                        String channelName,
                        String chainCodeName,
                        String chainCodeVersion) {
        super(peerWithOrg, channelName, chainCodeName, chainCodeVersion);

    }

}
