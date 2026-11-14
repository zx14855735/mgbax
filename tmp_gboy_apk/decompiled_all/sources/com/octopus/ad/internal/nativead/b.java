package com.octopus.ad.internal.nativead;

import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.d;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.s;
import com.octopus.ad.internal.utilities.HaoboLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends s {

    /* renamed from: a, reason: collision with root package name */
    private final SoftReference<a> f12451a;

    public b(a aVar) {
        this.f12451a = new SoftReference<>(aVar);
    }

    @Override // com.octopus.ad.internal.e
    public void a() {
        a aVar = this.f12451a.get();
        if (aVar == null) {
            HaoboLog.e(HaoboLog.baseLogTag, "Before execute request manager, you should set ad request!");
            return;
        }
        e();
        try {
            aVar.a(this);
            aVar.m();
        } catch (IllegalStateException e) {
            e.getMessage();
        } catch (RejectedExecutionException e2) {
            HaoboLog.e(HaoboLog.baseLogTag, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.octopus.ad.internal.e
    public d b() {
        a aVar = this.f12451a.get();
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }

    @Override // com.octopus.ad.internal.s
    public void c() {
    }

    @Override // com.octopus.ad.internal.e
    public void a(int i) {
        f();
        a aVar = this.f12451a.get();
        if (aVar != null) {
            aVar.k().a(i);
        }
    }

    @Override // com.octopus.ad.internal.e
    public void a(final ServerResponse serverResponse) {
        final a aVar = this.f12451a.get();
        if (aVar != null) {
            if (!serverResponse.t()) {
                HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_no_ads));
                aVar.k().a(80100);
                return;
            }
            final c cVar = (c) serverResponse.k();
            if (cVar == null) {
                return;
            }
            cVar.f(aVar.b());
            a(new com.octopus.ad.internal.network.b() { // from class: com.octopus.ad.internal.nativead.b.1
                @Override // com.octopus.ad.internal.network.b
                public p a() {
                    return aVar.getMediaType();
                }

                @Override // com.octopus.ad.internal.network.b
                public NativeAdResponse b() {
                    return cVar;
                }

                @Override // com.octopus.ad.internal.network.b
                public int c() {
                    return serverResponse.p();
                }

                @Override // com.octopus.ad.internal.network.b
                public String d() {
                    return serverResponse.r();
                }

                @Override // com.octopus.ad.internal.network.b
                public long e() {
                    return serverResponse.s();
                }
            });
        }
    }

    public void a(com.octopus.ad.internal.network.b bVar) {
        f();
        a aVar = this.f12451a.get();
        if (aVar != null) {
            aVar.k().a(bVar);
        }
    }
}
