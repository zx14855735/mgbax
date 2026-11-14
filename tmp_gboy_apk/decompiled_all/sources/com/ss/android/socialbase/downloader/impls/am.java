package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class am extends com.ss.android.socialbase.downloader.downloader.xj implements ServiceConnection {
    private static final String kd = "am";
    private com.ss.android.socialbase.downloader.downloader.am c;
    private int f = -1;
    private com.ss.android.socialbase.downloader.downloader.d y;

    private void c() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.xj) {
                clone = this.xj.clone();
                this.xj.clear();
            }
            if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.w.z() == null) {
                return;
            }
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.y.xj(com.ss.android.socialbase.downloader.tf.c.xj(it.next()));
                        } catch (RemoteException e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.w.xj.hf(kd, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void hf(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = kd;
        StringBuilder sb = new StringBuilder("tryDownload aidlService == null:");
        sb.append(this.y == null);
        com.ss.android.socialbase.downloader.w.xj.hf(str, sb.toString());
        if (this.y == null) {
            xj(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.w.tj(), this);
            return;
        }
        c();
        try {
            this.y.xj(com.ss.android.socialbase.downloader.tf.c.xj(downloadTask));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.y = null;
        com.ss.android.socialbase.downloader.downloader.am amVar = this.c;
        if (amVar != null) {
            amVar.f();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = kd;
        com.ss.android.socialbase.downloader.w.xj.hf(str, "onServiceConnected ");
        this.y = d.xj.xj(iBinder);
        com.ss.android.socialbase.downloader.downloader.am amVar = this.c;
        if (amVar != null) {
            amVar.xj(iBinder);
        }
        StringBuilder sb = new StringBuilder("onServiceConnected aidlService!=null");
        sb.append(this.y != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.xj.size());
        com.ss.android.socialbase.downloader.w.xj.hf(str, sb.toString());
        if (this.y != null) {
            com.ss.android.socialbase.downloader.downloader.u.xj().hf();
            this.hf = true;
            this.u = false;
            int i = this.f;
            if (i != -1) {
                try {
                    this.y.pl(i);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
            if (this.y != null) {
                c();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.w.xj.hf(kd, "onServiceDisconnected ");
        this.y = null;
        this.hf = false;
        com.ss.android.socialbase.downloader.downloader.am amVar = this.c;
        if (amVar != null) {
            amVar.f();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.w.xj.hf(kd, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.tf.y.xj()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.f.xj.w().xj("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.w.xj.hf(kd, "stopService");
        this.hf = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void w(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.u.xj().xj(downloadTask.getDownloadId(), true);
        xj z = com.ss.android.socialbase.downloader.downloader.w.z();
        if (z != null) {
            z.xj(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public IBinder xj(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.bytedance.sdk.component.utils.pl.hf(kd, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.f.xj.xj("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.w.xj.hf(kd, "onBind IndependentDownloadBinder");
        return new g();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void xj(com.ss.android.socialbase.downloader.downloader.am amVar) {
        this.c = amVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void xj(int i) {
        com.ss.android.socialbase.downloader.downloader.d dVar = this.y;
        if (dVar == null) {
            this.f = i;
            return;
        }
        try {
            dVar.pl(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void startService() {
        if (this.y == null) {
            startService(com.ss.android.socialbase.downloader.downloader.w.tj(), this);
        }
    }
}
