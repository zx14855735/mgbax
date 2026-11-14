package com.bytedance.sdk.openadsdk.core.qt;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.io;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    private static AtomicBoolean c = new AtomicBoolean();
    private static AtomicInteger f = new AtomicInteger();
    private static volatile String kd;
    private static String y;
    private GLSurfaceView xj;
    private AtomicBoolean u = new AtomicBoolean();
    private Handler hf = com.bytedance.sdk.component.utils.f.xj();
    private Handler w = com.bytedance.sdk.component.utils.f.hf();

    public interface xj {
        void xj(GLSurfaceView gLSurfaceView);
    }

    static {
        HXIisCy();
    }

    private static /* synthetic */ void HXIisCy() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj() {
        if (!TextUtils.isEmpty(kd)) {
            return kd;
        }
        String w = com.bytedance.sdk.openadsdk.core.w.u.xj().w("dev20", Long.MAX_VALUE);
        kd = w;
        if (!TextUtils.isEmpty(w)) {
            return kd;
        }
        if (!TextUtils.isEmpty(y)) {
            return y;
        }
        String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("dev21", Long.MAX_VALUE);
        y = w2;
        if (!TextUtils.isEmpty(w2)) {
            return y;
        }
        if (f.addAndGet(1) >= 3) {
            return y;
        }
        String hf = io.hf("ro.board.gpu");
        y = hf;
        if (TextUtils.isEmpty(hf)) {
            y = io.hf("ro.hardware.egl");
        }
        if (!TextUtils.isEmpty(y)) {
            com.bytedance.sdk.openadsdk.core.w.u.xj().u("dev21", y);
        }
        return y;
    }

    public static void xj(View view) {
        if (TextUtils.isEmpty(kd) && (view instanceof ViewGroup) && pz.hf().en() && c.compareAndSet(false, true)) {
            String w = com.bytedance.sdk.openadsdk.core.w.u.xj().w("dev20", Long.MAX_VALUE);
            if (!TextUtils.isEmpty(w)) {
                kd = w;
            } else {
                new f().xj((ViewGroup) view, new c() { // from class: com.bytedance.sdk.openadsdk.core.qt.f.1
                    @Override // com.bytedance.sdk.openadsdk.core.qt.c
                    public void xj(String str) {
                        String unused = f.kd = str;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.w.u.xj().u("dev20", f.kd);
                    }
                });
            }
        }
    }

    public void xj(final ViewGroup viewGroup, final c cVar) {
        Handler handler = this.w;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context = viewGroup.getContext();
                        f.this.xj = new GLSurfaceView(context);
                        f.this.xj.setAlpha(0.0f);
                        f.this.xj.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                        viewGroup.addView(f.this.xj);
                        f fVar = f.this;
                        fVar.xj(viewGroup, fVar.xj, cVar, new xj() { // from class: com.bytedance.sdk.openadsdk.core.qt.f.2.1
                            @Override // com.bytedance.sdk.openadsdk.core.qt.f.xj
                            public void xj(GLSurfaceView gLSurfaceView) {
                                f.this.xj(gLSurfaceView);
                            }
                        });
                    } catch (Throwable th) {
                        pl.u("gpuInfo", th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final GLSurfaceView gLSurfaceView) {
        Handler handler = this.w;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.f.3
                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent = gLSurfaceView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(gLSurfaceView);
                    }
                    f.this.xj = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ViewGroup viewGroup, final GLSurfaceView gLSurfaceView, final c cVar, final xj xjVar) {
        final String[] strArr = new String[1];
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qt.f.4
            @Override // java.lang.Runnable
            public void run() {
                c cVar2;
                f.this.u.set(true);
                try {
                    gLSurfaceView.onPause();
                    String str = strArr[0];
                    if (str != null && (cVar2 = cVar) != null) {
                        cVar2.xj(str);
                    }
                    xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.xj(gLSurfaceView);
                    }
                } catch (Throwable th) {
                    pl.u("gpuInfo2", th.getMessage());
                }
            }
        };
        try {
            gLSurfaceView.setEGLContextClientVersion(2);
            gLSurfaceView.setRenderer(new GLSurfaceView.Renderer() { // from class: com.bytedance.sdk.openadsdk.core.qt.f.5
                @Override // android.opengl.GLSurfaceView.Renderer
                public void onDrawFrame(GL10 gl10) {
                    gLSurfaceView.setRenderMode(0);
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    strArr[0] = GLES20.glGetString(7937);
                    Handler handler = f.this.hf;
                    if (handler == null || f.this.u.get()) {
                        return;
                    }
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                }
            });
            gLSurfaceView.setRenderMode(0);
            Handler handler = this.hf;
            if (handler != null) {
                handler.postDelayed(runnable, 2000L);
            }
        } catch (Throwable th) {
            pl.u("gpuInfo1", th.getMessage());
        }
    }
}
