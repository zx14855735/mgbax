package okhttp3.internal.http2;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.cm;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final ADYaiT[] STATIC_HEADER_TABLE;

    public static final class A2egSU {
        ADYaiT[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<ADYaiT> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        public A2egSU(int i, Source source) {
            this(i, i, source);
        }

        public final int A2egSU(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.dynamicTable[length].hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                ADYaiT[] aDYaiTArr = this.dynamicTable;
                System.arraycopy(aDYaiTArr, i2 + 1, aDYaiTArr, i2 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        public final ArrayList A4TApA() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        public final ByteString A5SV6n(int i) {
            if (i >= 0) {
                ADYaiT[] aDYaiTArr = AMqCpz.STATIC_HEADER_TABLE;
                if (i <= aDYaiTArr.length - 1) {
                    return aDYaiTArr[i].name;
                }
            }
            int length = this.nextHeaderIndex + 1 + (i - AMqCpz.STATIC_HEADER_TABLE.length);
            if (length >= 0) {
                ADYaiT[] aDYaiTArr2 = this.dynamicTable;
                if (length < aDYaiTArr2.length) {
                    return aDYaiTArr2[length].name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final void ADYaiT(ADYaiT aDYaiT) {
            this.headerList.add(aDYaiT);
            int i = aDYaiT.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                Arrays.fill(this.dynamicTable, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            A2egSU((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            ADYaiT[] aDYaiTArr = this.dynamicTable;
            if (i3 > aDYaiTArr.length) {
                ADYaiT[] aDYaiTArr2 = new ADYaiT[aDYaiTArr.length * 2];
                System.arraycopy(aDYaiTArr, 0, aDYaiTArr2, aDYaiTArr.length, aDYaiTArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = aDYaiTArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = aDYaiT;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final ByteString AMqCpz() {
            byte readByte = this.source.readByte();
            int i = readByte & 255;
            boolean z = (readByte & 128) == 128;
            int ASJ6gh2 = ASJ6gh(i, AMqCpz.PREFIX_7_BITS);
            return z ? ByteString.of(B9tovu.ADYaiT().A2egSU(this.source.readByteArray(ASJ6gh2))) : this.source.readByteString(ASJ6gh2);
        }

        public final void ARc23Z() {
            while (!this.source.exhausted()) {
                byte readByte = this.source.readByte();
                int i = readByte & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    int ASJ6gh2 = ASJ6gh(i, AMqCpz.PREFIX_7_BITS);
                    int i2 = ASJ6gh2 - 1;
                    if (i2 >= 0) {
                        ADYaiT[] aDYaiTArr = AMqCpz.STATIC_HEADER_TABLE;
                        if (i2 <= aDYaiTArr.length - 1) {
                            this.headerList.add(aDYaiTArr[i2]);
                        }
                    }
                    int length = this.nextHeaderIndex + 1 + (i2 - AMqCpz.STATIC_HEADER_TABLE.length);
                    if (length >= 0) {
                        ADYaiT[] aDYaiTArr2 = this.dynamicTable;
                        if (length < aDYaiTArr2.length) {
                            this.headerList.add(aDYaiTArr2[length]);
                        }
                    }
                    throw new IOException(CtFAbx.ARc23Z(ASJ6gh2, "Header index too large "));
                }
                if (i == 64) {
                    ByteString AMqCpz = AMqCpz();
                    AMqCpz.A2egSU(AMqCpz);
                    ADYaiT(new ADYaiT(AMqCpz, AMqCpz()));
                } else if ((readByte & 64) == 64) {
                    ADYaiT(new ADYaiT(A5SV6n(ASJ6gh(i, 63) - 1), AMqCpz()));
                } else if ((readByte & 32) == 32) {
                    int ASJ6gh3 = ASJ6gh(i, 31);
                    this.maxDynamicTableByteCount = ASJ6gh3;
                    if (ASJ6gh3 < 0 || ASJ6gh3 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    int i3 = this.dynamicTableByteCount;
                    if (ASJ6gh3 < i3) {
                        if (ASJ6gh3 == 0) {
                            Arrays.fill(this.dynamicTable, (Object) null);
                            this.nextHeaderIndex = this.dynamicTable.length - 1;
                            this.headerCount = 0;
                            this.dynamicTableByteCount = 0;
                        } else {
                            A2egSU(i3 - ASJ6gh3);
                        }
                    }
                } else if (i == 16 || i == 0) {
                    ByteString AMqCpz2 = AMqCpz();
                    AMqCpz.A2egSU(AMqCpz2);
                    this.headerList.add(new ADYaiT(AMqCpz2, AMqCpz()));
                } else {
                    this.headerList.add(new ADYaiT(A5SV6n(ASJ6gh(i, 15) - 1), AMqCpz()));
                }
            }
        }

        public final int ASJ6gh(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte readByte = this.source.readByte();
                int i5 = readByte & 255;
                if ((readByte & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (readByte & Byte.MAX_VALUE) << i4;
                i4 += 7;
            }
        }

        public A2egSU(int i, int i2, Source source) {
            this.headerList = new ArrayList();
            this.dynamicTable = new ADYaiT[8];
            this.nextHeaderIndex = r0.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = Okio.buffer(source);
        }
    }

    public static final class A4TApA {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        ADYaiT[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public A4TApA(Buffer buffer) {
            this(4096, true, buffer);
        }

        public final void A2egSU(int i) {
            int i2;
            if (i > 0) {
                int length = this.dynamicTable.length - 1;
                int i3 = 0;
                while (true) {
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.dynamicTable[length].hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                    length--;
                }
                ADYaiT[] aDYaiTArr = this.dynamicTable;
                int i5 = i2 + 1;
                System.arraycopy(aDYaiTArr, i5, aDYaiTArr, i5 + i3, this.headerCount);
                ADYaiT[] aDYaiTArr2 = this.dynamicTable;
                int i6 = this.nextHeaderIndex + 1;
                Arrays.fill(aDYaiTArr2, i6, i6 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
        }

        public final void A4TApA(ADYaiT aDYaiT) {
            int i = aDYaiT.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                Arrays.fill(this.dynamicTable, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            A2egSU((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            ADYaiT[] aDYaiTArr = this.dynamicTable;
            if (i3 > aDYaiTArr.length) {
                ADYaiT[] aDYaiTArr2 = new ADYaiT[aDYaiTArr.length * 2];
                System.arraycopy(aDYaiTArr, 0, aDYaiTArr2, aDYaiTArr.length, aDYaiTArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = aDYaiTArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = aDYaiT;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void A5SV6n(int i) {
            this.headerTableSizeSetting = i;
            int min = Math.min(i, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            int i3 = this.dynamicTableByteCount;
            if (min < i3) {
                if (min != 0) {
                    A2egSU(i3 - min);
                    return;
                }
                Arrays.fill(this.dynamicTable, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
            }
        }

        public final void ADYaiT(ByteString byteString) {
            if (this.useCompression) {
                B9tovu.ADYaiT().getClass();
                if (B9tovu.A5SV6n(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    B9tovu.ADYaiT().getClass();
                    B9tovu.A4TApA(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    ARc23Z(readByteString.size(), AMqCpz.PREFIX_7_BITS, r.b.d);
                    this.out.write(readByteString);
                    return;
                }
            }
            ARc23Z(byteString.size(), AMqCpz.PREFIX_7_BITS, 0);
            this.out.write(byteString);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void AMqCpz(java.util.ArrayList r14) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.AMqCpz.A4TApA.AMqCpz(java.util.ArrayList):void");
        }

        public final void ARc23Z(int i, int i2, int i3) {
            if (i < i2) {
                this.out.writeByte(i | i3);
                return;
            }
            this.out.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.writeByte(128 | (i4 & AMqCpz.PREFIX_7_BITS));
                i4 >>>= 7;
            }
            this.out.writeByte(i4);
        }

        public A4TApA(int i, boolean z, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new ADYaiT[8];
            this.nextHeaderIndex = r0.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.useCompression = z;
            this.out = buffer;
        }
    }

    static {
        ADYaiT aDYaiT = new ADYaiT(ADYaiT.TARGET_AUTHORITY, "");
        ByteString byteString = ADYaiT.TARGET_METHOD;
        ADYaiT aDYaiT2 = new ADYaiT(byteString, an.c);
        ADYaiT aDYaiT3 = new ADYaiT(byteString, an.b);
        ByteString byteString2 = ADYaiT.TARGET_PATH;
        ADYaiT aDYaiT4 = new ADYaiT(byteString2, "/");
        ADYaiT aDYaiT5 = new ADYaiT(byteString2, "/index.html");
        ByteString byteString3 = ADYaiT.TARGET_SCHEME;
        ADYaiT aDYaiT6 = new ADYaiT(byteString3, Constants.HTTP);
        ADYaiT aDYaiT7 = new ADYaiT(byteString3, "https");
        ByteString byteString4 = ADYaiT.RESPONSE_STATUS;
        int i = 0;
        ADYaiT[] aDYaiTArr = {aDYaiT, aDYaiT2, aDYaiT3, aDYaiT4, aDYaiT5, aDYaiT6, aDYaiT7, new ADYaiT(byteString4, "200"), new ADYaiT(byteString4, "204"), new ADYaiT(byteString4, "206"), new ADYaiT(byteString4, "304"), new ADYaiT(byteString4, "400"), new ADYaiT(byteString4, cm.b), new ADYaiT(byteString4, "500"), new ADYaiT("accept-charset", ""), new ADYaiT("accept-encoding", "gzip, deflate"), new ADYaiT("accept-language", ""), new ADYaiT("accept-ranges", ""), new ADYaiT("accept", ""), new ADYaiT("access-control-allow-origin", ""), new ADYaiT("age", ""), new ADYaiT("allow", ""), new ADYaiT("authorization", ""), new ADYaiT("cache-control", ""), new ADYaiT("content-disposition", ""), new ADYaiT("content-encoding", ""), new ADYaiT("content-language", ""), new ADYaiT("content-length", ""), new ADYaiT("content-location", ""), new ADYaiT("content-range", ""), new ADYaiT("content-type", ""), new ADYaiT("cookie", ""), new ADYaiT("date", ""), new ADYaiT(f.c, ""), new ADYaiT("expect", ""), new ADYaiT("expires", ""), new ADYaiT("from", ""), new ADYaiT("host", ""), new ADYaiT("if-match", ""), new ADYaiT("if-modified-since", ""), new ADYaiT("if-none-match", ""), new ADYaiT("if-range", ""), new ADYaiT("if-unmodified-since", ""), new ADYaiT("last-modified", ""), new ADYaiT("link", ""), new ADYaiT("location", ""), new ADYaiT("max-forwards", ""), new ADYaiT("proxy-authenticate", ""), new ADYaiT("proxy-authorization", ""), new ADYaiT("range", ""), new ADYaiT("referer", ""), new ADYaiT("refresh", ""), new ADYaiT("retry-after", ""), new ADYaiT("server", ""), new ADYaiT("set-cookie", ""), new ADYaiT("strict-transport-security", ""), new ADYaiT("transfer-encoding", ""), new ADYaiT("user-agent", ""), new ADYaiT("vary", ""), new ADYaiT("via", ""), new ADYaiT("www-authenticate", "")};
        STATIC_HEADER_TABLE = aDYaiTArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(aDYaiTArr.length);
        while (true) {
            ADYaiT[] aDYaiTArr2 = STATIC_HEADER_TABLE;
            if (i >= aDYaiTArr2.length) {
                NAME_TO_FIRST_INDEX = Collections.unmodifiableMap(linkedHashMap);
                abSH();
                return;
            } else {
                if (!linkedHashMap.containsKey(aDYaiTArr2[i].name)) {
                    linkedHashMap.put(aDYaiTArr2[i].name, Integer.valueOf(i));
                }
                i++;
            }
        }
    }

    private AMqCpz() {
    }

    public static void A2egSU(ByteString byteString) {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = byteString.getByte(i);
            if (b >= 65 && b <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
    }

    private static /* synthetic */ void abSH() {
        char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 218);
        }
        String str = new String(charArray);
        char[] charArray2 = "¹¶³´³®".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 218);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
