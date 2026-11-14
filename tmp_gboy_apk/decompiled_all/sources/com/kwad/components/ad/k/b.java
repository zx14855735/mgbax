package com.kwad.components.ad.k;

import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b extends a<l> {
    public com.kwad.components.core.video.b Mp;
    private boolean Mq;
    private l Mr;
    protected DetailVideoView mDetailVideoView;

    public b(AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.Mq = false;
        this.Mr = new m() { // from class: com.kwad.components.ad.k.b.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                try {
                    super.onMediaPlayError(i, i2);
                    if (!b.this.Mq) {
                        b.this.nU();
                    } else if (e.HK()) {
                        b.this.nU();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                b.this.mAdTemplate.setmCurPlayTime(j2);
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.Mp = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        nS();
    }

    private void nS() {
        this.Mp.c(this.Mr);
    }

    private void nT() {
        l lVar;
        com.kwad.components.core.video.b bVar = this.Mp;
        if (bVar == null || (lVar = this.Mr) == null) {
            return;
        }
        bVar.d(lVar);
        this.Mr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU() {
        com.kwad.components.core.o.a.tz().f(this.mAdTemplate, 21008);
        this.Mq = true;
    }

    @Override // com.kwad.components.ad.k.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.Mp;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public void pause() {
        this.Mp.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public void release() {
        super.release();
        this.Mq = false;
        nT();
        com.kwad.components.core.video.b bVar = this.Mp;
        if (bVar != null) {
            bVar.clear();
            this.Mp.release();
        }
    }

    @Override // com.kwad.components.ad.k.a
    public void resume() {
        this.Mp.resume();
    }

    @Override // com.kwad.components.ad.k.a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void b(l lVar) {
        com.kwad.components.core.video.b bVar;
        if (lVar == null || (bVar = this.Mp) == null) {
            return;
        }
        bVar.c(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.Mp.d(lVar);
    }
}
