package com.osmolovskyy.EasyContracts.dummy.messaging;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@MappedSuperclass
@TypeDef(name=TYPE_JSONB, typeClass=JsonBinaryType.class)
@NoArgsConstructor(access = PROTECTED)
public abstract class BaseEvent {
}
