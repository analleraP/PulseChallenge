package com.allerap.android.pulsechallenge.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.allerap.android.pulsechallenge.extensions.hideLoading
import com.allerap.android.pulsechallenge.extensions.showLoading
import com.allerap.android.pulsechallenge.R
import com.allerap.android.pulsechallenge.data.entities.Item
import kotlinx.android.synthetic.main.activity_detail.*

fun Context.detailIntent(id: Int): Intent =
        Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_ID, id)
        }

internal const val EXTRA_ID = "extra_id"
class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        configView()
    }

    private fun configView() {
        presenter = DetailPresenter(this, intent.getIntExtra(EXTRA_ID, 0))
    }

    // region DetailView
    override fun showLoading() {
        layout.showLoading(layoutInflater)
    }

    override fun hideLoading() {
        layout.hideLoading()
    }

    override fun handleError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showItem(item: Item) {
        tvTitle.text = item.title
        tvSubtitle.text = item.subtitle
        tvBody.text = item.body
        tvDate.text = item.date
    }
    // endregion
}
