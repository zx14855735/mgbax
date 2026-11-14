package com.bytedance.adsdk.lottie.w;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements u {
    private final HttpURLConnection xj;

    public xj(HttpURLConnection httpURLConnection) {
        this.xj = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.xj.disconnect();
    }

    @Override // com.bytedance.adsdk.lottie.w.u
    public InputStream hf() {
        return this.xj.getInputStream();
    }

    @Override // com.bytedance.adsdk.lottie.w.u
    public String u() {
        try {
            if (xj()) {
                return null;
            }
            return "Unable to fetch " + this.xj.getURL() + ". Failed with " + this.xj.getResponseCode() + "\n" + xj(this.xj);
        } catch (IOException e) {
            com.bytedance.adsdk.lottie.kd.kd.xj("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.lottie.w.u
    public String w() {
        return this.xj.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.w.u
    public boolean xj() {
        try {
            return this.xj.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    private String xj(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
