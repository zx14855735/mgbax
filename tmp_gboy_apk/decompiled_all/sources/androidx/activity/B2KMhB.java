package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB implements OnBackAnimationCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Function1 f7961A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Function1 f7962A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Function0 f7963A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ Function0 f7964ADYaiT;

    public B2KMhB(Function1 function1, Function1 function12, Function0 function0, Function0 function02) {
        this.f7961A2egSU = function1;
        this.f7962A4TApA = function12;
        this.f7963A5SV6n = function0;
        this.f7964ADYaiT = function02;
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        this.f7964ADYaiT.invoke();
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f7963A5SV6n.invoke();
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        this.f7962A4TApA.invoke(new A4TApA(backEvent));
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        this.f7961A2egSU.invoke(new A4TApA(backEvent));
    }
}
