package com.czhj.wire.protobuf;

import B4ZgIw.AYUAbz;
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
public final class UninterpretedOption extends Message<UninterpretedOption, Builder> {
    public static final String DEFAULT_AGGREGATE_VALUE = "";
    public static final String DEFAULT_IDENTIFIER_VALUE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String aggregate_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 6)
    public final Double double_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String identifier_value;

    @WireField(adapter = "com.google.protobuf.UninterpretedOption$NamePart#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<NamePart> name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long negative_int_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 4)
    public final Long positive_int_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 7)
    public final ByteString string_value;
    public static final ProtoAdapter<UninterpretedOption> ADAPTER = new ProtoAdapter_UninterpretedOption();
    public static final Long DEFAULT_POSITIVE_INT_VALUE = 0L;
    public static final Long DEFAULT_NEGATIVE_INT_VALUE = 0L;
    public static final Double DEFAULT_DOUBLE_VALUE = Double.valueOf(0.0d);
    public static final ByteString DEFAULT_STRING_VALUE = ByteString.EMPTY;

    public static final class Builder extends Message.Builder<UninterpretedOption, Builder> {
        public String aggregate_value;
        public Double double_value;
        public String identifier_value;
        public List<NamePart> name = Internal.newMutableList();
        public Long negative_int_value;
        public Long positive_int_value;
        public ByteString string_value;

        public Builder aggregate_value(String str) {
            this.aggregate_value = str;
            return this;
        }

        public Builder double_value(Double d) {
            this.double_value = d;
            return this;
        }

        public Builder identifier_value(String str) {
            this.identifier_value = str;
            return this;
        }

        public Builder name(List<NamePart> list) {
            Internal.checkElementsNotNull(list);
            this.name = list;
            return this;
        }

        public Builder negative_int_value(Long l) {
            this.negative_int_value = l;
            return this;
        }

        public Builder positive_int_value(Long l) {
            this.positive_int_value = l;
            return this;
        }

        public Builder string_value(ByteString byteString) {
            this.string_value = byteString;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public UninterpretedOption build() {
            return new UninterpretedOption(this.name, this.identifier_value, this.positive_int_value, this.negative_int_value, this.double_value, this.string_value, this.aggregate_value, buildUnknownFields());
        }
    }

    public static final class NamePart extends Message<NamePart, Builder> {
        public static final ProtoAdapter<NamePart> ADAPTER = new ProtoAdapter_NamePart();
        public static final Boolean DEFAULT_IS_EXTENSION = Boolean.FALSE;
        public static final String DEFAULT_NAME_PART = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 2)
        public final Boolean is_extension;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String name_part;

        public static final class Builder extends Message.Builder<NamePart, Builder> {
            public Boolean is_extension;
            public String name_part;

            public Builder is_extension(Boolean bool) {
                this.is_extension = bool;
                return this;
            }

            public Builder name_part(String str) {
                this.name_part = str;
                return this;
            }

            @Override // com.czhj.wire.Message.Builder
            public NamePart build() {
                String str = this.name_part;
                if (str == null || this.is_extension == null) {
                    throw Internal.missingRequiredFields(str, "name_part", this.is_extension, "is_extension");
                }
                return new NamePart(this.name_part, this.is_extension, buildUnknownFields());
            }
        }

        public static final class ProtoAdapter_NamePart extends ProtoAdapter<NamePart> {
            public ProtoAdapter_NamePart() {
                super(FieldEncoding.LENGTH_DELIMITED, NamePart.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public NamePart decode(ProtoReader protoReader) {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.build();
                    }
                    if (nextTag == 1) {
                        builder.name_part(ProtoAdapter.STRING.decode(protoReader));
                    } else if (nextTag != 2) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.is_extension(ProtoAdapter.BOOL.decode(protoReader));
                    }
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, NamePart namePart) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, namePart.name_part);
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, namePart.is_extension);
                protoWriter.writeBytes(namePart.unknownFields());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(NamePart namePart) {
                return namePart.unknownFields().size() + ProtoAdapter.BOOL.encodedSizeWithTag(2, namePart.is_extension) + ProtoAdapter.STRING.encodedSizeWithTag(1, namePart.name_part);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public NamePart redact(NamePart namePart) {
                Builder newBuilder = namePart.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        static {
            whAIfa();
        }

        public NamePart(String str, Boolean bool) {
            this(str, bool, ByteString.EMPTY);
        }

        private static /* synthetic */ void whAIfa() {
            char[] charArray = " ¬®í¤¢®¦í¡¬ºí°«¦¯¯í\u0089\u00adª\u0081±ª§¤¦".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 195);
            }
            String str = new String(charArray);
            char[] charArray2 = " ¯ª\u00adª·".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 195);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof NamePart)) {
                return false;
            }
            NamePart namePart = (NamePart) obj;
            return unknownFields().equals(namePart.unknownFields()) && this.name_part.equals(namePart.name_part) && this.is_extension.equals(namePart.is_extension);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = this.is_extension.hashCode() + A2egSU.A2egSU(unknownFields().hashCode() * 37, 37, this.name_part);
            this.hashCode = hashCode;
            return hashCode;
        }

        @Override // com.czhj.wire.Message
        public String toString() {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(", name_part=");
            A4TApA2.append(this.name_part);
            A4TApA2.append(", is_extension=");
            A4TApA2.append(this.is_extension);
            return A2egSU.AmA8tU(A4TApA2, 0, 2, "NamePart{", '}');
        }

        public NamePart(String str, Boolean bool, ByteString byteString) {
            super(ADAPTER, byteString);
            this.name_part = str;
            this.is_extension = bool;
        }

        @Override // com.czhj.wire.Message
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.name_part = this.name_part;
            builder.is_extension = this.is_extension;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    public static final class ProtoAdapter_UninterpretedOption extends ProtoAdapter<UninterpretedOption> {
        public ProtoAdapter_UninterpretedOption() {
            super(FieldEncoding.LENGTH_DELIMITED, UninterpretedOption.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public UninterpretedOption decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 2:
                        builder.name.add(NamePart.ADAPTER.decode(protoReader));
                        break;
                    case 3:
                        builder.identifier_value(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 4:
                        builder.positive_int_value(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 5:
                        builder.negative_int_value(ProtoAdapter.INT64.decode(protoReader));
                        break;
                    case 6:
                        builder.double_value(ProtoAdapter.DOUBLE.decode(protoReader));
                        break;
                    case 7:
                        builder.string_value(ProtoAdapter.BYTES.decode(protoReader));
                        break;
                    case 8:
                        builder.aggregate_value(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, UninterpretedOption uninterpretedOption) {
            NamePart.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, uninterpretedOption.name);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 3, uninterpretedOption.identifier_value);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 4, uninterpretedOption.positive_int_value);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, uninterpretedOption.negative_int_value);
            ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 6, uninterpretedOption.double_value);
            ProtoAdapter.BYTES.encodeWithTag(protoWriter, 7, uninterpretedOption.string_value);
            protoAdapter.encodeWithTag(protoWriter, 8, uninterpretedOption.aggregate_value);
            protoWriter.writeBytes(uninterpretedOption.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(UninterpretedOption uninterpretedOption) {
            int encodedSizeWithTag = NamePart.ADAPTER.asRepeated().encodedSizeWithTag(2, uninterpretedOption.name);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return uninterpretedOption.unknownFields().size() + protoAdapter.encodedSizeWithTag(8, uninterpretedOption.aggregate_value) + ProtoAdapter.BYTES.encodedSizeWithTag(7, uninterpretedOption.string_value) + ProtoAdapter.DOUBLE.encodedSizeWithTag(6, uninterpretedOption.double_value) + ProtoAdapter.INT64.encodedSizeWithTag(5, uninterpretedOption.negative_int_value) + ProtoAdapter.UINT64.encodedSizeWithTag(4, uninterpretedOption.positive_int_value) + protoAdapter.encodedSizeWithTag(3, uninterpretedOption.identifier_value) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public UninterpretedOption redact(UninterpretedOption uninterpretedOption) {
            Builder newBuilder = uninterpretedOption.newBuilder();
            Internal.redactElements(newBuilder.name, NamePart.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        nDPFK();
    }

    public UninterpretedOption(List<NamePart> list, String str, Long l, Long l2, Double d, ByteString byteString, String str2) {
        this(list, str, l, l2, d, byteString, str2, ByteString.EMPTY);
    }

    private static /* synthetic */ void nDPFK() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UninterpretedOption)) {
            return false;
        }
        UninterpretedOption uninterpretedOption = (UninterpretedOption) obj;
        return unknownFields().equals(uninterpretedOption.unknownFields()) && this.name.equals(uninterpretedOption.name) && Internal.equals(this.identifier_value, uninterpretedOption.identifier_value) && Internal.equals(this.positive_int_value, uninterpretedOption.positive_int_value) && Internal.equals(this.negative_int_value, uninterpretedOption.negative_int_value) && Internal.equals(this.double_value, uninterpretedOption.double_value) && Internal.equals(this.string_value, uninterpretedOption.string_value) && Internal.equals(this.aggregate_value, uninterpretedOption.aggregate_value);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int A5SV6n2 = A2egSU.A5SV6n(this.name, unknownFields().hashCode() * 37, 37);
        String str = this.identifier_value;
        int hashCode = (A5SV6n2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.positive_int_value;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.negative_int_value;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Double d = this.double_value;
        int hashCode4 = (hashCode3 + (d != null ? d.hashCode() : 0)) * 37;
        ByteString byteString = this.string_value;
        int hashCode5 = (hashCode4 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str2 = this.aggregate_value;
        int hashCode6 = hashCode5 + (str2 != null ? str2.hashCode() : 0);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.name.isEmpty()) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.identifier_value != null) {
            sb.append(", identifier_value=");
            sb.append(this.identifier_value);
        }
        if (this.positive_int_value != null) {
            sb.append(", positive_int_value=");
            sb.append(this.positive_int_value);
        }
        if (this.negative_int_value != null) {
            sb.append(", negative_int_value=");
            sb.append(this.negative_int_value);
        }
        if (this.double_value != null) {
            sb.append(", double_value=");
            sb.append(this.double_value);
        }
        if (this.string_value != null) {
            sb.append(", string_value=");
            sb.append(this.string_value);
        }
        if (this.aggregate_value != null) {
            sb.append(", aggregate_value=");
            sb.append(this.aggregate_value);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "UninterpretedOption{", '}');
    }

    public UninterpretedOption(List<NamePart> list, String str, Long l, Long l2, Double d, ByteString byteString, String str2, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.name = Internal.immutableCopyOf("name", list);
        this.identifier_value = str;
        this.positive_int_value = l;
        this.negative_int_value = l2;
        this.double_value = d;
        this.string_value = byteString;
        this.aggregate_value = str2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = Internal.copyOf("name", this.name);
        builder.identifier_value = this.identifier_value;
        builder.positive_int_value = this.positive_int_value;
        builder.negative_int_value = this.negative_int_value;
        builder.double_value = this.double_value;
        builder.string_value = this.string_value;
        builder.aggregate_value = this.aggregate_value;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
