package androidx.fragment.app;

import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class C2rE4F extends CQhlFr implements BPw6Q8.AaHO0E, BPw6Q8.AcNBzu, androidx.core.app.CqNSpT, androidx.core.app.CrfGsy, androidx.lifecycle.D07BeM, androidx.activity.B9tovu, androidx.activity.result.AYUAbz, DV2E8K.ARc23Z, DAk1zC, COJEAR.AmA8tU {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f8802B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2rE4F(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f8802B25kr6 = fragmentActivity;
    }

    @Override // androidx.fragment.app.DAk1zC
    public final void A2egSU(Fragment fragment) {
        this.f8802B25kr6.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.CNPG0E
    public final View A4TApA(int i) {
        return this.f8802B25kr6.findViewById(i);
    }

    @Override // androidx.fragment.app.CNPG0E
    public final boolean A5SV6n() {
        Window window = this.f8802B25kr6.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // COJEAR.AmA8tU
    public final void addMenuProvider(COJEAR.B7CMnp b7CMnp) {
        this.f8802B25kr6.addMenuProvider(b7CMnp);
    }

    @Override // BPw6Q8.AaHO0E
    public final void addOnConfigurationChangedListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.addOnConfigurationChangedListener(a2egSU);
    }

    @Override // androidx.core.app.CqNSpT
    public final void addOnMultiWindowModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.addOnMultiWindowModeChangedListener(a2egSU);
    }

    @Override // androidx.core.app.CrfGsy
    public final void addOnPictureInPictureModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.addOnPictureInPictureModeChangedListener(a2egSU);
    }

    @Override // BPw6Q8.AcNBzu
    public final void addOnTrimMemoryListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.addOnTrimMemoryListener(a2egSU);
    }

    @Override // androidx.activity.result.AYUAbz
    public final androidx.activity.result.ASJ6gh getActivityResultRegistry() {
        return this.f8802B25kr6.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.B9tovu
    public final androidx.lifecycle.AzWtSf getLifecycle() {
        return this.f8802B25kr6.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.B9tovu
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f8802B25kr6.getOnBackPressedDispatcher();
    }

    @Override // DV2E8K.ARc23Z
    public final DV2E8K.ADYaiT getSavedStateRegistry() {
        return this.f8802B25kr6.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.D07BeM
    public final androidx.lifecycle.CtxOCS getViewModelStore() {
        return this.f8802B25kr6.getViewModelStore();
    }

    @Override // COJEAR.AmA8tU
    public final void removeMenuProvider(COJEAR.B7CMnp b7CMnp) {
        this.f8802B25kr6.removeMenuProvider(b7CMnp);
    }

    @Override // BPw6Q8.AaHO0E
    public final void removeOnConfigurationChangedListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.removeOnConfigurationChangedListener(a2egSU);
    }

    @Override // androidx.core.app.CqNSpT
    public final void removeOnMultiWindowModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.removeOnMultiWindowModeChangedListener(a2egSU);
    }

    @Override // androidx.core.app.CrfGsy
    public final void removeOnPictureInPictureModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.removeOnPictureInPictureModeChangedListener(a2egSU);
    }

    @Override // BPw6Q8.AcNBzu
    public final void removeOnTrimMemoryListener(CNPG0E.A2egSU a2egSU) {
        this.f8802B25kr6.removeOnTrimMemoryListener(a2egSU);
    }
}
