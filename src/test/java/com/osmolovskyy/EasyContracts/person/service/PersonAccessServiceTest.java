package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.helper.asserter.person.PersonBoAssert;
import com.osmolovskyy.EasyContracts.person.exceptions.PersonNotFoundException;
import com.osmolovskyy.EasyContracts.person.persistence.PersonRepository;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.osmolovskyy.EasyContracts.helper.TestHelper.createPersonEntity;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    void upsertPerson_personDoesNotExists_insertNewPerson() {
    }

    @Test
    void loadPerson() {
    }

    @Test
    void loadRequiredPerson_successful() {
        var expected = createPersonEntity(PERSON_ID);
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.of(expected));

        var actual = service.loadRequiredPerson(PERSON_ID);

        PersonBoAssert.assertThat(actual).isEqualTo(expected.get());
    }
    @Test
    void loadRequiredPerson_throwsException() {
        when(repository.findByPersonId(PERSON_ID)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> service.loadRequiredPersonByPersonId(PERSON_ID)).isInstanceOf(PersonNotFoundException.class).hasMessageContaining("")
    }
}