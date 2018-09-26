package nhuviet.sync.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import io.realm.RealmList
import nhuviet.sync.Model.Person
import nhuviet.sync.Presenter.Presenter_Sync
import nhuviet.sync.R


class Apdapter_Recycle_LOL (private var context: Context,
                            private var listInfor_Person: RealmList<Person>)
    : RecyclerView.Adapter<Apdapter_Recycle_LOL.ViewHolderLOL>(),Presenter_Sync.IPresenter_Sync {

    var mPresenter_Sync : Presenter_Sync? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Apdapter_Recycle_LOL.ViewHolderLOL {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_layout_rc_lol, parent, false)
        return ViewHolderLOL(view)
    }

    override fun getItemCount(): Int {
        return listInfor_Person.size
    }

    override fun onBindViewHolder(holder: Apdapter_Recycle_LOL.ViewHolderLOL, position: Int) {

        val infor_lol = listInfor_Person[position]

        holder.name.text = infor_lol!!.name
        holder.title.text = infor_lol.title
        Picasso.with(context).load(infor_lol.img_lol).resize(147, 184).into(holder.img_lol)

    }

    class ViewHolderLOL(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView =  itemView.findViewById(R.id.tv_name)
        var title: TextView = itemView.findViewById(R.id.tv_title )
        var img_lol : ImageView = itemView.findViewById(R.id.img_lol)
    }


    override fun ViewJson_Sync(arrList_LoL: RealmList<Person>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setErrorNotFound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setErrorMessage(errorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
