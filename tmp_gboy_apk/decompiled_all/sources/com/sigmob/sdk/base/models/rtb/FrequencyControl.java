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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class FrequencyControl extends AndroidMessage<FrequencyControl, Builder> {
    public static final ProtoAdapter<FrequencyControl> ADAPTER;
    public static final Parcelable.Creator<FrequencyControl> CREATOR;
    public static final Integer DEFAULT_FREQUENCY_CONTROL_COUNT;
    public static final String DEFAULT_FREQUENCY_CONTROL_EVENT = "";
    public static final String DEFAULT_STRATEGY_ID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 4)
    public final List<Integer> ad_expire_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer frequency_control_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String frequency_control_event;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String strategy_id;

    public static final class Builder extends Message.Builder<FrequencyControl, Builder> {
        public String strategy_id = "";
        public String frequency_control_event = "";
        public Integer frequency_control_count = FrequencyControl.DEFAULT_FREQUENCY_CONTROL_COUNT;
        public List<Integer> ad_expire_type = Internal.newMutableList();

        public Builder ad_expire_type(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.ad_expire_type = list;
            return this;
        }

        public Builder frequency_control_count(Integer num) {
            this.frequency_control_count = num;
            return this;
        }

        public Builder frequency_control_event(String str) {
            this.frequency_control_event = str;
            return this;
        }

        public Builder strategy_id(String str) {
            this.strategy_id = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public FrequencyControl build() {
            return new FrequencyControl(this.strategy_id, this.frequency_control_event, this.frequency_control_count, this.ad_expire_type, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_FrequencyControl extends ProtoAdapter<FrequencyControl> {
        public ProtoAdapter_FrequencyControl() {
            super(FieldEncoding.LENGTH_DELIMITED, FrequencyControl.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public FrequencyControl decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.strategy_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.frequency_control_event(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.frequency_control_count(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.ad_expire_type.add(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FrequencyControl frequencyControl) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, frequencyControl.strategy_id);
            protoAdapter.encodeWithTag(protoWriter, 2, frequencyControl.frequency_control_event);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 3, frequencyControl.frequency_control_count);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 4, frequencyControl.ad_expire_type);
            protoWriter.writeBytes(frequencyControl.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FrequencyControl frequencyControl) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(2, frequencyControl.frequency_control_event) + protoAdapter.encodedSizeWithTag(1, frequencyControl.strategy_id);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            return frequencyControl.unknownFields().size() + protoAdapter2.asRepeated().encodedSizeWithTag(4, frequencyControl.ad_expire_type) + protoAdapter2.encodedSizeWithTag(3, frequencyControl.frequency_control_count) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FrequencyControl redact(FrequencyControl frequencyControl) {
            Builder newBuilder = frequencyControl.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_FrequencyControl protoAdapter_FrequencyControl = new ProtoAdapter_FrequencyControl();
        ADAPTER = protoAdapter_FrequencyControl;
        CREATOR = AndroidMessage.newCreator(protoAdapter_FrequencyControl);
        DEFAULT_FREQUENCY_CONTROL_COUNT = 0;
        ASFAOZ();
    }

    public FrequencyControl(String str, String str2, Integer num, List<Integer> list) {
        this(str, str2, num, list, ByteString.EMPTY);
    }

    private static /* synthetic */ void ASFAOZ() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FrequencyControl)) {
            return false;
        }
        FrequencyControl frequencyControl = (FrequencyControl) obj;
        return unknownFields().equals(frequencyControl.unknownFields()) && Internal.equals(this.strategy_id, frequencyControl.strategy_id) && Internal.equals(this.frequency_control_event, frequencyControl.frequency_control_event) && Internal.equals(this.frequency_control_count, frequencyControl.frequency_control_count) && this.ad_expire_type.equals(frequencyControl.ad_expire_type);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.strategy_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.frequency_control_event;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.frequency_control_count;
        int hashCode4 = this.ad_expire_type.hashCode() + ((hashCode3 + (num != null ? num.hashCode() : 0)) * 37);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.strategy_id != null) {
            sb.append(", strategy_id=");
            sb.append(this.strategy_id);
        }
        if (this.frequency_control_event != null) {
            sb.append(", frequency_control_event=");
            sb.append(this.frequency_control_event);
        }
        if (this.frequency_control_count != null) {
            sb.append(", frequency_control_count=");
            sb.append(this.frequency_control_count);
        }
        if (!this.ad_expire_type.isEmpty()) {
            sb.append(", ad_expire_type=");
            sb.append(this.ad_expire_type);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "FrequencyControl{", '}');
    }

    public FrequencyControl(String str, String str2, Integer num, List<Integer> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.strategy_id = str;
        this.frequency_control_event = str2;
        this.frequency_control_count = num;
        this.ad_expire_type = Internal.immutableCopyOf("ad_expire_type", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.strategy_id = this.strategy_id;
        builder.frequency_control_event = this.frequency_control_event;
        builder.frequency_control_count = this.frequency_control_count;
        builder.ad_expire_type = Internal.copyOf("ad_expire_type", this.ad_expire_type);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
