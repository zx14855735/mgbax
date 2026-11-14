package com.bytedance.pangle.f;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class pl implements p {
    private static final long xj = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final FileDescriptor hf;
    private final long u;
    private final long w;

    static {
        LAQoMJ();
    }

    public pl(FileDescriptor fileDescriptor, long j, long j2) {
        this.hf = fileDescriptor;
        this.w = j;
        this.u = j2;
    }

    private static /* synthetic */ void LAQoMJ() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.pangle.f.p
    public long xj() {
        return this.u;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.f.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.bytedance.pangle.f.tf r24, long r25, int r27) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.pl.xj(com.bytedance.pangle.f.tf, long, int):void");
    }
}
