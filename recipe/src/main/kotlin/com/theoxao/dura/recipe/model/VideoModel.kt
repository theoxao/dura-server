package com.theoxao.dura.recipe.model


import com.fasterxml.jackson.annotation.JsonProperty

class VideoModel {

    var uuid:String? = null

    @JsonProperty("cover")
    var cover: Cover? = null

    @JsonProperty("height")
    var height: Int? = null

    @JsonProperty("id")
    var id: Int? = null

    @JsonProperty("ident")
    var ident: String? = null

    @JsonProperty("is_public")
    var isPublic: Boolean? = null

    @JsonProperty("multi_definitions")
    var multiDefinitions: List<MultiDefinition?>? = null

    @JsonProperty("template")
    var template: String? = null

    @JsonProperty("transcode_status")
    var transcodeStatus: Int? = null

    @JsonProperty("universal_player_url")
    var universalPlayerUrl: String? = null

    @JsonProperty("url")
    var url: String? = null

    @JsonProperty("video_ident")
    var videoIdent: String? = null

    @JsonProperty("vod_id")
    var vodId: String? = null

    @JsonProperty("width")
    var width: Int? = null

    class Cover {

        @JsonProperty("ident")
        var ident: String? = null

        @JsonProperty("max_height")
        var maxHeight: Int? = null

        @JsonProperty("max_width")
        var maxWidth: Int? = null

        @JsonProperty("original_height")
        var originalHeight: Int? = null

        @JsonProperty("original_width")
        var originalWidth: Int? = null

        @JsonProperty("url_pattern")
        var urlPattern: String? = null
    }

    class MultiDefinition {

        @JsonProperty("definition_code")
        var definitionCode: String? = null

        @JsonProperty("ident")
        var ident: String? = null

        @JsonProperty("label")
        var label: String? = null

        @JsonProperty("url")
        var url: String? = null
    }
}