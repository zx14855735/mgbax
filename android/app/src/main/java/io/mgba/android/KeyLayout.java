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
    /** Optional utility keys the player can switch on in the settings. */
    public static final String[] EXTRA_KEYS = {"ta", "tb", "lr", "c", "c2", "save", "load", "ff", "shot", "rewind"};
    public static final float MIN_SCALE = 0.4f;
    public static final float MAX_SCALE = 3.0f;

    private final Map<String, float[]> saved = new HashMap<>();
    private final Map<String, Float> scales = new HashMap<>();

    public static KeyLayout decode(String text) {
        KeyLayout layout = new KeyLayout();
        if (text == null || text.isEmpty()) {
            return layout;
        }
        String[] parts = text.split(";");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            int eq = part.indexOf('=');
            if (eq <= 0) {
                continue;
            }
            String key = part.substring(0, eq);
            String value = part.substring(eq + 1);
            if (key.endsWith(".s")) {
                String base = key.substring(0, key.length() - 2);
                if (!known(base)) {
                    continue;
                }
                try {
                    layout.scales.put(base, clampScale(Float.parseFloat(value.trim())));
                } catch (NumberFormatException ignored) {
                }
                continue;
            }
            if (!known(key)) {
                continue;
            }
            String[] fields = value.split(",");
            if (fields.length < 2) {
                continue;
            }
            try {
                float x = Float.parseFloat(fields[0].trim());
                float y = Float.parseFloat(fields[1].trim());
                layout.saved.put(key, new float[] {clamp01(x), clamp01(y)});
                if (fields.length >= 3) {
                    layout.scales.put(key, clampScale(Float.parseFloat(fields[2].trim())));
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return layout;
    }

    public String encode() {
        StringBuilder out = new StringBuilder();
        String[] all = allKeys();
        for (int i = 0; i < all.length; i++) {
            float[] point = saved.get(all[i]);
            if (point != null) {
                if (out.length() > 0) {
                    out.append(';');
                }
                out.append(all[i]).append('=');
                out.append(String.format(Locale.US, "%.4f,%.4f", point[0], point[1]));
            }
        }
        for (int i = 0; i < all.length; i++) {
            Float scale = scales.get(all[i]);
            if (scale == null || Math.abs(scale - 1f) < 0.001f) {
                continue;
            }
            if (out.length() > 0) {
                out.append(';');
            }
            out.append(all[i]).append(".s=");
            out.append(String.format(Locale.US, "%.3f", scale));
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
        scales.clear();
    }

    public void setScale(String key, float scale) {
        if (!known(key)) {
            return;
        }
        float clamped = clampScale(scale);
        if (Math.abs(clamped - 1f) < 0.001f) {
            scales.remove(key);
        } else {
            scales.put(key, clamped);
        }
    }

    public float scaleFor(String key) {
        Float scale = scales.get(key);
        return scale == null ? 1f : scale;
    }

    public Map<String, Float> resolvedScales() {
        Map<String, Float> out = new HashMap<>();
        String[] all = allKeys();
        for (int i = 0; i < all.length; i++) {
            Float scale = scales.get(all[i]);
            if (scale != null) {
                out.put(all[i], scale);
            }
        }
        return out;
    }

    public float[] savedPoint(String key) {
        return copy(saved.get(key));
    }

    public Map<String, float[]> resolved() {
        Map<String, float[]> out = new HashMap<>();
        String[] all = allKeys();
        for (int i = 0; i < all.length; i++) {
            float[] point = saved.get(all[i]);
            if (point != null) {
                out.put(all[i], copy(point));
            }
        }
        return out;
    }

    private static String[] allKeys() {
        String[] all = new String[KEYS.length + EXTRA_KEYS.length];
        System.arraycopy(KEYS, 0, all, 0, KEYS.length);
        System.arraycopy(EXTRA_KEYS, 0, all, KEYS.length, EXTRA_KEYS.length);
        return all;
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

    public static float clampScale(float scale) {
        if (scale < MIN_SCALE) {
            return MIN_SCALE;
        }
        if (scale > MAX_SCALE) {
            return MAX_SCALE;
        }
        return scale;
    }

    private static boolean known(String key) {
        for (int i = 0; i < KEYS.length; i++) {
            if (KEYS[i].equals(key)) {
                return true;
            }
        }
        for (int i = 0; i < EXTRA_KEYS.length; i++) {
            if (EXTRA_KEYS[i].equals(key)) {
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
