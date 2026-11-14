package com.bytedance.sdk.openadsdk.core.et.xj;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.u;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private byte[] hf;
    private Map<String, String> kd;
    private List<Object> u;
    private Bitmap w;
    int xj;

    public hf(byte[] bArr, int i) {
        this.w = null;
        this.u = null;
        this.kd = null;
        this.hf = bArr;
        this.xj = i;
    }

    public int hf() {
        return this.xj;
    }

    public boolean kd() {
        byte[] bArr = this.hf;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public boolean u() {
        if (this.w != null) {
            return true;
        }
        byte[] bArr = this.hf;
        return bArr != null && bArr.length > 0;
    }

    public byte[] w() {
        try {
            if (this.hf == null) {
                this.hf = u.hf(this.w);
            }
        } catch (OutOfMemoryError e) {
            pl.xj(e);
        }
        return this.hf;
    }

    public Bitmap xj() {
        return this.w;
    }

    public hf(Bitmap bitmap, int i) {
        this.hf = null;
        this.u = null;
        this.kd = null;
        this.w = bitmap;
        this.xj = i;
    }
}
