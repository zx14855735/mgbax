package GnQT2j;

import C4FrIb.B4ZgIw;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static AcNBzu f3128A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final K1Z3yj.A2egSU f3129A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ExecutorService f3130A4TApA = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public AcNBzu() {
        int i;
        Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
        context = context == null ? null : context;
        if (context != null) {
            K1Z3yj.A2egSU a2egSU = new K1Z3yj.A2egSU(23, false);
            try {
                a2egSU.f4174AlLFFp = new H0R8Px.ASJ6gh();
                AZkASS.ARc23Z aRc23Z = new AZkASS.ARc23Z(14);
                try {
                    File BChYOn2 = AZkASS.ARc23Z.BChYOn(context);
                    if (BChYOn2 != null) {
                        if (!BChYOn2.exists()) {
                            BChYOn2.mkdirs();
                        }
                        try {
                            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                        } catch (Exception e) {
                            e.printStackTrace();
                            i = 1;
                        }
                        aRc23Z.f451AlLFFp = H0R8Px.AMqCpz.A4TApA(BChYOn2, i);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                a2egSU.f4175AmA8tU = aRc23Z;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f3129A2egSU = a2egSU;
        }
    }

    public static AcNBzu A2egSU() {
        if (f3128A5SV6n == null) {
            synchronized (AcNBzu.class) {
                f3128A5SV6n = new AcNBzu();
            }
        }
        return f3128A5SV6n;
    }

    public final void A4TApA(String str, AaHO0E aaHO0E) {
        try {
            if (TextUtils.isEmpty(str)) {
                if (aaHO0E != null) {
                    aaHO0E.a(new Exception("image url is empty"));
                    return;
                }
                return;
            }
            K1Z3yj.A2egSU a2egSU = this.f3129A2egSU;
            Bitmap bitmap = null;
            if (a2egSU != null) {
                try {
                    H0R8Px.ASJ6gh aSJ6gh = (H0R8Px.ASJ6gh) a2egSU.f4174AlLFFp;
                    Bitmap bitmap2 = (aSJ6gh == null || TextUtils.isEmpty(str)) ? null : (Bitmap) aSJ6gh.f3152A2egSU.get(str);
                    if (bitmap2 != null) {
                        bitmap = bitmap2;
                    } else {
                        AZkASS.ARc23Z aRc23Z = (AZkASS.ARc23Z) a2egSU.f4175AmA8tU;
                        if (aRc23Z != null) {
                            try {
                                String AYUAbz2 = NOd7IU.AlLFFp.AYUAbz(str);
                                H0R8Px.AMqCpz aMqCpz = (H0R8Px.AMqCpz) aRc23Z.f451AlLFFp;
                                H0R8Px.ADYaiT ARc23Z2 = aMqCpz != null ? aMqCpz.ARc23Z(AYUAbz2) : null;
                                if (ARc23Z2 != null) {
                                    bitmap = BitmapFactory.decodeStream(ARc23Z2.f3137AcNBzu[0]);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (bitmap == null || aaHO0E == null) {
                this.f3130A4TApA.submit(new B4ZgIw(4, this, str, aaHO0E));
            } else {
                aaHO0E.a(bitmap);
            }
        } catch (Exception e3) {
            if (aaHO0E != null) {
                aaHO0E.a(e3);
            }
        }
    }
}
