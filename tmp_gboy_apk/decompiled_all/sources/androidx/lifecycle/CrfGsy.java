package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CrfGsy implements CqNSpT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static CrfGsy f9038AcNBzu;

    @Override // androidx.lifecycle.CqNSpT
    public CikNvS A4TApA(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            RXb0Sz.ARc23Z.ADYaiT(newInstance, "{\n                modelC…wInstance()\n            }");
            return (CikNvS) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        }
    }

    @Override // androidx.lifecycle.CqNSpT
    public CikNvS AzWtSf(Class cls, D9tr6l.ADYaiT aDYaiT) {
        return A4TApA(cls);
    }
}
