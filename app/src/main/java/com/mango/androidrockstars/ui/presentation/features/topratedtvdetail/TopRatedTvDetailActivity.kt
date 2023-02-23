package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.mango.androidrockstars.databinding.ActivityTopRatedTvDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        lifecycleScope.launch(Dispatchers.IO) {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                this@TopRatedTvDetailActivity.topRatedTvDetailViewModel.tvShowDetail.collectLatest { detailId ->
                    withContext(Dispatchers.Main) {
                        binding.imgBackgroundTvShow.load(detailId.posterPath)
                        binding.imgPoster.load(detailId.posterPath)
                        binding.txtTitle.setText(detailId.name)
                        binding.txtLanguagePlaceholder.setText(detailId.original_language)
                        binding.txtDescription.setText(detailId.overview)
                        binding.txtReleasedDatePlaceholder.setText(detailId.first_air_date)
                        binding.txtRating.setText("${detailId.voteAverage} (${detailId.voteCount} Reviews)")
                    }
                }
            }
        }
    }
}
