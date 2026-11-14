package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EmptyView extends View implements ai.xj {
    private boolean am;
    private List<View> c;
    private final Handler d;
    private int e;
    private int f;
    private String g;
    private volatile boolean hf;
    private List<View> kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private ws f10273pl;
    private boolean qt;
    private final AtomicBoolean tf;
    private View u;
    private xj w;
    private volatile boolean xj;
    private List<View> y;
    private final AtomicBoolean zg;

    public static final class hf implements xj {
        private final xj xj;

        public hf(xj xjVar) {
            this.xj = xjVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
        public void hf() {
            if (this.xj != null) {
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.hf.3
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj.hf();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
        public void xj(final boolean z) {
            if (this.xj != null) {
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.hf.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj.xj(z);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
        public void xj() {
            if (this.xj != null) {
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.hf.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj.xj();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
        public void xj(final View view, final Map<String, Object> map) {
            if (this.xj != null) {
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.hf.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj.xj(view, map);
                    }
                });
            }
        }
    }

    public interface xj {
        void hf();

        void xj();

        void xj(View view, Map<String, Object> map);

        void xj(boolean z);
    }

    public EmptyView(Context context, View view) {
        super(pz.getContext());
        this.hf = true;
        this.tf = new AtomicBoolean(true);
        this.p = 1000;
        this.am = false;
        this.qt = false;
        this.zg = new AtomicBoolean(false);
        this.e = 0;
        this.u = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.d = new com.bytedance.sdk.component.utils.ai(com.bytedance.sdk.openadsdk.x.c.hf(), this);
        this.am = pz.hf().ap();
        this.qt = pz.hf().ee();
    }

    public static /* synthetic */ int w(EmptyView emptyView) {
        int i = emptyView.e;
        emptyView.e = i + 1;
        return i;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zg.set(false);
        u();
        if (this.am) {
            xj("checkWhenAddToWindow");
        }
        hf();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.zg.set(false);
        kd();
        w();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(z);
        }
    }

    public void setAdType(int i) {
        this.f = i;
    }

    public void setCallback(xj xjVar) {
        this.w = new hf(xjVar);
    }

    public void setNeedCheckingShow(final boolean z) {
        this.zg.set(false);
        this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.hf = z;
                if (!z && EmptyView.this.xj) {
                    EmptyView.this.kd();
                } else {
                    if (!z || EmptyView.this.xj) {
                        return;
                    }
                    EmptyView.this.u();
                }
            }
        });
    }

    public void setRefClickViews(List<View> list) {
        this.kd = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.y = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.c = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.xj = false;
                EmptyView.this.d.removeMessages(1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.hf || EmptyView.this.xj) {
                    return;
                }
                EmptyView.this.xj = true;
                EmptyView.w(EmptyView.this);
                Message obtain = Message.obtain();
                obtain.what = 1;
                EmptyView.this.d.handleMessage(obtain);
            }
        });
    }

    private void w() {
        xj xjVar;
        if (this.tf.getAndSet(true) || (xjVar = this.w) == null) {
            return;
        }
        xjVar.hf();
    }

    private void hf() {
        xj xjVar;
        if (!this.tf.getAndSet(false) || (xjVar = this.w) == null) {
            return;
        }
        xjVar.xj();
    }

    public void xj() {
        xj(this.kd, (com.bytedance.sdk.openadsdk.core.hf.u) null);
        xj(this.y, (com.bytedance.sdk.openadsdk.core.hf.u) null);
        xj(this.c, (com.bytedance.sdk.openadsdk.core.hf.u) null);
    }

    public void xj(List<View> list, com.bytedance.sdk.openadsdk.core.hf.u uVar) {
        if (com.bytedance.sdk.component.utils.tf.hf(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(uVar);
                    view.setOnTouchListener(uVar);
                }
            }
        }
    }

    public void xj(final String str) {
        this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.hf) {
                        EmptyView.this.xj(8, (String) null);
                    }
                    if (!EmptyView.this.xj) {
                        EmptyView.this.xj(EmptyView.this.zg.get() ? 10 : 9, (String) null);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                EmptyView.this.d.handleMessage(obtain);
            }
        });
    }

    public void xj(ws wsVar, String str) {
        this.f10273pl = wsVar;
        this.g = str;
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.p = i;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i;
        boolean z = false;
        boolean z2 = this.am || this.qt;
        Object obj = message.obj;
        if ((obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()))) {
            z = true;
        }
        if (message.what != 1) {
            return;
        }
        if (this.xj || (z2 && z)) {
            String str = null;
            if (!z2) {
                if (l.hf(this.u, 20, this.f)) {
                    kd();
                    xj xjVar = this.w;
                    if (xjVar != null) {
                        xjVar.xj(this.u, null);
                        return;
                    }
                    return;
                }
                this.d.sendEmptyMessageDelayed(1, this.p);
                return;
            }
            try {
                i = l.xj(this.u, 20, this.f);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
                str = th.getMessage();
                i = 7;
            }
            if (i == 0) {
                kd();
                if (this.w != null && !this.zg.get()) {
                    this.zg.set(true);
                    this.w.xj(this.u, xj(z, message));
                }
            } else if (!z) {
                this.d.sendEmptyMessageDelayed(1, this.p);
            }
            Object obj2 = message.obj;
            if ((obj2 instanceof String) && TextUtils.equals("checkWhenClicked", obj2.toString())) {
                xj(i, str);
            }
        }
    }

    private Map<String, Object> xj(boolean z, Message message) {
        if (!z) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
            hashMap.put("show_send_type", 2);
            return hashMap;
        }
        if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
            hashMap.put("show_send_type", 1);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str) {
        HashMap hashMap = new HashMap();
        if (i == 0) {
            hashMap.put("is_success", Boolean.TRUE);
        } else {
            hashMap.put("is_success", Boolean.FALSE);
            if (i != 7) {
                str = l.xj(i);
            }
            hashMap.put("error_code", Integer.valueOf(i));
            hashMap.put("error_message", str);
        }
        hashMap.put("checking_cnt", Integer.valueOf(this.e));
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.f10273pl, this.g, hashMap);
    }
}
