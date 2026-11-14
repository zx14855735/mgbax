package com.fl.saas.s2s.sdk.ad;

import COJEAR.AZOQYO;
import Kce6Pf.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.widget.InterceptClickLayout;
import com.fl.saas.common.widget.RoundedFrameLayout;
import com.fl.saas.common.widget.ShaderRoundImageView;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.util.S2SVideoView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2STemplateViewHelper {
    private final FrameLayout actionContainer;
    private FrameLayout adContainer;
    private final View adView;
    private final TextView desView;
    private int horizontalPadding;
    private Runnable mClosedEvent;
    private final Context mContext;
    private int mHeight;
    private final Type mType;
    private int mWidth;
    private final RoundedFrameLayout mediaContainer;
    private View templateView;
    private final TextView titleView;
    private int verticalPadding;
    private S2SVideoView videoView;

    public enum Type {
        MIXED_TEXT_IMAGE(true, R.layout.s2s_template_view_text_img_mixture),
        TEXT_OVERLAY(true, R.layout.s2s_template_view_text_float_layer),
        TOP_TEXT_BOTTOM_IMAGE(true, R.layout.s2s_template_view_top_text_bottom_img_with_btn),
        TOP_IMAGE_BOTTOM_TEXT(true, R.layout.s2s_template_view_top_img_bottom_text_with_btn),
        LEFT_TEXT_RIGHT_IMAGE(false, R.layout.s2s_template_view_left_text_right_img),
        LEFT_IMAGE_RIGHT_TEXT(false, R.layout.s2s_template_view_left_img_right_text),
        IMAGE_ONLY(true, R.layout.s2s_template_view_img);

        private final boolean isFullWidthMedia;
        private final int layoutId;

        static {
            FueYUUs();
        }

        Type(boolean z, int i) {
            this.layoutId = i;
            this.isFullWidthMedia = z;
        }

        private static /* synthetic */ void FueYUUs() {
            char[] charArray = "\u008c\u0080\u0082Á\u0088\u008e\u0082\u008aÁ\u008d\u0080\u0096Á\u009c\u0087\u008a\u0083\u0083Á¥\u0081\u0086\u00ad\u009d\u0086\u008b\u0088\u008a".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 239);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u008c\u0083\u0086\u0081\u0086\u009b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 239);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static Type parse(int i) {
            for (Type type : values()) {
                if (type.ordinal() == i) {
                    return type;
                }
            }
            return MIXED_TEXT_IMAGE;
        }

        public View inflateAdView(Context context) {
            return ViewHelper.inflate(context, this.layoutId);
        }

        public boolean isFullWidthMedia() {
            return this.isFullWidthMedia;
        }
    }

    public S2STemplateViewHelper(Context context, Type type) {
        this.mContext = context;
        this.mType = type;
        View inflateAdView = type.inflateAdView(context);
        this.adView = inflateAdView;
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) inflateAdView.findViewById(R.id.s2s_template_view_media_container);
        this.mediaContainer = roundedFrameLayout;
        this.actionContainer = (FrameLayout) Optional.of(inflateAdView).map(new AZOQYO(11)).orElse(roundedFrameLayout);
        TextView textView = (TextView) inflateAdView.findViewById(R.id.s2s_template_view_title);
        this.titleView = textView;
        TextView textView2 = (TextView) inflateAdView.findViewById(R.id.s2s_template_view_des);
        this.desView = textView2;
        if (type == Type.TEXT_OVERLAY) {
            if (textView != null) {
                textView.setTextColor(-1);
            }
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addActionView$3(View view) {
        int width = this.actionContainer.getWidth();
        int height = this.actionContainer.getHeight();
        int[] selfMeasure = ViewHelper.selfMeasure(view);
        int i = selfMeasure[0];
        int i2 = selfMeasure[1];
        int dip2px = DeviceUtil.dip2px(5.0f) * 2;
        int i3 = width - dip2px;
        int i4 = height - dip2px;
        if (i4 <= 0 || i3 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        if (i3 < i || i4 < i2) {
            float min = Math.min(i3 / i, i4 / i2);
            view.setScaleX(min);
            view.setScaleY(min);
        }
        this.actionContainer.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCloseView$1(View view) {
        ViewHelper.removeParent(this.templateView);
        Runnable runnable = this.mClosedEvent;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFillActionView$4(View view) {
        this.adContainer.addView(view, new FrameLayout.LayoutParams(this.mWidth, this.mHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImage$2(Drawable drawable) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageUtils.setBlurImage(imageView, drawable);
        ShaderRoundImageView shaderRoundImageView = new ShaderRoundImageView(this.mContext);
        shaderRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        shaderRoundImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = this.mType.isFullWidthMedia() ? new FrameLayout.LayoutParams(-2, -1) : new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.mediaContainer.addView(shaderRoundImageView, 0, layoutParams);
        this.mediaContainer.addView(imageView, 0, ViewHelper.getMatchParent());
        shaderRoundImageView.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FrameLayout lambda$new$0(View view) {
        return (FrameLayout) view.findViewById(R.id.s2s_template_action_container);
    }

    private void loadImage(String str) {
        ImageLoader.loadImageDrawable(str, new A2egSU(4, this));
    }

    private void loadMedia(AdInfoPoJo adInfoPoJo) {
        S2SVideoView s2SVideoView = new S2SVideoView(this.mContext);
        this.videoView = s2SVideoView;
        s2SVideoView.setVideo(adInfoPoJo);
        this.mediaContainer.addView(this.videoView, ViewHelper.getMatchParent());
    }

    public void addActionView(View view) {
        if (view == null) {
            return;
        }
        this.actionContainer.post(new KgrjnC.A2egSU(this, view, 1));
    }

    public S2STemplateViewHelper addCloseView() {
        int i;
        int i2;
        if (this.actionContainer != null) {
            try {
                ImageView imageView = new ImageView(this.mContext);
                Type type = this.mType;
                if (type != Type.LEFT_TEXT_RIGHT_IMAGE && type != Type.LEFT_IMAGE_RIGHT_TEXT) {
                    i = 20;
                    i2 = 12;
                    float f = i;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(f), DeviceUtil.dip2px(f));
                    layoutParams.gravity = 8388661;
                    int dip2px = DeviceUtil.dip2px(i2);
                    layoutParams.setMargins(dip2px, dip2px, dip2px, dip2px);
                    imageView.setImageResource(R.mipmap.yd_sdk_ad_dialog_close);
                    imageView.setOnClickListener(new Dphsd2.A2egSU(4, this));
                    this.actionContainer.addView(imageView, layoutParams);
                    return this;
                }
                i = 16;
                i2 = 6;
                float f2 = i;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DeviceUtil.dip2px(f2), DeviceUtil.dip2px(f2));
                layoutParams2.gravity = 8388661;
                int dip2px2 = DeviceUtil.dip2px(i2);
                layoutParams2.setMargins(dip2px2, dip2px2, dip2px2, dip2px2);
                imageView.setImageResource(R.mipmap.yd_sdk_ad_dialog_close);
                imageView.setOnClickListener(new Dphsd2.A2egSU(4, this));
                this.actionContainer.addView(imageView, layoutParams2);
                return this;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void addFillActionView(View view) {
        if (view == null) {
            return;
        }
        this.adContainer.post(new KgrjnC.A2egSU(this, view, 0));
    }

    public void destroy() {
        S2SVideoView s2SVideoView = this.videoView;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
    }

    public View load() {
        if (this.templateView == null) {
            InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(this.mContext, R.layout.s2s_template_view);
            int i = this.horizontalPadding;
            int i2 = this.verticalPadding;
            interceptClickLayout.setPadding(i, i2, i, i2);
            interceptClickLayout.setLayoutParams(new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
            this.adContainer = (FrameLayout) interceptClickLayout.findViewById(R.id.s2s_template_container);
            this.adContainer.addView(this.adView, new FrameLayout.LayoutParams(this.mWidth - (this.horizontalPadding * 2), this.mHeight - (this.verticalPadding * 2)));
            this.templateView = interceptClickLayout;
        }
        return this.templateView;
    }

    public S2STemplateViewHelper setAction(String str) {
        return this;
    }

    public S2STemplateViewHelper setAdLogo(Bitmap bitmap) {
        if (bitmap == null) {
            return this;
        }
        ShaderRoundImageView shaderRoundImageView = new ShaderRoundImageView(this.mContext);
        shaderRoundImageView.setRadius(DeviceUtil.dip2px(2.0f));
        shaderRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        shaderRoundImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, DeviceUtil.dip2px(12.0f));
        layoutParams.gravity = 85;
        int dip2px = DeviceUtil.dip2px(4.0f);
        layoutParams.setMargins(dip2px, dip2px, dip2px, dip2px);
        shaderRoundImageView.setImageBitmap(bitmap);
        this.actionContainer.addView(shaderRoundImageView, layoutParams);
        return this;
    }

    public S2STemplateViewHelper setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    public S2STemplateViewHelper setLogo(String str) {
        return this;
    }

    public S2STemplateViewHelper setMedia(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return this;
        }
        AdInfoPoJo.Creative creative = adInfoPoJo.creative;
        if (creative == null || !creative.isVideo()) {
            loadImage(adInfoPoJo.img_url);
            return this;
        }
        loadMedia(adInfoPoJo);
        return this;
    }

    public S2STemplateViewHelper setOnClosedListener(Runnable runnable) {
        this.mClosedEvent = runnable;
        return this;
    }

    public S2STemplateViewHelper setPadding(int i, int i2) {
        this.horizontalPadding = i;
        this.verticalPadding = i2;
        return this;
    }

    public S2STemplateViewHelper setSize(int i, int i2) {
        float f;
        float f2;
        int mobileWidth = DeviceUtil.getMobileWidth();
        if (mobileWidth >= i && i > 0) {
            mobileWidth = i;
        }
        this.mWidth = mobileWidth;
        if (this.mType.isFullWidthMedia()) {
            if (i2 <= 0) {
                f = i;
                f2 = 1.78f;
                i2 = Math.round(f / f2);
            }
        } else if (i2 <= 0) {
            f = i * 5;
            f2 = 19.0f;
            i2 = Math.round(f / f2);
        }
        this.mHeight = i2;
        return this;
    }

    public S2STemplateViewHelper setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
