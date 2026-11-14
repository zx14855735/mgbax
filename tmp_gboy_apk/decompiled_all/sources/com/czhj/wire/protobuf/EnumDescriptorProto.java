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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EnumDescriptorProto extends Message<EnumDescriptorProto, Builder> {
    public static final ProtoAdapter<EnumDescriptorProto> ADAPTER = new ProtoAdapter_EnumDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.EnumOptions#ADAPTER", tag = 3)
    public final EnumOptions options;

    @WireField(adapter = "com.google.protobuf.EnumValueDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<EnumValueDescriptorProto> value;

    public static final class Builder extends Message.Builder<EnumDescriptorProto, Builder> {
        public String name;
        public EnumOptions options;
        public List<EnumValueDescriptorProto> value = Internal.newMutableList();

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(EnumOptions enumOptions) {
            this.options = enumOptions;
            return this;
        }

        public Builder value(List<EnumValueDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.value = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public EnumDescriptorProto build() {
            return new EnumDescriptorProto(this.name, this.value, this.options, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_EnumDescriptorProto extends ProtoAdapter<EnumDescriptorProto> {
        public ProtoAdapter_EnumDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public EnumDescriptorProto decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.value.add(EnumValueDescriptorProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.options(EnumOptions.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, EnumDescriptorProto enumDescriptorProto) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, enumDescriptorProto.name);
            EnumValueDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, enumDescriptorProto.value);
            EnumOptions.ADAPTER.encodeWithTag(protoWriter, 3, enumDescriptorProto.options);
            protoWriter.writeBytes(enumDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(EnumDescriptorProto enumDescriptorProto) {
            return enumDescriptorProto.unknownFields().size() + EnumOptions.ADAPTER.encodedSizeWithTag(3, enumDescriptorProto.options) + EnumValueDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, enumDescriptorProto.value) + ProtoAdapter.STRING.encodedSizeWithTag(1, enumDescriptorProto.name);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public EnumDescriptorProto redact(EnumDescriptorProto enumDescriptorProto) {
            Builder newBuilder = enumDescriptorProto.newBuilder();
            Internal.redactElements(newBuilder.value, EnumValueDescriptorProto.ADAPTER);
            EnumOptions enumOptions = newBuilder.options;
            if (enumOptions != null) {
                newBuilder.options = EnumOptions.ADAPTER.redact(enumOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        zXUmze();
    }

    public EnumDescriptorProto(String str, List<EnumValueDescriptorProto> list, EnumOptions enumOptions) {
        this(str, list, enumOptions, ByteString.EMPTY);
    }

    private static /* synthetic */ void zXUmze() {
        char[] charArray = "\u008b\u0087\u0085Æ\u008f\u0089\u0085\u008dÆ\u008a\u0087\u0091Æ\u009b\u0080\u008d\u0084\u0084Æ¢\u0086\u0081ª\u009a\u0081\u008c\u008f\u008d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 232);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008b\u0084\u0081\u0086\u0081\u009c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 232);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnumDescriptorProto)) {
            return false;
        }
        EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj;
        return unknownFields().equals(enumDescriptorProto.unknownFields()) && Internal.equals(this.name, enumDescriptorProto.name) && this.value.equals(enumDescriptorProto.value) && Internal.equals(this.options, enumDescriptorProto.options);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int A5SV6n2 = A2egSU.A5SV6n(this.value, (hashCode + (str != null ? str.hashCode() : 0)) * 37, 37);
        EnumOptions enumOptions = this.options;
        int hashCode2 = A5SV6n2 + (enumOptions != null ? enumOptions.hashCode() : 0);
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
        if (!this.value.isEmpty()) {
            sb.append(", value=");
            sb.append(this.value);
        }
        if (this.options != null) {
            sb.append(", options=");
            sb.append(this.options);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "EnumDescriptorProto{", '}');
    }

    public EnumDescriptorProto(String str, List<EnumValueDescriptorProto> list, EnumOptions enumOptions, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.value = Internal.immutableCopyOf("value", list);
        this.options = enumOptions;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.value = Internal.copyOf("value", this.value);
        builder.options = this.options;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
