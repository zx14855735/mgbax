package com.bytedance.sdk.openadsdk.core.ai.hf;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.czhj.sdk.common.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static String hf;
    private static Map<String, Integer> w = new HashMap();
    private static String xj;

    static {
        if (w.xj()) {
            hf = Build.SUPPORTED_ABIS[0];
        } else {
            hf = Build.CPU_ABI;
        }
        w.put("arm64-v8a", 64);
        w.put("armeabi-v7a", 32);
        w.put("armeabi", 32);
        w.put("x86_64", 64);
        w.put("x86", 32);
        w.put("mips64", 64);
        w.put("mips", 32);
        xj = hf();
        KYYZ();
    }

    private static /* synthetic */ void KYYZ() {
        char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'P');
        }
        String str = new String(charArray);
        char[] charArray2 = "3<9>9$".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'P');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String hf() {
        JSONObject w2 = w();
        String xj2 = xj(w2);
        return xj2 == null ? hf(w2) : xj2;
    }

    private static JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", Constants.FAIL);
            jSONObject.put("processMode", Constants.FAIL);
            jSONObject.put("supportedABI0", Constants.FAIL);
            jSONObject.put("matchCpuAbi", Constants.FAIL);
            jSONObject.put("defaultABI0", Constants.FAIL);
            jSONObject.put("defaultABI", Constants.FAIL);
            jSONObject.put("autoError", Constants.FAIL);
            jSONObject.put("manualError", Constants.FAIL);
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return jSONObject;
        }
    }

    private static Map<String, List<ZipEntry>> xj(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (w.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        pl.xj("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    private static String hf(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            Context context = pz.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(xj(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            if (w.xj()) {
                strArr = Build.SUPPORTED_ABIS;
            } else {
                strArr = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
        } catch (Throwable th) {
            pl.w("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            xj(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            xj(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                xj(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (w.xj()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            xj(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        xj(jSONObject, "defaultABI", str2);
        return str2;
    }

    public static String xj() {
        String str = xj;
        if (str != null) {
            return str;
        }
        String hf2 = hf();
        xj = hf2;
        return hf2;
    }

    private static String xj(JSONObject jSONObject) {
        boolean is64Bit;
        if (!w.xj()) {
            return null;
        }
        try {
            String str = (String) xj.xj(pz.getContext().getApplicationInfo(), "primaryCpuAbi");
            pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            xj(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (w.hf()) {
                try {
                    is64Bit = Process.is64Bit();
                    i = is64Bit ? 64 : 32;
                    pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            xj(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (w.get(str).intValue() != i) {
                    return null;
                }
                pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
            } else {
                pl.hf("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
            }
            return str;
        } catch (Exception e) {
            pl.w("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e);
            xj(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static void xj(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }
}
