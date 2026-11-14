package com.fl.saas.base.adapter;

import com.fl.saas.base.adapter.AdViewSpreadAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AZkASS implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10726AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f10727AlLFFp;

    public /* synthetic */ AZkASS(int i, Object obj) {
        this.f10726AcNBzu = i;
        this.f10727AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10726AcNBzu) {
            case 0:
                ((AdViewSpreadAdapter.SpreadLoadAd) this.f10727AlLFFp).lambda$show$0();
                break;
            case 1:
                ((AdViewMixNativeAdapter) this.f10727AlLFFp).lambda$showAd$2();
                break;
            default:
                ((AdViewSpreadAdapter) this.f10727AlLFFp).lambda$showAd$1();
                break;
        }
    }
}
