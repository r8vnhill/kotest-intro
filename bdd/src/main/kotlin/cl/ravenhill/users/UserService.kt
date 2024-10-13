package cl.ravenhill.users

class UserService {
    private val _users = mutableMapOf<String, String>()
    val users: List<String>
        get() = _users.keys.toList()

    fun register(username: String, password: String) {
        require(username !in _users) { "User already exists" }
        _users[username] = password
    }
}
