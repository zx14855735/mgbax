package HFjH17;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.search.SearchView;
import com.sigmob.sdk.mraid.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3318AcNBzu;

    public /* synthetic */ AMqCpz(int i) {
        this.f3318AcNBzu = i;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean a2;
        boolean a3;
        switch (this.f3318AcNBzu) {
            case 1:
                int i = SearchView.f11758Cd8JRx;
            case 0:
                return true;
            case 2:
                a2 = h.a(view, motionEvent);
                return a2;
            default:
                a3 = com.sigmob.sdk.splash.h.a(view, motionEvent);
                return a3;
        }
    }
}
