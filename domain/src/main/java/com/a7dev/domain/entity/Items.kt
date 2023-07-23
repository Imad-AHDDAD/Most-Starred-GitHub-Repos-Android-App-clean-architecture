package com.a7dev.domain.entity

import com.a7dev.mobilecodingchallenge_moststarredgithubrepos.data.entities.Owners

/**
 * Items Class
 * @author Imad AHDDAD
 *
 * @property name : repository's name
 * @property owner : repository's owner
 * @property description : repository's description
 * @property stargazers_count : repository's stars number
 * @property html_url : repository's link
 */
data class Items(val name: String, val owner: Owners, val description: String, val stargazers_count: Int, val html_url: String)
