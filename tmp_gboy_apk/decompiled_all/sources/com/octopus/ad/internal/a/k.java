package com.octopus.ad.internal.a;

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
    private static final List<Proxy> f12398a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;
    private final String c;
    private final int d;

    static {
        ZgLE();
    }

    public k(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) n.a(proxySelector);
        this.c = (String) n.a(str);
        this.d = i;
    }

    private static /* synthetic */ void ZgLE() {
        char[] charArray = "2><\u007f60<4\u007f3>(\u007f\"94==\u007f\u001b?8\u0013#8564".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Q');
        }
        String str = new String(charArray);
        char[] charArray2 = "2=8?8%".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new k(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        try {
            return (this.c.equals(uri.getHost()) && this.d == uri.getPort()) ? f12398a : this.b.select(uri);
        } catch (Exception unused) {
            return f12398a;
        }
    }
}
