package react.bootstrap.lib.bootstrap

class Contextual {
    enum class Background(val className: ClassNames) {
        DANGER(ClassNames.BG_DANGER),
        DARK(ClassNames.BG_DARK),
        INFO(ClassNames.BG_INFO),
        LIGHT(ClassNames.BG_LIGHT),
        PRIMARY(ClassNames.BG_PRIMARY),
        SECONDARY(ClassNames.BG_SECONDARY),
        SUCCESS(ClassNames.BG_SUCCESS),
        TRANSPARENT(ClassNames.BG_TRANSPARENT),
        WARNING(ClassNames.BG_WARNING),
        WHITE(ClassNames.BG_WHITE);
    }
}
