package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.volley.toolbox.FileDownloader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static FileDownloader f13159a;

    public static FileDownloader a() {
        if (f13159a == null) {
            synchronized (s.class) {
                try {
                    SigmobRequestQueue downloadRequestQueue = Networking.getDownloadRequestQueue();
                    if (f13159a == null && downloadRequestQueue != null) {
                        f13159a = new FileDownloader(downloadRequestQueue, 3);
                    }
                } finally {
                }
            }
        }
        return f13159a;
    }
}
