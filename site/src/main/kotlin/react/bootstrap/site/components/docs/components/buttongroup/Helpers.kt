package react.bootstrap.site.components.docs.components.buttongroup

import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.components.button.ButtonGroup as ButtonGroupCmp

internal val ButtonGroupCmp.Sizes.ktN
    get() = buildNestedName(name, ButtonGroupCmp::class, this::class)

internal val ButtonGroupCmp.Appearance.nestedName
    get() = ButtonGroupCmp.Appearance::class.nestedName + ".$name"
