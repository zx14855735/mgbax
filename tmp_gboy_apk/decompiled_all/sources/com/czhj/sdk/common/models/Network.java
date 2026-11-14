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
public final class Network extends AndroidMessage<Network, Builder> {
    public static final ProtoAdapter<Network> ADAPTER;
    public static final Parcelable.Creator<Network> CREATOR;
    public static final String DEFAULT_CARRIER_NAME = "";
    public static final Integer DEFAULT_CONNECTION_TYPE;
    public static final String DEFAULT_IPV4 = "";
    public static final String DEFAULT_IPV6 = "";
    public static final Boolean DEFAULT_IS_CUSTOM_OPERATOR_CODE;
    public static final Boolean DEFAULT_IS_CUSTOM_OPERATOR_NAME;
    public static final String DEFAULT_MAC = "";
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_OPERATOR_TYPE;
    public static final String DEFAULT_UA = "";
    public static final String DEFAULT_WIFI_ID = "";
    public static final String DEFAULT_WIFI_MAC = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String carrier_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer connection_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> ips;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String ipv4;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String ipv6;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    public final Boolean is_custom_operator_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    public final Boolean is_custom_operator_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String mac;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String operator;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer operator_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String ua;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String wifi_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String wifi_mac;

    public static final class Builder extends Message.Builder<Network, Builder> {
        public String carrier_name;
        public Integer connection_type;
        public Map<String, String> ips = Internal.newMutableMap();
        public String ipv4;
        public String ipv6;
        public Boolean is_custom_operator_code;
        public Boolean is_custom_operator_name;
        public String mac;
        public String operator;
        public Integer operator_type;
        public String ua;
        public String wifi_id;
        public String wifi_mac;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public Network build() {
            return new Network(this.ipv4, this.connection_type, this.operator_type, this.ua, this.operator, this.mac, this.wifi_mac, this.wifi_id, this.ips, this.carrier_name, this.ipv6, this.is_custom_operator_code, this.is_custom_operator_name, buildUnknownFields());
        }

        public Builder carrier_name(String str) {
            this.carrier_name = str;
            return this;
        }

        public Builder connection_type(Integer num) {
            this.connection_type = num;
            return this;
        }

        public Builder ips(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.ips = map;
            return this;
        }

        public Builder ipv4(String str) {
            this.ipv4 = str;
            return this;
        }

        public Builder ipv6(String str) {
            this.ipv6 = str;
            return this;
        }

        public Builder is_custom_operator_code(Boolean bool) {
            this.is_custom_operator_code = bool;
            return this;
        }

        public Builder is_custom_operator_name(Boolean bool) {
            this.is_custom_operator_name = bool;
            return this;
        }

        public Builder mac(String str) {
            this.mac = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder operator_type(Integer num) {
            this.operator_type = num;
            return this;
        }

        public Builder ua(String str) {
            this.ua = str;
            return this;
        }

        public Builder wifi_id(String str) {
            this.wifi_id = str;
            return this;
        }

        public Builder wifi_mac(String str) {
            this.wifi_mac = str;
            return this;
        }
    }

    public static final class ProtoAdapter_Network extends ProtoAdapter<Network> {
        private final ProtoAdapter<Map<String, String>> ips;

        public ProtoAdapter_Network() {
            super(FieldEncoding.LENGTH_DELIMITED, Network.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.ips = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Network decode(ProtoReader protoReader) {
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
                        builder.ipv4(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.connection_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.operator_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.ua(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.operator(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 6:
                        builder.mac(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 7:
                        builder.wifi_mac(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 8:
                        builder.wifi_id(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 9:
                        builder.ips.putAll(this.ips.decode(protoReader));
                        break;
                    case 10:
                        builder.carrier_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 11:
                        builder.ipv6(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 12:
                        builder.is_custom_operator_code(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 13:
                        builder.is_custom_operator_name(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Network network) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, network.ipv4);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 2, network.connection_type);
            protoAdapter2.encodeWithTag(protoWriter, 3, network.operator_type);
            protoAdapter.encodeWithTag(protoWriter, 4, network.ua);
            protoAdapter.encodeWithTag(protoWriter, 5, network.operator);
            protoAdapter.encodeWithTag(protoWriter, 6, network.mac);
            protoAdapter.encodeWithTag(protoWriter, 7, network.wifi_mac);
            protoAdapter.encodeWithTag(protoWriter, 8, network.wifi_id);
            this.ips.encodeWithTag(protoWriter, 9, network.ips);
            protoAdapter.encodeWithTag(protoWriter, 10, network.carrier_name);
            protoAdapter.encodeWithTag(protoWriter, 11, network.ipv6);
            ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
            protoAdapter3.encodeWithTag(protoWriter, 12, network.is_custom_operator_code);
            protoAdapter3.encodeWithTag(protoWriter, 13, network.is_custom_operator_name);
            protoWriter.writeBytes(network.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Network network) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, network.ipv4);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            int encodedSizeWithTag2 = protoAdapter.encodedSizeWithTag(11, network.ipv6) + protoAdapter.encodedSizeWithTag(10, network.carrier_name) + this.ips.encodedSizeWithTag(9, network.ips) + protoAdapter.encodedSizeWithTag(8, network.wifi_id) + protoAdapter.encodedSizeWithTag(7, network.wifi_mac) + protoAdapter.encodedSizeWithTag(6, network.mac) + protoAdapter.encodedSizeWithTag(5, network.operator) + protoAdapter.encodedSizeWithTag(4, network.ua) + protoAdapter2.encodedSizeWithTag(3, network.operator_type) + protoAdapter2.encodedSizeWithTag(2, network.connection_type) + encodedSizeWithTag;
            ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
            return network.unknownFields().size() + protoAdapter3.encodedSizeWithTag(13, network.is_custom_operator_name) + protoAdapter3.encodedSizeWithTag(12, network.is_custom_operator_code) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Network redact(Network network) {
            Builder newBuilder = network.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Network protoAdapter_Network = new ProtoAdapter_Network();
        ADAPTER = protoAdapter_Network;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Network);
        DEFAULT_CONNECTION_TYPE = 0;
        DEFAULT_OPERATOR_TYPE = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IS_CUSTOM_OPERATOR_CODE = bool;
        DEFAULT_IS_CUSTOM_OPERATOR_NAME = bool;
        iTdaH();
    }

    public Network(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, String str7, String str8, Boolean bool, Boolean bool2) {
        this(str, num, num2, str2, str3, str4, str5, str6, map, str7, str8, bool, bool2, ByteString.EMPTY);
    }

    private static /* synthetic */ void iTdaH() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return unknownFields().equals(network.unknownFields()) && Internal.equals(this.ipv4, network.ipv4) && Internal.equals(this.connection_type, network.connection_type) && Internal.equals(this.operator_type, network.operator_type) && Internal.equals(this.ua, network.ua) && Internal.equals(this.operator, network.operator) && Internal.equals(this.mac, network.mac) && Internal.equals(this.wifi_mac, network.wifi_mac) && Internal.equals(this.wifi_id, network.wifi_id) && this.ips.equals(network.ips) && Internal.equals(this.carrier_name, network.carrier_name) && Internal.equals(this.ipv6, network.ipv6) && Internal.equals(this.is_custom_operator_code, network.is_custom_operator_code) && Internal.equals(this.is_custom_operator_name, network.is_custom_operator_name);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.ipv4;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.connection_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.operator_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.ua;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.operator;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.mac;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.wifi_mac;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.wifi_id;
        int hashCode9 = (this.ips.hashCode() + ((hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37)) * 37;
        String str7 = this.carrier_name;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.ipv6;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Boolean bool = this.is_custom_operator_code;
        int hashCode12 = (hashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_custom_operator_name;
        int hashCode13 = hashCode12 + (bool2 != null ? bool2.hashCode() : 0);
        this.hashCode = hashCode13;
        return hashCode13;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.ipv4 = this.ipv4;
        builder.connection_type = this.connection_type;
        builder.operator_type = this.operator_type;
        builder.ua = this.ua;
        builder.operator = this.operator;
        builder.mac = this.mac;
        builder.wifi_mac = this.wifi_mac;
        builder.wifi_id = this.wifi_id;
        builder.ips = Internal.copyOf("ips", this.ips);
        builder.carrier_name = this.carrier_name;
        builder.ipv6 = this.ipv6;
        builder.is_custom_operator_code = this.is_custom_operator_code;
        builder.is_custom_operator_name = this.is_custom_operator_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.ipv4 != null) {
            sb.append(", ipv4=");
            sb.append(this.ipv4);
        }
        if (this.connection_type != null) {
            sb.append(", connection_type=");
            sb.append(this.connection_type);
        }
        if (this.operator_type != null) {
            sb.append(", operator_type=");
            sb.append(this.operator_type);
        }
        if (this.ua != null) {
            sb.append(", ua=");
            sb.append(this.ua);
        }
        if (this.operator != null) {
            sb.append(", operator=");
            sb.append(this.operator);
        }
        if (this.mac != null) {
            sb.append(", mac=");
            sb.append(this.mac);
        }
        if (this.wifi_mac != null) {
            sb.append(", wifi_mac=");
            sb.append(this.wifi_mac);
        }
        if (this.wifi_id != null) {
            sb.append(", wifi_id=");
            sb.append(this.wifi_id);
        }
        if (!this.ips.isEmpty()) {
            sb.append(", ips=");
            sb.append(this.ips);
        }
        if (this.carrier_name != null) {
            sb.append(", carrier_name=");
            sb.append(this.carrier_name);
        }
        if (this.ipv6 != null) {
            sb.append(", ipv6=");
            sb.append(this.ipv6);
        }
        if (this.is_custom_operator_code != null) {
            sb.append(", is_custom_operator_code=");
            sb.append(this.is_custom_operator_code);
        }
        if (this.is_custom_operator_name != null) {
            sb.append(", is_custom_operator_name=");
            sb.append(this.is_custom_operator_name);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Network{", '}');
    }

    public Network(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, String str7, String str8, Boolean bool, Boolean bool2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ipv4 = str;
        this.connection_type = num;
        this.operator_type = num2;
        this.ua = str2;
        this.operator = str3;
        this.mac = str4;
        this.wifi_mac = str5;
        this.wifi_id = str6;
        this.ips = Internal.immutableCopyOf("ips", map);
        this.carrier_name = str7;
        this.ipv6 = str8;
        this.is_custom_operator_code = bool;
        this.is_custom_operator_name = bool2;
    }
}
