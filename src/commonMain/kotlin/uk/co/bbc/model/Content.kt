package uk.co.bbc.model

import uk.co.bbc.model.response.TrevorResponse
import uk.co.bbc.model.response.IblResponse as iPlayerDto
import uk.co.bbc.model.response.IblResponse.GroupEpisodes.Element as iPlayerEpisodeDto
import uk.co.bbc.model.response.IblResponse.GroupEpisodes.Element.Version as iPlayerVersionDto
import uk.co.bbc.model.response.RmsResponse as SoundsDto
import uk.co.bbc.model.response.RmsResponse.Data as SoundsPlayableItemDto
import uk.co.bbc.model.response.NitroResponse as LiveDto
import uk.co.bbc.model.response.NitroResponse.Nitro.Results.Item as LivePlayableItemDto

sealed class Content {
    abstract val title: String
    abstract val subtitle: String?
    abstract val vpid: String
    abstract val avType: String
    abstract val isLive: Boolean

    data class iPlayerContent(
        override val title: String,
        override val subtitle: String?,
        override val vpid: String,
        override val avType: String,
        override val isLive: Boolean,
        val episodeID: String?,
        val hd: Boolean,
        val download: Boolean,
        val duration: String,
        val image: String
    ) : Content() {
        companion object {
            fun fromDto(dto: iPlayerDto): List<iPlayerContent> =
                dto.groupEpisodes.elements
                    .flatMap { episode ->
                        episode.versions
                            .filter { it.kind == VERSION_KIND_ORIGINAL }
                            .map { version -> fromDto(episode, version) }
                    }

            private fun fromDto(episode: iPlayerEpisodeDto, version: iPlayerVersionDto): iPlayerContent =
                iPlayerContent(
                    title = episode.title,
                    subtitle = episode.subtitle,
                    vpid = version.id,
                    avType = AV_TYPE_VIDEO,
                    isLive = episode.live,
                    episodeID = episode.id,
                    hd = version.hd,
                    download = version.download,
                    duration = version.duration.text,
                    image = episode.images.standard.toSizedImageUrl()
                )

            private const val VERSION_KIND_ORIGINAL = "original"
        }
    }

    data class NewsContent(
        override val title: String,
        override val subtitle: String?,
        override val vpid: String,
        override val avType: String,
        override val isLive: Boolean,
        var duration: Int?,
        var clipID: String,
        var iChefUrl: String
    ) : Content() {
        companion object {
            fun fromDto(dto: TrevorResponse): List<NewsContent> {
                val flattenedRelations = dto.relations.flatMap { it.allChildRelations() }

                return flattenedRelations
                    .filter { it.primaryType == PRIMARY_TYPE_VIDEO }
                    .map { item ->
                        item.content.let { content ->
                            NewsContent(
                                title = content.caption ?: "",
                                subtitle = "",
                                vpid = content.externalId ?: "",
                                avType = AV_TYPE_VIDEO,
                                isLive = content.isLive ?: false,
                                duration = content.duration,
                                clipID = content.id?.replace(CLIP_ID_TRIM, "") ?: "",
                                iChefUrl = content.iChefUrl?.toSizedImageUrl() ?: FALLBACK_ICHEF_URL
                            )
                        }
                    }
            }

            private fun TrevorResponse.Relation.allChildRelations(): List<TrevorResponse.Relation> =
                listOf(this) + content.relations.flatMap { it.allChildRelations() }

            private const val PRIMARY_TYPE_VIDEO = "bbc.mobile.news.video"
            private const val CLIP_ID_TRIM = "/video/"
            private const val FALLBACK_ICHEF_URL =
                "https://i.pinimg.com/originals/d9/b3/ae/d9b3ae779f3c1b95b2dbac89327924d1.jpg"
        }
    }

    data class SoundsContent(
        override val title: String,
        override val subtitle: String?,
        override val vpid: String,
        override val avType: String,
        override val isLive: Boolean,
        var episodeID: String
    ) : Content() {
        companion object {
            fun fromDto(dto: SoundsDto): List<SoundsContent> =
                dto.data.map(::fromDto)

            private fun fromDto(playableItem: SoundsPlayableItemDto): SoundsContent =
                SoundsContent(
                    title = playableItem.titles.primary ?: "",
                    subtitle = playableItem.titles.secondary,
                    vpid = playableItem.id,
                    avType = AV_TYPE_AUDIO,
                    isLive = false,
                    episodeID = playableItem.container?.id ?: ""
                )
        }
    }

    data class LiveContent(
        override val title: String,
        override val subtitle: String?,
        override val vpid: String,
        override val avType: String,
        override val isLive: Boolean,
        var episodeID: String
    ) : Content() {
        companion object {
            fun fromDto(dto: LiveDto): List<LiveContent> =
                dto.nitro.results.items.mapNotNull(::fromDto)

            private fun fromDto(playableItem: LivePlayableItemDto): LiveContent? {
                val pid = playableItem.availableWebcasts?.version?.firstOrNull()?.pid ?: return null

                return LiveContent(
                    title = playableItem.title ?: "",
                    subtitle = "",
                    vpid = pid,
                    avType = playableItem.mediaType?.lowercase() ?: "",
                    isLive = true,
                    episodeID = playableItem.pid
                )
            }
        }
    }

    companion object {
        fun String.toSizedImageUrl(): String =
            replace(IMAGE_SIZE_TEMPLATE, IMAGE_SIZE_TARGET)

        private const val IMAGE_SIZE_TEMPLATE = "{recipe}"
        private const val IMAGE_SIZE_TARGET = "976x549"

        private const val AV_TYPE_VIDEO = "video"
        private const val AV_TYPE_AUDIO = "audio"
    }
}
