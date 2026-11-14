package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo {
    private boolean xj = false;
    private final Set<Object> hf = new xj();
    private final Map<String, com.bytedance.adsdk.lottie.kd.c> w = new HashMap();
    private final Comparator<Pair<String, Float>> u = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.yo.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public void xj(boolean z) {
        this.xj = z;
    }

    public void xj(String str, float f) {
        if (this.xj) {
            com.bytedance.adsdk.lottie.kd.c cVar = this.w.get(str);
            if (cVar == null) {
                cVar = new com.bytedance.adsdk.lottie.kd.c();
                this.w.put(str, cVar);
            }
            cVar.xj(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.hf.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
