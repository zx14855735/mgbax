package com.bytedance.sdk.openadsdk.core.hf.xj.hf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.hf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static volatile boolean f;
    private ne c;
    private final ws hf;
    private String kd;
    private int u;
    private final Context w;
    private Toast xj;
    private boolean y;

    public class hf implements dk.w<JSONObject> {
        private final ne hf;
        private final Toast u;
        private final xj xj;

        public hf(xj xjVar, ne neVar, Toast toast) {
            this.xj = xjVar;
            this.hf = neVar;
            this.u = toast;
        }

        @Override // com.bytedance.sdk.openadsdk.core.dk.w
        public void xj(int i, String str) {
            pl.hf("WechatClickHandler", "getWechatLink failed:" + i + ", " + str);
            this.hf.hf(0);
            Toast toast = this.u;
            if (toast != null) {
                toast.cancel();
            }
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.hf();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sdk.openadsdk.core.dk.w
        public void xj(JSONObject jSONObject) {
            String optString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(optString)) {
                kd.this.xj(optString, this.hf, this.xj);
            } else {
                xj(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " scheme is null!");
            }
        }
    }

    public interface xj {
        void hf();

        void xj();
    }

    public kd(ws wsVar, Context context) {
        this.hf = wsVar;
        this.w = context;
    }

    public kd hf(boolean z) {
        this.y = z;
        return this;
    }

    private int hf(xj xjVar) {
        ne kt;
        ws wsVar = this.hf;
        if (wsVar == null || (kt = wsVar.kt()) == null) {
            return 0;
        }
        if (kt.y() != 1 || !u.w().xj()) {
            return 1;
        }
        if (TextUtils.isEmpty(kt.c())) {
            return 0;
        }
        xj(xjVar, kt);
        return 2;
    }

    public static boolean xj() {
        return f;
    }

    public static void xj(boolean z) {
        f = z;
    }

    public kd xj(String str) {
        this.kd = str;
        return this;
    }

    public kd xj(int i) {
        this.u = i;
        return this;
    }

    public boolean xj(xj xjVar) {
        int hf2;
        if (this.c == null) {
            ws wsVar = this.hf;
            this.c = wsVar != null ? wsVar.kt() : null;
        }
        ne neVar = this.c;
        if (neVar == null) {
            return false;
        }
        int hf3 = neVar.hf();
        if (hf3 != 1) {
            if (hf3 != 2 || (hf2 = hf(xjVar)) == 0) {
                return false;
            }
            if (hf2 == 2) {
                return true;
            }
            if (TextUtils.isEmpty(this.c.xj())) {
                return false;
            }
            xj(xjVar, this.c, 2000L);
            return true;
        }
        if (this.y && (TextUtils.isEmpty(this.c.f()) || hf(xjVar) == 2)) {
            return true;
        }
        return false;
    }

    private void hf() {
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (kd.this.xj != null) {
                        kd.this.xj.cancel();
                    }
                    kd kdVar = kd.this;
                    kdVar.xj = x.xj(kdVar.w, "即将跳转微信...", 1, 17, 0, 0);
                    kd.this.xj.show();
                } catch (Throwable th) {
                    pl.w("toast error:" + th.getMessage());
                }
            }
        });
    }

    private void xj(final xj xjVar, ne neVar) {
        hf();
        pz.xj().xj(neVar, this.hf.ol(), this.hf.jf(), new hf(xjVar, neVar, this.xj) { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.hf, com.bytedance.sdk.openadsdk.core.dk.w
            public void xj(JSONObject jSONObject) {
                String optString = jSONObject.optString("userName");
                String optString2 = jSONObject.optString("path");
                if (TextUtils.isEmpty(optString)) {
                    xj(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
                    return;
                }
                if (kd.this.xj != null) {
                    kd.this.xj.cancel();
                }
                u.w().xj(kd.this.hf, optString, optString2, xjVar, kd.this.kd, kd.this.y);
            }
        }, 1, 2000L);
    }

    private void xj(xj xjVar, ne neVar, long j) {
        hf();
        pz.xj().xj(neVar, this.hf.ol(), this.hf.jf(), new hf(xjVar, neVar, this.xj), 2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, final ne neVar, final xj xjVar) {
        Toast toast = this.xj;
        if (toast != null) {
            toast.cancel();
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        final String xj2 = ht.hf(this.hf) ? this.kd : wo.xj(this.u);
        com.bytedance.sdk.component.utils.hf.xj(this.w, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.3
            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj() {
                neVar.hf(1);
                com.bytedance.sdk.openadsdk.core.am.u.xj(kd.this.hf, xj2, "deeplink_success_realtime", (Throwable) null);
                HashMap hashMap = new HashMap();
                hashMap.put(n.l, "WechatClickProcesser");
                com.bytedance.sdk.openadsdk.core.am.u.f(kd.this.hf, xj2, "open_url_app", hashMap);
                com.bytedance.sdk.openadsdk.core.am.c.xj().xj(kd.this.hf, xj2, false);
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj();
                }
            }

            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj(Throwable th) {
                neVar.hf(0);
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.hf();
                }
            }
        }, TextUtils.equals("main", "internal"));
    }
}
