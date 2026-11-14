package com.octopus.ad;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.internal.utilities.DownloadFactory;
import com.octopus.ad.internal.utilities.ReportEventUtil;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.c;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class DownloadService extends Service {
    private static DownloadFactory.Download f;

    /* renamed from: a, reason: collision with root package name */
    private long f12326a;
    private String b;
    private DownloadManager c;
    private a d;
    private b e;
    private HashMap<String, com.octopus.ad.utils.b> g;
    private HashMap<String, Boolean> h;
    private HashMap<Long, String> i;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursor = null;
            try {
                try {
                    cursor = DownloadService.this.c.query(new DownloadManager.Query().setFilterById(DownloadService.this.f12326a));
                    if (cursor != null && cursor.moveToFirst()) {
                        int i = cursor.getInt(cursor.getColumnIndex("status"));
                        f.a(com.sigmob.sdk.base.services.f.d, "onChange status：" + i);
                        if (i == 1) {
                            DownloadService.this.b(c.a(DownloadService.this).a());
                        }
                        iArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursor.getInt(cursor.getColumnIndex("status"));
                        f.a(com.sigmob.sdk.base.services.f.d, "progress：" + iArr[0] + "/" + iArr[1]);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor query2 = downloadManager.query(query);
                    if (query2 == null || !query2.moveToFirst()) {
                        DownloadService downloadService = DownloadService.this;
                        downloadService.a(Long.valueOf(downloadService.f12326a));
                    } else if (query2.getInt(query2.getColumnIndex("status")) == 8) {
                        DownloadService.this.a(context, longExtra);
                    }
                }
            } catch (Throwable th) {
                f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }

    private void d() {
        DownloadFactory.Download download = f;
        if (download != null) {
            download.destroy();
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        c.a(this).f();
        f.a(com.sigmob.sdk.base.services.f.d, "releaseResources()");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f.a(com.sigmob.sdk.base.services.f.d, "DownloadService onCreate()");
        this.c = (DownloadManager) getSystemService("download");
        this.d = new a(new Handler());
        this.e = new b();
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f.a(com.sigmob.sdk.base.services.f.d, "DownloadService onDestroy()");
        b();
        d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 1;
        }
        f.a(com.sigmob.sdk.base.services.f.d, "DownloadService onStartCommand()");
        c();
        return super.onStartCommand(intent, i, i2);
    }

    private void b() {
        if (this.d != null) {
            getContentResolver().unregisterContentObserver(this.d);
            this.d = null;
            f.a(com.sigmob.sdk.base.services.f.d, "unregisterContentObserver()");
        }
        b bVar = this.e;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.e = null;
            f.a(com.sigmob.sdk.base.services.f.d, "unregisterReceiver()");
        }
    }

    private void c() {
        com.octopus.ad.utils.b a2 = c.a(this).a();
        if (a2 == null) {
            return;
        }
        HashMap<String, com.octopus.ad.utils.b> hashMap = this.g;
        if (hashMap != null) {
            hashMap.put(a2.c(), a2);
        }
        HashMap<String, Boolean> hashMap2 = this.h;
        if (hashMap2 != null && hashMap2.get(a2.c()) == null) {
            f.a(com.sigmob.sdk.base.services.f.d, "not have package status...");
            this.h.put(a2.c(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(a2.g())) {
            this.b = getPackageName() + ".octopus.provider";
        } else {
            this.b = a2.g();
        }
        com.octopus.ad.utils.b.c.a(a2.d());
        a(a2);
    }

    @SuppressLint({"WrongConstant", "UnspecifiedRegisterReceiverFlag"})
    private void a() {
        try {
            getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.d);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            if (Build.VERSION.SDK_INT >= 26) {
                registerReceiver(this.e, intentFilter, 2);
            } else {
                registerReceiver(this.e, intentFilter);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private static File b(Context context, long j) {
        Cursor query;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j != -1) {
            DownloadManager.Query query2 = new DownloadManager.Query();
            query2.setFilterById(j);
            query2.setFilterByStatus(8);
            if (downloadManager != null && (query = downloadManager.query(query2)) != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null) {
                        file = new File(path);
                    }
                }
                query.close();
            }
        }
        return file;
    }

    private synchronized void a(com.octopus.ad.utils.b bVar) {
        Uri uriForFile;
        HashMap<String, Boolean> hashMap = this.h;
        if (hashMap != null && hashMap.get(bVar.c()) != null && Boolean.TRUE.equals(this.h.get(bVar.c()))) {
            f.a(com.sigmob.sdk.base.services.f.d, "downloading..." + bVar.c() + "...please not repeat click");
            Toast.makeText(getApplicationContext(), "正在下载…请勿重复点击", 0).show();
            return;
        }
        File file = new File(bVar.d(), bVar.b());
        if (file.exists()) {
            try {
                c.a(this).b(false);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                intent.setAction("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    uriForFile = Uri.fromFile(file);
                } else {
                    uriForFile = FileProvider.getUriForFile(this, bVar.g(), file);
                    intent.addFlags(3);
                }
                if (uriForFile != null) {
                    f.a(com.sigmob.sdk.base.services.f.d, "uri......" + uriForFile);
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                    startActivity(intent);
                    c(bVar);
                }
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(bVar.a()));
            request.setTitle(bVar.e());
            request.setDescription(bVar.f());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType(AdBaseConstants.MIME_APK);
            this.f12326a = this.c.enqueue(request);
            f.b(com.sigmob.sdk.base.services.f.d, "mReqId:" + this.f12326a);
            HashMap<Long, String> hashMap2 = this.i;
            if (hashMap2 != null) {
                hashMap2.put(Long.valueOf(this.f12326a), bVar.c());
            }
            HashMap<String, Boolean> hashMap3 = this.h;
            if (hashMap3 != null) {
                hashMap3.put(bVar.c(), Boolean.TRUE);
            }
            Toast.makeText(getApplicationContext(), "已开始下载…", 0).show();
            f.a(com.sigmob.sdk.base.services.f.d, "BEGIN_DOWNLOAD!");
            if (bVar.h() != null) {
                ReportEventUtil.report(bVar.h().a());
            }
        } catch (Exception e2) {
            f.a("OctopusAd", "An Exception Caught", e2);
            try {
                if (!TextUtils.isEmpty(bVar.a()) && bVar.a().contains(Constants.HTTP)) {
                    HashMap<String, Boolean> hashMap4 = this.h;
                    if (hashMap4 != null) {
                        hashMap4.put(bVar.c(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(bVar.a()));
                    intent2.setFlags(C.ENCODING_PCM_MU_LAW);
                    startActivity(intent2);
                }
            } catch (Exception e3) {
                f.a("OctopusAd", "An Exception Caught", e3);
            }
        }
    }

    private void c(com.octopus.ad.utils.b bVar) {
        f.a(com.sigmob.sdk.base.services.f.d, "BEGIN_INSTALL!");
        if (bVar.h() != null) {
            ReportEventUtil.report(bVar.h().c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.octopus.ad.utils.b bVar) {
        if (bVar == null) {
            return;
        }
        f.a(com.sigmob.sdk.base.services.f.d, "--appUpdate downloadApk start--");
        DownloadFactory.Download create = DownloadFactory.create();
        f = create;
        create.register(new DownloadFactory.DownloadDelegate() { // from class: com.octopus.ad.DownloadService.1
            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public boolean onCheck(File file) {
                return true;
            }

            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onFail(int i) {
                f.a(com.sigmob.sdk.base.services.f.d, "--appUpdate downloadApk onFail--");
                try {
                    String a2 = bVar.a();
                    if (TextUtils.isEmpty(a2) || !a2.contains(Constants.HTTP)) {
                        return;
                    }
                    if (DownloadService.this.h != null) {
                        DownloadService.this.h.put(bVar.c(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(a2));
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    DownloadService.this.startActivity(intent);
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }

            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onProgress(long j, long j2) {
            }

            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onSuccess(File file) {
                f.a(com.sigmob.sdk.base.services.f.d, "--appUpdate downloadApk onSuccess--");
                if (DownloadService.this.h != null) {
                    DownloadService.this.h.put(bVar.c(), Boolean.FALSE);
                }
                DownloadService.this.a(DownloadService.this.getApplicationContext(), (Long) (-1L), bVar);
            }
        });
        f.start(new DownloadFactory.Request(bVar.a(), bVar.d(), bVar.b()));
    }

    public void a(Long l) {
        try {
            HashMap<Long, String> hashMap = this.i;
            if (hashMap != null) {
                String str = hashMap.get(l);
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, Boolean> hashMap2 = this.h;
                    if (hashMap2 != null) {
                        hashMap2.put(str, Boolean.FALSE);
                    }
                    HashMap<String, com.octopus.ad.utils.b> hashMap3 = this.g;
                    if (hashMap3 != null) {
                        hashMap3.remove(str);
                    }
                }
            }
            DownloadManager downloadManager = this.c;
            if (downloadManager == null || l == null) {
                return;
            }
            downloadManager.remove(l.longValue());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        f.a(com.sigmob.sdk.base.services.f.d, "onReceived...download finish...begin install！");
        HashMap<Long, String> hashMap = this.i;
        if (hashMap == null || this.g == null) {
            return;
        }
        String str = hashMap.get(Long.valueOf(j));
        HashMap<String, Boolean> hashMap2 = this.h;
        if (hashMap2 != null) {
            hashMap2.put(str, Boolean.FALSE);
        }
        com.octopus.ad.utils.b bVar = this.g.get(str);
        if (bVar != null) {
            if (bVar.h() != null) {
                ReportEventUtil.report(bVar.h().b());
            }
            a(context, Long.valueOf(j), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Long l, com.octopus.ad.utils.b bVar) {
        Uri uriForFile;
        try {
            c.a(context).b(false);
            Intent intent = new Intent();
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.setAction("android.intent.action.VIEW");
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                uriForFile = this.c.getUriForDownloadedFile(l.longValue());
            } else if (i < 24) {
                File b2 = b(context, l.longValue());
                uriForFile = b2 != null ? Uri.fromFile(b2) : null;
            } else {
                uriForFile = FileProvider.getUriForFile(context, this.b, new File(bVar.d(), bVar.b()));
                intent.addFlags(3);
            }
            if (uriForFile != null) {
                f.a(com.sigmob.sdk.base.services.f.d, "uri......" + uriForFile);
                intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                c(bVar);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
