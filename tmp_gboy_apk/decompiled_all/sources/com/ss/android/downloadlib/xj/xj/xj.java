package com.ss.android.downloadlib.xj.xj;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.pl;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.xj.xj.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static volatile xj c = null;
    private static String kd = "";
    private static String u = "";
    private static String y = "";
    private Context p;
    public w xj;
    private boolean f = true;
    private boolean d = false;
    private volatile boolean tf = false;

    /* renamed from: pl, reason: collision with root package name */
    private final List<Pair<hf, u>> f13835pl = new ArrayList();
    public final List<Object> hf = new ArrayList();
    private final ServiceConnection g = new ServiceConnection() { // from class: com.ss.android.downloadlib.xj.xj.xj.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (xj.this.w) {
                try {
                    xj.this.xj(false);
                    xj.this.xj = w.xj.xj(iBinder);
                    xj.this.w();
                    Iterator<Object> it = xj.this.hf.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (xj.this.w) {
                try {
                    xj.this.xj(false);
                    xj xjVar = xj.this;
                    xjVar.xj = null;
                    Iterator<Object> it = xjVar.hf.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };
    private String am = "";
    public final Object w = new Object();

    private xj() {
    }

    public static xj xj() {
        if (c == null) {
            synchronized (xj.class) {
                try {
                    if (c == null) {
                        c = new xj();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void hf() {
        if (this.xj != null) {
            this.p.unbindService(this.g);
            this.xj = null;
        }
        this.hf.clear();
        this.f13835pl.clear();
    }

    public boolean u() {
        return this.tf;
    }

    public void w() {
        for (Pair<hf, u> pair : this.f13835pl) {
            try {
                this.xj.xj((hf) pair.first, (u) pair.second);
            } catch (RemoteException e) {
                pl.xj(e);
            }
        }
        this.f13835pl.clear();
    }

    public boolean xj(Context context, boolean z) {
        if (TextUtils.isEmpty(u)) {
            JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
            String optString = d.optString("s");
            u = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("q"), optString);
            kd = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString(t.i), optString);
            y = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.d = z;
        if (context == null) {
            return true;
        }
        this.p = context.getApplicationContext();
        if (TextUtils.isEmpty(y)) {
            y = this.p.getPackageName();
        }
        if (this.xj != null || u()) {
            return true;
        }
        return this.p.bindService(xj(context), this.g, 33);
    }

    public Intent xj(Context context) {
        Intent intent = new Intent();
        intent.setAction(u);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (kd.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void xj(hf hfVar, u uVar) {
        synchronized (this.w) {
            try {
                hfVar.kd = y;
                if (TextUtils.isEmpty(hfVar.y)) {
                    hfVar.y = this.am;
                }
                w wVar = this.xj;
                if (wVar != null) {
                    try {
                        wVar.xj(hfVar, uVar);
                    } catch (RemoteException e) {
                        pl.xj(e);
                    }
                } else if (u() || xj(this.p, this.d)) {
                    this.f13835pl.add(Pair.create(hfVar, uVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xj(boolean z) {
        this.tf = z;
    }
}
