package LLiCI0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import com.game.boy.view.MarqueeTextView;
import com.google.android.material.button.MaterialButton;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CSDoyG extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ImageView f4777AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final MarqueeTextView f4778AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final TextView f4779AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final TextView f4780AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final MaterialButton f4781B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final COJEAR f4782B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public long f4783B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final /* synthetic */ CcAIMM f4784B4ZgIw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSDoyG(CcAIMM ccAIMM, View view, COJEAR cojear) {
        super(view);
        this.f4784B4ZgIw = ccAIMM;
        this.f4783B3GDIM = 0L;
        this.f4782B2KMhB = cojear;
        this.f4777AcNBzu = (ImageView) view.findViewById(2131296659);
        this.f4778AlLFFp = (MarqueeTextView) view.findViewById(2131296660);
        this.f4779AmA8tU = (TextView) view.findViewById(2131298027);
        this.f4780AzWtSf = (TextView) view.findViewById(2131296663);
        MaterialButton materialButton = (MaterialButton) view.findViewById(2131296326);
        this.f4781B25kr6 = materialButton;
        view.setOnClickListener(new CQhlFr(this, 0));
        materialButton.setOnClickListener(new CQhlFr(this, 1));
    }

    public final void A2egSU(MTKlkd.ARc23Z aRc23Z) {
        String str;
        if ((aRc23Z.AYUAbz() != null && !aRc23Z.AYUAbz().isEmpty()) || aRc23Z.f5248BNL6CD != null) {
            switch (aRc23Z.AaHO0E()) {
                case 0:
                    str = "等待";
                    break;
                case 1:
                    str = String.format(Locale.getDefault(), "%d%%", Integer.valueOf(aRc23Z.ASJ6gh()));
                    break;
                case 2:
                    str = "继续";
                    break;
                case 3:
                    str = "打开";
                    break;
                case 4:
                    str = "失败";
                    break;
                case 5:
                    str = "验证中";
                    break;
                case 6:
                    str = "重试";
                    break;
                default:
                    str = "下载";
                    break;
            }
        } else {
            str = "详情";
        }
        this.f4781B25kr6.setText(str);
    }
}
