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
package org.agorava.yammer.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.agorava.yammer.MessageService;

/**
 * Details beyond the message, used when posting to yammer. Differs from
 * {@link YammerMessage} which is the type returned when submitting a posting or
 * when polling for messages with any of the get-methods in {@link MessageService}
 * 
 * @see YammerMessage
 * 
 * @author Werner Keil
 * @author Morten Andersen-Gott
 * 
 */
public class YammerPostDetails {

	private Long groupId;
	private Long replyToId;
	private Long directToUserId;
	private Boolean broadcast;
	private List<String> topics = new ArrayList<String>();
	private OpenGraphObject openGraphObject;
	private List<InputStream> attachments = new ArrayList<InputStream>();

	public Map<String, Object> toParameters() {
		Map<String, Object> params = new HashMap<String, Object>();
		if (broadcast != null) {
			params.put("broadcast", String.valueOf(broadcast));
		}
		addLongToParamsIfSet(params, groupId, "group_id");
		addLongToParamsIfSet(params, directToUserId, "direct_to_id");
		addLongToParamsIfSet(params, replyToId, "replied_to_id");
		addOpenGraphObjectToParamsIfSet(params);
		addAttachmentsIfPresent(params);

		return params;
	}
	
	public void addAttachment(InputStream InputStream){
		attachments.add(InputStream);
	}

	private void addOpenGraphObjectToParamsIfSet(Map<String,Object> params) {
		if (openGraphObject != null) {
			addStringToParamsIfSet(params, openGraphObject.getUrl(), "og_url");
			addStringToParamsIfSet(params, openGraphObject.getTitle(), "og_title");
			addStringToParamsIfSet(params, openGraphObject.getImageUrl(), "og_image");
			addStringToParamsIfSet(params, openGraphObject.getDescription(), "og_description");
			addStringToParamsIfSet(params, openGraphObject.getSiteName(), "og_site_name");
			addStringToParamsIfSet(params, openGraphObject.getMeta(), "og_meta");

			params.put("og_fetch", String.valueOf(openGraphObject.isFetch()));

			addTopicsIfPresent(params);
			addAttachmentsIfPresent(params);

			if (openGraphObject.getObjectType() != null) {
				params.put("og_object_type", openGraphObject.getObjectType().getTypeString());
			}
		}
	}

	/**
	 * @param params
	 */
	private void addAttachmentsIfPresent(Map<String, Object> params) {
		int count = 0;
		// attachment1..20 is valid more than 20 is ignored by Yammer
		for (InputStream attachment: attachments) {
			count++;
			params.put("attachment" + count, attachment);
		}
		
	}

	private void addTopicsIfPresent(Map<String,Object> params) {
		int count = 0;
		// topic1..topic20 is valid more than 20 is ignored by Yammer
		for (String topic : topics) {
			count++;
			params.put("topic" + count, topic);
		}
	}

	private void addStringToParamsIfSet(Map<String,Object> params, String param, String paramName) {
		if (param != null) {
			params.put(paramName, String.valueOf(param));
		}
	}

	private void addLongToParamsIfSet(Map<String,Object> params, Long param, String paramName) {
		if (param != null) {
			params.put(paramName, String.valueOf(param));
		}
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getReplyToId() {
		return replyToId;
	}

	public void setReplyToId(Long replyToId) {
		this.replyToId = replyToId;
	}

	public Long getDirectToUserId() {
		return directToUserId;
	}

	public void setDirectToUserId(Long directToUserId) {
		this.directToUserId = directToUserId;
	}

	public Boolean getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(Boolean broadcast) {
		this.broadcast = broadcast;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public OpenGraphObject getOpenGraphObject() {
		return openGraphObject;
	}

	public void setOpenGraphObject(OpenGraphObject openGraphObject) {
		this.openGraphObject = openGraphObject;
	}

	public List<InputStream> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<InputStream> attachements) {
		this.attachments = attachements;
	}
}
