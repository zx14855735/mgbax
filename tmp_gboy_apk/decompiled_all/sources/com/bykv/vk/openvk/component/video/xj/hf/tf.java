package com.bykv.vk.openvk.component.video.xj.hf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class tf extends ProxySelector {
    private static final List<Proxy> xj = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector hf = ProxySelector.getDefault();
    private final int u;
    private final String w;

    static {
        zilxV();
    }

    private tf(String str, int i) {
        this.w = str;
        this.u = i;
    }

    public static void xj(String str, int i) {
        ProxySelector.setDefault(new tf(str, i));
    }

    private static /* synthetic */ void zilxV() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.hf.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.w.equalsIgnoreCase(uri.getHost()) && this.u == uri.getPort()) ? xj : this.hf.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
