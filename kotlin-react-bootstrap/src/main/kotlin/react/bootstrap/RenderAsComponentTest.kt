package react.bootstrap

import kotlinx.html.HtmlBlockTag
import react.Children
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.createElement

class RenderAsComponentTest : RComponent<RenderAsComponentTest.Props, RState>() {
    interface Props : WithGlobalAttributes {
        var tag: HtmlBlockTag?
    }

    override fun RBuilder.render() {
        // vielleicht doch lieber nur die class vom HtmlBlockTag.
        // dann versuchen über reflection die zu instantiieren. und danach erst das create element ausführen

        // combined properties?
        // abschauen wie es mit der child(babla::class) funzt

        createElement(props.tag!!.tagName, props, *Children.toArray(props.children()))
    }
}
