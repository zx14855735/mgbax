package com.bytedance.sdk.component.adexpress.xj.hf;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.u.tf;
import com.bytedance.sdk.component.adexpress.xj.w.xj;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    static Object xj = new Object();

    static {
        FoNub();
    }

    private static /* synthetic */ void FoNub() {
        char[] charArray = "_SQ\u0012[]QY\u0012^SE\u0012OTYPP\u0012vRU~NUX[Y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '<');
        }
        String str = new String(charArray);
        char[] charArray2 = "_PURUH".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '<');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf() {
        try {
            f.u();
            File c = kd.c();
            if (c == null || !c.exists()) {
                return;
            }
            if (c.getParentFile() != null) {
                com.bytedance.sdk.component.utils.y.w(c.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.y.w(c);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean kd() {
        return kd.hf().u();
    }

    public static com.bytedance.sdk.component.adexpress.xj.w.xj u() {
        return kd.hf().kd();
    }

    public static String w() {
        return y.w();
    }

    @Deprecated
    private static String y() {
        com.bytedance.sdk.component.adexpress.xj.w.xj u = u();
        if (u == null) {
            return null;
        }
        return u.u();
    }

    private static File kd(String str) {
        List<Pair<String, String>> hf;
        xj.hf kd = u().kd();
        if (kd != null && (hf = kd.hf()) != null && hf.size() > 0) {
            for (Pair<String, String> pair : hf) {
                Object obj = pair.second;
                if (obj != null && ((String) obj).equals(str)) {
                    return new File(kd.c(), (String) pair.first);
                }
            }
        }
        return null;
    }

    private static File u(String str) {
        if (kd()) {
            Iterator<xj.C0107xj> it = u().getResources().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                xj.C0107xj next = it.next();
                if (next.xj() != null && next.xj().equals(str)) {
                    File file = new File(kd.c(), com.bytedance.sdk.component.utils.kd.hf(next.xj()));
                    String xj2 = com.bytedance.sdk.component.utils.kd.xj(file);
                    if (next.hf() == null || !next.hf().equals(xj2)) {
                        break;
                    }
                    return file;
                }
            }
        }
        return null;
    }

    private static boolean w(String str) {
        com.bytedance.sdk.component.adexpress.xj.w.xj u;
        List<xj.C0107xj> resources;
        if (!kd() || (u = u()) == null || (resources = u.getResources()) == null) {
            return false;
        }
        for (xj.C0107xj c0107xj : resources) {
            if (c0107xj != null && TextUtils.equals(str, c0107xj.xj())) {
                return true;
            }
        }
        return false;
    }

    public static void xj() {
        kd.hf();
    }

    public static void xj(com.bytedance.sdk.component.adexpress.xj.w.u uVar) {
        c.xj().xj(uVar, uVar.y);
    }

    public static Set<com.bytedance.sdk.component.adexpress.xj.w.hf> xj(String str, boolean z) {
        final Set<com.bytedance.sdk.component.adexpress.xj.w.hf> hf = c.xj().hf(str);
        if (hf != null && hf.size() > 0) {
            if (z) {
                com.bytedance.sdk.component.adexpress.u.kd.xj(new d("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.xj.hf.hf.1
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.hf((Set<com.bytedance.sdk.component.adexpress.xj.w.hf>) hf);
                    }
                }, 5);
                return hf;
            }
            hf(hf);
        }
        return hf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Set<com.bytedance.sdk.component.adexpress.xj.w.hf> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.xj.w.hf hfVar : set) {
                hfVar.xj(Long.valueOf(System.currentTimeMillis()));
                y.xj().xj(hfVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean w(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject == null || (opt = optJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static com.bytedance.sdk.component.adexpress.xj.w.hf xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.xj.w.hf xj2 = c.xj().xj(str);
        if (xj2 != null) {
            xj2.xj(Long.valueOf(System.currentTimeMillis()));
            xj(xj2);
        }
        return xj2;
    }

    public static String hf(String str) {
        com.bytedance.sdk.component.adexpress.xj.w.xj xjVar;
        com.bytedance.sdk.component.adexpress.xj.w.xj u = u();
        if (u == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj2 = u.xj();
            if (xj2 == null || xj2.size() <= 0 || (xjVar = xj2.get(str)) == null) {
                return null;
            }
            return xjVar.u();
        }
        return y();
    }

    private static void xj(final com.bytedance.sdk.component.adexpress.xj.w.hf hfVar) {
        com.bytedance.sdk.component.adexpress.u.kd.xj(new d("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.xj.hf.hf.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (hf.xj) {
                    y.xj().xj(hfVar, true);
                }
            }
        }, 10);
    }

    public static xj xj(String str, tf.xj xjVar, String str2, String str3) {
        File file;
        xj xjVar2 = new xj();
        if (TextUtils.isEmpty(str3)) {
            file = null;
        } else {
            file = hf(str3, str);
            if (file != null) {
                xjVar2.xj(1);
            }
        }
        if (file == null && (file = kd(str)) != null) {
            xjVar2.xj(3);
        }
        if (file == null && (file = u(str)) != null) {
            xjVar2.xj(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!xj(str, str3)) {
                xjVar2.xj(4);
            }
        } else if (!w(str)) {
            xjVar2.xj(6);
        }
        xjVar2.getType();
        if (file != null) {
            try {
                xjVar2.xj(new WebResourceResponse(xjVar.getType(), "utf-8", new FileInputStream(file)));
                return xjVar2;
            } catch (Throwable th) {
                pl.w("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return xjVar2;
    }

    private static File hf(String str, String str2) {
        com.bytedance.sdk.component.adexpress.xj.w.xj xjVar;
        com.bytedance.sdk.component.adexpress.xj.w.xj u = u();
        if (u != null && kd()) {
            Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj2 = u.xj();
            if (xj2.size() != 0 && (xjVar = xj2.get(str)) != null) {
                Iterator<xj.C0107xj> it = xjVar.getResources().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    xj.C0107xj next = it.next();
                    if (next.xj() != null && next.xj().equals(str2)) {
                        File file = new File(kd.c(), com.bytedance.sdk.component.utils.kd.hf(next.xj()));
                        String xj3 = com.bytedance.sdk.component.utils.kd.xj(file);
                        if (next.hf() == null || !next.hf().equals(xj3)) {
                            break;
                        }
                        return file;
                    }
                }
            }
        }
        return null;
    }

    public static boolean hf(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }

    private static boolean xj(String str, String str2) {
        com.bytedance.sdk.component.adexpress.xj.w.xj u;
        com.bytedance.sdk.component.adexpress.xj.w.xj xjVar;
        if (!kd() || (u = u()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj2 = u.xj();
        if (xj2.size() == 0 || (xjVar = xj2.get(str2)) == null) {
            return false;
        }
        for (xj.C0107xj c0107xj : xjVar.getResources()) {
            if (c0107xj != null && TextUtils.equals(str, c0107xj.xj())) {
                return true;
            }
        }
        return false;
    }

    public static boolean xj(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }
}
