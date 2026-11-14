package com.bytedance.adsdk.ugeno.kd;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements f {
    @Override // com.bytedance.adsdk.ugeno.kd.f
    public List<c> xj() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c("slide") { // from class: com.bytedance.adsdk.ugeno.kd.xj.1
            @Override // com.bytedance.adsdk.ugeno.kd.c
            public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                return new com.bytedance.adsdk.ugeno.kd.w.u(context);
            }
        });
        arrayList.add(new c("tap") { // from class: com.bytedance.adsdk.ugeno.kd.xj.2
            @Override // com.bytedance.adsdk.ugeno.kd.c
            public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                return new com.bytedance.adsdk.ugeno.kd.w.kd(context);
            }
        });
        arrayList.add(new c("timer") { // from class: com.bytedance.adsdk.ugeno.kd.xj.3
            @Override // com.bytedance.adsdk.ugeno.kd.c
            public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                return new com.bytedance.adsdk.ugeno.kd.w.y(context);
            }
        });
        arrayList.add(new c("touchStart") { // from class: com.bytedance.adsdk.ugeno.kd.xj.4
            @Override // com.bytedance.adsdk.ugeno.kd.c
            public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                return new com.bytedance.adsdk.ugeno.kd.w.f(context);
            }
        });
        arrayList.add(new c("touchEnd") { // from class: com.bytedance.adsdk.ugeno.kd.xj.5
            @Override // com.bytedance.adsdk.ugeno.kd.c
            public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                return new com.bytedance.adsdk.ugeno.kd.w.c(context);
            }
        });
        arrayList.add(new c("animateState") { // from class: com.bytedance.adsdk.ugeno.kd.xj.6
            @Override // com.bytedance.adsdk.ugeno.kd.c
            public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                return new com.bytedance.adsdk.ugeno.kd.w.xj(context);
            }
        });
        return arrayList;
    }
}
