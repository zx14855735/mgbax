package DaOi9o;

import android.os.Build;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CSDoyG extends CNPG0E {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static boolean f2287BI9f7h = true;

    @Override // ADYaiT.BmvVmW
    public void AcNBzu(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.AcNBzu(view, i);
        } else if (f2287BI9f7h) {
            try {
                CQhlFr.A2egSU(view, i);
            } catch (NoSuchMethodError unused) {
                f2287BI9f7h = false;
            }
        }
    }
}
