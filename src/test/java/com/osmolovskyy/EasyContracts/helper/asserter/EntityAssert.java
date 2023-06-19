package com.osmolovskyy.EasyContracts.helper.asserter;

import com.osmolovskyy.EasyContracts.commons.persistence.BaseEntity;

import java.math.BigDecimal;

import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_CREATED;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_ID;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_MODIFIED;
import static org.assertj.core.util.BigDecimalComparator.BIG_DECIMAL_COMPARATOR;

public class EntityAssert<ENTITY extends BaseEntity, ASSERTER extends EntityAssert<ENTITY, ?>>
        extends EasyContractAssert<EntityAssert<ENTITY, ?>, ENTITY> {

    protected EntityAssert(final ENTITY actual) {
        super(actual, EntityAssert.class);
    }

    public ASSERTER isEqualTo(final ENTITY expected) {
        hasNoNullFieldsOrProperties()
                .usingRecursiveComparison()
                .ignoringFields(FIELD_ID, FIELD_CREATED, FIELD_MODIFIED)
                .withComparatorForType(BIG_DECIMAL_COMPARATOR, BigDecimal.class)
                .isEqualTo(expected);

        ASSERTER asserter = (ASSERTER) this;
        return asserter;
    }
}