package com.ss.android.downloadlib.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    public void xj(final com.ss.android.downloadad.api.xj.hf hfVar, final c cVar, int i) {
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.hf.hf.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.xj(hfVar)) {
                    cVar.xj(false);
                } else if (y.xj(hfVar)) {
                    y.xj(hfVar, new f() { // from class: com.ss.android.downloadlib.hf.hf.1.1
                        @Override // com.ss.android.downloadlib.hf.f
                        public void xj(boolean z) {
                            cVar.xj(z);
                        }
                    });
                } else {
                    cVar.xj(false);
                }
            }
        }, i);
    }
}
