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
public final class DescriptorProto extends Message<DescriptorProto, Builder> {
    public static final ProtoAdapter<DescriptorProto> ADAPTER = new ProtoAdapter_DescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.EnumDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<EnumDescriptorProto> enum_type;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<FieldDescriptorProto> extension;

    @WireField(adapter = "com.google.protobuf.DescriptorProto$ExtensionRange#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtensionRange> extension_range;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<FieldDescriptorProto> field;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.DescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<DescriptorProto> nested_type;

    @WireField(adapter = "com.google.protobuf.OneofDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    public final List<OneofDescriptorProto> oneof_decl;

    @WireField(adapter = "com.google.protobuf.MessageOptions#ADAPTER", tag = 7)
    public final MessageOptions options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 10)
    public final List<String> reserved_name;

    @WireField(adapter = "com.google.protobuf.DescriptorProto$ReservedRange#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    public final List<ReservedRange> reserved_range;

    public static final class Builder extends Message.Builder<DescriptorProto, Builder> {
        public String name;
        public MessageOptions options;
        public List<FieldDescriptorProto> field = Internal.newMutableList();
        public List<FieldDescriptorProto> extension = Internal.newMutableList();
        public List<DescriptorProto> nested_type = Internal.newMutableList();
        public List<EnumDescriptorProto> enum_type = Internal.newMutableList();
        public List<ExtensionRange> extension_range = Internal.newMutableList();
        public List<OneofDescriptorProto> oneof_decl = Internal.newMutableList();
        public List<ReservedRange> reserved_range = Internal.newMutableList();
        public List<String> reserved_name = Internal.newMutableList();

        public Builder enum_type(List<EnumDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.enum_type = list;
            return this;
        }

        public Builder extension(List<FieldDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.extension = list;
            return this;
        }

        public Builder extension_range(List<ExtensionRange> list) {
            Internal.checkElementsNotNull(list);
            this.extension_range = list;
            return this;
        }

        public Builder field(List<FieldDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.field = list;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder nested_type(List<DescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.nested_type = list;
            return this;
        }

        public Builder oneof_decl(List<OneofDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.oneof_decl = list;
            return this;
        }

        public Builder options(MessageOptions messageOptions) {
            this.options = messageOptions;
            return this;
        }

        public Builder reserved_name(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.reserved_name = list;
            return this;
        }

        public Builder reserved_range(List<ReservedRange> list) {
            Internal.checkElementsNotNull(list);
            this.reserved_range = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public DescriptorProto build() {
            return new DescriptorProto(this.name, this.field, this.extension, this.nested_type, this.enum_type, this.extension_range, this.oneof_decl, this.options, this.reserved_range, this.reserved_name, buildUnknownFields());
        }
    }

    public static final class ExtensionRange extends Message<ExtensionRange, Builder> {
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
        public final Integer end;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
        public final Integer start;
        public static final ProtoAdapter<ExtensionRange> ADAPTER = new ProtoAdapter_ExtensionRange();
        public static final Integer DEFAULT_START = 0;
        public static final Integer DEFAULT_END = 0;

        public static final class Builder extends Message.Builder<ExtensionRange, Builder> {
            public Integer end;
            public Integer start;

            public Builder end(Integer num) {
                this.end = num;
                return this;
            }

            public Builder start(Integer num) {
                this.start = num;
                return this;
            }

            @Override // com.czhj.wire.Message.Builder
            public ExtensionRange build() {
                return new ExtensionRange(this.start, this.end, buildUnknownFields());
            }
        }

        public static final class ProtoAdapter_ExtensionRange extends ProtoAdapter<ExtensionRange> {
            public ProtoAdapter_ExtensionRange() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtensionRange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public ExtensionRange decode(ProtoReader protoReader) {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.build();
                    }
                    if (nextTag == 1) {
                        builder.start(ProtoAdapter.INT32.decode(protoReader));
                    } else if (nextTag != 2) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.end(ProtoAdapter.INT32.decode(protoReader));
                    }
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ExtensionRange extensionRange) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                protoAdapter.encodeWithTag(protoWriter, 1, extensionRange.start);
                protoAdapter.encodeWithTag(protoWriter, 2, extensionRange.end);
                protoWriter.writeBytes(extensionRange.unknownFields());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(ExtensionRange extensionRange) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                return extensionRange.unknownFields().size() + protoAdapter.encodedSizeWithTag(2, extensionRange.end) + protoAdapter.encodedSizeWithTag(1, extensionRange.start);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ExtensionRange redact(ExtensionRange extensionRange) {
                Builder newBuilder = extensionRange.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        static {
            cgMXq();
        }

        public ExtensionRange(Integer num, Integer num2) {
            this(num, num2, ByteString.EMPTY);
        }

        private static /* synthetic */ void cgMXq() {
            char[] charArray = "FJH\u000bBDH@\u000bGJ\\\u000bVM@II\u000boKLgWLAB@".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '%');
            }
            String str = new String(charArray);
            char[] charArray2 = "FILKLQ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '%');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtensionRange)) {
                return false;
            }
            ExtensionRange extensionRange = (ExtensionRange) obj;
            return unknownFields().equals(extensionRange.unknownFields()) && Internal.equals(this.start, extensionRange.start) && Internal.equals(this.end, extensionRange.end);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.start;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.end;
            int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.czhj.wire.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.start != null) {
                sb.append(", start=");
                sb.append(this.start);
            }
            if (this.end != null) {
                sb.append(", end=");
                sb.append(this.end);
            }
            return A2egSU.AmA8tU(sb, 0, 2, "ExtensionRange{", '}');
        }

        public ExtensionRange(Integer num, Integer num2, ByteString byteString) {
            super(ADAPTER, byteString);
            this.start = num;
            this.end = num2;
        }

        @Override // com.czhj.wire.Message
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.start = this.start;
            builder.end = this.end;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    public static final class ProtoAdapter_DescriptorProto extends ProtoAdapter<DescriptorProto> {
        public ProtoAdapter_DescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, DescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public DescriptorProto decode(ProtoReader protoReader) {
            List list;
            Object obj;
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
                        list = builder.field;
                        obj = (FieldDescriptorProto) FieldDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 3:
                        list = builder.nested_type;
                        obj = (DescriptorProto) DescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 4:
                        list = builder.enum_type;
                        obj = (EnumDescriptorProto) EnumDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 5:
                        list = builder.extension_range;
                        obj = (ExtensionRange) ExtensionRange.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 6:
                        list = builder.extension;
                        obj = (FieldDescriptorProto) FieldDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 7:
                        builder.options(MessageOptions.ADAPTER.decode(protoReader));
                        break;
                    case 8:
                        list = builder.oneof_decl;
                        obj = (OneofDescriptorProto) OneofDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 9:
                        list = builder.reserved_range;
                        obj = (ReservedRange) ReservedRange.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 10:
                        list = builder.reserved_name;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                        list.add(obj);
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, DescriptorProto descriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, descriptorProto.name);
            ProtoAdapter<FieldDescriptorProto> protoAdapter2 = FieldDescriptorProto.ADAPTER;
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 2, descriptorProto.field);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 6, descriptorProto.extension);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, descriptorProto.nested_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, descriptorProto.enum_type);
            ExtensionRange.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, descriptorProto.extension_range);
            OneofDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, descriptorProto.oneof_decl);
            MessageOptions.ADAPTER.encodeWithTag(protoWriter, 7, descriptorProto.options);
            ReservedRange.ADAPTER.asRepeated().encodeWithTag(protoWriter, 9, descriptorProto.reserved_range);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 10, descriptorProto.reserved_name);
            protoWriter.writeBytes(descriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(DescriptorProto descriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, descriptorProto.name);
            ProtoAdapter<FieldDescriptorProto> protoAdapter2 = FieldDescriptorProto.ADAPTER;
            return descriptorProto.unknownFields().size() + protoAdapter.asRepeated().encodedSizeWithTag(10, descriptorProto.reserved_name) + ReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(9, descriptorProto.reserved_range) + MessageOptions.ADAPTER.encodedSizeWithTag(7, descriptorProto.options) + OneofDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(8, descriptorProto.oneof_decl) + ExtensionRange.ADAPTER.asRepeated().encodedSizeWithTag(5, descriptorProto.extension_range) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, descriptorProto.enum_type) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(3, descriptorProto.nested_type) + protoAdapter2.asRepeated().encodedSizeWithTag(6, descriptorProto.extension) + protoAdapter2.asRepeated().encodedSizeWithTag(2, descriptorProto.field) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public DescriptorProto redact(DescriptorProto descriptorProto) {
            Builder newBuilder = descriptorProto.newBuilder();
            List<FieldDescriptorProto> list = newBuilder.field;
            ProtoAdapter<FieldDescriptorProto> protoAdapter = FieldDescriptorProto.ADAPTER;
            Internal.redactElements(list, protoAdapter);
            Internal.redactElements(newBuilder.extension, protoAdapter);
            Internal.redactElements(newBuilder.nested_type, DescriptorProto.ADAPTER);
            Internal.redactElements(newBuilder.enum_type, EnumDescriptorProto.ADAPTER);
            Internal.redactElements(newBuilder.extension_range, ExtensionRange.ADAPTER);
            Internal.redactElements(newBuilder.oneof_decl, OneofDescriptorProto.ADAPTER);
            MessageOptions messageOptions = newBuilder.options;
            if (messageOptions != null) {
                newBuilder.options = MessageOptions.ADAPTER.redact(messageOptions);
            }
            Internal.redactElements(newBuilder.reserved_range, ReservedRange.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public static final class ReservedRange extends Message<ReservedRange, Builder> {
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
        public final Integer end;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
        public final Integer start;
        public static final ProtoAdapter<ReservedRange> ADAPTER = new ProtoAdapter_ReservedRange();
        public static final Integer DEFAULT_START = 0;
        public static final Integer DEFAULT_END = 0;

        public static final class Builder extends Message.Builder<ReservedRange, Builder> {
            public Integer end;
            public Integer start;

            public Builder end(Integer num) {
                this.end = num;
                return this;
            }

            public Builder start(Integer num) {
                this.start = num;
                return this;
            }

            @Override // com.czhj.wire.Message.Builder
            public ReservedRange build() {
                return new ReservedRange(this.start, this.end, buildUnknownFields());
            }
        }

        public static final class ProtoAdapter_ReservedRange extends ProtoAdapter<ReservedRange> {
            public ProtoAdapter_ReservedRange() {
                super(FieldEncoding.LENGTH_DELIMITED, ReservedRange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.czhj.wire.ProtoAdapter
            public ReservedRange decode(ProtoReader protoReader) {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.build();
                    }
                    if (nextTag == 1) {
                        builder.start(ProtoAdapter.INT32.decode(protoReader));
                    } else if (nextTag != 2) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.end(ProtoAdapter.INT32.decode(protoReader));
                    }
                }
            }

            @Override // com.czhj.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ReservedRange reservedRange) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                protoAdapter.encodeWithTag(protoWriter, 1, reservedRange.start);
                protoAdapter.encodeWithTag(protoWriter, 2, reservedRange.end);
                protoWriter.writeBytes(reservedRange.unknownFields());
            }

            @Override // com.czhj.wire.ProtoAdapter
            public int encodedSize(ReservedRange reservedRange) {
                ProtoAdapter<Integer> protoAdapter = ProtoAdapter.INT32;
                return reservedRange.unknownFields().size() + protoAdapter.encodedSizeWithTag(2, reservedRange.end) + protoAdapter.encodedSizeWithTag(1, reservedRange.start);
            }

            @Override // com.czhj.wire.ProtoAdapter
            public ReservedRange redact(ReservedRange reservedRange) {
                Builder newBuilder = reservedRange.newBuilder();
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        static {
            Pepn();
        }

        public ReservedRange(Integer num, Integer num2) {
            this(num, num2, ByteString.EMPTY);
        }

        private static /* synthetic */ void Pepn() {
            char[] charArray = "\u0082\u008e\u008cÏ\u0086\u0080\u008c\u0084Ï\u0083\u008e\u0098Ï\u0092\u0089\u0084\u008d\u008dÏ«\u008f\u0088£\u0093\u0088\u0085\u0086\u0084".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 225);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0082\u008d\u0088\u008f\u0088\u0095".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 225);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReservedRange)) {
                return false;
            }
            ReservedRange reservedRange = (ReservedRange) obj;
            return unknownFields().equals(reservedRange.unknownFields()) && Internal.equals(this.start, reservedRange.start) && Internal.equals(this.end, reservedRange.end);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.start;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.end;
            int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.czhj.wire.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.start != null) {
                sb.append(", start=");
                sb.append(this.start);
            }
            if (this.end != null) {
                sb.append(", end=");
                sb.append(this.end);
            }
            return A2egSU.AmA8tU(sb, 0, 2, "ReservedRange{", '}');
        }

        public ReservedRange(Integer num, Integer num2, ByteString byteString) {
            super(ADAPTER, byteString);
            this.start = num;
            this.end = num2;
        }

        @Override // com.czhj.wire.Message
        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.start = this.start;
            builder.end = this.end;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    static {
        xeKksL();
    }

    public DescriptorProto(String str, List<FieldDescriptorProto> list, List<FieldDescriptorProto> list2, List<DescriptorProto> list3, List<EnumDescriptorProto> list4, List<ExtensionRange> list5, List<OneofDescriptorProto> list6, MessageOptions messageOptions, List<ReservedRange> list7, List<String> list8) {
        this(str, list, list2, list3, list4, list5, list6, messageOptions, list7, list8, ByteString.EMPTY);
    }

    private static /* synthetic */ void xeKksL() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DescriptorProto)) {
            return false;
        }
        DescriptorProto descriptorProto = (DescriptorProto) obj;
        return unknownFields().equals(descriptorProto.unknownFields()) && Internal.equals(this.name, descriptorProto.name) && this.field.equals(descriptorProto.field) && this.extension.equals(descriptorProto.extension) && this.nested_type.equals(descriptorProto.nested_type) && this.enum_type.equals(descriptorProto.enum_type) && this.extension_range.equals(descriptorProto.extension_range) && this.oneof_decl.equals(descriptorProto.oneof_decl) && Internal.equals(this.options, descriptorProto.options) && this.reserved_range.equals(descriptorProto.reserved_range) && this.reserved_name.equals(descriptorProto.reserved_name);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int A5SV6n2 = A2egSU.A5SV6n(this.oneof_decl, A2egSU.A5SV6n(this.extension_range, A2egSU.A5SV6n(this.enum_type, A2egSU.A5SV6n(this.nested_type, A2egSU.A5SV6n(this.extension, A2egSU.A5SV6n(this.field, (hashCode + (str != null ? str.hashCode() : 0)) * 37, 37), 37), 37), 37), 37), 37);
        MessageOptions messageOptions = this.options;
        int hashCode2 = this.reserved_name.hashCode() + A2egSU.A5SV6n(this.reserved_range, (A5SV6n2 + (messageOptions != null ? messageOptions.hashCode() : 0)) * 37, 37);
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
        if (!this.field.isEmpty()) {
            sb.append(", field=");
            sb.append(this.field);
        }
        if (!this.extension.isEmpty()) {
            sb.append(", extension=");
            sb.append(this.extension);
        }
        if (!this.nested_type.isEmpty()) {
            sb.append(", nested_type=");
            sb.append(this.nested_type);
        }
        if (!this.enum_type.isEmpty()) {
            sb.append(", enum_type=");
            sb.append(this.enum_type);
        }
        if (!this.extension_range.isEmpty()) {
            sb.append(", extension_range=");
            sb.append(this.extension_range);
        }
        if (!this.oneof_decl.isEmpty()) {
            sb.append(", oneof_decl=");
            sb.append(this.oneof_decl);
        }
        if (this.options != null) {
            sb.append(", options=");
            sb.append(this.options);
        }
        if (!this.reserved_range.isEmpty()) {
            sb.append(", reserved_range=");
            sb.append(this.reserved_range);
        }
        if (!this.reserved_name.isEmpty()) {
            sb.append(", reserved_name=");
            sb.append(this.reserved_name);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "DescriptorProto{", '}');
    }

    public DescriptorProto(String str, List<FieldDescriptorProto> list, List<FieldDescriptorProto> list2, List<DescriptorProto> list3, List<EnumDescriptorProto> list4, List<ExtensionRange> list5, List<OneofDescriptorProto> list6, MessageOptions messageOptions, List<ReservedRange> list7, List<String> list8, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.field = Internal.immutableCopyOf("field", list);
        this.extension = Internal.immutableCopyOf("extension", list2);
        this.nested_type = Internal.immutableCopyOf("nested_type", list3);
        this.enum_type = Internal.immutableCopyOf("enum_type", list4);
        this.extension_range = Internal.immutableCopyOf("extension_range", list5);
        this.oneof_decl = Internal.immutableCopyOf("oneof_decl", list6);
        this.options = messageOptions;
        this.reserved_range = Internal.immutableCopyOf("reserved_range", list7);
        this.reserved_name = Internal.immutableCopyOf("reserved_name", list8);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.field = Internal.copyOf("field", this.field);
        builder.extension = Internal.copyOf("extension", this.extension);
        builder.nested_type = Internal.copyOf("nested_type", this.nested_type);
        builder.enum_type = Internal.copyOf("enum_type", this.enum_type);
        builder.extension_range = Internal.copyOf("extension_range", this.extension_range);
        builder.oneof_decl = Internal.copyOf("oneof_decl", this.oneof_decl);
        builder.options = this.options;
        builder.reserved_range = Internal.copyOf("reserved_range", this.reserved_range);
        builder.reserved_name = Internal.copyOf("reserved_name", this.reserved_name);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
