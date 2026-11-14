package com.google.android.material.tabs;

import ADYaiT.BpkvW3;
import COJEAR.BmvVmW;
import COJEAR.CrfGsy;
import COJEAR.DG07BK;
import NOd7IU.AlLFFp;
import Oay4Bh.C4FrIb;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends LinearLayout {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f11817BI9f7h = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public TabLayout.A2egSU f11818AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public TextView f11819AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ImageView f11820AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public View f11821AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public NpX2pY.A2egSU f11822B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public View f11823B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public TextView f11824B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ImageView f11825B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Drawable f11826B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f11827B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final /* synthetic */ TabLayout f11828BChYOn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ADYaiT(TabLayout tabLayout, Context context) {
        super(context);
        int i = 8;
        this.f11828BChYOn = tabLayout;
        this.f11827B9tovu = 2;
        ADYaiT(context);
        setPaddingRelative(tabLayout.f11846B25kr6, tabLayout.f11847B2KMhB, tabLayout.f11848B3GDIM, tabLayout.f11849B4ZgIw);
        setGravity(17);
        setOrientation(!tabLayout.f11871Cd8JRx ? 1 : 0);
        setClickable(true);
        Context context2 = getContext();
        int i2 = Build.VERSION.SDK_INT;
        KCxDWD.A5SV6n a5SV6n = i2 >= 24 ? new KCxDWD.A5SV6n(i, BmvVmW.A4TApA(context2, 1002)) : new KCxDWD.A5SV6n(i, (Object) null);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (i2 >= 24) {
            CrfGsy.ADYaiT(this, BpkvW3.ASJ6gh((PointerIcon) a5SV6n.f4241AlLFFp));
        }
    }

    private NpX2pY.A2egSU getBadge() {
        return this.f11822B25kr6;
    }

    private NpX2pY.A2egSU getOrCreateBadge() {
        if (this.f11822B25kr6 == null) {
            this.f11822B25kr6 = new NpX2pY.A2egSU(getContext(), null);
        }
        A4TApA();
        NpX2pY.A2egSU a2egSU = this.f11822B25kr6;
        if (a2egSU != null) {
            return a2egSU;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    public final void A2egSU() {
        if (this.f11822B25kr6 != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.f11821AzWtSf;
            if (view != null) {
                NpX2pY.A2egSU a2egSU = this.f11822B25kr6;
                if (a2egSU != null) {
                    if (a2egSU.AMqCpz() != null) {
                        a2egSU.AMqCpz().setForeground(null);
                    } else {
                        view.getOverlay().remove(a2egSU);
                    }
                }
                this.f11821AzWtSf = null;
            }
        }
    }

    public final void A4TApA() {
        TabLayout.A2egSU a2egSU;
        if (this.f11822B25kr6 != null) {
            if (this.f11823B2KMhB != null) {
                A2egSU();
                return;
            }
            ImageView imageView = this.f11820AmA8tU;
            if (imageView != null && (a2egSU = this.f11818AcNBzu) != null && a2egSU.f11890A2egSU != null) {
                if (this.f11821AzWtSf == imageView) {
                    A5SV6n(imageView);
                    return;
                }
                A2egSU();
                ImageView imageView2 = this.f11820AmA8tU;
                if (this.f11822B25kr6 == null || imageView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                NpX2pY.A2egSU a2egSU2 = this.f11822B25kr6;
                Rect rect = new Rect();
                imageView2.getDrawingRect(rect);
                a2egSU2.setBounds(rect);
                a2egSU2.AZkASS(imageView2, null);
                if (a2egSU2.AMqCpz() != null) {
                    a2egSU2.AMqCpz().setForeground(a2egSU2);
                } else {
                    imageView2.getOverlay().add(a2egSU2);
                }
                this.f11821AzWtSf = imageView2;
                return;
            }
            TextView textView = this.f11819AlLFFp;
            if (textView == null || this.f11818AcNBzu == null) {
                A2egSU();
                return;
            }
            if (this.f11821AzWtSf == textView) {
                A5SV6n(textView);
                return;
            }
            A2egSU();
            TextView textView2 = this.f11819AlLFFp;
            if (this.f11822B25kr6 == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) getParent();
            if (viewGroup2 != null) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
            }
            NpX2pY.A2egSU a2egSU3 = this.f11822B25kr6;
            Rect rect2 = new Rect();
            textView2.getDrawingRect(rect2);
            a2egSU3.setBounds(rect2);
            a2egSU3.AZkASS(textView2, null);
            if (a2egSU3.AMqCpz() != null) {
                a2egSU3.AMqCpz().setForeground(a2egSU3);
            } else {
                textView2.getOverlay().add(a2egSU3);
            }
            this.f11821AzWtSf = textView2;
        }
    }

    public final void A5SV6n(View view) {
        NpX2pY.A2egSU a2egSU = this.f11822B25kr6;
        if (a2egSU == null || view != this.f11821AzWtSf) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        a2egSU.setBounds(rect);
        a2egSU.AZkASS(view, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.drawable.RippleDrawable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, com.google.android.material.tabs.ADYaiT] */
    public final void ADYaiT(Context context) {
        TabLayout tabLayout = this.f11828BChYOn;
        int i = tabLayout.BpkvW3;
        if (i != 0) {
            Drawable CQhlFr2 = AlLFFp.CQhlFr(context, i);
            this.f11826B7CMnp = CQhlFr2;
            if (CQhlFr2 != null && CQhlFr2.isStateful()) {
                this.f11826B7CMnp.setState(getDrawableState());
            }
        } else {
            this.f11826B7CMnp = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        if (tabLayout.f11855BJ7GGh != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList A2egSU2 = P5yM7D.A4TApA.A2egSU(tabLayout.f11855BJ7GGh);
            boolean z = tabLayout.f11875CqNSpT;
            if (z) {
                gradientDrawable = null;
            }
            gradientDrawable = new RippleDrawable(A2egSU2, gradientDrawable, z ? null : gradientDrawable2);
        }
        setBackground(gradientDrawable);
        tabLayout.invalidate();
    }

    public final void AMqCpz() {
        int i;
        ViewParent parent;
        TabLayout.A2egSU a2egSU = this.f11818AcNBzu;
        View view = a2egSU != null ? a2egSU.AMqCpz : null;
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.f11823B2KMhB;
                if (view2 != null && (parent = view2.getParent()) != null) {
                    ((ViewGroup) parent).removeView(this.f11823B2KMhB);
                }
                addView(view);
            }
            this.f11823B2KMhB = view;
            TextView textView = this.f11819AlLFFp;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.f11820AmA8tU;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.f11820AmA8tU.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.f11824B3GDIM = textView2;
            if (textView2 != null) {
                this.f11827B9tovu = textView2.getMaxLines();
            }
            this.f11825B4ZgIw = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view3 = this.f11823B2KMhB;
            if (view3 != null) {
                removeView(view3);
                this.f11823B2KMhB = null;
            }
            this.f11824B3GDIM = null;
            this.f11825B4ZgIw = null;
        }
        if (this.f11823B2KMhB == null) {
            if (this.f11820AmA8tU == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(2131492937, (ViewGroup) this, false);
                this.f11820AmA8tU = imageView2;
                addView(imageView2, 0);
            }
            if (this.f11819AlLFFp == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(2131492938, (ViewGroup) this, false);
                this.f11819AlLFFp = textView3;
                addView(textView3);
                this.f11827B9tovu = this.f11819AlLFFp.getMaxLines();
            }
            TextView textView4 = this.f11819AlLFFp;
            TabLayout tabLayout = this.f11828BChYOn;
            JrXYwF.A4TApA.DRlcZ9(textView4, tabLayout.f11850B7CMnp);
            if (!isSelected() || (i = tabLayout.f11852BChYOn) == -1) {
                JrXYwF.A4TApA.DRlcZ9(this.f11819AlLFFp, tabLayout.f11851B9tovu);
            } else {
                JrXYwF.A4TApA.DRlcZ9(this.f11819AlLFFp, i);
            }
            ColorStateList colorStateList = tabLayout.f11853BI9f7h;
            if (colorStateList != null) {
                this.f11819AlLFFp.setTextColor(colorStateList);
            }
            ARc23Z(this.f11819AlLFFp, this.f11820AmA8tU, true);
            A4TApA();
            ImageView imageView3 = this.f11820AmA8tU;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new PWIgQJ.ADYaiT(this, imageView3));
            }
            TextView textView5 = this.f11819AlLFFp;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new PWIgQJ.ADYaiT(this, textView5));
            }
        } else {
            TextView textView6 = this.f11824B3GDIM;
            if (textView6 != null || this.f11825B4ZgIw != null) {
                ARc23Z(textView6, this.f11825B4ZgIw, false);
            }
        }
        if (a2egSU == null || TextUtils.isEmpty(a2egSU.f11892A5SV6n)) {
            return;
        }
        setContentDescription(a2egSU.f11892A5SV6n);
    }

    public final void ARc23Z(TextView textView, ImageView imageView, boolean z) {
        boolean z2;
        Drawable drawable;
        TabLayout.A2egSU a2egSU = this.f11818AcNBzu;
        Drawable mutate = (a2egSU == null || (drawable = a2egSU.f11890A2egSU) == null) ? null : com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
        TabLayout tabLayout = this.f11828BChYOn;
        if (mutate != null) {
            mutate.setTintList(tabLayout.f11854BIYEnU);
            PorterDuff.Mode mode = tabLayout.f11858BTvldC;
            if (mode != null) {
                mutate.setTintMode(mode);
            }
        }
        TabLayout.A2egSU a2egSU2 = this.f11818AcNBzu;
        CharSequence charSequence = a2egSU2 != null ? a2egSU2.f11891A4TApA : null;
        if (imageView != null) {
            if (mutate != null) {
                imageView.setImageDrawable(mutate);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (isEmpty) {
                z2 = false;
            } else {
                this.f11818AcNBzu.getClass();
                z2 = true;
            }
            textView.setText(!isEmpty ? charSequence : null);
            textView.setVisibility(z2 ? 0 : 8);
            if (!isEmpty) {
                setVisibility(0);
            }
        } else {
            z2 = false;
        }
        if (z && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int AYUAbz2 = (z2 && imageView.getVisibility() == 0) ? (int) C4FrIb.AYUAbz(getContext(), 8) : 0;
            if (tabLayout.f11871Cd8JRx) {
                if (AYUAbz2 != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(AYUAbz2);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (AYUAbz2 != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = AYUAbz2;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        TabLayout.A2egSU a2egSU3 = this.f11818AcNBzu;
        CharSequence charSequence2 = a2egSU3 != null ? a2egSU3.f11892A5SV6n : null;
        if (Build.VERSION.SDK_INT > 23) {
            if (isEmpty) {
                charSequence = charSequence2;
            }
            JrXYwF.A4TApA.DV2E8K(this, charSequence);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f11826B7CMnp;
        if ((drawable == null || !drawable.isStateful()) ? false : this.f11826B7CMnp.setState(drawableState)) {
            invalidate();
            this.f11828BChYOn.invalidate();
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.f11819AlLFFp, this.f11820AmA8tU, this.f11823B2KMhB};
        int i = 0;
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < 3; i3++) {
            View view = viewArr[i3];
            if (view != null && view.getVisibility() == 0) {
                i2 = z ? Math.min(i2, view.getTop()) : view.getTop();
                i = z ? Math.max(i, view.getBottom()) : view.getBottom();
                z = true;
            }
        }
        return i - i2;
    }

    public int getContentWidth() {
        View[] viewArr = {this.f11819AlLFFp, this.f11820AmA8tU, this.f11823B2KMhB};
        int i = 0;
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < 3; i3++) {
            View view = viewArr[i3];
            if (view != null && view.getVisibility() == 0) {
                i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                i = z ? Math.max(i, view.getRight()) : view.getRight();
                z = true;
            }
        }
        return i - i2;
    }

    public TabLayout.A2egSU getTab() {
        return this.f11818AcNBzu;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        NpX2pY.A2egSU a2egSU = this.f11822B25kr6;
        if (a2egSU != null && a2egSU.isVisible()) {
            accessibilityNodeInfo.setContentDescription(this.f11822B25kr6.ADYaiT());
        }
        accessibilityNodeInfo.setCollectionItemInfo(CQhlFr.ASJ6gh.A2egSU(0, 1, this.f11818AcNBzu.f11893ADYaiT, 1, false, isSelected()).f1771A2egSU);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) CQhlFr.A5SV6n.f1758ASJ6gh.f1767A2egSU);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(2131886389));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.f11828BChYOn;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.f11862C2rE4F, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f11819AlLFFp != null) {
            float f = tabLayout.f11859BV3sI0;
            if (isSelected() && tabLayout.f11852BChYOn != -1) {
                f = tabLayout.f11860BmvVmW;
            }
            int i3 = this.f11827B9tovu;
            ImageView imageView = this.f11820AmA8tU;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.f11819AlLFFp;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.f11861BniPrB;
                }
            } else {
                i3 = 1;
            }
            float textSize = this.f11819AlLFFp.getTextSize();
            int lineCount = this.f11819AlLFFp.getLineCount();
            int maxLines = this.f11819AlLFFp.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                if (tabLayout.f11870CcAIMM == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.f11819AlLFFp.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.f11819AlLFFp.setTextSize(0, f);
                this.f11819AlLFFp.setMaxLines(i3);
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (this.f11818AcNBzu == null) {
            return performClick;
        }
        if (!performClick) {
            playSoundEffect(0);
        }
        TabLayout.A2egSU a2egSU = this.f11818AcNBzu;
        TabLayout tabLayout = a2egSU.f11894ARc23Z;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.AzWtSf(a2egSU, true);
        return true;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        isSelected();
        super.setSelected(z);
        TextView textView = this.f11819AlLFFp;
        if (textView != null) {
            textView.setSelected(z);
        }
        ImageView imageView = this.f11820AmA8tU;
        if (imageView != null) {
            imageView.setSelected(z);
        }
        View view = this.f11823B2KMhB;
        if (view != null) {
            view.setSelected(z);
        }
    }

    public void setTab(TabLayout.A2egSU a2egSU) {
        if (a2egSU != this.f11818AcNBzu) {
            this.f11818AcNBzu = a2egSU;
            update();
        }
    }

    public final void update() {
        boolean z;
        AMqCpz();
        TabLayout.A2egSU a2egSU = this.f11818AcNBzu;
        if (a2egSU != null) {
            TabLayout tabLayout = a2egSU.f11894ARc23Z;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            if (selectedTabPosition != -1 && selectedTabPosition == a2egSU.f11893ADYaiT) {
                z = true;
                setSelected(z);
            }
        }
        z = false;
        setSelected(z);
    }
}
