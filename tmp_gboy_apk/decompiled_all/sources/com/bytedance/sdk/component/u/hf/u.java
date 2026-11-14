package com.bytedance.sdk.component.u.hf;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements w, Function {
    w hf;
    Function xj;

    public u(w wVar) {
        this.hf = wVar;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void apply() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void applySync() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void clear() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean contains(String str) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(24, sparseArray, 0, 1, str);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        apply = this.xj.apply(sparseArray);
        return (SharedPreferences.Editor) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public float get(String str, float f) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(13, sparseArray, 0, 1, str);
        sparseArray.put(2, Float.valueOf(f));
        apply = this.xj.apply(sparseArray);
        return ((Float) apply).floatValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Map getAll() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        apply = this.xj.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(23, sparseArray, 0, 1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(22, sparseArray, 0, 1, str);
        sparseArray.put(2, Float.valueOf(f));
        apply = this.xj.apply(sparseArray);
        return ((Float) apply).floatValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(20, sparseArray, 0, 1, str);
        sparseArray.put(2, Integer.valueOf(i));
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(21, sparseArray, 0, 1, str);
        sparseArray.put(2, Long.valueOf(j));
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(18, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(19, sparseArray, 0, 1, str);
        sparseArray.put(2, set);
        apply = this.xj.apply(sparseArray);
        return (Set) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(3, sparseArray, 0, 1, str);
        sparseArray.put(2, Float.valueOf(f));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        sparseArray.put(1, onSharedPreferenceChangeListener);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void remove(String str) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(7, sparseArray, 0, 1, str);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, onSharedPreferenceChangeListener);
        this.xj.apply(sparseArray);
    }

    public u(Function function) {
        this.xj = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.hf.put((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 2:
                this.hf.put((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 3:
                this.hf.put((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue());
                return null;
            case 4:
                this.hf.put((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue());
                return null;
            case 5:
                this.hf.put((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 6:
                this.hf.put((String) sparseArray.get(1), (Set<String>) sparseArray.get(2));
                return null;
            case 7:
                this.hf.remove((String) sparseArray.get(1));
                return null;
            case 8:
                this.hf.clear();
                return null;
            case 9:
                this.hf.apply();
                return null;
            case 10:
                this.hf.applySync();
                return null;
            case 11:
                return Integer.valueOf(this.hf.get((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue()));
            case 12:
                return Long.valueOf(this.hf.get((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue()));
            case 13:
                return Float.valueOf(this.hf.get((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue()));
            case 14:
                return Boolean.valueOf(this.hf.get((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue()));
            case 15:
                return this.hf.get((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 16:
                return this.hf.get((String) sparseArray.get(1), (Set<String>) sparseArray.get(2));
            case 17:
                return this.hf.getAll();
            case 18:
                return this.hf.getString((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 19:
                return this.hf.getStringSet((String) sparseArray.get(1), (Set) sparseArray.get(2));
            case 20:
                return Integer.valueOf(this.hf.getInt((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue()));
            case 21:
                return Long.valueOf(this.hf.getLong((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue()));
            case 22:
                return Float.valueOf(this.hf.getFloat((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue()));
            case 23:
                return Boolean.valueOf(this.hf.getBoolean((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue()));
            case 24:
                return Boolean.valueOf(this.hf.contains((String) sparseArray.get(1)));
            case 25:
                return this.hf.edit();
            case 26:
                this.hf.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) sparseArray.get(1));
                return null;
            case 27:
                this.hf.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) sparseArray.get(1));
                return null;
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public int get(String str, int i) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(11, sparseArray, 0, 1, str);
        sparseArray.put(2, Integer.valueOf(i));
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        sparseArray.put(2, Integer.valueOf(i));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public long get(String str, long j) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(12, sparseArray, 0, 1, str);
        sparseArray.put(2, Long.valueOf(j));
        apply = this.xj.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        sparseArray.put(2, Long.valueOf(j));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public String get(String str, String str2) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(15, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(5, sparseArray, 0, 1, str);
        sparseArray.put(2, str2);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public Set get(String str, Set set) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(16, sparseArray, 0, 1, str);
        sparseArray.put(2, set);
        apply = this.xj.apply(sparseArray);
        return (Set) apply;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(6, sparseArray, 0, 1, str);
        sparseArray.put(2, set);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public boolean get(String str, boolean z) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(14, sparseArray, 0, 1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(4, sparseArray, 0, 1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
    }
}
