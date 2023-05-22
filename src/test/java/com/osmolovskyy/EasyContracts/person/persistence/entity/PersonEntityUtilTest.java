package com.osmolovskyy.EasyContracts.person.persistence.entity;

import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonBoAssert;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import org.junit.jupiter.api.Test;

import static com.osmolovskyy.EasyContracts.helper.TestHelper.createPersonEntity;

class PersonEntityUtilTest {

    @Test
    void convertToPersonBo() {
        PersonEntity expected = createPersonEntity();
        PersonBo actual = PersonEntityUtil.convertToPersonBo(expected);
        PersonBoAssert.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void mapToPersonEntity() {
    }
}