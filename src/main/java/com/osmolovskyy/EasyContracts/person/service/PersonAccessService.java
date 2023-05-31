package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.commons.util.ReadOnlyTransaction;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.persistence.PersonRepository;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.osmolovskyy.EasyContracts.commons.exception.ExceptionFactory.createPersonNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonAccessService {

    public static final String ID_TEMPLATE = "[person-id: {}]";
    private final PersonRepository repository;

    //================================================== GET ALL
    public Stream<PersonBo> loadAllPersons() {
        log.debug("load all persons ");
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(PersonEntityUtil::convertToPersonBo);
    }

    @ReadOnlyTransaction
    public Optional<PersonBo> loadByPersonId(final String personId) {
        log.debug("load person " + ID_TEMPLATE, personId);
        return repository.findByPersonId(personId)
                .map(PersonEntityUtil::convertToPersonBo);
    }

    @ReadOnlyTransaction
    public PersonBo loadRequiredPersonByPersonId(final String personId) {
        log.debug("load person required " + ID_TEMPLATE, personId);
        return repository.findByPersonId(personId)
                .map(PersonEntityUtil::convertToPersonBo)
                .orElseThrow(() -> createPersonNotFoundException(personId));
    }

    @Transactional
    public void upsertPerson(final PersonBo person) {
        log.debug("insert or update person" + ID_TEMPLATE, person.getId());

        final PersonEntity entity = repository.findByPersonIdForUpdate(person.getId()).orElseGet(PersonEntity::new);
        PersonEntityUtil.mapToPersonEntity(person, entity);

        repository.save(entity);
    }

    @ReadOnlyTransaction
    public Optional<PersonBo> loadPerson(final String personId) {
        log.debug("load person " + ID_TEMPLATE, personId);

        return repository.findByPersonId(personId)
                .map(PersonEntityUtil::convertToPersonBo);
    }

    @ReadOnlyTransaction
    public PersonBo loadRequiredPerson(final String personId) {
        log.debug("load person " + ID_TEMPLATE, personId);
        return repository.findByPersonId(personId).map(PersonEntityUtil::convertToPersonBo).orElseThrow(() -> createPersonNotFoundException(personId));
    }

    private PersonEntity loadRequiredPersonEntity(final String id) {
        log.debug("load person " + ID_TEMPLATE, id);
        return repository.findByPersonId(id).orElseThrow(() -> createPersonNotFoundException(id));
    }
}