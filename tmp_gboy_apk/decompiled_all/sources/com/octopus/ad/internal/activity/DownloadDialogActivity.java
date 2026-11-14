package com.octopus.ad.internal.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.DownloadFactory;
import com.octopus.ad.internal.utilities.ImageManager;
import com.octopus.ad.internal.utilities.ReportEventUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.b.i;
import com.octopus.ad.utils.c;
import com.octopus.ad.widget.FlickerProgressBar;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadDialogActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private static final String f12409a = "DownloadDialogActivity";
    private static DownloadFactory.Download h;
    private long b;
    private String c;
    private DownloadManager d;
    private a e;
    private b f;
    private FlickerProgressBar g;
    private HashMap<String, com.octopus.ad.utils.b> i;
    private HashMap<String, Boolean> j;
    private HashMap<Long, String> k;
    private c l;
    private ComplianceInfo m;
    private boolean n;

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
                    cursor = DownloadDialogActivity.this.d.query(new DownloadManager.Query().setFilterById(DownloadDialogActivity.this.b));
                    if (cursor != null && cursor.moveToFirst()) {
                        iArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursor.getInt(cursor.getColumnIndex("status"));
                        f.a(DownloadDialogActivity.f12409a, "progress：" + iArr[0] + "/" + iArr[1]);
                        if (iArr[1] > 0) {
                            DecimalFormat decimalFormat = new DecimalFormat("#.#");
                            decimalFormat.setRoundingMode(RoundingMode.DOWN);
                            DownloadDialogActivity.this.g.setProgress(Float.parseFloat(decimalFormat.format((iArr[0] * 100.0f) / iArr[1])));
                        }
                        int i = cursor.getInt(cursor.getColumnIndex("status"));
                        f.a(DownloadDialogActivity.f12409a, "onChange status：" + i);
                        DownloadDialogActivity.this.g.setStatus(i);
                        if (1 == i) {
                            DownloadDialogActivity.this.c(c.a(DownloadDialogActivity.this).a());
                        }
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
                String action = intent.getAction();
                String unused = DownloadDialogActivity.f12409a;
                if (!"android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
                    if ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(intent.getAction())) {
                        f.a(DownloadDialogActivity.f12409a, "NOTIFICATION_CLICKED");
                        return;
                    }
                    return;
                }
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(longExtra);
                Cursor query2 = downloadManager.query(query);
                if (query2 == null || !query2.moveToFirst()) {
                    DownloadDialogActivity downloadDialogActivity = DownloadDialogActivity.this;
                    downloadDialogActivity.a(Long.valueOf(downloadDialogActivity.b));
                } else if (query2.getInt(query2.getColumnIndex("status")) == 8) {
                    DownloadDialogActivity.this.a(context, longExtra);
                }
            } catch (Throwable th) {
                f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }

    private void g() {
        if (this.e != null) {
            getContentResolver().unregisterContentObserver(this.e);
            this.e = null;
            f.a(f12409a, "unregisterContentObserver()");
        }
        b bVar = this.f;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.f = null;
            f.a(f12409a, "unregisterReceiver()");
        }
    }

    private void h() {
        DownloadFactory.Download download = h;
        if (download != null) {
            download.destroy();
        }
        if (this.j != null) {
            this.j = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.k != null) {
            this.k = null;
        }
        c.a(this).f();
        f.a(f12409a, "releaseResources()");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c a2 = c.a(this);
        this.l = a2;
        this.m = a2.b();
        b();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f.a(f12409a, "DownloadService onDestroy()");
        c cVar = this.l;
        if (cVar != null) {
            cVar.d();
        }
        try {
            g();
            h();
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        f();
    }

    private void b() {
        try {
            if (this.l != null && this.m != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.OctopusAlertDialogStyle);
                View inflate = LayoutInflater.from(this).inflate(R.layout.oct_dialog_download, (ViewGroup) null);
                builder.setView(inflate);
                final AlertDialog create = builder.create();
                create.setCancelable(false);
                create.setCanceledOnTouchOutside(false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_app_icon);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_app_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_app_version);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_app_developer);
                TextView textView4 = (TextView) inflate.findViewById(R.id.tv_app_permission);
                TextView textView5 = (TextView) inflate.findViewById(R.id.tv_app_privacy);
                TextView textView6 = (TextView) inflate.findViewById(R.id.tv_app_function);
                this.g = (FlickerProgressBar) inflate.findViewById(R.id.btn_download);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_close);
                ImageManager.with(null).load(this.m.getAppIconURL()).into(imageView);
                textView.setText(this.m.getAppName());
                textView2.setText("版本号：" + this.m.getAppVersion());
                textView3.setText("开发者：" + this.m.getDeveloperName());
                com.octopus.ad.utils.b a2 = c.a(this).a();
                if (a2 != null && new File(a2.d(), a2.b()).exists()) {
                    this.g.setProgress(100.0f);
                    this.g.setStatus(8);
                }
                textView4.setPaintFlags(textView4.getPaintFlags() | 8);
                textView5.setPaintFlags(textView5.getPaintFlags() | 8);
                textView6.setPaintFlags(textView6.getPaintFlags() | 8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.DownloadDialogActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DownloadDialogActivity.this.m != null) {
                            ViewUtil.openLocalBrowser(DownloadDialogActivity.this.m.getPermissionsUrl(), 0);
                        }
                    }
                });
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.DownloadDialogActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DownloadDialogActivity.this.m != null) {
                            ViewUtil.openLocalBrowser(DownloadDialogActivity.this.m.getPrivacyUrl(), 0);
                        }
                    }
                });
                textView6.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.DownloadDialogActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DownloadDialogActivity.this.m != null) {
                            ViewUtil.openLocalBrowser(DownloadDialogActivity.this.m.getFunctionDescUrl(), 0);
                        }
                    }
                });
                this.g.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.DownloadDialogActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DownloadDialogActivity.this.c();
                    }
                });
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.DownloadDialogActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        create.cancel();
                        DownloadDialogActivity.this.finish();
                    }
                });
                create.show();
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d = (DownloadManager) getSystemService("download");
        this.e = new a(new Handler());
        this.f = new b();
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        d();
        e();
    }

    @SuppressLint({"WrongConstant", "UnspecifiedRegisterReceiverFlag"})
    private void d() {
        try {
            getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.e);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            if (Build.VERSION.SDK_INT >= 26) {
                registerReceiver(this.f, intentFilter, 2);
            } else {
                registerReceiver(this.f, intentFilter);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void e() {
        com.octopus.ad.utils.b a2 = c.a(this).a();
        if (a2 == null) {
            return;
        }
        HashMap<String, com.octopus.ad.utils.b> hashMap = this.i;
        if (hashMap != null) {
            hashMap.put(a2.c(), a2);
        }
        HashMap<String, Boolean> hashMap2 = this.j;
        if (hashMap2 != null && hashMap2.get(a2.c()) == null) {
            f.a(f12409a, "not have package status...");
            this.j.put(a2.c(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(a2.g())) {
            this.c = getPackageName() + ".octopus.provider";
        } else {
            this.c = a2.g();
        }
        com.octopus.ad.utils.b.c.a(a2.d());
        a(a2);
    }

    private void f() {
        try {
            HashMap<Long, String> hashMap = this.k;
            if (hashMap == null || this.i == null) {
                return;
            }
            String str = hashMap.get(Long.valueOf(this.b));
            if (i.e(this, str)) {
                com.octopus.ad.utils.b bVar = this.i.get(str);
                if (bVar != null) {
                    File file = new File(bVar.d(), bVar.b());
                    if (file.exists() && file.delete()) {
                        f.a(f12409a, "apkFile delete success");
                    }
                    c.a(this).b(true);
                    if (bVar.h() != null) {
                        ReportEventUtil.report(bVar.h().d());
                    }
                    this.i.remove(str);
                }
                HashMap<String, com.octopus.ad.utils.b> hashMap2 = this.i;
                if (hashMap2 == null || !hashMap2.isEmpty()) {
                    return;
                }
                finish();
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private synchronized void a(com.octopus.ad.utils.b bVar) {
        Uri uriForFile;
        HashMap<String, Boolean> hashMap = this.j;
        if (hashMap != null && hashMap.get(bVar.c()) != null && Boolean.TRUE.equals(this.j.get(bVar.c()))) {
            f.a(f12409a, "downloading..." + bVar.c() + "...please not repeat click");
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
                    f.a(f12409a, "uri......" + uriForFile);
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                    startActivity(intent);
                    b(bVar);
                }
            } catch (Exception e) {
                f.c(f12409a, "apkFile.exists():" + e);
            }
        }
        try {
            if (this.n) {
                a(Long.valueOf(this.b));
                this.g.b();
                this.n = false;
                Toast.makeText(getApplicationContext(), "已取消下载", 0).show();
            } else {
                this.n = true;
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(bVar.a()));
                request.setTitle(bVar.e());
                request.setDescription(bVar.f());
                request.setNotificationVisibility(1);
                request.setDestinationUri(Uri.fromFile(file));
                request.setMimeType(AdBaseConstants.MIME_APK);
                this.b = this.d.enqueue(request);
                String str = f12409a;
                f.b(str, "mReqId:" + this.b);
                HashMap<Long, String> hashMap2 = this.k;
                if (hashMap2 != null) {
                    hashMap2.put(Long.valueOf(this.b), bVar.c());
                }
                HashMap<String, Boolean> hashMap3 = this.j;
                if (hashMap3 != null) {
                    hashMap3.put(bVar.c(), Boolean.TRUE);
                }
                Toast.makeText(getApplicationContext(), "已开始下载…", 0).show();
                f.a(str, "BEGIN_DOWNLOAD!");
                if (bVar.h() != null) {
                    ReportEventUtil.report(bVar.h().a());
                }
            }
        } catch (Exception e2) {
            f.a(f12409a, "DownloadManager download fail:" + e2);
            try {
                if (!TextUtils.isEmpty(bVar.a()) && bVar.a().contains(Constants.HTTP)) {
                    HashMap<String, Boolean> hashMap4 = this.j;
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
                f.c(f12409a, "skip browser fail:" + e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.octopus.ad.utils.b bVar) {
        if (bVar == null) {
            return;
        }
        f.a(f12409a, "--appUpdate downloadApk start--");
        DownloadFactory.Download create = DownloadFactory.create();
        h = create;
        create.register(new DownloadFactory.DownloadDelegate() { // from class: com.octopus.ad.internal.activity.DownloadDialogActivity.6
            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public boolean onCheck(File file) {
                return true;
            }

            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onFail(int i) {
                f.a(DownloadDialogActivity.f12409a, "--appUpdate downloadApk onFail--");
                try {
                    String a2 = bVar.a();
                    if (TextUtils.isEmpty(a2) || !a2.contains(Constants.HTTP)) {
                        return;
                    }
                    if (DownloadDialogActivity.this.j != null) {
                        DownloadDialogActivity.this.j.put(bVar.c(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(a2));
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    DownloadDialogActivity.this.startActivity(intent);
                } catch (Exception e) {
                    f.a(DownloadDialogActivity.f12409a, "skip browser fail:" + e);
                }
            }

            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onProgress(long j, long j2) {
            }

            @Override // com.octopus.ad.internal.utilities.DownloadFactory.DownloadDelegate
            public void onSuccess(File file) {
                f.a(DownloadDialogActivity.f12409a, "--appUpdate downloadApk onSuccess--");
                if (DownloadDialogActivity.this.j != null) {
                    DownloadDialogActivity.this.j.put(bVar.c(), Boolean.FALSE);
                }
                DownloadDialogActivity.this.a(DownloadDialogActivity.this.getApplicationContext(), (Long) (-1L), bVar);
            }
        });
        h.start(new DownloadFactory.Request(bVar.a(), bVar.d(), bVar.b()));
    }

    private void b(com.octopus.ad.utils.b bVar) {
        f.a(f12409a, "BEGIN_INSTALL!");
        if (bVar.h() != null) {
            ReportEventUtil.report(bVar.h().c());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j) {
        f.a(f12409a, "onReceived...download finish...begin install！");
        HashMap<Long, String> hashMap = this.k;
        if (hashMap == null || this.i == null) {
            return;
        }
        String str = hashMap.get(Long.valueOf(j));
        HashMap<String, Boolean> hashMap2 = this.j;
        if (hashMap2 != null) {
            hashMap2.put(str, Boolean.FALSE);
        }
        com.octopus.ad.utils.b bVar = this.i.get(str);
        if (bVar != null) {
            if (bVar.h() != null) {
                ReportEventUtil.report(bVar.h().b());
            }
            a(context, Long.valueOf(j), bVar);
        }
    }

    public void a(Long l) {
        try {
            HashMap<Long, String> hashMap = this.k;
            if (hashMap != null) {
                String str = hashMap.get(l);
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, Boolean> hashMap2 = this.j;
                    if (hashMap2 != null) {
                        hashMap2.put(str, Boolean.FALSE);
                    }
                    HashMap<String, com.octopus.ad.utils.b> hashMap3 = this.i;
                    if (hashMap3 != null) {
                        hashMap3.remove(str);
                    }
                }
            }
            DownloadManager downloadManager = this.d;
            if (downloadManager == null || l == null) {
                return;
            }
            downloadManager.remove(l.longValue());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
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
                uriForFile = this.d.getUriForDownloadedFile(l.longValue());
            } else if (i < 24) {
                File b2 = b(context, l.longValue());
                uriForFile = b2 != null ? Uri.fromFile(b2) : null;
            } else {
                uriForFile = FileProvider.getUriForFile(context, this.c, new File(bVar.d(), bVar.b()));
                intent.addFlags(3);
            }
            if (uriForFile != null) {
                f.a(f12409a, "uri......" + uriForFile);
                intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                b(bVar);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
