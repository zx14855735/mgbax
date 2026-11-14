package com.bytedance.sdk.openadsdk.ats;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.SparseArray;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.component.u.d;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements d, Function {
    private static File hf;
    private static final Set<String> w = new HashSet();
    private Map<String, com.bytedance.sdk.component.u.hf.w> xj = new ConcurrentHashMap();

    static {
        Ufpe();
    }

    public u() {
        w.add("sp_bidding_opt_libra");
    }

    private static /* synthetic */ void Ufpe() {
        char[] charArray = "´¸ºù°¶º²ùµ¸®ù¤¿²»»ù\u009d¹¾\u0095¥¾³°²".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 215);
        }
        String str = new String(charArray);
        char[] charArray2 = "´»¾¹¾£".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 215);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private com.bytedance.sdk.component.c.xj hf() {
        return com.bytedance.sdk.component.c.w.kd.xj() ? new com.bytedance.sdk.component.c.w.kd(null) : new com.bytedance.sdk.component.c.w.y(null);
    }

    private static File u() {
        String name;
        File filesDir = pz.getContext().getFilesDir();
        do {
            name = filesDir.getName();
            if (name == null) {
                break;
            }
            filesDir = filesDir.getParentFile();
        } while (!name.equals("files"));
        return new File(filesDir, "shared_prefs");
    }

    private com.bytedance.sdk.component.u.hf.w w(String str) {
        int xe = pz.hf().xe();
        com.bytedance.sdk.openadsdk.core.j.y fc = pz.hf().fc();
        if (xe != 3 || Build.VERSION.SDK_INT == 27) {
            return new com.bytedance.sdk.component.c.w.u(pz.getContext().getSharedPreferences(u(str), 0));
        }
        File hf2 = hf(str);
        return new com.bytedance.sdk.component.c.w.w(hf2, xj(hf2, str), xj(str, fc.xj), fc.hf);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            com.bytedance.sdk.component.u.hf.w wVar = get((String) sparseArray.get(1));
            return wVar != null ? new com.bytedance.sdk.component.u.hf.u(wVar) : wVar;
        }
        if (intValue == 2) {
            com.bytedance.sdk.component.u.hf.w xj = xj((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            return xj != null ? new com.bytedance.sdk.component.u.hf.u(xj) : xj;
        }
        if (intValue == 3) {
            com.bytedance.sdk.component.u.hf.xj encrypt = getEncrypt(((Integer) sparseArray.get(1)).intValue());
            return encrypt != null ? new com.bytedance.sdk.component.u.hf.hf(encrypt) : encrypt;
        }
        if (intValue == 4) {
            store();
            return null;
        }
        if (intValue != 5) {
            return null;
        }
        xj();
        return null;
    }

    @Override // com.bytedance.sdk.component.u.d
    public com.bytedance.sdk.component.u.hf.w get(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.bytedance.sdk.component.u.hf.w wVar = this.xj.get(str);
        if (wVar != null) {
            return wVar;
        }
        synchronized (this.xj) {
            try {
                com.bytedance.sdk.component.u.hf.w wVar2 = this.xj.get(str);
                if (wVar2 != null) {
                    return wVar2;
                }
                com.bytedance.sdk.component.u.hf.w w2 = w(str);
                this.xj.put(str, w2);
                return w2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.sdk.component.u.d
    public com.bytedance.sdk.component.u.hf.xj getEncrypt(int i) {
        if (i != 32) {
            return null;
        }
        return new com.bytedance.sdk.component.c.xj.xj();
    }

    @Override // com.bytedance.sdk.component.u.d
    public void store() {
        Iterator<String> it = this.xj.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.u.hf.w wVar = this.xj.get(it.next());
            if (wVar != null) {
                wVar.apply();
            }
        }
    }

    public com.bytedance.sdk.component.u.hf.w xj(String str, int i) {
        return get(str);
    }

    private com.bytedance.sdk.component.c.xj xj(File file, String str) {
        if (w.contains(str)) {
            return hf();
        }
        if (ai.w < 6900) {
            return hf();
        }
        xj(file);
        return new com.bytedance.sdk.component.c.w.xj(null);
    }

    public static File hf(String str) {
        if (hf == null) {
            hf = u();
        }
        return new File(hf, CtFAbx.B25kr6(new StringBuilder(), u(str), ".xml"));
    }

    private static String u(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(str) : str;
    }

    private com.bytedance.sdk.component.c.hf xj(String str, boolean z) {
        if (w.contains(str)) {
            return w();
        }
        com.bytedance.sdk.component.c.xj.xj xjVar = z ? new com.bytedance.sdk.component.c.xj.xj() : null;
        if (Build.VERSION.SDK_INT != 27 && ai.w >= 6900) {
            return new com.bytedance.sdk.component.c.w.xj(xjVar);
        }
        return w();
    }

    private com.bytedance.sdk.component.c.hf w() {
        if (com.bytedance.sdk.component.c.w.kd.xj()) {
            return new com.bytedance.sdk.component.c.w.kd(null);
        }
        return new com.bytedance.sdk.component.c.w.y(null);
    }

    private void xj(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }

    public void xj() {
        synchronized (this.xj) {
            this.xj.clear();
        }
    }

    public static com.bytedance.sdk.component.u.hf.w xj(String str) {
        return ((d) w.xj("kv_store_factory")).get(str);
    }

    public static SharedPreferences xj(@ForbidWrapParam Context context, String str, int i) {
        return xj(str);
    }
}
