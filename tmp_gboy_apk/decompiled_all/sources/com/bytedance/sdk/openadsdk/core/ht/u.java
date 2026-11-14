package com.bytedance.sdk.openadsdk.core.ht;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements com.bytedance.sdk.component.u.kd, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            return xj();
        }
        if (intValue == 2) {
            return hf();
        }
        if (intValue != 3) {
            return null;
        }
        return encrypt((byte[]) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
    }

    @Override // com.bytedance.sdk.component.u.kd
    public byte[] encrypt(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.x.hf.xj(bArr, i);
    }

    @Deprecated
    public String hf() {
        return com.bytedance.sdk.openadsdk.core.a.tf.w(false);
    }

    @Deprecated
    public String xj() {
        return com.bytedance.sdk.openadsdk.core.a.tf.e();
    }
}
