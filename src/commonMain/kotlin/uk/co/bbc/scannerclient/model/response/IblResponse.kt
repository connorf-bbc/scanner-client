package uk.co.bbc.scannerclient.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IblResponse(
    @SerialName("group_episodes")
    val groupEpisodes: GroupEpisodes,
    @SerialName("schema")
    val schema: String? = null,
    @SerialName("version")
    val version: String? = null
) {
    @Serializable
    data class GroupEpisodes(
        @SerialName("count")
        val count: Int? = null,
        @SerialName("elements")
        val elements: List<Element> = emptyList(),
        @SerialName("group")
        val group: Group? = null,
        @SerialName("page")
        val page: Int? = null,
        @SerialName("per_page")
        val perPage: Int? = null
    ) {
        @Serializable
        data class Element(
            @SerialName("audio_described")
            val audioDescribed: Boolean? = null,
            @SerialName("categories")
            val categories: List<String?>? = null,
            @SerialName("childrens")
            val childrens: Boolean? = null,
            @SerialName("editorial_subtitle")
            val editorialSubtitle: String? = null,
            @SerialName("editorial_title")
            val editorialTitle: String? = null,
            @SerialName("guidance")
            val guidance: Boolean? = null,
            @SerialName("has_credits")
            val hasCredits: Boolean? = null,
            @SerialName("id")
            val id: String? = null,
            @SerialName("images")
            val images: Images,
            @SerialName("labels")
            val labels: Labels? = null,
            @SerialName("lexical_sort_letter")
            val lexicalSortLetter: String? = null,
            @SerialName("live")
            val live: Boolean,
            @SerialName("master_brand")
            val masterBrand: MasterBrand? = null,
            @SerialName("next_broadcast")
            val nextBroadcast: NextBroadcast? = null,
            @SerialName("numeric_tleo_position")
            val numericTleoPosition: Int? = null,
            @SerialName("original_title")
            val originalTitle: String? = null,
            @SerialName("parent_id")
            val parentId: String? = null,
            @SerialName("parent_position")
            val parentPosition: Int? = null,
            @SerialName("position")
            val position: Int? = null,
            @SerialName("programme_type")
            val programmeType: String? = null,
            @SerialName("related_links")
            val relatedLinks: List<RelatedLink?>? = null,
            @SerialName("release_date")
            val releaseDate: String? = null,
            @SerialName("release_date_time")
            val releaseDateTime: String? = null,
            @SerialName("requires_ab")
            val requiresAb: List<String?>? = null,
            @SerialName("requires_sign_in")
            val requiresSignIn: Boolean? = null,
            @SerialName("requires_tv_licence")
            val requiresTvLicence: Boolean? = null,
            @SerialName("signed")
            val signed: Boolean? = null,
            @SerialName("slice_id")
            val sliceId: String? = null,
            @SerialName("slice_subtitle")
            val sliceSubtitle: String? = null,
            @SerialName("status")
            val status: String? = null,
            @SerialName("subtitle")
            val subtitle: String? = null,
            @SerialName("synopses")
            val synopses: Synopses? = null,
            @SerialName("title")
            val title: String,
            @SerialName("tleo_id")
            val tleoId: String? = null,
            @SerialName("tleo_type")
            val tleoType: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("versions")
            val versions: List<Version> = emptyList()
        ) {
            @Serializable
            data class Images(
                @SerialName("inherited_from")
                val inheritedFrom: String? = null,
                @SerialName("portrait")
                val portrait: String? = null,
                @SerialName("promotional")
                val promotional: String? = null,
                @SerialName("promotional_with_logo")
                val promotionalWithLogo: String? = null,
                @SerialName("standard")
                val standard: String,
                @SerialName("type")
                val type: String? = null
            )

            @Serializable
            data class Labels(
                @SerialName("category")
                val category: String? = null
            )

            @Serializable
            data class MasterBrand(
                @SerialName("attribution")
                val attribution: String? = null,
                @SerialName("id")
                val id: String? = null,
                @SerialName("ident_id")
                val identId: String? = null,
                @SerialName("titles")
                val titles: Titles? = null
            ) {
                @Serializable
                data class Titles(
                    @SerialName("large")
                    val large: String? = null,
                    @SerialName("medium")
                    val medium: String? = null,
                    @SerialName("small")
                    val small: String? = null
                )
            }

            @Serializable
            data class NextBroadcast(
                @SerialName("channel_title")
                val channelTitle: String? = null,
                @SerialName("scheduled_start")
                val scheduledStart: String? = null
            )

            @Serializable
            data class RelatedLink(
                @SerialName("id")
                val id: String? = null,
                @SerialName("kind")
                val kind: String? = null,
                @SerialName("title")
                val title: String? = null,
                @SerialName("type")
                val type: String? = null,
                @SerialName("url")
                val url: String? = null
            )

            @Serializable
            data class Synopses(
                @SerialName("editorial")
                val editorial: String? = null,
                @SerialName("large")
                val large: String? = null,
                @SerialName("medium")
                val medium: String? = null,
                @SerialName("programme_small")
                val programmeSmall: String? = null,
                @SerialName("small")
                val small: String? = null
            )

            @Serializable
            data class Version(
                @SerialName("availability")
                val availability: Availability? = null,
                @SerialName("credits_start")
                val creditsStart: Int? = null,
                @SerialName("download")
                val download: Boolean,
                @SerialName("duration")
                val duration: Duration,
                @SerialName("events")
                val events: List<Event?>? = null,
                @SerialName("first_broadcast")
                val firstBroadcast: String? = null,
                @SerialName("first_broadcast_date_time")
                val firstBroadcastDateTime: String? = null,
                @SerialName("guidance")
                val guidance: Guidance? = null,
                @SerialName("hd")
                val hd: Boolean,
                @SerialName("id")
                val id: String,
                @SerialName("interactions")
                val interactions: List<Interaction?>? = null,
                @SerialName("kind")
                val kind: String? = null,
                @SerialName("type")
                val type: String? = null,
                @SerialName("uhd")
                val uhd: Boolean? = null
            ) {
                @Serializable
                data class Availability(
                    @SerialName("end")
                    val end: String? = null,
                    @SerialName("remaining")
                    val remaining: Remaining? = null,
                    @SerialName("start")
                    val start: String? = null
                ) {
                    @Serializable
                    data class Remaining(
                        @SerialName("text")
                        val text: String? = null
                    )
                }

                @Serializable
                data class Duration(
                    @SerialName("text")
                    val text: String,
                    @SerialName("value")
                    val value: String? = null
                )

                @Serializable
                data class Event(
                    @SerialName("name")
                    val name: String? = null,
                    @SerialName("offset")
                    val offset: Int? = null,
                    @SerialName("system")
                    val system: String? = null
                )

                @Serializable
                data class Guidance(
                    @SerialName("id")
                    val id: String? = null,
                    @SerialName("text")
                    val text: Text? = null
                ) {
                    @Serializable
                    data class Text(
                        @SerialName("large")
                        val large: String? = null,
                        @SerialName("medium")
                        val medium: String? = null,
                        @SerialName("small")
                        val small: String? = null
                    )
                }

                @Serializable
                data class Interaction(
                    @SerialName("interaction_points")
                    val interactionPoints: InteractionPoints? = null,
                    @SerialName("subtype")
                    val subtype: String? = null,
                    @SerialName("title")
                    val title: Title? = null,
                    @SerialName("type")
                    val type: String? = null
                ) {
                    @Serializable
                    data class InteractionPoints(
                        @SerialName("show_from")
                        val showFrom: Int? = null,
                        @SerialName("skip_to")
                        val skipTo: Int? = null
                    )

                    @Serializable
                    data class Title(
                        @SerialName("long")
                        val long: String? = null,
                        @SerialName("short")
                        val short: String? = null
                    )
                }
            }
        }

        @Serializable
        data class Group(
            @SerialName("id")
            val id: String? = null,
            @SerialName("synopses")
            val synopses: Synopses? = null,
            @SerialName("title")
            val title: String? = null,
            @SerialName("type")
            val type: String? = null
        ) {
            @Serializable
            data class Synopses(
                @SerialName("small")
                val small: String? = null
            )
        }
    }
}