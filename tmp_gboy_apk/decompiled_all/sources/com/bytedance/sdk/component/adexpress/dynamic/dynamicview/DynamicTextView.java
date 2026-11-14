package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.u.p;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.n;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.f += 6;
        if (this.f10177pl.r()) {
            AnimationText animationText = new AnimationText(context, this.f10177pl.c(), this.f10177pl.kd(), 1, this.f10177pl.f());
            this.qt = animationText;
            animationText.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.qt = textView;
            textView.setIncludeFontPadding(false);
        }
        this.qt.setTag(Integer.valueOf(getClickArea()));
        addView(this.qt, getWidgetLayoutParams());
    }

    private boolean d() {
        DynamicRootView dynamicRootView = this.am;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.am.getRenderRequest().g() == 4) ? false : true;
    }

    private void p() {
        if (this.qt instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                pl.xj(e);
                arrayList.add(text);
            }
            ((AnimationText) this.qt).setMaxLines(1);
            ((AnimationText) this.qt).setTextColor(this.f10177pl.c());
            ((AnimationText) this.qt).setTextSize(this.f10177pl.kd());
            ((AnimationText) this.qt).setAnimationText(arrayList);
            ((AnimationText) this.qt).setAnimationType(this.f10177pl.ws());
            ((AnimationText) this.qt).setAnimationDuration(this.f10177pl.b() * 1000);
            ((AnimationText) this.qt).xj();
        }
    }

    private void tf() {
        int xj;
        if (A2egSU.BNL6CD(this.g, n.l) || A2egSU.BNL6CD(this.g, "title") || A2egSU.BNL6CD(this.g, "text_star")) {
            int[] hf = p.hf(this.f10177pl.y(), this.f10177pl.kd(), true);
            int xj2 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), this.f10177pl.hf());
            int xj3 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), this.f10177pl.w());
            int xj4 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), this.f10177pl.u());
            int xj5 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), this.f10177pl.xj());
            int min = Math.min(xj2, xj5);
            if (A2egSU.BNL6CD(this.g, n.l) && (xj = ((this.f - ((int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), this.f10177pl.kd()))) - xj2) - xj5) > 1 && xj <= min * 2) {
                int i = xj / 2;
                this.qt.setPadding(xj3, xj2 - i, xj4, xj5 - (xj - i));
                return;
            }
            int i2 = (((hf[1] + xj2) + xj5) - this.f) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= min * 2) {
                int i3 = i2 / 2;
                this.qt.setPadding(xj3, xj2 - i3, xj4, xj5 - (i2 - i3));
            } else if (i2 > xj2 + xj5) {
                final int i4 = (i2 - xj2) - xj5;
                this.qt.setPadding(xj3, 0, xj4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), 1.0f)) + 1) {
                    ((TextView) this.qt).setTextSize(this.f10177pl.kd() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.u.f.xj(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.qt).setTextSize(this.f10177pl.kd() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.qt.getLayoutParams();
                                DynamicTextView dynamicTextView = DynamicTextView.this;
                                layoutParams.height = dynamicTextView.f + i4;
                                dynamicTextView.qt.setLayoutParams(layoutParams);
                                DynamicTextView.this.qt.setTranslationY(-i4);
                                ((ViewGroup) DynamicTextView.this.qt.getParent()).setClipChildren(false);
                                ((ViewGroup) DynamicTextView.this.qt.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (xj2 > xj5) {
                this.qt.setPadding(xj3, xj2 - (i2 - min), xj4, xj5 - min);
            } else {
                this.qt.setPadding(xj3, xj2 - min, xj4, xj5 - (i2 - min));
            }
        }
        if (A2egSU.BNL6CD(this.g, "fillButton")) {
            this.qt.setTextAlignment(2);
            ((TextView) this.qt).setGravity(17);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        int i;
        double d;
        super.f();
        if (TextUtils.isEmpty(getText())) {
            this.qt.setVisibility(4);
            return true;
        }
        if (this.f10177pl.r()) {
            p();
            return true;
        }
        ((TextView) this.qt).setText(this.f10177pl.y());
        ((TextView) this.qt).setTextDirection(5);
        this.qt.setTextAlignment(this.f10177pl.f());
        ((TextView) this.qt).setTextColor(this.f10177pl.c());
        ((TextView) this.qt).setTextSize(this.f10177pl.kd());
        if (this.f10177pl.ht()) {
            int ra = this.f10177pl.ra();
            if (ra > 0) {
                ((TextView) this.qt).setLines(ra);
                ((TextView) this.qt).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.qt).setMaxLines(1);
            ((TextView) this.qt).setGravity(17);
            ((TextView) this.qt).setEllipsize(TextUtils.TruncateAt.END);
        }
        f fVar = this.g;
        if (fVar != null && fVar.tf() != null) {
            if (com.bytedance.sdk.component.adexpress.u.xj() && d() && (A2egSU.BNL6CD(this.g, "text_star") || A2egSU.BNL6CD(this.g, "score-count") || A2egSU.BNL6CD(this.g, "score-count-type-1") || A2egSU.BNL6CD(this.g, "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (A2egSU.BNL6CD(this.g, "score-count") || A2egSU.BNL6CD(this.g, "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (NumberFormatException unused) {
                        i = -1;
                    }
                    if (i < 0) {
                        if (com.bytedance.sdk.component.adexpress.u.xj()) {
                            setVisibility(8);
                            return true;
                        }
                        this.qt.setVisibility(0);
                    }
                    if (TextUtils.equals(this.g.tf().getType(), "score-count-type-2")) {
                        ((TextView) this.qt).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                        ((TextView) this.qt).setGravity(17);
                        return true;
                    }
                    xj((TextView) this.qt, i, getContext(), "tt_comment_num");
                } catch (Exception unused2) {
                }
            } else if (A2egSU.BNL6CD(this.g, "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    pl.u("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.u.xj()) {
                        setVisibility(8);
                        return true;
                    }
                    this.qt.setVisibility(0);
                }
                ((TextView) this.qt).setIncludeFontPadding(false);
                ((TextView) this.qt).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.g.tf().getType())) {
                ((TextView) this.qt).setText("功能 | 权限 | 隐私");
            } else if (A2egSU.BNL6CD(this.g, "development-name")) {
                ((TextView) this.qt).setText(jk.xj(com.bytedance.sdk.component.adexpress.u.getContext(), "tt_text_privacy_development") + getText());
            } else if (A2egSU.BNL6CD(this.g, "app-version")) {
                ((TextView) this.qt).setText(jk.xj(com.bytedance.sdk.component.adexpress.u.getContext(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.qt).setText(getText());
            }
            this.qt.setTextAlignment(this.f10177pl.f());
            ((TextView) this.qt).setGravity(this.f10177pl.d());
            if (com.bytedance.sdk.component.adexpress.u.xj()) {
                tf();
            }
        }
        return true;
    }

    public String getText() {
        String y = this.f10177pl.y();
        if (TextUtils.isEmpty(y)) {
            if (!com.bytedance.sdk.component.adexpress.u.xj() && A2egSU.BNL6CD(this.g, "text_star")) {
                y = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.u.xj() && A2egSU.BNL6CD(this.g, "score-count")) {
                y = "6870";
            }
        }
        return (A2egSU.BNL6CD(this.g, "title") || A2egSU.BNL6CD(this.g, MediaFormat.KEY_SUBTITLE)) ? y.replace("\n", "") : y;
    }

    public void xj(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(jk.xj(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }
}
