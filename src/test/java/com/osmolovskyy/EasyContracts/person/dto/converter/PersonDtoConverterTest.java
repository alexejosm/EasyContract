package com.osmolovskyy.EasyContracts.person.dto.converter;

import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.dto.PersonDto;
import com.osmolovskyy.EasyContracts.person.dto.PersonRequestDto;
import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonBoAssert;
import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonDtoAssert;
import org.junit.jupiter.api.Test;

import static com.osmolovskyy.EasyContracts.Utils.EASY_RANDOM;

class PersonDtoConverterTest {

    @Test
    void toPersonDto() {
        PersonBo expected = EASY_RANDOM.nextObject(PersonBo.class);
        PersonDto actual = PersonDtoConverter.toPersonDto(expected);
        PersonDtoAssert.assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void toPersonBo() {
        PersonRequestDto expected = EASY_RANDOM.nextObject(PersonRequestDto.class);
        PersonBo actual = PersonDtoConverter.toPersonBo(expected);
        PersonBoAssert.assertThat(actual).isEqualTo(expected);
    }
}