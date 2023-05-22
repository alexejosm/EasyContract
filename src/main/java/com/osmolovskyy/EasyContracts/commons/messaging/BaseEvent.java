package com.osmolovskyy.EasyContracts.commons.messaging;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.MappedSuperclass;

import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.TYPE_JSONB;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@MappedSuperclass
@TypeDef(name = TYPE_JSONB, typeClass = JsonBinaryType.class)
@NoArgsConstructor(access = PROTECTED)
public abstract class BaseEvent {
}