package com.czhj.volley.toolbox;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() { // from class: com.czhj.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private final int c;

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f10638a = new ArrayList();
    private final List<byte[]> b = new ArrayList(64);
    private int d = 0;

    static {
        NUwnRP();
    }

    public ByteArrayPool(int i) {
        this.c = i;
    }

    private static /* synthetic */ void NUwnRP() {
        char[] charArray = "GKI\nCEIA\nFK]\nWLAHH\nnJMfVM@CA".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '$');
        }
        String str = new String(charArray);
        char[] charArray2 = "GHMJMP".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '$');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private synchronized void a() {
        while (this.d > this.c) {
            byte[] remove = this.f10638a.remove(0);
            this.b.remove(remove);
            this.d -= remove.length;
        }
    }

    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            byte[] bArr = this.b.get(i2);
            if (bArr.length >= i) {
                this.d -= bArr.length;
                this.b.remove(i2);
                this.f10638a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.c) {
                this.f10638a.add(bArr);
                int binarySearch = Collections.binarySearch(this.b, bArr, BUF_COMPARATOR);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, bArr);
                this.d += bArr.length;
                a();
            }
        }
    }
}
