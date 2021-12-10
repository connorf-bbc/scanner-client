package uk.co.bbc.model.response
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RmsResponse(
    @SerialName("data")
    val data: List<Data> = emptyList(),
    @SerialName("limit")
    val limit: Int? = null,
    @SerialName("offset")
    val offset: Int? = null,
    @SerialName("\$schema")
    val schema: String? = null,
    @SerialName("total")
    val total: Int? = null
) {
    @Serializable
    data class Data(
        @SerialName("activities")
        val activities: List<String?>? = null,
        @SerialName("availability")
        val availability: Availability? = null,
        @SerialName("container")
        val container: Container? = null,
        @SerialName("download")
        val download: Download? = null,
        @SerialName("duration")
        val duration: Duration? = null,
        @SerialName("guidance")
        val guidance: Guidance? = null,
        @SerialName("id")
        val id: String,
        @SerialName("image_url")
        val imageUrl: String? = null,
        @SerialName("network")
        val network: Network? = null,
        @SerialName("play_context")
        val playContext: String? = null,
        @SerialName("progress")
        val progress: String? = null,
        @SerialName("recommendation")
        val recommendation: String? = null,
        @SerialName("release")
        val release: Release? = null,
        @SerialName("synopses")
        val synopses: Synopses? = null,
        @SerialName("titles")
        val titles: Titles,
        @SerialName("type")
        val type: String? = null,
        @SerialName("uris")
        val uris: List<Uri?>? = null,
        @SerialName("urn")
        val urn: String? = null
    ) {
        @Serializable
        data class Availability(
            @SerialName("from")
            val from: String? = null,
            @SerialName("label")
            val label: String? = null,
            @SerialName("to")
            val to: String? = null
        )

        @Serializable
        data class Container(
            @SerialName("activities")
            val activities: List<String?>? = null,
            @SerialName("id")
            val id: String? = null,
            @SerialName("synopses")
            val synopses: Synopses? = null,
            @SerialName("title")
            val title: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("urn")
            val urn: String? = null
        ) {
            @Serializable
            data class Synopses(
                @SerialName("long")
                val long: String? = null,
                @SerialName("medium")
                val medium: String? = null,
                @SerialName("short")
                val short: String? = null
            )
        }

        @Serializable
        data class Download(
            @SerialName("quality_variants")
            val qualityVariants: QualityVariants? = null,
            @SerialName("type")
            val type: String? = null
        ) {
            @Serializable
            data class QualityVariants(
                @SerialName("high")
                val high: High? = null,
                @SerialName("low")
                val low: Low? = null,
                @SerialName("medium")
                val medium: Medium? = null
            ) {
                @Serializable
                data class High(
                    @SerialName("bitrate")
                    val bitrate: Int? = null,
                    @SerialName("file_size")
                    val fileSize: Int? = null,
                    @SerialName("file_url")
                    val fileUrl: String? = null,
                    @SerialName("label")
                    val label: String? = null
                )

                @Serializable
                data class Low(
                    @SerialName("bitrate")
                    val bitrate: Int? = null,
                    @SerialName("file_size")
                    val fileSize: Int? = null,
                    @SerialName("file_url")
                    val fileUrl: String? = null,
                    @SerialName("label")
                    val label: String? = null
                )

                @Serializable
                data class Medium(
                    @SerialName("bitrate")
                    val bitrate: Int? = null,
                    @SerialName("file_size")
                    val fileSize: Int? = null,
                    @SerialName("file_url")
                    val fileUrl: String? = null,
                    @SerialName("label")
                    val label: String? = null
                )
            }
        }

        @Serializable
        data class Duration(
            @SerialName("label")
            val label: String? = null,
            @SerialName("value")
            val value: Int? = null
        )

        @Serializable
        data class Guidance(
            @SerialName("competition_warning")
            val competitionWarning: Boolean? = null,
            @SerialName("warnings")
            val warnings: String? = null
        )

        @Serializable
        data class Network(
            @SerialName("id")
            val id: String? = null,
            @SerialName("key")
            val key: String? = null,
            @SerialName("logo_url")
            val logoUrl: String? = null,
            @SerialName("short_title")
            val shortTitle: String? = null
        )

        @Serializable
        data class Release(
            @SerialName("date")
            val date: String? = null,
            @SerialName("label")
            val label: String? = null
        )

        @Serializable
        data class Synopses(
            @SerialName("long")
            val long: String? = null,
            @SerialName("medium")
            val medium: String? = null,
            @SerialName("short")
            val short: String? = null
        )

        @Serializable
        data class Titles(
            @SerialName("primary")
            val primary: String? = null,
            @SerialName("secondary")
            val secondary: String? = null,
            @SerialName("tertiary")
            val tertiary: String? = null
        )

        @Serializable
        data class Uri(
            @SerialName("id")
            val id: String? = null,
            @SerialName("label")
            val label: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("uri")
            val uri: String? = null
        )
    }
}