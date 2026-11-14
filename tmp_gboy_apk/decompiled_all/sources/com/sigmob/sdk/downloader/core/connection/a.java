package com.sigmob.sdk.downloader.core.connection;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13364a = 0;

    /* renamed from: com.sigmob.sdk.downloader.core.connection.a$a, reason: collision with other inner class name */
    public interface InterfaceC0451a {
        String c(String str);

        int d();

        InputStream e();

        Map<String, List<String>> f();

        String g();
    }

    public interface b {
        a a(String str);
    }

    InterfaceC0451a a();

    void a(String str, String str2);

    boolean a(String str);

    String b(String str);

    void b();

    Map<String, List<String>> c();
}
