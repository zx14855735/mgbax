package com.czhj.wire.protobuf;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.wire.EnumAdapter;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireEnum;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class FieldDescriptorProto extends Message<FieldDescriptorProto, Builder> {
    public static final String DEFAULT_DEFAULT_VALUE = "";
    public static final String DEFAULT_EXTENDEE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_TYPE_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String default_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String extendee;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto$Label#ADAPTER", tag = 4)
    public final Label label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer number;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer oneof_index;

    @WireField(adapter = "com.google.protobuf.FieldOptions#ADAPTER", tag = 8)
    public final FieldOptions options;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto$Type#ADAPTER", tag = 5)
    public final Type type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String type_name;
    public static final ProtoAdapter<FieldDescriptorProto> ADAPTER = new ProtoAdapter_FieldDescriptorProto();
    public static final Integer DEFAULT_NUMBER = 0;
    public static final Label DEFAULT_LABEL = Label.LABEL_OPTIONAL;
    public static final Type DEFAULT_TYPE = Type.TYPE_DOUBLE;
    public static final Integer DEFAULT_ONEOF_INDEX = 0;

    public static final class Builder extends Message.Builder<FieldDescriptorProto, Builder> {
        public String default_value;
        public String extendee;
        public Label label;
        public String name;
        public Integer number;
        public Integer oneof_index;
        public FieldOptions options;
        public Type type;
        public String type_name;

        public Builder default_value(String str) {
            this.default_value = str;
            return this;
        }

        public Builder extendee(String str) {
            this.extendee = str;
            return this;
        }

        public Builder label(Label label) {
            this.label = label;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder number(Integer num) {
            this.number = num;
            return this;
        }

        public Builder oneof_index(Integer num) {
            this.oneof_index = num;
            return this;
        }

        public Builder options(FieldOptions fieldOptions) {
            this.options = fieldOptions;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder type_name(String str) {
            this.type_name = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public FieldDescriptorProto build() {
            return new FieldDescriptorProto(this.name, this.number, this.label, this.type, this.type_name, this.extendee, this.default_value, this.oneof_index, this.options, buildUnknownFields());
        }
    }

    public enum Label implements WireEnum {
        LABEL_OPTIONAL(1),
        LABEL_REQUIRED(2),
        LABEL_REPEATED(3);

        public static final ProtoAdapter<Label> ADAPTER = new ProtoAdapter_Label();
        private final int value;

        public static final class ProtoAdapter_Label extends EnumAdapter<Label> {
            public ProtoAdapter_Label() {
                super(Label.class);
            }

            @Override // com.czhj.wire.EnumAdapter
            public Label fromValue(int i) {
                return Label.fromValue(i);
            }
        }

        static {
            mJOiTcs();
        }

        Label(int i) {
            this.value = i;
        }

        public static Label fromValue(int i) {
            if (i == 1) {
                return LABEL_OPTIONAL;
            }
            if (i == 2) {
                return LABEL_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return LABEL_REPEATED;
        }

        private static /* synthetic */ void mJOiTcs() {
            char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 30);
            }
            String str = new String(charArray);
            char[] charArray2 = "}rwpwj".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 30);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // com.czhj.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class ProtoAdapter_FieldDescriptorProto extends ProtoAdapter<FieldDescriptorProto> {
        public ProtoAdapter_FieldDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, FieldDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public FieldDescriptorProto decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.extendee(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 3:
                        builder.number(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 4:
                        builder.label(Label.ADAPTER.decode(protoReader));
                        break;
                    case 5:
                        try {
                            builder.type(Type.ADAPTER.decode(protoReader));
                            break;
                        } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                            builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                            break;
                        }
                    case 6:
                        builder.type_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 7:
                        builder.default_value(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 8:
                        builder.options(FieldOptions.ADAPTER.decode(protoReader));
                        break;
                    case 9:
                        builder.oneof_index(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FieldDescriptorProto fieldDescriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, fieldDescriptorProto.name);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            protoAdapter2.encodeWithTag(protoWriter, 3, fieldDescriptorProto.number);
            Label.ADAPTER.encodeWithTag(protoWriter, 4, fieldDescriptorProto.label);
            Type.ADAPTER.encodeWithTag(protoWriter, 5, fieldDescriptorProto.type);
            protoAdapter.encodeWithTag(protoWriter, 6, fieldDescriptorProto.type_name);
            protoAdapter.encodeWithTag(protoWriter, 2, fieldDescriptorProto.extendee);
            protoAdapter.encodeWithTag(protoWriter, 7, fieldDescriptorProto.default_value);
            protoAdapter2.encodeWithTag(protoWriter, 9, fieldDescriptorProto.oneof_index);
            FieldOptions.ADAPTER.encodeWithTag(protoWriter, 8, fieldDescriptorProto.options);
            protoWriter.writeBytes(fieldDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FieldDescriptorProto fieldDescriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, fieldDescriptorProto.name);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            return fieldDescriptorProto.unknownFields().size() + FieldOptions.ADAPTER.encodedSizeWithTag(8, fieldDescriptorProto.options) + protoAdapter2.encodedSizeWithTag(9, fieldDescriptorProto.oneof_index) + protoAdapter.encodedSizeWithTag(7, fieldDescriptorProto.default_value) + protoAdapter.encodedSizeWithTag(2, fieldDescriptorProto.extendee) + protoAdapter.encodedSizeWithTag(6, fieldDescriptorProto.type_name) + Type.ADAPTER.encodedSizeWithTag(5, fieldDescriptorProto.type) + Label.ADAPTER.encodedSizeWithTag(4, fieldDescriptorProto.label) + protoAdapter2.encodedSizeWithTag(3, fieldDescriptorProto.number) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FieldDescriptorProto redact(FieldDescriptorProto fieldDescriptorProto) {
            Builder newBuilder = fieldDescriptorProto.newBuilder();
            FieldOptions fieldOptions = newBuilder.options;
            if (fieldOptions != null) {
                newBuilder.options = FieldOptions.ADAPTER.redact(fieldOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public enum Type implements WireEnum {
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18);

        public static final ProtoAdapter<Type> ADAPTER = new ProtoAdapter_Type();
        private final int value;

        public static final class ProtoAdapter_Type extends EnumAdapter<Type> {
            public ProtoAdapter_Type() {
                super(Type.class);
            }

            @Override // com.czhj.wire.EnumAdapter
            public Type fromValue(int i) {
                return Type.fromValue(i);
            }
        }

        static {
            cgNqfA();
        }

        Type(int i) {
            this.value = i;
        }

        private static /* synthetic */ void cgNqfA() {
            char[] charArray = "ÐÜÞ\u009dÔÒÞÖ\u009dÑÜÊ\u009dÀÛÖßß\u009dùÝÚñÁÚ×ÔÖ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 179);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÐßÚÝÚÇ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 179);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static Type fromValue(int i) {
            switch (i) {
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        @Override // com.czhj.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    static {
        KEEK();
    }

    public FieldDescriptorProto(String str, Integer num, Label label, Type type, String str2, String str3, String str4, Integer num2, FieldOptions fieldOptions) {
        this(str, num, label, type, str2, str3, str4, num2, fieldOptions, ByteString.EMPTY);
    }

    private static /* synthetic */ void KEEK() {
        char[] charArray = "HDF\u0005LJFN\u0005IDR\u0005XCNGG\u0005aEBiYBOLN".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '+');
        }
        String str = new String(charArray);
        char[] charArray2 = "HGBEB_".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '+');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldDescriptorProto)) {
            return false;
        }
        FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj;
        return unknownFields().equals(fieldDescriptorProto.unknownFields()) && Internal.equals(this.name, fieldDescriptorProto.name) && Internal.equals(this.number, fieldDescriptorProto.number) && Internal.equals(this.label, fieldDescriptorProto.label) && Internal.equals(this.type, fieldDescriptorProto.type) && Internal.equals(this.type_name, fieldDescriptorProto.type_name) && Internal.equals(this.extendee, fieldDescriptorProto.extendee) && Internal.equals(this.default_value, fieldDescriptorProto.default_value) && Internal.equals(this.oneof_index, fieldDescriptorProto.oneof_index) && Internal.equals(this.options, fieldDescriptorProto.options);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.number;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Label label = this.label;
        int hashCode4 = (hashCode3 + (label != null ? label.hashCode() : 0)) * 37;
        Type type = this.type;
        int hashCode5 = (hashCode4 + (type != null ? type.hashCode() : 0)) * 37;
        String str2 = this.type_name;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.extendee;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.default_value;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.oneof_index;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        FieldOptions fieldOptions = this.options;
        int hashCode10 = hashCode9 + (fieldOptions != null ? fieldOptions.hashCode() : 0);
        this.hashCode = hashCode10;
        return hashCode10;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.number != null) {
            sb.append(", number=");
            sb.append(this.number);
        }
        if (this.label != null) {
            sb.append(", label=");
            sb.append(this.label);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.type_name != null) {
            sb.append(", type_name=");
            sb.append(this.type_name);
        }
        if (this.extendee != null) {
            sb.append(", extendee=");
            sb.append(this.extendee);
        }
        if (this.default_value != null) {
            sb.append(", default_value=");
            sb.append(this.default_value);
        }
        if (this.oneof_index != null) {
            sb.append(", oneof_index=");
            sb.append(this.oneof_index);
        }
        if (this.options != null) {
            sb.append(", options=");
            sb.append(this.options);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "FieldDescriptorProto{", '}');
    }

    public FieldDescriptorProto(String str, Integer num, Label label, Type type, String str2, String str3, String str4, Integer num2, FieldOptions fieldOptions, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.number = num;
        this.label = label;
        this.type = type;
        this.type_name = str2;
        this.extendee = str3;
        this.default_value = str4;
        this.oneof_index = num2;
        this.options = fieldOptions;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.number = this.number;
        builder.label = this.label;
        builder.type = this.type;
        builder.type_name = this.type_name;
        builder.extendee = this.extendee;
        builder.default_value = this.default_value;
        builder.oneof_index = this.oneof_index;
        builder.options = this.options;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
