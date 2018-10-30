package languages.com.github.lilei.languagesswitch

import android.app.Activity
import android.content.Intent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_second.*
import languages.com.github.lilei.languagesswitch.utils.Constants
import languages.com.github.lilei.languagesswitch.utils.SpUtils


/**
 *@Description:
 * @author: lll
 * @date: 2018/10/30
 */
class SecondActivity : BaseActivity() {

    companion object {
        fun start(context: Activity) {
            context.startActivityForResult(Intent(context, SecondActivity::class.java), Constants.CHANGE_LANGUAGE)
        }
    }

    private var list: ArrayList<String> = ArrayList()

    private var adapter: ArrayAdapter<String>? = null

    override fun initLayout(): Int {
        return R.layout.activity_second
    }

    override fun initViewAndData() {
        resources.getStringArray(R.array.pref_language_titles).forEach {
            list.add(it)
        }
        //为适配器添加数据源
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        //为listView的容器添加适配器
        listView.adapter = adapter
        //设置点击事件mlv
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            SpUtils.putString(Constants.LANGUAGE_TYPE, resources.getStringArray(R.array.pref_language_values)[position])
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}