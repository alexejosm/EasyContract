package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.helper.asserter.person.OptionalPersonBoAssert;
import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonBoAssert;
import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonEntityAssert;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.exceptions.PersonNotFoundException;
import com.osmolovskyy.EasyContracts.person.persistence.PersonRepository;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntityUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.osmolovskyy.EasyContracts.helper.TestHelper.createPersonBo;
import static com.osmolovskyy.EasyContracts.helper.TestHelper.createPersonEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonAccessServiceTest {

    final String PERSON_ID = "ID01";
    @InjectMocks
    private PersonAccessService service;
    @Mock
    private PersonRepository repository;
    @Captor
    private ArgumentCaptor<PersonEntity> personEntityCaptor;

    //================================================== loadAllPersons

    @Test
    void loadAll_successful() {
        // Arrange
        List<PersonEntity> expected = Arrays.asList(
                createPersonEntity("1"),
                createPersonEntity("2"),
                createPersonEntity("3")
        );

        when(repository.findAll()).thenReturn(expected);

        Stream<PersonBo> actual = service.loadAllPersons();

        assertThat(actual).hasSize(3)
                .extracting(PersonBo::getId)
                .containsExactly(expected.get(0).getPersonId(),
                        expected.get(1).getPersonId(),
                        expected.get(2).getPersonId());
    }

    @Test
    void loadAll_nothingFound() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        Stream<PersonBo> actual = service.loadAllPersons();

        assertThat(actual).isEmpty();
    }

    //================================================== upsertPerson()

    @Test
    void upsertPerson_personDoesNotExists_insertNewPerson() {
        PersonBo expected = createPersonBo(PERSON_ID);
        when(repository.findByPersonIdForUpdate(PERSON_ID)).thenReturn(Optional.empty());

        service.upsert(expected);

        verify(repository, times(1)).findByPersonIdForUpdate(PERSON_ID);
        verify(repository, times(1)).save(personEntityCaptor.capture());
        PersonBoAssert.assertThat(expected).isEqualTo(personEntityCaptor.getValue());
    }

    @Test
    void upsertPerson_personExists_updatePerson() {
        PersonBo expected = createPersonBo(PERSON_ID);
        PersonEntity entity = new PersonEntity();
        PersonEntityUtil.mapToPersonEntity(expected, entity);

        when(repository.findByPersonIdForUpdate(PERSON_ID)).thenReturn(Optional.of(entity));

        service.upsert(expected);

        verify(repository, times(1)).findByPersonIdForUpdate(PERSON_ID);
        verify(repository, times(1)).save(personEntityCaptor.capture());

        PersonEntity actual = personEntityCaptor.getValue();

        PersonEntityAssert.assertThat(actual).isEqualTo(expected);
    }

    //================================================== loadPerson()
    @Test
    void loadByPersonId_successful() {
        PersonEntity expected = createPersonEntity(PERSON_ID);
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.of(expected));

        Optional<PersonBo> actual = service.loadByPersonId(PERSON_ID);

        OptionalPersonBoAssert.assertThat(actual).isPresent().isEqualTo(expected);
    }

    @Test
    void loadByPersonId_personNotFound() {
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.empty());

        Optional<PersonBo> actual = service.loadByPersonId(PERSON_ID);

        OptionalPersonBoAssert.assertThat(actual).isEmpty();
    }

    //================================================== loadRequiredPerson
    @Test
    void loadRequiredPerson_successful() {
        var expected = createPersonEntity(PERSON_ID);
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.of(expected));

        var actual = service.loadRequired(PERSON_ID);

        PersonBoAssert.assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    void loadRequiredPerson_throwsException() {
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.loadRequired(PERSON_ID))
                .isInstanceOf(PersonNotFoundException.class);
    }

    //================================================== delete()
    @Test
    void delete_personNotFound() {
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.delete(PERSON_ID)).isInstanceOf(PersonNotFoundException.class);
        verify(repository, times(0)).delete(any());
    }
}