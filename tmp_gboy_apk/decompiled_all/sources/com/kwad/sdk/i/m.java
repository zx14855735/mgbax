package com.kwad.sdk.i;

import com.kwad.sdk.i.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class m {
    private static final Map<String, k> aYd = new ConcurrentHashMap();
    private static long aYe;

    static {
        gMHrFR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void B(List<k> list) {
        synchronized (m.class) {
            if (list != null) {
                Iterator<k> it = list.iterator();
                while (it.hasNext()) {
                    aYd.remove(it.next().actionId);
                }
            }
        }
    }

    public static void Pf() {
        long currentTimeMillis = System.currentTimeMillis() - aYe;
        if (aYd.size() <= 0 || currentTimeMillis <= h.OS().OY()) {
            return;
        }
        aYe = System.currentTimeMillis();
        final List<k> actionList = getActionList();
        actionList.size();
        j.Pd();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.i.l.a
            public final void onSuccess() {
                j.Pd();
                m.B(actionList);
            }
        });
    }

    public static synchronized void a(i iVar, boolean z) {
        synchronized (m.class) {
            try {
                Map<String, k> map = aYd;
                if (map.size() > 200) {
                    j.al("LogRequestManger", "enqueueAction fail size limit");
                } else {
                    k b = b(iVar, z);
                    map.put(b.actionId, b);
                }
                Pf();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static k b(i iVar, boolean z) {
        com.kwai.adclient.kscommerciallogger.model.c Vh = (z ? c.a.Vf() : c.a.Vg()).c(BusinessType.OTHER).b(SubBusinessType.OTHER).m19if("ad_sdk_local_log").ie(iVar.aXW).B(iVar.toJson()).Vh();
        return new k(Vh.UZ(), Vh.toString(), iVar);
    }

    private static /* synthetic */ void gMHrFR() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        synchronized (m.class) {
            Map<String, k> map = aYd;
            arrayList = new ArrayList(map.size());
            Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        return arrayList;
    }
}
