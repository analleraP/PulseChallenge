package com.allerap.android.pulsechallenge.feature.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.allerap.android.pulsechallenge.extensions.hideLoading
import com.allerap.android.pulsechallenge.extensions.showLoading
import com.allerap.android.pulsechallenge.R
import com.allerap.android.pulsechallenge.data.entities.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configView()
    }

    private fun configView() {
        presenter = MainPresenter(this, this)
    }

    // region MainView
    override fun showLoading() {
        layout.showLoading(layoutInflater)
    }

    override fun hideLoading() {
        layout.hideLoading()
    }

    override fun handleError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showItems(items: List<Item>) {
        adapter = MainAdapter(
                items,
                object : MainAdapter.OnClickListener {
                    override fun onItemClick(item: Item) {
                        presenter.onItemClick(item.id)
                    }
                })

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    // endregion
}
