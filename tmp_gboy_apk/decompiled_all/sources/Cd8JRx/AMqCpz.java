package Cd8JRx;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends InputConnectionWrapper {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f1780A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AMqCpz(InputConnection inputConnection, ADYaiT aDYaiT) {
        super(inputConnection, false);
        this.f1780A2egSU = aDYaiT;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        KCxDWD.A5SV6n a5SV6n = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            a5SV6n = new KCxDWD.A5SV6n(10, new ASJ6gh(inputContentInfo));
        }
        if (this.f1780A2egSU.A5SV6n(a5SV6n, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
