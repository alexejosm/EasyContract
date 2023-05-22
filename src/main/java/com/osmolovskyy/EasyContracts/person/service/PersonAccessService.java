package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.commons.util.ReadOnlyTransaction;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.persistence.PersonRepository;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.osmolovskyy.EasyContracts.commons.exception.ExceptionFactory.createPersonNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonAccessService {

    public static final String PERSON_ID = "[person-id: {}]";
    private final PersonRepository repository;

    @Transactional
    public void upsertPerson(final PersonBo person) {
        log.debug("insert or update person" + PERSON_ID, person.getId());

        final PersonEntity entity = repository.findByPersonIdForUpdate(person.getId()).orElseGet(PersonEntity::new);
        PersonEntityUtil.mapToPersonEntity(person, entity);

        repository.save(entity);
    }

    @ReadOnlyTransaction
    public Optional<PersonBo> loadPerson(final Long personId) {
        log.debug("load person " + PERSON_ID, personId);

        return repository.findByPersonId(personId).map(PersonEntityUtil::convertToPersonBo);
    }

    @ReadOnlyTransaction
    public PersonBo loadRequiredPerson(final Long personId) {
        log.debug("load person " + PERSON_ID, personId);
        return repository.findByPersonId(personId).map(PersonEntityUtil::convertToPersonBo).orElseThrow(() -> createPersonNotFoundException(personId));
    }
}