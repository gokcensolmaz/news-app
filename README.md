# Appcent News App
Appcent News Application is an Android Application that allows users to follow the current news, search for news on the subject they are curious about, and add the news that interests them to their favorites to access it later.

While developing the application, I developed it with Kotlin language and followed OOP and SOLID principles. Architecturally, I aimed to establish a clean architecture using MVVM and Use Cases.

## Libraries and Tools
- [ViewModel](https://developer.android.com/reference/android/arch/lifecycle/ViewModel): Facilitates management of UI-related data in a lifecycle-aware manner, preserving state across configuration changes.

- [Jetpack Compose](https://developer.android.com/jetpack/compose): The cutting-edge UI toolkit used for crafting native Android UIs, promoting a declarative and intuitive approach to UI development.

- [Jetpack Navigation](https://developer.android.com/guide/navigation): Manages the app's navigation, delivering a consistent and intuitive user navigation experience throughout the app.

- [Android WebView](https://developer.android.com/reference/android/webkit/WebView): Integrated to present web content directly within the app, offering users an immersive article reading experience without leaving the app.

- [Paging 3 Library](https://developer.android.com/topic/libraries/architecture/paging/v3-paged-data): Crucial for efficiently loading and presenting paginated data from network or database sources, enhancing the app's performance and reducing resource usage. The Paging library seamlessly integrates with the app's architecture to provide smooth data loading and infinite scrolling capabilities.

- [Retrofit2 & Gson](https://square.github.io/retrofit/): Powers network operations for RESTful API interactions and JSON data parsing, enabling efficient data retrieval and serialization.

- [Room](https://developer.android.com/training/data-storage/room): Offers sophisticated local data storage with SQLite, supporting robust offline capabilities and fast data access.

- [Coil](https://github.com/coil-kt/coil#jetpack-compose): A Kotlin-native image loading library, optimized for Jetpack Compose, that simplifies asynchronous image loading and display.

- [Coroutines & Flow](https://developer.android.com/kotlin/flow): Implements modern concurrency patterns and asynchronous data streams, ensuring fluid UI interactions and background processing.

- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android): Provides a comprehensive dependency injection framework, simplifying component decoupling and enhancing the app's modularity and testability.

## Architecture
- MVVM
- Clean Architecture with Use Cases 

# API
[https://newsapi.org](https://newsapi.org)
