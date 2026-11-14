package com.czhj.wire;

import ADYaiT.CtFAbx;
import com.czhj.wire.Message;
import com.czhj.wire.WireField;
import com.czhj.wire.okio.Buffer;
import com.czhj.wire.okio.BufferedSink;
import com.czhj.wire.okio.BufferedSource;
import com.czhj.wire.okio.ByteString;
import com.czhj.wire.okio.Okio;
import com.czhj.wire.okio.Utf8;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL;
    public static final ProtoAdapter<ByteString> BYTES;
    public static final ProtoAdapter<Double> DOUBLE;
    public static final ProtoAdapter<Integer> FIXED32;
    public static final ProtoAdapter<Long> FIXED64;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT;
    public static final ProtoAdapter<Integer> INT32;
    public static final ProtoAdapter<Long> INT64;
    public static final ProtoAdapter<Integer> SFIXED32;
    public static final ProtoAdapter<Long> SFIXED64;
    public static final ProtoAdapter<Integer> SINT32;
    public static final ProtoAdapter<Long> SINT64;
    public static final ProtoAdapter<String> STRING;
    public static final ProtoAdapter<Integer> UINT32;
    public static final ProtoAdapter<Long> UINT64;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public EnumConstantNotFoundException(int r3, java.lang.Class<?> r4) {
            /*
                r2 = this;
                java.lang.String r0 = "Unknown enum tag "
                java.lang.String r1 = " for "
                java.lang.StringBuilder r0 = J3FDQU.A2egSU.B9tovu(r3, r0, r1)
                java.lang.String r4 = r4.getCanonicalName()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4)
                r2.value = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.ProtoAdapter.EnumConstantNotFoundException.<init>(int, java.lang.Class):void");
        }
    }

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final ProtoAdapter<K> f10669a;
        final ProtoAdapter<V> b;

        public MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, Map.Entry.class);
            this.f10669a = protoAdapter;
            this.b = protoAdapter2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader protoReader) {
            throw new UnsupportedOperationException();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Map.Entry<K, V> entry) {
            this.f10669a.encodeWithTag(protoWriter, 1, entry.getKey());
            this.b.encodeWithTag(protoWriter, 2, entry.getValue());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Map.Entry<K, V> entry) {
            return this.b.encodedSizeWithTag(2, entry.getValue()) + this.f10669a.encodedSizeWithTag(1, entry.getKey());
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final MapEntryProtoAdapter<K, V> f10670a;

        public MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, Map.class);
            this.f10670a = new MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader protoReader) {
            long beginMessage = protoReader.beginMessage();
            K k = null;
            V v = null;
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    break;
                }
                if (nextTag == 1) {
                    k = this.f10670a.f10669a.decode(protoReader);
                } else if (nextTag == 2) {
                    v = this.f10670a.b.decode(protoReader);
                }
            }
            protoReader.endMessage(beginMessage);
            if (k == null) {
                throw new IllegalStateException("Map entry with null key");
            }
            if (v != null) {
                return Collections.singletonMap(k, v);
            }
            throw new IllegalStateException("Map entry with null value");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encodeWithTag(ProtoWriter protoWriter, int i, Map<K, V> map) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.f10670a.encodeWithTag(protoWriter, i, it.next());
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSizeWithTag(int i, Map<K, V> map) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += this.f10670a.encodedSizeWithTag(i, it.next());
            }
            return i2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Map<K, V> redact(Map<K, V> map) {
            return Collections.EMPTY_MAP;
        }
    }

    static {
        FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        BOOL = new ProtoAdapter<Boolean>(fieldEncoding, Boolean.class) { // from class: com.czhj.wire.ProtoAdapter.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Boolean decode(ProtoReader protoReader) {
                int readVarint32 = protoReader.readVarint32();
                if (readVarint32 == 0) {
                    return Boolean.FALSE;
                }
                if (readVarint32 == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Boolean bool) {
                protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Boolean bool) {
                return 1;
            }
        };
        Class<Integer> cls = Integer.class;
        INT32 = new ProtoAdapter<Integer>(fieldEncoding, cls) { // from class: com.czhj.wire.ProtoAdapter.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) {
                return Integer.valueOf(protoReader.readVarint32());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) {
                protoWriter.f(num.intValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return ProtoWriter.b(num.intValue());
            }
        };
        UINT32 = new ProtoAdapter<Integer>(fieldEncoding, cls) { // from class: com.czhj.wire.ProtoAdapter.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) {
                return Integer.valueOf(protoReader.readVarint32());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) {
                protoWriter.writeVarint32(num.intValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return ProtoWriter.c(num.intValue());
            }
        };
        SINT32 = new ProtoAdapter<Integer>(fieldEncoding, cls) { // from class: com.czhj.wire.ProtoAdapter.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) {
                return Integer.valueOf(ProtoWriter.e(protoReader.readVarint32()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) {
                protoWriter.writeVarint32(ProtoWriter.d(num.intValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return ProtoWriter.c(ProtoWriter.d(num.intValue()));
            }
        };
        FieldEncoding fieldEncoding2 = FieldEncoding.FIXED32;
        ProtoAdapter<Integer> protoAdapter = new ProtoAdapter<Integer>(fieldEncoding2, cls) { // from class: com.czhj.wire.ProtoAdapter.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) {
                return Integer.valueOf(protoReader.readFixed32());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Integer num) {
                protoWriter.writeFixed32(num.intValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Integer num) {
                return 4;
            }
        };
        FIXED32 = protoAdapter;
        SFIXED32 = protoAdapter;
        Class<Long> cls2 = Long.class;
        INT64 = new ProtoAdapter<Long>(fieldEncoding, cls2) { // from class: com.czhj.wire.ProtoAdapter.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) {
                return Long.valueOf(protoReader.readVarint64());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l) {
                protoWriter.writeVarint64(l.longValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l) {
                return ProtoWriter.a(l.longValue());
            }
        };
        UINT64 = new ProtoAdapter<Long>(fieldEncoding, cls2) { // from class: com.czhj.wire.ProtoAdapter.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) {
                return Long.valueOf(protoReader.readVarint64());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l) {
                protoWriter.writeVarint64(l.longValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l) {
                return ProtoWriter.a(l.longValue());
            }
        };
        SINT64 = new ProtoAdapter<Long>(fieldEncoding, cls2) { // from class: com.czhj.wire.ProtoAdapter.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) {
                return Long.valueOf(ProtoWriter.c(protoReader.readVarint64()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l) {
                protoWriter.writeVarint64(ProtoWriter.b(l.longValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l) {
                return ProtoWriter.a(ProtoWriter.b(l.longValue()));
            }
        };
        FieldEncoding fieldEncoding3 = FieldEncoding.FIXED64;
        ProtoAdapter<Long> protoAdapter2 = new ProtoAdapter<Long>(fieldEncoding3, cls2) { // from class: com.czhj.wire.ProtoAdapter.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) {
                return Long.valueOf(protoReader.readFixed64());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Long l) {
                protoWriter.writeFixed64(l.longValue());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Long l) {
                return 8;
            }
        };
        FIXED64 = protoAdapter2;
        SFIXED64 = protoAdapter2;
        FLOAT = new ProtoAdapter<Float>(fieldEncoding2, Float.class) { // from class: com.czhj.wire.ProtoAdapter.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Float decode(ProtoReader protoReader) {
                return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Float f) {
                protoWriter.writeFixed32(Float.floatToIntBits(f.floatValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Float f) {
                return 4;
            }
        };
        DOUBLE = new ProtoAdapter<Double>(fieldEncoding3, Double.class) { // from class: com.czhj.wire.ProtoAdapter.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public Double decode(ProtoReader protoReader) {
                return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Double d) {
                protoWriter.writeFixed64(Double.doubleToLongBits(d.doubleValue()));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(Double d) {
                return 8;
            }
        };
        FieldEncoding fieldEncoding4 = FieldEncoding.LENGTH_DELIMITED;
        STRING = new ProtoAdapter<String>(fieldEncoding4, String.class) { // from class: com.czhj.wire.ProtoAdapter.12
            @Override // com.czhj.wire.ProtoAdapter
            public String decode(ProtoReader protoReader) {
                return protoReader.readString();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, String str) {
                protoWriter.writeString(str);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(String str) {
                return (int) Utf8.size(str);
            }
        };
        BYTES = new ProtoAdapter<ByteString>(fieldEncoding4, ByteString.class) { // from class: com.czhj.wire.ProtoAdapter.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public ByteString decode(ProtoReader protoReader) {
                return protoReader.readBytes();
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ByteString byteString) {
                protoWriter.writeBytes(byteString);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(ByteString byteString) {
                return byteString.size();
            }
        };
        tmwWqCA();
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding fieldEncoding = this.fieldEncoding;
        FieldEncoding fieldEncoding2 = FieldEncoding.LENGTH_DELIMITED;
        if (fieldEncoding != fieldEncoding2) {
            return new ProtoAdapter<List<E>>(fieldEncoding2, List.class) { // from class: com.czhj.wire.ProtoAdapter.14
                @Override // com.czhj.wire.ProtoAdapter
                public List<E> decode(ProtoReader protoReader) {
                    return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
                }

                @Override // com.czhj.wire.ProtoAdapter
                public void encode(ProtoWriter protoWriter, List<E> list) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ProtoAdapter.this.encode(protoWriter, (ProtoWriter) list.get(i));
                    }
                }

                @Override // com.czhj.wire.ProtoAdapter
                public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) {
                    if (list.isEmpty()) {
                        return;
                    }
                    super.encodeWithTag(protoWriter, i, (int) list);
                }

                @Override // com.czhj.wire.ProtoAdapter
                public int encodedSize(List<E> list) {
                    int size = list.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        i += ProtoAdapter.this.encodedSize(list.get(i2));
                    }
                    return i;
                }

                @Override // com.czhj.wire.ProtoAdapter
                public int encodedSizeWithTag(int i, List<E> list) {
                    if (list.isEmpty()) {
                        return 0;
                    }
                    return super.encodedSizeWithTag(i, (int) list);
                }

                @Override // com.czhj.wire.ProtoAdapter
                public List<E> redact(List<E> list) {
                    return Collections.EMPTY_LIST;
                }
            };
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) { // from class: com.czhj.wire.ProtoAdapter.15
            @Override // com.czhj.wire.ProtoAdapter
            public List<E> decode(ProtoReader protoReader) {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter protoWriter, int i, List<E> list) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ProtoAdapter.this.encodeWithTag(protoWriter, i, list.get(i2));
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSizeWithTag(int i, List<E> list) {
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += ProtoAdapter.this.encodedSizeWithTag(i, list.get(i3));
                }
                return i2;
            }

            @Override // com.czhj.wire.ProtoAdapter
            public List<E> redact(List<E> list) {
                return Collections.EMPTY_LIST;
            }
        };
    }

    public static <M extends Message> ProtoAdapter<M> get(M m) {
        return get(m.getClass());
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return new RuntimeEnumAdapter<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return RuntimeMessageAdapter.a(cls);
    }

    private static /* synthetic */ void tmwWqCA() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createPacked = createPacked();
        this.packedAdapter = createPacked;
        return createPacked;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createRepeated = createRepeated();
        this.repeatedAdapter = createRepeated;
        return createRepeated;
    }

    public abstract E decode(ProtoReader protoReader);

    public final E decode(BufferedSource bufferedSource) {
        Preconditions.a(bufferedSource, "source == null");
        return decode(new ProtoReader(bufferedSource));
    }

    public abstract void encode(ProtoWriter protoWriter, E e);

    public final void encode(BufferedSink bufferedSink, E e) {
        Preconditions.a(e, "value == null");
        Preconditions.a(bufferedSink, "sink == null");
        encode(new ProtoWriter(bufferedSink), (ProtoWriter) e);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, E e) {
        if (e == null) {
            return;
        }
        protoWriter.writeTag(i, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(e));
        }
        encode(protoWriter, (ProtoWriter) e);
    }

    public abstract int encodedSize(E e);

    public int encodedSizeWithTag(int i, E e) {
        if (e == null) {
            return 0;
        }
        int encodedSize = encodedSize(e);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += ProtoWriter.c(encodedSize);
        }
        return ProtoWriter.a(i) + encodedSize;
    }

    public E redact(E e) {
        return null;
    }

    public String toString(E e) {
        return e.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label label) {
        return label.a() ? label.b() ? asPacked() : asRepeated() : this;
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (Throwable th) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", th);
        }
    }

    public final E decode(ByteString byteString) {
        Preconditions.a(byteString, "bytes == null");
        return decode(new Buffer().write(byteString));
    }

    public final void encode(OutputStream outputStream, E e) {
        Preconditions.a(e, "value == null");
        Preconditions.a(outputStream, "stream == null");
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        encode(buffer, (BufferedSink) e);
        buffer.emit();
    }

    public static ProtoAdapter<?> get(String str) {
        try {
            int indexOf = str.indexOf(35);
            String substring = str.substring(0, indexOf);
            return (ProtoAdapter) Class.forName(substring).getField(str.substring(indexOf + 1)).get(null);
        } catch (Throwable th) {
            throw new IllegalArgumentException(CtFAbx.BChYOn("failed to access ", str), th);
        }
    }

    public final E decode(InputStream inputStream) {
        Preconditions.a(inputStream, "stream == null");
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final byte[] encode(E e) {
        Preconditions.a(e, "value == null");
        Buffer buffer = new Buffer();
        try {
            encode((BufferedSink) buffer, (Buffer) e);
            return buffer.readByteArray();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E decode(byte[] bArr) {
        Preconditions.a(bArr, "bytes == null");
        return decode(new Buffer().write(bArr));
    }
}
