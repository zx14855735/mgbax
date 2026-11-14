package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.i;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AaHO0E implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13071AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f13072AlLFFp;

    public /* synthetic */ AaHO0E(String str, int i) {
        this.f13071AcNBzu = i;
        this.f13072AlLFFp = str;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13071AcNBzu) {
            case 0:
                i.AnonymousClass3.f(this.f13072AlLFFp, obj);
                break;
            case 1:
                i.AnonymousClass3.e(this.f13072AlLFFp, obj);
                break;
            case 2:
                i.AnonymousClass3.d(this.f13072AlLFFp, obj);
                break;
            case 3:
                i.AnonymousClass3.c(this.f13072AlLFFp, obj);
                break;
            case 4:
                i.AnonymousClass3.b(this.f13072AlLFFp, obj);
                break;
            case 5:
                i.AnonymousClass3.a(this.f13072AlLFFp, obj);
                break;
            case 6:
                o.AnonymousClass2.a(this.f13072AlLFFp, obj);
                break;
            case 7:
                o.AnonymousClass2.c(this.f13072AlLFFp, obj);
                break;
            case 8:
                o.AnonymousClass2.b(this.f13072AlLFFp, obj);
                break;
            case 9:
                w.AnonymousClass1.a(this.f13072AlLFFp, obj);
                break;
            case 10:
                MiMarketManager.DirectMailStatusReceiver.c(this.f13072AlLFFp, obj);
                break;
            case 11:
                MiMarketManager.DirectMailStatusReceiver.b(this.f13072AlLFFp, obj);
                break;
            case 12:
                MiMarketManager.DirectMailStatusReceiver.a(this.f13072AlLFFp, obj);
                break;
            case 13:
                ae.a(this.f13072AlLFFp, obj);
                break;
            case 14:
                i.b(this.f13072AlLFFp, obj);
                break;
            case 15:
                i.a(this.f13072AlLFFp, obj);
                break;
            case 16:
                q.c(this.f13072AlLFFp, obj);
                break;
            case 17:
                q.b(this.f13072AlLFFp, obj);
                break;
            case 18:
                q.f(this.f13072AlLFFp, obj);
                break;
            case 19:
                q.e(this.f13072AlLFFp, obj);
                break;
            case 20:
                q.d(this.f13072AlLFFp, obj);
                break;
            case 21:
                q.a(this.f13072AlLFFp, obj);
                break;
            default:
                w.a(this.f13072AlLFFp, obj);
                break;
        }
    }
}
