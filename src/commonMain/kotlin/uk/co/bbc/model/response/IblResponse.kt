package uk.co.bbc.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IblResponse(
    @SerialName("group_episodes") val groupEpisodes: GroupEpisodes
) {
    @Serializable
    data class GroupEpisodes(
        val elements: List<Programme>
    ) {
        @Serializable
        data class Programme(
            val id: String,
            val title: String,
            val subtitle: String
        )
    }
}