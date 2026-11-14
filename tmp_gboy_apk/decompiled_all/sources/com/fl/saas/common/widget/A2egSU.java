package com.fl.saas.common.widget;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10831AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SkipView f10832AlLFFp;

    public /* synthetic */ A2egSU(SkipView skipView, int i) {
        this.f10831AcNBzu = i;
        this.f10832AlLFFp = skipView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10831AcNBzu) {
            case 0:
                this.f10832AlLFFp.lambda$onClick$3(view);
                break;
            case 1:
                this.f10832AlLFFp.lambda$onClick$4(view);
                break;
            case 2:
                this.f10832AlLFFp.lambda$setShowCountDown$0(view);
                break;
            case 3:
                this.f10832AlLFFp.lambda$setShowCountDown$1(view);
                break;
            default:
                this.f10832AlLFFp.lambda$setShowCountDown$2(view);
                break;
        }
    }
}
