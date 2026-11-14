package com.bytedance.sdk.component.f.hf;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.c;
import com.bytedance.sdk.component.f.xj.d;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import com.bytedance.sdk.component.f.xj.y;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.pl;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements c {
    private static volatile com.bytedance.sdk.component.f.xj.xj.xj u;
    private Context hf;
    private d w;
    private kd xj;

    public hf(com.bytedance.sdk.component.f.xj.xj xjVar) {
        xj(xjVar);
    }

    private boolean c() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static com.bytedance.sdk.component.f.xj.xj.xj y() {
        if (u == null) {
            synchronized (hf.class) {
                try {
                    if (u == null) {
                        u = new com.bytedance.sdk.component.f.hf.kd.xj();
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public void hf(kd kdVar) {
        this.xj = kdVar;
        this.hf = kdVar.getContext();
        this.w = new com.bytedance.sdk.component.f.hf.hf.hf(this.xj);
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public u kd() {
        kd kdVar = this.xj;
        if (kdVar == null) {
            return null;
        }
        return kdVar.u();
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public d u() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public kd w() {
        kd kdVar = this.xj;
        if (kdVar == null) {
            return null;
        }
        return kdVar;
    }

    public hf() {
    }

    private void hf(final com.bytedance.sdk.component.f.xj.hf hfVar) {
        kd kdVar = this.xj;
        if (kdVar != null && this.w != null) {
            final u u2 = kdVar.u();
            if (hfVar == null || u2 == null || this.xj.getContext() == null || u2.f() == null) {
                return;
            }
            if (this.xj.p()) {
                if (xj(this.xj.getContext(), u2)) {
                    this.w.xj(hfVar);
                    return;
                }
                c();
                if (c()) {
                    u2.f().execute(new com.bytedance.sdk.component.f.hf.kd.hf("dispatchEvent") { // from class: com.bytedance.sdk.component.f.hf.hf.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hf.this.xj(hfVar, u2.tf());
                        }
                    });
                    return;
                } else {
                    xj(hfVar, u2.tf());
                    return;
                }
            }
            this.w.xj(hfVar);
            return;
        }
        pl.u("log_error", "dispatch event configManager is null");
    }

    public void xj(kd kdVar) {
        hf(kdVar);
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void xj(y yVar) {
        kd kdVar = this.xj;
        if (kdVar != null) {
            if (yVar == null) {
                yVar = com.bytedance.sdk.component.f.hf.xj.xj.xj.hf.xj;
            }
            kdVar.xj(yVar);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void xj(boolean z) {
        kd kdVar = this.xj;
        if (kdVar != null) {
            kdVar.xj(z);
        }
    }

    private boolean xj(Context context, u uVar) {
        if (context == null || uVar == null) {
            return false;
        }
        if (uVar.tf() == 1) {
            return uVar.g();
        }
        try {
            return e.xj(context);
        } catch (Throwable th) {
            pl.xj(th);
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void xj() {
        final u u2;
        kd kdVar = this.xj;
        if (kdVar == null || (u2 = kdVar.u()) == null || this.xj.getContext() == null || u2.f() == null) {
            return;
        }
        if (this.xj.p()) {
            if (xj(this.xj.getContext(), u2)) {
                d dVar = this.w;
                if (dVar != null) {
                    dVar.xj();
                    return;
                }
                return;
            }
            if (c()) {
                u2.f().execute(new com.bytedance.sdk.component.f.hf.kd.hf("start") { // from class: com.bytedance.sdk.component.f.hf.hf.1
                    @Override // java.lang.Runnable
                    public void run() {
                        kd unused = hf.this.xj;
                        hf.this.xj(u2.tf());
                    }
                });
                return;
            } else {
                xj(u2.tf());
                return;
            }
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.xj();
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void hf() {
        d dVar = this.w;
        if (dVar != null) {
            dVar.hf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.f.hf.hf.hf.xj.xj(this.xj);
        } else if (i == 1) {
            com.bytedance.sdk.component.f.hf.hf.hf.hf.hf(this.xj);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        hf(hfVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.f.xj.hf hfVar, int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.f.hf.hf.hf.xj.xj(hfVar, this.xj);
        } else if (i == 1) {
            com.bytedance.sdk.component.f.hf.hf.hf.hf.xj(hfVar, this.xj);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void xj(final String str, final List<String> list, final boolean z, Map<String, String> map, final JSONObject jSONObject) {
        kd kdVar = this.xj;
        if (kdVar == null) {
            pl.u("log_error", "track configManager is null");
            return;
        }
        final u u2 = kdVar.u();
        if (u2 == null || this.xj.getContext() == null || u2.f() == null || !u2.y()) {
            return;
        }
        if (u2.tf() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (u2.tf() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (this.xj.p() && !xj(this.xj.getContext(), u2)) {
            if (c()) {
                u2.f().execute(new com.bytedance.sdk.component.f.hf.kd.hf("trackFailed") { // from class: com.bytedance.sdk.component.f.hf.hf.3
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj(str, (List<String>) list, z, u2.tf(), jSONObject);
                    }
                });
                return;
            } else {
                xj(str, list, z, u2.tf(), jSONObject);
                return;
            }
        }
        com.bytedance.sdk.component.f.hf.y.xj.xj(this.xj).xj(str, list, z, map, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, List<String> list, boolean z, int i, JSONObject jSONObject) {
        if (i == 0) {
            com.bytedance.sdk.component.f.hf.hf.hf.xj.xj(str, list, z, this.xj, jSONObject);
        } else if (i == 1) {
            com.bytedance.sdk.component.f.hf.hf.hf.hf.xj(str, list, z, this.xj);
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.c
    public void xj(final String str) {
        kd kdVar = this.xj;
        if (kdVar == null) {
            com.bytedance.sdk.component.f.hf.w.w.w("log_error", "trackFailedUrls configManager is null", kdVar);
            return;
        }
        final u u2 = kdVar.u();
        if (u2 == null || this.xj.getContext() == null || u2.f() == null || !u2.y()) {
            return;
        }
        if (u2.tf() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (this.xj.p() && !xj(this.xj.getContext(), u2)) {
            if (c()) {
                u2.f().execute(new com.bytedance.sdk.component.f.hf.kd.hf("trackFailed") { // from class: com.bytedance.sdk.component.f.hf.hf.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj(str, u2.tf());
                    }
                });
                return;
            } else {
                xj(str, u2.tf());
                return;
            }
        }
        com.bytedance.sdk.component.f.hf.y.xj.xj(this.xj).xj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.f.hf.hf.hf.xj.xj(str, this.xj);
        } else if (i == 1) {
            com.bytedance.sdk.component.f.hf.hf.hf.hf.xj(str, this.xj);
        }
    }
}
