package com.bytedance.sdk.component.w.hf.xj.c;

import com.bytedance.sdk.component.w.hf.dk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class w extends kd {
    private final Method hf;
    private final Class<?> kd;
    private final Class<?> u;
    private final Method w;
    private final Method xj;

    public static class xj implements InvocationHandler {
        String hf;
        private final List<String> w;
        boolean xj;

        public xj(List<String> list) {
            this.w = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.w.hf.xj.w.hf;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.xj = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.w;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.w.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.hf = str;
                            return str;
                        }
                    }
                    String str2 = this.w.get(0);
                    this.hf = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.hf = (String) objArr[0];
            return null;
        }
    }

    public w(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.xj = method;
        this.hf = method2;
        this.w = method3;
        this.u = cls;
        this.kd = cls2;
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void hf(SSLSocket sSLSocket) {
        try {
            this.w.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void xj(SSLSocket sSLSocket, String str, List<dk> list) {
        try {
            this.xj.invoke(null, sSLSocket, Proxy.newProxyInstance(kd.class.getClassLoader(), new Class[]{this.u, this.kd}, new xj(kd.xj(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public String xj(SSLSocket sSLSocket) {
        try {
            xj xjVar = (xj) Proxy.getInvocationHandler(this.hf.invoke(null, sSLSocket));
            boolean z = xjVar.xj;
            if (!z && xjVar.hf == null) {
                kd.hf().xj(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z) {
                return null;
            }
            return xjVar.hf;
        } catch (IllegalAccessException e) {
            e = e;
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to get selected protocol", e);
        } catch (InvocationTargetException e2) {
            e = e2;
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to get selected protocol", e);
        }
    }

    public static kd xj() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new w(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
