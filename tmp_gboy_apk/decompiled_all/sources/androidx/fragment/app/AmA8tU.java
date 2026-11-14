package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ViewGroup f8753A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f8754A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f8755A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f8756ADYaiT;
    public boolean AMqCpz;

    public AmA8tU(ViewGroup viewGroup) {
        RXb0Sz.ARc23Z.AMqCpz(viewGroup, "container");
        this.f8753A2egSU = viewGroup;
        this.f8754A4TApA = new ArrayList();
        this.f8755A5SV6n = new ArrayList();
    }

    public static void A2egSU(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (COJEAR.DXuj49.A4TApA(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                A2egSU(childAt, arrayList);
            }
        }
    }

    public static void AMqCpz(B25kr6.ADYaiT aDYaiT, View view) {
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        String AaHO0E2 = COJEAR.CmUvjW.AaHO0E(view);
        if (AaHO0E2 != null) {
            aDYaiT.put(AaHO0E2, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    AMqCpz(aDYaiT, childAt);
                }
            }
        }
    }

    public static final AmA8tU AYUAbz(ViewGroup viewGroup, CtxOCS ctxOCS) {
        RXb0Sz.ARc23Z.AMqCpz(viewGroup, "container");
        RXb0Sz.ARc23Z.AMqCpz(ctxOCS, "fragmentManager");
        RXb0Sz.ARc23Z.ADYaiT(ctxOCS.C2rE4F(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = viewGroup.getTag(2131298002);
        if (tag instanceof AmA8tU) {
            return (AmA8tU) tag;
        }
        AmA8tU amA8tU = new AmA8tU(viewGroup);
        viewGroup.setTag(2131298002, amA8tU);
        return amA8tU;
    }

    public static void AZkASS(B25kr6.ADYaiT aDYaiT, Collection collection) {
        Iterator it = ((com.google.gson.internal.AZkASS) aDYaiT.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            RXb0Sz.ARc23Z.AMqCpz(entry, "entry");
            View view = (View) entry.getValue();
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            if (!RD2OKB.B4ZgIw.AYUAbz(collection, COJEAR.CmUvjW.AaHO0E(view))) {
                it.remove();
            }
        }
    }

    public final void A4TApA(int i, int i2, DUi7mC dUi7mC) {
        synchronized (this.f8754A4TApA) {
            C2rE4F.AMqCpz aMqCpz = new C2rE4F.AMqCpz();
            Fragment fragment = dUi7mC.f8903A5SV6n;
            RXb0Sz.ARc23Z.ADYaiT(fragment, "fragmentStateManager.fragment");
            DyaChj ARc23Z2 = ARc23Z(fragment);
            if (ARc23Z2 != null) {
                ARc23Z2.A5SV6n(i, i2);
                return;
            }
            final DyaChj dyaChj = new DyaChj(i, i2, dUi7mC, aMqCpz);
            this.f8754A4TApA.add(dyaChj);
            final int i3 = 0;
            dyaChj.f8956ADYaiT.add(new Runnable(this) { // from class: androidx.fragment.app.DvK7DB

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ AmA8tU f8951AlLFFp;

                {
                    this.f8951AlLFFp = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i3) {
                        case 0:
                            AmA8tU amA8tU = this.f8951AlLFFp;
                            RXb0Sz.ARc23Z.AMqCpz(amA8tU, "this$0");
                            DyaChj dyaChj2 = dyaChj;
                            if (amA8tU.f8754A4TApA.contains(dyaChj2)) {
                                int i4 = dyaChj2.f8953A2egSU;
                                View view = dyaChj2.f8955A5SV6n.mView;
                                RXb0Sz.ARc23Z.ADYaiT(view, "operation.fragment.mView");
                                J3FDQU.A2egSU.A2egSU(i4, view);
                                break;
                            }
                            break;
                        default:
                            AmA8tU amA8tU2 = this.f8951AlLFFp;
                            RXb0Sz.ARc23Z.AMqCpz(amA8tU2, "this$0");
                            DyaChj dyaChj3 = dyaChj;
                            amA8tU2.f8754A4TApA.remove(dyaChj3);
                            amA8tU2.f8755A5SV6n.remove(dyaChj3);
                            break;
                    }
                }
            });
            final int i4 = 1;
            dyaChj.f8956ADYaiT.add(new Runnable(this) { // from class: androidx.fragment.app.DvK7DB

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ AmA8tU f8951AlLFFp;

                {
                    this.f8951AlLFFp = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i4) {
                        case 0:
                            AmA8tU amA8tU = this.f8951AlLFFp;
                            RXb0Sz.ARc23Z.AMqCpz(amA8tU, "this$0");
                            DyaChj dyaChj2 = dyaChj;
                            if (amA8tU.f8754A4TApA.contains(dyaChj2)) {
                                int i42 = dyaChj2.f8953A2egSU;
                                View view = dyaChj2.f8955A5SV6n.mView;
                                RXb0Sz.ARc23Z.ADYaiT(view, "operation.fragment.mView");
                                J3FDQU.A2egSU.A2egSU(i42, view);
                                break;
                            }
                            break;
                        default:
                            AmA8tU amA8tU2 = this.f8951AlLFFp;
                            RXb0Sz.ARc23Z.AMqCpz(amA8tU2, "this$0");
                            DyaChj dyaChj3 = dyaChj;
                            amA8tU2.f8754A4TApA.remove(dyaChj3);
                            amA8tU2.f8755A5SV6n.remove(dyaChj3);
                            break;
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x07a3, code lost:
    
        r0 = r0.f8804A4TApA;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x07a5, code lost:
    
        if (r0 != null) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x07ab, code lost:
    
        r4 = r5.f8741A2egSU;
        r1 = RXb0Sz.ARc23Z.A2egSU(r8.get(r4), java.lang.Boolean.TRUE);
        r2 = r4.f8955A5SV6n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x07b9, code lost:
    
        if (r1 == false) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x07cd, code lost:
    
        if (r4.f8953A2egSU != 3) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x07cf, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x07d4, code lost:
    
        if (r3 == false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x07d6, code lost:
    
        r14.remove(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x07d9, code lost:
    
        r2 = r2.mView;
        r15.startViewTransition(r2);
        r0.addListener(new androidx.fragment.app.AcNBzu(r38, r2, r3, r4, r5));
        r0.setTarget(r2);
        r0.start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0800, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0802, code lost:
    
        r4.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0805, code lost:
    
        r5.f8742A4TApA.A2egSU(new androidx.fragment.app.AMqCpz(r0, r4));
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x07d2, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x07c1, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x07c3, code lost:
    
        java.util.Objects.toString(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x07c6, code lost:
    
        r5.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x07a7, code lost:
    
        r11.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x079f, code lost:
    
        r5.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0792, code lost:
    
        r5.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0814, code lost:
    
        r2 = r38;
        r7 = r11.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x081e, code lost:
    
        if (r7.hasNext() == false) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0820, code lost:
    
        r3 = (androidx.fragment.app.AZOQYO) r7.next();
        r4 = r3.f8741A2egSU;
        r0 = r4.f8955A5SV6n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x082b, code lost:
    
        if (r6 == false) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x083e, code lost:
    
        if (r16 == false) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x084d, code lost:
    
        r0 = r0.mView;
        RXb0Sz.ARc23Z.ADYaiT(r10, r1);
        r5 = r3.A5SV6n(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0858, code lost:
    
        if (r5 == null) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x085a, code lost:
    
        r5 = r5.f8803A2egSU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x085c, code lost:
    
        if (r5 == null) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0861, code lost:
    
        if (r4.f8953A2egSU == 1) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0863, code lost:
    
        r0.startAnimation(r5);
        r3.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0869, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x088b, code lost:
    
        r3.f8742A4TApA.A2egSU(new androidx.fragment.app.ARc23Z(r0, r2, r3, r4, 0));
        r2 = r38;
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x086c, code lost:
    
        r15.startViewTransition(r0);
        r8 = new androidx.fragment.app.CASmeH(r5, r15, r0);
        r8.setAnimationListener(new androidx.fragment.app.AlLFFp(r4, r2, r0, r3));
        r0.startAnimation(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0885, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0887, code lost:
    
        r4.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        r13 = (androidx.fragment.app.DyaChj) r4;
        r3 = r39.listIterator(r39.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x08a2, code lost:
    
        throw new java.lang.IllegalStateException("Required value was null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x08a8, code lost:
    
        throw new java.lang.IllegalStateException("Required value was null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0844, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0846, code lost:
    
        java.util.Objects.toString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0849, code lost:
    
        r3.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0833, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0835, code lost:
    
        java.util.Objects.toString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0838, code lost:
    
        r3.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x08a9, code lost:
    
        r0 = r14.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x08b1, code lost:
    
        if (r0.hasNext() == false) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r3.hasPrevious() == false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x08b3, code lost:
    
        r1 = (androidx.fragment.app.DyaChj) r0.next();
        r2 = r1.f8955A5SV6n.mView;
        r1 = r1.f8953A2egSU;
        RXb0Sz.ARc23Z.ADYaiT(r2, "view");
        J3FDQU.A2egSU.A2egSU(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x08c8, code lost:
    
        r14.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x08d1, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x08d3, code lost:
    
        java.util.Objects.toString(r13);
        java.util.Objects.toString(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x08d9, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x01f1, code lost:
    
        r4 = new android.view.View(r15.getContext());
        r6 = new android.graphics.Rect();
        r11 = new java.util.ArrayList();
        r9 = new java.util.ArrayList();
        r2 = new B25kr6.ADYaiT();
        r27 = r5.iterator();
        r33 = r3;
        r1 = null;
        r3 = null;
        r28 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x021e, code lost:
    
        if (r27.hasNext() == false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r14 = r3.previous();
        r15 = (androidx.fragment.app.DyaChj) r14;
        r9 = r15.f8955A5SV6n.mView;
        RXb0Sz.ARc23Z.ADYaiT(r9, "operation.fragment.mView");
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0220, code lost:
    
        r29 = r5;
        r5 = ((androidx.fragment.app.AaHO0E) r27.next()).AMqCpz;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x022c, code lost:
    
        if (r5 == null) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x022e, code lost:
    
        if (r13 == null) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0230, code lost:
    
        if (r14 == null) goto L415;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0232, code lost:
    
        r3 = r10.B3GDIM(r10.ARc23Z(r5));
        r5 = r14.f8955A5SV6n;
        r30 = r1;
        r1 = r5.getSharedElementSourceNames();
        r34 = r8;
        RXb0Sz.ARc23Z.ADYaiT(r1, "lastIn.fragment.sharedElementSourceNames");
        r8 = r13.f8955A5SV6n;
        r31 = r12;
        r12 = r8.getSharedElementSourceNames();
        r35 = r7;
        RXb0Sz.ARc23Z.ADYaiT(r12, "firstOut.fragment.sharedElementSourceNames");
        r7 = r8.getSharedElementTargetNames();
        r32 = r4;
        RXb0Sz.ARc23Z.ADYaiT(r7, "firstOut.fragment.sharedElementTargetNames");
        r4 = r7.size();
        r36 = r6;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x026a, code lost:
    
        if (r6 >= r4) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x026c, code lost:
    
        r19 = r4;
        r4 = r1.indexOf(r7.get(r6));
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0279, code lost:
    
        if (r4 == (-1)) goto L422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x027b, code lost:
    
        r1.set(r4, r12.get(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        if (r9.getAlpha() != 0.0f) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0282, code lost:
    
        r6 = r6 + 1;
        r4 = r19;
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0289, code lost:
    
        r4 = r5.getSharedElementTargetNames();
        RXb0Sz.ARc23Z.ADYaiT(r4, "lastIn.fragment.sharedElementTargetNames");
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0292, code lost:
    
        if (r40 != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0294, code lost:
    
        r12 = new R8Rbcg.A4TApA(r8.getExitTransitionCallback(), r5.getEnterTransitionCallback());
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x02af, code lost:
    
        r6 = (androidx.core.app.D07BeM) r12.f7826AcNBzu;
        r7 = (androidx.core.app.D07BeM) r12.f7827AlLFFp;
        r12 = r1.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x02be, code lost:
    
        if (r6 >= r12) goto L423;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02c0, code lost:
    
        r2.put(r1.get(r6), r4.get(r6));
        r6 = r6 + 1;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02dc, code lost:
    
        r21 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02e2, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x02e4, code lost:
    
        r6 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x02ec, code lost:
    
        if (r6.hasNext() == false) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x02ee, code lost:
    
        r7 = r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x02f5, code lost:
    
        r6 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02fd, code lost:
    
        if (r6.hasNext() == false) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
    
        if (r9.getVisibility() != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02ff, code lost:
    
        r7 = r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0306, code lost:
    
        r6 = new B25kr6.ADYaiT();
        r7 = r8.mView;
        RXb0Sz.ARc23Z.ADYaiT(r7, "firstOut.fragment.mView");
        AMqCpz(r6, r7);
        r6.AlLFFp(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0318, code lost:
    
        if (r6 == null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x031e, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0320, code lost:
    
        r13.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0323, code lost:
    
        r7 = r1.size() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x032b, code lost:
    
        if (r7 < 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x032d, code lost:
    
        r12 = r7 - 1;
        r7 = r1.get(r7);
        r19 = (android.view.View) r6.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x033b, code lost:
    
        if (r19 != null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x033d, code lost:
    
        r2.remove(r7);
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x035e, code lost:
    
        if (r20 >= 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0361, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0343, code lost:
    
        r20 = COJEAR.DG07BK.f1680A2egSU;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x034f, code lost:
    
        if (RXb0Sz.ARc23Z.A2egSU(r7, COJEAR.CmUvjW.AaHO0E(r19)) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0351, code lost:
    
        r2.put(COJEAR.CmUvjW.AaHO0E(r19), (java.lang.String) r2.remove(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x036d, code lost:
    
        r7 = new B25kr6.ADYaiT();
        r12 = r5.mView;
        r24 = r9;
        RXb0Sz.ARc23Z.ADYaiT(r12, "lastIn.fragment.mView");
        AMqCpz(r7, r12);
        r7.AlLFFp(r4);
        r7.AlLFFp(r2.values());
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0388, code lost:
    
        if (r21 == null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
    
        if (r15.f8953A2egSU != 2) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x038e, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0390, code lost:
    
        r14.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0393, code lost:
    
        r9 = r4.size() - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x039b, code lost:
    
        if (r9 < 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x039d, code lost:
    
        r12 = r9 - 1;
        r9 = r4.get(r9);
        r19 = (android.view.View) r7.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x03af, code lost:
    
        if (r19 != null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x03b1, code lost:
    
        RXb0Sz.ARc23Z.ADYaiT(r9, "name");
        r9 = androidx.fragment.app.DaOi9o.A4TApA(r2, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x03b8, code lost:
    
        if (r9 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x03ba, code lost:
    
        r2.remove(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x03bd, code lost:
    
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x03de, code lost:
    
        if (r12 >= 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x03e2, code lost:
    
        r9 = r12;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0408, code lost:
    
        AZkASS(r6, r2.keySet());
        AZkASS(r7, r2.values());
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x041a, code lost:
    
        if (r2.isEmpty() == false) goto L411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0435, code lost:
    
        androidx.fragment.app.DaOi9o.A2egSU(r5, r8, r40, r6);
        COJEAR.BV3sI0.A4TApA(r15, new androidx.fragment.app.ASJ6gh(r14, r13, r40, r7));
        r11.addAll(r6.values());
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x044b, code lost:
    
        if (r1.isEmpty() != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009e, code lost:
    
        r14 = (androidx.fragment.app.DyaChj) r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x044d, code lost:
    
        r1 = (android.view.View) r6.get(r1.get(0));
        r10.AlLFFp(r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0460, code lost:
    
        r24.addAll(r7.values());
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x046d, code lost:
    
        if (r21.isEmpty() != false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x046f, code lost:
    
        r4 = (android.view.View) r7.get(r21.get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x047e, code lost:
    
        if (r4 == null) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0480, code lost:
    
        r7 = r36;
        COJEAR.BV3sI0.A4TApA(r15, new androidx.fragment.app.AYUAbz(r10, r4, r7));
        r28 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x048c, code lost:
    
        r4 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0492, code lost:
    
        r10.B25kr6(r3, r4, r11);
        r19 = r10;
        r19.AcNBzu(r3, null, null, r3, r24);
        r3 = java.lang.Boolean.TRUE;
        r35.put(r13, r3);
        r35.put(r14, r3);
        r10 = r19;
        r9 = r24;
        r6 = r7;
        r7 = r35;
        r3 = r3;
        r5 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04ba, code lost:
    
        r12 = r31;
        r8 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x048f, code lost:
    
        r7 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x045e, code lost:
    
        r1 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x041c, code lost:
    
        r11.clear();
        r24.clear();
        r9 = r24;
        r5 = r29;
        r1 = r30;
        r12 = r31;
        r4 = r32;
        r8 = r34;
        r7 = r35;
        r6 = r36;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x03c0, code lost:
    
        r21 = COJEAR.DG07BK.f1680A2egSU;
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x03cc, code lost:
    
        if (RXb0Sz.ARc23Z.A2egSU(r9, COJEAR.CmUvjW.AaHO0E(r19)) != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x03ce, code lost:
    
        RXb0Sz.ARc23Z.ADYaiT(r9, "name");
        r4 = androidx.fragment.app.DaOi9o.A4TApA(r2, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x03d5, code lost:
    
        if (r4 == null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        java.util.Objects.toString(r13);
        java.util.Objects.toString(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x03d7, code lost:
    
        r2.put(r4, COJEAR.CmUvjW.AaHO0E(r19));
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x03e9, code lost:
    
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03ec, code lost:
    
        r21 = r4;
        r4 = androidx.fragment.app.DaOi9o.f8933A2egSU;
        r4 = r2.f1011AmA8tU - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x03f5, code lost:
    
        if ((-1) >= r4) goto L428;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0401, code lost:
    
        if (r7.containsKey((java.lang.String) r2.AZkASS(r4)) != false) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0403, code lost:
    
        r2.AYUAbz(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0406, code lost:
    
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
    
        r3 = new java.util.ArrayList();
        r5 = new java.util.ArrayList();
        r8 = RD2OKB.B4ZgIw.AmA8tU(r39);
        r9 = ((androidx.fragment.app.DyaChj) RD2OKB.B4ZgIw.AcNBzu(r39)).f8955A5SV6n;
        r15 = r39.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0366, code lost:
    
        r2.AlLFFp(r6.keySet());
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x02a2, code lost:
    
        r12 = new R8Rbcg.A4TApA(r8.getEnterTransitionCallback(), r5.getExitTransitionCallback());
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x04c0, code lost:
    
        r34 = r8;
        r31 = r12;
        r10 = r10;
        r9 = r9;
        r6 = r6;
        r7 = r7;
        r5 = r29;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x04d4, code lost:
    
        r30 = r1;
        r29 = r5;
        r34 = r8;
        r5 = r10;
        r31 = r12;
        r8 = r7;
        r7 = r6;
        r6 = r9;
        r0 = new java.util.ArrayList();
        r1 = r29.iterator();
        r9 = null;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x04ef, code lost:
    
        if (r1.hasNext() == false) goto L431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x04f1, code lost:
    
        r12 = (androidx.fragment.app.AaHO0E) r1.next();
        r19 = r12.A4TApA();
        r40 = r1;
        r1 = r12.f8741A2egSU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x04ff, code lost:
    
        if (r19 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x050c, code lost:
    
        r26 = r2;
        r2 = r5.ARc23Z(r12.f8743A5SV6n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0514, code lost:
    
        if (r3 == null) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0516, code lost:
    
        if (r1 == r13) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0518, code lost:
    
        if (r1 != r14) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x051a, code lost:
    
        r19 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x051f, code lost:
    
        if (r2 != null) goto L432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ca, code lost:
    
        if (r15.hasNext() == false) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0530, code lost:
    
        r27 = r11;
        r11 = new java.util.ArrayList();
        r32 = r6;
        r6 = r1.f8955A5SV6n;
        r35 = r14;
        r14 = r6.mView;
        r36 = r3;
        r3 = r31;
        RXb0Sz.ARc23Z.ADYaiT(r14, r3);
        A2egSU(r14, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0549, code lost:
    
        if (r19 == false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x054b, code lost:
    
        if (r1 != r13) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x054d, code lost:
    
        r11.removeAll(RD2OKB.B4ZgIw.AzWtSf(r27));
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0555, code lost:
    
        r11.removeAll(RD2OKB.B4ZgIw.AzWtSf(r32));
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0560, code lost:
    
        if (r11.isEmpty() == false) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0562, code lost:
    
        r5.A2egSU(r4, r2);
        r31 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0567, code lost:
    
        r19 = r4;
        r14 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cc, code lost:
    
        r10 = ((androidx.fragment.app.DyaChj) r15.next()).f8955A5SV6n.mAnimationInfo;
        r11 = r9.mAnimationInfo;
        r10.f8777A4TApA = r11.f8777A4TApA;
        r10.f8778A5SV6n = r11.f8778A5SV6n;
        r10.f8779ADYaiT = r11.f8779ADYaiT;
        r10.AMqCpz = r11.AMqCpz;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x05a7, code lost:
    
        if (r1.f8953A2egSU != 2) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x05a9, code lost:
    
        r0.addAll(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x05ac, code lost:
    
        if (r28 == false) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x05ae, code lost:
    
        r5.AmA8tU(r2, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x05b1, code lost:
    
        r3 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x05b9, code lost:
    
        r8.put(r1, java.lang.Boolean.TRUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x05c0, code lost:
    
        if (r12.f8744ADYaiT == false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x05c2, code lost:
    
        r9 = r5.AZkASS(r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x05c6, code lost:
    
        r1 = r40;
        r30 = r3;
        r34 = r14;
        r4 = r19;
        r2 = r26;
        r11 = r27;
        r6 = r32;
        r14 = r35;
        r3 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x05de, code lost:
    
        r10 = r5.AZkASS(r10, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x05b4, code lost:
    
        r3 = r30;
        r5.AlLFFp(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x056c, code lost:
    
        r5.A4TApA(r2, r11);
        r5.AcNBzu(r2, r2, r11, null, null);
        r31 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0583, code lost:
    
        if (r1.f8953A2egSU != 3) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0585, code lost:
    
        r14 = r34;
        r14.remove(r1);
        r3 = new java.util.ArrayList(r11);
        r19 = r4;
        r3.remove(r6.mView);
        r5.AaHO0E(r2, r6.mView, r3);
        COJEAR.BV3sI0.A4TApA(r15, new androidx.fragment.app.B7CMnp(1, r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0521, code lost:
    
        if (r19 != false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0523, code lost:
    
        r8.put(r1, java.lang.Boolean.FALSE);
        r12.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x052b, code lost:
    
        r1 = r40;
        r2 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ef, code lost:
    
        r4 = r39.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x051d, code lost:
    
        r19 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0501, code lost:
    
        r26 = r2;
        r8.put(r1, java.lang.Boolean.FALSE);
        r12.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x05e3, code lost:
    
        r26 = r2;
        r1 = r3;
        r32 = r6;
        r27 = r11;
        r35 = r14;
        r14 = r34;
        r2 = r5.AZOQYO(r9, r10, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x05f2, code lost:
    
        if (r2 != null) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x05f4, code lost:
    
        r9 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x05f8, code lost:
    
        r3 = new java.util.ArrayList();
        r4 = r29.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0605, code lost:
    
        if (r4.hasNext() == false) goto L439;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0607, code lost:
    
        r6 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0612, code lost:
    
        if (((androidx.fragment.app.AaHO0E) r6).A4TApA() != false) goto L441;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0614, code lost:
    
        r3.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0618, code lost:
    
        r3 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
    
        if (r4.hasNext() == false) goto L366;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0620, code lost:
    
        if (r3.hasNext() == false) goto L443;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0622, code lost:
    
        r4 = (androidx.fragment.app.AaHO0E) r3.next();
        r6 = r4.f8743A5SV6n;
        r7 = r4.f8741A2egSU;
        r9 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x062e, code lost:
    
        if (r1 == null) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0630, code lost:
    
        if (r7 == r13) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0632, code lost:
    
        if (r7 != r9) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0634, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0637, code lost:
    
        if (r6 != null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0639, code lost:
    
        if (r10 == false) goto L445;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fb, code lost:
    
        r7 = (androidx.fragment.app.DyaChj) r4.next();
        r10 = new C2rE4F.AMqCpz();
        r7.ADYaiT();
        r11 = r7.AMqCpz;
        r11.add(r10);
        r3.add(new androidx.fragment.app.AZOQYO(r7, r10, r40));
        r10 = new C2rE4F.AMqCpz();
        r7.ADYaiT();
        r11.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x065f, code lost:
    
        r35 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x063b, code lost:
    
        r6 = COJEAR.DG07BK.f1680A2egSU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0641, code lost:
    
        if (r15.isLaidOut() != false) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0649, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x064b, code lost:
    
        java.util.Objects.toString(r15);
        java.util.Objects.toString(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0651, code lost:
    
        r4.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0655, code lost:
    
        r5.AzWtSf(r2, r4.f8742A4TApA, new androidx.fragment.app.AYUAbz(r4, r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0123, code lost:
    
        if (r40 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0636, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0662, code lost:
    
        r9 = r35;
        r3 = COJEAR.DG07BK.f1680A2egSU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x066a, code lost:
    
        if (r15.isLaidOut() != false) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x066f, code lost:
    
        androidx.fragment.app.DaOi9o.A5SV6n(r0, 4);
        r3 = new java.util.ArrayList();
        r4 = r32.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x067d, code lost:
    
        if (r6 >= r4) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x067f, code lost:
    
        r7 = r32;
        r10 = (android.view.View) r7.get(r6);
        r11 = COJEAR.DG07BK.f1680A2egSU;
        r3.add(COJEAR.CmUvjW.AaHO0E(r10));
        COJEAR.CmUvjW.BChYOn(r10, null);
        r6 = r6 + 1;
        r32 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x069b, code lost:
    
        r7 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x06a3, code lost:
    
        if (androidx.fragment.app.CtxOCS.C4FrIb(2) == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0125, code lost:
    
        if (r7 != r13) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x06a5, code lost:
    
        r4 = r27.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x06ad, code lost:
    
        if (r4.hasNext() == false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x06af, code lost:
    
        r6 = r4.next();
        RXb0Sz.ARc23Z.ADYaiT(r6, "sharedElementFirstOutViews");
        r6 = (android.view.View) r6;
        r6.toString();
        COJEAR.CmUvjW.AaHO0E(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x06c1, code lost:
    
        r4 = r7.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x06c9, code lost:
    
        if (r4.hasNext() == false) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x06cb, code lost:
    
        r6 = r4.next();
        RXb0Sz.ARc23Z.ADYaiT(r6, "sharedElementLastInViews");
        r6 = (android.view.View) r6;
        r6.toString();
        COJEAR.CmUvjW.AaHO0E(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0127, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x06dd, code lost:
    
        r5.A5SV6n(r15, r2);
        r2 = r7.size();
        r4 = new java.util.ArrayList();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x06ea, code lost:
    
        if (r6 >= r2) goto L450;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x06ec, code lost:
    
        r10 = r27;
        r11 = (android.view.View) r10.get(r6);
        r12 = COJEAR.DG07BK.f1680A2egSU;
        r12 = COJEAR.CmUvjW.AaHO0E(r11);
        r4.add(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x06fd, code lost:
    
        if (r12 != null) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x06ff, code lost:
    
        r27 = r2;
        r31 = r4;
        r16 = r6;
        r11 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x073c, code lost:
    
        r6 = r16 + 1;
        r26 = r11;
        r2 = r27;
        r4 = r31;
        r27 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x070a, code lost:
    
        r31 = r4;
        COJEAR.CmUvjW.BChYOn(r11, null);
        r11 = r26;
        r4 = (java.lang.String) r11.get(r12);
        r16 = r6;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x071d, code lost:
    
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x071f, code lost:
    
        if (r6 >= r2) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0729, code lost:
    
        if (r4.equals(r3.get(r6)) == false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0735, code lost:
    
        r6 = r6 + 1;
        r2 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x072b, code lost:
    
        COJEAR.CmUvjW.BChYOn((android.view.View) r7.get(r6), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0747, code lost:
    
        r10 = r27;
        COJEAR.BV3sI0.A4TApA(r15, new QgOIY0.CNPG0E(r2, r7, r3, r10, r4, 1));
        androidx.fragment.app.DaOi9o.A5SV6n(r0, 0);
        r5.B2KMhB(r1, r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012e, code lost:
    
        r5.add(new androidx.fragment.app.AaHO0E(r7, r10, r40, r9));
        r7.f8956ADYaiT.add(new androidx.fragment.app.ADYaiT(r8, r7, r38));
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0081, code lost:
    
        r9 = r9.getVisibility();
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0085, code lost:
    
        if (r9 == 0) goto L363;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0087, code lost:
    
        if (r9 == 4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0089, code lost:
    
        if (r9 != 8) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0095, code lost:
    
        throw new java.lang.IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(r9, "Unknown visibility "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x009d, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0129, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012b, code lost:
    
        if (r7 != r14) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x013f, code lost:
    
        r7 = new java.util.LinkedHashMap();
        r4 = new java.util.ArrayList();
        r10 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0151, code lost:
    
        if (r10.hasNext() == false) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0153, code lost:
    
        r11 = r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015e, code lost:
    
        if (((androidx.fragment.app.AaHO0E) r11).A4TApA() != false) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0160, code lost:
    
        r4.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0164, code lost:
    
        r10 = new java.util.ArrayList();
        r4 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0171, code lost:
    
        if (r4.hasNext() == false) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0173, code lost:
    
        r11 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017e, code lost:
    
        if (((androidx.fragment.app.AaHO0E) r11).A5SV6n() == null) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0180, code lost:
    
        r10.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0184, code lost:
    
        r4 = r10.iterator();
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018d, code lost:
    
        if (r4.hasNext() == false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018f, code lost:
    
        r11 = (androidx.fragment.app.AaHO0E) r4.next();
        r15 = r11.A5SV6n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0199, code lost:
    
        if (r10 == null) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
    
        if (r15 != r10) goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c8, code lost:
    
        throw new java.lang.IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r11.f8741A2egSU.f8955A5SV6n + " returned Transition " + r11.f8743A5SV6n + " which uses a different Transition type than other Fragments.").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
    
        r10 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01cb, code lost:
    
        r15 = r38.f8753A2egSU;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01cd, code lost:
    
        if (r10 != null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01cf, code lost:
    
        r0 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d7, code lost:
    
        if (r0.hasNext() == false) goto L383;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d9, code lost:
    
        r2 = (androidx.fragment.app.AaHO0E) r0.next();
        r7.put(r2.f8741A2egSU, java.lang.Boolean.FALSE);
        r2.A2egSU();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ea, code lost:
    
        r33 = r3;
        r9 = r14;
        r14 = r8;
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0768, code lost:
    
        r6 = r8.containsValue(java.lang.Boolean.TRUE);
        r10 = r15.getContext();
        r11 = new java.util.ArrayList();
        r12 = r33.iterator();
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x077d, code lost:
    
        r1 = "context";
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0783, code lost:
    
        if (r12.hasNext() == false) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0785, code lost:
    
        r5 = (androidx.fragment.app.AZOQYO) r12.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0790, code lost:
    
        if (r5.A4TApA() == false) goto L384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0796, code lost:
    
        RXb0Sz.ARc23Z.ADYaiT(r10, "context");
        r0 = r5.A5SV6n(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x079d, code lost:
    
        if (r0 != null) goto L387;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v8, types: [B25kr6.AzWtSf] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A5SV6n(java.util.ArrayList r39, final boolean r40) {
        /*
            Method dump skipped, instructions count: 2266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.AmA8tU.A5SV6n(java.util.ArrayList, boolean):void");
    }

    public final void ADYaiT() {
        if (this.AMqCpz) {
            return;
        }
        ViewGroup viewGroup = this.f8753A2egSU;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        if (!viewGroup.isAttachedToWindow()) {
            ASJ6gh();
            this.f8756ADYaiT = false;
            return;
        }
        synchronized (this.f8754A4TApA) {
            try {
                if (!this.f8754A4TApA.isEmpty()) {
                    ArrayList AmA8tU2 = RD2OKB.B4ZgIw.AmA8tU(this.f8755A5SV6n);
                    this.f8755A5SV6n.clear();
                    Iterator it = AmA8tU2.iterator();
                    while (it.hasNext()) {
                        DyaChj dyaChj = (DyaChj) it.next();
                        if (CtxOCS.C4FrIb(2)) {
                            Objects.toString(dyaChj);
                        }
                        dyaChj.A2egSU();
                        if (!dyaChj.f8958ASJ6gh) {
                            this.f8755A5SV6n.add(dyaChj);
                        }
                    }
                    AaHO0E();
                    ArrayList AmA8tU3 = RD2OKB.B4ZgIw.AmA8tU(this.f8754A4TApA);
                    this.f8754A4TApA.clear();
                    this.f8755A5SV6n.addAll(AmA8tU3);
                    CtxOCS.C4FrIb(2);
                    Iterator it2 = AmA8tU3.iterator();
                    while (it2.hasNext()) {
                        ((DyaChj) it2.next()).ADYaiT();
                    }
                    A5SV6n(AmA8tU3, this.f8756ADYaiT);
                    this.f8756ADYaiT = false;
                    CtxOCS.C4FrIb(2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final DyaChj ARc23Z(Fragment fragment) {
        Object obj;
        Iterator it = this.f8754A4TApA.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            DyaChj dyaChj = (DyaChj) obj;
            if (RXb0Sz.ARc23Z.A2egSU(dyaChj.f8955A5SV6n, fragment) && !dyaChj.f8957ARc23Z) {
                break;
            }
        }
        return (DyaChj) obj;
    }

    public final void ASJ6gh() {
        CtxOCS.C4FrIb(2);
        ViewGroup viewGroup = this.f8753A2egSU;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f8754A4TApA) {
            try {
                AaHO0E();
                Iterator it = this.f8754A4TApA.iterator();
                while (it.hasNext()) {
                    ((DyaChj) it.next()).ADYaiT();
                }
                Iterator it2 = RD2OKB.B4ZgIw.AmA8tU(this.f8755A5SV6n).iterator();
                while (it2.hasNext()) {
                    DyaChj dyaChj = (DyaChj) it2.next();
                    if (CtxOCS.C4FrIb(2)) {
                        if (!isAttachedToWindow) {
                            Objects.toString(this.f8753A2egSU);
                        }
                        Objects.toString(dyaChj);
                    }
                    dyaChj.A2egSU();
                }
                Iterator it3 = RD2OKB.B4ZgIw.AmA8tU(this.f8754A4TApA).iterator();
                while (it3.hasNext()) {
                    DyaChj dyaChj2 = (DyaChj) it3.next();
                    if (CtxOCS.C4FrIb(2)) {
                        if (!isAttachedToWindow) {
                            Objects.toString(this.f8753A2egSU);
                        }
                        Objects.toString(dyaChj2);
                    }
                    dyaChj2.A2egSU();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AZOQYO() {
        Object obj;
        synchronized (this.f8754A4TApA) {
            try {
                AaHO0E();
                ArrayList arrayList = this.f8754A4TApA;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    DyaChj dyaChj = (DyaChj) obj;
                    View view = dyaChj.f8955A5SV6n.mView;
                    RXb0Sz.ARc23Z.ADYaiT(view, "operation.fragment.mView");
                    char c = 4;
                    if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                        int visibility = view.getVisibility();
                        if (visibility == 0) {
                            c = 2;
                        } else if (visibility != 4) {
                            if (visibility != 8) {
                                throw new IllegalArgumentException("Unknown visibility " + visibility);
                            }
                            c = 3;
                        }
                    }
                    if (dyaChj.f8953A2egSU == 2 && c != 2) {
                        break;
                    }
                }
                DyaChj dyaChj2 = (DyaChj) obj;
                Fragment fragment = dyaChj2 != null ? dyaChj2.f8955A5SV6n : null;
                this.AMqCpz = fragment != null ? fragment.isPostponed() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AaHO0E() {
        Iterator it = this.f8754A4TApA.iterator();
        while (it.hasNext()) {
            DyaChj dyaChj = (DyaChj) it.next();
            int i = 2;
            if (dyaChj.f8954A4TApA == 2) {
                View requireView = dyaChj.f8955A5SV6n.requireView();
                RXb0Sz.ARc23Z.ADYaiT(requireView, "fragment.requireView()");
                int visibility = requireView.getVisibility();
                if (visibility != 0) {
                    i = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(visibility, "Unknown visibility "));
                        }
                        i = 3;
                    }
                }
                dyaChj.A5SV6n(i, 1);
            }
        }
    }
}
