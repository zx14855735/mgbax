import UIKit

final class ControlsView: UIView {
    static let A = 1 << 0
    static let B = 1 << 1
    static let select = 1 << 2
    static let start = 1 << 3
    static let right = 1 << 4
    static let left = 1 << 5
    static let up = 1 << 6
    static let down = 1 << 7
    static let r = 1 << 8
    static let l = 1 << 9
    static let face = A | B | select | start | l | r

    var onKeysChanged: ((Int) -> Void)?
    private var pressed = 0
    private var turboB = false
    private var turboLit = false
    private var pointers: [ObjectIdentifier: Int] = [:]
    private var dpad = CGRect.zero
    private var buttonL = CGRect.zero
    private var buttonR = CGRect.zero
    private var buttonA = CGRect.zero
    private var buttonB = CGRect.zero
    private var buttonSelect = CGRect.zero
    private var buttonStart = CGRect.zero
    private var slopA: CGFloat = 18
    private var slopFace: CGFloat = 10

    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = false
        backgroundColor = .clear
        isMultipleTouchEnabled = true
    }

    required init?(coder: NSCoder) { nil }

    func setBTurbo(active: Bool, lit: Bool) {
        if turboB == active && turboLit == lit { return }
        turboB = active
        turboLit = lit
        setNeedsDisplay()
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        let w = bounds.width
        let h = bounds.height
        let pad: CGFloat = 10
        let dpadSize = min(150, min(w, h) * 0.42)
        dpad = CGRect(x: pad, y: h - pad - dpadSize, width: dpadSize, height: dpadSize)
        buttonL = CGRect(x: pad, y: pad, width: 72, height: 36)
        buttonR = CGRect(x: w - pad - 72, y: pad, width: 72, height: 36)
        let faceA: CGFloat = 76
        let face: CGFloat = 58
        buttonA = CGRect(x: w - pad - faceA, y: h - pad - faceA, width: faceA, height: faceA)
        buttonB = CGRect(x: buttonA.minX - face - 14, y: buttonA.minY - 36, width: face, height: face)
        let menuW: CGFloat = 64
        let menuH: CGFloat = 32
        let menuTop = h - pad - menuH
        let center = w / 2
        buttonSelect = CGRect(x: center - menuW - 8, y: menuTop, width: menuW, height: menuH)
        buttonStart = CGRect(x: center + 8, y: menuTop, width: menuW, height: menuH)
        slopA = 18
        slopFace = 10
    }

    override func draw(_ rect: CGRect) {
        drawButton(buttonL, "L", (pressed & Self.l) != 0)
        drawButton(buttonR, "R", (pressed & Self.r) != 0)
        drawButton(buttonA, "A", (pressed & Self.A) != 0)
        drawButton(buttonB, "B", turboB ? turboLit : (pressed & Self.B) != 0)
        drawButton(buttonSelect, "SELECT", (pressed & Self.select) != 0)
        drawButton(buttonStart, "START", (pressed & Self.start) != 0)
        drawDpad()
    }

    private func drawButton(_ rect: CGRect, _ label: String, _ down: Bool) {
        let path = UIBezierPath(roundedRect: rect, cornerRadius: 12)
        if down {
            UIColor(red: 80 / 255, green: 210 / 255, blue: 130 / 255, alpha: 70 / 255).setFill()
            path.fill()
        }
        (down ? UIColor(red: 120 / 255, green: 230 / 255, blue: 160 / 255, alpha: 210 / 255) : UIColor(white: 1, alpha: 140 / 255)).setStroke()
        path.lineWidth = 2
        path.stroke()
        let attrs: [NSAttributedString.Key: Any] = [
            .font: UIFont.boldSystemFont(ofSize: 14),
            .foregroundColor: UIColor(white: 1, alpha: down ? 230 / 255 : 180 / 255)
        ]
        let text = label as NSString
        let size = text.size(withAttributes: attrs)
        text.draw(at: CGPoint(x: rect.midX - size.width / 2, y: rect.midY - size.height / 2), withAttributes: attrs)
    }

    private func drawDpad() {
        let cx = dpad.midX
        let cy = dpad.midY
        let arm = dpad.width * 0.28
        let thick = dpad.width * 0.22
        let vertical = CGRect(x: cx - thick, y: cy - arm * 1.6, width: thick * 2, height: arm * 3.2)
        let horizontal = CGRect(x: cx - arm * 1.6, y: cy - thick, width: arm * 3.2, height: thick * 2)
        let stroke = UIColor(white: 1, alpha: 140 / 255)
        stroke.setStroke()
        for rect in [vertical, horizontal] {
            let path = UIBezierPath(roundedRect: rect, cornerRadius: 10)
            path.lineWidth = 2
            path.stroke()
        }
        UIColor(red: 80 / 255, green: 210 / 255, blue: 130 / 255, alpha: 70 / 255).setFill()
        if (pressed & Self.up) != 0 {
            UIBezierPath(roundedRect: CGRect(x: cx - thick, y: cy - arm * 1.6, width: thick * 2, height: arm * 1.6), cornerRadius: 10).fill()
        }
        if (pressed & Self.down) != 0 {
            UIBezierPath(roundedRect: CGRect(x: cx - thick, y: cy, width: thick * 2, height: arm * 1.6), cornerRadius: 10).fill()
        }
        if (pressed & Self.left) != 0 {
            UIBezierPath(roundedRect: CGRect(x: cx - arm * 1.6, y: cy - thick, width: arm * 1.6, height: thick * 2), cornerRadius: 10).fill()
        }
        if (pressed & Self.right) != 0 {
            UIBezierPath(roundedRect: CGRect(x: cx, y: cy - thick, width: arm * 1.6, height: thick * 2), cornerRadius: 10).fill()
        }
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches {
            pointers[ObjectIdentifier(touch)] = hitTest(touch.location(in: self))
        }
        publish()
    }

    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches {
            let id = ObjectIdentifier(touch)
            guard let current = pointers[id] else { continue }
            if (current & Self.face) != 0 { continue }
            pointers[id] = hitTest(touch.location(in: self))
        }
        publish()
    }

    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches { pointers.removeValue(forKey: ObjectIdentifier(touch)) }
        publish()
    }

    override func touchesCancelled(_ touches: Set<UITouch>, with event: UIEvent?) {
        for touch in touches { pointers.removeValue(forKey: ObjectIdentifier(touch)) }
        publish()
    }

    private func publish() {
        let mask = pointers.values.reduce(0, |)
        if mask != pressed {
            pressed = mask
            onKeysChanged?(mask)
            setNeedsDisplay()
        }
    }

    private func hitTest(_ point: CGPoint) -> Int {
        if let face = nearestFace(point) { return face }
        guard dpad.contains(point) else { return 0 }
        let dx = point.x - dpad.midX
        let dy = point.y - dpad.midY
        let radius = dpad.width * 0.72
        if dx * dx + dy * dy > radius * radius { return 0 }
        var bits = 0
        if abs(dx) > abs(dy) * 0.35 { bits |= dx > 0 ? Self.right : Self.left }
        if abs(dy) > abs(dx) * 0.35 { bits |= dy > 0 ? Self.down : Self.up }
        return bits
    }

    private func nearestFace(_ point: CGPoint) -> Int? {
        var best = 0
        var bestDist = CGFloat.greatestFiniteMagnitude
        func consider(_ rect: CGRect, _ extra: CGFloat, _ bit: Int) {
            if point.x < rect.minX - extra || point.x >= rect.maxX + extra || point.y < rect.minY - extra || point.y >= rect.maxY + extra {
                return
            }
            let dx = point.x - rect.midX
            let dy = point.y - rect.midY
            let dist = dx * dx + dy * dy
            if dist < bestDist {
                bestDist = dist
                best = bit
            }
        }
        consider(buttonL, slopFace, Self.l)
        consider(buttonR, slopFace, Self.r)
        consider(buttonA, slopA, Self.A)
        consider(buttonB, slopFace, Self.B)
        consider(buttonSelect, slopFace, Self.select)
        consider(buttonStart, slopFace, Self.start)
        return best == 0 ? nil : best
    }
}
