package QgOIY0;

import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class CTkVKb {

    /* renamed from: A2egSU, reason: collision with root package name */
    public AZkASS.ARc23Z f7688A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public NCeV4Q.A5SV6n f7689A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f7690A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f7691ADYaiT;
    public Object AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f7692ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f7693ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f7694AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f7695AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f7696AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f7697AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CcAIMM f7698AcNBzu;

    public CTkVKb(CcAIMM ccAIMM, AZkASS.ARc23Z aRc23Z) {
        this.f7698AcNBzu = ccAIMM;
        this.f7688A2egSU = aRc23Z;
    }

    public final void A2egSU() {
        AZkASS.ARc23Z aRc23Z;
        if (this.f7693ASJ6gh && this.f7694AYUAbz) {
            this.f7692ARc23Z = true;
            return;
        }
        if (this.f7692ARc23Z) {
            return;
        }
        this.f7692ARc23Z = true;
        if (this.f7689A4TApA == null && (aRc23Z = this.f7688A2egSU) != null) {
            SignInHubActivity signInHubActivity = (SignInHubActivity) aRc23Z.f451AlLFFp;
            Set set = NSK3xo.AcNBzu.f5944AcNBzu;
            synchronized (set) {
            }
            this.f7689A4TApA = new NCeV4Q.A5SV6n(signInHubActivity, set);
        }
        if (this.f7689A4TApA != null) {
            if (NCeV4Q.A5SV6n.class.isMemberClass() && !Modifier.isStatic(this.f7689A4TApA.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f7689A4TApA);
            }
            if (!this.f7697AaHO0E) {
                NCeV4Q.A5SV6n a5SV6n = this.f7689A4TApA;
                if (a5SV6n.f5634A2egSU != null) {
                    throw new IllegalStateException("There is already a listener registered");
                }
                a5SV6n.f5634A2egSU = this;
                if (a5SV6n.f5635A4TApA != null) {
                    throw new IllegalStateException("There is already a listener registered");
                }
                a5SV6n.f5635A4TApA = this;
                this.f7697AaHO0E = true;
            }
            NCeV4Q.A5SV6n a5SV6n2 = this.f7689A4TApA;
            a5SV6n2.f5636A5SV6n = true;
            a5SV6n2.f5637ADYaiT = false;
            a5SV6n2.f5641AZOQYO.drainPermits();
            if (a5SV6n2.f5638ARc23Z != null) {
                if (!a5SV6n2.f5636A5SV6n) {
                    a5SV6n2.AMqCpz = true;
                }
                if (a5SV6n2.f5639ASJ6gh != null) {
                    a5SV6n2.f5638ARc23Z.getClass();
                    a5SV6n2.f5638ARc23Z = null;
                } else {
                    a5SV6n2.f5638ARc23Z.getClass();
                    QigWB9.A2egSU a2egSU = a5SV6n2.f5638ARc23Z;
                    a2egSU.f7717AzWtSf.set(true);
                    if (a2egSU.f7715AlLFFp.cancel(false)) {
                        a5SV6n2.f5639ASJ6gh = a5SV6n2.f5638ARc23Z;
                    }
                    a5SV6n2.f5638ARc23Z = null;
                }
            }
            a5SV6n2.f5638ARc23Z = new QigWB9.A2egSU(a5SV6n2);
            a5SV6n2.A5SV6n();
        }
    }

    public final void A4TApA(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(0);
        printWriter.print(" mArgs=");
        printWriter.println((Object) null);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f7688A2egSU);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f7689A4TApA);
        NCeV4Q.A5SV6n a5SV6n = this.f7689A4TApA;
        if (a5SV6n != null) {
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mListener=");
            printWriter.println(a5SV6n.f5634A2egSU);
            if (a5SV6n.f5636A5SV6n || a5SV6n.AMqCpz) {
                printWriter.print(str2);
                printWriter.print("mStarted=");
                printWriter.print(a5SV6n.f5636A5SV6n);
                printWriter.print(" mContentChanged=");
                printWriter.print(a5SV6n.AMqCpz);
                printWriter.print(" mProcessingChange=");
                printWriter.println(false);
            }
            if (a5SV6n.f5637ADYaiT) {
                printWriter.print(str2);
                printWriter.print("mAbandoned=");
                printWriter.print(false);
                printWriter.print(" mReset=");
                printWriter.println(a5SV6n.f5637ADYaiT);
            }
            if (a5SV6n.f5638ARc23Z != null) {
                printWriter.print(str2);
                printWriter.print("mTask=");
                printWriter.print(a5SV6n.f5638ARc23Z);
                printWriter.print(" waiting=");
                a5SV6n.f5638ARc23Z.getClass();
                printWriter.println(false);
            }
            if (a5SV6n.f5639ASJ6gh != null) {
                printWriter.print(str2);
                printWriter.print("mCancellingTask=");
                printWriter.print(a5SV6n.f5639ASJ6gh);
                printWriter.print(" waiting=");
                a5SV6n.f5639ASJ6gh.getClass();
                printWriter.println(false);
            }
        }
        if (this.f7690A5SV6n || this.f7691ADYaiT) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f7690A5SV6n);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f7691ADYaiT);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.AMqCpz);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f7692ARc23Z);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f7695AZOQYO);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f7696AZkASS);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f7693ASJ6gh);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f7694AYUAbz);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f7697AaHO0E);
    }

    public final void A5SV6n(Object obj) {
        String str;
        AZkASS.ARc23Z aRc23Z = this.f7688A2egSU;
        if (aRc23Z != null) {
            CcAIMM ccAIMM = this.f7698AcNBzu;
            B3GDIM b3gdim = ccAIMM.f7704ASJ6gh;
            if (b3gdim != null) {
                BNL6CD bnl6cd = b3gdim.f7589A5SV6n;
                str = bnl6cd.f7625B2KMhB;
                bnl6cd.f7625B2KMhB = "onLoadFinished";
            } else {
                str = null;
            }
            try {
                SignInHubActivity signInHubActivity = (SignInHubActivity) aRc23Z.f451AlLFFp;
                signInHubActivity.setResult(signInHubActivity.f11208BJ7GGh, signInHubActivity.f11209BNL6CD);
                signInHubActivity.finish();
                this.f7691ADYaiT = true;
            } finally {
                B3GDIM b3gdim2 = ccAIMM.f7704ASJ6gh;
                if (b3gdim2 != null) {
                    b3gdim2.f7589A5SV6n.f7625B2KMhB = str;
                }
            }
        }
    }

    public final void ADYaiT() {
        NCeV4Q.A5SV6n a5SV6n;
        this.f7692ARc23Z = false;
        if (this.f7693ASJ6gh || (a5SV6n = this.f7689A4TApA) == null || !this.f7697AaHO0E) {
            return;
        }
        this.f7697AaHO0E = false;
        CTkVKb cTkVKb = a5SV6n.f5634A2egSU;
        if (cTkVKb == null) {
            throw new IllegalStateException("No listener register");
        }
        if (cTkVKb != this) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        a5SV6n.f5634A2egSU = null;
        CTkVKb cTkVKb2 = a5SV6n.f5635A4TApA;
        if (cTkVKb2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (cTkVKb2 != this) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        a5SV6n.f5635A4TApA = null;
        a5SV6n.f5636A5SV6n = false;
    }

    public final void AMqCpz() {
        String str;
        this.f7696AZkASS = true;
        boolean z = this.f7691ADYaiT;
        this.f7691ADYaiT = false;
        if (this.f7688A2egSU != null && this.f7689A4TApA != null && this.f7690A5SV6n && z) {
            B3GDIM b3gdim = this.f7698AcNBzu.f7704ASJ6gh;
            if (b3gdim != null) {
                BNL6CD bnl6cd = b3gdim.f7589A5SV6n;
                str = bnl6cd.f7625B2KMhB;
                bnl6cd.f7625B2KMhB = "onLoaderReset";
            } else {
                str = null;
            }
            if (b3gdim != null) {
                b3gdim.f7589A5SV6n.f7625B2KMhB = str;
            }
        }
        this.f7688A2egSU = null;
        this.AMqCpz = null;
        this.f7690A5SV6n = false;
        NCeV4Q.A5SV6n a5SV6n = this.f7689A4TApA;
        if (a5SV6n != null) {
            if (this.f7697AaHO0E) {
                this.f7697AaHO0E = false;
                CTkVKb cTkVKb = a5SV6n.f5634A2egSU;
                if (cTkVKb == null) {
                    throw new IllegalStateException("No listener register");
                }
                if (cTkVKb != this) {
                    throw new IllegalArgumentException("Attempting to unregister the wrong listener");
                }
                a5SV6n.f5634A2egSU = null;
                CTkVKb cTkVKb2 = a5SV6n.f5635A4TApA;
                if (cTkVKb2 == null) {
                    throw new IllegalStateException("No listener register");
                }
                if (cTkVKb2 != this) {
                    throw new IllegalArgumentException("Attempting to unregister the wrong listener");
                }
                a5SV6n.f5635A4TApA = null;
            }
            a5SV6n.f5637ADYaiT = true;
            a5SV6n.f5636A5SV6n = false;
            a5SV6n.AMqCpz = false;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #0 : ");
        QkAq4X.ADYaiT.A4TApA(this.f7689A4TApA, sb);
        sb.append("}}");
        return sb.toString();
    }
}
