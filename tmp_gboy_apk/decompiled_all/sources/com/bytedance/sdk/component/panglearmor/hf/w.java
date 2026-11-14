package com.bytedance.sdk.component.panglearmor.hf;

import android.hardware.SensorManager;
import com.kwad.components.core.s.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static float[] xj(List<Float> list, List<Float> list2, List<Float> list3, List<Float> list4, List<Float> list5, List<Float> list6) {
        int i;
        char c;
        char c2;
        int i2 = 3;
        int min = Math.min(list.size(), list4.size());
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 0;
        while (i3 < min) {
            Float f4 = list.get(i3);
            Float f5 = list2.get(i3);
            Float f6 = list3.get(i3);
            Float f7 = list4.get(i3);
            c = 2;
            Float f8 = list5.get(i3);
            c2 = 1;
            Float f9 = list6.get(i3);
            if (f4 == null || f5 == null || f6 == null || f7 == null || f8 == null || f9 == null) {
                i = min;
                break;
            }
            float floatValue = f4.floatValue();
            float floatValue2 = f5.floatValue();
            float floatValue3 = f6.floatValue();
            float[] fArr = new float[i2];
            fArr[0] = floatValue;
            fArr[1] = floatValue2;
            fArr[2] = floatValue3;
            float floatValue4 = f7.floatValue();
            float floatValue5 = f8.floatValue();
            float floatValue6 = f9.floatValue();
            float[] fArr2 = new float[i2];
            fArr2[0] = floatValue4;
            fArr2[1] = floatValue5;
            fArr2[2] = floatValue6;
            float[] fArr3 = new float[9];
            SensorManager.getRotationMatrix(fArr3, null, fArr, fArr2);
            SensorManager.getOrientation(fArr3, new float[i2]);
            f += (((float) Math.toDegrees(r12[0])) + 360.0f) % 360.0f;
            f2 += (((float) Math.toDegrees(r12[1])) + 360.0f) % 360.0f;
            f3 += (((float) Math.toDegrees(r12[2])) + 360.0f) % 360.0f;
            i3++;
            min = min;
            i2 = 3;
        }
        i = min;
        c = 2;
        c2 = 1;
        if (i == 0) {
            return new float[]{0.0f, 0.0f, 0.0f};
        }
        float f10 = i;
        float f11 = f / f10;
        float f12 = f2 / f10;
        float f13 = f3 / f10;
        float[] fArr4 = new float[3];
        fArr4[0] = f11;
        fArr4[c2] = f12;
        fArr4[c] = f13;
        return fArr4;
    }

    public static int[][] xj(List<JSONObject> list, long j, long j2) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        double[] dArr3 = new double[size];
        for (int i = 0; i < size; i++) {
            JSONArray optJSONArray = list.get(i).optJSONArray("val");
            if (optJSONArray != null && optJSONArray.length() == 3) {
                dArr[i] = optJSONArray.getDouble(0);
                dArr2[i] = optJSONArray.getDouble(1);
                dArr3[i] = optJSONArray.getDouble(2);
            }
        }
        return new int[][]{xj(dArr, j), xj(dArr2, j2), xj(dArr3, j2)};
    }

    public static int[] xj(double[] dArr, long j) {
        if (j > 0 && j <= 360) {
            int[] iArr = new int[(int) (360 / j)];
            for (double d : dArr) {
                int i = (int) (d / j);
                iArr[i] = iArr[i] + 1;
            }
            return iArr;
        }
        return new int[0];
    }

    public static int[] xj(LinkedList<JSONObject> linkedList, int i) {
        int[] iArr = new int[i];
        if (linkedList.size() > 0) {
            int optLong = (int) (((linkedList.getLast().optLong(t.TAG, 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = linkedList.iterator();
            while (it.hasNext()) {
                int optLong2 = optLong - ((int) (((it.next().optLong(t.TAG, 0L) / 1000) / 60) / 60));
                if (optLong2 >= 0 && optLong2 < i) {
                    iArr[optLong2] = iArr[optLong2] + 1;
                }
            }
        }
        return iArr;
    }
}
