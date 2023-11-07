package com.example.chplaydemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameList: Array<String> = resources.getStringArray(R.array.nameList)
        val nameApp: Array<String> = resources.getStringArray(R.array.nameApp)
        val rate: Array<String> = resources.getStringArray(R.array.rate)
        val imageResource: Array<Int> =
            arrayOf(
                R.drawable.i0, R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4,
                R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8, R.drawable.i9,
                R.drawable.i10, R.drawable.i11, R.drawable.i12, R.drawable.i13, R.drawable.i14,
                R.drawable.i5, R.drawable.i16, R.drawable.i17, R.drawable.i18, R.drawable.i19,
                R.drawable.i20, R.drawable.i21, R.drawable.i22, R.drawable.i23, R.drawable.i24
            )

        val title1 = findViewById<TextView>(R.id.title1)
        title1.text = nameList[0]
        val childAdapter1 = arrayListOf<Application>()
        for (i in 0..4) {
            childAdapter1.add(Application(imageResource[i], nameApp[i], rate[i]))
        }
        var child1 = findViewById<RecyclerView>(R.id.recycler_view_child1)
        child1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        child1.adapter = RecyclerViewChild(childAdapter1)

        val title2 = findViewById<TextView>(R.id.title2)
        title2.text = nameList[1]
        val childAdapter2 = arrayListOf<Application>()
        for (i in 5..9) {
            childAdapter2.add(Application(imageResource[i], nameApp[i], rate[i]))
        }
        var child2 = findViewById<RecyclerView>(R.id.recycler_view_child2)
        child2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        child2.adapter = RecyclerViewChild(childAdapter2)

        val title3 = findViewById<TextView>(R.id.title3)
        title3.text = nameList[0]
        val childAdapter3 = arrayListOf<Application>()
        for (i in 10..14) {
            childAdapter3.add(Application(imageResource[i], nameApp[i], rate[i]))
        }
        var child3 = findViewById<RecyclerView>(R.id.recycler_view_child3)
        child3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        child3.adapter = RecyclerViewChild(childAdapter1)
    }
}

data class Application(val imageResource: Int, val name: String, val rate: String)

class RecyclerViewChild(val apps: ArrayList<Application>) :
    RecyclerView.Adapter<RecyclerViewChild.MyViewHolder>() {
    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val image = row.findViewById<ImageView>(R.id.image_app)
        val name = row.findViewById<TextView>(R.id.name_app)
        val rate = row.findViewById<TextView>(R.id.rate_app)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.app, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(apps[position].imageResource)
        holder.name.text = apps[position].name
        holder.rate.text = apps[position].rate
    }

    override fun getItemCount(): Int = apps.size
}

/*
data class ListOfApplication(val title: String, var recyclerViewChild: RecyclerView)

class RecyclerViewParent(val rcChildren: ArrayList<ListOfApplication>) :
    RecyclerView.Adapter<RecyclerViewParent.MyViewHolder>() {
    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val title = row.findViewById<TextView>(R.id.title)
        var recyclerViewChild = row.findViewById<RecyclerView>(R.id.recycler_view_child)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_child, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = rcChildren[position].title
        holder.recyclerViewChild = rcChildren[position].recyclerViewChild
    }

    override fun getItemCount(): Int = rcChildren.size
}
*/