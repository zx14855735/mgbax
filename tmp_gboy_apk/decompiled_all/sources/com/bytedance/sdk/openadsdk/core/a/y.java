package com.bytedance.sdk.openadsdk.core.a;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.am;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static com.bytedance.sdk.openadsdk.core.am hf;
    private static final Map<String, xj> xj = A2egSU.BIYEnU();

    public interface xj {
        void onDialogBtnNo();

        void onDialogBtnYes();

        void onDialogCancel();
    }

    static {
        wcqI();
    }

    public static xj kd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj.remove(str);
    }

    public static void u(com.bytedance.sdk.openadsdk.core.ra.ws wsVar, Context context, String str) {
        int yo = com.bytedance.sdk.openadsdk.core.ra.jk.yo(wsVar);
        if (wsVar == null || context == null) {
            return;
        }
        if (wsVar.vw() == 4 || yo != 0) {
            com.bytedance.sdk.openadsdk.core.pl.hf.w xj2 = com.bytedance.sdk.openadsdk.core.pl.f.xj(context, wsVar, str, false);
            if (xj2 instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                ((com.bytedance.sdk.openadsdk.core.pl.w.kd) xj2).f().xj(false);
            }
            xj2.xj(wsVar, false);
        }
    }

    public static void w(final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, final Context context, final String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        xj(context, wsVar.ho(), wsVar.he(), new xj() { // from class: com.bytedance.sdk.openadsdk.core.a.y.5
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                y.u(com.bytedance.sdk.openadsdk.core.ra.ws.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        });
    }

    private static /* synthetic */ void wcqI() {
        char[] charArray = "W[Y\u001aSUYQ\u001aV[M\u001aG\\QXX\u001a~Z]vF]PSQ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '4');
        }
        String str = new String(charArray);
        char[] charArray2 = "WX]Z]@".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '4');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, final Context context, final String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        xj(context, wsVar.ho(), new xj() { // from class: com.bytedance.sdk.openadsdk.core.a.y.4
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                y.u(com.bytedance.sdk.openadsdk.core.ra.ws.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        }, wsVar.he());
    }

    public static void xj(Context context, String str, String str2, String str3, xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        xj(str, xjVar);
        TTDelegateActivity.xj(context, str, str2, str3);
    }

    public static void w(String str) {
        xj(str, 2);
    }

    public static void hf(Context context, String str, String str2, xj xjVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        xj(str2, xjVar);
        TTDelegateActivity.w(context, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.am w() {
        if (hf == null) {
            hf = am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(com.bytedance.sdk.openadsdk.core.pz.getContext()).xj(2));
        }
        return hf;
    }

    public static void xj(final Context context, final String str, final String str2, final String str3, final xj xjVar, final com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar, final com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.y.1
            @Override // java.lang.Runnable
            public void run() {
                boolean xj2 = com.bytedance.sdk.openadsdk.core.f.zg().xj(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                    if (y.xj.containsKey(str)) {
                        return;
                    }
                    if (!wo.u() && !xj2) {
                        return;
                    }
                }
                y.xj(str, xjVar);
                TTDelegateActivity.xj(context, str, str2, str3, cVar, wsVar);
            }
        });
    }

    public static void u(String str) {
        xj(str, 3);
    }

    public static void hf(String str) {
        xj(str, 1);
    }

    public static void xj(final Context context, final String str, final String str2, final String str3, final xj xjVar, final com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.y.2
            @Override // java.lang.Runnable
            public void run() {
                boolean xj2 = com.bytedance.sdk.openadsdk.core.f.zg().xj(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                    if (y.xj.containsKey(str)) {
                        return;
                    }
                    if (!wo.u() && !xj2) {
                        return;
                    }
                }
                y.xj(str, xjVar);
                TTDelegateActivity.xj(context, str, str2, str3, wsVar);
            }
        });
    }

    public static void xj(String str) {
        Map<String, xj> map = xj;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void xj(Context context, String str, xj xjVar, String str2, com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        xj(str, xjVar);
        TTDelegateActivity.xj(context, str, str2, wsVar);
    }

    public static void xj(final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, final Context context, final String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        xj(context, wsVar.ho(), new xj() { // from class: com.bytedance.sdk.openadsdk.core.a.y.3
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                y.u(com.bytedance.sdk.openadsdk.core.ra.ws.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        }, wsVar.he(), wsVar);
    }

    public static void xj(Context context, String str, xj xjVar, String str2) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        xj(str, xjVar);
        TTDelegateActivity.hf(context, str, str2);
    }

    public static void xj(Context context, String str, String str2, xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        xj(str, xjVar);
        TTDelegateActivity.xj(context, str, str2);
    }

    public static void xj(final Context context, final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, final String str) {
        if (wsVar == null) {
            return;
        }
        String ho = wsVar.ho();
        if (TextUtils.isEmpty(ho)) {
            return;
        }
        xj(ho, new xj() { // from class: com.bytedance.sdk.openadsdk.core.a.y.6
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                y.u(com.bytedance.sdk.openadsdk.core.ra.ws.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        });
        com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar.ut();
        if (ut == null) {
            return;
        }
        TTDelegateActivity.w(context, ho, ut.d());
    }

    public static void xj(Context context, String str) {
        TTDelegateActivity.xj(context, str);
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(str);
    }

    public static void xj(Context context, String str, String str2, String str3, String str4, String str5, xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        xj(str, xjVar);
        TTDelegateActivity.xj(context, str, str2, str3, str4, str5);
    }

    public static void xj(Context context, String str, boolean z, xj xjVar) {
        if (z) {
            TTDelegateActivity.xj(context, str, z);
        } else {
            if (TextUtils.isEmpty(str) || xjVar == null) {
                return;
            }
            xj(str, xjVar);
            TTDelegateActivity.xj(context, str, z);
        }
    }

    public static void xj(final String str, final xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.core.a.y.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        y.w().xj(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.xj(xjVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            xj.put(str, xjVar);
        }
    }

    private static void xj(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("doHandler") { // from class: com.bytedance.sdk.openadsdk.core.a.y.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        y.w().xj(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        xj kd = kd(str);
        if (kd == null) {
            return;
        }
        if (i == 1) {
            kd.onDialogBtnYes();
            return;
        }
        if (i == 2) {
            kd.onDialogBtnNo();
        } else if (i != 3) {
            kd.onDialogCancel();
        } else {
            kd.onDialogCancel();
        }
    }

    public static void xj(Context context, String str, com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        TTDelegateActivity.xj(context, str, wsVar);
    }

    public static void xj(Context context, final com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return;
        }
        new xj.C0138xj().kd(wsVar.ho()).xj("pangle_logo").hf("open_policy").u(wsVar.jf()).xj(new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.y.9
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", com.bytedance.sdk.openadsdk.core.ra.ws.this.og());
                jSONObject2.put("ad_slot_type", wo.f(com.bytedance.sdk.openadsdk.core.ra.ws.this));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
        TTDelegateActivity.hf(context, wsVar.og());
    }

    public static boolean xj(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null || wsVar.ta() || wsVar.kc() == null || com.bytedance.sdk.openadsdk.core.ra.jk.g(wsVar) == 1 || wsVar.vw() != 4 || com.bytedance.sdk.openadsdk.core.ra.jk.pl(wsVar) == 0) {
            return false;
        }
        int yo = wsVar.yo();
        return yo == 4 || yo == 5;
    }
}
