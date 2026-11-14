package com.fl.saas.common.util.feature;

@FunctionalInterface
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface Predicate<T> {
    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t);
}
