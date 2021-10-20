package webflux

import reactor.core.publisher.Flux

fun main() {
    val users = listOf(User(1, "KIM", UserStatus.ACTIVE), User(2, "LEE", UserStatus.DORMANCY))

    Flux.fromIterable(users)
        .doOnNext { println("doOnNext - 1 : $it") }
        .map { changeStatus(it) }
        .doOnNext { println("doOnNext - 2 : $it") }
        .subscribe()
}

fun changeStatus(user: User): User {
    user.status = if (UserStatus.ACTIVE.equals(user.status)) {
        UserStatus.DORMANCY
    } else if (UserStatus.DORMANCY.equals(user.status)) {
        UserStatus.DELETED
    } else {
        UserStatus.ACTIVE
    }
    return user
}

data class User(
    var id: Long,
    var name: String,
    var status: UserStatus
)

enum class UserStatus {
    ACTIVE, DORMANCY, DELETED
}