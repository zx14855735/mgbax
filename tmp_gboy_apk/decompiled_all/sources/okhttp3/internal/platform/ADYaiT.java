package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ADYaiT extends ARc23Z {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    public static class A2egSU implements InvocationHandler {
        private final List<String> protocols;
        String selected;
        boolean unsupported;

        public A2egSU(List<String> list) {
            this.protocols = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.internal.A5SV6n.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.protocols.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.selected = str;
                            return str;
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.selected = (String) objArr[0];
            return null;
        }
    }

    public ADYaiT(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void A2egSU(SSLSocket sSLSocket) {
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.A5SV6n.A4TApA("unable to remove alpn", e);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void ASJ6gh(SSLSocket sSLSocket, String str, List list) {
        try {
            this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(ARc23Z.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new A2egSU(ARc23Z.A4TApA(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.A5SV6n.A4TApA("unable to set alpn", e);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final String AaHO0E(SSLSocket sSLSocket) {
        try {
            A2egSU a2egSU = (A2egSU) Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            boolean z = a2egSU.unsupported;
            if (!z && a2egSU.selected == null) {
                ARc23Z.AZOQYO().AmA8tU(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z) {
                return null;
            }
            return a2egSU.selected;
        } catch (IllegalAccessException e) {
            e = e;
            throw okhttp3.internal.A5SV6n.A4TApA("unable to get selected protocol", e);
        } catch (InvocationTargetException e2) {
            e = e2;
            throw okhttp3.internal.A5SV6n.A4TApA("unable to get selected protocol", e);
        }
    }
}
