package AaHO0E;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EPdU4G {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Method f765A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Method f766A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Method f767A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final boolean f768ADYaiT;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f765A2egSU = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f766A4TApA = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f767A5SV6n = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f768ADYaiT = true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
