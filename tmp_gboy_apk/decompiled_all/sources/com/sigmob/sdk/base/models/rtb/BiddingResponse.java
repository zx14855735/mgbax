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
public final class BiddingResponse extends AndroidMessage<BiddingResponse, Builder> {
    public static final ProtoAdapter<BiddingResponse> ADAPTER;
    public static final Parcelable.Creator<BiddingResponse> CREATOR;
    public static final Integer DEFAULT_ECPM;
    public static final String DEFAULT_LOSE_URL = "";
    public static final Integer DEFAULT_PRICE_FOR_SSP;
    public static final String DEFAULT_PRICE_FOR_SSP_ENC = "";
    public static final String DEFAULT_WIN_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer ecpm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String lose_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer price_for_ssp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String price_for_ssp_enc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String win_url;

    public static final class Builder extends Message.Builder<BiddingResponse, Builder> {
        public Integer ecpm;
        public String lose_url;
        public Integer price_for_ssp;
        public String price_for_ssp_enc;
        public String win_url;

        public Builder ecpm(Integer num) {
            this.ecpm = num;
            return this;
        }

        public Builder lose_url(String str) {
            this.lose_url = str;
            return this;
        }

        public Builder price_for_ssp(Integer num) {
            this.price_for_ssp = num;
            return this;
        }

        public Builder price_for_ssp_enc(String str) {
            this.price_for_ssp_enc = str;
            return this;
        }

        public Builder win_url(String str) {
            this.win_url = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public BiddingResponse build() {
            return new BiddingResponse(this.win_url, this.lose_url, this.ecpm, this.price_for_ssp, this.price_for_ssp_enc, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_BiddingResponse extends ProtoAdapter<BiddingResponse> {
        public ProtoAdapter_BiddingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BiddingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public BiddingResponse decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.win_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.lose_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.ecpm(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.price_for_ssp(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.price_for_ssp_enc(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, BiddingResponse biddingResponse) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, biddingResponse.win_url);
            protoAdapter.encodeWithTag(protoWriter, 2, biddingResponse.lose_url);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 3, biddingResponse.ecpm);
            protoAdapter2.encodeWithTag(protoWriter, 4, biddingResponse.price_for_ssp);
            protoAdapter.encodeWithTag(protoWriter, 5, biddingResponse.price_for_ssp_enc);
            protoWriter.writeBytes(biddingResponse.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(BiddingResponse biddingResponse) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(2, biddingResponse.lose_url) + protoAdapter.encodedSizeWithTag(1, biddingResponse.win_url);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            return biddingResponse.unknownFields().size() + protoAdapter.encodedSizeWithTag(5, biddingResponse.price_for_ssp_enc) + protoAdapter2.encodedSizeWithTag(4, biddingResponse.price_for_ssp) + protoAdapter2.encodedSizeWithTag(3, biddingResponse.ecpm) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public BiddingResponse redact(BiddingResponse biddingResponse) {
            Builder newBuilder = biddingResponse.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_BiddingResponse protoAdapter_BiddingResponse = new ProtoAdapter_BiddingResponse();
        ADAPTER = protoAdapter_BiddingResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BiddingResponse);
        DEFAULT_ECPM = 0;
        DEFAULT_PRICE_FOR_SSP = 0;
        zHla();
    }

    public BiddingResponse(String str, String str2, Integer num, Integer num2, String str3) {
        this(str, str2, num, num2, str3, ByteString.EMPTY);
    }

    private static /* synthetic */ void zHla() {
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
        if (!(obj instanceof BiddingResponse)) {
            return false;
        }
        BiddingResponse biddingResponse = (BiddingResponse) obj;
        return unknownFields().equals(biddingResponse.unknownFields()) && Internal.equals(this.win_url, biddingResponse.win_url) && Internal.equals(this.lose_url, biddingResponse.lose_url) && Internal.equals(this.ecpm, biddingResponse.ecpm) && Internal.equals(this.price_for_ssp, biddingResponse.price_for_ssp) && Internal.equals(this.price_for_ssp_enc, biddingResponse.price_for_ssp_enc);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.win_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.lose_url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ecpm;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.price_for_ssp;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.price_for_ssp_enc;
        int hashCode6 = hashCode5 + (str3 != null ? str3.hashCode() : 0);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.win_url != null) {
            sb.append(", win_url=");
            sb.append(this.win_url);
        }
        if (this.lose_url != null) {
            sb.append(", lose_url=");
            sb.append(this.lose_url);
        }
        if (this.ecpm != null) {
            sb.append(", ecpm=");
            sb.append(this.ecpm);
        }
        if (this.price_for_ssp != null) {
            sb.append(", price_for_ssp=");
            sb.append(this.price_for_ssp);
        }
        if (this.price_for_ssp_enc != null) {
            sb.append(", price_for_ssp_enc=");
            sb.append(this.price_for_ssp_enc);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "BiddingResponse{", '}');
    }

    public BiddingResponse(String str, String str2, Integer num, Integer num2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.win_url = str;
        this.lose_url = str2;
        this.ecpm = num;
        this.price_for_ssp = num2;
        this.price_for_ssp_enc = str3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.win_url = this.win_url;
        builder.lose_url = this.lose_url;
        builder.ecpm = this.ecpm;
        builder.price_for_ssp = this.price_for_ssp;
        builder.price_for_ssp_enc = this.price_for_ssp_enc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
