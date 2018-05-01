## Pulse Live Challenge

### How it's been done:

#### Language
Kotlin

#### Architecture
Based on Clean Architecture, divided into three layers:

* Data, with a remote data source
* Domain, for business model and repository.
* Feature, with Model-View-Presenter, + Interactor for use cases + Navigator for navigation.

### Possible improvements (Not implemented due to challenge libraries restrictions)
* Use dagger for dependency injection
* Add tests to every layer (need mockwebserver, roboelectric, mockito)

### Time spent
3 hours
