package com.bytedance.sdk.component.hf.xj;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends f implements Cloneable {
    static final List<g> f = com.bytedance.sdk.component.hf.xj.hf.tf.xj(g.HTTP_2, g.HTTP_1_1);
    public TimeUnit c;
    public List<g> d;
    public long hf;
    public TimeUnit kd;
    public com.bytedance.sdk.component.hf.xj.xj.xj.xj p;
    public Set<String> tf;
    public long u;
    public TimeUnit w;
    public List<d> xj;
    public long y;

    static {
        Ipil();
    }

    public pl() {
        this(new xj());
    }

    private static /* synthetic */ void Ipil() {
        char[] charArray = "\u0002\u000e\fO\u0006\u0000\f\u0004O\u0003\u000e\u0018O\u0012\t\u0004\r\rO+\u000f\b#\u0013\b\u0005\u0006\u0004".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'a');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0002\r\b\u000f\b\u0015".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'a');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public xj hf() {
        return new xj(this);
    }

    public hf xj(am amVar) {
        return null;
    }

    public static final class xj {
        public long c;
        List<g> d;
        public TimeUnit f;
        public com.bytedance.sdk.component.hf.xj.xj.xj.xj hf;
        public long kd;
        public Bundle p;
        public Set<String> tf;
        public TimeUnit u;
        public long w;
        public final List<d> xj;
        public TimeUnit y;

        public xj() {
            this.xj = new ArrayList();
            this.w = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.u = timeUnit;
            this.kd = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.y = timeUnit;
            this.c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f = timeUnit;
        }

        public xj hf(long j, TimeUnit timeUnit) {
            this.kd = j;
            this.y = timeUnit;
            return this;
        }

        public xj w(long j, TimeUnit timeUnit) {
            this.c = j;
            this.f = timeUnit;
            return this;
        }

        public xj xj(long j, TimeUnit timeUnit) {
            this.w = j;
            this.u = timeUnit;
            return this;
        }

        public xj xj(com.bytedance.sdk.component.hf.xj.xj.xj.xj xjVar) {
            this.hf = xjVar;
            return this;
        }

        public xj xj(d dVar) {
            this.xj.add(dVar);
            return this;
        }

        public xj xj(Set<String> set) {
            this.tf = set;
            return this;
        }

        public xj xj(List<g> list) {
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.contains(g.HTTP_1_1)) {
                if (!arrayList.contains(g.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(g.SPDY_3);
                        this.d = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                }
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
        }

        public xj(String str) {
            this.xj = new ArrayList();
            this.w = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.u = timeUnit;
            this.kd = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.y = timeUnit;
            this.c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f = timeUnit;
            this.d = pl.f;
        }

        public xj xj(Bundle bundle) {
            this.p = bundle;
            return this;
        }

        public pl xj() {
            if (com.bytedance.sdk.component.hf.xj.xj.xj.xj().hf()) {
                return com.bytedance.sdk.component.hf.xj.xj.xj.hf(this);
            }
            return com.bytedance.sdk.component.hf.xj.xj.xj.xj(this);
        }

        public xj(pl plVar) {
            this.xj = new ArrayList();
            this.w = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.u = timeUnit;
            this.kd = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.y = timeUnit;
            this.c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f = timeUnit;
            this.w = plVar.hf;
            this.u = plVar.w;
            this.kd = plVar.u;
            this.y = plVar.kd;
            this.c = plVar.y;
            this.f = plVar.c;
            this.d = plVar.d;
            this.tf = plVar.tf;
        }
    }

    public pl(xj xjVar) {
        this.hf = xjVar.w;
        this.u = xjVar.kd;
        this.y = xjVar.c;
        this.w = xjVar.u;
        this.kd = xjVar.y;
        this.c = xjVar.f;
        this.xj = xjVar.xj;
        this.d = xjVar.d;
        this.tf = xjVar.tf;
        this.p = xjVar.hf;
    }

    public u xj() {
        return null;
    }
}
