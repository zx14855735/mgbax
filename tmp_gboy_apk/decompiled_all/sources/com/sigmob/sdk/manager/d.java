package com.sigmob.sdk.manager;

import ADYaiT.CtFAbx;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13441a = "WindAdExpirationManager";
    private static volatile d b;
    private volatile boolean c;
    private volatile long d;
    private Timer e;
    private final ConcurrentHashMap<SoftReference<b>, a> f = new ConcurrentHashMap<>();
    private volatile boolean g = false;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        Boolean f13443a;
        int b;
        int c;
        String d;
        String e;
        String f;
        String g;
        String h;
        Long i;
        Integer j;
        boolean k = false;
        boolean l;

        public a(BaseAdUnit baseAdUnit, boolean z) {
            if (baseAdUnit == null) {
                return;
            }
            this.d = baseAdUnit.getVid();
            this.e = baseAdUnit.getOriginVid();
            this.f = baseAdUnit.getRequestId();
            this.h = baseAdUnit.getAdslot_id();
            this.g = baseAdUnit.getAdxEncPrice();
            this.j = baseAdUnit.getAdExpiredTime();
            this.i = Long.valueOf(baseAdUnit.getCreate_time());
            this.f13443a = Boolean.valueOf(baseAdUnit.expiredAdCanReload());
            int expiredAdReloadNum = baseAdUnit.expiredAdReloadNum();
            this.b = expiredAdReloadNum;
            this.c = expiredAdReloadNum;
            this.l = z;
        }

        public boolean a() {
            return (this.i.longValue() == 0 || this.j.intValue() == 0 || System.currentTimeMillis() - this.i.longValue() < ((long) this.j.intValue())) ? false : true;
        }

        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put(PointParamKey.EXPIRE_RELOAD_COUNT, String.valueOf(this.c));
            hashMap.put(PointParamKey.ORIGIN_VID, o.b(this.e) ? this.e : this.d);
            if (o.b(this.g)) {
                hashMap.put(PointParamKey.ORIGIN_PRICE, this.g);
            }
            hashMap.put(PointParamKey.REQUEST_ID, this.f);
            return hashMap;
        }
    }

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                try {
                    if (b == null) {
                        b = new d();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    private a e(b bVar) {
        if (bVar == null) {
            return null;
        }
        for (Map.Entry<SoftReference<b>, a> entry : this.f.entrySet()) {
            b bVar2 = entry.getKey().get();
            a value = entry.getValue();
            if (bVar2 != null && value != null && bVar2.equals(bVar)) {
                return value;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.g) {
            SigmobLogger.e(f13441a, "checkAdExpiration: The screen is locked.", new Object[0]);
            return;
        }
        if (this.f.isEmpty()) {
            SigmobLogger.e(f13441a, "checkAdExpiration: adManagerMap is unavailable.", new Object[0]);
            return;
        }
        if (!com.sigmob.sdk.manager.a.c()) {
            SigmobLogger.e(f13441a, "checkAdExpiration: The app is on background.", new Object[0]);
            return;
        }
        Iterator<Map.Entry<SoftReference<b>, a>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<SoftReference<b>, a> next = it.next();
            SoftReference<b> key = next.getKey();
            a value = next.getValue();
            if (key == null || value == null) {
                SigmobLogger.e(f13441a, "checkAdExpiration: entry is unavailable, remove entry.", new Object[0]);
            } else {
                b bVar = key.get();
                if (bVar == null) {
                    SigmobLogger.e(f13441a, "checkAdExpiration: manager is unavailable, remove entry.", new Object[0]);
                } else if (!value.f13443a.booleanValue() || value.c <= 0) {
                    SigmobLogger.e(f13441a, "checkAdExpiration: retry not available.", new Object[0]);
                } else if (value.k) {
                    SigmobLogger.e(f13441a, "checkAdExpiration: reloading.", new Object[0]);
                } else {
                    boolean a2 = value.a();
                    j jVar = value.l ? j.ActiveFailureReload : j.ReloadAfterExpiration;
                    SigmobLogger.d(f13441a, "checkAdExpiration: expiredAd = " + a2 + ", requestId = " + value.f + ", placementId = " + value.h + ", reloadLeftNum = " + value.c + ", requestSceneType = " + jVar.a(), new Object[0]);
                    boolean z = a2 && q.b(Boolean.valueOf(value.l));
                    if (z || q.a(Boolean.valueOf(value.l))) {
                        if (z) {
                            BaseAdUnit e = bVar.e();
                            if (value.b == value.c) {
                                ae.a(PointCategory.OBJECT_EXPIRE, (String) null, e, new A2egSU(0, value));
                            }
                        }
                        value.k = true;
                        bVar.a(value.d, value.g, jVar);
                        value.c--;
                    }
                }
            }
            it.remove();
        }
    }

    public void b() {
        if (this.f.isEmpty()) {
            return;
        }
        this.f.clear();
    }

    public synchronized void c() {
        SigmobLogger.d(f13441a, "stopExpirationCheck: running = " + this.c, new Object[0]);
        if (this.c) {
            e();
            this.c = false;
        }
    }

    public void d() {
        c();
        b();
        b = null;
    }

    private void d(b bVar) {
        Iterator<Map.Entry<SoftReference<b>, a>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            b bVar2 = it.next().getKey().get();
            if (bVar2 != null && bVar2.equals(bVar)) {
                it.remove();
                SigmobLogger.i(f13441a, "removeAdManager", new Object[0]);
                return;
            }
        }
    }

    private synchronized void e() {
        SigmobLogger.d(f13441a, "cancelTimer", new Object[0]);
        Timer timer = this.e;
        if (timer == null) {
            return;
        }
        timer.cancel();
        this.e = null;
    }

    public Map<String, String> a(b bVar, Integer num) {
        a e;
        return (b.a(num) && (e = e(bVar)) != null) ? e.b() : new HashMap();
    }

    public void b(b bVar) {
        if (bVar == null) {
            SigmobLogger.e(f13441a, "removeAdManager: adManager is unavailable.", new Object[0]);
            return;
        }
        d(bVar);
        if (com.sigmob.sdk.base.utils.e.a(this.f)) {
            c();
        }
    }

    public void c(b bVar) {
        if (bVar == null) {
            SigmobLogger.e(f13441a, "resetAdManager: adManager is unavailable.", new Object[0]);
        } else {
            d(bVar);
            a(bVar, true);
        }
    }

    public synchronized void a(long j) {
        if (j <= 0) {
            SigmobLogger.e(f13441a, "startExpirationCheck: interval is unavailable.", new Object[0]);
            return;
        }
        boolean z = j == this.d;
        SigmobLogger.d(f13441a, "startExpirationCheck: status = " + this.c + ", interval = " + j + ", result = " + z, new Object[0]);
        if (this.c && z) {
            return;
        }
        e();
        long j2 = j * 1000;
        Timer timer = new Timer();
        this.e = timer;
        timer.schedule(new TimerTask() { // from class: com.sigmob.sdk.manager.d.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                d.this.f();
            }
        }, j2, j2);
        this.c = true;
        this.d = j;
        SigmobLogger.d(f13441a, "startExpirationCheck: status = " + this.c, new Object[0]);
    }

    public void a(LoadAdRequest loadAdRequest) {
        if (loadAdRequest != null && b.a(Integer.valueOf(loadAdRequest.getRequest_scene_type()))) {
            String originVid = loadAdRequest.getOriginVid();
            loadAdRequest.getOriginPrice();
            Iterator<Map.Entry<SoftReference<b>, a>> it = this.f.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && o.a((CharSequence) originVid, (CharSequence) value.d)) {
                    value.k = false;
                    SigmobLogger.d(f13441a, CtFAbx.BChYOn("loadEnd: originVid = ", originVid), new Object[0]);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        a(bVar, false);
    }

    public void a(b bVar, boolean z) {
        if (bVar == null) {
            SigmobLogger.e(f13441a, "addAdManager: adManager is unavailable.", new Object[0]);
            return;
        }
        BaseAdUnit e = bVar.e();
        if (e == null) {
            SigmobLogger.e(f13441a, "addAdManager: baseAdUnit is unavailable.", new Object[0]);
            return;
        }
        if (o.b(e.getBid_token())) {
            return;
        }
        if (q.b(e(bVar))) {
            b(bVar);
        }
        if (b.b(Integer.valueOf(e.getRequestSceneType()))) {
            return;
        }
        a aVar = new a(e, z);
        this.f.put(new SoftReference<>(bVar), aVar);
        int size = this.f.size();
        if (size == 1) {
            a(this.d);
        }
        SigmobLogger.i(f13441a, "addAdManager: vid = " + aVar.d + ", size = " + size + ", activeExpiration = " + aVar.l, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> b2 = aVar.b();
            if (com.sigmob.sdk.base.utils.e.b(b2)) {
                pointEntitySigmob.getOptions().putAll(b2);
            }
        }
    }

    public void a(boolean z) {
        this.g = z;
    }
}
