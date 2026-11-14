package com.czhj.wire;

import com.czhj.wire.WireEnum;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<E> f10673a;
    private Method b;

    public RuntimeEnumAdapter(Class<E> cls) {
        super(cls);
        this.f10673a = cls;
    }

    private Method a() {
        Method method = this.b;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.f10673a.getMethod("fromValue", Integer.TYPE);
            this.b = method2;
            return method2;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && ((RuntimeEnumAdapter) obj).f10673a == this.f10673a;
    }

    @Override // com.czhj.wire.EnumAdapter
    public E fromValue(int i) {
        try {
            return (E) a().invoke(null, Integer.valueOf(i));
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public int hashCode() {
        return this.f10673a.hashCode();
    }
}
