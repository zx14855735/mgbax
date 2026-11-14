package com.bytedance.sdk.component.y.u;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends xj {
    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        List<com.bytedance.sdk.component.y.w.w> list;
        String zg = wVar.zg();
        Map<String, List<com.bytedance.sdk.component.y.w.w>> c = wVar.pl().c();
        synchronized (c) {
            try {
                list = c.get(zg);
                if (list == null) {
                    list = new LinkedList<>();
                }
            } finally {
            }
        }
        synchronized (list) {
            try {
                list.add(wVar);
                c.put(zg, list);
                if (list.size() <= 1) {
                    wVar.xj(new u());
                }
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "check_duplicate";
    }
}
