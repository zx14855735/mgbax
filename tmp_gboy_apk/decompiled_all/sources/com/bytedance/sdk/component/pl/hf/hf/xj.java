package com.bytedance.sdk.component.pl.hf.hf;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bykv.vk.openvk.component.video.api.kd.xj {
    public static volatile int hf;
    private static Object kd = new Object();
    public static volatile int u;
    public static volatile int w;
    public static volatile int xj;

    static {
        Gdkp();
    }

    private static /* synthetic */ void Gdkp() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    @Override // com.bykv.vk.openvk.component.video.api.kd.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(android.content.Context r21, final com.bykv.vk.openvk.component.video.api.w.u r22, final com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj r23) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.pl.hf.hf.xj.xj(android.content.Context, com.bykv.vk.openvk.component.video.api.w.u, com.bykv.vk.openvk.component.video.api.kd.xj$xj):void");
    }
}
