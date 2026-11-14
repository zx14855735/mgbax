package FdMWEC;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialEnvelopeView;
import com.google.android.material.search.SearchView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2798AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2799AlLFFp;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f2798AcNBzu = i;
        this.f2799AlLFFp = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean lambda$setAdType$0;
        Object obj = this.f2799AlLFFp;
        switch (this.f2798AcNBzu) {
            case 0:
                ((GestureDetector) obj).onTouchEvent(motionEvent);
                return false;
            case 1:
                int i = SearchView.f11758Cd8JRx;
                SearchView searchView = (SearchView) obj;
                if (searchView.AYUAbz()) {
                    searchView.ARc23Z();
                }
                return false;
            case 2:
                PWr3nF.AZkASS aZkASS = (PWr3nF.AZkASS) obj;
                aZkASS.getClass();
                if (motionEvent.getAction() == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - aZkASS.f7318AzWtSf;
                    if (uptimeMillis < 0 || uptimeMillis > 300) {
                        aZkASS.f7316AlLFFp = false;
                    }
                    aZkASS.B9tovu();
                    aZkASS.f7316AlLFFp = true;
                    aZkASS.f7318AzWtSf = SystemClock.uptimeMillis();
                }
                return false;
            default:
                lambda$setAdType$0 = ((InterstitialEnvelopeView) obj).lambda$setAdType$0(view, motionEvent);
                return lambda$setAdType$0;
        }
    }
}
