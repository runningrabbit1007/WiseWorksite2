/*
package com.sx.common_base.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.common.utils.LogUtils;
import com.sx.common_base.bean.CityItemBean;
import com.sx.common_base.bean.MallCityItemBean;
import com.sx.common_base.db.DBManager;
import com.sx.common_base.db.MallDBManager;

import java.util.ArrayList;

*/
/**
 * 
 * ============================================================
 * 
 * project name : TiantianFangFu
 * 
 * copyright ZENG HUI (c) 2015
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On June, 2015
 * 
 * description :
 * 
 * revision history :
 * 
 * ============================================================
 * 
 *//*

public class PlaceUtil {
	private static DBManager dbm;
	private static MallDBManager mallDBManager;
	private static SQLiteDatabase db;

	*/
/**
	 * 获得省份
	 *//*

	public static ArrayList<CityItemBean> getArea(Context context, int parent_id) {
		ArrayList<CityItemBean> list = new ArrayList<CityItemBean>();
		CityItemBean bean = new CityItemBean();
		bean.setName("不限");
		bean.setId(-1);
		list.add(bean);
		list.addAll(getAreaNoAll(context, parent_id));
		return list;
	}

	*/
/**
	 * 根据名字得到对象
	 *//*

	public static CityItemBean getCityItemBeanByName(String name,
			Context context) {
		dbm = new DBManager(context.getApplicationContext());
		dbm.openDatabase();
		db = dbm.getDatabase();
		try {
			String sql = "select id from v2_cities where name like '%" + name
					+ "%'";
			Cursor cursor = db.rawQuery(sql, null);
			CityItemBean bean = new CityItemBean();
			bean.setName(name);
			cursor.moveToFirst();
			bean.setId(cursor.getInt(0));
			bean.setCityCode(cursor.getString(cursor
					.getColumnIndex("city_code")));
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (db != null)
			db.close();
		dbm.closeDatabase();
		return null;
	}

	*/
/**
	 * 得到查找的数据，没有
	 *
	 * @param context
	 * @param parent_id
	 * @return
	 *//*

	public static ArrayList<CityItemBean> getAreaNoAll(Context context,
			int parent_id) {
		dbm = new DBManager(context.getApplicationContext());
		dbm.openDatabase();
		db = dbm.getDatabase();
		ArrayList<CityItemBean> list = new ArrayList<CityItemBean>();
		try {
			String sql = "select id,name,city_code from v2_cities where parent_id=" + parent_id;
			Cursor cursor = db.rawQuery(sql, null);
			LogUtils.e("parent_id = " + parent_id + "  select number = "
					+ cursor.getCount());
			while (cursor.moveToNext()) {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String cityCode = cursor.getString(cursor
						.getColumnIndex("city_code"));
				CityItemBean mListItem = new CityItemBean();
				mListItem.setName(name);
				mListItem.setId(id);
				mListItem.setCityCode(cityCode);
				list.add(mListItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (db != null)
			db.close();
		dbm.closeDatabase();
		return list;
	}

	*/
/**
	 * 获得省份
	 *//*

	*/
/*public static ArrayList<MallCityItemBean> getMallArea(Context context, int parent_id) {
		ArrayList<MallCityItemBean> list = new ArrayList<MallCityItemBean>();
		MallCityItemBean bean = new MallCityItemBean();
		bean.setText("不限");
		bean.setId(-1);
		list.add(bean);
		list.addAll(getMallAreaNoAll(context, parent_id));
		return list;
	}*//*



	*/
/**
	 * 得到商城查找的数据
	 *
	 * @param context
	 * @param parent_id
	 * @return
	 *//*

	public static ArrayList<MallCityItemBean> getMallAreaNoAll(Context context,
			int parent_id) {
		mallDBManager = new MallDBManager(context.getApplicationContext());
		mallDBManager.openDatabase();
		db = mallDBManager.getDatabase();
		ArrayList<MallCityItemBean> list = new ArrayList<MallCityItemBean>();
		try {
			String sql = "select id,text,full_text from mall_cities where parent_id=" + parent_id;
			Cursor cursor = db.rawQuery(sql, null);
			LogUtils.e("parent_id = " + parent_id + "  select number = "
					+ cursor.getCount());
			while (cursor.moveToNext()) {
				int id = cursor.getInt(cursor.getColumnIndex("id"));
				String text = cursor.getString(cursor.getColumnIndex("text"));
				String full_text = cursor.getString(cursor
						.getColumnIndex("full_text"));
				MallCityItemBean mListItem = new MallCityItemBean();
				mListItem.setText(text);
				mListItem.setId(id);
				mListItem.setFull_text(full_text);
				list.add(mListItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (db != null)
			db.close();
		mallDBManager.closeDatabase();
		return list;
	}
}
*/
