package com.sigmob.sdk.manager;

import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.FrequencyControl;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13444a = "WindAdFCManager";
    private static volatile e b = null;
    private static final int c = -1;
    private final Map<String, Integer> d = new ConcurrentHashMap();
    private final Map<String, List<SoftReference<b>>> e = new ConcurrentHashMap();

    private e() {
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                try {
                    if (b == null) {
                        b = new e();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public String a(String str, String str2, Integer num) {
        return str + "-" + str2 + "-" + num;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(com.sigmob.sdk.manager.b r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r9 != 0) goto L5
            monitor-exit(r8)
            return
        L5:
            com.sigmob.sdk.base.o r0 = com.sigmob.sdk.base.o.a()     // Catch: java.lang.Throwable -> L81
            boolean r0 = r0.l()     // Catch: java.lang.Throwable -> L81
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L81
            boolean r0 = com.sigmob.sdk.base.utils.q.b(r0)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L19
            monitor-exit(r8)
            return
        L19:
            com.sigmob.sdk.base.models.BaseAdUnit r0 = r9.e()     // Catch: java.lang.Throwable -> L81
            boolean r1 = com.sigmob.sdk.manager.b.m(r0)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto Le9
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L81
            boolean r1 = com.sigmob.sdk.base.utils.q.b(r1)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L2f
            goto Le9
        L2f:
            java.util.List r1 = r0.getFrequencyControl()     // Catch: java.lang.Throwable -> L81
            boolean r2 = com.sigmob.sdk.base.utils.e.a(r1)     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L3b
            monitor-exit(r8)
            return
        L3b:
            int r0 = r0.getAd_type()     // Catch: java.lang.Throwable -> L81
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L81
        L43:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto Le7
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L81
            com.sigmob.sdk.base.models.rtb.FrequencyControl r2 = (com.sigmob.sdk.base.models.rtb.FrequencyControl) r2     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r2.strategy_id     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r2.frequency_control_event     // Catch: java.lang.Throwable -> L81
            java.lang.Integer r5 = r2.frequency_control_count     // Catch: java.lang.Throwable -> L81
            java.util.List<java.lang.Integer> r2 = r2.ad_expire_type     // Catch: java.lang.Throwable -> L81
            boolean r6 = com.sigmob.sdk.base.utils.o.b(r3)     // Catch: java.lang.Throwable -> L81
            if (r6 == 0) goto L43
            boolean r6 = com.sigmob.sdk.base.utils.o.b(r4)     // Catch: java.lang.Throwable -> L81
            if (r6 == 0) goto L43
            boolean r6 = com.sigmob.sdk.base.utils.q.a(r5)     // Catch: java.lang.Throwable -> L81
            if (r6 == 0) goto L43
            boolean r2 = com.sigmob.sdk.base.utils.e.b(r2)     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L43
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r8.d     // Catch: java.lang.Throwable -> L81
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L83
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L81
            r6 = -1
            if (r2 != r6) goto L88
            goto L83
        L81:
            r9 = move-exception
            goto Leb
        L83:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r8.d     // Catch: java.lang.Throwable -> L81
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L81
        L88:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = r8.a(r3, r4, r2)     // Catch: java.lang.Throwable -> L81
            java.util.Map<java.lang.String, java.util.List<java.lang.ref.SoftReference<com.sigmob.sdk.manager.b>>> r3 = r8.e     // Catch: java.lang.Throwable -> L81
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L81
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L81
            r4 = 0
            if (r3 != 0) goto Lb7
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.lang.Throwable -> L81
            java.util.Map<java.lang.String, java.util.List<java.lang.ref.SoftReference<com.sigmob.sdk.manager.b>>> r5 = r8.e     // Catch: java.lang.Throwable -> L81
            r5.put(r2, r3)     // Catch: java.lang.Throwable -> L81
            java.lang.ref.SoftReference r2 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> L81
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L81
            r3.add(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "WindAdFCManager"
            java.lang.String r3 = "addAdManager: add"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L81
            com.czhj.sdk.logger.SigmobLogger.d(r2, r3, r4)     // Catch: java.lang.Throwable -> L81
            goto L43
        Lb7:
            boolean r2 = r8.a(r3, r9)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "WindAdFCManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r6.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r7 = "addAdManager: contains = "
            r6.append(r7)     // Catch: java.lang.Throwable -> L81
            r6.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L81
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L81
            com.czhj.sdk.logger.SigmobLogger.d(r5, r6, r4)     // Catch: java.lang.Throwable -> L81
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L81
            boolean r2 = com.sigmob.sdk.base.utils.q.b(r2)     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L43
            java.lang.ref.SoftReference r2 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> L81
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L81
            r3.add(r2)     // Catch: java.lang.Throwable -> L81
            goto L43
        Le7:
            monitor-exit(r8)
            return
        Le9:
            monitor-exit(r8)
            return
        Leb:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L81
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.manager.e.a(com.sigmob.sdk.manager.b):void");
    }

    private void a(b bVar, String str) {
        bVar.a(AdStatus.AdStatusNone);
        d.a().c(bVar);
        String h = bVar.h();
        BaseAdUnit e = bVar.e();
        if (e == null) {
            SigmobLogger.e(f13444a, "setInvalidManager: adUnit is unavailable.", new Object[0]);
            return;
        }
        String requestId = e.getRequestId();
        int requestSceneType = e.getRequestSceneType();
        String simpleName = bVar.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder("setInvalidManager: requestId = ");
        sb.append(requestId);
        sb.append(", requestSceneType = ");
        sb.append(requestSceneType);
        sb.append(", placementId = ");
        SigmobLogger.i(f13444a, J3FDQU.A2egSU.B3GDIM(sb, h, ", simpleName = ", simpleName), new Object[0]);
        ae.a(PointCategory.SUBJECT_EXPIRE, (String) null, e, new GnQT2j.A4TApA(e, str, requestId));
    }

    public synchronized void a(String str, BaseAdUnit baseAdUnit, b bVar) {
        SigmobLogger.d(f13444a, "checkFrequencyControl: event = " + str, new Object[0]);
        if (!o.a((CharSequence) str) && baseAdUnit != null) {
            List<FrequencyControl> frequencyControl = baseAdUnit.getFrequencyControl();
            if (com.sigmob.sdk.base.utils.e.a(frequencyControl)) {
                SigmobLogger.e(f13444a, "checkFrequencyControl: frequency is unavailable.", new Object[0]);
                return;
            }
            for (FrequencyControl frequencyControl2 : frequencyControl) {
                String str2 = frequencyControl2.strategy_id;
                String str3 = frequencyControl2.frequency_control_event;
                Integer num = frequencyControl2.frequency_control_count;
                List<Integer> list = frequencyControl2.ad_expire_type;
                Integer num2 = this.d.get(str2);
                boolean z = q.b(num2) && o.a((CharSequence) str, (CharSequence) str3) && q.a((Number) num) && com.sigmob.sdk.base.utils.e.b(list);
                SigmobLogger.d(f13444a, "checkFrequencyControl: num = " + num2 + ", canCheck = " + z + ", strategyId = " + str2 + ", strategyEvent = " + str3 + ", strategyCount = " + num, new Object[0]);
                if (z) {
                    if (num2.intValue() > 0) {
                        num2 = Integer.valueOf(num2.intValue() - 1);
                        this.d.put(str2, num2);
                    }
                    if (num2.intValue() <= 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Integer> it = list.iterator();
                        while (it.hasNext()) {
                            String a2 = a(str2, str3, it.next());
                            List<SoftReference<b>> list2 = this.e.get(a2);
                            if (com.sigmob.sdk.base.utils.e.b(list2)) {
                                for (SoftReference<b> softReference : list2) {
                                    if (softReference != null && softReference.get() != null) {
                                        arrayList.add(softReference.get());
                                    }
                                }
                            }
                            this.e.remove(a2);
                        }
                        boolean remove = arrayList.remove(bVar);
                        int size = arrayList.size();
                        SigmobLogger.d(f13444a, "checkFrequencyControl: result = " + remove + ", simpleName = " + bVar.getClass().getSimpleName() + ", size = " + size, new Object[0]);
                        Iterator it2 = arrayList.iterator();
                        int i = 0;
                        while (it2.hasNext()) {
                            b bVar2 = (b) it2.next();
                            BaseAdUnit e = bVar2.e();
                            if (e == null) {
                                SigmobLogger.e(f13444a, "checkFrequencyControl: baseAdUnit is unavailable.", new Object[0]);
                            } else if (b.b(Integer.valueOf(e.getRequestSceneType()))) {
                                SigmobLogger.e(f13444a, "checkFrequencyControl: unavailable requestSceneType.", new Object[0]);
                            } else {
                                a(bVar2, str2);
                                i++;
                            }
                        }
                        SigmobLogger.d(f13444a, "checkFrequencyControl: strategyId = " + str2 + ", expiredAdNum = " + i, new Object[0]);
                        if (i > 0) {
                            this.d.put(str2, -1);
                        }
                    }
                }
            }
            return;
        }
        SigmobLogger.e(f13444a, "checkFrequencyControl: event or adUnit is unavailable.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, BaseAdUnit baseAdUnit, String str2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put(PointParamKey.STRATEGY_ID, str);
            options.put(PointParamKey.EXPIRE_RELOAD_COUNT, String.valueOf(baseAdUnit.expiredAdReloadNum()));
            String vid = baseAdUnit.getVid();
            String originVid = baseAdUnit.getOriginVid();
            if (o.b(originVid)) {
                vid = originVid;
            }
            options.put(PointParamKey.ORIGIN_VID, vid);
            String adxEncPrice = baseAdUnit.getAdxEncPrice();
            if (o.b(adxEncPrice)) {
                options.put(PointParamKey.ORIGIN_PRICE, adxEncPrice);
            }
            options.put(PointParamKey.REQUEST_ID, str2);
            pointEntitySigmob.setOptions(options);
        }
    }

    private boolean a(List<SoftReference<b>> list, b bVar) {
        if (!com.sigmob.sdk.base.utils.e.a(list) && bVar != null) {
            for (SoftReference<b> softReference : list) {
                if (softReference != null && softReference.get() != null && softReference.get().equals(bVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
