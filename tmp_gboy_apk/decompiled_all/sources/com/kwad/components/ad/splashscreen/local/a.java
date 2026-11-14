package com.kwad.components.ad.splashscreen.local;

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
    public long jC = 0;
    public int jD = 0;

    static {
        JRtPj();
    }

    private static /* synthetic */ void JRtPj() {
        char[] charArray = "]QS\u0010Y_S[\u0010\\QG\u0010MV[RR\u0010tPW|LWZY[".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '>');
        }
        String str = new String(charArray);
        char[] charArray2 = "]RWPWJ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '>');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void V(Context context) {
        String Sm = ag.Sm();
        a aVar = new a();
        if (TextUtils.isEmpty(Sm)) {
            aVar.jD = 1;
            aVar.jC = System.currentTimeMillis();
            ag.ah(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Sm));
            if (b(aVar.jC, System.currentTimeMillis())) {
                aVar.jD++;
            } else {
                aVar.jD = 1;
            }
            aVar.jC = System.currentTimeMillis();
            ag.ah(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
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
}
