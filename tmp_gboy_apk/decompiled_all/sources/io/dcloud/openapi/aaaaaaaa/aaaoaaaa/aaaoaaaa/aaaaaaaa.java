package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa;

import android.content.Context;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaav;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa {
    private String aaaaaaa0;
    private long aaaaaaaa;
    private aaaaaaa0 aaaaaaao;

    public aaaaaaaa(String str) {
        this.aaaaaaa0 = str;
    }

    public boolean aaaaaaa0() {
        return System.currentTimeMillis() > this.aaaaaaaa;
    }

    public void aaaaaaaa(String str) {
        try {
            Date parse = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(new JSONObject(str).optString("expires"));
            if (parse != null) {
                this.aaaaaaaa = parse.getTime();
            }
        } catch (ParseException | JSONException unused) {
        }
    }

    public void aaaaaaaa(Context context, aaaaaaa0 aaaaaaa0Var) {
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.aaaaaaao(context);
            String aaaaaaaa = aaaaaaav.aaaaaaaa().aaaaaaaa(context, this.aaaaaaa0);
            if (aaaaaaaa != null) {
                try {
                    aaaaaaa0Var.aaaaaaaa(new JSONObject(aaaaaaaa), null, false);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public void aaaaaaaa(aaaaaaa0 aaaaaaa0Var) {
        this.aaaaaaao = aaaaaaa0Var;
    }

    public String aaaaaaaa() {
        return this.aaaaaaa0;
    }
}
