package com.sigmob.sdk.videocache;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class k extends ProxySelector {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Proxy> f13735a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;
    private final String c;
    private final int d;

    static {
        zZXCq();
    }

    public k(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) o.a(proxySelector);
        this.c = (String) o.a(str);
        this.d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new k(ProxySelector.getDefault(), str, i));
    }

    private static /* synthetic */ void zZXCq() {
        char[] charArray = "]QS\u0010Y_S[\u0010\\QG\u0010MV[RR\u0010tPW|LWZY[".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '>');
        }
        String str = new String(charArray);
        char[] charArray2 = "]RWPWJ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '>');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.c.equals(uri.getHost()) && this.d == uri.getPort()) ? f13735a : this.b.select(uri);
    }
}
