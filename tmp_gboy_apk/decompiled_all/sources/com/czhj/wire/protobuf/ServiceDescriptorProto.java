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
public final class ServiceDescriptorProto extends Message<ServiceDescriptorProto, Builder> {
    public static final ProtoAdapter<ServiceDescriptorProto> ADAPTER = new ProtoAdapter_ServiceDescriptorProto();
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.MethodDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<MethodDescriptorProto> method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.ServiceOptions#ADAPTER", tag = 3)
    public final ServiceOptions options;

    public static final class Builder extends Message.Builder<ServiceDescriptorProto, Builder> {
        public List<MethodDescriptorProto> method = Internal.newMutableList();
        public String name;
        public ServiceOptions options;

        public Builder method(List<MethodDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.method = list;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(ServiceOptions serviceOptions) {
            this.options = serviceOptions;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ServiceDescriptorProto build() {
            return new ServiceDescriptorProto(this.name, this.method, this.options, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ServiceDescriptorProto extends ProtoAdapter<ServiceDescriptorProto> {
        public ProtoAdapter_ServiceDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, ServiceDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public ServiceDescriptorProto decode(ProtoReader protoReader) {
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
                    builder.method.add(MethodDescriptorProto.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.options(ServiceOptions.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ServiceDescriptorProto serviceDescriptorProto) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, serviceDescriptorProto.name);
            MethodDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, serviceDescriptorProto.method);
            ServiceOptions.ADAPTER.encodeWithTag(protoWriter, 3, serviceDescriptorProto.options);
            protoWriter.writeBytes(serviceDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ServiceDescriptorProto serviceDescriptorProto) {
            return serviceDescriptorProto.unknownFields().size() + ServiceOptions.ADAPTER.encodedSizeWithTag(3, serviceDescriptorProto.options) + MethodDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, serviceDescriptorProto.method) + ProtoAdapter.STRING.encodedSizeWithTag(1, serviceDescriptorProto.name);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ServiceDescriptorProto redact(ServiceDescriptorProto serviceDescriptorProto) {
            Builder newBuilder = serviceDescriptorProto.newBuilder();
            Internal.redactElements(newBuilder.method, MethodDescriptorProto.ADAPTER);
            ServiceOptions serviceOptions = newBuilder.options;
            if (serviceOptions != null) {
                newBuilder.options = ServiceOptions.ADAPTER.redact(serviceOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        quhjSm();
    }

    public ServiceDescriptorProto(String str, List<MethodDescriptorProto> list, ServiceOptions serviceOptions) {
        this(str, list, serviceOptions, ByteString.EMPTY);
    }

    private static /* synthetic */ void quhjSm() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceDescriptorProto)) {
            return false;
        }
        ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj;
        return unknownFields().equals(serviceDescriptorProto.unknownFields()) && Internal.equals(this.name, serviceDescriptorProto.name) && this.method.equals(serviceDescriptorProto.method) && Internal.equals(this.options, serviceDescriptorProto.options);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int A5SV6n2 = A2egSU.A5SV6n(this.method, (hashCode + (str != null ? str.hashCode() : 0)) * 37, 37);
        ServiceOptions serviceOptions = this.options;
        int hashCode2 = A5SV6n2 + (serviceOptions != null ? serviceOptions.hashCode() : 0);
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
        if (!this.method.isEmpty()) {
            sb.append(", method=");
            sb.append(this.method);
        }
        if (this.options != null) {
            sb.append(", options=");
            sb.append(this.options);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "ServiceDescriptorProto{", '}');
    }

    public ServiceDescriptorProto(String str, List<MethodDescriptorProto> list, ServiceOptions serviceOptions, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.method = Internal.immutableCopyOf("method", list);
        this.options = serviceOptions;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.method = Internal.copyOf("method", this.method);
        builder.options = this.options;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
