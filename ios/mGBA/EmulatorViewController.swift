import CoreMotion
import Darwin
import GameController
import Photos
import UIKit
import UserNotifications
import UniformTypeIdentifiers

final class EmulatorViewController: UIViewController, UIDocumentPickerDelegate {
    private let defaults = UserDefaults.standard
    private let docs = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)[0]
    private var core: OpaquePointer?
    private let gameView = GameView()
    private let controls = ControlsView()
    private let shellStage = ShellStageView()
    private let stickerOverlay = StickerOverlayView()
    private let aiOverlay = AiOverlayView()
    private let hint = UILabel()
    private let fpsView = UILabel()
    private let savePathView = UILabel()
    private var pauseButton: UIButton!
    private var fastButton: UIButton!
    private var slotButton: UIButton!
    private let speedBar = UIScrollView()
    private var speedButtons: [UIButton] = []
    private var speedBarHeight: NSLayoutConstraint!
    private let gate = NSCondition()
    private var running = false
    private var paused = false
    /** Emulation speed in frames per paced frame; 0.05..16 with slow motion. */
    private var speed: Double = 1
    private var fastHold = false
    private var orientationMode = UserDefaults.standard.string(forKey: "orientation") ?? "landscape"
    private var portrait: Bool { orientationMode == "portrait" || orientationMode == "portrait_rev" }
    private var touchKeys = 0
    private var hwKeys = 0
    private var padKeys = 0
    private var turboB = false
    private var slot = 1
    private var pendingPath: String?
    private var command = 0
    private let stopped = DispatchSemaphore(value: 0)
    private let audio = AudioOut()
    private var presentQueued = false
    private var remote: RemoteLink?
    /** GBoy/My Boy Wi-Fi link session and the key mask it delivers. */
    private var gboyLink: GBoyLink?
    private var gboyRemoteKeys = 0
    /** Cloud lobby room link (signalling over HTTPS/WebSocket, KCP over UDP). */
    private var lobbyLink: LobbyLink?
    /** Auto frameskip state on the emulation thread. */
    private var skipAuto = false
    private var autoSkipLevel = 0
    private var lateStreak = 0
    /** Tilt cartridge input: device posture fed to the core when enabled. */
    private var motionManager: CMMotionManager?
    private var tiltListening = false
    private var linkStatusLabel: UILabel?
    private var linkRoomField: UITextField?
    private var lastLinkState = -1
    /** Cartridge rumble pulses, drained once per emulation slice. */
    private var lastRumbleAt: UInt64 = 0
    private let hapticHeavy = UIImpactFeedbackGenerator(style: .heavy)
    private let hapticMedium = UIImpactFeedbackGenerator(style: .medium)
    private let hapticLight = UIImpactFeedbackGenerator(style: .light)
    private let hapticRigid = UIImpactFeedbackGenerator(style: .rigid)
    /** GIF recording state; the queue hands frames to the encoder thread. */
    private var gifRecording = false
    /** The floating GIF button, when the user turned it on. */
    private var gifBall: GifBall?
    /** 提示过隐藏虚拟按键之后就不再打扰用户。 */
    private var keypadHideAsked = false
    /** 屏幕亮度作为阳光来源时的刷新定时器。 */
    private var solarTimer: Timer?
    private var gifButton: UIButton?
    private var gifQueue: GifFrameQueue?
    private var lastGifAt: UInt64 = 0
    private var gifFrames = 0
    /** A filtered frame capture was requested; done in the main present block. */
    private var gifWantCapture = false
    /** Fractional speeds (slow motion) accumulate whole frames in this debt. */
    private var frameDebt: Double = 0
    private var lastAudioSpeed: Double = 0
    /** Game speed the audio queues were last flushed for: 音乐原速 holds
     * audioSpeed at 1 across the 1x -> fast-forward switch, so the flush must
     * key on the game speed too or the parked audio never restarts. */
    private var lastGameSpeed: Double = 0
    /** Whether the native hold (音乐原速) is currently published to the core. */
    private var holdEngaged = false
    /** Stretch the hold was published with; republished when the multiplier changes. */
    private var lastHoldStretch: Double = 0
    /** Slice rate the device last sustained while fast-forwarding (slices per
     * second; eased toward the measured capability once per feedback window)
     * and the slice schedule derived from it; re-measured per speed. 0 =
     * free-run while measuring. */
    private var fastPace: Double = 0
    private var fastSliceNanos: Int64 = 0
    /** Schedule resyncs since the last feedback window. */
    private var fastResyncs = 0
    /** Whether the core's resampler rate can be trusted at the applied speed;
     * the pump holds playback back until the first feedback window lands. */
    private var paceSeeded = true
    private var armWork: DispatchWorkItem?
    private var pulseWork: DispatchWorkItem?
    private var linkWatch: DispatchWorkItem?
    private var pickerKind = 0
    private let cmdSave = 1
    private let cmdLoad = 2
    private let cmdReset = 3
    private let cmdAutoSave = 4
    private let cmdRewind = 5
    /** Separate command for the extra one-tap rewind key. */
    private let cmdRewindQuick = 6
    private let layoutBar = UIView()
    private let bar = UIScrollView()
    private let rewindBar = UIScrollView()
    private let stage = UIView()
    private let lowerScreen = UIView()
    private let hinge = UIView()
    private var stageLandscape: [NSLayoutConstraint] = []
    private var stagePortrait: [NSLayoutConstraint] = []
    private var gameClassicLandscape: [NSLayoutConstraint] = []
    private var gameShellLandscape: [NSLayoutConstraint] = []
    private var gamePortrait: [NSLayoutConstraint] = []
    private var appliedStagePortrait: Bool?
    private var appliedShellHandheld: Bool?
    private var rewindBarHeight: NSLayoutConstraint!
    private var menuButton: UIButton!
    private var menuVisible = true
    private var speedBarWanted = false
    private var speedCustomButton: UIButton?
    private var savePathWanted = false
    private var menuHideWork: DispatchWorkItem?
    private var menuLeading: NSLayoutConstraint!
    private var menuCenterY: NSLayoutConstraint!
    private var savePathHeight: NSLayoutConstraint!
    private var menuLeft: CGFloat = -1
    private var menuTop: CGFloat = -1
    private var scopedURL: URL?
    /// Skins, per-game overrides and the game library all live in the app's
    /// Documents folder, where the Files app can reach them.
    private lazy var skinStore = SkinStore(root: docs.appendingPathComponent("skins", isDirectory: true))
    private let romSettings = RomSettings()
    private let romLibrary = RomLibrary()
    private var romCrc: UInt32?
    private var crcCache: [String: UInt32] = [:]
    private var perRomFilter: Int?
    private var perRomSpeed: Double?
    private var perRomSaveType: Int?
    private var perRomPalette: Int?
    private var rewindWanted = false
    private var rewindSeconds = 15
    /** Save-state folder in effect for the loaded ROM (nil = shared folder). */
    private var activeStateDir: URL?
    private var currentRomPath: String?
    /** Security-scoped folder URLs kept open for the whole session. */
    private var scopedFolderURLs: [URL] = []
    private var rewindHold = false
    private var lastRewindAt: UInt64 = 0
    private var ffOn = false
    private var muted = false
    private var timedSaveTimer: Timer?
    private var aiFrame: UIImage?
    private var activeSkinName: String?
    private var backupExportURL: URL?
    private var doubleTapShot: UITapGestureRecognizer?
    private var stickerEditing = false
    private var pendingPreview: UIImage?
    private static let menuHideSeconds: TimeInterval = 4
    private static let audioStepFrames = 4
    private static let audioReadFrames: Int32 = 8192
    /** Speed presets on the tier bar; anything else goes through 自定义. */
    private static let speedTiers: [Double] = [0.25, 0.5, 1, 2, 4, 8, 16]
    /** Slot reserved for the automatic save-on-exit / load-on-start pair. */
    private static let autoSlot = 0
    /** GIF capture pacing and length cap (GIF_MAX_FRAMES at ~20 fps). */
    private static let gifFrameMs = 50
    private static let gifMaxFrames = 900
    private static let turboArmSeconds: TimeInterval = 0.2
    private static let turboPulseSeconds: TimeInterval = 0.04
    /** Names of the optional on-screen keys, shown and stored in this order. */
    private static let extraKeyChoices: [(String, String)] = [
        ("ta", "A键（连发）"), ("tb", "B键（连发）"), ("lr", "L+R键"),
        ("c", "C键（组合宏）"), ("c2", "C2键（组合宏）"),
        ("save", "快速存档"), ("load", "快速读档"), ("ff", "倍速（按住快进）"), ("shot", "截图"),
        ("rewind", "倒带快捷键（点一次 2 秒）"),
    ]
    /** Filter ids, matching the order shown in the 画质 picker (Shaders.functionNames). */
    private static let filterNames = ["关闭", "GBA 色彩", "灰度", "HQ2x", "HQ4x", "2xBR", "4xBR", "残影", "点阵", "LCD3x", "扫描线（平滑）", "锐利插值", "外部渲染器"]
    /**
     * GB DMG palettes, light to dark, expanded to the twelve gb.pal entries
     * (the same four colors for BG, OBJ0 and OBJ1).
     */
    private static let gbPalettes: [[Int32]] = [
        [0xFFFFFF, 0xA8B8A8, 0x285050, 0x000000],
        [0xFFFFFF, 0xA9A9A9, 0x545454, 0x000000],
        [0xFFFFFF, 0xAAAAAA, 0x555555, 0x000000],
        [0xF8E0C0, 0xD89058, 0xA85038, 0x381808],
        [0xF8F8D8, 0xD8B098, 0xA06848, 0x583020],
        [0xFFF8FF, 0xF8B8B8, 0xC85050, 0x680808],
        [0xFFFBE7, 0xC8D8A0, 0x789868, 0x183018],
        [0xF8FFD8, 0xB8F8B8, 0x70C078, 0x184818],
        [0xE0F8FF, 0xA0B8F8, 0x5078D8, 0x001888],
        [0xF8E8F8, 0xB8A0F0, 0x7858E8, 0x180090],
        [0xFFF0E0, 0xF8B888, 0xC07038, 0x602010],
        [0xFFF8D8, 0xF8D888, 0xC0A040, 0x604000],
        [0xFFF8F8, 0xE8C0C8, 0xC88898, 0x704858],
        [0x000000, 0x285050, 0xA8B8A8, 0xFFFFFF],
    ]
    private static let gbPaletteNames = ["默认", "原版", "灰度", "棕色", "深棕", "红色", "绿色", "深绿", "蓝色", "深蓝", "橙色", "黄色", "粉彩", "反转"]
    private var keyLayout = KeyLayout()
    /** Multiple key layouts: each is stored under its own defaults key. */
    private var layoutProfile = ""
    private var layoutEditing = false
    private var selectedKey: String?
    private var scaleSlider: UISlider?
    private var scaleLabel: UILabel?

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .black
        // Every launch starts at 1x. Fast-forward is a temporary choice: a
        // remembered speed would auto-resume the game, and its tape-style
        // raised audio pitch, before the player asks for it.
        buildChrome()
        audio.setSoundEnabled(defaults.object(forKey: "fast_audio") == nil ? true : defaults.bool(forKey: "fast_audio"))
        let saves = docs.appendingPathComponent("saves").path
        let states = docs.appendingPathComponent("states").path
        core = mgbaMobileCreate(saves, states, "ios")
        setupGifBall()
        // 上次隐藏了虚拟按键的话，这次继续隐藏
        if defaults.bool(forKey: "vkeypad_hidden") {
            controls.isHidden = true
        }
        if let core { mgbaMobileSetRewind(core, true) }
        applyCoreOptions()
        muted = defaults.bool(forKey: "muted")
        applyVolume()
        audio.lowLatency = defaults.bool(forKey: "low_latency")
        controls.onKeysChanged = { [weak self] mask in
            guard let self else { return }
            let prev = self.touchKeys
            self.touchKeys = mask
            self.noteUserKeys(prevTouch: prev, prevHw: self.hwKeys, prevPad: self.padKeys)
            if (mask & ~prev) != 0 {
                self.wakeInput()
                self.vibrateOnKey(mask & ~prev)
            }
        }
        controls.onAction = { [weak self] action in
            guard let self else { return }
            if action == ControlsView.actionSave {
                self.quickState(save: true)
            } else if action == ControlsView.actionLoad {
                self.quickState(save: false)
            } else if action == ControlsView.actionShot {
                self.takeScreenshot()
            } else if action == ControlsView.actionFFToggle {
                self.toggleFastForward()
            } else if action == ControlsView.actionMenu {
                self.toggleMenu()
            } else if action == ControlsView.actionMute {
                self.toggleMute()
            } else if action == ControlsView.actionRewind {
                self.toggleRewindBar()
            } else if action == ControlsView.actionRewindQuick {
                self.quickRewind()
            }
        }
        controls.onFastHold = { [weak self] down in
            guard let self else { return }
            self.fastHold = down
            if down { self.wakeInput() }
            self.refreshSpeedButtons()
        }
        applyInputSettings()
        restoreCustomFolderAccess()
        loadMacroSettings()
        controls.setMuted(muted)
        controls.setFastForwardOn(ffOn)
        applySkin()
        loadStickers()
        installDoubleTapScreenshot()
        layoutProfile = activeProfile()
        keyLayout = KeyLayout.decode(profileLayout(layoutProfile))
        controls.setCenters(keyLayout.resolved())
        controls.setScales(keyLayout.resolvedScales())
        controls.setOpacity(defaults.object(forKey: "controls_opacity") == nil ? 100 : defaults.integer(forKey: "controls_opacity"))
        controls.onCursorMoved = { [weak self] key, x, y in
            guard let self else { return }
            self.keyLayout.place(key, x, y)
            self.controls.setCenters(self.keyLayout.resolved())
            self.selectKey(key)
        }
        controls.onCursorStopped = { [weak self] key, x, y in
            guard let self else { return }
            self.keyLayout.place(key, x, y)
            self.controls.setCenters(self.keyLayout.resolved())
            self.saveKeyLayout()
            self.selectKey(key)
        }
        controls.onScaleChanged = { [weak self] key, scale in
            guard let self else { return }
            self.keyLayout.setScale(key, scale)
            self.saveKeyLayout()
            self.selectKey(key)
        }
        controls.onSelected = { [weak self] key in
            self?.selectKey(key)
        }
        controls.onLayoutChanged = { [weak self] in
            self?.layoutMenuButton()
        }
        var alreadyPending = false
        gate.lock()
        alreadyPending = pendingPath != nil
        gate.unlock()
        if !alreadyPending, let bookmark = defaults.data(forKey: "lastRomBookmark"), let url = resolveBookmark(bookmark) {
            scopedURL = url
            gate.lock()
            pendingPath = url.path
            gate.unlock()
        } else if !alreadyPending, let last = defaults.string(forKey: "lastRom"), FileManager.default.fileExists(atPath: last) {
            gate.lock()
            pendingPath = last
            gate.unlock()
        }
        running = true
        let thread = Thread(target: self, selector: #selector(emulationLoop), object: nil)
        thread.name = "mGBA"
        thread.qualityOfService = .userInteractive
        thread.start()
        NotificationCenter.default.addObserver(self, selector: #selector(bindControllers), name: .GCControllerDidConnect, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(controllerDisconnected), name: .GCControllerDidDisconnect, object: nil)
        // Losing the focus or the touch stream can take the matching key-ups
        // with it; drop every held key so the game cannot come back stuck
        // with A down or at 16x speed.
        NotificationCenter.default.addObserver(self, selector: #selector(appResignedActive), name: UIApplication.willResignActiveNotification, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(appResignedActive), name: UIApplication.didEnterBackgroundNotification, object: nil)
        bindControllers()
        applyVideo()
    }

    override var prefersStatusBarHidden: Bool { true }
    override var prefersHomeIndicatorAutoHidden: Bool { true }
    override var shouldAutorotate: Bool { true }
    override var supportedInterfaceOrientations: UIInterfaceOrientationMask {
        // Sensor-style masks: the chosen mode is requested on entry, the
        // device may still flip within that group.
        portrait ? [.portrait, .portraitUpsideDown] : [.landscapeLeft, .landscapeRight]
    }
    override var preferredInterfaceOrientationForPresentation: UIInterfaceOrientation {
        switch orientationMode {
        case "portrait": return .portrait
        case "portrait_rev": return .portraitUpsideDown
        case "landscape_rev": return .landscapeLeft
        default: return .landscapeRight
        }
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        applyOrientation()
    }

    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        applyStageLayout()
        // 画面场景是叠在布局之上的变换，尺寸变了要重新算一次
        applyVideoScene()
    }

    /** Portrait splits the stage into a DS-like pair of screens; the handheld
     * style also reshapes the landscape game box so the shell is visible. */
    private func applyStageLayout() {
        let shell = skinStylePref() == ControlsView.styleHandheld
        let switched = appliedStagePortrait != portrait
        let styleChanged = appliedShellHandheld != shell
        if !switched && !styleChanged {
            updateShellGeometry()
            return
        }
        appliedStagePortrait = portrait
        appliedShellHandheld = shell
        NSLayoutConstraint.deactivate(stageLandscape)
        NSLayoutConstraint.deactivate(stagePortrait)
        NSLayoutConstraint.deactivate(gameClassicLandscape)
        NSLayoutConstraint.deactivate(gameShellLandscape)
        NSLayoutConstraint.deactivate(gamePortrait)
        NSLayoutConstraint.activate(portrait ? stagePortrait : stageLandscape)
        if portrait {
            NSLayoutConstraint.activate(gamePortrait)
        } else {
            NSLayoutConstraint.activate(shell ? gameShellLandscape : gameClassicLandscape)
        }
        controls.setPortrait(portrait)
        shellStage.portrait = portrait
        shellStage.handheld = shell
        lowerScreen.isHidden = portrait ? shell : true
        hinge.isHidden = !portrait || shell
        if switched {
            // Keys, stickers and full-skin backgrounds are stored per
            // orientation, like the Android stage.
            reloadKeyLayout()
            loadStickers()
            applyFullSkin()
        }
        menuLeft = -1
        menuTop = -1
        layoutMenuButton()
        updateShellGeometry()
    }

    /** Feeds the game's laid-out box to the shell so its bezel can wrap it. */
    private func updateShellGeometry() {
        guard shellStage.bounds.width > 0, gameView.bounds.width > 0 else { return }
        shellStage.gameFrame = stage.convert(gameView.bounds, from: gameView)
        // The translated blocks are normalized to the emulator picture, which
        // may be letterboxed inside the game box or the shell layout.
        aiOverlay.pictureFrame = stage.convert(gameView.pictureRect, from: gameView)
    }

    /** Reloads the key layout for the current orientation. */
    private func reloadKeyLayout() {
        guard !layoutProfile.isEmpty else { return }
        keyLayout = KeyLayout.decode(profileLayout(layoutProfile))
        controls.setCenters(keyLayout.resolved())
        controls.setScales(keyLayout.resolvedScales())
    }

    private func buildChrome() {
        bar.backgroundColor = UIColor(white: 22 / 255, alpha: 1)
        bar.showsHorizontalScrollIndicator = false
        let stack = UIStackView()
        stack.axis = .horizontal
        stack.spacing = 6
        bar.addSubview(stack)
        let titles: [(String, Selector)] = [
            ("打开", #selector(openRom)),
            ("暂停", #selector(togglePause)),
            ("1倍", #selector(toggleSpeedBar)),
            ("复位", #selector(resetGame)),
            ("槽位 1", #selector(cycleSlot)),
            ("存档", #selector(saveState)),
            ("读档", #selector(loadState)),
            ("BIOS", #selector(openBios)),
            ("画质", #selector(showVideo)),
            ("联机", #selector(showLink)),
            ("键位", #selector(toggleLayout)),
            ("金手指", #selector(showCheats)),
            ("调试", #selector(showDebugTools)),
            ("图库", #selector(showRomLibrary)),
            ("倒带", #selector(toggleRewindBar)),
            ("皮肤", #selector(showSkinDialog)),
            ("每游戏", #selector(showPerRomDialog)),
            ("备份", #selector(showBackupDialog)),
            ("翻译", #selector(showTranslateDialog)),
            ("截图", #selector(takeScreenshot)),
            ("GIF", #selector(toggleGif)),
            ("设置", #selector(showSettings))
        ]
        for (index, item) in titles.enumerated() {
            let button = UIButton(type: .system)
            button.setTitle(item.0, for: .normal)
            button.setTitleColor(.white, for: .normal)
            button.titleLabel?.font = .systemFont(ofSize: 15)
            button.contentEdgeInsets = UIEdgeInsets(top: 6, left: 10, bottom: 6, right: 10)
            button.addTarget(self, action: item.1, for: .touchUpInside)
            stack.addArrangedSubview(button)
            if index == 1 { pauseButton = button }
            if index == 2 {
                fastButton = button
                button.setTitle("\(Self.speedLabel(speed))倍", for: .normal)
            }
            if index == 4 { slotButton = button }
            if item.0 == "GIF" { gifButton = button }
        }
        fpsView.textColor = UIColor(red: 156 / 255, green: 204 / 255, blue: 156 / 255, alpha: 1)
        fpsView.font = .systemFont(ofSize: 12)
        stack.addArrangedSubview(fpsView)
        speedBar.backgroundColor = UIColor(red: 16 / 255, green: 24 / 255, blue: 16 / 255, alpha: 1)
        speedBar.showsHorizontalScrollIndicator = false
        speedBar.isHidden = true
        let speedStack = UIStackView()
        speedStack.axis = .horizontal
        speedStack.spacing = 4
        speedStack.alignment = .center
        speedStack.translatesAutoresizingMaskIntoConstraints = false
        speedBar.addSubview(speedStack)
        let speedLabel = UILabel()
        speedLabel.text = "倍速"
        speedLabel.textColor = .white
        speedLabel.font = .systemFont(ofSize: 13)
        speedStack.addArrangedSubview(speedLabel)
        for tier in Self.speedTiers {
            let button = UIButton(type: .system)
            button.setTitle(Self.speedLabel(tier), for: .normal)
            button.titleLabel?.font = .systemFont(ofSize: 15, weight: .semibold)
            button.contentEdgeInsets = UIEdgeInsets(top: 4, left: 10, bottom: 4, right: 10)
            button.layer.cornerRadius = 6
            button.addTarget(self, action: #selector(pickTier(_:)), for: .touchUpInside)
            speedStack.addArrangedSubview(button)
            speedButtons.append(button)
        }
        let custom = UIButton(type: .system)
        custom.setTitle("自定义", for: .normal)
        custom.titleLabel?.font = .systemFont(ofSize: 15, weight: .semibold)
        custom.contentEdgeInsets = UIEdgeInsets(top: 4, left: 10, bottom: 4, right: 10)
        custom.layer.cornerRadius = 6
        custom.addTarget(self, action: #selector(showCustomSpeed), for: .touchUpInside)
        speedStack.addArrangedSubview(custom)
        speedCustomButton = custom
        let soundToggle = UISwitch()
        soundToggle.isOn = defaults.object(forKey: "fast_audio") == nil ? true : defaults.bool(forKey: "fast_audio")
        let soundLabel = UILabel()
        soundLabel.text = "倍速声音"
        soundLabel.textColor = .white
        soundLabel.font = .systemFont(ofSize: 13)
        let nativeToggle = UISwitch()
        nativeToggle.isOn = defaults.object(forKey: "fast_audio_native") == nil ? true : defaults.bool(forKey: "fast_audio_native")
        nativeToggle.isEnabled = soundToggle.isOn
        nativeToggle.alpha = soundToggle.isOn ? 1.0 : 0.45
        nativeToggle.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(nativeToggle.isOn, forKey: "fast_audio_native")
        }, for: .valueChanged)
        let nativeLabel = UILabel()
        nativeLabel.text = "音乐原速"
        nativeLabel.textColor = .white
        nativeLabel.font = .systemFont(ofSize: 13)
        // 不变速 only makes sense when sound is on during fast-forward.
        soundToggle.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(soundToggle.isOn, forKey: "fast_audio")
            self.audio.setSoundEnabled(soundToggle.isOn)
            nativeToggle.isEnabled = soundToggle.isOn
            nativeToggle.alpha = soundToggle.isOn ? 1.0 : 0.45
        }, for: .valueChanged)
        speedStack.addArrangedSubview(soundLabel)
        speedStack.addArrangedSubview(soundToggle)
        speedStack.addArrangedSubview(nativeLabel)
        speedStack.addArrangedSubview(nativeToggle)
        refreshSpeedButtons()
        savePathView.textColor = UIColor(red: 183 / 255, green: 227 / 255, blue: 183 / 255, alpha: 1)
        savePathView.font = .systemFont(ofSize: 12)
        savePathView.numberOfLines = 3
        savePathView.isHidden = true
        savePathView.isUserInteractionEnabled = true
        savePathView.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(copySavePath)))
        rewindBar.backgroundColor = UIColor(red: 24 / 255, green: 16 / 255, blue: 32 / 255, alpha: 1)
        rewindBar.showsHorizontalScrollIndicator = false
        rewindBar.isHidden = true
        let rewindStack = UIStackView()
        rewindStack.axis = .horizontal
        rewindStack.spacing = 4
        rewindStack.alignment = .center
        rewindStack.translatesAutoresizingMaskIntoConstraints = false
        rewindBar.addSubview(rewindStack)
        let rewindLabel = UILabel()
        rewindLabel.text = "倒带"
        rewindLabel.textColor = .white
        rewindLabel.font = .systemFont(ofSize: 13)
        rewindStack.addArrangedSubview(rewindLabel)
        for seconds in [60, 45, 30, 15, 12, 9, 6, 3] {
            let button = UIButton(type: .system)
            button.setTitle(seconds == 60 ? "1分钟" : "\(seconds)秒", for: .normal)
            button.titleLabel?.font = .systemFont(ofSize: 14)
            button.contentEdgeInsets = UIEdgeInsets(top: 4, left: 10, bottom: 4, right: 10)
            button.tag = seconds
            button.addTarget(self, action: #selector(rewindStep(_:)), for: .touchUpInside)
            rewindStack.addArrangedSubview(button)
        }
        let hold = UIButton(type: .system)
        hold.setTitle("按住倒带", for: .normal)
        hold.titleLabel?.font = .systemFont(ofSize: 14)
        hold.contentEdgeInsets = UIEdgeInsets(top: 4, left: 12, bottom: 4, right: 12)
        hold.addTarget(self, action: #selector(rewindHoldDown), for: .touchDown)
        hold.addTarget(self, action: #selector(rewindHoldUp), for: [.touchUpInside, .touchUpOutside, .touchCancel])
        rewindStack.addArrangedSubview(hold)
        hint.text = "点击「打开」选择 .gba、.gbc、.gb 或 .zip 游戏；也可以在文件 App 里用 mGBA 打开 ROM。"
        hint.textColor = UIColor(white: 0.87, alpha: 1)
        hint.numberOfLines = 0
        hint.textAlignment = .center
        // Portrait turns the stage into a DS-like pair of screens: a black
        // upper screen with the game, a slightly grey lower one with the keys.
        lowerScreen.backgroundColor = UIColor(white: 0.043, alpha: 1)
        hinge.backgroundColor = UIColor(white: 0.18, alpha: 1)
        hinge.isUserInteractionEnabled = false
        stickerOverlay.onStickersChanged = { [weak self] in self?.persistStickers() }
        stage.addSubview(shellStage)
        stage.addSubview(lowerScreen)
        stage.addSubview(gameView)
        stage.addSubview(hint)
        stage.addSubview(controls)
        // Stickers and translations sit above the keys, like the Android
        // overlays; the sticker view lets touches through unless editing.
        stage.addSubview(stickerOverlay)
        stage.addSubview(aiOverlay)
        stage.addSubview(hinge)
        buildLayoutBar()
        // Always-visible handle that pops the menu open. Added last so it stays
        // above the controls and gets taps first; placed by the activity just
        // right of the on-screen START key.
        let menu = UIButton(type: .system)
        menu.setTitle("☰ 菜单", for: .normal)
        menu.setTitleColor(UIColor(white: 1, alpha: 0.55), for: .normal)
        menu.titleLabel?.font = .systemFont(ofSize: 16)
        menu.backgroundColor = .clear
        menu.addTarget(self, action: #selector(toggleMenu), for: .touchUpInside)
        menuButton = menu
        stage.addSubview(menu)
        menu.translatesAutoresizingMaskIntoConstraints = false
        menuLeading = menu.leadingAnchor.constraint(equalTo: stage.leadingAnchor)
        menuCenterY = menu.centerYAnchor.constraint(equalTo: stage.topAnchor)
        // Touching the menu at all keeps it open.
        let menuTap = UITapGestureRecognizer(target: self, action: #selector(menuTouched(_:)))
        menuTap.cancelsTouchesInView = false
        view.addGestureRecognizer(menuTap)
        let menuPan = UIPanGestureRecognizer(target: self, action: #selector(menuTouched(_:)))
        menuPan.cancelsTouchesInView = false
        view.addGestureRecognizer(menuPan)
        for item in [bar, stack, speedBar, rewindBar, savePathView, stage, lowerScreen, gameView, hint, shellStage,
                     stickerOverlay, aiOverlay, controls, layoutBar, hinge] {
            item.translatesAutoresizingMaskIntoConstraints = false
        }
        view.addSubview(bar)
        view.addSubview(speedBar)
        view.addSubview(rewindBar)
        view.addSubview(savePathView)
        view.addSubview(stage)
        view.addSubview(layoutBar)
        speedBarHeight = speedBar.heightAnchor.constraint(equalToConstant: 0)
        rewindBarHeight = rewindBar.heightAnchor.constraint(equalToConstant: 0)
        savePathHeight = savePathView.heightAnchor.constraint(equalToConstant: 0)
        // Landscape: the menu bar on top, the keys over the full-screen game.
        stageLandscape = [
            bar.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            speedBar.topAnchor.constraint(equalTo: bar.bottomAnchor),
            rewindBar.topAnchor.constraint(equalTo: speedBar.bottomAnchor),
            savePathView.topAnchor.constraint(equalTo: rewindBar.bottomAnchor),
            stage.topAnchor.constraint(equalTo: savePathView.bottomAnchor),
            stage.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            controls.topAnchor.constraint(equalTo: stage.topAnchor),
            controls.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            hint.centerYAnchor.constraint(equalTo: stage.centerYAnchor)
        ]
        // Portrait: a DS-like split, game on the upper screen, keys and the
        // menu (docked at the bottom) on the lower one.
        stagePortrait = [
            stage.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            stage.bottomAnchor.constraint(equalTo: savePathView.topAnchor),
            savePathView.bottomAnchor.constraint(equalTo: rewindBar.topAnchor),
            rewindBar.bottomAnchor.constraint(equalTo: speedBar.topAnchor),
            speedBar.bottomAnchor.constraint(equalTo: bar.topAnchor),
            bar.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor),
            controls.topAnchor.constraint(equalTo: gameView.bottomAnchor),
            controls.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            hint.centerYAnchor.constraint(equalTo: gameView.centerYAnchor)
        ]
        // The game box: full-screen classic landscape, a handheld body with a
        // smaller screen in the shell style, or the upper half in portrait.
        gameClassicLandscape = [
            gameView.topAnchor.constraint(equalTo: stage.topAnchor),
            gameView.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            gameView.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            gameView.bottomAnchor.constraint(equalTo: stage.bottomAnchor)
        ]
        gameShellLandscape = [
            gameView.centerXAnchor.constraint(equalTo: stage.centerXAnchor),
            gameView.centerYAnchor.constraint(equalTo: stage.centerYAnchor),
            gameView.widthAnchor.constraint(equalTo: stage.widthAnchor, multiplier: 0.58),
            gameView.heightAnchor.constraint(equalTo: stage.heightAnchor, multiplier: 0.74)
        ]
        gamePortrait = [
            gameView.topAnchor.constraint(equalTo: stage.topAnchor),
            gameView.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            gameView.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            gameView.heightAnchor.constraint(equalTo: stage.heightAnchor, multiplier: 0.5)
        ]
        NSLayoutConstraint.activate([
            bar.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            bar.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            bar.heightAnchor.constraint(equalToConstant: 44),
            stack.topAnchor.constraint(equalTo: bar.topAnchor),
            stack.bottomAnchor.constraint(equalTo: bar.bottomAnchor),
            stack.leadingAnchor.constraint(equalTo: bar.leadingAnchor, constant: 4),
            stack.trailingAnchor.constraint(equalTo: bar.trailingAnchor, constant: -4),
            stack.heightAnchor.constraint(equalTo: bar.heightAnchor),
            speedBar.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            speedBar.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            speedBarHeight,
            speedStack.topAnchor.constraint(equalTo: speedBar.contentLayoutGuide.topAnchor),
            speedStack.bottomAnchor.constraint(equalTo: speedBar.contentLayoutGuide.bottomAnchor),
            speedStack.leadingAnchor.constraint(equalTo: speedBar.contentLayoutGuide.leadingAnchor, constant: 4),
            speedStack.trailingAnchor.constraint(equalTo: speedBar.contentLayoutGuide.trailingAnchor, constant: -4),
            speedStack.heightAnchor.constraint(equalTo: speedBar.frameLayoutGuide.heightAnchor),
            rewindBar.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            rewindBar.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            rewindBarHeight,
            rewindStack.topAnchor.constraint(equalTo: rewindBar.contentLayoutGuide.topAnchor),
            rewindStack.bottomAnchor.constraint(equalTo: rewindBar.contentLayoutGuide.bottomAnchor),
            rewindStack.leadingAnchor.constraint(equalTo: rewindBar.contentLayoutGuide.leadingAnchor, constant: 4),
            rewindStack.trailingAnchor.constraint(equalTo: rewindBar.contentLayoutGuide.trailingAnchor, constant: -4),
            rewindStack.heightAnchor.constraint(equalTo: rewindBar.frameLayoutGuide.heightAnchor),
            savePathView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 8),
            savePathView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -8),
            savePathHeight,
            stage.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            stage.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            controls.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            controls.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            hint.centerXAnchor.constraint(equalTo: stage.centerXAnchor),
            hint.leadingAnchor.constraint(greaterThanOrEqualTo: stage.leadingAnchor, constant: 24),
            hint.trailingAnchor.constraint(lessThanOrEqualTo: stage.trailingAnchor, constant: -24),
            shellStage.topAnchor.constraint(equalTo: stage.topAnchor),
            shellStage.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            shellStage.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            shellStage.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            stickerOverlay.topAnchor.constraint(equalTo: stage.topAnchor),
            stickerOverlay.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            stickerOverlay.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            stickerOverlay.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            aiOverlay.topAnchor.constraint(equalTo: stage.topAnchor),
            aiOverlay.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            aiOverlay.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            aiOverlay.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            // The lower screen collapses to nothing in landscape, where it
            // simply ends where the game does.
            lowerScreen.topAnchor.constraint(equalTo: gameView.bottomAnchor),
            lowerScreen.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            lowerScreen.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            lowerScreen.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            hinge.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            hinge.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            hinge.centerYAnchor.constraint(equalTo: stage.centerYAnchor),
            hinge.heightAnchor.constraint(equalToConstant: 2),
            menuLeading,
            menuCenterY,
            layoutBar.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            layoutBar.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            layoutBar.trailingAnchor.constraint(equalTo: view.trailingAnchor)
        ])
        NSLayoutConstraint.activate(portrait ? stagePortrait : stageLandscape)
        NSLayoutConstraint.activate(portrait ? gamePortrait : gameClassicLandscape)
        hinge.isHidden = !portrait
        lowerScreen.isHidden = !portrait
    }

    private func buildLayoutBar() {
        layoutBar.backgroundColor = UIColor(red: 16 / 255, green: 24 / 255, blue: 16 / 255, alpha: 0.92)
        layoutBar.isHidden = true
        let hintLabel = UILabel()
        hintLabel.text = "单指拖动移动，双指捏合缩放，也可用下方滑杆微调，松手即保存"
        hintLabel.textColor = UIColor(red: 246 / 255, green: 231 / 255, blue: 168 / 255, alpha: 1)
        hintLabel.font = .systemFont(ofSize: 12)
        hintLabel.numberOfLines = 2
        let reset = UIButton(type: .system)
        reset.setTitle("重置", for: .normal)
        reset.setTitleColor(.white, for: .normal)
        reset.titleLabel?.font = .systemFont(ofSize: 15)
        reset.addTarget(self, action: #selector(resetLayout), for: .touchUpInside)
        let profiles = UIButton(type: .system)
        profiles.setTitle("配置", for: .normal)
        profiles.setTitleColor(.white, for: .normal)
        profiles.titleLabel?.font = .systemFont(ofSize: 15)
        profiles.addTarget(self, action: #selector(showLayoutProfiles), for: .touchUpInside)
        let done = UIButton(type: .system)
        done.setTitle("完成", for: .normal)
        done.setTitleColor(.white, for: .normal)
        done.titleLabel?.font = .systemFont(ofSize: 15)
        done.addTarget(self, action: #selector(finishLayout), for: .touchUpInside)
        let row = UIStackView(arrangedSubviews: [hintLabel, reset, profiles, done])
        row.axis = .horizontal
        row.spacing = 8
        row.alignment = .center
        let label = UILabel()
        label.text = "点一下按键选中，再捏合或拖滑杆缩放"
        label.textColor = .white
        label.font = .systemFont(ofSize: 12)
        label.numberOfLines = 1
        scaleLabel = label
        let slider = UISlider()
        slider.minimumValue = 0.4
        slider.maximumValue = 3.0
        slider.value = 1
        slider.addTarget(self, action: #selector(scaleChanged(_:)), for: .valueChanged)
        scaleSlider = slider
        let minus = UIButton(type: .system)
        minus.setTitle("−", for: .normal)
        minus.setTitleColor(.white, for: .normal)
        minus.addTarget(self, action: #selector(shrinkSelected), for: .touchUpInside)
        let plus = UIButton(type: .system)
        plus.setTitle("＋", for: .normal)
        plus.setTitleColor(.white, for: .normal)
        plus.addTarget(self, action: #selector(enlargeSelected), for: .touchUpInside)
        let scaleRow = UIStackView(arrangedSubviews: [label, minus, slider, plus])
        scaleRow.axis = .horizontal
        scaleRow.spacing = 8
        scaleRow.alignment = .center
        let column = UIStackView(arrangedSubviews: [row, scaleRow])
        column.axis = .vertical
        column.spacing = 4
        column.translatesAutoresizingMaskIntoConstraints = false
        layoutBar.addSubview(column)
        NSLayoutConstraint.activate([
            column.topAnchor.constraint(equalTo: layoutBar.topAnchor, constant: 6),
            column.bottomAnchor.constraint(equalTo: layoutBar.bottomAnchor, constant: -6),
            column.leadingAnchor.constraint(equalTo: layoutBar.leadingAnchor, constant: 8),
            column.trailingAnchor.constraint(equalTo: layoutBar.trailingAnchor, constant: -8)
        ])
    }

    @objc private func scaleChanged(_ sender: UISlider) {
        guard let key = selectedKey else {
            toast("先点一下要缩放的按键")
            refreshScaleUI()
            return
        }
        keyLayout.setScale(key, CGFloat(sender.value))
        controls.setKeyScale(key, CGFloat(sender.value))
        saveKeyLayout()
        refreshScaleUI()
    }

    @objc private func shrinkSelected() {
        guard let key = selectedKey else {
            toast("先点一下要缩放的按键")
            return
        }
        let next = keyLayout.scale(for: key) - 0.05
        keyLayout.setScale(key, next)
        controls.setKeyScale(key, keyLayout.scale(for: key))
        saveKeyLayout()
        refreshScaleUI()
    }

    @objc private func enlargeSelected() {
        guard let key = selectedKey else {
            toast("先点一下要缩放的按键")
            return
        }
        let next = keyLayout.scale(for: key) + 0.05
        keyLayout.setScale(key, next)
        controls.setKeyScale(key, keyLayout.scale(for: key))
        saveKeyLayout()
        refreshScaleUI()
    }

    private func selectKey(_ key: String) {
        selectedKey = key
        DispatchQueue.main.async { [weak self] in self?.refreshScaleUI() }
    }

    private func refreshScaleUI() {
        guard let label = scaleLabel, let slider = scaleSlider else { return }
        guard let key = selectedKey else {
            label.text = "点一下按键选中，再捏合或拖滑杆缩放"
            return
        }
        let scale = keyLayout.scale(for: key)
        let percent = Int((scale * 100).rounded())
        label.text = "选中 \(key.uppercased()) \(percent)%"
        slider.value = Float(scale)
    }

    @objc private func toggleLayout() {
        setLayoutEditing(!layoutEditing)
    }

    @objc private func finishLayout() {
        setLayoutEditing(false)
    }

    private func setLayoutEditing(_ on: Bool) {
        layoutEditing = on
        layoutBar.isHidden = !on
        controls.editing = on
        menuButton.isHidden = on
        if on {
            refreshScaleUI()
            showMenu()
            menuHideWork?.cancel()
        } else {
            layoutMenuButton()
            armMenuAutoHide()
        }
    }

    @objc private func resetLayout() {
        keyLayout.resetAll()
        selectedKey = nil
        saveKeyLayout()
        controls.setCenters([:])
        controls.setScales([:])
        refreshScaleUI()
        toast("已恢复默认键位")
    }

    @objc private func emulationLoop() {
        var frames: Int64 = 0
        var slices: Int64 = 0
        var fpsStamp = DispatchTime.now().uptimeNanoseconds
        // Start of the next emulation slice. Slices are scheduled against this
        // absolute target (instead of waiting out the rest of each slice), so
        // a gate wait that oversleeps cannot accumulate and slow the loop -
        // and with it the audio's pitch - down.
        var nextSlice = Int64(bitPattern: fpsStamp)
        var nextFastPresent: UInt64 = 0
        let audioIn = UnsafeMutablePointer<Int16>.allocate(capacity: 8192 * 2)
        var video: UnsafeMutablePointer<UInt32>?
        var videoCap = 0
        defer {
            audioIn.deallocate()
            video?.deallocate()
        }
        while running {
            guard let core else { continue }
            mgbaMobilePumpLink(core)
            gate.lock()
            let path = pendingPath
            pendingPath = nil
            let cmd = command
            command = 0
            let isPaused = paused
            let mult: Double = (fastHold || ffOn) ? max(speed, fastHoldSpeed()) : speed
            gate.unlock()
            if let path {
                loadRom(path)
                // Loading blocks for a while; start the pacing schedule and
                // the feedback window fresh so the stall is not measured as
                // this front end being slow.
                nextSlice = Int64(bitPattern: DispatchTime.now().uptimeNanoseconds)
                slices = 0
                fpsStamp = UInt64(bitPattern: nextSlice)
            }
            if cmd != 0 {
                runCommand(cmd)
                nextSlice = Int64(bitPattern: DispatchTime.now().uptimeNanoseconds)
                slices = 0
                fpsStamp = UInt64(bitPattern: nextSlice)
            }
            if isPaused || !mgbaMobileIsLoaded(core) {
                // Do not carry stale pacing across a paused stretch: a resumed
                // game would otherwise be reported as a slow front end for one
                // window.
                slices = 0
                fpsStamp = DispatchTime.now().uptimeNanoseconds
                frameDebt = 0
                gate.lock()
                let until = Date(timeIntervalSinceNow: 0.016)
                gate.wait(until: until)
                gate.unlock()
                continue
            }
            // 按住倒带: one second every ~400 ms; emulation pauses while the
            // button is held, like the Android rewind bar.
            gate.lock()
            let wantHoldRewind = rewindHold
            let lastRewind = lastRewindAt
            gate.unlock()
            if wantHoldRewind {
                let holdNow = DispatchTime.now().uptimeNanoseconds
                if lastRewind == 0 || holdNow &- lastRewind >= 400_000_000 {
                    gate.lock()
                    lastRewindAt = holdNow
                    gate.unlock()
                    if mgbaMobileRewind(core, 1) {
                        mgbaMobileClearAudio(core)
                        _ = mgbaMobileRunFrames(core, 1)
                        // This branch skips the pacing and present below it, so
                        // the rewound frame has to be shown here or holding the
                        // button would look frozen.
                        present(core, &video, &videoCap)
                    } else {
                        gate.lock()
                        rewindHold = false
                        gate.unlock()
                        toast("没有可倒带的历史")
                    }
                }
                slices = 0
                fpsStamp = DispatchTime.now().uptimeNanoseconds
                gate.lock()
                gate.wait(until: Date(timeIntervalSinceNow: 0.016))
                gate.unlock()
                continue
            }
            let wantSound = defaults.object(forKey: "fast_audio") == nil ? true : defaults.bool(forKey: "fast_audio")
            audio.setSoundEnabled(wantSound)
            // 音乐原速: at fast-forward the score keeps its own tempo and pitch
            // while the surplus is cut in whole sections on gaps between notes
            // (native hold). The published stretch follows the multiplier even
            // though audioSpeed stays at 1.
            let musicNative = defaults.object(forKey: "fast_audio_native") == nil ? true : defaults.bool(forKey: "fast_audio_native")
            let holdOn = wantSound && musicNative && mult > 1.01
            if holdOn != holdEngaged || (holdOn && mult != lastHoldStretch) {
                if holdOn {
                    mgbaMobileSetAudioConstantPitch(core, true, mult)
                    mgbaMobileSetAudioHoldMode(core, Int32(MOBILE_AUDIO_HOLD_NATIVE))
                } else {
                    mgbaMobileSetAudioConstantPitch(core, false, 1.0)
                }
                holdEngaged = holdOn
                lastHoldStretch = mult
            }
            // Fast-forward keeps its sound unless it was switched off; with the
            // hold engaged the resampler plays the 1x stream, so a change only
            // needs the queues dropped.
            var audioSpeed: Double = wantSound ? mult : 1
            if holdOn {
                audioSpeed = 1
            }
            // The game speed keys the flush too: 音乐原速 holds audioSpeed at 1
            // across the 1x -> 4x switch, and the parked audio, the pace estimate
            // and the ff schedule all have to restart for the new rate.
            if audioSpeed != lastAudioSpeed || mult != lastGameSpeed {
                lastGameSpeed = mult
                lastAudioSpeed = audioSpeed
                audio.flush()
                audio.resetRateControl()
                mgbaMobileClearAudio(core)
                // Drop the pace estimate too, so the core's resampler re-locks
                // from the throughput memory - or, on the first fast-forward on
                // this device, from the first fresh reading - after the speed
                // change instead of chasing a stale reading.
                mgbaMobileResetAudioPace(core)
                // The sustainable slice rate differs per speed: re-learn it.
                fastPace = 0
                fastSliceNanos = 0
                fastResyncs = 0
                // A pace window straddling the change blends the two rates
                // (half a second of 1x plus half of 16x reports a meaningless
                // middle value) and the resampler would lock onto it; start the
                // measurement window fresh, same as after a stall.
                slices = 0
                frames = 0
                fpsStamp = DispatchTime.now().uptimeNanoseconds
                // Playback holds back until the rate is trustworthy: with a
                // throughput memory this is instant, and on the first
                // fast-forward it waits out one window - a beat of silence
                // instead of wrong-pitch audio draining into gaps.
                paceSeeded = mgbaMobileAudioPaceSeeded(core)
            }
            // Fractional speeds (slow motion) accumulate whole frames in a
            // small debt; integer speeds drain it every slice.
            frameDebt += mult
            if frameDebt > 48 {
                frameDebt = 48
            }
            let framesToRun = Int(frameDebt)
            if framesToRun > 0 {
                frameDebt -= Double(framesToRun)
                // Run in a few steps, pumping audio in between: a fast-forward
                // burst makes several frames of audio at once and the core's
                // audio buffer only holds a little more, so leaving it
                // undrained garbles the sound.
                let steps = max(1, (framesToRun + Self.audioStepFrames - 1) / Self.audioStepFrames)
                let step = (framesToRun + steps - 1) / steps
                var done = 0
                while done < framesToRun {
                    let n = min(step, framesToRun - done)
                    _ = mgbaMobileRunFrames(core, Int32(n))
                    pumpAudio(core: core, buffer: audioIn, speed: audioSpeed, drop: !wantSound && mult > 1)
                    done += n
                }
                pollRumble(core: core)
            } else {
                pumpAudio(core: core, buffer: audioIn, speed: audioSpeed, drop: false)
            }
            if mult <= 1.5 {
                present(core, &video, &videoCap)
            } else {
                let now = DispatchTime.now().uptimeNanoseconds
                if now >= nextFastPresent {
                    present(core, &video, &videoCap)
                    nextFastPresent = now + 80_000_000
                }
            }
            frames += Int64(framesToRun)
            slices += 1
            // Pace at the console's own frame time (about 16.74 ms, 59.73 fps,
            // for GBA and GB): a rounded 60 fps would play games and their
            // audio about 0.46% fast, which sounds slightly sharp.
            let frameNanos = mgbaMobileFrameNanos(core)
            let sliceNanos = frameNanos > 0 ? frameNanos : 1_000_000_000 / 60
            // Schedule slices against an absolute next start. A gate wait that
            // oversleeps then cannot accumulate into a loop that runs (and
            // pitches the music) slightly slow; a stall that leaves the loop
            // more than two slices behind starts a fresh schedule instead of
            // replaying a catching-up burst.
            //
            // While fast-forwarding the device usually cannot hold the
            // requested speed, and pure free-running (rescheduling from "now"
            // every slice) lets every scheduling hiccup straight into the game
            // speed - and with tape-style audio, into the pitch. The schedule
            // therefore eases toward the rate the device actually sustains,
            // measured once per feedback window: the first window free-runs
            // and locks that rate; while the schedule holds with slack it
            // climbs gently (additive), and whenever slices had to resync it
            // follows the delivered rate back down (multiplicative). A
            // delivered-rate schedule alone would ratchet - one noisy low
            // window would slow the pace for good, since a paced loop can
            // never deliver more than its own schedule - and a work-time
            // measure is polluted by the every-80ms presentation cost, which
            // made the schedule thrash. Additive-increase/
            // multiplicative-decrease avoids both.
            let fastPacing = mult > 1.5 && fastSliceNanos > 0
            let paceNanos = fastPacing ? fastSliceNanos : sliceNanos
            nextSlice += paceNanos
            let sliceNow = Int64(bitPattern: DispatchTime.now().uptimeNanoseconds)
            if sliceNow - nextSlice > 2 * paceNanos {
                nextSlice = sliceNow
                if mult > 1.5 {
                    fastResyncs += 1
                }
            } else {
                let remain = nextSlice - sliceNow
                if remain > 1_000_000 {
                    gate.lock()
                    gate.wait(until: Date(timeIntervalSinceNow: Double(remain) / 1_000_000_000))
                    gate.unlock()
                }
            }
            // 自动跳帧：the loop keeps score of how consistently it lands
            // late, and eases one or two skip levels in or out so slow
            // devices hold speed without stuttering every frame.
            if skipAuto {
                let late = Int64(bitPattern: DispatchTime.now().uptimeNanoseconds) - nextSlice
                lateStreak = late > 0 ? min(lateStreak + 1, 90) : max(lateStreak - 3, 0)
                let want = lateStreak > 60 ? 2 : lateStreak > 30 ? 1 : 0
                if want != autoSkipLevel {
                    autoSkipLevel = want
                    mgbaMobileSetFrameskip(core, Int32(want))
                }
            }
            let now = DispatchTime.now().uptimeNanoseconds
            if now &- fpsStamp >= 1_000_000_000 {
                let shown = frames
                let cycles = slices
                let elapsed = now &- fpsStamp
                let shownSpeed = mult
                frames = 0
                slices = 0
                fpsStamp = now
                // How many pacing cycles the loop really completed this
                // window: the audio resampler follows this rate so heavy games
                // that cannot hold the console's frame time do not starve it.
                if elapsed > 0 {
                    let achieved = Double(cycles) * 1_000_000_000 / Double(elapsed)
                    mgbaMobileSetAudioPaceFps(core, achieved)
                    // The window's reading locked the pace (or refreshed the
                    // seed): playback may start.
                    paceSeeded = true
                    if mult > 1.5 {
                        // Ease the fast-forward schedule toward the rate the
                        // device actually sustains: lock on the first window
                        // (it free-ran, so the reading is raw capability),
                        // follow the delivered rate down after any resync, and
                        // climb gently while the schedule held with slack -
                        // capped at the requested pacing rate.
                        if fastPace <= 0 {
                            fastPace = achieved
                        } else if fastResyncs > 0 {
                            fastPace += (achieved - fastPace) * 0.4
                        } else {
                            fastPace = min(fastPace * 1.03, 1_000_000_000 / Double(sliceNanos))
                        }
                        fastSliceNanos = Int64(1_000_000_000 / fastPace)
                    }
                }
                fastResyncs = 0
                // Rounded so the console's own 59.73 fps still shows as the 60
                // the counter has always displayed.
                let shownFps = elapsed > 0 ? Int((Double(shown) * 1_000_000_000 / Double(elapsed)).rounded()) : 0
                let shownSpeedText = Self.speedLabel(shownSpeed)
                DispatchQueue.main.async { [weak self] in
                    self?.fpsView.text = "\(shownSpeedText)倍 \(shownFps)fps"
                }
            }
        }
        stopped.signal()
    }

    /// Hands the core's resampled output to the playback queue, telling it how
    /// full that queue is so the audio clock stays locked to the device.
    private func pumpAudio(core: OpaquePointer, buffer: UnsafeMutablePointer<Int16>, speed: Double, drop: Bool) {
        if drop {
            mgbaMobileClearAudio(core)
            return
        }
        if !paceSeeded {
            // First fast-forward on this device: no locked pace and no
            // throughput memory to seed from. Converting now would queue
            // wrong-pitch audio; hold silent until the first feedback window
            // lands, then fill at the locked rate.
            mgbaMobileClearAudio(core)
            return
        }
        let drift = audio.rateDrift()
        var rounds = 0
        while rounds < 8 {
            let got = mgbaMobileReadAudioOut(core, buffer, Self.audioReadFrames, speed, drift)
            if got <= 0 { break }
            audio.pump(samples: buffer, frames: Int(got))
            rounds += 1
            if got < Self.audioReadFrames { break }
        }
    }

    /// Cartridge rumble pulses become a short haptic tap, throttled to one per
    /// 200 ms so long shakes read as one event.
    private func pollRumble(core: OpaquePointer) {
        let hits = mgbaMobileTakeRumbles(core)
        guard hits > 0 else { return }
        let now = DispatchTime.now().uptimeNanoseconds
        if now &- lastRumbleAt < 200_000_000 {
            return
        }
        lastRumbleAt = now
        DispatchQueue.main.async { [weak self] in
            self?.hapticHeavy.impactOccurred()
        }
    }

    private func present(_ core: OpaquePointer, _ video: inout UnsafeMutablePointer<UInt32>?, _ cap: inout Int) {
        let w = Int(mgbaMobileWidth(core))
        let h = Int(mgbaMobileHeight(core))
        if w <= 0 || h <= 0 { return }
        if cap < w * h {
            video?.deallocate()
            video = UnsafeMutablePointer<UInt32>.allocate(capacity: w * h)
            cap = w * h
        }
        guard let video, mgbaMobileCopyVideo(core, video, Int32(w)) else { return }
        captureGifFrame(pixels: video, width: w, height: h)
        if presentQueued { return }
        presentQueued = true
        let data = Data(bytes: video, count: w * h * 4)
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            data.withUnsafeBytes { raw in
                if let base = raw.bindMemory(to: UInt32.self).baseAddress {
                    self.gameView.present(pixels: base, width: w, height: h, stride: w)
                }
            }
            if self.gifWantCapture {
                self.gifWantCapture = false
                data.withUnsafeBytes { raw in
                    guard let base = raw.baseAddress else { return }
                    if let frame = self.gameView.captureFilteredFrame(
                        pixels: base, width: w, height: h,
                        outWidth: w, outHeight: h,
                        brightness: Float(min(150, max(50, self.gameView.brightness))) / 100,
                        contrast: Float(min(150, max(50, self.gameView.contrast))) / 100) {
                        self.gifQueue?.offer(frame)
                    } else if self.gifQueue != nil {
                        // Metal capture unavailable: keep the raw frame.
                        var copy = [UInt8](repeating: 0, count: w * h * 4)
                        copy.withUnsafeMutableBytes { dst in
                            guard let dstBase = dst.baseAddress else { return }
                            memcpy(dstBase, base, w * h * 4)
                        }
                        self.gifQueue?.offer(copy)
                    }
                }
            }
            self.presentQueued = false
        }
    }

    /// Hands the presented frame to the encoder at the GIF capture rate. With
    /// a filter or scanlines on screen the raw core frame would not match the
    /// display, so the capture is taken on the main thread right after the
    /// filtered present; the raw frame is otherwise the crisper source.
    private func captureGifFrame(pixels: UnsafePointer<UInt32>, width: Int, height: Int) {
        guard gifRecording, let queue = gifQueue else { return }
        let now = DispatchTime.now().uptimeNanoseconds / 1_000_000
        if now &- lastGifAt < Self.gifFrameMs {
            return
        }
        lastGifAt = now
        if gameView.showsFilteredOutput {
            // The main-thread present block performs the filtered capture.
            gifWantCapture = true
            return
        }
        // Core frames are RGBA in memory (byte 0 = R); the encoder reads them
        // back in that order.
        var copy = [UInt8](repeating: 0, count: width * height * 4)
        copy.withUnsafeMutableBytes { raw in
            guard let base = raw.baseAddress else { return }
            memcpy(base, pixels, width * height * 4)
        }
        queue.offer(copy)
    }

    private func loadRom(_ path: String) {
        guard let core else { return }
        currentRomPath = path
        applyRomSaveLocation(path)
        stopTimedSave()
        audio.stop()
        // The checksum keys the per-game overrides; compute it before the load
        // and cache it because a 32 MB ROM is not worth reading twice.
        if let cached = crcCache[path] {
            romCrc = cached
        } else if let crc = RomSettings.crc32(ofFile: URL(fileURLWithPath: path)) {
            romCrc = crc
            crcCache[path] = crc
        } else {
            romCrc = nil
        }
        let ok = mgbaMobileLoad(core, path)
        // 进出游戏时自动同步（设置里可关）
        if defaults.bool(forKey: "sync_auto") {
            runWebDavSync(quiet: true)
        }
        if !ok {
            DispatchQueue.main.async { [weak self] in
                self?.hint.isHidden = false
                self?.hint.text = "无法加载这个游戏"
                self?.toast("无法加载这个游戏")
                self?.showMenu()
            }
            return
        }
        DispatchQueue.main.async { [weak self] in
            self?.aiOverlay.hide()
        }
        var title = [CChar](repeating: 0, count: 32)
        mgbaMobileTitle(core, &title, 32)
        let name = String(cString: title).trimmingCharacters(in: .whitespaces)
        // The core converts its own stream to the rate the device runs at; the
        // queue level then steers that resampler (see AudioOut.rateDrift).
        audio.start()
        _ = mgbaMobileSetAudioOutput(core, Int32(audio.outputRate))
        // Do not let the previous game's overrides colour the global pass; the
        // per-game pass below loads this ROM's own overrides.
        perRomFilter = nil
        perRomSpeed = nil
        perRomSaveType = nil
        perRomPalette = nil
        applyCoreOptions()
        applyPerRomSettings()
        frameDebt = 0
        gate.lock()
        paused = false
        gate.unlock()
        // 进入游戏时自动读档：上次退出的进度。
        if defaults.bool(forKey: "auto_load_state"), mgbaMobileLoadState(core, Int32(Self.autoSlot)) {
            mgbaMobileClearAudio(core)
            _ = mgbaMobileRunFrames(core, 1)
        }
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            self.hint.isHidden = true
            self.pauseButton.setTitle("暂停", for: .normal)
            self.title = name.isEmpty ? "mGBA" : name
            self.showSaveLocation()
            self.refreshSlotButton()
            self.armMenuAutoHide()
            self.startTimedSave()
        }
    }

    /** Seconds the extra one-tap rewind key jumps back (1...10, default 2). */
    private func rewindTapSeconds() -> Int {
        let raw = defaults.object(forKey: "rewind_tap_seconds") == nil
            ? 2 : defaults.integer(forKey: "rewind_tap_seconds")
        return min(10, max(1, raw))
    }

    /** Only the extra rewind key lands here. The original rewind button,
     * seconds bar and hold-to-rewind are left untouched. */
    private func quickRewind() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        postCommand(cmdRewindQuick)
        wakeInput()
    }

    private func runCommand(_ cmd: Int) {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let current = slot
        if cmd == cmdSave {
            let ok = mgbaMobileSaveState(core, Int32(current))
            if ok {
                writePreview(current)
            } else {
                pendingPreview = nil
            }
            toast(ok ? "已保存即时存档 \(current)" : "即时存档失败")
            DispatchQueue.main.async { self.refreshSlotButton() }
        } else if cmd == cmdLoad {
            let ok = mgbaMobileLoadState(core, Int32(current))
            mgbaMobileClearAudio(core)
            if ok {
                _ = mgbaMobileRunFrames(core, 1)
            }
            toast(ok ? "已读取即时存档 \(current)" : "没有即时存档 \(current)")
            DispatchQueue.main.async { self.refreshSlotButton() }
        } else if cmd == cmdReset {
            mgbaMobileReset(core)
            mgbaMobileClearAudio(core)
            // The peer resets its own console to stay in sync.
            gboyLink?.sendReset()
            toast("已复位")
        } else if cmd == cmdAutoSave {
            // Silent save into the reserved slot on the way to the background.
            if mgbaMobileSaveState(core, Int32(Self.autoSlot)) {
                writePreview(Self.autoSlot)
            }
        } else if cmd == cmdRewind {
            let seconds = max(1, rewindSeconds)
            let ok = mgbaMobileRewind(core, Int32(seconds))
            mgbaMobileClearAudio(core)
            if ok {
                _ = mgbaMobileRunFrames(core, 1)
                toast("已倒带 \(seconds) 秒")
            } else {
                toast("没有可倒带的历史")
            }
        } else if cmd == cmdRewindQuick {
            let seconds = rewindTapSeconds()
            let ok = mgbaMobileRewind(core, Int32(seconds))
            mgbaMobileClearAudio(core)
            if ok {
                _ = mgbaMobileRunFrames(core, 1)
                toast("已倒带 \(seconds) 秒")
            } else {
                toast("没有可倒带的历史")
            }
        }
    }

    /// Drops every locally held key after the touch stream or focus was lost.
    /// Without this the matching UP/CANCEL can go to another window, and a
    /// latched A (or fast-forward hold) makes the next press look dead.
    private func releaseInput() {
        let held = touchKeys | hwKeys | padKeys
        let wasFastHold = fastHold
        touchKeys = 0
        hwKeys = 0
        padKeys = 0
        fastHold = false
        gate.lock()
        let wasHoldRewind = rewindHold
        rewindHold = false
        gate.unlock()
        controls.releaseAllKeys()
        armWork?.cancel()
        stopTurbo()
        if wasFastHold {
            refreshSpeedButtons()
        }
        if held != 0 || wasHoldRewind {
            publishKeys()
            wakeInput()
        }
    }

    private func noteUserKeys(prevTouch: Int, prevHw: Int, prevPad: Int) {
        let wasB = ((prevTouch | prevHw | prevPad) & ControlsView.B) != 0
        let nowB = ((touchKeys | hwKeys | padKeys) & ControlsView.B) != 0
        if nowB && !wasB {
            armWork?.cancel()
            // Holding B only auto-turboes in the classic mode; the dedicated
            // 连发 keys have their own pulsing in ControlsView.
            if turboModePref() == 0 {
                let work = DispatchWorkItem { [weak self] in self?.armTurbo() }
                armWork = work
                DispatchQueue.main.asyncAfter(deadline: .now() + Self.turboArmSeconds, execute: work)
            }
        } else if !nowB && wasB {
            armWork?.cancel()
            stopTurbo()
        }
        publishKeys()
    }

    /** Keys applied this frame: local input plus the GBoy peer's mask. */
    private func userKeys() -> Int {
        touchKeys | hwKeys | padKeys | gboyRemoteKeys
    }

    private func publishKeys() {
        guard let core else { return }
        // Keys applied now: local input plus the GBoy peer's mask.
        var mask = userKeys()
        if turboB { mask &= ~ControlsView.B }
        mgbaMobileSetKeys(core, UInt32(mask))
    }

    /** Vibration strength for on-screen key presses, 0-3. */
    private func vibrateOnKey(_ risingBits: Int) {
        guard risingBits != 0 else { return }
        let strength = defaults.integer(forKey: "touch_vibe")
        guard strength > 0 else { return }
        switch strength {
        case 1: hapticLight.impactOccurred()
        case 2: hapticMedium.impactOccurred()
        default: hapticRigid.impactOccurred()
        }
    }

    private func armTurbo() {
        if ((touchKeys | hwKeys | padKeys) & ControlsView.B) == 0 || turboB { return }
        turboB = true
        publishKeys()
        if let core { mgbaMobileSetTurbo(core, UInt32(ControlsView.B)) }
        controls.setBTurbo(active: true, lit: false)
        schedulePulse()
    }

    private func schedulePulse() {
        let work = DispatchWorkItem { [weak self] in
            guard let self else { return }
            if !self.turboB || ((self.touchKeys | self.hwKeys | self.padKeys) & ControlsView.B) == 0 {
                self.stopTurbo()
                return
            }
            let lit = self.controls.layer.presentation() != nil
            self.controls.setBTurbo(active: true, lit: !self.pulseLit)
            self.pulseLit.toggle()
            self.schedulePulse()
        }
        pulseWork = work
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.04, execute: work)
    }

    private var pulseLit = false

    private func stopTurbo() {
        let was = turboB
        turboB = false
        pulseLit = false
        pulseWork?.cancel()
        if let core { mgbaMobileSetTurbo(core, 0) }
        controls.setBTurbo(active: false, lit: false)
        if was { publishKeys() }
    }

    private func wakeInput() {
        gate.lock()
        gate.signal()
        gate.unlock()
    }

    @objc private func openRom() { pick(kind: 1) }
    @objc private func openBios() { pick(kind: 2) }

    private func pick(kind: Int) {
        pickerKind = kind
        let types: [UTType]
        var copy = false
        switch kind {
        case 3, 6, 8, 11:
            types = [.folder]
        case 4, 5:
            types = [.zip]
            // Archives are unpacked in the background; a local copy survives
            // iCloud providers that close their stream once the picker closes.
            copy = true
        case 7:
            types = [.image]
        default:
            types = [.data]
        }
        let picker = UIDocumentPickerViewController(forOpeningContentTypes: types, asCopy: copy)
        picker.delegate = self
        presentSheet(picker)
    }

    func documentPicker(_ controller: UIDocumentPickerViewController, didPickDocumentsAt urls: [URL]) {
        let kind = pickerKind
        pickerKind = 0
        guard let url = urls.first else { return }
        switch kind {
        case 1:
            openExternal(url)
        case 2:
            DispatchQueue.global().async { [weak self] in self?.importBios(url) }
        case 3:
            importMyBoySaves(urls)
        case 4:
            importBackup(url)
        case 5:
            importSkinZip(url)
        case 6:
            importSkinFolder(url)
        case 7:
            importStickerImage(url)
        case 8:
            importStickerFolder(url)
        case 11:
            addCustomRomFolder(url)
        case 10:
            installShader(url)
        case 9:
            // The archive was copied out to the chosen location; the temporary
            // file can go now.
            if let temp = backupExportURL {
                try? FileManager.default.removeItem(at: temp)
            }
            backupExportURL = nil
            toast("备份已导出")
        default:
            break
        }
    }

    func documentPickerWasCancelled(_ controller: UIDocumentPickerViewController) {
        if pickerKind == 9, let temp = backupExportURL {
            try? FileManager.default.removeItem(at: temp)
            backupExportURL = nil
        }
        pickerKind = 0
    }

    /// Loads a ROM handed over by the file picker or by another app ("用 mGBA
    /// 打开" in the Files app). Like the Android build, the file stays where it
    /// is; only a location that cannot be read back is copied into the app.
    /// The `mgba://` debug hooks - the iOS counterpart of the Android build's
    /// ADB broadcasts. They are meant for automation, not for everyday use:
    ///
    ///   mgba://state              dump the emulator state as JSON
    ///   mgba://rom                dump the ROM identity only
    ///   mgba://action=pause       pause the game
    ///   mgba://action=resume      resume the game
    ///   mgba://action=reset       reset the game
    ///   mgba://action=screenshot  take a screenshot
    ///   mgba://cloud?room=&user=&pass=   join a cloud lobby room
    ///
    /// The state dump is written to Documents/mgba-state.json and copied to
    /// the pasteboard.
    func handleDebugURL(_ url: URL) {
        let parts = url.pathComponents.filter { $0 != "/" }
        let command = parts.first?.lowercased() ?? ""
        let query = URLComponents(url: url, resolvingAgainstBaseURL: false)?.queryItems ?? []
        func value(_ name: String) -> String {
            query.first { $0.name.lowercased() == name }?.value ?? ""
        }
        switch command {
        case "state", "rom":
            dumpState(romOnly: command == "rom")
        case "action":
            switch value("action").lowercased() {
            case "pause": togglePause()
            case "resume": if paused { togglePause() }
            case "reset": resetGame()
            case "screenshot": takeScreenshot()
            default: toast("未知动作")
            }
        case "cloud":
            let room = value("room")
            let user = value("user")
            let pass = value("pass")
            guard !room.isEmpty, !user.isEmpty else {
                toast("需要 room 与 user 参数")
                return
            }
            ensureLobby().start(user: user, password: pass, roomId: room)
        default:
            toast("未知命令")
        }
    }

    /// Writes the emulator state as JSON and copies a summary to the
    /// pasteboard.
    private func dumpState(romOnly: Bool) {
        var info: [String: Any] = [:]
        var title = "mGBA"
        if let core, mgbaMobileIsLoaded(core) {
            var buffer = [CChar](repeating: 0, count: 32)
            mgbaMobileTitle(core, &buffer, 32)
            title = String(cString: buffer).trimmingCharacters(in: .whitespaces)
            info["title"] = title
            info["width"] = Int(mgbaMobileWidth(core))
            info["height"] = Int(mgbaMobileHeight(core))
            info["paused"] = paused
            info["speed"] = speed
            if !romOnly {
                info["link"] = lobbyLink == nil ? "none" : "cloud"
                info["filters"] = Self.filterNames[filterPref()]
                info["solar"] = defaults.bool(forKey: "solar_on")
            }
        }
        info["rom"] = defaults.string(forKey: "lastRom") ?? ""
        info["crc"] = romCrc.map { String(format: "0x%08X", $0) } ?? ""
        guard let data = try? JSONSerialization.data(withJSONObject: info,
                                                  options: [.prettyPrinted, .sortedKeys]),
              let text = String(data: data, encoding: .utf8) else {
            return
        }
        let file = docs.appendingPathComponent("mgba-state.json")
        try? text.write(to: file, atomically: true, encoding: .utf8)
        UIPasteboard.general.string = text
        toast("状态已写入 \(file.lastPathComponent) 并复制到剪贴板")
    }

    func openExternal(_ url: URL) {
        hint.isHidden = false
        hint.text = "正在读取游戏…"
        guard let adopted = adoptRomURL(url) else {
            toast("无法加载这个游戏")
            return
        }
        var path = adopted
        if adopted.lowercased().hasSuffix(".zip") {
            // A zip archive: pull the first game entry into Documents, like
            // the Android build. The archive itself stays where it was.
            guard let extracted = extractRomZip(URL(fileURLWithPath: adopted)) else {
                stopAccessingScopedRom()
                defaults.removeObject(forKey: "lastRomBookmark")
                hint.isHidden = true
                toast("压缩包里没有可用的游戏")
                return
            }
            path = extracted
            stopAccessingScopedRom()
            let extractedURL = URL(fileURLWithPath: path)
            if let bookmark = try? extractedURL.bookmarkData(options: [], includingResourceValuesForKeys: nil, relativeTo: nil) {
                defaults.set(bookmark, forKey: "lastRomBookmark")
            } else {
                defaults.removeObject(forKey: "lastRomBookmark")
            }
        }
        defaults.set(path, forKey: "lastRom")
        gate.lock()
        pendingPath = path
        gate.signal()
        gate.unlock()
    }

    private func adoptRomURL(_ url: URL) -> String? {
        stopAccessingScopedRom()
        if url.startAccessingSecurityScopedResource() {
            scopedURL = url
        }
        if FileManager.default.isReadableFile(atPath: url.path) {
            // Remember the file so the next launch can reopen it directly.
            if let bookmark = try? url.bookmarkData(options: [], includingResourceValuesForKeys: nil, relativeTo: nil) {
                defaults.set(bookmark, forKey: "lastRomBookmark")
            } else {
                defaults.removeObject(forKey: "lastRomBookmark")
            }
            return url.path
        }
        defaults.removeObject(forKey: "lastRomBookmark")
        return copyIn(url, docs.appendingPathComponent("roms", isDirectory: true), nil)
    }

    private func resolveBookmark(_ data: Data) -> URL? {
        var stale = false
        guard let url = try? URL(resolvingBookmarkData: data, options: [], relativeTo: nil, bookmarkDataIsStale: &stale) else {
            return nil
        }
        if url.startAccessingSecurityScopedResource() {
            return url
        }
        return FileManager.default.isReadableFile(atPath: url.path) ? url : nil
    }

    private func stopAccessingScopedRom() {
        scopedURL?.stopAccessingSecurityScopedResource()
        scopedURL = nil
    }

    private func importBios(_ url: URL) {
        let name = url.lastPathComponent
        guard let copied = copyIn(url, docs.appendingPathComponent("tmp-bios", isDirectory: true), "bios-import.bin") else {
            toast("BIOS 导入失败")
            return
        }
        let size = (try? FileManager.default.attributesOfItem(atPath: copied)[.size] as? NSNumber)?.int64Value ?? 0
        var destName = [CChar](repeating: 0, count: 32)
        mgbaMobileBiosFileName(name, Int(size), &destName, 32)
        let folder = docs.appendingPathComponent("config/mgba", isDirectory: true)
        try? FileManager.default.createDirectory(at: folder, withIntermediateDirectories: true)
        let dest = folder.appendingPathComponent(String(cString: destName))
        try? FileManager.default.removeItem(at: dest)
        do {
            try FileManager.default.moveItem(atPath: copied, toPath: dest.path)
        } catch {
            toast("BIOS 导入失败")
            return
        }
        toast("已导入 \(dest.lastPathComponent)，重新打开游戏后生效")
        if let last = defaults.string(forKey: "lastRom") {
            gate.lock()
            pendingPath = last
            gate.signal()
            gate.unlock()
        }
    }

    private func copyIn(_ url: URL, _ dir: URL, _ forced: String?) -> String? {
        try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        let name = forced ?? sanitize(url.lastPathComponent)
        let dest = dir.appendingPathComponent(name)
        if url.startAccessingSecurityScopedResource() {
            defer { url.stopAccessingSecurityScopedResource() }
            return writeCopy(url, dest)
        }
        return writeCopy(url, dest)
    }

    private func writeCopy(_ url: URL, _ dest: URL) -> String? {
        do {
            if FileManager.default.fileExists(atPath: dest.path) {
                try FileManager.default.removeItem(at: dest)
            }
            try FileManager.default.copyItem(at: url, to: dest)
            return dest.path
        } catch {
            return nil
        }
    }

    private func sanitize(_ name: String) -> String {
        let cleaned = name.replacingOccurrences(of: "[\\\\/:*?\"<>|]", with: "_", options: .regularExpression).trimmingCharacters(in: .whitespaces)
        if cleaned.isEmpty { return "game.gba" }
        if cleaned.count > 120 { return String(cleaned.suffix(120)) }
        return cleaned
    }

    @objc private func togglePause() {
        gate.lock()
        paused.toggle()
        let value = paused
        gate.unlock()
        pauseButton.setTitle(value ? "继续" : "暂停", for: .normal)
        audio.setPaused(value)
        if !value { wakeInput() }
    }

    @objc private func toggleSpeedBar() {
        speedBarWanted.toggle()
        updateMenuLayout()
        armMenuAutoHide()
    }

    /** Speed used while the fast-forward key is held (TAB, controller, 倍速 key). */
    private func fastHoldSpeed() -> Double {
        Double(min(16, max(2, defaults.integer(forKey: "fast_hold") == 0 ? 16 : defaults.integer(forKey: "fast_hold"))))
    }

    @objc private func pickTier(_ sender: UIButton) {
        guard let index = speedButtons.firstIndex(of: sender), index < Self.speedTiers.count else { return }
        setSpeed(Self.speedTiers[index])
    }

    @objc private func showCustomSpeed() {
        let alert = UIAlertController(title: "自定义", message: "0.05 ~ 16 之间，支持慢动作", preferredStyle: .alert)
        alert.addTextField { field in
            field.text = Self.speedLabel(self.speed)
            field.keyboardType = .decimalPad
        }
        alert.addAction(UIAlertAction(title: "确定", style: .default) { [weak self] _ in
            guard let self else { return }
            var value = Double(alert.textFields?.first?.text?.trimmingCharacters(in: .whitespaces).replacingOccurrences(of: ",", with: ".") ?? "") ?? -1
            if value < 0 {
                self.toast("倍速范围仅限 0.05~16")
                return
            }
            self.setSpeed(value)
        })
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(alert)
    }

    private func setSpeed(_ value: Double) {
        speed = min(16, max(0.05, value))
        refreshSpeedButtons()
        audio.flush()
        if let core { mgbaMobileClearAudio(core) }
        armMenuAutoHide()
    }

    @objc private func toggleMenu() {
        if menuVisible {
            hideMenuNow()
        } else {
            showMenu()
        }
    }

    /// Pops the menu open and arms the auto-hide timer.
    private func showMenu() {
        setMenuVisible(true)
        armMenuAutoHide()
    }

    private func hideMenuNow() {
        menuHideWork?.cancel()
        setMenuVisible(false)
    }

    private func setMenuVisible(_ visible: Bool) {
        menuVisible = visible
        updateMenuLayout()
    }

    /// Collapses the top rows while the menu is away, so the game fills the
    /// screen the way it does on Android.
    private func updateMenuLayout() {
        let showSpeed = menuVisible && speedBarWanted
        let showRewind = menuVisible && rewindWanted
        let showPath = menuVisible && savePathWanted
        bar.isHidden = !menuVisible
        speedBar.isHidden = !showSpeed
        rewindBar.isHidden = !showRewind
        savePathView.isHidden = !showPath
        speedBarHeight.constant = showSpeed ? 40 : 0
        rewindBarHeight.constant = showRewind ? 40 : 0
        if showPath {
            let width = max(0, view.bounds.width - 16)
            let height = savePathView.sizeThatFits(CGSize(width: width, height: .greatestFiniteMagnitude)).height
            savePathHeight.constant = max(14, height)
        } else {
            savePathHeight.constant = 0
        }
    }

    /// Hides the menu again after a moment without use; only while a game runs.
    private func armMenuAutoHide() {
        menuHideWork?.cancel()
        guard !layoutEditing, let core, mgbaMobileIsLoaded(core) else { return }
        let work = DispatchWorkItem { [weak self] in self?.hideMenuNow() }
        menuHideWork = work
        DispatchQueue.main.asyncAfter(deadline: .now() + Self.menuHideSeconds, execute: work)
    }

    /// Touching the menu at all keeps it open.
    @objc private func menuTouched(_ gesture: UIGestureRecognizer) {
        guard menuVisible else { return }
        let point = gesture.location(in: view)
        let inside = bar.frame.contains(point)
            || (speedBarWanted && speedBar.frame.contains(point))
            || (rewindWanted && rewindBar.frame.contains(point))
            || (savePathWanted && savePathView.frame.contains(point))
        if inside { armMenuAutoHide() }
    }

    /// Keeps the menu handle out of the keys' way: next to the on-screen START
    /// key in landscape, on the top edge of the lower screen in portrait.
    private func layoutMenuButton() {
        guard menuButton != nil, menuLeading != nil, menuCenterY != nil else { return }
        // The shell already draws its own menu button in the portrait toolbar;
        // while laying keys out the floating handle would only cover them.
        if layoutEditing || (portrait && skinStylePref() == ControlsView.styleHandheld) {
            menuButton.isHidden = true
            return
        }
        menuButton.isHidden = false
        let size = menuButton.bounds.size == .zero ? menuButton.intrinsicContentSize : menuButton.bounds.size
        let left: CGFloat
        let top: CGFloat
        if portrait {
            left = max(4, (stage.bounds.width - size.width) / 2)
            top = stage.bounds.height / 2 + 8 + size.height / 2
        } else {
            let start = controls.startButtonRect()
            if start.width <= 0 { return }
            left = start.maxX + 4
            top = start.midY
        }
        if abs(left - menuLeft) < 0.5 && abs(top - menuTop) < 0.5 { return }
        menuLeft = left
        menuTop = top
        menuLeading.constant = left
        menuCenterY.constant = top
    }

    private func refreshSpeedButtons() {
        let shown = (fastHold || ffOn) ? max(speed, fastHoldSpeed()) : speed
        fastButton.setTitle("\(Self.speedLabel(shown))倍", for: .normal)
        var tierMatched = false
        for (index, button) in speedButtons.enumerated() {
            let on = !tierMatched && index < Self.speedTiers.count && abs(Self.speedTiers[index] - speed) < 0.001
            if on { tierMatched = true }
            button.setTitleColor(on ? UIColor(red: 0.06, green: 0.13, blue: 0.06, alpha: 1) : .white, for: .normal)
            button.backgroundColor = on ? UIColor(red: 61 / 255, green: 220 / 255, blue: 132 / 255, alpha: 1) : .clear
        }
        speedCustomButton?.setTitleColor(!tierMatched ? UIColor(red: 0.06, green: 0.13, blue: 0.06, alpha: 1) : .white, for: .normal)
        speedCustomButton?.backgroundColor = !tierMatched ? UIColor(red: 61 / 255, green: 220 / 255, blue: 132 / 255, alpha: 1) : .clear
    }

    private static func speedLabel(_ value: Double) -> String {
        value == value.rounded() && abs(value) < 1000 ? String(Int(value)) : String(format: "%.2f", value)
    }

    /** Settings hub: display, sound, input, saves and hardware extras. */
    @objc private func showSettings() {
        let alert = UIAlertController(title: "设置", message: nil, preferredStyle: .actionSheet)
        alert.addAction(UIAlertAction(title: "屏幕方向", style: .default) { [weak self] _ in self?.showOrientationDialog() })
        alert.addAction(UIAlertAction(title: "声音", style: .default) { [weak self] _ in self?.showSoundDialog() })
        alert.addAction(UIAlertAction(title: "输入", style: .default) { [weak self] _ in self?.showInputDialog() })
        alert.addAction(UIAlertAction(title: "存档", style: .default) { [weak self] _ in self?.showSaveSettingsDialog() })
        alert.addAction(UIAlertAction(title: "ROM 文件夹", style: .default) { [weak self] _ in self?.showRomDirsDialog() })
        alert.addAction(UIAlertAction(title: "高级", style: .default) { [weak self] _ in self?.showAdvanced() })
        alert.addAction(UIAlertAction(title: "帮助", style: .default) { [weak self] _ in self?.showHelpDialog() })
        alert.addAction(UIAlertAction(title: "关闭", style: .cancel))
        if let popover = alert.popoverPresentationController {
            popover.sourceView = view
            popover.sourceRect = CGRect(x: view.bounds.midX, y: view.bounds.midY, width: 0, height: 0)
        }
        presentSheet(alert)
    }

    private func showOrientationDialog() {
        let alert = UIAlertController(title: "屏幕方向", message: nil, preferredStyle: .alert)
        let modes: [(String, String)] = [
            ("auto", "自动旋转"),
            ("system", "系统默认"),
            ("landscape", "横屏"),
            ("landscape_rev", "横屏（反向）"),
            ("portrait", "竖屏"),
            ("portrait_rev", "竖屏（反向）"),
        ]
        for (mode, label) in modes {
            let mark = mode == orientationMode ? "✓ " : ""
            alert.addAction(UIAlertAction(title: mark + label, style: .default) { [weak self] _ in
                self?.chooseOrientation(mode)
            })
        }
        alert.addAction(UIAlertAction(title: "关闭", style: .cancel))
        presentSheet(alert)
    }

    /** Output gain; mute only silences playback, the volume stays stored. */
    private func applyVolume() {
        let percent = defaults.object(forKey: "volume") == nil ? 100 : defaults.integer(forKey: "volume")
        audio.volume = muted ? 0 : Float(max(0, min(150, percent))) / 100
    }

    private func showSoundDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let volumeNow = defaults.object(forKey: "volume") == nil ? 100 : defaults.integer(forKey: "volume")
        let volumeLabel = UILabel()
        volumeLabel.text = "音量 \(volumeNow)%"
        let volume = UISlider()
        volume.minimumValue = 0
        volume.maximumValue = 150
        volume.value = Float(volumeNow)
        volume.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let percent = Int(volume.value)
            volumeLabel.text = "音量 \(percent)%"
            self.defaults.set(percent, forKey: "volume")
            self.applyVolume()
        }, for: .valueChanged)
        let lowLatency = labeledSwitch("低延迟音频（支持的设备上减少声音延迟）", defaults.bool(forKey: "low_latency"))
        lowLatency.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(lowLatency.1.isOn, forKey: "low_latency")
            self.audio.lowLatency = lowLatency.1.isOn
        }, for: .valueChanged)
        box.addArrangedSubview(volumeLabel)
        box.addArrangedSubview(volume)
        box.addArrangedSubview(lowLatency.0)
        // Per-channel gains, in the spirit of Pizza Boy's 声道音量.
        let channelKeys = ["vol_ch1", "vol_ch2", "vol_ch3", "vol_ch4", "vol_cha", "vol_chb"]
        let channelNames = ["声道 1", "声道 2", "声道 3", "声道 4", "声道 A", "声道 B"]
        for (index, key) in channelKeys.enumerated() {
            let value = defaults.object(forKey: key) == nil ? 100 : defaults.integer(forKey: key)
            let label = UILabel()
            label.text = "\(channelNames[index]) \(value)%"
            let bar = UISlider()
            bar.minimumValue = 0
            bar.maximumValue = 150
            bar.value = Float(max(0, min(150, value)))
            bar.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                let percent = Int(bar.value)
                label.text = "\(channelNames[index]) \(percent)%"
                self.defaults.set(percent, forKey: key)
                self.applyChannelVolumes()
            }, for: .valueChanged)
            box.addArrangedSubview(label)
            box.addArrangedSubview(bar)
        }
        let hint = UILabel()
        hint.text = "声道音量只影响混音输出，100% 是游戏原始音量；仅静音时整体静音。"
        hint.textColor = .secondaryLabel
        hint.font = .systemFont(ofSize: 11)
        hint.numberOfLines = 0
        box.addArrangedSubview(hint)
        presentSheet(SheetController(title: "声音", content: box))
    }

    private func showInputDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let vibe = UIButton(type: .system)
        vibe.contentHorizontalAlignment = .left
        vibe.setTitle("触屏振动：\(Self.vibeName(defaults.integer(forKey: "touch_vibe")))", for: .normal)
        vibe.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "触屏振动", current: self.defaults.integer(forKey: "touch_vibe"),
                            options: ["关", "轻", "中", "强"]) { [weak self] index in
                guard let self else { return }
                self.defaults.set(index, forKey: "touch_vibe")
                vibe.setTitle("触屏振动：\(Self.vibeName(index))", for: .normal)
            }
        }, for: .touchUpInside)
        let turboMode = UIButton(type: .system)
        turboMode.contentHorizontalAlignment = .left
        turboMode.setTitle("连击方式：\(Self.turboModeName(turboModePref()))", for: .normal)
        turboMode.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "连击方式", current: self.turboModePref(),
                            options: ["长按 B 键自动连击", "仅用连发键", "关闭"]) { [weak self] index in
                guard let self else { return }
                self.defaults.set(index, forKey: "turbo_mode")
                turboMode.setTitle("连击方式：\(Self.turboModeName(index))", for: .normal)
            }
        }, for: .touchUpInside)
        let rateNow = defaults.integer(forKey: "turbo_rate") == 0 ? 25 : defaults.integer(forKey: "turbo_rate")
        let rateLabel = UILabel()
        rateLabel.text = "连击速度 \(rateNow) 次/秒"
        let rate = slider(max: 28, value: Float(max(2, min(30, rateNow)) - 2))
        let diagonal = labeledSwitch("禁用方向键对角（一次只按一个方向）", defaults.bool(forKey: "no_diagonal"))
        let opacityNow = defaults.object(forKey: "controls_opacity") == nil ? 100 : defaults.integer(forKey: "controls_opacity")
        let opacityLabel = UILabel()
        opacityLabel.text = "虚拟按键不透明度 \(opacityNow)%"
        let opacity = UISlider()
        opacity.minimumValue = 30
        opacity.maximumValue = 150
        opacity.value = Float(opacityNow)
        let keypadVisible = labeledSwitch("显示虚拟按键", !defaults.bool(forKey: "vkeypad_hidden"))
        keypadVisible.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let visible = keypadVisible.1.isOn
            self.defaults.set(!visible, forKey: "vkeypad_hidden")
            self.controls.isHidden = !visible
        }, for: .valueChanged)
        let keypadDetect = labeledSwitch("识别到实体按键时提示隐藏虚拟按键", defaults.bool(forKey: "keypad_detect"))
        keypadDetect.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(keypadDetect.1.isOn, forKey: "keypad_detect")
        }, for: .valueChanged)
        let extras = UIButton(type: .system)
        extras.contentHorizontalAlignment = .left
        extras.setTitle("虚拟按键开关（连发/宏/快存/快读/倍速/截图）", for: .normal)
        extras.addAction(UIAction { [weak self] _ in self?.showExtraKeysDialog() }, for: .touchUpInside)
        let cKey = UIButton(type: .system)
        cKey.contentHorizontalAlignment = .left
        cKey.setTitle("C 键组合宏：\(macroTitle(controls.macro(0)))", for: .normal)
        cKey.addAction(UIAction { [weak self] _ in
            self?.showMacroDialog(which: 0) { [weak self] in
                guard let self else { return }
                cKey.setTitle("C 键组合宏：\(self.macroTitle(self.controls.macro(0)))", for: .normal)
            }
        }, for: .touchUpInside)
        let c2Key = UIButton(type: .system)
        c2Key.contentHorizontalAlignment = .left
        c2Key.setTitle("C2 键组合宏：\(macroTitle(controls.macro(1)))", for: .normal)
        c2Key.addAction(UIAction { [weak self] _ in
            self?.showMacroDialog(which: 1) { [weak self] in
                guard let self else { return }
                c2Key.setTitle("C2 键组合宏：\(self.macroTitle(self.controls.macro(1)))", for: .normal)
            }
        }, for: .touchUpInside)
        let shotFormat = UIButton(type: .system)
        shotFormat.contentHorizontalAlignment = .left
        var formatIndex = (defaults.string(forKey: "shot_format") ?? "png").lowercased() == "jpg" ? 1 : 0
        shotFormat.setTitle("截图格式：\(formatIndex == 1 ? "JPG" : "PNG")", for: .normal)
        shotFormat.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "截图格式", current: formatIndex, options: ["PNG", "JPG"]) { [weak self] index in
                guard let self else { return }
                formatIndex = index
                self.defaults.set(index == 1 ? "jpg" : "png", forKey: "shot_format")
                shotFormat.setTitle("截图格式：\(index == 1 ? "JPG" : "PNG")", for: .normal)
            }
        }, for: .touchUpInside)
        let rewindTap = UIButton(type: .system)
        rewindTap.contentHorizontalAlignment = .left
        rewindTap.setTitle("倒带快捷键：\(rewindTapSeconds()) 秒 / 点一次", for: .normal)
        rewindTap.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let options = (1...10).map { "\($0) 秒" }
            self.pickOption(title: "倒带快捷键秒数", current: self.rewindTapSeconds() - 1,
                            options: options) { [weak self] index in
                guard let self else { return }
                let seconds = index + 1
                self.defaults.set(seconds, forKey: "rewind_tap_seconds")
                rewindTap.setTitle("倒带快捷键：\(seconds) 秒 / 点一次", for: .normal)
                self.controls.setQuickRewindSeconds(seconds)
            }
        }, for: .touchUpInside)
        let doubleShot = labeledSwitch("双击屏幕截图", defaults.bool(forKey: "double_click_shot"))
        doubleShot.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(doubleShot.1.isOn, forKey: "double_click_shot")
        }, for: .valueChanged)
        rate.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let value = Int(rate.value) + 2
            rateLabel.text = "连击速度 \(value) 次/秒"
            self.defaults.set(value, forKey: "turbo_rate")
            self.applyInputSettings()
        }, for: .valueChanged)
        diagonal.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(diagonal.1.isOn, forKey: "no_diagonal")
            self.applyInputSettings()
        }, for: .valueChanged)
        opacity.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let percent = Int(opacity.value)
            opacityLabel.text = "虚拟按键不透明度 \(percent)%"
            self.defaults.set(percent, forKey: "controls_opacity")
            self.applyInputSettings()
        }, for: .valueChanged)
        box.addArrangedSubview(vibe)
        box.addArrangedSubview(turboMode)
        box.addArrangedSubview(rateLabel)
        box.addArrangedSubview(rate)
        box.addArrangedSubview(diagonal.0)
        box.addArrangedSubview(opacityLabel)
        box.addArrangedSubview(opacity)
        box.addArrangedSubview(keypadVisible.0)
        box.addArrangedSubview(keypadDetect.0)
        box.addArrangedSubview(extras)
        box.addArrangedSubview(cKey)
        box.addArrangedSubview(c2Key)
        box.addArrangedSubview(shotFormat)
        box.addArrangedSubview(rewindTap)
        box.addArrangedSubview(doubleShot.0)
        let hint = UILabel()
        hint.text = "C/C2 是组合键：按住时同时按下所选按键。双击截图只响应游戏画面上的双击。"
        hint.textColor = .secondaryLabel
        hint.font = .systemFont(ofSize: 11)
        hint.numberOfLines = 0
        box.addArrangedSubview(hint)
        presentSheet(SheetController(title: "输入", content: box))
    }

    private func showExtraKeysDialog() {
        let enabled = extraKeys()
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 6
        for (key, label) in Self.extraKeyChoices {
            let row = labeledSwitch(label, enabled.contains(key))
            row.1.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                var next = self.extraKeys()
                if row.1.isOn {
                    next.insert(key)
                } else {
                    next.remove(key)
                }
                self.defaults.set(next.joined(separator: ","), forKey: "extra_keys")
                self.applyInputSettings()
            }, for: .valueChanged)
            box.addArrangedSubview(row.0)
        }
        presentSheet(SheetController(title: "虚拟按键开关（连发/快存/快读/倍速/截图/倒带）", content: box))
    }

    private func extraKeys() -> Set<String> {
        var out = Set<String>()
        if defaults.object(forKey: "extra_keys") == nil {
            // First launch: put the one-tap rewind key on screen by default.
            return ["rewind"]
        }
        let csv = defaults.string(forKey: "extra_keys") ?? ""
        if !csv.isEmpty {
            for key in csv.split(separator: ",") {
                let name = String(key)
                if Self.extraKeyChoices.contains(where: { $0.0 == name }) {
                    out.insert(name)
                }
            }
        }
        return out
    }

    private func showSaveSettingsDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let saveType = UIButton(type: .system)
        saveType.contentHorizontalAlignment = .left
        saveType.setTitle("存档类型：\(Self.saveTypeName(saveTypePref()))", for: .normal)
        saveType.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            // Order mirrors the Android picker: the common flash sizes first.
            let values: [Int] = [3, -1, 4, 5, 2, 1, 6, 0]
            let labels = values.map { Self.saveTypeName($0) }
            self.pickOption(title: "游戏保存类型", current: self.saveTypeChoiceIndex(), options: labels) { [weak self] index in
                guard let self else { return }
                self.defaults.set(values[index], forKey: "save_type")
                self.applyCoreOptions()
                saveType.setTitle("存档类型：\(Self.saveTypeName(self.saveTypePref()))", for: .normal)
            }
        }, for: .touchUpInside)
        let autoLoad = labeledSwitch("进入游戏时自动读档（上次退出的进度）", defaults.bool(forKey: "auto_load_state"))
        autoLoad.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(autoLoad.1.isOn, forKey: "auto_load_state")
        }, for: .valueChanged)
        let autoSave = labeledSwitch("退出时自动存档", defaults.bool(forKey: "auto_save_state"))
        autoSave.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(autoSave.1.isOn, forKey: "auto_save_state")
        }, for: .valueChanged)
        let confirmClose = labeledSwitch("关闭/重置时确认", defaults.bool(forKey: "confirm_close"))
        confirmClose.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(confirmClose.1.isOn, forKey: "confirm_close")
        }, for: .valueChanged)
        let patches = labeledSwitch("自动使用 IPS/UPS/BPS 补丁（与 ROM 同名放同一文件夹）", defaults.object(forKey: "patches") == nil ? true : defaults.bool(forKey: "patches"))
        patches.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(patches.1.isOn, forKey: "patches")
            self.applyCoreOptions()
        }, for: .valueChanged)
        let quickRotate = labeledSwitch("快速存档自动轮换槽位 1-9", defaults.bool(forKey: "quick_rotate"))
        quickRotate.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(quickRotate.1.isOn, forKey: "quick_rotate")
        }, for: .valueChanged)
        let confirmQuick = labeledSwitch("快速存/读档前确认", defaults.bool(forKey: "confirm_quick"))
        confirmQuick.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(confirmQuick.1.isOn, forKey: "confirm_quick")
        }, for: .valueChanged)
        let besideRom = labeledSwitch("新游戏的存档也放 ROM 同目录", defaults.bool(forKey: "saves_beside_rom"))
        besideRom.1.addAction(UIAction { [weak self] _ in
            self?.defaults.set(besideRom.1.isOn, forKey: "saves_beside_rom")
        }, for: .valueChanged)
        let timedSave = UIButton(type: .system)
        timedSave.contentHorizontalAlignment = .left
        func timedTitle(_ minutes: Int) -> String {
            minutes <= 0 ? "定时自动存档：关闭" : "定时自动存档：每 \(minutes) 分钟"
        }
        var timedMinutes = defaults.object(forKey: "timed_save_min") == nil ? 0 : defaults.integer(forKey: "timed_save_min")
        timedSave.setTitle(timedTitle(timedMinutes), for: .normal)
        timedSave.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let values = [0, 5, 10, 30]
            let index = values.firstIndex(of: timedMinutes) ?? 0
            self.pickOption(title: "定时自动存档",
                            current: index,
                            options: ["关闭", "每 5 分钟", "每 10 分钟", "每 30 分钟"]) { [weak self] pick in
                guard let self else { return }
                timedMinutes = values[pick]
                self.defaults.set(timedMinutes, forKey: "timed_save_min")
                timedSave.setTitle(timedTitle(timedMinutes), for: .normal)
                if timedMinutes > 0, let core = self.core, mgbaMobileIsLoaded(core) {
                    self.startTimedSave()
                } else {
                    self.stopTimedSave()
                }
            }
        }, for: .touchUpInside)
        let deleteSav = UIButton(type: .system)
        deleteSav.contentHorizontalAlignment = .left
        deleteSav.setTitle("删除电池存档（.sav）", for: .normal)
        deleteSav.addAction(UIAction { [weak self] _ in self?.confirmDeleteBattery() }, for: .touchUpInside)
        let importSav = UIButton(type: .system)
        importSav.contentHorizontalAlignment = .left
        importSav.setTitle("导入 My Boy 存档（选择其 save 文件夹）", for: .normal)
        importSav.addAction(UIAction { [weak self] _ in self?.pickMyBoySaves() }, for: .touchUpInside)
        box.addArrangedSubview(saveType)
        box.addArrangedSubview(autoLoad.0)
        box.addArrangedSubview(autoSave.0)
        box.addArrangedSubview(confirmClose.0)
        box.addArrangedSubview(patches.0)
        box.addArrangedSubview(quickRotate.0)
        box.addArrangedSubview(confirmQuick.0)
        box.addArrangedSubview(besideRom.0)
        box.addArrangedSubview(timedSave)
        box.addArrangedSubview(deleteSav)
        box.addArrangedSubview(importSav)
        presentSheet(SheetController(title: "存档", content: box))
    }

    private func chooseOrientation(_ mode: String) {
        orientationMode = mode
        defaults.set(mode, forKey: "orientation")
        DispatchQueue.main.async { [weak self] in
            self?.applyOrientation()
        }
    }

    private func applyOrientation() {
        let mask: UIInterfaceOrientationMask
        // 自动旋转/系统默认不锁定方向，此时 target 为 nil。
        let target: UIInterfaceOrientation?
        switch orientationMode {
        case "auto": mask = .all; target = nil
        case "system": mask = .allButUpsideDown; target = nil
        case "portrait": mask = .portrait; target = .portrait
        case "portrait_rev": mask = .portraitUpsideDown; target = .portraitUpsideDown
        case "landscape_rev": mask = .landscapeLeft; target = .landscapeLeft
        default: mask = .landscapeRight; target = .landscapeRight
        }
        if #available(iOS 16.0, *) {
            setNeedsUpdateOfSupportedInterfaceOrientations()
            view.window?.windowScene?.requestGeometryUpdate(.iOS(interfaceOrientations: mask)) { _ in }
        }
        if let target {
            UIDevice.current.setValue(target.rawValue, forKey: "orientation")
        }
        UIViewController.attemptRotationToDeviceOrientation()
    }

    // == 高级：GB 调色板 / SGB 边框 / 倾斜传感器卡带 / 按键不透明度 ==

    private func palettePref() -> Int {
        let id = defaults.integer(forKey: "gb_palette")
        return id >= 0 && id < Self.gbPalettes.count ? id : 0
    }

    /** Pushes the emulation-related preferences into the core. */
    private func applyCoreOptions() {
        guard let core else { return }
        mgbaMobileSetSaveType(core, Int32(saveTypePref()))
        mgbaMobileSetPatches(core, defaults.object(forKey: "patches") == nil ? true : defaults.bool(forKey: "patches"))
        mgbaMobileSetBiosOptions(core,
                                 defaults.object(forKey: "use_bios") == nil ? true : defaults.bool(forKey: "use_bios"),
                                 defaults.object(forKey: "skip_bios") == nil ? true : defaults.bool(forKey: "skip_bios"))
        let mode = rtcModePref()
        let epoch = defaults.object(forKey: "rtc_epoch") == nil
            ? Int64(Date().timeIntervalSince1970)
            : Int64(defaults.integer(forKey: "rtc_epoch"))
        let offset = Int64(defaults.integer(forKey: "rtc_offset_min")) * 60
        mgbaMobileSetRtc(core, Int32(mode), epoch, offset)
        if defaults.bool(forKey: "solar_on") {
            if solarSourceIsScreen {
                mgbaMobileSetSolar(core, Int32(currentScreenSolarLevel()))
            } else {
                mgbaMobileSetSolar(core, Int32(defaults.integer(forKey: "solar_level") == 0 ? 5 : defaults.integer(forKey: "solar_level")))
            }
        } else {
            mgbaMobileSetSolar(core, -1)
        }
        updateSolarTimer()
        mgbaMobileSetCartRumble(core, defaults.bool(forKey: "cart_rumble"))
        pushGbPalette(palettePref())
        mgbaMobileSetSgbBorders(core, defaults.bool(forKey: "sgb_borders"))
        applyChannelVolumes()
        updateTiltSensor()
        // Neutral until a reading arrives; keeps held cartridges from drifting.
        mgbaMobileSetRotation(core, 0, 0, 0)
    }

    /// Twelve gb.pal entries for the chosen palette. Index 0 is the core's own
    /// stock colors, sent explicitly so a previous palette is cleared.
    private func pushGbPalette(_ index: Int) {
        guard let core else { return }
        let safe = index >= 0 && index < Self.gbPalettes.count ? index : 0
        let base = Self.gbPalettes[safe]
        var colors = [Int32](repeating: 0, count: 12)
        for slot in 0..<12 {
            colors[slot] = base[slot % 4]
        }
        colors.withUnsafeBufferPointer { buffer in
            if let address = buffer.baseAddress {
                mgbaMobileSetGbPalette(core, address)
            }
        }
    }

    /// Per-channel gains: PSG 1-4 then the GBA DMA A/B FIFOs. The slider is a
    /// percentage, the core wants 0-384 in 1/256ths of full volume.
    private func applyChannelVolumes() {
        guard let core else { return }
        let keys = ["vol_ch1", "vol_ch2", "vol_ch3", "vol_ch4", "vol_cha", "vol_chb"]
        var gains = [Int32](repeating: 256, count: keys.count)
        for (index, key) in keys.enumerated() {
            let percent = defaults.object(forKey: key) == nil ? 100 : defaults.integer(forKey: key)
            gains[index] = Int32(max(0, min(384, percent * 256 / 100)))
        }
        gains.withUnsafeBufferPointer { buffer in
            if let address = buffer.baseAddress {
                mgbaMobileSetChannelVolumes(core, address)
            }
        }
    }

    /** Pushes the input-related preferences into the on-screen controls. */
    private func applyInputSettings() {
        if !defaults.bool(forKey: "rewind_key_seen") {
            // One-time upgrade: show the new one-tap rewind key even for
            // players who had already saved an extras list before it existed.
            var extras = extraKeys()
            if extras.insert("rewind").inserted {
                defaults.set(extras.joined(separator: ","), forKey: "extra_keys")
            }
            defaults.set(true, forKey: "rewind_key_seen")
        }
        controls.setDiagonalLock(defaults.bool(forKey: "no_diagonal"))
        controls.setTurboRate(defaults.integer(forKey: "turbo_rate") == 0 ? 25 : defaults.integer(forKey: "turbo_rate"))
        controls.setVisibleExtras(extraKeys())
        controls.setQuickRewindSeconds(rewindTapSeconds())
        controls.setOpacity(defaults.object(forKey: "controls_opacity") == nil ? 100 : defaults.integer(forKey: "controls_opacity"))
        loadMacroSettings()
    }

    // == Key layout profiles ==

    private static let profilePrefix = "layout_p_"
    private static let defaultProfile = "默认"

    private func profileNames() -> [String] {
        var names: [String] = []
        if let csv = defaults.string(forKey: "layout_profiles") {
            for name in csv.split(separator: "\n") {
                let trim = name.trimmingCharacters(in: .whitespaces)
                if !trim.isEmpty && !names.contains(trim) {
                    names.append(trim)
                }
            }
        }
        if names.isEmpty {
            // First run of the profile system: carry the single stored layout
            // over as the default profile so nothing is lost.
            names.append(Self.defaultProfile)
            let legacy = defaults.string(forKey: "key_layout") ?? ""
            defaults.set(legacy, forKey: Self.profilePrefix + Self.defaultProfile)
            defaults.set(names.joined(separator: "\n"), forKey: "layout_profiles")
        }
        return names
    }

    private func activeProfile() -> String {
        if let active = defaults.string(forKey: "layout_active"), !active.isEmpty, profileNames().contains(active) {
            return active
        }
        return Self.defaultProfile
    }

    /** Landscape layouts live under a #L key, like the Android profiles; the
     * portrait key stays shared so older layouts keep working. */
    private var layoutSuffix: String { portrait ? "" : "#L" }

    private func profileLayout(_ name: String) -> String {
        let base = Self.profilePrefix + name
        if let data = defaults.string(forKey: base + layoutSuffix) {
            return data
        }
        if let data = defaults.string(forKey: base) {
            return data
        }
        if name == Self.defaultProfile {
            let legacy = defaults.string(forKey: "key_layout") ?? ""
            defaults.set(legacy, forKey: base + layoutSuffix)
            return legacy
        }
        return ""
    }

    /** Persists the current layout into its profile for this orientation. */
    private func saveKeyLayout() {
        defaults.set(keyLayout.encode(), forKey: Self.profilePrefix + layoutProfile + layoutSuffix)
    }

    private func switchProfile(_ name: String) {
        layoutProfile = name
        defaults.set(name, forKey: "layout_active")
        keyLayout = KeyLayout.decode(profileLayout(name))
        selectedKey = nil
        controls.setCenters(keyLayout.resolved())
        controls.setScales(keyLayout.resolvedScales())
        refreshScaleUI()
    }

    private func createProfile(_ name: String, copyCurrent: Bool) {
        var names = profileNames()
        if names.contains(name) {
            toast("配置名称已存在")
            return
        }
        names.append(name)
        defaults.set(names.joined(separator: "\n"), forKey: "layout_profiles")
        defaults.set(copyCurrent ? keyLayout.encode() : "", forKey: Self.profilePrefix + name)
        switchProfile(name)
        toast("已切换到 \(name)")
    }

    private func deleteProfile(_ name: String) {
        var names = profileNames()
        if names.count <= 1 {
            toast("至少保留一个配置")
            return
        }
        names.removeAll { $0 == name }
        defaults.set(names.joined(separator: "\n"), forKey: "layout_profiles")
        defaults.removeObject(forKey: Self.profilePrefix + name)
        if name == layoutProfile {
            switchProfile(names[0])
        }
    }

    /** Profile picker from the layout editor: tap to switch, new/copy below. */
    @objc private func showLayoutProfiles() {
        let names = profileNames()
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 4
        for name in names {
            let row = UIButton(type: .system)
            row.contentHorizontalAlignment = .left
            let active = name == layoutProfile
            row.setTitle((active ? "▸ " : "○ ") + name, for: .normal)
            row.setTitleColor(active ? UIColor(red: 27 / 255, green: 94 / 255, blue: 32 / 255, alpha: 1) : .darkText, for: .normal)
            row.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                self.dismiss(animated: true)
                self.switchProfile(name)
                self.toast("已切换到 \(name)")
            }, for: .touchUpInside)
            box.addArrangedSubview(row)
        }
        let actions = UIStackView()
        actions.axis = .horizontal
        actions.distribution = .fillEqually
        let newProfile = UIButton(type: .system)
        newProfile.setTitle("新配置", for: .normal)
        newProfile.addAction(UIAction { [weak self] _ in
            self?.dismiss(animated: true)
            self?.promptProfileName(nil, copy: false)
        }, for: .touchUpInside)
        let copyProfile = UIButton(type: .system)
        copyProfile.setTitle("复制当前", for: .normal)
        copyProfile.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.dismiss(animated: true)
            self.promptProfileName(self.layoutProfile + "-2", copy: true)
        }, for: .touchUpInside)
        actions.addArrangedSubview(newProfile)
        actions.addArrangedSubview(copyProfile)
        box.addArrangedSubview(actions)
        // Per-row delete, only when there is something to fall back to.
        if names.count > 1 {
            let deleteRow = UIStackView()
            deleteRow.axis = .horizontal
            deleteRow.alignment = .center
            deleteRow.spacing = 8
            let deleteLabel = UILabel()
            deleteLabel.text = "删除配置："
            deleteLabel.font = .systemFont(ofSize: 12)
            deleteRow.addArrangedSubview(deleteLabel)
            for name in names {
                let del = UIButton(type: .system)
                del.setTitle(name, for: .normal)
                del.titleLabel?.font = .systemFont(ofSize: 12)
                del.setTitleColor(.systemRed, for: .normal)
                del.addAction(UIAction { [weak self] _ in
                    guard let self else { return }
                    let confirm = UIAlertController(title: "删除配置", message: "删除配置「\(name)」？", preferredStyle: .alert)
                    confirm.addAction(UIAlertAction(title: "确定", style: .destructive) { _ in
                        self.deleteProfile(name)
                        self.toast("已删除 \(name)")
                    })
                    confirm.addAction(UIAlertAction(title: "取消", style: .cancel))
                    self.presentSheet(confirm)
                }, for: .touchUpInside)
                deleteRow.addArrangedSubview(del)
            }
            box.addArrangedSubview(deleteRow)
        }
        let hint = UILabel()
        hint.text = "点名称切换配置；下方按钮新建空配置或复制当前配置"
        hint.font = .systemFont(ofSize: 12)
        hint.textColor = .secondaryLabel
        box.addArrangedSubview(hint)
        presentSheet(SheetController(title: "按键映射配置", content: box))
    }

    private func promptProfileName(_ prefill: String?, copy: Bool) {
        let alert = UIAlertController(title: copy ? "复制当前" : "新配置", message: nil, preferredStyle: .alert)
        alert.addTextField { field in
            field.placeholder = "配置名称"
            field.text = prefill
        }
        alert.addAction(UIAlertAction(title: "确定", style: .default) { [weak self] _ in
            guard let self else { return }
            let name = alert.textFields?.first?.text?.trimmingCharacters(in: .whitespaces) ?? ""
            if name.isEmpty { return }
            if self.profileNames().contains(name) {
                self.toast("配置名称已存在")
                return
            }
            self.createProfile(name, copyCurrent: copy)
        })
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(alert)
    }

    /** Starts or stops the device posture listener for tilt cartridges. */
    private func updateTiltSensor() {
        let wanted = defaults.bool(forKey: "tilt_sensor")
        if wanted && !tiltListening {
            if motionManager == nil {
                motionManager = CMMotionManager()
            }
            guard let motion = motionManager, motion.isDeviceMotionAvailable else { return }
            motion.deviceMotionUpdateInterval = 1.0 / 30.0
            tiltListening = true
            motion.startDeviceMotionUpdates(to: .main) { [weak self] update, _ in
                guard let self, self.tiltListening, let update, let core = self.core else { return }
                // Gravity along the device's x/y axes, normalized to roughly
                // one gravity at full deflection; re-axed for landscape so
                // tilting the phone tilts the cartridge the way the screen moves.
                var x = CGFloat(update.gravity.x)
                var y = CGFloat(update.gravity.y)
                if !self.portrait {
                    let swap = x
                    x = y
                    y = -swap
                }
                mgbaMobileSetRotation(core, Float(Self.clampTilt(x)), Float(Self.clampTilt(y)), 0)
            }
        } else if !wanted && tiltListening {
            motionManager?.stopDeviceMotionUpdates()
            tiltListening = false
        }
    }

    private static func clampTilt(_ value: CGFloat) -> CGFloat {
        max(-1, min(1, value * 1.4))
    }

    @objc private func showAdvanced() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let useBios = labeledSwitch("使用 BIOS（需先在菜单导入）", defaults.object(forKey: "use_bios") == nil ? true : defaults.bool(forKey: "use_bios"))
        useBios.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(useBios.1.isOn, forKey: "use_bios")
            self.applyCoreOptions()
        }, for: .valueChanged)
        let skipBios = labeledSwitch("跳过 BIOS 启动画面", defaults.object(forKey: "skip_bios") == nil ? true : defaults.bool(forKey: "skip_bios"))
        skipBios.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(skipBios.1.isOn, forKey: "skip_bios")
            self.applyCoreOptions()
        }, for: .valueChanged)
        let clock = UIButton(type: .system)
        clock.contentHorizontalAlignment = .left
        clock.setTitle("游戏时钟：\(Self.clockName(rtcModePref()))", for: .normal)
        clock.addAction(UIAction { [weak self] _ in self?.pickRtcMode(clock) }, for: .touchUpInside)
        let rumble = labeledSwitch("卡带振动（轰隆声，需游戏支持）", defaults.bool(forKey: "cart_rumble"))
        rumble.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(rumble.1.isOn, forKey: "cart_rumble")
            self.applyCoreOptions()
        }, for: .valueChanged)
        let solar = labeledSwitch("太阳能仿真（我们的太阳 Boktai）", defaults.bool(forKey: "solar_on"))
        solar.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(solar.1.isOn, forKey: "solar_on")
            self.applyCoreOptions()
        }, for: .valueChanged)
        let solarNow = defaults.integer(forKey: "solar_level") == 0 ? 5 : defaults.integer(forKey: "solar_level")
        let solarLabel = UILabel()
        solarLabel.text = solarSourceIsScreen ? "阳光强度：跟随屏幕亮度" : "阳光强度 \(solarNow)"
        let solarBar = UISlider()
        solarBar.minimumValue = 0
        solarBar.maximumValue = 10
        solarBar.value = Float(solarNow)
        solarBar.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            solarLabel.text = "阳光强度 \(Int(solarBar.value))"
            self.defaults.set(Int(solarBar.value), forKey: "solar_level")
            self.applyCoreOptions()
        }, for: .valueChanged)
        solarBar.isEnabled = !solarSourceIsScreen
        let solarSource = UIButton(type: .system)
        solarSource.contentHorizontalAlignment = .left
        solarSource.setTitle("阳光来源：\(solarSourceIsScreen ? "屏幕亮度" : "手动")", for: .normal)
        solarSource.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "阳光来源", current: self.solarSourceIsScreen ? 1 : 0,
                            options: ["手动", "屏幕亮度"]) { [weak self] index in
                guard let self else { return }
                self.defaults.set(index == 1 ? "screen" : "manual", forKey: "solar_source")
                solarSource.setTitle("阳光来源：\(index == 1 ? "屏幕亮度" : "手动")", for: .normal)
                solarBar.isEnabled = index == 0
                self.applyCoreOptions()
            }
        }, for: .touchUpInside)
        let notice = labeledSwitch("游戏运行通知（切到后台继续运行）", defaults.bool(forKey: "keep_notice"))
        notice.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.setBackgroundRunning(notice.1.isOn)
        }, for: .valueChanged)
        let syncAuto = labeledSwitch("进出游戏时自动同步存档（WebDAV）", defaults.bool(forKey: "sync_auto"))
        syncAuto.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(syncAuto.1.isOn, forKey: "sync_auto")
        }, for: .valueChanged)
        let gifBallSwitch = labeledSwitch("GIF 悬浮球（悬浮按钮开始/停止录像）", defaults.bool(forKey: "gif_ball"))
        gifBallSwitch.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(gifBallSwitch.1.isOn, forKey: "gif_ball")
            if gifBallSwitch.1.isOn {
                self.setupGifBall()
            } else {
                self.gifBall?.removeFromSuperview()
                self.gifBall = nil
            }
        }, for: .valueChanged)
        let sgb = labeledSwitch("SGB 边框（Super Game Boy 专用边框画面）", defaults.bool(forKey: "sgb_borders"))
        sgb.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(sgb.1.isOn, forKey: "sgb_borders")
            self.applyCoreOptions()
        }, for: .valueChanged)
        let tilt = labeledSwitch("倾斜传感器卡带（扭转世界/科比摇摆，用手机姿态模拟）", defaults.bool(forKey: "tilt_sensor"))
        tilt.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(tilt.1.isOn, forKey: "tilt_sensor")
            self.updateTiltSensor()
            if !tilt.1.isOn, let core = self.core {
                // Neutral tilt so a held cartridge stops reacting.
                mgbaMobileSetRotation(core, 0, 0, 0)
            }
        }, for: .valueChanged)
        let palette = UIButton(type: .system)
        palette.contentHorizontalAlignment = .left
        palette.setTitle("GB 调色板：\(Self.gbPaletteNames[palettePref()])", for: .normal)
        palette.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "GB 调色板（单色 GB 游戏的配色）", current: self.palettePref(), options: Self.gbPaletteNames) { [weak self] index in
                guard let self else { return }
                self.defaults.set(index, forKey: "gb_palette")
                palette.setTitle("GB 调色板：\(Self.gbPaletteNames[self.palettePref()])", for: .normal)
                self.applyCoreOptions()
            }
        }, for: .touchUpInside)
        let fastNow = Int(fastHoldSpeed())
        let fastLabel = UILabel()
        fastLabel.text = "快进速度 \(fastNow)倍"
        let fastBar = UISlider()
        fastBar.minimumValue = 0
        fastBar.maximumValue = 14
        fastBar.value = Float(max(0, min(14, fastNow - 2)))
        fastBar.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let value = Int(fastBar.value) + 2
            fastLabel.text = "快进速度 \(value)倍"
            self.defaults.set(value, forKey: "fast_hold")
            self.refreshSpeedButtons()
        }, for: .valueChanged)
        box.addArrangedSubview(useBios.0)
        box.addArrangedSubview(skipBios.0)
        box.addArrangedSubview(clock)
        box.addArrangedSubview(rumble.0)
        box.addArrangedSubview(solar.0)
        box.addArrangedSubview(solarSource)
        box.addArrangedSubview(solarLabel)
        box.addArrangedSubview(solarBar)
        box.addArrangedSubview(sgb.0)
        box.addArrangedSubview(gifBallSwitch.0)
        box.addArrangedSubview(notice.0)
        box.addArrangedSubview(syncAuto.0)
        box.addArrangedSubview(tilt.0)
        box.addArrangedSubview(palette)
        box.addArrangedSubview(fastLabel)
        box.addArrangedSubview(fastBar)
        presentSheet(SheetController(title: "高级", content: box))
    }

    /** Game clock: wall clock, a fixed moment, or wall clock shifted by minutes. */
    private func pickRtcMode(_ label: UIButton) {
        let alert = UIAlertController(title: "游戏时钟（RTC 卡带）", message: nil, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "实时时钟（跟随手机时间）", style: .default) { [weak self] _ in
            guard let self else { return }
            self.defaults.set(0, forKey: "rtc_mode")
            self.applyCoreOptions()
            label.setTitle("游戏时钟：\(Self.clockName(0))", for: .normal)
        })
        alert.addAction(UIAlertAction(title: "固定时间（口袋妖怪时间事件用）", style: .default) { [weak self] _ in
            guard let self else { return }
            self.defaults.set(1, forKey: "rtc_mode")
            self.pickRtcDate(label)
        })
        alert.addAction(UIAlertAction(title: "偏移时间（手机时间加偏移分钟）", style: .default) { [weak self] _ in
            guard let self else { return }
            self.defaults.set(2, forKey: "rtc_mode")
            self.pickRtcOffset(label)
        })
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(alert)
    }

    private func pickRtcDate(_ label: UIButton) {
        let sheet = SheetController(title: "选择固定时间", content: makeRtcDatePicker(label))
        presentSheet(sheet)
    }

    private func makeRtcDatePicker(_ label: UIButton) -> UIView {
        let picker = UIDatePicker()
        if #available(iOS 13.4, *) {
            picker.preferredDatePickerStyle = .wheels
        }
        picker.datePickerMode = .dateAndTime
        let epoch = defaults.object(forKey: "rtc_epoch") == nil
            ? Date().timeIntervalSince1970
            : defaults.double(forKey: "rtc_epoch")
        picker.date = Date(timeIntervalSince1970: epoch)
        let done = UIButton(type: .system)
        done.setTitle("确定", for: .normal)
        done.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(picker.date.timeIntervalSince1970, forKey: "rtc_epoch")
            self.applyCoreOptions()
            label.setTitle("游戏时钟：\(Self.clockName(1))", for: .normal)
            self.topmostPresenter.dismiss(animated: true)
        }, for: .touchUpInside)
        let box = UIStackView(arrangedSubviews: [picker, done])
        box.axis = .vertical
        box.spacing = 8
        return box
    }

    private func pickRtcOffset(_ label: UIButton) {
        let alert = UIAlertController(title: "偏移时间（手机时间加偏移分钟）", message: nil, preferredStyle: .alert)
        alert.addTextField { field in
            field.text = String(self.defaults.integer(forKey: "rtc_offset_min"))
            field.keyboardType = .numbersAndPunctuation
        }
        alert.addAction(UIAlertAction(title: "确定", style: .default) { [weak self] _ in
            guard let self else { return }
            let minutes = Int(alert.textFields?.first?.text?.trimmingCharacters(in: .whitespaces) ?? "") ?? 0
            self.defaults.set(minutes, forKey: "rtc_offset_min")
            self.applyCoreOptions()
            label.setTitle("游戏时钟：\(Self.clockName(2))", for: .normal)
        })
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(alert)
    }

    private func showHelpDialog() {
        let text = UILabel()
        text.numberOfLines = 0
        text.font = .systemFont(ofSize: 14)
        text.text = "游戏：打开 .gba/.gbc/.gb 后自动继续上次的进度（电池存档自动保存）。\n\n倍速：菜单里点「倍速」选 0.25~16 倍，或长按「自定义」输入小数；TAB/空格/手柄右摇杆按下为快进。\n\n画质：可开画面滤镜（GBA 色彩、灰度、HQ2x、HQ4x、2xBR、4xBR、残影、点阵、LCD3x、扫描线、锐利插值），配整数缩放效果最佳；GB 游戏可在高级设置里换调色板。\n\n金手指：菜单「金手指」里新增，格式选自动识别即可，每行一个代码，勾选生效。\n\n补丁：把 IPS/UPS/BPS 补丁改成和 ROM 同名（扩展名保留）放在同一文件夹，进游戏时自动应用。\n\n联机：两边运行同一 ROM，一边创建一边加入。\n\n截屏：菜单「截图」存进相册，「录像」录制 GIF。"
        presentSheet(SheetController(title: "帮助", content: text))
    }

    // == Settings plumbing ==

    private func turboModePref() -> Int {
        defaults.integer(forKey: "turbo_mode")
    }

    private static func turboModeName(_ mode: Int) -> String {
        switch mode {
        case 1: return "连发键"
        case 2: return "关闭"
        default: return "长按B键"
        }
    }

    private static func vibeName(_ strength: Int) -> String {
        switch strength {
        case 1: return "轻"
        case 2: return "中"
        case 3: return "强"
        default: return "关"
        }
    }

    private func saveTypePref() -> Int {
        defaults.object(forKey: "save_type") == nil ? 3 : defaults.integer(forKey: "save_type")
    }

    private func saveTypeChoiceIndex() -> Int {
        switch saveTypePref() {
        case -1: return 1
        case 4: return 2
        case 5: return 3
        case 2: return 4
        case 1: return 5
        case 6: return 6
        case 0: return 7
        default: return 0
        }
    }

    private static func saveTypeName(_ type: Int) -> String {
        switch type {
        case -1: return "自动检测"
        case 0: return "不保存"
        case 1: return "SRAM 32KB"
        case 2: return "FLASH 64KB"
        case 4: return "EEPROM 8KB"
        case 5: return "EEPROM 512B"
        case 6: return "SRAM 64KB"
        default: return "FLASH 128KB"
        }
    }

    private func rtcModePref() -> Int {
        defaults.integer(forKey: "rtc_mode")
    }

    private static func clockName(_ mode: Int) -> String {
        switch mode {
        case 1: return "固定时间"
        case 2: return "偏移时间"
        default: return "实时时钟"
        }
    }

    // == Cheats ==

    /** Cheats list: toggle with the switch, 删除 button to remove, 新增 to add. */
    @objc private func showCheats() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let count = Int(mgbaMobileCheatCount(core))
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 4
        if count == 0 {
            let empty = UILabel()
            empty.numberOfLines = 0
            empty.text = "还没有作弊码。\n点「新增」添加，格式选「自动识别」，每行一个代码。"
            box.addArrangedSubview(empty)
        }
        var names: [String] = []
        for i in 0..<count {
            var name = [CChar](repeating: 0, count: 128)
            mgbaMobileCheatName(core, Int32(i), &name, 128)
            names.append(String(cString: name))
        }
        let sheet = SheetController(title: "金手指", content: box)
        for i in 0..<count {
            let index = i
            let row = UIStackView()
            row.axis = .horizontal
            row.alignment = .center
            row.spacing = 8
            let toggle = UISwitch()
            toggle.isOn = mgbaMobileCheatEnabled(core, Int32(index))
            toggle.addAction(UIAction { _ in
                mgbaMobileCheatSetEnabled(core, Int32(index), toggle.isOn)
            }, for: .valueChanged)
            let label = UILabel()
            label.text = names[index]
            label.numberOfLines = 0
            let delete = UIButton(type: .system)
            delete.setTitle("删除", for: .normal)
            delete.addAction(UIAction { [weak self, weak sheet] _ in
                let confirm = UIAlertController(title: "删除作弊码", message: "删除「\(names[index])」？", preferredStyle: .alert)
                confirm.addAction(UIAlertAction(title: "确定", style: .destructive) { _ in
                    _ = mgbaMobileCheatRemove(core, Int32(index))
                    sheet?.dismiss(animated: true)
                    self?.showCheats()
                })
                confirm.addAction(UIAlertAction(title: "取消", style: .cancel))
                self?.presentSheet(confirm)
            }, for: .touchUpInside)
            row.addArrangedSubview(toggle)
            row.addArrangedSubview(label)
            row.addArrangedSubview(delete)
            box.addArrangedSubview(row)
        }
        let add = UIButton(type: .system)
        add.setTitle("新增", for: .normal)
        add.addAction(UIAction { [weak self] _ in self?.showCheatEdit() }, for: .touchUpInside)
        box.addArrangedSubview(add)
        presentSheet(sheet)
    }

    private func showCheatEdit() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let name = UITextField()
        name.placeholder = "名称（比如：无限金钱）"
        name.borderStyle = .roundedRect
        name.heightAnchor.constraint(equalToConstant: 36).isActive = true
        let formatNames = ["自动识别", "代码断路器 CodeBreaker", "金手指 v1/v2 GameShark", "动作回放 Action Replay", "VBA 码"]
        let format = UIButton(type: .system)
        format.contentHorizontalAlignment = .left
        format.setTitle("格式：\(formatNames[0])", for: .normal)
        var type = 0
        format.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "作弊码格式", current: type, options: formatNames) { index in
                type = index
                format.setTitle("格式：\(formatNames[index])", for: .normal)
            }
        }, for: .touchUpInside)
        let lines = UITextView()
        lines.font = .systemFont(ofSize: 14)
        lines.layer.borderColor = UIColor.separator.cgColor
        lines.layer.borderWidth = 1
        lines.layer.cornerRadius = 6
        lines.heightAnchor.constraint(equalToConstant: 120).isActive = true
        let hint = UILabel()
        hint.numberOfLines = 0
        hint.font = .systemFont(ofSize: 12)
        hint.textColor = .secondaryLabel
        hint.text = "代码，每行一个\n例如 82025838 104E"
        let ok = UIButton(type: .system)
        ok.setTitle("确定", for: .normal)
        ok.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            var codeName = name.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let codeLines = lines.text?.trimmingCharacters(in: .whitespacesAndNewlines) ?? ""
            if codeName.isEmpty { codeName = "作弊码" }
            if codeLines.isEmpty {
                self.toast("作弊码无效，请检查格式")
                return
            }
            let added = codeLines.withCString { linesPtr in
                codeName.withCString { namePtr in
                    mgbaMobileCheatAdd(core, namePtr, linesPtr, Int32(type))
                }
            }
            if !added {
                self.toast("作弊码无效，请检查格式")
                return
            }
            self.toast("已添加：\(codeName)")
            self.dismiss(animated: true)
        }, for: .touchUpInside)
        box.addArrangedSubview(name)
        box.addArrangedSubview(format)
        box.addArrangedSubview(hint)
        box.addArrangedSubview(lines)
        box.addArrangedSubview(ok)
        presentSheet(SheetController(title: "新增", content: box))
    }

    // == Shell skin ==

    private func skinStylePref() -> Int {
        defaults.object(forKey: "skin_style") == nil
            ? ControlsView.styleHandheld
            : (defaults.integer(forKey: "skin_style") == ControlsView.styleClassic
                ? ControlsView.styleClassic : ControlsView.styleHandheld)
    }

    private func skinColorPref() -> Int {
        let value = defaults.integer(forKey: "skin_color")
        return value >= 0 && value < SkinTheme.all.count ? value : 0
    }

    /// Pushes the button style, body color and imported PNG pack into the
    /// controls and the stage around the game.
    private func applySkin() {
        let style = skinStylePref()
        let theme = SkinTheme.byIndex(skinColorPref())
        controls.setSkin(style: style, theme: theme)
        shellStage.theme = theme
        // Force the stage constraints to switch between the shell and the
        // classic full-screen picture.
        appliedStagePortrait = nil
        appliedShellHandheld = nil
        applyStageLayout()
        applyFullSkin()
        layoutMenuButton()
    }

    @objc private func showSkinDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8

        func choiceButton(_ title: String, checked: Bool, handler: @escaping () -> Void) -> UIButton {
            let button = UIButton(type: .system)
            button.contentHorizontalAlignment = .left
            button.setTitle(checked ? "✓ \(title)" : "    \(title)", for: .normal)
            button.addAction(UIAction { _ in handler() }, for: .touchUpInside)
            return button
        }

        let styleLabel = UILabel()
        styleLabel.font = .boldSystemFont(ofSize: 15)
        styleLabel.text = "按键样式"
        let styleStack = UIStackView()
        styleStack.axis = .vertical
        styleStack.spacing = 2
        var stylePick = skinStylePref()
        let classic = choiceButton("经典透明按键", checked: stylePick == ControlsView.styleClassic) {}
        let handheld = choiceButton("掌机外壳（推荐）", checked: stylePick == ControlsView.styleHandheld) {}
        func refreshStyle() {
            classic.setTitle(stylePick == ControlsView.styleClassic ? "✓ 经典透明按键" : "    经典透明按键", for: .normal)
            handheld.setTitle(stylePick == ControlsView.styleHandheld ? "✓ 掌机外壳（推荐）" : "    掌机外壳（推荐）", for: .normal)
        }
        classic.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            stylePick = ControlsView.styleClassic
            self.defaults.set(stylePick, forKey: "skin_style")
            self.applySkin()
            refreshStyle()
        }, for: .touchUpInside)
        handheld.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            stylePick = ControlsView.styleHandheld
            self.defaults.set(stylePick, forKey: "skin_style")
            self.applySkin()
            refreshStyle()
        }, for: .touchUpInside)
        styleStack.addArrangedSubview(classic)
        styleStack.addArrangedSubview(handheld)

        let colorLabel = UILabel()
        colorLabel.font = .boldSystemFont(ofSize: 15)
        colorLabel.text = "外壳颜色"
        let colorStack = UIStackView()
        colorStack.axis = .vertical
        colorStack.spacing = 2
        var colorPick = skinColorPref()
        var colorButtons: [UIButton] = []
        for (index, theme) in SkinTheme.all.enumerated() {
            let button = choiceButton(theme.name, checked: index == colorPick) {}
            button.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                colorPick = index
                self.defaults.set(index, forKey: "skin_color")
                self.applySkin()
                for (slot, item) in colorButtons.enumerated() {
                    item.setTitle(slot == index ? "✓ \(SkinTheme.all[slot].name)" : "    \(SkinTheme.all[slot].name)", for: .normal)
                }
            }, for: .touchUpInside)
            colorButtons.append(button)
            colorStack.addArrangedSubview(button)
        }

        let packLabel = UILabel()
        packLabel.font = .boldSystemFont(ofSize: 15)
        packLabel.text = "整包皮肤（PNG）"
        let packStack = UIStackView()
        packStack.axis = .vertical
        packStack.spacing = 2
        var refreshPacks: (() -> Void)!
        refreshPacks = { [weak self] in
            guard let self else { return }
            for view in packStack.arrangedSubviews {
                packStack.removeArrangedSubview(view)
                view.removeFromSuperview()
            }
            let packs = self.skinStore.list()
            var current = self.defaults.string(forKey: "full_skin")
            if let name = current, !packs.contains(name) {
                self.defaults.removeObject(forKey: "full_skin")
                current = nil
                self.applyFullSkin()
            }
            let none = choiceButton("不使用整包皮肤", checked: current == nil) {}
            none.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                self.defaults.removeObject(forKey: "full_skin")
                self.applyFullSkin()
                refreshPacks()
            }, for: .touchUpInside)
            packStack.addArrangedSubview(none)
            for name in packs {
                let row = choiceButton(name, checked: name == current) {}
                row.addAction(UIAction { [weak self] _ in
                    guard let self else { return }
                    self.defaults.set(name, forKey: "full_skin")
                    self.applyFullSkin()
                    refreshPacks()
                }, for: .touchUpInside)
                packStack.addArrangedSubview(row)
            }
        }
        refreshPacks()

        let importPack = UIButton(type: .system)
        importPack.contentHorizontalAlignment = .left
        importPack.setTitle("导入整包皮肤（ZIP）", for: .normal)
        importPack.addAction(UIAction { [weak self] _ in self?.pick(kind: 5) }, for: .touchUpInside)
        let scanPack = UIButton(type: .system)
        scanPack.contentHorizontalAlignment = .left
        scanPack.setTitle("从文件夹导入整包皮肤", for: .normal)
        scanPack.addAction(UIAction { [weak self] _ in self?.pick(kind: 6) }, for: .touchUpInside)
        let deletePack = UIButton(type: .system)
        deletePack.contentHorizontalAlignment = .left
        deletePack.setTitle("删除当前整包皮肤", for: .normal)
        deletePack.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            guard let name = self.defaults.string(forKey: "full_skin") else {
                self.toast("请先选择一个整包皮肤")
                return
            }
            self.skinStore.delete(name)
            self.defaults.removeObject(forKey: "full_skin")
            self.applyFullSkin()
            refreshPacks()
            self.toast("已删除皮肤包：\(name)")
        }, for: .touchUpInside)
        let packHelp = UILabel()
        packHelp.text = "ZIP 或文件夹里放 dpad/a/b/l/r/select/start 的 PNG，可加 _p 表示按下；背景用 bg_portrait.png / bg_landscape.png。"
        packHelp.textColor = .secondaryLabel
        packHelp.font = .systemFont(ofSize: 11)
        packHelp.numberOfLines = 0

        let stickerLabel = UILabel()
        stickerLabel.font = .boldSystemFont(ofSize: 15)
        stickerLabel.text = "贴纸"
        let stickerEdit = labeledSwitch("编辑贴纸（拖动移动，双指缩放）", stickerOverlay.editing)
        stickerEdit.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.stickerEditing = stickerEdit.1.isOn
            self.stickerOverlay.editing = stickerEdit.1.isOn
        }, for: .valueChanged)
        let addSticker = UIButton(type: .system)
        addSticker.contentHorizontalAlignment = .left
        addSticker.setTitle("添加贴纸图片", for: .normal)
        addSticker.addAction(UIAction { [weak self] _ in self?.pick(kind: 7) }, for: .touchUpInside)
        let folderSticker = UIButton(type: .system)
        folderSticker.contentHorizontalAlignment = .left
        folderSticker.setTitle("从文件夹选择贴纸", for: .normal)
        folderSticker.addAction(UIAction { [weak self] _ in self?.pick(kind: 8) }, for: .touchUpInside)
        let clearStickers = UIButton(type: .system)
        clearStickers.contentHorizontalAlignment = .left
        clearStickers.setTitle("清空贴纸", for: .normal)
        clearStickers.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.stickerOverlay.clear()
            self.toast("已清空贴纸")
        }, for: .touchUpInside)

        box.addArrangedSubview(styleLabel)
        box.addArrangedSubview(styleStack)
        box.addArrangedSubview(colorLabel)
        box.addArrangedSubview(colorStack)
        box.addArrangedSubview(packLabel)
        box.addArrangedSubview(packStack)
        box.addArrangedSubview(importPack)
        box.addArrangedSubview(scanPack)
        box.addArrangedSubview(deletePack)
        box.addArrangedSubview(packHelp)
        box.addArrangedSubview(stickerLabel)
        box.addArrangedSubview(stickerEdit.0)
        box.addArrangedSubview(addSticker)
        box.addArrangedSubview(folderSticker)
        box.addArrangedSubview(clearStickers)
        presentSheet(SheetController(title: "皮肤", content: box))
    }

    /// Pushes the active full PNG pack into the controls and the shell.
    private func applyFullSkin() {
        var name = defaults.string(forKey: "full_skin")
        if let current = name, !skinStore.list().contains(current) {
            defaults.removeObject(forKey: "full_skin")
            name = nil
        }
        activeSkinName = name
        let bitmaps = name.flatMap { skinStore.load($0) }
        controls.setFullSkin(bitmaps)
        shellStage.background = bitmaps?[portrait ? "bg_portrait" : "bg_landscape"]
    }

    /// Unpacks a picked zip and makes it the active pack, like the Android
    /// import action.
    private func importSkinZip(_ url: URL) {
        let store = skinStore
        let suggested = (url.lastPathComponent as NSString).deletingPathExtension
        toast("正在导入皮肤…")
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            let scoped = url.startAccessingSecurityScopedResource()
            let imported = store.importZip(url, suggestedName: suggested)
            if scoped { url.stopAccessingSecurityScopedResource() }
            DispatchQueue.main.async {
                guard let self else { return }
                guard let imported else {
                    self.toast("皮肤包无效：缺少按键 PNG")
                    return
                }
                self.defaults.set(imported, forKey: "full_skin")
                self.applyFullSkin()
                self.toast("已导入皮肤包：\(imported)")
            }
        }
    }

    /// A picked folder is one pack; if it instead holds several pack folders
    /// (a "skins" folder), every one with button PNGs is imported.
    private func importSkinFolder(_ url: URL) {
        let store = skinStore
        toast("正在导入皮肤…")
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            let scoped = url.startAccessingSecurityScopedResource()
            var imported: [String] = []
            if let one = store.importDirectory(url, name: url.lastPathComponent) {
                imported.append(one)
            } else {
                let keys: [URLResourceKey] = [.isDirectoryKey]
                let items = (try? FileManager.default.contentsOfDirectory(at: url,
                                                                          includingPropertiesForKeys: keys,
                                                                          options: [.skipsHiddenFiles])) ?? []
                let folders = items.filter {
                    (try? $0.resourceValues(forKeys: Set(keys)).isDirectory) == true
                }.sorted { $0.lastPathComponent.localizedStandardCompare($1.lastPathComponent) == .orderedAscending }
                for folder in folders {
                    if let one = store.importDirectory(folder, name: folder.lastPathComponent) {
                        imported.append(one)
                    }
                }
            }
            if scoped { url.stopAccessingSecurityScopedResource() }
            DispatchQueue.main.async {
                guard let self else { return }
                guard !imported.isEmpty else {
                    self.toast("文件夹里没有可用的按键 PNG")
                    return
                }
                if imported.count == 1, let name = imported.first {
                    self.defaults.set(name, forKey: "full_skin")
                }
                self.applyFullSkin()
                self.toast(imported.count == 1
                    ? "已导入皮肤包：\(imported[0])"
                    : "已导入 \(imported.count) 个皮肤包")
            }
        }
    }

    // == Stickers ==

    /// Stickers are stored per orientation, like the Android overlay.
    private var stickerPrefix: String { portrait ? "ver_" : "hor_" }

    private func loadStickers() {
        let prefix = stickerPrefix
        var list: [StickerOverlayView.Sticker] = []
        for index in 0..<StickerOverlayView.maxStickers {
            let base = prefix + "sticker\(index)_"
            guard let path = defaults.string(forKey: base + "path"),
                  FileManager.default.fileExists(atPath: path) else { continue }
            let x = defaults.object(forKey: base + "x") == nil ? 0.5 : defaults.double(forKey: base + "x")
            let y = defaults.object(forKey: base + "y") == nil ? 0.4 : defaults.double(forKey: base + "y")
            let w = defaults.object(forKey: base + "w") == nil ? 0.3 : defaults.double(forKey: base + "w")
            let alpha = defaults.object(forKey: base + "alpha") == nil ? 255 : defaults.integer(forKey: base + "alpha")
            list.append(StickerOverlayView.Sticker(path: path, x: CGFloat(x), y: CGFloat(y),
                                                   w: CGFloat(w), alpha: alpha))
        }
        stickerOverlay.setStickers(list)
    }

    private func persistStickers() {
        let prefix = stickerPrefix
        for index in 0..<StickerOverlayView.maxStickers {
            let base = prefix + "sticker\(index)_"
            defaults.removeObject(forKey: base + "path")
            defaults.removeObject(forKey: base + "x")
            defaults.removeObject(forKey: base + "y")
            defaults.removeObject(forKey: base + "w")
            defaults.removeObject(forKey: base + "alpha")
        }
        for (index, sticker) in stickerOverlay.stickers.enumerated() where index < StickerOverlayView.maxStickers {
            let base = prefix + "sticker\(index)_"
            defaults.set(sticker.path, forKey: base + "path")
            defaults.set(Double(sticker.x), forKey: base + "x")
            defaults.set(Double(sticker.y), forKey: base + "y")
            defaults.set(Double(sticker.w), forKey: base + "w")
            defaults.set(sticker.alpha, forKey: base + "alpha")
        }
    }

    private func installDoubleTapScreenshot() {
        guard doubleTapShot == nil else { return }
        let tap = UITapGestureRecognizer(target: self, action: #selector(handleDoubleTapShot(_:)))
        tap.numberOfTapsRequired = 2
        tap.cancelsTouchesInView = false
        // The keys sit above the game view, so the recognizer lives on the
        // stage and filters the point itself; a delayed touchesEnded would
        // hold every key press until the double tap gave up.
        tap.delaysTouchesEnded = false
        stage.addGestureRecognizer(tap)
        doubleTapShot = tap
    }

    @objc private func handleDoubleTapShot(_ gesture: UITapGestureRecognizer) {
        guard defaults.bool(forKey: "double_click_shot") else { return }
        let point = gesture.location(in: stage)
        guard gameView.pictureRect.contains(stage.convert(point, to: gameView)) else { return }
        // Double tapping a key is input, not a screenshot request.
        guard !controls.isOverKey(stage.convert(point, to: controls)) else { return }
        takeScreenshot()
    }

    private func importStickerImage(_ url: URL) {
        guard let path = copyStickerImage(url, index: 0) else {
            toast("贴纸图片无法读取")
            return
        }
        guard stickerOverlay.addSticker(path: path) else {
            toast("贴纸图片无法解码")
            return
        }
        stickerEditing = true
        stickerOverlay.editing = true
        toast("已添加贴纸，拖动调整位置")
    }

    private func importStickerFolder(_ url: URL) {
        let scoped = url.startAccessingSecurityScopedResource()
        let items = (try? FileManager.default.contentsOfDirectory(at: url,
                                                                  includingPropertiesForKeys: nil,
                                                                  options: [.skipsHiddenFiles])) ?? []
        let images = items.filter { item in
            ["png", "jpg", "jpeg", "webp", "gif"].contains(item.pathExtension.lowercased())
        }.sorted { $0.lastPathComponent.localizedStandardCompare($1.lastPathComponent) == .orderedAscending }
        var copied: [String] = []
        for (index, image) in images.prefix(30).enumerated() {
            if let path = copyStickerImage(image, index: index) {
                copied.append(path)
            }
        }
        if scoped { url.stopAccessingSecurityScopedResource() }
        guard !copied.isEmpty else {
            toast("文件夹里没有可用的贴纸图片")
            return
        }
        if copied.count == 1, let only = copied.first {
            addStickerPath(only)
            return
        }
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 2
        for path in copied {
            let name = URL(fileURLWithPath: path).lastPathComponent
            let button = UIButton(type: .system)
            button.contentHorizontalAlignment = .left
            button.setTitle(name, for: .normal)
            button.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                self.topmostPresenter.dismiss(animated: true) { self.addStickerPath(path) }
            }, for: .touchUpInside)
            box.addArrangedSubview(button)
        }
        presentSheet(SheetController(title: "选择贴纸", content: box))
    }

    private func addStickerPath(_ path: String) {
        guard stickerOverlay.addSticker(path: path) else {
            toast("贴纸图片无法解码")
            return
        }
        stickerEditing = true
        stickerOverlay.editing = true
        toast("已添加贴纸，拖动调整位置")
    }

    /// Copies a picked image into the app so it survives the source moving.
    private func copyStickerImage(_ source: URL, index: Int) -> String? {
        let dir = docs.appendingPathComponent("stickers", isDirectory: true)
        try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        let ext = source.pathExtension.isEmpty ? "png" : source.pathExtension.lowercased()
        let name = "sticker-\(Self.fileStamp())-\(index).\(ext)"
        let dest = dir.appendingPathComponent(name)
        let scoped = source.startAccessingSecurityScopedResource()
        defer { if scoped { source.stopAccessingSecurityScopedResource() } }
        do {
            let data = try Data(contentsOf: source)
            try data.write(to: dest, options: .atomic)
            return dest.path
        } catch {
            return nil
        }
    }

    // == Per-game settings ==

    /// Reads the overrides for the loaded ROM's CRC and overlays them on the
    /// global settings. Called after every load, like the Android activity.
    private func applyPerRomSettings() {
        perRomFilter = nil
        perRomSpeed = nil
        perRomSaveType = nil
        perRomPalette = nil
        guard let crc = romCrc else { return }
        let filter = romSettings.get(crc, "filter", fallback: RomSettings.defaultValue)
        if filter != RomSettings.defaultValue, let value = Int(filter),
           value >= 0, value < Self.filterNames.count {
            perRomFilter = value
        }
        let speed = romSettings.get(crc, "speed", fallback: RomSettings.defaultValue)
        if speed != RomSettings.defaultValue, let value = Double(speed) {
            perRomSpeed = value
        }
        let saveType = romSettings.get(crc, "save_type", fallback: RomSettings.defaultValue)
        if saveType != RomSettings.defaultValue, let value = Int(saveType) {
            perRomSaveType = value
        }
        let palette = romSettings.get(crc, "gb_palette", fallback: RomSettings.defaultValue)
        if palette != RomSettings.defaultValue, let value = Int(palette),
           value >= 0, value < Self.gbPalettes.count {
            perRomPalette = value
        }
        if let core {
            let type = perRomSaveType ?? saveTypePref()
            mgbaMobileSetSaveType(core, Int32(type))
            pushGbPalette(perRomPalette ?? palettePref())
        }
        let filterValue = perRomFilter ?? filterPref()
        let speedValue = perRomSpeed
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            self.gameView.filter = filterValue
            if let speedValue { self.setSpeed(speedValue) }
        }
        let summary = perRomSummary()
        if !summary.isEmpty {
            toast("已应用本游戏设置：\(summary)")
        }
    }

    private func perRomSummary() -> String {
        var parts: [String] = []
        if let filter = perRomFilter { parts.append(filterName(filter)) }
        if let speed = perRomSpeed { parts.append("\(Self.speedLabel(speed))倍") }
        if let saveType = perRomSaveType { parts.append(Self.saveTypeName(saveType)) }
        if let palette = perRomPalette { parts.append(paletteName(palette)) }
        return parts.joined(separator: " ")
    }

    private func filterName(_ index: Int) -> String {
        index >= 0 && index < Self.filterNames.count ? Self.filterNames[index] : "关闭"
    }

    private func paletteName(_ index: Int) -> String {
        index >= 0 && index < Self.gbPaletteNames.count ? Self.gbPaletteNames[index] : "默认"
    }

    @objc private func showPerRomDialog() {
        guard let core, mgbaMobileIsLoaded(core), let crc = romCrc else {
            toast("请先打开一个游戏")
            return
        }
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let filter = UIButton(type: .system)
        filter.contentHorizontalAlignment = .left
        let speed = UIButton(type: .system)
        speed.contentHorizontalAlignment = .left
        let saveType = UIButton(type: .system)
        saveType.contentHorizontalAlignment = .left
        let palette = UIButton(type: .system)
        palette.contentHorizontalAlignment = .left

        func refreshTitles() {
            let filterValue = romSettings.get(crc, "filter", fallback: RomSettings.defaultValue)
            filter.setTitle("滤镜：\(filterValue == RomSettings.defaultValue ? "跟随全局" : filterName(Int(filterValue) ?? 0))", for: .normal)
            let speedValue = romSettings.get(crc, "speed", fallback: RomSettings.defaultValue)
            speed.setTitle("倍速：\(speedValue == RomSettings.defaultValue ? "跟随全局" : "\(speedValue)倍")", for: .normal)
            let saveValue = romSettings.get(crc, "save_type", fallback: RomSettings.defaultValue)
            saveType.setTitle("存档类型：\(saveValue == RomSettings.defaultValue ? "跟随全局" : Self.saveTypeName(Int(saveValue) ?? 0))", for: .normal)
            let paletteValue = romSettings.get(crc, "gb_palette", fallback: RomSettings.defaultValue)
            palette.setTitle("GB 调色板：\(paletteValue == RomSettings.defaultValue ? "跟随全局" : paletteName(Int(paletteValue) ?? 0))", for: .normal)
        }
        refreshTitles()

        filter.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let stored = self.romSettings.get(crc, "filter", fallback: RomSettings.defaultValue)
            let options = ["跟随全局"] + Self.filterNames
            let current = stored == RomSettings.defaultValue ? 0 : (Int(stored) ?? 0) + 1
            self.pickOption(title: "本游戏滤镜", current: current, options: options) { [weak self] index in
                guard let self else { return }
                self.romSettings.put(crc, "filter", index == 0 ? RomSettings.defaultValue : String(index - 1))
                self.applyPerRomSettings()
                refreshTitles()
            }
        }, for: .touchUpInside)

        speed.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let stored = self.romSettings.get(crc, "speed", fallback: RomSettings.defaultValue)
            let alert = UIAlertController(title: "本游戏倍速", message: "0.05 ~ 16，留空或点「跟随全局」清除。", preferredStyle: .alert)
            alert.addTextField { field in
                field.text = stored == RomSettings.defaultValue ? "" : stored
                field.placeholder = "例如 1.5"
                field.keyboardType = .decimalPad
            }
            func clearSpeed() {
                self.romSettings.put(crc, "speed", RomSettings.defaultValue)
                self.applyPerRomSettings()
                refreshTitles()
            }
            alert.addAction(UIAlertAction(title: "跟随全局", style: .default) { _ in clearSpeed() })
            alert.addAction(UIAlertAction(title: "确定", style: .default) { _ in
                let text = alert.textFields?.first?.text?.trimmingCharacters(in: .whitespaces) ?? ""
                guard let value = Double(text.replacingOccurrences(of: ",", with: ".")) else {
                    self.toast("倍速范围仅限 0.05~16")
                    return
                }
                let clamped = min(16, max(0.05, value))
                self.romSettings.put(crc, "speed", String(clamped))
                self.applyPerRomSettings()
                refreshTitles()
            })
            alert.addAction(UIAlertAction(title: "取消", style: .cancel))
            self.presentSheet(alert)
        }, for: .touchUpInside)

        saveType.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let values = [-1, 0, 1, 2, 3, 4, 5, 6]
            let stored = self.romSettings.get(crc, "save_type", fallback: RomSettings.defaultValue)
            let options = ["跟随全局"] + values.map { Self.saveTypeName($0) }
            let current = stored == RomSettings.defaultValue
                ? 0 : (values.firstIndex(of: Int(stored) ?? 0) ?? 0) + 1
            self.pickOption(title: "本游戏存档类型", current: current, options: options) { [weak self] index in
                guard let self else { return }
                self.romSettings.put(crc, "save_type", index == 0 ? RomSettings.defaultValue : String(values[index - 1]))
                self.applyPerRomSettings()
                refreshTitles()
            }
        }, for: .touchUpInside)

        palette.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let stored = self.romSettings.get(crc, "gb_palette", fallback: RomSettings.defaultValue)
            let options = ["跟随全局"] + Self.gbPaletteNames
            let current = stored == RomSettings.defaultValue ? 0 : (Int(stored) ?? 0) + 1
            self.pickOption(title: "本游戏 GB 调色板", current: current, options: options) { [weak self] index in
                guard let self else { return }
                self.romSettings.put(crc, "gb_palette", index == 0 ? RomSettings.defaultValue : String(index - 1))
                self.applyPerRomSettings()
                refreshTitles()
            }
        }, for: .touchUpInside)

        let reset = UIButton(type: .system)
        reset.contentHorizontalAlignment = .left
        reset.setTitle("清除本游戏的全部覆盖", for: .normal)
        reset.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.romSettings.clear(crc)
            self.applyPerRomSettings()
            refreshTitles()
            self.toast("已清除本游戏设置")
        }, for: .touchUpInside)
        let hint = UILabel()
        hint.text = "按 CRC32 \(String(crc, radix: 16).uppercased()) 保存。留空的项目使用全局设置。"
        hint.textColor = .secondaryLabel
        hint.font = .systemFont(ofSize: 11)
        hint.numberOfLines = 0
        box.addArrangedSubview(filter)
        box.addArrangedSubview(speed)
        box.addArrangedSubview(saveType)
        box.addArrangedSubview(palette)
        box.addArrangedSubview(reset)
        box.addArrangedSubview(hint)
        presentSheet(SheetController(title: "本游戏设置", content: box))
    }

    // == ROM library ==

    // == Custom ROM folders ==

    private static let romDirsKey = "rom_dirs"
    private static let romDirBookmarksKey = "rom_dir_bookmarks"

    private func romDirs() -> [String] {
        let raw = defaults.string(forKey: Self.romDirsKey) ?? ""
        return raw.split(separator: "\n")
            .map { String($0).trimmingCharacters(in: .whitespaces) }
            .filter { !$0.isEmpty }
    }

    private func saveRomDirs(_ dirs: [String]) {
        defaults.set(dirs.joined(separator: "\n"), forKey: Self.romDirsKey)
    }

    private func romDirBookmarks() -> [String: Data] {
        (defaults.dictionary(forKey: Self.romDirBookmarksKey) as? [String: Data]) ?? [:]
    }

    private func setRomDirBookmark(_ path: String, _ data: Data?) {
        var all = romDirBookmarks()
        if let value = data {
            all[path] = value
        } else {
            all.removeValue(forKey: path)
        }
        defaults.set(all, forKey: Self.romDirBookmarksKey)
    }

    /** Resolves the player's folders; bookmarked ones keep their sandbox grant. */
    private func customRomDirs() -> [URL] {
        let bookmarks = romDirBookmarks()
        var out: [URL] = []
        for path in romDirs() {
            if let data = bookmarks[path] {
                var stale = false
                if let url = try? URL(resolvingBookmarkData: data, options: [], relativeTo: nil,
                                      bookmarkDataIsStale: &stale), !stale {
                    out.append(url)
                    continue
                }
            }
            out.append(URL(fileURLWithPath: path))
        }
        return out
    }

    /** Keeps a security-scoped grant alive for the whole session so ROMs and
     * their saves stay reachable after the picker closes. */
    private func restoreCustomFolderAccess() {
        for url in scopedFolderURLs { url.stopAccessingSecurityScopedResource() }
        scopedFolderURLs.removeAll()
        let bookmarks = romDirBookmarks()
        for path in romDirs() {
            guard let data = bookmarks[path] else { continue }
            var stale = false
            guard let url = try? URL(resolvingBookmarkData: data, options: [], relativeTo: nil,
                                     bookmarkDataIsStale: &stale) else { continue }
            if url.startAccessingSecurityScopedResource() { scopedFolderURLs.append(url) }
        }
    }

    private func addCustomRomFolder(_ url: URL) {
        let path = url.standardizedFileURL.path
        var isDir: ObjCBool = false
        guard FileManager.default.fileExists(atPath: path, isDirectory: &isDir), isDir.boolValue else {
            toast("这不是一个文件夹")
            return
        }
        if url.startAccessingSecurityScopedResource() {
            scopedFolderURLs.append(url)
        }
        if let data = try? url.bookmarkData(options: [], includingResourceValuesForKeys: nil, relativeTo: nil) {
            setRomDirBookmark(path, data)
        }
        addRomDirPath(path)
    }

    private func addRomDirPath(_ raw: String) {
        let path = raw.trimmingCharacters(in: .whitespacesAndNewlines)
        guard !path.isEmpty else { return }
        let url = URL(fileURLWithPath: path).standardizedFileURL
        var isDir: ObjCBool = false
        guard FileManager.default.fileExists(atPath: url.path, isDirectory: &isDir),
              isDir.boolValue, FileManager.default.isReadableFile(atPath: url.path) else {
            toast("文件夹不存在或不可读：\(url.path)")
            return
        }
        var dirs = romDirs()
        if dirs.contains(url.path) {
            toast("这个文件夹已经添加过了")
            return
        }
        dirs.append(url.path)
        saveRomDirs(dirs)
        toast("已添加：\(url.path)")
        showRomDirsDialog()
    }

    private func removeRomDir(_ path: String) {
        var dirs = romDirs()
        dirs.removeAll { $0 == path }
        saveRomDirs(dirs)
        setRomDirBookmark(path, nil)
        for (index, url) in scopedFolderURLs.enumerated().reversed() {
            if url.standardizedFileURL.path == path {
                url.stopAccessingSecurityScopedResource()
                scopedFolderURLs.remove(at: index)
            }
        }
        toast("已移除：\(path)")
        showRomDirsDialog()
    }

    /** Manage the folders the ROM scan looks in first. */
    private func showRomDirsDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        let hint = UILabel()
        hint.text = "把游戏（.gba/.gb/.gbc）和存档（.sav/.srm/.ss1）放在同一个文件夹，在这里添加该文件夹后即可扫描并自动读取同目录存档。\n\n同目录已有存档时优先使用它；否则仍用公共存档目录。同目录存档不纳入应用内备份和 WebDAV 同步。"
        hint.textColor = .secondaryLabel
        hint.font = .systemFont(ofSize: 12)
        hint.numberOfLines = 0
        box.addArrangedSubview(hint)
        let dirs = romDirs()
        if dirs.isEmpty {
            let empty = UILabel()
            empty.text = "还没有添加文件夹。"
            empty.textColor = .secondaryLabel
            box.addArrangedSubview(empty)
        }
        for path in dirs {
            let row = UIStackView()
            row.axis = .horizontal
            row.spacing = 6
            row.alignment = .center
            let label = UILabel()
            label.text = path
            label.font = .systemFont(ofSize: 12)
            label.numberOfLines = 2
            label.setContentCompressionResistancePriority(.defaultLow, for: .horizontal)
            row.addArrangedSubview(label)
            let remove = UIButton(type: .system)
            remove.setTitle("移除", for: .normal)
            let target = path
            remove.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                self.topmostPresenter.dismiss(animated: true) { self.removeRomDir(target) }
            }, for: .touchUpInside)
            row.addArrangedSubview(remove)
            box.addArrangedSubview(row)
        }
        let pickFolder = UIButton(type: .system)
        pickFolder.contentHorizontalAlignment = .left
        pickFolder.setTitle("选择文件夹（系统文件选择器）", for: .normal)
        pickFolder.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.topmostPresenter.dismiss(animated: true) { self.pick(kind: 11) }
        }, for: .touchUpInside)
        box.addArrangedSubview(pickFolder)
        let manual = UIButton(type: .system)
        manual.contentHorizontalAlignment = .left
        manual.setTitle("手动输入路径（App 文档目录内）", for: .normal)
        manual.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let alert = UIAlertController(title: "ROM 文件夹路径", message: nil, preferredStyle: .alert)
            alert.addTextField { field in field.text = self.docs.path + "/" }
            alert.addAction(UIAlertAction(title: "添加", style: .default) { [weak self] _ in
                guard let self else { return }
                self.addRomDirPath(alert.textFields?.first?.text ?? "")
            })
            alert.addAction(UIAlertAction(title: "取消", style: .cancel))
            self.presentSheet(alert)
        }, for: .touchUpInside)
        box.addArrangedSubview(manual)
        let rescan = UIButton(type: .system)
        rescan.contentHorizontalAlignment = .left
        rescan.setTitle("立即扫描", for: .normal)
        rescan.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.topmostPresenter.dismiss(animated: true) { self.showRomLibrary() }
        }, for: .touchUpInside)
        box.addArrangedSubview(rescan)
        presentSheet(SheetController(title: "ROM 文件夹", content: box))
    }

    // == Saves beside the ROM ==

    private func romBaseName(_ rom: URL) -> String {
        rom.deletingPathExtension().lastPathComponent
    }

    /** Whether a battery save or save state already sits beside this ROM. */
    private func hasBesideSaves(_ rom: URL) -> Bool {
        let parent = rom.deletingLastPathComponent()
        let base = romBaseName(rom)
        for suffix in [".sav", ".srm", ".sa1", ".sa2", ".sa3", ".sa4"] {
            let file = parent.appendingPathComponent(base + suffix)
            if ((try? FileManager.default.attributesOfItem(atPath: file.path)[.size] as? NSNumber)?.int64Value ?? 0) > 0 {
                return true
            }
        }
        for slot in 0...9 {
            let file = parent.appendingPathComponent("\(base).ss\(slot)")
            if ((try? FileManager.default.attributesOfItem(atPath: file.path)[.size] as? NSNumber)?.int64Value ?? 0) > 0 {
                return true
            }
        }
        return false
    }

    /**
     * Saves live beside the ROM when the player already keeps them there (or
     * explicitly asks for it); otherwise the shared folders stay in use so
     * existing saves are never orphaned. Must run before mgbaMobileLoad.
     */
    private func applyRomSaveLocation(_ path: String) {
        guard let core else { return }
        let rom = URL(fileURLWithPath: path).standardizedFileURL
        let parent = rom.deletingLastPathComponent()
        let beside = FileManager.default.isWritableFile(atPath: parent.path)
            && (hasBesideSaves(rom) || defaults.bool(forKey: "saves_beside_rom"))
        let saveDir = beside ? parent : docs.appendingPathComponent("saves", isDirectory: true)
        let stateDir = beside ? parent : docs.appendingPathComponent("states", isDirectory: true)
        activeStateDir = stateDir
        mgbaMobileSetSaveDirs(core, saveDir.path, stateDir.path)
    }

    @objc private func showRomLibrary() {
        let roots = romRoots()
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            guard let self else { return }
            var scoped: [URL] = []
            for root in roots where root.startAccessingSecurityScopedResource() {
                scoped.append(root)
            }
            let preferred = Set(self.customRomDirs().map { $0.standardizedFileURL.path })
            let found = self.romLibrary.scan(roots: roots, preferred: preferred)
            for url in scoped { url.stopAccessingSecurityScopedResource() }
            DispatchQueue.main.async { self.showRomLibraryList(found) }
        }
    }

    private func romRoots() -> [URL] {
        // Player-added folders come first: their games always top the list.
        var roots = customRomDirs()
        roots.append(contentsOf: [
            docs,
            docs.appendingPathComponent("roms", isDirectory: true),
            docs.appendingPathComponent("Inbox", isDirectory: true),
        ])
        if let last = romLibrary.lastRom() {
            roots.append(last.deletingLastPathComponent())
        }
        var seen = Set<String>()
        return roots.filter { seen.insert($0.standardizedFileURL.path).inserted }
    }

    private func showRomLibraryList(_ found: [RomLibrary.Entry]) {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 4
        let actions = UIStackView()
        actions.axis = .horizontal
        actions.spacing = 8
        let rescan = UIButton(type: .system)
        rescan.setTitle("重新扫描", for: .normal)
        rescan.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.topmostPresenter.dismiss(animated: true) { self.showRomLibrary() }
        }, for: .touchUpInside)
        let open = UIButton(type: .system)
        open.setTitle("打开文件", for: .normal)
        open.addAction(UIAction { [weak self] _ in self?.pick(kind: 1) }, for: .touchUpInside)
        let folders = UIButton(type: .system)
        folders.setTitle("文件夹", for: .normal)
        folders.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.topmostPresenter.dismiss(animated: true) { self.showRomDirsDialog() }
        }, for: .touchUpInside)
        actions.addArrangedSubview(rescan)
        actions.addArrangedSubview(open)
        actions.addArrangedSubview(folders)
        actions.addArrangedSubview(UIView())
        box.addArrangedSubview(actions)
        if found.isEmpty {
            let empty = UILabel()
            empty.text = "没有找到游戏。把 ROM 放进「文件」App 的 mGBA 文件夹，或用「打开文件」选择。"
            empty.numberOfLines = 0
            empty.textColor = .secondaryLabel
            box.addArrangedSubview(empty)
        }
        let favs = romLibrary.favorites()
        let last = romLibrary.lastRom()?.path
        var ordered: [RomLibrary.Entry] = []
        var seen = Set<String>()
        if let last, let entry = found.first(where: { $0.url.path == last }), seen.insert(entry.url.path).inserted {
            ordered.append(entry)
        }
        for entry in found where favs.contains(entry.url.path) && seen.insert(entry.url.path).inserted {
            ordered.append(entry)
        }
        for entry in found where seen.insert(entry.url.path).inserted {
            ordered.append(entry)
        }
        for entry in ordered {
            box.addArrangedSubview(romLibraryRow(entry,
                                                 favorite: favs.contains(entry.url.path),
                                                 last: entry.url.path == last))
        }
        presentSheet(SheetController(title: "图库", content: box))
    }

    private func romLibraryRow(_ entry: RomLibrary.Entry, favorite: Bool, last: Bool) -> UIView {
        let row = UIStackView()
        row.axis = .horizontal
        row.spacing = 6
        row.alignment = .center
        let open = UIButton(type: .system)
        open.contentHorizontalAlignment = .left
        open.titleLabel?.numberOfLines = 2
        open.titleLabel?.font = .systemFont(ofSize: 14)
        func title(_ favorite: Bool) -> String {
            let mark = favorite ? "★ " : "☆ "
            let suffix = last ? "（上次）" : ""
            let saveMark = hasBesideSaves(entry.url) ? "  [同目录有存档]" : ""
            return "\(mark)\(entry.url.lastPathComponent)\(suffix)\(saveMark)\n\(entry.url.deletingLastPathComponent().path)"
        }
        open.setTitle(title(favorite), for: .normal)
        open.heightAnchor.constraint(greaterThanOrEqualToConstant: 52).isActive = true
        open.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.topmostPresenter.dismiss(animated: true) { self.openFoundRom(entry.url) }
        }, for: .touchUpInside)
        let star = UIButton(type: .system)
        star.setTitle(favorite ? "★" : "☆", for: .normal)
        star.setTitleColor(UIColor(red: 1, green: 0.68, blue: 0.2, alpha: 1), for: .normal)
        star.widthAnchor.constraint(equalToConstant: 44).isActive = true
        star.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let now = self.romLibrary.toggleFavorite(entry.url)
            star.setTitle(now ? "★" : "☆", for: .normal)
            open.setTitle(title(now), for: .normal)
            self.toast(now ? "已收藏" : "已取消收藏")
        }, for: .touchUpInside)
        row.addArrangedSubview(open)
        row.addArrangedSubview(star)
        return row
    }

    private func openFoundRom(_ url: URL) {
        openExternal(url)
    }

    /// A zip-ROM: writes the first game entry into Documents/roms/unpacked.
    private func extractRomZip(_ url: URL) -> String? {
        guard let entries = Zip.read(url) else { return nil }
        let dir = docs.appendingPathComponent("roms/unpacked", isDirectory: true)
        try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        for entry in entries {
            let name = zipBaseName(entry.name)
            guard RomLibrary.isRomFile(name), !entry.data.isEmpty else { continue }
            let dest = dir.appendingPathComponent(sanitize(name))
            do {
                try entry.data.write(to: dest, options: .atomic)
                return dest.path
            } catch {
                continue
            }
        }
        return nil
    }

    private func zipBaseName(_ name: String) -> String {
        var file = name
        if let index = file.range(of: "/", options: .backwards) {
            file = String(file[index.upperBound...])
        }
        if let index = file.range(of: "\\", options: .backwards) {
            file = String(file[index.upperBound...])
        }
        return file
    }

    // == Backup ==

    @objc private func showBackupDialog() {
        let alert = UIAlertController(title: "备份", message: "备份包含设置、电池存档和即时存档。", preferredStyle: .actionSheet)
        alert.addAction(UIAlertAction(title: "导出备份（ZIP）", style: .default) { [weak self] _ in self?.exportBackup() })
        alert.addAction(UIAlertAction(title: "导入备份（ZIP）", style: .default) { [weak self] _ in self?.pick(kind: 4) })
        alert.addAction(UIAlertAction(title: "云同步设置（WebDAV）", style: .default) { [weak self] _ in self?.showWebDavSettings() })
        alert.addAction(UIAlertAction(title: "立即同步电池存档", style: .default) { [weak self] _ in self?.runWebDavSync() })
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        if let popover = alert.popoverPresentationController {
            popover.sourceView = view
            popover.sourceRect = CGRect(x: view.bounds.midX, y: view.bounds.midY, width: 0, height: 0)
        }
        presentSheet(alert)
    }

    private func exportBackup() {
        let settings = persistentSettings()
        let saves = docs.appendingPathComponent("saves", isDirectory: true)
        let states = docs.appendingPathComponent("states", isDirectory: true)
        let dest = FileManager.default.temporaryDirectory
            .appendingPathComponent("mGBAx-backup-\(Self.fileStamp()).zip")
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            guard let self else { return }
            let count = BackupStore.export(settings: settings, saves: saves, states: states, to: dest)
            DispatchQueue.main.async {
                guard count != nil else {
                    self.toast("备份失败")
                    return
                }
                self.backupExportURL = dest
                self.pickerKind = 9
                self.presentSheet(UIDocumentPickerViewController(forExporting: [dest], asCopy: true))
            }
        }
    }

    private func importBackup(_ url: URL) {
        let saves = docs.appendingPathComponent("saves", isDirectory: true)
        let states = docs.appendingPathComponent("states", isDirectory: true)
        // The document picker hands out a security scoped URL; the scope has to
        // stay open while the archive is read on the background queue.
        let scoped = url.startAccessingSecurityScopedResource()
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            guard let self else { return }
            let settings = BackupStore.restore(from: url, saves: saves, states: states)
            if scoped { url.stopAccessingSecurityScopedResource() }
            DispatchQueue.main.async {
                guard let settings else {
                    self.toast("备份文件无效或无法读取")
                    return
                }
                for (key, value) in settings where !(value is NSNull) {
                    self.defaults.set(value, forKey: key)
                }
                self.applyRestoredSettings()
                self.toast("备份已恢复")
            }
        }
    }

    /// The app's own persistent preferences, the same set Android exports.
    private func persistentSettings() -> [String: Any] {
        let id = Bundle.main.bundleIdentifier ?? "io.mgba"
        return defaults.persistentDomain(forName: id) ?? [:]
    }

    private func applyRestoredSettings() {
        orientationMode = defaults.string(forKey: "orientation") ?? "landscape"
        muted = defaults.bool(forKey: "muted")
        applyVolume()
        audio.lowLatency = defaults.bool(forKey: "low_latency")
        audio.setSoundEnabled(defaults.object(forKey: "fast_audio") == nil ? true : defaults.bool(forKey: "fast_audio"))
        loadMacroSettings()
        controls.setMuted(muted)
        controls.setFastForwardOn(ffOn)
        applyInputSettings()
        applySkin()
        applyVideo()
        applyCoreOptions()
        layoutProfile = activeProfile()
        reloadKeyLayout()
        loadStickers()
        refreshSpeedButtons()
        updateMenuLayout()
        applyOrientation()
        if let core, mgbaMobileIsLoaded(core) {
            applyPerRomSettings()
            startTimedSave()
        } else {
            stopTimedSave()
        }
    }

    // == AI translate ==

    @objc private func showTranslateDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        let keyButton = UIButton(type: .system)
        keyButton.contentHorizontalAlignment = .left
        func refreshKey() {
            let key = (defaults.string(forKey: "ai_key") ?? "").trimmingCharacters(in: .whitespacesAndNewlines)
            keyButton.setTitle(key.isEmpty ? "设置 Gemini API Key（必填）" : "Gemini API Key：已设置（点按修改）", for: .normal)
        }
        refreshKey()
        keyButton.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.promptAiKey(current: self.defaults.string(forKey: "ai_key") ?? "") { refreshKey() }
        }, for: .touchUpInside)
        let langButton = UIButton(type: .system)
        langButton.contentHorizontalAlignment = .left
        func refreshLang() {
            let lang = defaults.string(forKey: "ai_lang") ?? "简体中文"
            langButton.setTitle("翻译语言：\(lang)", for: .normal)
        }
        refreshLang()
        langButton.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let alert = UIAlertController(title: "翻译语言", message: "例如 简体中文、繁體中文、English、日本語", preferredStyle: .alert)
            alert.addTextField { field in
                field.text = self.defaults.string(forKey: "ai_lang") ?? "简体中文"
                field.placeholder = "简体中文"
            }
            alert.addAction(UIAlertAction(title: "保存", style: .default) { [weak self] _ in
                guard let self else { return }
                let text = alert.textFields?.first?.text?.trimmingCharacters(in: .whitespacesAndNewlines) ?? ""
                if text.isEmpty {
                    self.defaults.removeObject(forKey: "ai_lang")
                } else {
                    self.defaults.set(text, forKey: "ai_lang")
                }
                refreshLang()
            })
            alert.addAction(UIAlertAction(title: "取消", style: .cancel))
            self.presentSheet(alert)
        }, for: .touchUpInside)
        let go = UIButton(type: .system)
        go.contentHorizontalAlignment = .left
        go.setTitle("翻译当前画面", for: .normal)
        go.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            let key = (self.defaults.string(forKey: "ai_key") ?? "").trimmingCharacters(in: .whitespacesAndNewlines)
            guard !key.isEmpty else {
                self.toast("请先设置 Gemini API Key")
                return
            }
            self.topmostPresenter.dismiss(animated: true) { self.startTranslation() }
        }, for: .touchUpInside)
        let clear = UIButton(type: .system)
        clear.contentHorizontalAlignment = .left
        clear.setTitle("清除 API Key", for: .normal)
        clear.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.removeObject(forKey: "ai_key")
            refreshKey()
            self.toast("已清除 API Key")
        }, for: .touchUpInside)
        let hint = UILabel()
        hint.text = "识别画面中的文字并用 Gemini 翻译。画面只发送到 Google 的接口；没有文字时会跳过。"
        hint.textColor = .secondaryLabel
        hint.font = .systemFont(ofSize: 11)
        hint.numberOfLines = 0
        box.addArrangedSubview(keyButton)
        box.addArrangedSubview(langButton)
        box.addArrangedSubview(go)
        box.addArrangedSubview(clear)
        box.addArrangedSubview(hint)
        presentSheet(SheetController(title: "AI 翻译", content: box))
    }

    private func promptAiKey(current: String, completion: (() -> Void)? = nil) {
        let alert = UIAlertController(title: "Gemini API Key",
                                      message: "在 Google AI Studio 创建 API Key。Key 只保存在本机。",
                                      preferredStyle: .alert)
        alert.addTextField { field in
            field.text = current
            field.placeholder = "AIza..."
            field.isSecureTextEntry = true
        }
        alert.addAction(UIAlertAction(title: "保存", style: .default) { [weak self] _ in
            guard let self else { return }
            let value = alert.textFields?.first?.text?.trimmingCharacters(in: .whitespacesAndNewlines) ?? ""
            if value.isEmpty {
                self.defaults.removeObject(forKey: "ai_key")
            } else {
                self.defaults.set(value, forKey: "ai_key")
            }
            completion?()
        })
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(alert)
    }

    private func startTranslation() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let key = (defaults.string(forKey: "ai_key") ?? "").trimmingCharacters(in: .whitespacesAndNewlines)
        guard !key.isEmpty else {
            toast("请先设置 Gemini API Key")
            return
        }
        guard let frame = gameView.copyLast() ?? aiFrame else {
            toast("翻译失败：没有画面")
            return
        }
        let send = AiTranslate.snapshot(frame, maxSide: 960)
        aiFrame = send
        aiOverlay.hide()
        toast("正在翻译…")
        AiTranslate.translate(frame: send,
                              apiKey: key,
                              targetLang: defaults.string(forKey: "ai_lang") ?? "简体中文") { [weak self] blocks, error in
            guard let self else { return }
            if let error {
                self.toast("翻译失败：\(error)")
                return
            }
            guard let blocks, !blocks.isEmpty else {
                self.toast("没有找到可翻译的文字")
                return
            }
            self.aiOverlay.pictureFrame = self.stage.convert(self.gameView.pictureRect, from: self.gameView)
            self.aiOverlay.show(blocks, frame: send)
            self.toast("已翻译 \(blocks.count) 处文字，点击画面关闭")
        }
    }

    // == Rewind, mute and fast-forward ==

    @objc private func toggleRewindBar() {
        rewindWanted.toggle()
        updateMenuLayout()
        if rewindWanted {
            showMenu()
            armMenuAutoHide()
        }
    }

    @objc private func rewindStep(_ sender: UIButton) {
        rewindSeconds = max(1, sender.tag)
        postCommand(cmdRewind)
        wakeInput()
    }

    @objc private func rewindHoldDown() {
        gate.lock()
        rewindHold = true
        lastRewindAt = 0
        gate.unlock()
        // A long hold outlives the menu auto-hide; keep the bar up while the
        // finger stays down.
        menuHideWork?.cancel()
        wakeInput()
    }

    @objc private func rewindHoldUp() {
        gate.lock()
        rewindHold = false
        gate.unlock()
        armMenuAutoHide()
    }

    @objc private func toggleFastForward() {
        ffOn.toggle()
        controls.setFastForwardOn(ffOn)
        refreshSpeedButtons()
        toast(ffOn ? "已开启快进（\(Self.speedLabel(fastHoldSpeed()))倍）" : "已关闭快进")
    }

    @objc private func toggleMute() {
        muted.toggle()
        defaults.set(muted, forKey: "muted")
        controls.setMuted(muted)
        applyVolume()
        toast(muted ? "已静音" : "已取消静音")
    }

    // == Timed saves ==

    /// Periodic silent save into the reserved auto slot while a game runs.
    private func startTimedSave() {
        stopTimedSave()
        let minutes = defaults.object(forKey: "timed_save_min") == nil ? 0 : defaults.integer(forKey: "timed_save_min")
        guard minutes > 0 else { return }
        let timer = Timer(timeInterval: TimeInterval(minutes * 60), repeats: true) { [weak self] _ in
            guard let self, let core = self.core, mgbaMobileIsLoaded(core) else { return }
            self.gate.lock()
            let isPaused = self.paused
            self.gate.unlock()
            guard !isPaused else { return }
            if let frame = self.gameView.copyLast() {
                self.gate.lock()
                self.pendingPreview = frame
                self.gate.unlock()
            }
            self.postCommand(self.cmdAutoSave)
        }
        RunLoop.main.add(timer, forMode: .common)
        timedSaveTimer = timer
    }

    private func stopTimedSave() {
        if Thread.isMainThread {
            timedSaveTimer?.invalidate()
            timedSaveTimer = nil
        } else {
            DispatchQueue.main.async { [weak self] in
                self?.timedSaveTimer?.invalidate()
                self?.timedSaveTimer = nil
            }
        }
    }

    // == C / C2 macros ==

    private func loadMacroSettings() {
        let c = defaults.object(forKey: "c_macro") == nil
            ? (ControlsView.A | ControlsView.B) : defaults.integer(forKey: "c_macro")
        let c2 = defaults.object(forKey: "c2_macro") == nil
            ? (ControlsView.l | ControlsView.r) : defaults.integer(forKey: "c2_macro")
        controls.setMacro(0, c)
        controls.setMacro(1, c2)
    }

    private func macroTitle(_ mask: Int) -> String {
        let entries: [(Int, String)] = [
            (ControlsView.A, "A"), (ControlsView.B, "B"),
            (ControlsView.l, "L"), (ControlsView.r, "R"),
            (ControlsView.select, "SELECT"), (ControlsView.start, "START"),
            (ControlsView.up, "UP"), (ControlsView.down, "DOWN"),
            (ControlsView.left, "LEFT"), (ControlsView.right, "RIGHT"),
        ]
        let names = entries.filter { (mask & $0.0) != 0 }.map { $0.1 }
        return names.isEmpty ? "无" : names.joined(separator: "+")
    }

    private func showMacroDialog(which: Int, onChange: (() -> Void)? = nil) {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 2
        let hint = UILabel()
        hint.text = "按住 C/C2 键时，同时按下下面勾选的按键。"
        hint.textColor = .secondaryLabel
        hint.font = .systemFont(ofSize: 11)
        hint.numberOfLines = 0
        box.addArrangedSubview(hint)
        let entries: [(Int, String)] = [
            (ControlsView.A, "A"), (ControlsView.B, "B"),
            (ControlsView.l, "L"), (ControlsView.r, "R"),
            (ControlsView.select, "SELECT"), (ControlsView.start, "START"),
            (ControlsView.up, "UP"), (ControlsView.down, "DOWN"),
            (ControlsView.left, "LEFT"), (ControlsView.right, "RIGHT"),
        ]
        var mask = controls.macro(which)
        let key = which == 0 ? "c_macro" : "c2_macro"
        for (bit, name) in entries {
            let row = labeledSwitch(name, (mask & bit) != 0)
            row.1.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                if row.1.isOn {
                    mask |= bit
                } else {
                    mask &= ~bit
                }
                self.controls.setMacro(which, mask)
                self.defaults.set(mask, forKey: key)
                onChange?()
            }, for: .valueChanged)
            box.addArrangedSubview(row.0)
        }
        presentSheet(SheetController(title: which == 0 ? "C 键组合宏" : "C2 键组合宏", content: box))
    }

    // == Screenshots & GIF ==

    /** Saves the current frame as PNG or JPG into the photo library. */
    @objc private func takeScreenshot() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        // With a filter or scanlines on screen, capture the rendered output so
        // the saved file matches the display; the raw frame is otherwise
        // crisper.
        if let shot = gameView.captureFilteredScreenshot() {
            saveScreenshot(shot)
            return
        }
        saveScreenshot(gameView.copyLast())
    }

    private func saveScreenshot(_ shot: UIImage?) {
        guard let shot else {
            toast("请先打开一个游戏")
            return
        }
        let jpg = (defaults.string(forKey: "shot_format") ?? "png").lowercased() == "jpg"
        guard let data = jpg ? shot.jpegData(compressionQuality: 0.95) : shot.pngData() else {
            toast("截图失败")
            return
        }
        let stamp = Self.fileStamp()
        let name = "mGBAx-\(stamp).\(jpg ? "jpg" : "png")"
        PHPhotoLibrary.requestAuthorization(for: .addOnly) { [weak self] status in
            DispatchQueue.main.async {
                guard let self else { return }
                if status == .authorized || status == .limited {
                    PHPhotoLibrary.shared().performChanges {
                        let request = PHAssetCreationRequest.forAsset()
                        request.creationDate = Date()
                        let options = PHAssetResourceCreationOptions()
                        options.originalFilename = name
                        options.uniformTypeIdentifier = jpg ? UTType.jpeg.identifier : UTType.png.identifier
                        request.addResource(with: .photo, data: data, options: options)
                    } completionHandler: { ok, _ in
                        DispatchQueue.main.async {
                            if ok {
                                self.toast("已保存截图 相册/\(name)")
                            } else {
                                self.saveShotFallback(data: data, name: name)
                            }
                        }
                    }
                } else {
                    self.saveShotFallback(data: data, name: name)
                }
            }
        }
    }

    /// Photos was unavailable: keep the shot in the app's Documents/mGBAx,
    /// which the Files app shows.
    private func saveShotFallback(data: Data, name: String) {
        let dir = docs.appendingPathComponent("mGBAx", isDirectory: true)
        try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        do {
            try data.write(to: dir.appendingPathComponent(name))
            toast("已保存截图 文件/mGBAx/\(name)")
        } catch {
            toast("截图失败")
        }
    }

    /// Adds the floating GIF button when the user asked for it.
    private func setupGifBall() {
        guard gifBall == nil, defaults.bool(forKey: "gif_ball") else {
            return
        }
        let ball = GifBall(frame: CGRect(x: 0, y: 0, width: GifBall.side, height: GifBall.side))
        ball.onTap = { [weak self] in
            self?.toggleGif()
        }
        view.addSubview(ball)
        gifBall = ball
        // 记住上次停靠的位置
        let raw = defaults.string(forKey: "gif_ball_pos") ?? "80,120"
        let parts = raw.split(separator: ",").compactMap { Int($0.trimmingCharacters(in: .whitespaces)) }
        let x = parts.count >= 2 ? parts[0] : 80
        let y = parts.count >= 2 ? parts[1] : 120
        ball.center = CGPoint(x: CGFloat(x), y: CGFloat(y))
        ball.onMoved = { [weak self] in
            guard let self, let ball = self.gifBall else { return }
            self.defaults.set("\(Int(ball.center.x)),\(Int(ball.center.y))", forKey: "gif_ball_pos")
        }
        refreshGifBall()
    }

    /// Shows the ball only while a game is running, and reflects the state.
    private func refreshGifBall() {
        guard let ball = gifBall else {
            return
        }
        let loaded = core != nil && mgbaMobileIsLoaded(core)
        ball.isHidden = !loaded
        ball.setRecording(gifRecording)
    }

    @objc private func toggleGif() {
        if gifRecording {
            stopGif()
        } else {
            startGif()
        }
    }

    /** Starts recording the presented frames into a GIF. */
    private func startGif() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        if gifRecording { return }
        let w = Int(mgbaMobileWidth(core))
        let h = Int(mgbaMobileHeight(core))
        guard w > 0, h > 0 else {
            toast("请先打开一个游戏")
            return
        }
        let name = "mGBAx-\(Self.fileStamp()).gif"
        let queue = GifFrameQueue(limit: 24)
        gifQueue = queue
        lastGifAt = 0
        gifFrames = 0
        gifRecording = true
        gifButton?.setTitle("停止GIF", for: .normal)
        refreshGifBall()
        toast("开始GIF录制，再点一次菜单里的 GIF 停止")
        let thread = Thread { [weak self] in
            self?.runGifRecording(queue: queue, w: w, h: h, name: name)
        }
        thread.name = "gif-record"
        thread.stackSize = 1 << 21
        thread.start()
    }

    private func stopGif() {
        gifRecording = false
        gifButton?.setTitle("GIF", for: .normal)
        refreshGifBall()
    }

    /** Encoder loop: drains the queue into the GIF file, then publishes it. */
    private func runGifRecording(queue: GifFrameQueue, w: Int, h: Int, name: String) {
        let encoder = GifEncoder(width: w, height: h)
        while true {
            guard let frame = queue.poll(seconds: 1) else {
                if !gifRecording { break }
                continue
            }
            frame.withUnsafeBufferPointer { raw in
                if let base = raw.baseAddress {
                    encoder.addFrame(pixels: base, delayCs: Self.gifFrameMs / 10)
                }
            }
            gifFrames += 1
            if gifFrames >= Self.gifMaxFrames {
                // Reached the length cap: stop as if the user had.
                gifRecording = false
            }
        }
        let file = encoder.finish()
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            self.gifQueue = nil
            self.gifButton?.setTitle("GIF", for: .normal)
            if self.gifFrames > 0 {
                self.publishGif(file: file, name: name)
            } else {
                self.toast("GIF录制失败")
            }
        }
    }

    /// Writes the finished recording to Photos (GIF stays animated); falls
    /// back to Documents/mGBAx when Photos is unavailable.
    private func publishGif(file: Data, name: String) {
        let temp = FileManager.default.temporaryDirectory.appendingPathComponent("gif-publish.gif")
        do {
            try file.write(to: temp, options: .atomic)
        } catch {
            toast("GIF录制失败")
            return
        }
        PHPhotoLibrary.requestAuthorization(for: .addOnly) { [weak self] status in
            DispatchQueue.main.async {
                guard let self else { return }
                if status == .authorized || status == .limited {
                    PHPhotoLibrary.shared().performChanges {
                        _ = PHAssetCreationRequest.creationRequestForAssetFromImage(atFileURL: temp)
                    } completionHandler: { ok, _ in
                        DispatchQueue.main.async {
                            try? FileManager.default.removeItem(at: temp)
                            if ok {
                                self.toast("已保存GIF 相册/\(name)")
                            } else {
                                self.saveGifFallback(temp: temp, name: name)
                            }
                        }
                    }
                } else {
                    self.saveGifFallback(temp: temp, name: name)
                }
            }
        }
    }

    private func saveGifFallback(temp: URL, name: String) {
        let dir = docs.appendingPathComponent("mGBAx", isDirectory: true)
        try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        do {
            try FileManager.default.moveItem(at: temp, to: dir.appendingPathComponent(name))
            toast("已保存GIF 文件/mGBAx/\(name)")
        } catch {
            try? FileManager.default.removeItem(at: temp)
            toast("GIF录制失败")
        }
    }

    private static func fileStamp() -> String {
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyyMMdd-HHmmss"
        return formatter.string(from: Date())
    }

    // == Utility keys & confirmations ==

    /** Quick save/load used by the optional on-screen utility keys. */
    private func quickState(save: Bool) {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let go = { [weak self] in
            guard let self else { return }
            if save && self.defaults.bool(forKey: "quick_rotate") {
                self.slot = self.slot % 9 + 1
                self.refreshSlotButton()
            }
            if save {
                if let frame = self.gameView.copyLast() {
                    self.gate.lock()
                    self.pendingPreview = frame
                    self.gate.unlock()
                }
                self.postCommand(self.cmdSave)
            } else {
                self.postCommand(self.cmdLoad)
            }
        }
        if defaults.bool(forKey: "confirm_quick") {
            let title = save ? "快速存档" : "快速读档"
            let message = save ? "保存到槽位 \(slot)？" : "从槽位 \(slot) 读取？当前进度会丢失。"
            let alert = UIAlertController(title: title, message: message, preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "确定", style: .default) { _ in go() })
            alert.addAction(UIAlertAction(title: "取消", style: .cancel))
            presentSheet(alert)
        } else {
            go()
        }
    }

    /** Copies My Boy .sav files from a picked folder into the saves folder. */
    private func pickMyBoySaves() {
        pickerKind = 3
        let picker = UIDocumentPickerViewController(forOpeningContentTypes: [UTType.folder], asCopy: false)
        picker.delegate = self
        presentSheet(picker)
    }

    /// Copies every .sav in the picked folder next to the matching ROM save
    /// ("Rom.gba.sav" and "Rom.sav" both land as "Rom.sav").
    private func importMyBoySaves(_ urls: [URL]) {
        guard let url = urls.first else { return }
        toast("正在读取存档…")
        let saves = docs.appendingPathComponent("saves", isDirectory: true)
        try? FileManager.default.createDirectory(at: saves, withIntermediateDirectories: true)
        DispatchQueue.global().async { [weak self] in
            var okCount = 0
            var failCount = 0
            let secured = url.startAccessingSecurityScopedResource()
            defer { if secured { url.stopAccessingSecurityScopedResource() } }
            let files = (try? FileManager.default.contentsOfDirectory(at: url, includingPropertiesForKeys: nil)) ?? []
            for file in files where file.lastPathComponent.lowercased().hasSuffix(".sav") {
                var base = file.lastPathComponent
                if base.lowercased().hasSuffix(".sav") {
                    base = String(base.dropLast(4))
                }
                let lower = base.lowercased()
                if lower.hasSuffix(".gba") || lower.hasSuffix(".gbc") || lower.hasSuffix(".gb") || lower.hasSuffix(".sgb") {
                    base = String(base[..<base.lastIndex(of: ".")!])
                }
                if base.isEmpty {
                    failCount += 1
                    continue
                }
                do {
                    let data = try Data(contentsOf: file)
                    try data.write(to: saves.appendingPathComponent(base + ".sav"), options: .atomic)
                    okCount += 1
                } catch {
                    failCount += 1
                }
            }
            let good = okCount
            let bad = failCount
            DispatchQueue.main.async {
                self?.toast("导入完成：成功 \(good)，失败 \(bad)")
            }
        }
    }

    private func confirmDeleteBattery() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        var path = [CChar](repeating: 0, count: 1200)
        mgbaMobileSaveFile(core, &path, 1200)
        let savPath = String(cString: path)
        guard !savPath.isEmpty, FileManager.default.fileExists(atPath: savPath) else {
            toast("没有电池存档")
            return
        }
        let name = URL(fileURLWithPath: savPath).lastPathComponent
        let confirm = UIAlertController(title: "删除电池存档（.sav）", message: "将删除 \(name)（会备份为 .bak），并重新载入游戏。继续吗？", preferredStyle: .alert)
        confirm.addAction(UIAlertAction(title: "确定", style: .destructive) { [weak self] _ in
            let backup = savPath + ".bak"
            try? FileManager.default.removeItem(atPath: backup)
            do {
                try FileManager.default.moveItem(atPath: savPath, toPath: backup)
                self?.toast("已删除电池存档，正在重新载入")
                if let last = self?.defaults.string(forKey: "lastRom") {
                    self?.gate.lock()
                    self?.pendingPath = last
                    self?.gate.signal()
                    self?.gate.unlock()
                }
            } catch {
                self?.toast("删除失败")
            }
        })
        confirm.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(confirm)
    }

    @objc private func cycleSlot() {
        slot = slot % 9 + 1
        refreshSlotButton()
    }

    @objc private func resetGame() {
        guard let core, mgbaMobileIsLoaded(core), defaults.bool(forKey: "confirm_close") else {
            postCommand(cmdReset)
            return
        }
        let confirm = UIAlertController(title: "复位", message: "确定要重置这个游戏吗？未保存的进度会丢失。", preferredStyle: .alert)
        confirm.addAction(UIAlertAction(title: "确定", style: .default) { [weak self] _ in
            guard let self else { return }
            self.postCommand(self.cmdReset)
        })
        confirm.addAction(UIAlertAction(title: "取消", style: .cancel))
        presentSheet(confirm)
    }

    @objc private func saveState() { chooseSlot(save: true) }
    @objc private func loadState() { chooseSlot(save: false) }

    private func postCommand(_ cmd: Int) {
        gate.lock()
        command = cmd
        gate.signal()
        gate.unlock()
    }

    private func stateURL(_ index: Int) -> URL {
        let rom = currentRomPath ?? defaults.string(forKey: "lastRom") ?? "game"
        let base = URL(fileURLWithPath: rom).deletingPathExtension().lastPathComponent
        let dir = activeStateDir ?? docs.appendingPathComponent("states", isDirectory: true)
        return dir.appendingPathComponent("\(base).ss\(index)")
    }

    private func refreshSlotButton() {
        let file = stateURL(slot)
        let filled = FileManager.default.fileExists(atPath: file.path) && ((try? FileManager.default.attributesOfItem(atPath: file.path)[.size] as? NSNumber)?.int64Value ?? 0) > 0
        slotButton.setTitle(filled ? "槽位 \(slot) ●" : "槽位 \(slot)", for: .normal)
    }

    private func chooseSlot(save: Bool) {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        if save, let now = gameView.copyLast() {
            box.addArrangedSubview(slotRow("当前画面（存档前）", now, tag: 0))
        }
        let formatter = DateFormatter()
        formatter.dateFormat = "M月d日 HH:mm"
        for i in 1...9 {
            let file = stateURL(i)
            let filled = FileManager.default.fileExists(atPath: file.path)
            let when = filled ? formatter.string(from: (try? FileManager.default.attributesOfItem(atPath: file.path)[.modificationDate] as? Date) ?? Date()) : "空"
            let preview = filled ? UIImage(contentsOfFile: file.appendingPathExtension("png").path) ?? UIImage(contentsOfFile: file.path) : nil
            var label = "槽位 \(i)　\(when)"
            if filled && preview == nil { label += "　无画面" }
            box.addArrangedSubview(slotRow(label, preview, tag: i))
        }
        let sheet = SheetController(title: save ? "保存到哪个槽位" : "读取哪个槽位", content: box)
        for case let button as UIButton in box.arrangedSubviews {
            button.addAction(UIAction { [weak self, weak sheet] _ in
                guard let self, let tag = button.tag as Int?, tag > 0 else { return }
                if !save && !FileManager.default.fileExists(atPath: self.stateURL(tag).path) {
                    self.toast("没有即时存档 \(tag)")
                    return
                }
                self.slot = tag
                self.refreshSlotButton()
                if save, let frame = self.gameView.copyLast() {
                    self.gate.lock()
                    self.pendingPreview = frame
                    self.gate.unlock()
                }
                self.postCommand(save ? self.cmdSave : self.cmdLoad)
                sheet?.dismiss(animated: true)
            }, for: .touchUpInside)
        }
        presentSheet(sheet)
    }

    private func slotRow(_ label: String, _ image: UIImage?, tag: Int) -> UIButton {
        let button = UIButton(type: .system)
        button.tag = tag
        button.contentHorizontalAlignment = .left
        button.setTitle("  " + label, for: .normal)
        button.setTitleColor(.darkText, for: .normal)
        button.setImage(image, for: .normal)
        button.imageView?.contentMode = .scaleAspectFit
        button.heightAnchor.constraint(equalToConstant: 84).isActive = true
        if tag == 0 { button.isEnabled = false }
        return button
    }

    private func writePreview(_ index: Int) {
        gate.lock()
        let pending = pendingPreview
        pendingPreview = nil
        gate.unlock()
        guard let image = pending ?? gameView.copyLast(), let data = image.pngData() else { return }
        try? data.write(to: stateURL(index).appendingPathExtension("png"))
    }

    private func showSaveLocation() {
        guard let core else { return }
        var path = [CChar](repeating: 0, count: 1200)
        mgbaMobileSaveFile(core, &path, 1200)
        let text = filesPath(String(cString: path))
        if text.isEmpty {
            savePathWanted = false
            updateMenuLayout()
            return
        }
        savePathWanted = true
        savePathView.text = "ROM 存档位置：\(text)"
        savePathView.accessibilityValue = text
        updateMenuLayout()
        toast(savePathView.text ?? "")
    }

    @objc private func copySavePath() {
        let text = savePathView.accessibilityValue ?? ""
        if text.isEmpty { return }
        UIPasteboard.general.string = text
        toast("已复制 ROM 存档位置")
    }

    private func filesPath(_ absolute: String) -> String {
        let root = docs.path
        let prefix = root.hasSuffix("/") ? root : root + "/"
        let label = UIDevice.current.userInterfaceIdiom == .pad ? "我的 iPad" : "我的 iPhone"
        guard absolute.hasPrefix(prefix) else { return absolute }
        let rest = String(absolute.dropFirst(prefix.count))
        return rest.isEmpty ? "\(label)/mGBA" : "\(label)/mGBA/\(rest)"
    }

    private func applyVideo() {
        let blend = defaults.bool(forKey: "vf_blend")
        let linear = defaults.object(forKey: "vf_linear") == nil ? true : defaults.bool(forKey: "vf_linear")
        let aspect = defaults.object(forKey: "vf_aspect") == nil ? true : defaults.bool(forKey: "vf_aspect")
        skipAuto = defaults.bool(forKey: "vf_skip_auto")
        autoSkipLevel = 0
        lateStreak = 0
        if let core {
            mgbaMobileSetInterframe(core, blend)
            mgbaMobileSetFrameskip(core, Int32(skipAuto ? 0 : defaults.integer(forKey: "vf_skip")))
        }
        gameView.bilinear = linear
        gameView.lockAspect = aspect
        gameView.integerScale = defaults.bool(forKey: "vf_integer")
        gameView.scanlines = defaults.bool(forKey: "vf_scan")
        // A per-game filter override outlives a global quality change, so the
        // running game keeps the look the player picked for it.
        gameView.filter = perRomFilter ?? filterPref()
        let bright = defaults.object(forKey: "vf_bright") == nil ? 100 : defaults.integer(forKey: "vf_bright")
        gameView.brightness = bright
        let contrast = defaults.object(forKey: "vf_contrast") == nil ? 100 : defaults.integer(forKey: "vf_contrast")
        gameView.contrast = contrast
    }

    private func filterPref() -> Int {
        let id = defaults.integer(forKey: "vf_filter")
        return id >= 0 && id < Self.filterNames.count ? id : 0
    }

    @objc private func showVideo() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let blend = labeledSwitch("帧间混合", defaults.bool(forKey: "vf_blend"))
        let linear = labeledSwitch("双线性过滤", defaults.object(forKey: "vf_linear") == nil ? true : defaults.bool(forKey: "vf_linear"))
        let aspect = labeledSwitch("锁定宽高比", defaults.object(forKey: "vf_aspect") == nil ? true : defaults.bool(forKey: "vf_aspect"))
        let integer = labeledSwitch("整数缩放", defaults.bool(forKey: "vf_integer"))
        let scan = labeledSwitch("扫描线", defaults.bool(forKey: "vf_scan"))
        let filterRow = UIButton(type: .system)
        filterRow.contentHorizontalAlignment = .left
        filterRow.setTitle("滤镜：\(Self.filterNames[filterPref()])", for: .normal)
        filterRow.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.pickOption(title: "画面滤镜", current: self.filterPref(), options: Self.filterNames) { [weak self] index in
                guard let self else { return }
                self.defaults.set(index, forKey: "vf_filter")
                filterRow.setTitle("滤镜：\(Self.filterNames[self.filterPref()])", for: .normal)
                self.applyVideo()
            }
        }, for: .touchUpInside)
        let sceneRow = UIButton(type: .system)
        sceneRow.contentHorizontalAlignment = .left
        let sceneScale = defaults.integer(forKey: "scene_scale") == 0 ? 100 : defaults.integer(forKey: "scene_scale")
        sceneRow.setTitle("画面场景（移动/缩放画面，当前缩放 \(sceneScale)%）", for: .normal)
        sceneRow.addAction(UIAction { [weak self] _ in self?.showSceneDialog() }, for: .touchUpInside)
        let shaderRow = UIButton(type: .system)
        shaderRow.contentHorizontalAlignment = .left
        shaderRow.setTitle("外部渲染器：\(ExternalShader.current ?? "无")", for: .normal)
        shaderRow.addAction(UIAction { [weak self] _ in self?.showShaderDialog() }, for: .touchUpInside)
        let autoSkip = labeledSwitch("自动跳帧（跟不上时自动跳帧保速度）", defaults.bool(forKey: "vf_skip_auto"))
        let skip = slider(max: 5, value: Float(defaults.integer(forKey: "vf_skip")))
        let bright = slider(max: 100, value: Float((defaults.object(forKey: "vf_bright") == nil ? 100 : defaults.integer(forKey: "vf_bright")) - 50))
        let contrast = slider(max: 100, value: Float((defaults.object(forKey: "vf_contrast") == nil ? 100 : defaults.integer(forKey: "vf_contrast")) - 50))
        let skipLabel = UILabel()
        let brightLabel = UILabel()
        let contrastLabel = UILabel()
        func refresh() {
            skipLabel.text = "跳帧 \(Int(skip.value))"
            brightLabel.text = "亮度 \(Int(bright.value) + 50)%"
            contrastLabel.text = "对比度 \(Int(contrast.value) + 50)%"
            defaults.set(blend.1.isOn, forKey: "vf_blend")
            defaults.set(linear.1.isOn, forKey: "vf_linear")
            defaults.set(aspect.1.isOn, forKey: "vf_aspect")
            defaults.set(integer.1.isOn, forKey: "vf_integer")
            defaults.set(scan.1.isOn, forKey: "vf_scan")
            defaults.set(Int(skip.value), forKey: "vf_skip")
            defaults.set(Int(bright.value) + 50, forKey: "vf_bright")
            defaults.set(Int(contrast.value) + 50, forKey: "vf_contrast")
            applyVideo()
        }
        for item in [blend, linear, aspect, integer, scan] {
            item.1.addAction(UIAction { _ in refresh() }, for: .valueChanged)
            box.addArrangedSubview(item.0)
        }
        box.addArrangedSubview(filterRow)
        box.addArrangedSubview(sceneRow)
        box.addArrangedSubview(shaderRow)
        box.addArrangedSubview(autoSkip.0)
        box.addArrangedSubview(skipLabel)
        box.addArrangedSubview(skip)
        box.addArrangedSubview(brightLabel)
        box.addArrangedSubview(bright)
        box.addArrangedSubview(contrastLabel)
        box.addArrangedSubview(contrast)
        // The manual level is meaningless while auto frameskip owns it.
        skip.isEnabled = !autoSkip.1.isOn
        skipLabel.isEnabled = !autoSkip.1.isOn
        autoSkip.1.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(autoSkip.1.isOn, forKey: "vf_skip_auto")
            skip.isEnabled = !autoSkip.1.isOn
            skipLabel.isEnabled = !autoSkip.1.isOn
            self.applyVideo()
        }, for: .valueChanged)
        skip.addAction(UIAction { _ in refresh() }, for: .valueChanged)
        bright.addAction(UIAction { _ in refresh() }, for: .valueChanged)
        contrast.addAction(UIAction { _ in refresh() }, for: .valueChanged)
        refresh()
        presentSheet(SheetController(title: "画质", content: box))
    }

    /** A single-choice picker sheet; the result lands through `handler`. */
    private func pickOption(title: String, current: Int, options: [String], handler: @escaping (Int) -> Void) {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 4
        for (index, name) in options.enumerated() {
            let button = UIButton(type: .system)
            button.contentHorizontalAlignment = .left
            button.setTitle(index == current ? "✓ \(name)" : "    \(name)", for: .normal)
            button.addAction(UIAction { [weak self] _ in
                self?.topmostPresenter.dismiss(animated: true)
                handler(index)
            }, for: .touchUpInside)
            box.addArrangedSubview(button)
        }
        presentSheet(SheetController(title: title, content: box))
    }

    /// 调试工具：内存查看 / 数值搜索 / BG / OAM / 调色板
    @objc private func showDebugTools() {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        DebugViewers.showHub(core: core, presenter: topmostPresenter)
    }

    /// WebDAV 云同步的账号设置。
    private func showWebDavSettings() {
        let config = WebDavSync.Config.load(defaults)
        let alert = UIAlertController(title: "云同步设置（WebDAV）",
                                       message: "只同步电池存档（.sav），即时存档留在本机。",
                                       preferredStyle: .alert)
        alert.addTextField { field in
            field.placeholder = "同步地址，例如 https://dav.jianguoyun.com/dav/"
            field.text = config.url
            field.autocapitalizationType = .none
            field.keyboardType = .URL
        }
        alert.addTextField { field in
            field.placeholder = "目录，例如 mGBAx"
            field.text = config.dir
            field.autocapitalizationType = .none
        }
        alert.addTextField { field in
            field.placeholder = "账号"
            field.text = config.user
            field.autocapitalizationType = .none
        }
        alert.addTextField { field in
            field.placeholder = "密码"
            field.text = config.pass
            field.isSecureTextEntry = true
        }
        alert.addAction(UIAlertAction(title: "取消", style: .cancel))
        alert.addAction(UIAlertAction(title: "保存", style: .default) { [weak self] _ in
            guard let self else { return }
            var updated = WebDavSync.Config()
            updated.url = alert.textFields?[0].text?.trimmingCharacters(in: .whitespaces)
                ?? WebDavSync.defaultURL
            updated.dir = alert.textFields?[1].text?.trimmingCharacters(in: .whitespaces)
                ?? WebDavSync.defaultDir
            updated.user = alert.textFields?[2].text?.trimmingCharacters(in: .whitespaces) ?? ""
            updated.pass = alert.textFields?[3].text ?? ""
            updated.store(self.defaults)
            self.toast("已保存云同步设置")
        })
        presentSheet(alert)
    }

    /// 把电池存档和 WebDAV 双向同步一次。
    private func runWebDavSync(quiet: Bool = false) {
        let config = WebDavSync.Config.load(defaults)
        guard config.isComplete else {
            if !quiet {
                toast("请先填写云同步设置")
            }
            return
        }
        let saves = docs.appendingPathComponent("saves", isDirectory: true)
        if !quiet {
            toast("正在同步…")
        }
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            var message = ""
            do {
                let summary = try WebDavSync.run(saves: saves, config: config)
                message = "同步完成：\(summary.text)"
                if !summary.errors.isEmpty {
                    message += "\n失败：\(summary.errors.joined(separator: "、"))"
                }
            } catch {
                message = "同步失败：\(error.localizedDescription)"
            }
            DispatchQueue.main.async {
                if !quiet {
                    self?.toast(message)
                }
            }
        }
    }

    /// 外部渲染器：安装 / 选择 / 清除用户自己的着色器。
    private func showShaderDialog() {
        let alert = UIAlertController(title: "外部渲染器",
                                       message: "支持单采样的 GLSL（.glsl）与 Metal（.metal）片元着色器。\n"
                                        + "GLSL 里的 uTex / uTexSize / uOutSize / uBrightness / vTexCoord 会自动映射。",
                                       preferredStyle: .actionSheet)
        alert.addAction(UIAlertAction(title: "安装渲染器（.glsl/.metal）", style: .default) { [weak self] _ in
            guard let self else { return }
            self.pickerKind = 10
            let picker = UIDocumentPickerViewController(forOpeningContentTypes: [.data], asCopy: true)
            picker.delegate = self
            self.presentSheet(picker)
        })
        for name in ExternalShader.installed {
            let mark = name == ExternalShader.current ? "✓ " : ""
            alert.addAction(UIAlertAction(title: mark + name, style: .default) { [weak self] _ in
                guard let self else { return }
                do {
                    try ExternalShader.select(name)
                    self.defaults.set(ExternalShader.filterId, forKey: "vf_filter")
                    self.applyVideo()
                    self.toast("已选择渲染器 \(name)")
                } catch {
                    self.toast(error.localizedDescription)
                }
            })
        }
        if ExternalShader.current != nil {
            alert.addAction(UIAlertAction(title: "清除外部渲染器", style: .destructive) { [weak self] _ in
                guard let self else { return }
                ExternalShader.clear()
                self.defaults.set(0, forKey: "vf_filter")
                self.applyVideo()
                self.toast("已清除外部渲染器")
            })
        }
        alert.addAction(UIAlertAction(title: "关闭", style: .cancel))
        if let popover = alert.popoverPresentationController {
            popover.sourceView = view
            popover.sourceRect = CGRect(x: view.bounds.midX, y: view.bounds.midY, width: 0, height: 0)
        }
        presentSheet(alert)
    }

    /// Installs a shader the user picked and switches to it.
    private func installShader(_ url: URL) {
        do {
            let name = try ExternalShader.install(from: url)
            defaults.set(ExternalShader.filterId, forKey: "vf_filter")
            applyVideo()
            toast("已安装渲染器 \(name)")
        } catch {
            toast("安装失败：\(error.localizedDescription)")
        }
    }

    /// 阳光来源：屏幕亮度（iOS 没有环境光传感器，用屏幕亮度近似）。
    private var solarSourceIsScreen: Bool {
        defaults.string(forKey: "solar_source") == "screen"
    }

    private func currentScreenSolarLevel() -> Int {
        min(9, max(0, Int(UIScreen.main.brightness * 10)))
    }

    /// 每秒按屏幕亮度更新一次阳光强度。
    private func updateSolarTimer() {
        solarTimer?.invalidate()
        solarTimer = nil
        guard defaults.bool(forKey: "solar_on"), solarSourceIsScreen else {
            return
        }
        let timer = Timer(timeInterval: 1.0, repeats: true) { [weak self] _ in
            guard let self, let core = self.core, mgbaMobileIsLoaded(core) else { return }
            mgbaMobileSetSolar(core, Int32(self.currentScreenSolarLevel()))
        }
        RunLoop.main.add(timer, forMode: .common)
        solarTimer = timer
    }

    /// 画面场景编辑器：自由移动/缩放游戏画面（悠GBA 的画面场景移植）。
    private func showSceneDialog() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        let xLabel = UILabel()
        let yLabel = UILabel()
        let scaleLabel = UILabel()
        let xBar = slider(max: 200, value: Float(defaults.integer(forKey: "scene_x") + 100))
        let yBar = slider(max: 200, value: Float(defaults.integer(forKey: "scene_y") + 100))
        let stored = defaults.integer(forKey: "scene_scale")
        let scaleBar = slider(max: 375, value: Float((stored == 0 ? 100 : stored) - 25))

        func refresh() {
            let x = Int(xBar.value) - 100
            let y = Int(yBar.value) - 100
            let scale = Int(scaleBar.value) + 25
            xLabel.text = "水平位置 \(x)"
            yLabel.text = "垂直位置 \(y)"
            scaleLabel.text = "缩放 \(scale)%"
            defaults.set(x, forKey: "scene_x")
            defaults.set(y, forKey: "scene_y")
            defaults.set(scale, forKey: "scene_scale")
            applyVideoScene()
        }
        for bar in [xBar, yBar, scaleBar] {
            bar.addAction(UIAction { _ in refresh() }, for: .valueChanged)
        }
        let reset = UIButton(type: .system)
        reset.setTitle("重置", for: .normal)
        reset.addAction(UIAction { _ in
            xBar.value = 100
            yBar.value = 100
            scaleBar.value = 75
            refresh()
        }, for: .touchUpInside)
        box.addArrangedSubview(xLabel)
        box.addArrangedSubview(xBar)
        box.addArrangedSubview(yLabel)
        box.addArrangedSubview(yBar)
        box.addArrangedSubview(scaleLabel)
        box.addArrangedSubview(scaleBar)
        box.addArrangedSubview(reset)
        refresh()
        presentSheet(SheetController(title: "画面场景", content: box))
    }

    /// Applies the scene transform (pan and zoom) to the game view.
    private func applyVideoScene() {
        let x = CGFloat(defaults.integer(forKey: "scene_x"))
        let y = CGFloat(defaults.integer(forKey: "scene_y"))
        let stored = defaults.integer(forKey: "scene_scale")
        let scale = CGFloat(stored == 0 ? 100 : stored) / 100.0
        gameView.layer.anchorPoint = CGPoint(x: 0.5, y: 0.5)
        gameView.transform = CGAffineTransform(translationX: gameView.bounds.width * x / 100.0,
                                                y: gameView.bounds.height * y / 100.0)
            .scaledBy(x: scale, y: scale)
    }

    @objc private func showLink() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        let help = UILabel()
        help.numberOfLines = 0
        help.text = "两边打开同一个游戏，保持 1 倍速，不要暂停。创建方是 1P。\n局域网：一边创建，另一边填写对方 IP 后加入。\n互联网：两边填写同一个中继地址。一边点远程创建，把房间号给对方。中继留空时由本机充当，只在对方能访问这个 IP 时可用。"
        let host = field(defaults.string(forKey: "link_host") ?? "", "对方 IP，例如 192.168.1.8")
        let port = field(String(defaults.object(forKey: "link_port") == nil ? 8765 : defaults.integer(forKey: "link_port")), nil)
        port.keyboardType = .numberPad
        let relay = field(defaults.string(forKey: "link_relay") ?? "", "中继地址，例如 1.2.3.4:8766，留空则本机当中继")
        let room = field(defaults.string(forKey: "link_room") ?? "", "房间号")
        linkRoomField = room
        let status = UILabel()
        status.numberOfLines = 0
        status.textColor = UIColor(red: 27 / 255, green: 94 / 255, blue: 32 / 255, alpha: 1)
        status.text = linkMessage()
        linkStatusLabel = status
        box.addArrangedSubview(help)
        box.addArrangedSubview(host)
        box.addArrangedSubview(port)
        box.addArrangedSubview(row(linkButton("局域网创建") { [weak self] in
            guard let self else { return }
            let p = Int32(port.text ?? "") ?? -1
            if p < 1 || p > 65535 {
                status.text = "端口无效"
                return
            }
            self.remote?.close()
            if let core = self.core, mgbaMobileLinkHost(core, p) {
                self.defaults.set(Int(p), forKey: "link_port")
                status.text = "等待连接\n本机 \(self.localIpv4()):\(p)\n你是 1P"
                self.startLinkWatch()
            } else {
                status.text = self.linkMessage()
            }
        }, linkButton("局域网加入") { [weak self] in
            guard let self else { return }
            let ip = host.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let p = Int32(port.text ?? "") ?? -1
            if ip.isEmpty || p < 1 || p > 65535 {
                status.text = "端口无效"
                return
            }
            self.remote?.close()
            self.defaults.set(ip, forKey: "link_host")
            self.defaults.set(Int(p), forKey: "link_port")
            if let core = self.core {
                _ = mgbaMobileLinkJoin(core, ip, p)
            }
            status.text = self.linkMessage()
            self.startLinkWatch()
        }))
        box.addArrangedSubview(relay)
        box.addArrangedSubview(room)
        box.addArrangedSubview(row(linkButton("远程创建") { [weak self] in
            guard let self else { return }
            let text = relay.text?.trimmingCharacters(in: .whitespaces) ?? ""
            self.defaults.set(text, forKey: "link_relay")
            self.ensureRemote().create(relayField: text, localIp: self.localIpv4())
            self.startLinkWatch()
        }, linkButton("远程加入") { [weak self] in
            guard let self else { return }
            let text = relay.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let code = room.text?.trimmingCharacters(in: .whitespaces) ?? ""
            self.defaults.set(text, forKey: "link_relay")
            self.defaults.set(code, forKey: "link_room")
            self.ensureRemote().join(relayField: text, code: code)
            self.startLinkWatch()
        }))
        // ---- GBoy（My Boy）联机大厅 ----
        let gboyHelp = UILabel()
        gboyHelp.numberOfLines = 0
        gboyHelp.font = .systemFont(ofSize: 12)
        gboyHelp.textColor = UIColor(white: 0.25, alpha: 1)
        gboyHelp.text = "联机大厅：和对方联机对战。两边打开同一个游戏，保持 1 倍速，不要暂停。创房一方是 1P，另一方填对方 IP 加入。端口默认 6374，与其他模拟器的 Wi-Fi 联机互通。"
        let gboyIp = field(defaults.string(forKey: "gboy_ip") ?? "", "对方（或本机）IP，例如 192.168.1.8")
        let gboyPort = field(String(defaults.object(forKey: "gboy_port") == nil ? GBoyLink.defaultPort : defaults.integer(forKey: "gboy_port")), nil)
        gboyPort.keyboardType = .numberPad
        box.addArrangedSubview(gboyHelp)
        box.addArrangedSubview(gboyIp)
        box.addArrangedSubview(gboyPort)
        box.addArrangedSubview(row(linkButton("大厅创建") { [weak self] in
            guard let self else { return }
            let p = Int32(gboyPort.text ?? "") ?? -1
            if p < 1 || p > 65535 {
                status.text = "端口无效"
                return
            }
            guard let core = self.core, mgbaMobileIsLoaded(core) else {
                status.text = "请先打开一个游戏再联机"
                return
            }
            self.defaults.set(Int(p), forKey: "gboy_port")
            self.ensureGboy().host(Int(p))
        }, linkButton("大厅加入") { [weak self] in
            guard let self else { return }
            let ip = gboyIp.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let p = Int32(gboyPort.text ?? "") ?? -1
            if ip.isEmpty || p < 1 || p > 65535 {
                status.text = "端口无效"
                return
            }
            guard let core = self.core, mgbaMobileIsLoaded(core) else {
                status.text = "请先打开一个游戏再联机"
                return
            }
            self.defaults.set(ip, forKey: "gboy_ip")
            self.defaults.set(Int(p), forKey: "gboy_port")
            self.ensureGboy().join(ip, Int(p))
        }))
        // ---- 云端联机大厅（房号匹配，中继地址自动获取） ----
        let lobbyHelp = UILabel()
        lobbyHelp.numberOfLines = 0
        lobbyHelp.font = .systemFont(ofSize: 12)
        lobbyHelp.textColor = UIColor(white: 0.25, alpha: 1)
        lobbyHelp.text = "云端联机：两边打开同一个游戏，保持 1 倍速，不要暂停。\n创建方点「云端创建」拿到房号，把房号发给对方；对方填房号点「云端加入」，中继地址会自动获取，不用手填。\n已注册账号直接填原密码即可，不会收到任何邮件；新账号先「获取验证码」再「注册」。"
        let lobbyEmail = field(defaults.string(forKey: "lobby_email") ?? "", "邮箱")
        let lobbyPassword = field(defaults.string(forKey: "lobby_password") ?? "", "密码（老账号填原密码）")
        lobbyPassword.isSecureTextEntry = true
        let lobbyCode = field(defaults.string(forKey: "lobby_code") ?? "", "邮箱验证码（新账号注册用）")
        let lobbyRoom = field(defaults.string(forKey: "lobby_room") ?? "", "房号（加入时填对方房号）")
        box.addArrangedSubview(lobbyHelp)
        box.addArrangedSubview(lobbyEmail)
        box.addArrangedSubview(lobbyPassword)
        box.addArrangedSubview(lobbyCode)
        box.addArrangedSubview(lobbyRoom)
        box.addArrangedSubview(row(linkButton("获取验证码") { [weak self] in
            guard let self else { return }
            let email = lobbyEmail.text?.trimmingCharacters(in: .whitespaces) ?? ""
            guard !email.isEmpty else {
                status.text = "请先填写邮箱"
                return
            }
            status.text = "正在发送验证码…"
            DispatchQueue.global(qos: .userInitiated).async {
                let reply = try? LobbySignaling.sendVerificationCodeSync(email: email)
                DispatchQueue.main.async {
                    status.text = reply ?? "验证码发送失败"
                }
            }
        }, linkButton("注册") { [weak self] in
            guard let self else { return }
            let email = lobbyEmail.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let password = lobbyPassword.text ?? ""
            let code = lobbyCode.text?.trimmingCharacters(in: .whitespaces) ?? ""
            guard !email.isEmpty, !password.isEmpty, !code.isEmpty else {
                status.text = "注册需要邮箱、密码和验证码"
                return
            }
            status.text = "正在注册…"
            DispatchQueue.global(qos: .userInitiated).async {
                let name = self.lobbyUserName(from: email)
                let token = try? LobbySignaling.registerSync(username: name, email: email,
                                                             password: password, code: code)
                DispatchQueue.main.async {
                    guard let token else {
                        status.text = "注册失败，请检查验证码"
                        return
                    }
                    self.defaults.set(email, forKey: "lobby_email")
                    self.defaults.set(password, forKey: "lobby_password")
                    status.text = "注册成功，正在创建房间…"
                    self.ensureLobby().start(user: email, password: password, roomId: "", token: token)
                }
            }
        }))
        box.addArrangedSubview(row(linkButton("云端创建") { [weak self] in
            guard let self else { return }
            let email = lobbyEmail.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let password = lobbyPassword.text ?? ""
            guard !email.isEmpty else {
                status.text = "请填写邮箱"
                return
            }
            guard let core = self.core, mgbaMobileIsLoaded(core) else {
                status.text = "请先打开一个游戏再联机"
                return
            }
            self.defaults.set(email, forKey: "lobby_email")
            self.defaults.set(password, forKey: "lobby_password")
            self.ensureLobby().start(user: email, password: password, roomId: "")
        }, linkButton("云端加入") { [weak self] in
            guard let self else { return }
            let email = lobbyEmail.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let password = lobbyPassword.text ?? ""
            let code = lobbyRoom.text?.trimmingCharacters(in: .whitespaces) ?? ""
            guard !email.isEmpty else {
                status.text = "请填写邮箱"
                return
            }
            guard !code.isEmpty else {
                status.text = "请填写对方房号"
                return
            }
            guard let core = self.core, mgbaMobileIsLoaded(core) else {
                status.text = "请先打开一个游戏再联机"
                return
            }
            self.defaults.set(email, forKey: "lobby_email")
            self.defaults.set(password, forKey: "lobby_password")
            self.defaults.set(code, forKey: "lobby_room")
            self.ensureLobby().start(user: email, password: password, roomId: code)
        }))
        box.addArrangedSubview(linkButton("联机自检") { [weak self] in
            guard let self else { return }
            let email = lobbyEmail.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let password = lobbyPassword.text ?? ""
            guard !email.isEmpty else {
                status.text = "请填写邮箱"
                return
            }
            self.defaults.set(email, forKey: "lobby_email")
            self.defaults.set(password, forKey: "lobby_password")
            self.ensureLobby().selfTest(user: email, password: password)
        })
        box.addArrangedSubview(linkButton("重新连接中继") { [weak self] in
            guard let self else { return }
            // 不重建房间，直接重新解析中继节点并重连数据通道
            self.ensureLobby().reconnectRelay()
        })
        box.addArrangedSubview(linkButton("断开") { [weak self] in
            guard let self else { return }
            if let remote = self.remote {
                remote.close()
            } else if let core = self.core {
                mgbaMobileLinkClose(core)
            }
            if let gboy = self.gboyLink {
                gboy.close()
            }
            if let lobby = self.lobbyLink {
                lobby.close()
            }
            self.gboyRemoteKeys = 0
            // Mirror the Android disconnect path: republish the (now empty)
            // key mask so the last remote peer's buttons don't linger on the
            // core until the next local key event.
            self.publishKeys()
            self.linkWatch?.cancel()
            self.lastLinkState = 0
            status.text = "断开"
        })
        box.addArrangedSubview(status)
        presentSheet(SheetController(title: "联机", content: box))
    }

    private func ensureRemote() -> RemoteLink {
        if let remote { return remote }
        let link = RemoteLink()
        link.onStatus = { [weak self] text in self?.linkStatusLabel?.text = text }
        link.onRoom = { [weak self] code, advertise in
            guard let self else { return }
            self.linkRoomField?.text = code
            self.defaults.set(code, forKey: "link_room")
            UIPasteboard.general.string = code
            self.toast("房间号 \(code) 已复制\n对方中继填 \(advertise)")
        }
        link.hostLink = { [weak self] port in
            guard let self, let core = self.core else { return false }
            return mgbaMobileLinkHost(core, port)
        }
        link.joinLink = { [weak self] host, port in
            guard let self, let core = self.core else { return false }
            return mgbaMobileLinkJoin(core, host, port)
        }
        link.closeLink = { [weak self] in
            if let core = self?.core { mgbaMobileLinkClose(core) }
        }
        remote = link
        return link
    }

    private func ensureGboy() -> GBoyLink {
        if let gboyLink { return gboyLink }
        let link = GBoyLink()
        link.romPath = { [weak self] in self?.defaults.string(forKey: "lastRom") }
        link.localKeys = { [weak self] in
            guard let self else { return 0 }
            return Int32(self.touchKeys | self.hwKeys | self.padKeys)
        }
        link.onRemoteKeys = { [weak self] keys in
            DispatchQueue.main.async {
                guard let self else { return }
                self.gboyRemoteKeys = Int(keys)
                self.publishKeys()
            }
        }
        link.onStatus = { [weak self] text in
            DispatchQueue.main.async {
                self?.linkStatusLabel?.text = text
            }
        }
        link.onRemoteReset = { [weak self] in
            DispatchQueue.main.async {
                guard let self, let core = self.core, mgbaMobileIsLoaded(core) else { return }
                mgbaMobileReset(core)
                mgbaMobileClearAudio(core)
                self.toast("已复位")
            }
        }
        gboyLink = link
        return link
    }

    /// Cloud lobby session: room signalling plus the relay transport.
    private func ensureLobby() -> LobbyLink {
        if let lobbyLink { return lobbyLink }
        let link = LobbyLink()
        link.romPath = { [weak self] in self?.defaults.string(forKey: "lastRom") }
        link.localKeys = { [weak self] in
            guard let self else { return 0 }
            return Int32(self.touchKeys | self.hwKeys | self.padKeys)
        }
        link.onRemoteKeys = { [weak self] keys in
            DispatchQueue.main.async {
                guard let self else { return }
                self.gboyRemoteKeys = Int(keys)
                self.publishKeys()
            }
        }
        link.onStatus = { [weak self] text in
            DispatchQueue.main.async {
                self?.linkStatusLabel?.text = text
            }
        }
        link.onConnected = { [weak self] asHost, note in
            DispatchQueue.main.async {
                guard let self else { return }
                if let note {
                    self.toast(note)
                }
                self.toast(asHost ? "云端联机已连接，你是 1P" : "云端联机已连接，你是 2P")
            }
        }
        link.onRemoteReset = { [weak self] in
            DispatchQueue.main.async {
                guard let self, let core = self.core, mgbaMobileIsLoaded(core) else { return }
                mgbaMobileReset(core)
                mgbaMobileClearAudio(core)
                self.toast("已复位")
            }
        }
        lobbyLink = link
        return link
    }

    /// The lobby server rejects user names longer than ten characters, and the
    /// upstream brand must not show up in the account name either.
    private func lobbyUserName(from email: String) -> String {
        var name = (email as NSString).lastPathComponent
        name = name.replacingOccurrences(of: "gboy", with: "lobby", options: .caseInsensitive)
        for character in [" ", ".", "_", "-"] {
            name = name.replacingOccurrences(of: character, with: "")
        }
        if name.isEmpty {
            name = "player"
        }
        if name.count > 10 {
            name = String(name.prefix(10))
        }
        return name
    }

    private func startLinkWatch() {
        linkWatch?.cancel()
        let work = DispatchWorkItem { [weak self] in self?.watchLink() }
        linkWatch = work
        DispatchQueue.main.async(execute: work)
    }

    private func watchLink() {
        guard let core else { return }
        var text = [CChar](repeating: 0, count: 128)
        mgbaMobileLinkStatus(core, &text, 128)
        let status = String(cString: text)
        let state = Int(status.split(separator: " ").first ?? "0") ?? 0
        if state != lastLinkState && state == 3 { toast(linkMessage(status)) }
        lastLinkState = state
        if state == 1 || state == 2 {
            let work = DispatchWorkItem { [weak self] in self?.watchLink() }
            linkWatch = work
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.7, execute: work)
        }
    }

    private func linkMessage(_ status: String? = nil) -> String {
        var buffer = [CChar](repeating: 0, count: 128)
        let text: String
        if let status {
            text = status
        } else if let core {
            mgbaMobileLinkStatus(core, &buffer, 128)
            text = String(cString: buffer)
        } else {
            text = ""
        }
        let parts = text.split(separator: " ", maxSplits: 2, omittingEmptySubsequences: false)
        return parts.count >= 3 ? String(parts[2]) : text
    }

    private func localIpv4() -> String {
        var pointer: UnsafeMutablePointer<ifaddrs>?
        guard getifaddrs(&pointer) == 0, let first = pointer else { return "0.0.0.0" }
        defer { freeifaddrs(first) }
        var cursor: UnsafeMutablePointer<ifaddrs>? = first
        while let current = cursor {
            if let addr = current.pointee.ifa_addr, addr.pointee.sa_family == UInt8(AF_INET) {
                let flags = Int32(current.pointee.ifa_flags)
                if (flags & IFF_UP) != 0 && (flags & IFF_LOOPBACK) == 0 {
                    var host = [CChar](repeating: 0, count: Int(NI_MAXHOST))
                    if getnameinfo(addr, socklen_t(addr.pointee.sa_len), &host, socklen_t(host.count), nil, 0, NI_NUMERICHOST) == 0 {
                        return String(cString: host)
                    }
                }
            }
            cursor = current.pointee.ifa_next
        }
        return "0.0.0.0"
    }

    @objc private func bindControllers() {
        for controller in GCController.controllers() {
            controller.extendedGamepad?.valueChangedHandler = { [weak self] pad, _ in
                self?.updatePad(pad)
            }
        }
    }

    @objc private func controllerDisconnected() {
        // A controller can walk away with a button held; recompute the pad
        // mask from the controllers that remain so the game does not stay
        // latched on the lost one.
        var mask = 0
        for controller in GCController.controllers() {
            if let pad = controller.extendedGamepad {
                mask |= padMask(pad)
            }
        }
        let prev = padKeys
        padKeys = mask
        noteUserKeys(prevTouch: touchKeys, prevHw: hwKeys, prevPad: prev)
        if (mask & ~prev) != 0 { wakeInput() }
    }

    @objc private func appResignedActive() {
        releaseInput()
        if defaults.bool(forKey: "keep_notice") {
            postRunningNotice()
        }
    }

    /**
     * Keeps the game running while the app is in the background: iOS keeps a
     * process alive when it plays audio in the background mode, and the notice
     * tells the user the game is still going.
     */
    private func setBackgroundRunning(_ on: Bool) {
        defaults.set(on, forKey: "keep_notice")
        if on {
            UNUserNotificationCenter.current().requestAuthorization(options: [.alert, .sound]) { granted, _ in
                if !granted {
                    DispatchQueue.main.async {
                        self.toast("没有通知权限，游戏仍会在后台继续运行")
                    }
                }
            }
            UIApplication.shared.isIdleTimerDisabled = true
        } else {
            UIApplication.shared.isIdleTimerDisabled = false
        }
    }

    /// The "游戏运行中" notice, shown while the game keeps running.
    private func postRunningNotice() {
        let content = UNMutableNotificationContent()
        content.title = "游戏运行中"
        var name = "mGBA"
        if let core, mgbaMobileIsLoaded(core) {
            var title = [CChar](repeating: 0, count: 32)
            mgbaMobileTitle(core, &title, 32)
            let loaded = String(cString: title).trimmingCharacters(in: .whitespaces)
            if !loaded.isEmpty {
                name = loaded
            }
        }
        content.body = "\(name) 正在运行"
        content.sound = nil
        let request = UNNotificationRequest(identifier: "mgba-running", content: content, trigger: nil)
        UNUserNotificationCenter.current().add(request, withCompletionHandler: nil)
    }

    private func padMask(_ pad: GCExtendedGamepad) -> Int {
        var mask = 0
        if pad.buttonA.isPressed { mask |= ControlsView.A }
        if pad.buttonB.isPressed { mask |= ControlsView.B }
        if pad.leftShoulder.isPressed || pad.leftTrigger.isPressed { mask |= ControlsView.l }
        if pad.rightShoulder.isPressed || pad.rightTrigger.isPressed { mask |= ControlsView.r }
        if pad.buttonMenu.isPressed { mask |= ControlsView.start }
        if pad.buttonOptions?.isPressed == true { mask |= ControlsView.select }
        if pad.dpad.up.isPressed { mask |= ControlsView.up }
        if pad.dpad.down.isPressed { mask |= ControlsView.down }
        if pad.dpad.left.isPressed { mask |= ControlsView.left }
        if pad.dpad.right.isPressed { mask |= ControlsView.right }
        return mask
    }

    private func updatePad(_ pad: GCExtendedGamepad) {
        let mask = padMask(pad)
        let prev = padKeys
        padKeys = mask
        noteUserKeys(prevTouch: touchKeys, prevHw: hwKeys, prevPad: prev)
        if (mask & ~prev) != 0 {
            wakeInput()
            maybeOfferKeypadHide()
        }
    }

    /// 检测到实体按键（键盘/手柄）时，询问是否隐藏屏幕上的虚拟按键。
    private func maybeOfferKeypadHide() {
        guard defaults.bool(forKey: "keypad_detect"),
              !defaults.bool(forKey: "vkeypad_hidden"),
              !controls.isHidden,
              !keypadHideAsked else {
            return
        }
        keypadHideAsked = true
        let alert = UIAlertController(title: "检测到实体按键",
                                       message: "要隐藏虚拟按键吗？",
                                       preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "隐藏", style: .default) { [weak self] _ in
            guard let self else { return }
            self.defaults.set(true, forKey: "vkeypad_hidden")
            self.controls.isHidden = true
        })
        alert.addAction(UIAlertAction(title: "保持", style: .cancel))
        presentSheet(alert)
    }

    override func pressesBegan(_ presses: Set<UIPress>, with event: UIPressesEvent?) {
        var handled = false
        for press in presses {
            guard let key = press.key else { continue }
            if key.keyCode == .keyboardTab || key.keyCode == .keyboardSpacebar {
                fastHold = true
                refreshSpeedButtons()
                handled = true
                continue
            }
            let bit = mapKey(key.keyCode)
            if bit == 0 { continue }
            let prev = hwKeys
            hwKeys |= bit
            noteUserKeys(prevTouch: touchKeys, prevHw: prev, prevPad: padKeys)
            maybeOfferKeypadHide()
            if (bit & ~prev) != 0 { wakeInput() }
            handled = true
        }
        if !handled { super.pressesBegan(presses, with: event) }
    }

    override func pressesEnded(_ presses: Set<UIPress>, with event: UIPressesEvent?) {
        var handled = false
        for press in presses {
            guard let key = press.key else { continue }
            if key.keyCode == .keyboardTab || key.keyCode == .keyboardSpacebar {
                fastHold = false
                refreshSpeedButtons()
                handled = true
                continue
            }
            let bit = mapKey(key.keyCode)
            if bit == 0 { continue }
            let prev = hwKeys
            hwKeys &= ~bit
            noteUserKeys(prevTouch: touchKeys, prevHw: prev, prevPad: padKeys)
            handled = true
        }
        if !handled { super.pressesEnded(presses, with: event) }
    }

    override func pressesCancelled(_ presses: Set<UIPress>, with event: UIPressesEvent?) {
        // A held key can be cut off by a system overlay before its key-up
        // arrives; drop everything so the game cannot come back stuck with A
        // down or at 16x speed with raised audio.
        var handled = false
        for press in presses {
            if press.key != nil { handled = true }
        }
        if handled {
            releaseInput()
        } else {
            super.pressesCancelled(presses, with: event)
        }
    }

    private func mapKey(_ code: UIKeyboardHIDUsage) -> Int {
        switch code {
        case .keyboardUpArrow, .keyboardW: return ControlsView.up
        case .keyboardDownArrow: return ControlsView.down
        case .keyboardLeftArrow: return ControlsView.left
        case .keyboardRightArrow: return ControlsView.right
        case .keyboardA: return ControlsView.l
        case .keyboardX: return ControlsView.A
        case .keyboardZ: return ControlsView.B
        case .keyboardS: return ControlsView.r
        case .keyboardReturnOrEnter: return ControlsView.start
        case .keyboardDeleteOrBackspace, .keyboardLeftShift, .keyboardRightShift: return ControlsView.select
        default: return 0
        }
    }

    private func labeledSwitch(_ title: String, _ on: Bool) -> (UIStackView, UISwitch) {
        let label = UILabel()
        label.text = title
        let toggle = UISwitch()
        toggle.isOn = on
        let row = UIStackView(arrangedSubviews: [label, toggle])
        row.axis = .horizontal
        row.distribution = .equalSpacing
        return (row, toggle)
    }

    private func slider(max: Float, value: Float) -> UISlider {
        let slider = UISlider()
        slider.minimumValue = 0
        slider.maximumValue = max
        slider.value = value
        return slider
    }

    private func field(_ text: String, _ placeholder: String?) -> UITextField {
        let field = UITextField()
        field.text = text
        field.placeholder = placeholder
        field.borderStyle = .roundedRect
        field.autocapitalizationType = .none
        field.autocorrectionType = .no
        field.heightAnchor.constraint(equalToConstant: 36).isActive = true
        return field
    }

    private func linkButton(_ title: String, _ action: @escaping () -> Void) -> UIButton {
        let button = UIButton(type: .system)
        button.setTitle(title, for: .normal)
        button.addAction(UIAction { _ in action() }, for: .touchUpInside)
        return button
    }

    private func row(_ left: UIView, _ right: UIView) -> UIStackView {
        let row = UIStackView(arrangedSubviews: [left, right])
        row.axis = .horizontal
        row.distribution = .fillEqually
        return row
    }

    /// Topmost controller that can still present: the deepest sheet in the
    /// chain. Dismissing controllers are skipped so a picker that just closed
    /// does not swallow the next dialog.
    private var topmostPresenter: UIViewController {
        var host: UIViewController = self
        while let next = host.presentedViewController, !next.isBeingDismissed {
            host = next
        }
        return host
    }

    /// Presents above every open sheet. While an alert or picker is still
    /// animating away the call retries briefly instead of dropping the sheet
    /// ("already presenting").
    private func presentSheet(_ controller: UIViewController, completion: (() -> Void)? = nil) {
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            let host = self.topmostPresenter
            if host.presentedViewController != nil || host.isBeingDismissed {
                DispatchQueue.main.asyncAfter(deadline: .now() + 0.2) {
                    self.presentSheet(controller, completion: completion)
                }
                return
            }
            host.present(controller, animated: true, completion: completion)
        }
    }

    private func toast(_ message: String) {
        DispatchQueue.main.async {
            let alert = UIAlertController(title: nil, message: message, preferredStyle: .alert)
            // Dismiss only once the alert is on screen: presentSheet may wait
            // for another sheet to close, and an earlier timer used to fire
            // first and leave the alert up for good.
            self.presentSheet(alert) {
                DispatchQueue.main.asyncAfter(deadline: .now() + 1.8) {
                    alert.dismiss(animated: true)
                }
            }
        }
    }

    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        gate.lock()
        paused = true
        gate.unlock()
        // Do not stay held at 16x (raised pitch) or with A/B latched when the
        // key-up never arrives because the screen went away under a held key.
        releaseInput()
        // 后台运行开着时音频不能停，否则 iOS 会挂起进程。
        if !defaults.bool(forKey: "keep_notice") {
            audio.setPaused(true)
        }
        // 退出时自动存档 into the reserved slot.
        if defaults.bool(forKey: "auto_save_state"), let core, mgbaMobileIsLoaded(core) {
            if mgbaMobileSaveState(core, Int32(Self.autoSlot)) {
                writePreview(Self.autoSlot)
            }
        }
    }

    deinit {
        running = false
        wakeInput()
        stopped.wait()
        remote?.close()
        gboyLink?.close()
        audio.stop()
        if let core { mgbaMobileDestroy(core) }
    }
}

private final class SheetController: UIViewController {
    private let body: UIView
    private let heading: String

    init(title: String, content: UIView) {
        heading = title
        body = content
        super.init(nibName: nil, bundle: nil)
        modalPresentationStyle = .pageSheet
    }

    required init?(coder: NSCoder) { nil }

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        let titleLabel = UILabel()
        titleLabel.text = heading
        titleLabel.font = .boldSystemFont(ofSize: 18)
        let scroll = UIScrollView()
        let close = UIButton(type: .system)
        close.setTitle("关闭", for: .normal)
        close.addAction(UIAction { [weak self] _ in self?.dismiss(animated: true) }, for: .touchUpInside)
        for item in [titleLabel, scroll, close, body] {
            item.translatesAutoresizingMaskIntoConstraints = false
        }
        view.addSubview(titleLabel)
        view.addSubview(close)
        view.addSubview(scroll)
        scroll.addSubview(body)
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 16),
            titleLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 16),
            close.centerYAnchor.constraint(equalTo: titleLabel.centerYAnchor),
            close.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -16),
            scroll.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 12),
            scroll.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            scroll.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            scroll.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            body.topAnchor.constraint(equalTo: scroll.topAnchor, constant: 8),
            body.leadingAnchor.constraint(equalTo: scroll.leadingAnchor, constant: 16),
            body.trailingAnchor.constraint(equalTo: scroll.trailingAnchor, constant: -16),
            body.bottomAnchor.constraint(equalTo: scroll.bottomAnchor, constant: -16),
            body.widthAnchor.constraint(equalTo: scroll.widthAnchor, constant: -32)
        ])
    }
}
