package com.sigmob.sdk.base.common;

import android.content.Context;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AzWtSf implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13082AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f13083AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Comparable f13084AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ BaseAdUnit f13085AzWtSf;

    public /* synthetic */ AzWtSf(Context context, Comparable comparable, BaseAdUnit baseAdUnit, int i) {
        this.f13082AcNBzu = i;
        this.f13083AlLFFp = context;
        this.f13084AmA8tU = comparable;
        this.f13085AzWtSf = baseAdUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13082AcNBzu) {
            case 0:
                o.AnonymousClass3.a(this.f13083AlLFFp, (com.sigmob.sdk.downloader.f) this.f13084AmA8tU, this.f13085AzWtSf);
                break;
            case 1:
                o.a(this.f13083AlLFFp, (com.sigmob.sdk.downloader.f) this.f13084AmA8tU, this.f13085AzWtSf);
                break;
            default:
                q.a(this.f13083AlLFFp, (File) this.f13084AmA8tU, this.f13085AzWtSf);
                break;
        }
    }
}
