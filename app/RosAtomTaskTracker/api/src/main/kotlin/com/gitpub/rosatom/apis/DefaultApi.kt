package com.gitpub.rosatom.apis

import com.gitpub.rosatom.models.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface DefaultApi {
    /**
     * Добавить комментарий к задаче
     * Комментирование
     * Responses:
     *  - 200: Ид коммента, если все ок
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param taskId Ид задачи
     * @param commentResource Ресурс комментария
     * @return [kotlin.Long]
     */
    @POST("api/tasks/{taskId}/comments")
    suspend fun commentUsingPOST(
        @Path("taskId") taskId: Long,
        @Body commentResource: CommentResource
    ): Response<Long>

    /**
     * Добавить реакцию к задаче
     * Добавление реакции
     * Responses:
     *  - 200: ок не ок
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param reactionId Ид реакции
     * @param taskId Ид задачи
     * @return [kotlin.String]
     */
    @POST("api/tasks/{taskId}/reaction")
    suspend fun commentUsingPOST1(
        @Query("reactionId") reactionId: Long,
        @Path("taskId") taskId: Long
    ): Response<String>

    /**
     * Преобразование аудио в текст
     * Текстовое представление
     * Responses:
     *  - 200: Текстовое представление
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.String]
     */
    @Multipart
    @POST("api/speech/convert")
    suspend fun convertUsingPOST(@Part file: MultipartBody.Part): Response<String>

    /**
     * Создание подзадачи
     * Создание задачи или подзадачи
     * Responses:
     *  - 200: Ид новое задачи, если все ок
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param taskId Ид задачи
     * @param task task
     * @return [kotlin.Long]
     */
    @POST("api/tasks/{taskId}")
    suspend fun createSubTaskUsingPOST(
        @Path("taskId") taskId: Long,
        @Body task: TaskResource
    ): Response<Long>

    /**
     * Создание цеха
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param name name
     * @return [kotlin.String]
     */
    @POST("api/departments")
    suspend fun createUsingPOST(@Query("name") name: String): Response<String>

    /**
     * Создание новой должности
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param name name
     * @return [kotlin.String]
     */
    @POST("api/positions")
    suspend fun createUsingPOST1(@Query("name") name: String): Response<String>

    /**
     * Создание нового статуса задачи
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param name name
     * @return [kotlin.String]
     */
    @POST("api/task/statuses")
    suspend fun createUsingPOST2(@Query("name") name: String): Response<String>

    /**
     * Создание задачи
     * Создание задачи или подзадачи
     * Responses:
     *  - 200: Ид новое задачи, если все ок
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param task task
     * @return [kotlin.Long]
     */
    @POST("api/tasks")
    suspend fun createUsingPOST3(@Body task: TaskResource): Response<Long>

    /**
     * Создание нового типа задачи
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 201: Created
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param name name
     * @return [kotlin.String]
     */
    @POST("api/task/types")
    suspend fun createUsingPOST4(@Query("name") name: String): Response<String>

    /**
     * Конкретная задача
     * Возвращает задачу
     * Responses:
     *  - 200: Задача
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param taskId Ид задачи
     * @return [TaskModel]
     */
    @GET("api/tasks/{taskId}")
    suspend fun getUsingGET(@Path("taskId") taskId: Long): Response<TaskModel>

    /**
     * Список цехов
     * Возвращает список цехов
     * Responses:
     *  - 200: Список цехов
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<DepartmentModel>]
     */
    @GET("api/departments")
    suspend fun listUsingGET(): Response<List<DepartmentModel>>

    /**
     * Список групп задач
     * Список групп задач
     * Responses:
     *  - 200: Список групп задач
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<GroupModel>]
     */
    @GET("api/task/groups")
    suspend fun listUsingGET1(): Response<List<GroupModel>>

    /**
     * Список должностей
     * Возвращает список должностей
     * Responses:
     *  - 200: Список типов задачи
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<PositionModel>]
     */
    @GET("api/positions")
    suspend fun listUsingGET2(): Response<List<PositionModel>>

    /**
     * Список приоритетов для задачи
     * Возвращает список приоритетов для задачи
     * Responses:
     *  - 200: список приоритетов для задачи
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<PriorityModel>]
     */
    @GET("api/task/priorities")
    suspend fun listUsingGET3(): Response<List<PriorityModel>>

    /**
     * Список реакций на задачу
     * Список реакций на задачу
     * Responses:
     *  - 200: Список реакций на задачу
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<ReactionModel>]
     */
    @GET("api/task/reactions")
    suspend fun listUsingGET4(): Response<List<ReactionModel>>

    /**
     * Список статусов задачи
     * Возвращает список статусов задачи
     * Responses:
     *  - 200: Список статусов задачи
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<StatusTypeModel>]
     */
    @GET("api/task/statuses")
    suspend fun listUsingGET5(): Response<List<StatusTypeModel>>

    /**
     * Список задач
     * Возвращает список задач
     * Responses:
     *  - 200: Список задач
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @param assigneeId Фильтр по исполнителю (optional)
     * @param authorId Фильтр по автору задачи (optional)
     * @param groupId Фильтр по группе (optional)
     * @param page  (optional)
     * @param size  (optional)
     * @param sort  (optional)
     * @param statusId Фильтр по статусу задачи (optional)
     * @param typeId Фильтр по типу задачи (optional)
     * @return [PageTaskModel]
     */
    @GET("api/tasks")
    suspend fun listUsingGET6(
        @Query("assigneeId") assigneeId: Long? = null,
        @Query("authorId") authorId: Long? = null,
        @Query("groupId") groupId: Long? = null,
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null,
        @Query("sort") sort: String? = null,
        @Query("statusId") statusId: Long? = null,
        @Query("typeId") typeId: Long? = null
    ): Response<PageTaskModel>

    /**
     * Список типов задачи
     * Возвращает список типов задачи
     * Responses:
     *  - 200: Список типов задачи
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<TaskTypeModel>]
     */
    @GET("api/task/types")
    suspend fun listUsingGET7(): Response<List<TaskTypeModel>>

    /**
     * Список юзеров
     * Возвращает список юзеров
     * Responses:
     *  - 200: список юзеров
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *  - 404: Not Found
     *
     * @return [kotlin.collections.List<UserModel>]
     */
    @GET("api/users")
    suspend fun listUsingGET8(): Response<List<UserModel>>

    /**
     * Обновление цеха
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 204: No Content
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *
     * @param id id
     * @param name name
     * @return [kotlin.String]
     */
    @PATCH("api/departments/{id}")
    suspend fun updateUsingPATCH(
        @Path("id") id: Long,
        @Query("name") name: String
    ): Response<String>

    /**
     * Обновление должности
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 204: No Content
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *
     * @param id id
     * @param name name
     * @return [kotlin.String]
     */
    @PATCH("api/positions/{id}")
    suspend fun updateUsingPATCH1(
        @Path("id") id: Long,
        @Query("name") name: String
    ): Response<String>

    /**
     * Обновление статуса задачи
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 204: No Content
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *
     * @param id id
     * @param name name
     * @return [kotlin.String]
     */
    @PATCH("api/task/statuses/{id}")
    suspend fun updateUsingPATCH2(
        @Path("id") id: Long,
        @Query("name") name: String
    ): Response<String>

    /**
     * Обновление типа задачи
     * Ok\\ошибка
     * Responses:
     *  - 200: Ок или ошибку
     *  - 204: No Content
     *  - 401: Unauthorized
     *  - 403: Forbidden
     *
     * @param id id
     * @param name name
     * @return [kotlin.String]
     */
    @PATCH("api/task/types/{id}")
    suspend fun updateUsingPATCH3(
        @Path("id") id: Long,
        @Query("name") name: String
    ): Response<String>

    @POST("api/tasks/{taskId}/status")
    suspend fun updateTaskStatus(
        @Path("taskId") taskId: Long,
        @Query("statusId") statusId: Long
    ): Response<Unit>

}
