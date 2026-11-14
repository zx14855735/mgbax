package ms.bz.bd.c.Pgl;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.zip.ZipFile;
import ms.bz.bd.c.Pgl.pbld;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e1 {

    public interface pblb {
    }

    public interface pgla {
    }

    public static void A2egSU(Context context) {
        String[] strArr;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        g1 g1Var = new g1(new s1(), new pbld());
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        Locale locale = Locale.US;
        pblb pblbVar = g1Var.f14010A4TApA;
        HashSet hashSet = g1Var.f14009A2egSU;
        if (hashSet.contains("Pglbizssdk_ml")) {
            return;
        }
        try {
            ((s1) pblbVar).getClass();
            com.bytedance.sdk.openadsdk.x.y.xj("Pglbizssdk_ml");
            hashSet.add("Pglbizssdk_ml");
        } catch (UnsatisfiedLinkError unused) {
            Locale locale2 = Locale.US;
            ((s1) pblbVar).getClass();
            File file = new File(hf.xj(context, "lib", 0), System.mapLibraryName("Pglbizssdk_ml"));
            if (!file.exists()) {
                File xj = hf.xj(context, "lib", 0);
                File file2 = new File(hf.xj(context, "lib", 0), System.mapLibraryName("Pglbizssdk_ml"));
                File[] listFiles = xj.listFiles(new f1(System.mapLibraryName("Pglbizssdk_ml")));
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (!file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file3.delete();
                        }
                    }
                }
                String[] strArr2 = Build.SUPPORTED_ABIS;
                if (strArr2.length <= 0) {
                    String str = Build.CPU_ABI2;
                    strArr2 = (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
                }
                String mapLibraryName = System.mapLibraryName("Pglbizssdk_ml");
                g1Var.f14011A5SV6n.getClass();
                pbld.pgla pglaVar = null;
                r7 = null;
                FileOutputStream fileOutputStream2 = null;
                try {
                    pbld.pgla A2egSU2 = pbld.A2egSU(context, strArr2, mapLibraryName, g1Var);
                    try {
                        if (A2egSU2 == null) {
                            try {
                                strArr = pbld.A5SV6n(context, mapLibraryName);
                            } catch (Exception e) {
                                strArr = new String[]{e.toString()};
                            }
                            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Could not find '", mapLibraryName, "'. Looked for: ");
                            B3GDIM2.append(Arrays.toString(strArr2));
                            B3GDIM2.append(", but only found: ");
                            throw new y0(CtFAbx.B25kr6(B3GDIM2, Arrays.toString(strArr), "."));
                        }
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            ZipFile zipFile = A2egSU2.f14036A2egSU;
                            try {
                                if (i < 5) {
                                    Locale locale3 = Locale.US;
                                    try {
                                        if (file.exists() || file.createNewFile()) {
                                            try {
                                                inputStream = zipFile.getInputStream(A2egSU2.f14037A4TApA);
                                            } catch (FileNotFoundException | IOException unused2) {
                                                inputStream = null;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream = null;
                                            }
                                            try {
                                                fileOutputStream = new FileOutputStream(file);
                                                try {
                                                    try {
                                                        byte[] bArr = new byte[f.a.c];
                                                        long j = 0;
                                                        while (true) {
                                                            int read = inputStream.read(bArr);
                                                            if (read == -1) {
                                                                break;
                                                            }
                                                            fileOutputStream.write(bArr, 0, read);
                                                            j += read;
                                                        }
                                                        fileOutputStream.flush();
                                                        fileOutputStream.getFD().sync();
                                                        if (j == file.length()) {
                                                            pbld.A4TApA(inputStream);
                                                            pbld.A4TApA(fileOutputStream);
                                                            file.setReadable(true, false);
                                                            file.setExecutable(true, false);
                                                            file.setWritable(true);
                                                            zipFile.close();
                                                            break;
                                                        }
                                                        pbld.A4TApA(inputStream);
                                                        pbld.A4TApA(fileOutputStream);
                                                    } catch (FileNotFoundException | IOException unused3) {
                                                        pbld.A4TApA(inputStream);
                                                        pbld.A4TApA(fileOutputStream);
                                                        i = i2;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    fileOutputStream2 = fileOutputStream;
                                                    pbld.A4TApA(inputStream);
                                                    pbld.A4TApA(fileOutputStream2);
                                                    throw th;
                                                }
                                            } catch (FileNotFoundException | IOException unused4) {
                                                fileOutputStream = null;
                                                pbld.A4TApA(inputStream);
                                                pbld.A4TApA(fileOutputStream);
                                                i = i2;
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        }
                                    } catch (IOException unused5) {
                                    }
                                    i = i2;
                                } else if (zipFile != null) {
                                    zipFile.close();
                                }
                            } catch (IOException unused6) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        pglaVar = A2egSU2;
                        if (pglaVar != null) {
                            try {
                                ZipFile zipFile2 = pglaVar.f14036A2egSU;
                                if (zipFile2 != null) {
                                    zipFile2.close();
                                }
                            } catch (IOException unused7) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            System.load(file.getAbsolutePath());
            hashSet.add("Pglbizssdk_ml");
            Locale locale4 = Locale.US;
        }
    }
}
