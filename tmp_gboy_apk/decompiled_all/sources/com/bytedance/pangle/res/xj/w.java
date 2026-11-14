package com.bytedance.pangle.res.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public int xj(File file, boolean z, StringBuilder sb) {
        String byteArrayOutputStream;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.bytedance.pangle.util.c.xj(zipFile2);
                    return 200;
                }
                if (z) {
                    File file2 = new File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb.append("resMappingBakFile is not exists. ");
                        sb.append(file2.getAbsolutePath());
                        com.bytedance.pangle.util.c.xj(zipFile2);
                        return 300;
                    }
                    byteArrayOutputStream = com.bytedance.pangle.util.f.xj(file2);
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    com.bytedance.pangle.util.f.xj(zipFile2.getInputStream(entry), byteArrayOutputStream2);
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
                if (TextUtils.isEmpty(byteArrayOutputStream)) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z)));
                    sb.append("zeusResMappingContent isEmpty. useBakFile:");
                    sb.append(z);
                    com.bytedance.pangle.util.c.xj(zipFile2);
                    return 300;
                }
                JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
                JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
                JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
                final HashSet<String> hashSet = new HashSet<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add((String) jSONArray.get(i));
                }
                final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
                final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
                final int[] iArr = {0};
                try {
                    xj(file, hashSet, new f() { // from class: com.bytedance.pangle.res.xj.w.1
                        @Override // com.bytedance.pangle.res.xj.f
                        public int xj(int i2) {
                            String AzWtSf2 = CtFAbx.AzWtSf(new StringBuilder("0x"), i2);
                            String str = (String) jSONObject3.opt(AzWtSf2);
                            if (str == null) {
                                return i2;
                            }
                            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str.split(" ")[1], str.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            if (identifier == 0) {
                                identifier = Zeus.getAppApplication().getResources().getIdentifier(str.split(" ")[1].replaceAll("_", "."), str.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            }
                            if (identifier == 0) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str));
                                return i2;
                            }
                            String AzWtSf3 = CtFAbx.AzWtSf(new StringBuilder("0x"), identifier);
                            if (TextUtils.equals(jSONObject4.optString(AzWtSf2), str)) {
                                jSONObject4.remove(AzWtSf2);
                            }
                            try {
                                jSONObject4.put(AzWtSf3, str);
                            } catch (Throwable th) {
                                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
                            }
                            if (identifier != i2) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                            }
                            return identifier;
                        }

                        @Override // com.bytedance.pangle.res.xj.f
                        public boolean xj(String str) {
                            return hashSet.contains(str);
                        }
                    });
                    ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
                    if (com.bytedance.pangle.util.f.xj(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                        com.bytedance.pangle.util.c.xj(zipFile2);
                        return 100;
                    }
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
                    sb.append("writeText failed.");
                    com.bytedance.pangle.util.c.xj(zipFile2);
                    return 300;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    try {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                        sb.append("modifyRes failed. catch: ");
                        sb.append(th.getMessage());
                        return 300;
                    } finally {
                        if (zipFile != null) {
                            com.bytedance.pangle.util.c.xj(zipFile);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void xj(File file, HashSet<String> hashSet, f fVar) {
        MappedByteBuffer xj = xj(file);
        int xj2 = xj(xj);
        if (xj2 != -1) {
            int i = xj.getInt(xj2 + 12);
            int i2 = xj.getInt(xj2 + 16);
            int i3 = i + i2;
            while (i2 < i3) {
                if (xj.getInt(i2) == 33639248) {
                    int i4 = xj.getShort(i2 + 28);
                    short s = xj.getShort(i2 + 30);
                    byte[] bArr = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        bArr[i5] = xj.get(i2 + 46 + i5);
                    }
                    String str = new String(bArr);
                    int i6 = xj.getInt(i2 + 20);
                    int i7 = xj.getInt(i2 + 24);
                    if (hashSet.contains(str)) {
                        if (i6 == i7) {
                            com.bytedance.pangle.util.kd<Integer, byte[]> xj3 = xj(xj, xj.getInt(i2 + 42), str);
                            try {
                                p.xj(str, xj3.hf, fVar);
                                for (int i8 = 0; i8 < xj3.hf.length; i8++) {
                                    xj.put(xj3.xj.intValue() + i8, xj3.hf[i8]);
                                }
                            } catch (Throwable th) {
                                throw new RuntimeException(th);
                            }
                        } else {
                            throw new Throwable(str.concat(" is compressed."));
                        }
                    }
                    i2 += i4 + 46 + s;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + xj.getInt(i2));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    private static com.bytedance.pangle.util.kd<Integer, byte[]> xj(MappedByteBuffer mappedByteBuffer, int i, String str) {
        if (mappedByteBuffer.getInt(i) == 67324752) {
            int i2 = mappedByteBuffer.getInt(i + 18);
            int i3 = mappedByteBuffer.getInt(i + 22);
            if (i2 == i3) {
                byte[] bArr = new byte[i3];
                int i4 = i + 30 + mappedByteBuffer.getShort(i + 26) + mappedByteBuffer.getShort(i + 28);
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr[i5] = mappedByteBuffer.get(i4 + i5);
                }
                return new com.bytedance.pangle.util.kd<>(Integer.valueOf(i4), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i2 + " size:" + i3);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i) + " FileName:" + str);
    }

    private int xj(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && byteBuffer.getShort(i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public MappedByteBuffer xj(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            ZeusLogger.d("temp-pxr", "mappedByteBuffer " + file.canWrite());
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            FileChannel channel = randomAccessFile.getChannel();
            long size = channel.size();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
            byte[] bArr = new byte[4194304];
            long j = size / 4194304;
            int i = (int) (size % 4194304);
            for (int i2 = 0; i2 < j; i2++) {
                map.get(bArr);
            }
            if (i > 0) {
                map.get(new byte[i]);
            }
            map.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.close();
            return map;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 == null) {
                throw th;
            }
            randomAccessFile2.close();
            throw th;
        }
    }
}
