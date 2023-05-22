package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.helper.asserter.EasyContractAssert;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;

public class PersonEntityAssert extends EasyContractAssert<PersonEntityAssert, PersonEntity> {
    PersonEntityAssert(final PersonEntity actual) {
        super(actual, PersonEntity.class);
    }

    public static PersonEntityAssert assertThat(final PersonEntity actual) {
        return new PersonEntityAssert(actual);
    }

    public PersonEntityAssert isEqualTo(final PersonBo expected) {
        isEqualRequired(actual.getPersonId(), expected.getId());
        isEqualRequired(actual.getFirstName(), expected.getFirstName());
        isEqualRequired(actual.getLastName(), expected.getLastName());

        return this;
    }
}