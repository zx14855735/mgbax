package com.bytedance.sdk.component.pl.hf.xj;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.api.xj.hf;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements hf {
    private long xj;
    private String hf = "tt_video_reward_full";
    private String w = "tt_video_brand";
    private String u = "tt_video_splash";
    private String kd = "tt_video_default";
    private String y = null;
    private String c = null;
    private String f = null;
    private String d = null;
    private String tf = null;
    private String p = null;

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String hf() {
        if (this.f == null) {
            this.f = this.p + File.separator + this.w;
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public void kd() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String u() {
        if (this.tf == null) {
            this.tf = this.p + File.separator + this.kd;
            File file = new File(this.tf);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String w() {
        if (this.d == null) {
            this.d = this.p + File.separator + this.u;
            File file = new File(this.d);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public void xj(String str) {
        if (!TextUtils.isEmpty(this.p) && !this.p.equals(str)) {
            this.y = null;
            this.c = null;
            this.f = null;
            this.d = null;
            this.tf = null;
        }
        this.p = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public long hf(u uVar) {
        return this.xj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String xj() {
        if (this.c == null) {
            this.c = this.p + File.separator + this.hf;
            File file = new File(this.c);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public boolean xj(u uVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(uVar.e(), uVar.kd());
        if (cacheInfoByFilePath != null) {
            boolean g = uVar.g();
            this.xj = cacheInfoByFilePath.mCacheSizeFromZero;
            int hf = uVar.hf() > 0 ? uVar.hf() : uVar.y();
            if (g) {
                hf = (int) uVar.pl();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= hf) {
                return true;
            }
        }
        return false;
    }
}
