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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {

    public static class xj extends com.bytedance.msdk.hf.w {
        private com.bytedance.sdk.openadsdk.zg.w.hf.d p;

        /* renamed from: pl, reason: collision with root package name */
        private int f10160pl;
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj d = new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.w.xj.3
            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void hf(View view, g gVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).y != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).y.xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(View view, g gVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).y != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).y.xj(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(g gVar) {
                if (((com.bytedance.msdk.hf.w) xj.this).y != null) {
                    ((com.bytedance.msdk.hf.w) xj.this).y.xj();
                }
            }
        };
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj tf = new com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.w.xj.4
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

        /* JADX WARN: Multi-variable type inference failed */
        public xj(com.bytedance.sdk.openadsdk.zg.w.hf.d dVar, boolean z) {
            Map<String, Object> ht;
            this.p = dVar;
            com.bytedance.sdk.openadsdk.zg.w.hf.w v = dVar.v();
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
            j(dVar.c());
            en(dVar.f());
            q(dVar.d());
            x(dVar.am() != null ? dVar.am().w() : null);
            p(dVar.e());
            pl(dVar.zg());
            l(dVar.g());
            u(dVar.tf());
            f(dVar.zg() == 4);
            c(false);
            if (dVar.e() == 16 || dVar.e() == 3 || dVar.e() == 2 || dVar.e() == 131) {
                if (dVar.qt() != null && !dVar.qt().isEmpty() && dVar.qt().get(0) != null) {
                    com.bytedance.sdk.openadsdk.zg.w.hf.pl plVar = dVar.qt().get(0);
                    ai(plVar.w());
                    v(plVar.xj());
                    yo(plVar.hf());
                }
            } else if (dVar.e() != 4) {
                com.bytedance.sdk.openadsdk.zg.w.hf.pl kd2 = dVar.kd();
                if (kd2 == null && dVar.qt() != null && !dVar.qt().isEmpty() && dVar.qt().get(0) != null) {
                    kd2 = dVar.qt().get(0);
                }
                if (kd2 != null) {
                    ai(kd2.w());
                    v(kd2.xj());
                    yo(kd2.hf());
                }
            } else if (dVar.qt() != null && dVar.qt().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.zg.w.hf.pl> it = dVar.qt().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().w());
                }
                xj((List<String>) arrayList);
            }
            if (z && (ht = dVar.ht()) != null) {
                double xj = com.bytedance.msdk.xj.w.hf.xj(ht.get("price"));
                com.bytedance.msdk.xj.kd.w.xj("TTMediationSDK_ECMP", "pangle draw 返回的 cpm价格：".concat(String.valueOf(xj)));
                xj(xj <= 0.0d ? 0.0d : xj);
            }
            this.p.xj(this.tf);
            xj(MediationConstant.EXTRA_ADID, Long.valueOf(m()));
            xj(MediationConstant.EXTRA_CID, Long.valueOf(db()));
            xj(MediationConstant.EXTRA_DURATION, Double.valueOf(this.p.xj()));
            Map<String, Object> ht2 = this.p.ht();
            if (ht2 != null) {
                u(ht2);
                xj("log_extra", ht2.toString());
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void a(String str) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.p.xj(str);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public int ah() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                return dVar.u();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hf.w
        public double bh() {
            if (this.p == null) {
                return super.bh();
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getVideoDuration = " + this.p.xj());
            return this.p.xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public long db() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                return com.bytedance.msdk.xj.w.hf.xj(dVar.ht());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Bitmap ho() {
            if (this.p == null) {
                return super.ho();
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getAdLogo = " + this.p.y());
            return this.p.y();
        }

        @Override // com.bytedance.msdk.hf.w
        public String ir() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            return dVar != null ? com.bytedance.msdk.xj.w.hf.w(dVar.ht()) : "";
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.kd jf() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar == null) {
                return super.jf();
            }
            com.bytedance.sdk.openadsdk.zg.w.hf.kd jk = dVar.jk();
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getDownloadStatusController = ".concat(String.valueOf(jk)));
            return jk;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean jk() {
            return true;
        }

        @Override // com.bytedance.msdk.hf.w
        public int lx() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                return dVar.w();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hf.w
        public long m() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                return com.bytedance.msdk.xj.w.hf.hf(dVar.ht());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hf.w
        public Map<String, Object> q() {
            Map<String, Object> ht;
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar == null || (ht = dVar.ht()) == null) {
                return null;
            }
            w(ht);
            return super.q();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.u uj() {
            if (this.p == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getDislikeInfo");
            return this.p.yo();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.pl vh() {
            if (this.p == null) {
                return super.vh();
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getVideoCoverImage = " + this.p.kd());
            return this.p.kd();
        }

        @Override // com.bytedance.msdk.hf.w
        public int yt() {
            if (this.p == null) {
                return super.yt();
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getAppCommentNum = " + this.p.p());
            return this.p.p();
        }

        private void hf(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                try {
                    dVar.xj(new com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.w.xj.1
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
                this.p.xj(viewGroup, list, list2, list3, list4, view, this.d);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public String c() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar;
            if (!a() || (dVar = this.p) == null || dVar.hf() == null) {
                return null;
            }
            return this.p.hf().xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.msdk.api.u.xj.c.kd f() {
            if (a()) {
                return new com.bytedance.msdk.api.u.xj.c.kd() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.w.xj.2
                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void hf(long j) {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().hf(j);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void w(long j) {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().w(j);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj(long j) {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().xj(j);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void hf() {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().u();
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj() {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().w();
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj(int i, int i2) {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().xj(i, i2);
                    }

                    @Override // com.bytedance.msdk.api.u.xj.c.kd
                    public void xj(long j, int i, int i2) {
                        if (xj.this.p == null || xj.this.p.hf() == null) {
                            return;
                        }
                        xj.this.p.hf().xj(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.hf.w
        public boolean kd() {
            return this.p == null;
        }

        @Override // com.bytedance.msdk.hf.w
        public View tf() {
            if (this.p == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getVideoView = " + this.p.pz());
            return this.p.pz();
        }

        @Override // com.bytedance.msdk.hf.w
        public int u() {
            return this.f10160pl;
        }

        @Override // com.bytedance.msdk.hf.w
        public void w() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar == null || dVar.jk() == null) {
                return;
            }
            this.p.jk().hf();
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.xj(viewGroup, list, list2, list3, list4, view);
            hf(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.hf.w
        public void yo() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                dVar.xj((com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj) null);
                this.p = null;
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar;
            View pz;
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar2;
            View findViewById;
            super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
            hf(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar3 = this.p;
            if (dVar3 != null && dVar3.y() != null && tfVar != null && (findViewById = viewGroup.findViewById(tfVar.f10113pl)) != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.p.y());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.xj.kd.c.hf(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.xj.kd.c.hf(viewGroup.getContext(), 38.0f);
                    findViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ((ImageView) findViewById).setImageBitmap(this.p.y());
                }
            }
            if ((a() && (dVar2 = this.p) != null && dVar2.hf() != null && !TextUtils.isEmpty(this.p.hf().xj())) || tfVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(tfVar.c)) == null || (dVar = this.p) == null || (pz = dVar.pz()) == null) {
                return;
            }
            hf(pz);
            frameLayout.removeAllViews();
            frameLayout.addView(pz, -1, -1);
        }

        @Override // com.bytedance.msdk.hf.w
        public void tf(boolean z) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                dVar.xj(z);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void hf() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar == null || dVar.jk() == null || this.f10160pl != 3) {
                return;
            }
            this.p.jk().xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c hf(Dialog dialog, Integer[] numArr) {
            if (this.p == null) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.p.xj(dialog, numArr);
        }

        @Override // com.bytedance.msdk.hf.w
        public void hf(Activity activity) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : setActivityForDownloadApp  activity = ".concat(String.valueOf(activity)));
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                dVar.hf(activity);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj() {
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar == null || dVar.jk() == null || this.f10160pl != 2) {
                return;
            }
            this.p.jk().xj();
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw :  activity = " + activity + " pluginDislikeInteractionCallback:" + xjVar);
                this.p.xj(activity, xjVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Dialog dialog, Integer[] numArr) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.p.hf(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
            if (this.p != null) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : getDislikeDialog = ".concat(String.valueOf(activity)));
                return this.p.xj(activity);
            }
            return super.xj(activity);
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(Bitmap bitmap, int i) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : setPauseIcon bitmap = " + bitmap + " i = " + i);
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                dVar.xj(bitmap, i);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : setDrawVideoListener pluginDrawVideoListener = ".concat(String.valueOf(xjVar)));
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                dVar.xj(xjVar);
            }
        }

        @Override // com.bytedance.msdk.hf.w
        public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "pangle draw : setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(wVar)));
            com.bytedance.sdk.openadsdk.zg.w.hf.d dVar = this.p;
            if (dVar != null) {
                dVar.xj(wVar);
            }
        }
    }

    public void xj(final boolean z, z zVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.msdk.w.w.hf.xj.hf hfVar2) {
        if (zVar == null || hfVar2 == null) {
            return;
        }
        zVar.xj(hfVar, new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf(null) { // from class: com.bytedance.msdk.w.w.hf.xj.hf.w.1
            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf
            public void xj(int i, String str) {
                hfVar2.xj(new com.bytedance.msdk.api.xj(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf
            public void xj(List<com.bytedance.sdk.openadsdk.zg.w.hf.d> list) {
                if (list == null || list.isEmpty()) {
                    hfVar2.xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.zg.w.hf.d> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new xj(it.next(), z));
                }
                hfVar2.xj(arrayList);
            }
        });
    }
}
