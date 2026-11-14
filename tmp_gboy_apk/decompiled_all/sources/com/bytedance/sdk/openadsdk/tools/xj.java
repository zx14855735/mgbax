package com.bytedance.sdk.openadsdk.tools;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.wo.xj.w;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class xj implements w.xj {
    private hf hf = new hf();
    private final w.xj xj;

    /* renamed from: com.bytedance.sdk.openadsdk.tools.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0205xj {
        void xj(String str, String str2);
    }

    public xj(w.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void kd(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.xj.kd(str, str2);
        } else {
            xj(str, str2, new InterfaceC0205xj() { // from class: com.bytedance.sdk.openadsdk.tools.xj.5
                @Override // com.bytedance.sdk.openadsdk.tools.xj.InterfaceC0205xj
                public void xj(String str3, String str4) {
                    xj.this.xj.kd(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void u(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.xj.u(str, str2);
        } else {
            xj(str, str2, new InterfaceC0205xj() { // from class: com.bytedance.sdk.openadsdk.tools.xj.4
                @Override // com.bytedance.sdk.openadsdk.tools.xj.InterfaceC0205xj
                public void xj(String str3, String str4) {
                    xj.this.xj.u(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void w(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.xj.w(str, str2);
        } else {
            xj(str, str2, new InterfaceC0205xj() { // from class: com.bytedance.sdk.openadsdk.tools.xj.3
                @Override // com.bytedance.sdk.openadsdk.tools.xj.InterfaceC0205xj
                public void xj(String str3, String str4) {
                    xj.this.xj.w(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void hf(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.xj.hf(str, str2);
        } else {
            xj(str, str2, new InterfaceC0205xj() { // from class: com.bytedance.sdk.openadsdk.tools.xj.2
                @Override // com.bytedance.sdk.openadsdk.tools.xj.InterfaceC0205xj
                public void xj(String str3, String str4) {
                    xj.this.xj.hf(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void xj(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.xj.xj(str, str2);
        } else {
            xj(str, str2, new InterfaceC0205xj() { // from class: com.bytedance.sdk.openadsdk.tools.xj.1
                @Override // com.bytedance.sdk.openadsdk.tools.xj.InterfaceC0205xj
                public void xj(String str3, String str4) {
                    xj.this.xj.xj(str3, str4);
                }
            });
        }
    }

    public class hf {
        private hf() {
        }

        public void xj(String str, String str2, InterfaceC0205xj interfaceC0205xj) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int min = Math.min(i + f.a.c, str2.length());
                interfaceC0205xj.xj(xj(str, hexString, i, min), str2.substring(i, min));
                i = min;
            }
        }

        private String xj(String str, String str2, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(i);
            sb.append("_");
            sb.append(i2);
            return CtFAbx.B25kr6(sb, "_", str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void hf(String str, String str2, Throwable th) {
        this.xj.hf(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void xj(String str, String str2, Throwable th) {
        this.xj.xj(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void xj(String str, Throwable th) {
        this.xj.xj(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.w.xj
    public void xj() {
        this.xj.xj();
    }

    private void xj(final String str, final String str2, final InterfaceC0205xj interfaceC0205xj) {
        try {
            try {
                if (c.xj()) {
                    c.hf(new d("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.xj.6
                        @Override // java.lang.Runnable
                        public void run() {
                            xj.this.hf.xj(str, str2, interfaceC0205xj);
                        }
                    });
                } else {
                    this.hf.xj(str, str2, interfaceC0205xj);
                }
            } catch (Throwable th) {
                th = th;
                pl.hf("", "print big Str failed!", th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
