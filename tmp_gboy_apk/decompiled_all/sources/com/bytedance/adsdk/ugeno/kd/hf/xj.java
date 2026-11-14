package com.bytedance.adsdk.ugeno.kd.hf;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    public static final HashSet<String> xj = new HashSet<>(Arrays.asList("convert", PointCategory.DISLIKE, "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected String c;
    protected String f;
    protected y.xj hf;
    protected String kd;
    protected String u;
    protected com.bytedance.adsdk.ugeno.hf.w w;
    protected Map<String, String> y;

    /* renamed from: com.bytedance.adsdk.ugeno.kd.hf.xj$xj, reason: collision with other inner class name */
    public static class C0027xj {
        public static xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
            if (xjVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.kd.hf xj = com.bytedance.adsdk.ugeno.kd.u.xj(xjVar.hf());
            if (xj == null) {
                return new w(wVar, str, xjVar);
            }
            xj xj2 = xj.xj(wVar, str, xjVar);
            return xj2 == null ? new w(wVar, str, xjVar) : xj2;
        }
    }

    static {
        iDkR();
    }

    public xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
        this.w = wVar;
        this.hf = xjVar;
        this.c = str;
        kd();
    }

    private static /* synthetic */ void iDkR() {
        char[] charArray = "\u000f\u0003\u0001B\u000b\r\u0001\tB\u000e\u0003\u0015B\u001f\u0004\t\u0000\u0000B&\u0002\u0005.\u001e\u0005\b\u000b\t".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'l');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000f\u0000\u0005\u0002\u0005\u0018".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'l');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void kd() {
        y.xj xjVar = this.hf;
        if (xjVar == null) {
            return;
        }
        this.u = xjVar.xj();
        this.kd = this.hf.hf();
        Map<String, String> w = this.hf.w();
        this.y = w;
        if (w == null || w.isEmpty() || !this.y.containsKey("emitCustomEvent")) {
            return;
        }
        this.f = this.y.get("emitCustomEvent");
    }

    public void hf() {
        w();
    }

    public boolean u() {
        return !TextUtils.isEmpty(this.f);
    }

    public void w() {
        if (u()) {
            y.xj xjVar = new y.xj();
            xjVar.xj(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
            xjVar.hf("emit");
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.f);
            xjVar.xj(hashMap);
            new hf(this.w, this.kd, xjVar).xj();
        }
    }

    public abstract void xj();
}
