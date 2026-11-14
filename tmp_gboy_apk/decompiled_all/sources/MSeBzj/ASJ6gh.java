package MSeBzj;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.game.boy.activity.BJ7GGh;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ASJ6gh extends com.google.android.material.bottomsheet.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f5186AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f5187AlLFFp = new ArrayList();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BJ7GGh f5188AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ARc23Z f5189AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TextInputEditText f5190B25kr6;

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131493328, viewGroup, false);
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onStart() {
        View findViewById;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || dialog.getWindow() == null || (findViewById = dialog.findViewById(2131296576)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = (int) (getResources().getDisplayMetrics().heightPixels * 0.8f);
        findViewById.setLayoutParams(layoutParams);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5190B25kr6 = (TextInputEditText) view.findViewById(2131296620);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(2131297795);
        requireContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        recyclerView.setHasFixedSize(true);
        ARc23Z aRc23Z = new ARc23Z(this.f5187AlLFFp, new A2egSU(this));
        this.f5189AzWtSf = aRc23Z;
        recyclerView.setAdapter(aRc23Z);
        this.f5190B25kr6.addTextChangedListener(new A4TApA(this));
    }
}
