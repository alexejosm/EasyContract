package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.helper.asserter.EntityAssert;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;

public class PersonEntityAssert extends EntityAssert<PersonEntity, PersonEntityAssert> {
    PersonEntityAssert(final PersonEntity actual) {
        super(actual);
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