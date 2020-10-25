package react.bootstrap.lib.react.rprops.tags

import react.bootstrap.lib.react.rprops.WithGlobalAttributes

interface WithAttributesA : WithGlobalAttributes {
    var href: String?
    var target: String?
    var ping: String?
    var rel: String?
    var hrefLang: String?
    var type: String?
}
