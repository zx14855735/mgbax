package DUi7mC;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Executor f2156A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AMqCpz f2157A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final byte[] f2158A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final File f2159ADYaiT;
    public final String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f2160ARc23Z = false;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public A5SV6n[] f2161ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public byte[] f2162AYUAbz;

    public A4TApA(AssetManager assetManager, Executor executor, AMqCpz aMqCpz, String str, File file) {
        this.f2156A2egSU = executor;
        this.f2157A4TApA = aMqCpz;
        this.AMqCpz = str;
        this.f2159ADYaiT = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i >= 24 && i <= 34) {
            switch (i) {
                case 24:
                case 25:
                    bArr = ARc23Z.f2177AYUAbz;
                    break;
                case 26:
                    bArr = ARc23Z.f2176ASJ6gh;
                    break;
                case 27:
                    bArr = ARc23Z.f2175ARc23Z;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = ARc23Z.AMqCpz;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    bArr = ARc23Z.f2174ADYaiT;
                    break;
            }
        }
        this.f2158A5SV6n = bArr;
    }

    public final FileInputStream A2egSU(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null) {
                return null;
            }
            message.contains("compressed");
            return null;
        }
    }

    public final void A4TApA(int i, Serializable serializable) {
        this.f2156A2egSU.execute(new A2egSU(i, 0, this, serializable));
    }
}
