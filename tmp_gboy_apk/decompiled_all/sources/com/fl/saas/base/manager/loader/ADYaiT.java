package com.fl.saas.base.manager.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.telephony.TelephonyManager;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ReflectUtils;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.util.feature.joor.AnnontationManager;
import com.fl.saas.config.utils.DeviceUtil;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.mraid.h;
import com.sigmob.sdk.mraid.v;
import com.sigmob.sdk.nativead.z;
import com.sigmob.sdk.splash.f;
import io.dcloud.sdk.poly.adapter.custom.fl.CustomFLRewardAd;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements AmA8tU.A2egSU, Supplier, Predicate, ae.a, o.a, h.b, AdViewVideoCheckListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10804AcNBzu;

    public /* synthetic */ ADYaiT(int i) {
        this.f10804AcNBzu = i;
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f10804AcNBzu;
        return KfamK9.A4TApA.A2egSU(this, predicate);
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        AdInfo lambda$getAdInfo$5;
        Drawable lambda$loadImageDrawable$0;
        List lambda$findAllField$2;
        List lambda$findAllMethods$4;
        TelephonyManager lambda$getOperators$0;
        String lambda$getOperators$1;
        switch (this.f10804AcNBzu) {
            case 0:
                lambda$getAdInfo$5 = BaseLoader.lambda$getAdInfo$5((AdSource) obj);
                return lambda$getAdInfo$5;
            case 1:
            case 7:
            case 11:
            case 13:
            case 14:
            case 15:
            default:
                lambda$getOperators$1 = DeviceUtil.lambda$getOperators$1((String) obj);
                return lambda$getOperators$1;
            case 2:
                return Integer.valueOf(((AdSource) obj).getAdvPrice());
            case 3:
                return ((AdapterAPI) obj).getAdSource();
            case 4:
                return Check.findFirstNonNull((List) obj);
            case 5:
                return ((WeakReference) obj).get();
            case 6:
                return ((Class) obj).getSimpleName();
            case 8:
                return ImageUtils.byteArrayToBitmap((byte[]) obj);
            case 9:
                lambda$loadImageDrawable$0 = ImageLoader.lambda$loadImageDrawable$0((byte[]) obj);
                return lambda$loadImageDrawable$0;
            case 10:
                lambda$findAllField$2 = ReflectUtils.lambda$findAllField$2((Class) obj);
                return lambda$findAllField$2;
            case 12:
                lambda$findAllMethods$4 = ReflectUtils.lambda$findAllMethods$4((Class) obj);
                return lambda$findAllMethods$4;
            case 16:
                lambda$getOperators$0 = DeviceUtil.lambda$getOperators$0((Context) obj);
                return lambda$getOperators$0;
            case 17:
                return ((TelephonyManager) obj).getSimOperator();
        }
    }

    @Override // com.fl.saas.common.util.feature.Supplier
    public Object get() {
        String lambda$getClassTag$0;
        String str;
        switch (this.f10804AcNBzu) {
            case 1:
                return AdInfo.createEmpty();
            case 7:
                lambda$getClassTag$0 = CommConstant.lambda$getClassTag$0();
                return lambda$getClassTag$0;
            default:
                str = Constants.FAIL;
                return str;
        }
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.f10804AcNBzu) {
        }
        return KfamK9.A4TApA.A4TApA(this);
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        switch (this.f10804AcNBzu) {
            case 20:
                Sigmob.a(obj);
                break;
            default:
                f.a(obj);
                break;
        }
    }

    @Override // com.sigmob.sdk.mraid.h.b
    public void onReady(v vVar, u uVar) {
        switch (this.f10804AcNBzu) {
            case 22:
                z.b(vVar, uVar);
                break;
            default:
                z.a(vVar, uVar);
                break;
        }
    }

    @Override // com.sigmob.sdk.base.o.a
    public void onUpdate(boolean z) {
        Sigmob.a(z);
    }

    @Override // com.fl.saas.base.interfaces.AdViewVideoCheckListener
    public void onVideoCheckReward(String str) {
        CustomFLRewardAd.lambda$load$0(str);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f10804AcNBzu;
        return KfamK9.A4TApA.A5SV6n(this, predicate);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public boolean test(Object obj) {
        boolean lambda$findAllField$3;
        boolean lambda$findAllMethods$5;
        boolean lambda$loadHandlerAnn$0;
        boolean lambda$loadHandlerAnn$1;
        switch (this.f10804AcNBzu) {
            case 11:
                lambda$findAllField$3 = ReflectUtils.lambda$findAllField$3((Field) obj);
                return lambda$findAllField$3;
            case 12:
            default:
                lambda$loadHandlerAnn$1 = AnnontationManager.lambda$loadHandlerAnn$1((Class) obj);
                return lambda$loadHandlerAnn$1;
            case 13:
                lambda$findAllMethods$5 = ReflectUtils.lambda$findAllMethods$5((Method) obj);
                return lambda$findAllMethods$5;
            case 14:
                lambda$loadHandlerAnn$0 = AnnontationManager.lambda$loadHandlerAnn$0((Class) obj);
                return lambda$loadHandlerAnn$0;
        }
    }
}
