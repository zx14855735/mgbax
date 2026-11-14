package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class g implements m {
    public abstract void a(y yVar);

    public abstract void bO();

    public abstract void bP();

    public abstract void bQ();

    public abstract void bR();

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                final y yVar = new y();
                if (objArr[0] instanceof String) {
                    yVar.parseJson(new JSONObject((String) objArr[0]));
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.a.g.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (yVar.xa()) {
                                g.this.bR();
                                return;
                            }
                            if (yVar.xc()) {
                                return;
                            }
                            if (yVar.xd()) {
                                g.this.bP();
                                return;
                            }
                            if (yVar.xe()) {
                                g.this.bO();
                            } else if (yVar.xb()) {
                                g.this.bQ();
                            } else if (yVar.isFailed()) {
                                g.this.a(yVar);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
