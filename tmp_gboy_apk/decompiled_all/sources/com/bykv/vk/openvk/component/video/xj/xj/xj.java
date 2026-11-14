package com.bykv.vk.openvk.component.video.xj.xj;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.xj.xj.xj.hf;
import com.bykv.vk.openvk.component.video.xj.xj.xj.w;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends MediaDataSource {
    public static final ConcurrentHashMap<String, xj> xj = new ConcurrentHashMap<>();
    private final w hf;
    private final u kd;
    private final Context u;
    private long w = -2147483648L;

    static {
        gAOKE();
    }

    public xj(Context context, u uVar) {
        this.u = context;
        this.kd = uVar;
        this.hf = new hf(context, uVar);
    }

    private static /* synthetic */ void gAOKE() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("SdkMediaDataSource", "close: ", this.kd.zg());
        w wVar = this.hf;
        if (wVar != null) {
            wVar.hf();
        }
        xj.remove(this.kd.e());
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        if (this.w == -2147483648L) {
            if (this.u == null || TextUtils.isEmpty(this.kd.zg())) {
                return -1L;
            }
            this.w = this.hf.w();
            com.bykv.vk.openvk.component.video.api.y.w.xj("SdkMediaDataSource", "getSize: " + this.w);
        }
        return this.w;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        return this.hf.xj(j, bArr, i, i2);
    }

    public u xj() {
        return this.kd;
    }

    public static xj xj(Context context, u uVar) {
        xj xjVar = new xj(context, uVar);
        xj.put(uVar.e(), xjVar);
        return xjVar;
    }
}
