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
    var onScaleChanged: ((String, CGFloat) -> Void)?
    var onSelected: ((String) -> Void)?
    var editing = false {
        didSet {
            dragTouch = nil
            dragKey = nil
            pinchTouch = nil
            pinchActive = false
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
    private var scales: [String: CGFloat] = [:]
    static let minScale: CGFloat = 0.4
    static let maxScale: CGFloat = 3.0
    private var dpad = CGRect.zero
    private var dpadUp = CGRect.zero
    private var dpadDown = CGRect.zero
    private var dpadLeft = CGRect.zero
    private var dpadRight = CGRect.zero
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
    private var pinchTouch: ObjectIdentifier?
    private var pinchActive = false
    private var pinchStartDist: CGFloat = 10
    private var pinchStartScale: CGFloat = 1
    private var lastSelectedKey: String?
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
        let pinch = UIPinchGestureRecognizer(target: self, action: #selector(handlePinch(_:)))
        pinch.cancelsTouchesInView = false
        addGestureRecognizer(pinch)
    }

    required init?(coder: NSCoder) { nil }

    @objc private func handlePinch(_ gesture: UIPinchGestureRecognizer) {
        guard editing else { return }
        let key = dragKey ?? lastSelectedKey
        guard let key else { return }
        switch gesture.state {
        case .began:
            pinchStartScale = scales[key] ?? 1
            onSelected?(key)
        case .changed:
            let next = Self.clampScale(pinchStartScale * gesture.scale)
            scales[key] = next
            applyCenters()
            setNeedsDisplay()
            onScaleChanged?(key, next)
        case .ended, .cancelled:
            let final = scales[key] ?? 1
            onScaleChanged?(key, final)
        default:
            break
        }
    }

    func setCenters(_ next: [String: CGPoint]) {
        centers = next
        if bounds.width > 0 && bounds.height > 0 {
            applyCenters()
            setNeedsDisplay()
        }
    }

    func setScales(_ next: [String: CGFloat]) {
        var clamped: [String: CGFloat] = [:]
        for (key, value) in next {
            clamped[key] = Self.clampScale(value)
        }
        scales = clamped
        if bounds.width > 0 && bounds.height > 0 {
            applyCenters()
            setNeedsDisplay()
        }
    }

    func setKeyScale(_ key: String, _ scale: CGFloat) {
        let clamped = Self.clampScale(scale)
        if abs(clamped - 1) < 0.001 {
            scales.removeValue(forKey: key)
        } else {
            scales[key] = clamped
        }
        if bounds.width > 0 && bounds.height > 0 {
            applyCenters()
            setNeedsDisplay()
        }
    }

    func keyScale(_ key: String) -> CGFloat {
        scales[key] ?? 1
    }

    private static func clampScale(_ value: CGFloat) -> CGFloat {
        min(maxScale, max(minScale, value))
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
        let dpadSize = min(240, min(w, h) * 0.62)
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
        drawDirection(dpadUp, Self.up)
        drawDirection(dpadDown, Self.down)
        drawDirection(dpadLeft, Self.left)
        drawDirection(dpadRight, Self.right)
        if editing { drawCursor(dpad) }
    }

    private func drawDirection(_ rect: CGRect, _ bit: Int) {
        guard rect.width > 0 else { return }
        let down = (pressed & bit) != 0
        let path = UIBezierPath(roundedRect: rect, cornerRadius: 8)
        if down {
            UIColor(red: 80 / 255, green: 210 / 255, blue: 130 / 255, alpha: 90 / 255).setFill()
            path.fill()
        }
        let stroke = editing
            ? UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: 230 / 255)
            : (down ? UIColor(red: 120 / 255, green: 230 / 255, blue: 160 / 255, alpha: 220 / 255) : UIColor(white: 1, alpha: 170 / 255))
        stroke.setStroke()
        path.lineWidth = 2
        path.stroke()
        drawArrow(rect, bit, down)
    }

    private func drawArrow(_ rect: CGRect, _ bit: Int, _ down: Bool) {
        let cx = rect.midX
        let cy = rect.midY
        let a = min(rect.width, rect.height) * 0.36
        let path = UIBezierPath()
        switch bit {
        case Self.up:
            path.move(to: CGPoint(x: cx, y: cy - a))
            path.addLine(to: CGPoint(x: cx + a * 0.92, y: cy + a * 0.7))
            path.addLine(to: CGPoint(x: cx - a * 0.92, y: cy + a * 0.7))
        case Self.down:
            path.move(to: CGPoint(x: cx, y: cy + a))
            path.addLine(to: CGPoint(x: cx + a * 0.92, y: cy - a * 0.7))
            path.addLine(to: CGPoint(x: cx - a * 0.92, y: cy - a * 0.7))
        case Self.left:
            path.move(to: CGPoint(x: cx - a, y: cy))
            path.addLine(to: CGPoint(x: cx + a * 0.7, y: cy - a * 0.92))
            path.addLine(to: CGPoint(x: cx + a * 0.7, y: cy + a * 0.92))
        default:
            path.move(to: CGPoint(x: cx + a, y: cy))
            path.addLine(to: CGPoint(x: cx - a * 0.7, y: cy - a * 0.92))
            path.addLine(to: CGPoint(x: cx - a * 0.7, y: cy + a * 0.92))
        }
        path.close()
        UIColor(white: 1, alpha: down ? 245 / 255 : 210 / 255).setFill()
        path.fill()
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
                let id = ObjectIdentifier(touch)
                if dragTouch == id {
                    dragTouch = nil
                    dragKey = nil
                }
                if pinchTouch == id {
                    pinchTouch = nil
                    pinchActive = false
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
        lastSelectedKey = key
        dragMoved = false
        down = point
        let rect = rectFor(key)
        grab = CGPoint(x: point.x - rect.midX, y: point.y - rect.midY)
        onSelected?(key)
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
        return hitDpad(point)
    }

    private func hitDpad(_ point: CGPoint) -> Int {
        guard dpad.width > 0, dpad.contains(point) else { return 0 }
        var bits = 0
        if hitArm(dpadUp, point) { bits |= Self.up }
        if hitArm(dpadDown, point) { bits |= Self.down }
        if hitArm(dpadLeft, point) { bits |= Self.left }
        if hitArm(dpadRight, point) { bits |= Self.right }
        return bits
    }

    private func hitArm(_ rect: CGRect, _ point: CGPoint) -> Bool {
        let extra = dpad.width * 0.05
        var box = rect
        if rect.midX < dpad.midX {
            box.size.width += extra
        } else if rect.midX > dpad.midX {
            box.origin.x -= extra
            box.size.width += extra
        }
        if rect.midY < dpad.midY {
            box.size.height += extra
        } else if rect.midY > dpad.midY {
            box.origin.y -= extra
            box.size.height += extra
        }
        return box.contains(point)
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
        layoutDpadArms()
    }

    private func layoutDpadArms() {
        guard dpad.width > 0 else { return }
        let size = dpad.width
        let gap = size * 0.06
        let thick = size * 0.34
        let arm = (size - thick - gap * 2) / 2
        let cx = dpad.midX
        let cy = dpad.midY
        dpadUp = CGRect(x: cx - thick / 2, y: dpad.minY, width: thick, height: arm)
        dpadDown = CGRect(x: cx - thick / 2, y: dpad.maxY - arm, width: thick, height: arm)
        dpadLeft = CGRect(x: dpad.minX, y: cy - thick / 2, width: arm, height: thick)
        dpadRight = CGRect(x: dpad.maxX - arm, y: cy - thick / 2, width: arm, height: thick)
    }

    private func place(_ rect: inout CGRect, _ base: CGRect, _ key: String) {
        guard base.width > 0, base.height > 0 else { return }
        let s = Self.clampScale(scales[key] ?? 1)
        let w = base.width * s
        let h = base.height * s
        guard bounds.width > 0, bounds.height > 0 else {
            let cx0 = rect.midX
            let cy0 = rect.midY
            rect = CGRect(x: cx0 - w / 2, y: cy0 - h / 2, width: w, height: h)
            return
        }
        let baseCx = base.midX
        let baseCy = base.midY
        let nx = centers[key]?.x ?? baseCx / bounds.width
        let ny = centers[key]?.y ?? baseCy / bounds.height
        let cx = KeyLayout.clampCenter(nx * bounds.width, w / 2, bounds.width)
        let cy = KeyLayout.clampCenter(ny * bounds.height, h / 2, bounds.height)
        rect = CGRect(x: cx - w / 2, y: cy - h / 2, width: w, height: h)
    }
}
