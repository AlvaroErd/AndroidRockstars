package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.mango.androidrockstars.databinding.ActivityTopRatedTvDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TopRatedTvDetailActivity : ComponentActivity() {

    private val topRatedTvDetailViewModel: TopRatedTvDetailViewModel by viewModels()

    private lateinit var binding: ActivityTopRatedTvDetailBinding
    private var tvIdBundle: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTopRatedTvDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        tvIdBundle = bundle?.getInt("TV_ID")!!
        topRatedTvDetailViewModel.fetchTvShowDetail(tvIdBundle!!)

        val similarTvCompose = binding.composeSimilar
        similarTvCompose.setContent {
            val list by topRatedTvDetailViewModel.tvShowSimilar.collectAsState()
            ListSimilarTvShowCards(similarTvShowListItems = list, onItemClick = { tvId ->
                this.startActivity(newIntent(tvId, this))
            }
            )
        }


        lifecycleScope.launch(Dispatchers.IO) {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                this@TopRatedTvDetailActivity.topRatedTvDetailViewModel.tvShowDetail.collectLatest { detailId ->
                    withContext(Dispatchers.Main)
                    {
                        binding.progressBar.visibility = View.VISIBLE
                        delay(600)
                        binding.imgBackgroundTvShow.load(detailId.posterPath)
                        binding.imgBackgroundTvShow.contentDescription =
                            ("Background poster of the ${detailId.name} Tv Show")
                        binding.imgPoster.load(detailId.posterPath)
                        binding.imgPoster.contentDescription =
                            ("Poster of the ${detailId.name} Tv Show")
                        binding.txtTitle.text = detailId.name
                        binding.txtTitle.contentDescription = (detailId.name)
                        binding.txtLanguagePlaceholder.text = detailId.original_language
                        binding.txtLanguagePlaceholder.contentDescription =
                            (detailId.original_language)
                        binding.txtDescription.text = detailId.overview
                        binding.txtDescription.contentDescription = (detailId.overview)
                        binding.txtReleasedDatePlaceholder.text = detailId.first_air_date
                        binding.txtReleasedDatePlaceholder.contentDescription =
                            (detailId.first_air_date)
                        binding.txtRating.text =
                            "${detailId.voteAverage} (${detailId.voteCount} Reviews)"
                        binding.txtRating.contentDescription =
                            ("${detailId.voteAverage} votes of (${detailId.voteCount} Reviews)")
                    }
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    companion object {
        fun newIntent(tvId: Int, context: Context): Intent {
            val intent = Intent(context, TopRatedTvDetailActivity::class.java)
            intent.putExtra("TV_ID", tvId)
            return intent
        }
    }
}