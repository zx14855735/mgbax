package LCJm5h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU {
    public static ArrayList A2egSU(Context context) {
        String string = context.getSharedPreferences("favorites", 0).getString("rom_paths", "[]");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    public static void A4TApA(Context context, ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        context.getSharedPreferences("favorites", 0).edit().putString("rom_paths", jSONArray.toString()).apply();
    }

    public static boolean delete(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        ArrayList A2egSU2 = A2egSU(context);
        if (!A2egSU2.contains(str)) {
            return false;
        }
        A2egSU2.remove(str);
        A4TApA(context, A2egSU2);
        return true;
    }
}
