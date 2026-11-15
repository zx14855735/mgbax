// AVFoundation / CoreMedia / CoreVideo / AudioToolbox 的最小替身。

// MARK: - 基础类型

public typealias OSStatus = Int32
public typealias AudioUnitRenderActionFlags = UInt32
public typealias AudioTimeStamp = Double
public typealias AudioFormatID = UInt32
public typealias AudioChannelCount = UInt32

public let noErr: OSStatus = 0

// MARK: - CoreMedia

public struct CMTime {
    public var value: Int64
    public var timescale: Int32
    public var flags: UInt32
    public var epoch: Int64
    public init() { value = 0; timescale = 0; flags = 0; epoch = 0 }
    public init(value: Int64, timescale: Int32, flags: UInt32, epoch: Int64) {
        self.value = value; self.timescale = timescale; self.flags = flags; self.epoch = epoch
    }
    public init(seconds: Double, preferredTimescale: Int32) {
        value = Int64(seconds * Double(preferredTimescale)); timescale = preferredTimescale
        flags = 1; epoch = 0
    }
    public var seconds: Double { timescale == 0 ? 0 : Double(value) / Double(timescale) }
    public var isNumeric: Bool { true }
    public var isValid: Bool { true }
    public static let zero = CMTime(value: 0, timescale: 1, flags: 1, epoch: 0)
    public static let invalid = CMTime()
    public static let indefinite = CMTime()
    public static let positiveInfinity = CMTime()
}

public func CMTimeMake(value: Int64, timescale: Int32) -> CMTime { CMTime(value: value, timescale: timescale, flags: 1, epoch: 0) }
public func CMTimeMakeWithSeconds(_ seconds: Double, preferredTimescale: Int32) -> CMTime { CMTime(seconds: seconds, preferredTimescale: preferredTimescale) }
public func CMTimeGetSeconds(_ time: CMTime) -> Double { time.seconds }
public func CMTimeAdd(_ lhs: CMTime, _ rhs: CMTime) -> CMTime { lhs }
public func CMTimeSubtract(_ lhs: CMTime, _ rhs: CMTime) -> CMTime { lhs }
public func CMTimeCompare(_ lhs: CMTime, _ rhs: CMTime) -> Int32 { 0 }

public struct CMTimeRange {
    public var start: CMTime
    public var duration: CMTime
    public init(start: CMTime, duration: CMTime) { self.start = start; self.duration = duration }
    public init() { start = .zero; duration = .zero }
}

public typealias CMTimeScale = Int32

public typealias CMItemCount = Int
public typealias CVReturn = Int32
public let kCVReturnSuccess: CVReturn = 0

public struct CMSampleTimingInfo {
    public var duration: CMTime
    public var presentationTimeStamp: CMTime
    public var decodeTimeStamp: CMTime
    public init(duration: CMTime, presentationTimeStamp: CMTime, decodeTimeStamp: CMTime) {
        self.duration = duration; self.presentationTimeStamp = presentationTimeStamp
        self.decodeTimeStamp = decodeTimeStamp
    }
    public init() { duration = .zero; presentationTimeStamp = .zero; decodeTimeStamp = .zero }
}

public func CMSampleBufferCreate(allocator: CFAllocator?,
                                 dataBuffer: CMBlockBuffer?,
                                 dataReady: Bool,
                                 makeDataReadyCallback: ((CMSampleBuffer?, UnsafeMutableRawPointer?) -> OSStatus)?,
                                 refcon: UnsafeMutableRawPointer?,
                                 formatDescription: CMFormatDescription?,
                                 sampleCount: CMItemCount,
                                 sampleTimingEntryCount: CMItemCount,
                                 sampleTimingArray: UnsafePointer<CMSampleTimingInfo>?,
                                 sampleSizeEntryCount: CMItemCount,
                                 sampleSizeArray: UnsafePointer<Int>?,
                                 sampleBufferOut: UnsafeMutablePointer<CMSampleBuffer?>) -> OSStatus { -1 }

public func CMSampleBufferSetDataBufferFromAudioBufferList(_ sbuf: CMSampleBuffer,
                                                           blockBufferAllocator: CFAllocator?,
                                                           blockBufferMemoryAllocator: CFAllocator?,
                                                           flags: UInt32,
                                                           bufferList: UnsafePointer<AudioBufferList>) -> OSStatus { -1 }

public func CVPixelBufferPoolCreatePixelBuffer(_ allocator: CFAllocator?, _ pixelBufferPool: CVPixelBufferPool, _ pixelBufferOut: UnsafeMutablePointer<CVPixelBuffer?>) -> CVReturn { -1 }

public class CMSampleBuffer {
    public var duration: CMTime { get { fatalError() } set { fatalError() } }
    public var presentationTimeStamp: CMTime { get { fatalError() } set { fatalError() } }
    public var decodeTimeStamp: CMTime { get { fatalError() } set { fatalError() } }
    public var isValid: Bool { get { fatalError() } set { fatalError() } }
    public var dataBuffer: CMBlockBuffer? { get { fatalError() } set { fatalError() } }
    public func imageBuffer() -> CVImageBuffer? { fatalError() }
}

public class CMSampleBufferRef {}

public class CMBlockBuffer {}

public class CMFormatDescription {
    public var mediaType: CMMediaType { get { fatalError() } set { fatalError() } }
}

public struct CMMediaType: Hashable, RawRepresentable {
    public var rawValue: UInt32
    public init(rawValue: UInt32) { self.rawValue = rawValue }
    public static let video = CMMediaType(rawValue: 0x76696465)
    public static let audio = CMMediaType(rawValue: 0x61756469)
}

// MARK: - CoreVideo

public class CVImageBuffer: NSObject {}
public class CVPixelBuffer: CVImageBuffer {
    public var width: Int { get { fatalError() } set { fatalError() } }
    public var height: Int { get { fatalError() } set { fatalError() } }
    public var bytesPerRow: Int { get { fatalError() } set { fatalError() } }
    public var baseAddress: UnsafeMutableRawPointer? { get { fatalError() } set { fatalError() } }
    public func lockBaseAddress(_ flags: Int) {}
    public func unlockBaseAddress(_ flags: Int) {}
}
public class CVPixelBufferPool: NSObject {}

public typealias CVPixelBufferRef = CVPixelBuffer

public struct CVPixelBufferLockFlags: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let readOnly = CVPixelBufferLockFlags(rawValue: 1)
}

public struct CVPixelBufferCreationOptions {}

public func CVPixelBufferGetBaseAddress(_ buffer: CVPixelBuffer) -> UnsafeMutableRawPointer? { nil }
public func CVPixelBufferGetBytesPerRow(_ buffer: CVPixelBuffer) -> Int { 0 }
public func CVPixelBufferGetWidth(_ buffer: CVPixelBuffer) -> Int { 0 }
public func CVPixelBufferGetHeight(_ buffer: CVPixelBuffer) -> Int { 0 }
public func CVPixelBufferLockBaseAddress(_ buffer: CVPixelBuffer, _ flags: CVPixelBufferLockFlags) -> Int32 { 0 }
public func CVPixelBufferUnlockBaseAddress(_ buffer: CVPixelBuffer, _ flags: CVPixelBufferLockFlags) -> Int32 { 0 }
public func CVPixelBufferCreate(_ allocator: UnsafeMutableRawPointer?, _ width: Int, _ height: Int, _ pixelFormatType: UInt32, _ pixelBufferAttributes: CFDictionary?, _ pixelBufferOut: UnsafeMutablePointer<CVPixelBuffer?>) -> Int32 { -1 }




public let kCVPixelFormatType_32BGRA: UInt32 = 0x42475241
public let kCVPixelBufferPixelFormatTypeKey: CFString = CFString()
public let kCVPixelBufferCGBitmapContextCompatibilityKey: CFString = CFString()
public let kCVPixelBufferCGImageCompatibilityKey: CFString = CFString()
public let kCVPixelBufferWidthKey: CFString = CFString()
public let kCVPixelBufferHeightKey: CFString = CFString()

// MARK: - AudioToolbox / AudioUnit
// 音频缓冲：AudioBufferList 在 Swift 里靠 UnsafeMutableAudioBufferListPointer 访问

public struct AudioBuffer {
    public var mNumberChannels: UInt32
    public var mDataByteSize: UInt32
    public var mData: UnsafeMutableRawPointer?
    public init() { mNumberChannels = 0; mDataByteSize = 0; mData = nil }
}

public struct AudioBufferList {
    public var mNumberBuffers: UInt32
    public var mBuffers: AudioBuffer
    public init() { mNumberBuffers = 0; mBuffers = AudioBuffer() }
}

public struct UnsafeMutableAudioBufferListPointer: RandomAccessCollection, MutableCollection {
    public typealias Element = AudioBuffer
    public typealias Index = Int
    private let list: UnsafeMutablePointer<AudioBufferList>
    public init(_ p: UnsafeMutablePointer<AudioBufferList>) { list = p }
    public var count: Int { Int(list.pointee.mNumberBuffers) }
    public var startIndex: Int { 0 }
    public var endIndex: Int { count }
    public subscript(i: Int) -> AudioBuffer {
        get { fatalError() }
        set { fatalError() }
    }
    public var unsafeMutablePointer: UnsafeMutablePointer<AudioBufferList> { list }
}

// MARK: - AVAudio 基类

open class AVAudioSession: NSObject {
    public enum Category: String { case ambient, soloAmbient, playback, record, playAndRecord, audioProcessing, multiRoute }
    public enum Mode: String { case `default`, voiceChat, gameChat, videoRecording, measurement, moviePlayback, videoChat, voicePrompt, spokenAudio }
    public struct CategoryOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let mixWithOthers = CategoryOptions(rawValue: 1)
        public static let duckOthers = CategoryOptions(rawValue: 2)
        public static let allowBluetooth = CategoryOptions(rawValue: 4)
        public static let defaultToSpeaker = CategoryOptions(rawValue: 8)
        public static let allowBluetoothA2DP = CategoryOptions(rawValue: 0x20)
        public static let allowAirPlay = CategoryOptions(rawValue: 0x40)
    }
    public struct PortOverride: Hashable, RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
    }
    public enum RouteChangeReason: UInt { case unknown = 0, newDeviceAvailable = 1, oldDeviceUnavailable = 2, categoryChange = 3, override = 4 }
    open var sampleRate: Double { get { fatalError() } set { fatalError() } }
    open var ioBufferDuration: TimeInterval { get { fatalError() } set { fatalError() } }
    open var outputLatency: TimeInterval { get { fatalError() } set { fatalError() } }
    open var outputVolume: Float { get { fatalError() } set { fatalError() } }
    open var isOtherAudioPlaying: Bool { get { fatalError() } set { fatalError() } }
    open var categoryOptions: CategoryOptions { get { fatalError() } set { fatalError() } }
    open var currentRoute: AVAudioSessionRouteDescription { get { fatalError() } set { fatalError() } }
    open class func sharedInstance() -> AVAudioSession { AVAudioSession() }
    open func setCategory(_ category: Category, mode: Mode, options: CategoryOptions = []) throws {}
    open func setCategory(_ category: Category, mode: Mode, policy: Int, options: CategoryOptions = []) throws {}
    open func setCategory(_ category: Category, options: CategoryOptions = []) throws {}
    open func setMode(_ mode: Mode) throws {}
    open func setActive(_ active: Bool) throws {}
    open func setActive(_ active: Bool, options: Int) throws {}
    open func setPreferredIOBufferDuration(_ duration: TimeInterval) throws {}
    open func setPreferredSampleRate(_ sampleRate: Double) throws {}
    open func overrideOutputAudioPort(_ portOverride: AVAudioSession.PortOverride) throws {}
    open func requestRecordPermission(_ response: @escaping (Bool) -> Void) {}
}

public extension AVAudioSession.PortOverride {
    static let none = AVAudioSession.PortOverride(rawValue: 0)
    static let speaker = AVAudioSession.PortOverride(rawValue: 1)
}

open class AVAudioSessionRouteDescription: NSObject {
    open var inputs: [AVAudioSessionPortDescription] { get { fatalError() } set { fatalError() } }
    open var outputs: [AVAudioSessionPortDescription] { get { fatalError() } set { fatalError() } }
}

open class AVAudioSessionPortDescription: NSObject {
    open var portName: String { get { fatalError() } set { fatalError() } }
    open var portType: String { get { fatalError() } set { fatalError() } }
    open var uid: String { get { fatalError() } set { fatalError() } }
}

open class AVAudioFormat: NSObject {
    open var sampleRate: Double { get { fatalError() } set { fatalError() } }
    open var channelCount: UInt32 { get { fatalError() } set { fatalError() } }
    open var isStandard: Bool { get { fatalError() } set { fatalError() } }
    open var commonFormat: AVAudioCommonFormat { get { fatalError() } set { fatalError() } }
    public init?(standardFormatWithSampleRate sampleRate: Double, channels: AVAudioChannelCount) { super.init() }
    public init?(standardFormatWithSampleRate sampleRate: Double, channels: AVAudioChannelCount, interleaved: Bool) { super.init() }
    public init?(commonFormat format: AVAudioCommonFormat, sampleRate: Double, channels: AVAudioChannelCount, interleaved: Bool) { super.init() }
    public init?(settings: [String: Any]) { super.init() }
}

public typealias AVAudioChannelCount = UInt32

public enum AVAudioCommonFormat: UInt {
    case otherFormat = 0, pcmFormatFloat32 = 1, pcmFormatFloat64 = 2, pcmFormatInt16 = 3, pcmFormatInt32 = 4
}

open class AVAudioPCMBuffer: NSObject {
    open var format: AVAudioFormat { get { fatalError() } set { fatalError() } }
    open var frameCapacity: AVAudioFrameCount { get { fatalError() } set { fatalError() } }
    open var frameLength: AVAudioFrameCount { get { fatalError() } set { fatalError() } }
    open var stride: Int { get { fatalError() } set { fatalError() } }
    open var int16ChannelData: UnsafePointer<UnsafeMutablePointer<Int16>>? { get { fatalError() } set { fatalError() } }
    open var floatChannelData: UnsafePointer<UnsafeMutablePointer<Float>>? { get { fatalError() } set { fatalError() } }
    open var audioBufferList: UnsafeMutablePointer<AudioBufferList> { get { fatalError() } set { fatalError() } }
    public init?(pcmFormat format: AVAudioFormat, frameCapacity: AVAudioFrameCount) { super.init() }
}

public typealias AVAudioFrameCount = UInt32

open class AVAudioNode: NSObject {
    open var engine: AVAudioEngine? { get { fatalError() } set { fatalError() } }
    open var numberOfInputs: Int { get { fatalError() } set { fatalError() } }
    open var numberOfOutputs: Int { get { fatalError() } set { fatalError() } }
    open var lastRenderTime: Any? { get { fatalError() } set { fatalError() } }
    open func reset() {}
    open func installTap(onBus bus: Int, bufferSize: AVAudioFrameCount, format: AVAudioFormat?, block: @escaping AVAudioNodeTapBlock) {}
    open func removeTap(onBus bus: Int) {}
    open func inputFormat(forBus bus: Int) -> AVAudioFormat { fatalError() }
    open func outputFormat(forBus bus: Int) -> AVAudioFormat { fatalError() }
}

public typealias AVAudioNodeTapBlock = (AVAudioPCMBuffer, AVAudioTime) -> Void

open class AVAudioTime: NSObject {
    open var sampleTime: Int64 { get { fatalError() } set { fatalError() } }
    open var isSampleTimeValid: Bool { get { fatalError() } set { fatalError() } }
}

open class AVAudioMixerNode: AVAudioNode {
    open var outputVolume: Float { get { fatalError() } set { fatalError() } }
    open var inputVolume: Float { get { fatalError() } set { fatalError() } }
}

open class AVAudioOutputNode: AVAudioNode {}

open class AVAudioSourceNode: AVAudioNode {
    public typealias RenderBlock = (UnsafeMutablePointer<ObjCBool>, UnsafePointer<AudioTimeStamp>,
                                    AVAudioFrameCount, UnsafeMutablePointer<AudioBufferList>) -> OSStatus
    public init(format: AVAudioFormat, renderBlock: @escaping AVAudioSourceNode.RenderBlock) { super.init() }
    public init(renderBlock: @escaping AVAudioSourceNode.RenderBlock) { super.init() }
}

open class AVAudioSinkNode: AVAudioNode {}

open class AVAudioEngine: NSObject {
    open var mainMixerNode: AVAudioMixerNode { get { fatalError() } set { fatalError() } }
    open var outputNode: AVAudioOutputNode { get { fatalError() } set { fatalError() } }
    open var inputNode: AVAudioNode { get { fatalError() } set { fatalError() } }
    open var isRunning: Bool { get { fatalError() } set { fatalError() } }
    open var attachedNodes: Set<AVAudioNode> { get { fatalError() } set { fatalError() } }
    open var isInManualRenderingMode: Bool { get { fatalError() } set { fatalError() } }
    public override init() { super.init() }
    open func attach(_ node: AVAudioNode) {}
    open func detach(_ node: AVAudioNode) {}
    open func connect(_ node1: AVAudioNode, to node2: AVAudioNode, format: AVAudioFormat?) {}
    open func connect(_ node1: AVAudioNode, to node2: AVAudioNode, fromBus: Int, toBus: Int, format: AVAudioFormat?) {}
    open func disconnectNodeInput(_ node: AVAudioNode) {}
    open func disconnectNodeOutput(_ node: AVAudioNode) {}
    open func prepare() {}
    open func start() throws {}
    open func pause() {}
    open func stop() {}
    open func reset() {}
}

// MARK: - AVAssetWriter（录像）

open class AVAssetWriterInputPixelBufferAdaptor: NSObject {
    open var assetWriterInput: AVAssetWriterInput { get { fatalError() } set { fatalError() } }
    open var sourcePixelBufferAttributes: [String: Any]? { get { fatalError() } set { fatalError() } }
    open var pixelBufferPool: CVPixelBufferPool? { get { fatalError() } set { fatalError() } }
    public init(assetWriterInput input: AVAssetWriterInput, sourcePixelBufferAttributes: [String: Any]?) { super.init() }
    open func append(_ pixelBuffer: CVPixelBuffer, withPresentationTime presentationTime: CMTime) -> Bool { false }
    open func appendPixelBuffer(_ pixelBuffer: CVPixelBuffer, withPresentationTime presentationTime: CMTime) -> Bool { false }
}

open class AVAssetWriterInput: NSObject {
    open var isReadyForMoreMediaData: Bool { get { fatalError() } set { fatalError() } }
    open var expectsMediaDataInRealTime: Bool { get { fatalError() } set { fatalError() } }
    open var mediaTimeScale: CMTimeScale { get { fatalError() } set { fatalError() } }
    public init(mediaType: AVMediaType, outputSettings: [String: Any]?) { super.init() }
    open func append(_ sampleBuffer: CMSampleBuffer) -> Bool { false }
    open func requestMediaDataWhenReady(on queue: DispatchQueue, using block: @escaping () -> Void) {}
    open func markAsFinished() {}
}

open class AVAssetWriter: NSObject {
    public struct Status: Hashable, RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let unknown = Status(rawValue: 0)
        public static let writing = Status(rawValue: 1)
        public static let completed = Status(rawValue: 2)
        public static let failed = Status(rawValue: 3)
        public static let cancelled = Status(rawValue: 4)
    }
    open var status: Status { get { fatalError() } set { fatalError() } }
    open var error: Error? { get { fatalError() } set { fatalError() } }
    open var outputURL: URL { get { fatalError() } set { fatalError() } }
    public init(outputURL: URL, fileType: AVFileType) throws { super.init() }
    open func canApply(outputSettings: [String: Any]?, forMediaType mediaType: AVMediaType) -> Bool { false }
    open func add(_ input: AVAssetWriterInput) {}
    open func startWriting() -> Bool { false }
    open func startSession(atSourceTime startTime: CMTime) {}
    open func endSession(atSourceTime endTime: CMTime) {}
    open func finishWriting(completionHandler handler: @escaping () -> Void) {}
    open func finishWriting() -> Bool { false }
    open func cancelWriting() {}
    open func canAdd(_ input: AVAssetWriterInput) -> Bool { false }
}

public struct AVFileType: Hashable, RawRepresentable {
    public var rawValue: String
    public init(rawValue: String) { self.rawValue = rawValue }
    public static let mp4 = AVFileType(rawValue: "public.mpeg-4")
    public static let mov = AVFileType(rawValue: "com.apple.quicktime-movie")
}

public struct AVMediaType: Hashable, RawRepresentable {
    public var rawValue: String
    public init(rawValue: String) { self.rawValue = rawValue }
    public static let video = AVMediaType(rawValue: "vide")
    public static let audio = AVMediaType(rawValue: "soun")
}

public struct AVVideoCodecType: Hashable, RawRepresentable {
    public var rawValue: String
    public init(rawValue: String) { self.rawValue = rawValue }
    public static let h264 = AVVideoCodecType(rawValue: "avc1")
    public static let hevc = AVVideoCodecType(rawValue: "hvc1")
    public static let jpeg = AVVideoCodecType(rawValue: "jpeg")
}

public let AVVideoCodecKey = "AVVideoCodecKey"
public let AVVideoWidthKey = "AVVideoWidthKey"
public let AVVideoHeightKey = "AVVideoHeightKey"
public let AVVideoCompressionPropertiesKey = "AVVideoCompressionPropertiesKey"
public let AVVideoAverageBitRateKey = "AVVideoAverageBitRateKey"
public let AVVideoProfileLevelKey = "AVVideoProfileLevelKey"
public let AVVideoMaxKeyFrameIntervalKey = "AVVideoMaxKeyFrameIntervalKey"
public let AVVideoExpectedSourceFrameRateKey = "AVVideoExpectedSourceFrameRateKey"
public let AVVideoAllowFrameReorderingKey = "AVVideoAllowFrameReorderingKey"
public let AVVideoAverageNonDroppableFrameRateKey = "AVVideoAverageNonDroppableFrameRateKey"

open class AVAsset: NSObject {
    open var duration: CMTime { get { fatalError() } set { fatalError() } }
    open var tracks: [AVAssetTrack] { get { fatalError() } set { fatalError() } }
}

open class AVAssetTrack: NSObject {
    open var naturalSize: CGSize { get { fatalError() } set { fatalError() } }
}

public let AVFormatIDKey = "AVFormatID"
public let AVSampleRateKey = "AVSampleRateKey"
public let AVNumberOfChannelsKey = "AVNumberOfChannelsKey"
public let AVEncoderBitRateKey = "AVEncoderBitRateKey"
public let AVEncoderBitRatePerChannelKey = "AVEncoderBitRatePerChannelKey"
public let AVLinearPCMBitDepthKey = "AVLinearPCMBitDepth"
public let AVLinearPCMIsFloatKey = "AVLinearPCMIsFloat"
public let AVChannelLayoutKey = "AVChannelLayoutKey"
public let AVSampleRateConverterAlgorithmKey = "AVSampleRateConverterAlgorithm"

public let kAudioFormatMPEG4AAC: UInt32 = 0x61616320
public let kAudioFormatLinearPCM: UInt32 = 0x6C70636D

open class AVPlayer: NSObject {}
open class AVPlayerItem: NSObject {}
open class AVPlayerLayer: NSObject {}
open class AVAudioPlayer: NSObject {}
open class AVURLAsset: AVAsset {
    public init(url: URL, options: [String: Any]? = nil) { super.init() }
}
