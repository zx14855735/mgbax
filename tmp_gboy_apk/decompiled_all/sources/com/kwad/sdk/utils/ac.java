package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ac {
    private static Handler iK = new Handler(Looper.getMainLooper());
    private static volatile boolean MC = false;

    static {
        zwiLk();
    }

    public static void S(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i, long j) {
        if (com.kwad.framework.a.a.aph.booleanValue() && !MC) {
            MC = true;
            View inflate = com.kwad.sdk.o.m.inflate(context, i, null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            iK.postDelayed(new bg() { // from class: com.kwad.sdk.utils.ac.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    ac.access$002(false);
                }
            }, j);
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        MC = false;
        return false;
    }

    private static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    public static void c(Context context, String str, long j) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    private static /* synthetic */ void zwiLk() {
        char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'P');
        }
        String str = new String(charArray);
        char[] charArray2 = "3<9>9$".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'P');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void c(Context context, String str, int i) {
        if (com.kwad.framework.a.a.aph.booleanValue()) {
            Context applicationContext = context.getApplicationContext();
            View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(applicationContext);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }
}
