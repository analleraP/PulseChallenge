## Pulse Live Challenge

### How it's been done:

#### Language
Kotlin

#### Architecture
Based on Clean Architecture, divided into three layers:

* Data, with a remote data source
* Domain, for business model and repository.
* Feature, with Model-View-Presenter, + Interactor for use cases and Navigator for navigation.

#### Libraries
* coroutines (asynchronous programming)
* retrofit (http client)


### Possible improvements
