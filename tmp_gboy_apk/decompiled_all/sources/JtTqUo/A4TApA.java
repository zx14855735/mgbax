package JtTqUo;

import BPw6Q8.ASJ6gh;
import D8MqeW.AzWtSf;
import L2suez.B3GDIM;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;
import com.bumptech.glide.AMqCpz;
import com.kuaishou.weapon.p0.g;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4166AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Context f4167AlLFFp;

    public /* synthetic */ A4TApA() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        NetworkInfo activeNetworkInfo;
        switch (this.f4166AcNBzu) {
            case 0:
                Context context = this.f4167AlLFFp;
                try {
                    try {
                        EsrwYR.A4TApA a4TApA = new EsrwYR.A4TApA();
                        a4TApA.f2550AlLFFp = context;
                        boolean z = false;
                        try {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                                if (activeNetworkInfo.isAvailable()) {
                                    z = true;
                                }
                            }
                        } catch (Exception unused) {
                        }
                        a4TApA.A2egSU(z);
                    } catch (Throwable unused2) {
                        AMqCpz.C2rE4F();
                    }
                    return;
                } finally {
                    AzWtSf.A2egSU(K7mCWO.A2egSU.A2egSU()).A4TApA();
                }
            case 1:
                Toast.makeText(this.f4167AlLFFp, "网络连接失败，请稍后再试", 0).show();
                return;
            default:
                Context context2 = this.f4167AlLFFp;
                if (context2 == null) {
                    return;
                }
                synchronized (B3GDIM.f4388A4TApA) {
                    try {
                        Context applicationContext = context2.getApplicationContext();
                        int i = Build.VERSION.SDK_INT;
                        boolean z2 = false;
                        if (i >= 30) {
                            try {
                                z2 = Environment.isExternalStorageManager();
                            } catch (Throwable unused3) {
                            }
                        } else if (i < 23 || ASJ6gh.A2egSU(applicationContext, g.j) == 0) {
                            z2 = true;
                        }
                        if (z2) {
                            File file = new File(Environment.getExternalStorageDirectory(), "GBoy/shader");
                            if (!B3GDIM.AMqCpz(file)) {
                                file.getAbsolutePath();
                                return;
                            } else {
                                file.getAbsolutePath();
                                B3GDIM.A5SV6n(context2, file);
                                return;
                            }
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    public A4TApA(Context context, Handler handler) {
        this.f4167AlLFFp = context;
    }

    public A4TApA(Context context) {
        this.f4167AlLFFp = context;
    }
}
