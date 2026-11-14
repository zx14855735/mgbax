package MTKlkd;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    @PlKZ28.A5SV6n("updateUrl")
    private String f5260A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    @PlKZ28.A5SV6n("latestVersion")
    private String f5261A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    @PlKZ28.A5SV6n("announcement")
    private String f5262A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    @PlKZ28.A5SV6n("changeLog")
    private String f5263ADYaiT;

    @PlKZ28.A5SV6n("forceUpdate")
    private boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    @PlKZ28.A5SV6n("vip")
    private boolean f5264ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    @PlKZ28.A5SV6n(a.f13169a)
    private List<A2egSU> f5265ASJ6gh;

    public static class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        @PlKZ28.A5SV6n(f.f13353a)
        private int f5266A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        @PlKZ28.A5SV6n("title")
        private String f5267A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        @PlKZ28.A5SV6n(IAdInterListener.AdProdType.PRODUCT_CONTENT)
        private String f5268A5SV6n;

        /* renamed from: ADYaiT, reason: collision with root package name */
        @PlKZ28.A5SV6n("avatar")
        private String f5269ADYaiT;

        @PlKZ28.A5SV6n("cover")
        private String AMqCpz;

        /* renamed from: ARc23Z, reason: collision with root package name */
        @PlKZ28.A5SV6n("url")
        private String f5270ARc23Z;

        public final String A2egSU() {
            return this.f5269ADYaiT;
        }

        public final String A4TApA() {
            return this.f5268A5SV6n;
        }

        public final String A5SV6n() {
            return this.AMqCpz;
        }

        public final int ADYaiT() {
            return this.f5266A2egSU;
        }

        public final String AMqCpz() {
            return this.f5267A4TApA;
        }

        public final String ARc23Z() {
            return this.f5270ARc23Z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            A2egSU a2egSU = (A2egSU) obj;
            if (this.f5266A2egSU == a2egSU.f5266A2egSU && this.f5267A4TApA.equals(a2egSU.f5267A4TApA) && this.f5268A5SV6n.equals(a2egSU.f5268A5SV6n) && this.f5269ADYaiT.equals(a2egSU.f5269ADYaiT) && this.AMqCpz.equals(a2egSU.AMqCpz)) {
                return this.f5270ARc23Z.equals(a2egSU.f5270ARc23Z);
            }
            return false;
        }

        public final int hashCode() {
            return this.f5270ARc23Z.hashCode() + com.bykv.vk.component.ttvideo.player.A2egSU.A2egSU(com.bykv.vk.component.ttvideo.player.A2egSU.A2egSU(com.bykv.vk.component.ttvideo.player.A2egSU.A2egSU(com.bykv.vk.component.ttvideo.player.A2egSU.A2egSU(this.f5266A2egSU * 31, 31, this.f5267A4TApA), 31, this.f5268A5SV6n), 31, this.f5269ADYaiT), 31, this.AMqCpz);
        }
    }

    public final List A2egSU() {
        return this.f5265ASJ6gh;
    }

    public final String A4TApA() {
        return this.f5262A5SV6n;
    }

    public final String A5SV6n() {
        return this.f5263ADYaiT;
    }

    public final String ADYaiT() {
        return this.f5261A4TApA;
    }

    public final String AMqCpz() {
        return this.f5260A2egSU;
    }

    public final boolean ARc23Z() {
        return this.f5264ARc23Z;
    }

    public final boolean ASJ6gh() {
        return this.AMqCpz;
    }
}
