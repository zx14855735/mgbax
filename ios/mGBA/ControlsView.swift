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
    /** Toggle fast-forward on/off (the portrait shell switch). */
    static let actionFFToggle = 5
    static let actionMenu = 6
    static let actionMute = 7
    /** Original rewind control: opens the seconds bar. */
    static let actionRewind = 8
    /** Extra shortcut key: one tap rewinds a few seconds, no menu needed. */
    static let actionRewindQuick = 9
    /** Button styles: the classic translucent outlines or the handheld shell. */
    static let styleClassic = 0
    static let styleHandheld = 1
    /** Internal markers for the dedicated turbo/LR/macro keys; not in the mask. */
    private static let flagTurboA = 1 << 20
    private static let flagTurboB = 1 << 21
    private static let flagLR = 1 << 22
    private static let flagC = 1 << 23
    private static let flagC2 = 1 << 24

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
    /* Optional utility keys: turbo A/B, L+R, C/C2 macros, quick save/load,
     * fast-forward, screenshot. Hidden until the player turns them on. */
    private var keyTurboA = CGRect.zero
    private var keyTurboB = CGRect.zero
    private var keyLR = CGRect.zero
    private var keyC = CGRect.zero
    private var keyC2 = CGRect.zero
    private var keySave = CGRect.zero
    private var keyLoad = CGRect.zero
    private var keyFast = CGRect.zero
    private var keyShot = CGRect.zero
    private var keyRewind = CGRect.zero
    private var keyTurboADefault = CGRect.zero
    private var keyTurboBDefault = CGRect.zero
    private var keyLRDefault = CGRect.zero
    private var keyCDefault = CGRect.zero
    private var keyC2Default = CGRect.zero
    private var keySaveDefault = CGRect.zero
    private var keyLoadDefault = CGRect.zero
    private var keyFastDefault = CGRect.zero
    private var keyShotDefault = CGRect.zero
    private var keyRewindDefault = CGRect.zero
    /** Seconds printed on the extra one-tap rewind key. */
    private var quickRewindSeconds = 2

    func setQuickRewindSeconds(_ seconds: Int) {
        quickRewindSeconds = min(10, max(1, seconds))
        setNeedsDisplay()
    }

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

    // == Handheld shell skin ==
    private var skinStyle = ControlsView.styleHandheld
    private var theme = SkinTheme.purple
    private var portrait = false
    private var ffOn = false
    private var muted = false
    /** Full PNG skin overlays: button key -> image, "_p" suffix = pressed. */
    private var skinBitmaps: [String: UIImage] = [:]
    /** Fixed chrome of the portrait shell: the icon toolbar and its buttons. */
    private var toolbar = CGRect.zero
    private var toolbarMenu = CGRect.zero
    private var toolbarSave = CGRect.zero
    private var toolbarLoad = CGRect.zero
    private var toolbarMute = CGRect.zero
    private var toolbarRewind = CGRect.zero
    private var toggle = CGRect.zero
    /** Decorative speaker holes, recomputed per size. */
    private var speakerRects: [CGRect] = []
    /** Macro keys C and C2 press this combination of console keys while held. */
    private var macroMaskC = ControlsView.A | ControlsView.B
    private var macroMaskC2 = ControlsView.l | ControlsView.r

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

    /** Selects the button drawing style and shell colors. */
    func setSkin(style: Int, theme: SkinTheme) {
        skinStyle = style == Self.styleClassic ? Self.styleClassic : Self.styleHandheld
        self.theme = theme
        computeDefaults()
        applyCenters()
        setNeedsDisplay()
    }

    /** Replaces shell drawing with an imported PNG skin pack. */
    func setFullSkin(_ bitmaps: [String: UIImage]?) {
        skinBitmaps = bitmaps ?? [:]
        setNeedsDisplay()
    }

    /** Re-lays the stock keys for the current screen orientation. */
    func setPortrait(_ on: Bool) {
        if portrait == on { return }
        portrait = on
        computeDefaults()
        applyCenters()
        setNeedsDisplay()
    }

    /** Shell switch state (fast-forward), drawn in the portrait shell. */
    func setFastForwardOn(_ on: Bool) {
        if ffOn == on { return }
        ffOn = on
        setNeedsDisplay()
    }

    func setMuted(_ muted: Bool) {
        if self.muted == muted { return }
        self.muted = muted
        setNeedsDisplay()
    }

    /** Which console keys each macro key (0 = C, 1 = C2) holds down. */
    func setMacro(_ index: Int, _ mask: Int) {
        if index == 0 {
            macroMaskC = mask
        } else {
            macroMaskC2 = mask
        }
        setNeedsDisplay()
    }

    func macro(_ index: Int) -> Int {
        index == 0 ? macroMaskC : macroMaskC2
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
    // 红色模塑键帽的配色（与 Android 的 ControlsView 同一套）
    private static let keyRing = UIColor(red: 0x14 / 255, green: 0x10 / 255, blue: 0x0F / 255, alpha: 1)
    private static let keyFaceTop = UIColor(red: 0xCF / 255, green: 0x3A / 255, blue: 0x40 / 255, alpha: 1)
    private static let keyFaceBottom = UIColor(red: 0x9C / 255, green: 0x1F / 255, blue: 0x24 / 255, alpha: 1)
    private static let keyInk = UIColor(red: 0x67 / 255, green: 0x11 / 255, blue: 0x15 / 255, alpha: 1)
    private static let keyHub = UIColor(red: 0x8B / 255, green: 0x1C / 255, blue: 0x21 / 255, alpha: 1)

    /// 渐变缓存：按透明度分档，避免每帧重复创建。
    private var shadeCache: [String: CGGradient] = [:]

    private func fadedGradient(_ key: String, _ colors: [UIColor], _ locations: [CGFloat]) -> CGGradient? {
        let step = Int(fade(1) * 10)
        let cacheKey = "\(key)-\(step)"
        if let cached = shadeCache[cacheKey] {
            return cached
        }
        let space = CGColorSpaceCreateDeviceRGB()
        guard let made = CGGradient(colorsSpace: space, colors: colors as CFArray, locations: locations) else {
            return nil
        }
        shadeCache[cacheKey] = made
        return made
    }

    private func fade(_ alpha: CGFloat) -> CGFloat {
        min(1, alpha * opacity)
    }

    private func color(_ color: UIColor, alpha: CGFloat) -> UIColor {
        color.withAlphaComponent(fade(alpha))
    }

    private func handheld() -> Bool {
        skinStyle == Self.styleHandheld
    }

    private func bDown() -> Bool {
        turboB ? turboLit : (pressed & Self.B) != 0
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        computeDefaults()
        applyCenters()
    }

    // MARK: - Stock layouts

    /**
     * Rebuilds the stock key boxes for the current style and orientation. The
     * stored (normalized) centers from the layout editor then move each key
     * around its default.
     */
    private func computeDefaults() {
        let w = bounds.width
        let h = bounds.height
        guard w > 0, h > 0 else { return }
        if !handheld() {
            computeClassicDefaults(w, h)
        } else if portrait {
            computePortraitShellDefaults(w, h)
        } else {
            computeLandscapeShellDefaults(w, h)
        }
    }

    /** The original outline-style layout, used by both orientations. */
    private func computeClassicDefaults(_ w: CGFloat, _ h: CGFloat) {
        let pad: CGFloat = 10
        let menuW: CGFloat = 64
        let menuH: CGFloat = 32
        let center = w / 2
        // Keep the d-pad clear of SELECT: on the narrow portrait screen a
        // full sized d-pad would otherwise sit on top of it.
        let dpadRoom = center - menuW - 8 - pad - 6
        var dpadSize = min(240, min(w, h) * 0.62)
        dpadSize = min(dpadSize, max(48, dpadRoom))
        dpadDefault = CGRect(x: pad, y: h - pad - dpadSize, width: dpadSize, height: dpadSize)
        // Shoulder buttons sit a little lower so the top edge stays reachable.
        let shoulderTop = pad + 40
        buttonLDefault = CGRect(x: pad, y: shoulderTop, width: 72, height: 36)
        buttonRDefault = CGRect(x: w - pad - 72, y: shoulderTop, width: 72, height: 36)
        let faceA: CGFloat = 76
        let face: CGFloat = 58
        buttonADefault = CGRect(x: w - pad - faceA, y: h - pad - faceA, width: faceA, height: faceA)
        buttonBDefault = CGRect(x: buttonADefault.minX - face - 14, y: buttonADefault.minY - 36, width: face, height: face)
        let menuTop = h - pad - menuH
        buttonSelectDefault = CGRect(x: center - menuW - 8, y: menuTop, width: menuW, height: menuH)
        buttonStartDefault = CGRect(x: center + 8, y: menuTop, width: menuW, height: menuH)
        // Optional utility keys: defaults sit clear of the stock clusters; the
        // layout editor can drag each of them anywhere.
        let utilW: CGFloat = 56
        let utilH: CGFloat = 34
        let utilTop = menuTop - utilH - 8
        keySaveDefault = CGRect(x: buttonSelectDefault.minX, y: utilTop, width: utilW, height: utilH)
        keyLoadDefault = CGRect(x: buttonStartDefault.maxX - utilW, y: utilTop, width: utilW, height: utilH)
        keyFastDefault = CGRect(x: center - utilW / 2, y: utilTop, width: utilW, height: utilH)
        let lrTop = shoulderTop + 36 + 8
        keyLRDefault = CGRect(x: center - utilW, y: lrTop, width: utilW * 2, height: utilH)
        keyShotDefault = CGRect(x: center - utilW / 2, y: lrTop + utilH + 8, width: utilW, height: utilH)
        keyRewindDefault = CGRect(x: keyShotDefault.maxX + 8, y: keyShotDefault.minY, width: utilW, height: utilH)
        let turbo: CGFloat = 46
        keyTurboADefault = CGRect(x: buttonADefault.minX - 4, y: buttonADefault.minY - turbo - 6, width: turbo, height: turbo)
        keyTurboBDefault = CGRect(x: keyTurboADefault.minX - turbo - 8, y: keyTurboADefault.minY + 10, width: turbo, height: turbo)
        let cSize: CGFloat = 44
        keyCDefault = CGRect(x: buttonBDefault.minX - cSize - 10, y: buttonBDefault.minY, width: cSize, height: cSize)
        keyC2Default = CGRect(x: buttonADefault.minX, y: buttonADefault.minY - cSize - 10, width: cSize, height: cSize)
    }

    /**
     * Portrait shell (Pizza Boy style): a black icon toolbar between the L/R
     * pills, the fast-forward switch in the top right, a big white cross
     * d-pad at the lower left, round A/B keys at the right and the pill
     * SELECT/START pair at the bottom center.
     */
    private func computePortraitShellDefaults(_ w: CGFloat, _ h: CGFloat) {
        let fw = w / 100
        let fh = h / 100

        // Toolbar row: L ... toolbar ... R all on one line.
        let rowTop = 10.5 * fh
        let rowH = 13 * fh
        let pillW = 15 * fw
        buttonLDefault = CGRect(x: 3 * fw, y: rowTop, width: pillW, height: rowH)
        buttonRDefault = CGRect(x: w - 3 * fw - pillW, y: rowTop, width: pillW, height: rowH)
        let barW = 40 * fw
        toolbar = CGRect(x: 50 * fw - barW / 2, y: rowTop, width: barW, height: rowH)
        layoutToolbar()

        // Fast-forward switch, above the row at the right edge.
        toggle = CGRect(x: w - 22 * fw, y: 0.6 * fh, width: 19 * fw, height: 7.5 * fh)

        // D-pad: big cross at the lower left.
        let dpadSize = 46 * fw
        let dLeft = 3 * fw
        let dTop = 62 * fh - dpadSize / 2
        dpadDefault = CGRect(x: dLeft, y: dTop, width: dpadSize, height: dpadSize)

        // A/B round keys: A upper right, B lower left of it.
        let faceR = 13 * fw
        let ax = 82 * fw
        let ay = 47 * fh
        buttonADefault = CGRect(x: ax - faceR, y: ay - faceR, width: faceR * 2, height: faceR * 2)
        let bx = 66 * fw
        let by = 76 * fh
        buttonBDefault = CGRect(x: bx - faceR, y: by - faceR, width: faceR * 2, height: faceR * 2)

        // SELECT / START pills at the bottom center.
        let pillH = 7.5 * fh
        let pillW2 = 17 * fw
        let pillTop = 91.5 * fh - pillH / 2
        buttonSelectDefault = CGRect(x: 28 * fw - pillW2 / 2, y: pillTop, width: pillW2, height: pillH)
        buttonStartDefault = CGRect(x: 52 * fw - pillW2 / 2, y: pillTop, width: pillW2, height: pillH)

        // Optional utility keys: a small row under the toolbar; turbo keys
        // ride next to A/B; the C macro keys sit beside the face cluster.
        let utilW = 11 * fw
        let utilH = 7 * fh
        let utilTop = rowTop + rowH + 3 * fh
        keySaveDefault = CGRect(x: 18 * fw, y: utilTop, width: utilW, height: utilH)
        keyLoadDefault = CGRect(x: 31 * fw, y: utilTop, width: utilW, height: utilH)
        keyFastDefault = CGRect(x: 44 * fw, y: utilTop, width: utilW, height: utilH)
        keyShotDefault = CGRect(x: 57 * fw, y: utilTop, width: utilW, height: utilH)
        keyRewindDefault = CGRect(x: 83 * fw, y: utilTop, width: utilW, height: utilH)
        keyLRDefault = CGRect(x: 70 * fw, y: utilTop, width: utilW, height: utilH)
        let turbo = 9 * fw
        keyTurboADefault = CGRect(x: buttonADefault.minX - turbo - 2 * fw, y: buttonADefault.minY + 2 * fh, width: turbo, height: turbo)
        keyTurboBDefault = CGRect(x: buttonBDefault.minX - turbo - 2 * fw, y: buttonBDefault.minY - 2 * fh, width: turbo, height: turbo)
        let cSize = 9.5 * fw
        keyCDefault = CGRect(x: buttonBDefault.minX - cSize - 3 * fw, y: buttonBDefault.midY - cSize / 2, width: cSize, height: cSize)
        keyC2Default = CGRect(x: buttonADefault.midX - cSize / 2, y: buttonADefault.minY - cSize - 2 * fh, width: cSize, height: cSize)
        layoutSpeakerPortrait(w, h)
        // The portrait shell starts smaller so thumbs wrap the keys without
        // covering them; the layout editor can scale each one up again.
        shrink(&dpadDefault, 0.8)
        shrink(&buttonLDefault, 0.85)
        shrink(&buttonRDefault, 0.85)
        shrink(&buttonADefault, 0.8)
        shrink(&buttonBDefault, 0.8)
        shrink(&buttonSelectDefault, 0.8)
        shrink(&buttonStartDefault, 0.8)
        shrink(&keyTurboADefault, 0.8)
        shrink(&keyTurboBDefault, 0.8)
        shrink(&keyLRDefault, 0.8)
        shrink(&keyCDefault, 0.8)
        shrink(&keyC2Default, 0.8)
        shrink(&keySaveDefault, 0.8)
        shrink(&keyLoadDefault, 0.8)
        shrink(&keyFastDefault, 0.8)
        shrink(&keyShotDefault, 0.8)
        shrink(&keyRewindDefault, 0.8)
    }

    /** Landscape shell (GBA hardware style): d-pad left, A/B right, slanted
     * SELECT/START pills near the screen, speaker slots at the lower right. */
    private func computeLandscapeShellDefaults(_ w: CGFloat, _ h: CGFloat) {
        let fw = w / 100
        let fh = h / 100

        let dpadSize = 26 * fh
        let dLeft = 5 * fw
        let dTop = 56 * fh - dpadSize / 2
        dpadDefault = CGRect(x: dLeft, y: dTop, width: dpadSize, height: dpadSize)

        let faceR = 9.5 * fh
        let ax = 88 * fw
        let ay = 40 * fh
        buttonADefault = CGRect(x: ax - faceR, y: ay - faceR, width: faceR * 2, height: faceR * 2)
        let bx = 80 * fw
        let by = 72 * fh
        buttonBDefault = CGRect(x: bx - faceR, y: by - faceR, width: faceR * 2, height: faceR * 2)

        // START/SELECT: small pills angled like the real console, below the
        // screen between d-pad and A/B. The boxes stay axis-aligned; only
        // the drawing is rotated.
        let pillW = 11 * fw
        let pillH = 6.5 * fh
        buttonStartDefault = CGRect(x: 30 * fw - pillW / 2, y: 76 * fh - pillH / 2, width: pillW, height: pillH)
        buttonSelectDefault = CGRect(x: 30 * fw - pillW / 2 - 1 * fw, y: 87 * fh - pillH / 2, width: pillW, height: pillH)

        // Shoulders sit below the floating menu bar's two rows (button row
        // plus the save-path strip), so opening the menu cannot cover them.
        let shoulderTop: CGFloat = 78
        buttonLDefault = CGRect(x: 2, y: shoulderTop, width: 72, height: 36)
        buttonRDefault = CGRect(x: w - 74, y: shoulderTop, width: 72, height: 36)

        // Utility keys tuck into the free space below the shoulders.
        let utilW = 9 * fw
        let utilH = 8.5 * fh
        let utilTop = 12 * fh
        keySaveDefault = CGRect(x: 40 * fw, y: utilTop, width: utilW, height: utilH)
        keyLoadDefault = CGRect(x: 50 * fw, y: utilTop, width: utilW, height: utilH)
        keyFastDefault = CGRect(x: 60 * fw, y: utilTop, width: utilW, height: utilH)
        keyShotDefault = CGRect(x: 70 * fw, y: utilTop, width: utilW, height: utilH)
        keyRewindDefault = CGRect(x: 81 * fw, y: utilTop, width: utilW, height: utilH)
        keyLRDefault = CGRect(x: 45 * fw, y: 82 * fh, width: utilW + 6 * fw, height: utilH)
        keyTurboADefault = CGRect(x: buttonADefault.minX - utilW - 1.5 * fw, y: buttonADefault.minY, width: utilW, height: utilH)
        keyTurboBDefault = CGRect(x: buttonBDefault.minX - utilW - 1.5 * fw, y: buttonBDefault.minY, width: utilW, height: utilH)
        let cSize = 7 * fh
        keyCDefault = CGRect(x: buttonBDefault.minX - cSize - 2 * fw, y: buttonBDefault.midY - cSize / 2, width: cSize, height: cSize)
        keyC2Default = CGRect(x: buttonADefault.midX - cSize / 2, y: buttonADefault.minY - cSize - 2 * fh, width: cSize, height: cSize)
        // On-screen toolbar (menu/save/load/mute/rewind) is shell chrome in both
        // orientations; lay it out along the top center so rewind is reachable
        // without opening the menu.
        let tBarW = 52 * fw
        let tRowTop = 1.5 * fh
        let tRowH = 6 * fh
        toolbar = CGRect(x: 50 * fw - tBarW / 2, y: tRowTop, width: tBarW, height: tRowH)
        layoutToolbar()
        layoutSpeakerLandscape(w, h)
    }

    /** Scales a default key box around its center. */
    private func shrink(_ rect: inout CGRect, _ factor: CGFloat) {
        let cx = rect.midX
        let cy = rect.midY
        rect = CGRect(x: cx - rect.width * factor / 2, y: cy - rect.height * factor / 2,
                      width: rect.width * factor, height: rect.height * factor)
    }

    private func layoutToolbar() {
        let pad: CGFloat = 2.5
        let inner = toolbar.width - pad * 2
        let cell = inner / 5
        toolbarMenu = CGRect(x: toolbar.minX + pad, y: toolbar.minY + pad, width: cell, height: toolbar.height - pad * 2)
        toolbarSave = CGRect(x: toolbarMenu.maxX, y: toolbarMenu.minY, width: cell, height: toolbarMenu.height)
        toolbarLoad = CGRect(x: toolbarSave.maxX, y: toolbarSave.minY, width: cell, height: toolbarSave.height)
        toolbarMute = CGRect(x: toolbarLoad.maxX, y: toolbarLoad.minY, width: cell, height: toolbarLoad.height)
        toolbarRewind = CGRect(x: toolbarMute.maxX, y: toolbarMute.minY, width: toolbar.maxX - pad - toolbarMute.maxX, height: toolbarMute.height)
    }

    private func layoutSpeakerPortrait(_ w: CGFloat, _ h: CGFloat) {
        speakerRects.removeAll()
        let cols: CGFloat = 5
        let rows: CGFloat = 3
        let cell: CGFloat = 2.6
        let gap: CGFloat = 1.9
        let gridW = cols * cell + (cols - 1) * gap
        let gridH = rows * cell + (rows - 1) * gap
        let x0 = w - gridW - 4.5
        let y0 = h - gridH - 3.5
        for r in 0..<Int(rows) {
            for c in 0..<Int(cols) {
                let x = x0 + CGFloat(c) * (cell + gap)
                let y = y0 + CGFloat(r) * (cell + gap)
                speakerRects.append(CGRect(x: x, y: y, width: cell, height: cell))
            }
        }
    }

    private func layoutSpeakerLandscape(_ w: CGFloat, _ h: CGFloat) {
        speakerRects.removeAll()
        let slots: CGFloat = 6
        let len: CGFloat = 7
        let thick: CGFloat = 1.6
        let gap: CGFloat = 3.2
        let x0 = w - 9 - len
        let y0 = h - (slots * gap + 4)
        for s in 0..<Int(slots) {
            let y = y0 + CGFloat(s) * gap
            speakerRects.append(CGRect(x: x0, y: y, width: len, height: thick))
        }
    }

    // MARK: - Drawing

    override func draw(_ rect: CGRect) {
        let shell = handheld()
        if shell && !editing && toolbar.width > 0 {
            drawToolbar()
        }
        if shell && portrait && !editing && !toggle.isEmpty {
            drawToggle()
        }
        drawKey(buttonL, "L", (pressed & Self.l) != 0, editing, false)
        drawKey(buttonR, "R", (pressed & Self.r) != 0, editing, false)
        drawKey(buttonA, "A", (pressed & Self.A) != 0, editing, true)
        drawKey(buttonB, "B", bDown(), editing, true)
        drawKey(buttonSelect, "SELECT", (pressed & Self.select) != 0, editing, false)
        drawKey(buttonStart, "START", (pressed & Self.start) != 0, editing, false)
        drawDpad()
        if shell && portrait {
            drawSpeaker()
        } else if shell {
            drawSpeakerSlots()
        }
        if visibleExtras.contains("ta") {
            drawKey(keyTurboA, "A连", (pressed & Self.A) != 0 && pulseOn, editing, true)
        }
        if visibleExtras.contains("tb") {
            drawKey(keyTurboB, "B连", (pressed & Self.B) != 0 && pulseOn, editing, true)
        }
        if visibleExtras.contains("lr") {
            drawKey(keyLR, "L+R", (pressed & (Self.l | Self.r)) == (Self.l | Self.r), editing, false)
        }
        if visibleExtras.contains("c") {
            drawKey(keyC, "C", (pressed & macroMaskC) == macroMaskC && macroMaskC != 0, editing, true)
        }
        if visibleExtras.contains("c2") {
            drawKey(keyC2, "C2", (pressed & macroMaskC2) == macroMaskC2 && macroMaskC2 != 0, editing, true)
        }
        if visibleExtras.contains("save") {
            drawKey(keySave, "存", actionPointers.values.contains(Self.actionSave), editing, false)
        }
        if visibleExtras.contains("load") {
            drawKey(keyLoad, "读", actionPointers.values.contains(Self.actionLoad), editing, false)
        }
        if visibleExtras.contains("ff") {
            drawKey(keyFast, "倍速", actionPointers.values.contains(Self.actionFF), editing, false)
        }
        if visibleExtras.contains("shot") {
            drawKey(keyShot, "截图", actionPointers.values.contains(Self.actionShot), editing, false)
        }
        if visibleExtras.contains("rewind") {
            drawKey(keyRewind, "倒带\(quickRewindSeconds)s",
                    actionPointers.values.contains(Self.actionRewindQuick), editing, false)
        }
    }

    private func drawKey(_ rect: CGRect, _ label: String, _ down: Bool, _ selected: Bool, _ round: Bool) {
        guard rect.width > 0, rect.height > 0 else { return }
        if handheld() {
            drawShellKey(rect, label, down, selected, round)
        } else {
            drawClassicKey(rect, label, down, selected)
        }
    }

    private func drawClassicKey(_ rect: CGRect, _ label: String, _ down: Bool, _ selected: Bool) {
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

    /** White shell button: pill or circle with an accent letter. The fill
     * starts translucent; raising the opacity control brings it to white. */
    private func drawShellKey(_ rect: CGRect, _ label: String, _ down: Bool, _ selected: Bool, _ round: Bool) {
        if let key = Self.labelToKey(label), let bitmap = skinBitmaps[down ? key + "_p" : key] {
            bitmap.draw(in: rect)
        } else if let key = Self.labelToKey(label), let bitmap = skinBitmaps[key] {
            bitmap.draw(in: rect)
            if down {
                let path = round
                    ? UIBezierPath(ovalIn: rect)
                    : UIBezierPath(roundedRect: rect, cornerRadius: rect.height / 2.4)
                color(theme.accentDeep, alpha: 110 / 255).setFill()
                path.fill()
            }
        } else {
            drawShellButton(rect, label, down, selected, round)
        }
        if selected { drawCursor(rect) }
    }

    private func drawShellButton(_ rect: CGRect, _ label: String, _ down: Bool, _ selected: Bool, _ round: Bool) {
        let radius = round ? min(rect.width, rect.height) / 2 : rect.height / 2.4
        let path = round
            ? UIBezierPath(ovalIn: rect)
            : UIBezierPath(roundedRect: rect, cornerRadius: radius)
        guard let context = UIGraphicsGetCurrentContext() else { return }
        // 深色底环 + 落在下方的投影
        context.saveGState()
        context.setShadow(offset: CGSize(width: 0, height: 2), blur: 2.5,
                          color: color(UIColor.black, alpha: 0.35).cgColor)
        color(Self.keyRing, alpha: 1).setFill()
        path.fill()
        context.restoreGState()
        // 键面：垂直渐变的红色塑料
        context.saveGState()
        context.addPath(path.cgPath)
        context.clip()
        let top = down ? color(Self.keyFaceBottom, alpha: 1) : color(Self.keyFaceTop, alpha: 1)
        let bottom = color(Self.keyFaceBottom, alpha: 1)
        if let gradient = fadedGradient("face", [top, bottom], [0, 1]) {
            context.drawLinearGradient(gradient,
                                       start: CGPoint(x: rect.midX, y: rect.minY),
                                       end: CGPoint(x: rect.midX, y: rect.maxY),
                                       options: [.drawsBeforeStartLocation, .drawsAfterEndLocation])
        } else {
            top.setFill()
            path.fill()
        }
        // 上缘高光
        if let gradient = fadedGradient("shine",
                                       [UIColor(white: 1, alpha: fade(70 / 255)), UIColor(white: 1, alpha: 0)],
                                       [0, 1]) {
            context.drawLinearGradient(gradient,
                                       start: CGPoint(x: rect.midX, y: rect.minY),
                                       end: CGPoint(x: rect.midX, y: rect.midY + rect.height * 0.08),
                                       options: [.drawsBeforeStartLocation, .drawsAfterEndLocation])
        }
        // 下缘阴影
        if let gradient = fadedGradient("shade",
                                       [UIColor(white: 0, alpha: 0), UIColor(white: 0, alpha: fade(60 / 255))],
                                       [0, 1]) {
            context.drawLinearGradient(gradient,
                                       start: CGPoint(x: rect.midX, y: rect.midY),
                                       end: CGPoint(x: rect.midX, y: rect.maxY),
                                       options: [.drawsBeforeStartLocation, .drawsAfterEndLocation])
        }
        context.restoreGState()
        if selected {
            color(UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: 1), alpha: 1).setStroke()
            path.lineWidth = 2.5
            path.stroke()
        }
        let size: CGFloat = label.count > 2 ? 11 : label.count > 1 ? 13 : 17
        let attrs: [NSAttributedString.Key: Any] = [
            .font: UIFont.boldSystemFont(ofSize: size),
            .foregroundColor: color(Self.keyInk, alpha: 1)
        ]
        let text = label as NSString
        let textSize = text.size(withAttributes: attrs)
        text.draw(at: CGPoint(x: rect.midX - textSize.width / 2, y: rect.midY - textSize.height / 2), withAttributes: attrs)
    }

    /** Maps a drawn label to its skin-pack key, or nil for utility keys. */
    private static func labelToKey(_ label: String) -> String? {
        switch label {
        case "A": return "a"
        case "B": return "b"
        case "L": return "l"
        case "R": return "r"
        case "SELECT": return "select"
        case "START": return "start"
        default: return nil
        }
    }

    private func drawDpad() {
        guard dpad.width > 0 else { return }
        layoutDpadArms()
        if handheld() {
            drawShellDpad()
            return
        }
        drawDirection(dpadUp, Self.up)
        drawDirection(dpadDown, Self.down)
        drawDirection(dpadLeft, Self.left)
        drawDirection(dpadRight, Self.right)
        if editing { drawCursor(dpad) }
    }

    /** White cross with a center mark; a pressed arm glows in the accent. */
    private func drawShellDpad() {
        if let bitmap = skinBitmaps["dpad"] {
            bitmap.draw(in: dpad)
            drawArmGlow(dpadUp, Self.up, 0)
            drawArmGlow(dpadDown, Self.down, 0)
            drawArmGlow(dpadLeft, Self.left, 0)
            drawArmGlow(dpadRight, Self.right, 0)
            if editing { drawCursor(dpad) }
            return
        }
        let r = dpadUp.width / 2.4
        // The cross reads as two overlapping rounded bars.
        let bar = CGRect(x: dpad.minX, y: dpad.midY - dpadUp.width / 2,
                         width: dpad.width, height: dpadUp.width)
        let barV = CGRect(x: dpad.midX - dpadLeft.height / 2, y: dpad.minY,
                          width: dpadLeft.height, height: dpad.height)
        guard let context = UIGraphicsGetCurrentContext() else { return }
        // 两臂合成一条路径再填充：交叠处只画一次，不会出现更深的方块
        let cross = UIBezierPath()
        cross.append(UIBezierPath(roundedRect: bar, cornerRadius: r))
        cross.append(UIBezierPath(roundedRect: barV, cornerRadius: r))
        context.saveGState()
        context.setShadow(offset: CGSize(width: 0, height: 2), blur: 2.5,
                          color: color(UIColor.black, alpha: 0.35).cgColor)
        color(Self.keyRing, alpha: 1).setFill()
        cross.fill()
        context.restoreGState()
        // 键面：红色渐变 + 上缘高光 + 下缘阴影
        context.saveGState()
        context.addPath(cross.cgPath)
        context.clip()
        if let gradient = fadedGradient("face",
                                       [color(Self.keyFaceTop, alpha: 1), color(Self.keyFaceBottom, alpha: 1)],
                                       [0, 1]) {
            context.drawLinearGradient(gradient,
                                       start: CGPoint(x: dpad.midX, y: dpad.minY),
                                       end: CGPoint(x: dpad.midX, y: dpad.maxY),
                                       options: [.drawsBeforeStartLocation, .drawsAfterEndLocation])
        }
        if let gradient = fadedGradient("shine",
                                       [UIColor(white: 1, alpha: fade(60 / 255)), UIColor(white: 1, alpha: 0)],
                                       [0, 1]) {
            context.drawLinearGradient(gradient,
                                       start: CGPoint(x: dpad.midX, y: dpad.minY),
                                       end: CGPoint(x: dpad.midX, y: dpad.minY + dpad.height * 0.4),
                                       options: [.drawsBeforeStartLocation, .drawsAfterEndLocation])
        }
        if let gradient = fadedGradient("shade",
                                       [UIColor(white: 0, alpha: 0), UIColor(white: 0, alpha: fade(70 / 255))],
                                       [0, 1]) {
            context.drawLinearGradient(gradient,
                                       start: CGPoint(x: dpad.midX, y: dpad.midY),
                                       end: CGPoint(x: dpad.midX, y: dpad.maxY),
                                       options: [.drawsBeforeStartLocation, .drawsAfterEndLocation])
        }
        context.restoreGState()
        // Pressed arms light up in the accent color.
        drawArmGlow(dpadUp, Self.up, r)
        drawArmGlow(dpadDown, Self.down, r)
        drawArmGlow(dpadLeft, Self.left, r)
        drawArmGlow(dpadRight, Self.right, r)
        // Recessed hub plus the four direction arrows.
        let hub = dpadUp.width * 0.92
        color(Self.keyHub, alpha: 1).setFill()
        UIBezierPath(ovalIn: CGRect(x: dpad.midX - hub / 2, y: dpad.midY - hub / 2, width: hub, height: hub)).fill()
        color(Self.keyInk, alpha: 1).setFill()
        let arrow = dpadUp.width * 0.26
        drawCapArrow(CGPoint(x: dpad.midX, y: dpad.midY - dpadUp.height * 0.52), size: arrow, up: true)
        drawCapArrow(CGPoint(x: dpad.midX, y: dpad.midY + dpadDown.height * 0.52), size: arrow, up: false)
        drawCapArrow(CGPoint(x: dpad.midX - dpadLeft.width * 0.52, y: dpad.midY), size: arrow, left: true)
        drawCapArrow(CGPoint(x: dpad.midX + dpadRight.width * 0.52, y: dpad.midY), size: arrow, left: false)
        if editing { drawCursor(dpad) }
    }

    /// One triangular arrow on a key cap.
    private func drawCapArrow(_ center: CGPoint, size: CGFloat, up: Bool = false, left: Bool = false) {
        let half = size / 2
        let path: UIBezierPath
        if left {
            path = UIBezierPath()
            path.move(to: CGPoint(x: center.x - half, y: center.y))
            path.addLine(to: CGPoint(x: center.x + half, y: center.y - half))
            path.addLine(to: CGPoint(x: center.x + half, y: center.y + half))
        } else if up {
            path = UIBezierPath()
            path.move(to: CGPoint(x: center.x, y: center.y - half))
            path.addLine(to: CGPoint(x: center.x - half, y: center.y + half))
            path.addLine(to: CGPoint(x: center.x + half, y: center.y + half))
        } else {
            path = UIBezierPath()
            path.move(to: CGPoint(x: center.x, y: center.y + half))
            path.addLine(to: CGPoint(x: center.x - half, y: center.y - half))
            path.addLine(to: CGPoint(x: center.x + half, y: center.y - half))
        }
        path.close()
        path.fill()
    }

    private func drawArmGlow(_ arm: CGRect, _ bit: Int, _ r: CGFloat) {
        guard (pressed & bit) != 0 else { return }
        color(theme.accentDeep, alpha: 120 / 255).setFill()
        UIBezierPath(roundedRect: arm, cornerRadius: r * 0.8).fill()
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

    private func drawToolbar() {
        color(UIColor(red: 12 / 255, green: 12 / 255, blue: 14 / 255, alpha: 1), alpha: 236 / 255).setFill()
        UIBezierPath(roundedRect: toolbar, cornerRadius: toolbar.height / 2).fill()
        drawToolbarButton(toolbarMenu, "?", Self.actionMenu)
        drawToolbarButton(toolbarSave, "存", Self.actionSave)
        drawToolbarButton(toolbarLoad, "读", Self.actionLoad)
        drawToolbarButton(toolbarMute, muted ? "🔇" : "♪", Self.actionMute)
        drawToolbarButton(toolbarRewind, "⏪", Self.actionRewind)
    }

    private func drawToolbarButton(_ cell: CGRect, _ icon: String, _ action: Int) {
        if actionPointers.values.contains(action) {
            color(theme.accentDeep, alpha: 200 / 255).setFill()
            let size = min(cell.width, cell.height) * 0.84
            UIBezierPath(ovalIn: CGRect(x: cell.midX - size / 2, y: cell.midY - size / 2,
                                        width: size, height: size)).fill()
        }
        let attrs: [NSAttributedString.Key: Any] = [
            .font: UIFont.systemFont(ofSize: 13),
            .foregroundColor: UIColor(white: 1, alpha: fade(235 / 255))
        ]
        let text = icon as NSString
        let size = text.size(withAttributes: attrs)
        text.draw(at: CGPoint(x: cell.midX - size.width / 2, y: cell.midY - size.height / 2), withAttributes: attrs)
    }

    /** Fast-forward switch: green when held on, gray when off. */
    private func drawToggle() {
        let radius = toggle.height / 2
        (ffOn ? UIColor(red: 61 / 255, green: 220 / 255, blue: 132 / 255, alpha: fade(1)) : UIColor(red: 70 / 255, green: 70 / 255, blue: 76 / 255, alpha: fade(210 / 255))).setFill()
        UIBezierPath(roundedRect: toggle, cornerRadius: radius).fill()
        let knob = toggle.height * 0.86
        let kx = ffOn ? toggle.maxX - knob / 2 - 2 : toggle.minX + knob / 2 + 2
        UIColor(white: 1, alpha: fade(250 / 255)).setFill()
        UIBezierPath(ovalIn: CGRect(x: kx - knob / 2, y: toggle.midY - knob / 2,
                                    width: knob, height: knob)).fill()
        if ffOn {
            let attrs: [NSAttributedString.Key: Any] = [
                .font: UIFont.systemFont(ofSize: 9, weight: .bold),
                .foregroundColor: UIColor(red: 30 / 255, green: 90 / 255, blue: 50 / 255, alpha: fade(230 / 255))
            ]
            let text = "FF" as NSString
            let size = text.size(withAttributes: attrs)
            text.draw(at: CGPoint(x: toggle.midX - toggle.width * 0.12 - size.width / 2,
                                  y: toggle.midY - size.height / 2), withAttributes: attrs)
        }
    }

    private func drawSpeaker() {
        color(theme.speaker, alpha: 1).setFill()
        for dot in speakerRects {
            UIBezierPath(ovalIn: dot).fill()
        }
    }

    private func drawSpeakerSlots() {
        color(theme.speaker, alpha: 1).setFill()
        for slot in speakerRects {
            UIBezierPath(roundedRect: slot, cornerRadius: slot.height / 2).fill()
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

    // MARK: - Touches

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
                setNeedsDisplay()
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
            if (current & (Self.face | Self.flagTurboA | Self.flagTurboB | Self.flagLR | Self.flagC | Self.flagC2)) != 0 { continue }
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
                setNeedsDisplay()
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

    /// Drops every tracked touch and reports all keys up. A focus change or a
    /// system takeover can lose the matching UP/CANCEL for a touch, which
    /// would leave a key such as A logically held: later taps then changed
    /// nothing and looked like the button had stopped working.
    func releaseAllKeys() {
        let fastHeld = actionPointers.values.contains(Self.actionFF)
        pointers.removeAll()
        actionPointers.removeAll()
        turboTimer?.invalidate()
        turboTimer = nil
        pulseMask = 0
        pulseOn = false
        if fastHeld {
            onFastHold?(false)
        }
        publish(0)
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
            } else if (value & Self.flagC) != 0 {
                mask |= macroMaskC
            } else if (value & Self.flagC2) != 0 {
                mask |= macroMaskC2
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
        if handheld() {
            if !toggle.isEmpty && toggle.contains(point) { return Self.actionFFToggle }
            if toolbar.width > 0 {
                if toolbarMenu.contains(point) { return Self.actionMenu }
                if toolbarSave.contains(point) { return Self.actionSave }
                if toolbarLoad.contains(point) { return Self.actionLoad }
                if toolbarMute.contains(point) { return Self.actionMute }
                if toolbarRewind.contains(point) { return Self.actionRewind }
            }
        }
        if visibleExtras.contains("save"), keySave.contains(point) { return Self.actionSave }
        if visibleExtras.contains("load"), keyLoad.contains(point) { return Self.actionLoad }
        if visibleExtras.contains("ff"), keyFast.contains(point) { return Self.actionFF }
        if visibleExtras.contains("shot"), keyShot.contains(point) { return Self.actionShot }
        if visibleExtras.contains("rewind"), keyRewind.contains(point) { return Self.actionRewindQuick }
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
        if visibleExtras.contains("c"), keyC.contains(point) { return Self.flagC }
        if visibleExtras.contains("c2"), keyC2.contains(point) { return Self.flagC2 }
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
        if visibleExtras.contains("c"), keyC.contains(point) { return "c" }
        if visibleExtras.contains("c2"), keyC2.contains(point) { return "c2" }
        if visibleExtras.contains("save"), keySave.contains(point) { return "save" }
        if visibleExtras.contains("load"), keyLoad.contains(point) { return "load" }
        if visibleExtras.contains("ff"), keyFast.contains(point) { return "ff" }
        if visibleExtras.contains("shot"), keyShot.contains(point) { return "shot" }
        if visibleExtras.contains("rewind"), keyRewind.contains(point) { return "rewind" }
        return nil
    }

    /** True when the point lands on a control key instead of empty stage. */
    func isOverKey(_ point: CGPoint) -> Bool {
        keyAt(point) != nil
    }

    private func rectFor(_ key: String) -> CGRect {
        switch key {
        case "dpad": return dpad
        case "a": return buttonA
        case "b": return buttonB
        case "l": return buttonL
        case "r": return buttonR
        case "select": return buttonSelect
        case "start": return buttonStart
        case "ta": return keyTurboA
        case "tb": return keyTurboB
        case "lr": return keyLR
        case "c": return keyC
        case "c2": return keyC2
        case "save": return keySave
        case "load": return keyLoad
        case "ff": return keyFast
        case "shot": return keyShot
        case "rewind": return keyRewind
        default: return buttonStart
        }
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
        if visibleExtras.contains("c") { place(&keyC, keyCDefault, "c") }
        if visibleExtras.contains("c2") { place(&keyC2, keyC2Default, "c2") }
        if visibleExtras.contains("save") { place(&keySave, keySaveDefault, "save") }
        if visibleExtras.contains("load") { place(&keyLoad, keyLoadDefault, "load") }
        if visibleExtras.contains("ff") { place(&keyFast, keyFastDefault, "ff") }
        if visibleExtras.contains("shot") { place(&keyShot, keyShotDefault, "shot") }
        if visibleExtras.contains("rewind") { place(&keyRewind, keyRewindDefault, "rewind") }
        layoutDpadArms()
        onLayoutChanged?()
    }

    /** Current bounds of the START key, in this view's coordinates. */
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
