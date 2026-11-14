package com.bytedance.msdk.w.c.xj;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.w.f.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj {
    @Override // com.bytedance.msdk.w.c.xj.xj
    public boolean xj(com.bytedance.msdk.w.y.xj.hf hfVar, com.bytedance.msdk.hf.w wVar, List<tf> list) {
        if (wVar == null || hfVar == null) {
            return false;
        }
        if (hfVar.g().y(c.xj(hfVar.pl(), wVar)) == 0) {
            return true;
        }
        return xj(wVar, list);
    }

    public boolean xj(com.bytedance.msdk.hf.w wVar, List<tf> list) {
        if (wVar == null || TextUtils.isEmpty(wVar.cy()) || !wVar.cu() || q.xj(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !q.hf(arrayList) && wVar.cy().equals(((tf) arrayList.get(0)).yo());
    }
}
