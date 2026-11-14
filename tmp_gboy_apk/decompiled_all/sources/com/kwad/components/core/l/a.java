package com.kwad.components.core.l;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.ksad.json.annotation.KsJson;
import com.kuaishou.weapon.p0.bi;
import com.kwad.sdk.core.d.c;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat SM = new SimpleDateFormat("yyyy-MM-dd");
    public int SN;
    public long SO;

    static {
        GXlFM();
    }

    private static /* synthetic */ void GXlFM() {
        char[] charArray = ".\" c*, (c/\"4c>%(!!c\u0007#$\u000f?$)*(".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'M');
        }
        String str = new String(charArray);
        char[] charArray2 = ".!$#$9".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'M');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean k(int i, int i2) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.SO <= 0) {
            ri();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = SM.format(new Date(this.SO));
        String format2 = SM.format(new Date(currentTimeMillis));
        c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
        if (!format.equals(format2)) {
            this.SN = 0;
            ri();
            return true;
        }
        long j = (i * bi.s) + this.SO;
        A2egSU.BChYOn(CtFAbx.B2KMhB("checkAndAddCount minTimestamp: ", j, ", currentActiveCount: "), this.SN, "AdForceActiveInfo");
        if (j >= currentTimeMillis || this.SN > i2) {
            return false;
        }
        ri();
        return true;
    }

    public final void ri() {
        this.SO = System.currentTimeMillis();
        this.SN++;
        StringBuilder sb = new StringBuilder("doAddCount, lastForceActiveTimestamp: ");
        sb.append(this.SO);
        sb.append(", currentActiveCount ");
        A2egSU.BChYOn(sb, this.SN, "AdForceActiveInfo");
    }
}
