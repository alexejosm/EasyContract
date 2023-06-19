package com.osmolovskyy.EasyContracts.helper.asserter.person;

import com.osmolovskyy.EasyContracts.helper.asserter.OptionalAssert;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import lombok.NoArgsConstructor;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OptionalPersonBoAssert {

    public static OptionalAssert<PersonBoAssert, PersonBo> assertThat(final Optional<PersonBo> actualAsOptional) {
        return new OptionalAssert<>(actualAsOptional, PersonBoAssert::assertThat);
    }
}