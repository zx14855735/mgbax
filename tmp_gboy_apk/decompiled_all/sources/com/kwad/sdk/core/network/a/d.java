package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    static {
        fwYM();
    }

    private static /* synthetic */ void fwYM() {
        char[] charArray = "+'%f/)%-f*'1f; -$$f\u0002&!\n:!,/-".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'H');
        }
        String str = new String(charArray);
        char[] charArray2 = "+$!&!<".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'H');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String go = com.kwad.sdk.ip.direct.a.go(str);
        if (TextUtils.isEmpty(go)) {
            com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
            return SYSTEM.lookup(str);
        }
        List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(go));
        if (asList == null || asList.isEmpty()) {
            return SYSTEM.lookup(str);
        }
        com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
        return asList;
    }
}
