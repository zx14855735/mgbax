package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class B2KMhB implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13087AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f13088AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ File f13089AmA8tU;

    public /* synthetic */ B2KMhB(File file, String str, int i) {
        this.f13087AcNBzu = i;
        this.f13088AlLFFp = str;
        this.f13089AmA8tU = file;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13087AcNBzu) {
            case 0:
                q.b(this.f13088AlLFFp, this.f13089AmA8tU, obj);
                break;
            default:
                q.a(this.f13088AlLFFp, this.f13089AmA8tU, obj);
                break;
        }
    }
}
