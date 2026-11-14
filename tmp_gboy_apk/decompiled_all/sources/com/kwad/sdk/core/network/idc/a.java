package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static final int aKj;
    private final Map<String, String> aKe;
    private final com.kwad.sdk.core.network.idc.a.b aKf;
    private final Random aKg;
    private final Map<String, AtomicBoolean> aKh;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> aKi;
    private volatile int aKk;
    private volatile boolean aKl;
    private Context mContext;

    /* renamed from: com.kwad.sdk.core.network.idc.a$a, reason: collision with other inner class name */
    public static final class C0367a {
        private static final a aKo = new a(0);

        static {
            KHif();
        }

        private static /* synthetic */ void KHif() {
            char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 20);
            }
            String str = new String(charArray);
            char[] charArray2 = "wx}z}`".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 20);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        aKj = com.kwad.framework.a.a.oy.booleanValue() ? 0 : BaseConstants.Time.MINUTE;
        QLlVBa();
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA() {
        com.kwad.sdk.core.network.idc.a.b bJ = b.bJ(this.mContext);
        if (bJ.isEmpty()) {
            bJ = b.bI(this.mContext);
        }
        this.aKf.a(bJ);
    }

    public static a Jz() {
        return C0367a.aKo;
    }

    private static /* synthetic */ void QLlVBa() {
        char[] charArray = "zvt7~xt|7{v`7jq|uu7Swp[kp}~|".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 25);
        }
        String str = new String(charArray);
        char[] charArray2 = "zupwpm".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 25);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void W(String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> et = this.aKf.et(str2);
        if (et.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.aKh.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String er = er(str2);
                if (TextUtils.isEmpty(er) || host.equals(er)) {
                    int size = et.size();
                    int indexOf = et.indexOf(host);
                    boolean z = indexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.aKg.nextInt(size) + 1;
                        if (z) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % et.size();
                        String str3 = et.get(size2);
                        c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + et + ", key = " + size2);
                        Y(str2, str3);
                        if (q(str2, size2)) {
                            eo(str2);
                        }
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                } else {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                c.d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void Y(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.aKe.put(str, str2);
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(a.this.mContext, (Map<String, String>) a.this.aKe);
            }
        });
    }

    private void eo(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        A2egSU.B7CMnp("save switched host, type = ", str, "IdcManager");
        this.aKi.put(str, new com.kwad.sdk.core.network.idc.a.a(elapsedRealtime, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eq(String str) {
        boolean ht;
        String er = er(str);
        List<String> et = this.aKf.et(str);
        if (et.isEmpty()) {
            return false;
        }
        String str2 = et.get(0);
        if (TextUtils.equals(str2, er)) {
            return true;
        }
        if ("api".equals(str)) {
            ht = c(com.kwad.framework.a.a.oy.booleanValue() ? "beta2-ad-open-api.test.gifshow.com" : str2, this.mContext);
        } else {
            ht = ao.ht(str2);
        }
        StringBuilder BChYOn2 = J3FDQU.A2egSU.BChYOn("perform ping action for ", str, ",mainHost = ", str2, ",isSuccess = ");
        BChYOn2.append(ht);
        c.d("IdcManager", BChYOn2.toString());
        if (ht) {
            Y(str, str2);
        }
        return ht;
    }

    private String er(String str) {
        return this.aKe.get(str);
    }

    private boolean q(String str, int i) {
        return "api".equals(str) && i > 0 && !this.aKi.containsKey(str) && this.aKk > 0;
    }

    public final boolean JB() {
        return !this.aKi.isEmpty();
    }

    public final String X(String str, String str2) {
        String str3 = this.aKe.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String Z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String er = er(str2);
        if (er == null || er.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath()) || er.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(er);
        if (TextUtils.isEmpty(parse.getScheme())) {
            builder.scheme("https");
        } else {
            builder.scheme(parse.getScheme());
        }
        builder.path(parse.getPath());
        if (!TextUtils.isEmpty(parse.getQuery())) {
            builder.query(parse.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    public final void ep(String str) {
        int i = this.aKk;
        if (this.aKl || i <= 0) {
            c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.aKl + ",rollbackInterval = " + i);
            return;
        }
        com.kwad.sdk.core.network.idc.a.a aVar = this.aKi.get(str);
        if (aVar != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.JE();
            boolean z = elapsedRealtime > ((long) Math.max(i, aKj));
            c.d("IdcManager", "handleHostRollback: isAvailable = " + z + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i + ",hostType = hostType");
            if (z) {
                AtomicBoolean atomicBoolean = this.aKh.get(str);
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        try {
                            boolean JD = aVar.JD();
                            c.d("IdcManager", "handleHostRollback: isInRollback = " + JD);
                            if (!JD) {
                                aVar.bu(true);
                                if (eq(str)) {
                                    this.aKi.remove(str);
                                    c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                } else {
                                    c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                    eo(str);
                                }
                            }
                            atomicBoolean.set(false);
                            c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        } catch (Exception e) {
                            c.e("IdcManager", "handleHostRollback failed by " + e.getMessage());
                            atomicBoolean.set(false);
                            c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        }
                    }
                } catch (Throwable th) {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                    throw th;
                }
            }
        }
    }

    public final String es(String str) {
        return Z(str, "cdn");
    }

    public final void h(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void init(final Context context) {
        this.mContext = context.getApplicationContext();
        this.aKl = true;
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.aKe.putAll(b.bK(context));
                a.this.JA();
                if (!a.this.aKf.isEmpty()) {
                    Iterator<String> it = a.this.aKf.JG().iterator();
                    while (it.hasNext()) {
                        a.this.eq(it.next());
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    private a() {
        this.aKe = new ConcurrentHashMap(8);
        this.aKf = new com.kwad.sdk.core.network.idc.a.b();
        this.aKg = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.aKh = hashMap;
        this.aKi = new ConcurrentHashMap(4);
        this.aKk = 0;
        this.aKl = false;
        hashMap.put("api", new AtomicBoolean(false));
        hashMap.put("ulog", new AtomicBoolean(false));
        hashMap.put("zt", new AtomicBoolean(false));
        hashMap.put("cdn", new AtomicBoolean(false));
    }

    private static boolean c(final String str, Context context) {
        boolean isNetworkConnected = ao.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy Cm = g.Cm();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return com.kwad.sdk.h.cq("https://" + str);
                }
            };
            com.kwad.sdk.core.network.c doGet = Cm.doGet(dVar.getUrl(), Collections.EMPTY_MAP);
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (doGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + doGet.aIU + ",body = " + doGet.aIW);
                if (doGet.aIU == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aKl = false;
        return false;
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i) {
        this.aKk = i * 1000;
        com.kwad.components.ad.reward.A2egSU.A4TApA(i, "updateIdcData,rollback interval = ", "IdcManager");
        if (i == 0) {
            this.aKi.clear();
        }
        this.aKf.a(bVar);
        h.execute(new bg() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(a.this.mContext, a.this.aKf);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, "ulog", new DomainException(i, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            W(str, str2);
        }
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }
}
