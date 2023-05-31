package com.osmolovskyy.EasyContracts.person.persistence;

import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM PersonEntity p WHERE p.personId = ?1")
    Optional<PersonEntity> findByPersonIdForUpdate(String personId);

    Optional<PersonEntity> findByPersonId(String personId);
}