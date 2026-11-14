package com.bytedance.sdk.openadsdk.core.pl.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface u {
    c hf();

    void hf(String str);

    boolean hf(DownloadModel downloadModel, DownloadInfo downloadInfo);

    boolean w();

    AlertDialog xj(Activity activity, boolean z, xj xjVar);

    String xj(boolean z);

    JSONObject xj();

    void xj(int i, String str, Map<String, Object> map, kd kdVar);

    void xj(Activity activity, String[] strArr, y yVar);

    void xj(f fVar, boolean z);

    void xj(String str, byte[] bArr, String str2, kd kdVar);

    void xj(WeakReference<Context> weakReference, boolean z, xj xjVar);

    void xj(JSONObject jSONObject, String str);

    boolean xj(Context context, String str);

    boolean xj(DownloadModel downloadModel);

    boolean xj(DownloadModel downloadModel, DownloadInfo downloadInfo);

    boolean xj(String str);
}
