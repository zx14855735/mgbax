package com.ss.android.downloadlib.addownload.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private final ConcurrentHashMap<Long, DownloadModel> hf;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.xj.hf> kd;
    private final ConcurrentHashMap<Long, DownloadController> u;
    private final ConcurrentHashMap<Long, DownloadEventConfig> w;
    private volatile boolean xj;

    public static class xj {
        private static y xj = new y();

        static {
            nwOp();
        }

        private static /* synthetic */ void nwOp() {
            char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 175);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 175);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public kd kd(long j) {
        kd kdVar = new kd();
        kdVar.xj = j;
        kdVar.hf = xj(j);
        DownloadEventConfig hf = hf(j);
        kdVar.w = hf;
        if (hf == null) {
            kdVar.w = new com.ss.android.download.api.download.w();
        }
        DownloadController w = w(j);
        kdVar.u = w;
        if (w == null) {
            kdVar.u = new com.ss.android.download.api.download.hf();
        }
        return kdVar;
    }

    public com.ss.android.downloadad.api.xj.hf u(long j) {
        return this.kd.get(Long.valueOf(j));
    }

    public DownloadController w(long j) {
        return this.u.get(Long.valueOf(j));
    }

    public void y(long j) {
        this.hf.remove(Long.valueOf(j));
        this.w.remove(Long.valueOf(j));
        this.u.remove(Long.valueOf(j));
    }

    private y() {
        this.xj = false;
        this.hf = new ConcurrentHashMap<>();
        this.w = new ConcurrentHashMap<>();
        this.u = new ConcurrentHashMap<>();
        this.kd = new ConcurrentHashMap<>();
    }

    public void hf() {
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hf.y.1
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.xj) {
                    return;
                }
                synchronized (y.class) {
                    try {
                        if (!y.this.xj) {
                            y.this.kd.putAll(d.xj().hf());
                            y.this.xj = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.xj.hf> w() {
        return this.kd;
    }

    public static y xj() {
        return xj.xj;
    }

    public DownloadEventConfig hf(long j) {
        return this.w.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.xj.hf hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.xj.hf hfVar : this.kd.values()) {
            if (hfVar != null && str.equals(hfVar.xj())) {
                return hfVar;
            }
        }
        return null;
    }

    public void xj(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.hf.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void hf(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.hf.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void xj(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.w.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void xj(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.u.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        this.kd.put(Long.valueOf(hfVar.hf()), hfVar);
        d.xj().xj(hfVar);
    }

    public DownloadModel xj(long j) {
        return this.hf.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.xj.hf xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.xj.hf hfVar : this.kd.values()) {
            if (hfVar != null && str.equals(hfVar.kd())) {
                return hfVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.xj.hf xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.xj.hf hfVar : this.kd.values()) {
            if (hfVar != null && hfVar.v() == downloadInfo.getId()) {
                return hfVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long xj2 = g.xj(new JSONObject(downloadInfo.getExtra()), BaseConstants.EVENT_LABEL_EXTRA);
                if (xj2 != 0) {
                    for (com.ss.android.downloadad.api.xj.hf hfVar2 : this.kd.values()) {
                        if (hfVar2 != null && hfVar2.hf() == xj2) {
                            return hfVar2;
                        }
                    }
                    com.ss.android.downloadlib.kd.w.xj().xj("getNativeModelByInfo");
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        for (com.ss.android.downloadad.api.xj.hf hfVar3 : this.kd.values()) {
            if (hfVar3 != null && TextUtils.equals(hfVar3.xj(), downloadInfo.getUrl())) {
                return hfVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.xj.hf xj(int i) {
        for (com.ss.android.downloadad.api.xj.hf hfVar : this.kd.values()) {
            if (hfVar != null && hfVar.v() == i) {
                return hfVar;
            }
        }
        return null;
    }

    public Map<Long, com.ss.android.downloadad.api.xj.hf> xj(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.xj.hf hfVar : this.kd.values()) {
                if (hfVar != null && TextUtils.equals(hfVar.xj(), str)) {
                    hfVar.hf(str2);
                    hashMap.put(Long.valueOf(hfVar.hf()), hfVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void xj(List<Long> list) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Long l : list) {
                arrayList.add(String.valueOf(l.longValue()));
                this.kd.remove(l);
            }
            d.xj().xj((List<String>) arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }
}
