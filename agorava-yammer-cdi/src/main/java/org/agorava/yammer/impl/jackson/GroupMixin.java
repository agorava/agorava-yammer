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

import java.util.Date;

import org.agorava.yammer.impl.YammerDateDeserializer;
import org.agorava.yammer.model.Group.GroupStats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author Werner Keil
 * @author Morten Andersen-Gott
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class GroupMixin {

	@JsonCreator
	GroupMixin(
			@JsonProperty("privacy")String privacy,
			@JsonProperty("web_url")String webUrl,
			@JsonProperty("stats") GroupStats stats,
			@JsonProperty("mugshot_url")String mugshotUrl,
			@JsonProperty("url") String url,
			@JsonProperty("description")String description,
			@JsonProperty("full_name") String fullName,
			@JsonProperty("name") String name,
			@JsonProperty("id") long id,
			@JsonProperty("created_at") @JsonDeserialize(using=YammerDateDeserializer.class) Date createdAt			
			) {}

    @JsonIgnoreProperties(ignoreUnknown=true)
    static class GroupStatsMixin{
		@JsonCreator

		GroupStatsMixin(
				@JsonProperty("members") int members,
				@JsonProperty("updates") int updates,
				@JsonProperty("last_message_at") @JsonDeserialize(using=YammerDateDeserializer.class) Date lastMessageAt,
				@JsonProperty("last_message_id") long lastMessageId
		) {}
	}
}
