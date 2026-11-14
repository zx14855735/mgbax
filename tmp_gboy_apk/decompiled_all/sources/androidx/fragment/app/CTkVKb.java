package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CTkVKb implements LayoutInflater.Factory2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CtxOCS f8817AcNBzu;

    public CTkVKb(CtxOCS ctxOCS) {
        this.f8817AcNBzu = ctxOCS;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        DUi7mC ARc23Z2;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        CtxOCS ctxOCS = this.f8817AcNBzu;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, ctxOCS);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8700A2egSU);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z = Fragment.class.isAssignableFrom(FragmentFactory.A4TApA(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (z) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment BPw6Q82 = resourceId != -1 ? ctxOCS.BPw6Q8(resourceId) : null;
                    if (BPw6Q82 == null && string != null) {
                        BPw6Q82 = ctxOCS.BTvldC(string);
                    }
                    if (BPw6Q82 == null && id != -1) {
                        BPw6Q82 = ctxOCS.BPw6Q8(id);
                    }
                    if (BPw6Q82 == null) {
                        BPw6Q82 = ctxOCS.BpkvW3().A2egSU(context.getClassLoader(), attributeValue);
                        BPw6Q82.mFromLayout = true;
                        BPw6Q82.mFragmentId = resourceId != 0 ? resourceId : id;
                        BPw6Q82.mContainerId = id;
                        BPw6Q82.mTag = string;
                        BPw6Q82.mInLayout = true;
                        BPw6Q82.mFragmentManager = ctxOCS;
                        CQhlFr cQhlFr = ctxOCS.f8847B7CMnp;
                        BPw6Q82.mHost = cQhlFr;
                        BPw6Q82.onInflate(cQhlFr.getContext(), attributeSet, BPw6Q82.mSavedFragmentState);
                        ARc23Z2 = ctxOCS.A2egSU(BPw6Q82);
                        if (CtxOCS.C4FrIb(2)) {
                            BPw6Q82.toString();
                            Integer.toHexString(resourceId);
                        }
                    } else {
                        if (BPw6Q82.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        BPw6Q82.mInLayout = true;
                        BPw6Q82.mFragmentManager = ctxOCS;
                        CQhlFr cQhlFr2 = ctxOCS.f8847B7CMnp;
                        BPw6Q82.mHost = cQhlFr2;
                        BPw6Q82.onInflate(cQhlFr2.getContext(), attributeSet, BPw6Q82.mSavedFragmentState);
                        ARc23Z2 = ctxOCS.ARc23Z(BPw6Q82);
                        if (CtxOCS.C4FrIb(2)) {
                            BPw6Q82.toString();
                            Integer.toHexString(resourceId);
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
                    D6yqiO.ADYaiT.A4TApA(new D6yqiO.A2egSU(BPw6Q82, "Attempting to use <fragment> tag to add fragment " + BPw6Q82 + " to container " + viewGroup));
                    D6yqiO.ADYaiT.A2egSU(BPw6Q82).getClass();
                    BPw6Q82.mContainer = viewGroup;
                    ARc23Z2.AZOQYO();
                    ARc23Z2.AYUAbz();
                    View view2 = BPw6Q82.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(ADYaiT.CtFAbx.BI9f7h("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (BPw6Q82.mView.getTag() == null) {
                        BPw6Q82.mView.setTag(string);
                    }
                    BPw6Q82.mView.addOnAttachStateChangeListener(new CSDoyG(this, ARc23Z2));
                    return BPw6Q82.mView;
                }
            }
        }
        return null;
    }
}
