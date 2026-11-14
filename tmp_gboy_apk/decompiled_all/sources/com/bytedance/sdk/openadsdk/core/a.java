package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a {
    private static final HashSet<String> c;
    private static final HashSet<String> f;
    private static final boolean xj = com.bytedance.sdk.openadsdk.core.a.io.zg();
    private static final boolean hf = xj();
    private static int w = -1;
    private static int u = -1;
    private static int kd = -1;
    private static Handler y = null;

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        c = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        f = hashSet2;
        eWIKA();
    }

    private static /* synthetic */ void eWIKA() {
        char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '2');
        }
        String str = new String(charArray);
        char[] charArray2 = "Q^[\\[F".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '2');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(com.bytedance.sdk.component.g.w wVar) {
        if (wVar == null) {
            return;
        }
        wVar.setWebChromeClient(null);
        wVar.setWebViewClient(null);
        View view = wVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        wVar.removeAllViews();
        try {
            wVar.destroy();
        } catch (Throwable unused) {
        }
    }

    public static void xj(final Context context, final com.bytedance.sdk.component.g.w wVar) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.hf(context, wVar);
            }
        });
    }

    public static void hf(Context context, com.bytedance.sdk.component.g.w wVar) {
        if (context == null || wVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                wVar.loadUrl("about:blank");
                if (kd > 0) {
                    View rootView = wVar.getView().getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(createBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean xj() {
        return xj;
    }

    public static void xj(final com.bytedance.sdk.component.g.w wVar) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.w(com.bytedance.sdk.component.g.w.this);
            }
        });
    }
}
