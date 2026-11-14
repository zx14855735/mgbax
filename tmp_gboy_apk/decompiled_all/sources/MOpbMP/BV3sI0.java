package MOpbMP;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.sdk.internal.an;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import java.util.Locale;
import java.util.Random;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BV3sI0 implements TextView.OnEditorActionListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ SearchView f5053A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ SearchBar f5054A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5055A5SV6n;

    public BV3sI0(BpkvW3 bpkvW3, SearchView searchView, SearchBar searchBar) {
        this.f5055A5SV6n = bpkvW3;
        this.f5053A2egSU = searchView;
        this.f5054A4TApA = searchBar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        String AcNBzu2;
        String obj = this.f5053A2egSU.getText().toString();
        BpkvW3 bpkvW3 = this.f5055A5SV6n;
        if (TextUtils.isEmpty(obj)) {
            Toast.makeText(bpkvW3.getActivity(), 2131886294, 0).show();
        }
        this.f5054A4TApA.setText(obj);
        IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(9, this);
        OkHttpClient okHttpClient = LlW7FF.A2egSU.f4864A2egSU;
        Locale locale = Locale.ROOT;
        Request.Builder post = new Request.Builder().url("https://gboy.top/api/api.php").post(RequestBody.create(MediaType.parse(an.d), CtFAbx.BI9f7h("{\"action\":\"search_downloads\",\"keyword\":\"", obj, "\"}")));
        Random random = new Random();
        String[] strArr = LlW7FF.A2egSU.f4867ADYaiT;
        Request.Builder header = post.header("User-Agent", strArr[random.nextInt(strArr.length)]).header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        Locale locale2 = Locale.getDefault();
        String language = locale2.getLanguage();
        String country = locale2.getCountry();
        if (country == null || country.isEmpty()) {
            AcNBzu2 = CtFAbx.AcNBzu(language, ";q=0.9,en;q=0.8");
        } else {
            AcNBzu2 = language + "-" + country + "," + language + ";q=0.9,en;q=0.8";
        }
        LlW7FF.A2egSU.f4864A2egSU.newCall(header.header("Accept-Language", AcNBzu2).header("Connection", "keep-alive").build()).enqueue(new IQ76hF.AmA8tU(5, amA8tU));
        return true;
    }
}
