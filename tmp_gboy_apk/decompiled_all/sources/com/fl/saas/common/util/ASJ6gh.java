package com.fl.saas.common.util;

import android.view.View;
import com.fl.saas.common.util.feature.Predicate;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ASJ6gh implements AmA8tU.A2egSU, Predicate {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10826AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Serializable f10827AlLFFp;

    public /* synthetic */ ASJ6gh(int i, Serializable serializable) {
        this.f10826AcNBzu = i;
        this.f10827AlLFFp = serializable;
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return KfamK9.A4TApA.A2egSU(this, predicate);
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        Boolean lambda$findChildViewOfType$0;
        switch (this.f10826AcNBzu) {
            case 0:
                return ReflectUtils.lambda$getFieldValueByType$1((Class) this.f10827AlLFFp, (Field) obj);
            case 1:
            default:
                return ReflectUtils.lambda$getFieldValueByTypeName$0((String) this.f10827AlLFFp, (Field) obj);
            case 2:
                lambda$findChildViewOfType$0 = ViewHelper.lambda$findChildViewOfType$0((Class) this.f10827AlLFFp, (View) obj);
                return lambda$findChildViewOfType$0;
        }
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate negate() {
        return KfamK9.A4TApA.A4TApA(this);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return KfamK9.A4TApA.A5SV6n(this, predicate);
    }

    @Override // com.fl.saas.common.util.feature.Predicate
    public boolean test(Object obj) {
        return ReflectUtils.lambda$findMethodsByType$6((Class) this.f10827AlLFFp, (Method) obj);
    }
}
