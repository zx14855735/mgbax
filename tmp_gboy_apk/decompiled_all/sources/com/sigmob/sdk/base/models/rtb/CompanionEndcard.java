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
public final class CompanionEndcard extends AndroidMessage<CompanionEndcard, Builder> {
    public static final ProtoAdapter<CompanionEndcard> ADAPTER;
    public static final Parcelable.Creator<CompanionEndcard> CREATOR;
    public static final Integer DEFAULT_ANIMATE_TYPE;
    public static final String DEFAULT_BUTTON_TEXT = "";
    public static final Integer DEFAULT_CLICK_TYPE;
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final Float DEFAULT_SCORE;
    public static final Integer DEFAULT_SHOW_DELAY_SECS;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer animate_type;

    @WireField(adapter = "Color#ADAPTER", tag = 8)
    public final Color bar_color;

    @WireField(adapter = "Color#ADAPTER", tag = 5)
    public final Color button_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String button_text;

    @WireField(adapter = "Color#ADAPTER", tag = 6)
    public final Color button_text_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer click_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float score;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer show_delay_secs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String title;

    public static final class Builder extends Message.Builder<CompanionEndcard, Builder> {
        public Color bar_color;
        public Color button_color;
        public Color button_text_color;
        public String icon_url = "";
        public String title = "";
        public Float score = CompanionEndcard.DEFAULT_SCORE;
        public String button_text = "";
        public Integer click_type = CompanionEndcard.DEFAULT_CLICK_TYPE;
        public String desc = "";
        public Integer animate_type = CompanionEndcard.DEFAULT_ANIMATE_TYPE;
        public Integer show_delay_secs = CompanionEndcard.DEFAULT_SHOW_DELAY_SECS;

        public Builder animate_type(Integer num) {
            this.animate_type = num;
            return this;
        }

        public Builder bar_color(Color color) {
            this.bar_color = color;
            return this;
        }

        public Builder button_color(Color color) {
            this.button_color = color;
            return this;
        }

        public Builder button_text(String str) {
            this.button_text = str;
            return this;
        }

        public Builder button_text_color(Color color) {
            this.button_text_color = color;
            return this;
        }

        public Builder click_type(Integer num) {
            this.click_type = num;
            return this;
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder icon_url(String str) {
            this.icon_url = str;
            return this;
        }

        public Builder score(Float f) {
            this.score = f;
            return this;
        }

        public Builder show_delay_secs(Integer num) {
            this.show_delay_secs = num;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public CompanionEndcard build() {
            return new CompanionEndcard(this.icon_url, this.title, this.score, this.button_text, this.button_color, this.button_text_color, this.click_type, this.bar_color, this.desc, this.animate_type, this.show_delay_secs, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_CompanionEndcard extends ProtoAdapter<CompanionEndcard> {
        public ProtoAdapter_CompanionEndcard() {
            super(FieldEncoding.LENGTH_DELIMITED, CompanionEndcard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public CompanionEndcard decode(ProtoReader protoReader) {
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
                        builder.icon_url(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.title(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 3:
                        builder.score(ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 4:
                        builder.button_text(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.button_color(Color.ADAPTER.decode(protoReader));
                        break;
                    case 6:
                        builder.button_text_color(Color.ADAPTER.decode(protoReader));
                        break;
                    case 7:
                        builder.click_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 8:
                        builder.bar_color(Color.ADAPTER.decode(protoReader));
                        break;
                    case 9:
                        builder.desc(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 10:
                        builder.animate_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 11:
                        builder.show_delay_secs(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, CompanionEndcard companionEndcard) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, companionEndcard.icon_url);
            protoAdapter.encodeWithTag(protoWriter, 2, companionEndcard.title);
            ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, companionEndcard.score);
            protoAdapter.encodeWithTag(protoWriter, 4, companionEndcard.button_text);
            ProtoAdapter<Color> protoAdapter2 = Color.ADAPTER;
            protoAdapter2.encodeWithTag(protoWriter, 5, companionEndcard.button_color);
            protoAdapter2.encodeWithTag(protoWriter, 6, companionEndcard.button_text_color);
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.UINT32;
            protoAdapter3.encodeWithTag(protoWriter, 7, companionEndcard.click_type);
            protoAdapter2.encodeWithTag(protoWriter, 8, companionEndcard.bar_color);
            protoAdapter.encodeWithTag(protoWriter, 9, companionEndcard.desc);
            protoAdapter3.encodeWithTag(protoWriter, 10, companionEndcard.animate_type);
            protoAdapter3.encodeWithTag(protoWriter, 11, companionEndcard.show_delay_secs);
            protoWriter.writeBytes(companionEndcard.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(CompanionEndcard companionEndcard) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(4, companionEndcard.button_text) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, companionEndcard.score) + protoAdapter.encodedSizeWithTag(2, companionEndcard.title) + protoAdapter.encodedSizeWithTag(1, companionEndcard.icon_url);
            ProtoAdapter<Color> protoAdapter2 = Color.ADAPTER;
            int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(6, companionEndcard.button_text_color) + protoAdapter2.encodedSizeWithTag(5, companionEndcard.button_color) + encodedSizeWithTag;
            ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.UINT32;
            return companionEndcard.unknownFields().size() + protoAdapter3.encodedSizeWithTag(11, companionEndcard.show_delay_secs) + protoAdapter3.encodedSizeWithTag(10, companionEndcard.animate_type) + protoAdapter.encodedSizeWithTag(9, companionEndcard.desc) + protoAdapter2.encodedSizeWithTag(8, companionEndcard.bar_color) + protoAdapter3.encodedSizeWithTag(7, companionEndcard.click_type) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public CompanionEndcard redact(CompanionEndcard companionEndcard) {
            Builder newBuilder = companionEndcard.newBuilder();
            Color color = newBuilder.button_color;
            if (color != null) {
                newBuilder.button_color = Color.ADAPTER.redact(color);
            }
            Color color2 = newBuilder.button_text_color;
            if (color2 != null) {
                newBuilder.button_text_color = Color.ADAPTER.redact(color2);
            }
            Color color3 = newBuilder.bar_color;
            if (color3 != null) {
                newBuilder.bar_color = Color.ADAPTER.redact(color3);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_CompanionEndcard protoAdapter_CompanionEndcard = new ProtoAdapter_CompanionEndcard();
        ADAPTER = protoAdapter_CompanionEndcard;
        CREATOR = AndroidMessage.newCreator(protoAdapter_CompanionEndcard);
        DEFAULT_SCORE = Float.valueOf(0.0f);
        DEFAULT_CLICK_TYPE = 0;
        DEFAULT_ANIMATE_TYPE = 0;
        DEFAULT_SHOW_DELAY_SECS = 0;
        FHFfbk();
    }

    public CompanionEndcard(String str, String str2, Float f, String str3, Color color, Color color2, Integer num, Color color3, String str4, Integer num2, Integer num3) {
        this(str, str2, f, str3, color, color2, num, color3, str4, num2, num3, ByteString.EMPTY);
    }

    private static /* synthetic */ void FHFfbk() {
        char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 229);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 229);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CompanionEndcard)) {
            return false;
        }
        CompanionEndcard companionEndcard = (CompanionEndcard) obj;
        return unknownFields().equals(companionEndcard.unknownFields()) && Internal.equals(this.icon_url, companionEndcard.icon_url) && Internal.equals(this.title, companionEndcard.title) && Internal.equals(this.score, companionEndcard.score) && Internal.equals(this.button_text, companionEndcard.button_text) && Internal.equals(this.button_color, companionEndcard.button_color) && Internal.equals(this.button_text_color, companionEndcard.button_text_color) && Internal.equals(this.click_type, companionEndcard.click_type) && Internal.equals(this.bar_color, companionEndcard.bar_color) && Internal.equals(this.desc, companionEndcard.desc) && Internal.equals(this.animate_type, companionEndcard.animate_type) && Internal.equals(this.show_delay_secs, companionEndcard.show_delay_secs);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.icon_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Float f = this.score;
        int hashCode4 = (hashCode3 + (f != null ? f.hashCode() : 0)) * 37;
        String str3 = this.button_text;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Color color = this.button_color;
        int hashCode6 = (hashCode5 + (color != null ? color.hashCode() : 0)) * 37;
        Color color2 = this.button_text_color;
        int hashCode7 = (hashCode6 + (color2 != null ? color2.hashCode() : 0)) * 37;
        Integer num = this.click_type;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Color color3 = this.bar_color;
        int hashCode9 = (hashCode8 + (color3 != null ? color3.hashCode() : 0)) * 37;
        String str4 = this.desc;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.animate_type;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.show_delay_secs;
        int hashCode12 = hashCode11 + (num3 != null ? num3.hashCode() : 0);
        this.hashCode = hashCode12;
        return hashCode12;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.icon_url != null) {
            sb.append(", icon_url=");
            sb.append(this.icon_url);
        }
        if (this.title != null) {
            sb.append(", title=");
            sb.append(this.title);
        }
        if (this.score != null) {
            sb.append(", score=");
            sb.append(this.score);
        }
        if (this.button_text != null) {
            sb.append(", button_text=");
            sb.append(this.button_text);
        }
        if (this.button_color != null) {
            sb.append(", button_color=");
            sb.append(this.button_color);
        }
        if (this.button_text_color != null) {
            sb.append(", button_text_color=");
            sb.append(this.button_text_color);
        }
        if (this.click_type != null) {
            sb.append(", click_type=");
            sb.append(this.click_type);
        }
        if (this.bar_color != null) {
            sb.append(", bar_color=");
            sb.append(this.bar_color);
        }
        if (this.desc != null) {
            sb.append(", desc=");
            sb.append(this.desc);
        }
        if (this.animate_type != null) {
            sb.append(", animate_type=");
            sb.append(this.animate_type);
        }
        if (this.show_delay_secs != null) {
            sb.append(", show_delay_secs=");
            sb.append(this.show_delay_secs);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "CompanionEndcard{", '}');
    }

    public CompanionEndcard(String str, String str2, Float f, String str3, Color color, Color color2, Integer num, Color color3, String str4, Integer num2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.icon_url = str;
        this.title = str2;
        this.score = f;
        this.button_text = str3;
        this.button_color = color;
        this.button_text_color = color2;
        this.click_type = num;
        this.bar_color = color3;
        this.desc = str4;
        this.animate_type = num2;
        this.show_delay_secs = num3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.icon_url = this.icon_url;
        builder.title = this.title;
        builder.score = this.score;
        builder.button_text = this.button_text;
        builder.button_color = this.button_color;
        builder.button_text_color = this.button_text_color;
        builder.click_type = this.click_type;
        builder.bar_color = this.bar_color;
        builder.desc = this.desc;
        builder.animate_type = this.animate_type;
        builder.show_delay_secs = this.show_delay_secs;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
