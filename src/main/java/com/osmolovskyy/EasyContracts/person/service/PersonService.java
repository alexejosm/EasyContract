package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.commons.util.ReadOnlyTransaction;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;


@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonAccessService personAccessService;

    @ReadOnlyTransaction
    public Stream<PersonBo> loadAll() {
        return personAccessService.loadAllPersons();
    }

    public Optional<PersonBo> loadPersonByPersonId(final String personId) {
        return personAccessService.loadByPersonId(personId);
    }

    public PersonBo loadRequiredPerson(final String personId) {
        return personAccessService.loadRequiredPersonByPersonId(personId);
    }

    public void verifyPersonExist(final String personId) {
        loadPersonByPersonId(personId);
    }

    @Transactional
    public void create(final PersonBo person) {
        log.debug("create new person");
        // set something, if needed
        upsert(person);
    }

    @Transactional
    public void update(final PersonBo person) {
        log.info("Not implemented yet");
    }

    @Transactional
    public void delete(String personId) {
        log.info("Not implemented yet");
    }

    private void upsert(PersonBo person) {

        // enhance
        // post validate
        personAccessService.upsertPerson(person);
    }
}