package com.czhj.wire;

import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.WireEnum;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
    }

    @Override // com.czhj.wire.ProtoAdapter
    public final E decode(ProtoReader protoReader) {
        int readVarint32 = protoReader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.javaType);
    }

    @Override // com.czhj.wire.ProtoAdapter
    public final void encode(ProtoWriter protoWriter, E e) {
        protoWriter.writeVarint32(e.getValue());
    }

    @Override // com.czhj.wire.ProtoAdapter
    public final int encodedSize(E e) {
        return ProtoWriter.c(e.getValue());
    }

    public abstract E fromValue(int i);
}
