package com.fl.saas.common.util;

import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Check {
    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T, U> T checkNull(U u, AmA8tU.A2egSU a2egSU) {
        if (u != null) {
            return (T) a2egSU.apply(u);
        }
        return null;
    }

    public static <T> void clearNullList(List<? extends T> list) {
        if (isValidAdList(list)) {
            list.clear();
        }
    }

    public static <T, S> Optional<S> filterNullFindFirst(List<? extends T> list, AmA8tU.A2egSU a2egSU) {
        return Optional.ofNullable(list).map(new com.fl.saas.base.manager.loader.ADYaiT(4)).map(a2egSU);
    }

    public static <T> void filterNullList(List<? extends T> list, Consumer<T> consumer) {
        if (!isValidAdList(list) || consumer == null) {
            return;
        }
        for (T t : list) {
            if (t != null) {
                consumer.accept(t);
            }
        }
    }

    public static <T> T findFirstNonNull(List<T> list) {
        if (list == null) {
            return null;
        }
        for (T t : list) {
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public static <T> Optional<T> getRefValue(WeakReference<T> weakReference) {
        return Optional.ofNullable(weakReference).map(new com.fl.saas.base.manager.loader.ADYaiT(5));
    }

    public static <T> void ifPresentOrElse(T t, Consumer<? super T> consumer, Runnable runnable) {
        if (t != null) {
            consumer.accept(t);
        } else {
            runnable.run();
        }
    }

    public static boolean isValidAdList(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static <T> T[] listToArray(List<T> list) {
        if (list == null || list.isEmpty()) {
            return (T[]) new Object[0];
        }
        T[] tArr = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tArr[i] = list.get(i);
        }
        return tArr;
    }

    public static <T> T obtainNotNull(T t, Supplier<T> supplier) {
        return t != null ? t : supplier.get();
    }

    public static <T> void checkNull(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }

    public static <T> void filterNullFindFirst(List<T> list, Consumer<? super T> consumer) {
        Optional.ofNullable(list).map(new com.fl.saas.base.manager.loader.ADYaiT(4)).ifPresent(consumer);
    }
}
