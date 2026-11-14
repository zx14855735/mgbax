package com.sigmob.sdk.base.models.rtb;

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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ResponseAssetText extends AndroidMessage<ResponseAssetText, Builder> {
    public static final ProtoAdapter<ResponseAssetText> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetText> CREATOR;
    public static final String DEFAULT_CONTEXT = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String context;

    public static final class Builder extends Message.Builder<ResponseAssetText, Builder> {
        public String context = "";

        public Builder context(String str) {
            this.context = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ResponseAssetText build() {
            return new ResponseAssetText(this.context, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ResponseAssetText extends ProtoAdapter<ResponseAssetText> {
        public ProtoAdapter_ResponseAssetText() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetText.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public ResponseAssetText decode(ProtoReader protoReader) {
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
                    builder.context(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ResponseAssetText responseAssetText) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, responseAssetText.context);
            protoWriter.writeBytes(responseAssetText.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ResponseAssetText responseAssetText) {
            return responseAssetText.unknownFields().size() + ProtoAdapter.STRING.encodedSizeWithTag(1, responseAssetText.context);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ResponseAssetText redact(ResponseAssetText responseAssetText) {
            Builder newBuilder = responseAssetText.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetText protoAdapter_ResponseAssetText = new ProtoAdapter_ResponseAssetText();
        ADAPTER = protoAdapter_ResponseAssetText;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetText);
        JGXz();
    }

    public ResponseAssetText(String str) {
        this(str, ByteString.EMPTY);
    }

    private static /* synthetic */ void JGXz() {
        char[] charArray = "q}\u007f<us\u007fw<p}k<azw~~<X|{P`{vuw".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 18);
        }
        String str = new String(charArray);
        char[] charArray2 = "q~{|{f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 18);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAssetText)) {
            return false;
        }
        ResponseAssetText responseAssetText = (ResponseAssetText) obj;
        return unknownFields().equals(responseAssetText.unknownFields()) && Internal.equals(this.context, responseAssetText.context);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.context;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.context != null) {
            sb.append(", context=");
            sb.append(this.context);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "ResponseAssetText{", '}');
    }

    public ResponseAssetText(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.context = str;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.context = this.context;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
