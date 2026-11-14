package com.fl.saas.config.http;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10836AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ HttpUtils f10837AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f10838AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ HttpCallbackStringListener f10839AzWtSf;

    public /* synthetic */ A2egSU(HttpUtils httpUtils, String str, HttpCallbackStringListener httpCallbackStringListener, int i) {
        this.f10836AcNBzu = i;
        this.f10837AlLFFp = httpUtils;
        this.f10838AmA8tU = str;
        this.f10839AzWtSf = httpCallbackStringListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10836AcNBzu) {
            case 0:
                this.f10837AlLFFp.lambda$doGet$0(this.f10838AmA8tU, this.f10839AzWtSf);
                break;
            default:
                this.f10837AlLFFp.lambda$doGet$1(this.f10838AmA8tU, this.f10839AzWtSf);
                break;
        }
    }
}
