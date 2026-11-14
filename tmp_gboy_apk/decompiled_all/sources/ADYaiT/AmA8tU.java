package ADYaiT;

import AaHO0E.EmJGcg;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU extends CqNSpT implements DialogInterface {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final AcNBzu f83B2KMhB;

    public AmA8tU(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, ASJ6gh(contextThemeWrapper, i));
        this.f83B2KMhB = new AcNBzu(getContext(), this, getWindow());
    }

    public static int ASJ6gh(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130968624, typedValue, true);
        return typedValue.resourceId;
    }

    public final Button ARc23Z(int i) {
        AcNBzu acNBzu = this.f83B2KMhB;
        if (i == -3) {
            return acNBzu.f62AzWtSf;
        }
        if (i == -2) {
            return acNBzu.f59AcNBzu;
        }
        if (i == -1) {
            return acNBzu.f56AZOQYO;
        }
        acNBzu.getClass();
        return null;
    }

    @Override // ADYaiT.CqNSpT, androidx.activity.AcNBzu, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View findViewById;
        int i2 = 0;
        super.onCreate(bundle);
        AcNBzu acNBzu = this.f83B2KMhB;
        acNBzu.f50A4TApA.setContentView(acNBzu.f74BPw6Q8);
        Window window = acNBzu.f51A5SV6n;
        View findViewById2 = window.findViewById(2131297750);
        View findViewById3 = findViewById2.findViewById(2131298115);
        View findViewById4 = findViewById2.findViewById(2131296526);
        View findViewById5 = findViewById2.findViewById(2131296455);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(2131296545);
        View view = acNBzu.f54ASJ6gh;
        if (view == null) {
            view = null;
        }
        boolean z = view != null;
        if (!z || !AcNBzu.A2egSU(view)) {
            window.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(2131296544);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (acNBzu.f55AYUAbz) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (acNBzu.f53ARc23Z != null) {
                ((LinearLayout.LayoutParams) ((EmJGcg) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(2131298115);
        View findViewById7 = viewGroup.findViewById(2131296526);
        View findViewById8 = viewGroup.findViewById(2131296455);
        ViewGroup A5SV6n2 = AcNBzu.A5SV6n(findViewById6, findViewById3);
        ViewGroup A5SV6n3 = AcNBzu.A5SV6n(findViewById7, findViewById4);
        ViewGroup A5SV6n4 = AcNBzu.A5SV6n(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(2131297887);
        acNBzu.f65B3GDIM = nestedScrollView;
        nestedScrollView.setFocusable(false);
        acNBzu.f65B3GDIM.setNestedScrollingEnabled(false);
        TextView textView = (TextView) A5SV6n3.findViewById(R.id.message);
        acNBzu.f70BI9f7h = textView;
        if (textView != null) {
            CharSequence charSequence = acNBzu.AMqCpz;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                acNBzu.f65B3GDIM.removeView(acNBzu.f70BI9f7h);
                if (acNBzu.f53ARc23Z != null) {
                    ViewGroup viewGroup2 = (ViewGroup) acNBzu.f65B3GDIM.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(acNBzu.f65B3GDIM);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(acNBzu.f53ARc23Z, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    A5SV6n3.setVisibility(8);
                }
            }
        }
        Button button = (Button) A5SV6n4.findViewById(R.id.button1);
        acNBzu.f56AZOQYO = button;
        A5SV6n a5SV6n = acNBzu.f80C4FrIb;
        button.setOnClickListener(a5SV6n);
        if (TextUtils.isEmpty(acNBzu.f57AZkASS)) {
            acNBzu.f56AZOQYO.setVisibility(8);
            i = 0;
        } else {
            acNBzu.f56AZOQYO.setText(acNBzu.f57AZkASS);
            acNBzu.f56AZOQYO.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) A5SV6n4.findViewById(R.id.button2);
        acNBzu.f59AcNBzu = button2;
        button2.setOnClickListener(a5SV6n);
        if (TextUtils.isEmpty(acNBzu.f60AlLFFp)) {
            acNBzu.f59AcNBzu.setVisibility(8);
        } else {
            acNBzu.f59AcNBzu.setText(acNBzu.f60AlLFFp);
            acNBzu.f59AcNBzu.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) A5SV6n4.findViewById(R.id.button3);
        acNBzu.f62AzWtSf = button3;
        button3.setOnClickListener(a5SV6n);
        if (TextUtils.isEmpty(acNBzu.f63B25kr6)) {
            acNBzu.f62AzWtSf.setVisibility(8);
        } else {
            acNBzu.f62AzWtSf.setText(acNBzu.f63B25kr6);
            acNBzu.f62AzWtSf.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        acNBzu.f49A2egSU.getTheme().resolveAttribute(2130968622, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = acNBzu.f56AZOQYO;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = acNBzu.f59AcNBzu;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = acNBzu.f62AzWtSf;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            A5SV6n4.setVisibility(8);
        }
        if (acNBzu.f71BIYEnU != null) {
            A5SV6n2.addView(acNBzu.f71BIYEnU, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(2131298110).setVisibility(8);
        } else {
            acNBzu.f68B9tovu = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(acNBzu.f52ADYaiT) || !acNBzu.BpkvW3) {
                window.findViewById(2131298110).setVisibility(8);
                acNBzu.f68B9tovu.setVisibility(8);
                A5SV6n2.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(2131296370);
                acNBzu.f69BChYOn = textView2;
                textView2.setText(acNBzu.f52ADYaiT);
                int i3 = acNBzu.f66B4ZgIw;
                if (i3 != 0) {
                    acNBzu.f68B9tovu.setImageResource(i3);
                } else {
                    Drawable drawable = acNBzu.f67B7CMnp;
                    if (drawable != null) {
                        acNBzu.f68B9tovu.setImageDrawable(drawable);
                    } else {
                        acNBzu.f69BChYOn.setPadding(acNBzu.f68B9tovu.getPaddingLeft(), acNBzu.f68B9tovu.getPaddingTop(), acNBzu.f68B9tovu.getPaddingRight(), acNBzu.f68B9tovu.getPaddingBottom());
                        acNBzu.f68B9tovu.setVisibility(8);
                    }
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i4 = (A5SV6n2 == null || A5SV6n2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = A5SV6n4.getVisibility() != 8;
        if (!z3 && (findViewById = A5SV6n3.findViewById(2131298074)) != null) {
            findViewById.setVisibility(0);
        }
        if (i4 != 0) {
            NestedScrollView nestedScrollView2 = acNBzu.f65B3GDIM;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById9 = (acNBzu.AMqCpz == null && acNBzu.f53ARc23Z == null) ? null : A5SV6n2.findViewById(2131298107);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        } else {
            View findViewById10 = A5SV6n3.findViewById(2131298075);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = acNBzu.f53ARc23Z;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z3 || i4 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i4 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f8041AcNBzu, alertController$RecycleListView.getPaddingRight(), z3 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f8042AlLFFp);
            }
        }
        if (!z2) {
            View view2 = acNBzu.f53ARc23Z;
            if (view2 == null) {
                view2 = acNBzu.f65B3GDIM;
            }
            if (view2 != null) {
                int i5 = i4 | (z3 ? 2 : 0);
                View findViewById11 = window.findViewById(2131297886);
                View findViewById12 = window.findViewById(2131297885);
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 23) {
                    WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                    if (i6 >= 23) {
                        COJEAR.CqNSpT.ADYaiT(view2, i5, 3);
                    }
                    if (findViewById11 != null) {
                        A5SV6n3.removeView(findViewById11);
                    }
                    if (findViewById12 != null) {
                        A5SV6n3.removeView(findViewById12);
                    }
                } else {
                    if (findViewById11 != null && (i5 & 1) == 0) {
                        A5SV6n3.removeView(findViewById11);
                        findViewById11 = null;
                    }
                    if (findViewById12 != null && (i5 & 2) == 0) {
                        A5SV6n3.removeView(findViewById12);
                        findViewById12 = null;
                    }
                    if (findViewById11 != null || findViewById12 != null) {
                        if (acNBzu.AMqCpz != null) {
                            acNBzu.f65B3GDIM.setOnScrollChangeListener(new K1Z3yj.A2egSU(findViewById11, 1, findViewById12));
                            acNBzu.f65B3GDIM.post(new ADYaiT(acNBzu, findViewById11, findViewById12, i2));
                        } else {
                            AlertController$RecycleListView alertController$RecycleListView2 = acNBzu.f53ARc23Z;
                            if (alertController$RecycleListView2 != null) {
                                alertController$RecycleListView2.setOnScrollListener(new AMqCpz(findViewById11, findViewById12));
                                acNBzu.f53ARc23Z.post(new ADYaiT(acNBzu, findViewById11, findViewById12, 1));
                            } else {
                                if (findViewById11 != null) {
                                    A5SV6n3.removeView(findViewById11);
                                }
                                if (findViewById12 != null) {
                                    A5SV6n3.removeView(findViewById12);
                                }
                            }
                        }
                    }
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView3 = acNBzu.f53ARc23Z;
        if (alertController$RecycleListView3 == null || (listAdapter = acNBzu.f72BJ7GGh) == null) {
            return;
        }
        alertController$RecycleListView3.setAdapter(listAdapter);
        int i7 = acNBzu.f73BNL6CD;
        if (i7 > -1) {
            alertController$RecycleListView3.setItemChecked(i7, true);
            alertController$RecycleListView3.setSelection(i7);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f83B2KMhB.f65B3GDIM;
        if (nestedScrollView == null || !nestedScrollView.ADYaiT(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f83B2KMhB.f65B3GDIM;
        if (nestedScrollView == null || !nestedScrollView.ADYaiT(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // ADYaiT.CqNSpT, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AcNBzu acNBzu = this.f83B2KMhB;
        acNBzu.f52ADYaiT = charSequence;
        TextView textView = acNBzu.f69BChYOn;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
