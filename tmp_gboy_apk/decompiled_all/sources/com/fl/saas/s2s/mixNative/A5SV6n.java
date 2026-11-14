package com.fl.saas.s2s.mixNative;

import android.view.View;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.widget.InclineView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A5SV6n implements InclineView.InclineListener, ShakeView.ShakeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ S2SNative f10844AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AdInfoPoJo f10845AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ ActionView.Type f10846AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ View f10847AzWtSf;

    public /* synthetic */ A5SV6n(S2SNative s2SNative, AdInfoPoJo adInfoPoJo, ActionView.Type type, View view) {
        this.f10844AcNBzu = s2SNative;
        this.f10845AlLFFp = adInfoPoJo;
        this.f10846AmA8tU = type;
        this.f10847AzWtSf = view;
    }

    @Override // com.fl.saas.base.widget.InclineView.InclineListener
    public void onIncline(int i, int i2, int i3) {
        this.f10844AcNBzu.lambda$handleInclineView$9(this.f10845AlLFFp, this.f10846AmA8tU, this.f10847AzWtSf, i, i2, i3);
    }

    @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
    public void onShake(int i, int i2, int i3) {
        this.f10844AcNBzu.lambda$handleSharkView$8(this.f10845AlLFFp, this.f10846AmA8tU, this.f10847AzWtSf, i, i2, i3);
    }
}
