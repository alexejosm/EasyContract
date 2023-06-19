package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.helper.asserter.EntitiesAssert;
import com.osmolovskyy.EasyContracts.helper.asserter.EntityAssert;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;

import java.util.List;

public class PersonEntitiesAssert extends EntitiesAssert<PersonEntity, PersonEntitiesAssert> {

    public PersonEntitiesAssert(final List<PersonEntity> actual) {
        super(actual);
    }

    public static PersonEntitiesAssert assertThat(final List<PersonEntity> actual) {
        return new PersonEntitiesAssert(actual);
    }

    @Override
    protected EntityAssert<PersonEntity, ?> createEntityAssert(final PersonEntity actual) {
        return PersonEntityAssert.assertThat(actual);
    }
}