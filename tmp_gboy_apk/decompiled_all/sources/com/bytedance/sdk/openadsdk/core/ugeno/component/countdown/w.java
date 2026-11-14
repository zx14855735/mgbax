package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.adsdk.ugeno.widget.text.hf {
    private String cu;
    private String lm;
    private String no;
    private String qi;
    private String vi;

    public w(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        pl(((com.bytedance.adsdk.ugeno.widget.text.hf) this).xj);
        ((UGTextView) this.kd).setGravity(17);
    }

    public void pl(String str) {
        ((UGTextView) this.kd).setText(str);
        try {
            float measureText = ((UGTextView) this.kd).getPaint().measureText(str);
            if (measureText >= 0.0f) {
                u((int) measureText);
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(int i, int i2, int i3, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remain", i);
            jSONObject.put("index", i2);
            jSONObject.put("count", i3);
            Matcher matcher = Pattern.compile("\\$\\{([^}]+)\\}").matcher(z ? i2 == 1 ? this.cu : this.no : z2 ? this.vi : this.lm);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(matcher.group(1), "")));
            }
            matcher.appendTail(stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            this.qi = stringBuffer2;
            pl(stringBuffer2);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "text1":
                this.lm = str2;
                break;
            case "text2":
                this.vi = str2;
                break;
            case "text3":
                this.cu = str2;
                break;
            case "text4":
                this.no = str2;
                break;
        }
    }
}
