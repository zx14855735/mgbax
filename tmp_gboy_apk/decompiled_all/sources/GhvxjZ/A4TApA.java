package GhvxjZ;

import NOd7IU.AlLFFp;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends Dialog {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public FrameLayout f3076AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public TextView f3077AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public TextView f3078AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public String f3079AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public String f3080B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public View.OnClickListener f3081B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public View.OnClickListener f3082B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final /* synthetic */ int f3083B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public TextView f3084B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public String f3085B9tovu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A4TApA(Context context, int i) {
        super(context, 2131952952);
        this.f3083B4ZgIw = i;
        this.f3076AcNBzu = null;
        this.f3077AlLFFp = null;
        this.f3078AmA8tU = null;
        this.f3079AzWtSf = null;
        this.f3080B25kr6 = null;
        this.f3081B2KMhB = null;
        this.f3082B3GDIM = null;
    }

    public final void A2egSU(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131493184);
        this.f3076AcNBzu = (FrameLayout) findViewById(2131296676);
        this.f3077AlLFFp = (TextView) findViewById(2131298194);
        this.f3078AmA8tU = (TextView) findViewById(2131298195);
        setCancelable(false);
        if (!TextUtils.isEmpty(this.f3080B25kr6)) {
            this.f3077AlLFFp.setText(this.f3080B25kr6);
        }
        if (!TextUtils.isEmpty(this.f3079AzWtSf)) {
            this.f3078AmA8tU.setText(this.f3079AzWtSf);
        }
        this.f3077AlLFFp.setOnClickListener(new A2egSU(this, 0));
        this.f3078AmA8tU.setOnClickListener(new A2egSU(this, 1));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        switch (this.f3083B4ZgIw) {
            case 0:
                A2egSU(bundle);
                View inflate = LayoutInflater.from(getContext()).inflate(2131493186, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(2131298198);
                this.f3084B7CMnp = textView;
                if (textView != null && !TextUtils.isEmpty(this.f3085B9tovu)) {
                    this.f3084B7CMnp.setText(this.f3085B9tovu);
                }
                FrameLayout frameLayout = this.f3076AcNBzu;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                    this.f3076AcNBzu.addView(inflate);
                    break;
                }
                break;
            default:
                A2egSU(bundle);
                View inflate2 = LayoutInflater.from(getContext()).inflate(2131493187, (ViewGroup) null, false);
                TextView textView2 = (TextView) inflate2.findViewById(2131298221);
                this.f3084B7CMnp = textView2;
                if (textView2 != null && !TextUtils.isEmpty(this.f3085B9tovu)) {
                    this.f3084B7CMnp.setText(this.f3085B9tovu);
                }
                FrameLayout frameLayout2 = this.f3076AcNBzu;
                if (frameLayout2 != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout2.getLayoutParams();
                    layoutParams.height = AlLFFp.AMqCpz(getContext(), 137.0f);
                    this.f3076AcNBzu.setLayoutParams(layoutParams);
                    this.f3076AcNBzu.removeAllViews();
                    this.f3076AcNBzu.addView(inflate2);
                    break;
                }
                break;
        }
    }
}
