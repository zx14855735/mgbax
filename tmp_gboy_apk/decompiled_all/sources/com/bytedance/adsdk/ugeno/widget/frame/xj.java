package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.adsdk.ugeno.hf.xj<UGFrameLayout> {
    private UGFrameLayout my;

    /* renamed from: com.bytedance.adsdk.ugeno.widget.frame.xj$xj, reason: collision with other inner class name */
    public static class C0030xj extends xj.C0026xj {

        /* renamed from: io, reason: collision with root package name */
        protected int f10086io;

        public C0030xj(com.bytedance.adsdk.ugeno.hf.xj xjVar) {
            super(xjVar);
            this.f10086io = -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int hf(String str) {
            char c;
            str.getClass();
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals("bottom")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -348726240:
                    if (str.equals("center_vertical")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1063616078:
                    if (str.equals("center_horizontal")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return 80;
                case 1:
                    return 17;
                case 2:
                    return 16;
                case 3:
                    return 48;
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        /* renamed from: hf, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams xj() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.xj, (int) this.hf);
            layoutParams.leftMargin = (int) this.y;
            layoutParams.rightMargin = (int) this.c;
            layoutParams.topMargin = (int) this.f;
            layoutParams.bottomMargin = (int) this.d;
            layoutParams.gravity = this.f10086io;
            return layoutParams;
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        public void xj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.xj(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.f10086io = xj(str2);
            }
        }

        private int xj(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split("\\|")) == null || split.length <= 0) {
                return -1;
            }
            int i = 0;
            for (String str2 : split) {
                i |= hf(str2);
            }
            return i;
        }
    }

    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public xj.C0026xj f() {
        return new C0030xj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        this.my.setEventMap(this.oa);
        super.hf();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: tu, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout xj() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.hf);
        this.my = uGFrameLayout;
        uGFrameLayout.xj(this);
        return this.my;
    }
}
