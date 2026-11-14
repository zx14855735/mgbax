package DdagTj;

import B25kr6.ADYaiT;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f2391A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ADYaiT f2392A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ADYaiT f2393A5SV6n;

    public A2egSU(ADYaiT aDYaiT, ADYaiT aDYaiT2, ADYaiT aDYaiT3) {
        this.f2391A2egSU = aDYaiT;
        this.f2392A4TApA = aDYaiT2;
        this.f2393A5SV6n = aDYaiT3;
    }

    private <T> int getType(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof A5SV6n) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t.getClass().getName().concat(" cannot be VersionedParcelled"));
    }

    public abstract A4TApA A2egSU();

    public final Class A4TApA(Class cls) {
        String name = cls.getName();
        ADYaiT aDYaiT = this.f2393A5SV6n;
        Class cls2 = (Class) aDYaiT.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        aDYaiT.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method A5SV6n(String str) {
        ADYaiT aDYaiT = this.f2391A2egSU;
        Method method = (Method) aDYaiT.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, A2egSU.class.getClassLoader()).getDeclaredMethod("read", A2egSU.class);
        aDYaiT.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method ADYaiT(Class cls) {
        String name = cls.getName();
        ADYaiT aDYaiT = this.f2392A4TApA;
        Method method = (Method) aDYaiT.get(name);
        if (method != null) {
            return method;
        }
        Class A4TApA2 = A4TApA(cls);
        System.currentTimeMillis();
        Method declaredMethod = A4TApA2.getDeclaredMethod("write", cls, A2egSU.class);
        aDYaiT.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean AMqCpz(int i);

    public final Parcelable ARc23Z(Parcelable parcelable, int i) {
        if (!AMqCpz(i)) {
            return parcelable;
        }
        return ((A4TApA) this).AMqCpz.readParcelable(A4TApA.class.getClassLoader());
    }

    public final A5SV6n ASJ6gh() {
        String readString = ((A4TApA) this).AMqCpz.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (A5SV6n) A5SV6n(readString).invoke(null, A2egSU());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void AYUAbz(int i);

    public final void AZOQYO(A5SV6n a5SV6n) {
        if (a5SV6n == null) {
            ((A4TApA) this).AMqCpz.writeString(null);
            return;
        }
        try {
            ((A4TApA) this).AMqCpz.writeString(A4TApA(a5SV6n.getClass()).getName());
            A4TApA A2egSU2 = A2egSU();
            try {
                ADYaiT(a5SV6n.getClass()).invoke(null, a5SV6n, A2egSU2);
                int i = A2egSU2.f2398AZOQYO;
                if (i >= 0) {
                    int i2 = A2egSU2.f2394ADYaiT.get(i);
                    Parcel parcel = A2egSU2.AMqCpz;
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(dataPosition - i2);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(a5SV6n.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
