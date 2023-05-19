package com.osmolovskyy.EasyContracts;

import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Utils {
    public static final EasyRandom EASY_RANDOM = new EasyRandom();
}
