package GnQT2j;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.widget.InclineView;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.joor.HandlerAnnotation;
import com.fl.saas.s2s.mixNative.S2SNative;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.manager.b;
import com.sigmob.sdk.manager.e;
import com.sigmob.sdk.mraid2.s;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A4TApA implements G58fqA.A5SV6n, ShakeView.ShakeListener, InclineView.InclineListener, AmA8tU.A2egSU, ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3087AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f3088AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f3089AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f3090AzWtSf;

    public /* synthetic */ A4TApA(int i, Object obj, Object obj2, Object obj3) {
        this.f3087AcNBzu = i;
        this.f3088AlLFFp = obj;
        this.f3089AmA8tU = obj2;
        this.f3090AzWtSf = obj3;
    }

    @Override // G58fqA.A5SV6n
    public void A4TApA(Intent intent) {
        NotificationManager notificationManager;
        final int i = 0;
        Object obj = this.f3088AlLFFp;
        Object obj2 = this.f3090AzWtSf;
        Object obj3 = this.f3089AmA8tU;
        final int i2 = 1;
        switch (this.f3087AcNBzu) {
            case 0:
                if (intent != null && intent.getAction() != null) {
                    String action = intent.getAction();
                    action.getClass();
                    String str = (String) obj;
                    if (!action.equals("SA_TARGET_YT_NOTIFICATION_CLICK")) {
                        if (action.equals("SA_TARGET_YT_NOTIFICATION_CANCEL")) {
                            ARc23Z.f3104AZkASS = true;
                            ARc23Z.A4TApA(str, true);
                            ARc23Z.A2egSU(str);
                            G58fqA.A4TApA a4TApA = ARc23Z.f3100ARc23Z;
                            if (a4TApA.AMqCpz && (notificationManager = a4TApA.f2981A4TApA) != null) {
                                notificationManager.cancel(a4TApA.f2980A2egSU);
                                a4TApA.f2981A4TApA = null;
                                a4TApA.f2982A5SV6n = null;
                                a4TApA.f2983ADYaiT = null;
                                a4TApA.AMqCpz = false;
                            }
                            ARc23Z.f3101ASJ6gh.A4TApA();
                            break;
                        }
                    } else if (!ARc23Z.f3103AZOQYO) {
                        AMqCpz aMqCpz = (AMqCpz) obj2;
                        final String str2 = (String) obj3;
                        if (!ARc23Z.f3102AYUAbz) {
                            ARc23Z.f3102AYUAbz = true;
                            ARc23Z.A4TApA(str, true);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: GnQT2j.A5SV6n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i2) {
                                        case 0:
                                            ARc23Z.f3100ARc23Z.A2egSU(-1, -1, "下载中 " + str2, null);
                                            break;
                                        default:
                                            ARc23Z.f3100ARc23Z.A2egSU(-1, -1, "下载暂停 " + str2, null);
                                            break;
                                    }
                                }
                            }, 200L);
                            aMqCpz.A2egSU();
                            break;
                        } else {
                            ARc23Z.f3102AYUAbz = false;
                            ARc23Z.A4TApA(str, false);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: GnQT2j.A5SV6n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i) {
                                        case 0:
                                            ARc23Z.f3100ARc23Z.A2egSU(-1, -1, "下载中 " + str2, null);
                                            break;
                                        default:
                                            ARc23Z.f3100ARc23Z.A2egSU(-1, -1, "下载暂停 " + str2, null);
                                            break;
                                    }
                                }
                            }, 50L);
                            aMqCpz.b();
                            break;
                        }
                    }
                }
                break;
            default:
                H0qugq.AZOQYO azoqyo = (H0qugq.AZOQYO) obj3;
                azoqyo.getClass();
                if (intent != null && intent.getAction() != null) {
                    intent.getAction();
                    int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                    String action2 = intent.getAction();
                    action2.getClass();
                    SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) obj2;
                    if (!action2.equals("SA_TARGET_YT_DEEPLINK_OPEN_FAIL")) {
                        if (action2.equals("SA_TARGET_YT_DEEPLINK_OPEN_FINISH")) {
                            if (!azoqyo.f3246DuwtYk && !((String) obj).endsWith(".apk")) {
                                azoqyo.BmvVmW(sAAllianceAdData);
                            }
                            azoqyo.f3245Dphsd2.A4TApA();
                            break;
                        }
                    } else {
                        azoqyo.B3GDIM(sAAllianceAdData);
                        azoqyo.f3246DuwtYk = true;
                        azoqyo.CASmeH(sAAllianceAdData);
                        break;
                    }
                }
                break;
        }
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        Boolean lambda$parseMethodAnn$1;
        Boolean lambda$parseFieldAnn$0;
        Class cls = (Class) obj;
        switch (this.f3087AcNBzu) {
            case 4:
                lambda$parseMethodAnn$1 = ((HandlerAnnotation) this.f3088AlLFFp).lambda$parseMethodAnn$1((Predicate) this.f3089AmA8tU, (Method) this.f3090AzWtSf, cls);
                return lambda$parseMethodAnn$1;
            default:
                lambda$parseFieldAnn$0 = ((HandlerAnnotation) this.f3088AlLFFp).lambda$parseFieldAnn$0((Predicate) this.f3089AmA8tU, (Field) this.f3090AzWtSf, cls);
                return lambda$parseFieldAnn$0;
        }
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        switch (this.f3087AcNBzu) {
            case 7:
                ((m) this.f3089AmA8tU).a((String) this.f3088AlLFFp, (z) this.f3090AzWtSf, obj);
                break;
            case 8:
                ((b) this.f3088AlLFFp).a((List) this.f3089AmA8tU, (BaseAdUnit) this.f3090AzWtSf, obj);
                break;
            case 9:
                e.a((String) this.f3088AlLFFp, (BaseAdUnit) this.f3090AzWtSf, (String) this.f3089AmA8tU, obj);
                break;
            case 10:
                s.a((BaseAdUnit) this.f3088AlLFFp, (ClickCommon) this.f3089AmA8tU, (JSONObject) this.f3090AzWtSf, obj);
                break;
            default:
                ((com.sigmob.sdk.nativead.b) this.f3090AzWtSf).a((String) this.f3088AlLFFp, (String) this.f3089AmA8tU, obj);
                break;
        }
    }

    @Override // com.fl.saas.base.widget.InclineView.InclineListener
    public void onIncline(int i, int i2, int i3) {
        BaseNativeAd.lambda$listenInclineView$11((InclineView.InclineListener) this.f3088AlLFFp, (ActionView.Type) this.f3089AmA8tU, (View) this.f3090AzWtSf, i, i2, i3);
    }

    @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
    public void onShake(int i, int i2, int i3) {
        switch (this.f3087AcNBzu) {
            case 2:
                BaseNativeAd.lambda$listenShakeView$10((ShakeView.ShakeListener) this.f3088AlLFFp, (ActionView.Type) this.f3089AmA8tU, (View) this.f3090AzWtSf, i, i2, i3);
                break;
            default:
                ((S2SNative) this.f3088AlLFFp).lambda$render$0((AdInfoPoJo) this.f3089AmA8tU, (View) this.f3090AzWtSf, i, i2, i3);
                break;
        }
    }

    public /* synthetic */ A4TApA(H0qugq.AZOQYO azoqyo, SAAllianceAdData sAAllianceAdData, String str) {
        this.f3087AcNBzu = 1;
        this.f3089AmA8tU = azoqyo;
        this.f3090AzWtSf = sAAllianceAdData;
        this.f3088AlLFFp = str;
    }

    public /* synthetic */ A4TApA(m mVar, String str, z zVar) {
        this.f3087AcNBzu = 7;
        this.f3089AmA8tU = mVar;
        this.f3088AlLFFp = str;
        this.f3090AzWtSf = zVar;
    }

    public /* synthetic */ A4TApA(BaseAdUnit baseAdUnit, String str, String str2) {
        this.f3087AcNBzu = 9;
        this.f3088AlLFFp = str;
        this.f3090AzWtSf = baseAdUnit;
        this.f3089AmA8tU = str2;
    }

    public /* synthetic */ A4TApA(com.sigmob.sdk.nativead.b bVar, String str, String str2) {
        this.f3087AcNBzu = 11;
        this.f3090AzWtSf = bVar;
        this.f3088AlLFFp = str;
        this.f3089AmA8tU = str2;
    }
}
