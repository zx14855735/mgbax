package androidx.lifecycle;

import android.app.Dialog;
import android.os.Looper;
import android.view.View;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class LiveData {

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Object f9044AZkASS = new Object();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f9045A2egSU = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AlLFFp.ARc23Z f9046A4TApA = new AlLFFp.ARc23Z();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9047A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f9048ADYaiT;
    public volatile Object AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public volatile Object f9049ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f9050ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f9051AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f9052AZOQYO;

    public class LifecycleBoundObserver extends BNL6CD implements B4ZgIw {
        @Override // androidx.lifecycle.BNL6CD
        public final void A4TApA() {
            throw null;
        }

        @Override // androidx.lifecycle.BNL6CD
        public final boolean A5SV6n() {
            throw null;
        }

        @Override // androidx.lifecycle.B4ZgIw
        public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
            throw null;
        }
    }

    static {
        fvgtqaT();
    }

    public LiveData() {
        Object obj = f9044AZkASS;
        this.f9049ARc23Z = obj;
        this.AMqCpz = obj;
        this.f9050ASJ6gh = -1;
    }

    public static void A2egSU(String str) {
        AcNBzu.A2egSU.A2egSU().f937A2egSU.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(ADYaiT.CtFAbx.BI9f7h("Cannot invoke ", str, " on a background thread"));
        }
    }

    private static /* synthetic */ void fvgtqaT() {
        char[] charArray = "\".,o& ,$o#.8o2)$--o\u000b/(\u00033(%&$".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'A');
        }
        String str = new String(charArray);
        char[] charArray2 = "\"-(/(5".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'A');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA(BNL6CD bnl6cd) {
        boolean z;
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        if (bnl6cd.f8996AlLFFp) {
            if (!bnl6cd.A5SV6n()) {
                bnl6cd.A2egSU(false);
                return;
            }
            int i = bnl6cd.f8997AmA8tU;
            int i2 = this.f9050ASJ6gh;
            if (i >= i2) {
                return;
            }
            bnl6cd.f8997AmA8tU = i2;
            BV3sI0 bV3sI0 = bnl6cd.f8995AcNBzu;
            Object obj = this.AMqCpz;
            androidx.fragment.app.BJ7GGh bJ7GGh = (androidx.fragment.app.BJ7GGh) bV3sI0;
            bJ7GGh.getClass();
            if (((B9tovu) obj) != null) {
                androidx.fragment.app.B4ZgIw b4ZgIw = (androidx.fragment.app.B4ZgIw) bJ7GGh.f8771AlLFFp;
                z = b4ZgIw.mShowsDialog;
                if (z) {
                    View requireView = b4ZgIw.requireView();
                    if (requireView.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    dialog = b4ZgIw.mDialog;
                    if (dialog != null) {
                        if (androidx.fragment.app.CtxOCS.C4FrIb(3)) {
                            dialog3 = b4ZgIw.mDialog;
                            Objects.toString(dialog3);
                        }
                        dialog2 = b4ZgIw.mDialog;
                        dialog2.setContentView(requireView);
                    }
                }
            }
        }
    }

    public final void A5SV6n(BNL6CD bnl6cd) {
        if (this.f9051AYUAbz) {
            this.f9052AZOQYO = true;
            return;
        }
        this.f9051AYUAbz = true;
        do {
            this.f9052AZOQYO = false;
            if (bnl6cd != null) {
                A4TApA(bnl6cd);
                bnl6cd = null;
            } else {
                AlLFFp.ARc23Z aRc23Z = this.f9046A4TApA;
                aRc23Z.getClass();
                AlLFFp.ADYaiT aDYaiT = new AlLFFp.ADYaiT(aRc23Z);
                aRc23Z.f955AmA8tU.put(aDYaiT, Boolean.FALSE);
                while (aDYaiT.hasNext()) {
                    A4TApA((BNL6CD) ((Map.Entry) aDYaiT.next()).getValue());
                    if (this.f9052AZOQYO) {
                        break;
                    }
                }
            }
        } while (this.f9052AZOQYO);
        this.f9051AYUAbz = false;
    }

    public final void ADYaiT(BV3sI0 bV3sI0) {
        Object obj;
        A2egSU("observeForever");
        BJ7GGh bJ7GGh = new BJ7GGh(this, bV3sI0);
        AlLFFp.ARc23Z aRc23Z = this.f9046A4TApA;
        AlLFFp.A5SV6n A2egSU2 = aRc23Z.A2egSU(bV3sI0);
        if (A2egSU2 != null) {
            obj = A2egSU2.f945AlLFFp;
        } else {
            AlLFFp.A5SV6n a5SV6n = new AlLFFp.A5SV6n(bV3sI0, bJ7GGh);
            aRc23Z.f956AzWtSf++;
            AlLFFp.A5SV6n a5SV6n2 = aRc23Z.f954AlLFFp;
            if (a5SV6n2 == null) {
                aRc23Z.f953AcNBzu = a5SV6n;
                aRc23Z.f954AlLFFp = a5SV6n;
            } else {
                a5SV6n2.f946AmA8tU = a5SV6n;
                a5SV6n.f947AzWtSf = a5SV6n2;
                aRc23Z.f954AlLFFp = a5SV6n;
            }
            obj = null;
        }
        BNL6CD bnl6cd = (BNL6CD) obj;
        if (bnl6cd instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (bnl6cd != null) {
            return;
        }
        bJ7GGh.A2egSU(true);
    }
}
