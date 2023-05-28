package com.osmolovskyy.EasyContracts.commons.messaging;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor(access = PROTECTED)
public abstract class BaseEvent {
}