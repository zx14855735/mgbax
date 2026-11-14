package com.bytedance.sdk.component.c.w;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.c.hf, com.bytedance.sdk.component.c.xj {
    private final boolean hf = false;
    private final com.bytedance.sdk.component.u.hf.xj xj;

    public xj(com.bytedance.sdk.component.u.hf.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bytedance.sdk.component.c.xj
    public Map<String, Object> xj(File file) {
        if (file.getName().endsWith(".prop")) {
            return new hf(this.xj, this.hf).xj(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        return (!file2.exists() || file2.length() <= 0) ? file.getName().endsWith("xml") ? kd.xj() ? new kd(this.xj, this.hf).xj(file) : new y(this.xj, this.hf).xj(file) : new ConcurrentHashMap() : new hf(this.xj, this.hf).xj(file2);
    }

    @Override // com.bytedance.sdk.component.c.hf
    public void xj(Map<String, Object> map, File file) {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new hf(this.xj, this.hf).xj(map, file);
    }
}
