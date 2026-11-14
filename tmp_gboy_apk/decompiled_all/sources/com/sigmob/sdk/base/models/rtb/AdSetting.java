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
public final class AdSetting extends AndroidMessage<AdSetting, Builder> {
    public static final ProtoAdapter<AdSetting> ADAPTER;
    public static final Parcelable.Creator<AdSetting> CREATOR;
    public static final Boolean DEFAULT_CAN_EXPIRE_RELOAD;
    public static final Boolean DEFAULT_DISABLE_DOWNLOAD_LISTENER;
    public static final Integer DEFAULT_EXPIRE_RELOAD_COUNT;
    public static final Boolean DEFAULT_IN_APP;
    public static final Integer DEFAULT_RETRY_COUNT;
    public static final Integer DEFAULT_SENSITIVITY;
    public static final Integer DEFAULT_SHAKE_COUNT;
    public static final Integer DEFAULT_SHAKE_TIME_THRESHOLD;
    public static final Integer DEFAULT_SHAKE_TRIGGER_TYPE;
    public static final Integer DEFAULT_WIDGET_INTERVAL_TIME;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean can_expire_reload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean disable_download_listener;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 12)
    public final Integer expire_reload_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean in_app;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.LinkAction#ADAPTER", label = WireField.Label.REPEATED, tag = 10)
    public final List<LinkAction> link_actions;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer retry_count;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.RvAdSetting#ADAPTER", tag = 1)
    public final RvAdSetting rv_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 8)
    public final List<String> scheme_white_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer sensitivity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer shake_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 14)
    public final Integer shake_time_threshold;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer shake_trigger_type;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting#ADAPTER", tag = 4)
    public final SingleNativeAdSetting single_native_setting;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SplashAdSetting#ADAPTER", tag = 2)
    public final SplashAdSetting splash_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer widget_interval_time;

    public static final class Builder extends Message.Builder<AdSetting, Builder> {
        public RvAdSetting rv_setting;
        public SingleNativeAdSetting single_native_setting;
        public SplashAdSetting splash_setting;
        public Integer retry_count = AdSetting.DEFAULT_RETRY_COUNT;
        public Boolean in_app = AdSetting.DEFAULT_IN_APP;
        public Boolean disable_download_listener = AdSetting.DEFAULT_DISABLE_DOWNLOAD_LISTENER;
        public Integer sensitivity = AdSetting.DEFAULT_SENSITIVITY;
        public Boolean can_expire_reload = AdSetting.DEFAULT_CAN_EXPIRE_RELOAD;
        public Integer expire_reload_count = AdSetting.DEFAULT_EXPIRE_RELOAD_COUNT;
        public Integer shake_count = AdSetting.DEFAULT_SHAKE_COUNT;
        public Integer shake_time_threshold = AdSetting.DEFAULT_SHAKE_TIME_THRESHOLD;
        public Integer shake_trigger_type = AdSetting.DEFAULT_SHAKE_TRIGGER_TYPE;
        public Integer widget_interval_time = AdSetting.DEFAULT_WIDGET_INTERVAL_TIME;
        public List<String> scheme_white_list = Internal.newMutableList();
        public List<LinkAction> link_actions = Internal.newMutableList();

        public Builder can_expire_reload(Boolean bool) {
            this.can_expire_reload = bool;
            return this;
        }

        public Builder disable_download_listener(Boolean bool) {
            this.disable_download_listener = bool;
            return this;
        }

        public Builder expire_reload_count(Integer num) {
            this.expire_reload_count = num;
            return this;
        }

        public Builder in_app(Boolean bool) {
            this.in_app = bool;
            return this;
        }

        public Builder link_actions(List<LinkAction> list) {
            Internal.checkElementsNotNull(list);
            this.link_actions = list;
            return this;
        }

        public Builder retry_count(Integer num) {
            this.retry_count = num;
            return this;
        }

        public Builder rv_setting(RvAdSetting rvAdSetting) {
            this.rv_setting = rvAdSetting;
            return this;
        }

        public Builder scheme_white_list(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.scheme_white_list = list;
            return this;
        }

        public Builder sensitivity(Integer num) {
            this.sensitivity = num;
            return this;
        }

        public Builder shake_count(Integer num) {
            this.shake_count = num;
            return this;
        }

        public Builder shake_time_threshold(Integer num) {
            this.shake_time_threshold = num;
            return this;
        }

        public Builder shake_trigger_type(Integer num) {
            this.shake_trigger_type = num;
            return this;
        }

        public Builder single_native_setting(SingleNativeAdSetting singleNativeAdSetting) {
            this.single_native_setting = singleNativeAdSetting;
            return this;
        }

        public Builder splash_setting(SplashAdSetting splashAdSetting) {
            this.splash_setting = splashAdSetting;
            return this;
        }

        public Builder widget_interval_time(Integer num) {
            this.widget_interval_time = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public AdSetting build() {
            return new AdSetting(this.rv_setting, this.splash_setting, this.retry_count, this.single_native_setting, this.in_app, this.disable_download_listener, this.scheme_white_list, this.sensitivity, this.link_actions, this.can_expire_reload, this.expire_reload_count, this.shake_count, this.shake_time_threshold, this.shake_trigger_type, this.widget_interval_time, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_AdSetting extends ProtoAdapter<AdSetting> {
        public ProtoAdapter_AdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, AdSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public AdSetting decode(ProtoReader protoReader) {
            List list;
            Object obj;
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
                        builder.rv_setting(RvAdSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 2:
                        builder.splash_setting(SplashAdSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 3:
                        builder.retry_count(ProtoAdapter.INT32.decode(protoReader));
                        continue;
                    case 4:
                        builder.single_native_setting(SingleNativeAdSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 5:
                        builder.in_app(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 6:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        continue;
                    case 7:
                        builder.disable_download_listener(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 8:
                        list = builder.scheme_white_list;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        builder.sensitivity(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 10:
                        list = builder.link_actions;
                        obj = (LinkAction) LinkAction.ADAPTER.decode(protoReader);
                        break;
                    case 11:
                        builder.can_expire_reload(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 12:
                        builder.expire_reload_count(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 13:
                        builder.shake_count(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 14:
                        builder.shake_time_threshold(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 15:
                        builder.shake_trigger_type(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 16:
                        builder.widget_interval_time(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                }
                list.add(obj);
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, AdSetting adSetting) {
            RvAdSetting.ADAPTER.encodeWithTag(protoWriter, 1, adSetting.rv_setting);
            SplashAdSetting.ADAPTER.encodeWithTag(protoWriter, 2, adSetting.splash_setting);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, adSetting.retry_count);
            SingleNativeAdSetting.ADAPTER.encodeWithTag(protoWriter, 4, adSetting.single_native_setting);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 5, adSetting.in_app);
            protoAdapter.encodeWithTag(protoWriter, 7, adSetting.disable_download_listener);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 8, adSetting.scheme_white_list);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 9, adSetting.sensitivity);
            LinkAction.ADAPTER.asRepeated().encodeWithTag(protoWriter, 10, adSetting.link_actions);
            protoAdapter.encodeWithTag(protoWriter, 11, adSetting.can_expire_reload);
            protoAdapter2.encodeWithTag(protoWriter, 12, adSetting.expire_reload_count);
            protoAdapter2.encodeWithTag(protoWriter, 13, adSetting.shake_count);
            protoAdapter2.encodeWithTag(protoWriter, 14, adSetting.shake_time_threshold);
            protoAdapter2.encodeWithTag(protoWriter, 15, adSetting.shake_trigger_type);
            protoAdapter2.encodeWithTag(protoWriter, 16, adSetting.widget_interval_time);
            protoWriter.writeBytes(adSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(AdSetting adSetting) {
            int encodedSizeWithTag = SingleNativeAdSetting.ADAPTER.encodedSizeWithTag(4, adSetting.single_native_setting) + ProtoAdapter.INT32.encodedSizeWithTag(3, adSetting.retry_count) + SplashAdSetting.ADAPTER.encodedSizeWithTag(2, adSetting.splash_setting) + RvAdSetting.ADAPTER.encodedSizeWithTag(1, adSetting.rv_setting);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            int encodedSizeWithTag2 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, adSetting.scheme_white_list) + protoAdapter.encodedSizeWithTag(7, adSetting.disable_download_listener) + protoAdapter.encodedSizeWithTag(5, adSetting.in_app) + encodedSizeWithTag;
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            return adSetting.unknownFields().size() + protoAdapter2.encodedSizeWithTag(16, adSetting.widget_interval_time) + protoAdapter2.encodedSizeWithTag(15, adSetting.shake_trigger_type) + protoAdapter2.encodedSizeWithTag(14, adSetting.shake_time_threshold) + protoAdapter2.encodedSizeWithTag(13, adSetting.shake_count) + protoAdapter2.encodedSizeWithTag(12, adSetting.expire_reload_count) + protoAdapter.encodedSizeWithTag(11, adSetting.can_expire_reload) + LinkAction.ADAPTER.asRepeated().encodedSizeWithTag(10, adSetting.link_actions) + protoAdapter2.encodedSizeWithTag(9, adSetting.sensitivity) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdSetting redact(AdSetting adSetting) {
            Builder newBuilder = adSetting.newBuilder();
            RvAdSetting rvAdSetting = newBuilder.rv_setting;
            if (rvAdSetting != null) {
                newBuilder.rv_setting = RvAdSetting.ADAPTER.redact(rvAdSetting);
            }
            SplashAdSetting splashAdSetting = newBuilder.splash_setting;
            if (splashAdSetting != null) {
                newBuilder.splash_setting = SplashAdSetting.ADAPTER.redact(splashAdSetting);
            }
            SingleNativeAdSetting singleNativeAdSetting = newBuilder.single_native_setting;
            if (singleNativeAdSetting != null) {
                newBuilder.single_native_setting = SingleNativeAdSetting.ADAPTER.redact(singleNativeAdSetting);
            }
            Internal.redactElements(newBuilder.link_actions, LinkAction.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdSetting protoAdapter_AdSetting = new ProtoAdapter_AdSetting();
        ADAPTER = protoAdapter_AdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdSetting);
        DEFAULT_RETRY_COUNT = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IN_APP = bool;
        DEFAULT_DISABLE_DOWNLOAD_LISTENER = bool;
        DEFAULT_SENSITIVITY = 0;
        DEFAULT_CAN_EXPIRE_RELOAD = bool;
        DEFAULT_EXPIRE_RELOAD_COUNT = 0;
        DEFAULT_SHAKE_COUNT = 0;
        DEFAULT_SHAKE_TIME_THRESHOLD = 0;
        DEFAULT_SHAKE_TRIGGER_TYPE = 0;
        DEFAULT_WIDGET_INTERVAL_TIME = 0;
        tyaNY();
    }

    public AdSetting(RvAdSetting rvAdSetting, SplashAdSetting splashAdSetting, Integer num, SingleNativeAdSetting singleNativeAdSetting, Boolean bool, Boolean bool2, List<String> list, Integer num2, List<LinkAction> list2, Boolean bool3, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this(rvAdSetting, splashAdSetting, num, singleNativeAdSetting, bool, bool2, list, num2, list2, bool3, num3, num4, num5, num6, num7, ByteString.EMPTY);
    }

    private static /* synthetic */ void tyaNY() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSetting)) {
            return false;
        }
        AdSetting adSetting = (AdSetting) obj;
        return unknownFields().equals(adSetting.unknownFields()) && Internal.equals(this.rv_setting, adSetting.rv_setting) && Internal.equals(this.splash_setting, adSetting.splash_setting) && Internal.equals(this.retry_count, adSetting.retry_count) && Internal.equals(this.single_native_setting, adSetting.single_native_setting) && Internal.equals(this.in_app, adSetting.in_app) && Internal.equals(this.disable_download_listener, adSetting.disable_download_listener) && this.scheme_white_list.equals(adSetting.scheme_white_list) && Internal.equals(this.sensitivity, adSetting.sensitivity) && this.link_actions.equals(adSetting.link_actions) && Internal.equals(this.can_expire_reload, adSetting.can_expire_reload) && Internal.equals(this.expire_reload_count, adSetting.expire_reload_count) && Internal.equals(this.shake_count, adSetting.shake_count) && Internal.equals(this.shake_time_threshold, adSetting.shake_time_threshold) && Internal.equals(this.shake_trigger_type, adSetting.shake_trigger_type) && Internal.equals(this.widget_interval_time, adSetting.widget_interval_time);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        RvAdSetting rvAdSetting = this.rv_setting;
        int hashCode2 = (hashCode + (rvAdSetting != null ? rvAdSetting.hashCode() : 0)) * 37;
        SplashAdSetting splashAdSetting = this.splash_setting;
        int hashCode3 = (hashCode2 + (splashAdSetting != null ? splashAdSetting.hashCode() : 0)) * 37;
        Integer num = this.retry_count;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        SingleNativeAdSetting singleNativeAdSetting = this.single_native_setting;
        int hashCode5 = (hashCode4 + (singleNativeAdSetting != null ? singleNativeAdSetting.hashCode() : 0)) * 37;
        Boolean bool = this.in_app;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_download_listener;
        int A5SV6n2 = A2egSU.A5SV6n(this.scheme_white_list, (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37, 37);
        Integer num2 = this.sensitivity;
        int A5SV6n3 = A2egSU.A5SV6n(this.link_actions, (A5SV6n2 + (num2 != null ? num2.hashCode() : 0)) * 37, 37);
        Boolean bool3 = this.can_expire_reload;
        int hashCode7 = (A5SV6n3 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num3 = this.expire_reload_count;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.shake_count;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.shake_time_threshold;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.shake_trigger_type;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.widget_interval_time;
        int hashCode12 = hashCode11 + (num7 != null ? num7.hashCode() : 0);
        this.hashCode = hashCode12;
        return hashCode12;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.rv_setting != null) {
            sb.append(", rv_setting=");
            sb.append(this.rv_setting);
        }
        if (this.splash_setting != null) {
            sb.append(", splash_setting=");
            sb.append(this.splash_setting);
        }
        if (this.retry_count != null) {
            sb.append(", retry_count=");
            sb.append(this.retry_count);
        }
        if (this.single_native_setting != null) {
            sb.append(", single_native_setting=");
            sb.append(this.single_native_setting);
        }
        if (this.in_app != null) {
            sb.append(", in_app=");
            sb.append(this.in_app);
        }
        if (this.disable_download_listener != null) {
            sb.append(", disable_download_listener=");
            sb.append(this.disable_download_listener);
        }
        if (!this.scheme_white_list.isEmpty()) {
            sb.append(", scheme_white_list=");
            sb.append(this.scheme_white_list);
        }
        if (this.sensitivity != null) {
            sb.append(", sensitivity=");
            sb.append(this.sensitivity);
        }
        if (!this.link_actions.isEmpty()) {
            sb.append(", link_actions=");
            sb.append(this.link_actions);
        }
        if (this.can_expire_reload != null) {
            sb.append(", can_expire_reload=");
            sb.append(this.can_expire_reload);
        }
        if (this.expire_reload_count != null) {
            sb.append(", expire_reload_count=");
            sb.append(this.expire_reload_count);
        }
        if (this.shake_count != null) {
            sb.append(", shake_count=");
            sb.append(this.shake_count);
        }
        if (this.shake_time_threshold != null) {
            sb.append(", shake_time_threshold=");
            sb.append(this.shake_time_threshold);
        }
        if (this.shake_trigger_type != null) {
            sb.append(", shake_trigger_type=");
            sb.append(this.shake_trigger_type);
        }
        if (this.widget_interval_time != null) {
            sb.append(", widget_interval_time=");
            sb.append(this.widget_interval_time);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "AdSetting{", '}');
    }

    public AdSetting(RvAdSetting rvAdSetting, SplashAdSetting splashAdSetting, Integer num, SingleNativeAdSetting singleNativeAdSetting, Boolean bool, Boolean bool2, List<String> list, Integer num2, List<LinkAction> list2, Boolean bool3, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, ByteString byteString) {
        super(ADAPTER, byteString);
        this.rv_setting = rvAdSetting;
        this.splash_setting = splashAdSetting;
        this.retry_count = num;
        this.single_native_setting = singleNativeAdSetting;
        this.in_app = bool;
        this.disable_download_listener = bool2;
        this.scheme_white_list = Internal.immutableCopyOf("scheme_white_list", list);
        this.sensitivity = num2;
        this.link_actions = Internal.immutableCopyOf("link_actions", list2);
        this.can_expire_reload = bool3;
        this.expire_reload_count = num3;
        this.shake_count = num4;
        this.shake_time_threshold = num5;
        this.shake_trigger_type = num6;
        this.widget_interval_time = num7;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.rv_setting = this.rv_setting;
        builder.splash_setting = this.splash_setting;
        builder.retry_count = this.retry_count;
        builder.single_native_setting = this.single_native_setting;
        builder.in_app = this.in_app;
        builder.disable_download_listener = this.disable_download_listener;
        builder.scheme_white_list = Internal.copyOf("scheme_white_list", this.scheme_white_list);
        builder.sensitivity = this.sensitivity;
        builder.link_actions = Internal.copyOf("link_actions", this.link_actions);
        builder.can_expire_reload = this.can_expire_reload;
        builder.expire_reload_count = this.expire_reload_count;
        builder.shake_count = this.shake_count;
        builder.shake_time_threshold = this.shake_time_threshold;
        builder.shake_trigger_type = this.shake_trigger_type;
        builder.widget_interval_time = this.widget_interval_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
