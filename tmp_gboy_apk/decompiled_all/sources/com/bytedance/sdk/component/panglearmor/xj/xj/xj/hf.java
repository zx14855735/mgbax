package com.bytedance.sdk.component.panglearmor.xj.xj.xj;

import ADYaiT.CtFAbx;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {

    public static class xj {
        private final com.bytedance.sdk.component.panglearmor.xj.hf.hf hf;
        private final long xj;

        public xj(long j, com.bytedance.sdk.component.panglearmor.xj.hf.hf hfVar) {
            this.xj = j;
            this.hf = hfVar;
        }

        public com.bytedance.sdk.component.panglearmor.xj.hf.hf hf() {
            return this.hf;
        }

        public long xj() {
            return this.xj;
        }
    }

    public static com.bytedance.sdk.component.panglearmor.xj.xj.w.hf xj(com.bytedance.sdk.component.panglearmor.xj.hf.hf hfVar) {
        Pair<ByteBuffer, Long> xj2 = com.bytedance.sdk.component.panglearmor.xj.xj.hf.hf.xj.xj(hfVar);
        if (xj2 == null) {
            throw new com.bytedance.sdk.component.panglearmor.xj.xj.w.xj("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) xj2.first;
        long longValue = ((Long) xj2.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long xj3 = com.bytedance.sdk.component.panglearmor.xj.xj.hf.hf.xj.xj(byteBuffer);
        if (xj3 > longValue) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("ZIP Central Directory start offset out of range: ", xj3, ". ZIP End of Central Directory offset: ");
            B2KMhB2.append(longValue);
            throw new com.bytedance.sdk.component.panglearmor.xj.xj.w.xj(B2KMhB2.toString());
        }
        long hf = com.bytedance.sdk.component.panglearmor.xj.xj.hf.hf.xj.hf(byteBuffer);
        long j = xj3 + hf;
        if (j <= longValue) {
            return new com.bytedance.sdk.component.panglearmor.xj.xj.w.hf(xj3, hf, com.bytedance.sdk.component.panglearmor.xj.xj.hf.hf.xj.w(byteBuffer), longValue, byteBuffer);
        }
        StringBuilder B2KMhB3 = CtFAbx.B2KMhB("ZIP Central Directory overlaps with End of Central Directory. CD end: ", j, ", EoCD start: ");
        B2KMhB3.append(longValue);
        throw new com.bytedance.sdk.component.panglearmor.xj.xj.w.xj(B2KMhB3.toString());
    }

    public static xj xj(com.bytedance.sdk.component.panglearmor.xj.hf.hf hfVar, com.bytedance.sdk.component.panglearmor.xj.xj.w.hf hfVar2) {
        long xj2 = hfVar2.xj();
        long hf = hfVar2.hf() + xj2;
        long u = hfVar2.u();
        if (hf != u) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: ", hf, ", EoCD start: ");
            B2KMhB2.append(u);
            throw new Exception(B2KMhB2.toString());
        }
        if (xj2 >= 32) {
            ByteBuffer xj3 = hfVar.xj(xj2 - 24, 24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            xj3.order(byteOrder);
            if (xj3.getLong(8) == 2334950737559900225L && xj3.getLong(16) == 3617552046287187010L) {
                long j = xj3.getLong(0);
                if (j < xj3.capacity() || j > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
                }
                long j2 = (int) (8 + j);
                long j3 = xj2 - j2;
                if (j3 >= 0) {
                    ByteBuffer xj4 = hfVar.xj(j3, 8);
                    xj4.order(byteOrder);
                    long j4 = xj4.getLong(0);
                    if (j4 == j) {
                        return new xj(j3, hfVar.xj(j3, j2));
                    }
                    StringBuilder B2KMhB3 = CtFAbx.B2KMhB("APK Signing Block sizes in header and footer do not match: ", j4, " vs ");
                    B2KMhB3.append(j);
                    throw new Exception(B2KMhB3.toString());
                }
                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
            }
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(xj2)));
    }
}
