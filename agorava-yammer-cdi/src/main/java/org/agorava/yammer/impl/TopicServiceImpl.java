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

import org.agorava.yammer.TopicService;
import org.agorava.yammer.model.Topic;
import org.springframework.web.client.RestTemplate;

/**
 * @author Morten Andersen-Gott
 *
 */
public class TopicServiceImpl extends AbstractYammerOperations implements TopicService {

	private RestTemplate restTemplate;

	public TopicServiceImpl(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	
	public Topic getTopic(long id) {
		return restTemplate.getForObject(buildUri("topics/"+String.valueOf(id)+".json"), Topic.class);
	}

}
