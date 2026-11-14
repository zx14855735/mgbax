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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class FieldOptions extends Message<FieldOptions, Builder> {
    public static final ProtoAdapter<FieldOptions> ADAPTER = new ProtoAdapter_FieldOptions();
    public static final CType DEFAULT_CTYPE = CType.STRING;
    public static final Boolean DEFAULT_DEPRECATED;
    public static final JSType DEFAULT_JSTYPE;
    public static final Boolean DEFAULT_LAZY;
    public static final Boolean DEFAULT_PACKED;
    public static final Boolean DEFAULT_WEAK;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.FieldOptions$CType#ADAPTER", tag = 1)
    public final CType ctype;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean deprecated;

    @WireField(adapter = "com.google.protobuf.FieldOptions$JSType#ADAPTER", tag = 6)
    public final JSType jstype;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean lazy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean packed;

    @WireField(adapter = "com.google.protobuf.UninterpretedOption#ADAPTER", label = WireField.Label.REPEATED, tag = 999)
    public final List<UninterpretedOption> uninterpreted_option;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean weak;

    public static final class Builder extends Message.Builder<FieldOptions, Builder> {
        public CType ctype;
        public Boolean deprecated;
        public JSType jstype;
        public Boolean lazy;
        public Boolean packed;
        public List<UninterpretedOption> uninterpreted_option = Internal.newMutableList();
        public Boolean weak;

        public Builder ctype(CType cType) {
            this.ctype = cType;
            return this;
        }

        public Builder deprecated(Boolean bool) {
            this.deprecated = bool;
            return this;
        }

        public Builder jstype(JSType jSType) {
            this.jstype = jSType;
            return this;
        }

        public Builder lazy(Boolean bool) {
            this.lazy = bool;
            return this;
        }

        public Builder packed(Boolean bool) {
            this.packed = bool;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> list) {
            Internal.checkElementsNotNull(list);
            this.uninterpreted_option = list;
            return this;
        }

        public Builder weak(Boolean bool) {
            this.weak = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public FieldOptions build() {
            return new FieldOptions(this.ctype, this.packed, this.jstype, this.lazy, this.deprecated, this.weak, this.uninterpreted_option, buildUnknownFields());
        }
    }

    public enum CType implements WireEnum {
        STRING(0),
        CORD(1),
        STRING_PIECE(2);

        public static final ProtoAdapter<CType> ADAPTER = new ProtoAdapter_CType();
        private final int value;

        public static final class ProtoAdapter_CType extends EnumAdapter<CType> {
            public ProtoAdapter_CType() {
                super(CType.class);
            }

            @Override // com.czhj.wire.EnumAdapter
            public CType fromValue(int i) {
                return CType.fromValue(i);
            }
        }

        static {
            zbMPfx();
        }

        CType(int i) {
            this.value = i;
        }

        public static CType fromValue(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return CORD;
            }
            if (i != 2) {
                return null;
            }
            return STRING_PIECE;
        }

        private static /* synthetic */ void zbMPfx() {
            char[] charArray = "ñýÿ¼õóÿ÷¼ðýë¼áú÷þþ¼ØüûÐàûöõ÷".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 146);
            }
            String str = new String(charArray);
            char[] charArray2 = "ñþûüûæ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 146);
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

    public enum JSType implements WireEnum {
        JS_NORMAL(0),
        JS_STRING(1),
        JS_NUMBER(2);

        public static final ProtoAdapter<JSType> ADAPTER = new ProtoAdapter_JSType();
        private final int value;

        public static final class ProtoAdapter_JSType extends EnumAdapter<JSType> {
            public ProtoAdapter_JSType() {
                super(JSType.class);
            }

            @Override // com.czhj.wire.EnumAdapter
            public JSType fromValue(int i) {
                return JSType.fromValue(i);
            }
        }

        static {
            ZGjD();
        }

        JSType(int i) {
            this.value = i;
        }

        private static /* synthetic */ void ZGjD() {
            char[] charArray = "\u0096\u009a\u0098Û\u0092\u0094\u0098\u0090Û\u0097\u009a\u008cÛ\u0086\u009d\u0090\u0099\u0099Û¿\u009b\u009c·\u0087\u009c\u0091\u0092\u0090".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 245);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0096\u0099\u009c\u009b\u009c\u0081".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 245);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static JSType fromValue(int i) {
            if (i == 0) {
                return JS_NORMAL;
            }
            if (i == 1) {
                return JS_STRING;
            }
            if (i != 2) {
                return null;
            }
            return JS_NUMBER;
        }

        @Override // com.czhj.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class ProtoAdapter_FieldOptions extends ProtoAdapter<FieldOptions> {
        public ProtoAdapter_FieldOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, FieldOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public FieldOptions decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.ctype(CType.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.packed(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.deprecated(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 5) {
                    builder.lazy(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 6) {
                    try {
                        builder.jstype(JSType.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                    }
                } else if (nextTag == 10) {
                    builder.weak(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 999) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FieldOptions fieldOptions) {
            CType.ADAPTER.encodeWithTag(protoWriter, 1, fieldOptions.ctype);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 2, fieldOptions.packed);
            JSType.ADAPTER.encodeWithTag(protoWriter, 6, fieldOptions.jstype);
            protoAdapter.encodeWithTag(protoWriter, 5, fieldOptions.lazy);
            protoAdapter.encodeWithTag(protoWriter, 3, fieldOptions.deprecated);
            protoAdapter.encodeWithTag(protoWriter, 10, fieldOptions.weak);
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(protoWriter, 999, fieldOptions.uninterpreted_option);
            protoWriter.writeBytes(fieldOptions.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FieldOptions fieldOptions) {
            int encodedSizeWithTag = CType.ADAPTER.encodedSizeWithTag(1, fieldOptions.ctype);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            return fieldOptions.unknownFields().size() + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, fieldOptions.uninterpreted_option) + protoAdapter.encodedSizeWithTag(10, fieldOptions.weak) + protoAdapter.encodedSizeWithTag(3, fieldOptions.deprecated) + protoAdapter.encodedSizeWithTag(5, fieldOptions.lazy) + JSType.ADAPTER.encodedSizeWithTag(6, fieldOptions.jstype) + protoAdapter.encodedSizeWithTag(2, fieldOptions.packed) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FieldOptions redact(FieldOptions fieldOptions) {
            Builder newBuilder = fieldOptions.newBuilder();
            Internal.redactElements(newBuilder.uninterpreted_option, UninterpretedOption.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_PACKED = bool;
        DEFAULT_JSTYPE = JSType.JS_NORMAL;
        DEFAULT_LAZY = bool;
        DEFAULT_DEPRECATED = bool;
        DEFAULT_WEAK = bool;
        MQdHU();
    }

    public FieldOptions(CType cType, Boolean bool, JSType jSType, Boolean bool2, Boolean bool3, Boolean bool4, List<UninterpretedOption> list) {
        this(cType, bool, jSType, bool2, bool3, bool4, list, ByteString.EMPTY);
    }

    private static /* synthetic */ void MQdHU() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldOptions)) {
            return false;
        }
        FieldOptions fieldOptions = (FieldOptions) obj;
        return unknownFields().equals(fieldOptions.unknownFields()) && Internal.equals(this.ctype, fieldOptions.ctype) && Internal.equals(this.packed, fieldOptions.packed) && Internal.equals(this.jstype, fieldOptions.jstype) && Internal.equals(this.lazy, fieldOptions.lazy) && Internal.equals(this.deprecated, fieldOptions.deprecated) && Internal.equals(this.weak, fieldOptions.weak) && this.uninterpreted_option.equals(fieldOptions.uninterpreted_option);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        CType cType = this.ctype;
        int hashCode2 = (hashCode + (cType != null ? cType.hashCode() : 0)) * 37;
        Boolean bool = this.packed;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        JSType jSType = this.jstype;
        int hashCode4 = (hashCode3 + (jSType != null ? jSType.hashCode() : 0)) * 37;
        Boolean bool2 = this.lazy;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.deprecated;
        int hashCode6 = (hashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.weak;
        int hashCode7 = this.uninterpreted_option.hashCode() + ((hashCode6 + (bool4 != null ? bool4.hashCode() : 0)) * 37);
        this.hashCode = hashCode7;
        return hashCode7;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.ctype != null) {
            sb.append(", ctype=");
            sb.append(this.ctype);
        }
        if (this.packed != null) {
            sb.append(", packed=");
            sb.append(this.packed);
        }
        if (this.jstype != null) {
            sb.append(", jstype=");
            sb.append(this.jstype);
        }
        if (this.lazy != null) {
            sb.append(", lazy=");
            sb.append(this.lazy);
        }
        if (this.deprecated != null) {
            sb.append(", deprecated=");
            sb.append(this.deprecated);
        }
        if (this.weak != null) {
            sb.append(", weak=");
            sb.append(this.weak);
        }
        if (!this.uninterpreted_option.isEmpty()) {
            sb.append(", uninterpreted_option=");
            sb.append(this.uninterpreted_option);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "FieldOptions{", '}');
    }

    public FieldOptions(CType cType, Boolean bool, JSType jSType, Boolean bool2, Boolean bool3, Boolean bool4, List<UninterpretedOption> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ctype = cType;
        this.packed = bool;
        this.jstype = jSType;
        this.lazy = bool2;
        this.deprecated = bool3;
        this.weak = bool4;
        this.uninterpreted_option = Internal.immutableCopyOf("uninterpreted_option", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.ctype = this.ctype;
        builder.packed = this.packed;
        builder.jstype = this.jstype;
        builder.lazy = this.lazy;
        builder.deprecated = this.deprecated;
        builder.weak = this.weak;
        builder.uninterpreted_option = Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
