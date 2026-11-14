package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService aKT;
    private static volatile Handler iK;
    private T aKW;
    private Context mContext;
    private volatile long acx = 120000;
    protected l aKS = new m();
    private AtomicInteger aKU = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int aKV = 5;

    public b() {
        if (aKT == null) {
            aKT = GlobalThreadPools.Lj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.aKV) {
            if (andIncrement > 0) {
                this.acx *= 2;
            }
            aF(this.acx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aF(long j) {
        if (iK == null) {
            return;
        }
        iK.removeMessages(R.attr.childDivider);
        Message obtain = Message.obtain(iK, a(this.mContext, this.aKS, this.aKU));
        obtain.what = R.attr.childDivider;
        iK.sendMessageDelayed(obtain, j);
    }

    public abstract R A(List<T> list);

    public final boolean Kb() {
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.aKS.size() >= (sVar != null ? (long) (sVar.CQ() << i) : 20L);
    }

    public final void Kc() {
        aF(0L);
    }

    public final void aE(long j) {
        if (j < 60) {
            this.acx = 60000L;
        } else {
            this.acx = j * 1000;
        }
    }

    public synchronized void j(Context context, int i) {
        this.mContext = context;
        if (iK == null) {
            iK = com.kwad.sdk.core.threads.a.La();
        }
    }

    private void c(final k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            private static BatchReportResult eJ(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                e Kg = kVar.Kg();
                b.this.aKW = Kg;
                return (R) b.this.a((b) Kg);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aKT;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return eJ(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aKW + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i + " errorMsg:" + str + "\naction=" + b.this.aKW);
                b.this.a((k) new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.k
                    public final T Kg() {
                        return (T) b.this.aKW;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    public final void a(l lVar) {
        this.aKS = lVar;
    }

    public final void a(final k<T> kVar) {
        aKT.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.iK != null && !b.iK.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.aF(bVar.acx);
                }
                e Kg = kVar.Kg();
                if (Kg != null) {
                    b.this.aKS.m(Kg);
                }
                if (b.this.Kb()) {
                    b.this.Kc();
                }
            }
        });
    }

    public Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean, final u.a aVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.aKU.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            private static BatchReportResult eJ(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                return (R) b.this.A(list);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.aKT;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return eJ(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(BatchReportResult batchReportResult) {
                b.this.aKS.B(list);
                u.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.Kz();
                }
                if (b.this.aKU.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.Kd();
                }
                b.this.aE(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.aF(bVar.acx);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.aKU.decrementAndGet() == 0) {
                    b.this.Kd();
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return A(arrayList);
    }
}
