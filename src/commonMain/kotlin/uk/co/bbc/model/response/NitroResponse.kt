package uk.co.bbc.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NitroResponse(
    @SerialName("nitro")
    val nitro: Nitro
) {
    @Serializable
    data class Nitro(
        @SerialName("deprecations")
        val deprecations: Deprecations? = null,
        @SerialName("filters")
        val filters: Filters? = null,
        @SerialName("mixins")
        val mixins: Mixins? = null,
        @SerialName("pagination")
        val pagination: Pagination? = null,
        @SerialName("results")
        val results: Results,
        @SerialName("sorts")
        val sorts: Sorts? = null
    ) {
        @Serializable
        data class Deprecations(
            @SerialName("deprecated")
            val deprecated: List<Deprecated?>? = null
        ) {
            @Serializable
            data class Deprecated(
                @SerialName("deprecated_since")
                val deprecatedSince: String? = null,
                @SerialName("name")
                val name: String? = null,
                @SerialName("replaced_by")
                val replacedBy: String? = null,
                @SerialName("replacement_type")
                val replacementType: String? = null,
                @SerialName("type")
                val type: String? = null
            )
        }

        @Serializable
        data class Filters(
            @SerialName("filter")
            val filter: List<Filter?>? = null
        ) {
            @Serializable
            data class Filter(
                @SerialName("default")
                val default: String? = null,
                @SerialName("depends_on")
                val dependsOn: String? = null,
                @SerialName("deprecated")
                val deprecated: Boolean? = null,
                @SerialName("deprecated_since")
                val deprecatedSince: String? = null,
                @SerialName("min_value")
                val minValue: Int? = null,
                @SerialName("multiple_values")
                val multipleValues: Boolean? = null,
                @SerialName("name")
                val name: String? = null,
                @SerialName("prefer")
                val prefer: String? = null,
                @SerialName("release_status")
                val releaseStatus: String? = null,
                @SerialName("title")
                val title: String? = null,
                @SerialName("type")
                val type: String? = null
            )
        }

        @Serializable
        data class Mixins(
            @SerialName("mixin")
            val mixin: List<Mixin?>? = null
        ) {
            @Serializable
            data class Mixin(
                @SerialName("depends_on")
                val dependsOn: String? = null,
                @SerialName("deprecated")
                val deprecated: Boolean? = null,
                @SerialName("deprecated_since")
                val deprecatedSince: String? = null,
                @SerialName("href")
                val href: String? = null,
                @SerialName("name")
                val name: String? = null,
                @SerialName("prohibits")
                val prohibits: Prohibits? = null,
                @SerialName("release_status")
                val releaseStatus: String? = null,
                @SerialName("replaced_by")
                val replacedBy: String? = null,
                @SerialName("title")
                val title: String? = null
            ) {
                @Serializable
                data class Prohibits(
                    @SerialName("mixin")
                    val mixin: Mixin? = null
                ) {
                    @Serializable
                    data class Mixin(
                        @SerialName("name")
                        val name: String? = null
                    )
                }
            }
        }

        @Serializable
        data class Pagination(
            @SerialName("next")
            val next: Next? = null
        ) {
            @Serializable
            data class Next(
                @SerialName("href")
                val href: String? = null
            )
        }

        @Serializable
        data class Results(
            @SerialName("items")
            val items: List<Item> = emptyList(),
            @SerialName("more_than")
            val moreThan: Int? = null,
            @SerialName("page")
            val page: Int? = null,
            @SerialName("page_size")
            val pageSize: Int? = null,
            @SerialName("total")
            val total: Int? = null
        ) {
            @Serializable
            data class Item(
                @SerialName("advertising_allowed")
                val advertisingAllowed: String? = null,
                @SerialName("ancestors")
                val ancestors: Ancestors? = null,
                @SerialName("available_webcasts")
                val availableWebcasts: AvailableWebcasts? = null,
                @SerialName("embargoed")
                val embargoed: String? = null,
                @SerialName("episode_of")
                val episodeOf: EpisodeOf? = null,
                @SerialName("franchises")
                val franchises: Franchises? = null,
                @SerialName("genre_groups")
                val genreGroups: GenreGroups? = null,
                @SerialName("has_guidance")
                val hasGuidance: Boolean? = null,
                @SerialName("identifiers")
                val identifiers: Identifiers? = null,
                @SerialName("image")
                val image: Image? = null,
                @SerialName("is_stacked")
                val isStacked: Boolean? = null,
                @SerialName("item_type")
                val itemType: String? = null,
                @SerialName("items_for")
                val itemsFor: ItemsFor? = null,
                @SerialName("master_brand")
                val masterBrand: MasterBrand? = null,
                @SerialName("media_type")
                val mediaType: String? = null,
                @SerialName("partner")
                val partner: String? = null,
                @SerialName("pid")
                val pid: String,
                @SerialName("presentation_title")
                val presentationTitle: String? = null,
                @SerialName("release_date")
                val releaseDate: String? = null,
                @SerialName("series_of")
                val seriesOf: SeriesOf? = null,
                @SerialName("synopses")
                val synopses: Synopses? = null,
                @SerialName("title")
                val title: String? = null,
                @SerialName("updated_time")
                val updatedTime: String? = null
            ) {
                @Serializable
                data class Ancestors(
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
                )

                @Serializable
                data class AvailableWebcasts(
                    @SerialName("available")
                    val available: Int? = null,
                    @SerialName("version")
                    val version: List<Version?>? = null
                ) {
                    @Serializable
                    data class Version(
                        @SerialName("availabilities")
                        val availabilities: Availabilities? = null,
                        @SerialName("competition_warning")
                        val competitionWarning: Boolean? = null,
                        @SerialName("duration")
                        val duration: String? = null,
                        @SerialName("pid")
                        val pid: String? = null,
                        @SerialName("types")
                        val types: Types? = null
                    ) {
                        @Serializable
                        data class Availabilities(
                            @SerialName("availability")
                            val availability: List<Availability?>? = null
                        ) {
                            @Serializable
                            data class Availability(
                                @SerialName("accurate_start")
                                val accurateStart: String? = null,
                                @SerialName("media_sets")
                                val mediaSets: MediaSets? = null,
                                @SerialName("scheduled_end")
                                val scheduledEnd: String? = null,
                                @SerialName("scheduled_start")
                                val scheduledStart: String? = null,
                                @SerialName("services")
                                val services: Services? = null,
                                @SerialName("status")
                                val status: String? = null,
                                @SerialName("type")
                                val type: String? = null
                            ) {
                                @Serializable
                                data class MediaSets(
                                    @SerialName("media_set")
                                    val mediaSet: List<MediaSet?>? = null
                                ) {
                                    @Serializable
                                    data class MediaSet(
                                        @SerialName("name")
                                        val name: String? = null,
                                        @SerialName("territories")
                                        val territories: Territories? = null
                                    ) {
                                        @Serializable
                                        data class Territories(
                                            @SerialName("territory")
                                            val territory: List<String?>? = null
                                        )
                                    }
                                }

                                @Serializable
                                data class Services(
                                    @SerialName("service")
                                    val service: List<Service?>? = null
                                ) {
                                    @Serializable
                                    data class Service(
                                        @SerialName("sid")
                                        val sid: String? = null
                                    )
                                }
                            }
                        }

                        @Serializable
                        data class Types(
                            @SerialName("type")
                            val type: List<String?>? = null
                        )
                    }
                }

                @Serializable
                data class EpisodeOf(
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("pid")
                    val pid: String? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
                )

                @Serializable
                data class Franchises(
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
                )

                @Serializable
                data class GenreGroups(
                    @SerialName("deprecated")
                    val deprecated: Boolean? = null,
                    @SerialName("deprecated_since")
                    val deprecatedSince: String? = null,
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("replaced_by")
                    val replacedBy: String? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
                )

                @Serializable
                data class Identifiers(
                    @SerialName("identifier")
                    val identifier: List<Identifier?>? = null
                ) {
                    @Serializable
                    data class Identifier(
                        @SerialName("authority")
                        val authority: String? = null,
                        @SerialName("type")
                        val type: String? = null,
                        @SerialName("$")
                        val x: String? = null
                    )
                }

                @Serializable
                data class Image(
                    @SerialName("deprecated")
                    val deprecated: Boolean? = null,
                    @SerialName("deprecated_since")
                    val deprecatedSince: String? = null,
                    @SerialName("pid")
                    val pid: String? = null,
                    @SerialName("replaced_by")
                    val replacedBy: String? = null,
                    @SerialName("template_url")
                    val templateUrl: String? = null
                )

                @Serializable
                data class ItemsFor(
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
                )

                @Serializable
                data class MasterBrand(
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("mid")
                    val mid: String? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
                )

                @Serializable
                data class SeriesOf(
                    @SerialName("href")
                    val href: String? = null,
                    @SerialName("pid")
                    val pid: String? = null,
                    @SerialName("position")
                    val position: Int? = null,
                    @SerialName("result_type")
                    val resultType: String? = null
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
            }
        }

        @Serializable
        data class Sorts(
            @SerialName("sort")
            val sort: List<Sort?>? = null
        ) {
            @Serializable
            data class Sort(
                @SerialName("is_default")
                val isDefault: String? = null,
                @SerialName("name")
                val name: String? = null,
                @SerialName("release_status")
                val releaseStatus: String? = null,
                @SerialName("title")
                val title: String? = null
            )
        }
    }
}