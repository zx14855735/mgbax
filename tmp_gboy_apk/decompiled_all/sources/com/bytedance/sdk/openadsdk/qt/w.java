package com.bytedance.sdk.openadsdk.qt;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public String hf;
    private String w;
    public String xj;

    public static class xj {
        private static w xj = new w();

        static {
            ClIBd();
        }

        private static /* synthetic */ void ClIBd() {
            char[] charArray = "gki*ceia*fk}*wlahh*NjmFvm`ca".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 4);
            }
            String str = new String(charArray);
            char[] charArray2 = "ghmjmp".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 4);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private String d() {
        Map<String, Object> tf = tf();
        if (tf == null) {
            return null;
        }
        Object obj = tf.get("od");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private boolean p() {
        String pz = f.zg().pz();
        if (TextUtils.isEmpty(pz)) {
            return false;
        }
        pz.getClass();
        switch (pz) {
        }
        return false;
    }

    private Map<String, Object> tf() {
        com.bytedance.sdk.openadsdk.zg.w.w.u e;
        if (ai.w >= 6408 && (e = f.zg().e()) != null) {
            return e.qt();
        }
        return null;
    }

    public static w xj() {
        return xj.xj;
    }

    public boolean c() {
        Map<String, Object> tf = tf();
        if (tf != null) {
            Object obj = tf.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.hf = str;
                return !TextUtils.equals(str, Constants.FAIL);
            }
        }
        return true;
    }

    public boolean f() {
        return hf(w());
    }

    public String hf() {
        Map<String, Object> tf;
        try {
            tf = tf();
        } catch (Exception e) {
            pl.xj(e);
        }
        if (tf == null) {
            w(null);
            return null;
        }
        Object obj = tf.get("motion_info");
        if (obj instanceof String) {
            if (TextUtils.equals(Constants.FAIL, (String) obj)) {
                w(Constants.FAIL);
                return Constants.FAIL;
            }
            w("1");
            return "1";
        }
        w(null);
        return null;
    }

    public boolean kd() {
        return !TextUtils.equals(hf(), Constants.FAIL);
    }

    public void u() {
        if (p()) {
            String d = d();
            if (TextUtils.equals(d, this.xj)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.live.hf.xj().xj("setOaidEnabled", xj(d));
            this.xj = d;
        }
    }

    public String w() {
        Map<String, Object> tf = tf();
        if (tf == null) {
            return null;
        }
        Object obj = tf.get("blt");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean y() {
        if (p()) {
            return xj(d());
        }
        return true;
    }

    private w() {
    }

    private boolean xj(String str) {
        return !TextUtils.equals(str, Constants.FAIL);
    }

    private void w(String str) {
        if (!TextUtils.equals(this.w, str)) {
            com.bytedance.sdk.openadsdk.core.live.hf.xj().xj("setSensorEnable", !TextUtils.equals(str, Constants.FAIL));
        }
        this.w = str;
    }

    private boolean hf(String str) {
        return !TextUtils.equals(str, Constants.FAIL);
    }
}
