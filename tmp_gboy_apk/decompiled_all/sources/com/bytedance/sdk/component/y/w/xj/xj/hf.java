package com.bytedance.sdk.component.y.w.xj.xj;

import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.w.xj.xj.xj;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.sdk.component.y.u {
    private xj hf;
    private long xj;

    public hf(File file, long j, ExecutorService executorService) {
        this.xj = j;
        try {
            this.hf = xj.xj(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            pl.hf("LruCountDiskCache", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.y.xj
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public boolean hf(String str) {
        try {
            try {
                xj.w xj = this.hf.xj(str);
                boolean z = xj != null;
                com.bytedance.sdk.component.y.w.w.hf.xj(xj);
                return z;
            } catch (IOException e) {
                pl.hf("LruCountDiskCache", e.getMessage());
                com.bytedance.sdk.component.y.w.w.hf.xj(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.y.w.w.hf.xj(null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable, java.io.InputStream] */
    @Override // com.bytedance.sdk.component.y.xj
    /* renamed from: hf, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] xj(String str) {
        Closeable closeable;
        Closeable closeable2;
        ByteArrayOutputStream byteArrayOutputStream;
        xj xjVar = this.hf;
        Closeable closeable3 = null;
        if (xjVar != null) {
            try {
                if (str != 0) {
                    try {
                        xj.w xj = xjVar.xj((String) str);
                        if (xj == null) {
                            com.bytedance.sdk.component.y.w.w.hf.xj(null);
                            com.bytedance.sdk.component.y.w.w.hf.xj(null);
                            return null;
                        }
                        str = xj.xj(0);
                        if (str != 0) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = str.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    closeable2 = str;
                                    pl.hf("LruCountDiskCache", e.toString());
                                    com.bytedance.sdk.component.y.w.w.hf.xj(closeable2);
                                    com.bytedance.sdk.component.y.w.w.hf.xj(byteArrayOutputStream);
                                    return null;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                byteArrayOutputStream = null;
                                closeable2 = str;
                                pl.hf("LruCountDiskCache", e.toString());
                                com.bytedance.sdk.component.y.w.w.hf.xj(closeable2);
                                com.bytedance.sdk.component.y.w.w.hf.xj(byteArrayOutputStream);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                closeable = null;
                                closeable3 = str;
                                com.bytedance.sdk.component.y.w.w.hf.xj(closeable3);
                                com.bytedance.sdk.component.y.w.w.hf.xj(closeable);
                                throw th;
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.bytedance.sdk.component.y.w.w.hf.xj(str);
                        com.bytedance.sdk.component.y.w.w.hf.xj(byteArrayOutputStream);
                        return byteArray;
                    } catch (IOException e3) {
                        e = e3;
                        closeable2 = null;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        com.bytedance.sdk.component.y.w.w.hf.xj(closeable3);
                        com.bytedance.sdk.component.y.w.w.hf.xj(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.y.u
    public InputStream xj(String str) {
        xj xjVar = this.hf;
        if (xjVar == null) {
            return null;
        }
        try {
            xj.w xj = xjVar.xj(str);
            if (xj != null) {
                return xj.xj(0);
            }
        } catch (IOException e) {
            pl.hf("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.y.xj
    public boolean xj(String str, byte[] bArr) {
        Closeable closeable;
        xj.C0128xj hf;
        xj xjVar = this.hf;
        if (xjVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        xj.C0128xj c0128xj = null;
        try {
            try {
                hf = xjVar.hf(str);
            } catch (IOException e) {
                e = e;
                closeable = null;
            }
            try {
                if (hf == null) {
                    pl.hf("LruCountDiskCache", "save " + str + " failed for edit null");
                    com.bytedance.sdk.component.y.w.w.hf.xj(null);
                    return false;
                }
                OutputStream xj = hf.xj(0);
                if (xj == xj.w) {
                    pl.hf("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                    com.bytedance.sdk.component.y.w.w.hf.xj(xj);
                    return false;
                }
                xj.write(bArr);
                hf.xj();
                this.hf.xj();
                com.bytedance.sdk.component.y.w.w.hf.xj(xj);
                return true;
            } catch (IOException e2) {
                e = e2;
                closeable = null;
                c0128xj = hf;
                try {
                    pl.hf("LruCountDiskCache", e.toString());
                    if (c0128xj != null) {
                        try {
                            c0128xj.hf();
                        } catch (IOException unused) {
                        }
                    }
                    com.bytedance.sdk.component.y.w.w.hf.xj(closeable);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    com.bytedance.sdk.component.y.w.w.hf.xj(closeable2);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            com.bytedance.sdk.component.y.w.w.hf.xj(closeable2);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.y.xj
    public void xj(double d) {
        this.hf.xj((long) (this.xj * d));
    }
}
