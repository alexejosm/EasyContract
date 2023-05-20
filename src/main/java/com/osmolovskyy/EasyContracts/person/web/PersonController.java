package com.osmolovskyy.EasyContracts.person.web;

import com.osmolovskyy.EasyContracts.commons.util.EasyContractUri;
import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.dto.PersonRequestDto;
import com.osmolovskyy.EasyContracts.person.dto.converter.PersonDtoConverter;
import com.osmolovskyy.EasyContracts.person.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.osmolovskyy.EasyContracts.commons.util.EasyContractUri.API_V1_PERSON;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping(API_V1_PERSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createNewPerson(@Valid @RequestBody PersonRequestDto person) {
        final PersonBo personBo = PersonDtoConverter.toPersonBo(person);
        service.create(personBo);
    }

}
