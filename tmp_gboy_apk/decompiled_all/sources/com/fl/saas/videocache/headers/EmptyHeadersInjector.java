package com.fl.saas.videocache.headers;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EmptyHeadersInjector implements HeaderInjector {
    @Override // com.fl.saas.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String str) {
        return new HashMap();
    }
}
