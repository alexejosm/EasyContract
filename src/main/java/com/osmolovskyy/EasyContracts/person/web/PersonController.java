package com.osmolovskyy.EasyContracts.person.web;

import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.dto.PersonDto;
import com.osmolovskyy.EasyContracts.person.dto.PersonRequestDto;
import com.osmolovskyy.EasyContracts.person.dto.converter.PersonDtoConverter;
import com.osmolovskyy.EasyContracts.person.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.osmolovskyy.EasyContracts.commons.util.EasyContractUri.API_V1_PERSON;
import static com.osmolovskyy.EasyContracts.commons.util.EasyContractUri.API_V1_PERSON_WITH_ID;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    //======================== GET ALL ==========================

    @GetMapping(API_V1_PERSON)
    public List<PersonDto> loadAllPersons() {
        return service.loadAll()
                .map(PersonDtoConverter::toPersonDto)
                .collect(Collectors.toList());
    }

    //======================== GET BY ID ==========================

    @GetMapping(API_V1_PERSON_WITH_ID)
    public PersonDto getPersonByPersonId(@Valid @PathVariable String personId) {
        var person = service.loadRequiredPerson(personId);
        return PersonDtoConverter.toPersonDto(person);
    }

    //======================== INSERT ==========================

    @PostMapping(API_V1_PERSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createNewPerson(@Valid @RequestBody PersonRequestDto person) {
        final PersonBo personBo = PersonDtoConverter.toPersonBo(person);
        service.create(personBo);
    }

    //======================== UPDATE ==========================
    //======================== DELETE ==========================
}