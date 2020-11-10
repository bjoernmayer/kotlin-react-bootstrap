package react.bootstrap.components.nav

import kotlinext.js.clone
import kotlinext.js.jsObject
import kotlinx.html.A
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NavLinkTest {
    @Test
    fun testOnActiveIsCalledOnMount() {
        var initial = false

        val component = NavLink(
            jsObject {
                active = false
                onActive = { initial = true }
                domHandler = { }
                domClass = A::class
            }
        )
        component.state.active = true
        component.componentDidMount()

        assertTrue {
            initial
        }
    }

    @Test
    fun testStateIsUpdatedOnComponentDidUpdate() {
        var initial = false

        val props: NavLink.Props = jsObject {
            active = false
            onActive = { initial = true }
            domHandler = { }
            domClass = A::class
        }

        val component = NavLink(clone(props))

        assertFalse { component.state.active == true }

        component.props.active = true

        component.componentDidMount()
        component.componentDidUpdate(
            props,
            component.state,
            Any()
        )

        assertTrue {
            initial
        }
    }
}
