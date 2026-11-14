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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class User extends AndroidMessage<User, Builder> {
    public static final ProtoAdapter<User> ADAPTER;
    public static final Parcelable.Creator<User> CREATOR;
    public static final Boolean DEFAULT_CHANGE_RECOMMENDATION_STATE;
    public static final Boolean DEFAULT_DISABLE_PERSONALIZED_RECOMMENDATION;
    public static final String DEFAULT_GENDER = "";
    public static final Boolean DEFAULT_IS_MINOR;
    public static final Integer DEFAULT_YOB;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> app_list;

    @WireField(adapter = "com.sigmob.sdk.common.models.Version#ADAPTER", tag = 5)
    public final Version app_market_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean change_recommendation_state;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean disable_personalized_recommendation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String gender;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean is_minor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> user_strategy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer yob;

    public static final class Builder extends Message.Builder<User, Builder> {
        public Version app_market_version;
        public Boolean change_recommendation_state;
        public Boolean disable_personalized_recommendation;
        public String gender;
        public Boolean is_minor;
        public Integer yob;
        public List<String> app_list = Internal.newMutableList();
        public List<String> user_strategy = Internal.newMutableList();

        public Builder app_list(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.app_list = list;
            return this;
        }

        public Builder app_market_version(Version version) {
            this.app_market_version = version;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public User build() {
            return new User(this.yob, this.gender, this.app_list, this.user_strategy, this.app_market_version, this.is_minor, this.disable_personalized_recommendation, this.change_recommendation_state, buildUnknownFields());
        }

        public Builder change_recommendation_state(Boolean bool) {
            this.change_recommendation_state = bool;
            return this;
        }

        public Builder disable_personalized_recommendation(Boolean bool) {
            this.disable_personalized_recommendation = bool;
            return this;
        }

        public Builder gender(String str) {
            this.gender = str;
            return this;
        }

        public Builder is_minor(Boolean bool) {
            this.is_minor = bool;
            return this;
        }

        public Builder user_strategy(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.user_strategy = list;
            return this;
        }

        public Builder yob(Integer num) {
            this.yob = num;
            return this;
        }
    }

    public static final class ProtoAdapter_User extends ProtoAdapter<User> {
        public ProtoAdapter_User() {
            super(FieldEncoding.LENGTH_DELIMITED, User.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public User decode(ProtoReader protoReader) {
            List<String> list;
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
                        builder.yob(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 2:
                        builder.gender(ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 3:
                        list = builder.app_list;
                        break;
                    case 4:
                        list = builder.user_strategy;
                        break;
                    case 5:
                        builder.app_market_version(Version.ADAPTER.decode(protoReader));
                        continue;
                    case 6:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        continue;
                    case 7:
                        builder.is_minor(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 8:
                        builder.disable_personalized_recommendation(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 9:
                        builder.change_recommendation_state(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                }
                list.add(ProtoAdapter.STRING.decode(protoReader));
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, User user) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, user.yob);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 2, user.gender);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 3, user.app_list);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, user.user_strategy);
            Version.ADAPTER.encodeWithTag(protoWriter, 5, user.app_market_version);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 7, user.is_minor);
            protoAdapter2.encodeWithTag(protoWriter, 8, user.disable_personalized_recommendation);
            protoAdapter2.encodeWithTag(protoWriter, 9, user.change_recommendation_state);
            protoWriter.writeBytes(user.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(User user) {
            int encodedSizeWithTag = ProtoAdapter.UINT32.encodedSizeWithTag(1, user.yob);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag2 = Version.ADAPTER.encodedSizeWithTag(5, user.app_market_version) + protoAdapter.asRepeated().encodedSizeWithTag(4, user.user_strategy) + protoAdapter.asRepeated().encodedSizeWithTag(3, user.app_list) + protoAdapter.encodedSizeWithTag(2, user.gender) + encodedSizeWithTag;
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            return user.unknownFields().size() + protoAdapter2.encodedSizeWithTag(9, user.change_recommendation_state) + protoAdapter2.encodedSizeWithTag(8, user.disable_personalized_recommendation) + protoAdapter2.encodedSizeWithTag(7, user.is_minor) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public User redact(User user) {
            Builder newBuilder = user.newBuilder();
            Version version = newBuilder.app_market_version;
            if (version != null) {
                newBuilder.app_market_version = Version.ADAPTER.redact(version);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_User protoAdapter_User = new ProtoAdapter_User();
        ADAPTER = protoAdapter_User;
        CREATOR = AndroidMessage.newCreator(protoAdapter_User);
        DEFAULT_YOB = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IS_MINOR = bool;
        DEFAULT_DISABLE_PERSONALIZED_RECOMMENDATION = bool;
        DEFAULT_CHANGE_RECOMMENDATION_STATE = bool;
        ArErnfA();
    }

    public User(Integer num, String str, List<String> list, List<String> list2, Version version, Boolean bool, Boolean bool2, Boolean bool3) {
        this(num, str, list, list2, version, bool, bool2, bool3, ByteString.EMPTY);
    }

    private static /* synthetic */ void ArErnfA() {
        char[] charArray = "\u009e\u0092\u0090Ó\u009a\u009c\u0090\u0098Ó\u009f\u0092\u0084Ó\u008e\u0095\u0098\u0091\u0091Ó·\u0093\u0094¿\u008f\u0094\u0099\u009a\u0098".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 253);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009e\u0091\u0094\u0093\u0094\u0089".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 253);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return unknownFields().equals(user.unknownFields()) && Internal.equals(this.yob, user.yob) && Internal.equals(this.gender, user.gender) && this.app_list.equals(user.app_list) && this.user_strategy.equals(user.user_strategy) && Internal.equals(this.app_market_version, user.app_market_version) && Internal.equals(this.is_minor, user.is_minor) && Internal.equals(this.disable_personalized_recommendation, user.disable_personalized_recommendation) && Internal.equals(this.change_recommendation_state, user.change_recommendation_state);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.yob;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.gender;
        int A5SV6n2 = A2egSU.A5SV6n(this.user_strategy, A2egSU.A5SV6n(this.app_list, (hashCode2 + (str != null ? str.hashCode() : 0)) * 37, 37), 37);
        Version version = this.app_market_version;
        int hashCode3 = (A5SV6n2 + (version != null ? version.hashCode() : 0)) * 37;
        Boolean bool = this.is_minor;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_personalized_recommendation;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.change_recommendation_state;
        int hashCode6 = hashCode5 + (bool3 != null ? bool3.hashCode() : 0);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.yob = this.yob;
        builder.gender = this.gender;
        builder.app_list = Internal.copyOf("app_list", this.app_list);
        builder.user_strategy = Internal.copyOf("user_strategy", this.user_strategy);
        builder.app_market_version = this.app_market_version;
        builder.is_minor = this.is_minor;
        builder.disable_personalized_recommendation = this.disable_personalized_recommendation;
        builder.change_recommendation_state = this.change_recommendation_state;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.yob != null) {
            sb.append(", yob=");
            sb.append(this.yob);
        }
        if (this.gender != null) {
            sb.append(", gender=");
            sb.append(this.gender);
        }
        if (!this.app_list.isEmpty()) {
            sb.append(", app_list=");
            sb.append(this.app_list);
        }
        if (!this.user_strategy.isEmpty()) {
            sb.append(", user_strategy=");
            sb.append(this.user_strategy);
        }
        if (this.app_market_version != null) {
            sb.append(", app_market_version=");
            sb.append(this.app_market_version);
        }
        if (this.is_minor != null) {
            sb.append(", is_minor=");
            sb.append(this.is_minor);
        }
        if (this.disable_personalized_recommendation != null) {
            sb.append(", disable_personalized_recommendation=");
            sb.append(this.disable_personalized_recommendation);
        }
        if (this.change_recommendation_state != null) {
            sb.append(", change_recommendation_state=");
            sb.append(this.change_recommendation_state);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "User{", '}');
    }

    public User(Integer num, String str, List<String> list, List<String> list2, Version version, Boolean bool, Boolean bool2, Boolean bool3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.yob = num;
        this.gender = str;
        this.app_list = Internal.immutableCopyOf("app_list", list);
        this.user_strategy = Internal.immutableCopyOf("user_strategy", list2);
        this.app_market_version = version;
        this.is_minor = bool;
        this.disable_personalized_recommendation = bool2;
        this.change_recommendation_state = bool3;
    }
}
