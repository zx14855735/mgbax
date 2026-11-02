/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * The GIF recording float ball: a small draggable dot that floats over the
 * game; a tap starts or stops the recording. Dragging snaps it to the nearer
 * screen edge, and its position survives restarts through the app's defaults.
 * An in-window view, not a system overlay, so no permission is needed.
 *
 * A Swift port of the Android `GifBall`.
 */
final class GifBall: UIControl {
    /// Called on a tap (a drag never toggles).
    var onTap: (() -> Void)?
    /// Called after a drag so the owner can remember the new position.
    var onMoved: (() -> Void)?

    private var recording = false
    private var moved = false
    private var downPoint: CGPoint = .zero

    static let side: CGFloat = 40

    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = .clear
        isOpaque = false
        accessibilityLabel = "GIF 录像"
    }

    required init?(coder: NSCoder) { nil }

    func setRecording(_ value: Bool) {
        recording = value
        setNeedsDisplay()
    }

    override func draw(_ rect: CGRect) {
        let radius = bounds.width / 2 - 2
        let center = CGPoint(x: bounds.midX, y: bounds.midY)
        let fill = recording
            ? UIColor(red: 0.72, green: 0.11, blue: 0.11, alpha: 0.8)
            : UIColor(red: 0.11, green: 0.37, blue: 0.13, alpha: 0.8)
        let circle = CGRect(x: center.x - radius, y: center.y - radius,
                            width: radius * 2, height: radius * 2)
        fill.setFill()
        UIBezierPath(ovalIn: circle).fill()
        UIColor(white: 1, alpha: 0.9).setStroke()
        let ring = UIBezierPath(ovalIn: circle.insetBy(dx: 1, dy: 1))
        ring.lineWidth = 2
        ring.stroke()

        let text = recording ? "■" : "GIF"
        let attributes: [NSAttributedString.Key: Any] = [
            .font: UIFont.systemFont(ofSize: 11),
            .foregroundColor: UIColor.white
        ]
        let size = (text as NSString).size(withAttributes: attributes)
        (text as NSString).draw(at: CGPoint(x: center.x - size.width / 2,
                                             y: center.y - size.height / 2),
                                 withAttributes: attributes)
    }

    // MARK: - Dragging

    override func beginTracking(_ touch: UITouch, with event: UIEvent?) -> Bool {
        moved = false
        downPoint = touch.location(in: superview ?? self)
        return true
    }

    override func continueTracking(_ touch: UITouch, with event: UIEvent?) -> Bool {
        let point = touch.location(in: superview ?? self)
        if abs(point.x - downPoint.x) > 4 || abs(point.y - downPoint.y) > 4 {
            moved = true
        }
        let limits = superview?.bounds.size ?? bounds.size
        let half = CGSize(width: bounds.width / 2, height: bounds.height / 2)
        center = CGPoint(x: min(max(point.x, half.width), max(half.width, limits.width - half.width)),
                         y: min(max(point.y, half.height), max(half.height, limits.height - half.height)))
        return true
    }

    override func endTracking(_ touch: UITouch, with event: UIEvent?) {
        if moved {
            // Stick to the nearer horizontal edge; a drag never toggles.
            let limits = superview?.bounds.size ?? bounds.size
            let target = center.x < limits.width / 2 ? bounds.width / 2 : limits.width - bounds.width / 2
            UIView.animate(withDuration: 0.15) {
                self.center.x = target
            }
            // The position changed: let the owner remember it.
            onMoved?()
            return
        }
        onTap?()
        super.endTracking(touch, with: event)
    }
}
