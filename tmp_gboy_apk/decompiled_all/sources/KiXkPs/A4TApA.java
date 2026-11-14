package KiXkPs;

import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.manager.AdViewNativeManager;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4268A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ boolean f4269A4TApA;

    public /* synthetic */ A4TApA(int i, boolean z) {
        this.f4268A2egSU = i;
        this.f4269A4TApA = z;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f4268A2egSU) {
            case 0:
                ((AdViewNativeManager) obj).setSoundEnable(this.f4269A4TApA);
                break;
            case 1:
                ((AdViewNativeAdapter) obj).soundControl(this.f4269A4TApA);
                break;
            default:
                ((AdViewSpreadAdapter) obj).setSoundEnable(this.f4269A4TApA);
                break;
        }
    }
}
