package react.bootstrap.content.typography.heading

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet
import kotlin.reflect.KClass

inline fun RBuilder.heading(
    size: Heading.Sizes,
    rendererTag: KClass<out CommonAttributeGroupFacade>,
    classes: String?,
    crossinline block: RHandler<Heading.Props>
): ReactElement = child(Heading::class) {
    attrs {
        this.size = size
        this.rendererTag = rendererTag
        this.classes = classes.splitClassesToSet()
    }

    block()
}

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h1(
    classes: String? = null,
    noinline block: RHandler<Heading.Props>
): ReactElement =
    heading(Heading.Sizes.H1, TT::class, classes, block)

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h2(
    classes: String? = null,
    noinline block: RHandler<Heading.Props>
): ReactElement =
    heading(Heading.Sizes.H2, TT::class, classes, block)

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h3(
    classes: String? = null,
    noinline block: RHandler<Heading.Props>
): ReactElement =
    heading(Heading.Sizes.H3, TT::class, classes, block)

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h4(
    classes: String? = null,
    noinline block: RHandler<Heading.Props>
): ReactElement =
    heading(Heading.Sizes.H4, TT::class, classes, block)

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h5(
    classes: String? = null,
    noinline block: RHandler<Heading.Props>
): ReactElement =
    heading(Heading.Sizes.H5, TT::class, classes, block)

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h6(
    classes: String? = null,
    noinline block: RHandler<Heading.Props>
): ReactElement =
    heading(Heading.Sizes.H6, TT::class, classes, block)
