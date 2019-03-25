# IntuitRepo

Allows user to login to github (this allows a greater quantity of fetch to github than when not authenticated)
View repos list, drill down into repo, see repo issues and drill down into selected issue.

# Layers
## UI Layer
uses Activities, DataBinding to corresponding ViewModels
## Repository Layer
uses Room (for DB) Retrofit (for network) and prefs to emulate secure storage.
