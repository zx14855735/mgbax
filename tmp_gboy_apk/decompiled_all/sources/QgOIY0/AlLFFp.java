package QgOIY0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AlLFFp extends AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f7534AcNBzu;

    public static void A2egSU(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        ((B3GDIM) ((B7CMnp) this).f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.ASJ6gh(view, str, context, attributeSet);
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.f7534AcNBzu && i != -1) {
            A2egSU(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            A2egSU(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (i != -1) {
            A2egSU(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        ((B3GDIM) ((B7CMnp) this).f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.ASJ6gh(null, str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }
}
