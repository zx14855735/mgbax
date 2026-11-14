package com.bykv.vk.openvk.component.video.xj.hf.xj;

import android.content.Context;
import com.bykv.vk.openvk.component.video.xj.hf.kd;
import com.bykv.vk.openvk.component.video.xj.hf.u;
import com.bytedance.sdk.component.tf.d;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends xj {
    public final File xj;

    public void hf() {
        u.w().u();
        Context context = kd.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.xj.hf.hf.w.xj(context).xj(1);
        }
        for (File file : this.xj.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    public File kd(String str) {
        return new File(this.xj, str);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.xj
    public File u(String str) {
        return kd(str);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.xj.xj
    public File w(String str) {
        return kd(str);
    }

    public void xj() {
        com.bykv.vk.openvk.component.video.xj.w.xj.xj(new d("clear") { // from class: com.bykv.vk.openvk.component.video.xj.hf.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                hf.this.hf();
            }
        });
    }
}
