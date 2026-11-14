package GJee0v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends I3HV03.ASJ6gh {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ WeakReference f3030A4TApA;

    public A5SV6n(WeakReference weakReference) {
        this.f3030A4TApA = weakReference;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
    }

    @Override // I3HV03.ASJ6gh
    public final Bitmap A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap, int i, int i2) {
        Context context = (Context) this.f3030A4TApA.get();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(20);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            createFromBitmap.destroy();
            createFromBitmap2.destroy();
            create2.destroy();
            return createBitmap;
        } catch (Exception unused) {
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap2.eraseColor(Color.argb(0, 0, 0, 0));
            return createBitmap2;
        }
    }
}
