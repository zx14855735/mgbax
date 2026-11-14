package com.fl.saas.common.widget;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10833AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ VisibilityLayout f10834AlLFFp;

    public /* synthetic */ A4TApA(VisibilityLayout visibilityLayout, int i) {
        this.f10833AcNBzu = i;
        this.f10834AlLFFp = visibilityLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10833AcNBzu) {
            case 0:
                this.f10834AlLFFp.checkAreaRatio();
                break;
            default:
                this.f10834AlLFFp.checkValidArea();
                break;
        }
    }
}
