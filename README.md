<h1> // Android Rock Stars //</h1>

Repository of my first application. It is an Android app made with Kotlin, clean architecture and MVVM.

The application brings the data of the top rated tv series from the IMDB api. It consists of two screens, the first is an infinite list of the series and the second is the detail view of the specific serie, where you can see more information such as the release date, the summary, etc.

The curiosity of this project is that it mixes views and components created with Jetpack Compose with classic xml views.

<p align="center">
<img width="200" src="https://user-images.githubusercontent.com/108676373/225890538-d40a1aab-508a-410a-9ded-760854dc6a6f.png"> <img width="200" src="https://user-images.githubusercontent.com/108676373/225890508-7ca544dd-f1f6-42ed-90c9-ca293c42fd0e.png"> <img width="200" src="https://user-images.githubusercontent.com/108676373/225890542-68a15b73-b650-4133-83ed-e2b87231dd0c.png"> <img width="200" src="https://user-images.githubusercontent.com/108676373/225890529-a752e88d-8030-4070-9d51-86d8312289d4.png">
</p>

<div align="center">
<video width="100" src="https://user-images.githubusercontent.com/108676373/225919734-c3037c9a-3016-4403-9e64-550a5daf412a.mp4">
</div>
  
<h1> // Main characteristics // </h1>

<h2>🏛️ Architecture 🏛️</h2>
- Build entirely in Kotlin
- Clean Arquitecture with 3 layers. Data -> Domain  -> Ui
- SOLID principies
- A Jetpack compose component showed in a xml activity

<h2>🎨 Design 🎨</h2>
- Good loking design! (I hope 😇)
- Support dark and light theme
- TopBar indicator with jetpack compose
- Android icon

<h2>🔖 Libraries 🔖</h2>
- Dependencies gradle file to manage libraries much more easy 
- <a href="https://developers.themoviedb.org/3/tv/get-top-rated-tv">Tmdb oficial api</a>
- <a href="https://developer.android.com/jetpack?hl=es-419">Jetpack compose</a> and <a href="https://developer.android.com/develop/ui/views/layout/declaring-layout">classic XML views</a>
- <a href="https://m3.material.io/">Material design 3</a>
- <a href="https://developer.android.com/develop/ui/views/launch/splash-screen">Custom Splash Screen</a> with an <a href="  https://lottiefiles.com/37355-popcorn">animated logo and brand logo</a>
- Infinite scroll with <a href="https://developer.android.com/topic/libraries/architecture/paging/v3-overview?hl=es-419">Paging 3.0</a>
- <a href="https://square.github.io/retrofit/">Retrofit</a> and <a href="https://github.com/google/gson">Gson</a>
- <a href="https://developer.android.com/kotlin/coroutines?hl=es-419">Coroutines</a>
- Dependecies Injector <a href="https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419">Dagger Hilt</a>
- <a href="https://coil-kt.github.io/coil/">Coil</a>
- <a href="https://developer.android.com/kotlin/flow/stateflow-and-sharedflow?hl=es-419">StateFlow</a>
- <a href="https://developer.android.com/jetpack/compose/navigation?hl=es-419">Navigation compose</a>
- <a href="https://developer.android.com/topic/libraries/view-binding?hl=es-419">ViewBinding</a>
- <a href="https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419">Dagger Hilt</a>

<h2>📢 Others 📢</h2>
- Custom mappers between Data and Domain
- Differents mocks to show the preview with jetpack
- Circular Progress Indicator (jetpack)when open the app while fetching the data
. Circular Progress bar (xml) when open the detail screen while fethcing the data
- Design with accesibility in mind (every item has a content description and great contrast)
- Reformat some parameters (like 5300 to 5.3k, 8.9 average votes to 8,9)
 
