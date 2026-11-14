package com.bytedance.sdk.component.adexpress.dynamic.u;

import com.bytedance.sdk.component.adexpress.dynamic.u.hf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {
    public static float xj(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<hf.xj> xj(float f, List<hf.xj> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<hf.xj> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((hf.xj) it.next().clone());
        }
        Iterator it2 = arrayList.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it2.hasNext()) {
            hf.xj xjVar = (hf.xj) it2.next();
            if (xjVar.hf) {
                i = (int) (i + xjVar.xj);
            } else {
                i2 = (int) (i2 + xjVar.xj);
                z = false;
            }
        }
        if (!z || f <= i) {
            float f2 = i;
            float f3 = f < f2 ? f / f2 : 1.0f;
            float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
            if (f4 > 1.0f) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                boolean z2 = false;
                while (it3.hasNext()) {
                    hf.xj xjVar2 = (hf.xj) it3.next();
                    if (!xjVar2.hf) {
                        float f5 = xjVar2.w;
                        if (f5 != 0.0f && xjVar2.xj * f4 > f5) {
                            xjVar2.xj = f5;
                            xjVar2.hf = true;
                            z2 = true;
                        }
                    }
                    arrayList2.add(xjVar2);
                }
                if (z2) {
                    return xj(f, arrayList2);
                }
            }
            Iterator it4 = arrayList.iterator();
            int i3 = 0;
            while (it4.hasNext()) {
                hf.xj xjVar3 = (hf.xj) it4.next();
                if (xjVar3.hf) {
                    xjVar3.xj = xj(xjVar3.xj * f3);
                } else {
                    xjVar3.xj = xj(xjVar3.xj * f4);
                }
                i3 = (int) (i3 + xjVar3.xj);
            }
            float f6 = i3;
            if (f6 < f) {
                float f7 = f - f6;
                for (int i4 = 0; i4 < arrayList.size() && f7 > 0.0f; i4 = (i4 + 1) % arrayList.size()) {
                    hf.xj xjVar4 = (hf.xj) arrayList.get(i4);
                    if ((f < f2 && xjVar4.hf) || (f > f2 && !xjVar4.hf)) {
                        xjVar4.xj += 0.0625f;
                        f7 -= 0.0625f;
                    }
                }
            }
        }
        return arrayList;
    }
}
