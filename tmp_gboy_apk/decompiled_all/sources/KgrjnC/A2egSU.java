package KgrjnC;

import android.view.View;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4264AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ S2STemplateViewHelper f4265AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ View f4266AmA8tU;

    public /* synthetic */ A2egSU(S2STemplateViewHelper s2STemplateViewHelper, View view, int i) {
        this.f4264AcNBzu = i;
        this.f4265AlLFFp = s2STemplateViewHelper;
        this.f4266AmA8tU = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4264AcNBzu) {
            case 0:
                this.f4265AlLFFp.lambda$addFillActionView$4(this.f4266AmA8tU);
                break;
            default:
                this.f4265AlLFFp.lambda$addActionView$3(this.f4266AmA8tU);
                break;
        }
    }
}
