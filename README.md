# IntuitRepo

Allows user to login to github (this allows a greater quantity of fetch to github than when not authenticated)
View repos list, drill down into repo, see repo issues and drill down into selected issue.

# Dependency Injection
Use Dagger for dependency injection. Uses ViewModelFactory so that ViewModels are created via Dagger.
# Layers
## UI Layer
Uses Activities, DataBinding to corresponding ViewModels, ViewModels contain LiveData
## Repository Layer
Uses Room (for DB) Retrofit (for network) and prefs to emulate secure storage. Repository serves up LiveData via Room.
