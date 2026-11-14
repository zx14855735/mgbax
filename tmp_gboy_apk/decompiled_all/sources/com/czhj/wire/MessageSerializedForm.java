package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f10666a;
    private final Class<M> b;

    public MessageSerializedForm(byte[] bArr, Class<M> cls) {
        this.f10666a = bArr;
        this.b = cls;
    }

    public Object readResolve() {
        try {
            return ProtoAdapter.get(this.b).decode(this.f10666a);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
