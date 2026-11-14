package com.bytedance.sdk.component.p.w;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum hf {
    INSTANCE;

    private Map<String, w> hf = new HashMap();

    static {
        pVBY();
    }

    hf() {
    }

    private static /* synthetic */ void pVBY() {
        char[] charArray = "§«©ê£¥©¡ê¦«½ê·¬¡¨¨ê\u008eª\u00ad\u0086¶\u00ad £¡".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 196);
        }
        String str = new String(charArray);
        char[] charArray2 = "§¨\u00adª\u00ad°".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 196);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public w xj(String str) {
        return this.hf.get(str);
    }

    public void xj(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = keys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                w wVar = new w(jSONObject2);
                this.hf.put(wVar.hf(), wVar);
            } catch (JSONException unused) {
            }
        }
    }
}
