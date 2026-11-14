package kotlin.coroutines.jvm.internal;

import ADYaiT.DUi7mC;
import RJJjP9.A2egSU;
import RJJjP9.ADYaiT;
import RPBX6S.A5SV6n;
import RXb0Sz.ARc23Z;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class BaseContinuationImpl implements A2egSU, A5SV6n, Serializable {
    private final A2egSU completion;

    public BaseContinuationImpl(A2egSU a2egSU) {
        this.completion = a2egSU;
    }

    public final A2egSU create(A2egSU a2egSU) {
        ARc23Z.AMqCpz(a2egSU, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public final A5SV6n getCallerFrame() {
        A2egSU a2egSU = this.completion;
        if (a2egSU instanceof A5SV6n) {
            return (A5SV6n) a2egSU;
        }
        return null;
    }

    public final A2egSU getCompletion() {
        return this.completion;
    }

    @Override // RJJjP9.A2egSU
    public abstract /* synthetic */ ADYaiT getContext();

    public final StackTraceElement getStackTraceElement() {
        int i;
        String str;
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        String str2 = null;
        if (debugMetadata == null) {
            return null;
        }
        int v = debugMetadata.v();
        if (v > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            i = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            i = -1;
        }
        int i2 = i >= 0 ? debugMetadata.l()[i] : -1;
        DUi7mC dUi7mC = RPBX6S.ADYaiT.f7877A4TApA;
        DUi7mC dUi7mC2 = RPBX6S.ADYaiT.f7876A2egSU;
        if (dUi7mC == null) {
            try {
                DUi7mC dUi7mC3 = new DUi7mC(23, Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                RPBX6S.ADYaiT.f7877A4TApA = dUi7mC3;
                dUi7mC = dUi7mC3;
            } catch (Exception unused2) {
                RPBX6S.ADYaiT.f7877A4TApA = dUi7mC2;
                dUi7mC = dUi7mC2;
            }
        }
        if (dUi7mC != dUi7mC2) {
            Method method = (Method) dUi7mC.f239AlLFFp;
            Object invoke = method != null ? method.invoke(getClass(), new Object[0]) : null;
            if (invoke != null) {
                Method method2 = (Method) dUi7mC.f240AmA8tU;
                Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
                if (invoke2 != null) {
                    Method method3 = (Method) dUi7mC.f241AzWtSf;
                    Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
                    if (invoke3 instanceof String) {
                        str2 = (String) invoke3;
                    }
                }
            }
        }
        if (str2 == null) {
            str = debugMetadata.c();
        } else {
            str = str2 + '/' + debugMetadata.c();
        }
        return new StackTraceElement(str, debugMetadata.m(), debugMetadata.f(), i2);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // RJJjP9.A2egSU
    public final void resumeWith(Object obj) {
        A2egSU a2egSU = this;
        while (true) {
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) a2egSU;
            A2egSU a2egSU2 = baseContinuationImpl.completion;
            ARc23Z.A4TApA(a2egSU2);
            try {
                obj = baseContinuationImpl.invokeSuspend(obj);
                if (obj == RLgVYi.A2egSU.f7865AcNBzu) {
                    return;
                }
            } catch (Throwable th) {
                obj = new R8Rbcg.A5SV6n(th);
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(a2egSU2 instanceof BaseContinuationImpl)) {
                a2egSU2.resumeWith(obj);
                return;
            }
            a2egSU = a2egSU2;
        }
    }

    public String toString() {
        return "Continuation at " + ((Object) getClass().getName());
    }

    public A2egSU create(Object obj, A2egSU a2egSU) {
        ARc23Z.AMqCpz(a2egSU, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
