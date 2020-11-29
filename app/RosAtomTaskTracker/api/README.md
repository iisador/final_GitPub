# com.gitpub.rosatom - Kotlin client library for Rosatom REST Api

## Requires

* Kotlin 1.3.61
* Gradle 4.9

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://92.243.125.184:9000*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**commentUsingPOST**](docs/DefaultApi.md#commentusingpost) | **POST** api/tasks/{taskId}/comments | Добавить комментарий к задаче
*DefaultApi* | [**commentUsingPOST1**](docs/DefaultApi.md#commentusingpost1) | **POST** api/tasks/{taskId}/reaction | Добавить реакцию к задаче
*DefaultApi* | [**convertUsingPOST**](docs/DefaultApi.md#convertusingpost) | **POST** api/speech/convert | Преобразование аудио в текст
*DefaultApi* | [**createSubTaskUsingPOST**](docs/DefaultApi.md#createsubtaskusingpost) | **POST** api/tasks/{taskId} | Создание подзадачи
*DefaultApi* | [**createUsingPOST**](docs/DefaultApi.md#createusingpost) | **POST** api/departments | Создание цеха
*DefaultApi* | [**createUsingPOST1**](docs/DefaultApi.md#createusingpost1) | **POST** api/positions | Создание новой должности
*DefaultApi* | [**createUsingPOST2**](docs/DefaultApi.md#createusingpost2) | **POST** api/task/statuses | Создание нового статуса задачи
*DefaultApi* | [**createUsingPOST3**](docs/DefaultApi.md#createusingpost3) | **POST** api/tasks | Создание задачи
*DefaultApi* | [**createUsingPOST4**](docs/DefaultApi.md#createusingpost4) | **POST** api/task/types | Создание нового типа задачи
*DefaultApi* | [**getUsingGET**](docs/DefaultApi.md#getusingget) | **GET** api/tasks/{taskId} | Конкретная задача
*DefaultApi* | [**listUsingGET**](docs/DefaultApi.md#listusingget) | **GET** api/departments | Список цехов
*DefaultApi* | [**listUsingGET1**](docs/DefaultApi.md#listusingget1) | **GET** api/task/groups | Список групп задач
*DefaultApi* | [**listUsingGET2**](docs/DefaultApi.md#listusingget2) | **GET** api/positions | Список должностей
*DefaultApi* | [**listUsingGET3**](docs/DefaultApi.md#listusingget3) | **GET** api/task/priorities | Список приоритетов для задачи
*DefaultApi* | [**listUsingGET4**](docs/DefaultApi.md#listusingget4) | **GET** api/task/reactions | Список реакций на задачу
*DefaultApi* | [**listUsingGET5**](docs/DefaultApi.md#listusingget5) | **GET** api/task/statuses | Список статусов задачи
*DefaultApi* | [**listUsingGET6**](docs/DefaultApi.md#listusingget6) | **GET** api/tasks | Список задач
*DefaultApi* | [**listUsingGET7**](docs/DefaultApi.md#listusingget7) | **GET** api/task/types | Список типов задачи
*DefaultApi* | [**listUsingGET8**](docs/DefaultApi.md#listusingget8) | **GET** api/users | Список юзеров
*DefaultApi* | [**updateUsingPATCH**](docs/DefaultApi.md#updateusingpatch) | **PATCH** api/departments/{id} | Обновление цеха
*DefaultApi* | [**updateUsingPATCH1**](docs/DefaultApi.md#updateusingpatch1) | **PATCH** api/positions/{id} | Обновление должности
*DefaultApi* | [**updateUsingPATCH2**](docs/DefaultApi.md#updateusingpatch2) | **PATCH** api/task/statuses/{id} | Обновление статуса задачи
*DefaultApi* | [**updateUsingPATCH3**](docs/DefaultApi.md#updateusingpatch3) | **PATCH** api/task/types/{id} | Обновление типа задачи


<a name="documentation-for-models"></a>
## Documentation for Models

 - [com.gitpub.rosatom.models.AttachmentModel](docs/AttachmentModel.md)
 - [com.gitpub.rosatom.models.CommentModel](docs/CommentModel.md)
 - [com.gitpub.rosatom.models.CommentResource](docs/CommentResource.md)
 - [com.gitpub.rosatom.models.DepartmentModel](docs/DepartmentModel.md)
 - [com.gitpub.rosatom.models.GroupModel](docs/GroupModel.md)
 - [com.gitpub.rosatom.models.HousingModel](docs/HousingModel.md)
 - [com.gitpub.rosatom.models.PageTaskModel](docs/PageTaskModel.md)
 - [com.gitpub.rosatom.models.Pageable](docs/Pageable.md)
 - [com.gitpub.rosatom.models.PositionModel](docs/PositionModel.md)
 - [com.gitpub.rosatom.models.PriorityModel](docs/PriorityModel.md)
 - [com.gitpub.rosatom.models.ReactionModel](docs/ReactionModel.md)
 - [com.gitpub.rosatom.models.Sort](docs/Sort.md)
 - [com.gitpub.rosatom.models.StatusTypeModel](docs/StatusTypeModel.md)
 - [com.gitpub.rosatom.models.TaskModel](docs/TaskModel.md)
 - [com.gitpub.rosatom.models.TaskResource](docs/TaskResource.md)
 - [com.gitpub.rosatom.models.TaskTypeModel](docs/TaskTypeModel.md)
 - [com.gitpub.rosatom.models.UserModel](docs/UserModel.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
