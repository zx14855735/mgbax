package com.fl.saas.s2s.sdk.helper;

import android.content.Context;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.s2s.sdk.helper.DownloadTipDialog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements DownloadTipDialog.OnAgreeClickListener, YdCommonDialog.OnSubmitListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10865AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CommJumpHelper f10866AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Context f10867AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AdInfoPoJo f10868AzWtSf;

    public /* synthetic */ A2egSU(CommJumpHelper commJumpHelper, Context context, AdInfoPoJo adInfoPoJo, int i) {
        this.f10865AcNBzu = i;
        this.f10866AlLFFp = commJumpHelper;
        this.f10867AmA8tU = context;
        this.f10868AzWtSf = adInfoPoJo;
    }

    @Override // com.fl.saas.s2s.sdk.helper.DownloadTipDialog.OnAgreeClickListener, com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
    public final void onClick() {
        switch (this.f10865AcNBzu) {
            case 0:
                this.f10866AlLFFp.lambda$jump2Download$0(this.f10867AmA8tU, this.f10868AzWtSf);
                break;
            default:
                this.f10866AlLFFp.lambda$jump2App$1(this.f10867AmA8tU, this.f10868AzWtSf);
                break;
        }
    }
}
