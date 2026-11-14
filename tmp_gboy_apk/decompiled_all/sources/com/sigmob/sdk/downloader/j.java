package com.sigmob.sdk.downloader;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.downloader.core.connection.a;
import java.net.ProtocolException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13428a = 10;
    static final int b = 307;
    static final int c = 308;

    public static String a(a.InterfaceC0451a interfaceC0451a, int i) {
        String c2 = interfaceC0451a.c("Location");
        if (c2 != null) {
            return c2;
        }
        throw new ProtocolException(CtFAbx.ASJ6gh(i, "Response code is ", " but can't find Location field"));
    }

    public static boolean a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
