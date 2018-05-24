package com.sx.common_base.db;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.common.base.config.PreferencesManager;
import com.common.utils.LogUtils;
import com.sx.common_base.constant.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yonggege on 2017/11/28.
 */

public class MallDBManager{
    private final int BUFFER_SIZE = 400000;

    public static final String DB_NAME = "mall.db"; //保存的数据库文件名

    public static String PACKAGE_NAME = "com.ffu365.android";

    public static String DB_PATH = "";  //在手机里存放数据库的位置
    public static String TABLE_NAME = "mw_area";
    private SQLiteDatabase database;

    private Context context;

    public MallDBManager(Context context){
        this.context = context;
    }

    public void openDatabase(){
        PACKAGE_NAME = context.getPackageName();
        DB_PATH = "data/data/" + PACKAGE_NAME + "/databases";
        this.database = this.openDatabase1(DB_PATH + "/" + DB_NAME);
    }

    public SQLiteDatabase getDatabase(){
        Log.e("cc", "getDatabase()");
        return this.database;
    }

    private SQLiteDatabase openDatabase1(String dbfile){
        try{
            LogUtils.e("Database", "11111111111");
            if(!(new File(dbfile).exists())){//判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
                LogUtils.e("Database", "new a DB");
                AssetManager am= context.getAssets();
                InputStream is = am.open("mall.db"); //欲导入的数据库
                File file = new File(dbfile);
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while((count = is.read(buffer)) > 0){
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,
                    null);
            PreferencesManager.getInstance().saveParam(Configuration.IS_FIRST_INIT, false);
            LogUtils.e("Database", "ok......");
            return db;
        }catch(FileNotFoundException e){
            LogUtils.e("Database", "File not found");
            e.printStackTrace();
        }catch(IOException e){
            LogUtils.e("Database", "IO exception");
            e.printStackTrace();
        }
        LogUtils.e("Database", "error");
        return null;
    }

    public void closeDatabase() {
        Log.e("cc", "closeDatabase()");
        if(this.database!=null)
            this.database.close();
    }
}
