package com.octopus.ad.internal.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.IBidding;
import com.octopus.ad.NativeAdListener;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.d;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.o;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.DeviceInfoUtil;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.ImageService;
import com.octopus.ad.internal.utilities.LocationInfoUtil;
import com.octopus.ad.internal.utilities.StringUtil;
import com.octopus.ad.internal.utilities.UserEnvInfoUtil;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.b.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.octopus.ad.internal.network.a implements IBidding, com.octopus.ad.internal.a {

    /* renamed from: a, reason: collision with root package name */
    public com.octopus.ad.internal.c f12446a;
    private NativeAdListener c;
    private C0406a d;
    private boolean e;
    private boolean f;
    private Context g;
    private d h;
    private int i;
    private String j;
    private String k;
    private long l;
    private long m;
    private boolean n = false;
    private boolean o = false;

    /* renamed from: com.octopus.ad.internal.nativead.a$a, reason: collision with other inner class name */
    public class C0406a implements com.octopus.ad.internal.b, ImageService.ImageServiceListener {

        /* renamed from: a, reason: collision with root package name */
        ImageService f12447a;
        NativeAdResponse b;

        private C0406a() {
        }

        @Override // com.octopus.ad.internal.b
        public void a(long j) {
        }

        @Override // com.octopus.ad.internal.b
        public void b() {
        }

        @Override // com.octopus.ad.internal.b
        public void c() {
        }

        @Override // com.octopus.ad.internal.b
        public void d() {
        }

        @Override // com.octopus.ad.internal.utilities.ImageService.ImageServiceListener
        public void onAllImageDownloadsFinish() {
            if (a.this.c != null) {
                a.this.c.onAdLoaded(this.b);
            }
            this.f12447a = null;
            this.b = null;
            a.this.o = false;
        }

        @Override // com.octopus.ad.internal.b
        public void a(com.octopus.ad.internal.view.b bVar) {
        }

        @Override // com.octopus.ad.internal.b
        public void a(boolean z) {
        }

        @Override // com.octopus.ad.internal.b
        public void a(com.octopus.ad.internal.network.b bVar) {
            if (!bVar.a().equals(p.NATIVE) && !bVar.a().equals(p.BANNER) && !bVar.a().equals(p.DRAW)) {
                a(80103);
                return;
            }
            final NativeAdResponse b = bVar.b();
            if (b == null) {
                return;
            }
            this.b = b;
            c cVar = (c) b;
            cVar.a(a.this);
            cVar.a(a.this.h());
            cVar.a(a.this.g);
            if (a.this.h.l()) {
                cVar.h();
                return;
            }
            if (cVar.a() != 1) {
                a.this.n = true;
                a.this.m = System.currentTimeMillis();
                a.this.a(bVar.c());
                a.this.b(bVar.d());
                a.this.a(bVar.e());
                a.this.e(b.getLandingPageUrl());
                cVar.a(a.this.m, a.this.l);
                if (!a.this.e && !a.this.f) {
                    if (a.this.c != null) {
                        a.this.c.onAdLoaded(b);
                    }
                    a.this.o = false;
                    return;
                }
                this.f12447a = new ImageService();
                if (a.this.e) {
                    this.f12447a.registerImageReceiver(new ImageService.ImageReceiver() { // from class: com.octopus.ad.internal.nativead.a.a.1
                        @Override // com.octopus.ad.internal.utilities.ImageService.ImageReceiver
                        public void onFail() {
                            HaoboLog.e(HaoboLog.httpRespLogTag, "Image downloading logFailed for url " + b.getImageUrl());
                        }

                        @Override // com.octopus.ad.internal.utilities.ImageService.ImageReceiver
                        public void onReceiveImage(Bitmap bitmap) {
                            b.setImage(bitmap);
                        }
                    }, b.getImageUrl());
                }
                if (a.this.f) {
                    this.f12447a.registerImageReceiver(new ImageService.ImageReceiver() { // from class: com.octopus.ad.internal.nativead.a.a.2
                        @Override // com.octopus.ad.internal.utilities.ImageService.ImageReceiver
                        public void onFail() {
                            HaoboLog.e(HaoboLog.httpRespLogTag, "Image downloading logFailed for url " + b.getIconUrl());
                        }

                        @Override // com.octopus.ad.internal.utilities.ImageService.ImageReceiver
                        public void onReceiveImage(Bitmap bitmap) {
                            b.setIcon(bitmap);
                        }
                    }, b.getIconUrl());
                }
                this.f12447a.registerNotification(this);
                this.f12447a.execute();
                return;
            }
            a(80100);
            cVar.g();
            if (cVar.i()) {
                return;
            }
            com.octopus.ad.internal.network.a.a(a.this.h.b(), cVar.b());
        }

        @Override // com.octopus.ad.internal.b
        public void a(final int i) {
            ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.nativead.a.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.c != null) {
                        a.this.c.onAdFailed(i);
                    }
                }
            });
            a.this.o = false;
        }

        @Override // com.octopus.ad.internal.b
        public void a() {
            NativeAdResponse nativeAdResponse = this.b;
            if (nativeAdResponse != null) {
                nativeAdResponse.destroy();
                this.b = null;
            }
        }
    }

    public a(Context context, String str, p pVar) {
        this.g = context;
        DeviceInfoUtil.retrieveDeviceInfo(context.getApplicationContext());
        UserEnvInfoUtil.retrieveUserEnvInfo(context.getApplicationContext());
        LocationInfoUtil.refreshLocation(context.getApplicationContext());
        d dVar = new d(context, StringUtil.createRequestId());
        this.h = dVar;
        dVar.a(str);
        this.h.a(1);
        this.h.a(pVar);
        com.octopus.ad.internal.c cVar = new com.octopus.ad.internal.c(this);
        this.f12446a = cVar;
        cVar.a(-1);
        this.d = new C0406a();
    }

    @Override // com.octopus.ad.internal.a
    public p getMediaType() {
        return this.h.p();
    }

    public String h() {
        return !TextUtils.isEmpty(this.h.f()) ? this.h.f() : this.h.a();
    }

    public d i() {
        return this.h;
    }

    public void j() {
        o.a(new l("LOAD", c(), h()));
    }

    public com.octopus.ad.internal.b k() {
        return this.d;
    }

    public void l() {
        this.d.a();
    }

    @Override // com.octopus.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        NativeAdResponse nativeAdResponse;
        try {
            C0406a c0406a = this.d;
            if (c0406a == null || (nativeAdResponse = c0406a.b) == null) {
                return;
            }
            c cVar = (c) nativeAdResponse;
            cVar.a(i, str, str2);
            cVar.g();
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    @Override // com.octopus.ad.IBidding
    public void sendWinNotice(int i) {
        NativeAdResponse nativeAdResponse;
        try {
            C0406a c0406a = this.d;
            if (c0406a == null || (nativeAdResponse = c0406a.b) == null) {
                return;
            }
            ((c) nativeAdResponse).b(i);
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public String c() {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.get_placement_id, this.h.c()));
        return this.h.c();
    }

    public int d() {
        return this.i;
    }

    public String e() {
        return this.j;
    }

    public boolean f() {
        return this.n;
    }

    public boolean g() {
        return System.currentTimeMillis() - this.m < this.l;
    }

    public boolean b() {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.get_opens_native_browser, this.h.o()));
        return this.h.o();
    }

    public void d(String str) {
        this.h.c(str);
    }

    public void e(String str) {
        this.k = str;
    }

    public void a(boolean z) {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.set_opens_native_browser, z));
        this.h.c(z);
    }

    public void a(String str) {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.set_placement_id, str));
        this.h.a(str);
    }

    public void c(String str) {
        this.h.b(str);
    }

    public void b(boolean z) {
        a(z);
    }

    public void a(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.j = str;
    }

    public void a(long j) {
        q.s = j;
        this.l = j;
    }

    public void a(NativeAdListener nativeAdListener) {
        this.c = nativeAdListener;
    }

    @Override // com.octopus.ad.internal.a
    public boolean a() {
        return this.h.q();
    }

    public boolean a(a.C0411a c0411a) {
        if (this.o) {
            HaoboLog.e(HaoboLog.nativeLogTag, "Still loading last nativead ad , won't load a new ad");
            return false;
        }
        j();
        if (this.h.q()) {
            this.f12446a.a();
            this.f12446a.d();
            this.f12446a.c();
            this.o = true;
            return true;
        }
        C0406a c0406a = this.d;
        if (c0406a != null) {
            c0406a.a(MediationConstant.ErrorCode.ADN_INIT_FAIL);
        }
        return false;
    }
}
