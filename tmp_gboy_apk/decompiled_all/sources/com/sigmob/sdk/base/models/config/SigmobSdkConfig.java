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
public final class SigmobSdkConfig extends AndroidMessage<SigmobSdkConfig, Builder> {
    public static final ProtoAdapter<SigmobSdkConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobSdkConfig> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.SigmobAndroid#ADAPTER", tag = 3)
    public final SigmobAndroid sigmobAndroid_config;

    @WireField(adapter = "com.sigmob.sdk.base.models.SigmobCommon#ADAPTER", tag = 1)
    public final SigmobCommon sigmobCommon_config;

    public static final class Builder extends Message.Builder<SigmobSdkConfig, Builder> {
        public SigmobAndroid sigmobAndroid_config;
        public SigmobCommon sigmobCommon_config;

        public Builder android_config(SigmobAndroid sigmobAndroid) {
            this.sigmobAndroid_config = sigmobAndroid;
            return this;
        }

        public Builder common_config(SigmobCommon sigmobCommon) {
            this.sigmobCommon_config = sigmobCommon;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobSdkConfig build() {
            return new SigmobSdkConfig(this.sigmobCommon_config, this.sigmobAndroid_config, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SdkConfig extends ProtoAdapter<SigmobSdkConfig> {
        public ProtoAdapter_SdkConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSdkConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobSdkConfig decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.common_config(SigmobCommon.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.android_config(SigmobAndroid.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobSdkConfig sigmobSdkConfig) {
            SigmobCommon.ADAPTER.encodeWithTag(protoWriter, 1, sigmobSdkConfig.sigmobCommon_config);
            SigmobAndroid.ADAPTER.encodeWithTag(protoWriter, 3, sigmobSdkConfig.sigmobAndroid_config);
            protoWriter.writeBytes(sigmobSdkConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobSdkConfig sigmobSdkConfig) {
            return sigmobSdkConfig.unknownFields().size() + SigmobAndroid.ADAPTER.encodedSizeWithTag(3, sigmobSdkConfig.sigmobAndroid_config) + SigmobCommon.ADAPTER.encodedSizeWithTag(1, sigmobSdkConfig.sigmobCommon_config);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobSdkConfig redact(SigmobSdkConfig sigmobSdkConfig) {
            Builder newBuilder = sigmobSdkConfig.newBuilder();
            SigmobCommon sigmobCommon = newBuilder.sigmobCommon_config;
            if (sigmobCommon != null) {
                newBuilder.sigmobCommon_config = SigmobCommon.ADAPTER.redact(sigmobCommon);
            }
            SigmobAndroid sigmobAndroid = newBuilder.sigmobAndroid_config;
            if (sigmobAndroid != null) {
                newBuilder.sigmobAndroid_config = SigmobAndroid.ADAPTER.redact(sigmobAndroid);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SdkConfig protoAdapter_SdkConfig = new ProtoAdapter_SdkConfig();
        ADAPTER = protoAdapter_SdkConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SdkConfig);
        WwYxA();
    }

    public SigmobSdkConfig(SigmobCommon sigmobCommon, SigmobAndroid sigmobAndroid) {
        this(sigmobCommon, sigmobAndroid, ByteString.EMPTY);
    }

    private static /* synthetic */ void WwYxA() {
        char[] charArray = "¤¨ªé ¦ª¢é¥¨¾é´¯¢««é\u008d©®\u0085µ®£ ¢".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 199);
        }
        String str = new String(charArray);
        char[] charArray2 = "¤«®©®³".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 199);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobSdkConfig)) {
            return false;
        }
        SigmobSdkConfig sigmobSdkConfig = (SigmobSdkConfig) obj;
        return unknownFields().equals(sigmobSdkConfig.unknownFields()) && Internal.equals(this.sigmobCommon_config, sigmobSdkConfig.sigmobCommon_config) && Internal.equals(this.sigmobAndroid_config, sigmobSdkConfig.sigmobAndroid_config);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        SigmobCommon sigmobCommon = this.sigmobCommon_config;
        int hashCode2 = (hashCode + (sigmobCommon != null ? sigmobCommon.hashCode() : 0)) * 37;
        SigmobAndroid sigmobAndroid = this.sigmobAndroid_config;
        int hashCode3 = hashCode2 + (sigmobAndroid != null ? sigmobAndroid.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.sigmobCommon_config != null) {
            sb.append(", sigmobCommon_config=");
            sb.append(this.sigmobCommon_config);
        }
        if (this.sigmobAndroid_config != null) {
            sb.append(", sigmobAndroid_config=");
            sb.append(this.sigmobAndroid_config);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobSdkConfig{", '}');
    }

    public SigmobSdkConfig(SigmobCommon sigmobCommon, SigmobAndroid sigmobAndroid, ByteString byteString) {
        super(ADAPTER, byteString);
        this.sigmobCommon_config = sigmobCommon;
        this.sigmobAndroid_config = sigmobAndroid;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.sigmobCommon_config = this.sigmobCommon_config;
        builder.sigmobAndroid_config = this.sigmobAndroid_config;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
