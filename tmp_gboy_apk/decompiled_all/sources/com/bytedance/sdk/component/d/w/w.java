package com.bytedance.sdk.component.d.w;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public boolean xj = false;
    public boolean hf = true;
    public Map<String, Integer> w = null;
    public Map<String, String> u = null;
    public int kd = 10;
    public int y = 1;
    public int c = 1;
    public int f = 10;
    public int d = 1;
    public int tf = 1;
    public int p = AVMDLDataLoader.KeyIsMaxIpCountEachDomain;

    /* renamed from: pl, reason: collision with root package name */
    public int f10201pl = AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT;
    public String g = null;
    public int am = 0;
    public long qt = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.xj);
        sb.append(" probeEnable: ");
        sb.append(this.hf);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.w;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.u;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.kd);
        sb.append("#");
        sb.append(this.y);
        sb.append("#");
        sb.append(this.c);
        sb.append(" reqErr: ");
        sb.append(this.f);
        sb.append("#");
        sb.append(this.d);
        sb.append("#");
        sb.append(this.tf);
        sb.append(" updateInterval: ");
        sb.append(this.p);
        sb.append(" updateRandom: ");
        sb.append(this.f10201pl);
        sb.append(" httpBlack: ");
        sb.append(this.g);
        return sb.toString();
    }
}
