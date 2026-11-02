/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * Stage behind the game and the keys for the handheld shell. It paints the
 * console body (a gradient or an imported PNG background), the black screen
 * plate with its `mGBAx` model strip, and the green power LED in landscape,
 * mirroring the Android ScreenArea.
 *
 * In portrait the shell fills the lower half, under the upper game screen; in
 * landscape it fills the whole stage and the game sits in a smaller box in the
 * middle.
 */
final class ShellStageView: UIView {
    var portrait = false { didSet { setNeedsDisplay() } }
    var handheld = false {
        didSet {
            isHidden = !handheld
            setNeedsDisplay()
        }
    }
    var theme = SkinTheme.purple { didSet { setNeedsDisplay() } }
    /// Frame of the game picture inside this view, in this view's coordinates.
    var gameFrame = CGRect.zero { didSet { setNeedsDisplay() } }
    /// Optional imported background for the current orientation.
    var background: UIImage? { didSet { setNeedsDisplay() } }

    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = false
        backgroundColor = .clear
        isUserInteractionEnabled = false
        isHidden = true
    }

    required init?(coder: NSCoder) { nil }

    override func draw(_ rect: CGRect) {
        guard handheld, bounds.width > 0, bounds.height > 0, let ctx = UIGraphicsGetCurrentContext() else { return }
        let body: CGRect
        if portrait {
            body = CGRect(x: 0, y: bounds.midY, width: bounds.width, height: bounds.height / 2)
        } else {
            body = bounds
        }
        if let background {
            background.draw(in: body)
        } else {
            drawBody(ctx, body)
        }
        drawScreenPlate(ctx, strip: portrait ? 26 : 34)
    }

    private func drawBody(_ ctx: CGContext, _ body: CGRect) {
        let colors = [theme.bodyTop.cgColor, theme.bodyBottom.cgColor] as CFArray
        guard let gradient = CGGradient(colorsSpace: CGColorSpaceCreateDeviceRGB(),
                                        colors: colors, locations: [0, 1]) else { return }
        ctx.saveGState()
        ctx.clip(to: body)
        ctx.drawLinearGradient(gradient,
                               start: CGPoint(x: body.midX, y: body.minY),
                               end: CGPoint(x: body.midX, y: body.maxY),
                               options: [])
        ctx.restoreGState()
    }

    /**
     * Draws the black screen plate around the game: a rounded bezel extending
     * into a model strip that reads "mGBAx". In landscape a green power LED
     * sits at the strip's right end.
     */
    private func drawScreenPlate(_ ctx: CGContext, strip: CGFloat) {
        guard gameFrame.width > 0, gameFrame.height > 0 else { return }
        let pad: CGFloat = 5
        let left = gameFrame.minX - pad
        let top = gameFrame.minY - pad
        let right = gameFrame.maxX + pad
        let bottom = gameFrame.maxY + strip
        let radius: CGFloat = 12
        let plate = CGRect(x: left, y: top, width: right - left, height: bottom - top)

        ctx.saveGState()
        let path = UIBezierPath(roundedRect: plate, cornerRadius: radius)
        theme.bezel.setFill()
        path.fill()
        UIColor(white: 1, alpha: 0.2).setStroke()
        path.lineWidth = 1
        path.stroke()
        // The screen itself gets a soft inner edge so the picture does not
        // touch the bezel directly.
        let inner = UIBezierPath(rect: gameFrame)
        UIColor(white: 1, alpha: 0.2).setStroke()
        inner.lineWidth = 1
        inner.stroke()

        let title = "mGBAx" as NSString
        if portrait {
            let size = strip * 0.42
            let attrs: [NSAttributedString.Key: Any] = [
                .font: UIFont.boldSystemFont(ofSize: size),
                .foregroundColor: UIColor(red: 231 / 255, green: 178 / 255, blue: 58 / 255, alpha: 1)
            ]
            let textSize = title.size(withAttributes: attrs)
            title.draw(at: CGPoint(x: gameFrame.midX - textSize.width / 2,
                                   y: gameFrame.maxY + strip * 0.72 - textSize.height / 2),
                       withAttributes: attrs)
        } else {
            let size = strip * 0.40
            let attrs: [NSAttributedString.Key: Any] = [
                .font: UIFont.boldSystemFont(ofSize: size),
                .foregroundColor: UIColor(red: 231 / 255, green: 178 / 255, blue: 58 / 255, alpha: 1)
            ]
            let textSize = title.size(withAttributes: attrs)
            title.draw(at: CGPoint(x: gameFrame.midX - textSize.width / 2,
                                   y: gameFrame.maxY + strip * 0.78 - textSize.height / 2),
                       withAttributes: attrs)
            // Power LED at the strip's right end.
            let led = CGRect(x: right - pad - 2.4 * 2.2 - 2.4,
                             y: gameFrame.maxY + strip * 0.5 - 2.4,
                             width: 4.8, height: 4.8)
            UIColor(red: 124 / 255, green: 252 / 255, blue: 0, alpha: 1).setFill()
            UIBezierPath(ovalIn: led).fill()
        }
        ctx.restoreGState()
    }
}
