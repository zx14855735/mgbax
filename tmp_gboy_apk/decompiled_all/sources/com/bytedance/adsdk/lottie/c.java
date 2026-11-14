package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.u.ra;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private static final Map<String, g<y>> xj = new HashMap();
    private static final Set<Object> hf = new HashSet();
    private static final byte[] w = {80, 75, 3, 4};

    public static g<y> hf(Context context, String str) {
        return hf(context, str, "asset_" + str);
    }

    @WorkerThread
    public static pl<y> w(Context context, String str) {
        return w(context, str, "asset_" + str);
    }

    public static g<y> hf(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return xj(str2, new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.c.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public pl<y> call() {
                return c.w(applicationContext, str, str2);
            }
        });
    }

    @WorkerThread
    public static pl<y> w(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return hf(context.getAssets().open(str), str2);
            }
            return xj(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new pl<>((Throwable) e);
        }
    }

    public static void xj(int i) {
        com.bytedance.adsdk.lottie.model.kd.xj().xj(i);
    }

    public static g<y> xj(Context context, String str) {
        return xj(context, str, "url_" + str);
    }

    @WorkerThread
    public static pl<y> hf(Context context, @RawRes int i) {
        return hf(context, i, w(context, i));
    }

    public static g<y> xj(final Context context, final String str, final String str2) {
        return xj(str2, new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.c.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public pl<y> call() {
                pl<y> xj2 = kd.xj(context).xj(context, str, str2);
                if (str2 != null && xj2.xj() != null) {
                    com.bytedance.adsdk.lottie.model.kd.xj().xj(str2, xj2.xj());
                }
                return xj2;
            }
        });
    }

    @WorkerThread
    public static pl<y> hf(Context context, @RawRes int i, String str) {
        try {
            return hf(context.getResources().openRawResource(i), w(context, i));
        } catch (Resources.NotFoundException e) {
            return new pl<>((Throwable) e);
        }
    }

    public static g<y> xj(Context context, @RawRes int i) {
        return xj(context, i, w(context, i));
    }

    private static String w(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(xj(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    public static g<y> xj(Context context, @RawRes final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return xj(str, new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.c.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public pl<y> call() {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return c.hf(context2, i, str);
            }
        });
    }

    @WorkerThread
    public static pl<y> hf(InputStream inputStream, String str) {
        return xj(inputStream, str, true);
    }

    @WorkerThread
    private static pl<y> hf(Context context, ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            y yVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    yVar = xj(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).xj();
                } else {
                    if (!name.endsWith(".png") && !name.endsWith(".webp") && !name.endsWith(".jpg") && !name.endsWith(".jpeg")) {
                        if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        if (name.contains("../")) {
                            zipInputStream.closeEntry();
                            nextEntry = zipInputStream.getNextEntry();
                        } else {
                            String[] split = name.split("/");
                            String str2 = split[split.length - 1];
                            String str3 = str2.split("\\.")[0];
                            File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context), str2);
                            new FileOutputStream(file);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[f.a.c];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th4) {
                                com.bytedance.adsdk.lottie.kd.kd.xj("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th4);
                            }
                            Typeface createFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                com.bytedance.adsdk.lottie.kd.kd.hf("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            hashMap2.put(str3, createFromFile);
                        }
                    }
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] split2 = name.split("/");
                        hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (yVar == null) {
                return new pl<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                d xj2 = xj(yVar, (String) entry.getKey());
                if (xj2 != null) {
                    xj2.xj(com.bytedance.adsdk.lottie.kd.d.xj((Bitmap) entry.getValue(), xj2.xj(), xj2.hf()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.lottie.model.w wVar : yVar.zg().values()) {
                    if (wVar.xj().equals(entry2.getKey())) {
                        wVar.xj((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.bytedance.adsdk.lottie.kd.kd.hf("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                Iterator<Map.Entry<String, d>> it = yVar.e().entrySet().iterator();
                while (it.hasNext()) {
                    d value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String pl2 = value.pl();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (pl2.startsWith("data:") && pl2.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(pl2.substring(pl2.indexOf(44) + 1), 0);
                            value.xj(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.bytedance.adsdk.lottie.kd.kd.xj("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, d> entry3 : yVar.e().entrySet()) {
                if (entry3.getValue().am() == null) {
                    return new pl<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().pl()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.lottie.model.kd.xj().xj(str, yVar);
            }
            return new pl<>(yVar);
        } catch (IOException e2) {
            return new pl<>((Throwable) e2);
        }
    }

    private static boolean xj(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static g<y> xj(final InputStream inputStream, final String str) {
        return xj(str, new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.c.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public pl<y> call() {
                return c.hf(inputStream, str);
            }
        });
    }

    @WorkerThread
    private static pl<y> xj(InputStream inputStream, String str, boolean z) {
        try {
            return xj(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.lottie.kd.d.xj(inputStream);
            }
        }
    }

    @WorkerThread
    public static pl<y> xj(JsonReader jsonReader, String str) {
        return xj(jsonReader, str, true);
    }

    private static pl<y> xj(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                y xj2 = ra.xj(jsonReader);
                com.bytedance.adsdk.lottie.model.kd.xj().xj(str, xj2);
                pl<y> plVar = new pl<>(xj2);
                if (z) {
                    xj(jsonReader);
                }
                return plVar;
            } catch (Exception e) {
                pl<y> plVar2 = new pl<>(e);
                if (z) {
                    xj(jsonReader);
                }
                return plVar2;
            }
        } catch (Throwable th) {
            if (z) {
                xj(jsonReader);
            }
            throw th;
        }
    }

    public static void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    @WorkerThread
    public static pl<y> xj(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return hf(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.kd.d.xj(zipInputStream);
        }
    }

    private static d xj(y yVar, String str) {
        for (d dVar : yVar.e().values()) {
            if (dVar.pl().equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    private static g<y> xj(final String str, Callable<pl<y>> callable) {
        final y xj2 = str == null ? null : com.bytedance.adsdk.lottie.model.kd.xj().xj(str);
        if (xj2 != null) {
            return new g<>(new Callable<pl<y>>() { // from class: com.bytedance.adsdk.lottie.c.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public pl<y> call() {
                    return new pl<>(y.this);
                }
            });
        }
        if (str != null) {
            Map<String, g<y>> map = xj;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        g<y> gVar = new g<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            gVar.xj(new tf<y>() { // from class: com.bytedance.adsdk.lottie.c.2
                @Override // com.bytedance.adsdk.lottie.tf
                public void xj(y yVar) {
                    c.xj.remove(str);
                    atomicBoolean.set(true);
                    if (c.xj.size() == 0) {
                        c.hf(true);
                    }
                }
            });
            gVar.w(new tf<Throwable>() { // from class: com.bytedance.adsdk.lottie.c.3
                @Override // com.bytedance.adsdk.lottie.tf
                public void xj(Throwable th) {
                    c.xj.remove(str);
                    atomicBoolean.set(true);
                    if (c.xj.size() == 0) {
                        c.hf(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, g<y>> map2 = xj;
                map2.put(str, gVar);
                if (map2.size() == 1) {
                    hf(false);
                }
            }
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(boolean z) {
        ArrayList arrayList = new ArrayList(hf);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
