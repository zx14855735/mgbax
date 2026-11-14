package com.fl.saas.config.oaid;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DeviceIdentifier {
    private static volatile String androidId;
    private static volatile String clientId;
    private static volatile String guid;
    private static volatile String imei;
    private static volatile String oaid;
    private static volatile String pseudoId;
    private static volatile boolean registered;
    private static volatile String widevineId;

    private DeviceIdentifier() {
    }

    public static String getAndroidID(Context context) {
        if (androidId == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (androidId == null) {
                        androidId = DeviceID.getAndroidID(context);
                    }
                } finally {
                }
            }
        }
        if (androidId == null) {
            androidId = "";
        }
        return androidId;
    }

    public static String getClientId() {
        if (TextUtils.isEmpty(clientId)) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (TextUtils.isEmpty(clientId)) {
                        clientId = DeviceID.getClientIdMD5();
                    }
                } finally {
                }
            }
        }
        if (clientId == null) {
            clientId = "";
        }
        return clientId;
    }

    public static String getGUID(Context context) {
        if (guid == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (guid == null) {
                        guid = DeviceID.getGUID(context);
                    }
                } finally {
                }
            }
        }
        if (guid == null) {
            guid = "";
        }
        return guid;
    }

    public static String getIMEI(Context context) {
        if (imei == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (imei == null) {
                        imei = DeviceID.getUniqueID(context);
                    }
                } finally {
                }
            }
        }
        if (imei == null) {
            imei = "";
        }
        return imei;
    }

    public static String getOAID(Context context) {
        if (TextUtils.isEmpty(oaid)) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (TextUtils.isEmpty(oaid)) {
                        oaid = DeviceID.getOAID();
                        if (oaid != null) {
                            if (oaid.length() == 0) {
                            }
                        }
                        DeviceID.getOAID(context, new IGetter() { // from class: com.fl.saas.config.oaid.DeviceIdentifier.1
                            @Override // com.fl.saas.config.oaid.IGetter
                            public void onOAIDGetComplete(String str) {
                                String unused = DeviceIdentifier.oaid = str;
                            }

                            @Override // com.fl.saas.config.oaid.IGetter
                            public void onOAIDGetError(Exception exc) {
                                String unused = DeviceIdentifier.oaid = "";
                            }
                        });
                    }
                } finally {
                }
            }
        }
        if (oaid == null) {
            oaid = "";
        }
        return oaid;
    }

    public static String getPseudoID() {
        if (pseudoId == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (pseudoId == null) {
                        pseudoId = DeviceID.getPseudoID();
                    }
                } finally {
                }
            }
        }
        if (pseudoId == null) {
            pseudoId = "";
        }
        return pseudoId;
    }

    public static String getWidevineID() {
        if (widevineId == null) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (widevineId == null) {
                        widevineId = DeviceID.getWidevineID();
                    }
                } finally {
                }
            }
        }
        if (widevineId == null) {
            widevineId = "";
        }
        return widevineId;
    }

    public static void register(Context context) {
        if (registered) {
            return;
        }
        synchronized (DeviceIdentifier.class) {
            try {
                if (!registered) {
                    DeviceID.register(context);
                    registered = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
