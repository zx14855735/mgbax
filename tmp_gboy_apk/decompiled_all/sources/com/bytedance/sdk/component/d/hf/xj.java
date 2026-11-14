package com.bytedance.sdk.component.d.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.y;
import com.bytedance.sdk.component.hf.xj.zg;
import com.sigmob.sdk.downloader.core.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends u {
    public xj(pl plVar) {
        super(plVar);
    }

    public void xj(final com.bytedance.sdk.component.d.xj.xj xjVar) {
        try {
            am.xj xjVar2 = new am.xj();
            xjVar2.xj((Object) hf());
            hf(c.b, "bytes=0-");
            if (TextUtils.isEmpty(this.y)) {
                xjVar.xj(this, new IOException("Url is Empty"));
                return;
            }
            xjVar2.xj(this.y);
            xj(xjVar2);
            this.w.xj(xjVar2.xj().hf()).xj(new com.bytedance.sdk.component.hf.xj.w() { // from class: com.bytedance.sdk.component.d.hf.xj.1
                @Override // com.bytedance.sdk.component.hf.xj.w
                public void onFailure(com.bytedance.sdk.component.hf.xj.hf hfVar, IOException iOException) {
                    com.bytedance.sdk.component.d.xj.xj xjVar3 = xjVar;
                    if (xjVar3 != null) {
                        xjVar3.xj(xj.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.hf.xj.w
                public void onResponse(com.bytedance.sdk.component.hf.xj.hf hfVar, zg zgVar) {
                    if (xjVar == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (zgVar == null) {
                        return;
                    }
                    com.bytedance.sdk.component.d.hf hfVar2 = new com.bytedance.sdk.component.d.hf(zgVar.u(), zgVar.w(), zgVar.kd(), hashMap, null, zgVar.hf(), zgVar.xj());
                    if (!zgVar.u()) {
                        xjVar.xj(xj.this, hfVar2);
                        return;
                    }
                    InputStream inputStream = null;
                    try {
                        try {
                            y c = zgVar.c();
                            if (c != null) {
                                for (int i = 0; i < c.xj(); i++) {
                                    hashMap.put(c.xj(i), c.hf(i));
                                }
                            }
                            int intValue = Long.valueOf(zgVar.y().xj()).intValue();
                            byte[] bArr = new byte[intValue];
                            inputStream = zgVar.y().w();
                            if (inputStream.read(bArr) == intValue) {
                                hfVar2.xj(bArr);
                            } else {
                                hfVar2 = new com.bytedance.sdk.component.d.hf(false, zgVar.w(), "Byte opt fail", hashMap, null, zgVar.hf(), zgVar.xj());
                            }
                            xjVar.xj(xj.this, hfVar2);
                            inputStream.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th) {
                        try {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                            xjVar.xj(xj.this, new IOException(th.getMessage()));
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } finally {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.component.d.hf.u
    public com.bytedance.sdk.component.d.hf xj() {
        InputStream inputStream;
        try {
            am.xj xjVar = new am.xj();
            xjVar.xj((Object) hf());
            hf(c.b, "bytes=0-");
            if (TextUtils.isEmpty(this.y)) {
                com.bytedance.sdk.component.utils.pl.u("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            xjVar.xj(this.y);
            xj(xjVar);
            zg hf = this.w.xj(xjVar.xj().hf()).hf();
            if (hf == null || !hf.u()) {
                return null;
            }
            HashMap hashMap = new HashMap();
            y c = hf.c();
            if (c != null) {
                for (int i = 0; i < c.xj(); i++) {
                    hashMap.put(c.xj(i), c.hf(i));
                }
            }
            long xj = hf.y().xj();
            byte[] bArr = new byte[Long.valueOf(xj).intValue()];
            inputStream = hf.y().w();
            try {
                if (inputStream.read(bArr) == xj) {
                    com.bytedance.sdk.component.d.hf hfVar = new com.bytedance.sdk.component.d.hf(hf.u(), hf.w(), hf.kd(), hashMap, null, hf.hf(), hf.xj());
                    hfVar.xj(bArr);
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                    }
                    return hfVar;
                }
                com.bytedance.sdk.component.d.hf hfVar2 = new com.bytedance.sdk.component.d.hf(false, hf.w(), "Byte opt fail", hashMap, null, hf.hf(), hf.xj());
                try {
                    inputStream.close();
                } catch (Throwable unused2) {
                }
                return hfVar2;
            } catch (Throwable th) {
                th = th;
                try {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }
}
