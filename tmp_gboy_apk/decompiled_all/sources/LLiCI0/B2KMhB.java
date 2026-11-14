package LLiCI0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import com.game.boy.view.MarqueeTextView;
import com.google.android.material.button.MaterialButton;
import com.sigmob.sdk.base.mta.PointCategory;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ImageView f4709AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final MarqueeTextView f4710AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final TextView f4711AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final TextView f4712AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final MaterialButton f4713B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public L5dZB6.A4TApA f4714B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final /* synthetic */ B3GDIM f4715B3GDIM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B2KMhB(B3GDIM b3gdim, View view) {
        super(view);
        this.f4715B3GDIM = b3gdim;
        this.f4709AcNBzu = (ImageView) view.findViewById(2131296659);
        this.f4710AlLFFp = (MarqueeTextView) view.findViewById(2131296660);
        this.f4711AmA8tU = (TextView) view.findViewById(2131298027);
        this.f4712AzWtSf = (TextView) view.findViewById(2131296663);
        this.f4713B25kr6 = (MaterialButton) view.findViewById(2131296326);
    }

    public static String A2egSU(long j) {
        if (j <= 0) {
            return "0 B";
        }
        double d = j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, log10)) + " " + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public final void A4TApA(Object obj, L5dZB6.A4TApA a4TApA) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (PointCategory.PROGRESS.equals(str)) {
                A5SV6n(a4TApA);
            } else if ("status".equals(str)) {
                ADYaiT(a4TApA);
            }
        }
        Objects.toString(obj);
    }

    public final void A5SV6n(L5dZB6.A4TApA a4TApA) {
        this.f4711AmA8tU.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(a4TApA.f4399B4ZgIw)));
        long j = a4TApA.f4397B2KMhB;
        TextView textView = this.f4712AzWtSf;
        if (j <= 0) {
            textView.setText("");
            return;
        }
        textView.setText(A2egSU(a4TApA.f4398B3GDIM) + "/" + A2egSU(a4TApA.f4397B2KMhB));
    }

    public final void ADYaiT(L5dZB6.A4TApA a4TApA) {
        String str = "等待";
        switch (a4TApA.f4400B7CMnp) {
            case 0:
            case 5:
                break;
            case 1:
                str = String.format(Locale.getDefault(), "%d%%", Integer.valueOf(a4TApA.f4399B4ZgIw));
                break;
            case 2:
                str = "继续";
                break;
            case 3:
                str = "打开";
                break;
            case 4:
            case 6:
                str = "重试";
                break;
            default:
                str = "";
                break;
        }
        this.f4713B25kr6.setText(str);
    }
}
