package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.wo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface g {
    boolean am(int i);

    boolean c();

    boolean c(int i);

    List<com.ss.android.socialbase.downloader.model.hf> d(int i);

    io e(int i);

    DownloadInfo f(int i);

    int g(int i);

    DownloadInfo hf(String str, String str2);

    List<DownloadInfo> hf(String str);

    void hf(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z);

    void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list);

    void hf(int i, boolean z);

    void hf(DownloadInfo downloadInfo);

    void hf(DownloadTask downloadTask);

    void hf(List<String> list);

    boolean hf();

    boolean hf(int i);

    long kd(int i);

    List<DownloadInfo> kd(String str);

    boolean kd();

    void p(int i);

    boolean pl(int i);

    void qt(int i);

    void startService();

    void tf(int i);

    List<DownloadInfo> u();

    List<DownloadInfo> u(String str);

    void u(int i);

    IDownloadFileUriProvider v(int i);

    List<DownloadInfo> w(String str);

    void w(int i);

    void w(int i, boolean z);

    boolean w();

    boolean w(DownloadInfo downloadInfo);

    int xj(String str, String str2);

    List<DownloadInfo> xj(String str);

    void xj();

    void xj(int i);

    void xj(int i, int i2);

    void xj(int i, int i2, int i3, int i4);

    void xj(int i, int i2, int i3, long j);

    void xj(int i, int i2, long j);

    void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z);

    void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z, boolean z2);

    void xj(int i, long j);

    void xj(int i, Notification notification);

    void xj(int i, io ioVar);

    void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list);

    void xj(int i, boolean z);

    void xj(wo woVar);

    void xj(DownloadTask downloadTask);

    void xj(com.ss.android.socialbase.downloader.model.hf hfVar);

    void xj(List<String> list);

    void xj(boolean z, boolean z2);

    boolean xj(DownloadInfo downloadInfo);

    int y(int i);

    void y();

    j yo(int i);

    boolean zg(int i);
}
