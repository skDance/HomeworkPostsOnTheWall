private var uniqId: Int = 0
private var posts = emptyArray<Post>()

fun main() {
    val post = Post(ownerId = 5, fromId = 4, text = "Hello!", date = 1662740214)
    val post2 = Post(ownerId = 5, fromId = 4, text = "Hello!", date = 1662740214)
    val post3 = Post(ownerId = 5, fromId = 4, text = "Hello!", date = 1662740214)

    println(WallService.add(post))
    println(WallService.add(post2))
    println(WallService.add(post3))

    val post7 = Post(id = 3, ownerId = 24, fromId = 55, text = "Hello everybody!", date = 1662740255)
    println(WallService.update(post7))
    println(posts[2])

}

data class Post(
    val id: Int = uniqId,
    val ownerId: Int,
    val fromId: Int,
    val likesCount: Likes = Likes(0),
    val text: String?,
    val date: Long?,
    val friendsOnly: Boolean = false,
    val commentsCount: Int = 0,
    val repostsCount: Int = 0,
    val views: Int = 0
) {
    class Likes(count: Int) {
        var count = count
        override fun toString(): String {
            return "$count"
        }
    }
}


object WallService {

    fun clear() {
        posts = emptyArray()
    }

    fun add(post: Post): Post {
        val uniqPost = post.copy(id = uniqId)
        posts += uniqPost
        uniqId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index) in posts.withIndex()) {
            val checkPost = posts[index]
            if (post.id == checkPost.id) {
                val updatePost = checkPost.copy(
                    id = post.id, fromId = post.fromId, text = post.text, friendsOnly = post.friendsOnly,
                    commentsCount = post.commentsCount, repostsCount = post.repostsCount, views = post.views
                )
                posts.set(index, updatePost)
                return true
            }
        }
        return false
    }
}