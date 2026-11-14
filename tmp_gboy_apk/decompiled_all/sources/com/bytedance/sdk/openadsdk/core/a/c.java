package com.bytedance.sdk.openadsdk.core.a;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.am;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private static com.bytedance.sdk.openadsdk.core.am hf;
    private static final Map<String, xj> xj = A2egSU.BIYEnU();

    public interface xj {
        void onDenied(String str);

        void onGranted();
    }

    static {
        HGwkYCu();
    }

    private static /* synthetic */ void HGwkYCu() {
        char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '2');
        }
        String str = new String(charArray);
        char[] charArray2 = "Q^[\\[F".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '2');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static xj hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj.remove(str);
    }

    public static void xj(String str, String[] strArr, xj xjVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        xj(str, xjVar);
        TTDelegateActivity.xj(str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.am hf() {
        if (hf == null) {
            hf = am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(com.bytedance.sdk.openadsdk.core.pz.getContext()).xj(4));
        }
        return hf;
    }

    public static void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.component.tf.c.w().execute(new com.bytedance.sdk.component.tf.d("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.hf().hf(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        xj hf2 = hf(str);
        if (hf2 == null) {
            return;
        }
        hf2.onGranted();
    }

    public static void xj(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.component.tf.c.w().execute(new com.bytedance.sdk.component.tf.d("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.hf().hf(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        xj hf2 = hf(str);
        if (hf2 == null) {
            return;
        }
        hf2.onDenied(str2);
    }

    private static void xj(final String str, final xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("addListener") { // from class: com.bytedance.sdk.openadsdk.core.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.pl.u("MultiProcess", "getListenerManager().registerPermissionListener...");
                        c.hf().xj(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.hf(xjVar));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.pl.xj(th);
                        com.bytedance.sdk.component.utils.pl.u("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            xj.put(str, xjVar);
        }
    }
}
