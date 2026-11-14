package com.ss.android.downloadlib.addownload.w;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static volatile u xj;
    private long hf = 0;
    private ConcurrentHashMap<String, kd> w = new ConcurrentHashMap<>();
    private HashMap<String, Integer> u = new HashMap<>();
    private List<String> kd = new CopyOnWriteArrayList();

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public long hf() {
        return this.hf;
    }

    public void w() {
        this.hf = System.currentTimeMillis();
    }

    public int hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.u == null) {
            this.u = new HashMap<>();
        }
        if (this.u.containsKey(str)) {
            return this.u.get(str).intValue();
        }
        return 0;
    }

    public void xj(String str, kd kdVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.w.put(str, kdVar);
    }

    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.w.remove(str);
    }

    public static void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        DownloadInfo downloadInfo;
        if (hfVar == null || hfVar.hf() <= 0 || (downloadInfo = Downloader.getInstance(pl.getContext()).getDownloadInfo(hfVar.v())) == null) {
            return;
        }
        xj(downloadInfo);
    }

    public static void xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
