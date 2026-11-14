package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10674a = "██";
    private final Class<M> b;
    private final Class<B> c;
    private final Map<Integer, FieldBinding<M, B>> d;

    public RuntimeMessageAdapter(Class<M> cls, Class<B> cls2, Map<Integer, FieldBinding<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.b = cls;
        this.c = cls2;
        this.d = map;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> a(Class<M> cls) {
        Class b = b(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new FieldBinding(wireField, field, b));
            }
        }
        return new RuntimeMessageAdapter<>(cls, b, Collections.unmodifiableMap(linkedHashMap));
    }

    public B b() {
        try {
            return this.c.newInstance();
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    @Override // com.czhj.wire.ProtoAdapter
    public M decode(ProtoReader protoReader) {
        B b = b();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return (M) b.build();
            }
            FieldBinding<M, B> fieldBinding = this.d.get(Integer.valueOf(nextTag));
            if (fieldBinding != null) {
                try {
                    fieldBinding.a((FieldBinding<M, B>) b, (fieldBinding.a() ? fieldBinding.d() : fieldBinding.b()).decode(protoReader));
                } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                    b.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                }
            } else {
                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                b.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
            }
        }
    }

    @Override // com.czhj.wire.ProtoAdapter
    public void encode(ProtoWriter protoWriter, M m) {
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            Object a2 = fieldBinding.a((FieldBinding<M, B>) m);
            if (a2 != null) {
                fieldBinding.d().encodeWithTag(protoWriter, fieldBinding.tag, a2);
            }
        }
        protoWriter.writeBytes(m.unknownFields());
    }

    @Override // com.czhj.wire.ProtoAdapter
    public int encodedSize(M m) {
        int i = m.cachedSerializedSize;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            Object a2 = fieldBinding.a((FieldBinding<M, B>) m);
            if (a2 != null) {
                i2 += fieldBinding.d().encodedSizeWithTag(fieldBinding.tag, a2);
            }
        }
        int size = m.unknownFields().size() + i2;
        m.cachedSerializedSize = size;
        return size;
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && ((RuntimeMessageAdapter) obj).b == this.b;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.czhj.wire.ProtoAdapter
    public M redact(M m) {
        Message.Builder newBuilder = m.newBuilder();
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            if (fieldBinding.redacted && fieldBinding.label == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException("Field '" + fieldBinding.name + "' in " + this.javaType.getName() + " is required and cannot be redacted.");
            }
            boolean isAssignableFrom = Message.class.isAssignableFrom(fieldBinding.b().javaType);
            if (fieldBinding.redacted || (isAssignableFrom && !fieldBinding.label.a())) {
                Object a2 = fieldBinding.a((FieldBinding<M, B>) newBuilder);
                if (a2 != null) {
                    fieldBinding.b(newBuilder, fieldBinding.d().redact(a2));
                }
            } else if (isAssignableFrom && fieldBinding.label.a()) {
                Internal.redactElements((List) fieldBinding.a((FieldBinding<M, B>) newBuilder), fieldBinding.b());
            }
        }
        newBuilder.clearUnknownFields();
        return (M) newBuilder.build();
    }

    @Override // com.czhj.wire.ProtoAdapter
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            Object a2 = fieldBinding.a((FieldBinding<M, B>) m);
            if (a2 != null) {
                sb.append(", ");
                sb.append(fieldBinding.name);
                sb.append('=');
                if (fieldBinding.redacted) {
                    a2 = f10674a;
                }
                sb.append(a2);
            }
        }
        sb.replace(0, 2, this.b.getSimpleName().concat("{"));
        sb.append('}');
        return sb.toString();
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> b(Class<M> cls) {
        try {
            return (Class<B>) Class.forName(cls.getName().concat("$Builder"));
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type ".concat(cls.getName()));
        }
    }

    public Map<Integer, FieldBinding<M, B>> a() {
        return this.d;
    }
}
