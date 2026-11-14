package com.bytedance.sdk.component.c.hf.xj;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.u.hf.w;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements w {
    private Keva xj;
    private static final Map<String, w> hf = new HashMap();
    private static volatile boolean w = false;
    private static volatile boolean u = true;

    static {
        XVovXvi();
    }

    private xj(String str, boolean z, int i) {
        if (i != 1) {
            hf(str, z);
        } else {
            xj(str, z);
        }
    }

    private static /* synthetic */ void XVovXvi() {
        char[] charArray = "JFD\u0007NHDL\u0007KFP\u0007ZALEE\u0007cG@k[@MNL".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ')');
        }
        String str = new String(charArray);
        char[] charArray2 = "JE@G@]".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ')');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void hf(String str, boolean z) {
        if (z) {
            this.xj = Keva.getRepoSync(str, 1);
        } else {
            this.xj = Keva.getRepoSync(str, 0);
        }
    }

    public static w xj(Context context, String str, boolean z, int i) {
        if (!u) {
            return null;
        }
        try {
            if (!w) {
                w = xj(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!u) {
                return null;
            }
            Map<String, w> map = hf;
            w wVar = map.get(str);
            if (wVar == null) {
                wVar = new xj(str, z, i);
                if (u) {
                    map.put(str, wVar);
                }
            }
            if (u) {
                return wVar;
            }
            return null;
        } catch (Throwable unused) {
            u = false;
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void applySync() {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void clear() {
        this.xj.clear();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.xj.contains(str);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.xj.getAll();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.xj.getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.xj.getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.xj.getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.xj.getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.xj.getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.xj.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, int i) {
        this.xj.storeInt(str, i);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void remove(String str) {
        this.xj.erase(str);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, long j) {
        this.xj.storeLong(str, j);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, float f) {
        this.xj.storeFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, boolean z) {
        this.xj.storeBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, String str2) {
        this.xj.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, Set<String> set) {
        this.xj.getStringSet(str, set);
    }

    private static boolean xj(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.c.hf.xj.xj.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private void xj(String str, boolean z) {
        if (z) {
            this.xj = Keva.getRepo(str, 1);
        } else {
            this.xj = Keva.getRepo(str, 0);
        }
    }
}
