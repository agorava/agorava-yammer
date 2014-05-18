/*
 * Copyright 2011 the original author or authors.
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
package org.agorava.yammer.model;

public class TopicReference extends YammerReference{

	private String name;
	private String normalizedName;
	private String permalink;
	
	public TopicReference(long id, String url, String webUrl, String name) {
		super(id, url, webUrl);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNormalizedName() {
		return normalizedName;
	}
	
	public String getPermalink() {
		return permalink;
	}
	
	

}
