package com.google.android.gms.auth.api.signin.internal;

import AZkASS.ARc23Z;
import N9P37h.ADYaiT;
import NCeV4Q.A2egSU;
import NCeV4Q.A5SV6n;
import NCeV4Q.B3GDIM;
import NSK3xo.A4TApA;
import NSK3xo.AcNBzu;
import NUY5pn.AYUAbz;
import QgOIY0.B7CMnp;
import QgOIY0.CTkVKb;
import QgOIY0.CcAIMM;
import android.accounts.Account;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SignInHubActivity extends B7CMnp {

    /* renamed from: BChYOn, reason: collision with root package name */
    public B3GDIM f11205BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public A2egSU f11206BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f11207BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f11208BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public Intent f11209BNL6CD;

    public final void AMqCpz(int i) {
        A4TApA a4TApA = new A4TApA(i, null);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", a4TApA);
        setResult(0, intent);
        finish();
    }

    public final void ARc23Z() {
        QgOIY0.B3GDIM b3gdim = (QgOIY0.B3GDIM) this.f7599AmA8tU.f3956AlLFFp;
        CcAIMM ccAIMM = b3gdim.f7592ASJ6gh;
        if (ccAIMM == null) {
            b3gdim.f7593AYUAbz = true;
            ccAIMM = b3gdim.A5SV6n("(root)", b3gdim.f7594AZOQYO, true);
            b3gdim.f7592ASJ6gh = ccAIMM;
        }
        ARc23Z aRc23Z = new ARc23Z(29, this);
        if (ccAIMM.f7703ARc23Z) {
            throw new IllegalStateException("Called while creating a loader");
        }
        CTkVKb cTkVKb = (CTkVKb) ccAIMM.f7699A2egSU.A2egSU(0);
        if (cTkVKb == null) {
            try {
                ccAIMM.f7703ARc23Z = true;
                cTkVKb = new CTkVKb(ccAIMM, aRc23Z);
                Set set = AcNBzu.f5944AcNBzu;
                synchronized (set) {
                }
                cTkVKb.f7689A4TApA = new A5SV6n(this, set);
                ccAIMM.f7699A2egSU.A5SV6n(0, cTkVKb);
                if (ccAIMM.f7702ADYaiT) {
                    cTkVKb.A2egSU();
                }
            } finally {
                ccAIMM.f7703ARc23Z = false;
            }
        } else {
            cTkVKb.f7688A2egSU = aRc23Z;
        }
        if (cTkVKb.f7690A5SV6n && ccAIMM.f7702ADYaiT) {
            cTkVKb.A5SV6n(cTkVKb.AMqCpz);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // QgOIY0.B7CMnp, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        N9P37h.A2egSU a2egSU;
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            ADYaiT aDYaiT = (ADYaiT) intent.getParcelableExtra("signInAccount");
            if (aDYaiT != null && (a2egSU = aDYaiT.f5630AzWtSf) != null) {
                B3GDIM b3gdim = this.f11205BChYOn;
                N9P37h.A5SV6n a5SV6n = this.f11206BI9f7h.f5633AmA8tU;
                b3gdim.getClass();
                AYUAbz.A4TApA(a5SV6n);
                String str = a2egSU.f5607B9tovu;
                b3gdim.A4TApA("defaultGoogleSignInAccount", str);
                String A5SV6n2 = B3GDIM.A5SV6n("googleSignInAccount", str);
                JSONObject A4TApA2 = a2egSU.A4TApA();
                A4TApA2.remove("serverAuthCode");
                b3gdim.A4TApA(A5SV6n2, A4TApA2.toString());
                String A5SV6n3 = B3GDIM.A5SV6n("googleSignInOptions", str);
                String str2 = a5SV6n.f5626B4ZgIw;
                String str3 = a5SV6n.f5625B3GDIM;
                ArrayList arrayList = a5SV6n.f5620AlLFFp;
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Collections.sort(arrayList, N9P37h.A5SV6n.f5618BChYOn);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((NSK3xo.A2egSU) it.next()).f5920AlLFFp);
                    }
                    jSONObject.put("scopes", jSONArray);
                    Account account = a5SV6n.f5621AmA8tU;
                    if (account != null) {
                        jSONObject.put("accountName", account.name);
                    }
                    jSONObject.put("idTokenRequested", a5SV6n.f5622AzWtSf);
                    jSONObject.put("forceCodeForRefreshToken", a5SV6n.f5624B2KMhB);
                    jSONObject.put("serverAuthRequested", a5SV6n.f5623B25kr6);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("serverClientId", str3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("hostedDomain", str2);
                    }
                    b3gdim.A4TApA(A5SV6n3, jSONObject.toString());
                    intent.removeExtra("signInAccount");
                    intent.putExtra("googleSignInAccount", a2egSU);
                    this.f11207BIYEnU = true;
                    this.f11208BJ7GGh = i2;
                    this.f11209BNL6CD = intent;
                    ARc23Z();
                    return;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            if (intent.hasExtra(MediationConstant.KEY_ERROR_CODE)) {
                AMqCpz(intent.getIntExtra(MediationConstant.KEY_ERROR_CODE, 8));
                return;
            }
        }
        AMqCpz(8);
    }

    @Override // QgOIY0.B7CMnp, QgOIY0.AlLFFp, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11205BChYOn = B3GDIM.A2egSU(this);
        Intent intent = getIntent();
        if (!"com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent.getAction())) {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown action: ".concat(valueOf);
            }
            finish();
        }
        A2egSU a2egSU = (A2egSU) intent.getParcelableExtra("config");
        this.f11206BI9f7h = a2egSU;
        if (a2egSU == null) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            Intent intent2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            intent2.setPackage("com.google.android.gms");
            intent2.putExtra("config", this.f11206BI9f7h);
            try {
                startActivityForResult(intent2, 40962);
                return;
            } catch (ActivityNotFoundException unused) {
                AMqCpz(8);
                return;
            }
        }
        boolean z = bundle.getBoolean("signingInGoogleApiClients");
        this.f11207BIYEnU = z;
        if (z) {
            this.f11208BJ7GGh = bundle.getInt("signInResultCode");
            this.f11209BNL6CD = (Intent) bundle.getParcelable("signInResultData");
            ARc23Z();
        }
    }

    @Override // QgOIY0.B7CMnp, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f11207BIYEnU);
        if (this.f11207BIYEnU) {
            bundle.putInt("signInResultCode", this.f11208BJ7GGh);
            bundle.putParcelable("signInResultData", this.f11209BNL6CD);
        }
    }
}
