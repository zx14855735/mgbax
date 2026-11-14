package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class aaaaaaac extends aaaaaaan {
    private final Method aaaaaaac;
    private final Class aaaaaaae;
    private final Class aaaaaaan;
    private final Method aaaaaaao;
    private final Method aaaaaaau;

    public static class aaaaaaaa implements InvocationHandler {
        boolean aaaaaaa0;
        private final List aaaaaaaa;
        String aaaaaaao;

        public aaaaaaaa(List list) {
            this.aaaaaaaa = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.aaaaaaa0 = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.aaaaaaaa;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.aaaaaaaa.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.aaaaaaao = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.aaaaaaaa.get(0);
                    this.aaaaaaao = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.aaaaaaao = (String) objArr[0];
            return null;
        }
    }

    public aaaaaaac(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.aaaaaaao = method;
        this.aaaaaaac = method2;
        this.aaaaaaau = method3;
        this.aaaaaaan = cls;
        this.aaaaaaae = cls2;
    }

    public static aaaaaaan aaaaaaac() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new aaaaaaac(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public String aaaaaaa0(SSLSocket sSLSocket) {
        try {
            aaaaaaaa aaaaaaaaVar = (aaaaaaaa) Proxy.getInvocationHandler(this.aaaaaaac.invoke(null, sSLSocket));
            boolean z = aaaaaaaaVar.aaaaaaa0;
            if (!z && aaaaaaaaVar.aaaaaaao == null) {
                aaaaaaan.aaaaaaa0().aaaaaaaa(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z) {
                return null;
            }
            return aaaaaaaaVar.aaaaaaao;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to get selected protocol", (Exception) e);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(SSLSocket sSLSocket, String str, List list) {
        try {
            this.aaaaaaao.invoke(null, sSLSocket, Proxy.newProxyInstance(aaaaaaan.class.getClassLoader(), new Class[]{this.aaaaaaan, this.aaaaaaae}, new aaaaaaaa(aaaaaaan.aaaaaaaa(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to set alpn", (Exception) e);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(SSLSocket sSLSocket) {
        try {
            this.aaaaaaau.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to remove alpn", (Exception) e);
        }
    }
}
