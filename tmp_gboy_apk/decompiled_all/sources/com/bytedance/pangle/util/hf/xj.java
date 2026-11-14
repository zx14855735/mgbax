package com.bytedance.pangle.util.hf;

import com.bytedance.pangle.util.c;
import com.bytedance.pangle.util.d;
import com.bytedance.pangle.util.hf.hf.u;
import com.bytedance.pangle.util.hf.hf.w;
import com.kuaishou.weapon.p0.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final com.bytedance.pangle.util.hf.xj.hf hf = new com.bytedance.pangle.util.hf.xj.hf();
    private final u xj;

    public xj(u uVar) {
        this.xj = uVar;
    }

    public void xj(boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        Iterator<w> it;
        long y;
        xj xjVar = this;
        File file = new File(xjVar.xj.w().getAbsolutePath() + ".rm_tmp");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile2 = new RandomAccessFile(xjVar.xj.w(), t.k);
                try {
                    List<w> xj = xjVar.xj.xj().xj();
                    HashSet hashSet = new HashSet();
                    Iterator<w> it2 = xj.iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        w next = it2.next();
                        if (xjVar.xj(next, z, z2)) {
                            hashSet.add(next.pl());
                        } else {
                            long g = next.g();
                            if ("resources.arsc".equals(next.pl())) {
                                try {
                                    long filePointer = randomAccessFile.getFilePointer() + next.u();
                                    if (filePointer % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF == 0) {
                                        it = it2;
                                        y = 0;
                                    } else {
                                        it = it2;
                                        y = ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF - ((filePointer - next.y()) % ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF);
                                    }
                                    if (y != 0) {
                                        int y2 = next.y();
                                        int i2 = (int) y;
                                        next.hf(i2);
                                        xj(randomAccessFile2, randomAccessFile, g, next.kd(), next.pl());
                                        this.xj.u().xj(randomAccessFile, i2);
                                        xj(randomAccessFile2, randomAccessFile, g + next.kd() + 2, next.tf(), next.pl());
                                        randomAccessFile.write(new byte[i2]);
                                        xj(randomAccessFile2, randomAccessFile, g + next.kd() + 2 + next.tf() + y2, next.hf(), next.pl());
                                        xjVar = this;
                                        long j = i;
                                        next.u(j);
                                        i = (int) (j + next.w());
                                        it2 = it;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    xjVar = this;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile2.close();
                                    }
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                    }
                                    xjVar.xj(file);
                                    throw th;
                                }
                            } else {
                                it = it2;
                            }
                            xjVar = this;
                            xjVar.xj(randomAccessFile2, randomAccessFile, g, next.w(), next.pl());
                            long j2 = i;
                            next.u(j2);
                            i = (int) (j2 + next.w());
                            it2 = it;
                        }
                    }
                    xjVar.xj.xj().xj(hashSet);
                    xjVar.hf.xj(xjVar.xj, randomAccessFile);
                    xjVar.xj(xjVar.xj.w(), file);
                    randomAccessFile2.close();
                    randomAccessFile.close();
                    xjVar.xj(file);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    private boolean xj(w wVar, boolean z, boolean z2) {
        if (z) {
            if (d.y() && wVar.pl().equals("classes.dex")) {
                return false;
            }
            if (wVar.pl().startsWith("classes") && wVar.pl().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && wVar.pl().startsWith("lib/") && wVar.pl().endsWith(".so");
    }

    public void xj(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public void xj(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) {
        c.xj(randomAccessFile, randomAccessFile2, j, j2 + j, str);
    }

    private void xj(File file, File file2) {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}
