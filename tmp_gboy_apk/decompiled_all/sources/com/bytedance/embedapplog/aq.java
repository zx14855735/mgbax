package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class aq {
    private static final String[] y = {"channel", "package", com.sigmob.sdk.base.n.r};
    private final SharedPreferences c;
    private final Context hf;
    private final wn w;
    private boolean xj;
    private final ArrayList<n> kd = new ArrayList<>(32);
    private int f = 0;
    private JSONObject u = new JSONObject();

    static {
        UJQwuqp();
    }

    public aq(Context context, wn wnVar) {
        this.hf = context;
        this.w = wnVar;
        this.c = wnVar.kd();
        if (xj.hf) {
            zm.xj(context);
        }
    }

    private static /* synthetic */ void UJQwuqp() {
        char[] charArray = "!-/l%#/'l -;l1*'..l\b,+\u00000+&%'".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'B');
        }
        String str = new String(charArray);
        char[] charArray2 = "!.+,+6".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'B');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private JSONObject qt() {
        return this.u;
    }

    public String am() {
        return qt().optString("ab_sdk_version", "");
    }

    public String c() {
        return qt().optString("device_id", "");
    }

    public String d() {
        return qt().optString("install_id", "");
    }

    public String f() {
        return qt().optString("aid", "");
    }

    public long g() {
        return qt().optLong("register_time", 0L);
    }

    public int hf() {
        int optInt = this.xj ? qt().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && optInt == -1; i++) {
            y();
            optInt = this.xj ? qt().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public void kd() {
        try {
            new bl(this.hf, this.w).xj(this.u);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w("od", "e:" + e.getMessage(), e);
        }
    }

    public String p() {
        return qt().optString("user_unique_id", "");
    }

    public int pl() {
        String optString = qt().optString("device_id", "");
        qt().optString("install_id", "");
        if (hf(optString)) {
            return this.c.getInt("version_code", 0) == qt().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public String tf() {
        return qt().optString("ssid", "");
    }

    public void u() {
        a.y().d();
    }

    public String w() {
        String optString = this.xj ? qt().optString(com.sigmob.sdk.base.n.r, null) : null;
        for (int i = 0; i < 3 && optString == null; i++) {
            y();
            optString = this.xj ? qt().optString(com.sigmob.sdk.base.n.r, null) : null;
        }
        return optString;
    }

    public JSONObject xj() {
        if (this.xj) {
            return qt();
        }
        return null;
    }

    public boolean y() {
        synchronized (this.kd) {
            try {
                if (this.kd.size() == 0) {
                    this.kd.add(new yy(this.hf, this.w));
                    this.kd.add(new vm(this.hf));
                    this.kd.add(new dc(this.hf, this.w));
                    this.kd.add(new tu(this.hf));
                    this.kd.add(new s(this.hf));
                    this.kd.add(new dq(this.hf, this.w));
                    this.kd.add(new qd(this.hf));
                    this.kd.add(new lw(this.hf, this.w));
                    this.kd.add(new wa(this.hf, this.w));
                    this.kd.add(new gh());
                    this.kd.add(new op(this.w));
                    this.kd.add(new gy(this.hf));
                    this.kd.add(new nb(this.hf));
                    this.kd.add(new ss(this.hf, this.w));
                    this.kd.add(new eu(this.hf, this.w));
                    this.kd.add(new bl(this.hf, this.w));
                    this.kd.add(new hl(this.hf, this.w));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        JSONObject qt = qt();
        JSONObject jSONObject = new JSONObject();
        no.hf(jSONObject, qt);
        Iterator<n> it = this.kd.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (!next.xj || next.w || xj(next)) {
                try {
                    next.xj = next.xj(jSONObject);
                } catch (SecurityException e) {
                    if (!next.hf) {
                        i++;
                        cu.hf("loadHeader, " + this.f, e);
                        if (!next.xj && this.f > 10) {
                            next.xj = true;
                        }
                    }
                } catch (JSONException e2) {
                    cu.hf(e2);
                }
                if (!next.xj && !next.hf) {
                    i2++;
                }
            }
            z &= next.xj || next.hf;
        }
        if (z) {
            int length = y.length;
            for (int i3 = 0; i3 < length; i3++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(r7[i3]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.u = jSONObject;
        this.xj = z;
        if (cu.hf) {
            cu.xj("loadHeader, " + this.xj + ", " + this.f + ", " + this.u.toString(), null);
        } else {
            cu.u("loadHeader, " + this.xj + ", " + this.f, null);
        }
        if (i > 0 && i == i2) {
            this.f++;
            if (pl() != 0) {
                this.f += 10;
            }
        }
        if (this.xj) {
            xj.pl().xj(c(), d(), tf());
        }
        return this.xj;
    }

    public <T> T xj(String str, T t) {
        T t2;
        JSONObject qt = qt();
        if (qt == null || (t2 = (T) qt.opt(str)) == null) {
            t2 = null;
        }
        return t2 == null ? t : t2;
    }

    private synchronized void hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            cu.hf("null abconfig", null);
            return;
        }
        String optString = qt().optString("ab_version");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(",");
            HashSet hashSet = new HashSet();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> keys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString(PointParamKey.VID));
                        } catch (JSONException e) {
                            cu.hf(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            hf("ab_version", xj(hashSet));
        }
    }

    private boolean xj(n nVar) {
        boolean z = !this.w.yo() && nVar.u;
        if (cu.hf) {
            cu.xj("needSyncFromSub " + nVar + " " + z, null);
        }
        return z;
    }

    public void xj(JSONObject jSONObject) {
        this.w.w(jSONObject);
        hf(jSONObject);
    }

    private String xj(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void xj(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = qt().optJSONObject(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                cu.hf(e);
            }
        }
        if (hf(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject)) {
            this.w.hf(jSONObject);
        }
    }

    public static void xj(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private boolean hf(String str, Object obj) {
        boolean z;
        Object opt = qt().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.u;
                    JSONObject jSONObject2 = new JSONObject();
                    no.hf(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.u = jSONObject2;
                } catch (JSONException e) {
                    cu.hf(e);
                }
            }
            z = true;
        }
        cu.xj("updateHeader, " + str + ", " + opt + ", " + obj, null);
        return z;
    }

    public static boolean xj(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean xj(org.json.JSONObject r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r5 = r21
            r7 = r22
            r9 = r23
            java.lang.String r2 = "register_time"
            java.lang.String r3 = "ssid"
            java.lang.String r4 = "install_id"
            java.lang.String r6 = ""
            java.lang.String r8 = "device_id"
            java.lang.String r10 = "version_code"
            boolean r11 = com.bytedance.embedapplog.cu.hf
            if (r11 == 0) goto L33
            java.lang.String r11 = "saveRegisterInfo, "
            java.lang.String r12 = ", "
            java.lang.StringBuilder r11 = J3FDQU.A2egSU.BChYOn(r11, r5, r12, r7, r12)
            r11.append(r9)
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r12 = 0
            com.bytedance.embedapplog.cu.xj(r11, r12)
        L33:
            boolean r11 = hf(r5)
            boolean r12 = hf(r7)
            r14 = 0
            boolean r15 = hf(r9)     // Catch: org.json.JSONException -> Ldb
            r16 = 1
            android.content.SharedPreferences r13 = r1.c     // Catch: org.json.JSONException -> Ld7
            int r13 = r13.getInt(r10, r14)     // Catch: org.json.JSONException -> Ld7
            r17 = r11
            org.json.JSONObject r11 = r1.qt()     // Catch: org.json.JSONException -> Ld3
            int r11 = r11.optInt(r10, r14)     // Catch: org.json.JSONException -> Ld3
            r18 = 0
            android.content.SharedPreferences r14 = r1.c     // Catch: org.json.JSONException -> L60
            android.content.SharedPreferences$Editor r14 = r14.edit()     // Catch: org.json.JSONException -> L60
            if (r13 == r11) goto L63
            r14.putInt(r10, r11)     // Catch: org.json.JSONException -> L60
            goto L63
        L60:
            r0 = move-exception
            goto Le1
        L63:
            if (r17 == 0) goto L74
            long r10 = java.lang.System.currentTimeMillis()     // Catch: org.json.JSONException -> L60
            r14.putLong(r2, r10)     // Catch: org.json.JSONException -> L60
            java.lang.Long r0 = java.lang.Long.valueOf(r10)     // Catch: org.json.JSONException -> L60
            r1.hf(r2, r0)     // Catch: org.json.JSONException -> L60
            goto L85
        L74:
            if (r17 != 0) goto L85
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L60
            r2.<init>()     // Catch: org.json.JSONException -> L60
            java.lang.String r10 = "response"
            r2.put(r10, r0)     // Catch: org.json.JSONException -> L60
            java.lang.String r0 = "tt_fetch_did_error"
            com.bytedance.embedapplog.xj.xj(r0, r2)     // Catch: org.json.JSONException -> L60
        L85:
            org.json.JSONObject r0 = r1.qt()     // Catch: org.json.JSONException -> L60
            java.lang.String r0 = r0.optString(r8, r6)     // Catch: org.json.JSONException -> L60
            if (r17 == 0) goto L9a
            boolean r2 = r1.hf(r8, r5)     // Catch: org.json.JSONException -> L60
            if (r2 == 0) goto L9a
            r14.putString(r8, r5)     // Catch: org.json.JSONException -> L60
            r2 = 1
            goto L9b
        L9a:
            r2 = 0
        L9b:
            org.json.JSONObject r8 = r1.qt()     // Catch: org.json.JSONException -> L60
            java.lang.String r8 = r8.optString(r4, r6)     // Catch: org.json.JSONException -> L60
            if (r12 == 0) goto Laf
            boolean r10 = r1.hf(r4, r7)     // Catch: org.json.JSONException -> L60
            if (r10 == 0) goto Laf
            r14.putString(r4, r7)     // Catch: org.json.JSONException -> L60
            r2 = 1
        Laf:
            org.json.JSONObject r4 = r1.qt()     // Catch: org.json.JSONException -> L60
            java.lang.String r4 = r4.optString(r3, r6)     // Catch: org.json.JSONException -> L60
            if (r15 == 0) goto Lc4
            boolean r6 = r1.hf(r3, r9)     // Catch: org.json.JSONException -> L60
            if (r6 == 0) goto Lc4
            r14.putString(r3, r9)     // Catch: org.json.JSONException -> L60
            r3 = 1
            goto Lc5
        Lc4:
            r3 = r2
        Lc5:
            com.bytedance.embedapplog.w r2 = com.bytedance.embedapplog.xj.pl()     // Catch: org.json.JSONException -> L60
            r6 = r8
            r8 = r4
            r4 = r0
            r2.xj(r3, r4, r5, r6, r7, r8, r9)     // Catch: org.json.JSONException -> L60
            r14.apply()     // Catch: org.json.JSONException -> L60
            goto Le4
        Ld3:
            r0 = move-exception
        Ld4:
            r18 = 0
            goto Le1
        Ld7:
            r0 = move-exception
            r17 = r11
            goto Ld4
        Ldb:
            r0 = move-exception
            r17 = r11
            r16 = 1
            goto Ld4
        Le1:
            com.bytedance.embedapplog.cu.hf(r0)
        Le4:
            if (r17 == 0) goto Le9
            if (r12 == 0) goto Le9
            return r16
        Le9:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.aq.xj(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean hf(String str) {
        if (!TextUtils.isEmpty(str) && !MediationConfigUserInfoForSegment.GENDER_UNKNOWN.equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    return true;
                }
            }
        }
        return false;
    }
}
