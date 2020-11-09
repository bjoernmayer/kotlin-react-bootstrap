package react.bootstrap.site.components.docs.gettingstarted.introduction

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Introduction : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Introduction")
        pageLead {
            +"Learn how to include Kotlin React Bootstrap in your project."
        }
        child(Installation::class)
        child(StarterTemplate::class)
    }
}
