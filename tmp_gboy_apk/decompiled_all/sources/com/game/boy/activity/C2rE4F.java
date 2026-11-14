package com.game.boy.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class C2rE4F extends BaseAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f10935A2egSU = new ArrayList();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Resources f10936A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final LayoutInflater f10937A5SV6n;

    public C2rE4F(LayoutEditor layoutEditor, LayoutEditor layoutEditor2) {
        this.f10936A4TApA = layoutEditor2.getResources();
        this.f10937A5SV6n = (LayoutInflater) layoutEditor2.getSystemService("layout_inflater");
        HashSet hashSet = new HashSet();
        Iterator<MkAsKS.ADYaiT> it = layoutEditor.f11057B3GDIM.getAllItems().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().f5435ADYaiT.toString());
        }
        int i = 0;
        while (true) {
            String[] strArr = LayoutEditor.f11053BI9f7h;
            if (i >= 21) {
                return;
            }
            if (!hashSet.contains(strArr[i])) {
                this.f10935A2egSU.add(Integer.valueOf(i));
            }
            i++;
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f10935A2egSU.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return LayoutEditor.f11053BI9f7h[((Integer) this.f10935A2egSU.get(i)).intValue()];
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return ((Integer) this.f10935A2egSU.get(i)).intValue();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (textView == null) {
            textView = (TextView) this.f10937A5SV6n.inflate(2131492908, viewGroup, false);
        }
        int intValue = ((Integer) this.f10935A2egSU.get(i)).intValue();
        textView.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.f10936A4TApA, (Bitmap) LayoutEditor.f11052BChYOn.get(LayoutEditor.f11053BI9f7h[intValue])), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText(LayoutEditor.f11054BIYEnU[intValue]);
        return textView;
    }
}
