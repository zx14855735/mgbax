package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AMqCpz {
    private final String methodName;
    private final Class[] methodParams;
    private final Class<?> returnType;

    public AMqCpz(Class<?> cls, String str, Class... clsArr) {
        this.returnType = cls;
        this.methodName = str;
        this.methodParams = clsArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if ((r4.getModifiers() & 1) == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.reflect.Method A2egSU(java.lang.Class r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.methodName
            r1 = 0
            if (r0 == 0) goto L2b
            java.lang.Class[] r2 = r3.methodParams
            java.lang.reflect.Method r4 = r4.getMethod(r0, r2)     // Catch: java.lang.NoSuchMethodException -> L17
            int r0 = r4.getModifiers()     // Catch: java.lang.NoSuchMethodException -> L15
            r0 = r0 & 1
            if (r0 != 0) goto L19
        L13:
            r4 = r1
            goto L19
        L15:
            goto L19
        L17:
            goto L13
        L19:
            if (r4 == 0) goto L2a
            java.lang.Class<?> r0 = r3.returnType
            if (r0 == 0) goto L2a
            java.lang.Class r2 = r4.getReturnType()
            boolean r0 = r0.isAssignableFrom(r2)
            if (r0 != 0) goto L2a
            goto L2b
        L2a:
            r1 = r4
        L2b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AMqCpz.A2egSU(java.lang.Class):java.lang.reflect.Method");
    }

    public final Object A4TApA(SSLSocket sSLSocket, Object... objArr) {
        Method A2egSU2 = A2egSU(sSLSocket.getClass());
        if (A2egSU2 == null) {
            throw new AssertionError("Method " + this.methodName + " not supported for object " + sSLSocket);
        }
        try {
            return A2egSU2.invoke(sSLSocket, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + A2egSU2);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public final void A5SV6n(SSLSocket sSLSocket, Object... objArr) {
        try {
            Method A2egSU2 = A2egSU(sSLSocket.getClass());
            if (A2egSU2 == null) {
                return;
            }
            try {
                A2egSU2.invoke(sSLSocket, objArr);
            } catch (IllegalAccessException unused) {
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
