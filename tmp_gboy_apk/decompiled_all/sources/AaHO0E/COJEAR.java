package AaHO0E;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class COJEAR {
    public static boolean A2egSU(DragEvent dragEvent, TextView textView, Activity activity) {
        COJEAR.AMqCpz aMqCpz;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                aMqCpz = new KCxDWD.A5SV6n(clipData, 3);
            } else {
                COJEAR.ARc23Z aRc23Z = new COJEAR.ARc23Z();
                aRc23Z.f1619AlLFFp = clipData;
                aRc23Z.f1620AmA8tU = 3;
                aMqCpz = aRc23Z;
            }
            COJEAR.DG07BK.AzWtSf(textView, aMqCpz.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean A4TApA(DragEvent dragEvent, View view, Activity activity) {
        COJEAR.AMqCpz aMqCpz;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            aMqCpz = new KCxDWD.A5SV6n(clipData, 3);
        } else {
            COJEAR.ARc23Z aRc23Z = new COJEAR.ARc23Z();
            aRc23Z.f1619AlLFFp = clipData;
            aRc23Z.f1620AmA8tU = 3;
            aMqCpz = aRc23Z;
        }
        COJEAR.DG07BK.AzWtSf(view, aMqCpz.build());
        return true;
    }
}
