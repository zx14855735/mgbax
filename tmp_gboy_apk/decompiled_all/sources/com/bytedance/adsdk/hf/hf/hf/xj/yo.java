package com.bytedance.adsdk.hf.hf.hf.xj;

import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo extends e {
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.hf.hf.hf.xj.yo.1
        @Override // java.lang.ThreadLocal
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    static {
        QiHBSjl();
    }

    public yo() {
        super(com.bytedance.adsdk.hf.hf.u.w.PLUS);
    }

    private static /* synthetic */ void QiHBSjl() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        Object xj;
        Object xj2 = this.xj.xj(map);
        if (xj2 == null || (xj = this.hf.xj(map)) == null) {
            return null;
        }
        if (!(xj2 instanceof String) && !(xj instanceof String)) {
            return com.bytedance.adsdk.hf.hf.kd.xj.f.xj((Number) xj2, (Number) xj);
        }
        StringBuilder sb = u.get();
        sb.append(xj2);
        sb.append(xj);
        String sb2 = sb.toString();
        sb.setLength(0);
        return sb2;
    }
}
