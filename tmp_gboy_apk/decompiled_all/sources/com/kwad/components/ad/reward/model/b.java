package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ag;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long lX = -1;
    public int lY = 0;

    static {
        XWyXX();
    }

    public static void L(Context context) {
        String Sn = ag.Sn();
        b bVar = new b();
        if (TextUtils.isEmpty(Sn)) {
            bVar.lY = 1;
            bVar.lX = System.currentTimeMillis();
            ag.ai(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Sn));
            if (b(bVar.lX, System.currentTimeMillis())) {
                bVar.lY++;
            } else {
                bVar.lY = 1;
                bVar.lX = System.currentTimeMillis();
            }
            ag.ai(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static /* synthetic */ void XWyXX() {
        char[] charArray = "£¯\u00adî§¡\u00ad¥î¢¯¹î³¨¥¬¬î\u008a®©\u0082²©¤§¥".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 192);
        }
        String str = new String(charArray);
        char[] charArray2 = "£¬©®©´".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 192);
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
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return false;
    }

    public static int dR() {
        String Sn = ag.Sn();
        if (TextUtils.isEmpty(Sn)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Sn));
            if (b(bVar.lX, System.currentTimeMillis())) {
                return bVar.lY;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
