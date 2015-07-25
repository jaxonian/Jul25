package edu.nyu.scps.jaxon.jul25;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jaxonian on 7/23/15.
 */
public class Helper extends SQLiteOpenHelper {

    public Helper(Context context, String databaseName) {
        super(context, databaseName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //a Java array of five Strings containing five SQLite statements.
        String[] statements = {


                "CREATE TABLE inventory ("
                        + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "name TEXT,"
                        + "category TEXT,"
                        + "image TEXT,"
                        + "largeimage TEXT,"
                        + "price INTEGER"
                        + ");",



                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Drawing 1', 'drawing', 'drawing_s1', 'drawing_m1', 300 );",
                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Drawing 2', 'drawing', 'drawing_s2', 'drawing_m1', 400 );",
                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Drawing 3', 'drawing', 'drawing_s3', 'drawing_m1', 300 );",
                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Drawing 4', 'drawing', 'drawing_s4', 'drawing_m1', 500 );",

                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Painting 1', 'painting', 'painting_s1', 'painting_m1', 900 );",
                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Painting 2', 'painting', 'painting_s2', 'painting_m1', 700 );",
                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Painting 3', 'painting', 'painting_s3', 'painting_m1', 600 );",
                "INSERT INTO inventory (_id, name, category, image, largeimage, price) VALUES (NULL, 'Painting 4', 'painting', 'painting_s4', 'painting_m1', 500 );"



        };

        for (String statement: statements) {
            db.execSQL(statement);
        }
    } // END ONCREATE

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor getCursor() {
        SQLiteDatabase db = getReadableDatabase(); // the db passed to onCreate
        //can say "_id, name" instead of "*", but _id must be included.
        Cursor cursor = db.rawQuery("SELECT * FROM inventory ORDER BY name;", null);
        cursor.moveToFirst();
        return cursor;
    }
} // END CLASS
