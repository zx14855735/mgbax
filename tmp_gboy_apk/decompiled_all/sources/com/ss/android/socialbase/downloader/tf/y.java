package com.ss.android.socialbase.downloader.tf;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.depend.ff;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.BJ7GGh;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private static ConnectivityManager d = null;
    private static Boolean p = null;
    private static Boolean tf = null;
    private static final String xj = "y";
    private static final Pattern hf = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String w = null;
    private static volatile SparseArray<Boolean> u = new SparseArray<>();
    private static volatile SparseArray<List<ff>> kd = new SparseArray<>();
    private static final char[] y = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern c = null;
    private static Pattern f = null;

    public static String c(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static String d() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.ss.android.socialbase.downloader.w.xj.hf("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            xj(bufferedReader);
            return sb2;
        } catch (Throwable unused2) {
            xj(bufferedReader);
            return null;
        }
    }

    public static boolean f(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String tf2 = tf(th);
            if (!TextUtils.isEmpty(tf2) && tf2.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean hf(long j) {
        return j == -1;
    }

    public static String kd(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return xj(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static boolean p(String str) {
        String str2 = xj;
        pl.hf(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                pl.hf(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    private static String tf(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (c == null) {
                c = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = c.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (f == null) {
            f = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = f.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static boolean u(int i) {
        return i == 206 || i == 200;
    }

    public static boolean w(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static double xj(long j) {
        return j / 1048576.0d;
    }

    public static boolean y(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String u2 = u(com.ss.android.socialbase.downloader.downloader.w.tj());
        return u2 != null && u2.equals(str);
    }

    public static long hf(com.ss.android.socialbase.downloader.network.c cVar) {
        if (cVar == null) {
            return -1L;
        }
        String hf2 = hf(cVar, com.sigmob.sdk.downloader.core.c.f);
        if (TextUtils.isEmpty(hf2)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(hf2);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.ss.android.socialbase.downloader.w.xj.u(xj, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static boolean u(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "dcache::last modify is emtpy, so just return cache");
        }
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return CtFAbx.AcNBzu(str, ".tp");
    }

    public static boolean xj(int i) {
        return i == 0 || i == 2;
    }

    public static String xj(byte[] bArr) {
        if (bArr != null) {
            return xj(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean y(Throwable th) {
        if (th == null) {
            return false;
        }
        String tf2 = tf(th);
        return !TextUtils.isEmpty(tf2) && tf2.contains("Requested Range Not Satisfiable");
    }

    public static String xj(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    byte b = bArr[i5 + i];
                    int i6 = i4 + 1;
                    char[] cArr2 = y;
                    cArr[i4] = cArr2[(b & 255) >> 4];
                    i4 += 2;
                    cArr[i6] = cArr2[b & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    private static String kd(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                            com.ss.android.socialbase.downloader.w.xj.hf("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return null;
    }

    public static long y(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.hf> w2 = com.ss.android.socialbase.downloader.downloader.w.et().w(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (w2 == null || chunkCount != w2.size()) {
                return 0L;
            }
            return hf(w2);
        }
        return downloadInfo.getCurBytes();
    }

    public static boolean c(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.w.eu().xj(th);
    }

    private static String p() {
        String str;
        Throwable th;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            str = (String) invoke;
            try {
                if (TextUtils.isEmpty(str) || !com.ss.android.socialbase.downloader.w.xj.xj()) {
                    return str;
                }
                com.ss.android.socialbase.downloader.w.xj.hf("Process", "processName = " + str);
                return str;
            } catch (Throwable th2) {
                th = th2;
                pl.xj(th);
                return str;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
    }

    public static long u(String str) {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            throw new BaseException(1050, e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static File c() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static boolean f(String str) {
        Context tj;
        if (com.ss.android.socialbase.downloader.f.xj.w().hf("save_path_security") > 0 && (tj = com.ss.android.socialbase.downloader.downloader.w.tj()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + tj.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static long hf(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.w.xj.u(xj, "parse instance length failed with ".concat(str));
            }
        }
        return -1L;
    }

    public static void w(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            pl.u(xj, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    private static String tf() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.ss.android.socialbase.downloader.w.xj.hf("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    public static boolean u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String y() {
        return xj(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getGlobalSaveTempDir(), false);
    }

    public static long d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                try {
                    return Long.parseLong(matcher.group(1));
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        } catch (Throwable th2) {
            pl.xj(th2);
        }
        return 0L;
    }

    public static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            pl.xj(e2);
            return str;
        }
    }

    public static boolean f() {
        Context tj = com.ss.android.socialbase.downloader.downloader.w.tj();
        return (tj == null || hf(tj) || !w(tj)) ? false : true;
    }

    public static String hf(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static boolean kd(Throwable th) {
        if (th == null) {
            return false;
        }
        String tf2 = tf(th);
        return !TextUtils.isEmpty(tf2) && tf2.contains("Precondition Failed");
    }

    public static String u(Context context) {
        String str = w;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String tf2 = tf();
        w = tf2;
        if (!TextUtils.isEmpty(tf2)) {
            return w;
        }
        String p2 = p();
        w = p2;
        if (!TextUtils.isEmpty(p2)) {
            return w;
        }
        String kd2 = kd(context);
        w = kd2;
        if (!TextUtils.isEmpty(kd2)) {
            return w;
        }
        String d2 = d();
        w = d2;
        return d2;
    }

    public static boolean w(DownloadInfo downloadInfo) {
        return xj(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static long hf(List<com.ss.android.socialbase.downloader.model.hf> list) {
        Iterator<com.ss.android.socialbase.downloader.model.hf> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().qt();
        }
        return j;
    }

    public static com.ss.android.socialbase.downloader.constants.y kd(int i) {
        com.ss.android.socialbase.downloader.constants.y yVar = com.ss.android.socialbase.downloader.constants.y.MAIN;
        com.ss.android.socialbase.downloader.constants.y yVar2 = com.ss.android.socialbase.downloader.constants.y.SUB;
        if (i == yVar2.ordinal()) {
            return yVar2;
        }
        com.ss.android.socialbase.downloader.constants.y yVar3 = com.ss.android.socialbase.downloader.constants.y.NOTIFICATION;
        return i == yVar3.ordinal() ? yVar3 : yVar;
    }

    public static String tf(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            pl.xj(th2);
            return "throwable getMsg error";
        }
    }

    public static boolean w(String str, String str2, String str3) {
        return xj(hf(str, str2, str3));
    }

    public static void hf(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.f.xj xj2;
        JSONObject u2;
        if (downloadInfo == null || (u2 = (xj2 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId())).u("download_dir")) == null) {
            return;
        }
        String optString = u2.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            w(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String xj3 = xj(title, xj2);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(xj3) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(xj3);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            p(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static boolean w(com.ss.android.socialbase.downloader.network.c cVar) {
        if (cVar == null) {
            return false;
        }
        return xj.xj(8) ? "chunked".equals(cVar.xj(com.sigmob.sdk.downloader.core.c.h)) || xj(cVar) == -1 : xj(cVar) == -1;
    }

    public static long kd(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.hf> w2 = com.ss.android.socialbase.downloader.downloader.w.et().w(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (w2 != null && w2.size() > 1) {
            long u2 = u(w2);
            if (u2 >= 0) {
                return u2;
            }
        }
        return 0L;
    }

    public static long xj(com.ss.android.socialbase.downloader.network.c cVar) {
        if (cVar == null) {
            return -1L;
        }
        String hf2 = hf(cVar, com.sigmob.sdk.downloader.core.c.e);
        if (TextUtils.isEmpty(hf2) && xj.xj(1)) {
            return hf(cVar);
        }
        try {
            return Long.parseLong(hf2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean w(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager xj2 = xj(context);
            if (xj2 == null || (activeNetworkInfo = xj2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String kd() {
        return xj(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getGlobalSaveDir(), true);
    }

    public static boolean w() {
        Boolean bool = p;
        if (bool != null) {
            return bool.booleanValue();
        }
        String u2 = u(com.ss.android.socialbase.downloader.downloader.w.tj());
        if (u2 != null) {
            if (u2.equals(com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName() + ":downloader")) {
                p = Boolean.TRUE;
                return p.booleanValue();
            }
        }
        p = Boolean.FALSE;
        return p.booleanValue();
    }

    public static String xj(com.ss.android.socialbase.downloader.network.c cVar, String str) {
        String tf2 = tf(cVar.xj(com.sigmob.sdk.downloader.core.c.j));
        return TextUtils.isEmpty(tf2) ? kd(str) : tf2;
    }

    public static String kd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String kd2 = kd(str2);
        return (TextUtils.isEmpty(kd2) || str.contains(kd2)) ? str : new File(str, kd2).getAbsolutePath();
    }

    public static boolean u() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean u(Throwable th) {
        if (th == null) {
            return false;
        }
        String tf2 = tf(th);
        return !TextUtils.isEmpty(tf2) && tf2.contains("Exception in connect");
    }

    public static com.ss.android.socialbase.downloader.model.kd xj(DownloadInfo downloadInfo, String str, String str2, int i) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo).xj("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(AVMDLDataLoader.KeyIsPreloadStragetyWhenPlay, "download savePath directory can not created:" + str);
                                }
                                int i2 = 0;
                                while (!z) {
                                    int i3 = i2 + 1;
                                    if (i2 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        z = file2.mkdirs();
                                        i2 = i3;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!z) {
                                    if (u(downloadInfo.getSavePath()) < 16384) {
                                        throw new BaseException(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(AVMDLDataLoader.KeyIsPreloadStragetyWhenPlay, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    throw new BaseException(1036, e);
                }
            }
            return new com.ss.android.socialbase.downloader.model.kd(file, i);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    private static long u(List<com.ss.android.socialbase.downloader.model.hf> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j = -1;
        for (com.ss.android.socialbase.downloader.model.hf hfVar : list) {
            if (hfVar != null && (hfVar.am() <= hfVar.zg() || hfVar.zg() == 0)) {
                if (j == -1 || j > hfVar.am()) {
                    j = hfVar.am();
                }
            }
        }
        return j;
    }

    public static boolean w(Throwable th) {
        if (th == null) {
            return false;
        }
        String tf2 = tf(th);
        return !TextUtils.isEmpty(tf2) && tf2.contains("network not available");
    }

    public static boolean w(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    private static void w(Throwable th, String str) {
        com.ss.android.socialbase.downloader.exception.c xj2 = com.ss.android.socialbase.downloader.downloader.w.eu().xj(th, null);
        if (xj2 == null) {
            xj2 = com.ss.android.socialbase.downloader.downloader.w.eu().xj(th.getCause(), null);
        }
        if (xj2 == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.c(xj2.getErrorCode(), hf(xj2, str)).xj(xj2.xj());
    }

    public static int hf(String str, String str2, String str3) {
        return com.ss.android.xj.w.xj(str3, new File(str, str2));
    }

    public static String hf(int i) {
        String ASJ6gh2 = CtFAbx.ASJ6gh(i, "ttmd5 check code = ", ", ");
        if (i != 99) {
            switch (i) {
                case 0:
                    return CtFAbx.AcNBzu(ASJ6gh2, "md5 match");
                case 1:
                    return CtFAbx.AcNBzu(ASJ6gh2, "md5 not match");
                case 2:
                    return CtFAbx.AcNBzu(ASJ6gh2, "md5 empty");
                case 3:
                    return CtFAbx.AcNBzu(ASJ6gh2, "ttmd5 version not support");
                case 4:
                    return CtFAbx.AcNBzu(ASJ6gh2, "ttmd5 tag parser error");
                case 5:
                    return CtFAbx.AcNBzu(ASJ6gh2, "file not exist");
                case 6:
                    return CtFAbx.AcNBzu(ASJ6gh2, "get file md5 error");
                default:
                    return ASJ6gh2;
            }
        }
        return CtFAbx.AcNBzu(ASJ6gh2, "unknown error");
    }

    public static long w(long j) {
        return System.currentTimeMillis() - j;
    }

    public static boolean w(List<com.ss.android.socialbase.downloader.model.w> list) {
        if (list != null && list.size() != 0) {
            for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                if (wVar != null && !TextUtils.isEmpty(wVar.xj()) && !TextUtils.isEmpty(wVar.hf()) && "download-tc21-1-15".equals(wVar.xj()) && "download-tc21-1-15".equals(wVar.hf())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<com.ss.android.socialbase.downloader.model.hf> xj(List<com.ss.android.socialbase.downloader.model.hf> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.hf hfVar : list) {
            if (hfVar != null) {
                if (hfVar.u()) {
                    sparseArray.put(hfVar.v(), hfVar);
                    List<com.ss.android.socialbase.downloader.model.hf> list2 = (List) sparseArray2.get(hfVar.v());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.model.hf> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().xj(hfVar);
                        }
                        hfVar.xj(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.hf hfVar2 = (com.ss.android.socialbase.downloader.model.hf) sparseArray.get(hfVar.hf());
                    if (hfVar2 != null) {
                        List<com.ss.android.socialbase.downloader.model.hf> c2 = hfVar2.c();
                        if (c2 == null) {
                            c2 = new ArrayList<>();
                            hfVar2.xj(c2);
                        }
                        hfVar.xj(hfVar2);
                        c2.add(hfVar);
                    } else {
                        List list3 = (List) sparseArray2.get(hfVar.hf());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(hfVar.hf(), list3);
                        }
                        list3.add(hfVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static String xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return CtFAbx.AlLFFp(str, File.separator, str2);
    }

    public static String xj(String str, String str2, String str3) {
        String xj2;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            xj2 = xj(str2, str3);
        } else {
            xj2 = xj(str, str3);
        }
        if (TextUtils.isEmpty(xj2)) {
            return null;
        }
        return CtFAbx.AcNBzu(xj2, ".tp");
    }

    public static void xj(DownloadInfo downloadInfo) {
        xj(downloadInfo, true);
    }

    public static void xj(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                w(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                pl.xj(th);
                return;
            }
        }
        w(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            hf(downloadInfo);
        }
        if (z) {
            String kd2 = kd(downloadInfo.getUrl());
            if (TextUtils.isEmpty(kd2) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(kd2)) {
                return;
            }
            p(downloadInfo.getSavePath());
        }
    }

    @TargetApi(19)
    private static void hf(File file, File file2, boolean z) {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException(A2egSU.AlLFFp("Destination '", file2, "' exists but is a directory"));
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            if (j2 > 31457280) {
                                j2 = 31457280;
                            }
                            long transferFrom = channel2.transferFrom(channel, j, j2);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static boolean xj(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean xj(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (w(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e) {
                pl.xj(e);
            }
        }
        return false;
    }

    public static int xj(File file, String str) {
        return com.ss.android.xj.w.xj(str, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void xj(com.ss.android.socialbase.downloader.model.DownloadInfo r17, com.ss.android.socialbase.downloader.depend.dk r18, com.ss.android.socialbase.downloader.depend.ff r19) {
        /*
            Method dump skipped, instructions count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.tf.y.xj(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.dk, com.ss.android.socialbase.downloader.depend.ff):void");
    }

    public static boolean hf(File file, File file2) {
        String str = xj;
        pl.u(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = xj(file, file2);
            try {
                pl.u(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return renameTo;
    }

    public static boolean hf(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager xj2 = xj(context);
            if (xj2 != null && (activeNetworkInfo = xj2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean hf() {
        return !w() && com.ss.android.socialbase.downloader.downloader.w.w() && com.ss.android.socialbase.downloader.impls.pl.xj(true).c();
    }

    public static boolean hf(Throwable th) {
        if (th == null) {
            return false;
        }
        String tf2 = tf(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.hf) || (((com.ss.android.socialbase.downloader.exception.hf) th).xj() != 403 && (TextUtils.isEmpty(tf2) || !tf2.contains("403")))) {
            return !TextUtils.isEmpty(tf2) && tf2.contains("Forbidden");
        }
        return true;
    }

    public static boolean hf(BaseException baseException) {
        if (!(baseException instanceof com.ss.android.socialbase.downloader.exception.hf)) {
            return false;
        }
        com.ss.android.socialbase.downloader.exception.hf hfVar = (com.ss.android.socialbase.downloader.exception.hf) baseException;
        return hfVar.xj() == 412 || hfVar.xj() == 416;
    }

    public static String hf(Throwable th, String str) {
        if (str == null) {
            return tf(th);
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "-");
        A5SV6n2.append(tf(th));
        return A5SV6n2.toString();
    }

    public static void hf(List<com.ss.android.socialbase.downloader.model.w> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.w("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String hf(com.ss.android.socialbase.downloader.network.c cVar, String str) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String xj2 = cVar.xj(str);
        if (!com.ss.android.socialbase.downloader.f.xj.w().hf("fix_get_http_resp_head_ignore_case", true)) {
            return xj2;
        }
        if (TextUtils.isEmpty(xj2)) {
            xj2 = cVar.xj(str.toLowerCase());
        }
        return TextUtils.isEmpty(xj2) ? cVar.xj(str.toUpperCase()) : xj2;
    }

    public static boolean hf(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && w(com.ss.android.socialbase.downloader.downloader.w.tj());
    }

    private static void xj(int i, boolean z, BaseException baseException) {
        synchronized (u) {
            try {
                List<ff> list = kd.get(i);
                if (list != null) {
                    for (ff ffVar : list) {
                        if (ffVar != null) {
                            if (z) {
                                ffVar.xj();
                            } else {
                                ffVar.xj(baseException);
                            }
                        }
                    }
                }
                com.ss.android.socialbase.downloader.w.xj.hf(xj, "handleTempSaveCallback id:" + i);
                u.remove(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void xj(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        pl.u(xj, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (xj(file, file2)) {
            return;
        }
        throw new BaseException(1001, A2egSU.AzWtSf(J3FDQU.A2egSU.BChYOn("Can't copy the exist file(", downloadInfo.getSavePath(), "/", str, ") to the target file("), downloadInfo.getSavePath(), "/", downloadInfo.getName(), ")"));
    }

    public static boolean xj(File file, File file2) {
        return xj(file, file2, true);
    }

    public static boolean xj(File file, File file2, boolean z) {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    pl.u(xj, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    hf(file, file2, z);
                    return true;
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                xj(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean xj(int i, String str) {
        if (xj.xj(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static List<com.ss.android.socialbase.downloader.model.w> xj(List<com.ss.android.socialbase.downloader.model.w> list, String str, com.ss.android.socialbase.downloader.model.hf hfVar) {
        return xj(list, str, hfVar.g(), hfVar.zg());
    }

    public static List<com.ss.android.socialbase.downloader.model.w> xj(List<com.ss.android.socialbase.downloader.model.w> list, String str, long j, long j2) {
        String AmA8tU2;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                if (wVar != null) {
                    arrayList.add(wVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.w(com.sigmob.sdk.downloader.core.c.c, str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.w("Accept-Encoding", "identity"));
        if (j2 <= 0) {
            AmA8tU2 = CtFAbx.BI9f7h("bytes=", String.valueOf(j), "-");
        } else {
            AmA8tU2 = CtFAbx.AmA8tU("bytes=", String.valueOf(j), "-", String.valueOf(j2));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.w(com.sigmob.sdk.downloader.core.c.b, AmA8tU2));
        String str2 = xj;
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB(" range CurrentOffset:", j, " EndOffset:");
        B2KMhB2.append(j2);
        B2KMhB2.append(", range = ");
        B2KMhB2.append(AmA8tU2);
        com.ss.android.socialbase.downloader.w.xj.hf(str2, B2KMhB2.toString());
        return arrayList;
    }

    public static boolean xj(int i, String str, String str2) {
        return i == -3 && !u(str, str2);
    }

    public static ConnectivityManager xj(Context context) {
        ConnectivityManager connectivityManager = d;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        d = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean xj() {
        Boolean bool = tf;
        if (bool != null) {
            return bool.booleanValue();
        }
        String u2 = u(com.ss.android.socialbase.downloader.downloader.w.tj());
        boolean z = (u2 == null || !u2.contains(":")) && u2 != null && u2.equals(com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName());
        tf = Boolean.valueOf(z);
        return z;
    }

    public static boolean xj(Throwable th) {
        if (th == null) {
            return false;
        }
        String tf2 = tf(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(tf2) && (tf2.contains("time out") || tf2.contains("Time-out"));
    }

    public static boolean xj(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void xj(Throwable th, String str) {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!xj(th)) {
                    if (!kd(th)) {
                        if (!y(th)) {
                            if (!hf(th)) {
                                if (!w(th)) {
                                    if (!u(th)) {
                                        if (th instanceof IOException) {
                                            w(th, str);
                                            xj((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, hf(th, str2));
                                    }
                                    throw new BaseException(1041, hf(th, str2));
                                }
                                throw new BaseException(1049, hf(th, str2));
                            }
                            throw new BaseException(1047, hf(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.hf(PluginConstants.ERROR_PLUGIN_DOWNLOAD, 416, hf(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.hf(PluginConstants.ERROR_PLUGIN_DOWNLOAD, TTAdConstant.IMAGE_URL_CODE, hf(th, str2));
                }
                throw new BaseException(1048, hf(th, str2));
            }
            throw new BaseException(AVMDLDataLoader.KeyIsGetCostLog, hf(th, str2));
        }
        BaseException baseException = (BaseException) th;
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str2, "-");
        A5SV6n2.append(baseException.getErrorMessage());
        baseException.setErrorMsg(A5SV6n2.toString());
        throw baseException;
    }

    public static void xj(IOException iOException, String str) {
        if (str == null) {
            str = "";
        }
        String hf2 = hf(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof BJ7GGh)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (f(iOException)) {
                                                                            throw new BaseException(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, hf2);
                                                                        }
                                                                        throw new BaseException(1023, hf2);
                                                                    }
                                                                    throw new BaseException(AVMDLDataLoader.KeyIsGetCostLog, hf2);
                                                                }
                                                                throw new BaseException(1067, hf2);
                                                            }
                                                            throw new BaseException(1066, hf2);
                                                        }
                                                        throw new BaseException(1065, hf2);
                                                    }
                                                    throw new BaseException(1064, hf2);
                                                }
                                                throw new BaseException(1063, hf2);
                                            }
                                            throw new BaseException(1062, hf2);
                                        }
                                        throw new BaseException(1061, hf2);
                                    }
                                    throw new BaseException(1060, hf2);
                                }
                                throw new BaseException(1059, hf2);
                            }
                            throw new BaseException(1048, hf2);
                        }
                        throw new BaseException(1058, hf2);
                    }
                    throw new BaseException(1057, hf2);
                }
                throw new BaseException(1056, hf2);
            }
            throw new BaseException(1055, hf2);
        }
        throw new BaseException(1041, hf2);
    }

    public static boolean xj(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> xj(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i));
        }
        return hashMap;
    }

    public static <K> void xj(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean xj(List<com.ss.android.socialbase.downloader.model.w> list, List<com.ss.android.socialbase.downloader.model.w> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void xj(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
    }

    public static void xj(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }
    }

    public static String xj(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String xj(String str, com.ss.android.socialbase.downloader.f.xj xjVar) {
        JSONObject u2;
        if (xjVar != null && (u2 = xjVar.u("download_dir")) != null) {
            String optString = u2.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains("%s")) {
                optString = CtFAbx.AcNBzu(optString, str);
            } else {
                try {
                    optString = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r1 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (com.ss.android.socialbase.downloader.f.xj.w().hf("fix_save_external_dir") > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        r4 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(r0, android.os.Environment.DIRECTORY_DOWNLOADS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (xj(r4) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        return r4.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        if (r4 > 29) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String xj(java.io.File r4, boolean r5) {
        /*
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.w.tj()
            boolean r1 = xj(r4)
            if (r1 == 0) goto Lf
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        Lf:
            android.content.pm.ApplicationInfo r4 = r0.getApplicationInfo()
            int r4 = r4.targetSdkVersion
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "fix_save_external_dir"
            r3 = 29
            if (r1 < r3) goto L42
            if (r4 != r3) goto L25
            boolean r1 = DaOi9o.COJEAR.BIYEnU()
            if (r1 == 0) goto L27
        L25:
            if (r4 <= r3) goto L42
        L27:
            com.ss.android.socialbase.downloader.f.xj r4 = com.ss.android.socialbase.downloader.f.xj.w()
            int r4 = r4.hf(r2)
            if (r4 > 0) goto L6e
            java.lang.String r4 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(r0, r4)
            boolean r5 = xj(r4)
            if (r5 == 0) goto L6e
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        L42:
            if (r5 == 0) goto L53
            java.io.File r4 = c()
            boolean r5 = xj(r4)
            if (r5 == 0) goto L53
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        L53:
            com.ss.android.socialbase.downloader.f.xj r4 = com.ss.android.socialbase.downloader.f.xj.w()
            int r4 = r4.hf(r2)
            if (r4 > 0) goto L6e
            java.lang.String r4 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(r0, r4)
            boolean r5 = xj(r4)
            if (r5 == 0) goto L6e
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        L6e:
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(r0)
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.tf.y.xj(java.io.File, boolean):java.lang.String");
    }

    public static boolean xj(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void xj(List<com.ss.android.socialbase.downloader.model.w> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.w("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int xj(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static String xj(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean xj(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}
