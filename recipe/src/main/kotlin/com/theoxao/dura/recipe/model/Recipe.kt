package com.theoxao.dura.recipe.model

import com.fasterxml.jackson.annotation.JsonProperty


class ResponseWrapper{
    var status:String?  = null
    var content:Map<String, RecipeModel>? = null
}

class Recipe {
    var adaptation: Adaptation? = null
    @JsonProperty("audit_info")
    var auditInfo: AuditInfo? = null
    var author: Author? = null
    @JsonProperty("cover_micro_video")
    var coverMicroVideo: CoverMicroVideo? = null
    @JsonProperty("create_time")
    var createTime: String? = null
    var desc: String? = null
    var difficulty: Difficulty? = null
    @JsonProperty("create_time")
    var dishAuthor: List<Any?>? = null
    var duration: Duration? = null
    @JsonProperty("create_time")
    var equipmentRelatedInfo: EquipmentRelatedInfo? = null
    @JsonProperty("create_time")
    var friendlyCreateTime: String? = null
    @JsonProperty("create_time")
    var hasMinorAvatar: Boolean? = null
    var id: Int? = null
    var ident: String? = null
    var image: Image? = null
    var ingredient: List<Ingredient?>? = null
    var instruction: List<Instruction?>? = null
    @JsonProperty("create_time")
    var isAdaptationRecipe: Boolean? = null
    var isExclusive: Boolean? = null
    var isFullscreen: Boolean? = null
    var isPrimeRecipe: Boolean? = null
    var isPrivate: Boolean? = null
    var labels: List<Any?>? = null
    var minorAuthor: MinorAuthor? = null
    var name: String? = null
    var originalCategories: List<Any?>? = null
    var photo: String? = null
    var photo140: String? = null
    var photo280: String? = null
    var photo340: String? = null
    var photo526: String? = null
    var photo580: String? = null
    var photo640: String? = null
    var photo80: String? = null
    var photo90: String? = null
    var propertyDesc: PropertyDesc? = null
    var purchaseButton: PurchaseButton? = null
    var purchaseUrl: String? = null
    var recipeCats: List<Any?>? = null
    var score: String? = null
    var stats: Stats? = null
    var summary: String? = null
    var summaryDesc: String? = null
    var thumb: String? = null
    var tips: String? = null
    var updateTime: String? = null
    var url: String? = null
    var videoPageUrl: String? = null
    var videoUrl: String? = null
    var vodVideo: VodVideo? = null

    class Adaptation {

        var adaptationHistoryUrl: String? = null
        var allowAdaptation: Boolean? = null
        var allowToChangeAdaptationStatus: Boolean? = null
        var nAdaptation: Int? = null
        var rootRecipeId: String? = null
    }

    class AuditInfo {

        var url: String? = null
        var waitingForAudit: Boolean? = null
    }

    class Author {

        var hasUserBeenPrime: Boolean? = null
        var id: String? = null
        var image: Image? = null
        var isExpert: Boolean? = null
        var isFollowing: Boolean? = null
        var isMp: Boolean? = null
        var isPrimeAvaliable: Boolean? = null
        var isSocialVerified: Boolean? = null
        var labels: List<Label?>? = null
        var mail: String? = null
        var name: String? = null
        var photo: String? = null
        var photo160: String? = null
        var photo60: String? = null
        var reportUrl: String? = null
        var socialVerifiedReason: String? = null
        var url: String? = null

        class Image {

            var ident: String? = null
            var maxHeight: Int? = null
            var maxWidth: Int? = null
            var originalHeight: Int? = null
            var originalWidth: Int? = null
            var urlPattern: String? = null
        }

        class Label {

            var bgColor: String? = null
            var color: String? = null
            var colorV2: String? = null
            var gradientBgColors: List<String?>? = null
            var rank: Int? = null
            var text: String? = null
            var url: String? = null
        }
    }

    class CoverMicroVideo

    class Difficulty {

        var text: String? = null
        var value: Int? = null
    }

    class Duration {

        var text: String? = null
        var value: Int? = null
    }

    class EquipmentRelatedInfo {

        var equipments: List<Any?>? = null
    }

    class Image {

        var ident: String? = null
        var maxHeight: Int? = null
        var maxWidth: Int? = null
        var originalHeight: Int? = null
        var originalWidth: Int? = null
        var urlPattern: String? = null
    }

    class Ingredient {

        var amount: String? = null
        var cat: String? = null
        var name: String? = null
    }

    class Instruction {

        var ident: String? = null
        var image: Image? = null
        var photo800: String? = null
        var step: String? = null
        var text: String? = null
        var url: String? = null
        var video: Video? = null

        class Image {

            var ident: String? = null
            var maxHeight: Int? = null
            var maxWidth: Int? = null
            var originalHeight: Int? = null
            var originalWidth: Int? = null
            var urlPattern: String? = null
        }

        class Video
    }

    class MinorAuthor

    class PropertyDesc

    class PurchaseButton

    class Stats {

        var cookedByMe: Boolean? = null
        var nCollects: String? = null
        var nComments: String? = null
        var nCooked: String? = null
        var nCookedLastWeek: String? = null
        var nDiggs: String? = null
        var nDishes: String? = null
        var nInstructions: Int? = null
        var nPv: String? = null
        var nQuestionAndAnswers: String? = null
        var nQuestions: String? = null
        var nUnformattedCollects: String? = null
        var nUnformattedPv: String? = null
        var nUnformattedVodPlayed: String? = null
        var nVodPlayed: String? = null
    }

    class VodVideo
}