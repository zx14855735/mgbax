package MQlCFp;

import OCUYV2.AZkASS;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.game.boy.viewUi.HTMLTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AYUAbz extends Fragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public MTKlkd.ARc23Z f5152AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ASJ6gh f5153AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f5154AmA8tU = false;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f5155AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TextView f5156B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public HTMLTextView f5157B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public MaterialButton f5158B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public MaterialButton f5159B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public RecyclerView f5160B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public MaterialCardView f5161B9tovu;

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f5152AcNBzu = (MTKlkd.ARc23Z) getArguments().getParcelable("game_item");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131492959, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5156B25kr6 = (TextView) view.findViewById(2131296650);
        this.f5157B2KMhB = (HTMLTextView) view.findViewById(2131296651);
        this.f5158B3GDIM = (MaterialButton) view.findViewById(2131296648);
        this.f5159B4ZgIw = (MaterialButton) view.findViewById(2131296649);
        this.f5160B7CMnp = (RecyclerView) view.findViewById(2131297883);
        this.f5161B9tovu = (MaterialCardView) view.findViewById(2131296463);
        MTKlkd.ARc23Z aRc23Z = this.f5152AcNBzu;
        if (aRc23Z != null) {
            String AMqCpz = aRc23Z.AMqCpz();
            TextView textView = this.f5156B25kr6;
            String str = "无";
            if (AMqCpz == null || AMqCpz.isEmpty()) {
                AMqCpz = "无";
            }
            textView.setText(AMqCpz);
            String A2egSU2 = this.f5152AcNBzu.A2egSU();
            HTMLTextView hTMLTextView = this.f5157B2KMhB;
            if (A2egSU2 != null && !A2egSU2.isEmpty()) {
                str = A2egSU2;
            }
            hTMLTextView.setHTMLText(str);
            this.f5158B3GDIM.setOnClickListener(new ADYaiT(this, 0));
            this.f5159B4ZgIw.setOnClickListener(new ADYaiT(this, 1));
        }
        MTKlkd.ARc23Z aRc23Z2 = this.f5152AcNBzu;
        if (aRc23Z2 == null || aRc23Z2.A5SV6n() == null || this.f5152AcNBzu.A5SV6n().isEmpty()) {
            this.f5161B9tovu.setVisibility(8);
            return;
        }
        this.f5153AlLFFp = new ASJ6gh(this, this.f5152AcNBzu.A5SV6n());
        CarouselLayoutManager carouselLayoutManager = new CarouselLayoutManager(new AZkASS());
        carouselLayoutManager.f11513AmA8tU = 0;
        carouselLayoutManager.BChYOn();
        this.f5160B7CMnp.setLayoutManager(carouselLayoutManager);
        this.f5160B7CMnp.setNestedScrollingEnabled(false);
        new OCUYV2.AYUAbz(false).attachToRecyclerView(this.f5160B7CMnp);
        this.f5160B7CMnp.setAdapter(this.f5153AlLFFp);
    }
}
