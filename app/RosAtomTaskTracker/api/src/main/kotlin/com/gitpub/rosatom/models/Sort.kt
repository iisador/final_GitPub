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
 *
 * @param empty
 * @param sorted
 * @param unsorted
 */

data class Sort(
    @SerializedName("empty")
    val empty: Boolean? = null,
    @SerializedName("sorted")
    val sorted: Boolean? = null,
    @SerializedName("unsorted")
    val unsorted: Boolean? = null
)

