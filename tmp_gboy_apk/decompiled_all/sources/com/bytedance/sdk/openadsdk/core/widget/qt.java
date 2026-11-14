package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt {
    private com.bykv.vk.openvk.component.video.api.w.w c;
    private View d;
    private TTViewStub f;
    private TextView hf;
    private hf kd;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.hf u;
    private Context w;
    private View xj;
    private boolean y = false;

    public interface hf {
        void pl();

        boolean tf();
    }

    public enum xj {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO;

        static {
            uBBpmZ();
        }

        private static /* synthetic */ void uBBpmZ() {
            char[] charArray = "gki*ceia*fk}*wlahh*NjmFvm`ca".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 4);
            }
            String str = new String(charArray);
            char[] charArray2 = "ghmjmp".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 4);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private void u() {
        View view = this.xj;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.w == null) {
            return;
        }
        u();
    }

    private void hf() {
        this.c = null;
    }

    public void xj(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.d = view;
        this.w = pz.getContext().getApplicationContext();
        try {
            this.f = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.f());
        } catch (Throwable unused) {
        }
    }

    private void xj(Context context, View view, boolean z) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.f) == null || tTViewStub.getParent() == null || this.xj != null) {
            return;
        }
        this.f.xj();
        this.xj = view.findViewById(2114387870);
        this.hf = (TextView) view.findViewById(2114387817);
        View findViewById = view.findViewById(2114387880);
        if (z) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.qt.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    qt.this.w();
                    if (qt.this.u != null) {
                        qt.this.u.xj(xj.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            findViewById.setOnClickListener(null);
            findViewById.setClickable(false);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.nativevideo.hf hfVar, hf hfVar2) {
        this.kd = hfVar2;
        this.u = hfVar;
    }

    public boolean xj(int i, com.bykv.vk.openvk.component.video.api.w.w wVar, boolean z) {
        Context context = this.w;
        if (context != null && wVar != null) {
            try {
                xj(context, this.d, z);
                this.c = wVar;
                if (i == 1 || i == 2) {
                    return xj(i);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
        return true;
    }

    private boolean xj(int i) {
        hf hfVar;
        if (xj() || this.y) {
            return true;
        }
        if (this.u != null && (hfVar = this.kd) != null) {
            if (hfVar.tf()) {
                this.u.kd(null, null);
            }
            this.u.xj(xj.PAUSE_VIDEO, (String) null);
        }
        xj(this.c, true);
        return false;
    }

    public void xj(boolean z) {
        if (z) {
            hf();
        }
        u();
    }

    public boolean xj() {
        View view = this.xj;
        return view != null && view.getVisibility() == 0;
    }

    private void xj(com.bykv.vk.openvk.component.video.api.w.w wVar, boolean z) {
        View view;
        String str;
        View view2;
        if (wVar == null || (view = this.xj) == null || this.w == null || view.getVisibility() == 0) {
            return;
        }
        hf hfVar = this.kd;
        if (hfVar != null) {
            hfVar.pl();
        }
        int ceil = (int) Math.ceil((wVar.kd() * 1.0d) / 1048576.0d);
        if (z) {
            str = jk.xj(this.w, "tt_video_without_wifi_tips") + ceil + jk.xj(this.w, "tt_video_bytesize_MB") + jk.xj(this.w, "tt_video_bytesize");
        } else {
            str = jk.xj(this.w, "tt_video_without_wifi_tips") + jk.xj(this.w, "tt_video_bytesize");
        }
        r.xj(this.xj, 0);
        r.xj(this.hf, str);
        if (!r.u(this.xj) || (view2 = this.xj) == null) {
            return;
        }
        view2.bringToFront();
    }
}
