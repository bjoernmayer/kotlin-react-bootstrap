package react.bootstrap.lib.rprops.tags

import react.bootstrap.lib.rprops.WithGlobalAttributes

interface WithAttributesA : WithGlobalAttributes {
    var href: String?
    var target: String?
    var ping: String?
    var rel: String?
    var hrefLang: String?
    var type: String?
}
