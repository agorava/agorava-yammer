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

import org.agorava.yammer.model.YammerThread.ThreadStats;

public class ThreadReference extends YammerReference{

	private long threadStarterId;
	private ThreadStats stats;
	private boolean directMessage;
	
	public ThreadReference(long id, String url, String webUrl) {
		super(id, url, webUrl);
	}
	
	public long getThreadStarterId() {
		return threadStarterId;
	}
	
	public ThreadStats getStats() {
		return stats;
	}
	
	public boolean isDirectMessage() {
		return directMessage;
	}

	@Override
	public String toString() {
		return "ThreadReference [getId()=" + getId() + ", getUrl()=" + getUrl() + ", getWebUrl()=" + getWebUrl() + ", threadStarterId="
				+ threadStarterId + ", stats=" + stats + ", directMessage=" + directMessage + "]";
	}
	
	

}
