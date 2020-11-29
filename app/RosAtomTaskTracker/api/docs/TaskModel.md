
# TaskModel

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**assignee** | [**UserModel**](UserModel.md) |  |  [optional]
**attachments** | [**kotlin.collections.List&lt;AttachmentModel&gt;**](AttachmentModel.md) | Приложенные файлы |  [optional]
**author** | [**UserModel**](UserModel.md) |  |  [optional]
**comments** | [**kotlin.collections.List&lt;CommentModel&gt;**](CommentModel.md) | Комментарии |  [optional]
**dateFact** | [**DateTime**](DateTime.md) | Фактическая дата\\время выполнения |  [optional]
**dateTo** | [**DateTime**](DateTime.md) | Необходимая дата\\время выполнения |  [optional]
**header** | **kotlin.String** | Заголовок |  [optional]
**id** | **kotlin.Long** | Ид |  [optional]
**info** | **kotlin.String** | Содержание задачи |  [optional]
**priority** | [**PriorityModel**](PriorityModel.md) |  |  [optional]
**status** | [**StatusTypeModel**](StatusTypeModel.md) |  |  [optional]
**subTaskList** | [**kotlin.collections.List&lt;TaskModel&gt;**](TaskModel.md) | Подзадачи |  [optional]
**tstmpCreate** | [**DateTime**](DateTime.md) | Время создания задачи |  [optional]
**type** | [**TaskTypeModel**](TaskTypeModel.md) |  |  [optional]



