package languages.com.github.lilei.languagesswitch

import android.content.Intent
import android.os.Build
import kotlinx.android.synthetic.main.activity_main.*
import languages.com.github.lilei.languagesswitch.utils.AppLanguageUtils
import languages.com.github.lilei.languagesswitch.utils.Constants
import languages.com.github.lilei.languagesswitch.utils.SpUtils

/**
 * @Description:
 * @author: lll
 * @date: 2018/8/7
 */
class MainActivity : BaseActivity() {

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initViewAndData() {
        setting.setOnClickListener {
            SecondActivity.start(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Constants.CHANGE_LANGUAGE && resultCode == RESULT_OK) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                AppLanguageUtils.changeAppLanguage(this, SpUtils.getString(Constants.LANGUAGE_TYPE, "")!!)
                AppLanguageUtils.changeAppLanguage(BaseApplication.mContext!!, SpUtils.getString(Constants.LANGUAGE_TYPE, "")!!)
            }
            recreate()
            //重新启动Activity
//            mActivity?.finish()
//            HomeActivity.start(mContext!!, true)
//            mActivity?.overridePendingTransition(0, 0)
        }
    }
}
