package ADYaiT;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CqNSpT extends androidx.activity.AcNBzu implements B3GDIM {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public CkXcdM f204AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final CmUvjW f205B25kr6;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [ADYaiT.CmUvjW] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CqNSpT(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 2130969012(0x7f0401b4, float:1.7546694E38)
            if (r6 != 0) goto L15
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L16
        L15:
            r2 = r6
        L16:
            r4.<init>(r5, r2)
            ADYaiT.CmUvjW r2 = new ADYaiT.CmUvjW
            r2.<init>()
            r4.f205B25kr6 = r2
            ADYaiT.BJ7GGh r2 = r4.A5SV6n()
            if (r6 != 0) goto L34
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L34:
            r5 = r2
            ADYaiT.CkXcdM r5 = (ADYaiT.CkXcdM) r5
            r5.f191DG07BK = r6
            r2.A5SV6n()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CqNSpT.<init>(android.content.Context, int):void");
    }

    public final BJ7GGh A5SV6n() {
        if (this.f204AzWtSf == null) {
            BI9f7h bI9f7h = BJ7GGh.f97AcNBzu;
            this.f204AzWtSf = new CkXcdM(getContext(), getWindow(), this, this);
        }
        return this.f204AzWtSf;
    }

    public final void ADYaiT() {
        androidx.lifecycle.CQhlFr.ARc23Z(getWindow().getDecorView(), this);
        JrXYwF.A4TApA.CtFAbx(getWindow().getDecorView(), this);
        JrXYwF.A4TApA.CtxOCS(getWindow().getDecorView(), this);
    }

    public final boolean AMqCpz(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        CkXcdM ckXcdM = (CkXcdM) A5SV6n();
        ckXcdM.BIYEnU();
        ((ViewGroup) ckXcdM.f172CQhlFr.findViewById(R.id.content)).addView(view, layoutParams);
        ckXcdM.f159BIYEnU.A2egSU(ckXcdM.f158BI9f7h.getCallback());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        A5SV6n().ADYaiT();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return NOd7IU.AlLFFp.BpkvW3(this.f205B25kr6, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        CkXcdM ckXcdM = (CkXcdM) A5SV6n();
        ckXcdM.BIYEnU();
        return ckXcdM.f158BI9f7h.findViewById(i);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        A5SV6n().A2egSU();
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public void onCreate(Bundle bundle) {
        CkXcdM ckXcdM = (CkXcdM) A5SV6n();
        LayoutInflater from = LayoutInflater.from(ckXcdM.f157BChYOn);
        if (from.getFactory() == null) {
            from.setFactory2(ckXcdM);
        } else {
            boolean z = from.getFactory2() instanceof CkXcdM;
        }
        super.onCreate(bundle);
        A5SV6n().A5SV6n();
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public final void onStop() {
        super.onStop();
        CkXcdM ckXcdM = (CkXcdM) A5SV6n();
        ckXcdM.BV3sI0();
        A2egSU a2egSU = ckXcdM.f161BNL6CD;
        if (a2egSU != null) {
            a2egSU.AzWtSf(false);
        }
    }

    @Override // ADYaiT.B3GDIM
    public final void onSupportActionModeFinished(AZOQYO.A4TApA a4TApA) {
    }

    @Override // ADYaiT.B3GDIM
    public final void onSupportActionModeStarted(AZOQYO.A4TApA a4TApA) {
    }

    @Override // ADYaiT.B3GDIM
    public final AZOQYO.A4TApA onWindowStartingSupportActionMode(AZOQYO.A2egSU a2egSU) {
        return null;
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public void setContentView(int i) {
        ADYaiT();
        A5SV6n().ASJ6gh(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        A5SV6n().AlLFFp(charSequence);
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public void setContentView(View view) {
        ADYaiT();
        A5SV6n().AYUAbz(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        A5SV6n().AlLFFp(getContext().getString(i));
    }

    @Override // androidx.activity.AcNBzu, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ADYaiT();
        A5SV6n().AZOQYO(view, layoutParams);
    }
}
