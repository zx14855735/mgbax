package CtFAbx;

import android.content.Context;
import android.webkit.WebSettings;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1874AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f1875AlLFFp;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f1874AcNBzu = i;
        this.f1875AlLFFp = obj;
    }

    private final void A2egSU() {
        HttpURLConnection httpURLConnection;
        EY4UKY.AMqCpz aMqCpz = (EY4UKY.AMqCpz) this.f1875AlLFFp;
        KCxDWD.A5SV6n a5SV6n = (KCxDWD.A5SV6n) aMqCpz.f2538AmA8tU;
        FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) a5SV6n.f4241AlLFFp;
        String[] AZkASS2 = com.bumptech.glide.A5SV6n.AZkASS((String) aMqCpz.f2539AzWtSf);
        try {
            try {
                URL url = new URL(("https://de.ad.gameley.com/" + ((String) aMqCpz.f2540B25kr6)).trim());
                if (url.getProtocol().equalsIgnoreCase("https")) {
                    EY4UKY.AMqCpz.ARc23Z();
                    aMqCpz.f2537AlLFFp = (HttpsURLConnection) url.openConnection();
                } else {
                    aMqCpz.f2537AlLFFp = (HttpURLConnection) url.openConnection();
                }
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setConnectTimeout(TTAdConstant.STYLE_SIZE_RADIO_3_2);
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setReadTimeout(TTAdConstant.STYLE_SIZE_RADIO_3_2);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) aMqCpz.f2537AlLFFp;
                Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
                if (context == null) {
                    context = null;
                }
                httpURLConnection2.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(context));
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setDoOutput(true);
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setDoInput(true);
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setUseCaches(false);
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setRequestMethod(an.b);
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setRequestProperty("Content-Type", an.d);
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setRequestProperty("Connection", "Keep-Alive");
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).setRequestProperty("Charset", "UTF-8");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cipher", AZkASS2[0]);
                jSONObject.put("encryptParams", AZkASS2[1]);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(((HttpURLConnection) aMqCpz.f2537AlLFFp).getOutputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();
                bufferedOutputStream.close();
                int responseCode = ((HttpURLConnection) aMqCpz.f2537AlLFFp).getResponseCode();
                ((HttpURLConnection) aMqCpz.f2537AlLFFp).getResponseMessage();
                if (200 == responseCode) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection) aMqCpz.f2537AlLFFp).getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    bufferedReader.close();
                    if (200 == responseCode) {
                        a5SV6n.AlLFFp(EY4UKY.AMqCpz.A2egSU(sb.toString()));
                    } else {
                        a5SV6n.a();
                    }
                } else {
                    a5SV6n.a();
                }
                httpURLConnection = (HttpURLConnection) aMqCpz.f2537AlLFFp;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (SocketTimeoutException unused) {
                a4TApA.getClass();
                new EY4UKY.ADYaiT().B3GDIM(3, 4, a4TApA.f3187AYUAbz, a4TApA.f3200B9tovu, "");
                a4TApA.De4eam(5, FZu94u.A4TApA.Ddcejp(a4TApA, null), null);
                httpURLConnection = (HttpURLConnection) aMqCpz.f2537AlLFFp;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (UnknownHostException unused2) {
                httpURLConnection = (HttpURLConnection) aMqCpz.f2537AlLFFp;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e) {
                EY4UKY.AMqCpz.ADYaiT("001", e);
                httpURLConnection = (HttpURLConnection) aMqCpz.f2537AlLFFp;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) aMqCpz.f2537AlLFFp;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:306:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x057c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: CtFAbx.A2egSU.run():void");
    }
}
