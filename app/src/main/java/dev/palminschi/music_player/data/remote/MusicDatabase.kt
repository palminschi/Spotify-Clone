package dev.palminschi.music_player.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import dev.palminschi.music_player.data.entities.Song
import dev.palminschi.music_player.utils.Constants
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(Constants.SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}