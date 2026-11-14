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
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class FileDescriptorSet extends Message<FileDescriptorSet, Builder> {
    public static final ProtoAdapter<FileDescriptorSet> ADAPTER = new ProtoAdapter_FileDescriptorSet();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.FileDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<FileDescriptorProto> file;

    public static final class Builder extends Message.Builder<FileDescriptorSet, Builder> {
        public List<FileDescriptorProto> file = Internal.newMutableList();

        public Builder file(List<FileDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.file = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public FileDescriptorSet build() {
            return new FileDescriptorSet(this.file, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_FileDescriptorSet extends ProtoAdapter<FileDescriptorSet> {
        public ProtoAdapter_FileDescriptorSet() {
            super(FieldEncoding.LENGTH_DELIMITED, FileDescriptorSet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorSet decode(ProtoReader protoReader) {
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
                    builder.file.add(FileDescriptorProto.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FileDescriptorSet fileDescriptorSet) {
            FileDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, fileDescriptorSet.file);
            protoWriter.writeBytes(fileDescriptorSet.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FileDescriptorSet fileDescriptorSet) {
            return fileDescriptorSet.unknownFields().size() + FileDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(1, fileDescriptorSet.file);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorSet redact(FileDescriptorSet fileDescriptorSet) {
            Builder newBuilder = fileDescriptorSet.newBuilder();
            Internal.redactElements(newBuilder.file, FileDescriptorProto.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        THwGiWq();
    }

    public FileDescriptorSet(List<FileDescriptorProto> list) {
        this(list, ByteString.EMPTY);
    }

    private static /* synthetic */ void THwGiWq() {
        char[] charArray = "\\PR\u0011X^RZ\u0011]PF\u0011LWZSS\u0011uQV}MV[XZ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '?');
        }
        String str = new String(charArray);
        char[] charArray2 = "\\SVQVK".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '?');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileDescriptorSet)) {
            return false;
        }
        FileDescriptorSet fileDescriptorSet = (FileDescriptorSet) obj;
        return unknownFields().equals(fileDescriptorSet.unknownFields()) && this.file.equals(fileDescriptorSet.file);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.file.hashCode() + (unknownFields().hashCode() * 37);
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.file.isEmpty()) {
            sb.append(", file=");
            sb.append(this.file);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "FileDescriptorSet{", '}');
    }

    public FileDescriptorSet(List<FileDescriptorProto> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.file = Internal.immutableCopyOf(n.z, list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.file = Internal.copyOf(n.z, this.file);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
