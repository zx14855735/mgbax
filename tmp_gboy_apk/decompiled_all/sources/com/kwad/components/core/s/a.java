package com.kwad.components.core.s;

import android.content.Context;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a {
    private static volatile a acr;
    private com.kwad.sdk.utils.i acn;
    private List<WeakReference<OfflineOnAudioConflictListener>> aco = new ArrayList();
    private boolean acp = false;
    private boolean acq = false;

    private a(Context context) {
        init(context);
    }

    public static a aG(Context context) {
        if (acr == null) {
            synchronized (a.class) {
                try {
                    if (acr == null) {
                        acr = new a(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return acr;
    }

    private void init(Context context) {
        this.acp = false;
        com.kwad.sdk.utils.i iVar = new com.kwad.sdk.utils.i(context);
        this.acn = iVar;
        iVar.c(new i.a() { // from class: com.kwad.components.core.s.a.1
            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.aco.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.aco.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final boolean aU(boolean z) {
        com.kwad.sdk.utils.i iVar = this.acn;
        if (iVar == null) {
            return false;
        }
        if (!z && this.acp) {
            return false;
        }
        this.acp = true;
        this.acq = false;
        return iVar.Ru();
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.aco.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean ur() {
        return this.acq;
    }

    public final boolean us() {
        return this.acp;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.acq = true;
        return true;
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.aco.add(new WeakReference<>(offlineOnAudioConflictListener));
    }
}
