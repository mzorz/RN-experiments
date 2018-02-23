package com.example.mariozorz.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings


class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private val OVERLAY_PERMISSION_REQ_CODE = 234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testEdit = findViewById<EditText>(R.id.testedit)

        testEdit.addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(text: Editable) {
                        Log.d("NORMAL TEST", "afterTextChanged: \"" + text + "\"")
                    }

                    override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) {
                        Log.d("NORMAL TEST", "beforeTextChanged: \"" + text + "\" start: " + start + " count: " + count + " after: " + after)
                    }

                    override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                        //Log.d("NORMAL TEST", "onTextChanged: \"" + text + "\" start: " + start + " count: " + count)
                        Log.d("NORMAL TEST", "onTextChanged: \"" + text + "\" start: " + start + "\" before: " + before + " count: " + count)
                    }
                }
        )

        val testMario = TestEditMario(testEdit)
        testMario.addExampleFilter()

        //testEdit.filters =
        testEdit.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                Log.d("NORMAL TEST", "KEYEVENT: \"" + event.getAction() + "\"")
                when (event.getAction()) {
                    KeyEvent.ACTION_DOWN -> {
                        Log.d("NORMAL TEST", "KEYDOWN: \"" + keyCode + "\"")
                    }
                    KeyEvent.ACTION_UP -> {
                        Log.d("NORMAL TEST", "KEYUP: \"" + keyCode + "\"")
                    }
                }
                return false
            }
        })



        // RECYCLERVIEW TEST
        // use a linear layout manager
        mRecyclerView = findViewById(R.id.my_recycler_view)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = mLayoutManager

        // specify an adapter (see also next example)
        var itemList = ArrayList<ItemData>()
        itemList.add(ItemData("test1", "test"))
        itemList.add(ItemData("test2", "test"))
        itemList.add(ItemData("test3", "test"))
        itemList.add(ItemData("test4", "test"))
        itemList.add(ItemData("test5", "test"))
        itemList.add(ItemData("test6", "test"))
        itemList.add(ItemData("test7", "test"))
        itemList.add(ItemData("test8", "test"))
        itemList.add(ItemData("test9", "test"))
        itemList.add(ItemData("test10", "test"))
        itemList.add(ItemData("test11", "test"))
        itemList.add(ItemData("test12", "test"))
        itemList.add(ItemData("test13", "test"))
        itemList.add(ItemData("test14", "test"))
        itemList.add(ItemData("test15", "test"))
        itemList.add(ItemData("test16", "test"))
        itemList.add(ItemData("test17", "test"))
        itemList.add(ItemData("test18", "test"))
        itemList.add(ItemData("test19", "test"))

        mAdapter =  MyAdapter(itemList);
        mRecyclerView?.setAdapter(mAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + packageName))
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                }
            }
        }
    }

    class MyAdapter(private val items: ArrayList<ItemData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>()  {
        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            val item = items[position]
            holder?.bindItemData(item)
        }

        override fun getItemCount() = items.size

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyAdapter.ViewHolder {
            val inflatedView = LayoutInflater.from(parent?.context).inflate(R.layout.item_row, parent, false)
            return ViewHolder(inflatedView)

        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
            private var view: View = v

            init {
                v.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                Log.d("RecyclerView", "CLICK!")
            }

            fun bindItemData(item: ItemData) {
                view.itemTitle.text = item.title
                view.itemDescription.text = item.description
            }
        }
    }

    data class ItemData(var title: String, var description: String)

}
