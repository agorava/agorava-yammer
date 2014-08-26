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

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.agorava.yammer.GroupService;
import org.agorava.yammer.MessageService;
import org.agorava.yammer.SearchService;
import org.agorava.yammer.SubscriptionService;
import org.agorava.yammer.ThreadService;
import org.agorava.yammer.TopicService;
import org.agorava.yammer.UserService;
import org.agorava.yammer.YammerService;
import org.agorava.yammer.jackson.YammerModule;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerServiceImpl extends AbstractOAuth2ApiBinding implements YammerService{
	
	private UserService userOperations;
	private MessageService messageOperations;
	private GroupService groupOperations;
	private SearchService searchOperations;
	private TopicService topicOperations;
	private SubscriptionService subscriptionOperations;
	private ThreadService threadOperations;
	
	public YammerServiceImpl(String accessToken) {
		super(accessToken);
		initSubApis();
		registerYammerJsonModule();
	}

	public UserService userOperations(){
		return userOperations;
	}
	
	public MessageService messageOperations(){
		return messageOperations;
	}
	
	public GroupService groupOperations(){
		return groupOperations;
	}
	
	public SearchService searchOperations(){
		return searchOperations;
	}
	
	public TopicService topicOperations(){
		return topicOperations;
	}
	
	public SubscriptionService subscriptionOperations(){
		return subscriptionOperations;
	}
	
	public ThreadService threadOperations(){
		return threadOperations;
	}
	
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new YammerErrorHandler());
	}
	
	private void initSubApis() {
		userOperations = new UserServiceImpl(getRestTemplate());
		messageOperations = new MessageServiceImpl(getRestTemplate());
		groupOperations = new GroupServiceImpl(getRestTemplate());
		searchOperations = new SearchServiceImpl(getRestTemplate());
		topicOperations = new TopicServiceImpl(getRestTemplate());
		subscriptionOperations = new SubscriptionServiceImpl(getRestTemplate());
		threadOperations = new ThreadServiceImpl(getRestTemplate());
	}
	
	private void registerYammerJsonModule() {
		List<HttpMessageConverter<?>> converters = getRestTemplate().getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if(converter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
				ObjectMapper objectMapper = new ObjectMapper();				
				objectMapper.registerModule(new YammerModule());
				jsonConverter.setObjectMapper(objectMapper);
			}
		}
	}
}
