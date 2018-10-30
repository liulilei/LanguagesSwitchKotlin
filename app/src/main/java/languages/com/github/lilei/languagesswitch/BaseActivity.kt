package languages.com.github.lilei.languagesswitch

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import languages.com.github.lilei.languagesswitch.utils.AppLanguageUtils
import languages.com.github.lilei.languagesswitch.utils.Constants
import languages.com.github.lilei.languagesswitch.utils.SpUtils

/**
 *@Description:
 * @author: lll
 * @date: 2018/8/7
 */
abstract class BaseActivity : FragmentActivity() {

    var mContext: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayout())
        mContext = this
        initViewAndData()
    }

    protected abstract fun initLayout(): Int

    open fun initViewAndData() {}

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(AppLanguageUtils.attachBaseContext(newBase, SpUtils.getString(Constants.LANGUAGE_TYPE, "")!!))
    }

}