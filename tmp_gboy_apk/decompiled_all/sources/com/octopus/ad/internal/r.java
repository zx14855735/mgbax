package com.octopus.ad.internal;

import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.StringUtil;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class r extends s {

    /* renamed from: a, reason: collision with root package name */
    private com.octopus.ad.internal.network.a f12520a;
    private final d b = new d(q.a().j(), StringUtil.createRequestId());

    @Override // com.octopus.ad.internal.e
    public void a() {
        this.f12520a = new com.octopus.ad.internal.network.a(new a.C0411a());
        e();
        try {
            this.f12520a.a(this);
            this.f12520a.m();
        } catch (RejectedExecutionException e) {
            HaoboLog.e(HaoboLog.baseLogTag, "Concurrent Thread Exception while firing new ad request: " + e.getMessage());
        } catch (Exception e2) {
            HaoboLog.e(HaoboLog.baseLogTag, "Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.octopus.ad.internal.e
    public d b() {
        return this.b;
    }

    @Override // com.octopus.ad.internal.s
    public void c() {
        if (this.f12520a != null) {
            this.f12520a = null;
        }
    }

    @Override // com.octopus.ad.internal.e
    public void a(int i) {
        HaoboLog.d(HaoboLog.pbLogTag, "Failed to load prefetch request: " + i);
    }

    @Override // com.octopus.ad.internal.e
    public void a(ServerResponse serverResponse) {
        Iterator<String> it = serverResponse.aa().iterator();
        while (it.hasNext()) {
            String next = it.next();
            HaoboLog.d(HaoboLog.baseLogTag, "Prefetch resource: " + next);
        }
    }
}
