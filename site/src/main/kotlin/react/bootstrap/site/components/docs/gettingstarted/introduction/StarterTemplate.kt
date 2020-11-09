package react.bootstrap.site.components.docs.gettingstarted.introduction

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown

internal class StarterTemplate : SectionComponent() {
    override val title: String = "Starter template"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Start off with
[Bootstrap's normal Starter template](https://getbootstrap.com/docs/4.5/getting-started/introduction/#starter-template).
You do not need the Javascript files, though.

The `resources/index.html` files of this documentation looks like this:
            """
        }
        codeExample {
            attrs {
                language = "HTML"
            }
            //language=HTML
            +"""
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Kotlin React Bootstrap</title>
</head>
<body>
<div id="root"></div>
<script src="site.js"></script>
</body>
</html>
            """
        }
    }
}
