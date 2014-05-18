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
package org.agorava.yammer;

import java.util.List;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.agorava.yammer.model.YammerOperations;
import org.agorava.yammer.model.YammerProfile;
import org.springframework.web.client.RestClientException;


public class YammerAdapter implements ApiAdapter<YammerOperations> {

    public static final String EMAIL_PRIMARY_TYPE = "primary";

    public boolean test(YammerOperations yammer) {
        try {
            yammer.userOperations().getUserProfile();
            return true;
        } catch (RestClientException e) {
            return false;
        }
    }

    public void setConnectionValues(YammerOperations yammer, ConnectionValues values) {
        YammerProfile profile = yammer.userOperations().getUserProfile();
        String providerUserId = String.valueOf(profile.getId());
        values.setProviderUserId(providerUserId);
        values.setDisplayName(profile.getFullName());
        values.setProfileUrl(profile.getUrl());
        values.setImageUrl(profile.getMugshotUrl());
    }

    public UserProfile fetchUserProfile(YammerOperations yammer) {
        YammerProfile profile = yammer.userOperations().getUserProfile();

        String primaryMail = getEMail(profile);
        return new UserProfileBuilder().setName(profile.getFullName()).setUsername(profile.getName()).setEmail(primaryMail).build();
    }

    private String getEMail(YammerProfile profile) {
        List<YammerProfile.EMail> eMailAdresses = profile.getContact().getEMailAdresses();

        if (eMailAdresses.isEmpty())
            return null;

        for (YammerProfile.EMail eMail : eMailAdresses) {
            if (EMAIL_PRIMARY_TYPE.equals(eMail.getType())) {
                return eMail.getAddress();
            }
        }
        YammerProfile.EMail fallbackEMail = eMailAdresses.get(0);
        return fallbackEMail.getAddress();
    }

    public void updateStatus(YammerOperations yammer, String message) {
        yammer.messageOperations().postUpdate(message);
    }

}
