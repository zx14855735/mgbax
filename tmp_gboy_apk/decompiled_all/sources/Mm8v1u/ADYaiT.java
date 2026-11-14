package Mm8v1u;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f5464A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final RectF f5465A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f5466A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f5467ADYaiT;
    public Bitmap AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public Bitmap f5468ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Bitmap[] f5469ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f5470AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final Bitmap f5471AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final HashMap f5472AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final Paint f5473AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ARc23Z f5474AcNBzu;

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(4:3|(1:35)|7|(5:9|(1:11)|12|13|14)(8:16|(1:18)(1:34)|19|(1:33)|23|(1:25)|26|(2:31|32)(1:30)))|36|(2:37|(1:50)(1:41))|42|43|44|(1:46)|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cd, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ADYaiT(android.content.Context r11, java.lang.String r12, android.graphics.RectF r13, Mm8v1u.ARc23Z r14) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Mm8v1u.ADYaiT.<init>(android.content.Context, java.lang.String, android.graphics.RectF, Mm8v1u.ARc23Z):void");
    }

    public static boolean A4TApA(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:6:0x000b, B:8:0x0010, B:10:0x0014, B:12:0x0018, B:14:0x001b, B:17:0x003d, B:19:0x0043, B:20:0x0045, B:25:0x004c, B:29:0x0024, B:31:0x0028, B:33:0x0030, B:34:0x0035, B:37:0x0033), top: B:5:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:6:0x000b, B:8:0x0010, B:10:0x0014, B:12:0x0018, B:14:0x001b, B:17:0x003d, B:19:0x0043, B:20:0x0045, B:25:0x004c, B:29:0x0024, B:31:0x0028, B:33:0x0030, B:34:0x0035, B:37:0x0033), top: B:5:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU(android.graphics.Canvas r6) {
        /*
            r5 = this;
            android.graphics.RectF r0 = r5.f5465A4TApA
            if (r0 == 0) goto L51
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Lb
            goto L51
        Lb:
            boolean r1 = r5.f5467ADYaiT     // Catch: java.lang.Throwable -> L51
            r2 = 0
            if (r1 == 0) goto L24
            android.graphics.Bitmap[] r1 = r5.f5469ASJ6gh     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L3c
            int r3 = r5.f5470AYUAbz     // Catch: java.lang.Throwable -> L51
            if (r3 < 0) goto L3c
            int r4 = r1.length     // Catch: java.lang.Throwable -> L51
            if (r3 >= r4) goto L3c
            r1 = r1[r3]     // Catch: java.lang.Throwable -> L51
            boolean r3 = A4TApA(r1)     // Catch: java.lang.Throwable -> L51
            if (r3 == 0) goto L3c
            goto L3d
        L24:
            boolean r1 = r5.f5466A5SV6n     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L33
            android.graphics.Bitmap r1 = r5.f5468ARc23Z     // Catch: java.lang.Throwable -> L51
            boolean r1 = A4TApA(r1)     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L33
            android.graphics.Bitmap r1 = r5.f5468ARc23Z     // Catch: java.lang.Throwable -> L51
            goto L35
        L33:
            android.graphics.Bitmap r1 = r5.AMqCpz     // Catch: java.lang.Throwable -> L51
        L35:
            boolean r3 = A4TApA(r1)     // Catch: java.lang.Throwable -> L51
            if (r3 == 0) goto L3c
            goto L3d
        L3c:
            r1 = r2
        L3d:
            boolean r3 = A4TApA(r1)     // Catch: java.lang.Throwable -> L51
            if (r3 != 0) goto L45
            android.graphics.Bitmap r1 = r5.f5471AZOQYO     // Catch: java.lang.Throwable -> L51
        L45:
            boolean r3 = A4TApA(r1)     // Catch: java.lang.Throwable -> L51
            if (r3 != 0) goto L4c
            goto L51
        L4c:
            android.graphics.Paint r3 = r5.f5473AaHO0E     // Catch: java.lang.Throwable -> L51
            r6.drawBitmap(r1, r2, r0, r3)     // Catch: java.lang.Throwable -> L51
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Mm8v1u.ADYaiT.A2egSU(android.graphics.Canvas):void");
    }
}
