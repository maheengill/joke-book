package com.example.jokebook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Random;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "myAppDB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createJokesTablesStatement = "CREATE TABLE Jokes (" +
                "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "joke       TEXT NOT NULL," +
                "categoryId INTEGER NOT NULL," +
                "    FOREIGN KEY (categoryId)" +
                "       REFERENCES Categories (id) );";
        String createCategoriesTablesStatement = "CREATE TABLE Categories(id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT);";
        String insertCategories = "INSERT INTO Categories (id, category) VALUES (1, 'general'), (2, 'knock-knock'), (3, 'programming');";


        db.execSQL(createCategoriesTablesStatement);
        db.execSQL(createJokesTablesStatement);
        db.execSQL(insertCategories);
        db.execSQL("INSERT INTO Jokes (joke, categoryId) VALUES ('I invented a new word!\n" +
                "Plagiarism!', 1)");
        db.execSQL("INSERT INTO Jokes (joke, categoryId) VALUES ('Hear about the new restaurant called Karma?\n" +
                "There’s no menu: You get what you deserve.', 1)");
        db.execSQL("INSERT INTO Jokes (joke, categoryId) VALUES ('Who’s there?\n" +
                "Tank.\n" +
                "Tank who?\n" +
                "You’re welcome.', 2)");
        db.execSQL("INSERT INTO Jokes (joke, categoryId) VALUES ('Who’s there?\n" +
                "Luke.\n" +
                "Luke who?\n" +
                "Luke through the peep hole and find out.', 2)");
        db.execSQL("INSERT INTO Jokes (joke, categoryId) VALUES ('There are only 10 kinds of people in this world: those who know binary and those who don’t.', 3)");
        db.execSQL("INSERT INTO Jokes (joke, categoryId) VALUES ('Q. How did the programmer die in the shower?\n" +
                "A. He read the shampoo bottle instructions: Lather. Rinse. Repeat.', 3)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Jokes");
        db.execSQL("DROP TABLE IF EXISTS Categories");
        onCreate(db);
    }

    public String getGeneralJoke() {
        SQLiteDatabase db = getReadableDatabase();
        Random rand = new Random();
        Cursor jokesCursor = db.rawQuery("SELECT * FROM Jokes WHERE categoryId=1", null);
        jokesCursor.moveToFirst();
        int count = jokesCursor.getCount();
         for (int i = 0; i < rand.nextInt(jokesCursor.getCount()); i++){
            jokesCursor.moveToNext();
        }
        return jokesCursor.getString(1);

    }

    public String getKnockKnockJoke() {
        SQLiteDatabase db = getReadableDatabase();
        Random rand = new Random();
        Cursor jokesCursor = db.rawQuery("SELECT * FROM Jokes WHERE categoryId=2", null);
        jokesCursor.moveToFirst();
        int count = jokesCursor.getCount();
        for (int i = 0; i < rand.nextInt(jokesCursor.getCount()); i++){
            jokesCursor.moveToNext();
        }
        return jokesCursor.getString(1);
    }

    public String getProgrammingJoke() {
        SQLiteDatabase db = getReadableDatabase();
        Random rand = new Random();
        Cursor jokesCursor = db.rawQuery("SELECT * FROM Jokes WHERE categoryId=3", null);
        jokesCursor.moveToFirst();
        int count = jokesCursor.getCount();
        for (int i = 0; i < rand.nextInt(jokesCursor.getCount()); i++){
            jokesCursor.moveToNext();
        }
        return jokesCursor.getString(1);
    }
}
