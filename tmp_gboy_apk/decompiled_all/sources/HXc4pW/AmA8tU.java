package HXc4pW;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final KCxDWD.A5SV6n f3559A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile Hdahpu.A2egSU f3560A4TApA;

    public AmA8tU(KCxDWD.A5SV6n a5SV6n) {
        this.f3559A2egSU = a5SV6n;
    }

    public final Hdahpu.A2egSU A2egSU() {
        if (this.f3560A4TApA == null) {
            synchronized (this) {
                try {
                    if (this.f3560A4TApA == null) {
                        File cacheDir = ((NOd7IU.AmA8tU) this.f3559A2egSU.f4241AlLFFp).f5913AlLFFp.getCacheDir();
                        Hdahpu.ADYaiT aDYaiT = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            aDYaiT = new Hdahpu.ADYaiT(file);
                        }
                        this.f3560A4TApA = aDYaiT;
                    }
                    if (this.f3560A4TApA == null) {
                        this.f3560A4TApA = new Hdahpu.A4TApA();
                    }
                } finally {
                }
            }
        }
        return this.f3560A4TApA;
    }
}
