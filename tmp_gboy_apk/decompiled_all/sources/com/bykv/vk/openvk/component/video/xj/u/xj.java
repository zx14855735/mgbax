package com.bykv.vk.openvk.component.video.xj.u;

import com.bykv.vk.openvk.component.video.xj.u.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj implements w {
    private w.InterfaceC0020w c;
    private w.u f;
    private w.kd hf;
    private w.y kd;
    private w.xj u;
    private w.hf w;
    protected boolean xj = false;
    private w.c y;

    public final void hf() {
        try {
            w.kd kdVar = this.hf;
            if (kdVar != null) {
                kdVar.hf(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void u() {
        try {
            w.y yVar = this.kd;
            if (yVar != null) {
                yVar.w(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    public final void w() {
        try {
            w.hf hfVar = this.w;
            if (hfVar != null) {
                hfVar.xj(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.kd kdVar) {
        this.hf = kdVar;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.hf hfVar) {
        this.w = hfVar;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.xj xjVar) {
        this.u = xjVar;
    }

    public final boolean hf(int i, int i2) {
        try {
            w.u uVar = this.f;
            if (uVar != null) {
                if (uVar.hf(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.y yVar) {
        this.kd = yVar;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.InterfaceC0020w interfaceC0020w) {
        this.c = interfaceC0020w;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.u uVar) {
        this.f = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public final void xj(w.c cVar) {
        this.y = cVar;
    }

    public void xj() {
        this.hf = null;
        this.u = null;
        this.w = null;
        this.kd = null;
        this.y = null;
        this.c = null;
        this.f = null;
    }

    public final void xj(int i) {
        try {
            w.xj xjVar = this.u;
            if (xjVar != null) {
                xjVar.xj(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void xj(int i, int i2, int i3, int i4) {
        try {
            w.c cVar = this.y;
            if (cVar != null) {
                cVar.xj(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean xj(int i, int i2) {
        try {
            w.InterfaceC0020w interfaceC0020w = this.c;
            if (interfaceC0020w != null) {
                if (interfaceC0020w.xj(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void xj(boolean z) {
        this.xj = z;
    }
}
