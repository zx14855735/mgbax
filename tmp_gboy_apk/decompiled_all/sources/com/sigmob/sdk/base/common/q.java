package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.base.cache.DatabaseHelper;
import com.sigmob.sdk.base.common.r;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13155a = "q";
    private static final Map<String, String> b = new Hashtable();
    private static final Set<a> c = new CopyOnWriteArraySet();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f13157a;
        String b;
        long c;

        public a(String str, String str2, long j) {
            this.f13157a = str;
            this.b = str2;
            this.c = j;
        }

        public String a() {
            return this.f13157a;
        }

        public String b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }
    }

    static {
        dEXjYoS();
    }

    public static DownloadManager a() {
        Context e = com.sigmob.sdk.b.e();
        if (e == null) {
            return null;
        }
        return (DownloadManager) e.getSystemService("download");
    }

    private static long b(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String trim = str.trim();
                    if (TextUtils.isEmpty(Uri.parse(trim).getScheme())) {
                        trim = "http://" + trim;
                    }
                    if (!trim.startsWith(Constants.HTTP)) {
                        return -2L;
                    }
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(trim));
                    File file = new File(str2);
                    request.setTitle(str3);
                    request.setAllowedNetworkTypes(3);
                    request.setAllowedOverRoaming(true);
                    request.setVisibleInDownloadsUi(true);
                    request.setNotificationVisibility(1);
                    File parentFile = file.getParentFile();
                    if (parentFile == null) {
                        return -1L;
                    }
                    if (parentFile.exists()) {
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            if (!parentFile.mkdirs()) {
                                return -3L;
                            }
                        }
                    } else if (!parentFile.mkdirs()) {
                        return -4L;
                    }
                    request.addRequestHeader("User-Agent", Networking.getUserAgent());
                    request.setDestinationUri(Uri.fromFile(file));
                    DownloadManager a2 = a();
                    if (a2 == null) {
                        return -1L;
                    }
                    return a2.enqueue(request);
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
        return -1L;
    }

    public static Long c(long j, String str) {
        for (a aVar : c) {
            if (aVar.c == j || aVar.f13157a.equalsIgnoreCase(str)) {
                return Long.valueOf(aVar.c);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(str);
        }
    }

    private static /* synthetic */ void dEXjYoS() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).getOptions().put("url", str);
        }
    }

    public static String a(File file) {
        String name = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1).toLowerCase());
    }

    public static HashMap<String, Object> b() {
        Cursor cursor;
        try {
            DownloadManager a2 = a();
            if (a2 == null) {
                return null;
            }
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterByStatus(3);
            cursor = a2.query(query);
            try {
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    cursor.close();
                    return null;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                do {
                    Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("local_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(string, valueOf);
                    }
                } while (cursor.moveToNext());
                cursor.close();
                return hashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    SigmobLog.e(th.getMessage());
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    private static String a(List<String> list, String str) {
        String str2;
        String str3;
        int indexOf;
        if (!list.contains(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            str3 = str.substring(lastIndexOf);
        } else {
            str2 = "";
            str3 = "";
        }
        int lastIndexOf2 = str2.lastIndexOf("(");
        if (lastIndexOf2 != -1 && (indexOf = str2.indexOf(")", lastIndexOf2)) != -1 && indexOf >= str2.length() - 1) {
            try {
                return a(list, str2.substring(0, lastIndexOf2) + "(" + (Integer.parseInt(str2.substring(lastIndexOf2 + 1, indexOf)) + 1) + ")" + str3);
            } catch (Throwable unused) {
            }
        }
        return a(list, CtFAbx.AlLFFp(str2, "(1)", str3));
    }

    public static void b(long j, String str) {
        for (a aVar : c) {
            if (aVar.c == j || aVar.f13157a.equalsIgnoreCase(str)) {
                c.remove(aVar);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, String str2, String str3) {
        Long l;
        if (TextUtils.isEmpty(str)) {
            str = Md5Util.md5(str2) + ".apk";
        }
        File a2 = com.sigmob.sdk.base.utils.k.a(com.sigmob.sdk.base.utils.k.a(com.sigmob.sdk.b.e()), str);
        if (a2 != null) {
            Long c2 = c(-1L, a2.getAbsolutePath());
            if (c2 != null && c2.longValue() > 0) {
                try {
                    ak.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            long b2 = b(str2, a2.getAbsolutePath(), str3);
            l = Long.valueOf(b2);
            if (b2 > 0) {
                ak.a(com.sigmob.sdk.b.e(), "开始下载", 1).show();
                File file = new File(com.sigmob.sdk.base.utils.k.g(), l + ".log");
                if (!file.exists()) {
                    file.delete();
                }
                FileUtil.writeToCache(str, file.getAbsolutePath());
            }
        } else {
            l = null;
        }
        ae.a("download_start", (l == null || l.longValue() <= 0) ? Constants.FAIL : "1", (BaseAdUnit) null, new AaHO0E(str2, 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, File file, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("apkfile", file.getAbsolutePath());
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(str);
        }
    }

    public static boolean b(File file) {
        return (file == null || !file.exists() || ClientMetadata.getPackageInfoWithUri(com.sigmob.sdk.b.e(), file.getAbsolutePath()) == null) ? false : true;
    }

    public static Map<String, Object> a(long j) {
        Cursor cursor;
        try {
            DownloadManager a2 = a();
            if (a2 == null) {
                return null;
            }
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j);
            Uri uriForDownloadedFile = a2.getUriForDownloadedFile(j);
            cursor = a2.query(query);
            try {
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    cursor.close();
                    return null;
                }
                int i = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow(MediationConstant.KEY_REASON));
                String string = cursor.getString(cursor.getColumnIndexOrThrow("local_uri"));
                HashMap hashMap = new HashMap();
                hashMap.put("fileName", string);
                hashMap.put("status", Integer.valueOf(i));
                hashMap.put(ContentProviderManager.PROVIDER_URI, uriForDownloadedFile);
                hashMap.put(MediationConstant.KEY_REASON, Integer.valueOf(i2));
                cursor.close();
                return hashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    SigmobLog.e(th.getMessage());
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static void a(Context context, BaseAdUnit baseAdUnit, String str, File file) {
        if (baseAdUnit.isRecord()) {
            ae.a("download_start", "1", baseAdUnit, new B2KMhB(file, str, 0));
        }
        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", "1");
        BI9f7h2.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), BI9f7h2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, File file, BaseAdUnit baseAdUnit) {
        a(context, file.getAbsolutePath(), baseAdUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r11, java.lang.String r12, com.sigmob.sdk.base.models.BaseAdUnit r13) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.q.a(android.content.Context, java.lang.String, com.sigmob.sdk.base.models.BaseAdUnit):void");
    }

    public static void a(String str, BaseAdUnit baseAdUnit) {
        String str2;
        Context e = com.sigmob.sdk.b.e();
        try {
            ae.a(PointCategory.APK_CLICK, "download", baseAdUnit);
            SigmobLog.i("download apk:" + str);
            h.a(baseAdUnit);
            String apkMd5 = baseAdUnit.getApkMd5();
            if (TextUtils.isEmpty(apkMd5)) {
                str2 = Md5Util.md5(str) + ".apk";
            } else {
                str2 = apkMd5 + ".apk";
                File file = new File(com.sigmob.sdk.base.utils.k.a(e), str2);
                boolean exists = file.exists();
                boolean b2 = baseAdUnit.getApkDownloadType() != 0 ? com.sigmob.sdk.downloader.l.b(str, com.sigmob.sdk.base.utils.k.a(e).getAbsolutePath(), str2) : true;
                if (exists && b2 && baseAdUnit.canUseDownloadApk() && b(file)) {
                    baseAdUnit.setApkName(str2);
                    if (baseAdUnit.getDownloadId() == null) {
                        ae.b(PointCategory.EXIT_APK_INSTALL, "", baseAdUnit);
                    }
                    WindAds.sharedAds().getHandler().post(new AzWtSf(e, file, baseAdUnit, 2));
                    return;
                }
            }
            baseAdUnit.setApkName(str2);
            baseAdUnit.setDownloadUrl(str);
            int apkDownloadType = baseAdUnit.getApkDownloadType();
            if (apkDownloadType == 0) {
                a(str2, str, baseAdUnit);
                return;
            }
            if (apkDownloadType == 1) {
                o.a(str, baseAdUnit, false);
                return;
            }
            if (apkDownloadType == 2) {
                o.a(str, baseAdUnit, true);
                return;
            }
            SigmobLog.e("not support Download Type: " + apkDownloadType);
            throw new Exception("not support Download Type: " + apkDownloadType);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            if (baseAdUnit.isRecord()) {
                ae.a("download_start", Constants.FAIL, baseAdUnit, new AaHO0E(str, 16));
                ae.a("download_start", 0, th.getMessage(), baseAdUnit, new AaHO0E(str, 17));
            }
            try {
                ak.a(e, "下载失败", 1).show();
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, File file, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("apkfile", file.getAbsolutePath());
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFile_name(str);
        }
    }

    private static void a(String str, String str2, BaseAdUnit baseAdUnit) {
        int i;
        String absolutePath;
        String str3;
        Context e = com.sigmob.sdk.b.e();
        try {
            try {
                String str4 = TextUtils.isEmpty(str) ? Md5Util.md5(baseAdUnit.getLanding_page()) + ".apk" : str;
                File file = new File(com.sigmob.sdk.base.utils.k.a(e), str4);
                Long c2 = c(-1L, file.getAbsolutePath());
                i = -1;
                if (c2 != null) {
                    try {
                        if (c2.longValue() > 0) {
                            ak.a(e, "正在下载", 1).show();
                            if (baseAdUnit.getDownloadId() == null) {
                                baseAdUnit.setDownloadId(c2);
                                File file2 = new File(com.sigmob.sdk.base.utils.k.g(), c2 + ".log");
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                FileUtil.writeToCache(baseAdUnit, file2.getAbsolutePath());
                                a(e, baseAdUnit, str2, file);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        SigmobLog.e(th.getMessage());
                        if (baseAdUnit.isRecord()) {
                            ae.a("download_start", Constants.FAIL, baseAdUnit, new AaHO0E(str2, 19));
                            ae.a("download_start", 0, th.getMessage(), baseAdUnit, new AaHO0E(str2, 20));
                        }
                        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", Constants.FAIL);
                        BI9f7h2.put("downloadId", Integer.valueOf(i));
                        BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), BI9f7h2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                        ak.a(e, "请先给予应用权限", 1).show();
                        return;
                    }
                }
                HashMap<String, Object> b2 = b();
                if (b2 != null) {
                    for (String str5 : b2.keySet()) {
                        if (!TextUtils.isEmpty(str5) && str5.equals(file.getAbsolutePath())) {
                            try {
                                ak.a(e, "正在下载", 1).show();
                            } catch (Throwable unused) {
                            }
                            Object obj = b2.get(str5);
                            if (obj instanceof Long) {
                                baseAdUnit.setDownloadId((Long) obj);
                                File file3 = new File(com.sigmob.sdk.base.utils.k.g(), c2 + ".log");
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                FileUtil.writeToCache(baseAdUnit, file3.getAbsolutePath());
                                a(e, baseAdUnit, str2, file);
                                return;
                            }
                            return;
                        }
                    }
                }
                Map<String, String> map = b;
                boolean containsKey = map.containsKey(baseAdUnit.getUuid());
                if (file.exists() && !containsKey && !a(e, file.getAbsolutePath())) {
                    SigmobLog.i("cacheFile deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath()));
                }
                SigmobLog.i(str4 + " exists:" + file.exists() + " containsKey:" + containsKey);
                if (file.exists()) {
                    if (containsKey) {
                        absolutePath = file.getAbsolutePath();
                    } else {
                        long lastModified = file.lastModified();
                        int Z = com.sigmob.sdk.base.o.a().Z();
                        if (Z == 0) {
                            str3 = "default deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath());
                        } else if (System.currentTimeMillis() - lastModified > Z * 1000) {
                            str3 = "timeOut deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath());
                        } else {
                            absolutePath = file.getAbsolutePath();
                        }
                        SigmobLog.i(str3);
                    }
                    a(e, absolutePath, baseAdUnit);
                    return;
                }
                map.put(baseAdUnit.getUuid(), str4);
                String appName = baseAdUnit.getAppName();
                if (TextUtils.isEmpty(appName)) {
                    appName = file.getName();
                }
                long b3 = b(str2, file.getAbsolutePath(), appName);
                if (b3 >= 0) {
                    try {
                        ak.a(e, "已开始下载，可在通知栏尝试取消", 1).show();
                    } catch (Throwable th2) {
                        SigmobLog.e(th2.getMessage());
                    }
                    a(b3, file.getAbsolutePath());
                    File file4 = new File(com.sigmob.sdk.base.utils.k.g(), b3 + ".log");
                    baseAdUnit.setDownloadId(Long.valueOf(b3));
                    FileUtil.writeToCache(baseAdUnit, file4.getAbsolutePath());
                    a(e, baseAdUnit, str2, file);
                } else {
                    if (baseAdUnit.isRecord()) {
                        ae.a("download_start", Constants.FAIL, baseAdUnit, new B2KMhB(file, str2, 1));
                        ae.a(PointCategory.DOWNLOAD_FAILED, (int) b3, "下载失败,错误码 " + b3, baseAdUnit);
                    }
                    ak.a(e, "下载失败,错误码 " + b3, 0).show();
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", Constants.FAIL);
                    hashMap.put("downloadId", -1);
                    BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                }
                if (baseAdUnit.isRecord()) {
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "download_start");
                }
            } catch (Throwable th3) {
                th = th3;
                i = -1;
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(final String str, final String str2, final String str3, final int i) {
        r.a(str, new r.a() { // from class: com.sigmob.sdk.base.common.q.1
            @Override // com.sigmob.sdk.base.common.r.a
            public void a(String str4, String str5) {
                String str6;
                String str7 = TextUtils.isEmpty(str3) ? str4 : str3;
                int i2 = i;
                boolean z = true;
                if (i2 == 1) {
                    str6 = str2;
                    z = false;
                } else {
                    if (i2 != 2) {
                        q.c(str4, str5, str7);
                        return;
                    }
                    str6 = str2;
                }
                o.a(str4, str5, str6, str7, z);
            }

            @Override // com.sigmob.sdk.base.common.r.a
            public void a(String str4, Throwable th) {
                String str5 = Md5Util.md5(str) + ".apk";
                String str6 = TextUtils.isEmpty(str3) ? str5 : str3;
                int i2 = i;
                if (i2 == 1) {
                    o.a(str5, str, str2, str6, false);
                } else if (i2 != 2) {
                    q.c(str5, str, str6);
                } else {
                    o.a(str5, str, str2, str6, true);
                }
            }
        });
    }

    public static boolean a(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        c.add(new a(str, null, j));
        return true;
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            DownloadManager a2 = a();
            if (a2 == null) {
                return false;
            }
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterByStatus(3);
            Cursor query2 = a2.query(query);
            if (!query2.moveToFirst()) {
                query2.close();
                query2.close();
                return false;
            }
            do {
                String string = query2.getString(query2.getColumnIndexOrThrow(ContentProviderManager.PROVIDER_URI));
                if (!TextUtils.isEmpty(string) && str.equalsIgnoreCase(string)) {
                    query2.close();
                    return true;
                }
            } while (query2.moveToNext());
            query2.close();
            return false;
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                return false;
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    public static long[] a(Context context, Long l) {
        long[] jArr = {-1, -1, 0};
        if (l != null && l.longValue() >= 0) {
            Cursor cursor = null;
            try {
                cursor = ((DownloadManager) context.getSystemService("download")).query(new DownloadManager.Query().setFilterById(l.longValue()));
                if (cursor != null && cursor.moveToFirst()) {
                    jArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                    jArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                    jArr[2] = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
                }
                if (cursor != null) {
                    return jArr;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return jArr;
    }
}
