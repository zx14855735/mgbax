package com.bytedance.sdk.openadsdk.core.dk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ht.am;
import java.lang.reflect.Method;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    static HashSet<String> xj = new HashSet<>();

    static {
        ZzEb();
    }

    private static /* synthetic */ void ZzEb() {
        char[] charArray = "/#!b+-!)b.#5b?$)  b\u0006\"%\u000e>%(+)".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'L');
        }
        String str = new String(charArray);
        char[] charArray2 = "/ %\"%8".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'L');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(final String str) {
        if (TextUtils.isEmpty(str) || !xj.contains(str)) {
            return;
        }
        xj.remove(str);
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.dk.xj.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("union_key", str);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("listener_process_but_not_register").hf(jSONObject.toString());
            }
        }, "listener_process_but_not_register");
    }

    public static void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xj.add(str);
    }
}
