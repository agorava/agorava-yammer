/*
 * Copyright 2014 Agorava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agorava.yammer;


import org.agorava.api.oauth.OAuthService;
import org.agorava.spi.ProviderApiService;

import javax.inject.Inject;

/**
 * @author Werner Keil
 * @author Justin Wyer
 */
public abstract class YammerBaseService extends ProviderApiService {

    public static String API_ROOT = "https://www.yammer.com/api/v1/";

    @Inject
    @Yammer
    private OAuthService service;

    @Override
    public String buildAbsoluteUri(String url) {
        return API_ROOT + url;
    }

    @Override
    public OAuthService getService() {
        return service;
    }
}