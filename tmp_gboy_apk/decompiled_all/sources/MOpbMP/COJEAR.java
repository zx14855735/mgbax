package MOpbMP;

import AaHO0E.D8MqeW;
import android.view.View;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class COJEAR implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5091AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CQhlFr f5092AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ CSDoyG f5093AmA8tU;

    public /* synthetic */ COJEAR(CSDoyG cSDoyG, CQhlFr cQhlFr, int i) {
        this.f5091AcNBzu = i;
        this.f5093AmA8tU = cSDoyG;
        this.f5092AlLFFp = cQhlFr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CSDoyG cSDoyG = this.f5093AmA8tU;
        CQhlFr cQhlFr = this.f5092AlLFFp;
        switch (this.f5091AcNBzu) {
            case 0:
                int bindingAdapterPosition = cQhlFr.getBindingAdapterPosition();
                if (bindingAdapterPosition != -1) {
                    int intValue = ((Integer) cSDoyG.f5104AmA8tU.get(bindingAdapterPosition)).intValue();
                    String A4TApA2 = cSDoyG.A4TApA(bindingAdapterPosition);
                    CTkVKb cTkVKb = cSDoyG.f5102AcNBzu;
                    CSDoyG.A2egSU(cSDoyG, cTkVKb.getString(2131886217), cTkVKb.getString(2131886216, A4TApA2), new C4FrIb.A4TApA(intValue, 2, this));
                    break;
                }
                break;
            case 1:
                int bindingAdapterPosition2 = cQhlFr.getBindingAdapterPosition();
                if (bindingAdapterPosition2 != -1 && ((File) cSDoyG.f5103AlLFFp.get(bindingAdapterPosition2)).exists()) {
                    int intValue2 = ((Integer) cSDoyG.f5104AmA8tU.get(bindingAdapterPosition2)).intValue();
                    String A4TApA3 = cSDoyG.A4TApA(bindingAdapterPosition2);
                    CTkVKb cTkVKb2 = cSDoyG.f5102AcNBzu;
                    CSDoyG.A2egSU(cSDoyG, cTkVKb2.getString(2131886213), cTkVKb2.getString(2131886212, A4TApA3), new C4FrIb.A4TApA(intValue2, 3, this));
                    break;
                }
                break;
            case 2:
                int bindingAdapterPosition3 = cQhlFr.getBindingAdapterPosition();
                if (bindingAdapterPosition3 != -1 && ((File) cSDoyG.f5103AlLFFp.get(bindingAdapterPosition3)).exists()) {
                    String A4TApA4 = cSDoyG.A4TApA(bindingAdapterPosition3);
                    CTkVKb cTkVKb3 = cSDoyG.f5102AcNBzu;
                    CSDoyG.A2egSU(cSDoyG, cTkVKb3.getString(2131886219), cTkVKb3.getString(2131886218, A4TApA4), new LLYwnm.AMqCpz(11, this));
                    break;
                }
                break;
            default:
                int bindingAdapterPosition4 = cQhlFr.getBindingAdapterPosition();
                if (bindingAdapterPosition4 != -1) {
                    File file = (File) cSDoyG.f5103AlLFFp.get(bindingAdapterPosition4);
                    if (file.exists()) {
                        String A4TApA5 = cSDoyG.A4TApA(bindingAdapterPosition4);
                        CTkVKb cTkVKb4 = cSDoyG.f5102AcNBzu;
                        CSDoyG.A2egSU(cSDoyG, cTkVKb4.getString(2131886211), cTkVKb4.getString(2131886210, A4TApA5), new D8MqeW(this, file, bindingAdapterPosition4, 1, false));
                        break;
                    }
                }
                break;
        }
    }
}
