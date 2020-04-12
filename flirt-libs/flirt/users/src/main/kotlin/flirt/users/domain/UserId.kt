package flirt.users.domain

import flirt.shared.domain.Identifier

class UserId(value: String) : Identifier(value) {
    override var value: String = ""
        get() = value
}
