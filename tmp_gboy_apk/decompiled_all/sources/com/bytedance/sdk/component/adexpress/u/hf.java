package com.bytedance.sdk.component.adexpress.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a9 A[DONT_GENERATE] */
    @com.bytedance.component.sdk.annotation.RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap xj(android.content.Context r5, android.graphics.Bitmap r6, int r7) {
        /*
            r0 = 0
            boolean r1 = com.bytedance.sdk.component.adexpress.u.xj()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L15
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Le
            r2 = 26
            if (r1 >= r2) goto L15
            return r0
        Le:
            r5 = move-exception
            r6 = r0
            r7 = r6
        L11:
            r2 = r7
            r3 = r2
            goto L95
        L15:
            if (r6 == 0) goto L94
            boolean r1 = r6.isRecycled()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L1f
            goto L94
        L1f:
            int r1 = r6.getWidth()     // Catch: java.lang.Throwable -> Le
            float r1 = (float) r1     // Catch: java.lang.Throwable -> Le
            r2 = 1045220557(0x3e4ccccd, float:0.2)
            float r1 = r1 * r2
            int r1 = java.lang.Math.round(r1)     // Catch: java.lang.Throwable -> Le
            int r3 = r6.getHeight()     // Catch: java.lang.Throwable -> Le
            float r3 = (float) r3     // Catch: java.lang.Throwable -> Le
            float r3 = r3 * r2
            int r2 = java.lang.Math.round(r3)     // Catch: java.lang.Throwable -> Le
            r3 = 0
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r1, r2, r3)     // Catch: java.lang.Throwable -> Le
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r6)     // Catch: java.lang.Throwable -> Le
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r5)     // Catch: java.lang.Throwable -> Le
            if (r5 != 0) goto L4d
            if (r5 == 0) goto L4c
            r5.destroy()
        L4c:
            return r0
        L4d:
            android.renderscript.Element r2 = android.renderscript.Element.U8_4(r5)     // Catch: java.lang.Throwable -> L8d
            android.renderscript.ScriptIntrinsicBlur r2 = android.renderscript.ScriptIntrinsicBlur.create(r5, r2)     // Catch: java.lang.Throwable -> L8d
            android.renderscript.Allocation r6 = android.renderscript.Allocation.createFromBitmap(r5, r6)     // Catch: java.lang.Throwable -> L86
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r5, r1)     // Catch: java.lang.Throwable -> L7f
            float r7 = (float) r7
            r2.setRadius(r7)     // Catch: java.lang.Throwable -> L79
            r2.setInput(r6)     // Catch: java.lang.Throwable -> L79
            r2.forEach(r3)     // Catch: java.lang.Throwable -> L79
            r3.copyTo(r1)     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L6f
            r6.destroy()
        L6f:
            r3.destroy()
            r2.destroy()
            r5.destroy()
            return r1
        L79:
            r7 = move-exception
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L95
        L7f:
            r7 = move-exception
            r3 = r6
            r6 = r5
            r5 = r7
            r7 = r3
            r3 = r0
            goto L95
        L86:
            r6 = move-exception
            r7 = r6
            r6 = r5
            r5 = r7
            r7 = r0
            r3 = r7
            goto L95
        L8d:
            r6 = move-exception
            r7 = r6
            r6 = r5
            r5 = r7
            r7 = r0
            goto L11
        L94:
            return r0
        L95:
            com.bytedance.sdk.component.utils.pl.xj(r5)     // Catch: java.lang.Throwable -> Lad
            if (r7 == 0) goto L9d
            r7.destroy()
        L9d:
            if (r3 == 0) goto La2
            r3.destroy()
        La2:
            if (r2 == 0) goto La7
            r2.destroy()
        La7:
            if (r6 == 0) goto Lac
            r6.destroy()
        Lac:
            return r0
        Lad:
            r5 = move-exception
            if (r7 == 0) goto Lb3
            r7.destroy()
        Lb3:
            if (r3 == 0) goto Lb8
            r3.destroy()
        Lb8:
            if (r2 == 0) goto Lbd
            r2.destroy()
        Lbd:
            if (r6 == 0) goto Lc2
            r6.destroy()
        Lc2:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.u.hf.xj(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
