package com.octopus.ad.internal;

import com.octopus.ad.internal.utilities.SPUtils;
import com.octopus.ad.utils.ThreadUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o {
    private static boolean a() {
        return SPUtils.getBoolean(q.a().j(), "logReportFlag", true);
    }

    public static void a(final l lVar) {
        if (a()) {
            ThreadUtils.runOnLogThreadPool(new Runnable() { // from class: com.octopus.ad.internal.o.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x007f A[Catch: Exception -> 0x0069, TryCatch #0 {Exception -> 0x0069, blocks: (B:3:0x0002, B:5:0x000c, B:10:0x0012, B:12:0x0023, B:15:0x0030, B:18:0x0037, B:20:0x0055, B:22:0x005d, B:23:0x0077, B:25:0x007f, B:26:0x008a, B:28:0x0092, B:30:0x00a5, B:32:0x00ab, B:34:0x00b1, B:36:0x00b9, B:38:0x00cc, B:40:0x00d8, B:41:0x00e3, B:43:0x015c, B:46:0x0163, B:47:0x0191, B:50:0x017d, B:53:0x018d, B:54:0x00c1, B:55:0x009a, B:56:0x006c), top: B:2:0x0002 }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00d8 A[Catch: Exception -> 0x0069, TryCatch #0 {Exception -> 0x0069, blocks: (B:3:0x0002, B:5:0x000c, B:10:0x0012, B:12:0x0023, B:15:0x0030, B:18:0x0037, B:20:0x0055, B:22:0x005d, B:23:0x0077, B:25:0x007f, B:26:0x008a, B:28:0x0092, B:30:0x00a5, B:32:0x00ab, B:34:0x00b1, B:36:0x00b9, B:38:0x00cc, B:40:0x00d8, B:41:0x00e3, B:43:0x015c, B:46:0x0163, B:47:0x0191, B:50:0x017d, B:53:0x018d, B:54:0x00c1, B:55:0x009a, B:56:0x006c), top: B:2:0x0002 }] */
                /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 413
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.o.AnonymousClass1.run():void");
                }
            });
        }
    }
}
