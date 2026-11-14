package com.czhj.wire.okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    final ByteString[] f10698a;
    final int[] b;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.f10698a = byteStringArr;
        this.b = iArr;
    }

    private static int a(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.czhj.wire.okio.Options of(com.czhj.wire.okio.ByteString... r11) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.Options.of(com.czhj.wire.okio.ByteString[]):com.czhj.wire.okio.Options");
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.f10698a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10698a.length;
    }

    private static void a(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        long j2;
        int i6;
        List<Integer> list3;
        long j3;
        int i7;
        List<ByteString> list4 = list;
        List<Integer> list5 = list2;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (list4.get(i8).size() < i) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list4.get(i3 - 1);
        if (i == byteString.size()) {
            int intValue = list5.get(i2).intValue();
            int i9 = i2 + 1;
            ByteString byteString3 = list4.get(i9);
            i4 = i9;
            i5 = intValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        long j4 = 2;
        if (byteString.getByte(i) == byteString2.getByte(i)) {
            int min = Math.min(byteString.size(), byteString2.size());
            int i10 = 0;
            int i11 = i;
            while (true) {
                if (i11 >= min) {
                    j2 = j4;
                    break;
                }
                j2 = j4;
                if (byteString.getByte(i11) != byteString2.getByte(i11)) {
                    break;
                }
                i10++;
                i11++;
                j4 = j2;
            }
            long a2 = j + a(buffer) + j2 + i10 + 1;
            buffer.writeInt(-i10);
            buffer.writeInt(i5);
            int i12 = i;
            while (true) {
                i6 = i + i10;
                if (i12 >= i6) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i12) & 255);
                i12++;
            }
            if (i4 + 1 == i3) {
                if (i6 != list4.get(i4).size()) {
                    throw new AssertionError();
                }
                buffer.writeInt(list5.get(i4).intValue());
                return;
            } else {
                Buffer buffer2 = new Buffer();
                buffer.writeInt((int) ((a(buffer2) + a2) * (-1)));
                a(a2, buffer2, i6, list4, i4, i3, list5);
                buffer.write(buffer2, buffer2.size());
                return;
            }
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (list4.get(i14 - 1).getByte(i) != list4.get(i14).getByte(i)) {
                i13++;
            }
        }
        long a3 = j + a(buffer) + 2 + (i13 * 2);
        buffer.writeInt(i13);
        buffer.writeInt(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            byte b = list4.get(i15).getByte(i);
            if (i15 == i4 || b != list4.get(i15 - 1).getByte(i)) {
                buffer.writeInt(b & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        int i16 = i4;
        while (i16 < i3) {
            byte b2 = list4.get(i16).getByte(i);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i18 = i3;
                    break;
                } else if (b2 != list4.get(i18).getByte(i)) {
                    break;
                } else {
                    i18++;
                }
            }
            if (i17 == i18 && i + 1 == list4.get(i16).size()) {
                buffer.writeInt(list5.get(i16).intValue());
                list3 = list5;
                j3 = a3;
                i7 = i18;
            } else {
                buffer.writeInt((int) ((a(buffer3) + a3) * (-1)));
                list3 = list5;
                j3 = a3;
                i7 = i18;
                a(j3, buffer3, i + 1, list, i16, i7, list3);
                list4 = list;
            }
            a3 = j3;
            i16 = i7;
            list5 = list3;
        }
        buffer.write(buffer3, buffer3.size());
    }
}
