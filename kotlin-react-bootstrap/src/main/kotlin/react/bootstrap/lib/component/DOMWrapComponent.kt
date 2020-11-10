package react.bootstrap.lib.component

import kotlinx.html.attributesMapOf
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.helpers.addOrInit
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder
import kotlin.reflect.KClass
import kotlinx.html.CommonAttributeGroupFacade as CommonAttribute

/**
 * todo: add another component, which is not that generic but just needs a handler
 * A DOMWrapComponent is a pass-through component.
 * It can be rendered with any HTML Tag and gives the user full controll of the tag attributes
 *
 * @param TT Tag type
 * @param PT Prop Type
 */
abstract class DOMWrapComponent<TT : CommonAttribute, PT : DOMWrapComponent.Props<TT>, ST : RState>(props: PT) :
    RComponent<PT, ST>(props) {
    init {
        // These comparison are not senseless. The props are built using kotlin's `dynamic` keyword. Null is a possible
        // value.

        @Suppress("SENSELESS_COMPARISON")
        require(props.domClass != null) {
            "Missing property: domClass must not be null!"
        }

        @Suppress("SENSELESS_COMPARISON")
        require(props.domHandler != null) {
            "Missing property: domHandler must not be null!"
        }
    }

    protected open fun RDOMBuilder<TT>.build() { }

    /**
     * @return A set of [ClassNames] values used to render this component
     */
    protected abstract fun buildClasses(): Set<ClassNames>

    final override fun RBuilder.render() {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        val rROMBuilder = RDOMBuilder { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = props.domClass.js
            val attributes = attributesMapOf("class", null)

            js("new constructor(attributes, tagConsumer)") as TT
        }

        child(
            rROMBuilder
                .apply {
                    attrs {
                        classes = props.classes.addOrInit(buildClasses())
                    }

                    build()

                    props.domHandler.invoke(this)
                }
                .create()
        )
    }

    interface Props<TT : CommonAttribute> : WithGlobalAttributes {
        var domClass: KClass<TT>
        var domHandler: RDOMHandler<TT>
    }

    companion object {
        inline fun <reified TT : CommonAttribute, reified PT : Props<TT>> RBuilder.domWrapComponent(
            classes: String? = null,
            klazz: KClass<out DOMWrapComponent<*, *, *>>,
            crossinline handler: RHandler<PT> = { },
            noinline domHandler: RDOMHandler<TT>,
        ): ReactElement {

            @Suppress("UNCHECKED_CAST")
            val componentKlazz: KClass<out DOMWrapComponent<*, PT, *>> = klazz as KClass<out DOMWrapComponent<*, PT, *>>

            return child(componentKlazz) {
                attrs {
                    this.classes = classes.splitClassesToSet()
                    this.domHandler = domHandler
                    domClass = TT::class
                }

                handler()
            }
        }
    }
}
