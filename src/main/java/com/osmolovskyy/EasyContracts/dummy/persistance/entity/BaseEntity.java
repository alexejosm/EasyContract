package com.osmolovskyy.EasyContracts.dummy.persistance.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_CREATED;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_ID;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_MODIFIED;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.TYPE_JSONB;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@MappedSuperclass
@TypeDef(name = TYPE_JSONB, typeClass = JsonBinaryType.class)
@NoArgsConstructor(access = PROTECTED)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = FIELD_ID)
    private Long id;

    @Generated(GenerationTime.INSERT)
    @Column(name = FIELD_CREATED, insertable = false, updatable = false)
    private OffsetDateTime created;

    @UpdateTimestamp
    @Column(name = FIELD_MODIFIED, insertable = false)
    private OffsetDateTime modified;
}