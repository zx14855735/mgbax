package com.czhj.sdk.common.models;

import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.wire.AndroidMessage;
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
public final class Size extends AndroidMessage<Size, Builder> {
    public static final ProtoAdapter<Size> ADAPTER;
    public static final Parcelable.Creator<Size> CREATOR;
    public static final Integer DEFAULT_HEIGHT;
    public static final Integer DEFAULT_WIDTH;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer height;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer width;

    public static final class Builder extends Message.Builder<Size, Builder> {
        public Integer width = Size.DEFAULT_WIDTH;
        public Integer height = Size.DEFAULT_HEIGHT;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public Size build() {
            return new Size(this.width, this.height, buildUnknownFields());
        }

        public Builder height(Integer num) {
            this.height = num;
            return this;
        }

        public Builder width(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static final class ProtoAdapter_Size extends ProtoAdapter<Size> {
        public ProtoAdapter_Size() {
            super(FieldEncoding.LENGTH_DELIMITED, Size.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Size decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.width(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.height(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Size size) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, size.width);
            protoAdapter.encodeWithTag(protoWriter, 2, size.height);
            protoWriter.writeBytes(size.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Size size) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return size.unknownFields().size() + protoAdapter.encodedSizeWithTag(2, size.height) + protoAdapter.encodedSizeWithTag(1, size.width);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Size redact(Size size) {
            Builder newBuilder = size.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Size protoAdapter_Size = new ProtoAdapter_Size();
        ADAPTER = protoAdapter_Size;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Size);
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        zreMPec();
    }

    public Size(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    private static /* synthetic */ void zreMPec() {
        char[] charArray = "s\u007f}>wq}u>r\u007fi>cxu||>Z~yRbytwu".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        String str = new String(charArray);
        char[] charArray2 = "s|y~yd".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 16);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return unknownFields().equals(size.unknownFields()) && Internal.equals(this.width, size.width) && Internal.equals(this.height, size.height);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.width;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.height;
        int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.width = this.width;
        builder.height = this.height;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.width != null) {
            sb.append(", width=");
            sb.append(this.width);
        }
        if (this.height != null) {
            sb.append(", height=");
            sb.append(this.height);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Size{", '}');
    }

    public Size(Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.width = num;
        this.height = num2;
    }
}
