package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.dto.PersonRequestDto;
import com.osmolovskyy.EasyContracts.person.persistance.entity.PersonEntity;
import com.osmolovskyy.EasyContracts.helper.asserter.EasyContractAssert;
import org.assertj.core.api.Assertions;

public class PersonBoAssert extends EasyContractAssert<PersonBoAssert, PersonBo> {

    PersonBoAssert(final PersonBo actual) {
        super(actual, PersonBoAssert.class);
    }

    public static PersonBoAssert assertThat(final PersonBo actual) {
        return new PersonBoAssert(actual);
    }

    public PersonBoAssert isEqualTo(PersonEntity expected) {
        hasNoNullFieldsOrProperties().usingRecursiveComparison().isEqualTo(expected);
        return this;
    }

    public PersonBoAssert isEqualTo(PersonRequestDto expected) {
        Assertions.assertThat(actual.getId()).isEqualTo(expected.getPersonId());
        Assertions.assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
        Assertions.assertThat(actual.getLastName()).isEqualTo(expected.getLastName());

        return this;
    }


}
