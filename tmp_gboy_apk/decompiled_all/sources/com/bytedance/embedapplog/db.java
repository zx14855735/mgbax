package com.bytedance.embedapplog;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.kd;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.nt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class db {
    private static final String hf = "db#";
    private static long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private static boolean f10101pl = false;
    private static String tf = null;
    private static final List<kd> u = new ArrayList();
    static final String xj = "db#";
    private Long am;
    private final ah c;
    private final Context f;
    private Map<String, String> g;
    private final m kd;
    private final boolean y;
    private final ReentrantLock w = new ReentrantLock();
    private final AtomicBoolean d = new AtomicBoolean(false);

    static {
        pPhr();
    }

    public db(Context context) {
        this.f = context.getApplicationContext();
        m xj2 = ir.xj(context);
        this.kd = xj2;
        if (xj2 != null) {
            this.y = xj2.xj(context);
        } else {
            this.y = false;
        }
        this.c = new ah(context);
    }

    private static /* synthetic */ void pPhr() {
        char[] charArray = "\u0000\f\u000eM\u0004\u0002\u000e\u0006M\u0001\f\u001aM\u0010\u000b\u0006\u000f\u000fM)\r\n!\u0011\n\u0007\u0004\u0006".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'c');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0000\u000f\n\r\n\u0017".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'c');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int i;
        try {
            this.w.lock();
            lx xj2 = this.c.xj();
            long j = -1;
            boolean z = false;
            if (xj2 != null) {
                tf = xj2.xj;
                Boolean bool = xj2.w;
                f10101pl = bool != null && bool.booleanValue();
                Long l = xj2.c;
                p = l == null ? -1L : l.longValue();
                this.g = xj2.xj();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> xj3 = xj(this.f);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            lx lxVar = null;
            String str = null;
            if (xj3.first != null) {
                if (xj2 != null) {
                    str = xj2.hf;
                    i = xj2.y.intValue() + 1;
                } else {
                    i = -1;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                if (i <= 0) {
                    i = 1;
                }
                lx lxVar2 = new lx((String) xj3.first, str, (Boolean) xj3.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), this.am);
                this.c.xj(lxVar2);
                lxVar = lxVar2;
            }
            if (lxVar != null) {
                tf = lxVar.xj;
                Boolean bool2 = lxVar.w;
                if (bool2 != null && bool2.booleanValue()) {
                    z = true;
                }
                f10101pl = z;
                Long l2 = lxVar.c;
                if (l2 != null) {
                    j = l2.longValue();
                }
                p = j;
                this.g = lxVar.xj();
            }
            this.w.unlock();
            xj(new kd.xj(tf, f10101pl, p), w());
        } catch (Throwable th) {
            this.w.unlock();
            xj(new kd.xj(tf, f10101pl, p), w());
            throw th;
        }
    }

    private static Object[] w() {
        Object[] array;
        List<kd> list = u;
        synchronized (list) {
            try {
                array = list.size() > 0 ? list.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array;
    }

    public void hf() {
        if (this.d.compareAndSet(false, true)) {
            xj(new Runnable() { // from class: com.bytedance.embedapplog.db.1
                @Override // java.lang.Runnable
                public void run() {
                    db.this.u();
                }
            });
        }
    }

    public Map<String, String> xj(long j) {
        if (!this.y) {
            return null;
        }
        if (!xj.hf) {
            lx xj2 = this.c.xj();
            if (xj2 != null) {
                return xj2.xj();
            }
            return null;
        }
        hf();
        if (this.g == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.w.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.w.unlock();
                }
            } catch (InterruptedException e) {
                cu.xj(e);
            }
        }
        return this.g;
    }

    public static void xj(kd kdVar) {
        List<kd> list = u;
        synchronized (list) {
            list.add(kdVar);
        }
        String str = tf;
        if (str != null) {
            xj(new kd.xj(str, f10101pl, p), new Object[]{kdVar});
        }
    }

    public m xj() {
        return this.kd;
    }

    private static void xj(kd.xj xjVar, Object[] objArr) {
        if (xjVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((kd) obj).xj(xjVar);
        }
    }

    public static void xj(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            cu.xj(e);
        }
    }

    public static <K, V> void xj(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    private Pair<String, Boolean> xj(Context context) {
        String str;
        Boolean bool;
        m.xj hf2;
        m mVar = this.kd;
        if (mVar == null || (hf2 = mVar.hf(context)) == null) {
            str = null;
            bool = null;
        } else {
            str = hf2.hf;
            bool = Boolean.valueOf(hf2.w);
            if (hf2 instanceof nt.xj) {
                this.am = Long.valueOf(((nt.xj) hf2).xj);
            }
        }
        return new Pair<>(str, bool);
    }

    private static void xj(Runnable runnable) {
        ey.xj(CtFAbx.B25kr6(new StringBuilder(), xj, "-query"), runnable);
    }
}
