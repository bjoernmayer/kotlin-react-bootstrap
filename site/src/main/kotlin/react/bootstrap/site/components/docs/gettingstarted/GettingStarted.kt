package react.bootstrap.site.components.docs.gettingstarted

import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.fixings.CategoryComponent
import react.bootstrap.site.components.docs.gettingstarted.introduction.Introduction

internal class GettingStarted : CategoryComponent() {
    companion object {
        val component = Category(
            "Getting started",
            "getting-started",
            GettingStarted::class
        ).apply {
            addCategory("Introduction", "introduction", Introduction::class)
        }
    }
}
