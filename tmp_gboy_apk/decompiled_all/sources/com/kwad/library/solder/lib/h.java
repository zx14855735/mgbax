package com.kwad.library.solder.lib;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        Objects.toString(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                StringBuilder sb = new StringBuilder();
                sb.append(file2.getAbsolutePath());
                hashSet.add(new File(CtFAbx.B25kr6(sb, File.separator, str)));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.auD.BV());
        w.Y(file3);
        Iterator<String> it = com.kwad.library.solder.lib.d.c.b(file, file3).iterator();
        while (it.hasNext()) {
            File a2 = com.kwad.library.solder.lib.d.c.a(file3, it.next(), file2);
            if (a2 != null) {
                hashSet.add(a2);
            }
        }
        w.T(file3);
        return hashSet;
    }

    private void c(Set<File> set) {
        com.kwad.library.solder.lib.c.b bVar = this.ave;
        if (bVar == null || bVar.avR.size() <= 0 || set == null) {
            return;
        }
        for (Map.Entry<String, String> entry : this.ave.avR.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                for (File file : set) {
                    String fileMD5Digest = al.getFileMD5Digest(file);
                    if (file.getName().equals(key)) {
                        if (!TextUtils.equals(fileMD5Digest, value)) {
                            d(set);
                            throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + fileMD5Digest + ",except " + value), 4008);
                        }
                    }
                }
                throw new PluginError.LoadError(new Exception(CtFAbx.AcNBzu(key, " not found")), 4001);
            }
        }
    }

    private static void d(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            w.T(it.next());
        }
    }

    private File f(File file) {
        File file2 = new File(file.getParentFile(), this.auD.BU());
        w.Y(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void k(Context context, String str) {
        ClassLoader classLoader;
        super.k(context, str);
        getId();
        File file = new File(str);
        try {
            File f = f(file);
            this.auY = f;
            try {
                try {
                    c(a(context, file, f));
                    com.kwad.library.solder.lib.c.b bVar = this.ave;
                    if (bVar == null || (classLoader = bVar.avU) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            try {
                                com.kwad.library.solder.lib.ext.d.c(classLoader, this.auY);
                            } finally {
                                PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (PluginError.LoadError e) {
                    w.T(file);
                    throw e;
                }
            } catch (IOException th2) {
                throw new PluginError.LoadError(th2, r1);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4003);
        }
    }
}
