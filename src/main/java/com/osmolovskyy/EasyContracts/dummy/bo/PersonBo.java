package com.osmolovskyy.EasyContracts.dummy.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonBo implements BaseBo {

    private long id;
    private String firstName;
    private String lastName;

}
