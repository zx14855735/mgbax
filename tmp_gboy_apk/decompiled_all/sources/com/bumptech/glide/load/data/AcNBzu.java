package com.bumptech.glide.load.data;

import ADYaiT.CtFAbx;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu implements AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Hjvs0g.AcNBzu f9990AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f9991AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public HttpURLConnection f9992AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public InputStream f9993AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public volatile boolean f9994B25kr6;

    static {
        bNCNqgY();
    }

    public AcNBzu(Hjvs0g.AcNBzu acNBzu, int i) {
        this.f9990AcNBzu = acNBzu;
        this.f9991AlLFFp = i;
    }

    private static /* synthetic */ void bNCNqgY() {
        char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 21);
        }
        String str = new String(charArray);
        char[] charArray2 = "vy|{|a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 21);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        return InputStream.class;
    }

    public final InputStream A4TApA(URL url, int i, URL url2, Map map) {
        int i2;
        int i3 = -1;
        if (i >= 5) {
            throw new HSHyT0.A5SV6n("Too many (> 5) redirects!", -1, null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HSHyT0.A5SV6n("In re-direct loop", -1, null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int i4 = this.f9991AlLFFp;
            httpURLConnection.setConnectTimeout(i4);
            httpURLConnection.setReadTimeout(i4);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.f9992AmA8tU = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f9993AzWtSf = this.f9992AmA8tU.getInputStream();
                if (this.f9994B25kr6) {
                    return null;
                }
                try {
                    i2 = this.f9992AmA8tU.getResponseCode();
                } catch (IOException unused2) {
                    Log.isLoggable("HttpUrlFetcher", 3);
                    i2 = -1;
                }
                int i5 = i2 / 100;
                if (i5 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f9992AmA8tU;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f9993AzWtSf = new ItGa5w.ADYaiT(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                httpURLConnection2.getContentEncoding();
                            }
                            this.f9993AzWtSf = httpURLConnection2.getInputStream();
                        }
                        return this.f9993AzWtSf;
                    } catch (IOException e) {
                        try {
                            i3 = httpURLConnection2.getResponseCode();
                        } catch (IOException unused3) {
                            Log.isLoggable("HttpUrlFetcher", 3);
                        }
                        throw new HSHyT0.A5SV6n("Failed to obtain InputStream", i3, e);
                    }
                }
                if (i5 != 3) {
                    if (i2 == -1) {
                        throw new HSHyT0.A5SV6n("Http request failed", i2, null);
                    }
                    try {
                        throw new HSHyT0.A5SV6n(this.f9992AmA8tU.getResponseMessage(), i2, null);
                    } catch (IOException e2) {
                        throw new HSHyT0.A5SV6n("Failed to get a response message", i2, e2);
                    }
                }
                String headerField = this.f9992AmA8tU.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new HSHyT0.A5SV6n("Received empty or null redirect url", i2, null);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    AMqCpz();
                    return A4TApA(url3, i + 1, url, map);
                } catch (MalformedURLException e3) {
                    throw new HSHyT0.A5SV6n(CtFAbx.BChYOn("Bad redirect url: ", headerField), i2, e3);
                }
            } catch (IOException e4) {
                try {
                    i3 = this.f9992AmA8tU.getResponseCode();
                } catch (IOException unused4) {
                    Log.isLoggable("HttpUrlFetcher", 3);
                }
                throw new HSHyT0.A5SV6n("Failed to connect or obtain data", i3, e4);
            }
        } catch (IOException e5) {
            throw new HSHyT0.A5SV6n("URL.openConnection threw", 0, e5);
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        InputStream inputStream = this.f9993AzWtSf;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f9992AmA8tU;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f9992AmA8tU = null;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(com.bumptech.glide.AZOQYO azoqyo, ADYaiT aDYaiT) {
        Hjvs0g.AcNBzu acNBzu = this.f9990AcNBzu;
        int i = ItGa5w.ASJ6gh.f4081A2egSU;
        SystemClock.elapsedRealtimeNanos();
        try {
            try {
                aDYaiT.ASJ6gh(A4TApA(acNBzu.ADYaiT(), 0, null, acNBzu.f3719A4TApA.A4TApA()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
            } catch (IOException e) {
                Log.isLoggable("HttpUrlFetcher", 3);
                aDYaiT.A5SV6n(e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        this.f9994B25kr6 = true;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        return 2;
    }
}
