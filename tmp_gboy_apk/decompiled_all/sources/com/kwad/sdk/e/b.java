package com.kwad.sdk.e;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements a {
    private static volatile b aVZ;
    private static c aWa;

    private b() {
    }

    public static synchronized b Oe() {
        b bVar;
        synchronized (b.class) {
            try {
                if (aVZ == null) {
                    synchronized (b.class) {
                        try {
                            if (aVZ == null) {
                                aVZ = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = aVZ;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static String Of() {
        return a(false, "", 2);
    }

    public static void a(c cVar) {
        aWa = cVar;
    }

    @Override // com.kwad.sdk.e.a
    public final String NU() {
        c cVar = aWa;
        return cVar != null ? cVar.NU() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String NV() {
        c cVar = aWa;
        return cVar != null ? cVar.NV() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String NW() {
        c cVar = aWa;
        return cVar != null ? cVar.NW() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String NX() {
        c cVar = aWa;
        return cVar != null ? cVar.NX() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String NY() {
        c cVar = aWa;
        return cVar != null ? cVar.NY() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String NZ() {
        c cVar = aWa;
        return cVar != null ? cVar.NZ() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String Oa() {
        c cVar = aWa;
        return cVar != null ? cVar.Oa() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String Ob() {
        c cVar = aWa;
        return cVar != null ? cVar.Ob() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String Oc() {
        c cVar = aWa;
        return cVar != null ? cVar.Oc() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String Od() {
        c cVar = aWa;
        return cVar != null ? cVar.Od() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = aWa;
        return cVar != null ? cVar.getAppId() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = aWa;
        return cVar != null ? cVar.getDeviceId() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIMEI() {
        c cVar = aWa;
        return cVar != null ? cVar.getIMEI() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = aWa;
        return cVar != null ? cVar.getIccId() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = aWa;
        return cVar != null ? cVar.getIp() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = aWa;
        return cVar != null ? cVar.getLocation() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getMac() {
        c cVar = aWa;
        return cVar != null ? cVar.getMac() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = aWa;
        return cVar != null ? cVar.getOaid() : Of();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = aWa;
        return cVar != null ? cVar.getSdkVersion() : Of();
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put("value", obj);
        hashMap.put(MediationConstant.KEY_ERROR_CODE, String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }
}
