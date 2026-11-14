package com.bytedance.sdk.component.y.xj;

import com.bytedance.sdk.component.y.pl;
import com.bytedance.sdk.component.y.yo;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static yo xj() {
        return new yo() { // from class: com.bytedance.sdk.component.y.xj.hf.1
            private WeakHashMap<String, String> xj = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.y.yo
            public String hf(pl plVar) {
                return xj(plVar.getUrl());
            }

            @Override // com.bytedance.sdk.component.y.yo
            public String xj(pl plVar) {
                return xj(plVar.getUrl() + "#width=" + plVar.getWidth() + "#height=" + plVar.getHeight() + "#scaletype=" + plVar.getScaleType() + "#bitmapConfig=" + plVar.getBitmapConfig());
            }

            private String xj(String str) {
                String str2 = this.xj.get(str);
                if (str2 != null) {
                    return str2;
                }
                String xj = com.bytedance.sdk.component.y.w.w.w.xj(str);
                this.xj.put(str, xj);
                return xj;
            }
        };
    }
}
