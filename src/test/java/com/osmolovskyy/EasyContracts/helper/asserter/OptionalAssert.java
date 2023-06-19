package com.osmolovskyy.EasyContracts.helper.asserter;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class OptionalAssert<ASSERT, ACTUAL> {

    private final Optional<ACTUAL> actual;

    private final Function<ACTUAL, ASSERT> assertConverter;

    public void isEmpty() {
        Assertions.assertThat(actual).isNotNull().isEmpty();
    }

    public ASSERT isPresent() {
        Assertions.assertThat(actual).isNotNull().isPresent();

        return assertConverter.apply(actual.get());
    }
}