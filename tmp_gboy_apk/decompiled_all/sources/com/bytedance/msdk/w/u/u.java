package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.msdk.core.hf;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class u extends tf {
    private Object ai;
    private int dk;
    private int et;
    private volatile boolean hf;
    private Handler ht;

    /* renamed from: io, reason: collision with root package name */
    private int f10155io;
    private SoftReference<Activity> jk;
    private SoftReference<Activity> pz;
    private String q;
    private int ra;
    private com.bytedance.msdk.hf.w x;
    private boolean xj;
    private final Application.ActivityLifecycleCallbacks z;
    protected boolean zg;

    public static class xj implements Runnable {
        private final int hf;
        private final Handler w;
        private Toast xj;

        @Override // java.lang.Runnable
        public void run() {
            if (this.hf <= 0) {
                this.xj.cancel();
                return;
            }
            this.xj.cancel();
            Toast makeText = Toast.makeText(com.bytedance.msdk.core.hf.getContext(), this.hf + "秒后播放下一个广告", 0);
            this.xj = makeText;
            makeText.show();
            Handler handler = this.w;
            handler.postDelayed(new xj(this.xj, this.hf - 1, handler), 1000L);
        }

        private xj(Toast toast, int i, Handler handler) {
            this.xj = toast;
            this.hf = i;
            this.w = handler;
        }
    }

    public u(Context context) {
        super(context);
        this.xj = false;
        this.zg = true;
        this.hf = false;
        this.jk = new SoftReference<>(null);
        this.pz = new SoftReference<>(null);
        this.ra = 0;
        this.dk = 2;
        this.et = 0;
        this.f10155io = 15000;
        this.z = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.w.u.u.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated: activity: ".concat(String.valueOf(activity)));
                Activity activity2 = (Activity) u.this.pz.get();
                if (activity2 == null) {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated: start transparent activity");
                    if (activity instanceof TTTransparentActivity) {
                        u.this.pz = new SoftReference(activity);
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated: start transparent activity, callSuperShowAd");
                        u uVar = u.this;
                        uVar.hf(uVar.x, activity, u.this.ai, u.this.q);
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated: end");
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated again, showingActivity: ".concat(String.valueOf(activity2)));
                String name = activity.getClass().getName();
                if ((activity2 instanceof TTTransparentActivity) && com.bytedance.msdk.core.admanager.xj.hf(name)) {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated again, is adn ad activity: ".concat(String.valueOf(activity)));
                    activity2.finish();
                    u.this.pz = new SoftReference(activity);
                } else {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated again, is not adn ad activity");
                }
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- onActivityCreated: end 2");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@ForbidWrapParam Activity activity) {
            }
        };
    }

    private int y() {
        CopyOnWriteArrayList<com.bytedance.msdk.hf.w> copyOnWriteArrayList;
        CopyOnWriteArrayList<com.bytedance.msdk.hf.w> copyOnWriteArrayList2;
        CopyOnWriteArrayList<com.bytedance.msdk.hf.w> copyOnWriteArrayList3;
        boolean z;
        com.bytedance.msdk.w.y.xj.hf hfVar = this.w;
        List<com.bytedance.msdk.core.tf.tf> list = null;
        if (hfVar != null) {
            copyOnWriteArrayList = hfVar.c();
            copyOnWriteArrayList2 = this.w.tf();
            copyOnWriteArrayList3 = this.w.f();
        } else {
            copyOnWriteArrayList = null;
            copyOnWriteArrayList2 = null;
            copyOnWriteArrayList3 = null;
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            z = false;
        } else {
            z = false;
            for (com.bytedance.msdk.hf.w wVar : copyOnWriteArrayList) {
                if (wVar != null && wVar.ff(this.kd) && !wVar.tu()) {
                    if (!u(wVar) && !com.bytedance.msdk.core.admanager.xj.xj(wVar.lw(), wVar.ci(), wVar.tj())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar2 : copyOnWriteArrayList3) {
                if (wVar2 != null && wVar2.ff(this.kd) && !wVar2.tu()) {
                    if (!u(wVar2) && !com.bytedance.msdk.core.admanager.xj.xj(wVar2.lw(), wVar2.ci(), wVar2.tj())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar3 : copyOnWriteArrayList2) {
                if (wVar3 != null && wVar3.ff(this.kd) && !wVar3.tu()) {
                    if (!u(wVar3) && !com.bytedance.msdk.core.admanager.xj.xj(wVar3.lw(), wVar3.ci(), wVar3.tj())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.core.tf.tf tfVar : list) {
                String yo = tfVar.yo();
                if (tfVar.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, yo, v()) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, this.y, false) == 3) {
                    if (!xj(tfVar) && !com.bytedance.msdk.core.admanager.xj.xj(tfVar.qt(), tfVar.g(), tfVar.y())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        return z ? 1 : 2;
    }

    public final void dk() {
        if (w()) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 用户点击了广告，停止轮播");
            kd();
        }
    }

    public final void ht() {
        if (w()) {
            this.zg = true;
            this.ra++;
            final Activity activity = this.jk.get();
            final Activity activity2 = this.pz.get();
            final com.bytedance.msdk.hf.w wVar = this.x;
            if (!xj(activity2, activity, wVar)) {
                kd();
                return;
            }
            Handler handler = this.ht;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                xj(this.ht, activity2);
                this.ht.postDelayed(new Runnable() { // from class: com.bytedance.msdk.w.u.u.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!u.this.xj(activity2)) {
                            u.this.kd();
                            return;
                        }
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播 开始，先showingActivity finish");
                        u.this.zg = false;
                        activity2.finish();
                        wVar.yo();
                        u.this.pz = new SoftReference(null);
                        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播开始 showingActivity finish end");
                        u.this.xj = true;
                        u uVar = u.this;
                        uVar.xj(activity, uVar.ai, u.this.q);
                    }
                }, this.f10155io);
            }
        }
    }

    @Override // com.bytedance.msdk.w.u.tf
    public boolean pz() {
        return this.xj;
    }

    public final void ra() {
        if (w()) {
            if (!this.zg) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 调用finish触发了close回调");
                return;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 用户关闭了广告，停止轮播");
            Activity activity = this.pz.get();
            if (activity instanceof TTTransparentActivity) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 用户关闭了广告，finish showingActivity");
                activity.finish();
                this.pz = new SoftReference<>(null);
            }
            kd();
        }
    }

    public void xj(Activity activity, Object obj, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        Handler handler = this.ht;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application xj2 = hf.xj.xj();
        if (xj2 != null) {
            xj2.unregisterActivityLifecycleCallbacks(this.z);
        }
    }

    private void u() {
        if (this.hf) {
            return;
        }
        Application xj2 = hf.xj.xj();
        if (xj2 == null) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- app is null, 插全屏轮播直接return");
            return;
        }
        xj2.unregisterActivityLifecycleCallbacks(this.z);
        xj2.registerActivityLifecycleCallbacks(this.z);
        this.hf = true;
    }

    private boolean w() {
        return this.et != 0;
    }

    public void hf(com.bytedance.msdk.api.xj.hf hfVar) {
        xj(hfVar);
        com.bytedance.msdk.core.tf.hf hfVar2 = this.c;
        if (hfVar2 != null) {
            this.et = hfVar2.am();
            if (!w()) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- inter full refresh is not enabled");
                return;
            }
            this.dk = this.c.qt();
            com.bytedance.msdk.core.tf.hf hfVar3 = this.c;
            int tf = hfVar3.tf(hfVar3.a());
            this.f10155io = tf;
            if (tf <= 0) {
                this.f10155io = 15000;
            }
            this.ht = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.bytedance.msdk.w.u.tf
    public void xj(com.bytedance.msdk.hf.w wVar, Activity activity, Object obj, String str) {
        if (w()) {
            u();
            this.jk = new SoftReference<>(activity);
            this.x = wVar;
            this.u = wVar;
            this.ai = obj;
            this.q = str;
            Intent intent = new Intent(com.bytedance.msdk.core.hf.getContext(), (Class<?>) TTTransparentActivity.class);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            com.bytedance.msdk.core.hf.getContext().startActivity(intent);
            return;
        }
        super.xj(wVar, activity, obj, str);
    }

    private boolean u(com.bytedance.msdk.hf.w wVar) {
        return wVar.sv() && wVar.dk() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.msdk.hf.w wVar, Activity activity, Object obj, String str) {
        super.xj(wVar, activity, obj, str);
    }

    private void xj(final Handler handler, final Activity activity) {
        int i = this.f10155io + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
        if (i <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bytedance.msdk.w.u.u.2
            @Override // java.lang.Runnable
            public void run() {
                if (!u.this.xj(activity)) {
                    u.this.kd();
                    return;
                }
                Toast makeText = Toast.makeText(com.bytedance.msdk.core.hf.getContext(), "2秒后播放下一个广告", 0);
                makeText.show();
                Handler handler2 = handler;
                handler2.postDelayed(new xj(makeText, 1, handler2), 1000L);
            }
        }, i);
    }

    private boolean xj(com.bytedance.msdk.core.tf.tf tfVar) {
        return tfVar.r() && tfVar.xj() != 1;
    }

    private boolean xj(Activity activity, Activity activity2, com.bytedance.msdk.hf.w wVar) {
        if (this.ra >= this.dk) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，轮播次数已达上限: " + this.dk);
            return false;
        }
        if (activity2 == null) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播 停止轮播 developerActivity为null");
            return false;
        }
        if (wVar == null) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，ttBaseAd为null，不轮播");
            return false;
        }
        if (u(wVar)) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，展示的是自定义adn，则不轮播");
            return false;
        }
        if (!com.bytedance.msdk.core.admanager.xj.xj(wVar.lw(), wVar.ci(), wVar.tj())) {
            if (activity != null) {
                return true;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，showingActivity是null，停止轮播");
            com.bytedance.msdk.kd.y.xj(this.y, 81010);
            return false;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，当前展示的广告不支持轮播: " + wVar.lw() + ", adtype: " + wVar.ci() + ", subType: " + wVar.tj());
        com.bytedance.msdk.kd.y.xj(this.y, 81011);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，showingActivity正在finish或已经destroy，停止轮播");
            return false;
        }
        int y = y();
        if (y == 2) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，无任何广告可用，停止轮播");
            com.bytedance.msdk.kd.y.xj(this.y, 81008);
            return false;
        }
        if (y == 1) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，仅有自定义adn广告可用，停止轮播");
            com.bytedance.msdk.kd.y.xj(this.y, 81009);
            return false;
        }
        int hf = hf.hf(this.kd);
        if (hf == 0) {
            return true;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播，命中了展示频控，停止轮播");
        com.bytedance.msdk.kd.y.xj(this.y, hf);
        return false;
    }
}
