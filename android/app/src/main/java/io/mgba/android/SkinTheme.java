/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

/**
 * Colors for the handheld-style skins. The default is the purple shell the
 * player picked; the rest recolor the same layout. Buttons stay white, the
 * accent colors their letters and pressed states.
 */
public final class SkinTheme {
    public final String name;
    /** Gradient of the shell (controls area / whole body in landscape). */
    public final int bodyTop;
    public final int bodyBottom;
    /** Letter and pressed color on the white buttons. */
    public final int accent;
    public final int accentDeep;
    /** Bezel around the game screen and the title strip below it. */
    public final int bezel;
    public final int titleText;
    /** Decorative speaker dots / slots on the shell. */
    public final int speaker;
    /** Center marker on the d-pad. */
    public final int dpadMark;

    public SkinTheme(String name, int bodyTop, int bodyBottom, int accent, int accentDeep,
                     int titleText, int speaker, int dpadMark) {
        this.name = name;
        this.bodyTop = bodyTop;
        this.bodyBottom = bodyBottom;
        this.accent = accent;
        this.accentDeep = accentDeep;
        this.bezel = 0xFF0A0A0C;
        this.titleText = titleText;
        this.speaker = speaker;
        this.dpadMark = dpadMark;
    }

    public static final SkinTheme PURPLE = new SkinTheme("紫色", 0xFF8A63D2, 0xFF54329E,
            0xFF6C4AB0, 0xFF4B2E86, 0xFFF2E9FF, 0x46000000, 0x3D6C4AB0);
    public static final SkinTheme GREEN = new SkinTheme("绿色", 0xFF63B852, 0xFF3B8A33,
            0xFF3B8A33, 0xFF2A6624, 0xFFEFFFEA, 0x42000000, 0x3D3B8A33);
    public static final SkinTheme BLUE = new SkinTheme("蓝色", 0xFF5B9BD9, 0xFF2F669E,
            0xFF2F669E, 0xFF224B78, 0xFFEAF4FF, 0x44000000, 0x3D2F669E);
    public static final SkinTheme RED = new SkinTheme("红色", 0xFFD96B5E, 0xFFA83A30,
            0xFFA83A30, 0xFF7E2A22, 0xFFFFEDEA, 0x44000000, 0x3DA83A30);
    public static final SkinTheme PINK = new SkinTheme("粉色", 0xFFDE84B4, 0xFFAE5086,
            0xFFAE5086, 0xFF8A3A68, 0xFFFFECF5, 0x44000000, 0x3DAE5086);
    public static final SkinTheme GRAPHITE = new SkinTheme("石墨黑", 0xFF3C3C42, 0xFF1F1F24,
            0xFFB9B9C2, 0xFF8E8E96, 0xFFE8E8EE, 0x4C000000, 0x3D9E9EA8);

    public static final SkinTheme[] ALL = {PURPLE, GREEN, BLUE, RED, PINK, GRAPHITE};

    public static SkinTheme byIndex(int index) {
        if (index < 0 || index >= ALL.length) {
            return PURPLE;
        }
        return ALL[index];
    }
}
