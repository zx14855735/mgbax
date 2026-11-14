package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static AtomicBoolean xj;

    public static boolean c() {
        return com.bytedance.sdk.openadsdk.core.w.w.xj().d();
    }

    public static boolean f() {
        return false;
    }

    public static boolean hf() {
        return kd() && !com.bytedance.sdk.openadsdk.core.w.w.xj().f() && xj();
    }

    public static boolean kd() {
        return ai.hf;
    }

    public static int u() {
        return ai.hf ? 1 : 0;
    }

    public static boolean w() {
        return false;
    }

    public static boolean xj() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = xj;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext()).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (file.exists()) {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.u.xj.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i = ai.w;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String group = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(group) ? 0 : Integer.parseInt(group.substring(8))) > i;
                        } catch (Exception e) {
                            pl.xj(e);
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                if (listFiles != null && listFiles.length != 0) {
                    z = true;
                    xj(z);
                    return z;
                }
            }
            z = false;
            xj(z);
            return z;
        } catch (Throwable th) {
            pl.xj(th);
            return false;
        }
    }

    public static boolean y() {
        return kd() && f.zg().z();
    }

    public static void xj(boolean z) {
        if (xj == null) {
            xj = new AtomicBoolean();
        }
        xj.set(z);
        f.zg().qt();
    }
}
