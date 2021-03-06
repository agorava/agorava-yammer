/*
 * Copyright 2014 Agorava
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
package org.agorava.yammer.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class GroupReferenceMixin {

	@JsonCreator
	public GroupReferenceMixin(
			@JsonProperty("id") long id, 
			@JsonProperty("url")String url, 
			@JsonProperty("web_url")String webUrl,
			@JsonProperty("name")String name
			) {	}
	
	@JsonProperty("full_name")
	String fullName;
	
	@JsonProperty("description")
	String description;
	
	@JsonProperty("mugshot_url")
	String mugshotUrl;
	
}
