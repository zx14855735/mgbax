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
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class HeaderBidding extends AndroidMessage<HeaderBidding, Builder> {
    public static final ProtoAdapter<HeaderBidding> ADAPTER;
    public static final Parcelable.Creator<HeaderBidding> CREATOR;
    public static final Integer DEFAULT_AD_TYPE;
    public static final String DEFAULT_BID_TOKEN = "";
    public static final Integer DEFAULT_CHANNEL_ID;
    public static final String DEFAULT_CUR = "";
    public static final String DEFAULT_P_ID = "";
    public static final Integer DEFAULT_TAG;
    public static final String DEFAULT_THRMEI = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String bid_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer channel_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String cur;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String p_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer tag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String thrmei;

    public static final class Builder extends Message.Builder<HeaderBidding, Builder> {
        public String bid_token = "";
        public Integer channel_id = HeaderBidding.DEFAULT_CHANNEL_ID;
        public String p_id = "";
        public String cur = "";
        public Integer ad_type = HeaderBidding.DEFAULT_AD_TYPE;
        public String thrmei = "";
        public Integer tag = HeaderBidding.DEFAULT_TAG;
        public Map<String, String> options = Internal.newMutableMap();

        public Builder ad_type(Integer num) {
            this.ad_type = num;
            return this;
        }

        public Builder bid_token(String str) {
            this.bid_token = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public HeaderBidding build() {
            return new HeaderBidding(this.bid_token, this.channel_id, this.options, this.p_id, this.cur, this.ad_type, this.thrmei, this.tag, buildUnknownFields());
        }

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder cur(String str) {
            this.cur = str;
            return this;
        }

        public Builder options(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.options = map;
            return this;
        }

        public Builder p_id(String str) {
            this.p_id = str;
            return this;
        }

        public Builder tag(Integer num) {
            this.tag = num;
            return this;
        }

        public Builder thrmei(String str) {
            this.thrmei = str;
            return this;
        }
    }

    public static final class ProtoAdapter_HeaderBidding extends ProtoAdapter<HeaderBidding> {
        private final ProtoAdapter<Map<String, String>> options;

        public ProtoAdapter_HeaderBidding() {
            super(FieldEncoding.LENGTH_DELIMITED, HeaderBidding.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.options = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public HeaderBidding decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.bid_token(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.channel_id(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.options.putAll(this.options.decode(protoReader));
                        break;
                    case 4:
                        builder.p_id(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.cur(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 6:
                        builder.ad_type(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 7:
                        builder.thrmei(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 8:
                        builder.tag(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, HeaderBidding headerBidding) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, headerBidding.bid_token);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, headerBidding.channel_id);
            this.options.encodeWithTag(protoWriter, 3, headerBidding.options);
            protoAdapter.encodeWithTag(protoWriter, 4, headerBidding.p_id);
            protoAdapter.encodeWithTag(protoWriter, 5, headerBidding.cur);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            protoAdapter2.encodeWithTag(protoWriter, 6, headerBidding.ad_type);
            protoAdapter.encodeWithTag(protoWriter, 7, headerBidding.thrmei);
            protoAdapter2.encodeWithTag(protoWriter, 8, headerBidding.tag);
            protoWriter.writeBytes(headerBidding.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(HeaderBidding headerBidding) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(5, headerBidding.cur) + protoAdapter.encodedSizeWithTag(4, headerBidding.p_id) + this.options.encodedSizeWithTag(3, headerBidding.options) + ProtoAdapter.UINT32.encodedSizeWithTag(2, headerBidding.channel_id) + protoAdapter.encodedSizeWithTag(1, headerBidding.bid_token);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            return headerBidding.unknownFields().size() + protoAdapter2.encodedSizeWithTag(8, headerBidding.tag) + protoAdapter.encodedSizeWithTag(7, headerBidding.thrmei) + protoAdapter2.encodedSizeWithTag(6, headerBidding.ad_type) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public HeaderBidding redact(HeaderBidding headerBidding) {
            Builder newBuilder = headerBidding.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_HeaderBidding protoAdapter_HeaderBidding = new ProtoAdapter_HeaderBidding();
        ADAPTER = protoAdapter_HeaderBidding;
        CREATOR = AndroidMessage.newCreator(protoAdapter_HeaderBidding);
        DEFAULT_CHANNEL_ID = 0;
        DEFAULT_AD_TYPE = 0;
        DEFAULT_TAG = 0;
        Rogbl();
    }

    public HeaderBidding(String str, Integer num, Map<String, String> map, String str2, String str3, Integer num2, String str4, Integer num3) {
        this(str, num, map, str2, str3, num2, str4, num3, ByteString.EMPTY);
    }

    private static /* synthetic */ void Rogbl() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeaderBidding)) {
            return false;
        }
        HeaderBidding headerBidding = (HeaderBidding) obj;
        return unknownFields().equals(headerBidding.unknownFields()) && Internal.equals(this.bid_token, headerBidding.bid_token) && Internal.equals(this.channel_id, headerBidding.channel_id) && this.options.equals(headerBidding.options) && Internal.equals(this.p_id, headerBidding.p_id) && Internal.equals(this.cur, headerBidding.cur) && Internal.equals(this.ad_type, headerBidding.ad_type) && Internal.equals(this.thrmei, headerBidding.thrmei) && Internal.equals(this.tag, headerBidding.tag);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.bid_token;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.channel_id;
        int hashCode3 = (this.options.hashCode() + ((hashCode2 + (num != null ? num.hashCode() : 0)) * 37)) * 37;
        String str2 = this.p_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cur;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.ad_type;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.thrmei;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.tag;
        int hashCode8 = hashCode7 + (num3 != null ? num3.hashCode() : 0);
        this.hashCode = hashCode8;
        return hashCode8;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.bid_token = this.bid_token;
        builder.channel_id = this.channel_id;
        builder.options = Internal.copyOf("options", this.options);
        builder.p_id = this.p_id;
        builder.cur = this.cur;
        builder.ad_type = this.ad_type;
        builder.thrmei = this.thrmei;
        builder.tag = this.tag;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bid_token != null) {
            sb.append(", bid_token=");
            sb.append(this.bid_token);
        }
        if (this.channel_id != null) {
            sb.append(", channel_id=");
            sb.append(this.channel_id);
        }
        if (!this.options.isEmpty()) {
            sb.append(", options=");
            sb.append(this.options);
        }
        if (this.p_id != null) {
            sb.append(", p_id=");
            sb.append(this.p_id);
        }
        if (this.cur != null) {
            sb.append(", cur=");
            sb.append(this.cur);
        }
        if (this.ad_type != null) {
            sb.append(", ad_type=");
            sb.append(this.ad_type);
        }
        if (this.thrmei != null) {
            sb.append(", thrmei=");
            sb.append(this.thrmei);
        }
        if (this.tag != null) {
            sb.append(", tag=");
            sb.append(this.tag);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "HeaderBidding{", '}');
    }

    public HeaderBidding(String str, Integer num, Map<String, String> map, String str2, String str3, Integer num2, String str4, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bid_token = str;
        this.channel_id = num;
        this.options = Internal.immutableCopyOf("options", map);
        this.p_id = str2;
        this.cur = str3;
        this.ad_type = num2;
        this.thrmei = str4;
        this.tag = num3;
    }
}
