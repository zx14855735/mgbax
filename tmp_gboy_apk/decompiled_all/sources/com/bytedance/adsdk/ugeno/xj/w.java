package com.bytedance.adsdk.ugeno.xj;

import ADYaiT.CtFAbx;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private String c;
    private int d = 1;
    private String f;
    private long hf;
    private long kd;
    private JSONObject tf;
    private String u;
    private int w;
    private Map<String, TreeMap<Float, String>> xj;
    private xj y;

    public static class xj {
        public String hf;
        public String xj;
    }

    public xj c() {
        return this.y;
    }

    public String d() {
        return this.f;
    }

    public String f() {
        return this.c;
    }

    public Map<String, TreeMap<Float, String>> hf() {
        return this.xj;
    }

    public String kd() {
        return this.u;
    }

    public int tf() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AnimationModel{mKeyFramesMap=");
        sb.append(this.xj);
        sb.append(", mDuration=");
        sb.append(this.hf);
        sb.append(", mPlayCount=");
        sb.append(this.w);
        sb.append(", mPlayDirection=");
        sb.append(this.u);
        sb.append(", mDelay=");
        sb.append(this.kd);
        sb.append(", mName=");
        sb.append(this.f);
        sb.append(", mPlayState=");
        sb.append(this.d);
        sb.append(", mTransformOrigin='");
        sb.append(this.y);
        sb.append("', mTimingFunction='");
        return CtFAbx.B25kr6(sb, this.c, "'}");
    }

    public int u() {
        return this.w;
    }

    public long w() {
        return this.hf;
    }

    public JSONObject xj() {
        return this.tf;
    }

    public long y() {
        return this.kd;
    }

    public void hf(long j) {
        this.kd = j;
    }

    public void w(String str) {
        this.f = str;
    }

    public void xj(JSONObject jSONObject) {
        this.tf = jSONObject;
    }

    public void hf(String str) {
        this.c = str;
    }

    public void xj(Map<String, TreeMap<Float, String>> map) {
        this.xj = map;
    }

    public void hf(int i) {
        this.d = i;
    }

    public void xj(long j) {
        this.hf = j;
    }

    public void xj(int i) {
        this.w = i;
    }

    public void xj(String str) {
        this.u = str;
    }

    public void xj(xj xjVar) {
        this.y = xjVar;
    }
}
