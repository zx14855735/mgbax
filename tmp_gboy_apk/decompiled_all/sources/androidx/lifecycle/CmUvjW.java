package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CmUvjW extends CrfGsy {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static CmUvjW f9035AmA8tU;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Application f9036AlLFFp;

    public CmUvjW(Application application) {
        this.f9036AlLFFp = application;
    }

    public final CikNvS A2egSU(Class cls, Application application) {
        if (!A2egSU.class.isAssignableFrom(cls)) {
            return super.A4TApA(cls);
        }
        try {
            CikNvS cikNvS = (CikNvS) cls.getConstructor(Application.class).newInstance(application);
            RXb0Sz.ARc23Z.ADYaiT(cikNvS, "{\n                try {\n…          }\n            }");
            return cikNvS;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }

    @Override // androidx.lifecycle.CrfGsy, androidx.lifecycle.CqNSpT
    public final CikNvS A4TApA(Class cls) {
        Application application = this.f9036AlLFFp;
        if (application != null) {
            return A2egSU(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.CrfGsy, androidx.lifecycle.CqNSpT
    public final CikNvS AzWtSf(Class cls, D9tr6l.ADYaiT aDYaiT) {
        if (this.f9036AlLFFp != null) {
            return A4TApA(cls);
        }
        Application application = (Application) aDYaiT.f2052A2egSU.get(CkXcdM.f9033A2egSU);
        if (application != null) {
            return A2egSU(cls, application);
        }
        if (A2egSU.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.A4TApA(cls);
    }

    public CmUvjW() {
        this(null);
    }
}
