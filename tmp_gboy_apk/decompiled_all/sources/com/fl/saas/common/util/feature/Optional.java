package com.fl.saas.common.util.feature;

import AmA8tU.A2egSU;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    static {
        VGGLHtI();
    }

    private Optional() {
        this.value = null;
    }

    private static /* synthetic */ void VGGLHtI() {
        char[] charArray = "×ÛÙ\u009aÓÕÙÑ\u009aÖÛÍ\u009aÇÜÑØØ\u009aþÚÝöÆÝÐÓÑ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 180);
        }
        String str = new String(charArray);
        char[] charArray2 = "×ØÝÚÝÀ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 180);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    public static <T> Optional<T> of(T t) {
        return new Optional<>(t);
    }

    public static <T> Optional<T> ofNullable(T t) {
        return t == null ? empty() : of(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Optional) {
            return Objects.equals(this.value, ((Optional) obj).value);
        }
        return false;
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return (isPresent() && !predicate.test(this.value)) ? empty() : this;
    }

    public <U> Optional<U> flatMap(A2egSU a2egSU) {
        Objects.requireNonNull(a2egSU);
        if (!isPresent()) {
            return empty();
        }
        Optional<U> optional = (Optional) a2egSU.apply(this.value);
        Objects.requireNonNull(optional);
        return optional;
    }

    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    public void ifEmpty(Runnable runnable) {
        if (this.value == null) {
            runnable.run();
        }
    }

    public void ifPresent(Consumer<? super T> consumer) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> consumer, Runnable runnable) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        } else {
            runnable.run();
        }
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public <U> Optional<U> map(A2egSU a2egSU) {
        Objects.requireNonNull(a2egSU);
        return !isPresent() ? empty() : ofNullable(a2egSU.apply(this.value));
    }

    public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) {
            return this;
        }
        Optional<? extends T> optional = supplier.get();
        Objects.requireNonNull(optional);
        return optional;
    }

    public T orElse(T t) {
        T t2 = this.value;
        return t2 != null ? t2 : t;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        T t = this.value;
        return t != null ? t : supplier.get();
    }

    public T orElseThrow() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public String toString() {
        T t = this.value;
        return t != null ? String.format("Optional[%s]", t) : "Optional.empty";
    }

    private Optional(T t) {
        Objects.requireNonNull(t);
        this.value = t;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw supplier.get();
    }
}
