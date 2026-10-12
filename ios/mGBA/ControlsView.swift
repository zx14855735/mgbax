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
    var onCursorMoved: ((String, CGFloat, CGFloat) -> Void)?
    var onCursorStopped: ((String, CGFloat, CGFloat) -> Void)?
    var editing = false {
        didSet {
            dragTouch = nil
            dragKey = nil
            pointers.removeAll()
            if pressed != 0 {
                pressed = 0
                onKeysChanged?(0)
            }
            setNeedsDisplay()
        }
    }
    private var pressed = 0
    private var turboB = false
    private var turboLit = false
    private var pointers: [ObjectIdentifier: Int] = [:]
    private var centers: [String: CGPoint] = [:]
    private var dpad = CGRect.zero
    private var buttonL = CGRect.zero
    private var buttonR = CGRect.zero
    private var buttonA = CGRect.zero
    private var buttonB = CGRect.zero
    private var buttonSelect = CGRect.zero
    private var buttonStart = CGRect.zero
    private var dpadDefault = CGRect.zero
    private var buttonLDefault = CGRect.zero
    private var buttonRDefault = CGRect.zero
    private var buttonADefault = CGRect.zero
    private var buttonBDefault = CGRect.zero
    private var buttonSelectDefault = CGRect.zero
    private var buttonStartDefault = CGRect.zero
    private var slopA: CGFloat = 18
    private var slopFace: CGFloat = 10
    private var dragTouch: ObjectIdentifier?
    private var dragKey: String?
    private var grab = CGPoint.zero
    private var down = CGPoint.zero
    private var last = CGPoint.zero
    private var dragMoved = false

    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = false
        backgroundColor = .clear
        isMultipleTouchEnabled = true
    }

    required init?(coder: NSCoder) { nil }

    func setCenters(_ next: [String: CGPoint]) {
        centers = next
        if bounds.width > 0 && bounds.height > 0 {
            applyCenters()
            setNeedsDisplay()
        }
    }

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
        snapDefaults()
        applyCenters()
    }

    override func draw(_ rect: CGRect) {
        drawButton(buttonL, "L", (pressed & Self.l) != 0, editing)
        drawButton(buttonR, "R", (pressed & Self.r) != 0, editing)
        drawButton(buttonA, "A", (pressed & Self.A) != 0, editing)
        drawButton(buttonB, "B", turboB ? turboLit : (pressed & Self.B) != 0, editing)
        drawButton(buttonSelect, "SELECT", (pressed & Self.select) != 0, editing)
        drawButton(buttonStart, "START", (pressed & Self.start) != 0, editing)
        drawDpad()
    }

    private func drawButton(_ rect: CGRect, _ label: String, _ down: Bool, _ selected: Bool) {
        let path = UIBezierPath(roundedRect: rect, cornerRadius: 12)
        if down {
            UIColor(red: 80 / 255, green: 210 / 255, blue: 130 / 255, alpha: 70 / 255).setFill()
            path.fill()
        }
        let stroke = selected
            ? UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: 230 / 255)
            : (down ? UIColor(red: 120 / 255, green: 230 / 255, blue: 160 / 255, alpha: 210 / 255) : UIColor(white: 1, alpha: 140 / 255))
        stroke.setStroke()
        path.lineWidth = 2
        path.stroke()
        let attrs: [NSAttributedString.Key: Any] = [
            .font: UIFont.boldSystemFont(ofSize: 14),
            .foregroundColor: UIColor(white: 1, alpha: down || selected ? 230 / 255 : 180 / 255)
        ]
        let text = label as NSString
        let size = text.size(withAttributes: attrs)
        text.draw(at: CGPoint(x: rect.midX - size.width / 2, y: rect.midY - size.height / 2), withAttributes: attrs)
        if selected { drawCursor(rect) }
    }

    private func drawDpad() {
        let cx = dpad.midX
        let cy = dpad.midY
        let arm = dpad.width * 0.28
        let thick = dpad.width * 0.22
        let vertical = CGRect(x: cx - thick, y: cy - arm * 1.6, width: thick * 2, height: arm * 3.2)
        let horizontal = CGRect(x: cx - arm * 1.6, y: cy - thick, width: arm * 3.2, height: thick * 2)
        let stroke = editing
            ? UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: 230 / 255)
            : UIColor(white: 1, alpha: 140 / 255)
        stroke.setStroke()
        for rect in [vertical, horizontal] {
            let path = UIBezierPath(roundedRect: rect, cornerRadius: 10)
            path.lineWidth = 2
            path.stroke()
        }
        if editing { drawCursor(dpad) }
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

    private func drawCursor(_ rect: CGRect) {
        let arm = max(18, min(rect.width, rect.height) * 0.45)
        let path = UIBezierPath()
        path.move(to: CGPoint(x: rect.midX - arm, y: rect.midY))
        path.addLine(to: CGPoint(x: rect.midX + arm, y: rect.midY))
        path.move(to: CGPoint(x: rect.midX, y: rect.midY - arm))
        path.addLine(to: CGPoint(x: rect.midX, y: rect.midY + arm))
        path.move(to: CGPoint(x: rect.midX + 4, y: rect.midY))
        path.addArc(withCenter: CGPoint(x: rect.midX, y: rect.midY), radius: 4, startAngle: 0, endAngle: .pi * 2, clockwise: true)
        UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: 240 / 255).setStroke()
        path.lineWidth = 2
        path.stroke()
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        if editing {
            for touch in touches { beginDrag(touch) }
            return
        }
        for touch in touches {
            pointers[ObjectIdentifier(touch)] = hitTest(touch.location(in: self))
        }
        publish()
    }

    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        if editing {
            for touch in touches { moveDrag(touch) }
            return
        }
        for touch in touches {
            let id = ObjectIdentifier(touch)
            guard let current = pointers[id] else { continue }
            if (current & Self.face) != 0 { continue }
            pointers[id] = hitTest(touch.location(in: self))
        }
        publish()
    }

    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        if editing {
            for touch in touches { endDrag(touch) }
            return
        }
        for touch in touches { pointers.removeValue(forKey: ObjectIdentifier(touch)) }
        publish()
    }

    override func touchesCancelled(_ touches: Set<UITouch>, with event: UIEvent?) {
        if editing {
            for touch in touches {
                if dragTouch == ObjectIdentifier(touch) {
                    dragTouch = nil
                    dragKey = nil
                }
            }
            return
        }
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

    private func beginDrag(_ touch: UITouch) {
        if dragTouch != nil { return }
        let point = touch.location(in: self)
        guard let key = keyAt(point) else { return }
        dragTouch = ObjectIdentifier(touch)
        dragKey = key
        dragMoved = false
        down = point
        let rect = rectFor(key)
        grab = CGPoint(x: point.x - rect.midX, y: point.y - rect.midY)
    }

    private func moveDrag(_ touch: UITouch) {
        guard dragTouch == ObjectIdentifier(touch), let key = dragKey, bounds.width > 0, bounds.height > 0 else { return }
        let point = touch.location(in: self)
        let dx = point.x - down.x
        let dy = point.y - down.y
        if dx * dx + dy * dy > 36 { dragMoved = true }
        if !dragMoved { return }
        last = CGPoint(x: (point.x - grab.x) / bounds.width, y: (point.y - grab.y) / bounds.height)
        onCursorMoved?(key, last.x, last.y)
    }

    private func endDrag(_ touch: UITouch) {
        guard dragTouch == ObjectIdentifier(touch) else { return }
        moveDrag(touch)
        if let key = dragKey, dragMoved {
            onCursorStopped?(key, last.x, last.y)
        }
        dragTouch = nil
        dragKey = nil
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

    private func keyAt(_ point: CGPoint) -> String? {
        if let face = nearestFace(point) {
            if face == Self.A { return "a" }
            if face == Self.B { return "b" }
            if face == Self.l { return "l" }
            if face == Self.r { return "r" }
            if face == Self.select { return "select" }
            if face == Self.start { return "start" }
        }
        return dpad.contains(point) ? "dpad" : nil
    }

    private func rectFor(_ key: String) -> CGRect {
        switch key {
        case "dpad": return dpad
        case "a": return buttonA
        case "b": return buttonB
        case "l": return buttonL
        case "r": return buttonR
        case "select": return buttonSelect
        default: return buttonStart
        }
    }

    private func snapDefaults() {
        dpadDefault = dpad
        buttonLDefault = buttonL
        buttonRDefault = buttonR
        buttonADefault = buttonA
        buttonBDefault = buttonB
        buttonSelectDefault = buttonSelect
        buttonStartDefault = buttonStart
    }

    private func applyCenters() {
        place(&dpad, dpadDefault, "dpad")
        place(&buttonL, buttonLDefault, "l")
        place(&buttonR, buttonRDefault, "r")
        place(&buttonA, buttonADefault, "a")
        place(&buttonB, buttonBDefault, "b")
        place(&buttonSelect, buttonSelectDefault, "select")
        place(&buttonStart, buttonStartDefault, "start")
    }

    private func place(_ rect: inout CGRect, _ base: CGRect, _ key: String) {
        guard base.width > 0, base.height > 0 else { return }
        rect = base
        guard let center = centers[key], bounds.width > 0, bounds.height > 0 else { return }
        let cx = KeyLayout.clampCenter(center.x * bounds.width, rect.width / 2, bounds.width)
        let cy = KeyLayout.clampCenter(center.y * bounds.height, rect.height / 2, bounds.height)
        rect.origin.x += cx - rect.midX
        rect.origin.y += cy - rect.midY
    }
}
