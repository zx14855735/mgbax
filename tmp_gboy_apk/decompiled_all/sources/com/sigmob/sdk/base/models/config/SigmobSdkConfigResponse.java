package com.sigmob.sdk.base.models.config;

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
public final class SigmobSdkConfigResponse extends AndroidMessage<SigmobSdkConfigResponse, Builder> {
    public static final ProtoAdapter<SigmobSdkConfigResponse> ADAPTER;
    public static final Parcelable.Creator<SigmobSdkConfigResponse> CREATOR;
    public static final Integer DEFAULT_CODE;
    public static final String DEFAULT_ERROR_MESSAGE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer code;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobSdkConfig#ADAPTER", tag = 3)
    public final SigmobSdkConfig config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String error_message;

    public static final class Builder extends Message.Builder<SigmobSdkConfigResponse, Builder> {
        public Integer code;
        public SigmobSdkConfig config;
        public String error_message;

        public Builder code(Integer num) {
            this.code = num;
            return this;
        }

        public Builder config(SigmobSdkConfig sigmobSdkConfig) {
            this.config = sigmobSdkConfig;
            return this;
        }

        public Builder error_message(String str) {
            this.error_message = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobSdkConfigResponse build() {
            return new SigmobSdkConfigResponse(this.code, this.error_message, this.config, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobSdkConfigResponse extends ProtoAdapter<SigmobSdkConfigResponse> {
        public ProtoAdapter_SigmobSdkConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSdkConfigResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobSdkConfigResponse decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.code(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.error_message(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.config(SigmobSdkConfig.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobSdkConfigResponse sigmobSdkConfigResponse) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, sigmobSdkConfigResponse.code);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, sigmobSdkConfigResponse.error_message);
            SigmobSdkConfig.ADAPTER.encodeWithTag(protoWriter, 3, sigmobSdkConfigResponse.config);
            protoWriter.writeBytes(sigmobSdkConfigResponse.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
            return sigmobSdkConfigResponse.unknownFields().size() + SigmobSdkConfig.ADAPTER.encodedSizeWithTag(3, sigmobSdkConfigResponse.config) + ProtoAdapter.STRING.encodedSizeWithTag(2, sigmobSdkConfigResponse.error_message) + ProtoAdapter.UINT32.encodedSizeWithTag(1, sigmobSdkConfigResponse.code);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobSdkConfigResponse redact(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
            Builder newBuilder = sigmobSdkConfigResponse.newBuilder();
            SigmobSdkConfig sigmobSdkConfig = newBuilder.config;
            if (sigmobSdkConfig != null) {
                newBuilder.config = SigmobSdkConfig.ADAPTER.redact(sigmobSdkConfig);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobSdkConfigResponse protoAdapter_SigmobSdkConfigResponse = new ProtoAdapter_SigmobSdkConfigResponse();
        ADAPTER = protoAdapter_SigmobSdkConfigResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobSdkConfigResponse);
        DEFAULT_CODE = 0;
        aXkS();
    }

    public SigmobSdkConfigResponse(Integer num, String str, SigmobSdkConfig sigmobSdkConfig) {
        this(num, str, sigmobSdkConfig, ByteString.EMPTY);
    }

    private static /* synthetic */ void aXkS() {
        char[] charArray = "ÝÑÓ\u0090ÙßÓÛ\u0090ÜÑÇ\u0090ÍÖÛÒÒ\u0090ôÐ×üÌ×ÚÙÛ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 190);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÝÒ×Ð×Ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 190);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobSdkConfigResponse)) {
            return false;
        }
        SigmobSdkConfigResponse sigmobSdkConfigResponse = (SigmobSdkConfigResponse) obj;
        return unknownFields().equals(sigmobSdkConfigResponse.unknownFields()) && Internal.equals(this.code, sigmobSdkConfigResponse.code) && Internal.equals(this.error_message, sigmobSdkConfigResponse.error_message) && Internal.equals(this.config, sigmobSdkConfigResponse.config);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.code;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.error_message;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        SigmobSdkConfig sigmobSdkConfig = this.config;
        int hashCode4 = hashCode3 + (sigmobSdkConfig != null ? sigmobSdkConfig.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.code != null) {
            sb.append(", code=");
            sb.append(this.code);
        }
        if (this.error_message != null) {
            sb.append(", error_message=");
            sb.append(this.error_message);
        }
        if (this.config != null) {
            sb.append(", config=");
            sb.append(this.config);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobSdkConfigResponse{", '}');
    }

    public SigmobSdkConfigResponse(Integer num, String str, SigmobSdkConfig sigmobSdkConfig, ByteString byteString) {
        super(ADAPTER, byteString);
        this.code = num;
        this.error_message = str;
        this.config = sigmobSdkConfig;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.code = this.code;
        builder.error_message = this.error_message;
        builder.config = this.config;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
