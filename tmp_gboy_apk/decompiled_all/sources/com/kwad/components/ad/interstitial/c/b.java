package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long jC = -1;
    public int lV = 0;
    public int lW = 0;

    static {
        LTBAds();
    }

    public static void J(Context context) {
        String Sk = ag.Sk();
        b bVar = new b();
        if (TextUtils.isEmpty(Sk)) {
            bVar.lV = 1;
            bVar.jC = System.currentTimeMillis();
            ag.ae(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Sk));
            if (b(bVar.jC, System.currentTimeMillis())) {
                bVar.lV++;
            } else {
                bVar.lV = 1;
                bVar.lW = 0;
                bVar.jC = System.currentTimeMillis();
            }
            ag.ae(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static void K(Context context) {
        String Sk = ag.Sk();
        b bVar = new b();
        if (TextUtils.isEmpty(Sk)) {
            bVar.lW = 1;
            bVar.jC = System.currentTimeMillis();
            ag.ae(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Sk));
            if (b(bVar.jC, System.currentTimeMillis())) {
                bVar.lW++;
            } else {
                bVar.lW = 1;
                bVar.lV = 0;
                bVar.jC = System.currentTimeMillis();
            }
            ag.ae(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    private static /* synthetic */ void LTBAds() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static int dP() {
        String Sk = ag.Sk();
        if (TextUtils.isEmpty(Sk)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Sk));
            return bVar.lV;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int dQ() {
        String Sk = ag.Sk();
        if (TextUtils.isEmpty(Sk)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Sk));
            return bVar.lW;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }
}
