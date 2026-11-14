package com.octopus.ad.utils;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {

    public interface a {
        void a(Bitmap bitmap);
    }

    public static void a(final Context context, final Bitmap bitmap, final a aVar) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.octopus.ad.utils.d.1
            /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[Catch: Exception -> 0x0048, TRY_ENTER, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0099 A[Catch: Exception -> 0x0048, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x009e A[Catch: Exception -> 0x0048, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00a3 A[Catch: Exception -> 0x0048, TRY_LEAVE, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0078 A[Catch: Exception -> 0x0048, TRY_ENTER, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x007d A[Catch: Exception -> 0x0048, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0082 A[Catch: Exception -> 0x0048, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0087 A[Catch: Exception -> 0x0048, TRY_LEAVE, TryCatch #8 {Exception -> 0x0048, blocks: (B:17:0x0044, B:19:0x004c, B:20:0x004f, B:40:0x0078, B:42:0x007d, B:44:0x0082, B:46:0x0087, B:27:0x0094, B:29:0x0099, B:31:0x009e, B:33:0x00a3), top: B:2:0x0005 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r9 = this;
                    java.lang.String r0 = "An Exception Caught"
                    java.lang.String r1 = "OctopusAd"
                    r2 = 0
                    android.graphics.Bitmap r3 = r1     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    int r3 = r3.getWidth()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    android.graphics.Bitmap r4 = r1     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    int r4 = r4.getHeight()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    android.content.Context r4 = r2     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    android.renderscript.RenderScript r4 = android.renderscript.RenderScript.create(r4)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
                    android.renderscript.Element r5 = android.renderscript.Element.U8_4(r4)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
                    android.renderscript.ScriptIntrinsicBlur r5 = android.renderscript.ScriptIntrinsicBlur.create(r4, r5)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
                    android.graphics.Bitmap r6 = r1     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
                    android.renderscript.Allocation r6 = android.renderscript.Allocation.createFromBitmap(r4, r6)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L62
                    android.renderscript.Allocation r7 = android.renderscript.Allocation.createFromBitmap(r4, r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
                    r8 = 1101004800(0x41a00000, float:20.0)
                    r5.setRadius(r8)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L8d
                    r5.setInput(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L8d
                    r5.forEach(r7)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L8d
                    r7.copyTo(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L8d
                    com.octopus.ad.utils.d$a r8 = r3     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L8d
                    r8.a(r3)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L8d
                    if (r4 == 0) goto L4a
                    r4.destroy()     // Catch: java.lang.Exception -> L48
                    goto L4a
                L48:
                    r2 = move-exception
                    goto L56
                L4a:
                    if (r6 == 0) goto L4f
                    r6.destroy()     // Catch: java.lang.Exception -> L48
                L4f:
                    r7.destroy()     // Catch: java.lang.Exception -> L48
                    r5.destroy()     // Catch: java.lang.Exception -> L48
                    return
                L56:
                    com.octopus.ad.utils.b.f.a(r1, r0, r2)
                    goto La6
                L5b:
                    r7 = r2
                    goto L71
                L5d:
                    r7 = r2
                    goto L8d
                L5f:
                    r6 = r2
                L60:
                    r7 = r6
                    goto L71
                L62:
                    r6 = r2
                L63:
                    r7 = r6
                    goto L8d
                L65:
                    r5 = r2
                L66:
                    r6 = r5
                    goto L60
                L68:
                    r5 = r2
                L69:
                    r6 = r5
                    goto L63
                L6b:
                    r4 = r2
                    r5 = r4
                    goto L66
                L6e:
                    r4 = r2
                    r5 = r4
                    goto L69
                L71:
                    com.octopus.ad.utils.d$a r3 = r3     // Catch: java.lang.Throwable -> L8b
                    r3.a(r2)     // Catch: java.lang.Throwable -> L8b
                    if (r4 == 0) goto L7b
                    r4.destroy()     // Catch: java.lang.Exception -> L48
                L7b:
                    if (r6 == 0) goto L80
                    r6.destroy()     // Catch: java.lang.Exception -> L48
                L80:
                    if (r7 == 0) goto L85
                    r7.destroy()     // Catch: java.lang.Exception -> L48
                L85:
                    if (r5 == 0) goto La6
                    r5.destroy()     // Catch: java.lang.Exception -> L48
                    goto La6
                L8b:
                    r2 = move-exception
                    goto La7
                L8d:
                    com.octopus.ad.utils.d$a r3 = r3     // Catch: java.lang.Throwable -> L8b
                    r3.a(r2)     // Catch: java.lang.Throwable -> L8b
                    if (r4 == 0) goto L97
                    r4.destroy()     // Catch: java.lang.Exception -> L48
                L97:
                    if (r6 == 0) goto L9c
                    r6.destroy()     // Catch: java.lang.Exception -> L48
                L9c:
                    if (r7 == 0) goto La1
                    r7.destroy()     // Catch: java.lang.Exception -> L48
                La1:
                    if (r5 == 0) goto La6
                    r5.destroy()     // Catch: java.lang.Exception -> L48
                La6:
                    return
                La7:
                    if (r4 == 0) goto Laf
                    r4.destroy()     // Catch: java.lang.Exception -> Lad
                    goto Laf
                Lad:
                    r3 = move-exception
                    goto Lbf
                Laf:
                    if (r6 == 0) goto Lb4
                    r6.destroy()     // Catch: java.lang.Exception -> Lad
                Lb4:
                    if (r7 == 0) goto Lb9
                    r7.destroy()     // Catch: java.lang.Exception -> Lad
                Lb9:
                    if (r5 == 0) goto Lc2
                    r5.destroy()     // Catch: java.lang.Exception -> Lad
                    goto Lc2
                Lbf:
                    com.octopus.ad.utils.b.f.a(r1, r0, r3)
                Lc2:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.utils.d.AnonymousClass1.run():void");
            }
        });
    }
}
