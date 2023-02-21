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
                        binding.txtLanguage.setText(detailId.original_language)
                        binding.txtDescription.setText(detailId.overview)
                        binding.txtReleased.setText(detailId.first_air_date)
                    }
                }
            }
        }
    }
}

/*
@Suppress("UNREACHABLE_CODE")
class TopRatedTvDetailActivity : ComponentActivity() {

    private val topRatedTvDetailViewModel: TopRatedTvDetailViewModel by viewModels()
    private var _binding: ActivityTopRatedTvDetailBinding? = null
    private val binding get() = _binding!!
    private var tvIdBundle : Int? = 0

    override fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityTopRatedTvDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

        val bundle = intent.extras
        tvIdBundle = bundle?.getInt("TV_ID")!!
        topRatedTvDetailViewModel.fetchTvShowDetail(tvIdBundle!!)

        lifecycleScope.launch(Dispatchers.IO){
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                this@TopRatedTvDetailActivity.topRatedTvDetailViewModel.tvShowDetail.collectLatest { detailId ->
                    withContext(Dispatchers.Main){
                        binding.imgBackgroundTvShow.load(detailId.posterPath)
                        binding.imgPosterTvShow.load(detailId.posterPath)
                        binding.txtTvShowTitle.setText(detailId.name)
                        binding.txtLanguage.setText(detailId.original_language)
                        binding.txtDescriptionTvShow.setText(detailId.overview)
                        binding.txtReleased.setText(detailId.first_air_date)
                    }
                }
            }
        }
    }
}*/


