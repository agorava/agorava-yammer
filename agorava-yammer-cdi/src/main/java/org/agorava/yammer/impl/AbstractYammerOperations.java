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
import java.util.Map;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author Werner Keil
 * @author Morten Andersen-Gott
 *
 */
public class AbstractYammerOperations {

	
	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS);
	}
	
	protected URI buildUri(String path, String parameterName, String parameterValue) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(parameterName, parameterValue);
		return buildUri(path, parameters);
	}
	
	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
	}
	
	private static final String API_URL_BASE = "https://www.yammer.com/api/v1/";

	private static final Map<String, String> EMPTY_PARAMETERS = new HashMap<String, String>();

	
}
