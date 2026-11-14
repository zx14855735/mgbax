package com.bytedance.sdk.component.d;

import com.bytedance.sdk.component.hf.xj.p;
import java.io.File;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    p c;
    private final boolean d;
    final String hf;
    final long kd;
    final String u;
    final Map<String, String> w;
    final int xj;
    final long y;
    private File f = null;
    private byte[] tf = null;

    public hf(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.d = z;
        this.xj = i;
        this.hf = str;
        this.w = map;
        this.u = str2;
        this.kd = j;
        this.y = j2;
    }

    public File c() {
        return this.f;
    }

    public long d() {
        return this.kd - this.y;
    }

    public boolean f() {
        return this.d;
    }

    public String hf() {
        return this.hf;
    }

    public long kd() {
        return this.kd;
    }

    public p p() {
        return this.c;
    }

    public byte[] tf() {
        return this.tf;
    }

    public String u() {
        return this.u;
    }

    public Map<String, String> w() {
        return this.w;
    }

    public int xj() {
        return this.xj;
    }

    public long y() {
        return this.y;
    }

    public void xj(File file) {
        this.f = file;
    }

    public void xj(byte[] bArr) {
        this.tf = bArr;
    }

    public void xj(p pVar) {
        this.c = pVar;
    }
}
