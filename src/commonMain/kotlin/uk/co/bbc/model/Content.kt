package uk.co.bbc.model

import uk.co.bbc.model.response.IblResponse.GroupEpisodes.Programme as iPlayerDto

sealed class Content {
    data class iPlayerContent(
        val title: String,
        val subtitle: String?,
        val vpid: String
    ): Content() {
        companion object {
            fun fromDto(dto: iPlayerDto): iPlayerContent =
                with(dto) {
                    iPlayerContent(
                        title = title,
                        subtitle = subtitle,
                        vpid = id
                    )
                }

        }
    }
}