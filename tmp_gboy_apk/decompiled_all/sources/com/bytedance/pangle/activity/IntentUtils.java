package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class IntentUtils {
    static HashMap<Long, WeakReference<Bundle>> xj = new HashMap<>();

    static {
        kUiPVfi();
    }

    private static /* synthetic */ void kUiPVfi() {
        char[] charArray = "èäæ¥ìêæî¥éäò¥øãîçç¥ÁåâÉùâïìî".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 139);
        }
        String str = new String(charArray);
        char[] charArray2 = "èçâåâÿ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 139);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @A5SV6n.A2egSU
    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void xj(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            xj(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void xj(long j, Bundle bundle) {
        xj.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void xj(Intent intent) {
        Bundle xj2;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (xj2 = xj(longExtra)) == null) {
            return;
        }
        intent.putExtras(xj2);
    }

    private static Bundle xj(long j) {
        WeakReference<Bundle> remove = xj.remove(Long.valueOf(j));
        if (remove != null) {
            return remove.get();
        }
        return null;
    }
}
