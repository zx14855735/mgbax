package com.fl.saas.s2s.mixNative;

import android.app.Activity;
import android.view.View;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10848AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ S2SNative f10849AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Activity f10850AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f10851AzWtSf;

    public /* synthetic */ ADYaiT(S2SNative s2SNative, Object obj, Activity activity, int i) {
        this.f10848AcNBzu = i;
        this.f10849AlLFFp = s2SNative;
        this.f10851AzWtSf = obj;
        this.f10850AmA8tU = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10848AcNBzu) {
            case 0:
                this.f10849AlLFFp.lambda$bindMediaViewClick$6((AdInfoPoJo) this.f10851AzWtSf, this.f10850AmA8tU, view);
                break;
            default:
                this.f10849AlLFFp.lambda$bindClickViews$5((List) this.f10851AzWtSf, this.f10850AmA8tU, view);
                break;
        }
    }
}
