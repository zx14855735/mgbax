package ms.bz.bd.c.Pgl;

import ADYaiT.CtFAbx;
import android.content.res.AssetManager;
import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class s0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        AssetManager assetManager;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        String str2 = str;
        AssetManager assets = pblv.f14062A4TApA.f14063A2egSU.getAssets();
        if (!str2.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "31170c", new byte[]{108}))) {
            str2 = CtFAbx.B25kr6(new StringBuilder(), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c9bff5", new byte[]{60}), str2);
        }
        String str3 = str2;
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.length) {
            if (list[i].endsWith(str3)) {
                String str4 = list[i];
                String absolutePath = File.createTempFile((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "91ba27", new byte[]{37, 32, 20, 13, 25}), "").getAbsolutePath();
                FileOutputStream fileOutputStream2 = null;
                try {
                    inputStream = assets.open(str4);
                    try {
                        try {
                            fileOutputStream = new FileOutputStream(absolutePath);
                            try {
                                try {
                                    byte[] bArr = new byte[256];
                                    long j = 0;
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        j += read;
                                        assets = assets;
                                    }
                                    assetManager = assets;
                                    try {
                                        fileOutputStream.flush();
                                        if (j > 0) {
                                            arrayList.add(absolutePath);
                                        }
                                        pbln.A2egSU(inputStream);
                                        pbln.A2egSU(fileOutputStream);
                                    } catch (IOException e) {
                                        e = e;
                                        fileOutputStream2 = fileOutputStream;
                                        pl.xj(e);
                                        pbln.A2egSU(inputStream);
                                        pbln.A2egSU(fileOutputStream2);
                                        i++;
                                        assets = assetManager;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    assetManager = assets;
                                }
                            } catch (Throwable th) {
                                th = th;
                                pbln.A2egSU(inputStream);
                                pbln.A2egSU(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            assetManager = assets;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        pbln.A2egSU(inputStream);
                        pbln.A2egSU(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    assetManager = assets;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } else {
                assetManager = assets;
            }
            i++;
            assets = assetManager;
        }
        return arrayList.toArray(new String[0]);
    }
}
