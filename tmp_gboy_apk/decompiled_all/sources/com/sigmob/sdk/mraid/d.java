package com.sigmob.sdk.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.sigmob.sdk.mraid.b;
import com.sigmob.windad.WindAdError;
import java.net.URI;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface d {
    void a();

    void a(int i, int i2, int i3, int i4, b.a aVar, boolean z);

    void a(WindAdError windAdError);

    void a(String str, Map<String, String> map);

    void a(URI uri);

    void a(URI uri, int i, String str);

    void a(URI uri, boolean z);

    void a(boolean z);

    void a(boolean z, p pVar);

    boolean a(ConsoleMessage consoleMessage);

    boolean a(String str, JsResult jsResult);

    void b();

    void b(String str, Map<String, String> map);

    void b(boolean z);

    void c();

    void d();

    void e();

    void f();

    void g();
}
