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
package org.agorava.yammer.impl;

import java.util.HashMap;
import java.util.List;

import org.agorava.yammer.GroupService;
import org.agorava.yammer.YammerBaseService;
import org.agorava.yammer.model.Group;
import org.agorava.yammer.model.GroupList;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

/**
 * @author Werner Keil
 *
 */
public class GroupServiceImpl extends YammerBaseService implements GroupService {

	private RestTemplate restTemplate;

	public GroupServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Group> getGroups(int page, Character letter, String sortBy, boolean reverse) {
		Map<String, String> params = new FastHashMap<String, String>();
		params.set("page", String.valueOf(page));
		if(sortBy!=null){
			params.set("sort_by", sortBy);
		}
		params.set("reverse", String.valueOf(reverse));
		if(letter!=null){
			params.set("letter", String.valueOf(letter));
		}
		return restTemplate.getForObject(buildUri("groups.json", params), GroupList.class);
	}

	public Group getGroup(long groupId) {
		return restTemplate.getForObject(buildUri("groups/"+String.valueOf(groupId)+".json"), Group.class);
	}

	/* (non-Javadoc)
	 * @see org.agorava.yammer.model.GroupOperations#createGroup(java.lang.String, boolean)
	 */
	public void createGroup(String name, boolean isPrivate) {
		Map<String, String> params = new FastHashMap<String, String>();
		params.set("name",name);
		params.set("private", String.valueOf(isPrivate));
		restTemplate.postForEntity(buildUri("groups"), params, String.class);
	}

	/**
	 * Method returns 401 from Yammer, so it isn't visible in GroupOperations yet
	 * @param groupId
	 * @param name
	 * @param isPrivate
	 */
	public void updateGroup(long groupId, String name, boolean isPrivate) {
		Map<String, String> params = new HashMap<String, String>();
		params.set("name",name);
		params.set("private", String.valueOf(isPrivate));
		restTemplate.put(buildUri("groups/"+groupId), params);
	}
	
	public void joinGroup(long groupId){
		restTemplate.postForObject(buildUri("group_memberships.json", "group_id", String.valueOf(groupId)), null, String.class);
	}
	
	public void leaveGroup(long groupId){
		restTemplate.delete(buildUri("group_memberships.json", "group_id", String.valueOf(groupId)));
	}

}
