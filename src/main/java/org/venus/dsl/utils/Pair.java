package org.venus.dsl.utils;

import lombok.Getter;

@Getter
public class Pair<F0, F1> {

    private final F0 f0;

    private final F1 f1;

    public Pair(F0 f0, F1 f1) {
        this.f0 = f0;
        this.f1 = f1;
    }

    public static <F0, F1> Pair<F0, F1> from(F0 f0, F1 f1) {
        return new Pair<>(f0, f1);
    }

}
