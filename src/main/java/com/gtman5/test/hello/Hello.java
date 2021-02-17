package com.gtman5.test.hello;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Hello {
    private final String name;
    private final int amount;
}
