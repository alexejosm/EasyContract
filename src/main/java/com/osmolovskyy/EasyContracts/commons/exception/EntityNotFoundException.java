package com.osmolovskyy.EasyContracts.commons.exception;

public class EntityNotFoundException extends EasyContractException {

    private static final long serialVersionUID = -194929193847329253L;

    public EntityNotFoundException(final String message) {
        super(message);
    }
}
