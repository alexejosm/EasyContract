package com.osmolovskyy.EasyContracts.commons.exception;


import com.osmolovskyy.EasyContracts.person.exceptions.PersonNotFoundException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.osmolovskyy.EasyContracts.commons.web.ResponseErrorConstants.PERSON_NOT_FOUND;
import static lombok.AccessLevel.PRIVATE;

@Slf4j
@NoArgsConstructor(access = PRIVATE)
public class ExceptionFactory {
    private static final String ID = "[id: {}]";

    public static PersonNotFoundException createPersonNotFoundException(final String personId) {
        log.info(PERSON_NOT_FOUND + ID, personId);

        return new PersonNotFoundException();
    }
}