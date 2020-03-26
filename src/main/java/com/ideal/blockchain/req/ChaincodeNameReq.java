/*
 *  Copyright 2018, Mindtree Ltd. - All Rights Reserved.
 *
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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author SWATI RAJ
 *
 */
public class ChaincodeNameReq extends BaseReq {

	@NotEmpty(message = "please enter peerWithOrg in request body")
	private String peerWithOrg;

	@NotBlank(message = "please enter channelName in request body")
	private String channelName;

	@NotBlank(message = "please enter ChainCodeName in request body")
	private String chainCodeName;

	@NotBlank(message = "please enter chainCodeVersion in request body")
	private String chainCodeVersion;

    public String getChainCodeName() {
        return chainCodeName;
    }

    public void setChainCodeName(String chainCodeName) {
        this.chainCodeName = chainCodeName;
    }

	public String getPeerWithOrg() {
		return peerWithOrg;
	}

	public void setPeerWithOrg(String peerWithOrg) {
		this.peerWithOrg = peerWithOrg;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChainCodeVersion() {
		return chainCodeVersion;
	}

	public void setChainCodeVersion(String chainCodeVersion) {
		this.chainCodeVersion = chainCodeVersion;
	}

}
