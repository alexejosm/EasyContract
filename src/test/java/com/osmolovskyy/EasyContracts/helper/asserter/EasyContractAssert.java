package com.osmolovskyy.EasyContracts.helper.asserter;

import org.assertj.core.api.AbstractObjectAssert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Collection;

import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Objects.nonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class EasyContractAssert<SELF extends AbstractObjectAssert<SELF, ACTUAL>, ACTUAL> extends AbstractObjectAssert<SELF, ACTUAL> {

    public EasyContractAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    /**
     * NUL = NULL returns true
     *
     * @param actual
     * @param expected
     */
    protected void isEqual(final Object actual, final Object expected) {
        if (nonNull(expected)) {
            assertThat(actual).isNotNull().isEqualTo(expected);
        } else {
            assertThat(actual).isNull();
        }
    }

    protected void isEqual(final BigDecimal actual, final BigDecimal expected) {
        if (nonNull(expected)) {
            assertThat(actual).isNotNull().isEqualByComparingTo(expected);
        } else {
            assertThat(actual).isNull();
        }
    }

    protected void isEqual(final Collection<?> actual, final Collection<?> expected) {
        if (expected.isEmpty()) {
            assertThat(actual).isEmpty();
        } else {
            assertThat(actual).isNotEmpty().isEqualTo(expected);
        }
    }

    protected void isEqualRequired(final Object actual, final Object expected) {
        assertThat(actual).isNotNull().as("actual: %s - expected: %s", actual, expected).isEqualTo(expected);
    }

    protected void isEqualRequired(final BigDecimal actual, final BigDecimal expected) {
        assertThat(actual).isNotNull().isEqualByComparingTo(expected);
    }

    protected void isEqualRequired(final OffsetDateTime actual, final OffsetDateTime expected) {
        assertThat(actual)
                .isNotNull()
                .as("actual: %s - expected: %s", actual, expected)
                .usingComparator(OffsetDateTime::compareTo)
                .isEqualTo(expected);
    }

    protected void isEqualRequired(final LocalDateTime actual, final LocalDateTime expected) {
        assertThat(actual)
                .isNotNull()
                .as("actual: %s - expected: %s", actual, expected)
                .usingComparator(LocalDateTime::compareTo)
                .isEqualTo(expected);
    }


    protected void isNearTo(final OffsetDateTime actual, final OffsetDateTime expected) {
        assertThat(actual).isNotNull()
                .as("actual: %s - expected: %s", actual, expected)
                .isCloseTo(expected, within(2, SECONDS));
    }

    protected void isNearTo(final LocalDateTime actual, final LocalDateTime expected) {
        assertThat(actual).isNotNull()
                .as("actual: %s - expected: %s", actual, expected)
                .isCloseTo(expected, within(2, SECONDS));
    }
}