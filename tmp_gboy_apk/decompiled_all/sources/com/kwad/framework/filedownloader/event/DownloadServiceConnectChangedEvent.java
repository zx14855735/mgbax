package com.kwad.framework.filedownloader.event;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus asG;
    private final Class<?> asH;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost;

        static {
            GizVvh();
        }

        private static /* synthetic */ void GizVvh() {
            char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '.');
            }
            String str = new String(charArray);
            char[] charArray2 = "MBG@GZ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '.');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.asG = connectStatus;
        this.asH = cls;
    }

    public final ConnectStatus Al() {
        return this.asG;
    }
}
