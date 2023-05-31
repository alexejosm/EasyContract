package com.osmolovskyy.EasyContracts.person.bo;

import com.osmolovskyy.EasyContracts.commons.bo.BaseBo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonBo implements BaseBo {

    private String id;
    private String firstName;
    private String lastName;
}