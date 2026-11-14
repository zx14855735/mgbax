package com.kwad.sdk.export.proxy;

import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdHttpResponseHelper {
    public static void notifyResponseEnd(final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            @Override // java.lang.Runnable
            public void run() {
                AdHttpResponseListener.this.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(AdHttpResponseListener adHttpResponseListener, long j, long j2) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j, j2);
    }

    public static void notifyResponseStart(final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            @Override // java.lang.Runnable
            public void run() {
                AdHttpResponseListener.this.onResponseStart();
            }
        });
    }
}
