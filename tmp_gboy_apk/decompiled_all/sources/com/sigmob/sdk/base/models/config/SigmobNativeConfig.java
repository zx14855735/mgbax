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
public final class SigmobNativeConfig extends AndroidMessage<SigmobNativeConfig, Builder> {
    public static final ProtoAdapter<SigmobNativeConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobNativeConfig> CREATOR;
    public static final Integer DEFAULT_AD_LOAD_TIMEOUT;
    public static final Integer DEFAULT_CACHETOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer ad_load_timeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cacheTop;

    public static final class Builder extends Message.Builder<SigmobNativeConfig, Builder> {
        public Integer ad_load_timeout;
        public Integer cacheTop;

        public Builder ad_load_timeout(Integer num) {
            this.ad_load_timeout = num;
            return this;
        }

        public Builder cacheTop(Integer num) {
            this.cacheTop = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobNativeConfig build() {
            return new SigmobNativeConfig(this.cacheTop, this.ad_load_timeout, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobNativeConfig extends ProtoAdapter<SigmobNativeConfig> {
        public ProtoAdapter_SigmobNativeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobNativeConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobNativeConfig decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.cacheTop(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.ad_load_timeout(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobNativeConfig sigmobNativeConfig) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, sigmobNativeConfig.cacheTop);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, sigmobNativeConfig.ad_load_timeout);
            protoWriter.writeBytes(sigmobNativeConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobNativeConfig sigmobNativeConfig) {
            return sigmobNativeConfig.unknownFields().size() + ProtoAdapter.UINT32.encodedSizeWithTag(2, sigmobNativeConfig.ad_load_timeout) + ProtoAdapter.INT32.encodedSizeWithTag(1, sigmobNativeConfig.cacheTop);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobNativeConfig redact(SigmobNativeConfig sigmobNativeConfig) {
            Builder newBuilder = sigmobNativeConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobNativeConfig protoAdapter_SigmobNativeConfig = new ProtoAdapter_SigmobNativeConfig();
        ADAPTER = protoAdapter_SigmobNativeConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobNativeConfig);
        DEFAULT_CACHETOP = 0;
        DEFAULT_AD_LOAD_TIMEOUT = 0;
        LaQb();
    }

    public SigmobNativeConfig(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    private static /* synthetic */ void LaQb() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobNativeConfig)) {
            return false;
        }
        SigmobNativeConfig sigmobNativeConfig = (SigmobNativeConfig) obj;
        return unknownFields().equals(sigmobNativeConfig.unknownFields()) && Internal.equals(this.cacheTop, sigmobNativeConfig.cacheTop) && Internal.equals(this.ad_load_timeout, sigmobNativeConfig.ad_load_timeout);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.cacheTop;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ad_load_timeout;
        int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.cacheTop != null) {
            sb.append(", cacheTop=");
            sb.append(this.cacheTop);
        }
        if (this.ad_load_timeout != null) {
            sb.append(", ad_load_timeout=");
            sb.append(this.ad_load_timeout);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobNativeConfig{", '}');
    }

    public SigmobNativeConfig(Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.cacheTop = num;
        this.ad_load_timeout = num2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.cacheTop = this.cacheTop;
        builder.ad_load_timeout = this.ad_load_timeout;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
