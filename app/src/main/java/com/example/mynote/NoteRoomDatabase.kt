package com.example.mynote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Database annotation digunakan untuk mendefinisikan kelas sebagai database Room
// entities menyatakan entitas-entitas yang akan disimpan dalam database, dalam hal ini hanya Note::class
// version adalah versi database, dan exportSchema menandakan apakah akan mengekspor skema database
@Database(entities = [Note::class], version = 1, exportSchema = false)

// Kelas abstrak yang merupakan turunan dari RoomDatabase, digunakan untuk mengakses dan mengelola database Room
abstract class NoteRoomDatabase : RoomDatabase() {

    // Abstract function untuk mendapatkan objek DAO (Data Access Object) yang terkait dengan entitas Note
    abstract fun noteDao(): NoteDao?

    companion object {
        // Variabel INSTANCE digunakan untuk menyimpan instance dari database yang sudah dibuat
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        // Metode getDatabase digunakan untuk mendapatkan instance dari database,
        // menggunakan synchronized untuk menghindari akses konkuren pada pembuatan instance
        fun getDatabase(context: Context): NoteRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    // Membangun database menggunakan databaseBuilder dari Room
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database"
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
}

