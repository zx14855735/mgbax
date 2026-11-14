package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ADEvent {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f12906A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object[] f12907A4TApA;

    public ADEvent(int i, Object... objArr) {
        this.f12906A2egSU = i;
        this.f12907A4TApA = objArr;
        if (i < 100) {
            GDTLogger.e("EventId 错误" + i);
        }
    }

    public <T> T getParam(int i, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f12907A4TApA) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t != null) {
            if (cls.isInstance(t)) {
                return t;
            }
            return null;
        }
        GDTLogger.e("ADEvent 参数为空,type:" + this.f12906A2egSU);
        return null;
    }

    public int getType() {
        return this.f12906A2egSU;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }
}
