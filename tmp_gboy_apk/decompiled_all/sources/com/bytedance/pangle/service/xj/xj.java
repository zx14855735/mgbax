package com.bytedance.pangle.service.xj;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.f;
import com.bytedance.pangle.kd;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.openadsdk.api.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends kd.xj {
    private static volatile xj hf;
    private final HashMap<ComponentName, IBinder> w = new HashMap<>();
    private final HashMap<ComponentName, hf> u = new HashMap<>();
    private final C0094xj<Intent> kd = new C0094xj<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.xj> y = new HashMap<>();
    private final HashSet<ComponentName> c = new HashSet<>();
    private final HashSet<ComponentName> f = new HashSet<>();
    private final List<Runnable> d = new ArrayList();
    private final Handler xj = new Handler(Looper.getMainLooper());

    public class hf extends HashSet<f> {
        public hf() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    y.xj(e);
                }
                if (it.next().xj() == ((f) obj).xj()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            f fVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = (f) it.next();
                try {
                } catch (RemoteException e) {
                    y.xj(e);
                }
                if (fVar.xj() == ((f) obj).xj()) {
                    break;
                }
            }
            return super.remove(fVar);
        }
    }

    /* renamed from: com.bytedance.pangle.service.xj.xj$xj, reason: collision with other inner class name */
    public class C0094xj<T> extends HashMap<f, T> {
        public C0094xj() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    y.xj(e);
                }
                if (it.next().xj() == ((f) obj).xj()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object obj) {
            f fVar;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<f> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = it.next();
                try {
                } catch (RemoteException e) {
                    y.xj(e);
                }
                if (fVar.xj() == ((f) obj).xj()) {
                    break;
                }
            }
            return (T) super.remove(fVar);
        }
    }

    private xj() {
    }

    public static xj hf() {
        if (hf == null) {
            synchronized (xj.class) {
                try {
                    if (hf == null) {
                        hf = new xj();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    @Override // com.bytedance.pangle.kd.xj, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.kd
    public boolean bindService(final Intent intent, final f fVar, final int i, final String str) {
        if (!Zeus.hasInit()) {
            this.d.add(new Runnable() { // from class: com.bytedance.pangle.service.xj.xj.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        xj.this.xj(intent, fVar, i, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                    }
                }
            });
            return true;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return xj(intent, fVar, i, str);
        }
        this.xj.post(new Runnable() { // from class: com.bytedance.pangle.service.xj.xj.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xj.this.xj(intent, fVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.pangle.kd
    public ComponentName startService(final Intent intent, final String str) {
        if (!Zeus.hasInit()) {
            this.d.add(new Runnable() { // from class: com.bytedance.pangle.service.xj.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.xj(intent, str);
                }
            });
        } else {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return xj(intent, str);
            }
            this.xj.post(new Runnable() { // from class: com.bytedance.pangle.service.xj.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.xj(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.kd
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf().xj(intent.getComponent());
            return true;
        }
        this.xj.post(new Runnable() { // from class: com.bytedance.pangle.service.xj.xj.3
            @Override // java.lang.Runnable
            public void run() {
                xj.hf().xj(intent.getComponent());
            }
        });
        return true;
    }

    @Override // com.bytedance.pangle.kd
    public void unbindService(final f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xj(fVar);
        } else {
            this.xj.post(new Runnable() { // from class: com.bytedance.pangle.service.xj.xj.6
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.xj(fVar);
                }
            });
        }
    }

    public void w() {
        for (Runnable runnable : this.d) {
            if (runnable != null) {
                this.xj.post(runnable);
            }
        }
        this.d.clear();
    }

    private com.bytedance.pangle.service.xj w(Intent intent, String str) {
        boolean z;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z = Zeus.loadPlugin(str);
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            com.bytedance.pangle.service.xj xjVar = (com.bytedance.pangle.service.xj) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
            xjVar.attach(plugin);
            return xjVar;
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName xj(Intent intent, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.y.containsKey(component)) {
                com.bytedance.pangle.service.xj hf2 = hf(intent, str);
                if (hf2 == null) {
                    return component;
                }
                this.y.put(component, hf2);
                this.c.add(component);
            }
            com.bytedance.pangle.service.xj xjVar = this.y.get(component);
            if (xjVar != null) {
                xjVar.onStartCommand(intent, 0, 0);
            }
            return component;
        } catch (Throwable th) {
            throw th;
        }
    }

    private com.bytedance.pangle.service.xj hf(Intent intent, String str) {
        com.bytedance.pangle.service.xj w = w(intent, str);
        if (w != null) {
            w.onCreate();
        }
        return w;
    }

    private boolean hf(ComponentName componentName) {
        if (!this.c.contains(componentName)) {
            if (this.u.get(componentName) != null) {
                return false;
            }
            w(componentName);
            return true;
        }
        if (!this.f.contains(componentName) || this.u.containsKey(componentName)) {
            return false;
        }
        w(componentName);
        return true;
    }

    private void w(ComponentName componentName) {
        com.bytedance.pangle.service.xj remove = this.y.remove(componentName);
        this.f.remove(componentName);
        this.w.remove(componentName);
        this.c.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    public synchronized boolean xj(ComponentName componentName) {
        if (!this.y.containsKey(componentName)) {
            return false;
        }
        this.f.add(componentName);
        return hf(componentName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean xj(Intent intent, f fVar, int i, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.y.containsKey(component)) {
                com.bytedance.pangle.service.xj hf2 = hf(intent, str);
                if (hf2 == null) {
                    return false;
                }
                this.y.put(component, hf2);
            }
            com.bytedance.pangle.service.xj xjVar = this.y.get(component);
            if (!this.w.containsKey(component)) {
                this.w.put(component, xjVar.onBind(intent));
            }
            IBinder iBinder = this.w.get(component);
            if (iBinder != null) {
                if (this.u.containsKey(component)) {
                    if (!this.u.get(component).contains(fVar)) {
                        this.u.get(component).add(fVar);
                        this.kd.put(fVar, intent);
                        fVar.xj(component, iBinder);
                    }
                } else {
                    hf hfVar = new hf();
                    hfVar.add(fVar);
                    this.u.put(component, hfVar);
                    this.kd.put(fVar, intent);
                    fVar.xj(component, iBinder);
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(f fVar) {
        try {
            for (ComponentName componentName : this.u.keySet()) {
                hf hfVar = this.u.get(componentName);
                if (hfVar.contains(fVar)) {
                    hfVar.remove(fVar);
                    Intent remove = this.kd.remove(fVar);
                    if (hfVar.size() == 0) {
                        this.u.remove(componentName);
                        com.bytedance.pangle.service.xj xjVar = this.y.get(componentName);
                        if (xjVar != null) {
                            xjVar.onUnbind(remove);
                        }
                    }
                    hf(componentName);
                    return;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
