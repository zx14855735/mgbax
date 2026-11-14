package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsPriceView extends TextView implements d {
    private static String Nd = "¥%s 到手约 ¥%s";
    private static String Ne = "¥%s  ¥%s";
    private static String Nf = "¥%s";
    private a Nc;
    private String Ng;
    private String Nh;
    private boolean Ni;

    public static class a {
        private int Nj;
        private int Nk;
        private int Nl;
        private int Nm;
        private int Nn;
        private int No;

        public final a au(int i) {
            this.Nk = i;
            return this;
        }

        public final a av(int i) {
            this.Nn = i;
            return this;
        }

        public final a aw(int i) {
            this.No = i;
            return this;
        }

        public final int ob() {
            return this.Nl;
        }

        public final int oc() {
            return this.Nn;
        }

        public final int od() {
            return this.Nm;
        }

        public final int oe() {
            return this.No;
        }

        public final int of() {
            return this.Nj;
        }

        public final int og() {
            return this.Nk;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Nc = new a();
        A(context);
    }

    private void A(Context context) {
        setMaxLines(1);
        this.Nc.Nl = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Nc.Nm = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.Nc.Nn = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.Nc.No = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.Nc.Nj = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Nc.Nk = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
    }

    private static SpannableString a(String str, String str2, boolean z, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(Nf, str);
        } else {
            format = String.format(z ? Ne : Nd, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.of()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.og()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.ob()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.od()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.oc()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.oe()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Ng = str;
        this.Nh = str2;
        this.Ni = z;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.Nh = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Nc.ob());
        try {
            spannableString = a(str, this.Nh, z, this.Nc);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    public a getConfig() {
        return this.Nc;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public KsPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nc = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nc = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Nc = new a();
        A(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.Nc.Nl = eVar.xG();
        d(this.Ng, this.Nh, this.Ni);
    }
}
