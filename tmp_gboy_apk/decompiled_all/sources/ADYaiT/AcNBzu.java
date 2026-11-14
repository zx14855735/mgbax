package ADYaiT;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f49A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AmA8tU f50A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Window f51A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public CharSequence f52ADYaiT;
    public CharSequence AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AlertController$RecycleListView f53ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public View f54ASJ6gh;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public Button f56AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public CharSequence f57AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public Message f58AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Button f59AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public CharSequence f60AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Message f61AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Button f62AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public CharSequence f63B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Message f64B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public NestedScrollView f65B3GDIM;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Drawable f67B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public ImageView f68B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public TextView f69BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public TextView f70BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public View f71BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public ListAdapter f72BJ7GGh;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final int f74BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final int f75BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f76BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final int f77BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final int f78BniPrB;
    public final boolean BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final AZkASS f79C2rE4F;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f55AYUAbz = false;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f66B4ZgIw = 0;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f73BNL6CD = -1;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final A5SV6n f80C4FrIb = new A5SV6n(0, this);

    public AcNBzu(Context context, AmA8tU amA8tU, Window window) {
        this.f49A2egSU = context;
        this.f50A4TApA = amA8tU;
        this.f51A5SV6n = window;
        AZkASS aZkASS = new AZkASS();
        aZkASS.f48A4TApA = new WeakReference(amA8tU);
        this.f79C2rE4F = aZkASS;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AMqCpz, 2130968623, 0);
        this.f74BPw6Q8 = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.f75BTvldC = obtainStyledAttributes.getResourceId(4, 0);
        this.f76BV3sI0 = obtainStyledAttributes.getResourceId(5, 0);
        this.f77BmvVmW = obtainStyledAttributes.getResourceId(7, 0);
        this.f78BniPrB = obtainStyledAttributes.getResourceId(3, 0);
        this.BpkvW3 = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        amA8tU.A5SV6n().ARc23Z(1);
    }

    public static boolean A2egSU(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (A2egSU(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void A4TApA(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup A5SV6n(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void ADYaiT(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.f79C2rE4F.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.f63B25kr6 = charSequence;
            this.f64B2KMhB = obtainMessage;
        } else if (i == -2) {
            this.f60AlLFFp = charSequence;
            this.f61AmA8tU = obtainMessage;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f57AZkASS = charSequence;
            this.f58AaHO0E = obtainMessage;
        }
    }
}
