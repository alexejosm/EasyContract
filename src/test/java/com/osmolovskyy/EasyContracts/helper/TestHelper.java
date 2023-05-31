package com.osmolovskyy.EasyContracts.helper;

import com.osmolovskyy.EasyContracts.person.persistence.entity.PersonEntity;
import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.BigDecimalRangeRandomizer;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;

import java.math.BigDecimal;

import static java.nio.charset.StandardCharsets.UTF_8;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class TestHelper {

    static {
        final EasyRandomParameters config = new EasyRandomParameters();
        config.seed(123L);
        config.objectPoolSize(100);
        config.randomizationDepth(10);
        config.charset(UTF_8);
        config.stringLengthRange(5, 20);
        config.collectionSizeRange(3, 3);
        config.scanClasspathForConcreteTypes(true);
        config.overrideDefaultInitialization(true);
        config.ignoreRandomizationErrors(true);
        config.randomize(Integer.class, new IntegerRangeRandomizer(100, 100_000_00));
        config.randomize(Long.class, new LongRangeRandomizer(100L, 100_000_00L));
        config.randomize(BigDecimal.class, new BigDecimalRangeRandomizer(1.0, 100_000_00.0, 0, 2));

        EASY_RANDOM = new EasyRandom(config);
    }

    public static final EasyRandom EASY_RANDOM;

    public static <T> T randomize(final Class<T> expectedType) {
        return EASY_RANDOM.nextObject(expectedType);
    }

    public static PersonEntity createPersonEntity() {
        return randomize(PersonEntity.class);
    }


    public static PersonEntity createPersonEntity(final String personID) {
        PersonEntity entity = createPersonEntity();
        entity.setPersonId(personID);
        return entity;
    }
}