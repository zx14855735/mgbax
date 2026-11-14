package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends w<NativeVideoView> {
    private com.bykv.vk.openvk.component.video.api.w.w cu;
    private xj kc;
    private String lm;
    private String my;
    private ws no;
    private boolean qi;
    private String vi;
    private boolean xj;

    public hf(Context context) {
        super(context);
        this.qi = false;
    }

    private void gh() {
        if (!this.xj) {
            this.no = new ws();
            this.cu = new com.bykv.vk.openvk.component.video.api.w.w();
            return;
        }
        if (!TextUtils.isEmpty(this.vi)) {
            try {
                this.no = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(this.vi));
                this.vi = null;
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        ws wsVar = this.no;
        if (wsVar == null) {
            this.no = new ws();
            this.cu = new com.bykv.vk.openvk.component.video.api.w.w();
            return;
        }
        com.bykv.vk.openvk.component.video.api.w.w am = h.am(wsVar);
        this.cu = am;
        if (am == null) {
            this.cu = new com.bykv.vk.openvk.component.video.api.w.w();
        }
    }

    public boolean bl() {
        com.bykv.vk.openvk.component.video.api.xj e;
        T t = this.kd;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null || (e = ((NativeVideoView) this.kd).getNativeVideoController().e()) == null) {
            return false;
        }
        return e.g();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public NativeVideoView xj() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.hf);
        nativeVideoView.xj(this);
        return nativeVideoView;
    }

    public void dq() {
        T t = this.kd;
        if (t != 0) {
            ((NativeVideoView) t).f();
            if (this.xj) {
                ((NativeVideoView) this.kd).xj(true, false);
            } else {
                ((NativeVideoView) this.kd).xj(this.lm);
            }
        }
    }

    public boolean f() {
        T t = this.kd;
        return (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null) ? this.qi : ((NativeVideoView) this.kd).getNativeVideoController().v();
    }

    public boolean lw() {
        com.bykv.vk.openvk.component.video.api.xj e;
        T t = this.kd;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null || (e = ((NativeVideoView) this.kd).getNativeVideoController().e()) == null) {
            return false;
        }
        return e.d();
    }

    public void qd() {
        T t = this.kd;
        if (t != 0) {
            ((NativeVideoView) t).kd();
            ((NativeVideoView) this.kd).xj(this.lm);
        }
    }

    public void s() {
        T t = this.kd;
        if (t != 0) {
            ((NativeVideoView) t).M_();
        }
    }

    public void tu() {
        xj((com.bytedance.sdk.openadsdk.core.multipro.hf.xj) null);
    }

    public void wa() {
        if (lw()) {
            T t = this.kd;
            if (t != 0) {
                ((NativeVideoView) t).yo();
                return;
            }
            return;
        }
        if (bl()) {
            dq();
        } else {
            s();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        gh();
        this.cu.w(this.my);
        this.cu.xj(this.g + "x" + this.am);
        this.cu.hf(this.lm);
        this.no.xj(this.cu);
        ((NativeVideoView) this.kd).setMaterialMeta(this.no);
        ((NativeVideoView) this.kd).setIsAutoPlay(true);
        ((NativeVideoView) this.kd).setIsQuiet(this.qi);
        ((NativeVideoView) this.kd).setVisibility(0);
        ((NativeVideoView) this.kd).setEnableAutoCheck(false);
        ((NativeVideoView) this.kd).xj(this.hf, 25, this.lm);
        ((NativeVideoView) this.kd).xj(0L, true, false);
        ((NativeVideoView) this.kd).xj(this.lm);
        com.bykv.vk.openvk.component.video.api.u.w nativeVideoController = ((NativeVideoView) this.kd).getNativeVideoController();
        if (nativeVideoController != null) {
            xj xjVar = new xj();
            this.kc = xjVar;
            nativeVideoController.xj(xjVar);
        }
    }

    public void kd(boolean z) {
        T t = this.kd;
        if (t != 0) {
            ((NativeVideoView) t).setNeedNativeVideoPlayBtnVisible(z);
        }
    }

    public void u(boolean z) {
        this.qi = z;
        T t = this.kd;
        if (t == 0 || ((NativeVideoView) t).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.kd).getNativeVideoController().hf(z);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar) {
        ws wsVar;
        if (tf() != null && (wsVar = this.no) != null) {
            if (wsVar.rx() == 0) {
                int optInt = tf().optInt("image_mode");
                this.no.a(optInt);
                this.no.xj(new wo(tf()));
                if (optInt == 166) {
                    this.no.dc(-2);
                    ((NativeVideoView) this.kd).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.kd).setPlayerType(0);
        }
        if (xjVar != null) {
            com.bykv.vk.openvk.component.video.api.u.w nativeVideoController = ((NativeVideoView) this.kd).getNativeVideoController();
            nativeVideoController.u(xjVar.u);
            nativeVideoController.hf(xjVar.f);
            if (xjVar.xj) {
                nativeVideoController.hf(0L);
            } else {
                nativeVideoController.hf(xjVar.c);
            }
        }
        ((NativeVideoView) this.kd).u();
    }

    public class xj implements w.xj {
        w.xj xj;

        private xj() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
        public void hf(long j, int i) {
            w.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.hf(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
        public void xj(long j, int i) {
            if (hf.this.xj) {
                if (((com.bytedance.adsdk.ugeno.hf.w) hf.this).kd != null) {
                    ((NativeVideoView) ((com.bytedance.adsdk.ugeno.hf.w) hf.this).kd).setComplete(true);
                }
                if (((com.bytedance.adsdk.ugeno.hf.w) hf.this).kd != null) {
                    ((NativeVideoView) ((com.bytedance.adsdk.ugeno.hf.w) hf.this).kd).xj(true, true);
                }
            }
            w.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
        public void xj() {
            w.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
        public void xj(long j, long j2) {
            w.xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(j, j2);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "coverSrc":
                this.lm = str2;
                break;
            case "src":
                this.my = str2;
                break;
            case "isLp":
                try {
                    boolean booleanValue = Boolean.valueOf(str2).booleanValue();
                    this.xj = booleanValue;
                    T t = this.kd;
                    if (t != 0) {
                        ((NativeVideoView) t).setLp(booleanValue);
                        break;
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.vi = str2;
                break;
        }
    }

    public void xj(Map<String, Object> map) {
        T t = this.kd;
        if (t != 0) {
            ((NativeVideoView) t).setExtraMap(map);
        }
    }
}
