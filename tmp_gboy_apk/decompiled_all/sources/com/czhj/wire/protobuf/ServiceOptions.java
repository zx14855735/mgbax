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
public final class ServiceOptions extends Message<ServiceOptions, Builder> {
    public static final ProtoAdapter<ServiceOptions> ADAPTER = new ProtoAdapter_ServiceOptions();
    public static final Boolean DEFAULT_DEPRECATED = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 33)
    public final Boolean deprecated;

    @WireField(adapter = "com.google.protobuf.UninterpretedOption#ADAPTER", label = WireField.Label.REPEATED, tag = 999)
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends Message.Builder<ServiceOptions, Builder> {
        public Boolean deprecated;
        public List<UninterpretedOption> uninterpreted_option = Internal.newMutableList();

        public Builder deprecated(Boolean bool) {
            this.deprecated = bool;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> list) {
            Internal.checkElementsNotNull(list);
            this.uninterpreted_option = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ServiceOptions build() {
            return new ServiceOptions(this.deprecated, this.uninterpreted_option, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ServiceOptions extends ProtoAdapter<ServiceOptions> {
        public ProtoAdapter_ServiceOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, ServiceOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public ServiceOptions decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 33) {
                    builder.deprecated(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 999) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ServiceOptions serviceOptions) {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 33, serviceOptions.deprecated);
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(protoWriter, 999, serviceOptions.uninterpreted_option);
            protoWriter.writeBytes(serviceOptions.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ServiceOptions serviceOptions) {
            return serviceOptions.unknownFields().size() + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, serviceOptions.uninterpreted_option) + ProtoAdapter.BOOL.encodedSizeWithTag(33, serviceOptions.deprecated);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ServiceOptions redact(ServiceOptions serviceOptions) {
            Builder newBuilder = serviceOptions.newBuilder();
            Internal.redactElements(newBuilder.uninterpreted_option, UninterpretedOption.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        RmXjISF();
    }

    public ServiceOptions(Boolean bool, List<UninterpretedOption> list) {
        this(bool, list, ByteString.EMPTY);
    }

    private static /* synthetic */ void RmXjISF() {
        char[] charArray = "P\\^\u001dTR^V\u001dQ\\J\u001d@[V__\u001dy]ZqAZWTV".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '3');
        }
        String str = new String(charArray);
        char[] charArray2 = "P_Z]ZG".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '3');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceOptions)) {
            return false;
        }
        ServiceOptions serviceOptions = (ServiceOptions) obj;
        return unknownFields().equals(serviceOptions.unknownFields()) && Internal.equals(this.deprecated, serviceOptions.deprecated) && this.uninterpreted_option.equals(serviceOptions.uninterpreted_option);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.deprecated;
        int hashCode2 = this.uninterpreted_option.hashCode() + ((hashCode + (bool != null ? bool.hashCode() : 0)) * 37);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.deprecated != null) {
            sb.append(", deprecated=");
            sb.append(this.deprecated);
        }
        if (!this.uninterpreted_option.isEmpty()) {
            sb.append(", uninterpreted_option=");
            sb.append(this.uninterpreted_option);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "ServiceOptions{", '}');
    }

    public ServiceOptions(Boolean bool, List<UninterpretedOption> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.deprecated = bool;
        this.uninterpreted_option = Internal.immutableCopyOf("uninterpreted_option", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.deprecated = this.deprecated;
        builder.uninterpreted_option = Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
