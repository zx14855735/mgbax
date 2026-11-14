package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class Cd8JRx {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final List f9028A2egSU = RD2OKB.AaHO0E.AMqCpz(Application.class, COJEAR.class);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final List f9029A4TApA = RD2OKB.AZkASS.A5SV6n(COJEAR.class);

    static {
        pYAGy();
    }

    public static final Constructor A2egSU(List list, Class cls) {
        RXb0Sz.ARc23Z.AMqCpz(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        RXb0Sz.ARc23Z.ADYaiT(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            RXb0Sz.ARc23Z.ADYaiT(parameterTypes, "constructor.parameterTypes");
            int length = parameterTypes.length;
            List arrayList = length != 0 ? length != 1 ? new ArrayList(new RD2OKB.AMqCpz(parameterTypes, false)) : RD2OKB.AZkASS.A5SV6n(parameterTypes[0]) : RD2OKB.B9tovu.f7846AcNBzu;
            if (list.equals(arrayList)) {
                return constructor;
            }
            if (list.size() == arrayList.size() && arrayList.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final CikNvS A4TApA(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (CikNvS) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }

    private static /* synthetic */ void pYAGy() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
