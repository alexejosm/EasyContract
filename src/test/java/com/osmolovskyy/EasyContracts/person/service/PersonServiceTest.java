package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.helper.asserter.person.OptionalPersonBoAssert;
import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonBoAssert;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.exceptions.PersonNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.osmolovskyy.EasyContracts.helper.TestHelper.createPersonBo;
import static com.osmolovskyy.EasyContracts.helper.asserter.TestConstants.PERSON_ID_01;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService service;

    @Mock
    private PersonAccessService accessService;

    @Test
    void loadAll_successful() {
        PersonBo person1 = createPersonBo("ID01");
        PersonBo person2 = createPersonBo("ID02");
        Stream<PersonBo> stream = Stream.of(person1, person2);
        when(accessService.loadAllPersons()).thenReturn(stream);

        List<PersonBo> actual = service.loadAll();

        assertThat(actual).hasSize(2);
    }

    @Test
    void loadAll_nothingFound_emptyList() {
        when(accessService.loadAllPersons()).thenReturn(Stream.empty());

        var actual = service.loadAll();

        assertThat(actual).isEmpty();
    }

    //==================================================
    @Test
    void load_isPresent() {
        Optional<PersonBo> expected = Optional.of(createPersonBo(PERSON_ID_01));
        when(accessService.loadByPersonId(PERSON_ID_01)).thenReturn(expected);

        var actual = service.load(PERSON_ID_01);

        OptionalPersonBoAssert.assertThat(actual).isPresent();
    }

    @Test
    void load_isEmpty() {
        Optional<PersonBo> expected = Optional.empty();
        when(accessService.loadByPersonId(PERSON_ID_01)).thenReturn(expected);

        var actual = service.load(PERSON_ID_01);

        OptionalPersonBoAssert.assertThat(actual).isEmpty();
    }

    @Test
    void loadRequired_successful() {
        PersonBo expected = createPersonBo(PERSON_ID_01);
        when(accessService.loadRequired(PERSON_ID_01)).thenReturn(expected);

        var actual = service.loadRequired(PERSON_ID_01);

        PersonBoAssert.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void loadRequiredPerson_throwsException() {
        when(accessService.loadRequired(PERSON_ID_01)).thenThrow(PersonNotFoundException.class);

        Assertions.assertThatThrownBy(() -> service.loadRequired(PERSON_ID_01))
                .isInstanceOf(PersonNotFoundException.class);
    }

    @Test
    void verifyPersonExist() {
        when(accessService.loadRequired(PERSON_ID_01)).thenReturn(createPersonBo(PERSON_ID_01));

        service.verifyPersonExist(PERSON_ID_01);

        verify(accessService, times(1)).loadRequired(PERSON_ID_01);
    }

    @Test
    void verifyPersonExist_throwsException() {
        when(accessService.loadRequired(PERSON_ID_01)).thenThrow(PersonNotFoundException.class);

        assertThatThrownBy(() -> service.verifyPersonExist(PERSON_ID_01)).isInstanceOf(PersonNotFoundException.class);

        verify(accessService, times(1)).loadRequired(PERSON_ID_01);
    }

    @Test
    void create() {
        var expected = createPersonBo(PERSON_ID_01);
        service.create(expected);
        verify(accessService).upsert(argThat(person -> person.getId().equals(PERSON_ID_01)));
    }

    @Test
    void update() {
        var expected = createPersonBo(PERSON_ID_01);

        service.update(expected);

        verify(accessService).upsert(argThat(personBo -> personBo.getId().equals(PERSON_ID_01)));
    }

    @Test
    void delete() {
    }
}