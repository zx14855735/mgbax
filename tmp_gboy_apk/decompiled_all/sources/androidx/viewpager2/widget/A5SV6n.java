package androidx.viewpager2.widget;

import De4eam.AlLFFp;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public A2egSU f9572A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ViewPager2 f9573A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AlLFFp f9574A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final LinearLayoutManager f9575ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f9576ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final De4eam.ADYaiT f9577ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f9578AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f9579AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f9580AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f9581AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f9582AcNBzu;

    public A5SV6n(ViewPager2 viewPager2) {
        this.f9573A4TApA = viewPager2;
        AlLFFp alLFFp = viewPager2.f9594B9tovu;
        this.f9574A5SV6n = alLFFp;
        this.f9575ADYaiT = (LinearLayoutManager) alLFFp.getLayoutManager();
        this.f9577ASJ6gh = new De4eam.ADYaiT();
        A4TApA();
    }

    public final void A2egSU(int i) {
        if ((this.AMqCpz == 3 && this.f9576ARc23Z == 0) || this.f9576ARc23Z == i) {
            return;
        }
        this.f9576ARc23Z = i;
        A2egSU a2egSU = this.f9572A2egSU;
        if (a2egSU != null) {
            a2egSU.A2egSU(i);
        }
    }

    public final void A4TApA() {
        this.AMqCpz = 0;
        this.f9576ARc23Z = 0;
        De4eam.ADYaiT aDYaiT = this.f9577ASJ6gh;
        aDYaiT.f2404A2egSU = -1;
        aDYaiT.f2405A4TApA = 0.0f;
        aDYaiT.f2406A5SV6n = 0;
        this.f9578AYUAbz = -1;
        this.f9579AZOQYO = -1;
        this.f9580AZkASS = false;
        this.f9581AaHO0E = false;
        this.f9582AcNBzu = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0124, code lost:
    
        r1 = r0.getChildCount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0128, code lost:
    
        if (r3 >= r1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0132, code lost:
    
        if (De4eam.A2egSU.A2egSU(r0.getChildAt(r3)) != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0134, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013e, code lost:
    
        throw new java.lang.IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013f, code lost:
    
        r1 = java.util.Locale.US;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014e, code lost:
    
        throw new java.lang.IllegalStateException(ADYaiT.CtFAbx.ARc23Z(r2.f2406A5SV6n, "Page can only be offset by a positive amount, not by "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x011b, code lost:
    
        if (r5[r1 - 1][1] >= r6) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0122, code lost:
    
        if (r0.getChildCount() <= 1) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A5SV6n() {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.A5SV6n.A5SV6n():void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        A2egSU a2egSU;
        A2egSU a2egSU2;
        int i2 = this.AMqCpz;
        boolean z = true;
        if (!(i2 == 1 && this.f9576ARc23Z == 1) && i == 1) {
            this.AMqCpz = 1;
            int i3 = this.f9579AZOQYO;
            if (i3 != -1) {
                this.f9578AYUAbz = i3;
                this.f9579AZOQYO = -1;
            } else if (this.f9578AYUAbz == -1) {
                this.f9578AYUAbz = this.f9575ADYaiT.findFirstVisibleItemPosition();
            }
            A2egSU(1);
            return;
        }
        if ((i2 == 1 || i2 == 4) && i == 2) {
            if (this.f9581AaHO0E) {
                A2egSU(2);
                this.f9580AZkASS = true;
                return;
            }
            return;
        }
        if (i2 != 1 && i2 != 4) {
            z = false;
        }
        De4eam.ADYaiT aDYaiT = this.f9577ASJ6gh;
        if (z && i == 0) {
            A5SV6n();
            if (!this.f9581AaHO0E) {
                int i4 = aDYaiT.f2404A2egSU;
                if (i4 != -1 && (a2egSU2 = this.f9572A2egSU) != null) {
                    a2egSU2.A4TApA(i4, 0.0f, 0);
                }
            } else if (aDYaiT.f2406A5SV6n == 0) {
                int i5 = this.f9578AYUAbz;
                int i6 = aDYaiT.f2404A2egSU;
                if (i5 != i6 && (a2egSU = this.f9572A2egSU) != null) {
                    a2egSU.A5SV6n(i6);
                }
            }
            A2egSU(0);
            A4TApA();
        }
        if (this.AMqCpz == 2 && i == 0 && this.f9582AcNBzu) {
            A5SV6n();
            if (aDYaiT.f2406A5SV6n == 0) {
                int i7 = this.f9579AZOQYO;
                int i8 = aDYaiT.f2404A2egSU;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    A2egSU a2egSU3 = this.f9572A2egSU;
                    if (a2egSU3 != null) {
                        a2egSU3.A5SV6n(i8);
                    }
                }
                A2egSU(0);
                A4TApA();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if ((r7 < 0) == (r5.f9573A4TApA.f9591B3GDIM.getLayoutDirection() == 1)) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f9581AaHO0E = r6
            r5.A5SV6n()
            boolean r0 = r5.f9580AZkASS
            De4eam.ADYaiT r1 = r5.f9577ASJ6gh
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L40
            r5.f9580AZkASS = r3
            if (r8 > 0) goto L28
            if (r8 != 0) goto L30
            if (r7 >= 0) goto L18
            r7 = 1
            goto L19
        L18:
            r7 = 0
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f9573A4TApA
            De4eam.AZOQYO r8 = r8.f9591B3GDIM
            int r8 = r8.getLayoutDirection()
            if (r8 != r6) goto L25
            r8 = 1
            goto L26
        L25:
            r8 = 0
        L26:
            if (r7 != r8) goto L30
        L28:
            int r7 = r1.f2406A5SV6n
            if (r7 == 0) goto L30
            int r7 = r1.f2404A2egSU
            int r7 = r7 + r6
            goto L32
        L30:
            int r7 = r1.f2404A2egSU
        L32:
            r5.f9579AZOQYO = r7
            int r8 = r5.f9578AYUAbz
            if (r8 == r7) goto L50
            androidx.viewpager2.widget.A2egSU r8 = r5.f9572A2egSU
            if (r8 == 0) goto L50
            r8.A5SV6n(r7)
            goto L50
        L40:
            int r7 = r5.AMqCpz
            if (r7 != 0) goto L50
            int r7 = r1.f2404A2egSU
            if (r7 != r2) goto L49
            r7 = 0
        L49:
            androidx.viewpager2.widget.A2egSU r8 = r5.f9572A2egSU
            if (r8 == 0) goto L50
            r8.A5SV6n(r7)
        L50:
            int r7 = r1.f2404A2egSU
            if (r7 != r2) goto L55
            r7 = 0
        L55:
            float r8 = r1.f2405A4TApA
            int r0 = r1.f2406A5SV6n
            androidx.viewpager2.widget.A2egSU r4 = r5.f9572A2egSU
            if (r4 == 0) goto L60
            r4.A4TApA(r7, r8, r0)
        L60:
            int r7 = r1.f2404A2egSU
            int r8 = r5.f9579AZOQYO
            if (r7 == r8) goto L68
            if (r8 != r2) goto L76
        L68:
            int r7 = r1.f2406A5SV6n
            if (r7 != 0) goto L76
            int r7 = r5.f9576ARc23Z
            if (r7 == r6) goto L76
            r5.A2egSU(r3)
            r5.A4TApA()
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.A5SV6n.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
