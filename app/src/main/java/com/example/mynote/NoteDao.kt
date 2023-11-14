package com.example.mynote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// Dao annotation digunakan untuk menandai bahwa kelas ini adalah Data Access Object (DAO)
@Dao
interface NoteDao {

    // Insert annotation menandakan bahwa metode ini digunakan untuk menyisipkan data ke dalam database
    // OnConflictStrategy.IGNORE digunakan untuk mengatasi konflik dengan mengabaikan operasi jika terdapat konflik pada primary key
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    // Update annotation menandakan bahwa metode ini digunakan untuk memperbarui data dalam database
    @Update
    fun update(note: Note)

    // Delete annotation menandakan bahwa metode ini digunakan untuk menghapus data dari database
    @Delete
    fun delete(note: Note)

    // Query annotation digunakan untuk melakukan query pada database
    // SELECT * from note_table ORDER BY id ASC
    // Mengembalikan LiveData<List<Note>> yang akan secara otomatis diperbarui saat terdapat perubahan data
    @get:Query("SELECT * from note_table ORDER BY id ASC")
    val allNotes: LiveData<List<Note>>
}
