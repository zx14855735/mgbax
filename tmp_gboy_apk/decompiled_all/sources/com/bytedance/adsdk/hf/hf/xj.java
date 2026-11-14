package com.bytedance.adsdk.hf.hf;

import com.bytedance.adsdk.hf.hf.w.xj.c;
import com.bytedance.adsdk.hf.hf.w.xj.d;
import com.bytedance.adsdk.hf.hf.w.xj.f;
import com.bytedance.adsdk.hf.hf.w.xj.hf;
import com.bytedance.adsdk.hf.hf.w.xj.kd;
import com.bytedance.adsdk.hf.hf.w.xj.tf;
import com.bytedance.adsdk.hf.hf.w.xj.u;
import com.bytedance.adsdk.hf.hf.w.xj.w;
import com.bytedance.adsdk.hf.hf.w.xj.y;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final com.bytedance.adsdk.hf.hf.w.xj xj;
    private final com.bytedance.adsdk.hf.hf.w.xj hf;
    private String kd;
    private Deque<com.bytedance.adsdk.hf.hf.hf.xj> u = new LinkedList();
    private com.bytedance.adsdk.hf.hf.hf.xj w;

    static {
        int i = 8;
        y[] yVarArr = {new tf(), new u(), new d(), new hf(), new kd(), new com.bytedance.adsdk.hf.hf.w.xj.xj(), new c(), new w(), new f()};
        final com.bytedance.adsdk.hf.hf.w.xj xjVar = new com.bytedance.adsdk.hf.hf.w.xj() { // from class: com.bytedance.adsdk.hf.hf.xj.1
            @Override // com.bytedance.adsdk.hf.hf.w.xj
            public int xj(String str, int i2, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final y yVar = yVarArr[i];
            i--;
            xjVar = new com.bytedance.adsdk.hf.hf.w.xj() { // from class: com.bytedance.adsdk.hf.hf.xj.2
                @Override // com.bytedance.adsdk.hf.hf.w.xj
                public int xj(String str, int i2, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque) {
                    return y.this.xj(str, i2, deque, xjVar);
                }
            };
        }
        xj = xjVar;
        tpGmbfw();
    }

    private xj(String str, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        this.hf = xjVar;
        this.kd = str;
        try {
            xj();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.hf.xj.hf(str, e);
        }
    }

    private static /* synthetic */ void tpGmbfw() {
        char[] charArray = " ¬®í¤¢®¦í¡¬ºí°«¦¯¯í\u0089\u00adª\u0081±ª§¤¦".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 195);
        }
        String str = new String(charArray);
        char[] charArray2 = " ¯ª\u00adª·".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 195);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj(String str) {
        return new xj(str, xj);
    }

    private void xj() {
        int length = this.kd.length();
        int i = 0;
        while (i < length) {
            int xj2 = this.hf.xj(this.kd, i, this.u);
            if (xj2 == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.kd.substring(0, i));
            }
            i = xj2;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.hf.hf.hf.xj pollFirst = this.u.pollFirst();
            if (pollFirst == null) {
                this.w = com.bytedance.adsdk.hf.hf.kd.hf.xj(arrayList, this.kd, i);
                this.u = null;
                return;
            }
            arrayList.add(0, pollFirst);
        }
    }

    public <T> T xj(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("default_key", jSONObject);
        return (T) xj(hashMap);
    }

    public <T> T xj(Map<String, JSONObject> map) {
        return (T) this.w.xj(map);
    }
}
