package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface c {
    void f();

    c hf(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    c hf(Context context);

    c hf(DownloadController downloadController);

    c hf(DownloadEventConfig downloadEventConfig);

    c hf(DownloadModel downloadModel);

    void hf(int i);

    boolean hf();

    long u();

    c xj(long j);

    c xj(IDownloadButtonClickListener iDownloadButtonClickListener);

    c xj(OnItemClickListener onItemClickListener);

    c xj(String str);

    void xj();

    void xj(boolean z);

    boolean xj(int i);
}
