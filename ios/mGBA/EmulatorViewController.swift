import CoreMotion
import Darwin
import GameController
import Photos
import UIKit
import UniformTypeIdentifiers

final class EmulatorViewController: UIViewController, UIDocumentPickerDelegate {
    private let defaults = UserDefaults.standard
    private let docs = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)[0]
    private var core: OpaquePointer?
    private let gameView = GameView()
    private let controls = ControlsView()
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
    private var gifButton: UIButton?
    private var gifQueue: GifFrameQueue?
    private var lastGifAt: UInt64 = 0
    private var gifFrames = 0
    /** A filtered frame capture was requested; done in the main present block. */
    private var gifWantCapture = false
    /** Fractional speeds (slow motion) accumulate whole frames in this debt. */
    private var frameDebt: Double = 0
    private var lastAudioSpeed: Double = 0
    private var armWork: DispatchWorkItem?
    private var pulseWork: DispatchWorkItem?
    private var linkWatch: DispatchWorkItem?
    private var pickerKind = 0
    private let cmdSave = 1
    private let cmdLoad = 2
    private let cmdReset = 3
    private let cmdAutoSave = 4
    private let layoutBar = UIView()
    private let bar = UIScrollView()
    private let stage = UIView()
    private let lowerScreen = UIView()
    private let hinge = UIView()
    private var stageLandscape: [NSLayoutConstraint] = []
    private var stagePortrait: [NSLayoutConstraint] = []
    private var appliedStagePortrait: Bool?
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
        ("save", "快速存档"), ("load", "快速读档"), ("ff", "倍速（按住快进）"), ("shot", "截图"),
    ]
    /** Filter ids, matching the order shown in the 画质 picker (Shaders.functionNames). */
    private static let filterNames = ["关闭", "GBA 色彩", "灰度", "HQ2x", "HQ4x", "2xBR", "4xBR", "残影", "点阵", "LCD3x", "扫描线（平滑）", "锐利插值"]
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
        applyCoreOptions()
        audio.volume = Float(defaults.object(forKey: "volume") == nil ? 100 : defaults.integer(forKey: "volume")) / 100
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
            }
        }
        controls.onFastHold = { [weak self] down in
            guard let self else { return }
            self.fastHold = down
            if down { self.wakeInput() }
            self.refreshSpeedButtons()
        }
        applyInputSettings()
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
    }

    /** Portrait splits the stage into a DS-like pair of screens. */
    private func applyStageLayout() {
        if appliedStagePortrait == portrait {
            return
        }
        appliedStagePortrait = portrait
        if portrait {
            NSLayoutConstraint.deactivate(stageLandscape)
            NSLayoutConstraint.activate(stagePortrait)
        } else {
            NSLayoutConstraint.deactivate(stagePortrait)
            NSLayoutConstraint.activate(stageLandscape)
        }
        hinge.isHidden = !portrait
        // The handle follows the keys, which move between the screens.
        menuLeft = -1
        menuTop = -1
        layoutMenuButton()
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
        soundToggle.addAction(UIAction { [weak self] _ in
            guard let self else { return }
            self.defaults.set(soundToggle.isOn, forKey: "fast_audio")
            self.audio.setSoundEnabled(soundToggle.isOn)
        }, for: .valueChanged)
        let soundLabel = UILabel()
        soundLabel.text = "倍速声音"
        soundLabel.textColor = .white
        soundLabel.font = .systemFont(ofSize: 13)
        speedStack.addArrangedSubview(soundLabel)
        speedStack.addArrangedSubview(soundToggle)
        refreshSpeedButtons()
        savePathView.textColor = UIColor(red: 183 / 255, green: 227 / 255, blue: 183 / 255, alpha: 1)
        savePathView.font = .systemFont(ofSize: 12)
        savePathView.numberOfLines = 3
        savePathView.isHidden = true
        savePathView.isUserInteractionEnabled = true
        savePathView.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(copySavePath)))
        hint.text = "点击「打开」选择 .gba、.gbc、.gb 或 .zip 游戏；也可以在文件 App 里用 mGBA 打开 ROM。"
        hint.textColor = UIColor(white: 0.87, alpha: 1)
        hint.numberOfLines = 0
        hint.textAlignment = .center
        // Portrait turns the stage into a DS-like pair of screens: a black
        // upper screen with the game, a slightly grey lower one with the keys.
        lowerScreen.backgroundColor = UIColor(white: 0.043, alpha: 1)
        hinge.backgroundColor = UIColor(white: 0.18, alpha: 1)
        hinge.isUserInteractionEnabled = false
        stage.addSubview(lowerScreen)
        stage.addSubview(gameView)
        stage.addSubview(hint)
        stage.addSubview(controls)
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
        for item in [bar, stack, speedBar, savePathView, stage, lowerScreen, gameView, hint, controls, layoutBar, hinge] {
            item.translatesAutoresizingMaskIntoConstraints = false
        }
        view.addSubview(bar)
        view.addSubview(speedBar)
        view.addSubview(savePathView)
        view.addSubview(stage)
        view.addSubview(layoutBar)
        speedBarHeight = speedBar.heightAnchor.constraint(equalToConstant: 0)
        savePathHeight = savePathView.heightAnchor.constraint(equalToConstant: 0)
        // Landscape: the menu bar on top, the keys over the full-screen game.
        stageLandscape = [
            bar.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            speedBar.topAnchor.constraint(equalTo: bar.bottomAnchor),
            savePathView.topAnchor.constraint(equalTo: speedBar.bottomAnchor),
            stage.topAnchor.constraint(equalTo: savePathView.bottomAnchor),
            stage.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            gameView.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            controls.topAnchor.constraint(equalTo: stage.topAnchor),
            controls.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            hint.centerYAnchor.constraint(equalTo: stage.centerYAnchor)
        ]
        // Portrait: a DS-like split, game on the upper screen, keys and the
        // menu (docked at the bottom) on the lower one.
        stagePortrait = [
            stage.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            stage.bottomAnchor.constraint(equalTo: savePathView.topAnchor),
            savePathView.bottomAnchor.constraint(equalTo: speedBar.topAnchor),
            speedBar.bottomAnchor.constraint(equalTo: bar.topAnchor),
            bar.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor),
            gameView.heightAnchor.constraint(equalTo: stage.heightAnchor, multiplier: 0.5),
            controls.topAnchor.constraint(equalTo: gameView.bottomAnchor),
            controls.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            hint.centerYAnchor.constraint(equalTo: gameView.centerYAnchor)
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
            savePathView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 8),
            savePathView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -8),
            savePathHeight,
            stage.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            stage.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            gameView.topAnchor.constraint(equalTo: stage.topAnchor),
            gameView.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            gameView.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            controls.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            controls.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            hint.centerXAnchor.constraint(equalTo: stage.centerXAnchor),
            hint.leadingAnchor.constraint(greaterThanOrEqualTo: stage.leadingAnchor, constant: 24),
            hint.trailingAnchor.constraint(lessThanOrEqualTo: stage.trailingAnchor, constant: -24),
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
        appliedStagePortrait = portrait
        hinge.isHidden = !portrait
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
            let mult: Double = fastHold ? max(speed, fastHoldSpeed()) : speed
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
            let wantSound = defaults.object(forKey: "fast_audio") == nil ? true : defaults.bool(forKey: "fast_audio")
            audio.setSoundEnabled(wantSound)
            // Fast-forward keeps its sound unless it was switched off; the core's
            // resampler plays that stream faster (tape style), so a change only
            // needs the queues dropped.
            let audioSpeed: Double = wantSound ? mult : 1
            if audioSpeed != lastAudioSpeed {
                lastAudioSpeed = audioSpeed
                audio.flush()
                mgbaMobileClearAudio(core)
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
            nextSlice += sliceNanos
            let sliceNow = Int64(bitPattern: DispatchTime.now().uptimeNanoseconds)
            if sliceNow - nextSlice > 2 * sliceNanos {
                nextSlice = sliceNow
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
                    mgbaMobileSetAudioPaceFps(core, Double(cycles) * 1_000_000_000 / Double(elapsed))
                }
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
                        brightness: Float(min(150, max(50, self.gameView.brightness))) / 100) {
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
        audio.stop()
        let ok = mgbaMobileLoad(core, path)
        if !ok {
            DispatchQueue.main.async { [weak self] in
                self?.hint.isHidden = false
                self?.hint.text = "无法加载这个游戏"
                self?.toast("无法加载这个游戏")
                self?.showMenu()
            }
            return
        }
        var title = [CChar](repeating: 0, count: 32)
        mgbaMobileTitle(core, &title, 32)
        let name = String(cString: title).trimmingCharacters(in: .whitespaces)
        // The core converts its own stream to the rate the device runs at; the
        // queue level then steers that resampler (see AudioOut.rateDrift).
        audio.start()
        _ = mgbaMobileSetAudioOutput(core, Int32(audio.outputRate))
        applyCoreOptions()
        frameDebt = 0
        gate.lock()
        paused = false
        gate.unlock()
        // 进入游戏时自动读档：上次退出的进度。
        if defaults.bool(forKey: "auto_load_state"), mgbaMobileLoadState(core, Self.autoSlot) {
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
        }
    }

    private func runCommand(_ cmd: Int) {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let current = slot
        if cmd == cmdSave {
            let ok = mgbaMobileSaveState(core, Int32(current))
            if ok { writePreview(current) }
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
            if mgbaMobileSaveState(core, Self.autoSlot) {
                writePreview(Self.autoSlot)
            }
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
        let picker = UIDocumentPickerViewController(forOpeningContentTypes: [UTType.data], asCopy: false)
        picker.delegate = self
        present(picker, animated: true)
    }

    func documentPicker(_ controller: UIDocumentPickerViewController, didPickDocumentsAt urls: [URL]) {
        guard let url = urls.first else { return }
        if pickerKind == 1 {
            openExternal(url)
        } else if pickerKind == 3 {
            importMyBoySaves(urls)
        } else {
            DispatchQueue.global().async { [weak self] in self?.importBios(url) }
        }
    }

    /// Loads a ROM handed over by the file picker or by another app ("用 mGBA
    /// 打开" in the Files app). Like the Android build, the file stays where it
    /// is; only a location that cannot be read back is copied into the app.
    func openExternal(_ url: URL) {
        hint.isHidden = false
        hint.text = "正在读取游戏…"
        guard let path = adoptRomURL(url) else {
            toast("无法加载这个游戏")
            return
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
        present(alert, animated: true)
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
        let showPath = menuVisible && savePathWanted
        bar.isHidden = !menuVisible
        speedBar.isHidden = !showSpeed
        savePathView.isHidden = !showPath
        speedBarHeight.constant = showSpeed ? 40 : 0
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
            || (savePathWanted && savePathView.frame.contains(point))
        if inside { armMenuAutoHide() }
    }

    /// Keeps the menu handle out of the keys' way: next to the on-screen START
    /// key in landscape, on the top edge of the lower screen in portrait.
    private func layoutMenuButton() {
        guard menuButton != nil, menuLeading != nil, menuCenterY != nil else { return }
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
        let shown = fastHold ? max(speed, fastHoldSpeed()) : speed
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
        alert.addAction(UIAlertAction(title: "高级", style: .default) { [weak self] _ in self?.showAdvanced() })
        alert.addAction(UIAlertAction(title: "帮助", style: .default) { [weak self] _ in self?.showHelpDialog() })
        alert.addAction(UIAlertAction(title: "关闭", style: .cancel))
        if let popover = alert.popoverPresentationController {
            popover.sourceView = view
            popover.sourceRect = CGRect(x: view.bounds.midX, y: view.bounds.midY, width: 0, height: 0)
        }
        present(alert, animated: true)
    }

    private func showOrientationDialog() {
        let alert = UIAlertController(title: "屏幕方向", message: nil, preferredStyle: .alert)
        let modes: [(String, String)] = [
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
        present(alert, animated: true)
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
            self.audio.volume = Float(percent) / 100
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
        present(SheetController(title: "声音", content: box), animated: true)
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
        let extras = UIButton(type: .system)
        extras.contentHorizontalAlignment = .left
        extras.setTitle("虚拟按键开关（连发/快存/快读/倍速/截图）", for: .normal)
        extras.addAction(UIAction { [weak self] _ in self?.showExtraKeysDialog() }, for: .touchUpInside)
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
        box.addArrangedSubview(extras)
        present(SheetController(title: "输入", content: box), animated: true)
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
        present(SheetController(title: "虚拟按键开关（连发/快存/快读/倍速/截图）", content: box), animated: true)
    }

    private func extraKeys() -> Set<String> {
        var out = Set<String>()
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
        box.addArrangedSubview(deleteSav)
        box.addArrangedSubview(importSav)
        present(SheetController(title: "存档", content: box), animated: true)
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
        let target: UIInterfaceOrientation
        switch orientationMode {
        case "portrait": mask = .portrait; target = .portrait
        case "portrait_rev": mask = .portraitUpsideDown; target = .portraitUpsideDown
        case "landscape_rev": mask = .landscapeLeft; target = .landscapeLeft
        default: mask = .landscapeRight; target = .landscapeRight
        }
        if #available(iOS 16.0, *) {
            setNeedsUpdateOfSupportedInterfaceOrientations()
            view.window?.windowScene?.requestGeometryUpdate(.iOS(interfaceOrientations: mask)) { _ in }
        }
        UIDevice.current.setValue(target.rawValue, forKey: "orientation")
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
            : defaults.integer(forKey: "rtc_epoch")
        let offset = Int64(defaults.integer(forKey: "rtc_offset_min")) * 60
        mgbaMobileSetRtc(core, Int32(mode), epoch, offset)
        mgbaMobileSetSolar(core, Int32(defaults.bool(forKey: "solar_on")
            ? (defaults.integer(forKey: "solar_level") == 0 ? 5 : defaults.integer(forKey: "solar_level"))
            : -1))
        mgbaMobileSetCartRumble(core, defaults.bool(forKey: "cart_rumble"))
        // Twelve gb.pal entries for the chosen palette. Index 0 is the core's
        // own stock colors, sent explicitly so a previous palette is cleared.
        let base = Self.gbPalettes[palettePref()]
        var colors = [Int32](repeating: 0, count: 12)
        for index in 0..<12 {
            colors[index] = base[index % 4]
        }
        colors.withUnsafeBufferPointer { buffer in
            if let address = buffer.baseAddress {
                mgbaMobileSetGbPalette(core, address)
            }
        }
        mgbaMobileSetSgbBorders(core, defaults.bool(forKey: "sgb_borders"))
        updateTiltSensor()
        // Neutral until a reading arrives; keeps held cartridges from drifting.
        mgbaMobileSetRotation(core, 0, 0, 0)
    }

    /** Pushes the input-related preferences into the on-screen controls. */
    private func applyInputSettings() {
        controls.setDiagonalLock(defaults.bool(forKey: "no_diagonal"))
        controls.setTurboRate(defaults.integer(forKey: "turbo_rate") == 0 ? 25 : defaults.integer(forKey: "turbo_rate"))
        controls.setVisibleExtras(extraKeys())
        controls.setOpacity(defaults.object(forKey: "controls_opacity") == nil ? 100 : defaults.integer(forKey: "controls_opacity"))
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

    private func profileLayout(_ name: String) -> String {
        if let data = defaults.string(forKey: Self.profilePrefix + name) {
            return data
        }
        if name == Self.defaultProfile {
            let legacy = defaults.string(forKey: "key_layout") ?? ""
            defaults.set(legacy, forKey: Self.profilePrefix + name)
            return legacy
        }
        return ""
    }

    /** Persists the current layout into its profile. */
    private func saveKeyLayout() {
        defaults.set(keyLayout.encode(), forKey: Self.profilePrefix + layoutProfile)
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
                    self.present(confirm, animated: true)
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
        present(SheetController(title: "按键映射配置", content: box), animated: true)
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
        present(alert, animated: true)
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
        solarLabel.text = "阳光强度 \(solarNow)"
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
        box.addArrangedSubview(solarLabel)
        box.addArrangedSubview(solarBar)
        box.addArrangedSubview(sgb.0)
        box.addArrangedSubview(tilt.0)
        box.addArrangedSubview(palette)
        box.addArrangedSubview(fastLabel)
        box.addArrangedSubview(fastBar)
        present(SheetController(title: "高级", content: box), animated: true)
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
        present(alert, animated: true)
    }

    private func pickRtcDate(_ label: UIButton) {
        let sheet = SheetController(title: "选择固定时间", content: makeRtcDatePicker(label))
        present(sheet, animated: true)
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
            self.dismiss(animated: true)
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
        present(alert, animated: true)
    }

    private func showHelpDialog() {
        let text = UILabel()
        text.numberOfLines = 0
        text.font = .systemFont(ofSize: 14)
        text.text = "游戏：打开 .gba/.gbc/.gb 后自动继续上次的进度（电池存档自动保存）。\n\n倍速：菜单里点「倍速」选 0.25~16 倍，或长按「自定义」输入小数；TAB/空格/手柄右摇杆按下为快进。\n\n画质：可开画面滤镜（GBA 色彩、灰度、HQ2x、HQ4x、2xBR、4xBR、残影、点阵、LCD3x、扫描线、锐利插值），配整数缩放效果最佳；GB 游戏可在高级设置里换调色板。\n\n金手指：菜单「金手指」里新增，格式选自动识别即可，每行一个代码，勾选生效。\n\n补丁：把 IPS/UPS/BPS 补丁改成和 ROM 同名（扩展名保留）放在同一文件夹，进游戏时自动应用。\n\n联机：两边运行同一 ROM，一边创建一边加入。\n\n截屏：菜单「截图」存进相册，「录像」录制 GIF。"
        present(SheetController(title: "帮助", content: text), animated: true)
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
                self?.present(confirm, animated: true)
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
        present(sheet, animated: true)
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
        present(SheetController(title: "新增", content: box), animated: true)
    }

    // == Screenshots & GIF ==

    /** Saves the current frame as a PNG into the photo library. */
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
        guard let data = shot.pngData() else {
            toast("截图失败")
            return
        }
        let stamp = Self.fileStamp()
        let name = "mGBAx-\(stamp).png"
        PHPhotoLibrary.requestAuthorization(for: .addOnly) { [weak self] status in
            DispatchQueue.main.async {
                guard let self else { return }
                if status == .authorized || status == .limited {
                    PHPhotoLibrary.shared().performChanges {
                        let request = PHAssetCreationRequest.forAsset()
                        request.creationDate = Date()
                        let options = PHAssetResourceCreationOptions()
                        options.originalFilename = name
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
        if save {
            postCommand(cmdSave)
        } else {
            postCommand(cmdLoad)
        }
    }

    /** Copies My Boy .sav files from a picked folder into the saves folder. */
    private func pickMyBoySaves() {
        pickerKind = 3
        let picker = UIDocumentPickerViewController(forOpeningContentTypes: [UTType.folder], asCopy: false)
        picker.delegate = self
        present(picker, animated: true)
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
        present(confirm, animated: true)
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
        present(confirm, animated: true)
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
        let rom = defaults.string(forKey: "lastRom") ?? "game"
        let base = URL(fileURLWithPath: rom).deletingPathExtension().lastPathComponent
        return docs.appendingPathComponent("states").appendingPathComponent("\(base).ss\(index)")
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
                self.postCommand(save ? self.cmdSave : self.cmdLoad)
                sheet?.dismiss(animated: true)
            }, for: .touchUpInside)
        }
        present(sheet, animated: true)
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
        guard let image = gameView.copyLast(), let data = image.pngData() else { return }
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
        gameView.filter = filterPref()
        let bright = defaults.object(forKey: "vf_bright") == nil ? 100 : defaults.integer(forKey: "vf_bright")
        gameView.brightness = bright
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
        let autoSkip = labeledSwitch("自动跳帧（跟不上时自动跳帧保速度）", defaults.bool(forKey: "vf_skip_auto"))
        let skip = slider(max: 5, value: Float(defaults.integer(forKey: "vf_skip")))
        let bright = slider(max: 100, value: Float((defaults.object(forKey: "vf_bright") == nil ? 100 : defaults.integer(forKey: "vf_bright")) - 50))
        let skipLabel = UILabel()
        let brightLabel = UILabel()
        func refresh() {
            skipLabel.text = "跳帧 \(Int(skip.value))"
            brightLabel.text = "亮度 \(Int(bright.value) + 50)%"
            defaults.set(blend.1.isOn, forKey: "vf_blend")
            defaults.set(linear.1.isOn, forKey: "vf_linear")
            defaults.set(aspect.1.isOn, forKey: "vf_aspect")
            defaults.set(integer.1.isOn, forKey: "vf_integer")
            defaults.set(scan.1.isOn, forKey: "vf_scan")
            defaults.set(Int(skip.value), forKey: "vf_skip")
            defaults.set(Int(bright.value) + 50, forKey: "vf_bright")
            applyVideo()
        }
        for item in [blend, linear, aspect, integer, scan] {
            item.1.addAction(UIAction { _ in refresh() }, for: .valueChanged)
            box.addArrangedSubview(item.0)
        }
        box.addArrangedSubview(filterRow)
        box.addArrangedSubview(autoSkip.0)
        box.addArrangedSubview(skipLabel)
        box.addArrangedSubview(skip)
        box.addArrangedSubview(brightLabel)
        box.addArrangedSubview(bright)
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
        refresh()
        present(SheetController(title: "画质", content: box), animated: true)
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
                self?.dismiss(animated: true)
                handler(index)
            }, for: .touchUpInside)
            box.addArrangedSubview(button)
        }
        present(SheetController(title: title, content: box), animated: true)
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
            self.gboyRemoteKeys = 0
            self.linkWatch?.cancel()
            self.lastLinkState = 0
            status.text = "断开"
        })
        box.addArrangedSubview(status)
        present(SheetController(title: "联机", content: box), animated: true)
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

    private func updatePad(_ pad: GCExtendedGamepad) {
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
        let prev = padKeys
        padKeys = mask
        noteUserKeys(prevTouch: touchKeys, prevHw: hwKeys, prevPad: prev)
        if (mask & ~prev) != 0 { wakeInput() }
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
        // A held fast-forward key can be cut off by a system overlay before its
        // key-up arrives; drop the hold so the game cannot come back stuck at
        // 16x speed with raised audio.
        for press in presses {
            guard let key = press.key else { continue }
            if key.keyCode == .keyboardTab || key.keyCode == .keyboardSpacebar {
                fastHold = false
            }
        }
        super.pressesCancelled(presses, with: event)
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

    private func toast(_ message: String) {
        DispatchQueue.main.async {
            let alert = UIAlertController(title: nil, message: message, preferredStyle: .alert)
            self.present(alert, animated: true)
            DispatchQueue.main.asyncAfter(deadline: .now() + 1.2) { alert.dismiss(animated: true) }
        }
    }

    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        gate.lock()
        paused = true
        // Do not stay held at 16x (raised pitch) when the key-up never arrives
        // because the screen went away under a held key.
        fastHold = false
        gate.unlock()
        audio.setPaused(true)
        // 退出时自动存档 into the reserved slot.
        if defaults.bool(forKey: "auto_save_state"), let core, mgbaMobileIsLoaded(core) {
            if mgbaMobileSaveState(core, Self.autoSlot) {
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
