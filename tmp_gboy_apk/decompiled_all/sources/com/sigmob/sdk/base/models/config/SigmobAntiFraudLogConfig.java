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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class SigmobAntiFraudLogConfig extends AndroidMessage<SigmobAntiFraudLogConfig, Builder> {
    public static final ProtoAdapter<SigmobAntiFraudLogConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobAntiFraudLogConfig> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> events;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobMotionConfig#ADAPTER", tag = 1)
    public final SigmobMotionConfig motion_config;

    public static final class Builder extends Message.Builder<SigmobAntiFraudLogConfig, Builder> {
        public List<String> events = Internal.newMutableList();
        public SigmobMotionConfig motion_config;

        public Builder events(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.events = list;
            return this;
        }

        public Builder motion_config(SigmobMotionConfig sigmobMotionConfig) {
            this.motion_config = sigmobMotionConfig;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobAntiFraudLogConfig build() {
            return new SigmobAntiFraudLogConfig(this.motion_config, this.events, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobAntiFraudLogConfig extends ProtoAdapter<SigmobAntiFraudLogConfig> {
        public ProtoAdapter_SigmobAntiFraudLogConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobAntiFraudLogConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobAntiFraudLogConfig decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.motion_config(SigmobMotionConfig.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.events.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            SigmobMotionConfig.ADAPTER.encodeWithTag(protoWriter, 1, sigmobAntiFraudLogConfig.motion_config);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, sigmobAntiFraudLogConfig.events);
            protoWriter.writeBytes(sigmobAntiFraudLogConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            return sigmobAntiFraudLogConfig.unknownFields().size() + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, sigmobAntiFraudLogConfig.events) + SigmobMotionConfig.ADAPTER.encodedSizeWithTag(1, sigmobAntiFraudLogConfig.motion_config);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobAntiFraudLogConfig redact(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            Builder newBuilder = sigmobAntiFraudLogConfig.newBuilder();
            SigmobMotionConfig sigmobMotionConfig = newBuilder.motion_config;
            if (sigmobMotionConfig != null) {
                newBuilder.motion_config = SigmobMotionConfig.ADAPTER.redact(sigmobMotionConfig);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobAntiFraudLogConfig protoAdapter_SigmobAntiFraudLogConfig = new ProtoAdapter_SigmobAntiFraudLogConfig();
        ADAPTER = protoAdapter_SigmobAntiFraudLogConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobAntiFraudLogConfig);
        MbVNhPo();
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig sigmobMotionConfig, List<String> list) {
        this(sigmobMotionConfig, list, ByteString.EMPTY);
    }

    private static /* synthetic */ void MbVNhPo() {
        char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '2');
        }
        String str = new String(charArray);
        char[] charArray2 = "Q^[\\[F".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '2');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobAntiFraudLogConfig)) {
            return false;
        }
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = (SigmobAntiFraudLogConfig) obj;
        return unknownFields().equals(sigmobAntiFraudLogConfig.unknownFields()) && Internal.equals(this.motion_config, sigmobAntiFraudLogConfig.motion_config) && this.events.equals(sigmobAntiFraudLogConfig.events);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        SigmobMotionConfig sigmobMotionConfig = this.motion_config;
        int hashCode2 = this.events.hashCode() + ((hashCode + (sigmobMotionConfig != null ? sigmobMotionConfig.hashCode() : 0)) * 37);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.motion_config != null) {
            sb.append(", motion_config=");
            sb.append(this.motion_config);
        }
        if (!this.events.isEmpty()) {
            sb.append(", events=");
            sb.append(this.events);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobAntiFraudLogConfig{", '}');
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig sigmobMotionConfig, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.motion_config = sigmobMotionConfig;
        this.events = Internal.immutableCopyOf("events", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.motion_config = this.motion_config;
        builder.events = Internal.copyOf("events", this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
