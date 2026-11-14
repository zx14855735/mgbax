package com.yxcorp.kuaishou.addfp.android.a;

import android.os.Build;
import android.text.TextUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private static boolean d = true;
    private static int e;

    /* renamed from: a, reason: collision with root package name */
    private String f13876a;
    private String b;
    private ReentrantLock c;

    private c() {
        this.b = "";
        this.c = new ReentrantLock();
    }

    public static c c() {
        return b.f13875a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f13876a) ? this.f13876a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    public void b(String str) {
        this.f13876a = str;
    }

    public static String b() {
        try {
            if (!d) {
                return "KWE_NPN";
            }
            if (e == 0) {
                int i = Build.VERSION.SDK_INT;
                boolean z = true;
                if (i < 33) {
                    boolean z2 = false;
                    if (i >= 29) {
                        String str = Build.MODEL;
                        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                            z2 = true;
                        }
                        if (!Build.BRAND.equalsIgnoreCase("HONOR")) {
                            z = z2;
                        }
                    } else {
                        z = false;
                    }
                }
                if (!z) {
                    String gSer = Orange.getInstance().gSer();
                    if (!TextUtils.isEmpty(gSer) && !gSer.startsWith("KWE")) {
                        return gSer;
                    }
                }
            }
            return !TextUtils.isEmpty("") ? "" : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(85:9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|29)|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(3:44|45|(1:47))|48|49|50|51|52|53|54|55|56|57|58|59|(3:60|61|62)|(3:63|64|65)|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|(1:130)(4:95|(3:97|98|99)(1:129)|100|101)|102|103|104|105|(4:108|(2:110|111)(1:113)|112|106)|114|115|116|117|(1:119)|120|121) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02f9, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x020e, code lost:
    
        r5 = "KWE_PE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01e8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01ec, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01ef, code lost:
    
        if (r15 != null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01f4, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01f1, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x032a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x032b, code lost:
    
        if (r15 != null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0330, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x032d, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01ea, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01eb, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b0 A[Catch: all -> 0x02d0, TryCatch #9 {all -> 0x02d0, blocks: (B:105:0x02a6, B:108:0x02b0, B:110:0x02c4, B:112:0x02d2, B:115:0x02d5), top: B:104:0x02a6, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x026c A[Catch: all -> 0x002c, TryCatch #7 {all -> 0x002c, blocks: (B:3:0x0017, B:5:0x0024, B:9:0x002f, B:11:0x0036, B:13:0x0045, B:15:0x005a, B:17:0x0067, B:19:0x0075, B:21:0x0083, B:23:0x008c, B:25:0x0099, B:30:0x00b7, B:32:0x00d3, B:34:0x00dc, B:36:0x00e9, B:38:0x00f6, B:40:0x0103, B:42:0x0118, B:48:0x013e, B:50:0x014b, B:54:0x0166, B:56:0x016f, B:58:0x0182, B:66:0x01b4, B:74:0x01e4, B:75:0x01f6, B:79:0x020f, B:81:0x0218, B:83:0x0229, B:85:0x0232, B:87:0x0250, B:89:0x025d, B:91:0x026c, B:93:0x0272, B:95:0x027a, B:97:0x0280, B:99:0x0286, B:101:0x0297, B:103:0x029f, B:116:0x02fc, B:125:0x02f9, B:128:0x0291, B:142:0x01f1, B:150:0x032d, B:148:0x0330, B:163:0x0162, B:166:0x013a, B:169:0x00b2, B:53:0x0154, B:138:0x01ec, B:105:0x02a6, B:108:0x02b0, B:110:0x02c4, B:112:0x02d2, B:115:0x02d5, B:28:0x00a6, B:45:0x0121), top: B:2:0x0017, inners: #0, #4, #9, #11, #14, #15 }] */
    /* JADX WARN: Type inference failed for: r16v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.Context r23, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    d = false;
                }
                if ("64_level".equals(next)) {
                    e = jSONObject.optInt(next, 0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
