package com.bytedance.sdk.component.adexpress.xj.hf;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.xj.w.xj;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w {
    public List<xj.C0107xj> hf(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar, com.bytedance.sdk.component.adexpress.xj.w.xj xjVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<xj.C0107xj> arrayList3 = new ArrayList<>();
        if (xjVar2 == null || xjVar2.getResources().isEmpty()) {
            arrayList2.addAll(xjVar.getResources());
        } else if (xjVar.getResources().isEmpty()) {
            arrayList.addAll(xjVar2.getResources());
        } else {
            for (xj.C0107xj c0107xj : xjVar.getResources()) {
                if (!xjVar2.getResources().contains(c0107xj) && c0107xj != null && c0107xj.xj() != null && c0107xj.hf() != null) {
                    arrayList2.add(c0107xj);
                }
            }
            for (xj.C0107xj c0107xj2 : xjVar2.getResources()) {
                if (!xjVar.getResources().contains(c0107xj2)) {
                    arrayList.add(c0107xj2);
                }
            }
        }
        if (xj(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void w(List<xj.C0107xj> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<xj.C0107xj> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(xj(), com.bytedance.sdk.component.utils.kd.hf(it.next().xj()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public abstract File xj();

    public boolean xj(Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.xj.w.xj xjVar = map.get(it.next());
            if (xjVar != null && !xj(xjVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    public boolean xj(List<xj.C0107xj> list) {
        if (list == null || list.size() <= 0 || xj() == null) {
            return false;
        }
        for (xj.C0107xj c0107xj : list) {
            String hf = com.bytedance.sdk.component.utils.kd.hf(c0107xj.xj());
            if (TextUtils.isEmpty(hf)) {
                return false;
            }
            File file = new File(xj(), hf);
            String xj = com.bytedance.sdk.component.utils.kd.xj(file);
            if (!file.exists() || !file.isFile() || c0107xj.hf() == null || !c0107xj.hf().equals(xj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean w(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar, com.bytedance.sdk.component.adexpress.xj.w.xj xjVar2) {
        if (xjVar != null) {
            try {
                if (!TextUtils.isEmpty(xjVar.w())) {
                    if (xjVar2 == null) {
                        return false;
                    }
                    if (xj(xjVar.w(), xjVar2.w())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj = xjVar.xj();
                    Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj2 = xjVar2.xj();
                    if (xj.isEmpty()) {
                        return !xj2.isEmpty();
                    }
                    if (xj2.isEmpty()) {
                        return false;
                    }
                    return xj(xj, xj2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    public boolean xj(xj.hf hfVar) {
        if (hfVar == null || xj() == null) {
            return false;
        }
        List<Pair<String, String>> hf = hfVar.hf();
        if (hf == null || hf.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = hf.iterator();
        while (it.hasNext()) {
            File file = new File(xj(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public void hf(List<xj.C0107xj> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<xj.C0107xj> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(xj(), com.bytedance.sdk.component.utils.kd.hf(it.next().xj()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<xj.C0107xj> xj(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar, com.bytedance.sdk.component.adexpress.xj.w.xj xjVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj = xjVar.xj();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<xj.C0107xj> arrayList3 = new ArrayList<>();
        if (xj.size() == 0) {
            if (xjVar2 != null && xjVar2.xj().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj2 = xjVar2.xj();
                Iterator<String> it = xj2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.xj.w.xj xjVar3 = xj2.get(it.next());
                    if (xjVar3 != null) {
                        arrayList.addAll(xjVar3.getResources());
                    }
                }
            }
        } else if (xjVar2 != null && xjVar2.xj().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> xj3 = xjVar2.xj();
            for (String str : xj.keySet()) {
                com.bytedance.sdk.component.adexpress.xj.w.xj xjVar4 = xj.get(str);
                com.bytedance.sdk.component.adexpress.xj.w.xj xjVar5 = xj3.get(str);
                if (xjVar5 == null && xjVar4 != null) {
                    arrayList2.addAll(xjVar4.getResources());
                } else if (xjVar4 == null && xjVar5 != null) {
                    arrayList.addAll(xjVar5.getResources());
                } else if (xjVar4 != null) {
                    for (xj.C0107xj c0107xj : xjVar4.getResources()) {
                        if (c0107xj != null && !xjVar5.getResources().contains(c0107xj) && c0107xj.hf() != null && c0107xj.xj() != null) {
                            arrayList2.add(c0107xj);
                        }
                    }
                    for (xj.C0107xj c0107xj2 : xjVar5.getResources()) {
                        if (c0107xj2 != null && !xjVar4.getResources().contains(c0107xj2)) {
                            arrayList.add(c0107xj2);
                        }
                    }
                }
            }
        } else if (xj.size() != 0) {
            Iterator<String> it2 = xj.keySet().iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.component.adexpress.xj.w.xj xjVar6 = xj.get(it2.next());
                if (xjVar6 != null) {
                    arrayList2.addAll(xjVar6.getResources());
                }
            }
        }
        if (xj(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public static void hf(File file, com.bytedance.sdk.component.adexpress.xj.w.xj xjVar, String str) {
        if (xjVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (xjVar.getResources() != null) {
            Iterator<xj.C0107xj> it = xjVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.kd.hf(it.next().xj())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private boolean xj(List<xj.C0107xj> list, List<xj.C0107xj> list2) {
        for (xj.C0107xj c0107xj : list) {
            String xj = c0107xj.xj();
            String hf = com.bytedance.sdk.component.utils.kd.hf(xj);
            File file = new File(xj(), hf);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.d.hf.hf u = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().u();
            u.xj(xj);
            u.xj(xj().getAbsolutePath(), hf);
            com.bytedance.sdk.component.d.hf xj2 = u.xj();
            list2.add(c0107xj);
            if (xj2 == null || !xj2.f() || xj2.c() == null || !xj2.c().exists()) {
                w(list2);
                return false;
            }
        }
        return true;
    }

    public boolean xj(String str) {
        File file = new File(xj().getAbsoluteFile(), CtFAbx.AcNBzu(com.bytedance.sdk.component.utils.kd.hf(str), ".zip"));
        com.bytedance.sdk.component.d.hf.hf u = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().u();
        u.xj(str);
        u.xj(file.getParent(), file.getName());
        com.bytedance.sdk.component.d.hf xj = u.xj();
        if (xj.f() && xj.c() != null && xj.c().exists()) {
            File c = xj.c();
            try {
                z.xj(c.getAbsolutePath(), file.getParent());
                if (!c.exists()) {
                    return true;
                }
                c.delete();
                return true;
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return false;
    }

    public void xj(int i) {
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().u() != null) {
            com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().u().xj(i);
        }
    }

    public static void xj(File file, com.bytedance.sdk.component.adexpress.xj.w.xj xjVar, String str) {
        FileOutputStream fileOutputStream;
        if (xjVar == null) {
            return;
        }
        String f = xjVar.f();
        if (TextUtils.isEmpty(f)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file3);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(f.getBytes("utf-8"));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    pl.w("PlayComponentEngineCacheManager", "version save error3", th);
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th3) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (IOException unused2) {
        }
    }

    private static boolean xj(Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> map, Map<String, com.bytedance.sdk.component.adexpress.xj.w.xj> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.xj.w.xj xjVar = map.get(str);
            if (xjVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.xj.w.xj xjVar2 = map2.get(str);
            if (xjVar2 == null) {
                return false;
            }
            if (xj(xjVar.w(), xjVar2.w())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean xj(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = 0
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.xj.hf.w.xj(java.lang.String, java.lang.String):boolean");
    }

    @Deprecated
    public static boolean xj(com.bytedance.sdk.component.adexpress.xj.w.xj xjVar, String str) {
        if (xjVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(xjVar.w())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return xj(xjVar.w(), str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
