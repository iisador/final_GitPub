/**
 * Rosatom REST Api
 * Апи
 *
 * The version of the OpenAPI document: 0.0.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.gitpub.rosatom.models

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

/**
 * Комментарий
 * @param author
 * @param content Содержание
 * @param id Ид
 */

data class CommentModel(
    @SerializedName("author")
    val author: UserModel? = null,
    /* Содержание */
    @SerializedName("content")
    val content: String? = null,
    /* Ид */
    @SerializedName("id")
    val id: Long? = null,
    /* Время создания */
    @SerializedName("tstmpCreate")
    val tstmpCreate: DateTime? = null,
    @SerializedName("attachments")
    val attachments: List<AttachmentModel>? = null,
    @SerializedName("closing")
    val isClosing: Boolean? = null
)
