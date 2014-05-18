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
package org.agorava.yammer.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.agorava.yammer.model.UserOperations;
import org.agorava.yammer.model.YammerProfile;

/**
 * 
 * @author Morten Andersen-Gott
 *
 */
public class UserTemplate extends AbstractYammerOperations implements UserOperations{

	private RestTemplate restTemplate;
	
	/**
	 * @param restTemplate
	 */
	public UserTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public List<YammerProfile> getUsers(int page){
		return getUsers(page, null, false, null);
	}
	
	public List<YammerProfile> getUsers(int page, String sortBy, boolean reverse, Character letter){
		Map<String, String> params = new HashMap<String, String>();
		params.put("page", String.valueOf(page));
		if(sortBy!=null){
			params.put("sort_by", sortBy);
		}
		params.put("reverse", String.valueOf(reverse));
		if(letter!=null){
			params.put("letter", String.valueOf(letter));
		}
		return restTemplate.getForObject(buildUri("users.json", params), YammerProfileList.class);
	}

	public YammerProfile getUser(long id){
        String userId = String.valueOf(id);
        return getUser(userId);
	}

    public YammerProfile getUser(String userId){
		URI uri = buildUri("users/"+userId+".json");
		return restTemplate.getForObject(uri, YammerProfile.class);
	}
	
	public void updateProfile(long userId, UserInfo userInfo){
		restTemplate.put(buildUri("users/"+String.valueOf(userId)+".json", userInfo.toParams()),null);
	}
	
	public YammerProfile getUserProfile(){
		return restTemplate.getForObject(buildUri("users/current.json"), YammerProfile.class);
	}
	
	public YammerProfile getUserByEmail(String email){
		URI uri = buildUri("users/by_email.json", "email", email);
		YammerProfileList profileList = restTemplate.getForObject(uri, YammerProfileList.class);

		//Yammer returns user inside a Json array element
		if(CollectionUtils.isEmpty(profileList)){
			return null;
		}
		return profileList.get(0);
	}
	
}
