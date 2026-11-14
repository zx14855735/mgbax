package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a aHS;

    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    public static final class C0358a {
        static final a aHT = new a(0);

        static {
            PTxsRKQ();
        }

        private static /* synthetic */ void PTxsRKQ() {
            char[] charArray = "JFD\u0007NHDL\u0007KFP\u0007ZALEE\u0007cG@k[@MNL".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ ')');
            }
            String str = new String(charArray);
            char[] charArray2 = "JE@G@]".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ ')');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private a() {
    }

    public static a IJ() {
        return C0358a.aHT;
    }

    private boolean IK() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.aHS == null;
    }

    private File dU(String str) {
        if (IK() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aHS, str);
    }

    private synchronized void init(Context context) {
        if (this.aHS != null || context == null) {
            return;
        }
        try {
            this.aHS = com.kwad.sdk.core.diskcache.a.a.a(be.dQ(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public final boolean a(String str, a.C0366a c0366a) {
        File dU;
        if (!IK() && !TextUtils.isEmpty(str)) {
            String dV = c.dV(str);
            if (b.a(this.aHS, str, dV, c0366a) && (dU = dU(dV)) != null && dU.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, String str2, a.C0366a c0366a) {
        File dU;
        if (!IK() && !TextUtils.isEmpty(str)) {
            String dV = c.dV(str2);
            if (b.a(this.aHS, str, dV, c0366a) && (dU = dU(dV)) != null && dU.exists()) {
                return true;
            }
        }
        return false;
    }

    public final File cr(String str) {
        if (IK() || TextUtils.isEmpty(str)) {
            return null;
        }
        return dU(c.dV(str));
    }

    public final void dT(String str) {
        if (IK() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aHS, str, c.dV(str));
    }

    public final void delete() {
        if (IK()) {
            return;
        }
        try {
            this.aHS.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (IK()) {
            return false;
        }
        try {
            ax.aA(str, "cacheKey is not allowed empty");
            return this.aHS.remove(c.dV(str));
        } catch (IOException unused) {
            return false;
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }
}
