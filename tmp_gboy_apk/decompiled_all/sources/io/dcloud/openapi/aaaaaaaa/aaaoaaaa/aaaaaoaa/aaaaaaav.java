package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaaa;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaav {
    private static io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaaa aaaaaaa0 = null;
    private static int aaaaaaaa = 1;
    private static aaaaaaav aaaaaaac;
    private static SharedPreferences aaaaaaao;
    private static Map aaaaaaau = new ConcurrentHashMap();

    static {
        TuBr();
    }

    private static /* synthetic */ void TuBr() {
        char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 21);
        }
        String str = new String(charArray);
        char[] charArray2 = "vy|{|a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 21);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaaa aaaaaaaa(Context context) {
        if (aaaaaaa0 == null) {
            synchronized (aaaaaaav.class) {
                if (aaaaaaa0 == null) {
                    try {
                        aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaaa.aaaaaaaa(new File(context.getFilesDir(), "dcloudcache"), aaaaaaaa, 1, 10240L);
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return aaaaaaa0;
    }

    private static void aaaaaaao(Context context) {
        if (aaaaaaao == null) {
            synchronized (aaaaaaav.class) {
                try {
                    if (aaaaaaao == null) {
                        aaaaaaao = context.getSharedPreferences("dcloudcache", 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public Map aaaaaaa0(Context context) {
        aaaaaaao(context);
        Map<String, ?> all = aaaaaaao.getAll();
        if (all != null) {
            for (String str : all.keySet()) {
                if (!TextUtils.isEmpty(str) && !aaaaaaau.containsKey(str)) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaaa(str);
                    aaaaaaaaVar.aaaaaaaa((String) all.get(str));
                    aaaaaaau.put(str, aaaaaaaaVar);
                }
            }
        }
        return aaaaaaau;
    }

    public static aaaaaaav aaaaaaaa() {
        if (aaaaaaac == null) {
            synchronized (aaaaaaav.class) {
                try {
                    if (aaaaaaac == null) {
                        aaaaaaac = new aaaaaaav();
                        aaaaaaau.clear();
                    }
                } finally {
                }
            }
        }
        return aaaaaaac;
    }

    public void aaaaaaa0(Context context, String str) {
        aaaaaaau.remove(str);
        aaaaaaao(context);
        SharedPreferences.Editor edit = aaaaaaao.edit();
        edit.remove(str);
        edit.apply();
        try {
            aaaaaaaa(context).aaaaaaau(str);
        } catch (IOException unused) {
        }
    }

    private void aaaaaaaa(Context context, String str, String str2) {
        aaaaaaao(context);
        SharedPreferences.Editor edit = aaaaaaao.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void aaaaaaaa(Context context, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var, String str) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaaa(aaaaaaa0Var.aaaaeaaa());
        aaaaaaaaVar.aaaaaaaa(aaaaaaa0Var.aaaaaaav());
        aaaaaaaaVar.aaaaaaaa(aaaaaaa0Var);
        aaaaaaau.put(aaaaaaa0Var.aaaaeaaa(), aaaaaaaaVar);
        try {
            aaaaaaaa(context, aaaaaaa0Var.aaaaeaaa(), aaaaaaa0Var.aaaaaaav());
            aaaaaaaa.aaaaaaao aaaaaaa02 = aaaaaaaa(context).aaaaaaa0(aaaaaaa0Var.aaaaeaaa());
            OutputStream aaaaaaaa2 = aaaaaaa02.aaaaaaaa(0);
            aaaaaaaa2.write(str.getBytes());
            aaaaaaaa2.close();
            aaaaaaa02.aaaaaaa0();
            aaaaaaaa(context).flush();
        } catch (Exception unused) {
        }
    }

    public String aaaaaaaa(Context context, String str) {
        try {
            return aaaaaaaa(context).aaaaaaao(str).getString(0);
        } catch (Exception unused) {
            return null;
        }
    }
}
