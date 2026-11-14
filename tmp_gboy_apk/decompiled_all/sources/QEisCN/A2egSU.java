package QEisCN;

import KpHwm4.ADYaiT;
import Qo94AZ.B25kr6;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bn;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.common.util.CommConstant;
import com.octopus.ad.Octopus;
import com.octopus.ad.internal.q;
import com.octopus.ad.utils.b.d;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.b.h;
import com.octopus.ad.utils.b.i;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7454AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f7455AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Serializable f7456AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f7457AzWtSf;

    public A2egSU(ADYaiT aDYaiT, String str, boolean z) {
        this.f7454AcNBzu = 0;
        this.f7457AzWtSf = aDYaiT;
        this.f7456AmA8tU = str;
        this.f7455AlLFFp = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        String str;
        switch (this.f7454AcNBzu) {
            case 0:
                Looper.prepare();
                boolean z = this.f7455AlLFFp;
                ADYaiT aDYaiT = (ADYaiT) this.f7457AzWtSf;
                aDYaiT.getClass();
                String str2 = (String) this.f7456AmA8tU;
                if (str2.contains("com.octopus.ad")) {
                    try {
                        if (((Context) aDYaiT.f4283A5SV6n) == null) {
                            aDYaiT.f4283A5SV6n = q.a().j();
                        }
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put(MedProConst.AD_APPID, q.a().h());
                        jSONObject.put("packageName", ((Context) aDYaiT.f4283A5SV6n).getPackageName());
                        jSONObject.put("versionName", i.e((Context) aDYaiT.f4283A5SV6n));
                        jSONObject.put("versionCode", i.g((Context) aDYaiT.f4283A5SV6n) + "");
                        jSONObject.put(CommConstant.SdkVersion.SDK_VERSION_KEY, "2.5.10.5");
                        jSONObject.put("sdkTag", "OctopusAd");
                        jSONObject2.put("oaid", Octopus.getOaid((Context) aDYaiT.f4283A5SV6n));
                        jSONObject2.put("osVersion", Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT);
                        jSONObject2.put("vendor", Build.MANUFACTURER);
                        jSONObject2.put(bn.i, Build.MODEL);
                        jSONObject2.put(IAdInterListener.AdProdType.PRODUCT_CPU, Build.CPU_ABI);
                        jSONObject.put("device", jSONObject2);
                        jSONObject.put("crashType", z ? "native" : "java");
                        jSONObject.put("crashMessage", str2);
                        String m = q.a().m();
                        if (z) {
                            str = m + "/sdk/soCrashReport";
                        } else {
                            str = m + "/sdk/crashReport";
                        }
                        d.a(str, jSONObject.toString().getBytes());
                    } catch (Exception e) {
                        f.a("OctopusAd", "An Exception Caught", e);
                    }
                    if (!z) {
                        try {
                            if (Environment.getExternalStorageState().equals("mounted") && (context = (Context) aDYaiT.f4283A5SV6n) != null) {
                                File a2 = h.a(context);
                                f.a("OctopusAd", "CrashHandler storagePath == " + a2);
                                if (a2 != null) {
                                    String str3 = a2.getPath() + "/Octopus/log/";
                                    File file = new File(str3);
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    String format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
                                    File file2 = new File(str3 + "crash_" + format + ".trace");
                                    file2.createNewFile();
                                    FileWriter fileWriter = new FileWriter(file2, true);
                                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                    bufferedWriter.write(format);
                                    bufferedWriter.write("\r\n");
                                    bufferedWriter.write("------------------crash----------------------");
                                    bufferedWriter.write("\r\n");
                                    bufferedWriter.write(str2);
                                    bufferedWriter.write("\r\n");
                                    bufferedWriter.write("-------------------end-----------------------");
                                    bufferedWriter.newLine();
                                    bufferedWriter.close();
                                    fileWriter.close();
                                }
                            }
                        } catch (Exception e2) {
                            f.a("OctopusAd", "An Exception Caught", e2);
                        } catch (Throwable th) {
                            f.a("OctopusAd", "A Throwable Caught", th);
                        }
                    }
                }
                Looper.loop();
                break;
            default:
                try {
                    ServerSocket serverSocket = ((B25kr6) this.f7457AzWtSf).f7820A4TApA;
                    ((B25kr6) this.f7457AzWtSf).getClass();
                    serverSocket.bind(new InetSocketAddress(((B25kr6) this.f7457AzWtSf).f7819A2egSU));
                    this.f7455AlLFFp = true;
                    do {
                        try {
                            Socket accept = ((B25kr6) this.f7457AzWtSf).f7820A4TApA.accept();
                            accept.setSoTimeout(5000);
                            InputStream inputStream = accept.getInputStream();
                            B25kr6 b25kr6 = (B25kr6) this.f7457AzWtSf;
                            b25kr6.AMqCpz.A2egSU(new Qo94AZ.A2egSU(b25kr6, inputStream, accept));
                        } catch (IOException e3) {
                            B25kr6.f7818AZkASS.log(Level.FINE, "Communication with the client broken", (Throwable) e3);
                        }
                    } while (!((B25kr6) this.f7457AzWtSf).f7820A4TApA.isClosed());
                } catch (IOException e4) {
                    this.f7456AmA8tU = e4;
                    return;
                }
        }
    }

    public A2egSU(B25kr6 b25kr6) {
        this.f7454AcNBzu = 1;
        this.f7457AzWtSf = b25kr6;
        this.f7455AlLFFp = false;
    }
}
