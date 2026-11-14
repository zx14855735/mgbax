package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.os.AsyncTask;
import com.baidu.mobads.sdk.internal.bn;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.AdCache;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.videocache.h;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13129a = "h";
    private static com.sigmob.sdk.videocache.h i;
    private static volatile ImageManager k;
    private static BaseAdUnit l;
    private static BaseAdUnit m;
    private static ab o;
    private String v;
    private String w;
    private static final Integer c = 0;
    private static final Integer d = 1;
    private static final Integer e = 2;
    private static final Integer f = 3;
    private static h g = null;
    private static final Map<String, BaseAdUnit> h = new HashMap();
    private static final HashMap<String, Integer> j = new HashMap<>();
    private static final HashMap<String, List<BaseAdUnit>> n = new HashMap<>();
    private static final HashMap<String, BidResponse> q = new HashMap<>();
    private static final HashMap<String, Integer> s = new HashMap<>();
    private static final Map<String, List<BaseAdUnit>> A = new HashMap();
    private final Map<String, String> p = new HashMap();
    private final HashSet<a> r = new HashSet<>();
    final FileDownloadRequest.FileDownloadListener b = new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.1
        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void downloadProgress(DownloadItem downloadItem, long j2, long j3) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onCancel(DownloadItem downloadItem) {
            h.j.put(Md5Util.md5(downloadItem.url), h.f);
            Iterator it = h.this.r.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit a2 = aVar.a();
                if (a2 != null && downloadItem.type == DownloadItem.FileType.FILE && a2.getEndCardZipPath().equals(downloadItem.filePath)) {
                    aVar.b(a2);
                }
            }
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onErrorResponse(DownloadItem downloadItem) {
            SigmobLog.e("onErrorResponse: ", downloadItem.error);
            h.j.put(Md5Util.md5(downloadItem.url), h.f);
            Iterator it = h.this.r.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit a2 = aVar.a();
                if (a2 != null && a2.getEndCardZipPath().equals(downloadItem.filePath) && downloadItem.type == DownloadItem.FileType.FILE) {
                    aVar.b(a2);
                }
            }
            h.this.new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onSuccess(DownloadItem downloadItem) {
            h.j.put(Md5Util.md5(downloadItem.url), h.f);
            Iterator it = h.this.r.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit a2 = aVar.a();
                if (a2 != null && downloadItem.type == DownloadItem.FileType.FILE && a2.getEndCardZipPath().equals(downloadItem.filePath)) {
                    aVar.a(a2);
                }
            }
            h.this.new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }
    };
    private final ArrayList<BaseAdUnit> t = new ArrayList<>();
    private final HashMap<String, AdCache> u = new HashMap<>();
    private final HashMap<String, b> x = new HashMap<>();
    private final HashMap<String, AdCache> y = new HashMap<>();
    private final Map<String, AdCache> z = new HashMap();

    public interface a {
        BaseAdUnit a();

        void a(BaseAdUnit baseAdUnit);

        void b(BaseAdUnit baseAdUnit);
    }

    public interface b {
        void a(BaseAdUnit baseAdUnit);

        void a(BaseAdUnit baseAdUnit, String str);
    }

    public class c extends AsyncTask<Object, Void, String> {
        private final DownloadItem b;

        public c(DownloadItem downloadItem) {
            this.b = downloadItem;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Object... objArr) {
            WindAdError windAdError;
            String message;
            DownloadItem downloadItem = this.b;
            if (downloadItem != null) {
                VolleyError volleyError = downloadItem.error;
                if (volleyError != null) {
                    return volleyError.toString();
                }
                String str = downloadItem.filePath;
                String extensionName = FileUtil.getExtensionName(str);
                String fileMd5 = Md5Util.fileMd5(str);
                if (!com.sigmob.sdk.base.utils.o.b(this.b.md5) || this.b.md5.equalsIgnoreCase(fileMd5)) {
                    if (this.b.type == DownloadItem.FileType.VIDEO) {
                        h.this.p.put(str, fileMd5);
                        this.b.status = 1;
                    } else if (com.sigmob.sdk.base.utils.o.b(extensionName) && extensionName.equalsIgnoreCase("tgz")) {
                        try {
                            com.sigmob.sdk.base.utils.f.a(new File(str), new File(str.replace(".tgz", "/")));
                            this.b.status = 1;
                        } catch (Throwable th) {
                            this.b.status = 0;
                            message = th.getMessage();
                        }
                    } else {
                        DownloadItem downloadItem2 = this.b;
                        if (downloadItem2.type == DownloadItem.FileType.MRAID_VIDEO) {
                            return null;
                        }
                        downloadItem2.status = 0;
                        windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                    }
                    return null;
                }
                this.b.status = 0;
                windAdError = WindAdError.ERROR_SIGMOB_FILE_MD5;
                return windAdError.toString();
            }
            message = "doInBackground: item is null.";
            SigmobLog.e(message);
            windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            return windAdError.toString();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            DownloadItem downloadItem;
            DownloadItem.FileType fileType;
            super.onPostExecute(str);
            if (com.sigmob.sdk.base.utils.o.b(str)) {
                FileUtil.deleteFile(this.b.filePath);
            }
            Iterator it = new CopyOnWriteArrayList(h.this.t).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                b bVar = (b) h.this.x.get(baseAdUnit.getUuid());
                if (this.b.type == DownloadItem.FileType.VIDEO && baseAdUnit.getVideoPath().equals(this.b.filePath)) {
                    downloadItem = this.b;
                } else {
                    if ((this.b.type != DownloadItem.FileType.FILE || !baseAdUnit.getEndCardZipPath().equals(this.b.filePath)) && (fileType = (downloadItem = this.b).type) != DownloadItem.FileType.ZIP_FILE) {
                        if (fileType == DownloadItem.FileType.MRAID_VIDEO) {
                        }
                    }
                    h.this.a(baseAdUnit, str, bVar);
                }
                ae.a(downloadItem, baseAdUnit, str, false);
                h.this.a(baseAdUnit, str, bVar);
            }
        }
    }

    static {
        ugTIdZ();
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(BaseAdUnit baseAdUnit, BaseAdUnit baseAdUnit2) {
        return -com.sigmob.sdk.base.utils.d.a(baseAdUnit.getBidEcpm() > 0 ? baseAdUnit.getBidEcpm() : baseAdUnit.getBP(), baseAdUnit2.getBidEcpm() > 0 ? baseAdUnit2.getBidEcpm() : baseAdUnit2.getBP());
    }

    public static BaseAdUnit c(String str) {
        return h.get(str);
    }

    public static synchronized com.sigmob.sdk.videocache.h d() {
        com.sigmob.sdk.videocache.h hVar;
        synchronized (h.class) {
            try {
                if (i == null) {
                    e();
                }
                hVar = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public static List<BaseAdUnit> e(String str) {
        return A.get(str);
    }

    public static BaseAdUnit f() {
        return l;
    }

    public static synchronized h g() {
        h hVar;
        synchronized (h.class) {
            try {
                if (g == null) {
                    g = new h();
                }
                hVar = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public static Integer h(String str) {
        if (com.sigmob.sdk.base.utils.o.b(str)) {
            HashMap<String, Integer> hashMap = s;
            if (hashMap.containsKey(str)) {
                return hashMap.get(str);
            }
        }
        return 1;
    }

    public static void i() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.k.b()), com.sigmob.sdk.base.o.a().w() + com.sigmob.sdk.base.o.a().B());
            if (clearCacheFileByCount == null) {
                str = "splash ad file list is null.";
            } else {
                str = "splash ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static void j() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.k.f()), com.sigmob.sdk.base.o.a().B());
            if (clearCacheFileByCount == null) {
                str = "native ad file list is null.";
            } else {
                str = "native ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th) {
            SigmobLog.e("clean native ad file error", th);
        }
    }

    private String l(String str) {
        File c2;
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || (c2 = d().c(str)) == null || !c2.exists()) {
            return null;
        }
        return c2.getAbsolutePath();
    }

    public static BaseAdUnit m() {
        return m;
    }

    private static void t() {
        try {
            File f2 = com.sigmob.sdk.base.utils.k.f(com.sigmob.sdk.base.utils.k.c);
            if (f2 == null) {
                return;
            }
            for (File file : FileUtil.orderByDate(f2.getAbsolutePath())) {
                long currentTimeMillis = System.currentTimeMillis() - com.sigmob.sdk.base.o.a().A();
                if (file.exists() && currentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static /* synthetic */ void ugTIdZ() {
        char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ ' ');
        }
        String str = new String(charArray);
        char[] charArray2 = "CLINIT".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ ' ');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String k(String str) {
        return this.p.get(str);
    }

    public String n() {
        return this.v;
    }

    public String o() {
        return this.w;
    }

    public static synchronized ImageManager a() {
        ImageManager imageManager;
        synchronized (h.class) {
            try {
                if (k == null) {
                    File file = new File(com.sigmob.sdk.base.utils.k.f());
                    synchronized (ImageManager.class) {
                        try {
                            if (k == null) {
                                k = new ImageManager(com.sigmob.sdk.b.e()).customCachePath(file);
                            }
                        } finally {
                        }
                    }
                }
                imageManager = k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return imageManager;
    }

    public static void b() {
        try {
            File d2 = com.sigmob.sdk.base.utils.k.d(com.sigmob.sdk.base.utils.k.f13220a);
            if (d2 == null) {
                return;
            }
            FileUtil.deleteDirectory(d2.getAbsolutePath());
            t();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public static synchronized void e() {
        synchronized (h.class) {
            h.a aVar = new h.a(com.sigmob.sdk.b.e());
            try {
                aVar.a(new File(com.sigmob.sdk.base.utils.k.b()));
            } catch (Throwable th) {
                SigmobLog.e("initHttpProxyCacheServer fail ", th);
            }
            i = aVar.a();
        }
    }

    public static void h() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(a(FileUtil.orderByDate(com.sigmob.sdk.base.utils.k.e()), System.currentTimeMillis(), com.sigmob.sdk.base.o.a().A()), com.sigmob.sdk.base.o.a().z());
            if (clearCacheFileByCount == null) {
                str = "splash ad file list is null.";
            } else {
                str = "splash ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static void k() {
        try {
            File[] orderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.k.a(com.sigmob.sdk.b.e()).getAbsolutePath());
            if (orderByDate != null && orderByDate.length != 0) {
                for (File file : orderByDate) {
                    if (file != null && System.currentTimeMillis() - file.lastModified() > bn.d) {
                        SigmobLog.d("clearDownloadAPK: file = " + file.getName() + ", result = " + file.delete());
                    }
                }
                return;
            }
            SigmobLog.d("clearDownloadAPK: files = " + Arrays.toString(orderByDate));
        } catch (Exception e2) {
            SigmobLog.e("clearDownloadAPK: error = " + e2.getMessage());
        }
    }

    public static void l() {
        try {
            File[] orderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.k.a());
            ArrayList arrayList = new ArrayList(Arrays.asList(orderByDate));
            for (File file : orderByDate) {
                if (!file.getPath().endsWith(".mp4") && !file.getPath().endsWith(".mp4.tmp") && !file.getPath().endsWith(".tgz") && !file.getPath().endsWith(".html")) {
                    arrayList.remove(file);
                }
            }
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount((File[]) arrayList.toArray(new File[0]), 5);
            SigmobLog.i(clearCacheFileByCount == null ? "splash ad file list is null" : "splash ad file remain num: " + clearCacheFileByCount.length);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public void f(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || com.sigmob.sdk.base.utils.o.a((CharSequence) baseAdUnit.getCrid()) || com.sigmob.sdk.base.utils.o.a((CharSequence) baseAdUnit.getAdslot_id())) {
            return;
        }
        Map<String, AdCache> a2 = a(baseAdUnit.getAd_type());
        if ((a2 == null || a2.size() <= 29) && a2 != null) {
            AdCache adCache = a2.get(baseAdUnit.getAdslot_id());
            ArrayList arrayList = new ArrayList();
            arrayList.add(baseAdUnit.getCrid());
            if (adCache != null) {
                arrayList.addAll(adCache.crids);
            }
            a2.put(baseAdUnit.getAdslot_id(), new AdCache(Integer.valueOf(baseAdUnit.getAd_type()), arrayList));
        }
    }

    public void g(BaseAdUnit baseAdUnit) {
        this.t.remove(baseAdUnit);
        this.x.remove(baseAdUnit.getUuid());
    }

    public void i(String str) {
        this.v = str;
    }

    public void j(String str) {
        this.w = str;
    }

    public static BidResponse a(String str) {
        return q.get(str);
    }

    public static void c() {
        try {
            for (File file : FileUtil.orderByDate(com.sigmob.sdk.base.utils.k.c())) {
                long currentTimeMillis = System.currentTimeMillis() - ((com.sigmob.sdk.base.o.a().ai() * SdkConfigData.DEFAULT_REQUEST_INTERVAL) * 1000);
                if (file.exists() && currentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static List<BaseAdUnit> d(String str) {
        List<BaseAdUnit> list;
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || (list = n.get(str)) == null || list.isEmpty()) {
            return null;
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
            if (baseAdUnit.isExpiredAd()) {
                list.remove(baseAdUnit);
            }
        }
        return list;
    }

    public static void f(String str) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return;
        }
        HashMap<String, Integer> hashMap = s;
        Integer num = hashMap.get(str);
        hashMap.put(str, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static void g(String str) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return;
        }
        s.remove(str);
    }

    public void b(a aVar) {
        if (aVar == null || !this.r.contains(aVar)) {
            return;
        }
        this.r.remove(aVar);
    }

    public void e(BaseAdUnit baseAdUnit) {
        Map<String, AdCache> a2;
        AdCache adCache;
        if (baseAdUnit == null || com.sigmob.sdk.base.utils.o.a((CharSequence) baseAdUnit.getAdslot_id()) || (a2 = a(baseAdUnit.getAd_type())) == null || (adCache = a2.get(baseAdUnit.getAdslot_id())) == null || adCache.crids == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(adCache.crids);
        String crid = baseAdUnit.getCrid();
        if (arrayList.contains(crid)) {
            arrayList.remove(crid);
        }
        a2.put(baseAdUnit.getAdslot_id(), new AdCache(Integer.valueOf(baseAdUnit.getAd_type()), arrayList));
    }

    public static void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return;
        }
        String uuid = baseAdUnit.getUuid();
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) uuid)) {
            return;
        }
        h.remove(uuid);
        A.remove(uuid);
    }

    public static void c(BaseAdUnit baseAdUnit) {
        l = baseAdUnit;
    }

    public static void d(BaseAdUnit baseAdUnit) {
        m = baseAdUnit;
    }

    public static List<BaseAdUnit> a(String str, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        List<BaseAdUnit> d2 = d(str);
        if (d2 != null) {
            Iterator it = new CopyOnWriteArrayList(d2).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                int bidEcpm = baseAdUnit.getBidEcpm();
                if (bidEcpm == 0) {
                    bidEcpm = baseAdUnit.getBP();
                }
                if (bidEcpm >= i2 || i2 == 0) {
                    arrayList.add(baseAdUnit);
                    d2.remove(baseAdUnit);
                }
                if (baseAdUnit.bidding_response != null || arrayList.size() >= i3) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private void b(final BaseAdUnit baseAdUnit, final b bVar) {
        if (baseAdUnit == null) {
            return;
        }
        File adPrivacyTemplateFile = baseAdUnit.getAdPrivacyTemplateFile();
        if (adPrivacyTemplateFile != null && !adPrivacyTemplateFile.exists()) {
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = baseAdUnit.getadPrivacy().privacy_template_url;
            downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.OTHER;
            FileDownloader a2 = s.a();
            if (a2 != null) {
                a2.add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.3
                    @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                    public void downloadProgress(DownloadItem downloadItem2, long j2, long j3) {
                    }

                    @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                    public void onCancel(DownloadItem downloadItem2) {
                    }

                    @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                    public void onErrorResponse(DownloadItem downloadItem2) {
                    }

                    @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                    public void onSuccess(DownloadItem downloadItem2) {
                    }
                });
            }
        }
        File file = new File(baseAdUnit.getSplashFilePath());
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
            if (bVar != null) {
                bVar.a(baseAdUnit, null);
                return;
            }
            return;
        }
        FileDownloader a3 = s.a();
        DownloadItem downloadItem2 = new DownloadItem();
        downloadItem2.filePath = baseAdUnit.getSplashFilePath();
        downloadItem2.url = baseAdUnit.getSplashURL();
        downloadItem2.type = DownloadItem.FileType.OTHER;
        downloadItem2.userRange = false;
        a3.add(downloadItem2, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.4
            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void downloadProgress(DownloadItem downloadItem3, long j2, long j3) {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onCancel(DownloadItem downloadItem3) {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onErrorResponse(DownloadItem downloadItem3) {
                String message = downloadItem3.error.getMessage();
                if (downloadItem3.error.networkResponse != null) {
                    StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(message, " status code ");
                    A5SV6n2.append(downloadItem3.error.networkResponse.statusCode);
                    message = A5SV6n2.toString();
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(baseAdUnit, message);
                }
                SigmobLog.e("onErrorResponse: " + message);
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onSuccess(DownloadItem downloadItem3) {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(baseAdUnit, null);
                }
            }
        });
    }

    public static void b(String str) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return;
        }
        q.remove(str);
    }

    public Map<String, AdCache> a(int i2) {
        if (i2 == 1 || i2 == 4) {
            return this.u;
        }
        if (i2 == 5) {
            return this.y;
        }
        if (i2 != 6) {
            return null;
        }
        return this.z;
    }

    public class d extends AsyncTask<Object, Void, ArrayList<DownloadItem>> {

        /* renamed from: a, reason: collision with root package name */
        BaseAdUnit f13135a;

        public d(BaseAdUnit baseAdUnit) {
            this.f13135a = baseAdUnit;
        }

        private DownloadItem a(Template template) {
            if (!com.sigmob.sdk.base.utils.o.b(template.context.utf8())) {
                return null;
            }
            File file = new File(com.sigmob.sdk.base.utils.k.f(com.sigmob.sdk.base.utils.k.c), CtFAbx.AcNBzu(Md5Util.md5(template.context.utf8()), ".tgz"));
            if (file.exists()) {
                return null;
            }
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = template.context.utf8();
            downloadItem.filePath = file.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.ZIP_FILE;
            return downloadItem;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<DownloadItem> doInBackground(Object... objArr) {
            ResponseAssetVideo responseAssetVideo;
            DownloadItem a2;
            DownloadItem a3;
            DownloadItem a4;
            String str;
            ArrayList<DownloadItem> arrayList = new ArrayList<>();
            BaseAdUnit baseAdUnit = this.f13135a;
            if (baseAdUnit != null && baseAdUnit.getMaterial() != null) {
                try {
                    MaterialMeta material = this.f13135a.getMaterial();
                    if (com.sigmob.sdk.base.utils.o.b(this.f13135a.getVideo_url())) {
                        long j = 0;
                        if (this.f13135a.isVideoExist()) {
                            str = Md5Util.fileMd5(this.f13135a.getVideoPath());
                            if (!com.sigmob.sdk.base.utils.o.b(this.f13135a.getVideo_OriginMD5()) || this.f13135a.getVideo_OriginMD5().equalsIgnoreCase(str)) {
                                h.this.p.put(this.f13135a.getVideoPath(), str);
                                j = new File(this.f13135a.getVideoPath()).length();
                            } else {
                                FileUtil.deleteFile(this.f13135a.getVideoPath());
                            }
                        } else {
                            str = null;
                        }
                        boolean checkVideoValid = this.f13135a.checkVideoValid();
                        DownloadItem downloadItem = new DownloadItem();
                        if (checkVideoValid && this.f13135a.isVideoExist()) {
                            downloadItem.url = this.f13135a.getVideo_url();
                            downloadItem.filePath = this.f13135a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = str;
                            downloadItem.size = j;
                            downloadItem.status = 1;
                            ae.a(downloadItem, this.f13135a, (String) null, true);
                        } else if (this.f13135a.getPlayMode() != 2) {
                            downloadItem.url = this.f13135a.getVideo_url();
                            downloadItem.filePath = this.f13135a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = this.f13135a.getVideo_OriginMD5();
                            h.this.a(downloadItem, this.f13135a);
                            arrayList.add(downloadItem);
                        }
                    }
                    if (material.creative_type.intValue() == n.CreativeTypeVideo_Tar.a()) {
                        DownloadItem downloadItem2 = new DownloadItem();
                        downloadItem2.url = this.f13135a.getEndcard_url();
                        downloadItem2.filePath = this.f13135a.getEndCardZipPath();
                        downloadItem2.type = DownloadItem.FileType.FILE;
                        downloadItem2.md5 = this.f13135a.getEndCard_OriginMD5();
                        arrayList.add(downloadItem2);
                    }
                    Template template = this.f13135a.scene;
                    if (template != null && template.type.intValue() == 3 && (a4 = a(this.f13135a.scene)) != null) {
                        arrayList.add(a4);
                    }
                    Template template2 = material.main_template;
                    if (template2 != null && template2.type.intValue() == 3 && (a3 = a(material.main_template)) != null) {
                        arrayList.add(a3);
                    }
                    Template template3 = material.sub_template;
                    if (template3 != null && template3.type.intValue() == 3 && (a2 = a(material.sub_template)) != null) {
                        arrayList.add(a2);
                    }
                    if (this.f13135a.isCatchVideo() && com.sigmob.sdk.base.utils.e.b(material.asset)) {
                        for (int i = 0; i < material.asset.size(); i++) {
                            ResponseAsset responseAsset = material.asset.get(i);
                            if (responseAsset != null && (responseAssetVideo = responseAsset.video) != null) {
                                String str2 = responseAssetVideo.url;
                                if (!com.sigmob.sdk.base.utils.o.a((CharSequence) str2)) {
                                    File c = h.d().c(str2);
                                    if (!c.exists()) {
                                        DownloadItem downloadItem3 = new DownloadItem();
                                        downloadItem3.url = str2;
                                        downloadItem3.filePath = c.getAbsolutePath();
                                        downloadItem3.type = DownloadItem.FileType.MRAID_VIDEO;
                                        h.this.a(downloadItem3, this.f13135a);
                                        arrayList.add(downloadItem3);
                                    }
                                }
                            }
                        }
                    }
                    SigmobLog.d("doInBackground: crid = " + this.f13135a.getCrid() + ", videoUrl = " + this.f13135a.getVideo_url() + ", endCardUrl = " + this.f13135a.getEndcard_url());
                    return arrayList;
                } catch (Throwable th) {
                    com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("doInBackground: error = "));
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<DownloadItem> arrayList) {
            Integer num;
            AdPrivacy adPrivacy;
            File[] listFiles;
            super.onPostExecute(arrayList);
            BaseAdUnit baseAdUnit = this.f13135a;
            if (baseAdUnit == null) {
                return;
            }
            MaterialMeta material = baseAdUnit.getMaterial();
            b bVar = (b) h.this.x.get(this.f13135a.getUuid());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (arrayList.isEmpty()) {
                if (bVar != null) {
                    bVar.a(this.f13135a, null);
                }
                h.this.g(this.f13135a);
            } else {
                FileDownloader a2 = s.a();
                Iterator it = h.this.t.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((BaseAdUnit) it.next()).getUuid().equals(this.f13135a.getUuid())) {
                            break;
                        }
                    } else if (bVar != null) {
                        h.this.t.add(this.f13135a);
                    }
                }
                Iterator<DownloadItem> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    DownloadItem next = it2.next();
                    String md5 = Md5Util.md5(next.url);
                    SigmobLog.d("onPostExecute: url = " + next.url);
                    if (next.type != DownloadItem.FileType.VIDEO && ((num = (Integer) h.j.get(md5)) == null || num.equals(h.f))) {
                        h.j.put(md5, h.d);
                        a2.add(next, h.this.b);
                    }
                }
            }
            if (material == null || (adPrivacy = material.ad_privacy) == null) {
                return;
            }
            String str = adPrivacy.privacy_template_url;
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
                return;
            }
            String md52 = Md5Util.md5(str);
            File d = com.sigmob.sdk.base.utils.k.d(com.sigmob.sdk.base.utils.k.b);
            File a3 = com.sigmob.sdk.base.utils.k.a(d, md52 + ".html");
            if (a3 == null || a3.exists()) {
                SigmobLog.i("privacyTemplateUrl: " + md52 + " is exists");
                return;
            }
            try {
                if (d.exists() && d.isDirectory() && (listFiles = d.listFiles()) != null) {
                    for (File file : listFiles) {
                        if (file.exists() && file.isFile() && file.delete()) {
                            SigmobLog.d("删除单个文件 " + file.getAbsolutePath() + " 成功");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = str;
            downloadItem.filePath = a3.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.OTHER;
            arrayList.add(downloadItem);
            s.a().add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.d.1
                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void downloadProgress(DownloadItem downloadItem2, long j, long j2) {
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onCancel(DownloadItem downloadItem2) {
                    SigmobLog.i("onPostExecute#onCancel: item = " + downloadItem2.url);
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onErrorResponse(DownloadItem downloadItem2) {
                    SigmobLog.i("onPostExecute#onErrorResponse: item = " + downloadItem2.url);
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onSuccess(DownloadItem downloadItem2) {
                    SigmobLog.i("onPostExecute#onSuccess: item = " + downloadItem2.url);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DownloadItem downloadItem, BaseAdUnit baseAdUnit) {
        if (i == null) {
            return;
        }
        String str = downloadItem.url;
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || i.b(str)) {
            return;
        }
        String a2 = i.a(str);
        final long currentTimeMillis = System.currentTimeMillis();
        i.a(new com.sigmob.sdk.videocache.d() { // from class: com.sigmob.sdk.base.common.h.2
            @Override // com.sigmob.sdk.videocache.d
            public void a(File file, String str2, int i2) {
                SigmobLog.d(file + " onCacheAvailable " + i2);
                if (i2 != 100 || file == null || file.getAbsolutePath().endsWith("download")) {
                    return;
                }
                h.i.a(this);
                downloadItem.networkMs = System.currentTimeMillis() - currentTimeMillis;
                h.this.new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
            }

            @Override // com.sigmob.sdk.videocache.d
            public void a(String str2, Throwable th) {
                h.i.a(this);
                downloadItem.error = new VolleyError(WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage());
                downloadItem.networkMs = System.currentTimeMillis() - currentTimeMillis;
                h.this.new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
                SigmobLog.e(str2 + " onCacheUnavailable ", th);
            }
        }, str);
        com.sigmob.sdk.videocache.x.a(com.sigmob.sdk.b.e()).a(a2);
    }

    public void a(a aVar) {
        if (aVar == null || this.r.contains(aVar)) {
            return;
        }
        this.r.add(aVar);
    }

    public static void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return;
        }
        String uuid = baseAdUnit.getUuid();
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) uuid)) {
            return;
        }
        h.put(uuid, baseAdUnit);
    }

    public void a(BaseAdUnit baseAdUnit, b bVar) {
        if (bVar != null) {
            bVar.a(baseAdUnit);
        }
        if (baseAdUnit == null) {
            SigmobLog.e("adUnit is null.");
            if (bVar != null) {
                bVar.a(null, "adUnit is null.");
                return;
            }
            return;
        }
        if (baseAdUnit.getAd_type() == 2) {
            b(baseAdUnit, bVar);
            return;
        }
        if (bVar != null) {
            this.x.put(baseAdUnit.getUuid(), bVar);
        }
        try {
            new d(baseAdUnit).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        } catch (Throwable th) {
            SigmobLog.e("AdUnitCheckCacheTask execute error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAdUnit baseAdUnit, String str, b bVar) {
        if (str != null || (baseAdUnit.isVideoExist() && baseAdUnit.isEndCardIndexExist())) {
            if (bVar != null) {
                bVar.a(baseAdUnit, str);
            }
            g(baseAdUnit);
        }
    }

    public void a(String str, int i2) {
        Map<String, AdCache> a2;
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || (a2 = a(i2)) == null) {
            return;
        }
        a2.remove(str);
    }

    public static void a(String str, BidResponse bidResponse) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || bidResponse == null) {
            return;
        }
        q.put(str, bidResponse);
    }

    public static void a(String str, List<BaseAdUnit> list, int i2) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || com.sigmob.sdk.base.utils.e.a(list)) {
            return;
        }
        List<BaseAdUnit> d2 = d(str);
        if (d2 != null && !d2.isEmpty() && i2 != 0) {
            d2.addAll(list);
            list = d2;
        }
        Collections.sort(list, new AYUAbz());
        if (i2 <= 0) {
            n.remove(str);
            return;
        }
        if (list.size() > i2) {
            list = new LinkedList(list.subList(0, i2));
        }
        n.put(str, list);
    }

    public static void a(List<BaseAdUnit> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        A.put(list.get(0).getUuid(), list);
    }

    public static File[] a(File[] fileArr, long j2, long j3) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (File file : fileArr) {
            long j4 = j2 - j3;
            if (file.exists() && j4 > file.lastModified()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }
}
