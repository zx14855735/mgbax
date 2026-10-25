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
    /** Utility-key actions reported through onAction; not part of the key mask. */
    static let actionSave = 1
    static let actionLoad = 2
    static let actionShot = 3
    static let actionFF = 4
    /** Internal markers for the dedicated turbo/LR keys; not part of the mask. */
    private static let flagTurboA = 1 << 20
    private static let flagTurboB = 1 << 21
    private static let flagLR = 1 << 22

    var onKeysChanged: ((Int) -> Void)?
    var onAction: ((Int) -> Void)?
    /// Fired while the on-screen 倍速 utility key is held (fast-forward).
    var onFastHold: ((Bool) -> Void)?
    var onCursorMoved: ((String, CGFloat, CGFloat) -> Void)?
    var onCursorStopped: ((String, CGFloat, CGFloat) -> Void)?
    var onScaleChanged: ((String, CGFloat) -> Void)?
    var onSelected: ((String) -> Void)?
    /// Fired after the keys were placed again, so the menu handle can follow.
    var onLayoutChanged: (() -> Void)?
    var editing = false {
        didSet {
            dragTouch = nil
            dragKey = nil
            pinchTouch = nil
            pinchActive = false
            pointers.removeAll()
            actionPointers.removeAll()
            turboTimer?.invalidate()
            turboTimer = nil
            pulseMask = 0
            pulseOn = false
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
    /// Opacity of the drawn keys, 0.3-1.5 (1 = the stock translucency).
    private var opacity: CGFloat = 1
    /* Optional utility keys: turbo A/B, L+R, quick save/load, fast-forward,
     * screenshot. Hidden until the player turns them on in the settings. */
    private var keyTurboA = CGRect.zero
    private var keyTurboB = CGRect.zero
    private var keyLR = CGRect.zero
    private var keySave = CGRect.zero
    private var keyLoad = CGRect.zero
    private var keyFast = CGRect.zero
    private var keyShot = CGRect.zero
    private var keyTurboADefault = CGRect.zero
    private var keyTurboBDefault = CGRect.zero
    private var keyLRDefault = CGRect.zero
    private var keySaveDefault = CGRect.zero
    private var keyLoadDefault = CGRect.zero
    private var keyFastDefault = CGRect.zero
    private var keyShotDefault = CGRect.zero
    private var visibleExtras: Set<String> = []
    /** When true the d-pad reports only its dominant direction, no diagonals. */
    private var diagonalLock = false
    /* Dedicated turbo keys pulse their bit at this many repeats per second. */
    private var turboRate = 25
    private var pulseMask = 0
    private var pulseOn = false
    private var turboTimer: Timer?
    /** Utility-key taps per touch, so the 倍速 key's release can be matched. */
    private var actionPointers: [ObjectIdentifier: Int] = [:]
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

    /** Overall opacity of the on-screen keys, 30-150 percent. */
    func setOpacity(_ percent: Int) {
        let clamped = CGFloat(min(150, max(30, percent))) / 100
        if clamped == opacity { return }
        opacity = clamped
        setNeedsDisplay()
    }

    /** Shows the optional utility keys named like "ta", "tb", "lr", "save"... */
    func setVisibleExtras(_ keys: Set<String>) {
        visibleExtras = keys
        applyCenters()
        setNeedsDisplay()
    }

    /** One direction at a time on the d-pad. */
    func setDiagonalLock(_ enabled: Bool) {
        diagonalLock = enabled
    }

    /** Repeats per second for the dedicated A/B turbo keys. */
    func setTurboRate(_ rate: Int) {
        turboRate = max(2, min(30, rate))
    }

    /** Base alpha scaled by the opacity setting. */
    private func fade(_ alpha: CGFloat) -> CGFloat {
        min(1, alpha * opacity)
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        let w = bounds.width
        let h = bounds.height
        let pad: CGFloat = 10
        let menuW: CGFloat = 64
        let menuH: CGFloat = 32
        let center = w / 2
        // Keep the d-pad clear of SELECT: on the narrow portrait screen a
        // full sized d-pad would otherwise sit on top of it.
        let dpadRoom = center - menuW - 8 - pad - 6
        var dpadSize = min(240, min(w, h) * 0.62)
        dpadSize = min(dpadSize, max(48, dpadRoom))
        dpad = CGRect(x: pad, y: h - pad - dpadSize, width: dpadSize, height: dpadSize)
        // Shoulder buttons sit a little lower so the top edge stays reachable.
        let shoulderTop = pad + 40
        buttonL = CGRect(x: pad, y: shoulderTop, width: 72, height: 36)
        buttonR = CGRect(x: w - pad - 72, y: shoulderTop, width: 72, height: 36)
        let faceA: CGFloat = 76
        let face: CGFloat = 58
        buttonA = CGRect(x: w - pad - faceA, y: h - pad - faceA, width: faceA, height: faceA)
        buttonB = CGRect(x: buttonA.minX - face - 14, y: buttonA.minY - 36, width: face, height: face)
        let menuTop = h - pad - menuH
        buttonSelect = CGRect(x: center - menuW - 8, y: menuTop, width: menuW, height: menuH)
        buttonStart = CGRect(x: center + 8, y: menuTop, width: menuW, height: menuH)
        // Optional utility keys: defaults sit clear of the stock clusters; the
        // layout editor can drag each of them anywhere.
        let utilW: CGFloat = 56
        let utilH: CGFloat = 34
        let utilTop = menuTop - utilH - 8
        keySave = CGRect(x: buttonSelect.minX, y: utilTop, width: utilW, height: utilH)
        keyLoad = CGRect(x: buttonStart.maxX - utilW, y: utilTop, width: utilW, height: utilH)
        keyFast = CGRect(x: center - utilW / 2, y: utilTop, width: utilW, height: utilH)
        let lrTop = pad + 40 + 36 + 8
        keyLR = CGRect(x: center - utilW, y: lrTop, width: utilW * 2, height: utilH)
        keyShot = CGRect(x: center - utilW / 2, y: lrTop + utilH + 8, width: utilW, height: utilH)
        let turbo: CGFloat = 46
        keyTurboA = CGRect(x: buttonA.minX - 4, y: buttonA.minY - turbo - 6, width: turbo, height: turbo)
        keyTurboB = CGRect(x: keyTurboA.minX - turbo - 8, y: keyTurboA.minY + 10, width: turbo, height: turbo)
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
        if visibleExtras.contains("ta") {
            drawButton(keyTurboA, "A连", (pressed & Self.A) != 0 && pulseOn, editing)
        }
        if visibleExtras.contains("tb") {
            drawButton(keyTurboB, "B连", (pressed & Self.B) != 0 && pulseOn, editing)
        }
        if visibleExtras.contains("lr") {
            drawButton(keyLR, "L+R", (pressed & (Self.l | Self.r)) == (Self.l | Self.r), editing)
        }
        if visibleExtras.contains("save") {
            drawButton(keySave, "快存", actionPointers.values.contains(Self.actionSave), editing)
        }
        if visibleExtras.contains("load") {
            drawButton(keyLoad, "快读", actionPointers.values.contains(Self.actionLoad), editing)
        }
        if visibleExtras.contains("ff") {
            drawButton(keyFast, "倍速", actionPointers.values.contains(Self.actionFF), editing)
        }
        if visibleExtras.contains("shot") {
            drawButton(keyShot, "截图", actionPointers.values.contains(Self.actionShot), editing)
        }
    }

    private func drawButton(_ rect: CGRect, _ label: String, _ down: Bool, _ selected: Bool) {
        let path = UIBezierPath(roundedRect: rect, cornerRadius: 12)
        if down {
            UIColor(red: 80 / 255, green: 210 / 255, blue: 130 / 255, alpha: fade(70 / 255)).setFill()
            path.fill()
        }
        let stroke = selected
            ? UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: fade(230 / 255))
            : (down ? UIColor(red: 120 / 255, green: 230 / 255, blue: 160 / 255, alpha: fade(210 / 255)) : UIColor(white: 1, alpha: fade(140 / 255)))
        stroke.setStroke()
        path.lineWidth = 2
        path.stroke()
        let attrs: [NSAttributedString.Key: Any] = [
            .font: UIFont.boldSystemFont(ofSize: 14),
            .foregroundColor: UIColor(white: 1, alpha: fade(down || selected ? 230 / 255 : 180 / 255))
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
            UIColor(red: 80 / 255, green: 210 / 255, blue: 130 / 255, alpha: fade(90 / 255)).setFill()
            path.fill()
        }
        let stroke = editing
            ? UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: fade(230 / 255))
            : (down ? UIColor(red: 120 / 255, green: 230 / 255, blue: 160 / 255, alpha: fade(220 / 255)) : UIColor(white: 1, alpha: fade(170 / 255)))
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
        UIColor(white: 1, alpha: fade(down ? 245 / 255 : 210 / 255)).setFill()
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
            let point = touch.location(in: self)
            let utility = actionAt(point)
            if utility != 0 {
                actionPointers[ObjectIdentifier(touch)] = utility
                if utility == Self.actionFF {
                    onFastHold?(true)
                } else {
                    onAction?(utility)
                }
                continue
            }
            pointers[ObjectIdentifier(touch)] = hitTest(point)
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
            // Face buttons and the dedicated keys stick until release. A thumb
            // sliding a few pixels used to drop A before the game sampled it.
            if (current & (Self.face | Self.flagTurboA | Self.flagTurboB | Self.flagLR)) != 0 { continue }
            pointers[id] = hitTest(touch.location(in: self))
        }
        publish()
    }

    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        if editing {
            for touch in touches { endDrag(touch) }
            return
        }
        for touch in touches {
            let id = ObjectIdentifier(touch)
            if let held = actionPointers[id] {
                actionPointers.removeValue(forKey: id)
                if held == Self.actionFF { onFastHold?(false) }
                continue
            }
            pointers.removeValue(forKey: id)
        }
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
        pointers.removeAll()
        actionPointers.removeAll()
        onFastHold?(false)
        publish()
    }

    private func publish() {
        publish(computeMask())
    }

    private func publish(_ mask: Int) {
        if mask != pressed {
            pressed = mask
            onKeysChanged?(mask)
            setNeedsDisplay()
        }
    }

    /** Mask implied by the current pointers, including pulsing turbo keys. */
    private func computeMask() -> Int {
        var mask = 0
        var turbo = 0
        for value in pointers.values {
            if (value & Self.flagTurboA) != 0 {
                turbo |= Self.A
            } else if (value & Self.flagTurboB) != 0 {
                turbo |= Self.B
            } else if (value & Self.flagLR) != 0 {
                mask |= Self.l | Self.r
            } else {
                mask |= value
            }
        }
        if turbo != pulseMask {
            pulseMask = turbo
            turboTimer?.invalidate()
            turboTimer = nil
            if pulseMask == 0 {
                pulseOn = false
            } else {
                pulseOn = true
                scheduleTurboTick()
            }
        }
        return mask | (pulseOn ? pulseMask : 0)
    }

    private func scheduleTurboTick() {
        let interval = TimeInterval(max(20, 1000 / max(1, turboRate))) / 1000
        let timer = Timer(timeInterval: interval, repeats: true) { [weak self] _ in
            guard let self, self.pulseMask != 0 else { return }
            self.pulseOn.toggle()
            self.publish()
        }
        RunLoop.main.add(timer, forMode: .common)
        turboTimer = timer
    }

    /** Optional utility key under the point, or 0 (action codes). */
    private func actionAt(_ point: CGPoint) -> Int {
        if visibleExtras.contains("save"), keySave.contains(point) { return Self.actionSave }
        if visibleExtras.contains("load"), keyLoad.contains(point) { return Self.actionLoad }
        if visibleExtras.contains("ff"), keyFast.contains(point) { return Self.actionFF }
        if visibleExtras.contains("shot"), keyShot.contains(point) { return Self.actionShot }
        return 0
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
        if visibleExtras.contains("ta"), keyTurboA.contains(point) { return Self.flagTurboA }
        if visibleExtras.contains("tb"), keyTurboB.contains(point) { return Self.flagTurboB }
        if visibleExtras.contains("lr"), keyLR.contains(point) { return Self.flagLR }
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
        if bits != 0 && diagonalLock {
            // Keep only the dominant direction so a diagonal press reads as
            // one clean input, the way some games expect.
            let dx = point.x - dpad.midX
            let dy = point.y - dpad.midY
            if abs(dx) > abs(dy) {
                return dx > 0 ? Self.right : Self.left
            }
            return dy > 0 ? Self.down : Self.up
        }
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
        if dpad.contains(point) { return "dpad" }
        if visibleExtras.contains("ta"), keyTurboA.contains(point) { return "ta" }
        if visibleExtras.contains("tb"), keyTurboB.contains(point) { return "tb" }
        if visibleExtras.contains("lr"), keyLR.contains(point) { return "lr" }
        if visibleExtras.contains("save"), keySave.contains(point) { return "save" }
        if visibleExtras.contains("load"), keyLoad.contains(point) { return "load" }
        if visibleExtras.contains("ff"), keyFast.contains(point) { return "ff" }
        if visibleExtras.contains("shot"), keyShot.contains(point) { return "shot" }
        return nil
    }

    private func rectFor(_ key: String) -> CGRect {
        switch key {
        case "dpad": return dpad
        case "a": return buttonA
        case "b": return buttonB
        case "l": return buttonL
        case "r": return buttonR
        case "select": return buttonSelect
        case "ta": return keyTurboA
        case "tb": return keyTurboB
        case "lr": return keyLR
        case "save": return keySave
        case "load": return keyLoad
        case "ff": return keyFast
        case "shot": return keyShot
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
        keyTurboADefault = keyTurboA
        keyTurboBDefault = keyTurboB
        keyLRDefault = keyLR
        keySaveDefault = keySave
        keyLoadDefault = keyLoad
        keyFastDefault = keyFast
        keyShotDefault = keyShot
    }

    private func applyCenters() {
        place(&dpad, dpadDefault, "dpad")
        place(&buttonL, buttonLDefault, "l")
        place(&buttonR, buttonRDefault, "r")
        place(&buttonA, buttonADefault, "a")
        place(&buttonB, buttonBDefault, "b")
        place(&buttonSelect, buttonSelectDefault, "select")
        place(&buttonStart, buttonStartDefault, "start")
        if visibleExtras.contains("ta") { place(&keyTurboA, keyTurboADefault, "ta") }
        if visibleExtras.contains("tb") { place(&keyTurboB, keyTurboBDefault, "tb") }
        if visibleExtras.contains("lr") { place(&keyLR, keyLRDefault, "lr") }
        if visibleExtras.contains("save") { place(&keySave, keySaveDefault, "save") }
        if visibleExtras.contains("load") { place(&keyLoad, keyLoadDefault, "load") }
        if visibleExtras.contains("ff") { place(&keyFast, keyFastDefault, "ff") }
        if visibleExtras.contains("shot") { place(&keyShot, keyShotDefault, "shot") }
        layoutDpadArms()
        onLayoutChanged?()
    }

    /// Current bounds of the START key, in this view's coordinates.
    func startButtonRect() -> CGRect {
        buttonStart
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
