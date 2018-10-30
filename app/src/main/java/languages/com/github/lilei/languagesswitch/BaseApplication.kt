package languages.com.github.lilei.languagesswitch

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import languages.com.github.lilei.languagesswitch.utils.AppLanguageUtils
import languages.com.github.lilei.languagesswitch.utils.Constants
import languages.com.github.lilei.languagesswitch.utils.SpUtils

/**
 *@Description:
 * @author: lll
 * @date: 2018/8/6
 */
class BaseApplication : Application() {

    companion object {
        var mInstance: BaseApplication? = null

        var mContext: Context? = null

        fun getInstance(): BaseApplication? {
            return mInstance
        }

    }

    override fun onCreate() {
        super.onCreate()
        if (mInstance == null) {
            mInstance = this
        }
        mContext = applicationContext

        onLanguageChange()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(AppLanguageUtils.attachBaseContext(base,
                base.getSharedPreferences(SpUtils.SP_FILE_NAME, Context.MODE_PRIVATE).getString(Constants.LANGUAGE_TYPE, "")!!))
    }

    /**
     * Handling Configuration Changes
     *
     * @param newConfig newConfig
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        onLanguageChange()
    }

    private fun onLanguageChange() {
        AppLanguageUtils.changeAppLanguage(mContext!!, SpUtils.getString(Constants.LANGUAGE_TYPE, "")!!)
    }

}