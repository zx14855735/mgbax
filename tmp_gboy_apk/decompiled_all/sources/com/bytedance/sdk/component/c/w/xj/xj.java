package com.bytedance.sdk.component.c.w.xj;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.u.hf.w {
    private static final Map<String, com.bytedance.sdk.component.u.hf.w> hf = new ConcurrentHashMap();
    private String xj;

    static {
        lSqX();
    }

    private xj(String str) {
        this.xj = str;
    }

    private static /* synthetic */ void lSqX() {
        char[] charArray = "2><\u007f60<4\u007f3>(\u007f\"94==\u007f\u001b?8\u0013#8564".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Q');
        }
        String str = new String(charArray);
        char[] charArray2 = "2=8?8%".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.sdk.component.u.hf.w xj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.u.hf.w> map = hf;
        com.bytedance.sdk.component.u.hf.w wVar = map.get(str);
        if (wVar != null) {
            return wVar;
        }
        xj xjVar = new xj(str);
        map.put(str, xjVar);
        return xjVar;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void applySync() {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void clear() {
        hf.xj(this.xj);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean contains(String str) {
        return hf.xj(this.xj, str);
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
        return hf.hf(this.xj);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return hf.xj(this.xj, str, z);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return hf.xj(this.xj, str, f);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return hf.xj(this.xj, str, i);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return hf.xj(this.xj, str, j);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return hf.hf(this.xj, str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return hf.hf(this.xj, str, set);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, int i) {
        hf.xj(this.xj, str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void remove(String str) {
        hf.hf(this.xj, str);
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
        hf.xj(this.xj, str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, float f) {
        hf.xj(this.xj, str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, boolean z) {
        hf.xj(this.xj, str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, String str2) {
        hf.xj(this.xj, str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, Set<String> set) {
        hf.xj(this.xj, str, set);
    }
}
