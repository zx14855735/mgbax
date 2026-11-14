package com.fl.saas.videocache;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class VideoPreLoadModel {
    public Map<String, String> header;
    public String originalUrl;
    public int preLoadBytes;

    public VideoPreLoadModel(int i, String str) {
        this(i, str, new HashMap());
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public int getPreLoadBytes() {
        return this.preLoadBytes;
    }

    public void setHeader(Map<String, String> map) {
        this.header = map;
    }

    public void setOriginalUrl(String str) {
        this.originalUrl = str;
    }

    public void setPreLoadBytes(int i) {
        this.preLoadBytes = i;
    }

    public VideoPreLoadModel(int i, String str, Map<String, String> map) {
        this.preLoadBytes = i;
        this.originalUrl = str;
        this.header = map;
    }
}
