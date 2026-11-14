package ADYaiT;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements AdapterView.OnItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f18AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f19AlLFFp;

    public ASJ6gh(AZOQYO azoqyo, AcNBzu acNBzu) {
        this.f19AlLFFp = azoqyo;
        this.f18AcNBzu = acNBzu;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AZOQYO azoqyo = this.f19AlLFFp;
        DialogInterface.OnClickListener onClickListener = azoqyo.f40B4ZgIw;
        AcNBzu acNBzu = this.f18AcNBzu;
        onClickListener.onClick(acNBzu.f50A4TApA, i);
        if (azoqyo.f44BI9f7h) {
            return;
        }
        acNBzu.f50A4TApA.dismiss();
    }
}
