package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.l;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, com.sigmob.sdk.downloader.f> f13147a = new HashMap<>();

    /* renamed from: com.sigmob.sdk.base.common.o$2, reason: invalid class name */
    public class AnonymousClass2 extends com.sigmob.sdk.downloader.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f13149a;
        final /* synthetic */ String b;
        final /* synthetic */ List c;
        private l.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, Context context2, String str, List list) {
            super(context);
            this.f13149a = context2;
            this.b = str;
            this.c = list;
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void a(final com.sigmob.sdk.downloader.f fVar) {
            this.e = l.a.COMPLETED;
            super.a(fVar);
            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.o.2.1
                @Override // java.lang.Runnable
                public void run() {
                    q.a(AnonymousClass2.this.f13149a, fVar.n().getAbsolutePath(), (BaseAdUnit) null);
                }
            });
            ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, (BaseAdUnit) null, new AaHO0E(this.b, 7));
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void b(com.sigmob.sdk.downloader.f fVar) {
            this.e = l.a.RUNNING;
            super.b(fVar);
            ae.a(PointCategory.APKDOWNLOAD, "start", (BaseAdUnit) null, new AaHO0E(this.b, 8));
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void c(com.sigmob.sdk.downloader.f fVar) {
            l.a aVar = this.e;
            l.a aVar2 = l.a.CANCELED;
            if (aVar == aVar2) {
                return;
            }
            this.e = aVar2;
            super.c(fVar);
            ae.a(PointCategory.APKDOWNLOAD, com.sigmob.sdk.base.common.a.j, (BaseAdUnit) null, new AaHO0E(this.b, 6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put("status", String.valueOf(1));
                options.put("url", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put("status", String.valueOf(1));
                options.put("url", str);
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0455a
        public void a(com.sigmob.sdk.downloader.f fVar, int i, long j, long j2) {
            super.a(fVar, i, j, j2);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0455a
        public void a(com.sigmob.sdk.downloader.f fVar, long j, long j2) {
            this.e = l.a.RUNNING;
            super.a(fVar, j, j2);
            List<com.sigmob.sdk.videoAd.d> a2 = com.sigmob.sdk.videoAd.d.a(this.c, com.sigmob.sdk.base.common.a.l, j, j2);
            if (com.sigmob.sdk.base.utils.e.a(a2)) {
                return;
            }
            for (com.sigmob.sdk.videoAd.d dVar : a2) {
                dVar.setTracked();
                ae.a(PointCategory.APKDOWNLOAD, PointCategory.PROGRESS, (BaseAdUnit) null, new AmA8tU(this.b, dVar));
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void a(com.sigmob.sdk.downloader.f fVar, Exception exc) {
            this.e = l.a.UNKNOWN;
            super.a(fVar, exc);
            if (fVar.C()) {
                return;
            }
            ak.a(this.f13149a, "下载失败，" + exc.getMessage(), 1).show();
            ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, (BaseAdUnit) null, new AmA8tU(exc, this.b, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Exception exc, String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put("status", String.valueOf(0));
                options.put("error", exc.getMessage());
                options.put("url", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, com.sigmob.sdk.videoAd.d dVar, Object obj) {
            int i;
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put("url", str);
                String event = dVar.getEvent();
                event.getClass();
                switch (event) {
                    case "download_quarter":
                        i = 25;
                        break;
                    case "download_three_quarter":
                        i = 75;
                        break;
                    case "download_two_quarter":
                        i = 50;
                        break;
                    default:
                        return;
                }
                options.put("status", String.valueOf(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put("status", String.valueOf(1));
                options.put("url", str);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.o$3, reason: invalid class name */
    public class AnonymousClass3 extends com.sigmob.sdk.downloader.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseAdUnit f13151a;
        final /* synthetic */ Context b;
        private l.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, BaseAdUnit baseAdUnit, Context context2) {
            super(context);
            this.f13151a = baseAdUnit;
            this.b = context2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Context context, com.sigmob.sdk.downloader.f fVar, BaseAdUnit baseAdUnit) {
            q.a(context, fVar.n().getAbsolutePath(), baseAdUnit);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void b(com.sigmob.sdk.downloader.f fVar) {
            this.c = l.a.RUNNING;
            super.b(fVar);
            ae.a(PointCategory.APKDOWNLOAD, "start", this.f13151a, new B25kr6(1));
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void c(com.sigmob.sdk.downloader.f fVar) {
            l.a aVar = this.c;
            l.a aVar2 = l.a.CANCELED;
            if (aVar == aVar2) {
                return;
            }
            this.c = aVar2;
            super.c(fVar);
            ae.a(PointCategory.APKDOWNLOAD, com.sigmob.sdk.base.common.a.j, this.f13151a, new B25kr6(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void a(com.sigmob.sdk.downloader.f fVar) {
            this.c = l.a.COMPLETED;
            super.a(fVar);
            this.f13151a.enableUseDownloadApk(true);
            if (this.f13151a.isRecord()) {
                ae.b(PointCategory.DOWNLOAD_END, "1", this.f13151a);
                com.sigmob.sdk.base.network.g.a(this.f13151a, com.sigmob.sdk.base.common.a.D);
            }
            WindAds.sharedAds().getHandler().post(new AzWtSf(this.b, fVar, this.f13151a, 0));
            ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, this.f13151a, new B25kr6(0));
            HashMap hashMap = new HashMap();
            hashMap.put("result", "1");
            hashMap.put("downloadId", this.f13151a.getDownloadId());
            BaseBroadcastReceiver.a(this.b, this.f13151a.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0455a
        public void a(com.sigmob.sdk.downloader.f fVar, int i, long j, long j2) {
            super.a(fVar, i, j, j2);
            HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", "1");
            BI9f7h2.put("downloadId", this.f13151a.getDownloadId());
            BaseBroadcastReceiver.a(this.b, this.f13151a.getUuid(), BI9f7h2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0455a
        public void a(com.sigmob.sdk.downloader.f fVar, long j, long j2) {
            this.c = l.a.RUNNING;
            super.a(fVar, j, j2);
            List<com.sigmob.sdk.videoAd.d> a2 = com.sigmob.sdk.videoAd.d.a(this.f13151a.getDownloadQuarterTrack(), com.sigmob.sdk.base.common.a.l, j, j2);
            if (com.sigmob.sdk.base.utils.e.a(a2)) {
                return;
            }
            for (com.sigmob.sdk.videoAd.d dVar : a2) {
                dVar.setTracked();
                ae.a(PointCategory.APKDOWNLOAD, PointCategory.PROGRESS, this.f13151a, new ADYaiT(1, dVar));
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void a(com.sigmob.sdk.downloader.f fVar, Exception exc) {
            this.c = l.a.UNKNOWN;
            super.a(fVar, exc);
            if (fVar.C()) {
                return;
            }
            ak.a(this.b, "下载失败，" + exc.getMessage(), 1).show();
            if (this.f13151a.isRecord()) {
                ae.b(PointCategory.DOWNLOAD_END, Constants.FAIL, this.f13151a);
            }
            ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, this.f13151a, new ADYaiT(2, exc));
            HashMap hashMap = new HashMap();
            hashMap.put("result", Constants.FAIL);
            hashMap.put("downloadId", this.f13151a.getDownloadId());
            BaseBroadcastReceiver.a(this.b, this.f13151a.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.sigmob.sdk.videoAd.d dVar, Object obj) {
            int i;
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                String event = dVar.getEvent();
                event.getClass();
                switch (event) {
                    case "download_quarter":
                        i = 25;
                        break;
                    case "download_three_quarter":
                        i = 75;
                        break;
                    case "download_two_quarter":
                        i = 50;
                        break;
                    default:
                        return;
                }
                options.put("status", String.valueOf(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Exception exc, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put("status", String.valueOf(0));
                options.put("error", exc.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.o$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13152a;

        static {
            int[] iArr = new int[l.a.values().length];
            f13152a = iArr;
            try {
                iArr[l.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13152a[l.a.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13152a[l.a.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13152a[l.a.CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        static final String f13153a = "downloadButtonAction";
        static final String b = "downloadAction";
        private final com.sigmob.sdk.downloader.f c;
        private final BaseAdUnit d;
        private final String e;

        public a(com.sigmob.sdk.downloader.f fVar, String str, BaseAdUnit baseAdUnit) {
            this.c = fVar;
            this.e = str;
            this.d = baseAdUnit;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.c == null || com.sigmob.sdk.base.utils.o.a((CharSequence) this.e)) {
                return;
            }
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) intent.getAction(), (CharSequence) this.e)) {
                if (com.sigmob.sdk.downloader.l.c(this.c)) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.o.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            q.a(com.sigmob.sdk.b.e(), a.this.c.n().getAbsolutePath(), a.this.d);
                        }
                    });
                }
            } else {
                if (!com.sigmob.sdk.downloader.l.a(this.c)) {
                    this.c.B();
                    return;
                }
                if (this.d != null) {
                    HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", "1");
                    BI9f7h2.put("downloadId", this.d.getDownloadId());
                    BaseBroadcastReceiver.a(context, this.d.getUuid(), BI9f7h2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
                }
                Handler handler = WindAds.sharedAds().getHandler();
                com.sigmob.sdk.downloader.f fVar = this.c;
                Objects.requireNonNull(fVar);
                handler.postDelayed(new A2egSU(1, fVar), 200L);
            }
        }
    }

    static {
        NMlVl();
    }

    private static /* synthetic */ void NMlVl() {
        char[] charArray = "\u0087\u008b\u0089Ê\u0083\u0085\u0089\u0081Ê\u0086\u008b\u009dÊ\u0097\u008c\u0081\u0088\u0088Ê®\u008a\u008d¦\u0096\u008d\u0080\u0083\u0081".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 228);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0087\u0088\u008d\u008a\u008d\u0090".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 228);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int a(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null || !com.sigmob.sdk.downloader.l.a(downloadTask)) {
            return -1;
        }
        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", "1");
        BI9f7h2.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), BI9f7h2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
        WindAds.sharedAds().getHandler().postDelayed(new A2egSU(1, downloadTask), 200L);
        return 0;
    }

    public static int b(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        boolean a2 = com.sigmob.sdk.downloader.l.a(downloadTask);
        if (downloadTask == null || a2) {
            return -1;
        }
        downloadTask.B();
        return 0;
    }

    public static int c(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null) {
            return -1;
        }
        downloadTask.a((com.sigmob.sdk.downloader.c) null);
        downloadTask.E();
        com.sigmob.sdk.downloader.g.j().c().b(downloadTask.c());
        File m = downloadTask.m();
        if (m != null && m.exists()) {
            m.delete();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(downloadTask.c());
        }
        File n = downloadTask.n();
        if (n != null && n.exists()) {
            n.delete();
        }
        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", Constants.FAIL);
        BI9f7h2.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), BI9f7h2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        baseAdUnit.setDownloadId(null);
        baseAdUnit.setDownloadTask(null);
        if (baseAdUnit.isRecord()) {
            ae.b(PointCategory.DOWNLOAD_END, Constants.FAIL, baseAdUnit);
        }
        ae.a(PointCategory.APKDOWNLOAD, PointCategory.END, baseAdUnit, new B25kr6(4));
        return 0;
    }

    public static long[] d(Context context, BaseAdUnit baseAdUnit) {
        l.a b;
        long[] jArr = {-1, -1, 0};
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null) {
            return jArr;
        }
        com.sigmob.sdk.downloader.core.breakpoint.c y = downloadTask.y();
        if (y == null) {
            b = com.sigmob.sdk.downloader.l.a(baseAdUnit.getDownloadUrl(), com.sigmob.sdk.base.utils.k.a(context).getAbsolutePath(), baseAdUnit.getApkName());
        } else {
            jArr[0] = y.i();
            jArr[1] = y.j();
            b = com.sigmob.sdk.downloader.l.b(downloadTask);
        }
        int i = AnonymousClass4.f13152a[b.ordinal()];
        if (i == 1) {
            jArr[2] = 2;
            return jArr;
        }
        if (i == 2) {
            jArr[2] = 8;
            return jArr;
        }
        if (i == 3) {
            jArr[2] = 1;
            return jArr;
        }
        if (i != 4) {
            jArr[2] = 16;
            return jArr;
        }
        jArr[2] = 4;
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, String str2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("apkfile", str2);
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    private static String a(BaseAdUnit baseAdUnit, String str) {
        String apkMd5 = baseAdUnit.getApkMd5();
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) apkMd5)) {
            apkMd5 = Md5Util.md5(str);
        }
        return CtFAbx.AcNBzu(apkMd5, ".apk");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, com.sigmob.sdk.downloader.f fVar, BaseAdUnit baseAdUnit) {
        q.a(context, fVar.n().getAbsolutePath(), baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
            options.put("status", String.valueOf(0));
            options.put("error", "cancel download");
        }
    }

    public static void a(final String str, BaseAdUnit baseAdUnit, boolean z) {
        String str2;
        Object obj;
        final String str3;
        StringBuilder sb;
        PendingIntent broadcast;
        com.sigmob.sdk.downloader.core.breakpoint.g c;
        Context e = com.sigmob.sdk.b.e();
        try {
            com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
            if (downloadTask != null) {
                str3 = downloadTask.n().getAbsolutePath();
                try {
                    if (com.sigmob.sdk.downloader.l.c(downloadTask)) {
                        if (baseAdUnit.isRecord()) {
                            com.sigmob.sdk.base.network.g.a(baseAdUnit, com.sigmob.sdk.base.common.a.D);
                        }
                        WindAds.sharedAds().getHandler().post(new AzWtSf(e, downloadTask, baseAdUnit, 1));
                        return;
                    } else {
                        if (com.sigmob.sdk.downloader.l.a(downloadTask)) {
                            ak.a(e, "正在下载", 1).show();
                            HashMap hashMap = new HashMap();
                            hashMap.put("result", "1");
                            hashMap.put("downloadId", baseAdUnit.getDownloadId());
                            BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                            return;
                        }
                        str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                        obj = "downloadId";
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                    obj = "downloadId";
                    HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("result", Constants.FAIL);
                    BI9f7h2.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), BI9f7h2, str2);
                    final int i = 1;
                    ae.a("download_start", Constants.FAIL, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.AlLFFp
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public final void onAddExtra(Object obj2) {
                            switch (i) {
                                case 0:
                                    o.b(str, str3, obj2);
                                    break;
                                default:
                                    o.a(str, str3, obj2);
                                    break;
                            }
                        }
                    });
                    ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new AmA8tU(th, e, 2));
                }
            } else {
                f.a c2 = new f.a(str, com.sigmob.sdk.base.utils.k.a(e)).a(baseAdUnit.getApkName()).c(false);
                c2.a("User-Agent", Networking.getUserAgent());
                downloadTask = z ? c2.a() : c2.a(1).a();
                if (com.sigmob.sdk.downloader.l.a(downloadTask)) {
                    com.sigmob.sdk.downloader.g.j().a().a((com.sigmob.sdk.downloader.core.a) downloadTask);
                }
                File n = downloadTask.n();
                if (n != null && n.exists()) {
                    n.delete();
                }
                if (n.getParentFile().exists()) {
                    n.getParentFile().mkdirs();
                }
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(e, baseAdUnit, e);
                String str4 = "downloadButtonAction_" + baseAdUnit.getUuid() + "_" + downloadTask.c();
                Intent intent = new Intent(str4);
                intent.setPackage(e.getPackageName());
                a aVar = new a(downloadTask, str4, baseAdUnit);
                str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                try {
                    sb = new StringBuilder("downloadAction_");
                    obj = "downloadId";
                } catch (Throwable th2) {
                    th = th2;
                    obj = "downloadId";
                    str3 = null;
                    HashMap BI9f7h22 = J3FDQU.A2egSU.BI9f7h("result", Constants.FAIL);
                    BI9f7h22.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), BI9f7h22, str2);
                    final int i2 = 1;
                    ae.a("download_start", Constants.FAIL, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.AlLFFp
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public final void onAddExtra(Object obj2) {
                            switch (i2) {
                                case 0:
                                    o.b(str, str3, obj2);
                                    break;
                                default:
                                    o.a(str, str3, obj2);
                                    break;
                            }
                        }
                    });
                    ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new AmA8tU(th, e, 2));
                }
                try {
                    sb.append(baseAdUnit.getUuid());
                    sb.append("_");
                    sb.append(downloadTask.c());
                    IntentFilter intentFilter = new IntentFilter(sb.toString());
                    intentFilter.addAction(str4);
                    v.a(e, aVar, intentFilter);
                    Intent intent2 = new Intent("downloadAction_" + baseAdUnit.getUuid() + "_" + downloadTask.c());
                    intent2.setPackage(e.getPackageName());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.l, 0.25f));
                    arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.W, 0.5f));
                    arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.X, 0.75f));
                    baseAdUnit.setDownloadQuarterTrack(arrayList);
                    anonymousClass3.a(baseAdUnit.getIconUrl(), baseAdUnit.getAppName(), baseAdUnit.getDesc());
                    if (Build.VERSION.SDK_INT >= 31) {
                        anonymousClass3.a(PendingIntent.getBroadcast(e, 0, intent, 201326592));
                        broadcast = PendingIntent.getBroadcast(e, 0, intent2, 201326592);
                    } else {
                        anonymousClass3.a(PendingIntent.getBroadcast(e, 0, intent, 134217728));
                        broadcast = PendingIntent.getBroadcast(e, 0, intent2, 134217728);
                    }
                    anonymousClass3.b(broadcast);
                    downloadTask.a((com.sigmob.sdk.downloader.c) anonymousClass3);
                    baseAdUnit.setDownloadTask(downloadTask);
                    if (!baseAdUnit.isResumableDownload() && (c = com.sigmob.sdk.downloader.g.j().c()) != null) {
                        c.b(downloadTask.c());
                    }
                    str3 = null;
                } catch (Throwable th3) {
                    th = th3;
                    str3 = null;
                    HashMap BI9f7h222 = J3FDQU.A2egSU.BI9f7h("result", Constants.FAIL);
                    BI9f7h222.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), BI9f7h222, str2);
                    final int i22 = 1;
                    ae.a("download_start", Constants.FAIL, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.AlLFFp
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public final void onAddExtra(Object obj2) {
                            switch (i22) {
                                case 0:
                                    o.b(str, str3, obj2);
                                    break;
                                default:
                                    o.a(str, str3, obj2);
                                    break;
                            }
                        }
                    });
                    ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new AmA8tU(th, e, 2));
                }
            }
            try {
                baseAdUnit.setDownloadId(Long.valueOf(downloadTask.c()));
                downloadTask.B();
                ak.a(e, "已开始下载", 1).show();
                if (baseAdUnit.isRecord()) {
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "download_start");
                    final int i3 = 0;
                    ae.a("download_start", "1", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.AlLFFp
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public final void onAddExtra(Object obj2) {
                            switch (i3) {
                                case 0:
                                    o.b(str, str3, obj2);
                                    break;
                                default:
                                    o.a(str, str3, obj2);
                                    break;
                            }
                        }
                    });
                }
            } catch (Throwable th4) {
                th = th4;
                HashMap BI9f7h2222 = J3FDQU.A2egSU.BI9f7h("result", Constants.FAIL);
                BI9f7h2222.put(obj, baseAdUnit.getDownloadId());
                BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), BI9f7h2222, str2);
                final int i222 = 1;
                ae.a("download_start", Constants.FAIL, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.AlLFFp
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public final void onAddExtra(Object obj2) {
                        switch (i222) {
                            case 0:
                                o.b(str, str3, obj2);
                                break;
                            default:
                                o.a(str, str3, obj2);
                                break;
                        }
                    }
                });
                ae.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new AmA8tU(th, e, 2));
            }
        } catch (Throwable th5) {
            th = th5;
            str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("apkfile", str2);
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    public static void a(String str, String str2, String str3, String str4, boolean z) {
        final Context e = com.sigmob.sdk.b.e();
        HashMap<String, com.sigmob.sdk.downloader.f> hashMap = f13147a;
        final com.sigmob.sdk.downloader.f fVar = hashMap.get(str);
        if (fVar != null) {
            if (com.sigmob.sdk.downloader.l.c(fVar)) {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.o.1
                    @Override // java.lang.Runnable
                    public void run() {
                        q.a(e, fVar.n().getAbsolutePath(), (BaseAdUnit) null);
                    }
                });
                return;
            } else if (com.sigmob.sdk.downloader.l.a(fVar)) {
                ak.a(e, "正在下载", 1).show();
                return;
            } else {
                ak.a(e, "继续下载", 1).show();
                fVar.B();
                return;
            }
        }
        f.a c = new f.a(str2, com.sigmob.sdk.base.utils.k.a(e)).a(str).c(false);
        c.a("User-Agent", Networking.getUserAgent());
        if (!z) {
            c = c.a(1);
        }
        com.sigmob.sdk.downloader.f a2 = c.a();
        if (com.sigmob.sdk.downloader.l.a(a2)) {
            com.sigmob.sdk.downloader.g.j().a().a((com.sigmob.sdk.downloader.core.a) a2);
        }
        File n = a2.n();
        if (n != null && n.exists()) {
            n.delete();
        }
        if (n.getParentFile().exists()) {
            n.getParentFile().mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.l, 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.W, 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.X, 0.75f));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(e, e, str2, arrayList);
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("downloadButtonAction_", str, "_");
        B3GDIM2.append(a2.c());
        String sb = B3GDIM2.toString();
        Intent intent = new Intent(sb);
        intent.setPackage(e.getPackageName());
        a aVar = new a(a2, sb, null);
        StringBuilder B3GDIM3 = CtFAbx.B3GDIM("downloadAction_", str, "_");
        B3GDIM3.append(a2.c());
        IntentFilter intentFilter = new IntentFilter(B3GDIM3.toString());
        intentFilter.addAction(sb);
        v.a(e, aVar, intentFilter);
        StringBuilder B3GDIM4 = CtFAbx.B3GDIM("downloadAction_", str, "_");
        B3GDIM4.append(a2.c());
        Intent intent2 = new Intent(B3GDIM4.toString());
        intent2.setPackage(e.getPackageName());
        anonymousClass2.a(str3, str4, str);
        int i = Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
        anonymousClass2.a(PendingIntent.getBroadcast(e, 0, intent, i));
        anonymousClass2.b(PendingIntent.getBroadcast(e, 0, intent2, i));
        a2.a((com.sigmob.sdk.downloader.c) anonymousClass2);
        a2.B();
        ak.a(e, "已开始下载", 1).show();
        hashMap.put(str, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th, Context context, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
            options.put("status", String.valueOf(0));
            options.put("error", th.getMessage());
            ak.a(context, "下载失败，" + th.getMessage(), 1).show();
        }
    }
}
