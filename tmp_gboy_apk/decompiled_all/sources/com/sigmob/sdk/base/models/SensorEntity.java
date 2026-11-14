package com.sigmob.sdk.base.models;

import com.sigmob.sdk.base.utils.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SensorEntity {
    public int level;
    public int shakeTimeThreshold;
    public int shakeTriggerType;
    public int widgetIntervalTime;

    private SensorEntity() {
    }

    public static SensorEntity format(BaseAdUnit baseAdUnit) {
        SensorEntity sensorEntity = new SensorEntity();
        if (q.b(baseAdUnit)) {
            sensorEntity.level = baseAdUnit.getSensitivity();
            sensorEntity.shakeTriggerType = baseAdUnit.getShakeTriggerType();
            sensorEntity.widgetIntervalTime = baseAdUnit.getWidgetIntervalTime();
            sensorEntity.shakeTimeThreshold = baseAdUnit.getShakeTimeThreshold();
        }
        return sensorEntity;
    }

    public SensorEntity(int i) {
        this.level = i;
    }

    public SensorEntity(int i, int i2, int i3, int i4) {
        this.level = i;
        this.shakeTriggerType = i2;
        this.widgetIntervalTime = i3;
        this.shakeTimeThreshold = i4;
    }
}
