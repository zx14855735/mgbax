package com.bytedance.sdk.openadsdk.core.q;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.q.xj.hf;
import com.bytedance.sdk.openadsdk.core.q.xj.w;
import com.bytedance.sdk.openadsdk.core.w.u;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static xj xj = new xj();
    private volatile int hf = -1;
    private volatile long w = 0;
    private volatile long u = 0;

    static {
        upxjZ();
    }

    private xj() {
    }

    private static /* synthetic */ void upxjZ() {
        char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '.');
        }
        String str = new String(charArray);
        char[] charArray2 = "MBG@GZ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '.');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj() {
        return xj;
    }

    public long hf() {
        return this.w;
    }

    public boolean kd() {
        return this.hf == 0 || this.hf == 3;
    }

    public void u() {
        JSONObject vl = pz.hf().vl();
        if (vl == null) {
            this.hf = 1;
        }
        if (xj(vl)) {
            new w().xj(vl, this.hf);
        } else if (hf(vl)) {
            new hf().xj(vl, this.hf);
        } else {
            this.hf = 1;
        }
    }

    public long w() {
        return this.u;
    }

    public int y() {
        if (!f.zg().kd()) {
            return 0;
        }
        if (this.hf == -1) {
            int jk = u.xj().jk();
            if (jk != -1) {
                this.hf = jk;
            } else if (pz.hf().vl() == null) {
                this.hf = 1;
            } else {
                this.hf = 2;
            }
        }
        return this.hf;
    }

    public boolean hf(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("callback")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (xj(optJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void xj(long j, long j2) {
        this.w = j;
        this.u = j2;
    }

    public boolean xj(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public void xj(int i) {
        if (this.hf != i) {
            u.xj().y(i);
        }
        this.hf = i;
    }

    public boolean xj(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("register")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (xj(optJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
