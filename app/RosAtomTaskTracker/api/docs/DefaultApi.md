# DefaultApi

All URIs are relative to *http://92.243.125.184:9000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**commentUsingPOST**](DefaultApi.md#commentUsingPOST) | **POST** api/tasks/{taskId}/comments | Добавить комментарий к задаче
[**commentUsingPOST1**](DefaultApi.md#commentUsingPOST1) | **POST** api/tasks/{taskId}/reaction | Добавить реакцию к задаче
[**convertUsingPOST**](DefaultApi.md#convertUsingPOST) | **POST** api/speech/convert | Преобразование аудио в текст
[**createSubTaskUsingPOST**](DefaultApi.md#createSubTaskUsingPOST) | **POST** api/tasks/{taskId} | Создание подзадачи
[**createUsingPOST**](DefaultApi.md#createUsingPOST) | **POST** api/departments | Создание цеха
[**createUsingPOST1**](DefaultApi.md#createUsingPOST1) | **POST** api/positions | Создание новой должности
[**createUsingPOST2**](DefaultApi.md#createUsingPOST2) | **POST** api/task/statuses | Создание нового статуса задачи
[**createUsingPOST3**](DefaultApi.md#createUsingPOST3) | **POST** api/tasks | Создание задачи
[**createUsingPOST4**](DefaultApi.md#createUsingPOST4) | **POST** api/task/types | Создание нового типа задачи
[**getUsingGET**](DefaultApi.md#getUsingGET) | **GET** api/tasks/{taskId} | Конкретная задача
[**listUsingGET**](DefaultApi.md#listUsingGET) | **GET** api/departments | Список цехов
[**listUsingGET1**](DefaultApi.md#listUsingGET1) | **GET** api/task/groups | Список групп задач
[**listUsingGET2**](DefaultApi.md#listUsingGET2) | **GET** api/positions | Список должностей
[**listUsingGET3**](DefaultApi.md#listUsingGET3) | **GET** api/task/priorities | Список приоритетов для задачи
[**listUsingGET4**](DefaultApi.md#listUsingGET4) | **GET** api/task/reactions | Список реакций на задачу
[**listUsingGET5**](DefaultApi.md#listUsingGET5) | **GET** api/task/statuses | Список статусов задачи
[**listUsingGET6**](DefaultApi.md#listUsingGET6) | **GET** api/tasks | Список задач
[**listUsingGET7**](DefaultApi.md#listUsingGET7) | **GET** api/task/types | Список типов задачи
[**listUsingGET8**](DefaultApi.md#listUsingGET8) | **GET** api/users | Список юзеров
[**updateUsingPATCH**](DefaultApi.md#updateUsingPATCH) | **PATCH** api/departments/{id} | Обновление цеха
[**updateUsingPATCH1**](DefaultApi.md#updateUsingPATCH1) | **PATCH** api/positions/{id} | Обновление должности
[**updateUsingPATCH2**](DefaultApi.md#updateUsingPATCH2) | **PATCH** api/task/statuses/{id} | Обновление статуса задачи
[**updateUsingPATCH3**](DefaultApi.md#updateUsingPATCH3) | **PATCH** api/task/types/{id} | Обновление типа задачи



Добавить комментарий к задаче

Комментирование

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val taskId : kotlin.Long = 1 // kotlin.Long | Ид задачи
val commentResource : CommentResource =  // CommentResource | Ресурс комментария

launch(Dispatchers.IO) {
    val result : kotlin.Long = webService.commentUsingPOST(taskId, commentResource)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **kotlin.Long**| Ид задачи |
 **commentResource** | [**CommentResource**](CommentResource.md)| Ресурс комментария |

### Return type

**kotlin.Long**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Добавить реакцию к задаче

Добавление реакции

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val reactionId : kotlin.Long = 1 // kotlin.Long | Ид реакции
val taskId : kotlin.Long = 1 // kotlin.Long | Ид задачи

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.commentUsingPOST1(reactionId, taskId)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reactionId** | **kotlin.Long**| Ид реакции |
 **taskId** | **kotlin.Long**| Ид задачи |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Преобразование аудио в текст

Текстовое представление

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.convertUsingPOST()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json


Создание подзадачи

Создание задачи или подзадачи

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val taskId : kotlin.Long = 1 // kotlin.Long | Ид задачи
val task : TaskResource =  // TaskResource | task

launch(Dispatchers.IO) {
    val result : kotlin.Long = webService.createSubTaskUsingPOST(taskId, task)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **kotlin.Long**| Ид задачи |
 **task** | [**TaskResource**](TaskResource.md)| task |

### Return type

**kotlin.Long**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Создание цеха

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.createUsingPOST(name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Создание новой должности

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.createUsingPOST1(name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Создание нового статуса задачи

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.createUsingPOST2(name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Создание задачи

Создание задачи или подзадачи

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val task : TaskResource =  // TaskResource | task

launch(Dispatchers.IO) {
    val result : kotlin.Long = webService.createUsingPOST3(task)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **task** | [**TaskResource**](TaskResource.md)| task |

### Return type

**kotlin.Long**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Создание нового типа задачи

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.createUsingPOST4(name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Конкретная задача

Возвращает задачу

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val taskId : kotlin.Long = 1 // kotlin.Long | Ид задачи

launch(Dispatchers.IO) {
    val result : TaskModel = webService.getUsingGET(taskId)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **kotlin.Long**| Ид задачи |

### Return type

[**TaskModel**](TaskModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список цехов

Возвращает список цехов

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<DepartmentModel> = webService.listUsingGET()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;DepartmentModel&gt;**](DepartmentModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список групп задач

Список групп задач

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<GroupModel> = webService.listUsingGET1()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;GroupModel&gt;**](GroupModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список должностей

Возвращает список должностей

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PositionModel> = webService.listUsingGET2()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;PositionModel&gt;**](PositionModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список приоритетов для задачи

Возвращает список приоритетов для задачи

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PriorityModel> = webService.listUsingGET3()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;PriorityModel&gt;**](PriorityModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список реакций на задачу

Список реакций на задачу

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ReactionModel> = webService.listUsingGET4()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;ReactionModel&gt;**](ReactionModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список статусов задачи

Возвращает список статусов задачи

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<StatusTypeModel> = webService.listUsingGET5()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;StatusTypeModel&gt;**](StatusTypeModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список задач

Возвращает список задач

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val assigneeId : kotlin.Long = 0 // kotlin.Long | Фильтр по исполнителю
val authorId : kotlin.Long = 0 // kotlin.Long | Фильтр по автору задачи
val groupId : kotlin.Long = 0 // kotlin.Long | Фильтр по группе
val page : kotlin.Int = 56 // kotlin.Int | 
val size : kotlin.Int = 56 // kotlin.Int | 
val sort : kotlin.String = sort_example // kotlin.String | 
val statusId : kotlin.Long = 0 // kotlin.Long | Фильтр по статусу задачи
val typeId : kotlin.Long = 0 // kotlin.Long | Фильтр по типу задачи

launch(Dispatchers.IO) {
    val result : PageTaskModel = webService.listUsingGET6(assigneeId, authorId, groupId, page, size, sort, statusId, typeId)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **assigneeId** | **kotlin.Long**| Фильтр по исполнителю | [optional]
 **authorId** | **kotlin.Long**| Фильтр по автору задачи | [optional]
 **groupId** | **kotlin.Long**| Фильтр по группе | [optional]
 **page** | **kotlin.Int**|  | [optional]
 **size** | **kotlin.Int**|  | [optional]
 **sort** | **kotlin.String**|  | [optional]
 **statusId** | **kotlin.Long**| Фильтр по статусу задачи | [optional]
 **typeId** | **kotlin.Long**| Фильтр по типу задачи | [optional]

### Return type

[**PageTaskModel**](PageTaskModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список типов задачи

Возвращает список типов задачи

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<TaskTypeModel> = webService.listUsingGET7()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;TaskTypeModel&gt;**](TaskTypeModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Список юзеров

Возвращает список юзеров

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<UserModel> = webService.listUsingGET8()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;UserModel&gt;**](UserModel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Обновление цеха

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | id
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.updateUsingPATCH(id, name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| id |
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Обновление должности

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | id
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.updateUsingPATCH1(id, name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| id |
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Обновление статуса задачи

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | id
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.updateUsingPATCH2(id, name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| id |
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Обновление типа задачи

Ok\\ошибка

### Example
```kotlin
// Import classes:
//import com.gitpub.rosatom.*
//import com.gitpub.rosatom.infrastructure.*
//import com.gitpub.rosatom.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | id
val name : kotlin.String = name_example // kotlin.String | name

launch(Dispatchers.IO) {
    val result : kotlin.String = webService.updateUsingPATCH3(id, name)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| id |
 **name** | **kotlin.String**| name |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

