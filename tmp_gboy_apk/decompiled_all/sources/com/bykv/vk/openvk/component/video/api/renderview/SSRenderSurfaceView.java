package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.hf;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, hf {
    private static final ArrayList<w> w = new ArrayList<>();
    private w hf;
    private hf.xj u;
    private WeakReference<xj> xj;

    static {
        HjeKgH();
    }

    private static /* synthetic */ void HjeKgH() {
        char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '@');
        }
        String str = new String(charArray);
        char[] charArray2 = "#,).)4".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '@');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(hf.xj xjVar) {
        this.u = xjVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<xj> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().xj(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<xj> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            this.xj.get().xj(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<xj> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().hf(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(xj xjVar) {
        this.xj = new WeakReference<>(xjVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<w> it = w.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (next != null && next.xj() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.hf);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
