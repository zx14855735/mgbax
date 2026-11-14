package androidx.appcompat.view.menu;

import AZkASS.B25kr6;
import AZkASS.BPw6Q8;
import AaHO0E.GYpKKt;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ListMenuItemView extends LinearLayout implements BPw6Q8, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public B25kr6 f8060AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ImageView f8061AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public RadioButton f8062AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public TextView f8063AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public CheckBox f8064B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public TextView f8065B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ImageView f8066B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ImageView f8067B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public LinearLayout f8068B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Drawable f8069B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f8070BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Context f8071BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f8072BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final Drawable f8073BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final boolean f8074BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public LayoutInflater f8075BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f8076BTvldC;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(getContext(), attributeSet, R$styleable.f8031B4ZgIw, 2130969506);
        this.f8069B9tovu = ARc23Z2.A4TApA(5);
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        this.f8070BChYOn = typedArray.getResourceId(1, -1);
        this.f8072BIYEnU = typedArray.getBoolean(7, false);
        this.f8071BI9f7h = context;
        this.f8073BJ7GGh = ARc23Z2.A4TApA(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, 2130969043, 0);
        this.f8074BNL6CD = obtainStyledAttributes.hasValue(0);
        ARc23Z2.ASJ6gh();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f8075BPw6Q8 == null) {
            this.f8075BPw6Q8 = LayoutInflater.from(getContext());
        }
        return this.f8075BPw6Q8;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f8066B3GDIM;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    @Override // AZkASS.BPw6Q8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU(AZkASS.B25kr6 r11) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.A2egSU(AZkASS.B25kr6):void");
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f8067B4ZgIw;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8067B4ZgIw.getLayoutParams();
        rect.top = this.f8067B4ZgIw.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // AZkASS.BPw6Q8
    public B25kr6 getItemData() {
        return this.f8060AcNBzu;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f8069B9tovu);
        TextView textView = (TextView) findViewById(2131298106);
        this.f8063AzWtSf = textView;
        int i = this.f8070BChYOn;
        if (i != -1) {
            textView.setTextAppearance(this.f8071BI9f7h, i);
        }
        this.f8065B2KMhB = (TextView) findViewById(2131297915);
        ImageView imageView = (ImageView) findViewById(2131298032);
        this.f8066B3GDIM = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f8073BJ7GGh);
        }
        this.f8067B4ZgIw = (ImageView) findViewById(2131296710);
        this.f8068B7CMnp = (LinearLayout) findViewById(2131296525);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.f8061AlLFFp != null && this.f8072BIYEnU) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f8061AlLFFp.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.f8062AmA8tU == null && this.f8064B25kr6 == null) {
            return;
        }
        if ((this.f8060AcNBzu.f542CASmeH & 4) != 0) {
            if (this.f8062AmA8tU == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(2131492883, (ViewGroup) this, false);
                this.f8062AmA8tU = radioButton;
                LinearLayout linearLayout = this.f8068B7CMnp;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f8062AmA8tU;
            view = this.f8064B25kr6;
        } else {
            if (this.f8064B25kr6 == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(2131492880, (ViewGroup) this, false);
                this.f8064B25kr6 = checkBox;
                LinearLayout linearLayout2 = this.f8068B7CMnp;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f8064B25kr6;
            view = this.f8062AmA8tU;
        }
        if (z) {
            compoundButton.setChecked(this.f8060AcNBzu.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f8064B25kr6;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f8062AmA8tU;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f8060AcNBzu.f542CASmeH & 4) != 0) {
            if (this.f8062AmA8tU == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(2131492883, (ViewGroup) this, false);
                this.f8062AmA8tU = radioButton;
                LinearLayout linearLayout = this.f8068B7CMnp;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f8062AmA8tU;
        } else {
            if (this.f8064B25kr6 == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(2131492880, (ViewGroup) this, false);
                this.f8064B25kr6 = checkBox;
                LinearLayout linearLayout2 = this.f8068B7CMnp;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f8064B25kr6;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f8076BTvldC = z;
        this.f8072BIYEnU = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f8067B4ZgIw;
        if (imageView != null) {
            imageView.setVisibility((this.f8074BNL6CD || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f8060AcNBzu.f533BJ7GGh.f511BmvVmW || this.f8076BTvldC;
        if (z || this.f8072BIYEnU) {
            ImageView imageView = this.f8061AlLFFp;
            if (imageView == null && drawable == null && !this.f8072BIYEnU) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(2131492881, (ViewGroup) this, false);
                this.f8061AlLFFp = imageView2;
                LinearLayout linearLayout = this.f8068B7CMnp;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f8072BIYEnU) {
                this.f8061AlLFFp.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f8061AlLFFp;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f8061AlLFFp.getVisibility() != 0) {
                this.f8061AlLFFp.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f8063AzWtSf.getVisibility() != 8) {
                this.f8063AzWtSf.setVisibility(8);
            }
        } else {
            this.f8063AzWtSf.setText(charSequence);
            if (this.f8063AzWtSf.getVisibility() != 0) {
                this.f8063AzWtSf.setVisibility(0);
            }
        }
    }
}
