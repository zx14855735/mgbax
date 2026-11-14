package BV3sI0;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu extends AaHO0E {
    @Override // BV3sI0.AaHO0E
    public final Typeface EicXu4(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f1501AzWtSf, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1507B9tovu.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // BV3sI0.AaHO0E
    public final Method EwN40Z(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
