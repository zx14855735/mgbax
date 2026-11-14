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
public final class SigmobMotionConfig extends AndroidMessage<SigmobMotionConfig, Builder> {
    public static final ProtoAdapter<SigmobMotionConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobMotionConfig> CREATOR;
    public static final Integer DEFAULT_COUNT;
    public static final Integer DEFAULT_INTERVAL;
    public static final Integer DEFAULT_QUEUE_MAX;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer queue_max;

    public static final class Builder extends Message.Builder<SigmobMotionConfig, Builder> {
        public Integer count;
        public Integer interval;
        public Integer queue_max;

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder interval(Integer num) {
            this.interval = num;
            return this;
        }

        public Builder queue_max(Integer num) {
            this.queue_max = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobMotionConfig build() {
            return new SigmobMotionConfig(this.interval, this.queue_max, this.count, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobMotionConfig extends ProtoAdapter<SigmobMotionConfig> {
        public ProtoAdapter_SigmobMotionConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobMotionConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobMotionConfig decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.interval(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.queue_max(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.count(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobMotionConfig sigmobMotionConfig) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobMotionConfig.interval);
            protoAdapter.encodeWithTag(protoWriter, 2, sigmobMotionConfig.queue_max);
            protoAdapter.encodeWithTag(protoWriter, 3, sigmobMotionConfig.count);
            protoWriter.writeBytes(sigmobMotionConfig.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobMotionConfig sigmobMotionConfig) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return sigmobMotionConfig.unknownFields().size() + protoAdapter.encodedSizeWithTag(3, sigmobMotionConfig.count) + protoAdapter.encodedSizeWithTag(2, sigmobMotionConfig.queue_max) + protoAdapter.encodedSizeWithTag(1, sigmobMotionConfig.interval);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobMotionConfig redact(SigmobMotionConfig sigmobMotionConfig) {
            Builder newBuilder = sigmobMotionConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobMotionConfig protoAdapter_SigmobMotionConfig = new ProtoAdapter_SigmobMotionConfig();
        ADAPTER = protoAdapter_SigmobMotionConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobMotionConfig);
        DEFAULT_INTERVAL = 0;
        DEFAULT_QUEUE_MAX = 0;
        DEFAULT_COUNT = 0;
        aEyb();
    }

    public SigmobMotionConfig(Integer num, Integer num2, Integer num3) {
        this(num, num2, num3, ByteString.EMPTY);
    }

    private static /* synthetic */ void aEyb() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobMotionConfig)) {
            return false;
        }
        SigmobMotionConfig sigmobMotionConfig = (SigmobMotionConfig) obj;
        return unknownFields().equals(sigmobMotionConfig.unknownFields()) && Internal.equals(this.interval, sigmobMotionConfig.interval) && Internal.equals(this.queue_max, sigmobMotionConfig.queue_max) && Internal.equals(this.count, sigmobMotionConfig.count);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.interval;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.queue_max;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.count;
        int hashCode4 = hashCode3 + (num3 != null ? num3.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.interval != null) {
            sb.append(", interval=");
            sb.append(this.interval);
        }
        if (this.queue_max != null) {
            sb.append(", queue_max=");
            sb.append(this.queue_max);
        }
        if (this.count != null) {
            sb.append(", count=");
            sb.append(this.count);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobMotionConfig{", '}');
    }

    public SigmobMotionConfig(Integer num, Integer num2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.interval = num;
        this.queue_max = num2;
        this.count = num3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.interval = this.interval;
        builder.queue_max = this.queue_max;
        builder.count = this.count;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
