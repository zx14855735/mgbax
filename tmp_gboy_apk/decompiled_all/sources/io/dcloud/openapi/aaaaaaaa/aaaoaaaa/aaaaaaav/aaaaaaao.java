package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aaaaaaao extends aaaaaaan {
    final Method aaaaaaac;
    final Method aaaaaaao;

    public aaaaaaao(Method method, Method method2) {
        this.aaaaaaao = method;
        this.aaaaaaac = method2;
    }

    public static aaaaaaao aaaaaaac() {
        try {
            return new aaaaaaao(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public String aaaaaaa0(SSLSocket sSLSocket) {
        try {
            String str = (String) this.aaaaaaac.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e) {
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("failed to get ALPN selected protocol", (Exception) e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("failed to get ALPN selected protocol", (Exception) e2);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List aaaaaaaa = aaaaaaan.aaaaaaaa(list);
            this.aaaaaaao.invoke(sSLParameters, aaaaaaaa.toArray(new String[aaaaaaaa.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to set ssl parameters", (Exception) e);
        }
    }
}
