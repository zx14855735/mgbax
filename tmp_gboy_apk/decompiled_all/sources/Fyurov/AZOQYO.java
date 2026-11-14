package Fyurov;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.bean.Material;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f2928A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ViewGroup f2929A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Context f2930A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Material f2931ADYaiT;
    public AZkASS AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f2932ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f2933ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public View f2934AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public FrameLayout f2935AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public RelativeLayout f2936AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public TextView f2937AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public SpannableString f2938AcNBzu;

    public static class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final AZOQYO f2939A2egSU;

        public A2egSU() {
            if (this.f2939A2egSU == null) {
                this.f2939A2egSU = new AZOQYO();
            }
        }

        public final void A2egSU() {
            String str;
            AZOQYO azoqyo = this.f2939A2egSU;
            if (azoqyo.f2929A4TApA == null) {
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                return;
            }
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            try {
                int i3 = azoqyo.f2928A2egSU;
                if (i3 == 1) {
                    View inflate = LayoutInflater.from(azoqyo.f2930A5SV6n).inflate(2131493193, (ViewGroup) null, false);
                    azoqyo.f2934AYUAbz = inflate;
                    azoqyo.f2935AZOQYO = (FrameLayout) inflate.findViewById(2131298357);
                    azoqyo.f2937AaHO0E = (TextView) azoqyo.f2934AYUAbz.findViewById(2131298358);
                    FrameLayout frameLayout = azoqyo.f2935AZOQYO;
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    gradientDrawable.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#80000000")});
                    frameLayout.setBackground(gradientDrawable);
                } else if (i3 == 2) {
                    View inflate2 = LayoutInflater.from(azoqyo.f2930A5SV6n).inflate(2131493192, (ViewGroup) null, false);
                    azoqyo.f2934AYUAbz = inflate2;
                    azoqyo.f2936AZkASS = (RelativeLayout) inflate2.findViewById(2131298357);
                    azoqyo.f2937AaHO0E = (TextView) azoqyo.f2934AYUAbz.findViewById(2131298358);
                }
            } catch (Exception e) {
                e.getMessage();
                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SixElementDecorator 001: "), new EY4UKY.ADYaiT(), "004", e);
            }
            if (azoqyo.f2934AYUAbz == null || azoqyo.f2937AaHO0E == null) {
                return;
            }
            if (azoqyo.f2935AZOQYO == null && azoqyo.f2936AZkASS == null) {
                return;
            }
            Material material = azoqyo.f2931ADYaiT;
            if (material != null && (!JrXYwF.A4TApA.AlLFFp(material.getApkname()) || !JrXYwF.A4TApA.AlLFFp(azoqyo.f2931ADYaiT.getAppPublisher()) || !JrXYwF.A4TApA.AlLFFp(azoqyo.f2931ADYaiT.getVersionName()) || !JrXYwF.A4TApA.AlLFFp(azoqyo.f2931ADYaiT.getAppIntro()) || !JrXYwF.A4TApA.AlLFFp(azoqyo.f2931ADYaiT.getPermissionUrl()) || !JrXYwF.A4TApA.AlLFFp(azoqyo.f2931ADYaiT.getPrivacyUrl()))) {
                if (azoqyo.f2931ADYaiT.getApkname() == null || azoqyo.f2931ADYaiT.getApkname().isEmpty()) {
                    str = "";
                } else {
                    str = "应用名称: " + azoqyo.f2931ADYaiT.getApkname();
                }
                if (azoqyo.f2931ADYaiT.getVersionName() != null && !azoqyo.f2931ADYaiT.getVersionName().isEmpty()) {
                    StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(str, " | 应用版本: ");
                    A5SV6n2.append(azoqyo.f2931ADYaiT.getVersionName());
                    str = A5SV6n2.toString();
                }
                if (azoqyo.f2931ADYaiT.getAppPublisher() != null && !azoqyo.f2931ADYaiT.getAppPublisher().isEmpty()) {
                    str = CtFAbx.AlLFFp(str, " | 开发者: ", azoqyo.f2931ADYaiT.getAppPublisher());
                }
                String str2 = " | 功能列表";
                String str3 = str.length() > azoqyo.f2933ASJ6gh ? " | 功能列表" : "\n功能列表";
                if (azoqyo.f2932ARc23Z) {
                    azoqyo.f2937AaHO0E.setMaxEms(95);
                } else {
                    str2 = str3;
                }
                azoqyo.f2938AcNBzu = new SpannableString(CtFAbx.AlLFFp(str, str2, " | 隐私权限 | 隐私协议"));
                int length = str.length();
                int length2 = str2.length() + str.length();
                azoqyo.f2938AcNBzu.setSpan(new AYUAbz(azoqyo, 1), length, length2, 17);
                int i5 = length2 + 7;
                azoqyo.f2938AcNBzu.setSpan(new AYUAbz(azoqyo, 2), length2, i5, 17);
                azoqyo.f2938AcNBzu.setSpan(new AYUAbz(azoqyo, 3), i5, length2 + 14, 17);
                TextView textView = azoqyo.f2937AaHO0E;
                if (textView != null) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    azoqyo.f2937AaHO0E.setText(azoqyo.f2938AcNBzu);
                    azoqyo.f2937AaHO0E.setTextSize(9);
                }
            }
            azoqyo.f2929A4TApA.addView(azoqyo.f2934AYUAbz);
        }
    }
}
