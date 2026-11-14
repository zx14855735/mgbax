package GnQT2j;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz extends Thread {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AZkASS f3107AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public SQLiteDatabase f3108AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A2egSU f3109AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f3110AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AlLFFp f3111B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public String f3112B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Looper f3113B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Handler f3114B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Handler f3115B7CMnp;

    public static long A2egSU(File file) {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        file.createNewFile();
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:153:0x0094, code lost:
    
        if (r12 == null) goto L175;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0060: MOVE (r11 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:97), block:B:185:0x005f */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0297 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6 A[Catch: all -> 0x00da, Exception -> 0x00dd, TryCatch #17 {Exception -> 0x00dd, all -> 0x00da, blocks: (B:21:0x00ab, B:23:0x00d6, B:24:0x00e7, B:133:0x00e4), top: B:20:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012c A[Catch: all -> 0x0115, Exception -> 0x0118, TRY_ENTER, TryCatch #19 {Exception -> 0x0118, all -> 0x0115, blocks: (B:27:0x0106, B:30:0x010f, B:31:0x0120, B:34:0x012c, B:39:0x018a, B:40:0x018e, B:42:0x0195, B:45:0x01bf, B:46:0x01c2, B:63:0x013b, B:65:0x0146, B:67:0x014f, B:69:0x0159, B:70:0x01c9, B:73:0x01f4, B:74:0x01f8, B:78:0x0202, B:81:0x0217, B:82:0x021d, B:87:0x01d8, B:89:0x01e3, B:91:0x01ec, B:92:0x011b), top: B:26:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0195 A[Catch: all -> 0x0115, Exception -> 0x0118, TryCatch #19 {Exception -> 0x0118, all -> 0x0115, blocks: (B:27:0x0106, B:30:0x010f, B:31:0x0120, B:34:0x012c, B:39:0x018a, B:40:0x018e, B:42:0x0195, B:45:0x01bf, B:46:0x01c2, B:63:0x013b, B:65:0x0146, B:67:0x014f, B:69:0x0159, B:70:0x01c9, B:73:0x01f4, B:74:0x01f8, B:78:0x0202, B:81:0x0217, B:82:0x021d, B:87:0x01d8, B:89:0x01e3, B:91:0x01ec, B:92:0x011b), top: B:26:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c2 A[EDGE_INSN: B:60:0x01c2->B:46:0x01c2 BREAK  A[LOOP:0: B:40:0x018e->B:59:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c9 A[Catch: all -> 0x0115, Exception -> 0x0118, TryCatch #19 {Exception -> 0x0118, all -> 0x0115, blocks: (B:27:0x0106, B:30:0x010f, B:31:0x0120, B:34:0x012c, B:39:0x018a, B:40:0x018e, B:42:0x0195, B:45:0x01bf, B:46:0x01c2, B:63:0x013b, B:65:0x0146, B:67:0x014f, B:69:0x0159, B:70:0x01c9, B:73:0x01f4, B:74:0x01f8, B:78:0x0202, B:81:0x0217, B:82:0x021d, B:87:0x01d8, B:89:0x01e3, B:91:0x01ec, B:92:0x011b), top: B:26:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0263  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: GnQT2j.AYUAbz.run():void");
    }
}
