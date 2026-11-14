package com.czhj.wire.protobuf;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class OneofDescriptorProto extends Message<OneofDescriptorProto, Builder> {
    public static final ProtoAdapter<OneofDescriptorProto> ADAPTER = new ProtoAdapter_OneofDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    public static final class Builder extends Message.Builder<OneofDescriptorProto, Builder> {
        public String name;

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public OneofDescriptorProto build() {
            return new OneofDescriptorProto(this.name, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_OneofDescriptorProto extends ProtoAdapter<OneofDescriptorProto> {
        public ProtoAdapter_OneofDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, OneofDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public OneofDescriptorProto decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, OneofDescriptorProto oneofDescriptorProto) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, oneofDescriptorProto.name);
            protoWriter.writeBytes(oneofDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(OneofDescriptorProto oneofDescriptorProto) {
            return oneofDescriptorProto.unknownFields().size() + ProtoAdapter.STRING.encodedSizeWithTag(1, oneofDescriptorProto.name);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public OneofDescriptorProto redact(OneofDescriptorProto oneofDescriptorProto) {
            Builder newBuilder = oneofDescriptorProto.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        nZld();
    }

    public OneofDescriptorProto(String str) {
        this(str, ByteString.EMPTY);
    }

    private static /* synthetic */ void nZld() {
        char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 244);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 244);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OneofDescriptorProto)) {
            return false;
        }
        OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj;
        return unknownFields().equals(oneofDescriptorProto.unknownFields()) && Internal.equals(this.name, oneofDescriptorProto.name);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "OneofDescriptorProto{", '}');
    }

    public OneofDescriptorProto(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
