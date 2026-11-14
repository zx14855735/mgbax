package com.bytedance.sdk.openadsdk.core.kd.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.kd.u.y;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements hf {
    private static final com.bytedance.sdk.component.u.hf.w xj = j.xj("open_ad_sdk_meta_cache_kv");

    /* renamed from: com.bytedance.sdk.openadsdk.core.kd.u.u$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[y.xj.hf.values().length];
            xj = iArr;
            try {
                iArr[y.xj.hf.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[y.xj.hf.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        tSMk();
    }

    private static /* synthetic */ void tSMk() {
        char[] charArray = ", \"a(.\"*a- 6a<'*##a\u0005!&\r=&+(*".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'O');
        }
        String str = new String(charArray);
        char[] charArray2 = ",#&!&;".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'O');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String w(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Constants.FAIL;
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void hf(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            xj xj2 = xj.xj((String) it.next());
            xj2.w = false;
            copyOnWriteArraySet2.add(xj2.toString());
        }
        xj.put(w(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, y.hf hfVar, boolean z, long j, y.xj xjVar, com.bytedance.sdk.openadsdk.core.kd.u.xj xjVar2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        if (xjVar.w() <= 0) {
            return;
        }
        if (xjVar.w() > 0 && copyOnWriteArraySet.size() >= xjVar.w()) {
            Iterator it = copyOnWriteArraySet.iterator();
            xj xjVar3 = null;
            long j2 = 0;
            String str2 = null;
            while (it.hasNext()) {
                String str3 = (String) it.next();
                xj xj2 = xj.xj(str3);
                if (str2 == null || j2 < xj2.xj) {
                    j2 = xj2.xj;
                    str2 = str3;
                    xjVar3 = xj2;
                }
            }
            if (xjVar3 != null) {
                xjVar2.xj(new y.hf(xjVar3.u, xjVar3.xj, xjVar3.hf, xjVar3.y));
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new xj(hfVar.w, hfVar.xj, hfVar.hf, z, hfVar.kd, j).toString());
        xj.put(w(str), copyOnWriteArraySet);
    }

    public static class xj {
        long c;
        long hf;
        int kd;
        String u;
        boolean w;
        long xj;
        String y;

        public xj(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this.xj = j;
            this.hf = j2;
            this.w = z;
            this.u = str;
            this.y = str2;
            this.c = j3;
            this.kd = i;
        }

        public static xj xj(String str) {
            String str2;
            long j;
            long j2;
            boolean z;
            int i;
            String str3;
            String str4;
            boolean z2;
            int i2;
            JSONObject jSONObject;
            String str5 = "";
            long j3 = 0;
            try {
                jSONObject = new JSONObject(str);
                j = jSONObject.optLong("create_time", 0L);
                try {
                    j2 = jSONObject.optLong("expire_time", 0L);
                } catch (JSONException unused) {
                    str2 = "";
                    j2 = 0;
                }
            } catch (JSONException unused2) {
                str2 = "";
                j = 0;
                j2 = 0;
            }
            try {
                boolean optBoolean = jSONObject.optBoolean("is_using", false);
                try {
                    String optString = jSONObject.optString("material_data", "");
                    try {
                        int optInt = jSONObject.optInt("save_version", 0);
                        try {
                            str5 = jSONObject.optString("uuid", "");
                            j3 = jSONObject.optLong("priority", 0L);
                            str4 = str5;
                            z2 = optBoolean;
                            i2 = optInt;
                            str3 = optString;
                        } catch (JSONException unused3) {
                            i = optInt;
                            z = optBoolean;
                            str2 = str5;
                            str5 = optString;
                            str3 = str5;
                            str4 = str2;
                            z2 = z;
                            i2 = i;
                            return new xj(str3, j, j2, z2, str4, j3, i2);
                        }
                    } catch (JSONException unused4) {
                        z = optBoolean;
                        i = 0;
                    }
                } catch (JSONException unused5) {
                    z = optBoolean;
                    i = 0;
                    str2 = "";
                }
            } catch (JSONException unused6) {
                str2 = "";
                z = true;
                i = 0;
                str3 = str5;
                str4 = str2;
                z2 = z;
                i2 = i;
                return new xj(str3, j, j2, z2, str4, j3, i2);
            }
            return new xj(str3, j, j2, z2, str4, j3, i2);
        }

        public boolean hf(y.xj xjVar) {
            if (System.currentTimeMillis() <= this.hf && !TextUtils.isEmpty(this.u)) {
                return xjVar.hf() && 7132 != this.kd;
            }
            return true;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.xj);
                jSONObject.put("expire_time", this.hf);
                jSONObject.put("is_using", this.w);
                jSONObject.put("material_data", this.u);
                jSONObject.put("save_version", this.kd);
                jSONObject.put("uuid", this.y);
                jSONObject.put("priority", this.c);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }

        public xj(String str, long j, long j2, boolean z, String str2, long j3) {
            this(str, j, j2, z, str2, j3, 7132);
        }

        public boolean xj(y.xj xjVar) {
            return (hf(xjVar) || this.w) ? false : true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public y.hf xj(String str, y.xj xjVar, long j) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        return xj(copyOnWriteArraySet, xjVar, j, (List<String>) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public y.hf xj(String str, y.xj xjVar, long j, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        return xj(copyOnWriteArraySet, xjVar, j, list);
    }

    private y.hf xj(CopyOnWriteArraySet<String> copyOnWriteArraySet, y.xj xjVar, long j, List<String> list) {
        Iterator<String> it = copyOnWriteArraySet.iterator();
        xj xjVar2 = null;
        while (it.hasNext()) {
            xj xj2 = xj.xj(it.next());
            if (xj2.xj(xjVar)) {
                String str = xj2.y;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || xj2.xj >= j) {
                        int i = AnonymousClass1.xj[xjVar.u().ordinal()];
                        if (i == 1) {
                            if (xjVar2 != null && xjVar2.xj >= xj2.xj) {
                            }
                            xjVar2 = xj2;
                        } else {
                            if (i != 2) {
                                return new y.hf(xj2.u, xj2.xj, xj2.hf, xj2.y);
                            }
                            if (xjVar2 != null && xjVar2.c >= xj2.c) {
                            }
                            xjVar2 = xj2;
                        }
                    }
                }
            }
        }
        if (xjVar2 != null) {
            return new y.hf(xjVar2.u, xjVar2.xj, xjVar2.hf, xjVar2.y);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str) {
        xj.remove(w(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(y.xj xjVar) {
        xj.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, y.xj xjVar, com.bytedance.sdk.openadsdk.core.kd.u.xj xjVar2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            xj xj2 = xj.xj((String) it.next());
            if (!xj2.hf(xjVar)) {
                copyOnWriteArraySet2.add(xj2.toString());
            } else if (xjVar2 != null) {
                xjVar2.xj(new y.hf(xj2.u, xj2.xj, xj2.hf, xj2.y));
            }
        }
        xj.put(w(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, String str2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (!TextUtils.equals(xj.xj(str3).y, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        xj.put(w(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, String str2, boolean z) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(xj.get(w(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            xj xj2 = xj.xj(str3);
            if (TextUtils.equals(xj2.y, str2)) {
                xj2.w = z;
                copyOnWriteArraySet2.add(xj2.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        xj.put(w(str), copyOnWriteArraySet2);
    }
}
