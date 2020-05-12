package react.bootstrap.lib

import kotlinx.html.HTMLTag
import react.RHandler
import react.RProps

interface WithRDOMHandler<T : HTMLTag> : RProps {
    var handler: RDOMHandler<T>
}

interface WithRHandlerBlock<T : RProps> : RProps {
    var handler: RHandler<T>
}

interface WithDomEvents : RProps {
    var onAbort: EventHandler?
    var onAnimationEnd: EventHandler?
    var onAnimationIteration: EventHandler?
    var onAnimationStart: EventHandler?
    var onBlur: EventHandler?
    var onCanPlay: EventHandler?
    var onCanPlayThrough: EventHandler?
    var onChange: EventHandler?
    var onClick: EventHandler?
    var onCompositionEnd: EventHandler?
    var onCompositionStart: EventHandler?
    var onCompositionUpdate: EventHandler?
    var onContextMenu: EventHandler?
    var onCopy: EventHandler?
    var onCut: EventHandler?
    var onDoubleClick: EventHandler?
    var onDrag: EventHandler?
    var onDragEnd: EventHandler?
    var onDragEnter: EventHandler?
    var onDragExit: EventHandler?
    var onDragLeave: EventHandler?
    var onDragOver: EventHandler?
    var onDragStart: EventHandler?
    var onDrop: EventHandler?
    var onDurationChange: EventHandler?
    var onEmptied: EventHandler?
    var onEncrypted: EventHandler?
    var onEnded: EventHandler?
    var onError: EventHandler?
    var onFocus: EventHandler?
    var onGotPointerCapture: EventHandler?
    var onInput: EventHandler?
    var onInvalid: EventHandler?
    var onKeyDown: EventHandler?
    var onKeyPress: EventHandler?
    var onKeyUp: EventHandler?
    var onLoad: EventHandler?
    var onLoadedData: EventHandler?
    var onLoadedMetadata: EventHandler?
    var onLoadStart: EventHandler?
    var onLostPointerCapture: EventHandler?
    var onMouseDown: EventHandler?
    var onMouseEnter: EventHandler?
    var onMouseLeave: EventHandler?
    var onMouseMove: EventHandler?
    var onMouseOut: EventHandler?
    var onMouseOver: EventHandler?
    var onMouseUp: EventHandler?
    var onPaste: EventHandler?
    var onPause: EventHandler?
    var onPlay: EventHandler?
    var onPlaying: EventHandler?
    var onPointerCancel: EventHandler?
    var onPointerDown: EventHandler?
    var onPointerEnter: EventHandler?
    var onPointerLeave: EventHandler?
    var onPointerMove: EventHandler?
    var onPointerOut: EventHandler?
    var onPointerOver: EventHandler?
    var onPointerUp: EventHandler?
    var onProgress: EventHandler?
    var onRateChange: EventHandler?
    var onReset: EventHandler?
    var onScroll: EventHandler?
    var onSeeked: EventHandler?
    var onSeeking: EventHandler?
    var onSelect: EventHandler?
    var onStalled: EventHandler?
    var onSubmit: EventHandler?
    var onSuspend: EventHandler?
    var onTimeUpdate: EventHandler?
    var onToggle: EventHandler?
    var onTouchCancel: EventHandler?
    var onTouchEnd: EventHandler?
    var onTouchMove: EventHandler?
    var onTouchStart: EventHandler?
    var onTransitionEnd: EventHandler?
    var onVolumeChange: EventHandler?
    var onWaiting: EventHandler?
    var onWheel: EventHandler?
}
