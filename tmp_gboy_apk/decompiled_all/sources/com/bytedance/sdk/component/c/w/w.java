package com.bytedance.sdk.component.c.w;

import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.component.tf.tf;
import com.bytedance.sdk.component.u.c;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements com.bytedance.sdk.component.u.hf.w {
    private static int hf = 3;
    private static ThreadPoolExecutor xj;
    private final boolean am;
    private long d;
    private volatile boolean f;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private final com.bytedance.sdk.component.c.hf f10199pl;
    private final File u;
    private final File w;
    private final Object kd = new Object();
    private final Map<String, Object> y = new ConcurrentHashMap();
    private Map<String, Object> c = new HashMap();
    private final List<Runnable> tf = new ArrayList();
    private AtomicBoolean g = new AtomicBoolean(false);

    public final class xj implements SharedPreferences.Editor {
        public xj() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            w.this.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                w.w(w.this);
                w.this.c.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            w.this.xj(str, (String) Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            w.this.xj(str, (String) Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            w.this.xj(str, (String) Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            w.this.xj(str, (String) Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            w.this.xj(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            w.this.xj(str, (String) set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            w.this.remove(str);
            return this;
        }
    }

    public w(File file, com.bytedance.sdk.component.c.xj xjVar, com.bytedance.sdk.component.c.hf hfVar, boolean z) {
        this.f = false;
        this.am = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            xjVar = new com.bytedance.sdk.component.c.w.xj(null);
            file = file2;
        }
        this.w = file;
        this.u = new File(file.getPath() + ".bak");
        this.f = false;
        xjVar = xjVar == null ? new com.bytedance.sdk.component.c.w.xj(null) : xjVar;
        if (hfVar == null) {
            this.f10199pl = new com.bytedance.sdk.component.c.w.xj(null);
        } else {
            this.f10199pl = hfVar;
        }
        xj(xjVar);
    }

    public static /* synthetic */ long w(w wVar) {
        long j = wVar.d;
        wVar.d = 1 + j;
        return j;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void apply() {
        if (!this.f) {
            if (this.g.compareAndSet(false, true)) {
                xj(new Runnable() { // from class: com.bytedance.sdk.component.c.w.w.3
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.g.set(false);
                        w.this.apply();
                    }
                });
            }
        } else if (this.p != this.d && this.g.compareAndSet(false, true)) {
            w().execute(new Runnable() { // from class: com.bytedance.sdk.component.c.w.w.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> kd = w.this.kd();
                        if (kd != null) {
                            w.this.f10199pl.xj(kd, w.this.w);
                        }
                        w.this.g.set(false);
                    } catch (Exception e) {
                        w.this.xj("apply write error", (Throwable) e);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void applySync() {
        if (!this.f) {
            if (this.g.compareAndSet(false, true)) {
                xj(new Runnable() { // from class: com.bytedance.sdk.component.c.w.w.5
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.g.set(false);
                        w.this.applySync();
                    }
                });
            }
        } else if (this.g.compareAndSet(false, true)) {
            try {
                Map<String, Object> kd = kd();
                if (kd != null) {
                    this.f10199pl.xj(kd, this.w);
                }
                this.g.set(false);
            } catch (Exception e) {
                xj("applySync write error", (Throwable) e);
            }
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void clear() {
        if (!this.f) {
            xj(new Runnable() { // from class: com.bytedance.sdk.component.c.w.w.2
                @Override // java.lang.Runnable
                public void run() {
                    w.this.y.clear();
                    synchronized ("SharedPreferencesImpl") {
                        w.this.c.clear();
                        w.w(w.this);
                    }
                }
            });
            return;
        }
        this.y.clear();
        synchronized ("SharedPreferencesImpl") {
            this.c.clear();
            this.d++;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean contains(String str) {
        boolean containsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.kd) {
            hf();
            containsKey = this.y.containsKey(str);
        }
        return containsKey;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> u;
        if (!this.am) {
            return u();
        }
        synchronized (this.kd) {
            hf();
            u = u();
        }
        return u;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean xj2;
        if (str == null) {
            str = "";
        }
        if (!this.am) {
            return xj(str, z);
        }
        synchronized (this.kd) {
            hf();
            xj2 = xj(str, z);
        }
        return xj2;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float xj2;
        if (str == null) {
            str = "";
        }
        if (!this.am) {
            return xj(str, f);
        }
        synchronized (this.kd) {
            hf();
            xj2 = xj(str, f);
        }
        return xj2;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public int getInt(String str, int i) {
        int xj2;
        if (str == null) {
            str = "";
        }
        if (!this.am) {
            return xj(str, i);
        }
        synchronized (this.kd) {
            hf();
            xj2 = xj(str, i);
        }
        return xj2;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public long getLong(String str, long j) {
        long xj2;
        if (str == null) {
            str = "";
        }
        if (!this.am) {
            return xj(str, j);
        }
        synchronized (this.kd) {
            hf();
            xj2 = xj(str, j);
        }
        return xj2;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public String getString(String str, String str2) {
        String xj2;
        if (str == null) {
            str = "";
        }
        if (!this.am) {
            return xj(str, str2);
        }
        synchronized (this.kd) {
            hf();
            xj2 = xj(str, str2);
        }
        return xj2;
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> xj2;
        if (str == null) {
            str = "";
        }
        if (!this.am) {
            return xj(str, set);
        }
        synchronized (this.kd) {
            hf();
            xj2 = xj(str, set);
        }
        return xj2;
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, int i) {
        xj(str, (String) Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void remove(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.c.put(str, null);
            this.d++;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.component.c.xj xjVar) {
        Map<String, Object> map;
        synchronized (this.kd) {
            try {
                if (this.f) {
                    return;
                }
                if (this.u.exists()) {
                    this.w.delete();
                    this.u.renameTo(this.w);
                }
                try {
                    map = xjVar.xj(this.w);
                } catch (Throwable th) {
                    xj("loadFromDisk error", th);
                    map = null;
                }
                synchronized (this.kd) {
                    try {
                        this.f = true;
                        if (map != null) {
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                Object value = entry.getValue();
                                if (value != null) {
                                    String key = entry.getKey();
                                    if (key == null) {
                                        key = "";
                                    }
                                    this.y.put(key, value);
                                }
                            }
                        }
                        this.kd.notifyAll();
                    } catch (Throwable th2) {
                        this.kd.notifyAll();
                        throw th2;
                    } finally {
                    }
                }
                synchronized (this.tf) {
                    try {
                        Iterator<Runnable> it = this.tf.iterator();
                        while (it.hasNext()) {
                            it.next().run();
                        }
                        this.tf.clear();
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> kd() {
        HashMap hashMap;
        synchronized ("SharedPreferencesImpl") {
            hashMap = new HashMap(this.c);
            this.c = new HashMap();
        }
        HashMap hashMap2 = new HashMap(this.y);
        if (!hashMap.isEmpty() || !hashMap2.isEmpty()) {
            int i = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Object obj = hashMap2.get(str);
                if (value == null) {
                    if (obj != null) {
                        hashMap2.remove(str);
                        i++;
                    }
                } else if (!value.equals(obj)) {
                    hashMap2.put(str, value);
                    i++;
                }
            }
            if (i <= 0) {
                return null;
            }
        }
        return hashMap2;
    }

    private Map<String, ?> u() {
        HashMap hashMap = new HashMap(this.y);
        hashMap.putAll(this.c);
        return hashMap;
    }

    private static ThreadPoolExecutor w() {
        ThreadPoolExecutor threadPoolExecutor = xj;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (w.class) {
            try {
                ThreadPoolExecutor threadPoolExecutor2 = xj;
                if (threadPoolExecutor2 != null) {
                    return threadPoolExecutor2;
                }
                int i = hf;
                com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new tf("SharedPreferencesImpl"));
                xj = uVar;
                return uVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, long j) {
        xj(str, (String) Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, float f) {
        xj(str, (String) Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, boolean z) {
        xj(str, (String) Boolean.valueOf(z));
    }

    private void xj(final com.bytedance.sdk.component.c.xj xjVar) {
        synchronized (this.kd) {
            this.f = false;
        }
        w().execute(new Runnable() { // from class: com.bytedance.sdk.component.c.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.hf(xjVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, String str2) {
        xj(str, str2);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.u.hf.w
    public void put(String str, Set<String> set) {
        xj(str, (String) set);
    }

    private String xj(String str, String str2) {
        try {
            Object obj = this.c.get(str);
            if (obj == null) {
                obj = this.y.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            xj("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    private Set<String> xj(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.c.get(str);
            if (set2 == null) {
                set2 = (Set) this.y.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            xj("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    private int xj(String str, int i) {
        try {
            Object obj = this.c.get(str);
            if (obj == null) {
                obj = this.y.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            xj("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    private long xj(String str, long j) {
        try {
            Long l = (Long) this.c.get(str);
            if (l == null) {
                l = (Long) this.y.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            xj("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    private void hf() {
        while (!this.f) {
            try {
                this.kd.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private float xj(String str, float f) {
        try {
            Object obj = this.c.get(str);
            if (obj == null) {
                obj = this.y.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            xj("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    private boolean xj(String str, boolean z) {
        try {
            Boolean bool = (Boolean) this.c.get(str);
            if (bool == null) {
                bool = (Boolean) this.y.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            xj("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.u.hf.w, android.content.SharedPreferences
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public xj edit() {
        synchronized (this.kd) {
            hf();
        }
        return new xj();
    }

    private void xj(Runnable runnable) {
        synchronized (this.tf) {
            try {
                if (this.f) {
                    runnable.run();
                } else {
                    this.tf.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void xj(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.c.put(str, t);
            this.d++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, Throwable th) {
        c cVar = (c) com.bytedance.sdk.openadsdk.ats.w.xj("event");
        if (cVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(n.z, this.w.getAbsolutePath());
                jSONObject.put(br.c, str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            cVar.onExceptionEvent("kv", jSONObject, th);
        }
    }
}
