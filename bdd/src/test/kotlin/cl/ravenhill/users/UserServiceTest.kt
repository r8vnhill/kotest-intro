package cl.ravenhill.users

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

private const val USER = "ichigo"
private const val PASSWORD = "shinigami123"

class UserServiceTest : FreeSpec({
    lateinit var userService: UserService

    beforeEach {
        userService = UserService()
    }

    "A user service" - {
        "when registering a new user" - {
            "should have the user in the database" {
                userService.register(USER, PASSWORD)
                userService.users.contains(USER) shouldBe true
            }
        }

        "when registering an existing user" - {
            "should throw an exception" {
                userService.register(USER, PASSWORD)
                shouldThrow<IllegalArgumentException> {
                    userService.register(USER, PASSWORD)
                }.message shouldBe "User already exists"
            }
        }
    }
})
