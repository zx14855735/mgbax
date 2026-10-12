/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Key positions. Dragging a button writes its center immediately.
 */
public final class KeyLayout {
    public static final String[] KEYS = {"dpad", "a", "b", "l", "r", "select", "start"};

    private final Map<String, float[]> saved = new HashMap<>();

    public static KeyLayout decode(String text) {
        KeyLayout layout = new KeyLayout();
        if (text == null || text.isEmpty()) {
            return layout;
        }
        String[] parts = text.split(";");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            int eq = part.indexOf('=');
            int comma = part.indexOf(',');
            if (eq <= 0 || comma <= eq + 1) {
                continue;
            }
            String key = part.substring(0, eq);
            if (!known(key)) {
                continue;
            }
            try {
                float x = Float.parseFloat(part.substring(eq + 1, comma));
                float y = Float.parseFloat(part.substring(comma + 1));
                layout.saved.put(key, new float[] {clamp01(x), clamp01(y)});
            } catch (NumberFormatException ignored) {
            }
        }
        return layout;
    }

    public String encode() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < KEYS.length; i++) {
            float[] point = saved.get(KEYS[i]);
            if (point == null) {
                continue;
            }
            if (out.length() > 0) {
                out.append(';');
            }
            out.append(KEYS[i]).append('=');
            out.append(String.format(Locale.US, "%.4f,%.4f", point[0], point[1]));
        }
        return out.toString();
    }

    public void place(String key, float x, float y) {
        if (!known(key)) {
            return;
        }
        saved.put(key, new float[] {clamp01(x), clamp01(y)});
    }

    public void resetAll() {
        saved.clear();
    }

    public float[] savedPoint(String key) {
        return copy(saved.get(key));
    }

    public Map<String, float[]> resolved() {
        Map<String, float[]> out = new HashMap<>();
        for (int i = 0; i < KEYS.length; i++) {
            float[] point = saved.get(KEYS[i]);
            if (point != null) {
                out.put(KEYS[i], copy(point));
            }
        }
        return out;
    }

    public static float clamp01(float value) {
        if (value < 0f) {
            return 0f;
        }
        if (value > 1f) {
            return 1f;
        }
        return value;
    }

    public static float clampCenter(float center, float half, float span) {
        if (span <= 0f) {
            return 0f;
        }
        if (half * 2f >= span) {
            return span / 2f;
        }
        if (center < half) {
            return half;
        }
        if (center > span - half) {
            return span - half;
        }
        return center;
    }

    private static boolean known(String key) {
        for (int i = 0; i < KEYS.length; i++) {
            if (KEYS[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    private static float[] copy(float[] point) {
        if (point == null) {
            return null;
        }
        return new float[] {point[0], point[1]};
    }
}
