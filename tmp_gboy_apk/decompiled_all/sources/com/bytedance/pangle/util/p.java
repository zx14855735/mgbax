package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class p {
    private static String hf;
    static volatile ArrayList<String> xj;

    public static String hf(AssetManager assetManager) {
        return xj(xj(assetManager));
    }

    public static List<String> xj() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
            assetManager = null;
        }
        return xj(assetManager);
    }

    public static synchronized List<String> hf() {
        ArrayList<String> arrayList;
        synchronized (p.class) {
            try {
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "start");
                if (xj == null) {
                    synchronized (p.class) {
                        if (xj == null) {
                            xj = new ArrayList<>();
                            if (d.kd()) {
                                try {
                                    Resources resources = Zeus.getAppApplication().getResources();
                                    xj.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir);
                                } catch (Exception e) {
                                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e);
                                }
                            } else if (d.p()) {
                                try {
                                    Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                                    if (d.zg()) {
                                        Collections.addAll(xj, xj(((Context) invokeStaticMethod).getApplicationInfo()));
                                    } else {
                                        xj.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                    }
                                } catch (Exception e2) {
                                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e2);
                                }
                            }
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "finish :" + xj);
                arrayList = xj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public static List<String> xj(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager != null) {
            try {
                if (d.qt()) {
                    Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                    if (objArr != null && objArr.length > 0) {
                        for (Object obj : objArr) {
                            arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                        }
                    }
                } else {
                    int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                    for (int i = 0; i < intValue; i++) {
                        try {
                            String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i + 1));
                            if (!TextUtils.isEmpty(str)) {
                                arrayList.add(str);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
            }
        }
        return arrayList;
    }

    public static boolean xj(AssetManager assetManager, String str) {
        try {
            if (d.qt()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i = 0;
                while (i < intValue) {
                    i++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    public static String xj(List<String> list) {
        StringBuilder sb = new StringBuilder("[");
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private static String[] xj(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.hf.hf.xj.xj((Class<?>) ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i = 0; i < 3; i++) {
            String[] strArr3 = strArr2[i];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
