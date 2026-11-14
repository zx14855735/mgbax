package COJEAR;

import android.view.View;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EY4UKY {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Field f1717A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Field f1718A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Field f1719A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final boolean f1720ADYaiT;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f1717A2egSU = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f1718A4TApA = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f1719A5SV6n = declaredField3;
            declaredField3.setAccessible(true);
            f1720ADYaiT = true;
        } catch (ReflectiveOperationException e) {
            e.getMessage();
        }
    }
}
