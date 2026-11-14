package com.kwad.sdk.i;

import android.text.TextUtils;
import com.kwad.sdk.i.e;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class h {
    private static final AtomicBoolean aXM = new AtomicBoolean(false);
    private static final AtomicInteger aXN = new AtomicInteger(0);
    private static final float azH = new Random().nextFloat();
    private final AtomicBoolean aXL;
    private d aXO;
    private g aXP;
    private ConcurrentLinkedQueue<i> aXQ;
    private f aXR;
    private final AtomicBoolean mHasInit;

    public static final class a {
        private static final h aXU = new h(0);

        static {
            OCxfad();
        }

        private static /* synthetic */ void OCxfad() {
            char[] charArray = "ieg$mkgo$hes$yboff$@dcHxcnmo".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '\n');
            }
            String str = new String(charArray);
            char[] charArray2 = "ifcdc~".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '\n');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        aAnAYY();
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h OS() {
        return a.aXU;
    }

    private void OZ() {
        ConcurrentLinkedQueue<i> concurrentLinkedQueue = this.aXQ;
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator<i> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.aXQ.clear();
        this.aXQ = null;
    }

    private static /* synthetic */ void aAnAYY() {
        char[] charArray = "¸´¶õ¼º¶¾õ¹´¢õ¨³¾··õ\u0091µ²\u0099©²¿¼¾".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 219);
        }
        String str = new String(charArray);
        char[] charArray2 = "¸·²µ²¯".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 219);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void b(final i iVar) {
        d dVar = this.aXO;
        if (dVar == null || j.L(dVar.aXy) || this.aXP == null || this.aXR == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.i.n
            public final void doTask() {
                h hVar = h.this;
                e a2 = hVar.a(hVar.aXO, iVar);
                if (a2 == null) {
                    return;
                }
                iVar.n(a2.aAi);
                m.a(iVar, a2.aXz == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aSZ;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aXP.getSdkVersion(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(e.b bVar) {
        String androidId = this.aXP.getAndroidId();
        String deviceId = this.aXP.getDeviceId();
        String imei = this.aXP.getImei();
        String oaid = this.aXP.getOaid();
        List<String> list = bVar.aXH;
        if (j.L(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    private static d gy(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.Pc();
            return null;
        }
    }

    public final void OT() {
        if (!this.mHasInit.get() || this.aXO == null) {
            return;
        }
        j.Pd();
        m.Pf();
    }

    public final synchronized void OU() {
        this.aXL.set(true);
    }

    public final synchronized void OV() {
        this.aXL.set(false);
    }

    public final g OW() {
        return this.aXP;
    }

    public final f OX() {
        return this.aXR;
    }

    public final long OY() {
        return this.aXO.OL();
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aXL.get()) {
                    j.Pd();
                    return;
                }
                i gB = i.Pb().gz(str).gA(str2).gB(str3);
                if (this.mHasInit.get()) {
                    b(gB);
                } else {
                    if (aXM.get()) {
                        return;
                    }
                    j.Pd();
                    a(gB);
                }
            }
        } catch (Throwable unused) {
            j.Pc();
        }
    }

    private h() {
        this.mHasInit = new AtomicBoolean(false);
        this.aXL = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aSY;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aXP.getAppId(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            j.Pd();
            this.aXP = gVar;
            this.aXR = fVar;
            this.aXO = gy(str);
            this.mHasInit.set(true);
            OZ();
        } catch (Throwable unused) {
            aXM.set(true);
            j.Pc();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aXE;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.aXD;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.aXQ == null) {
            this.aXQ = new ConcurrentLinkedQueue<>();
        }
        AtomicInteger atomicInteger = aXN;
        if (atomicInteger.get() >= 500) {
            return;
        }
        atomicInteger.incrementAndGet();
        this.aXQ.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.aXy;
        if (j.L(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aXA) && a(eVar.aXB, iVar)) {
                double d = eVar.aAi;
                if (d > 0.0d && azH <= d) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aXI != e.b.aXF) {
            return bVar.OM();
        }
        bVar.bO(b(bVar) && c(bVar) && d(bVar));
        return bVar.OM();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aXV) && b(aVar, iVar.aXW) && c(aVar, iVar.aXX);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aXC;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }
}
