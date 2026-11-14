package com.bykv.vk.openvk.component.video.xj.hf.kd;

import com.bykv.vk.openvk.component.video.xj.hf.d;
import com.bytedance.sdk.component.hf.xj.zg;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends xj {
    private zg w;

    public y(zg zgVar, kd kdVar) {
        com.bytedance.sdk.component.hf.xj.y c;
        this.w = zgVar;
        this.xj = new ArrayList();
        if (zgVar != null && (c = zgVar.c()) != null) {
            for (int i = 0; i < c.xj(); i++) {
                this.xj.add(new d.hf(c.xj(i), c.hf(i)));
            }
        }
        this.hf = kdVar;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public boolean hf() {
        return this.w.w() >= 200 && this.w.w() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public String kd() {
        zg zgVar = this.w;
        return (zgVar == null || zgVar.f() == null) ? "http/1.1" : this.w.f().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public InputStream u() {
        return this.w.y().w();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public List<d.hf> w() {
        return this.xj;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public int xj() {
        return this.w.w();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public String y() {
        return xj(this.w.w());
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.xj
    public String xj(String str, String str2) {
        return xj(str) != null ? xj(str).hf : str2;
    }
}
