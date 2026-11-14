package com.kwad.sdk.ip.direct;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.kwad.components.ad.reward.A2egSU;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static c aWA = null;
    private static HandlerThread aWB = null;
    private static Handler aWC = null;
    private static int aWr = -1;
    private static volatile boolean aWs;
    private static List<HttpDnsInfo.IpInfo> aWt = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aWu = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aWv = new CopyOnWriteArrayList();
    private static List<c> aWw = new CopyOnWriteArrayList();
    private static List<c> aWx = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> aWy = new PriorityBlockingQueue<>();
    private static AtomicInteger aWz = new AtomicInteger(0);
    private static volatile boolean aWD = false;
    private static float aWE = -1.0f;
    private static float aWF = -1.0f;
    private static float aWG = -1.0f;
    private static int aWH = 0;
    private static volatile boolean aWI = false;
    private static volatile boolean aWJ = false;
    private static NetworkMonitor.a aWK = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.aWJ) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    };
    private static Runnable aWL = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.Oq();
        }
    };

    static {
        iBfy();
    }

    private static void J(List<HttpDnsInfo.IpInfo> list) {
        b(list, aWw);
        if (aWw.isEmpty()) {
            return;
        }
        Iterator<c> it = aWw.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += it.next().OG();
        }
        aWE = f / aWw.size();
    }

    private static void K(List<HttpDnsInfo.IpInfo> list) {
        b(list, aWx);
        if (aWx.isEmpty()) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        for (c cVar : aWx) {
            if (cVar != null) {
                int weight = cVar.getWeight() + i;
                f = (cVar.OG() * cVar.getWeight()) + f;
                i = weight;
            }
        }
        if (i != 0) {
            aWF = f / i;
        }
    }

    private static void OA() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = aWA;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aWt.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                ipInfo2 = null;
                break;
            }
            ipInfo2 = it.next();
            if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
                break;
            }
        }
        if (ipInfo2 != null) {
            aWt.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aWu.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next = it2.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                ipInfo2 = next;
                break;
            }
        }
        if (ipInfo2 != null) {
            aWu.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aWv.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it3.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            aWv.remove(ipInfo);
        }
    }

    private static void OB() {
        c cVar;
        if (aWA == null) {
            return;
        }
        List<c> list = aWw;
        if (list != null && !list.isEmpty() && aWw.contains(aWA)) {
            aWw.remove(aWA);
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aWA);
        }
        List<c> list2 = aWx;
        if (list2 != null && !list2.isEmpty()) {
            if (aWx.contains(aWA)) {
                aWx.remove(aWA);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aWA);
            }
            Iterator<c> it = aWx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (cVar != null && TextUtils.equals(cVar.getIp(), aWA.getIp())) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                    break;
                }
            }
            if (cVar != null) {
                aWx.remove(cVar);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = aWy.peek();
        if (peek != null && peek == aWA) {
            aWy.poll();
        }
        aWA = null;
    }

    private static void Ol() {
        Handler handler;
        if (aWD || (handler = aWC) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String Om() {
        c cVar = aWA;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float On() {
        return aWE;
    }

    public static float Oo() {
        return aWF;
    }

    public static float Op() {
        return aWG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Oq() {
        Ov();
        List<HttpDnsInfo.IpInfo> list = aWt;
        List<HttpDnsInfo.IpInfo> list2 = aWu;
        clear();
        if (aWD) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "start pick");
        aWD = true;
        J(list);
        K(list2);
        if (aWw.isEmpty() && aWx.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aWD = false;
                return;
            } else {
                if (!hVar.Dq()) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    aWD = false;
                    return;
                }
                Ot();
            }
        }
        aWD = false;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Or() {
        if (Os()) {
            return;
        }
        Ou();
    }

    private static boolean Os() {
        List<c> list = aWw;
        List<c> list2 = aWx;
        if (!list.isEmpty()) {
            aWA = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from recommend:" + aWA);
            aWH = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i2 = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                i2 += cVar.getWeight();
            }
        }
        if (i2 <= 0) {
            return false;
        }
        int nextInt = random.nextInt(i2);
        int i3 = 0;
        while (true) {
            if (i3 >= list2.size()) {
                break;
            }
            if (list2.get(i3) != null) {
                nextInt -= list2.get(i3).getWeight();
            }
            if (nextInt < 0) {
                i = i3;
                break;
            }
            i3++;
        }
        aWA = list2.get(i);
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from backUp:" + aWA);
        aWH = 2;
        return true;
    }

    private static void Ot() {
        List<HttpDnsInfo.IpInfo> list = aWv;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c f = b.f(ipInfo.ip, aWr);
                if (f.isSuccess()) {
                    aWy.offer(f);
                }
            }
        }
        c peek = aWy.peek();
        if (peek != null) {
            aWG = peek.OG();
        }
    }

    private static void Ou() {
        if (aWy.isEmpty()) {
            return;
        }
        c peek = aWy.peek();
        if (peek.OG() < aWr) {
            aWA = peek;
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from Other:" + aWA);
            aWH = 3;
        }
    }

    private static void Ov() {
        if (aWr == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aWr = hVar.Dr();
            } else {
                aWr = 200;
            }
        }
    }

    private static boolean Ow() {
        if (aWI) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aWz.get();
        A2egSU.A4TApA(i, "value:", "IpDirect_Helper");
        return i <= 3;
    }

    private static void Ox() {
        aWz.getAndIncrement();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "addFailedTimes:" + aWz.intValue());
    }

    public static void Oy() {
        c cVar;
        Handler handler;
        if (!aWs || (cVar = aWA) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = aWC) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void Oz() {
        Ox();
        OA();
        OB();
        aWH = 0;
        Or();
        Oq();
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean Dp = hVar.Dp();
        aWs = Dp;
        com.bykv.vk.component.ttvideo.player.A2egSU.B9tovu("isEnable:", "IpDirect_Helper", Dp);
        if (Dp) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            aWt = list;
            aWu = httpDnsInfo.backUpList;
            aWv = httpDnsInfo.otherList;
            if (list.isEmpty() && aWu.isEmpty() && aWv.isEmpty()) {
                com.kwad.sdk.core.d.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                Ol();
            }
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        aWJ = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        aWI = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", ipInfo.toString());
                c f = b.f(ipInfo.ip, aWr);
                f.er(ipInfo.weight);
                if (f.isSuccess() && f.OG() < aWr) {
                    list2.add(f);
                }
            }
        }
    }

    private static void clear() {
        aWw.clear();
        aWx.clear();
        aWy.clear();
    }

    public static int getType() {
        return aWH;
    }

    public static String go(String str) {
        if (!aWs) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (gp(str)) {
            com.bykv.vk.component.ttvideo.player.A2egSU.B7CMnp("isHostInvalid:false ：", str, "IpDirect_Helper");
            return "";
        }
        if (!Ow()) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String Om = Om();
        com.bykv.vk.component.ttvideo.player.A2egSU.B7CMnp("getIpByHost ip:", Om, "IpDirect_Helper");
        return Om;
    }

    private static boolean gp(String str) {
        boolean equals = TextUtils.equals(CtFAbx.BChYOn("https://", str), com.kwad.sdk.h.Co());
        boolean z = !equals;
        if (!equals) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.h.Co() + "try direct host:https://" + str);
        }
        return z;
    }

    private static /* synthetic */ void iBfy() {
        char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 229);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 229);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void init() {
        if (aWB != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aWB = handlerThread;
        handlerThread.start();
        aWC = new Handler(aWB.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    a.Oq();
                    a.Or();
                } else {
                    if (i != 2) {
                        return;
                    }
                    a.Oz();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aWK);
        }
    }
}
