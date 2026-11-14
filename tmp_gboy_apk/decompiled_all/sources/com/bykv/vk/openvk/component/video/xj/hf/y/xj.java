package com.bykv.vk.openvk.component.video.xj.hf.y;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.y.w;
import com.bykv.vk.openvk.component.video.xj.hf.kd;
import com.bykv.vk.openvk.component.video.xj.hf.u;
import com.bykv.vk.openvk.component.video.xj.hf.y;
import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static final boolean xj = w.hf();
    private HashMap<String, Boolean> hf;
    private C0017xj w;

    public static class hf {
        private static final xj xj = new xj();

        static {
            OxhC();
        }

        private static /* synthetic */ void OxhC() {
            char[] charArray = "±½¿üµ³¿·ü°½«ü¡º·¾¾ü\u0098¼»\u0090 »¶µ·".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 210);
            }
            String str = new String(charArray);
            char[] charArray2 = "±¾»¼»¦".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 210);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        YQLuR();
    }

    private static /* synthetic */ void YQLuR() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static com.bykv.vk.openvk.component.video.xj.hf.xj.w w() {
        com.bykv.vk.openvk.component.video.xj.hf.xj.w wVar;
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(com.bykv.vk.openvk.component.video.api.w.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.bykv.vk.openvk.component.video.xj.hf.xj.w wVar2 = null;
        try {
            wVar = new com.bykv.vk.openvk.component.video.xj.hf.xj.w(file);
        } catch (IOException e) {
            e = e;
        }
        try {
            wVar.xj(104857600L);
            return wVar;
        } catch (IOException e2) {
            e = e2;
            wVar2 = wVar;
            pl.xj(e);
            return wVar2;
        }
    }

    public static xj xj() {
        return hf.xj;
    }

    public boolean hf() {
        if (this.w != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.xj.hf.xj.w w = w();
        if (w == null) {
            return false;
        }
        kd.xj(true);
        kd.hf(true);
        kd.xj(1);
        y.xj().u();
        try {
            C0017xj c0017xj = new C0017xj();
            this.w = c0017xj;
            c0017xj.setName("csj_video_cache_preloader");
            this.w.start();
            kd.xj(w, com.bykv.vk.openvk.component.video.api.w.getContext());
            u.w();
            u.w().xj(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private xj() {
        this.hf = new HashMap<>();
        hf();
    }

    public boolean xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (!hf()) {
            return false;
        }
        this.w.xj(uVar);
        return true;
    }

    /* renamed from: com.bykv.vk.openvk.component.video.xj.hf.y.xj$xj, reason: collision with other inner class name */
    public class C0017xj extends com.bytedance.sdk.component.tf.u.w {
        private Queue<C0018xj> hf;
        private Queue<C0018xj> kd;
        private final Queue<C0018xj> u;
        private boolean w;

        /* renamed from: com.bykv.vk.openvk.component.video.xj.hf.y.xj$xj$xj, reason: collision with other inner class name */
        public class C0018xj {
            public String hf;
            public String kd;
            public int u;
            public String[] w;
            public int xj;
            public com.bykv.vk.openvk.component.video.api.w.u y;

            public C0018xj() {
            }
        }

        public C0017xj() {
            super("VideoCachePreloader$PreLoadThread");
            this.u = new ArrayBlockingQueue(10);
            this.hf = new LinkedBlockingQueue();
            this.w = true;
            this.kd = new LinkedBlockingQueue();
        }

        private synchronized void hf(C0018xj c0018xj) {
            this.kd.add(c0018xj);
            notify();
        }

        private void w(C0018xj c0018xj) {
            if (c0018xj == null) {
                return;
            }
            this.hf.offer(c0018xj);
            notify();
        }

        private C0018xj xj(int i, com.bykv.vk.openvk.component.video.api.w.u uVar) {
            this.u.size();
            C0018xj poll = this.u.poll();
            if (poll == null) {
                poll = new C0018xj();
            }
            poll.xj = i;
            poll.y = uVar;
            return poll;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.w) {
                synchronized (this) {
                    try {
                        if (!this.kd.isEmpty()) {
                            xj();
                        }
                        while (!this.hf.isEmpty()) {
                            C0018xj poll = this.hf.poll();
                            if (poll != null) {
                                int i = poll.xj;
                                if (i == 0) {
                                    String[] strArr = poll.w;
                                    if (strArr != null && strArr.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : poll.w) {
                                            if (com.bykv.vk.openvk.component.video.xj.w.xj.xj(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        u.w().xj(false, !TextUtils.isEmpty(poll.kd), poll.u, poll.hf, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                    }
                                } else if (i == 1) {
                                    u.w().xj(poll.hf);
                                } else if (i == 2) {
                                    u.w().u();
                                } else if (i == 3) {
                                    u.w().u();
                                    if (kd.hf() != null) {
                                        kd.hf().xj();
                                    }
                                    if (kd.xj() != null) {
                                        kd.xj().xj();
                                    }
                                } else if (i == 4) {
                                    u.w().u();
                                    this.w = false;
                                }
                                xj(poll);
                            }
                        }
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            pl.xj(e);
                        }
                    } finally {
                    }
                }
            }
        }

        private void xj(C0018xj c0018xj) {
            c0018xj.w = null;
            c0018xj.hf = null;
            c0018xj.xj = -1;
            c0018xj.y = null;
            this.u.offer(c0018xj);
        }

        private void xj() {
            while (true) {
                C0018xj poll = this.kd.poll();
                if (poll == null) {
                    return;
                }
                poll.hf = poll.y.zg();
                poll.w = new String[]{poll.y.zg()};
                int hf = poll.y.hf();
                if (hf <= 0) {
                    hf = poll.y.y();
                }
                poll.u = hf;
                poll.kd = poll.y.e();
                if (!TextUtils.isEmpty(poll.y.e())) {
                    poll.hf = poll.y.e();
                }
                poll.y = null;
                w(poll);
            }
        }

        public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
            hf(xj(0, uVar));
        }
    }

    public String hf(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (uVar == null) {
            return null;
        }
        boolean isEmpty = TextUtils.isEmpty(uVar.e());
        return y.xj().xj(false, !isEmpty, !isEmpty ? uVar.e() : uVar.zg(), uVar.zg());
    }
}
