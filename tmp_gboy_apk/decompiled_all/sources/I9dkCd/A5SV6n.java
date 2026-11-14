package I9dkCd;

import HSHyT0.AmA8tU;
import HSHyT0.B25kr6;
import HXc4pW.BTvldC;
import I3HV03.ARc23Z;
import android.content.Context;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3880A2egSU = 1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f3881A4TApA;

    public A5SV6n(HZUvgL.ADYaiT aDYaiT) {
        this.f3881A4TApA = aDYaiT;
    }

    @Override // HSHyT0.B25kr6
    public final BTvldC A2egSU(Object obj, int i, int i2, AmA8tU amA8tU) {
        switch (this.f3880A2egSU) {
            case 0:
                return A5SV6n((Uri) obj);
            default:
                return ARc23Z.A5SV6n((HZUvgL.ADYaiT) this.f3881A4TApA, ((HPJABZ.ADYaiT) obj).A4TApA());
        }
    }

    @Override // HSHyT0.B25kr6
    public final boolean A4TApA(Object obj, AmA8tU amA8tU) {
        switch (this.f3880A2egSU) {
            case 0:
                return ((Uri) obj).getScheme().equals("android.resource");
            default:
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HXc4pW.BTvldC A5SV6n(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getAuthority()
            java.lang.Object r1 = r7.f3881A4TApA
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r2 = r1.getPackageName()
            boolean r2 = r0.equals(r2)
            r3 = 0
            if (r2 == 0) goto L15
        L13:
            r0 = r1
            goto L26
        L15:
            android.content.Context r0 = r1.createPackageContext(r0, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1a
            goto L26
        L1a:
            r2 = move-exception
            java.lang.String r4 = r1.getPackageName()
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto Lba
            goto L13
        L26:
            java.util.List r2 = r8.getPathSegments()
            int r4 = r2.size()
            r5 = 2
            r6 = 1
            if (r4 != r5) goto L71
            java.util.List r2 = r8.getPathSegments()
            java.lang.String r4 = r8.getAuthority()
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            android.content.res.Resources r5 = r0.getResources()
            int r4 = r5.getIdentifier(r2, r3, r4)
            if (r4 != 0) goto L5a
            android.content.res.Resources r4 = android.content.res.Resources.getSystem()
            java.lang.String r5 = "android"
            int r4 = r4.getIdentifier(r2, r3, r5)
        L5a:
            if (r4 == 0) goto L5d
            goto L87
        L5d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find resource id for: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L71:
            int r2 = r2.size()
            java.lang.String r4 = "Unrecognized Uri format: "
            if (r2 != r6) goto La8
            java.util.List r2 = r8.getPathSegments()
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.NumberFormatException -> L95
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.NumberFormatException -> L95
            int r4 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L95
        L87:
            r8 = 0
            android.graphics.drawable.Drawable r0 = NOd7IU.AlLFFp.CSDoyG(r1, r0, r4, r8)
            if (r0 == 0) goto L94
            I9dkCd.A4TApA r8 = new I9dkCd.A4TApA
            r1 = 0
            r8.<init>(r0, r1)
        L94:
            return r8
        L95:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8, r0)
            throw r1
        La8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        Lba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to obtain context or unrecognized Uri format for: "
            r1.<init>(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I9dkCd.A5SV6n.A5SV6n(android.net.Uri):HXc4pW.BTvldC");
    }

    public A5SV6n(Context context) {
        this.f3881A4TApA = context.getApplicationContext();
    }
}
