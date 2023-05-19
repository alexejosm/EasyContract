package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.dummy.bo.PersonBo;
import com.osmolovskyy.EasyContracts.dummy.dto.PersonDto;
import com.osmolovskyy.EasyContracts.helper.asserter.EasyContractAssert;

public class PersonDtoAssert extends EasyContractAssert<PersonDtoAssert, PersonDto> {

    PersonDtoAssert(final PersonDto actual) {
        super(actual, PersonDtoAssert.class);
    }

    public static PersonDtoAssert assertThat(final PersonDto actual) {
        return new PersonDtoAssert(actual);
    }

    public PersonDtoAssert isEqualTo(final PersonBo expected) {
        isEqualRequired(actual.getFirstName(), expected.getFirstName());
        isEqualRequired(actual.getLastName(), expected.getLastName());
        isEqualRequired(actual.getId(), expected.getId());

        return this;
    }

}
