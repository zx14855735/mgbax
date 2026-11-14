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
public final class NativeAdSetting extends AndroidMessage<NativeAdSetting, Builder> {
    public static final ProtoAdapter<NativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<NativeAdSetting> CREATOR;
    public static final Integer DEFAULT_AD_POOL_SIZE;
    public static final Integer DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
    public static final Boolean DEFAULT_ENABLE_ADVANCED_INTERACTION;
    public static final Integer DEFAULT_END_IMPRESSION_TIME;
    public static final Integer DEFAULT_IMPRESSION_PERCENT;
    public static final Integer DEFAULT_IMPRESSION_TIME;
    public static final Integer DEFAULT_LOG_INTERVAL_TIME;
    public static final Integer DEFAULT_MEDIA_EXPECTED_FLOOR;
    public static final Integer DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
    public static final Integer DEFAULT_REQ_INTERVAL_TIME;
    public static final Integer DEFAULT_VIDEO_AUTO_PLAY;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer ad_pool_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer detail_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean enable_advanced_interaction;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer end_impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer impression_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer log_interval_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer media_expected_floor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer preview_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer req_interval_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer video_auto_play;

    public static final class Builder extends Message.Builder<NativeAdSetting, Builder> {
        public Integer video_auto_play = NativeAdSetting.DEFAULT_VIDEO_AUTO_PLAY;
        public Integer preview_page_video_mute = NativeAdSetting.DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
        public Integer detail_page_video_mute = NativeAdSetting.DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
        public Integer impression_percent = NativeAdSetting.DEFAULT_IMPRESSION_PERCENT;
        public Integer impression_time = NativeAdSetting.DEFAULT_IMPRESSION_TIME;
        public Integer end_impression_time = NativeAdSetting.DEFAULT_END_IMPRESSION_TIME;
        public Integer req_interval_time = NativeAdSetting.DEFAULT_REQ_INTERVAL_TIME;
        public Integer ad_pool_size = NativeAdSetting.DEFAULT_AD_POOL_SIZE;
        public Integer media_expected_floor = NativeAdSetting.DEFAULT_MEDIA_EXPECTED_FLOOR;
        public Integer log_interval_time = NativeAdSetting.DEFAULT_LOG_INTERVAL_TIME;
        public Boolean enable_advanced_interaction = NativeAdSetting.DEFAULT_ENABLE_ADVANCED_INTERACTION;

        public Builder ad_pool_size(Integer num) {
            this.ad_pool_size = num;
            return this;
        }

        public Builder detail_page_video_mute(Integer num) {
            this.detail_page_video_mute = num;
            return this;
        }

        public Builder enable_advanced_interaction(Boolean bool) {
            this.enable_advanced_interaction = bool;
            return this;
        }

        public Builder end_impression_time(Integer num) {
            this.end_impression_time = num;
            return this;
        }

        public Builder impression_percent(Integer num) {
            this.impression_percent = num;
            return this;
        }

        public Builder impression_time(Integer num) {
            this.impression_time = num;
            return this;
        }

        public Builder log_interval_time(Integer num) {
            this.log_interval_time = num;
            return this;
        }

        public Builder media_expected_floor(Integer num) {
            this.media_expected_floor = num;
            return this;
        }

        public Builder preview_page_video_mute(Integer num) {
            this.preview_page_video_mute = num;
            return this;
        }

        public Builder req_interval_time(Integer num) {
            this.req_interval_time = num;
            return this;
        }

        public Builder video_auto_play(Integer num) {
            this.video_auto_play = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public NativeAdSetting build() {
            return new NativeAdSetting(this.video_auto_play, this.preview_page_video_mute, this.detail_page_video_mute, this.impression_percent, this.impression_time, this.end_impression_time, this.req_interval_time, this.ad_pool_size, this.media_expected_floor, this.log_interval_time, this.enable_advanced_interaction, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_NativeAdSetting extends ProtoAdapter<NativeAdSetting> {
        public ProtoAdapter_NativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, NativeAdSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public NativeAdSetting decode(ProtoReader protoReader) {
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
                        builder.video_auto_play(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.preview_page_video_mute(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.detail_page_video_mute(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.impression_percent(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 5:
                        builder.impression_time(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 6:
                        builder.end_impression_time(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 7:
                        builder.req_interval_time(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 8:
                        builder.ad_pool_size(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 9:
                        builder.media_expected_floor(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 10:
                        builder.log_interval_time(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 11:
                        builder.enable_advanced_interaction(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, NativeAdSetting nativeAdSetting) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, nativeAdSetting.video_auto_play);
            protoAdapter.encodeWithTag(protoWriter, 2, nativeAdSetting.preview_page_video_mute);
            protoAdapter.encodeWithTag(protoWriter, 3, nativeAdSetting.detail_page_video_mute);
            protoAdapter.encodeWithTag(protoWriter, 4, nativeAdSetting.impression_percent);
            protoAdapter.encodeWithTag(protoWriter, 5, nativeAdSetting.impression_time);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            protoAdapter2.encodeWithTag(protoWriter, 6, nativeAdSetting.end_impression_time);
            protoAdapter2.encodeWithTag(protoWriter, 7, nativeAdSetting.req_interval_time);
            protoAdapter2.encodeWithTag(protoWriter, 8, nativeAdSetting.ad_pool_size);
            protoAdapter.encodeWithTag(protoWriter, 9, nativeAdSetting.media_expected_floor);
            protoAdapter.encodeWithTag(protoWriter, 10, nativeAdSetting.log_interval_time);
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 11, nativeAdSetting.enable_advanced_interaction);
            protoWriter.writeBytes(nativeAdSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(NativeAdSetting nativeAdSetting) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(5, nativeAdSetting.impression_time) + protoAdapter.encodedSizeWithTag(4, nativeAdSetting.impression_percent) + protoAdapter.encodedSizeWithTag(3, nativeAdSetting.detail_page_video_mute) + protoAdapter.encodedSizeWithTag(2, nativeAdSetting.preview_page_video_mute) + protoAdapter.encodedSizeWithTag(1, nativeAdSetting.video_auto_play);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            return nativeAdSetting.unknownFields().size() + ProtoAdapter.BOOL.encodedSizeWithTag(11, nativeAdSetting.enable_advanced_interaction) + protoAdapter.encodedSizeWithTag(10, nativeAdSetting.log_interval_time) + protoAdapter.encodedSizeWithTag(9, nativeAdSetting.media_expected_floor) + protoAdapter2.encodedSizeWithTag(8, nativeAdSetting.ad_pool_size) + protoAdapter2.encodedSizeWithTag(7, nativeAdSetting.req_interval_time) + protoAdapter2.encodedSizeWithTag(6, nativeAdSetting.end_impression_time) + encodedSizeWithTag;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public NativeAdSetting redact(NativeAdSetting nativeAdSetting) {
            Builder newBuilder = nativeAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_NativeAdSetting protoAdapter_NativeAdSetting = new ProtoAdapter_NativeAdSetting();
        ADAPTER = protoAdapter_NativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_NativeAdSetting);
        DEFAULT_VIDEO_AUTO_PLAY = 0;
        DEFAULT_PREVIEW_PAGE_VIDEO_MUTE = 0;
        DEFAULT_DETAIL_PAGE_VIDEO_MUTE = 0;
        DEFAULT_IMPRESSION_PERCENT = 0;
        DEFAULT_IMPRESSION_TIME = 0;
        DEFAULT_END_IMPRESSION_TIME = 0;
        DEFAULT_REQ_INTERVAL_TIME = 0;
        DEFAULT_AD_POOL_SIZE = 0;
        DEFAULT_MEDIA_EXPECTED_FLOOR = 0;
        DEFAULT_LOG_INTERVAL_TIME = 0;
        DEFAULT_ENABLE_ADVANCED_INTERACTION = Boolean.FALSE;
        pNcLGMC();
    }

    public NativeAdSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Boolean bool) {
        this(num, num2, num3, num4, num5, num6, num7, num8, num9, num10, bool, ByteString.EMPTY);
    }

    private static /* synthetic */ void pNcLGMC() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdSetting)) {
            return false;
        }
        NativeAdSetting nativeAdSetting = (NativeAdSetting) obj;
        return unknownFields().equals(nativeAdSetting.unknownFields()) && Internal.equals(this.video_auto_play, nativeAdSetting.video_auto_play) && Internal.equals(this.preview_page_video_mute, nativeAdSetting.preview_page_video_mute) && Internal.equals(this.detail_page_video_mute, nativeAdSetting.detail_page_video_mute) && Internal.equals(this.impression_percent, nativeAdSetting.impression_percent) && Internal.equals(this.impression_time, nativeAdSetting.impression_time) && Internal.equals(this.end_impression_time, nativeAdSetting.end_impression_time) && Internal.equals(this.req_interval_time, nativeAdSetting.req_interval_time) && Internal.equals(this.ad_pool_size, nativeAdSetting.ad_pool_size) && Internal.equals(this.media_expected_floor, nativeAdSetting.media_expected_floor) && Internal.equals(this.log_interval_time, nativeAdSetting.log_interval_time) && Internal.equals(this.enable_advanced_interaction, nativeAdSetting.enable_advanced_interaction);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.video_auto_play;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.preview_page_video_mute;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.detail_page_video_mute;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.impression_percent;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.impression_time;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_impression_time;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.req_interval_time;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.ad_pool_size;
        int hashCode9 = (hashCode8 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.media_expected_floor;
        int hashCode10 = (hashCode9 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.log_interval_time;
        int hashCode11 = (hashCode10 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Boolean bool = this.enable_advanced_interaction;
        int hashCode12 = hashCode11 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode12;
        return hashCode12;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.video_auto_play != null) {
            sb.append(", video_auto_play=");
            sb.append(this.video_auto_play);
        }
        if (this.preview_page_video_mute != null) {
            sb.append(", preview_page_video_mute=");
            sb.append(this.preview_page_video_mute);
        }
        if (this.detail_page_video_mute != null) {
            sb.append(", detail_page_video_mute=");
            sb.append(this.detail_page_video_mute);
        }
        if (this.impression_percent != null) {
            sb.append(", impression_percent=");
            sb.append(this.impression_percent);
        }
        if (this.impression_time != null) {
            sb.append(", impression_time=");
            sb.append(this.impression_time);
        }
        if (this.end_impression_time != null) {
            sb.append(", end_impression_time=");
            sb.append(this.end_impression_time);
        }
        if (this.req_interval_time != null) {
            sb.append(", req_interval_time=");
            sb.append(this.req_interval_time);
        }
        if (this.ad_pool_size != null) {
            sb.append(", ad_pool_size=");
            sb.append(this.ad_pool_size);
        }
        if (this.media_expected_floor != null) {
            sb.append(", media_expected_floor=");
            sb.append(this.media_expected_floor);
        }
        if (this.log_interval_time != null) {
            sb.append(", log_interval_time=");
            sb.append(this.log_interval_time);
        }
        if (this.enable_advanced_interaction != null) {
            sb.append(", enable_advanced_interaction=");
            sb.append(this.enable_advanced_interaction);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "NativeAdSetting{", '}');
    }

    public NativeAdSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_auto_play = num;
        this.preview_page_video_mute = num2;
        this.detail_page_video_mute = num3;
        this.impression_percent = num4;
        this.impression_time = num5;
        this.end_impression_time = num6;
        this.req_interval_time = num7;
        this.ad_pool_size = num8;
        this.media_expected_floor = num9;
        this.log_interval_time = num10;
        this.enable_advanced_interaction = bool;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.video_auto_play = this.video_auto_play;
        builder.preview_page_video_mute = this.preview_page_video_mute;
        builder.detail_page_video_mute = this.detail_page_video_mute;
        builder.impression_percent = this.impression_percent;
        builder.impression_time = this.impression_time;
        builder.end_impression_time = this.end_impression_time;
        builder.req_interval_time = this.req_interval_time;
        builder.ad_pool_size = this.ad_pool_size;
        builder.media_expected_floor = this.media_expected_floor;
        builder.log_interval_time = this.log_interval_time;
        builder.enable_advanced_interaction = this.enable_advanced_interaction;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
