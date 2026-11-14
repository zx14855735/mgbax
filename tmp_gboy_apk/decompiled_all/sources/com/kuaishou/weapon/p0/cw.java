package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f12254a;

    public cw(Context context) {
        this.f12254a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:10|(2:11|12)|(45:14|15|16|17|18|19|20|21|(1:23)|25|26|(1:28)|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|(3:58|(1:60)|61)|63|64|(1:66)|68|69|(1:71)|73)|97|98|20|21|(0)|25|26|(0)|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|(0)|63|64|(0)|68|69|(0)|73) */
    /* JADX WARN: Can't wrap try/catch for region: R(45:10|11|12|(45:14|15|16|17|18|19|20|21|(1:23)|25|26|(1:28)|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|(3:58|(1:60)|61)|63|64|(1:66)|68|69|(1:71)|73)|97|98|20|21|(0)|25|26|(0)|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|(0)|63|64|(0)|68|69|(0)|73) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0335, code lost:
    
        r13 = com.kuaishou.weapon.p0.t.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0338, code lost:
    
        r13 = com.kuaishou.weapon.p0.t.b;
        r10 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x033d, code lost:
    
        r13 = com.kuaishou.weapon.p0.t.b;
        r10 = r19;
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x028e, code lost:
    
        r18 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0344, code lost:
    
        r18 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0103 A[Catch: Exception -> 0x012a, TRY_LEAVE, TryCatch #3 {Exception -> 0x012a, blocks: (B:21:0x00f4, B:23:0x0103), top: B:20:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x013e A[Catch: Exception -> 0x0201, TRY_LEAVE, TryCatch #16 {Exception -> 0x0201, blocks: (B:26:0x012a, B:28:0x013e), top: B:25:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03e2 A[Catch: Exception -> 0x0447, TryCatch #13 {Exception -> 0x0447, blocks: (B:56:0x03d3, B:58:0x03e2, B:60:0x040e, B:61:0x0444), top: B:55:0x03d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0458 A[Catch: Exception -> 0x0489, TRY_LEAVE, TryCatch #4 {Exception -> 0x0489, blocks: (B:64:0x0447, B:66:0x0458), top: B:63:0x0447 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x049a A[Catch: Exception -> 0x04dd, TRY_LEAVE, TryCatch #11 {Exception -> 0x04dd, blocks: (B:69:0x0489, B:71:0x049a), top: B:68:0x0489 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.kuaishou.weapon.p0.y b(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cw.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String a2 = new bn(this.f12254a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                y b = b(a2);
                if (b != null) {
                    df.a(this.f12254a).a(str, b);
                } else {
                    df.a(this.f12254a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = cu.f12252a + cu.d;
            String a2 = cv.a(this.f12254a);
            if (!TextUtils.isEmpty(a2)) {
                str = str + "?" + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject b = cv.b(this.f12254a);
            if (b != null) {
                jSONObject.put(PointParamKey.DATA, new bn(this.f12254a).c(b.toString()));
            }
            l a3 = l.a(this.f12254a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cw.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cw.this.a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
