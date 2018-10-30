package languages.com.github.lilei.languagesswitch.utils

import android.content.Context
import android.content.SharedPreferences
import languages.com.github.lilei.languagesswitch.BaseApplication


/**
 * @author liulilei
 * 操作sp的工具类
 */
object SpUtils {
    const val SP_FILE_NAME = "languageSwitch"
    private var sp: SharedPreferences? = null

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sp!!.getBoolean(key, defValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putBoolean(key, value).commit()
    }

    fun getString(key: String, defValue: String): String? {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sp!!.getString(key, defValue)
    }

    fun putString(key: String, value: String) {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putString(key, value).commit()
    }

    fun getInt(key: String, defValue: Int): Int {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sp!!.getInt(key, defValue)
    }

    fun putInt(key: String, value: Int) {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putInt(key, value).commit()
    }

    fun getLong(key: String, defValue: Long?): Long {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME,
                    Context.MODE_PRIVATE)
        }
        return sp!!.getLong(key, defValue!!)
    }

    fun putLong(key: String, value: Long?) {
        if (sp == null) {
            sp = BaseApplication.getInstance()!!.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putLong(key, value!!).commit()
    }
}
