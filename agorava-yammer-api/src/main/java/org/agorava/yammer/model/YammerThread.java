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

import java.util.Date;
import java.util.List;


/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerThread {

	private ThreadStats stats;
	private String type;
	private String privacy;
	private long threadStarterId;
	private boolean hasAttachements;
	private String webUrl;
	private long id;
	private boolean directMessage;
	private List<Topic> topics;
	
	public YammerThread(
			ThreadStats stats, String type, String privacy, long threadStarterId, boolean hasAttachements,
			String webUrl, long id, boolean directMessage, List<Topic> topics) {
		this.stats = stats;
		this.type = type;
		this.privacy = privacy;
		this.threadStarterId = threadStarterId;
		this.hasAttachements = hasAttachements;
		this.webUrl = webUrl;
		this.id = id;
		this.directMessage = directMessage;
		this.topics = topics;
	}
	

	public long getFirstReplyId(){
		return stats.firstReplyId;
	}
	
	public Date getFirstReplyDate(){
		return stats.firstReplyAt;
	}
	
	public long getLatestReplyId(){
		return stats.latestReplyId;
	}
	
	public Date getLatestReplyDate(){
		return stats.latestReplyAt;
	}
	
	public int getMessageCount(){
		return stats.messageCount;
	}

	public String getType() {
		return type;
	}

	public String getPrivacy() {
		return privacy;
	}

	public long getThreadStarterId() {
		return threadStarterId;
	}

	public boolean hasAttachements() {
		return hasAttachements;
	}


	public String getWebUrl() {
		return webUrl;
	}


	public long getId() {
		return id;
	}


	public boolean isDirectMessage() {
		return directMessage;
	}

	public List<Topic> getTopics() {
		return topics;
	}


	public static class ThreadStats{
		private Date firstReplyAt;
		private Date latestReplyAt;
		private long firstReplyId;
		private long latestReplyId;
		private int messageCount;
        private int shares;
		
		
		public ThreadStats(Date firstReplyAt, Date latestReplyAt, long firstReplyId, long latestReplyId,
				int messageCount, int shares) {
			this.firstReplyAt = firstReplyAt;
			this.latestReplyAt = latestReplyAt;
			this.firstReplyId = firstReplyId;
			this.latestReplyId = latestReplyId;
			this.messageCount = messageCount;
            this.shares=shares;
		}


		@Override
		public String toString() {
			return "ThreadStats [firstReplyAt=" + firstReplyAt + ", latestReplyAt=" + latestReplyAt + ", firstReplyId=" + firstReplyId
					+ ", latestReplyId=" + latestReplyId + ", messageCount=" + messageCount + ", shares=" + shares + "]";
		}
		
		
		
	}
	
}
