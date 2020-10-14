@file:Suppress("DuplicatedCode")

package react.bootstrap.lib

import react.RProps
import kotlin.reflect.KProperty

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

fun WithDomEvents.transferDomEvents(props: WithDomEvents, vararg excludes: KProperty<EventHandler?>) {
    if (props::onAbort !in excludes) {
        props.onAbort?.let { onAbort = it }
    }
    if (props::onAnimationEnd !in excludes) {
        props.onAnimationEnd?.let { onAnimationEnd = it }
    }
    if (props::onAnimationIteration !in excludes) {
        props.onAnimationIteration?.let { onAnimationIteration = it }
    }
    if (props::onAnimationStart !in excludes) {
        props.onAnimationStart?.let { onAnimationStart = it }
    }
    if (props::onBlur !in excludes) {
        props.onBlur?.let { onBlur = it }
    }
    if (props::onCanPlay !in excludes) {
        props.onCanPlay?.let { onCanPlay = it }
    }
    if (props::onCanPlayThrough !in excludes) {
        props.onCanPlayThrough?.let { onCanPlayThrough = it }
    }
    if (props::onChange !in excludes) {
        props.onChange?.let { onChange = it }
    }
    if (props::onClick !in excludes) {
        props.onClick?.let { onClick = it }
    }
    if (props::onCompositionEnd !in excludes) {
        props.onCompositionEnd?.let { onCompositionEnd = it }
    }
    if (props::onCompositionStart !in excludes) {
        props.onCompositionStart?.let { onCompositionStart = it }
    }
    if (props::onCompositionUpdate !in excludes) {
        props.onCompositionUpdate?.let { onCompositionUpdate = it }
    }
    if (props::onContextMenu !in excludes) {
        props.onContextMenu?.let { onContextMenu = it }
    }
    if (props::onCopy !in excludes) {
        props.onCopy?.let { onCopy = it }
    }
    if (props::onCut !in excludes) {
        props.onCut?.let { onCut = it }
    }
    if (props::onDoubleClick !in excludes) {
        props.onDoubleClick?.let { onDoubleClick = it }
    }
    if (props::onDrag !in excludes) {
        props.onDrag?.let { onDrag = it }
    }
    if (props::onDragEnd !in excludes) {
        props.onDragEnd?.let { onDragEnd = it }
    }
    if (props::onDragEnter !in excludes) {
        props.onDragEnter?.let { onDragEnter = it }
    }
    if (props::onDragExit !in excludes) {
        props.onDragExit?.let { onDragExit = it }
    }
    if (props::onDragLeave !in excludes) {
        props.onDragLeave?.let { onDragLeave = it }
    }
    if (props::onDragOver !in excludes) {
        props.onDragOver?.let { onDragOver = it }
    }
    if (props::onDragStart !in excludes) {
        props.onDragStart?.let { onDragStart = it }
    }
    if (props::onDrop !in excludes) {
        props.onDrop?.let { onDrop = it }
    }
    if (props::onDurationChange !in excludes) {
        props.onDurationChange?.let { onDurationChange = it }
    }
    if (props::onEmptied !in excludes) {
        props.onEmptied?.let { onEmptied = it }
    }
    if (props::onEncrypted !in excludes) {
        props.onEncrypted?.let { onEncrypted = it }
    }
    if (props::onEnded !in excludes) {
        props.onEnded?.let { onEnded = it }
    }
    if (props::onError !in excludes) {
        props.onError?.let { onError = it }
    }
    if (props::onFocus !in excludes) {
        props.onFocus?.let { onFocus = it }
    }
    if (props::onGotPointerCapture !in excludes) {
        props.onGotPointerCapture?.let { onGotPointerCapture = it }
    }
    if (props::onInput !in excludes) {
        props.onInput?.let { onInput = it }
    }
    if (props::onInvalid !in excludes) {
        props.onInvalid?.let { onInvalid = it }
    }
    if (props::onKeyDown !in excludes) {
        props.onKeyDown?.let { onKeyDown = it }
    }
    if (props::onKeyPress !in excludes) {
        props.onKeyPress?.let { onKeyPress = it }
    }
    if (props::onKeyUp !in excludes) {
        props.onKeyUp?.let { onKeyUp = it }
    }
    if (props::onLoad !in excludes) {
        props.onLoad?.let { onLoad = it }
    }
    if (props::onLoadedData !in excludes) {
        props.onLoadedData?.let { onLoadedData = it }
    }
    if (props::onLoadedMetadata !in excludes) {
        props.onLoadedMetadata?.let { onLoadedMetadata = it }
    }
    if (props::onLoadStart !in excludes) {
        props.onLoadStart?.let { onLoadStart = it }
    }
    if (props::onLostPointerCapture !in excludes) {
        props.onLostPointerCapture?.let { onLostPointerCapture = it }
    }
    if (props::onMouseDown !in excludes) {
        props.onMouseDown?.let { onMouseDown = it }
    }
    if (props::onMouseEnter !in excludes) {
        props.onMouseEnter?.let { onMouseEnter = it }
    }
    if (props::onMouseLeave !in excludes) {
        props.onMouseLeave?.let { onMouseLeave = it }
    }
    if (props::onMouseMove !in excludes) {
        props.onMouseMove?.let { onMouseMove = it }
    }
    if (props::onMouseOut !in excludes) {
        props.onMouseOut?.let { onMouseOut = it }
    }
    if (props::onMouseOver !in excludes) {
        props.onMouseOver?.let { onMouseOver = it }
    }
    if (props::onMouseUp !in excludes) {
        props.onMouseUp?.let { onMouseUp = it }
    }
    if (props::onPaste !in excludes) {
        props.onPaste?.let { onPaste = it }
    }
    if (props::onPause !in excludes) {
        props.onPause?.let { onPause = it }
    }
    if (props::onPlay !in excludes) {
        props.onPlay?.let { onPlay = it }
    }
    if (props::onPlaying !in excludes) {
        props.onPlaying?.let { onPlaying = it }
    }
    if (props::onPointerCancel !in excludes) {
        props.onPointerCancel?.let { onPointerCancel = it }
    }
    if (props::onPointerDown !in excludes) {
        props.onPointerDown?.let { onPointerDown = it }
    }
    if (props::onPointerEnter !in excludes) {
        props.onPointerEnter?.let { onPointerEnter = it }
    }
    if (props::onPointerLeave !in excludes) {
        props.onPointerLeave?.let { onPointerLeave = it }
    }
    if (props::onPointerMove !in excludes) {
        props.onPointerMove?.let { onPointerMove = it }
    }
    if (props::onPointerOut !in excludes) {
        props.onPointerOut?.let { onPointerOut = it }
    }
    if (props::onPointerOver !in excludes) {
        props.onPointerOver?.let { onPointerOver = it }
    }
    if (props::onPointerUp !in excludes) {
        props.onPointerUp?.let { onPointerUp = it }
    }
    if (props::onProgress !in excludes) {
        props.onProgress?.let { onProgress = it }
    }
    if (props::onRateChange !in excludes) {
        props.onRateChange?.let { onRateChange = it }
    }
    if (props::onReset !in excludes) {
        props.onReset?.let { onReset = it }
    }
    if (props::onScroll !in excludes) {
        props.onScroll?.let { onScroll = it }
    }
    if (props::onSeeked !in excludes) {
        props.onSeeked?.let { onSeeked = it }
    }
    if (props::onSeeking !in excludes) {
        props.onSeeking?.let { onSeeking = it }
    }
    if (props::onSelect !in excludes) {
        props.onSelect?.let { onSelect = it }
    }
    if (props::onStalled !in excludes) {
        props.onStalled?.let { onStalled = it }
    }
    if (props::onSubmit !in excludes) {
        props.onSubmit?.let { onSubmit = it }
    }
    if (props::onSuspend !in excludes) {
        props.onSuspend?.let { onSuspend = it }
    }
    if (props::onTimeUpdate !in excludes) {
        props.onTimeUpdate?.let { onTimeUpdate = it }
    }
    if (props::onToggle !in excludes) {
        props.onToggle?.let { onToggle = it }
    }
    if (props::onTouchCancel !in excludes) {
        props.onTouchCancel?.let { onTouchCancel = it }
    }
    if (props::onTouchEnd !in excludes) {
        props.onTouchEnd?.let { onTouchEnd = it }
    }
    if (props::onTouchMove !in excludes) {
        props.onTouchMove?.let { onTouchMove = it }
    }
    if (props::onTouchStart !in excludes) {
        props.onTouchStart?.let { onTouchStart = it }
    }
    if (props::onTransitionEnd !in excludes) {
        props.onTransitionEnd?.let { onTransitionEnd = it }
    }
    if (props::onVolumeChange !in excludes) {
        props.onVolumeChange?.let { onVolumeChange = it }
    }
    if (props::onWaiting !in excludes) {
        props.onWaiting?.let { onWaiting = it }
    }
    if (props::onWheel !in excludes) {
        props.onWheel?.let { onWheel = it }
    }
}
