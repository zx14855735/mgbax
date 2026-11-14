package io.dcloud.openapi.base.service;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.app.BIYEnU;
import com.baidu.mobads.sdk.internal.bn;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadService extends BIYEnU {
    private acaaaaaa aaaaaaaa = new acaaaaaa.aaaaaaa0().aaaaaaaa();
    private List aaaaaaa0 = new ArrayList();
    private final Object aaaaaaao = new Object();

    public class aaaaaaaa implements Runnable {
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0;
        final /* synthetic */ Context aaaaaaaa;
        final /* synthetic */ int aaaaaaao;

        public aaaaaaaa(Context context, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var, int i) {
            this.aaaaaaaa = context;
            this.aaaaaaa0 = aaaaaaa0Var;
            this.aaaaaaao = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaa0.aaaaaaaa(this.aaaaaaaa, this.aaaaaaa0.aaaaaaau(), this.aaaaaaa0.aaaeaaaa(), "", this.aaaaaaao, this.aaaaaaa0.aaaaaaao(), this.aaaaaaa0.aaaaaaa0(), this.aaaaaaa0.aaaaaaac(), null);
        }
    }

    public class aaaaaaao extends BroadcastReceiver {
        private Application aaaaaaa0;
        private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaaa;
        private long aaaaaaao = System.currentTimeMillis();

        public aaaaaaao(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var, Application application) {
            this.aaaaaaaa = aaaaaaa0Var;
            this.aaaaaaa0 = application;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                if (System.currentTimeMillis() - this.aaaaaaao < 60000) {
                    DownloadService.aaaaaaaa(DownloadService.this.getApplicationContext(), this.aaaaaaaa, 31);
                }
                this.aaaaaaa0.unregisterReceiver(this);
            }
        }
    }

    @Override // androidx.core.app.BIYEnU, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // androidx.core.app.BIYEnU
    public void onHandleWork(Intent intent) {
        synchronized (this.aaaaaaao) {
            try {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0) intent.getParcelableExtra(PointParamKey.DATA);
                for (aaaaaaa0 aaaaaaa0Var2 : this.aaaaaaa0) {
                    if (aaaaaaa0Var2.aaaaaaaa().equals(aaaaaaa0Var.aaaaeaaa()) && !aaaaaaa0Var2.aaaaaaao()) {
                        return;
                    }
                }
                aaaaaaa0 aaaaaaa0Var3 = new aaaaaaa0(aaaaaaa0Var);
                this.aaaaaaa0.add(aaaaaaa0Var3);
                aaaaaaaa(getApplicationContext(), aaaaaaa0Var, 29);
                this.aaaaaaaa.aaaaaaaa(aaaaaaa0Var3.aaaaaaa0()).aaaaaaaa(aaaaaaa0Var3);
                aaaaaaaa();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void aaaaaaaa() {
        File[] listFiles;
        try {
            long currentTimeMillis = System.currentTimeMillis() - bn.d;
            File file = new File(getApplication().getExternalCacheDir() + io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaaa.aaaaaaa0);
            if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.lastModified() < currentTimeMillis) {
                    file2.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public class aaaaaaa0 implements aaaaaaau {
        private boolean aaaaaaa0 = false;
        private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaaa;

        public aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var) {
            this.aaaaaaaa = aaaaaaa0Var;
        }

        public aaaacaaa aaaaaaa0() {
            return new aaaacaaa.aaaaaaaa().aaaaaaa0(this.aaaaaaaa.aaaaaeaa()).aaaaaaaa();
        }

        public String aaaaaaaa() {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
            return aaaaaaa0Var != null ? aaaaaaa0Var.aaaaeaaa() : "";
        }

        public boolean aaaaaaao() {
            return this.aaaaaaa0;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaau
        public void aaaaaaaa(aaaaaaac aaaaaaacVar, IOException iOException) {
            this.aaaaaaa0 = true;
            DownloadService.aaaaaaaa(DownloadService.this.getApplicationContext(), this.aaaaaaaa, 32);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaau
        public void aaaaaaaa(aaaaaaac aaaaaaacVar, aaaaaaca aaaaaacaVar) {
            this.aaaaaaa0 = true;
            String str = DownloadService.this.getApplication().getExternalCacheDir() + io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaaa.aaaaaaa0 + System.currentTimeMillis() + io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaaa.aaaaaaaa;
            a0aaaaaa aaaaaaeo = aaaaaacaVar.aaaaaaeo();
            if (aaaaaaeo != null) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaao.aaaaaaaa(aaaaaaeo.aaaaaaeo(), 0, str);
                DownloadService.this.aaaaaaaa(str, this.aaaaaaaa);
            }
            DownloadService.aaaaaaaa(DownloadService.this.getApplicationContext(), this.aaaaaaaa, 30);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaaa(String str, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        getApplication().registerReceiver(new aaaaaaao(aaaaaaa0Var, getApplication()), intentFilter);
        try {
            Class.forName("io.dcloud.feature.pack.FileUtils").getDeclaredMethod("addFileToSystem", Context.class, String.class, String.class).invoke(null, getApplication(), getApplication().getPackageName() + ".dc.fileprovider", str);
        } catch (Exception unused) {
        }
    }

    public static void aaaaaaaa(Context context, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var, int i) {
        aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaaa(context, aaaaaaa0Var, i));
    }
}
