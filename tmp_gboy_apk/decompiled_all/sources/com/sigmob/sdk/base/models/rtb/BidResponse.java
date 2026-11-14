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
import com.sigmob.sdk.base.db.a;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BidResponse extends AndroidMessage<BidResponse, Builder> {
    public static final ProtoAdapter<BidResponse> ADAPTER;
    public static final Parcelable.Creator<BidResponse> CREATOR;
    public static final String DEFAULT_ADX_ID = "";
    public static final String DEFAULT_AD_UA = "";
    public static final Long DEFAULT_ERROR_CODE;
    public static final String DEFAULT_ERROR_MESSAGE = "";
    public static final Integer DEFAULT_EXPIRATION_TIME;
    public static final Boolean DEFAULT_NONCOMPLIANCE_MARK;
    public static final Integer DEFAULT_PCTR_VALID_CHECK;
    public static final String DEFAULT_PCTR_VERSION = "";
    public static final Long DEFAULT_PROCESS_TIME_MS_DSP;
    public static final Long DEFAULT_PROCESS_TIME_MS_SSP;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final String DEFAULT_RV_CALLBACK_URL = "";
    public static final String DEFAULT_UID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String ad_ua;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Ad#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<Ad> ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String adx_id;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.BiddingResponse#ADAPTER", tag = 14)
    public final BiddingResponse bidding_response;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 3)
    public final Long error_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String error_message;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer expiration_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean noncompliance_mark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer pctr_valid_check;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String pctr_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 4)
    public final Long process_time_ms_dsp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 5)
    public final Long process_time_ms_ssp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String request_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final String rv_callback_url;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Template#ADAPTER", tag = 13)
    public final Template scene;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SlotAdSetting#ADAPTER", tag = 11)
    public final SlotAdSetting slot_ad_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String uid;

    public static final class Builder extends Message.Builder<BidResponse, Builder> {
        public String ad_ua;
        public List<Ad> ads = Internal.newMutableList();
        public String adx_id;
        public BiddingResponse bidding_response;
        public Long error_code;
        public String error_message;
        public Integer expiration_time;
        public Boolean noncompliance_mark;
        public Integer pctr_valid_check;
        public String pctr_version;
        public Long process_time_ms_dsp;
        public Long process_time_ms_ssp;
        public String request_id;
        public String rv_callback_url;
        public Template scene;
        public SlotAdSetting slot_ad_setting;
        public String uid;

        public Builder ad_ua(String str) {
            this.ad_ua = str;
            return this;
        }

        public Builder ads(List<Ad> list) {
            Internal.checkElementsNotNull(list);
            this.ads = list;
            return this;
        }

        public Builder adx_id(String str) {
            this.adx_id = str;
            return this;
        }

        public Builder bidding_response(BiddingResponse biddingResponse) {
            this.bidding_response = biddingResponse;
            return this;
        }

        public Builder error_code(Long l) {
            this.error_code = l;
            return this;
        }

        public Builder error_message(String str) {
            this.error_message = str;
            return this;
        }

        public Builder expiration_time(Integer num) {
            this.expiration_time = num;
            return this;
        }

        public Builder noncompliance_mark(Boolean bool) {
            this.noncompliance_mark = bool;
            return this;
        }

        public Builder pctr_valid_check(Integer num) {
            this.pctr_valid_check = num;
            return this;
        }

        public Builder pctr_version(String str) {
            this.pctr_version = str;
            return this;
        }

        public Builder process_time_ms_dsp(Long l) {
            this.process_time_ms_dsp = l;
            return this;
        }

        public Builder process_time_ms_ssp(Long l) {
            this.process_time_ms_ssp = l;
            return this;
        }

        public Builder request_id(String str) {
            this.request_id = str;
            return this;
        }

        public Builder rv_callback_url(String str) {
            this.rv_callback_url = str;
            return this;
        }

        public Builder scene(Template template) {
            this.scene = template;
            return this;
        }

        public Builder slot_ad_setting(SlotAdSetting slotAdSetting) {
            this.slot_ad_setting = slotAdSetting;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public BidResponse build() {
            return new BidResponse(this.request_id, this.ads, this.error_code, this.process_time_ms_dsp, this.process_time_ms_ssp, this.pctr_valid_check, this.pctr_version, this.uid, this.expiration_time, this.ad_ua, this.slot_ad_setting, this.error_message, this.scene, this.bidding_response, this.rv_callback_url, this.adx_id, this.noncompliance_mark, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_BidResponse extends ProtoAdapter<BidResponse> {
        public ProtoAdapter_BidResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BidResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public BidResponse decode(ProtoReader protoReader) {
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
                        builder.request_id(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.ads.add(Ad.ADAPTER.decode(protoReader));
                        break;
                    case 3:
                        builder.error_code(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 4:
                        builder.process_time_ms_dsp(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 5:
                        builder.process_time_ms_ssp(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 6:
                        builder.pctr_valid_check(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 7:
                        builder.pctr_version(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 8:
                        builder.uid(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 9:
                        builder.expiration_time(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 10:
                        builder.ad_ua(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 11:
                        builder.slot_ad_setting(SlotAdSetting.ADAPTER.decode(protoReader));
                        break;
                    case 12:
                        builder.error_message(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 13:
                        builder.scene(Template.ADAPTER.decode(protoReader));
                        break;
                    case 14:
                        builder.bidding_response(BiddingResponse.ADAPTER.decode(protoReader));
                        break;
                    case 15:
                        builder.rv_callback_url(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 16:
                        builder.adx_id(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 17:
                        builder.noncompliance_mark(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, BidResponse bidResponse) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, bidResponse.request_id);
            Ad.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, bidResponse.ads);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.UINT64;
            protoAdapter2.encodeWithTag(protoWriter, 3, bidResponse.error_code);
            protoAdapter2.encodeWithTag(protoWriter, 4, bidResponse.process_time_ms_dsp);
            protoAdapter2.encodeWithTag(protoWriter, 5, bidResponse.process_time_ms_ssp);
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.UINT32;
            protoAdapter3.encodeWithTag(protoWriter, 6, bidResponse.pctr_valid_check);
            protoAdapter.encodeWithTag(protoWriter, 7, bidResponse.pctr_version);
            protoAdapter.encodeWithTag(protoWriter, 8, bidResponse.uid);
            protoAdapter3.encodeWithTag(protoWriter, 9, bidResponse.expiration_time);
            protoAdapter.encodeWithTag(protoWriter, 10, bidResponse.ad_ua);
            SlotAdSetting.ADAPTER.encodeWithTag(protoWriter, 11, bidResponse.slot_ad_setting);
            protoAdapter.encodeWithTag(protoWriter, 12, bidResponse.error_message);
            Template.ADAPTER.encodeWithTag(protoWriter, 13, bidResponse.scene);
            BiddingResponse.ADAPTER.encodeWithTag(protoWriter, 14, bidResponse.bidding_response);
            protoAdapter.encodeWithTag(protoWriter, 15, bidResponse.rv_callback_url);
            protoAdapter.encodeWithTag(protoWriter, 16, bidResponse.adx_id);
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 17, bidResponse.noncompliance_mark);
            protoWriter.writeBytes(bidResponse.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(BidResponse bidResponse) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = Ad.ADAPTER.asRepeated().encodedSizeWithTag(2, bidResponse.ads) + protoAdapter.encodedSizeWithTag(1, bidResponse.request_id);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.UINT64;
            int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(5, bidResponse.process_time_ms_ssp) + protoAdapter2.encodedSizeWithTag(4, bidResponse.process_time_ms_dsp) + protoAdapter2.encodedSizeWithTag(3, bidResponse.error_code) + encodedSizeWithTag;
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.UINT32;
            return bidResponse.unknownFields().size() + ProtoAdapter.BOOL.encodedSizeWithTag(17, bidResponse.noncompliance_mark) + protoAdapter.encodedSizeWithTag(16, bidResponse.adx_id) + protoAdapter.encodedSizeWithTag(15, bidResponse.rv_callback_url) + BiddingResponse.ADAPTER.encodedSizeWithTag(14, bidResponse.bidding_response) + Template.ADAPTER.encodedSizeWithTag(13, bidResponse.scene) + protoAdapter.encodedSizeWithTag(12, bidResponse.error_message) + SlotAdSetting.ADAPTER.encodedSizeWithTag(11, bidResponse.slot_ad_setting) + protoAdapter.encodedSizeWithTag(10, bidResponse.ad_ua) + protoAdapter3.encodedSizeWithTag(9, bidResponse.expiration_time) + protoAdapter.encodedSizeWithTag(8, bidResponse.uid) + protoAdapter.encodedSizeWithTag(7, bidResponse.pctr_version) + protoAdapter3.encodedSizeWithTag(6, bidResponse.pctr_valid_check) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public BidResponse redact(BidResponse bidResponse) {
            Builder newBuilder = bidResponse.newBuilder();
            Internal.redactElements(newBuilder.ads, Ad.ADAPTER);
            SlotAdSetting slotAdSetting = newBuilder.slot_ad_setting;
            if (slotAdSetting != null) {
                newBuilder.slot_ad_setting = SlotAdSetting.ADAPTER.redact(slotAdSetting);
            }
            Template template = newBuilder.scene;
            if (template != null) {
                newBuilder.scene = Template.ADAPTER.redact(template);
            }
            BiddingResponse biddingResponse = newBuilder.bidding_response;
            if (biddingResponse != null) {
                newBuilder.bidding_response = BiddingResponse.ADAPTER.redact(biddingResponse);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_BidResponse protoAdapter_BidResponse = new ProtoAdapter_BidResponse();
        ADAPTER = protoAdapter_BidResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BidResponse);
        DEFAULT_ERROR_CODE = 0L;
        DEFAULT_PROCESS_TIME_MS_DSP = 0L;
        DEFAULT_PROCESS_TIME_MS_SSP = 0L;
        DEFAULT_PCTR_VALID_CHECK = 0;
        DEFAULT_EXPIRATION_TIME = 0;
        DEFAULT_NONCOMPLIANCE_MARK = Boolean.FALSE;
        oyfqC();
    }

    public BidResponse(String str, List<Ad> list, Long l, Long l2, Long l3, Integer num, String str2, String str3, Integer num2, String str4, SlotAdSetting slotAdSetting, String str5, Template template, BiddingResponse biddingResponse, String str6, String str7, Boolean bool) {
        this(str, list, l, l2, l3, num, str2, str3, num2, str4, slotAdSetting, str5, template, biddingResponse, str6, str7, bool, ByteString.EMPTY);
    }

    private static /* synthetic */ void oyfqC() {
        char[] charArray = "L@B\u0001HNBJ\u0001M@V\u0001\\GJCC\u0001eAFm]FKHJ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '/');
        }
        String str = new String(charArray);
        char[] charArray2 = "LCFAF[".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '/');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BidResponse)) {
            return false;
        }
        BidResponse bidResponse = (BidResponse) obj;
        return unknownFields().equals(bidResponse.unknownFields()) && Internal.equals(this.request_id, bidResponse.request_id) && this.ads.equals(bidResponse.ads) && Internal.equals(this.error_code, bidResponse.error_code) && Internal.equals(this.process_time_ms_dsp, bidResponse.process_time_ms_dsp) && Internal.equals(this.process_time_ms_ssp, bidResponse.process_time_ms_ssp) && Internal.equals(this.pctr_valid_check, bidResponse.pctr_valid_check) && Internal.equals(this.pctr_version, bidResponse.pctr_version) && Internal.equals(this.uid, bidResponse.uid) && Internal.equals(this.expiration_time, bidResponse.expiration_time) && Internal.equals(this.ad_ua, bidResponse.ad_ua) && Internal.equals(this.slot_ad_setting, bidResponse.slot_ad_setting) && Internal.equals(this.error_message, bidResponse.error_message) && Internal.equals(this.scene, bidResponse.scene) && Internal.equals(this.bidding_response, bidResponse.bidding_response) && Internal.equals(this.rv_callback_url, bidResponse.rv_callback_url) && Internal.equals(this.adx_id, bidResponse.adx_id) && Internal.equals(this.noncompliance_mark, bidResponse.noncompliance_mark);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.request_id;
        int A5SV6n2 = A2egSU.A5SV6n(this.ads, (hashCode + (str != null ? str.hashCode() : 0)) * 37, 37);
        Long l = this.error_code;
        int hashCode2 = (A5SV6n2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.process_time_ms_dsp;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.process_time_ms_ssp;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.pctr_valid_check;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.pctr_version;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.uid;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.expiration_time;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.ad_ua;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        SlotAdSetting slotAdSetting = this.slot_ad_setting;
        int hashCode10 = (hashCode9 + (slotAdSetting != null ? slotAdSetting.hashCode() : 0)) * 37;
        String str5 = this.error_message;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Template template = this.scene;
        int hashCode12 = (hashCode11 + (template != null ? template.hashCode() : 0)) * 37;
        BiddingResponse biddingResponse = this.bidding_response;
        int hashCode13 = (hashCode12 + (biddingResponse != null ? biddingResponse.hashCode() : 0)) * 37;
        String str6 = this.rv_callback_url;
        int hashCode14 = (hashCode13 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.adx_id;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool = this.noncompliance_mark;
        int hashCode16 = hashCode15 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode16;
        return hashCode16;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.request_id != null) {
            sb.append(", request_id=");
            sb.append(this.request_id);
        }
        if (!this.ads.isEmpty()) {
            sb.append(", ads=");
            sb.append(this.ads);
        }
        if (this.error_code != null) {
            sb.append(", error_code=");
            sb.append(this.error_code);
        }
        if (this.process_time_ms_dsp != null) {
            sb.append(", process_time_ms_dsp=");
            sb.append(this.process_time_ms_dsp);
        }
        if (this.process_time_ms_ssp != null) {
            sb.append(", process_time_ms_ssp=");
            sb.append(this.process_time_ms_ssp);
        }
        if (this.pctr_valid_check != null) {
            sb.append(", pctr_valid_check=");
            sb.append(this.pctr_valid_check);
        }
        if (this.pctr_version != null) {
            sb.append(", pctr_version=");
            sb.append(this.pctr_version);
        }
        if (this.uid != null) {
            sb.append(", uid=");
            sb.append(this.uid);
        }
        if (this.expiration_time != null) {
            sb.append(", expiration_time=");
            sb.append(this.expiration_time);
        }
        if (this.ad_ua != null) {
            sb.append(", ad_ua=");
            sb.append(this.ad_ua);
        }
        if (this.slot_ad_setting != null) {
            sb.append(", slot_ad_setting=");
            sb.append(this.slot_ad_setting);
        }
        if (this.error_message != null) {
            sb.append(", error_message=");
            sb.append(this.error_message);
        }
        if (this.scene != null) {
            sb.append(", scene=");
            sb.append(this.scene);
        }
        if (this.bidding_response != null) {
            sb.append(", bidding_response=");
            sb.append(this.bidding_response);
        }
        if (this.rv_callback_url != null) {
            sb.append(", rv_callback_url=");
            sb.append(this.rv_callback_url);
        }
        if (this.adx_id != null) {
            sb.append(", adx_id=");
            sb.append(this.adx_id);
        }
        if (this.noncompliance_mark != null) {
            sb.append(", noncompliance_mark=");
            sb.append(this.noncompliance_mark);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "BidResponse{", '}');
    }

    public BidResponse(String str, List<Ad> list, Long l, Long l2, Long l3, Integer num, String str2, String str3, Integer num2, String str4, SlotAdSetting slotAdSetting, String str5, Template template, BiddingResponse biddingResponse, String str6, String str7, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.request_id = str;
        this.ads = Internal.immutableCopyOf(a.f13169a, list);
        this.error_code = l;
        this.process_time_ms_dsp = l2;
        this.process_time_ms_ssp = l3;
        this.pctr_valid_check = num;
        this.pctr_version = str2;
        this.uid = str3;
        this.expiration_time = num2;
        this.ad_ua = str4;
        this.slot_ad_setting = slotAdSetting;
        this.error_message = str5;
        this.scene = template;
        this.bidding_response = biddingResponse;
        this.rv_callback_url = str6;
        this.adx_id = str7;
        this.noncompliance_mark = bool;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.request_id = this.request_id;
        builder.ads = Internal.copyOf(a.f13169a, this.ads);
        builder.error_code = this.error_code;
        builder.process_time_ms_dsp = this.process_time_ms_dsp;
        builder.process_time_ms_ssp = this.process_time_ms_ssp;
        builder.pctr_valid_check = this.pctr_valid_check;
        builder.pctr_version = this.pctr_version;
        builder.uid = this.uid;
        builder.expiration_time = this.expiration_time;
        builder.ad_ua = this.ad_ua;
        builder.slot_ad_setting = this.slot_ad_setting;
        builder.error_message = this.error_message;
        builder.scene = this.scene;
        builder.bidding_response = this.bidding_response;
        builder.rv_callback_url = this.rv_callback_url;
        builder.adx_id = this.adx_id;
        builder.noncompliance_mark = this.noncompliance_mark;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
