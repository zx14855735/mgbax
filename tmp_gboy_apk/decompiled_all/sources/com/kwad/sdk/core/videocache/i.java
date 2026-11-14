package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class i extends ProxySelector {
    private static final List<Proxy> aQd = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector aQe;
    private final String aQf;
    private final int aQg;

    static {
        kucsijU();
    }

    private i(ProxySelector proxySelector, String str, int i) {
        this.aQe = (ProxySelector) ax.checkNotNull(proxySelector);
        this.aQf = ax.hy(str);
        this.aQg = i;
    }

    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    private static /* synthetic */ void kucsijU() {
        char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'm');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'm');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aQe.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return (this.aQf.equals(uri.getHost()) && this.aQg == uri.getPort()) ? aQd : this.aQe.select(uri);
    }
}
