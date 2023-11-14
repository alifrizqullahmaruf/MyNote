package com.example.mynote

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity annotation digunakan untuk menandai bahwa kelas ini adalah entitas untuk penyimpanan Room database
// dengan nama tabel "note_table"
@Entity(tableName = "note_table")

// Data class untuk merepresentasikan entitas catatan (Note) yang akan disimpan dalam database Room
data class Note(
    // PrimaryKey annotation menunjukkan bahwa properti id adalah kunci utama
    // autoGenerate = true berarti nilai id akan di-generate secara otomatis oleh Room
    @PrimaryKey(autoGenerate = true)
    // NonNull annotation menandakan bahwa properti id tidak boleh memiliki nilai null
    @NonNull
    val id: Int = 0,

    // ColumnInfo annotation digunakan untuk menentukan nama kolom dalam tabel database
    // Properti title akan disimpan dalam kolom "title"
    @ColumnInfo(name = "title")
    val title: String,

    // Properti description akan disimpan dalam kolom "description"
    @ColumnInfo(name = "description")
    val description: String,

    // Properti date akan disimpan dalam kolom "date"
    @ColumnInfo(name = "date")
    val date: String
)
