package KfamK9;

import COJEAR.AZOQYO;
import Cd8JRx.ADYaiT;
import com.fl.saas.common.util.feature.Predicate;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract /* synthetic */ class A4TApA {
    public static Predicate A2egSU(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new A2egSU(predicate, predicate2, 0);
    }

    public static Predicate A4TApA(Predicate predicate) {
        return new ADYaiT(4, predicate);
    }

    public static Predicate A5SV6n(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new A2egSU(predicate, predicate2, 1);
    }

    public static /* synthetic */ boolean ADYaiT(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    public static /* synthetic */ boolean AMqCpz(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean ARc23Z(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }

    public static Predicate ASJ6gh(Object obj) {
        return obj == null ? new AZOQYO(10) : new ADYaiT(3, obj);
    }

    public static /* synthetic */ boolean AYUAbz(Object obj) {
        return obj == null;
    }
}
