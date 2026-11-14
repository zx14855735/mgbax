package com.ss.android.socialbase.downloader.network.xj;

import com.ss.android.socialbase.downloader.network.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements c {
    private static final ArrayList<String> kd;
    private int c;
    private boolean d;
    private long f;
    protected final long hf;
    private c p;
    private boolean tf;
    protected List<com.ss.android.socialbase.downloader.model.w> w;
    protected final String xj;
    private Map<String, String> y = null;
    protected final Object u = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        kd = arrayList;
        arrayList.add(com.sigmob.sdk.downloader.core.c.e);
        arrayList.add(com.sigmob.sdk.downloader.core.c.f);
        arrayList.add(com.sigmob.sdk.downloader.core.c.h);
        arrayList.add(com.sigmob.sdk.downloader.core.c.i);
        arrayList.add(com.sigmob.sdk.downloader.core.c.g);
        arrayList.add(com.sigmob.sdk.downloader.core.c.j);
        aTeN();
    }

    public w(String str, List<com.ss.android.socialbase.downloader.model.w> list, long j) {
        this.xj = str;
        this.w = list;
        this.hf = j;
    }

    private static /* synthetic */ void aTeN() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean c() {
        return this.tf;
    }

    public Map<String, String> d() {
        return this.y;
    }

    public List<com.ss.android.socialbase.downloader.model.w> f() {
        return this.w;
    }

    @Override // com.ss.android.socialbase.downloader.network.c
    public int hf() {
        return this.c;
    }

    public boolean kd() {
        return this.d;
    }

    public void u() {
        synchronized (this.u) {
            try {
                if (this.tf && this.y == null) {
                    this.u.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c
    public void w() {
        c cVar = this.p;
        if (cVar != null) {
            cVar.w();
        }
    }

    public boolean xj(int i) {
        return i >= 200 && i < 300;
    }

    public boolean y() {
        return System.currentTimeMillis() - this.f < hf.hf;
    }

    public void xj() {
        if (this.y != null) {
            return;
        }
        try {
            this.tf = true;
            this.p = com.ss.android.socialbase.downloader.downloader.w.xj(this.xj, this.w);
            synchronized (this.u) {
                try {
                    if (this.p != null) {
                        HashMap hashMap = new HashMap();
                        this.y = hashMap;
                        xj(this.p, hashMap);
                        this.c = this.p.hf();
                        this.f = System.currentTimeMillis();
                        this.d = xj(this.c);
                    }
                    this.tf = false;
                    this.u.notifyAll();
                } finally {
                }
            }
        } catch (Throwable th) {
            synchronized (this.u) {
                try {
                    if (this.p != null) {
                        HashMap hashMap2 = new HashMap();
                        this.y = hashMap2;
                        xj(this.p, hashMap2);
                        this.c = this.p.hf();
                        this.f = System.currentTimeMillis();
                        this.d = xj(this.c);
                    }
                    this.tf = false;
                    this.u.notifyAll();
                    throw th;
                } finally {
                }
            }
        }
    }

    private void xj(c cVar, Map<String, String> map) {
        if (cVar == null || map == null) {
            return;
        }
        Iterator<String> it = kd.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, cVar.xj(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c
    public String xj(String str) {
        Map<String, String> map = this.y;
        if (map != null) {
            return map.get(str);
        }
        c cVar = this.p;
        if (cVar != null) {
            return cVar.xj(str);
        }
        return null;
    }
}
