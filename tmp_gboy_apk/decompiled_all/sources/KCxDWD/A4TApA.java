package KCxDWD;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import java.io.BufferedReader;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f4235A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile long f4236A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile boolean f4237A5SV6n = false;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final SharedPreferences f4238ADYaiT;

    public A4TApA(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.f4235A2egSU = context;
        SharedPreferences hf = hf.hf(context, "anr_monitor_table", 0);
        this.f4238ADYaiT = hf;
        this.f4236A4TApA = hf.getLong("trace_anr_happen_time", 0L);
    }

    public static String A2egSU(BufferedReader bufferedReader) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            sb.append(readLine);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Object[] A4TApA(BufferedReader bufferedReader, Pattern... patternArr) {
        if (patternArr.length <= 0) {
            return null;
        }
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return null;
                }
                for (Pattern pattern : patternArr) {
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                }
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
