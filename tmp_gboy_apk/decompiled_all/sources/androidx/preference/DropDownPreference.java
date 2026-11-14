package androidx.preference;

import AaHO0E.EsrwYR;
import DRlcZ9.BV3sI0;
import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: DaOi9o, reason: collision with root package name */
    public final ArrayAdapter f9066DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public Spinner f9067DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public final EsrwYR f9068DdagTj;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969045);
        this.f9068DdagTj = new EsrwYR(1, this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_dropdown_item);
        this.f9066DaOi9o = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.f9070DRlcZ9;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void AZOQYO() {
        super.AZOQYO();
        ArrayAdapter arrayAdapter = this.f9066DaOi9o;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void AlLFFp(BV3sI0 bV3sI0) {
        int i;
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) bV3sI0.itemView.findViewById(2131298003);
        this.f9067DcUJf1 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f9066DaOi9o);
        this.f9067DcUJf1.setOnItemSelectedListener(this.f9068DdagTj);
        Spinner spinner2 = this.f9067DcUJf1;
        String str = this.f9072DV2E8K;
        if (str != null && (charSequenceArr = this.f9071DUi7mC) != null) {
            i = charSequenceArr.length - 1;
            while (i >= 0) {
                if (TextUtils.equals(charSequenceArr[i].toString(), str)) {
                    break;
                } else {
                    i--;
                }
            }
        }
        i = -1;
        spinner2.setSelection(i);
        super.AlLFFp(bV3sI0);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void AmA8tU() {
        this.f9067DcUJf1.performClick();
    }
}
