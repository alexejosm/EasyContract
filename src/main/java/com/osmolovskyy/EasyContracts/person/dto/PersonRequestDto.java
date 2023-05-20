package com.osmolovskyy.EasyContracts.person.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonRequestDto implements BaseDto {

    @NotNull
    private long personId;

    @NotEmpty
    @Size(max = 40)
    private String firstName;

    @NotEmpty
    @Size(max = 40)
    private String lastName;
}
