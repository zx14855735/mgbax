package com.ss.android.downloadlib.addownload;

import B4ZgIw.AYUAbz;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private final ConcurrentHashMap<String, String> hf;
    private final ConcurrentHashMap<String, String> xj;

    public static class xj {
        private static y xj = new y();

        static {
            VztZEHG();
        }

        private static /* synthetic */ void VztZEHG() {
            char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 170);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 170);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private String w(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.xj.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    public static y xj() {
        return xj.xj;
    }

    public void hf(String str) {
        Iterator<Map.Entry<String, String>> it = this.hf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.xj.remove(next.getKey());
            }
        }
    }

    private y() {
        this.xj = new ConcurrentHashMap<>();
        this.hf = new ConcurrentHashMap<>();
    }

    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.hf.containsKey(str2)) {
            return;
        }
        this.hf.put(str2, str);
    }

    public String xj(String str) {
        if (TextUtils.isEmpty(str) || this.hf.isEmpty() || !this.hf.containsKey(str)) {
            return null;
        }
        String w = w(str);
        if (this.xj.containsValue(w)) {
            for (Map.Entry<String, String> entry : this.xj.entrySet()) {
                if (TextUtils.equals(entry.getValue(), w)) {
                    String str2 = this.hf.get(entry.getKey());
                    this.hf.put(str, str2);
                    if (!this.xj.containsKey(str)) {
                        this.xj.put(str, w);
                    }
                    return str2;
                }
            }
        }
        return this.hf.get(str);
    }

    public String xj(DownloadModel downloadModel) {
        String w = w(downloadModel.getDownloadUrl());
        if (w == null || TextUtils.isEmpty(w)) {
            return null;
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(w);
        A4TApA2.append(downloadModel.getPackageName());
        String kd = com.ss.android.socialbase.downloader.tf.y.kd(A4TApA2.toString());
        this.hf.put(downloadModel.getDownloadUrl(), kd);
        return kd;
    }
}
