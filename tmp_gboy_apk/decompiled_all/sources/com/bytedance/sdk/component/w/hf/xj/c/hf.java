package com.bytedance.sdk.component.w.hf.xj.c;

import com.bytedance.sdk.component.w.hf.dk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class hf extends kd {
    final Method hf;
    final Method xj;

    public hf(Method method, Method method2) {
        this.xj = method;
        this.hf = method2;
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void xj(SSLSocket sSLSocket, String str, List<dk> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> xj = kd.xj(list);
            this.xj.invoke(sSLParameters, xj.toArray(new String[xj.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public String xj(SSLSocket sSLSocket) {
        try {
            String str = (String) this.hf.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to get selected protocols", (Exception) e);
        }
    }

    public static hf xj() {
        try {
            return new hf(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
