package GJee0v;

import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Application.ActivityLifecycleCallbacks {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3032A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f3033A4TApA;

    public AMqCpz(ARc23Z aRc23Z, BmvVmW bmvVmW) {
        this.f3033A4TApA = aRc23Z;
    }

    private final void A2egSU(Activity activity, Bundle bundle) {
    }

    private final void A4TApA(Activity activity) {
    }

    private final void A5SV6n(Activity activity, Bundle bundle) {
    }

    private final void ADYaiT(Activity activity, Bundle bundle) {
    }

    private final void AMqCpz(Activity activity) {
    }

    private final void ARc23Z(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f3032A2egSU) {
            case 0:
                break;
            default:
                String name = activity.getClass().getName();
                KBDfKG.A4TApA a4TApA = (KBDfKG.A4TApA) this.f3033A4TApA;
                a4TApA.f4208ASJ6gh = name;
                a4TApA.f4209AYUAbz = System.currentTimeMillis();
                a4TApA.f4205A5SV6n.add(a4TApA.f4208ASJ6gh);
                a4TApA.f4206ADYaiT.add(Long.valueOf(a4TApA.f4209AYUAbz));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f3032A2egSU) {
            case 0:
                break;
            default:
                String name = activity.getClass().getName();
                KBDfKG.A4TApA a4TApA = (KBDfKG.A4TApA) this.f3033A4TApA;
                int indexOf = a4TApA.f4205A5SV6n.indexOf(name);
                if (indexOf >= 0 && indexOf < a4TApA.f4205A5SV6n.size()) {
                    a4TApA.f4205A5SV6n.remove(indexOf);
                    a4TApA.f4206ADYaiT.remove(indexOf);
                }
                a4TApA.AMqCpz.add(name);
                a4TApA.f4207ARc23Z.add(Long.valueOf(System.currentTimeMillis()));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        long j;
        Object obj = this.f3033A4TApA;
        switch (this.f3032A2egSU) {
            case 0:
                int hashCode = activity.hashCode();
                ARc23Z aRc23Z = (ARc23Z) obj;
                HashMap hashMap = aRc23Z.f3036A5SV6n;
                Long l = (Long) hashMap.get(Integer.valueOf(hashCode));
                if (l == null) {
                    j = (SystemClock.elapsedRealtimeNanos() / C.MICROS_PER_SECOND) - aRc23Z.f3035A4TApA;
                    aRc23Z.f3034A2egSU += j;
                    aRc23Z.f3035A4TApA = SystemClock.elapsedRealtimeNanos() / C.MICROS_PER_SECOND;
                } else {
                    long elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() / C.MICROS_PER_SECOND) - l.longValue();
                    aRc23Z.f3034A2egSU += elapsedRealtimeNanos;
                    hashMap.remove(Integer.valueOf(hashCode));
                    j = elapsedRealtimeNanos;
                }
                EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
                aDYaiT.ARc23Z(0, 0, null, String.valueOf(System.currentTimeMillis()), CtFAbx.AaHO0E("", j));
                try {
                    if (aDYaiT.f2535A4TApA == null) {
                        aDYaiT.f2535A4TApA = new JSONObject();
                    }
                    aDYaiT.f2535A4TApA.put("stage", 9);
                    JSONObject jSONObject = new JSONObject();
                    EY4UKY.ADYaiT.B2KMhB(jSONObject, null);
                    aDYaiT.f2534A2egSU.put(n.m, jSONObject.toString());
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 015: "), new EY4UKY.ADYaiT(), "004", e);
                }
                try {
                    aDYaiT.ADYaiT();
                } catch (Exception e2) {
                    CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 016: "), new EY4UKY.ADYaiT(), "004", e2);
                }
                int i = AZOQYO.f3039AcNBzu;
                break;
            default:
                KBDfKG.A4TApA a4TApA = (KBDfKG.A4TApA) obj;
                a4TApA.f4214AlLFFp = activity.getClass().getName();
                a4TApA.f4215AmA8tU = System.currentTimeMillis();
                int i2 = a4TApA.f4218B2KMhB - 1;
                a4TApA.f4218B2KMhB = i2;
                if (i2 <= 0) {
                    a4TApA.f4219B3GDIM = false;
                    break;
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f3032A2egSU) {
            case 0:
                ((ARc23Z) this.f3033A4TApA).f3036A5SV6n.put(Integer.valueOf(activity.hashCode()), Long.valueOf(SystemClock.elapsedRealtimeNanos() / C.MICROS_PER_SECOND));
                break;
            default:
                String name = activity.getClass().getName();
                KBDfKG.A4TApA a4TApA = (KBDfKG.A4TApA) this.f3033A4TApA;
                a4TApA.f4212AaHO0E = name;
                a4TApA.f4213AcNBzu = System.currentTimeMillis();
                a4TApA.f4219B3GDIM = true;
                a4TApA.f4218B2KMhB++;
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        int i = this.f3032A2egSU;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.f3032A2egSU) {
            case 0:
                break;
            default:
                String name = activity.getClass().getName();
                KBDfKG.A4TApA a4TApA = (KBDfKG.A4TApA) this.f3033A4TApA;
                a4TApA.f4210AZOQYO = name;
                a4TApA.f4211AZkASS = System.currentTimeMillis();
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.f3032A2egSU) {
            case 0:
                break;
            default:
                String name = activity.getClass().getName();
                KBDfKG.A4TApA a4TApA = (KBDfKG.A4TApA) this.f3033A4TApA;
                a4TApA.f4216AzWtSf = name;
                a4TApA.f4217B25kr6 = System.currentTimeMillis();
                break;
        }
    }

    public AMqCpz(KBDfKG.A4TApA a4TApA) {
        this.f3033A4TApA = a4TApA;
    }
}
