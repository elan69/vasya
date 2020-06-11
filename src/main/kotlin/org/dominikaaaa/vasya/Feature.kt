package org.dominikaaaa.vasya

/**
 * @author dominikaaaa
 * Created by dominikaaaa on 10/06/20 at 11:26
 */
open class Feature(val name: String, val description: String?, val category: Category, _enabled: Boolean = false) {

    var enabled = _enabled
        set(value) {
            if (field == value) return // Early return if field doesn't actually change
            field = value
            if (value)
                onEnable()
            else
                onDisable()
            onToggle()
        }

    open fun onEnable() {}

    open fun onDisable() {}

    open fun onToggle() {}

    open fun onUpdate() {}

    fun toggle() {
        enabled = !enabled
    }

    open fun registerUpdate() {
        if (enabled) {
            onUpdate()
        }
    }

    enum class Category(s: String) {
        PLAYER("Player"),
        WORLD("World")
    }
}