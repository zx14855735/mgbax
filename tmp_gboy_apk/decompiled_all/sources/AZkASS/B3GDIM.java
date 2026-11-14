package AZkASS;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM extends FrameLayout implements AZOQYO.A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CollapsibleActionView f551AcNBzu;

    /* JADX WARN: Multi-variable type inference failed */
    public B3GDIM(View view) {
        super(view.getContext());
        this.f551AcNBzu = (CollapsibleActionView) view;
        addView(view);
    }
}
