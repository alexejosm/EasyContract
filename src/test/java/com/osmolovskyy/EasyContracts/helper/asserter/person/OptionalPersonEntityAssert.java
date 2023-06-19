package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.helper.asserter.OptionalAssert;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import lombok.NoArgsConstructor;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OptionalPersonEntityAssert {

    public static OptionalAssert<PersonEntityAssert, PersonEntity> assertThat(final Optional<PersonEntity> actualAsOptional) {
        return new OptionalAssert<>(actualAsOptional, PersonEntityAssert::assertThat);
    }
}