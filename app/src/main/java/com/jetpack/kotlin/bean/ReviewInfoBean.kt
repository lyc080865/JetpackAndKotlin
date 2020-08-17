package com.jetpack.kotlin.bean

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
data class ReviewInfoBean(
    var id: String,
    var uid: String,
    var img_url: String,
    var img_url_thumb: String,
    var atime: String,
    var zvid: String,
    var zvsid: String,
    var uname: String,
    var avator: String,
    var video_title: String,
    var class_name: String,
    var section_name: String,
    var frequency: String,
    var img_url_cj: String,
    var review_voice: String,
    var coordinate: String,
    var like_num: Int,
    var medal_num: Int,
    var like_time: String,
    var medal_time: String,
    var gif_time: String,
    var is_recommend: Int
)