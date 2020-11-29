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

/**
 * Группа задачи
 * @param code Строковое представление
 * @param id Ид
 */

data class GroupModel(
    /* Строковое представление */
    @SerializedName("code")
    val code: String? = null,
    /* Ид */
    @SerializedName("id")
    val id: Long? = null
)

