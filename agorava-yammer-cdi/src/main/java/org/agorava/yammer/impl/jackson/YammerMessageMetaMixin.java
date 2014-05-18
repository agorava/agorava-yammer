/*
 * Copyright 2014 Agorava.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agorava.yammer.impl.jackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Morten Andersen-Gott
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class YammerMessageMetaMixin {

	@JsonCreator
	public YammerMessageMetaMixin(
			@JsonProperty("current_user_id")long currentUserId, 
			@JsonProperty("feed_name")String feedName, 
			@JsonProperty("feed_desc")String feedDescription,
			@JsonProperty("unsee_message_count_following")int unseenMessageCountFollowing, 
			@JsonProperty("unseen_message_count_received")int unseenMessageCountReceived, 
			@JsonProperty("liked_message_ids")List<Long> likedMessageIds,
			@JsonProperty("favorite_message_ids")List<Long> favoriteMessageIds, 
			@JsonProperty("followed_user_id")List<Long> followedUserIds, 
			@JsonProperty("bookmarked_message_ids")List<Long> bookmarkedMessageIds) {}
	
}