package com.bykv.vk.openvk.component.video.xj.xj.xj;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bykv.vk.openvk.component.video.api.xj.hf {
    private String xj = "video_reward_full";
    private String hf = "video_brand";
    private String w = "video_splash";
    private String u = "video_default";
    private String kd = null;
    private String y = null;
    private String c = null;
    private String f = null;
    private String d = null;

    private Set<String> c() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.xj.xj.xj xjVar : com.bykv.vk.openvk.component.video.xj.xj.xj.xj.values()) {
            if (xjVar != null && xjVar.xj() != null) {
                u xj = xjVar.xj();
                hashSet.add(com.bykv.vk.openvk.component.video.xj.kd.w.hf(xj.kd(), xj.e()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.xj.kd.w.w(xj.kd(), xj.e()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.xj.xj.hf.hf hfVar : com.bykv.vk.openvk.component.video.xj.xj.hf.w.xj.values()) {
            if (hfVar != null && hfVar.xj() != null) {
                u xj2 = hfVar.xj();
                hashSet.add(com.bykv.vk.openvk.component.video.xj.kd.w.hf(xj2.kd(), xj2.e()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.xj.kd.w.w(xj2.kd(), xj2.e()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    private List<com.bykv.vk.openvk.component.video.api.xj.xj> y() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.xj.xj(new File(xj()).listFiles(), com.bykv.vk.openvk.component.video.xj.xj.w()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.xj.xj(new File(w()).listFiles(), com.bykv.vk.openvk.component.video.xj.xj.hf()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.xj.xj(new File(hf()).listFiles(), com.bykv.vk.openvk.component.video.xj.xj.u()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.xj.xj(new File(u()).listFiles(), com.bykv.vk.openvk.component.video.xj.xj.kd()));
        return arrayList;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String hf() {
        if (this.c == null) {
            this.c = this.kd + File.separator + this.hf;
            File file = new File(this.c);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public synchronized void kd() {
        try {
            com.bykv.vk.openvk.component.video.api.y.w.xj("Exec clear video cache ");
            com.bykv.vk.openvk.component.video.api.y.w.xj(this.kd);
            List<com.bykv.vk.openvk.component.video.api.xj.xj> y = y();
            if (Build.VERSION.SDK_INT >= 23) {
                Set<String> set = null;
                for (com.bykv.vk.openvk.component.video.api.xj.xj xjVar : y) {
                    File[] xj = xjVar.xj();
                    if (xj != null && xj.length >= xjVar.hf()) {
                        if (set == null) {
                            set = c();
                        }
                        int hf = xjVar.hf() - 2;
                        if (hf < 0) {
                            hf = 0;
                        }
                        xj(xjVar.xj(), hf, set);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String u() {
        if (this.d == null) {
            this.d = this.kd + File.separator + this.u;
            File file = new File(this.d);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String w() {
        if (this.f == null) {
            this.f = this.kd + File.separator + this.w;
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public void xj(String str) {
        this.kd = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public String xj() {
        if (this.y == null) {
            this.y = this.kd + File.separator + this.xj;
            File file = new File(this.y);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public long hf(u uVar) {
        if (TextUtils.isEmpty(uVar.kd()) || TextUtils.isEmpty(uVar.e())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.xj.kd.w.xj(uVar.kd(), uVar.e());
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj.hf
    public boolean xj(u uVar) {
        if (TextUtils.isEmpty(uVar.kd()) || TextUtils.isEmpty(uVar.e())) {
            return false;
        }
        return new File(uVar.kd(), uVar.e()).exists();
    }

    private static void xj(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List asList = Arrays.asList(fileArr);
                    Collections.sort(asList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.xj.xj.xj.xj.1
                        @Override // java.util.Comparator
                        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long lastModified = file2.lastModified() - file.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            return lastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < asList.size()) {
                        File file = (File) asList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) asList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }
}
