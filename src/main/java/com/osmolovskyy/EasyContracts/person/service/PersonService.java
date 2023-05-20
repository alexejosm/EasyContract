package com.osmolovskyy.EasyContracts.person.service;

import com.osmolovskyy.EasyContracts.commons.util.ReadOnlyTransaction;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonAccessService personAccessService;

    @ReadOnlyTransaction
    public List<PersonBo> loadAll() {
        log.info("Not implemented yet");
    }

    public Optional<PersonBo> loadPerson(final long personId) {

    }

    public PersonBo loadRequiredPerson(final long personId) {

    }

    @ReadOnlyTransaction
    public List<PersonBo> loadAll() {
        log.info("Not implemented yet");
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
        presonAccessService.upsert(person);
    }
}
