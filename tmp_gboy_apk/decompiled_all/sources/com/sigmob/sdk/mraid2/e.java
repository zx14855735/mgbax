package com.sigmob.sdk.mraid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.WindAdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f13543a;
    private boolean b = false;
    private m c;
    private i d;
    private LinearLayout e;
    private o f;
    private a g;
    private final List<i> h;
    private final List<BaseAdUnit> i;
    private com.sigmob.sdk.base.common.g j;
    private WindowInsets k;
    private final t l;

    /* renamed from: com.sigmob.sdk.mraid2.e$2, reason: invalid class name */
    public class AnonymousClass2 implements t {
        public AnonymousClass2() {
        }

        @Override // com.sigmob.sdk.mraid2.t
        public LinearLayout a(i iVar, int i) {
            if (e.this.e == null) {
                e.this.e = new LinearLayout(e.this.f());
            }
            if (e.this.f == null) {
                if (i == 1) {
                    e.this.f = new l(e.this.f());
                    e.this.e.setOrientation(0);
                } else {
                    e.this.f = new r(e.this.f());
                    e.this.e.setOrientation(1);
                }
                e.this.f.setPageChangedListener(new ARc23Z());
                e.this.f.getView().addView(e.this.e, new ViewGroup.LayoutParams(-1, -1));
                e.this.f13543a.addView(e.this.f.getView(), 0, new ViewGroup.LayoutParams(-1, -1));
            }
            if (iVar != null && iVar.getScrollTouchListener() == null) {
                iVar.setScrollTouchListener(new v() { // from class: com.sigmob.sdk.mraid2.e.2.1
                    @Override // com.sigmob.sdk.mraid2.v
                    public void a(i iVar2, JSONObject jSONObject) {
                        if (e.this.f == null) {
                            return;
                        }
                        e.this.f.a(iVar2, Dips.asIntPixels(jSONObject.optInt("x"), e.this.f()), Dips.asIntPixels(jSONObject.optInt("y"), e.this.f()));
                    }

                    @Override // com.sigmob.sdk.mraid2.v
                    public void b(JSONObject jSONObject) {
                        if (e.this.f == null) {
                            return;
                        }
                        e.this.f.b(Dips.asIntPixels(jSONObject.optInt("x"), e.this.f()), Dips.asIntPixels(jSONObject.optInt("y"), e.this.f()));
                    }

                    @Override // com.sigmob.sdk.mraid2.v
                    public void a(JSONObject jSONObject) {
                        if (e.this.f == null) {
                            return;
                        }
                        e.this.f.a(Dips.asIntPixels(jSONObject.optInt("x"), e.this.f()), Dips.asIntPixels(jSONObject.optInt("y"), e.this.f()));
                    }
                });
            }
            return e.this.e;
        }

        @Override // com.sigmob.sdk.mraid2.t
        public void b(i iVar) {
            if (e.this.c == null) {
                return;
            }
            e.this.c.c();
        }

        @Override // com.sigmob.sdk.mraid2.t
        public i a(i iVar, JSONObject jSONObject) {
            e eVar = e.this;
            i a2 = eVar.a(eVar.f(), iVar, jSONObject);
            e.this.h.add(a2);
            return a2;
        }

        @Override // com.sigmob.sdk.mraid2.t
        public void b(i iVar, JSONObject jSONObject) {
            e.this.b = jSONObject.optBoolean("flag");
            if (e.this.c == null) {
                return;
            }
            e.this.c.a(e.this.b);
        }

        @Override // com.sigmob.sdk.mraid2.t
        public void a() {
            if (e.this.c == null) {
                return;
            }
            e.this.c.d();
        }

        @Override // com.sigmob.sdk.mraid2.t
        public void a(i iVar) {
            if (e.this.c != null) {
                e.this.c.b();
            }
            if (e.this.h.isEmpty()) {
                return;
            }
            for (int i = 0; i < e.this.h.size(); i++) {
                ((i) e.this.h.get(i)).a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(i iVar, int i, int i2) {
            d mraidBridge;
            if (iVar == null || (mraidBridge = iVar.getMraidBridge()) == null) {
                return;
            }
            mraidBridge.a(i, i2);
        }

        @Override // com.sigmob.sdk.mraid2.t
        public void a(i iVar, BaseAdUnit baseAdUnit, JSONObject jSONObject) {
            if (e.this.c == null) {
                return;
            }
            e.this.c.a(iVar, baseAdUnit, jSONObject);
        }
    }

    public class a extends BroadcastReceiver {
        private Context b;
        private int c = -1;

        public a() {
        }

        public void a() {
            Context context = this.b;
            if (context == null) {
                return;
            }
            context.unregisterReceiver(this);
            this.b = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int screenOrientation;
            if (this.b == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (screenOrientation = ClientMetadata.getInstance().getScreenOrientation(e.this.f())) == this.c) {
                return;
            }
            this.c = screenOrientation;
            e.this.a(screenOrientation);
        }

        public void a(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            if (applicationContext == null) {
                return;
            }
            IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public e(Context context, List<BaseAdUnit> list) {
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.l = anonymousClass2;
        Preconditions.checkNotNull(context);
        this.i = list;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f13543a = frameLayout;
        frameLayout.setBackgroundColor(0);
        a aVar = new a();
        this.g = aVar;
        aVar.a(context);
        i iVar = new i(context, list, frameLayout);
        this.d = iVar;
        iVar.setLoadListener(new b() { // from class: com.sigmob.sdk.mraid2.e.1
            @Override // com.sigmob.sdk.mraid2.b
            public void a(i iVar2) {
                if (e.this.c == null) {
                    return;
                }
                try {
                    e.this.c.a(e.this.d);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.sigmob.sdk.mraid2.b
            public void a(WindAdError windAdError) {
                if (e.this.c == null) {
                    return;
                }
                try {
                    e.this.c.a(windAdError);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        this.d.setNextWebViewListener(anonymousClass2);
        arrayList.clear();
        arrayList.add(this.d);
        frameLayout.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context f() {
        FrameLayout frameLayout = this.f13543a;
        if (frameLayout == null) {
            return null;
        }
        return frameLayout.getContext();
    }

    public FrameLayout e() {
        return this.f13543a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i a(Context context, i iVar, JSONObject jSONObject) {
        i iVar2 = new i(context, this.i, this.f13543a, iVar, jSONObject);
        iVar2.setAdSize(this.j);
        iVar2.setNextWebViewListener(this.l);
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        SigmobLog.d("onShow end");
        m mVar = this.c;
        if (mVar == null) {
            return;
        }
        mVar.a(this.b);
    }

    public void b() {
        if (com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            i iVar = this.h.get(i);
            iVar.j();
            d mraidBridge = iVar.getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.a(true);
            }
        }
    }

    public i c() {
        return this.d;
    }

    public void d() {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a();
            this.g = null;
        }
        try {
            Iterator<i> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.h.clear();
            this.d = null;
            this.c = null;
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            d mraidBridge = this.h.get(i).getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.a(false);
            }
        }
    }

    public void a(int i) {
        SigmobLog.i("handleOrientationChange " + i);
        if (com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            d mraidBridge = this.h.get(i2).getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.e();
                mraidBridge.a(this.j);
            }
        }
    }

    public void a(WindowInsets windowInsets, boolean z) {
        this.k = windowInsets;
        SigmobLog.d("updateWindowInsets " + windowInsets);
        if (!z || com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        com.sigmob.sdk.base.utils.j a2 = com.sigmob.sdk.videoplayer.c.a(windowInsets);
        for (int i = 0; i < this.h.size(); i++) {
            d mraidBridge = this.h.get(i).getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.a(a2.a(), a2.b(), a2.c(), a2.d());
            }
        }
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        this.j = gVar;
        this.d.setAdSize(gVar);
        this.d.k();
    }

    public void a(BaseAdUnit baseAdUnit) {
        SigmobLog.d("onShow start");
        new Handler(Looper.getMainLooper()).postDelayed(new AaHO0E(2, this), 5 * 1000);
    }

    public void a(f fVar) {
        this.d.getMraidBridge().a(fVar);
    }

    public void a(m mVar) {
        this.c = mVar;
    }
}
