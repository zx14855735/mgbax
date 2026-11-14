package com.bytedance.sdk.openadsdk.core.pl.hf;

import com.bytedance.sdk.openadsdk.core.pl.hf.hf;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements xj {
    private final ConcurrentHashMap<Integer, xj> xj = new ConcurrentHashMap<>();

    public void hf() {
        if (this.xj.isEmpty()) {
            return;
        }
        this.xj.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
    public void w(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, xj> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hf.xj().xj(next.getValue()).xj("onDownloadFailed").xj(j).hf(j2).hf(str).w(str2).xj();
            }
        }
    }

    public void xj(xj xjVar) {
        if (xjVar != null) {
            this.xj.put(Integer.valueOf(xjVar.hashCode()), xjVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
    public void xj() {
        Iterator<Map.Entry<Integer, xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, xj> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hf.xj().xj(next.getValue()).xj("onIdle").xj();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
    public void hf(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, xj> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hf.xj().xj(next.getValue()).xj("onDownloadPaused").xj(j).hf(j2).hf(str).w(str2).xj();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
    public void xj(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, xj> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hf.xj().xj(next.getValue()).xj("onDownloadActive").xj(j).hf(j2).hf(str).w(str2).xj();
            }
        }
    }

    public boolean w() {
        return this.xj.size() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
    public void xj(String str, String str2) {
        Iterator<Map.Entry<Integer, xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, xj> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().xj(str, str2);
                new hf.xj().xj(next.getValue()).xj("onInstalled").hf(str).w(str2).xj();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
    public void xj(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, xj> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new hf.xj().xj(next.getValue()).xj("onDownloadFinished").xj(j).hf(str).w(str2).xj();
            }
        }
    }
}
