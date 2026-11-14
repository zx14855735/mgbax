package com.bytedance.msdk.w.w.hf.xj.hf;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {

    public static class xj extends com.bytedance.msdk.hf.w {
        private int g;

        /* renamed from: pl, reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.zg.w.hf.tf f10157pl;
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj d = new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.xj.2
            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void hf(View view, g gVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).xj != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).xj.xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(View view, g gVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).xj != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).xj.xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(g gVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).xj != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).xj.xj();
                }
            }
        };
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj tf = new com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.xj.3
            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void hf(com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void kd(com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.kd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void u(com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void w(com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void xj(int i, int i2) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.xj(new com.bytedance.msdk.api.xj(i, "Android MediaPlay Error Code :".concat(String.valueOf(i2))));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj
            public void xj(long j, long j2) {
                if (((com.bytedance.msdk.hf.w) xj.this).hf != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).hf.xj(j, j2);
                }
            }
        };
        com.bytedance.sdk.openadsdk.zg.w.xj.w p = new com.bytedance.sdk.openadsdk.zg.w.xj.w(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.xj.4
            @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
            public void hf(long j, long j2, String str, String str2) {
                xj.this.g = 3;
                if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).w.xj(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
            public void w(long j, long j2, String str, String str2) {
                xj.this.g = 4;
                if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).w.hf(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
            public void xj() {
                xj.this.g = 0;
                if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).w.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
            public void xj(long j, long j2, String str, String str2) {
                xj.this.g = 2;
                if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).w.xj(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
            public void xj(long j, String str, String str2) {
                xj.this.g = 5;
                if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).w.xj(j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.xj.w
            public void xj(String str, String str2) {
                xj.this.g = 6;
                if (((com.bytedance.msdk.hf.w) xj.this).w != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).w.xj(str, str2);
                }
            }
        };

        /* JADX WARN: Multi-variable type inference failed */
        public xj(com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar, boolean z, boolean z2) {
            Map<String, Object> ht;
            List<com.bytedance.sdk.openadsdk.zg.w.hf.pl> qt;
            this.f10157pl = tfVar;
            com.bytedance.sdk.openadsdk.zg.w.hf.w v = tfVar.v();
            if (v != null) {
                ht(v.xj());
                ra(v.w());
                et(v.u());
                io(v.hf());
                HashMap hashMap = new HashMap();
                Map<String, String> kd = v.kd();
                if (kd != null && kd.size() > 0) {
                    hashMap.putAll(kd);
                }
                kd(hashMap);
                if (com.bytedance.msdk.xj.w.hf.xj("5.1.0.0")) {
                    dk(v.y());
                }
                if (com.bytedance.msdk.xj.w.hf.xj("5.4.0.3")) {
                    pl(v.c());
                }
                if (com.bytedance.msdk.xj.w.hf.xj("6.8.1.6")) {
                    tf(v.f());
                }
                p(v.d());
            }
            hf(z2 ? 1 : 0);
            j(tfVar.c());
            en(tfVar.f());
            q(tfVar.d());
            x(tfVar.am() != null ? tfVar.am().w() : null);
            p(tfVar.e());
            pl(tfVar.zg());
            l(tfVar.g());
            u(tfVar.tf());
            f(tfVar.zg() == 4);
            c(false);
            if (tfVar.e() == 16 || tfVar.e() == 3 || tfVar.e() == 2 || tfVar.e() == 131) {
                List<com.bytedance.sdk.openadsdk.zg.w.hf.pl> qt2 = tfVar.qt();
                if (qt2 != null && !qt2.isEmpty() && qt2.get(0) != null) {
                    com.bytedance.sdk.openadsdk.zg.w.hf.pl plVar = qt2.get(0);
                    ai(plVar.w());
                    v(plVar.xj());
                    yo(plVar.hf());
                }
            } else if (tfVar.e() == 4) {
                List<com.bytedance.sdk.openadsdk.zg.w.hf.pl> qt3 = tfVar.qt();
                if (qt3 != null && qt3.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.bytedance.sdk.openadsdk.zg.w.hf.pl> it = qt3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().w());
                    }
                    xj((List<String>) arrayList);
                }
            } else {
                com.bytedance.sdk.openadsdk.zg.w.hf.pl kd2 = tfVar.kd();
                if ((kd2 == null || TextUtils.isEmpty(kd2.w())) && (qt = tfVar.qt()) != null && !qt.isEmpty() && qt.get(0) != null) {
                    kd2 = qt.get(0);
                }
                if (kd2 != null) {
                    ai(kd2.w());
                    v(kd2.xj());
                    yo(kd2.hf());
                }
            }
            if (z && (ht = tfVar.ht()) != null) {
                double xj = com.bytedance.msdk.xj.w.hf.xj(ht.get("price"));
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(xj)));
                xj(xj <= 0.0d ? 0.0d : xj);
            }
            this.f10157pl.xj(this.tf);
            this.f10157pl.xj(this.p);
            new HashMap();
            xj(MediationConstant.EXTRA_ADID, Long.valueOf(m()));
            xj(MediationConstant.EXTRA_CID, Long.valueOf(db()));
            xj(MediationConstant.EXTRA_DURATION, Double.valueOf(this.f10157pl.xj()));
            Map<String, Object> ht2 = this.f10157pl.ht();
            if (ht2 != null) {
                u(ht2);
                xj("log_extra", ht2.toString());
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public int ah() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                return tfVar.u();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hf.w
        public double bh() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            return tfVar != null ? tfVar.xj() : super.bh();
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(tfVar.ht());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Bitmap ho() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            return tfVar != null ? tfVar.y() : super.ho();
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                return com.bytedance.msdk.xj.w.hf.w(tfVar.ht());
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean jk() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public int lx() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                return tfVar.w();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(tfVar.ht());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            if (this.f10157pl == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native : getDislikeInfo");
            return this.f10157pl.yo();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.pl vh() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            return tfVar != null ? tfVar.kd() : super.vh();
        }

        @Override // com.bytedance.msdk.hf.w
        public int yt() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            return tfVar != null ? tfVar.p() : super.yt();
        }

        private void hf(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                tfVar.xj(this.p);
                try {
                    this.f10157pl.xj(new com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.xj.1
                        @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf
                        public void xj(int i) {
                            if (((com.bytedance.msdk.hf.w) xj.this).kd != null) {
                                ((com.bytedance.msdk.hf.w) xj.this).kd.xj(i);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
                this.f10157pl.xj(viewGroup, list, list2, list3, list4, view, this.d);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            if (this.f10157pl != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.f10157pl.xj(str);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public String c() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar;
            if (!a() || (tfVar = this.f10157pl) == null || tfVar.hf() == null) {
                return null;
            }
            return this.f10157pl.hf().xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.msdk.api.u.xj.c.kd f() {
            if (a()) {
                return new com.bytedance.msdk.api.u.xj.c.kd() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.xj.5
                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void hf(long j) {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().hf(j);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void w(long j) {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().w(j);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj(long j) {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().xj(j);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void hf() {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().u();
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj() {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().w();
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj(int i, int i2) {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().xj(i, i2);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj(long j, int i, int i2) {
                        if (xj.this.f10157pl == null || xj.this.f10157pl.hf() == null) {
                            return;
                        }
                        xj.this.f10157pl.hf().xj(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.f10157pl == null;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> ht;
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar == null || (ht = tfVar.ht()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("coupon", ht.get("coupon"));
            hashMap.put("live_room", ht.get("live_room"));
            hashMap.put("product", ht.get("product"));
            w(hashMap);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public View tf() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                return tfVar.pz();
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public int u() {
            return this.g;
        }

        @Override // com.bytedance.msdk.hf.w
        public void w() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar == null || tfVar.jk() == null) {
                return;
            }
            this.f10157pl.jk().hf();
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                tfVar.xj((com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj) null);
                this.f10157pl.dk();
                this.f10157pl = null;
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.xj(viewGroup, list, list2, list3, list4, view);
            hf(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
            this.f10157pl.xj(hfVar);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar2;
            View pz;
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar3;
            View findViewById;
            super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
            hf(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar4 = this.f10157pl;
            if (tfVar4 != null && tfVar4.y() != null && tfVar != null && (findViewById = viewGroup.findViewById(tfVar.f10113pl)) != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.f10157pl.y());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.xj.kd.c.hf(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.xj.kd.c.hf(viewGroup.getContext(), 38.0f);
                    findViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ((ImageView) findViewById).setImageBitmap(this.f10157pl.y());
                }
            }
            if ((a() && (tfVar3 = this.f10157pl) != null && tfVar3.hf() != null && !TextUtils.isEmpty(this.f10157pl.hf().xj())) || tfVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(tfVar.c)) == null || (tfVar2 = this.f10157pl) == null || (pz = tfVar2.pz()) == null) {
                return;
            }
            hf(pz);
            frameLayout.removeAllViews();
            frameLayout.addView(pz, -1, -1);
        }

        @Override // com.bytedance.msdk.hf.w
        public void hf(Activity activity) {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar != null) {
                tfVar.hf(activity);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void hf() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar == null || tfVar.jk() == null || this.g != 3) {
                return;
            }
            this.f10157pl.jk().xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c hf(Dialog dialog, Integer[] numArr) {
            if (this.f10157pl == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.f10157pl.xj(dialog, numArr);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj() {
            com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar = this.f10157pl;
            if (tfVar == null || tfVar.jk() == null || this.g != 2) {
                return;
            }
            this.f10157pl.jk().xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.f10157pl != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.f10157pl.xj(activity, xjVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.f10157pl != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.f10157pl.hf(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
            if (this.f10157pl == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.f10157pl.xj(activity);
        }
    }

    public void xj(final boolean z, z zVar, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.msdk.w.w.hf.xj.hf hfVar2) {
        if (zVar == null || hfVar2 == null || hfVar == null) {
            return;
        }
        zVar.xj(hfVar, new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.1
            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w
            public void xj(int i, String str) {
                hfVar2.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w
            public void xj(List<com.bytedance.sdk.openadsdk.zg.w.hf.tf> list) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + hfVar.p());
                if (list == null || list.isEmpty()) {
                    hfVar2.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                if (hfVar.p()) {
                    f.this.xj(list, hfVar2, z);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.zg.w.hf.tf> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new xj(it.next(), z, false));
                }
                hfVar2.xj(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(List<com.bytedance.sdk.openadsdk.zg.w.hf.tf> list, final com.bytedance.msdk.w.w.hf.xj.hf hfVar, final boolean z) {
        final int size = list.size();
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_adNum:".concat(String.valueOf(size)));
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final com.bytedance.sdk.openadsdk.zg.w.hf.tf tfVar : list) {
            final long currentTimeMillis = System.currentTimeMillis();
            tfVar.xj(new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.f.2
                @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w
                public void xj(View view, float f, float f2, boolean z2) {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z2 + " duration:" + (System.currentTimeMillis() - currentTimeMillis));
                    arrayList.add(new xj(tfVar, z, z2));
                    if (atomicInteger.incrementAndGet() != size || hfVar == null) {
                        return;
                    }
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    hfVar.xj(arrayList);
                }
            });
            tfVar.ra();
        }
    }
}
