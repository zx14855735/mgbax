package PCV8se;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CASmeH {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f7159A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public NGepWW.A2egSU f7160A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int[][] f7161A5SV6n = new int[10][];

    /* renamed from: ADYaiT, reason: collision with root package name */
    public NGepWW.A2egSU[] f7162ADYaiT = new NGepWW.A2egSU[10];

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU(android.content.Context r12, android.content.res.XmlResourceParser r13, android.util.AttributeSet r14, android.content.res.Resources.Theme r15) {
        /*
            r11 = this;
            int r0 = r13.getDepth()
            r1 = 1
            int r0 = r0 + r1
        L6:
            int r2 = r13.next()
            if (r2 == r1) goto Lca
            int r3 = r13.getDepth()
            if (r3 >= r0) goto L15
            r4 = 3
            if (r2 == r4) goto Lca
        L15:
            r4 = 2
            if (r2 != r4) goto L6
            if (r3 > r0) goto L6
            java.lang.String r2 = r13.getName()
            java.lang.String r3 = "item"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L27
            goto L6
        L27:
            android.content.res.Resources r2 = r12.getResources()
            int[] r3 = com.google.android.material.R$styleable.f11260D6DOie
            r5 = 0
            if (r15 != 0) goto L35
            android.content.res.TypedArray r2 = r2.obtainAttributes(r14, r3)
            goto L39
        L35:
            android.content.res.TypedArray r2 = r15.obtainStyledAttributes(r14, r3, r5, r5)
        L39:
            android.util.TypedValue r3 = r2.peekValue(r5)
            if (r3 != 0) goto L40
            goto L69
        L40:
            int r6 = r3.type
            r7 = 5
            if (r6 != r7) goto L5a
            PCV8se.C4FrIb r6 = new PCV8se.C4FrIb
            int r3 = r3.data
            android.content.res.Resources r7 = r2.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r3 = android.util.TypedValue.complexToDimensionPixelSize(r3, r7)
            float r3 = (float) r3
            r6.<init>(r4, r3)
            goto L6a
        L5a:
            r4 = 6
            if (r6 != r4) goto L69
            PCV8se.C4FrIb r6 = new PCV8se.C4FrIb
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3.getFraction(r4, r4)
            r6.<init>(r1, r3)
            goto L6a
        L69:
            r6 = 0
        L6a:
            r2.recycle()
            int r2 = r14.getAttributeCount()
            int[] r3 = new int[r2]
            r4 = 0
            r7 = 0
        L75:
            if (r4 >= r2) goto L90
            int r8 = r14.getAttributeNameResource(r4)
            r9 = 2130970202(0x7f04065a, float:1.7549107E38)
            if (r8 == r9) goto L8d
            int r9 = r7 + 1
            boolean r10 = r14.getAttributeBooleanValue(r4, r5)
            if (r10 == 0) goto L89
            goto L8a
        L89:
            int r8 = -r8
        L8a:
            r3[r7] = r8
            r7 = r9
        L8d:
            int r4 = r4 + 1
            goto L75
        L90:
            int[] r2 = android.util.StateSet.trimStateSet(r3, r7)
            NGepWW.A2egSU r3 = new NGepWW.A2egSU
            r3.<init>()
            r3.f5658AlLFFp = r6
            int r4 = r11.f7159A2egSU
            if (r4 == 0) goto La2
            int r6 = r2.length
            if (r6 != 0) goto La4
        La2:
            r11.f7160A4TApA = r3
        La4:
            int[][] r6 = r11.f7161A5SV6n
            int r7 = r6.length
            if (r4 < r7) goto Lbb
            int r7 = r4 + 10
            int[][] r8 = new int[r7][]
            java.lang.System.arraycopy(r6, r5, r8, r5, r4)
            r11.f7161A5SV6n = r8
            NGepWW.A2egSU[] r6 = new NGepWW.A2egSU[r7]
            NGepWW.A2egSU[] r7 = r11.f7162ADYaiT
            java.lang.System.arraycopy(r7, r5, r6, r5, r4)
            r11.f7162ADYaiT = r6
        Lbb:
            int[][] r4 = r11.f7161A5SV6n
            int r5 = r11.f7159A2egSU
            r4[r5] = r2
            NGepWW.A2egSU[] r2 = r11.f7162ADYaiT
            r2[r5] = r3
            int r5 = r5 + r1
            r11.f7159A2egSU = r5
            goto L6
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: PCV8se.CASmeH.A2egSU(android.content.Context, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }
}
