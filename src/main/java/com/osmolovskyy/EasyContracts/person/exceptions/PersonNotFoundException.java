package com.osmolovskyy.EasyContracts.person.exceptions;


import com.osmolovskyy.EasyContracts.commons.exception.EntityNotFoundException;

import static com.osmolovskyy.EasyContracts.commons.web.ResponseErrorConstants.PERSON_NOT_FOUND;

public class PersonNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 83658374294973707L;

    public PersonNotFoundException() {
        super(PERSON_NOT_FOUND);
    }
}
