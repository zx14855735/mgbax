package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends Q2dWmT.A4TApA {
    public static final A2egSU BpkvW3 = new A2egSU();

    /* renamed from: C2rE4F, reason: collision with root package name */
    public static final Object f12081C2rE4F = new Object();

    /* renamed from: BTvldC, reason: collision with root package name */
    public Object[] f12082BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f12083BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public String[] f12084BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int[] f12085BniPrB;

    static {
        WvdZO();
    }

    public A4TApA(JsonElement jsonElement) {
        super(BpkvW3);
        this.f12082BTvldC = new Object[32];
        this.f12083BV3sI0 = 0;
        this.f12084BmvVmW = new String[32];
        this.f12085BniPrB = new int[32];
        C2rE4F(jsonElement);
    }

    private static /* synthetic */ void WvdZO() {
        char[] charArray = "\u008a\u0086\u0084Ç\u008e\u0088\u0084\u008cÇ\u008b\u0086\u0090Ç\u009a\u0081\u008c\u0085\u0085Ç£\u0087\u0080«\u009b\u0080\u008d\u008e\u008c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 233);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008a\u0085\u0080\u0087\u0080\u009d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 233);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // Q2dWmT.A4TApA
    public final void A2egSU() {
        BV3sI0(1);
        C2rE4F(((JsonArray) BniPrB()).iterator());
        this.f12085BniPrB[this.f12083BV3sI0 - 1] = 0;
    }

    @Override // Q2dWmT.A4TApA
    public final void A4TApA() {
        BV3sI0(3);
        C2rE4F(((JsonObject) BniPrB()).entrySet().iterator());
    }

    @Override // Q2dWmT.A4TApA
    public final void AMqCpz() {
        BV3sI0(2);
        BpkvW3();
        BpkvW3();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // Q2dWmT.A4TApA
    public final void ARc23Z() {
        BV3sI0(4);
        BpkvW3();
        BpkvW3();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // Q2dWmT.A4TApA
    public final String AYUAbz() {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (i < this.f12083BV3sI0) {
            Object[] objArr = this.f12082BTvldC;
            Object obj = objArr[i];
            if (obj instanceof JsonArray) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f12085BniPrB[i]);
                    sb.append(']');
                }
            } else if (obj instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String str = this.f12084BmvVmW[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // Q2dWmT.A4TApA
    public final boolean AZOQYO() {
        int BChYOn2 = BChYOn();
        return (BChYOn2 == 4 || BChYOn2 == 2) ? false : true;
    }

    @Override // Q2dWmT.A4TApA
    public final boolean AcNBzu() {
        BV3sI0(8);
        boolean asBoolean = ((JsonPrimitive) BpkvW3()).getAsBoolean();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asBoolean;
    }

    @Override // Q2dWmT.A4TApA
    public final double AlLFFp() {
        int BChYOn2 = BChYOn();
        if (BChYOn2 != 7 && BChYOn2 != 6) {
            throw new IllegalStateException("Expected " + J3FDQU.A2egSU.BPw6Q8(7) + " but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn2) + BmvVmW());
        }
        double asDouble = ((JsonPrimitive) BniPrB()).getAsDouble();
        if (!this.f7429AlLFFp && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        BpkvW3();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asDouble;
    }

    @Override // Q2dWmT.A4TApA
    public final int AmA8tU() {
        int BChYOn2 = BChYOn();
        if (BChYOn2 != 7 && BChYOn2 != 6) {
            throw new IllegalStateException("Expected " + J3FDQU.A2egSU.BPw6Q8(7) + " but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn2) + BmvVmW());
        }
        int asInt = ((JsonPrimitive) BniPrB()).getAsInt();
        BpkvW3();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asInt;
    }

    @Override // Q2dWmT.A4TApA
    public final long AzWtSf() {
        int BChYOn2 = BChYOn();
        if (BChYOn2 != 7 && BChYOn2 != 6) {
            throw new IllegalStateException("Expected " + J3FDQU.A2egSU.BPw6Q8(7) + " but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn2) + BmvVmW());
        }
        long asLong = ((JsonPrimitive) BniPrB()).getAsLong();
        BpkvW3();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asLong;
    }

    @Override // Q2dWmT.A4TApA
    public final String B25kr6() {
        BV3sI0(5);
        Map.Entry entry = (Map.Entry) ((Iterator) BniPrB()).next();
        String str = (String) entry.getKey();
        this.f12084BmvVmW[this.f12083BV3sI0 - 1] = str;
        C2rE4F(entry.getValue());
        return str;
    }

    @Override // Q2dWmT.A4TApA
    public final void B3GDIM() {
        BV3sI0(9);
        BpkvW3();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // Q2dWmT.A4TApA
    public final String B7CMnp() {
        int BChYOn2 = BChYOn();
        if (BChYOn2 != 6 && BChYOn2 != 7) {
            throw new IllegalStateException("Expected " + J3FDQU.A2egSU.BPw6Q8(6) + " but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn2) + BmvVmW());
        }
        String asString = ((JsonPrimitive) BpkvW3()).getAsString();
        int i = this.f12083BV3sI0;
        if (i > 0) {
            int[] iArr = this.f12085BniPrB;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asString;
    }

    @Override // Q2dWmT.A4TApA
    public final int BChYOn() {
        if (this.f12083BV3sI0 == 0) {
            return 10;
        }
        Object BniPrB2 = BniPrB();
        if (BniPrB2 instanceof Iterator) {
            boolean z = this.f12082BTvldC[this.f12083BV3sI0 - 2] instanceof JsonObject;
            Iterator it = (Iterator) BniPrB2;
            if (!it.hasNext()) {
                return z ? 4 : 2;
            }
            if (z) {
                return 5;
            }
            C2rE4F(it.next());
            return BChYOn();
        }
        if (BniPrB2 instanceof JsonObject) {
            return 3;
        }
        if (BniPrB2 instanceof JsonArray) {
            return 1;
        }
        if (!(BniPrB2 instanceof JsonPrimitive)) {
            if (BniPrB2 instanceof JsonNull) {
                return 9;
            }
            if (BniPrB2 == f12081C2rE4F) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) BniPrB2;
        if (jsonPrimitive.isString()) {
            return 6;
        }
        if (jsonPrimitive.isBoolean()) {
            return 8;
        }
        if (jsonPrimitive.isNumber()) {
            return 7;
        }
        throw new AssertionError();
    }

    @Override // Q2dWmT.A4TApA
    public final void BPw6Q8() {
        if (BChYOn() == 5) {
            B25kr6();
            this.f12084BmvVmW[this.f12083BV3sI0 - 2] = "null";
        } else {
            BpkvW3();
            this.f12084BmvVmW[this.f12083BV3sI0 - 1] = "null";
        }
        int[] iArr = this.f12085BniPrB;
        int i = this.f12083BV3sI0 - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final void BV3sI0(int i) {
        if (BChYOn() == i) {
            return;
        }
        throw new IllegalStateException("Expected " + J3FDQU.A2egSU.BPw6Q8(i) + " but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + BmvVmW());
    }

    public final String BmvVmW() {
        return " at path " + AYUAbz();
    }

    public final Object BniPrB() {
        return this.f12082BTvldC[this.f12083BV3sI0 - 1];
    }

    public final Object BpkvW3() {
        Object[] objArr = this.f12082BTvldC;
        int i = this.f12083BV3sI0 - 1;
        this.f12083BV3sI0 = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void C2rE4F(Object obj) {
        int i = this.f12083BV3sI0;
        Object[] objArr = this.f12082BTvldC;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[i * 2];
            int[] iArr = new int[i * 2];
            String[] strArr = new String[i * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f12085BniPrB, 0, iArr, 0, this.f12083BV3sI0);
            System.arraycopy(this.f12084BmvVmW, 0, strArr, 0, this.f12083BV3sI0);
            this.f12082BTvldC = objArr2;
            this.f12085BniPrB = iArr;
            this.f12084BmvVmW = strArr;
        }
        Object[] objArr3 = this.f12082BTvldC;
        int i2 = this.f12083BV3sI0;
        this.f12083BV3sI0 = i2 + 1;
        objArr3[i2] = obj;
    }

    @Override // Q2dWmT.A4TApA, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12082BTvldC = new Object[]{f12081C2rE4F};
        this.f12083BV3sI0 = 1;
    }

    @Override // Q2dWmT.A4TApA
    public final String toString() {
        return A4TApA.class.getSimpleName();
    }
}
