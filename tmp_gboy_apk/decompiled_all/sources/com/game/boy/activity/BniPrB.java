package com.game.boy.activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BniPrB implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10927AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ LayoutEditor f10928AlLFFp;

    public /* synthetic */ BniPrB(LayoutEditor layoutEditor, int i) {
        this.f10927AcNBzu = i;
        this.f10928AlLFFp = layoutEditor;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f10927AcNBzu) {
            case 0:
                this.f10928AlLFFp.finish();
                break;
            case 1:
                LayoutEditor layoutEditor = this.f10928AlLFFp;
                layoutEditor.AZOQYO(((Hdahpu.ASJ6gh) layoutEditor.f11056B2KMhB.f3809AmA8tU).A2egSU(layoutEditor.f11057B3GDIM.getWidth(), layoutEditor.f11057B3GDIM.getHeight(), false));
                layoutEditor.f11055B25kr6 = true;
                layoutEditor.f11057B3GDIM.invalidate();
                break;
            case 2:
                LayoutEditor layoutEditor2 = this.f10928AlLFFp;
                layoutEditor2.getClass();
                Iterator it = new ArrayList(layoutEditor2.f11057B3GDIM.getAllItems()).iterator();
                while (it.hasNext()) {
                    MkAsKS.ADYaiT aDYaiT = (MkAsKS.ADYaiT) it.next();
                    if (!"video".equals(aDYaiT.f5435ADYaiT)) {
                        MkAsKS.A2egSU a2egSU = layoutEditor2.f11057B3GDIM;
                        a2egSU.A4TApA(aDYaiT);
                        a2egSU.f5418AcNBzu.remove(aDYaiT);
                        if (a2egSU.f5422B25kr6 == aDYaiT) {
                            a2egSU.f5422B25kr6 = null;
                            a2egSU.f5423B2KMhB = null;
                        }
                    }
                }
                layoutEditor2.f11055B25kr6 = true;
                break;
            default:
                String obj = ((ADYaiT.AmA8tU) dialogInterface).f83B2KMhB.f53ARc23Z.getItemAtPosition(i).toString();
                LayoutEditor layoutEditor3 = this.f10928AlLFFp;
                float f = layoutEditor3.f11058B4ZgIw.density * 0.45f;
                Bitmap bitmap = (Bitmap) LayoutEditor.f11052BChYOn.get(obj);
                int width = (int) (bitmap.getWidth() * f);
                int height = (int) (bitmap.getHeight() * f);
                Rect rect = new Rect(0, 0, width, height);
                rect.offsetTo((layoutEditor3.f11057B3GDIM.getWidth() - width) / 2, (layoutEditor3.f11057B3GDIM.getHeight() - height) / 2);
                layoutEditor3.f11057B3GDIM.setCurrentItem(layoutEditor3.AaHO0E(obj, bitmap, rect));
                layoutEditor3.f11055B25kr6 = true;
                break;
        }
    }
}
