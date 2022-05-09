package com.theoxao.dura.recipe.model


import com.fasterxml.jackson.annotation.JsonProperty

class RecipeModel {

    @JsonProperty("adaptation")
    var adaptation: Adaptation? = null

    @JsonProperty("audit_info")
    var auditInfo: AuditInfo? = null

    @JsonProperty("author")
    var author: Author? = null

    @JsonProperty("cover_micro_video")
    var coverMicroVideo: CoverMicroVideo? = null

    @JsonProperty("create_time")
    var createTime: String? = null

    @JsonProperty("desc")
    var desc: String? = null

    @JsonProperty("difficulty")
    var difficulty: Difficulty? = null

    @JsonProperty("dish_author")
    var dishAuthor: List<Any?>? = null

    @JsonProperty("duration")
    var duration: Duration? = null

    @JsonProperty("equipment_related_info")
    var equipmentRelatedInfo: EquipmentRelatedInfo? = null

    @JsonProperty("friendly_create_time")
    var friendlyCreateTime: String? = null

    @JsonProperty("has_minor_avatar")
    var hasMinorAvatar: Boolean? = null

    @JsonProperty("id")
    var id: Int? = null

    @JsonProperty("ident")
    var ident: String? = null

    @JsonProperty("image")
    var image: Image? = null

    @JsonProperty("ingredient")
    var ingredient: List<Ingredient?>? = null

    @JsonProperty("instruction")
    var instruction: List<Instruction?>? = null

    @JsonProperty("is_adaptation_recipe")
    var isAdaptationRecipe: Boolean? = null

    @JsonProperty("is_exclusive")
    var isExclusive: Boolean? = null

    @JsonProperty("is_fullscreen")
    var isFullscreen: Boolean? = null

    @JsonProperty("is_prime_recipe")
    var isPrimeRecipe: Boolean? = null

    @JsonProperty("is_private")
    var isPrivate: Boolean? = null

    @JsonProperty("labels")
    var labels: List<Any?>? = null

    @JsonProperty("minor_author")
    var minorAuthor: MinorAuthor? = null

    @JsonProperty("name")
    var name: String? = null

    @JsonProperty("original_categories")
    var originalCategories: List<Any?>? = null

    @JsonProperty("photo")
    var photo: String? = null

    @JsonProperty("photo140")
    var photo140: String? = null

    @JsonProperty("photo280")
    var photo280: String? = null

    @JsonProperty("photo340")
    var photo340: String? = null

    @JsonProperty("photo526")
    var photo526: String? = null

    @JsonProperty("photo580")
    var photo580: String? = null

    @JsonProperty("photo640")
    var photo640: String? = null

    @JsonProperty("photo80")
    var photo80: String? = null

    @JsonProperty("photo90")
    var photo90: String? = null

    @JsonProperty("property_desc")
    var propertyDesc: PropertyDesc? = null

    @JsonProperty("purchase_button")
    var purchaseButton: PurchaseButton? = null

    @JsonProperty("purchase_url")
    var purchaseUrl: String? = null

    @JsonProperty("recipe_cats")
    var recipeCats: List<Any?>? = null

    @JsonProperty("recipe_type")
    var recipeType: Int? = null

    @JsonProperty("score")
    var score: String? = null

    @JsonProperty("stats")
    var stats: Stats? = null

    @JsonProperty("summary")
    var summary: String? = null

    @JsonProperty("summary_desc")
    var summaryDesc: String? = null

    @JsonProperty("thumb")
    var thumb: String? = null

    @JsonProperty("tips")
    var tips: String? = null

    @JsonProperty("update_time")
    var updateTime: String? = null

    @JsonProperty("url")
    var url: String? = null

    @JsonProperty("video_page_url")
    var videoPageUrl: String? = null

    @JsonProperty("video_url")
    var videoUrl: String? = null

    @JsonProperty("vod_video")
    var vodVideo: VodVideo? = null

    class Adaptation {

        @JsonProperty("adaptation_history_url")
        var adaptationHistoryUrl: String? = null

        @JsonProperty("allow_adaptation")
        var allowAdaptation: Boolean? = null

        @JsonProperty("allow_to_change_adaptation_status")
        var allowToChangeAdaptationStatus: Boolean? = null

        @JsonProperty("n_adaptation")
        var nAdaptation: Int? = null

        @JsonProperty("root_recipe_id")
        var rootRecipeId: String? = null
    }

    class AuditInfo {

        @JsonProperty("url")
        var url: String? = null

        @JsonProperty("waiting_for_audit")
        var waitingForAudit: Boolean? = null
    }

    class Author {

        @JsonProperty("has_user_been_prime")
        var hasUserBeenPrime: Boolean? = null

        @JsonProperty("id")
        var id: String? = null

        @JsonProperty("image")
        var image: Image? = null

        @JsonProperty("is_expert")
        var isExpert: Boolean? = null

        @JsonProperty("is_following")
        var isFollowing: Boolean? = null

        @JsonProperty("is_mp")
        var isMp: Boolean? = null

        @JsonProperty("is_prime_avaliable")
        var isPrimeAvaliable: Boolean? = null

        @JsonProperty("is_social_verified")
        var isSocialVerified: Boolean? = null

        @JsonProperty("labels")
        var labels: List<Any?>? = null

        @JsonProperty("mail")
        var mail: String? = null

        @JsonProperty("name")
        var name: String? = null

        @JsonProperty("photo")
        var photo: String? = null

        @JsonProperty("photo160")
        var photo160: String? = null

        @JsonProperty("photo60")
        var photo60: String? = null

        @JsonProperty("report_url")
        var reportUrl: String? = null

        @JsonProperty("social_verified_reason")
        var socialVerifiedReason: String? = null

        @JsonProperty("url")
        var url: String? = null

        class Image {

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
    }

    class CoverMicroVideo

    class Difficulty {

        @JsonProperty("text")
        var text: String? = null

        @JsonProperty("value")
        var value: Int? = null
    }

    class Duration {

        @JsonProperty("text")
        var text: String? = null

        @JsonProperty("value")
        var value: Int? = null
    }

    class EquipmentRelatedInfo {

        @JsonProperty("equipments")
        var equipments: List<Any?>? = null
    }

    class Image {

        var uuid:String? = null

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

    class Ingredient {

        var oid:Int? = null

        @JsonProperty("amount")
        var amount: String? = null

        @JsonProperty("cat")
        var cat: String? = null

        @JsonProperty("name")
        var name: String? = null
    }

    class Instruction {

        @JsonProperty("ident")
        var ident: String? = null

        @JsonProperty("image")
        var image: Image? = null

        @JsonProperty("photo800")
        var photo800: String? = null

        @JsonProperty("step")
        var step: String? = null

        @JsonProperty("text")
        var text: String? = null

        @JsonProperty("url")
        var url: String? = null

        @JsonProperty("video")
        var video: VideoModel? = null

        class Image {

            var uuid:String?  =null

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

    }

    class MinorAuthor

    class PropertyDesc

    class PurchaseButton

    class Stats {

        @JsonProperty("cooked_by_me")
        var cookedByMe: Boolean? = null

        @JsonProperty("n_collects")
        var nCollects: String? = null

        @JsonProperty("n_comments")
        var nComments: String? = null

        @JsonProperty("n_cooked")
        var nCooked: String? = null

        @JsonProperty("n_cooked_last_week")
        var nCookedLastWeek: String? = null

        @JsonProperty("n_diggs")
        var nDiggs: String? = null

        @JsonProperty("n_dishes")
        var nDishes: String? = null

        @JsonProperty("n_instructions")
        var nInstructions: Int? = null

        @JsonProperty("n_pv")
        var nPv: String? = null

        @JsonProperty("n_question_and_answers")
        var nQuestionAndAnswers: String? = null

        @JsonProperty("n_questions")
        var nQuestions: String? = null

        @JsonProperty("n_unformatted_collects")
        var nUnformattedCollects: String? = null

        @JsonProperty("n_unformatted_pv")
        var nUnformattedPv: String? = null

        @JsonProperty("n_unformatted_vod_played")
        var nUnformattedVodPlayed: String? = null

        @JsonProperty("n_vod_played")
        var nVodPlayed: String? = null
    }

    class VodVideo
}