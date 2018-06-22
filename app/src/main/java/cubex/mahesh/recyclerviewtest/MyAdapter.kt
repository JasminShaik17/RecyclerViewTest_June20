package cubex.mahesh.recyclerviewtest

import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.io.File

class MyAdapter: RecyclerView.Adapter<MyHolder>{

    var path:String? = null
    var file:File? = null
    var files:Array<File>? = null
    var inflater:LayoutInflater? = null

    constructor( mainActivity: MainActivity){
path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
file = File(path)
        if(!file!!.exists()){
 path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
 file = File(path)
        }
    files = file!!.listFiles()
        inflater = LayoutInflater.from(mainActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        var view = inflater?.inflate(R.layout.indiview,parent,
                false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
                return  files!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var f: File = files!!.get(position)
        var bmp = BitmapFactory.decodeFile(f.path)
        holder.cview.setImageBitmap(bmp)
        holder.tv1.text = f.name
        holder.tv2.text = "${f.length()} bytes"
        holder.del.setOnClickListener({
            f.delete()
            files = file!!.listFiles()
            this@MyAdapter.notifyDataSetChanged()
        })
    }


}