package nhuviet.sync

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmList
import kotlinx.android.synthetic.main.activity_main_sync.*
import nhuviet.sync.Adapter.Apdapter_Recycle_LOL
import nhuviet.sync.Check.Check
import nhuviet.sync.Model.Person
import nhuviet.sync.Presenter.Presenter_Sync

class MainActivity_sync : AppCompatActivity(),Presenter_Sync.IPresenter_Sync  {

    var mPresenter_Sync : Presenter_Sync? = null

    val marr_Person = RealmList<Person>()
    var layoutManager: LinearLayoutManager? = null
    var mcheck : Check? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sync)

        mcheck = Check(this)
        if (mcheck!!.isConnected()){
            Realm.init(this)
            mPresenter_Sync = Presenter_Sync(this)
            mPresenter_Sync!!.get_Infor_Sync()
            Toast.makeText(this,"Connect Internet",Toast.LENGTH_SHORT).show()

//          mPresenter_Sync = Presenter_Sync(this)
            mPresenter_Sync!!.save_to_data("a","b","c","d")
        }else{
            Toast.makeText(this,"No Connect Internet",Toast.LENGTH_SHORT).show()
        }
    }

    override fun ViewJson_Sync(arrList_LoL: RealmList<Person>) {
//        Log.d("Log_sync", arrList_LoL[0]!!.name)
        val recycler_products = Apdapter_Recycle_LOL(this,arrList_LoL)
        layoutManager = LinearLayoutManager(this)
        layoutManager?.reverseLayout = true
        layoutManager?.stackFromEnd = true
        rc_lol.layoutManager = layoutManager
        rc_lol.adapter = recycler_products
        recycler_products.notifyDataSetChanged()

    }

    override fun setErrorNotFound() {
       Toast.makeText(this,"Not Data !",Toast.LENGTH_SHORT).show()
    }

    override fun setErrorMessage(errorMessage: String) {
        Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show()
        Log.d("Log_sync", "Lỗi : $errorMessage")
    }

}
