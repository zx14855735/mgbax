package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long jC;
    public int jD;

    static {
        NVMOT();
    }

    public b() {
        this.jC = -1L;
        this.jD = -1;
    }

    private static /* synthetic */ void NVMOT() {
        char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 213);
        }
        String str = new String(charArray);
        char[] charArray2 = "¶¹¼»¼¡".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 213);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean F(int i) {
        int i2 = this.jD;
        return i2 > 0 && i2 >= i;
    }

    public final boolean j(long j) {
        if (this.jC > 0 && j > 0) {
            try {
                return jB.format(new Date(this.jC)).equals(jB.format(new Date(j)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public b(long j, int i) {
        this.jC = j;
        this.jD = 1;
    }
}
