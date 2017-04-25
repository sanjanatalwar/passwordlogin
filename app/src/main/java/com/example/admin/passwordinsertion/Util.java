package com.example.admin.passwordinsertion;

/**
 * Created by Admin on 22-04-2017.
 */

public class Util {

    // Information for my Database
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "data.db";

    // Information for my Table
    public static final String TAB_NAME = "Student";
    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_EMAIL = "EMAIL";

    public static final String COL_CITY = "CITY";
    public static final String COL_PASSWORD= "PASSWORD";

    public static final String CREATE_TAB_QUERY = "create table Student(" +
            "_ID integer primary key autoincrement," +
            "NAME varchar(256)," +
            "PHONE varchar(20)," +
            "EMAIL varchar(256)," +

            "CITY varchar(256)" +
            "PASSWORD varchar(256)"+
            ")";



    // URL

    public static final String INSERT_STUDENT_PHP = "http://studentedu.esy.es/password/insertt.php";
    public static final String LOGIN_STUDENT_PHP = "http://studentedu.esy.es/insert/login.php";
}
