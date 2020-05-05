package react.bootstrap.site.components.docs.content.code

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Code : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Code")
        pageLead {
            +"Documentation and examples for displaying inline and multiline blocks of code with Bootstrap."
        }
        child(CodeBlocks::class)
    }
}
