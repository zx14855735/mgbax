package com.bytedance.pangle.res.xj;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    public static int xj(c cVar) {
        return (int) cVar.xj.xj().hf();
    }

    public static byte[] xj(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int xj(byte[] bArr, int i, int i2, f fVar) {
        if (i < 2130706432) {
            return i;
        }
        int xj = fVar.xj(i);
        byte[] xj2 = xj(xj);
        bArr[i2] = xj2[0];
        bArr[i2 + 1] = xj2[1];
        bArr[i2 + 2] = xj2[2];
        bArr[i2 + 3] = xj2[3];
        return xj;
    }

    public static void xj(byte[] bArr, f fVar) {
        hf hfVar = new hf(bArr, fVar);
        hfVar.hf(new ByteArrayInputStream(bArr));
        while (hfVar.w() != 1) {
        }
    }

    public static void xj(String str, byte[] bArr, f fVar) {
        if (!TextUtils.isEmpty(str) && fVar.xj(str)) {
            if (str.equals("AndroidManifest.xml")) {
                xj(bArr, fVar);
                return;
            }
            if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                xj(bArr, fVar);
            } else if (str.equals("resources.arsc")) {
                new xj(bArr, fVar).xj();
            }
        }
    }

    public static void xj(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> hashMap) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[(i4 * 5) + 1];
            if (hashMap.containsKey(Integer.valueOf(i5))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i6 = (i4 * 20) + i;
                hashMap2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i6, i6 + 20));
                Integer num = hashMap.get(Integer.valueOf(i5));
                num.intValue();
                hashMap3.put(num, Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(hashMap3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            Integer num2 = (Integer) hashMap3.get((Integer) it.next());
            num2.intValue();
            byte[] bArr2 = (byte[]) hashMap2.get(num2);
            System.arraycopy(bArr2, 0, bArr, ((i7 + i3) * 20) + i, bArr2.length);
            i7++;
        }
    }
}
