/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * Colors for the handheld-style skins, mirroring the Android SkinTheme. The
 * default is the purple shell the player picked; the rest recolor the same
 * layout. Buttons stay white, the accent colors their letters and pressed
 * states.
 */
struct SkinTheme {
    let name: String
    /// Gradient of the shell (controls area / whole body in landscape).
    let bodyTop: UIColor
    let bodyBottom: UIColor
    /// Letter and pressed color on the white buttons.
    let accent: UIColor
    let accentDeep: UIColor
    /// Bezel around the game screen and the title strip below it.
    let bezel: UIColor
    let titleText: UIColor
    /// Decorative speaker dots / slots on the shell.
    let speaker: UIColor
    /// Center marker on the d-pad.
    let dpadMark: UIColor

    static let purple = SkinTheme(name: "紫色",
                                  bodyTop: UIColor(argb: 0xFF8A63D2),
                                  bodyBottom: UIColor(argb: 0xFF54329E),
                                  accent: UIColor(argb: 0xFF6C4AB0),
                                  accentDeep: UIColor(argb: 0xFF4B2E86),
                                  bezel: UIColor(argb: 0xFF0A0A0C),
                                  titleText: UIColor(argb: 0xFFF2E9FF),
                                  speaker: UIColor(argb: 0x46000000),
                                  dpadMark: UIColor(argb: 0x3D6C4AB0))

    static let green = SkinTheme(name: "绿色",
                                 bodyTop: UIColor(argb: 0xFF63B852),
                                 bodyBottom: UIColor(argb: 0xFF3B8A33),
                                 accent: UIColor(argb: 0xFF3B8A33),
                                 accentDeep: UIColor(argb: 0xFF2A6624),
                                 bezel: UIColor(argb: 0xFF0A0A0C),
                                 titleText: UIColor(argb: 0xFFEFFFEA),
                                 speaker: UIColor(argb: 0x42000000),
                                 dpadMark: UIColor(argb: 0x3D3B8A33))

    static let blue = SkinTheme(name: "蓝色",
                                bodyTop: UIColor(argb: 0xFF5B9BD9),
                                bodyBottom: UIColor(argb: 0xFF2F669E),
                                accent: UIColor(argb: 0xFF2F669E),
                                accentDeep: UIColor(argb: 0xFF224B78),
                                bezel: UIColor(argb: 0xFF0A0A0C),
                                titleText: UIColor(argb: 0xFFEAF4FF),
                                speaker: UIColor(argb: 0x44000000),
                                dpadMark: UIColor(argb: 0x3D2F669E))

    static let red = SkinTheme(name: "红色",
                               bodyTop: UIColor(argb: 0xFFD96B5E),
                               bodyBottom: UIColor(argb: 0xFFA83A30),
                               accent: UIColor(argb: 0xFFA83A30),
                               accentDeep: UIColor(argb: 0xFF7E2A22),
                               bezel: UIColor(argb: 0xFF0A0A0C),
                               titleText: UIColor(argb: 0xFFFFEDEA),
                               speaker: UIColor(argb: 0x44000000),
                               dpadMark: UIColor(argb: 0x3DA83A30))

    static let pink = SkinTheme(name: "粉色",
                                bodyTop: UIColor(argb: 0xFFDE84B4),
                                bodyBottom: UIColor(argb: 0xFFAE5086),
                                accent: UIColor(argb: 0xFFAE5086),
                                accentDeep: UIColor(argb: 0xFF8A3A68),
                                bezel: UIColor(argb: 0xFF0A0A0C),
                                titleText: UIColor(argb: 0xFFFFECF5),
                                speaker: UIColor(argb: 0x44000000),
                                dpadMark: UIColor(argb: 0x3DAE5086))

    static let graphite = SkinTheme(name: "石墨黑",
                                    bodyTop: UIColor(argb: 0xFF3C3C42),
                                    bodyBottom: UIColor(argb: 0xFF1F1F24),
                                    accent: UIColor(argb: 0xFFB9B9C2),
                                    accentDeep: UIColor(argb: 0xFF8E8E96),
                                    bezel: UIColor(argb: 0xFF0A0A0C),
                                    titleText: UIColor(argb: 0xFFE8E8EE),
                                    speaker: UIColor(argb: 0x4C000000),
                                    dpadMark: UIColor(argb: 0x3D9E9EA8))

    /// All themes, in the order the color picker shows them.
    static let all: [SkinTheme] = [purple, green, blue, red, pink, graphite]

    /// Theme for a stored index; out of range falls back to purple.
    static func byIndex(_ index: Int) -> SkinTheme {
        guard index >= 0, index < all.count else { return purple }
        return all[index]
    }
}

private extension UIColor {
    /// Builds a color from a packed 0xAARRGGBB value.
    convenience init(argb: UInt32) {
        self.init(red: CGFloat((argb >> 16) & 0xFF) / 255,
                  green: CGFloat((argb >> 8) & 0xFF) / 255,
                  blue: CGFloat(argb & 0xFF) / 255,
                  alpha: CGFloat((argb >> 24) & 0xFF) / 255)
    }
}
