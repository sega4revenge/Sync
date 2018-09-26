package nhuviet.sync.Model

import io.realm.RealmObject

class Person : RealmObject() {

    var id: String? = null
    var name: String? = null
    var title: String? = null
    var img_lol: String? = null


    override fun toString(): String {
        return "Person(id=$id, name=$name, title=$title, img_lol=$img_lol)"
    }


}