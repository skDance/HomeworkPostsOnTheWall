import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post1 = Post(ownerId = 14, fromId = 55, text = "Hello Test!", date = 1662740214)
        val post2 = Post(ownerId = 11, fromId = 102, text = "Hello Test!", date = 1662740214)
        WallService.add(post1)
        WallService.add(post2)
        assertTrue(post2.id != 0)
    }

    @Test
    fun updateTrue() {
        val post1 = Post(ownerId = 14, fromId = 55, text = "Hello Test!", date = 1662740214)
        WallService.add(post1)
        val post2 = Post(id = 0, ownerId = 11, fromId = 102, text = "Hello Test!", date = 1662740214)
        WallService.update(post2)
    }

    @Test
    fun updateFalse() {
        val post1 = Post(ownerId = 14, fromId = 55, text = "Hello Test!", date = 1662740214)
        WallService.add(post1)
        val post2 = Post(id = 2, ownerId = 11, fromId = 102, text = "Hello Test!", date = 1662740214)
        WallService.update(post2)
    }
}