package com.kwad.sdk.kgeo;

import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static String aXd;
    private static KGeoInfo aXe;
    private static final AtomicBoolean aXf = new AtomicBoolean();

    static {
        cmuLVk();
    }

    public static String CX() {
        return aXd;
    }

    public static KGeoInfo OH() {
        return aXe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void OI() {
        try {
            if (aXf.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Re(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aXd = str;
                    a.OJ();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void qF() {
                    a.OJ();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void OJ() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                private static KGeoResultData gq(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                public final f createRequest() {
                    return new b();
                }

                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return gq(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                private static void a(KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aXe = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static /* synthetic */ void cmuLVk() {
        char[] charArray = "%)+h!'+#h$)?h5.#**h\f(/\u00044/\"!#".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'F');
        }
        String str = new String(charArray);
        char[] charArray2 = "%*/(/2".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'F');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void es(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            OI();
        } else if (i == 2) {
            com.kwad.components.core.request.b.tE().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void tG() {
                    com.kwad.components.core.request.b.tE().b(this);
                    a.OI();
                }
            });
        }
    }
}
