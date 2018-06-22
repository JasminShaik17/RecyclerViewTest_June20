package cubex.mahesh.recyclerviewtest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var cview:CircleImageView = itemView!!.findViewById(R.id.cview)
    var tv1:TextView = itemView!!.findViewById(R.id.name)
    var tv2:TextView = itemView!!.findViewById(R.id.size)
    var del:Button = itemView!!.findViewById(R.id.del)

}