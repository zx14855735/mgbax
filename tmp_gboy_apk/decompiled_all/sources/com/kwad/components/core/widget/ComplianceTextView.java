package com.kwad.components.core.widget;

import B4ZgIw.AYUAbz;
import BPw6Q8.A2egSU;
import BPw6Q8.ASJ6gh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ComplianceTextView extends TextView {
    private String ame;
    private String amf;
    private String amg;
    private String amh;
    private String ami;
    private String amj;
    private String amk;
    private int aml;
    private AdTemplate mAdTemplate;
    private int textColor;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.aml = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET);
        int color = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (aq.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(A2egSU.A4TApA(context, R.drawable.ksad_compliance_view_bg));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        this.amf = "功能";
        this.amg = "权限";
        this.amh = "隐私";
        AdInfo.DownloadSafeInfo downloadSafeInfo = er.downloadSafeInfo;
        this.ami = downloadSafeInfo.appPermissionInfoUrl;
        this.amk = downloadSafeInfo.appPrivacyUrl;
        this.amj = downloadSafeInfo.introductionInfoUrl;
        if (this.aml > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (aq.SM()) {
                layoutParams.width = -1;
            } else {
                layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), this.aml);
            }
            setLayoutParams(layoutParams);
        }
        post(new bg() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = er.downloadSafeInfo;
                complianceTextView.a(downloadSafeInfo2.appName, TextUtils.isEmpty(downloadSafeInfo2.corporationName) ? "" : er.downloadSafeInfo.corporationName, TextUtils.isEmpty(er.downloadSafeInfo.recordNumber) ? "" : er.downloadSafeInfo.recordNumber, er.downloadSafeInfo.appVersion, ComplianceTextView.this.amf, ComplianceTextView.this.amg, ComplianceTextView.this.amh);
            }
        });
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str4);
        }
        if (!TextUtils.isEmpty(this.amj)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0304a().aH("功能介绍").aI(ComplianceTextView.this.amj).aI(true).aG(ComplianceTextView.this.mAdTemplate).rV());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.ami)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0304a().aH("权限信息").aI(ComplianceTextView.this.ami).aI(true).aG(ComplianceTextView.this.mAdTemplate).rV());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.amk)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str7);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                @Override // android.text.style.ClickableSpan
                public final void onClick(View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0304a().aH("隐私政策").aI(ComplianceTextView.this.amk).aI(true).aG(ComplianceTextView.this.mAdTemplate).rV());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ASJ6gh.A4TApA(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ame = "...\n";
        this.aml = MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int width;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        getContext();
        if (!aq.SM()) {
            width = (this.aml - getPaddingLeft()) - getPaddingRight();
            z = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z = false;
        }
        if (width < 0) {
            return;
        }
        if (!z && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float measureText = width - paint.measureText(str);
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(" ", str2);
            if (paint.measureText(A5SV6n2.toString()) > measureText && measureText > 0.0f) {
                while (str2.length() > 1) {
                    str2 = str2.substring(0, str2.length() - 1);
                    A5SV6n2.setLength(0);
                    A5SV6n2.append(" ");
                    A5SV6n2.append(str2);
                    A5SV6n2.append(this.ame);
                    if (paint.measureText(A5SV6n2.toString()) <= measureText) {
                        break;
                    }
                }
            } else {
                this.ame = "";
            }
        } else {
            this.ame = "";
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str2);
        A4TApA2.append(this.ame);
        b(str, A4TApA2.toString(), str3, str4, str5, str6, str7);
        requestLayout();
    }
}
