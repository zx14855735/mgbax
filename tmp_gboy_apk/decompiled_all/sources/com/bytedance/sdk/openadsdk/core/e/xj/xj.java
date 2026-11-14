package com.bytedance.sdk.openadsdk.core.e.xj;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.y.hf;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private JSONObject xj;

    public String toString() {
        JSONObject jSONObject = this.xj;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean xj() {
        JSONObject jSONObject = this.xj;
        if (jSONObject != null && jSONObject.optInt(PointParamKey.TYPE) > 0) {
            return hf.xj((float) this.xj.optDouble("rate"), false);
        }
        return false;
    }

    public static xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xj(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static xj xj(JSONObject jSONObject) {
        xj xjVar = new xj();
        xjVar.xj = jSONObject;
        return xjVar;
    }

    public void xj(WebView webView, final ws wsVar) {
        View view;
        if (xj() && webView != null) {
            try {
                System.currentTimeMillis();
                if (Build.VERSION.SDK_INT >= 28 && webView.getLayerType() == 2 && (view = (View) webView.getParent()) != null) {
                    int measuredWidth = (int) (view.getMeasuredWidth() * 0.6d);
                    int measuredHeight = (int) (view.getMeasuredHeight() * 0.6d);
                    if (xj(pz.getContext(), measuredWidth, measuredHeight)) {
                        final Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
                        view.draw(new Canvas(createBitmap));
                        System.currentTimeMillis();
                        c.hf(new d("") { // from class: com.bytedance.sdk.openadsdk.core.e.xj.xj.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        System.currentTimeMillis();
                                        xj.this.xj(createBitmap, wsVar);
                                        System.currentTimeMillis();
                                    } catch (Throwable th) {
                                        try {
                                            th.getMessage();
                                            if (createBitmap.isRecycled()) {
                                                return;
                                            }
                                            createBitmap.recycle();
                                        } finally {
                                            try {
                                                if (!createBitmap.isRecycled()) {
                                                    createBitmap.recycle();
                                                }
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Bitmap bitmap, ws wsVar) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.4f, 0.4f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        try {
            bitmap.recycle();
        } catch (Throwable th) {
            th.getMessage();
        }
        float height = createBitmap.getHeight() * createBitmap.getWidth();
        float f = 0.0f;
        for (int i = 0; i < createBitmap.getWidth(); i++) {
            for (int i2 = 0; i2 < createBitmap.getHeight(); i2++) {
                if (createBitmap.getPixel(i, i2) == -1) {
                    f += 1.0f;
                }
            }
        }
        try {
            createBitmap.recycle();
        } catch (Throwable th2) {
            th2.getMessage();
        }
        if ((f / height) * 100.0f > 95.0d) {
            JSONObject jSONObject = new JSONObject();
            if (wsVar != null) {
                jSONObject.put("url", wsVar.ol());
                jSONObject.put(MediationConstant.EXTRA_ADID, wsVar.jq());
                jSONObject.put("cid", wsVar.ho());
            }
            am.xj().f(jSONObject);
        }
    }

    public boolean xj(Context context, int i, int i2) {
        ActivityManager.MemoryInfo memoryInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
        } catch (Exception unused) {
        }
        if (memoryInfo.lowMemory) {
            return false;
        }
        return memoryInfo.availMem > Math.max((long) Math.max(((double) memoryInfo.totalMem) * 0.02d, 5.24288E7d), (long) (((float) ((i * i2) * 2)) * 2.0f));
    }
}
