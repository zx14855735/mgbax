package com.octopus.ad.internal.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.C;
import com.octopus.ad.AdActivity;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.DeviceInfoUtil;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.utils.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class InterstitialAdViewImpl extends AdViewImpl {
    public static InterstitialAdViewImpl t;
    private AdActivity.a A;
    protected boolean u;
    protected boolean v;
    private int w;
    private int x;
    private boolean y;
    private final Queue<d> z;

    public InterstitialAdViewImpl(Context context, p pVar, boolean z) {
        super(context);
        this.w = 0;
        this.x = 10000;
        this.z = new LinkedList();
        this.A = null;
        this.u = false;
        this.v = false;
        this.g = pVar;
        this.h = z;
        this.d.a(pVar);
        if (d()) {
            this.w = com.sigmob.sdk.base.blurkit.d.f13043a;
        } else if (z) {
            this.w = 0;
        } else {
            this.w = Color.argb(8, 0, 0, 0);
        }
    }

    private boolean b(b bVar) {
        if (bVar != null && !bVar.j()) {
            return true;
        }
        HaoboLog.e(HaoboLog.baseLogTag, "Loaded an ad with an invalid displayable");
        return false;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void a(Context context, AttributeSet attributeSet) {
        super.a(context, attributeSet);
        try {
            this.f.a(-1);
            DisplayMetrics displayMetrics = DeviceInfoUtil.getDisplayMetrics(context);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            try {
                Activity activity = (Activity) context;
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
                i -= activity.getWindow().findViewById(R.id.content).getTop();
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
            q a2 = q.a();
            int o = (int) ((i / a2.o()) + 0.5f);
            this.d.b((int) ((i2 / a2.n()) + 0.5f));
            this.d.c(o);
        } catch (Exception e2) {
            f.a("OctopusAd", "An Exception Caught", e2);
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void cancel() {
        super.cancel();
        t = null;
        this.z.clear();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void destroy() {
        super.destroy();
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(com.octopus.ad.R.string.destroy_int));
        com.octopus.ad.internal.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        this.z.clear();
        t = null;
    }

    public AdActivity.a getAdImplementation() {
        return this.A;
    }

    public Queue<d> getAdQueue() {
        return this.z;
    }

    public int getBackgroundColor() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(com.octopus.ad.R.string.get_bg));
        return this.w;
    }

    public int getCloseButtonDelay() {
        return this.x;
    }

    @Override // com.octopus.ad.internal.a
    public p getMediaType() {
        return this.g;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean k() {
        return true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onCreateLifeCycle() {
        super.onCreateLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        super.onDestroyLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onPauseLifeCycle() {
        super.onPauseLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onRestartLifeCycle() {
        super.onRestartLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onResumeLifeCycle() {
        super.onResumeLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onStartLifeCycle() {
        super.onStartLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, com.octopus.ad.AdLifeControl
    public void onStopLifeCycle() {
        super.onStopLifeCycle();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void s() {
        this.u = true;
    }

    public void setAdImplementation(AdActivity.a aVar) {
        this.A = aVar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(com.octopus.ad.R.string.set_bg));
        this.w = i;
    }

    public void setCloseButtonDelay(int i) {
        this.x = Math.min(i, 10000);
    }

    public void setDismissOnClick(boolean z) {
        this.y = z;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void t() {
        this.v = true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void u() {
        this.v = false;
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = 0;
        this.x = 10000;
        this.z = new LinkedList();
        this.A = null;
        this.u = false;
        this.v = false;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean a(a.C0411a c0411a) {
        com.octopus.ad.internal.c cVar;
        h();
        getAdParameters().a(false);
        this.e = c0411a;
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(com.octopus.ad.R.string.load_ad_int));
        if (!a() || (cVar = this.f) == null) {
            return false;
        }
        cVar.a();
        this.f.c();
        this.i = 1;
        this.j = 0;
        return true;
    }

    public InterstitialAdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 0;
        this.x = 10000;
        this.z = new LinkedList();
        this.A = null;
        this.u = false;
        this.v = false;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean a(b bVar) {
        if (!b(bVar)) {
            b(80102);
            return false;
        }
        b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.k();
        }
        if (!this.u && !this.v) {
            this.c = bVar;
            this.z.add(new c(bVar, Long.valueOf(System.currentTimeMillis()), false));
            return true;
        }
        if (bVar == null) {
            return true;
        }
        bVar.k();
        return true;
    }

    private boolean a(long j) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<d> it = this.z.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d next = it.next();
            if (next != null && j - next.a() <= q.s && j - next.a() >= 0 && !next.b()) {
                z = true;
                break;
            }
            arrayList.add(next);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.z.remove((d) it2.next());
        }
        return z;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void a(Context context) {
        if (context == null) {
            return;
        }
        if ((this.p && !this.o) || !this.r) {
            this.q = true;
            this.s = context;
            return;
        }
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(com.octopus.ad.R.string.show_int));
        long currentTimeMillis = System.currentTimeMillis();
        if (a(currentTimeMillis) && !this.u) {
            Class<AdActivity> a2 = AdActivity.a();
            Intent intent = new Intent(context, a2);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra("ACTIVITY_TYPE", "INTERSTITIAL");
            intent.putExtra("TIME", currentTimeMillis);
            intent.putExtra("CLOSE_BUTTON_DELAY", this.x);
            t = this;
            try {
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                t = null;
                HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(com.octopus.ad.R.string.adactivity_missing, a2.getName()));
                return;
            }
        }
        HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(com.octopus.ad.R.string.empty_queue));
    }
}
