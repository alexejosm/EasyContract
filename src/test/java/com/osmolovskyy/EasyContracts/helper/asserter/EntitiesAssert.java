package com.osmolovskyy.EasyContracts.helper.asserter;

import com.osmolovskyy.EasyContracts.commons.persistence.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class EntitiesAssert<ENTITY extends BaseEntity, ASSERTER extends EntitiesAssert<ENTITY, ?>> {
    private final List<EntityAssert<ENTITY, ?>> entityAssertions = new ArrayList<>();
    protected final List<ENTITY> actual = new ArrayList<>();

    public EntitiesAssert(final List<ENTITY> actual) {
        this.actual.addAll(actual);
        actual.stream()
                .map(EntityAssert::new)
                .forEach(entityAssertions::add);
    }

    protected abstract EntityAssert<ENTITY, ?> createEntityAssert(ENTITY actual);


    public EntitiesAssert<ENTITY, ASSERTER> areEqualTo(final List<ENTITY> expected) {
        assertThatHasSameSize(expected);

        for (int i = 0; i < actual.size(); ++i) {
            createEntityAssert(actual.get(i)).isEqualTo(expected.get(i));
        }
        return this;
    }

    public void isEmpty() {
        assertThat(actual).isEmpty();
    }

    public void assertThatHasSameSize(final List<?> expected) {
        assertThat(actual).hasSize(expected.size());
    }
}