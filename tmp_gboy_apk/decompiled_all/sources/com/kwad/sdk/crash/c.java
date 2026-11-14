package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private static final String TAG = "c";
    public final String Ml;
    public final List<com.kwad.sdk.crash.a> aTA;
    public final double aTb;
    public final boolean aTg;
    public final boolean aTh;
    public final com.kwad.sdk.crash.model.c aTk;
    public final com.kwad.sdk.crash.model.a aTl;
    public final h aTm;
    public final String[] aTn;
    public final String[] aTo;
    public final boolean aTp;
    public final f aTq;
    public final String aTr;
    public final String aTs;
    public final String aTt;
    public final String aTu;
    public final String aTv;
    public final String aTw;
    public final String aTx;
    public final String aTy;
    public final String aTz;
    public final boolean awI;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    public static class a {
        private String Ml;
        private int aMu;
        private String aTB;
        private h aTC;
        private String[] aTD;
        public String[] aTE;
        private f aTq;
        private String aTr;
        private String aTs;
        private String aTt;
        private String aTu;
        private String aTv;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private String channel;
        private Context context;
        private String platform;
        private String sdkApiVersion;
        private int sdkApiVersionCode;
        public int sdkType;
        private String sdkVersion;
        private boolean aTp = false;
        private boolean aTg = false;
        private boolean aTh = false;
        private boolean awI = false;
        private String aTw = "";
        private String aTx = "";
        private String aTy = "";
        private String aTz = "";
        private List<com.kwad.sdk.crash.a> aTA = new ArrayList();
        private double aTb = 1.0d;

        public final a H(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aTA.add(aVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.w(c.TAG, Log.getStackTraceString(e));
                    }
                }
            }
            return this;
        }

        public final c Ni() {
            return new c(this, (byte) 0);
        }

        public final a bI(boolean z) {
            this.aTg = z;
            return this;
        }

        public final a bJ(boolean z) {
            this.aTh = z;
            return this;
        }

        public final a bK(boolean z) {
            this.awI = z;
            return this;
        }

        public final a ck(Context context) {
            this.context = context;
            return this;
        }

        public final a el(int i) {
            this.aMu = i;
            return this;
        }

        public final a em(int i) {
            this.sdkApiVersionCode = i;
            return this;
        }

        public final a en(int i) {
            this.sdkType = 1;
            return this;
        }

        public final a fA(String str) {
            this.platform = str;
            return this;
        }

        public final a fB(String str) {
            this.aTr = str;
            return this;
        }

        public final a fC(String str) {
            this.Ml = str;
            return this;
        }

        public final a fD(String str) {
            this.channel = str;
            return this;
        }

        public final a fE(String str) {
            this.aTv = str;
            return this;
        }

        public final a fF(String str) {
            this.aTB = str;
            return this;
        }

        public final a fG(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a fH(String str) {
            this.sdkApiVersion = str;
            return this;
        }

        public final a fI(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a fJ(String str) {
            this.appId = str;
            return this;
        }

        public final a fK(String str) {
            this.appName = str;
            return this;
        }

        public final a fL(String str) {
            this.appVersion = str;
            return this;
        }

        public final a fM(String str) {
            this.aTs = str;
            return this;
        }

        public final a fN(String str) {
            this.aTt = str;
            return this;
        }

        public final a fO(String str) {
            this.aTy = str;
            return this;
        }

        public final a fP(String str) {
            this.aTz = str;
            return this;
        }

        public final a fy(String str) {
            this.aTw = str;
            return this;
        }

        public final a fz(String str) {
            this.aTx = str;
            return this;
        }

        public final a a(f fVar) {
            this.aTq = fVar;
            return this;
        }

        public final a d(String[] strArr) {
            this.aTD = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.aTE = strArr;
            return this;
        }

        public final a m(double d) {
            this.aTb = d;
            return this;
        }

        public final a a(h hVar) {
            this.aTC = hVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final f Ng() {
        return this.aTq;
    }

    public final boolean isDebugMode() {
        return this.aTp;
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.aTk = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.aTl = aVar2;
        ArrayList arrayList = new ArrayList();
        this.aTA = arrayList;
        this.aTp = aVar.aTp;
        this.aTg = aVar.aTg;
        this.aTh = aVar.aTh;
        this.awI = aVar.awI;
        this.aTw = aVar.aTw;
        this.aTx = aVar.aTx;
        this.aTy = aVar.aTy;
        this.aTz = aVar.aTz;
        this.context = aVar.context;
        this.aTq = aVar.aTq;
        this.platform = aVar.platform;
        this.aTr = aVar.aTr;
        this.aTs = aVar.aTs;
        this.aTt = aVar.aTt;
        this.sdkVersion = aVar.sdkVersion;
        this.Ml = aVar.Ml;
        this.channel = aVar.channel;
        this.aTu = aVar.aTu;
        this.aTv = aVar.aTv;
        aVar2.mAppId = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.aUi = aVar.appVersion;
        aVar2.aUh = aVar.appPackageName;
        cVar.aUs = aVar.sdkApiVersion;
        cVar.aUt = aVar.sdkApiVersionCode;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.aUr = aVar.aMu;
        cVar.aUq = aVar.aTB;
        cVar.aUu = aVar.sdkType;
        this.aTm = aVar.aTC;
        this.aTn = aVar.aTD;
        this.aTo = aVar.aTE;
        arrayList.addAll(aVar.aTA);
        this.aTb = aVar.aTb;
    }
}
