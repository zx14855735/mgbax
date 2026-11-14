package com.bytedance.pangle.util.hf.hf;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private List<w> xj = new ArrayList();

    public List<w> xj() {
        return this.xj;
    }

    public void xj(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (w wVar : this.xj) {
            if (!set.contains(wVar.pl())) {
                arrayList.add(wVar);
            }
        }
        this.xj = arrayList;
    }

    public void xj(List<w> list) {
        this.xj = list;
    }
}
