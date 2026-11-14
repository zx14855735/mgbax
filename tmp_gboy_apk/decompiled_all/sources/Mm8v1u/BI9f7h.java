package Mm8v1u;

import android.view.View;
import com.game.boy.viewUi.Material3AutoCompleteTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5518AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ LLYwnm.AMqCpz f5519AlLFFp;

    public /* synthetic */ BI9f7h(LLYwnm.AMqCpz aMqCpz, int i) {
        this.f5518AcNBzu = i;
        this.f5519AlLFFp = aMqCpz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5518AcNBzu) {
            case 0:
                ((Material3AutoCompleteTextView) this.f5519AlLFFp.f4619AlLFFp).showDropDown();
                break;
            default:
                ((Material3AutoCompleteTextView) this.f5519AlLFFp.f4619AlLFFp).showDropDown();
                break;
        }
    }
}
