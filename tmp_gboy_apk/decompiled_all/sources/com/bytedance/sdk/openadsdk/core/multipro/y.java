package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;
import io.dcloud.openapi.core.util.Const;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements u.xj {
    private static WeakReference<Context> hf;
    private static List<u.xj> w;
    private static volatile y xj;

    static {
        List<u.xj> synchronizedList = Collections.synchronizedList(new ArrayList());
        w = synchronizedList;
        synchronizedList.add(new w());
        w.add(new com.bytedance.sdk.openadsdk.core.multipro.xj.hf());
        w.add(new com.bytedance.sdk.openadsdk.core.multipro.w.xj());
        w.add(new xj(new com.bytedance.sdk.component.f.hf.hf.hf.xj(Const.TYPE_CSJ)));
        Iterator<u.xj> it = w.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
        MPGQA();
    }

    private y() {
    }

    private static /* synthetic */ void MPGQA() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Context getContext() {
        WeakReference<Context> weakReference = hf;
        return (weakReference == null || weakReference.get() == null) ? pz.getContext() : hf.get();
    }

    private boolean hf(Uri uri) {
        return true;
    }

    public static y xj(Context context) {
        if (context != null) {
            hf = new WeakReference<>(context.getApplicationContext());
        }
        if (xj == null) {
            synchronized (y.class) {
                try {
                    if (xj == null) {
                        xj = new y();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            u.xj xj2 = xj(uri);
            if (xj2 != null) {
                return xj2.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        try {
            u.xj xj2 = xj(uri);
            if (xj2 != null) {
                return xj2.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
        Iterator<u.xj> it = w.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            u.xj xj2 = xj(uri);
            if (xj2 != null) {
                return xj2.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            u.xj xj2 = xj(uri);
            if (xj2 != null) {
                return xj2.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            u.xj xj2 = xj(uri);
            if (xj2 != null) {
                return xj2.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private u.xj xj(Uri uri) {
        if (uri == null || !hf(uri)) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (u.xj xjVar : w) {
            if (str.equals(xjVar.getTableName())) {
                return xjVar;
            }
        }
        return null;
    }
}
