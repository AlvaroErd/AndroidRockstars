package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.mango.androidrockstars.R
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

        val similarTvCompose = findViewById<ComposeView>(R.id.compose_similar)
        similarTvCompose.setContent {
            ListSimilarTvShowCards(items = topRatedTvListMock, onItemClick = {})
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
                        binding.composeSimilar
                    }
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}