package com.bytedance.sdk.component.c.w;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements com.bytedance.sdk.component.u.hf.w {
    SharedPreferences xj;

    public u(SharedPreferences sharedPreferences) {
        this.xj = sharedPreferences;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void applySync() {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void clear() {
        try {
            this.xj.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.xj.contains(str);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.xj.edit();
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public int get(String str, int i) {
        try {
            return this.xj.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.xj.getAll();
        } catch (Exception unused) {
            return Collections.EMPTY_MAP;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.xj.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.xj.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.xj.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.xj.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.xj.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.xj.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, int i) {
        try {
            this.xj.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.xj.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void remove(String str) {
        try {
            this.xj.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.xj.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public long get(String str, long j) {
        try {
            return this.xj.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, long j) {
        try {
            this.xj.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public float get(String str, float f) {
        try {
            return this.xj.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, float f) {
        try {
            this.xj.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public boolean get(String str, boolean z) {
        try {
            return this.xj.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, boolean z) {
        try {
            this.xj.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public String get(String str, String str2) {
        try {
            return this.xj.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, String str2) {
        try {
            this.xj.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public Set<String> get(String str, Set<String> set) {
        try {
            return this.xj.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, Set<String> set) {
        try {
            this.xj.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }
}
