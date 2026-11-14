package androidx.fragment.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DV2E8K {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f8905A2egSU = new ArrayList();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f8906A4TApA = new HashMap();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f8907A5SV6n = new HashMap();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public D9tr6l f8908ADYaiT;

    public final void A2egSU(Fragment fragment) {
        if (this.f8905A2egSU.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f8905A2egSU) {
            this.f8905A2egSU.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final Fragment A4TApA(String str) {
        DUi7mC dUi7mC = (DUi7mC) this.f8906A4TApA.get(str);
        if (dUi7mC != null) {
            return dUi7mC.f8903A5SV6n;
        }
        return null;
    }

    public final Fragment A5SV6n(String str) {
        Fragment findFragmentByWho;
        for (DUi7mC dUi7mC : this.f8906A4TApA.values()) {
            if (dUi7mC != null && (findFragmentByWho = dUi7mC.f8903A5SV6n.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList ADYaiT() {
        ArrayList arrayList = new ArrayList();
        for (DUi7mC dUi7mC : this.f8906A4TApA.values()) {
            if (dUi7mC != null) {
                arrayList.add(dUi7mC);
            }
        }
        return arrayList;
    }

    public final ArrayList AMqCpz() {
        ArrayList arrayList = new ArrayList();
        for (DUi7mC dUi7mC : this.f8906A4TApA.values()) {
            if (dUi7mC != null) {
                arrayList.add(dUi7mC.f8903A5SV6n);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List ARc23Z() {
        ArrayList arrayList;
        if (this.f8905A2egSU.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f8905A2egSU) {
            arrayList = new ArrayList(this.f8905A2egSU);
        }
        return arrayList;
    }

    public final void ASJ6gh(DUi7mC dUi7mC) {
        Fragment fragment = dUi7mC.f8903A5SV6n;
        String str = fragment.mWho;
        HashMap hashMap = this.f8906A4TApA;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(fragment.mWho, dUi7mC);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.f8908ADYaiT.A5SV6n(fragment);
            } else {
                this.f8908ADYaiT.AMqCpz(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (CtxOCS.C4FrIb(2)) {
            fragment.toString();
        }
    }

    public final void AYUAbz(DUi7mC dUi7mC) {
        Fragment fragment = dUi7mC.f8903A5SV6n;
        if (fragment.mRetainInstance) {
            this.f8908ADYaiT.AMqCpz(fragment);
        }
        HashMap hashMap = this.f8906A4TApA;
        if (hashMap.get(fragment.mWho) == dUi7mC && ((DUi7mC) hashMap.put(fragment.mWho, null)) != null && CtxOCS.C4FrIb(2)) {
            fragment.toString();
        }
    }

    public final Bundle AZOQYO(Bundle bundle, String str) {
        HashMap hashMap = this.f8907A5SV6n;
        return bundle != null ? (Bundle) hashMap.put(str, bundle) : (Bundle) hashMap.remove(str);
    }
}
