package Hjvs0g;

import ADYaiT.DUi7mC;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BmvVmW {
    public static final Hdahpu.AZOQYO AMqCpz = new Hdahpu.AZOQYO(6);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final BTvldC f3758ARc23Z = new BTvldC();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f3759A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Hdahpu.AZOQYO f3760A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashSet f3761A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final DUi7mC f3762ADYaiT;

    static {
        LEynag();
    }

    public BmvVmW(DUi7mC dUi7mC) {
        Hdahpu.AZOQYO azoqyo = AMqCpz;
        this.f3759A2egSU = new ArrayList();
        this.f3761A5SV6n = new HashSet();
        this.f3762ADYaiT = dUi7mC;
        this.f3760A4TApA = azoqyo;
    }

    private static /* synthetic */ void LEynag() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized void A2egSU(Class cls, Class cls2, BIYEnU bIYEnU) {
        BV3sI0 bV3sI0 = new BV3sI0(cls, cls2, bIYEnU);
        ArrayList arrayList = this.f3759A2egSU;
        arrayList.add(arrayList.size(), bV3sI0);
    }

    public final BI9f7h A4TApA(BV3sI0 bV3sI0) {
        BI9f7h AYUAbz2 = bV3sI0.f3757A5SV6n.AYUAbz(this);
        ItGa5w.ARc23Z.A5SV6n(AYUAbz2, "Argument must not be null");
        return AYUAbz2;
    }

    public final synchronized BI9f7h A5SV6n(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f3759A2egSU.iterator();
            boolean z = false;
            while (it.hasNext()) {
                BV3sI0 bV3sI0 = (BV3sI0) it.next();
                if (this.f3761A5SV6n.contains(bV3sI0)) {
                    z = true;
                } else if (bV3sI0.f3755A2egSU.isAssignableFrom(cls) && bV3sI0.f3756A4TApA.isAssignableFrom(cls2)) {
                    this.f3761A5SV6n.add(bV3sI0);
                    arrayList.add(A4TApA(bV3sI0));
                    this.f3761A5SV6n.remove(bV3sI0);
                }
            }
            if (arrayList.size() > 1) {
                Hdahpu.AZOQYO azoqyo = this.f3760A4TApA;
                DUi7mC dUi7mC = this.f3762ADYaiT;
                azoqyo.getClass();
                return new A4TApA(arrayList, 1, dUi7mC);
            }
            if (arrayList.size() == 1) {
                return (BI9f7h) arrayList.get(0);
            }
            if (z) {
                return f3758ARc23Z;
            }
            throw new com.bumptech.glide.AcNBzu("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f3761A5SV6n.clear();
            throw th;
        }
    }

    public final synchronized ArrayList ADYaiT(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f3759A2egSU.iterator();
            while (it.hasNext()) {
                BV3sI0 bV3sI0 = (BV3sI0) it.next();
                if (!this.f3761A5SV6n.contains(bV3sI0) && bV3sI0.f3755A2egSU.isAssignableFrom(cls)) {
                    this.f3761A5SV6n.add(bV3sI0);
                    arrayList.add(A4TApA(bV3sI0));
                    this.f3761A5SV6n.remove(bV3sI0);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList AMqCpz(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f3759A2egSU.iterator();
        while (it.hasNext()) {
            BV3sI0 bV3sI0 = (BV3sI0) it.next();
            if (!arrayList.contains(bV3sI0.f3756A4TApA) && bV3sI0.f3755A2egSU.isAssignableFrom(cls)) {
                arrayList.add(bV3sI0.f3756A4TApA);
            }
        }
        return arrayList;
    }
}
