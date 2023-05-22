package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.person.persistence.PersonRepository;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonAccessServiceTest {

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
    void loadRequiredPerson() {
    }
}