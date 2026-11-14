package com.kwad.components.ad.interstitial.d;

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
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long lX = -1;
    public int lY = 0;

    static {
        HVkKFqM();
    }

    private static /* synthetic */ void HVkKFqM() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void L(Context context) {
        String So = ag.So();
        a aVar = new a();
        if (TextUtils.isEmpty(So)) {
            aVar.lY = 1;
            aVar.lX = System.currentTimeMillis();
            ag.aj(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(So));
            if (b(aVar.lX, System.currentTimeMillis())) {
                aVar.lY++;
            } else {
                aVar.lY = 1;
                aVar.lX = System.currentTimeMillis();
            }
            ag.aj(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return false;
    }

    public static int dR() {
        String So = ag.So();
        if (TextUtils.isEmpty(So)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(So));
            if (b(aVar.lX, System.currentTimeMillis())) {
                return aVar.lY;
            }
            return 0;
        } catch (Exception e) {
            c.printStackTrace(e);
            return 0;
        }
    }
}
