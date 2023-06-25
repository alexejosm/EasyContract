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

    //================================================== GET ONE
    @ReadOnlyTransaction
    public Optional<PersonBo> loadByPersonId(final String personId) {
        log.debug("load person " + ID_TEMPLATE, personId);
        return repository.findByPersonId(personId)
                .map(PersonEntityUtil::convertToPersonBo);
    }

    @ReadOnlyTransaction
    public PersonBo loadRequired(final String personId) {
        log.debug("load person required " + ID_TEMPLATE, personId);
        return repository.findByPersonId(personId)
                .map(PersonEntityUtil::convertToPersonBo)
                .orElseThrow(() -> createPersonNotFoundException(personId));
    }

    //================================================== UPSERT
    @Transactional
    public void upsert(final PersonBo person) {
        log.debug("insert or update person" + ID_TEMPLATE, person.getId());

        final PersonEntity entity = repository.findByPersonIdForUpdate(person.getId()).orElseGet(PersonEntity::new);
        PersonEntityUtil.mapToPersonEntity(person, entity);

        repository.save(entity);
    }

    //================================================== DELETE
    @Transactional
    public void delete(final String personId) {
        log.debug("delete person " + ID_TEMPLATE, personId);
        repository.delete(loadPersonEntity(personId));
    }

    private PersonEntity loadPersonEntity(final String personId) {
        return repository.findByPersonId(personId).orElseThrow(() -> createPersonNotFoundException(personId));
    }
}