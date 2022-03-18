package uk.co.bbc.scannerclient.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrevorResponse(
    @SerialName("allowAdvertising")
    val allowAdvertising: Boolean? = null,
    @SerialName("analytics")
    val analytics: List<Analytic?>? = null,
    @SerialName("format")
    val format: String? = null,
    @SerialName("iStatsCounter")
    val iStatsCounter: String? = null,
    @SerialName("iStatsLabels")
    val iStatsLabels: IStatsLabels? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("lastUpdated")
    val lastUpdated: Long? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("relations")
    val relations: List<Relation> = emptyList(),
    @SerialName("summary")
    val summary: String? = null,
    @SerialName("type")
    val type: String? = null
) {
    @Serializable
    data class Analytic(
        @SerialName("metadata")
        val metadata: Metadata? = null,
        @SerialName("provider")
        val provider: String? = null
    ) {
        @Serializable
        data class Metadata(
            @SerialName("content_type")
            val contentType: String? = null,
            @SerialName("countername")
            val countername: String? = null,
            @SerialName("page_title")
            val pageTitle: String? = null,
            @SerialName("producer")
            val producer: String? = null
        )
    }

    @Serializable
    data class IStatsLabels(
        @SerialName("page_type")
        val pageType: String? = null
    )

    @Serializable
    data class Relation(
        @SerialName("content")
        val content: Content,
        @SerialName("eTag")
        val eTag: String? = null,
        @SerialName("primaryType")
        val primaryType: String? = null,
        @SerialName("secondaryType")
        val secondaryType: String? = null
    ) {
        @Serializable
        data class Content(
            @SerialName("analytics")
            val analytics: List<Analytic?>? = null,
            @SerialName("format")
            val format: String? = null,
            @SerialName("iStatsCounter")
            val iStatsCounter: String? = null,
            @SerialName("iStatsLabels")
            val iStatsLabels: IStatsLabels? = null,
            @SerialName("id")
            val id: String? = null,
            @SerialName("language")
            val language: String? = null,
            @SerialName("lastUpdated")
            val lastUpdated: Long? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("passport")
            val passport: Passport? = null,
            @SerialName("relations")
            val relations: List<Relation> = emptyList(),
            @SerialName("shareUrl")
            val shareUrl: String? = null,
            @SerialName("shortName")
            val shortName: String? = null,
            @SerialName("site")
            val site: String? = null,
            @SerialName("summary")
            val summary: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("urn")
            val urn: String? = null,
            @SerialName("allowAdvertising")
            val allowAdvertising: Boolean? = null,
            @SerialName("altText")
            val altText: String? = null,
            @SerialName("caption")
            val caption: String? = null,
            @SerialName("copyrightHolder")
            val copyrightHolder: String? = null,
            @SerialName("duration")
            val duration: Int? = null,
            @SerialName("eTag")
            val eTag: String? = null,
            @SerialName("externalId")
            val externalId: String? = null,
            @SerialName("height")
            val height: Int? = null,
            @SerialName("href")
            val href: String? = null,
            @SerialName("iChefUrl")
            val iChefUrl: String? = null,
            @SerialName("isAvailable")
            val isAvailable: Boolean? = null,
            @SerialName("isEmbeddable")
            val isEmbeddable: Boolean? = null,
            @SerialName("isLive")
            val isLive: Boolean? = null,
            @SerialName("width")
            val width: Int? = null,
        ) {
            @Serializable
            data class Passport(
                @SerialName("category")
                val category: Category? = null
            ) {
                @Serializable
                data class Category(
                    @SerialName("categoryName")
                    val categoryName: String? = null
                )
            }
        }
    }
}