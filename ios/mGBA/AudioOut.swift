import AVFoundation

/// Plays the emulator's audio through AVFoundation.
///
/// Mirrors the Android playback path: the core converts its own stream to the
/// device rate with its native sinc resampler (`mgbaMobileSetAudioOutput` plus
/// `mgbaMobileReadAudioOut`), and this class only queues what the core produced
/// and reports how full that queue is. The core turns the level into a tiny
/// rate adjustment (dynamic rate control) so the queue neither drains nor
/// overflows, and fast-forward sound comes out of the same resampler in tape
/// style, so no playback-rate unit is involved.
final class AudioOut {
    /// Port of the Android AudioRateControl: the emulator produces samples
    /// against its own clock while the device consumes them against its
    /// crystal, so the queue level steers the core's resampler ratio by at most
    /// a fraction of a percent. That is inaudible but keeps the queue near its
    /// target, avoiding both gaps and dropped samples.
    private struct RateControl {
        /// Largest ratio adjustment; also covers a front end that cannot pace
        /// at full speed.
        static let maxDrift: Float = 0.02
        /// Ratio adjustment per unit of normalized queue error.
        static let gain: Float = 0.08
        /// Smoothing of the queue measurement, which the device reports in
        /// coarse steps.
        static let smoothing: Float = 0.12

        let trackFrames: Int
        let targetFrames: Int
        private var smoothedError: Float = 0

        init(trackFrames: Int, targetFrames: Int) {
            self.trackFrames = max(1, trackFrames)
            self.targetFrames = max(0, min(targetFrames, trackFrames))
        }

        /// `steady` is false while the pipeline is still filling up, where the
        /// measurement is followed directly instead of being averaged.
        mutating func drift(levelFrames: Int, steady: Bool) -> Float {
            let error = Float(levelFrames - targetFrames) / Float(trackFrames)
            if steady {
                smoothedError += (error - smoothedError) * Self.smoothing
            } else {
                smoothedError = error
            }
            return min(Self.maxDrift, max(-Self.maxDrift, smoothedError * Self.gain))
        }
    }

    private let engine = AVAudioEngine()
    private var sourceNode: AVAudioSourceNode?
    private let lock = NSLock()
    private var storage: [Int16]
    private var readPos = 0
    private var writePos = 0
    /// Frames the queue may hold; the target level is a fraction of it.
    private let capacity: Int
    private var control: RateControl
    private var paused = false
    /// Rate the output device runs at; the core resamples to it.
    private(set) var outputRate = 48000
    private var started = false
    private var soundEnabled = true

    init() {
        capacity = 8192
        storage = [Int16](repeating: 0, count: capacity * 2)
        control = RateControl(trackFrames: capacity, targetFrames: Int(Double(capacity) * 0.65))
    }

    /// Starts the output device at its own sample rate. The core is told about
    /// the rate separately, through `mgbaMobileSetAudioOutput`.
    func start() {
        let session = AVAudioSession.sharedInstance()
        try? session.setCategory(.playback, mode: .default, options: [.mixWithOthers])
        try? session.setActive(true)
        var rate = Int(session.sampleRate.rounded())
        if rate <= 0 {
            rate = 48000
        }
        if sourceNode == nil || rate != outputRate {
            if let old = sourceNode {
                engine.disconnectNodeOutput(old)
                engine.detach(old)
                sourceNode = nil
            }
            guard let format = AVAudioFormat(standardFormatWithSampleRate: Double(rate), channels: 2) else {
                return
            }
            // One node at a time: it is only replaced when the device rate
            // changes, so the queue is drained by a single render callback and
            // the core always resamples to the rate the graph was built for.
            let node = AVAudioSourceNode(format: format) { [weak self] _, _, frameCount, audioBufferList -> OSStatus in
                self?.render(frameCount: Int(frameCount), list: audioBufferList)
                return noErr
            }
            engine.attach(node)
            engine.connect(node, to: engine.mainMixerNode, format: format)
            sourceNode = node
        }
        outputRate = rate
        if !engine.isRunning {
            try? engine.start()
        }
        started = true
    }

    func setPaused(_ value: Bool) {
        paused = value
        if value { clear() }
    }

    func setSoundEnabled(_ value: Bool) {
        soundEnabled = value
        if !value { clear() }
    }

    /// Drops the queued audio; the next pump refills it. Used when the speed or
    /// the sound setting changes, so the old rate never mixes with the new one.
    func flush() {
        clear()
    }

    func stop() {
        engine.stop()
        started = false
        clear()
    }

    /// Ratio adjustment for the core's resampler, derived from how much audio
    /// is queued right now.
    func rateDrift() -> Float {
        lock.lock()
        let level = ((writePos - readPos + capacity * 2) % (capacity * 2)) / 2
        lock.unlock()
        return control.drift(levelFrames: level, steady: started && !paused && soundEnabled)
    }

    /// Queues frames the core already converted to `outputRate`.
    func pump(samples: UnsafePointer<Int16>, frames: Int) {
        if paused || !soundEnabled || frames <= 0 { return }
        write(samples, frames: frames)
    }

    private func write(_ samples: UnsafePointer<Int16>, frames: Int) {
        let shorts = frames * 2
        let total = capacity * 2
        lock.lock()
        var i = 0
        while i < shorts {
            storage[writePos] = samples[i]
            writePos = (writePos + 1) % total
            if writePos == readPos {
                readPos = (readPos + 1) % total
            }
            i += 1
        }
        lock.unlock()
    }

    private func clear() {
        lock.lock()
        readPos = 0
        writePos = 0
        lock.unlock()
    }

    private func render(frameCount: Int, list: UnsafeMutablePointer<AudioBufferList>) {
        let buffers = UnsafeMutableAudioBufferListPointer(list)
        guard buffers.count >= 2,
              let leftData = buffers[0].mData?.assumingMemoryBound(to: Float.self),
              let rightData = buffers[1].mData?.assumingMemoryBound(to: Float.self) else { return }
        lock.lock()
        let available = (writePos - readPos + capacity * 2) % (capacity * 2)
        let frames = min(frameCount, available / 2)
        for i in 0..<frameCount {
            if i < frames {
                let l = storage[readPos]
                readPos = (readPos + 1) % (capacity * 2)
                let r = storage[readPos]
                readPos = (readPos + 1) % (capacity * 2)
                leftData[i] = Float(l) / 32768
                rightData[i] = Float(r) / 32768
            } else {
                leftData[i] = 0
                rightData[i] = 0
            }
        }
        lock.unlock()
    }
}
