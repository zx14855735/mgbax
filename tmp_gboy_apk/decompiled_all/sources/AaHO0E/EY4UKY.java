package AaHO0E;

import android.widget.AbsListView;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EY4UKY {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Field f770A2egSU;

    static {
        Field field = null;
        try {
            field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        f770A2egSU = field;
    }
}
