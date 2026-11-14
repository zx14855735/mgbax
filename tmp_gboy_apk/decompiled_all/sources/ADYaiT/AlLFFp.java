package ADYaiT;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AZOQYO f81AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f82AlLFFp;

    public AlLFFp(Context context) {
        this(context, AmA8tU.ASJ6gh(context, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [ADYaiT.AmA8tU, android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r1v29, types: [ADYaiT.ARc23Z] */
    /* JADX WARN: Type inference failed for: r1v34, types: [android.content.DialogInterface$OnKeyListener, java.lang.Object] */
    public AmA8tU A2egSU() {
        ?? r1;
        AZOQYO azoqyo = this.f81AcNBzu;
        ?? amA8tU = new AmA8tU(azoqyo.f23A2egSU, this.f82AlLFFp);
        View view = azoqyo.f27ARc23Z;
        AcNBzu acNBzu = amA8tU.f83B2KMhB;
        if (view != null) {
            acNBzu.f71BIYEnU = view;
        } else {
            CharSequence charSequence = azoqyo.AMqCpz;
            if (charSequence != null) {
                acNBzu.f52ADYaiT = charSequence;
                TextView textView = acNBzu.f69BChYOn;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = azoqyo.f26ADYaiT;
            if (drawable != null) {
                acNBzu.f67B7CMnp = drawable;
                acNBzu.f66B4ZgIw = 0;
                ImageView imageView = acNBzu.f68B9tovu;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    acNBzu.f68B9tovu.setImageDrawable(drawable);
                }
            }
            int i = azoqyo.f25A5SV6n;
            if (i != 0) {
                acNBzu.f67B7CMnp = null;
                acNBzu.f66B4ZgIw = i;
                ImageView imageView2 = acNBzu.f68B9tovu;
                if (imageView2 != null) {
                    if (i != 0) {
                        imageView2.setVisibility(0);
                        acNBzu.f68B9tovu.setImageResource(acNBzu.f66B4ZgIw);
                    } else {
                        imageView2.setVisibility(8);
                    }
                }
            }
        }
        CharSequence charSequence2 = azoqyo.f28ASJ6gh;
        if (charSequence2 != null) {
            acNBzu.AMqCpz = charSequence2;
            TextView textView2 = acNBzu.f70BI9f7h;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = azoqyo.f29AYUAbz;
        if (charSequence3 != null) {
            acNBzu.ADYaiT(-1, charSequence3, azoqyo.f30AZOQYO);
        }
        CharSequence charSequence4 = azoqyo.f31AZkASS;
        if (charSequence4 != null) {
            acNBzu.ADYaiT(-2, charSequence4, azoqyo.f32AaHO0E);
        }
        CharSequence charSequence5 = azoqyo.f33AcNBzu;
        if (charSequence5 != null) {
            acNBzu.ADYaiT(-3, charSequence5, azoqyo.f34AlLFFp);
        }
        if (azoqyo.f38B2KMhB != null || azoqyo.f39B3GDIM != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) azoqyo.f24A4TApA.inflate(acNBzu.f75BTvldC, (ViewGroup) null);
            boolean z = azoqyo.f43BChYOn;
            ContextThemeWrapper contextThemeWrapper = azoqyo.f23A2egSU;
            if (z) {
                r1 = new ARc23Z(azoqyo, contextThemeWrapper, acNBzu.f76BV3sI0, azoqyo.f38B2KMhB, alertController$RecycleListView);
            } else {
                int i2 = azoqyo.f44BI9f7h ? acNBzu.f77BmvVmW : acNBzu.f78BniPrB;
                Object obj = azoqyo.f39B3GDIM;
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = new AaHO0E(contextThemeWrapper, i2, R.id.text1, azoqyo.f38B2KMhB);
                }
                r1 = obj2;
            }
            acNBzu.f72BJ7GGh = r1;
            acNBzu.f73BNL6CD = azoqyo.f45BIYEnU;
            if (azoqyo.f40B4ZgIw != null) {
                alertController$RecycleListView.setOnItemClickListener(new ASJ6gh(azoqyo, acNBzu));
            } else if (azoqyo.f46BJ7GGh != null) {
                alertController$RecycleListView.setOnItemClickListener(new AYUAbz(azoqyo, alertController$RecycleListView, acNBzu));
            }
            if (azoqyo.f44BI9f7h) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (azoqyo.f43BChYOn) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            acNBzu.f53ARc23Z = alertController$RecycleListView;
        }
        View view2 = azoqyo.f41B7CMnp;
        if (view2 != null) {
            acNBzu.f54ASJ6gh = view2;
            acNBzu.f55AYUAbz = false;
        }
        amA8tU.setCancelable(azoqyo.f35AmA8tU);
        if (azoqyo.f35AmA8tU) {
            amA8tU.setCanceledOnTouchOutside(true);
        }
        amA8tU.setOnCancelListener(null);
        amA8tU.setOnDismissListener(azoqyo.f36AzWtSf);
        ?? r12 = azoqyo.f37B25kr6;
        if (r12 != 0) {
            amA8tU.setOnKeyListener(r12);
        }
        return amA8tU;
    }

    public void A4TApA(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f38B2KMhB = charSequenceArr;
        azoqyo.f46BJ7GGh = onMultiChoiceClickListener;
        azoqyo.f42B9tovu = zArr;
        azoqyo.f43BChYOn = true;
    }

    public void A5SV6n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f29AYUAbz = charSequence;
        azoqyo.f30AZOQYO = onClickListener;
    }

    public void ADYaiT(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f38B2KMhB = charSequenceArr;
        azoqyo.f40B4ZgIw = onClickListener;
        azoqyo.f45BIYEnU = i;
        azoqyo.f44BI9f7h = true;
    }

    public AmA8tU AMqCpz() {
        AmA8tU A2egSU2 = A2egSU();
        A2egSU2.show();
        return A2egSU2;
    }

    public Context getContext() {
        return this.f81AcNBzu.f23A2egSU;
    }

    public AlLFFp(Context context, int i) {
        this.f81AcNBzu = new AZOQYO(new ContextThemeWrapper(context, AmA8tU.ASJ6gh(context, i)));
        this.f82AlLFFp = i;
    }
}
