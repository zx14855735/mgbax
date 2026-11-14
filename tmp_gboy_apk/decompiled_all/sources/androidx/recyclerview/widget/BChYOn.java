package androidx.recyclerview.widget;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f9245A2egSU = new B4ZgIw.ARc23Z(13);

    static {
        TLggK();
    }

    public static B3GDIM A2egSU(B25kr6 b25kr6) {
        int i;
        B9tovu b9tovu;
        int i2;
        B9tovu b9tovu2;
        B9tovu b9tovu3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int AMqCpz = b25kr6.AMqCpz();
        int ADYaiT2 = b25kr6.ADYaiT();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        B7CMnp b7CMnp = new B7CMnp();
        b7CMnp.f9237A2egSU = 0;
        b7CMnp.f9238A4TApA = AMqCpz;
        b7CMnp.f9239A5SV6n = 0;
        b7CMnp.f9240ADYaiT = ADYaiT2;
        arrayList2.add(b7CMnp);
        int i11 = AMqCpz + ADYaiT2;
        int i12 = 1;
        int i13 = (((i11 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i13];
        int i14 = i13 / 2;
        int[] iArr2 = new int[i13];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            B7CMnp b7CMnp2 = (B7CMnp) arrayList2.remove(arrayList2.size() - i12);
            if (b7CMnp2.A4TApA() >= i12 && b7CMnp2.A2egSU() >= i12) {
                int A2egSU2 = ((b7CMnp2.A2egSU() + b7CMnp2.A4TApA()) + i12) / 2;
                int i15 = i12 + i14;
                iArr[i15] = b7CMnp2.f9237A2egSU;
                iArr2[i15] = b7CMnp2.f9238A4TApA;
                int i16 = 0;
                while (i16 < A2egSU2) {
                    boolean z2 = Math.abs(b7CMnp2.A4TApA() - b7CMnp2.A2egSU()) % 2 == i12;
                    int A4TApA2 = b7CMnp2.A4TApA() - b7CMnp2.A2egSU();
                    int i17 = -i16;
                    int i18 = i17;
                    while (true) {
                        if (i18 > i16) {
                            i = i14;
                            i2 = A2egSU2;
                            b9tovu2 = null;
                            break;
                        }
                        if (i18 == i17 || (i18 != i16 && iArr[i18 + 1 + i14] > iArr[(i18 - 1) + i14])) {
                            i7 = iArr[i18 + 1 + i14];
                            i8 = i7;
                        } else {
                            i7 = iArr[(i18 - 1) + i14];
                            i8 = i7 + 1;
                        }
                        i = i14;
                        int i19 = ((i8 - b7CMnp2.f9237A2egSU) + b7CMnp2.f9239A5SV6n) - i18;
                        if (i16 == 0 || i8 != i7) {
                            i9 = i8;
                            i10 = i19;
                        } else {
                            i9 = i8;
                            i10 = i19 - 1;
                        }
                        int i20 = i18;
                        int i21 = i19;
                        int i22 = i9;
                        i2 = A2egSU2;
                        while (i22 < b7CMnp2.f9238A4TApA && i21 < b7CMnp2.f9240ADYaiT && b25kr6.A4TApA(i22, i21)) {
                            i22++;
                            i21++;
                        }
                        iArr[i20 + i] = i22;
                        if (z2) {
                            int i23 = A4TApA2 - i20;
                            z = z2;
                            if (i23 >= i17 + 1 && i23 <= i16 - 1 && iArr2[i23 + i] <= i22) {
                                b9tovu2 = new B9tovu();
                                b9tovu2.f9241A2egSU = i7;
                                b9tovu2.f9242A4TApA = i10;
                                b9tovu2.f9243A5SV6n = i22;
                                b9tovu2.f9244ADYaiT = i21;
                                b9tovu2.AMqCpz = false;
                                break;
                            }
                        } else {
                            z = z2;
                        }
                        i18 = i20 + 2;
                        i14 = i;
                        A2egSU2 = i2;
                        z2 = z;
                    }
                    if (b9tovu2 != null) {
                        b9tovu = b9tovu2;
                        break;
                    }
                    boolean z3 = (b7CMnp2.A4TApA() - b7CMnp2.A2egSU()) % 2 == 0;
                    int A4TApA3 = b7CMnp2.A4TApA() - b7CMnp2.A2egSU();
                    int i24 = i17;
                    while (true) {
                        if (i24 > i16) {
                            b9tovu3 = null;
                            break;
                        }
                        if (i24 == i17 || (i24 != i16 && iArr2[i24 + 1 + i] < iArr2[(i24 - 1) + i])) {
                            i3 = iArr2[i24 + 1 + i];
                            i4 = i3;
                        } else {
                            i3 = iArr2[(i24 - 1) + i];
                            i4 = i3 - 1;
                        }
                        int i25 = b7CMnp2.f9240ADYaiT - ((b7CMnp2.f9238A4TApA - i4) - i24);
                        int i26 = (i16 == 0 || i4 != i3) ? i25 : i25 + 1;
                        boolean z4 = z3;
                        while (i4 > b7CMnp2.f9237A2egSU && i25 > b7CMnp2.f9239A5SV6n) {
                            i5 = A4TApA3;
                            if (!b25kr6.A4TApA(i4 - 1, i25 - 1)) {
                                break;
                            }
                            i4--;
                            i25--;
                            A4TApA3 = i5;
                        }
                        i5 = A4TApA3;
                        iArr2[i24 + i] = i4;
                        if (z4 && (i6 = i5 - i24) >= i17 && i6 <= i16 && iArr[i6 + i] >= i4) {
                            b9tovu3 = new B9tovu();
                            b9tovu3.f9241A2egSU = i4;
                            b9tovu3.f9242A4TApA = i25;
                            b9tovu3.f9243A5SV6n = i3;
                            b9tovu3.f9244ADYaiT = i26;
                            b9tovu3.AMqCpz = true;
                            break;
                        }
                        i24 += 2;
                        z3 = z4;
                        A4TApA3 = i5;
                    }
                    if (b9tovu3 != null) {
                        b9tovu = b9tovu3;
                        break;
                    }
                    i16++;
                    i14 = i;
                    A2egSU2 = i2;
                    i12 = 1;
                }
            }
            i = i14;
            b9tovu = null;
            if (b9tovu != null) {
                if (b9tovu.A2egSU() > 0) {
                    int i27 = b9tovu.f9244ADYaiT;
                    int i28 = b9tovu.f9242A4TApA;
                    int i29 = i27 - i28;
                    int i30 = b9tovu.f9243A5SV6n;
                    int i31 = b9tovu.f9241A2egSU;
                    int i32 = i30 - i31;
                    arrayList.add(i29 != i32 ? b9tovu.AMqCpz ? new B2KMhB(i31, i28, b9tovu.A2egSU()) : i29 > i32 ? new B2KMhB(i31, i28 + 1, b9tovu.A2egSU()) : new B2KMhB(i31 + 1, i28, b9tovu.A2egSU()) : new B2KMhB(i31, i28, i32));
                }
                B7CMnp b7CMnp3 = arrayList3.isEmpty() ? new B7CMnp() : (B7CMnp) arrayList3.remove(arrayList3.size() - 1);
                b7CMnp3.f9237A2egSU = b7CMnp2.f9237A2egSU;
                b7CMnp3.f9239A5SV6n = b7CMnp2.f9239A5SV6n;
                b7CMnp3.f9238A4TApA = b9tovu.f9241A2egSU;
                b7CMnp3.f9240ADYaiT = b9tovu.f9242A4TApA;
                arrayList2.add(b7CMnp3);
                b7CMnp2.f9238A4TApA = b7CMnp2.f9238A4TApA;
                b7CMnp2.f9240ADYaiT = b7CMnp2.f9240ADYaiT;
                b7CMnp2.f9237A2egSU = b9tovu.f9243A5SV6n;
                b7CMnp2.f9239A5SV6n = b9tovu.f9244ADYaiT;
                arrayList2.add(b7CMnp2);
            } else {
                arrayList3.add(b7CMnp2);
            }
            i14 = i;
            i12 = 1;
        }
        Collections.sort(arrayList, f9245A2egSU);
        return new B3GDIM(b25kr6, arrayList, iArr, iArr2);
    }

    private static /* synthetic */ void TLggK() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
