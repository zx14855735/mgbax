package RujA7D;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import Hdahpu.AZOQYO;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static Context f7917A2egSU;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.io.Closeable, java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [I3HV03.A4TApA] */
    public static void A2egSU() {
        InputStream inputStream;
        ?? r9;
        String[] strArr;
        ZipFile zipFile;
        InputStream inputStream2;
        InputStream inputStream3;
        ?? r12;
        char c = 0;
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            Context context = getContext();
            DUi7mC dUi7mC = new DUi7mC();
            if (context == null) {
                throw new IllegalArgumentException("Given context is null");
            }
            DUi7mC.B2KMhB("Beginning load of %s...", "pl_droidsonroids_gif");
            AZOQYO azoqyo = (AZOQYO) dUi7mC.f240AmA8tU;
            HashSet hashSet = (HashSet) dUi7mC.f239AlLFFp;
            if (hashSet.contains("pl_droidsonroids_gif")) {
                DUi7mC.B2KMhB("%s already loaded previously!", "pl_droidsonroids_gif");
                return;
            }
            InputStream inputStream4 = null;
            try {
                azoqyo.getClass();
                System.loadLibrary("pl_droidsonroids_gif");
                hashSet.add("pl_droidsonroids_gif");
                DUi7mC.B2KMhB("%s (%s) was loaded normally!", "pl_droidsonroids_gif", null);
            } catch (UnsatisfiedLinkError e) {
                DUi7mC.B2KMhB("Loading the library normally failed: %s", Log.getStackTraceString(e));
                DUi7mC.B2KMhB("%s (%s) was not loaded normally, re-linking...", "pl_droidsonroids_gif", null);
                File B25kr62 = dUi7mC.B25kr6(context);
                if (B25kr62.exists()) {
                    inputStream = null;
                } else {
                    File dir = context.getDir("lib", 0);
                    File B25kr63 = dUi7mC.B25kr6(context);
                    azoqyo.getClass();
                    File[] listFiles = dir.listFiles(new Mxl9NN.A4TApA(System.mapLibraryName("pl_droidsonroids_gif")));
                    if (listFiles != null) {
                        int length = listFiles.length;
                        int i = 0;
                        while (i < length) {
                            File file = listFiles[i];
                            InputStream inputStream5 = inputStream4;
                            if (!file.getAbsolutePath().equals(B25kr63.getAbsolutePath())) {
                                file.delete();
                            }
                            i++;
                            inputStream4 = inputStream5;
                        }
                    }
                    inputStream = inputStream4;
                    String[] strArr2 = Build.SUPPORTED_ABIS;
                    if (strArr2.length <= 0) {
                        String str = Build.CPU_ABI2;
                        strArr2 = (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
                    }
                    String mapLibraryName = System.mapLibraryName("pl_droidsonroids_gif");
                    ((Mxl9NN.A2egSU) dUi7mC.f241AzWtSf).getClass();
                    try {
                        I3HV03.A4TApA A4TApA2 = Mxl9NN.A2egSU.A4TApA(context, strArr2, mapLibraryName, dUi7mC);
                        try {
                            if (A4TApA2 == null) {
                                try {
                                    strArr = Mxl9NN.A2egSU.A5SV6n(context, mapLibraryName);
                                } catch (Exception e2) {
                                    strArr = new String[]{e2.toString()};
                                }
                                StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Could not find '", mapLibraryName, "'. Looked for: ");
                                B3GDIM2.append(Arrays.toString(strArr2));
                                B3GDIM2.append(", but only found: ");
                                throw new DXnQ0V.A5SV6n(CtFAbx.B25kr6(B3GDIM2, Arrays.toString(strArr), "."));
                            }
                            int i2 = 0;
                            while (true) {
                                int i3 = i2 + 1;
                                zipFile = (ZipFile) A4TApA2.f3808AlLFFp;
                                if (i2 < 5) {
                                    Object[] objArr = new Object[1];
                                    objArr[c] = mapLibraryName;
                                    DUi7mC.B2KMhB("Found %s! Extracting...", objArr);
                                    try {
                                        if (B25kr62.exists() || B25kr62.createNewFile()) {
                                            try {
                                                inputStream3 = zipFile.getInputStream((ZipEntry) A4TApA2.f3809AmA8tU);
                                                try {
                                                    r12 = new FileOutputStream(B25kr62);
                                                    try {
                                                        byte[] bArr = new byte[f.a.c];
                                                        long j = 0;
                                                        while (true) {
                                                            int read = inputStream3.read(bArr);
                                                            if (read == -1) {
                                                                break;
                                                            }
                                                            r12.write(bArr, 0, read);
                                                            j += read;
                                                        }
                                                        r12.flush();
                                                        r12.getFD().sync();
                                                        if (j == B25kr62.length()) {
                                                            Mxl9NN.A2egSU.A2egSU(inputStream3);
                                                            Mxl9NN.A2egSU.A2egSU(r12);
                                                            B25kr62.setReadable(true, false);
                                                            B25kr62.setExecutable(true, false);
                                                            B25kr62.setWritable(true);
                                                            break;
                                                        }
                                                        Mxl9NN.A2egSU.A2egSU(inputStream3);
                                                        Mxl9NN.A2egSU.A2egSU(r12);
                                                    } catch (FileNotFoundException unused2) {
                                                        Mxl9NN.A2egSU.A2egSU(inputStream3);
                                                        Mxl9NN.A2egSU.A2egSU(r12);
                                                        i2 = i3;
                                                        c = 0;
                                                    } catch (IOException unused3) {
                                                        Mxl9NN.A2egSU.A2egSU(inputStream3);
                                                        Mxl9NN.A2egSU.A2egSU(r12);
                                                        i2 = i3;
                                                        c = 0;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream2 = inputStream3;
                                                        inputStream = r12;
                                                        Mxl9NN.A2egSU.A2egSU(inputStream2);
                                                        Mxl9NN.A2egSU.A2egSU(inputStream);
                                                        throw th;
                                                    }
                                                } catch (FileNotFoundException unused4) {
                                                    r12 = inputStream;
                                                } catch (IOException unused5) {
                                                    r12 = inputStream;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    inputStream2 = inputStream3;
                                                }
                                            } catch (FileNotFoundException unused6) {
                                                inputStream3 = inputStream;
                                                r12 = inputStream3;
                                            } catch (IOException unused7) {
                                                inputStream3 = inputStream;
                                                r12 = inputStream3;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream2 = inputStream;
                                            }
                                        }
                                    } catch (IOException unused8) {
                                    }
                                    i2 = i3;
                                    c = 0;
                                }
                            }
                            try {
                                zipFile.close();
                                break;
                            } catch (IOException unused9) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            r9 = A4TApA2;
                            if (r9 != 0) {
                                try {
                                    ((ZipFile) r9.f3808AlLFFp).close();
                                } catch (IOException unused10) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r9 = inputStream;
                    }
                }
                String absolutePath = B25kr62.getAbsolutePath();
                azoqyo.getClass();
                System.load(absolutePath);
                hashSet.add("pl_droidsonroids_gif");
                DUi7mC.B2KMhB("%s (%s) was re-linked!", "pl_droidsonroids_gif", inputStream);
            }
        }
    }

    private static Context getContext() {
        if (f7917A2egSU == null) {
            try {
                f7917A2egSU = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return f7917A2egSU;
    }
}
