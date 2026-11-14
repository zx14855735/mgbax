package com.octopus.ad;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.util.TypedValue;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f12348a = new b(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 50, "320x50_mb");
    public static final b b = new b(468, 60, "468x60_as");
    public static final b c = new b(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 100, "320x100_as");
    public static final b d = new b(728, 90, "728x90_as");
    public static final b e = new b(300, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM, "300x250_as");
    public static final b f = new b(160, 600, "160x600_as");
    public static final b g = new b(-1, -2, "smart_banner");
    public static final b h = new b(-3, -4, "fluid");
    public static final b i = new b(-3, 0, "search_v2");
    private final int j;
    private final int k;
    private final String l;

    static {
        WbLs();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(int r4, int r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = -1
            if (r4 != r1) goto Lb
            java.lang.String r1 = "FULL"
            goto Lf
        Lb:
            java.lang.String r1 = java.lang.String.valueOf(r4)
        Lf:
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            r1 = -2
            if (r5 != r1) goto L1d
            java.lang.String r1 = "AUTO"
            goto L21
        L1d:
            java.lang.String r1 = java.lang.String.valueOf(r5)
        L21:
            java.lang.String r2 = "_as"
            java.lang.String r0 = ADYaiT.CtFAbx.B25kr6(r0, r1, r2)
            r3.<init>(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.b.<init>(int, int):void");
    }

    private static /* synthetic */ void WbLs() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a(Context context) {
        int i2 = this.k;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        return i2 != -2 ? (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics()) : context.getResources().getDisplayMetrics().heightPixels;
    }

    public int b(Context context) {
        int i2 = this.j;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        return i2 != -1 ? (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics()) : context.getResources().getDisplayMetrics().widthPixels;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.j == bVar.j && this.k == bVar.k && this.l.equals(bVar.l);
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    public String toString() {
        return this.l;
    }

    private b(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i2, "Invalid width for AdSize: "));
        }
        if (i3 < 0 && i3 != -2 && i3 != -4) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i3, "Invalid height for AdSize: "));
        }
        this.j = i2;
        this.k = i3;
        this.l = str;
    }
}
