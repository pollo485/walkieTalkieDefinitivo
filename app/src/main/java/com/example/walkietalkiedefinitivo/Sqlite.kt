package com.example.walkietalkiedefinitivo
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sqlite(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
    CREATE TABLE tbUsers (
        id_Users INTEGER PRIMARY KEY AUTOINCREMENT,
        Name TEXT,
        Email TEXT,
        Password TEXT,
        Register_Date DATETIME DEFAULT (datetime('now'))
    )
""")

        db?.execSQL("""
    CREATE TABLE TbParticipants (
        Id_Participants INTEGER PRIMARY KEY AUTOINCREMENT,
        Id_Conversation INTEGER,
        Id_User INTEGER,
        Union_Date DATETIME DEFAULT (datetime('now'))
    )
""")

        db?.execSQL("""
    CREATE TABLE TbDevice (
        Id_Device INTEGER PRIMARY KEY AUTOINCREMENT,
        Id_User INTEGER,
        Device_Name TEXT
    )
""")

        db?.execSQL("""
    CREATE TABLE TbConversations (
        Id_Conversation INTEGER PRIMARY KEY AUTOINCREMENT,
        Conversation_Name TEXT,
        Date_Conversation DATETIME DEFAULT (datetime('now'))
    )
""")

        db?.execSQL("""
    CREATE TABLE TbAudio (
        Id_Audio INTEGER PRIMARY KEY AUTOINCREMENT,
        Id_Conversation INTEGER,
        File_Patch TEXT
    )
""")

    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS tbUsers")
        db?.execSQL("DROP TABLE IF EXISTS TbParticipants")
        db?.execSQL("DROP TABLE IF EXISTS TbDevice")
        db?.execSQL("DROP TABLE IF EXISTS TbConversations")
        db?.execSQL("DROP TABLE IF EXISTS TbAudio")
        onCreate(db)
        TODO("Not yet implemented")
    }

}