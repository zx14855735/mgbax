package com.bytedance.adsdk.ugeno.kd.hf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.adsdk.ugeno.kd.y;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends xj {
    public kd(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
        super(wVar, str, xjVar);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.hf.xj
    public void xj() {
        Map<String, String> map = this.y;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.y.get(f.f13353a);
        if (TextUtils.isEmpty(str)) {
            xj(this.w);
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w wVar = this.w;
        com.bytedance.adsdk.ugeno.hf.w hf = wVar.hf(wVar);
        if (hf == null) {
            return;
        }
        xj(hf.u(str));
    }

    private void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (wVar == null) {
            return;
        }
        for (String str : this.y.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.f13353a)) {
                wVar.xj(str, this.y.get(str));
            }
        }
        wVar.xj(this.y.containsKey(MediaFormat.KEY_WIDTH), this.y.containsKey(MediaFormat.KEY_HEIGHT));
        wVar.hf();
    }
}
