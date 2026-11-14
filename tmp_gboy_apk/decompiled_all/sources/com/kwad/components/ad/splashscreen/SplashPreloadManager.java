package com.kwad.components.ad.splashscreen;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> FJ;
    private List<String> FK;
    private volatile SharedPreferences FL;
    private final Object mLock;

    @KsJson
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public int materialType;
        public String preloadId;
    }

    public static class a {
        private static final SplashPreloadManager FM = new SplashPreloadManager(0);

        static {
            GmApalV();
        }

        private static /* synthetic */ void GmApalV() {
            char[] charArray = "\u0019\u0015\u0017T\u001d\u001b\u0017\u001fT\u0018\u0015\u0003T\t\u0012\u001f\u0016\u0016T0\u0014\u00138\b\u0013\u001e\u001d\u001f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'z');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0019\u0016\u0013\u0014\u0013\u000e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'z');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    public static File ad(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(str);
        if (cr == null || !cr.exists()) {
            return null;
        }
        return cr;
    }

    public static boolean i(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.be(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.FL = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.FL.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(preLoadItem.preloadId);
                            if (cr == null || !cr.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    try {
                                        this.FJ.put(str, preLoadItem);
                                        if (!this.FK.contains(str)) {
                                            this.FK.add(str);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor edit = this.FL.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    public static boolean j(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public static SplashPreloadManager lO() {
        SplashPreloadManager splashPreloadManager = a.FM;
        if (splashPreloadManager.FL == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = (adInfo.adPreloadInfo.validityPeriod * 1000) + System.currentTimeMillis();
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.ba(adInfo);
        preLoadItem.materialType = com.kwad.sdk.core.response.b.a.bd(adInfo) ? 2 : 1;
        synchronized (this.mLock) {
            try {
                this.FJ.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
                if (!this.FK.contains(adInfo.adPreloadInfo.preloadId)) {
                    this.FK.add(adInfo.adPreloadInfo.preloadId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.FL != null) {
            SharedPreferences.Editor edit = this.FL.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) && com.kwad.sdk.core.response.b.a.be(adInfo);
    }

    private boolean q(AdInfo adInfo) {
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aV(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(str);
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("check preloadId ", str, " file exists ");
            B3GDIM2.append(cr == null ? "null" : Boolean.valueOf(cr.exists()));
            com.kwad.sdk.core.d.c.d("PreloadManager", B3GDIM2.toString());
            if (cr != null && cr.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> S() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList start ");
                for (int i = 0; i < this.FK.size(); i++) {
                    String str = this.FK.get(i);
                    File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(str);
                    if (cr != null && cr.exists()) {
                        arrayList.add(str);
                    }
                }
                com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList end ");
            } catch (Throwable th) {
                throw th;
            }
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList " + this.FK.size());
        return arrayList;
    }

    public final void a(long j, int i) {
        int i2;
        int i3;
        int i4;
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        int size2 = this.FK.size();
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList();
                i3 = 0;
                i4 = 0;
                for (String str : this.FJ.keySet()) {
                    PreLoadItem preLoadItem = this.FJ.get(str);
                    if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                        arrayList.add(str);
                        int i5 = preLoadItem.materialType;
                        if (i5 == 2) {
                            i3++;
                        } else if (i5 == 1) {
                            i4++;
                        }
                    }
                }
                SharedPreferences.Editor edit = this.FL.edit();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    this.FK.remove(str2);
                    this.FJ.remove(str2);
                    edit.remove(str2);
                    com.kwad.sdk.core.diskcache.b.a.IJ().remove(str2);
                }
                edit.apply();
                size = this.FK.size();
            } finally {
            }
        }
        if (size > 30) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i6 = size - 15;
            for (i2 = 0; i2 < i6; i2++) {
                String str3 = "";
                synchronized (this.mLock) {
                    try {
                        long j2 = Long.MAX_VALUE;
                        for (PreLoadItem preLoadItem2 : this.FJ.values()) {
                            long j3 = j2;
                            long j4 = preLoadItem2.expiredTime;
                            if (j4 < j3) {
                                str3 = preLoadItem2.preloadId;
                                j2 = j4;
                            } else {
                                j2 = j3;
                            }
                        }
                        long j5 = j2;
                        if (!TextUtils.isEmpty(str3)) {
                            PreLoadItem preLoadItem3 = this.FJ.get(str3);
                            if (preLoadItem3 != null) {
                                int i7 = preLoadItem3.materialType;
                                if (i7 == 2) {
                                    i3++;
                                } else {
                                    if (i7 == 1) {
                                        i4++;
                                    }
                                    this.FK.remove(str3);
                                    this.FJ.remove(str3);
                                    this.FL.edit().remove(str3).apply();
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j5);
                                }
                            }
                            this.FK.remove(str3);
                            this.FJ.remove(str3);
                            this.FL.edit().remove(str3).apply();
                            com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j5);
                        }
                    } finally {
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.IJ().remove(str3);
                }
            }
        }
        int i8 = i3;
        List<String> lP = lP();
        int size3 = size2 - lP.size();
        List<Integer> i9 = i(lP);
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.a(j, lP, i9, i, size3, i4, i8);
    }

    public final boolean h(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    return p(adInfo) ? KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aV(adInfo).materialUrl) : q(adInfo);
                }
            }
        }
        return false;
    }

    public final List<String> lP() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean start ");
            arrayList = new ArrayList(this.FK);
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean " + this.FK.size());
        return arrayList;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.FJ = new HashMap<>();
        this.FK = new ArrayList();
        init();
    }

    public final List<Integer> i(List<String> list) {
        PreLoadItem preLoadItem;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        synchronized (this.mLock) {
            try {
                com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList start ");
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (this.FJ.containsKey(str) && (preLoadItem = this.FJ.get(str)) != null) {
                        arrayList.add(Integer.valueOf(preLoadItem.materialType));
                    }
                }
                com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList end ");
            } catch (Throwable th) {
                throw th;
            }
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList " + arrayList.size());
        return arrayList;
    }

    public final int a(AdResultData adResultData, boolean z, int i) {
        Iterator<AdInfo> it;
        String str;
        boolean a2;
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.k(adResultData);
        int i2 = 0;
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            if (adTemplate != null) {
                Iterator<AdInfo> it2 = adTemplate.adInfoList.iterator();
                while (it2.hasNext()) {
                    AdInfo next = it2.next();
                    if (next.adPreloadInfo != null && this.FL != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(next)) {
                            if (com.kwad.sdk.core.response.b.a.bd(next)) {
                                str = com.kwad.sdk.core.response.b.a.L(next);
                            } else {
                                str = com.kwad.sdk.core.response.b.a.be(next) ? com.kwad.sdk.core.response.b.a.aV(next).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String ba = com.kwad.sdk.core.response.b.a.ba(next);
                                if (next.adPreloadInfo.preloadType == 1 && !ao.isWifiConnected(ServiceProvider.getContext()) && !z) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                    it = it2;
                                } else {
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "start Download preloadId " + ba + " true url " + str);
                                    it = it2;
                                    a(adResultData.getPosId(), 1);
                                    a.C0366a c0366a = new a.C0366a();
                                    if (p(next)) {
                                        a2 = KSImageLoader.loadImageSync(str) != null;
                                    } else {
                                        a2 = k.a(str, ba, c0366a);
                                    }
                                    if (a2) {
                                        o(next);
                                        i2++;
                                        com.kwad.components.ad.splashscreen.monitor.b.mk();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - elapsedRealtime, 1, i);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.mk();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 4, c0366a.msg);
                                        com.kwad.components.core.o.a.tz().f(adTemplate, 1, c0366a.msg);
                                    }
                                }
                            } else {
                                it = it2;
                                com.kwad.components.ad.splashscreen.monitor.b.mk();
                                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            it = it2;
                            com.kwad.components.ad.splashscreen.monitor.b.mk();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - elapsedRealtime, 2, i);
                            o(next);
                            i2++;
                        }
                    } else {
                        it = it2;
                        com.kwad.components.ad.splashscreen.monitor.b.mk();
                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                    it2 = it;
                }
            }
        }
        AdTemplate adTemplate2 = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i2 > 0) {
            com.kwad.sdk.utils.k.ar("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.o.a.tz().e(adTemplate2, i2);
            return i2;
        }
        com.kwad.sdk.utils.k.ar("splashAd_", "onSplashVideoAdCacheFailed");
        return i2;
    }
}
