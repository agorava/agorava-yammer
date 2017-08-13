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

import java.util.List;

/**
 * Holder for the results of a message poll
 * @author Morten Andersen-Gott
 *
 */
public class MessageInfo {

	private List<YammerMessage> messages;
	private YammerMessageMeta metadata;
	private List<YammerReference> references;
	
	public MessageInfo(List<YammerMessage> messages, YammerMessageMeta meta, List<YammerReference> references) {
		this.messages=messages;
		this.metadata=meta;
		this.references=references;
	}
	
	/**
	 * List of messages
	 * @return <code>List</code> of {@link YammerMessage}s
	 */
	public List<YammerMessage> getMessages() {
		return messages;
	}
	
	/**
	 * Getter for the meta data for the message poll. Describes the meta data for the messages returned from {@link #getMessages()}
	 * @return {@link YammerMessageMeta}
	 */
	public YammerMessageMeta getMetadata() {
		return metadata;
	}
	
	/**
	 * Returns a list of references. The messages will link to references in this list
	 * @return list of references
	 * @see YammerReference
	 */
	public List<YammerReference> getReferences() {
		return references;
	}
	
}
