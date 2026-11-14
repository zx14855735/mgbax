package DRlcZ9;

import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.R$styleable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B4ZgIw extends Fragment implements BJ7GGh, BIYEnU, A4TApA {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BNL6CD f2105AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public RecyclerView f2106AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f2107AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f2108B25kr6;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B3GDIM f2104AcNBzu = new B3GDIM(this);

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f2109B2KMhB = 2131493294;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final DG07BK.A2egSU f2110B3GDIM = new DG07BK.A2egSU(this, Looper.getMainLooper(), 1);

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final D8MqeW f2111B4ZgIw = new D8MqeW(9, this);

    @Override // DRlcZ9.BJ7GGh
    public boolean A5SV6n(Preference preference) {
        if (preference.f9090BJ7GGh == null) {
            return false;
        }
        for (Fragment fragment = this; fragment != null; fragment = fragment.getParentFragment()) {
        }
        getContext();
        getActivity();
        CtxOCS parentFragmentManager = getParentFragmentManager();
        if (preference.f9091BNL6CD == null) {
            preference.f9091BNL6CD = new Bundle();
        }
        Bundle bundle = preference.f9091BNL6CD;
        Fragment A2egSU2 = parentFragmentManager.BpkvW3().A2egSU(requireActivity().getClassLoader(), preference.f9090BJ7GGh);
        A2egSU2.setArguments(bundle);
        A2egSU2.setTargetFragment(this, 0);
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(parentFragmentManager);
        a2egSU.AlLFFp(((View) requireView().getParent()).getId(), A2egSU2, null);
        if (!a2egSU.f8923AYUAbz) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        a2egSU.f8922ASJ6gh = true;
        a2egSU.f8924AZOQYO = null;
        a2egSU.B2KMhB(false);
        return true;
    }

    @Override // DRlcZ9.BIYEnU
    public void ADYaiT(DialogPreference dialogPreference) {
        androidx.fragment.app.B4ZgIw aaHO0E;
        for (Fragment fragment = this; fragment != null; fragment = fragment.getParentFragment()) {
        }
        getContext();
        getActivity();
        if (getParentFragmentManager().BTvldC("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (dialogPreference instanceof EditTextPreference) {
            String str = dialogPreference.f9088BI9f7h;
            aaHO0E = new ADYaiT();
            Bundle bundle = new Bundle(1);
            bundle.putString("key", str);
            aaHO0E.setArguments(bundle);
        } else if (dialogPreference instanceof ListPreference) {
            String str2 = dialogPreference.f9088BI9f7h;
            aaHO0E = new AYUAbz();
            Bundle bundle2 = new Bundle(1);
            bundle2.putString("key", str2);
            aaHO0E.setArguments(bundle2);
        } else {
            if (!(dialogPreference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + dialogPreference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            String str3 = dialogPreference.f9088BI9f7h;
            aaHO0E = new AaHO0E();
            Bundle bundle3 = new Bundle(1);
            bundle3.putString("key", str3);
            aaHO0E.setArguments(bundle3);
        }
        aaHO0E.setTargetFragment(this, 0);
        aaHO0E.show(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }

    public final Preference AZkASS(String str) {
        PreferenceScreen preferenceScreen;
        BNL6CD bnl6cd = this.f2105AlLFFp;
        if (bnl6cd == null || (preferenceScreen = bnl6cd.f2132ASJ6gh) == null) {
            return null;
        }
        return preferenceScreen.BniPrB(str);
    }

    public RecyclerView.A2egSU AcNBzu(PreferenceScreen preferenceScreen) {
        return new BChYOn(preferenceScreen);
    }

    public abstract void AlLFFp(String str);

    public final void AmA8tU(PreferenceScreen preferenceScreen) {
        BNL6CD bnl6cd = this.f2105AlLFFp;
        PreferenceScreen preferenceScreen2 = bnl6cd.f2132ASJ6gh;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.AzWtSf();
            }
            bnl6cd.f2132ASJ6gh = preferenceScreen;
            if (preferenceScreen != null) {
                this.f2107AzWtSf = true;
                if (this.f2108B25kr6) {
                    DG07BK.A2egSU a2egSU = this.f2110B3GDIM;
                    if (a2egSU.hasMessages(1)) {
                        return;
                    }
                    a2egSU.obtainMessage(1).sendToTarget();
                }
            }
        }
    }

    public final void AzWtSf(int i, String str) {
        BNL6CD bnl6cd = this.f2105AlLFFp;
        if (bnl6cd == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        Context requireContext = requireContext();
        bnl6cd.AMqCpz = true;
        BI9f7h bI9f7h = new BI9f7h(requireContext, bnl6cd);
        XmlResourceParser xml = bI9f7h.getContext().getResources().getXml(i);
        try {
            PreferenceGroup A5SV6n2 = bI9f7h.A5SV6n(xml);
            xml.close();
            PreferenceScreen preferenceScreen = (PreferenceScreen) A5SV6n2;
            preferenceScreen.AcNBzu(bnl6cd);
            SharedPreferences.Editor editor = bnl6cd.f2130ADYaiT;
            if (editor != null) {
                editor.apply();
            }
            bnl6cd.AMqCpz = false;
            PreferenceScreen preferenceScreen2 = preferenceScreen;
            if (str != null) {
                Preference BniPrB2 = preferenceScreen.BniPrB(str);
                boolean z = BniPrB2 instanceof PreferenceScreen;
                preferenceScreen2 = BniPrB2;
                if (!z) {
                    throw new IllegalArgumentException(CtFAbx.BI9f7h("Preference object with key ", str, " is not a PreferenceScreen"));
                }
            }
            AmA8tU(preferenceScreen2);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(2130969759, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = 2131952024;
        }
        requireContext().getTheme().applyStyle(i, false);
        BNL6CD bnl6cd = new BNL6CD(requireContext());
        this.f2105AlLFFp = bnl6cd;
        bnl6cd.f2135AZkASS = this;
        AlLFFp(getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        TypedArray obtainStyledAttributes = requireContext().obtainStyledAttributes(null, R$styleable.f9129AYUAbz, 2130969752, 0);
        this.f2109B2KMhB = obtainStyledAttributes.getResourceId(0, this.f2109B2KMhB);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(requireContext());
        View inflate = cloneInContext.inflate(this.f2109B2KMhB, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.list_container);
        if (!(findViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        if (!requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup2.findViewById(2131297796)) == null) {
            recyclerView = (RecyclerView) cloneInContext.inflate(2131493296, viewGroup2, false);
            requireContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAccessibilityDelegateCompat(new BTvldC(recyclerView));
        }
        this.f2106AmA8tU = recyclerView;
        B3GDIM b3gdim = this.f2104AcNBzu;
        recyclerView.addItemDecoration(b3gdim);
        if (drawable != null) {
            b3gdim.getClass();
            b3gdim.f2101A4TApA = drawable.getIntrinsicHeight();
        } else {
            b3gdim.f2101A4TApA = 0;
        }
        b3gdim.f2100A2egSU = drawable;
        B4ZgIw b4ZgIw = b3gdim.f2103ADYaiT;
        b4ZgIw.f2106AmA8tU.invalidateItemDecorations();
        if (dimensionPixelSize != -1) {
            b3gdim.f2101A4TApA = dimensionPixelSize;
            b4ZgIw.f2106AmA8tU.invalidateItemDecorations();
        }
        b3gdim.f2102A5SV6n = z;
        if (this.f2106AmA8tU.getParent() == null) {
            viewGroup2.addView(this.f2106AmA8tU);
        }
        this.f2110B3GDIM.post(this.f2111B4ZgIw);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        D8MqeW d8MqeW = this.f2111B4ZgIw;
        DG07BK.A2egSU a2egSU = this.f2110B3GDIM;
        a2egSU.removeCallbacks(d8MqeW);
        a2egSU.removeMessages(1);
        if (this.f2107AzWtSf) {
            this.f2106AmA8tU.setAdapter(null);
            PreferenceScreen preferenceScreen = this.f2105AlLFFp.f2132ASJ6gh;
            if (preferenceScreen != null) {
                preferenceScreen.AzWtSf();
            }
        }
        this.f2106AmA8tU = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = this.f2105AlLFFp.f2132ASJ6gh;
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.A5SV6n(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        BNL6CD bnl6cd = this.f2105AlLFFp;
        bnl6cd.f2133AYUAbz = this;
        bnl6cd.f2134AZOQYO = this;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        BNL6CD bnl6cd = this.f2105AlLFFp;
        bnl6cd.f2133AYUAbz = null;
        bnl6cd.f2134AZOQYO = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        PreferenceScreen preferenceScreen;
        Bundle bundle2;
        PreferenceScreen preferenceScreen2;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreen2 = this.f2105AlLFFp.f2132ASJ6gh) != null) {
            preferenceScreen2.A4TApA(bundle2);
        }
        if (this.f2107AzWtSf && (preferenceScreen = this.f2105AlLFFp.f2132ASJ6gh) != null) {
            this.f2106AmA8tU.setAdapter(AcNBzu(preferenceScreen));
            preferenceScreen.AaHO0E();
        }
        this.f2108B25kr6 = true;
    }
}
