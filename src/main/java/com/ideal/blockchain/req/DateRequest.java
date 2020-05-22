package com.ideal.blockchain.req;

import lombok.Data;

@Data
public class DateRequest extends FabricPage {

    private String startDate;

    private String endDate;
}
